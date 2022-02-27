package com.naukri.automation.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicTestOps {
 
	/**
	 * This method will return Random Number of string as per desire.
	 * 
	 * @param length
	 * @param type
	 * @return
	 */
	public static String generateRandomStrings(int length, String type) {
		StringBuilder sb = new StringBuilder(length);
		if (type.equalsIgnoreCase("Number")) {
			final String strg = "0123456789";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("String")) {
			final String strg = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("Alphanumeric")) {
			final String strg = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else {
			System.err.println("Wrong type declared.");
		}
		return sb.toString();
	}
	
	public static String getDateInSpecificFormat(String patternToGet,String patternOfDate, String dateValue) {
		SimpleDateFormat formatter = new SimpleDateFormat(patternOfDate);
		SimpleDateFormat formatter2 = new SimpleDateFormat(patternToGet);
		Calendar cal = new GregorianCalendar();
		try {
			cal.setTime(formatter.parse(dateValue));
			return formatter2.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getSpecificValueFromJSON(String jsonString, String key, int index) {
		key=key.replaceAll("\\[", "\\\\[").replaceAll("\\]", "\\\\]");
		String toCompile = "\""+key+"\":(.+?),";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(jsonString);
		for(int i=0;i<=index;i++) {
			matcher.find();
			if(index==i) {
				return matcher.group(1).replaceAll("\"", "").toString();
			}
		}
		return null; 
	}
	
	public static String getDataAsJson(Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
