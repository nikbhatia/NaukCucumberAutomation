package com.naukri.automation.util;

import static io.restassured.RestAssured.expect;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.SessionInitiator;

import io.restassured.RestAssured;


/**
 * <b> This class is the utility class for JIRA plugin (Xray) for test case repo fetching and test case execution publisher </b>
 * <br>
 * @version 1.1
 * @since 13/12/2019
 * @author mohit.dagar
 *
 */

public class XrayUtility {

	private String testPlanPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "java" + File.separator + "com" + File.separator + "naukri" + File.separator + "features"
			+ File.separator + "TestPlan.feature";
	private String testPlan = System.getProperty("testPlan");
	private String publishTestExecution = System.getProperty("publishTestExecution");
	private String testExecutionKey;
	private final String cucumberReportPath = System.getProperty("user.dir") + File.separator + "target"
			+ File.separator + "cucumber-reports" + File.separator;
	private final String basicAuthToken = ReadWritePropertyFile.getProperty("basicAuthToken", BaseAutomation.configFile); 
	private final String XrayClientId = ReadWritePropertyFile.getProperty("XrayClientId", BaseAutomation.configFile),
			XrayClientSecretKey = ReadWritePropertyFile.getProperty("XrayClientSecretKey", BaseAutomation.configFile);

	public XrayUtility() {
		File file = new File(testPlanPath);
		if (file.exists())
			file.delete();
	}

	/**
	 * <b> This method fetches test plan as feature files, depending on flag(testplan) is set to false or any test plan key is provided </b>
	 * @author mohit.dagar
	 */
	public void configureTests() {
		if(_setXrayTestPlan()) {
		_getXrayFeatures(getXrayAuthToken());
		}
	}

	public void publishResultsOnXray() {
		if (publishTestExecution.equalsIgnoreCase("false")) {
			System.out.println("<<<<    Tests Execution completed for default Test Plan [" + testPlan + "]    >>>>");
		} else {
			_createTestExecutionIssueFields();
			_publishTestExecutionResult(getXrayAuthToken());
			_provideDetailsInJira();
		}
	}
	
	private void _provideDetailsInJira() {
		_addScreenshots();
		_addTestPlanLink();
		_addAdditionalDetails();
	}

	private void _publishTestExecutionResult(String token) {
		Map<String, Object> header = new HashMap<>();
		header.put("Authorization", "Bearer " + token);
		header.put("Content-Type", "multipart/form-data");

		String body = expect().statusCode(200).and().statusLine("HTTP/1.1 200 OK").given()
				.multiPart("results", new File(cucumberReportPath + "Cucumber.json")).and()
				.multiPart("info", new File(cucumberReportPath + "issueFields.json")).with().headers(header).with()
				.relaxedHTTPSValidation().when()
				.post("https://xray.cloud.xpand-it.com/api/v1/import/execution/cucumber/multipart").getBody()
				.asString();
		String toCompile = "\"key\".+?\"(.+?)\"";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(body);
		if (matcher.find()) {
			testExecutionKey = matcher.group(1);
		} else {
			testExecutionKey = "<<<<     Xray Test Execution not created    >>>>";
		}
		System.out.println("<<<<    Xray Test Execution [" + testExecutionKey
				+ "] is successfully created for Test Plan [" + testPlan + "]    >>>>");
	}

	private String getXrayAuthToken() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("client_id", XrayClientId);
		map.put("client_secret", XrayClientSecretKey);
		String bodydata =BasicTestOps.getDataAsJson(map);

		Map<String, Object> header = new HashMap<>();
		header.put("Content-Type", "application/json");

		String accessToken = "";
		accessToken = expect().statusCode(200).and().statusLine("HTTP/1.1 200 OK").given().headers(header).with()
				.body(bodydata).relaxedHTTPSValidation().when()
				.post("https://xray.cloud.xpand-it.com/api/v1/authenticate").getHeader("x-access-token");

		return accessToken;
	}

	private void _getXrayFeatures(String token) {

		Map<String, Object> header = new HashMap<>();
		header.put("Authorization", "Bearer " + token);

		byte[] featureZip = expect().statusCode(200).and().statusLine("HTTP/1.1 200 OK").given().headers(header).with()
				.relaxedHTTPSValidation().when()
				.get("https://xray.cloud.xpand-it.com/api/v1/export/cucumber?keys=" + testPlan).asByteArray();

		ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(featureZip));
		@SuppressWarnings("unused")
		ZipEntry entry = null;
		try {
			while ((entry = zipStream.getNextEntry()) != null) {
				// String entryName = entry.getName();
				FileOutputStream out = new FileOutputStream(testPlanPath);
				byte[] byteBuff = new byte[4096];
				int bytesRead = 0;
				while ((bytesRead = zipStream.read(byteBuff)) != -1) {
					out.write(byteBuff, 0, bytesRead);
				}
				out.close();
				zipStream.closeEntry();
			}
			zipStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean _setXrayTestPlan() {
		boolean executeViaXray = true;
		String defaultPublisher = ReadWritePropertyFile.getProperty("publishTestExecution",
				BaseAutomation.configFile);
		String defaultPlan = ReadWritePropertyFile.getProperty("testPlan",
				BaseAutomation.configFile);
		if (publishTestExecution == null) {
			publishTestExecution = defaultPublisher;
		}else if(publishTestExecution.trim().isEmpty()) {
			publishTestExecution = defaultPublisher;
		}
		if (testPlan == null) {
			if (defaultPlan.trim().toUpperCase().contains("FALSE")) {
				System.out.println("<<<<     Executing Scenarios without XRAY Test Plan   >>>>");
				return false;
			}
			testPlan = defaultPlan;
			System.out.println("<<<<    Default Test Plan [" + testPlan
					+ "] Execution Started with Test Execution Publisher set to [" + publishTestExecution + "]   >>>>");
		}else if(testPlan.trim().isEmpty()) {
			if (defaultPlan.trim().toUpperCase().contains("FALSE")) {
				System.out.println("<<<<     Executing Scenarios without XRAY Test Plan   >>>>");
				return false;
			}
			testPlan = defaultPlan;
			System.out.println("<<<<    Default Test Plan [" + testPlan
					+ "] Execution Started with Test Execution Publisher set to [" + publishTestExecution + "]   >>>>");
		}else {
			System.out.println("<<<<    Test Plan [" + testPlan
					+ "] Execution Started with Test Execution Publisher set to [" + publishTestExecution + "]   >>>>");
		}
		return executeViaXray;
	}

	private void _createTestExecutionIssueFields() {
		String projectKey = System.getProperty("projectKey");
		if (projectKey == null)
			projectKey = ReadWritePropertyFile.getProperty("projectKey",
					BaseAutomation.configFile);
		else if (projectKey.trim().isEmpty())
			projectKey = ReadWritePropertyFile.getProperty("projectKey",
					BaseAutomation.configFile);
		
		String content = "{\"fields\":{\"project\":{\"key\":\"" + projectKey + "\"},\"summary\":\"Test Execution for "
				+ testPlan
				+ "\",\"issuetype\":{\"id\":\"10925\"},\"description\":\"This Test Execution was executed for Test Plan - "
				+ testPlan
				+ ". Please refer attached screenshots if any test scenario has failed and linked test plan.\",\"environment\":\""
				+ SessionInitiator.environment + "\"}}";
		try (FileWriter writer = new FileWriter(new File(cucumberReportPath + "issueFields.json"));
				BufferedWriter bw = new BufferedWriter(writer)) {
			bw.write(content);

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	private void _addScreenshots() {
		Iterator<String> iterator = SessionInitiator.screenshots.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> header = new HashMap<>();
			header.put("Accept", "application/json");
			header.put("Authorization", "Basic " + basicAuthToken);
			header.put("X-Atlassian-Token", "no-check");
			expect().statusCode(200).given().headers(header).with().multiPart("file", new File(iterator.next()))
			.relaxedHTTPSValidation().when()
			.post("https://infoedge.atlassian.net/rest/api/3/issue/" + testExecutionKey + "/attachments");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void _addTestPlanLink() {
		String body = "{\"type\":{\"id\":\"10501\"},\"inwardIssue\":{\"key\":\"" + testExecutionKey
				+ "\"},\"outwardIssue\":{\"key\":\"" + testPlan + "\"}}";
		Map<String, Object> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Authorization", "Basic " + basicAuthToken);
		header.put("Content-Type", "application/json");
		expect().statusCode(201).given().headers(header).with().body(body).and().relaxedHTTPSValidation().when()
		.post("https://infoedge.atlassian.net/rest/api/3/issueLink");
	}

	private void _addAdditionalDetails() {
		String qaOwnwer = System.getProperty("testExecutionOwner");
		if (qaOwnwer == null)
			qaOwnwer = System.getProperty("user.name");
		else if (qaOwnwer.trim().isEmpty())
			qaOwnwer = System.getProperty("user.name");
		Map<String, Object> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Authorization", "Basic " + basicAuthToken);
		header.put("Content-Type", "application/json");

		String result = expect().statusCode(200).given().headers(header).with().relaxedHTTPSValidation().when()
				.get("https://infoedge.atlassian.net/rest/api/3/groupuserpicker?query=" + qaOwnwer).getBody()
				.asString();

		String toCompile = "\"total\":(.+?),";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(result);
		String userCount;
		if (matcher.find()) {
			userCount = matcher.group(1);
			if (userCount.equalsIgnoreCase("0")) {
				qaOwnwer = ReadWritePropertyFile.getProperty("testExecutionOwner",
						BaseAutomation.configFile);
			}
		} else {
			qaOwnwer = ReadWritePropertyFile.getProperty("testExecutionOwner",
					BaseAutomation.configFile);
		}
		String body = "{\"fields\": {\"assignee\": {\"name\":\"" + qaOwnwer + "\"},\"customfield_14234\":{\"name\":\""
				+ qaOwnwer + "\"}}}";
		int statusCode = RestAssured.given().headers(header).with().body(body).and().relaxedHTTPSValidation().when()
				.put("https://infoedge.atlassian.net/rest/api/3/issue/" + testExecutionKey).getStatusCode();
		if (statusCode == 204) {
			System.out.println("<<<<    Test Execution details successfully added to ["
					+ testExecutionKey + "] and assigned to [" + qaOwnwer + "]    >>>>");
		}else {
			System.out.println("<<<<    Screenshots and Test Plan successfully attached to [" + testExecutionKey + "]     >>>>");
			System.out.println("<<<<    Xray Test Execution [" + testExecutionKey + "] can't be assigned to provided QaOwner/Assignee [" + qaOwnwer + "]     >>>>");
		}
	}
}
