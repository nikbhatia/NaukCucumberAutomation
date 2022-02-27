package com.naukri.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ReadWritePropertyFile {

	public static String getProperty(String Property, String filePath) {
		try {
			Properties prop = loadProperties(filePath);
			return prop.getProperty(Property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void setProperty(String key, String value, String filePath) {
		OutputStream out = null;
		try {
			Properties props = loadProperties(filePath);
			props.setProperty(key, value);
			out = new FileOutputStream(filePath);
			props.store(out, "");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (out != null) {

				try {

					out.close();
				} catch (IOException ex) {

					System.out.println("IOException: Could not close properties output stream; " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}

	}

	public static Properties loadProperties(String resourceName) throws IOException {
		Properties properties = null;
		InputStream inputStream = null;
		try {
			inputStream = loadResource(resourceName);
			;
			if (inputStream != null) {
				properties = new Properties();
				properties.load(inputStream);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return properties;
	}

	public static InputStream loadResource(String resourceName) throws IOException {
		ClassLoader classLoader = ReadWritePropertyFile.class.getClassLoader();

		InputStream inputStream = null;

		if (classLoader != null) {
			inputStream = classLoader.getResourceAsStream(resourceName);
		}

		if (inputStream == null) {
			classLoader = ClassLoader.getSystemClassLoader();
			if (classLoader != null) {
				inputStream = classLoader.getResourceAsStream(resourceName);
			}
		}

		if (inputStream == null) {
			File file = new File(resourceName);
			if (file.exists()) {
				inputStream = new FileInputStream(file);
			}
		}

		return inputStream;
	}// end loadResource

	/**
	 * This method will return last downloaded file name
	 * @author himanshu.dua
	 * @param dirPath
	 * @return
	 */
	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
}
