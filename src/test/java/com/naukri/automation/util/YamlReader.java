package com.naukri.automation.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import com.naukri.test.base.BaseAutomation;

public class YamlReader {

    public static String appConfigPath = "";
    public static String MySqlConfigPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "mysqlConfig" + ".yml";
    public static String KafkaConfigPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "kafkaConfig" + ".yml";
    public static String MyMongoConfigPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "mongoDBConfig" + ".yml";

    public static void configureTestDataPaths(String env) {
        appConfigPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testdata" + File.separator + "appConfig_" + env + ".yml";
        BaseAutomation.appUrlFile = appConfigPath;
    }

    /**
     * @author abhishek.dwivedi, This method use to read YML file and return the
     * value according to the key
     * @param key {yaml key for which value is needed}
     * @return {yaml value according to key}
     */
    public static String getAppConfigValue(String key) {
        String value = null;
        try {
            value = getValue(key, appConfigPath);
        } catch (FileNotFoundException ex) {
            TestNGLogUtility.info(ex.getMessage());
            return null;
        }
        return value;
    }

    /**
     * Method used for getting any of configuration values from mysqlConfig.yml
     *
     * @author rachit.mehrotra
     * @param String acting as the key for which value is present in yml
     * @return String
     */
    public static String getMySQLConfigValue(String key) {
        try {
            return getValue(key, MySqlConfigPath);
        } catch (FileNotFoundException ex) {
            TestNGLogUtility.info(ex.getMessage());
            return null;
        }
    }

    /**
     * This method is used for getting any of configuration values from
     * mongoDBConfig.yml
     *
     * @author ambar.gupta
     * @param String acting as the key for which value is present in yml
     * @return value as String
     */
    public static String getMongoDBConfigValue(String key) {
        try {
            return getValue(key, MyMongoConfigPath);
        } catch (FileNotFoundException ex) {
            TestNGLogUtility.info(ex.getMessage());
            return null;
        }
    }

    /**
     * Method used for getting any of configuration values from kafka.yml
     *
     * @author rachit.mehrotra
     * @param String acting as the key for which value is present in yml
     * @return String
     */
    public static String getKafkaConfigValue(String key) {
        try {
            return getValue(key, KafkaConfigPath);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getYamlValues(String token) {
        Reader doc;
        System.out.println("Yaml: " + appConfigPath);
        try {
            doc = new FileReader(appConfigPath);
        } catch (FileNotFoundException ex) {
            TestNGLogUtility.info("File not valid or missing!!!");
            ex.printStackTrace();
            return null;
        }
        Yaml yaml = new Yaml();
        // TODO: check the type casting of object into the Map and create
        // instance in one place
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return parseMap(object, token + ".");
    }

    @SuppressWarnings("unchecked")
    private static String getValue(String token, String yamlFile) throws FileNotFoundException {
        Reader doc = new FileReader(yamlFile);
        Yaml yaml = new Yaml();
        Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
        return getMapValue(object, token);
    }

    public static String getMapValue(Map<String, Object> object, String token) {
        // TODO: check for proper yaml token string based on presence of '.'
        String[] st = token.split("\\.");
        return parseMap(object, token).get(st[st.length - 1]).toString();
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> parseMap(Map<String, Object> object,
            String token) {
        if (token.contains(".")) {
            String[] st = token.split("\\.");
            object = parseMap((Map<String, Object>) object.get(st[0]),
                    token.replace(st[0] + ".", ""));
        }
        return object;
    }

    public static int generateRandomNumber(int MinRange, int MaxRange) {
        int randomNumber = MinRange
                + (int) (Math.random() * ((MaxRange - MinRange) + 1));
        return randomNumber;
    }
}
