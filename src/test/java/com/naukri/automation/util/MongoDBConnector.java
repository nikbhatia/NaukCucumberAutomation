package com.naukri.automation.util;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import com.naukri.test.base.BaseAutomation;

import io.netty.handler.timeout.TimeoutException;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.dbunit.operation.DatabaseOperation;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


/**
 * Utility file to connect to MongoDB of test environment
 * @author ambar.gupta
 */
 
public class MongoDBConnector extends BaseAutomation
{
	static List<String> dbname;
	static String dburi="mongodb://rmstesting:rmstesting@192.168.40.199:27017/?authSource=AutomationTestDB";
	public static BasicDBObject whereQuery = new BasicDBObject();
	//Connecting to the mongoDB instance with authentication
	static MongoClient  mongoClient= null;
    static MongoCredential credential = MongoCredential.createCredential(YamlReader.getMongoDBConfigValue("Credentials.username"), YamlReader.getMongoDBConfigValue("DBName.npponboard"), YamlReader.getMongoDBConfigValue("Credentials.password").toCharArray());
      
    @SuppressWarnings("deprecation")
	static MongoClient  mongoClient1 = new MongoClient(new ServerAddress(YamlReader.getMongoDBConfigValue("IP.test2ConnectionIp"), Integer.parseInt(YamlReader.getMongoDBConfigValue("Port.test2ConnectionPort"))),Arrays.asList(credential));
                                                 
    //Selecting the database
    static MongoDatabase db = mongoClient1.getDatabase(YamlReader.getMongoDBConfigValue("DBName.npponboard"));
       
    /**
     * This method is used to delete a document from the collection
     * @author ambar.gupta
    * @param Collection name and Document to delete
     */
    public static String deleteDocument(String collectn, Document toDel) 
    {
    	String deleteString = "";
    	try {
    		//Selecting the collection
            MongoCollection<Document> collection = db.getCollection(collectn);
            //Deleting the document
          deleteString =  collection.deleteOne(toDel).toString();
    	}
        catch (Exception e) {
        	e.printStackTrace(); 
        }
    	return deleteString;
     }
    
    /**
     * This method is used fetch value of a key from a document of a collection
     * @author ambar.gupta
     * @param  collection name, document to view and Key to fetch value
     * @return
     * @return Value of the Key
     */
    
    public static String fetchValueFromDocument(String collectn, Document toView, String KeytofetchValue )
    {
    	Document doc = new Document();
    	try {
    	
    		//Selecting the collection
            MongoCollection<Document> collection = db.getCollection(collectn);

         // Getting the iterable object 
            FindIterable<Document> iterDoc = collection.find(toView); 
            int i = 1; 
            // Getting the iterator 
            Iterator it = iterDoc.iterator(); 
            while (it.hasNext()) {  
            	doc = (Document)it.next();  
            i++; 
            }
    } catch(Exception ex) {
		ex.printStackTrace();
	} 
            return doc.get(KeytofetchValue).toString();
    	}

    /**
     * This method is used get the count of number of documents found for a particular set of key values 
     * passed in form of a document 
     * @author ambar.gupta
     * @param String collectn, Document toCheck
     */
    public static long verifyNumberOfDocumentInCollection(String collectn, Document toCheck ) 
    {
    		//Selecting the collection
            MongoCollection<Document> collection = db.getCollection(collectn);
            long count = collection.count(toCheck);
            return count;
    }
    
    /**
     * This method is used get the list of  documents found for a particular set of key values 
     * passed in form of a document 
     * @author ambar.gupta
     * @param Collection name and Document to Check
     * @return list of  documents
     */
    public static List<Document> GetDocumentsfromSubDocumentInCollection(String collectn, Document toCheck ) 
    {
    	List<Document> list=new ArrayList<Document>();
    		//Selecting the collection
            MongoCollection<Document> collection = db.getCollection(collectn);
            long count = collection.count(toCheck);
  
         // Getting the iterable object 
            FindIterable<Document> iterDoc = collection.find(toCheck); 

            // Getting the iterator 
            Iterator it = iterDoc.iterator(); 
            while(it.hasNext())
            {
            	list.add((Document)it.next());
            }            	
            return list;
            
    }
    
    /**
	 * Fetch JSON Object from AutomationTestData
	 * @author abhishek.dwivedi
	 * @param mongdb name, collection name, key and value
	 * @return json object
	 *
	 * @throws ParseException
	 */
	public synchronized static JSONObject getJSONObject(String collectionName, String field, String value) {
		String staticJson = getCollectionDeatils(dbname.get(0), collectionName, field, value);
		JSONParser JsonParser = new JSONParser();
		Object staticObj;
		JSONObject staticJsonObject = new JSONObject();
		try {
			staticObj = JsonParser.parse(staticJson);
			staticJsonObject = (JSONObject) staticObj;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return staticJsonObject;
	}

	/**
	 * Return string given the dbname, collection, filter name & value.
	 * @author abhishek.dwivedi
	 * 
	 * @param mongdb name, collection name, key and value
	 * @return collection details on the basis of key
	 * 
	 */
	public synchronized static String getCollectionDeatils(String dbname, String collectionName, String field,
			Object value) {
		String filteredCollection = null;
		// mongoClient.getDatabase(dbname).getCollection(collectionName)
		for (Document doc : getDocument(mongoClient.getDatabase(dbname).getCollection(collectionName), field, value)) {
			filteredCollection = doc.toJson();
		}
		return filteredCollection;
	}

	/**
	 * Create a new Mongo connection using mongo URI
	 * 
	 * @author abhishek.dwivedi
	 * 
	 * @param mongodb
	 *            URI
	 * @return mongoclient
	 */
	public static MongoClient connectMongoDB() {
		try {
			mongoClient = new MongoClient(new MongoClientURI(dburi));
			dbname = mongoClient.getDatabaseNames();
			return mongoClient;
		} catch (Exception e) {
			TestNGLogUtility.info("Could not connect to Mongo DB"+ e); 
			return mongoClient;
		} 

	}

	/**
	 * Return Iterable Document given a filter string key/value
	 * 
	 * @author abhishek.dwivedi
	 * @param collection
	 *            name, key and value
	 * 
	 * 
	 */
	public static FindIterable<Document> getDocument(MongoCollection<Document> collection, String key, Object value) {
		whereQuery.clear();
		whereQuery.put(key, value);
		return collection.find(whereQuery);
	}

	/**
	 * Refresh DB.
	 * 
	 * @author abhishek.dwivedi
	 * 
	 * @return
	 * @throws Exception
	 */
	public static DatabaseOperation getSetUpOperation()  {
		return DatabaseOperation.REFRESH;
	}

	/**
	 * Cleanup DB .
	 * 
	 * @author abhishek.dwivedi
	 * 
	 * @return
	 * @throws Exception
	 */
	public static DatabaseOperation getTearDownOperation()  {
		return DatabaseOperation.NONE;
	}

	/**
	 * Update values of key in a collection
	 *
	 * @author abhishek.dwivedi
	 *@param collectionName values to be updated in the document
	 *@param searchKey on the basis of which filter has to be applied like column name
	 *@param searchValue on the basis of which filter has to be applied like column value respect to column name
	 *@param keyValuesToBeUpdated
	 * 
	 */

	public synchronized static void UpdateValuesInMongoDocument(String collectionName, HashMap<String,String> keyValuesToBeUpdated ,String searchKey, String searchValue) {
		JSONObject toUpdateJson = new JSONObject();
        toUpdateJson.putAll(keyValuesToBeUpdated);
        BasicDBObject keyValue = new BasicDBObject();
        HashMap<String, String> mapFilter=new HashMap<>();
        mapFilter.put(searchKey, searchValue);
        keyValue.putAll(mapFilter);
        mongoClient.getDatabase(dbname.get(0)).getCollection(collectionName).updateOne(keyValue, new Document("$set", new Document(toUpdateJson)));
  }
	
}
        
