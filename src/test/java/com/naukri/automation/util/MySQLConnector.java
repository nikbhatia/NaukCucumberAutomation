package com.naukri.automation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility file to connect to MySql Database of test environment
 * @author rachit.mehrotra
 */

public class MySQLConnector {
	
	/**
	 * The method will return the resultSet of the query as a map
	 * @author rachit.mehrotra
	 * @param dbName - Name of Database on which the query will be executed
	 * @param query - which will be executed for fetching data
	 * @return Map<Object,Object>
	 */
	public Map<Object,Object> connectAndExecuteQuery(String dbName,String query) {
		Map<Object,Object> resultMap = new HashMap<Object, Object>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://"+YamlReader.getMySQLConfigValue("IP.test2ConnectionIp")+"/"+dbName, 
																YamlReader.getMySQLConfigValue("Credentials.username"), 
																YamlReader.getMySQLConfigValue("Credentials.password"));
			TestNGLogUtility.info("DB connected " + dbName);
			TestNGLogUtility.info("Query executed " + query);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			while(resultSet.next()) {
				int rowCount = resultSet.getRow();
				for(int j = 1 ; j <= rowCount ; j++) {
					int columnCount = rsmd.getColumnCount();
					Map<Object,Object> rowData = new HashMap<Object,Object>();
					for(int i = 1 ; i <= columnCount ; i++) {
						Map<Object,Object> innerJSONMap = new HashMap<Object, Object>();
						if(resultSet.getString(i) == null) {
							rowData.put(rsmd.getColumnName(i), resultSet.getString(i));
						} else if(resultSet.getString(i).contains("{")) {
							String test = resultSet.getString(i).substring(1, resultSet.getString(i).length()-1);
							String [] strPair = test.split(",");
							for(int k = 0 ; k < strPair.length ; k++) {
								String[] keyValue = strPair[k].split(":");
								String key = keyValue[0].replace("\"", "");
								String value = (keyValue[1].length() > 2 ? keyValue[1].replace("\"", "") : keyValue[1]);
								innerJSONMap.put(key, value);
							}
							rowData.put(rsmd.getColumnName(i), innerJSONMap);
						} else {
						rowData.put(rsmd.getColumnName(i), resultSet.getString(i));
						}
					}
					resultMap.put(j, rowData);
				}
			}
			connection.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} 
		return resultMap;
	}
	
}
