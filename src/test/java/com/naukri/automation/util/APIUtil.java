package com.naukri.automation.util;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.test.base.BaseAutomation;
/**
 * Utility file to automate APIs
 * @author rachit.mehrotra
 *
 */
public class APIUtil {

	final String clientId = "r3sndr01d";
	final String eappsClientId="r3s1f0n3";
	public static String groupName = "";
	String deviceId = "";
	String authURL = "https://login.recruit.naukri.com";
	public static String vendorCandidateEmail = "";
	public String companyId = "691449";
	public String baseUrl ="https://rms.naukri.com";
	
	/**
	 * Method will return the Auth token for accessing the API
	 * @author rachit.mehrotra
	 * @param username 
	 * @param password
	 * @return String (authentication token)
	 */
	private String getAuthToken(String username, String password) {
		deviceId = "dev" + GenericFunctions.generateRandomStrings(6, "Number");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		String bodydata = getDataAsJson(map);

		Map<String, Object> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("accept", "application/json");
		header.put("deviceId", deviceId);
		header.put("clientId", clientId);

		String accessToken = "";
		accessToken = expect().statusCode(200).and().body(containsString(username)).and().statusLine("HTTP/1.1 200 OK")
				.given().headers(header).with().body(bodydata).relaxedHTTPSValidation().when()
				.post(authURL + "/rlogin/v1/user/session").getHeader("accessToken");
		System.out.println(accessToken);
		return accessToken;
	}
	
	/**
	 * To generate the auth token for eapps account
	 * @param username
	 * @param password
	 * @return access token
	 */
	private String getAuthTokenForEapps(String username, String password) {
		deviceId = "dev" + GenericFunctions.generateRandomStrings(6, "Number");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		String bodydata = getDataAsJson(map);

		Map<String, Object> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("accept", "application/json");
		header.put("deviceId", deviceId);
		header.put("clientId", eappsClientId);

		String accessToken = "";
		accessToken = expect().statusCode(200).and().body(containsString(username)).and().statusLine("HTTP/1.1 200 OK")
				.given().headers(header).with().body(bodydata).relaxedHTTPSValidation().when()
				.post(authURL + "/rlogin/v1/user/session").getHeader("accessToken");
		System.out.println(accessToken);
		return accessToken;
	}
	
	/**
	 * To create Group using createGroup API
	 * @author rachit.mehrotra
	 * @param username
	 * @param password
	 */
	public void createNewGroup(String username, String password) {
		String groupName = "GroupName" + GenericFunctions.generateRandomStrings(6, "String");
		String accessToken = getAuthToken(username,password);
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		
		Map<String, Object> billingDetails = new HashMap<String, Object>();
		billingDetails.put("billingDetails", null);
		billingDetails.put("invoiceGenerationAfterDays", 0);
		billingDetails.put("payableAfterDays", 0);
		
		Map<String, Object> groupDetails = new HashMap<String, Object>();
		groupDetails.put("description", "");
		groupDetails.put("name", groupName);
		
		System.out.println(billingDetails);
	}
	
	protected static String getDataAsJson(Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
