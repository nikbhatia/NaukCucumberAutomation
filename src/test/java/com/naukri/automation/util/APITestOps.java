package com.naukri.automation.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;
import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.containsString;

public class APITestOps extends BaseAutomation {

	private static String configProperties = ".//configuration.properties";
	public static String username = getAppConfigValue("Users.RMS.Username");
	final String password = getAppConfigValue("Users.RMS.Password");
	// final String baseURL = ReadWritePropertyFile.getProperty("appURL",
	// appUrlFile);
	// final String authURL = ReadWritePropertyFile.getProperty("authURL",
	// appUrlFile);
	final String baseURL = getAppConfigValue("URLs.appURL");
	final String authURL = getAppConfigValue("URLs.authURL");

	final String clientId = "r3sndr01d";
	String hmId = "", deviceId = "";
	public static String applicationId, candidateName, requirementName="", billingCategory, employerName, billingValue,
			billingMode, invoiceGenAfterDays, payableAfterDays, billToAddress, candidateId;
	public static Map<String, Object> candidateDataByApplicationIdAsJSON = new HashMap<>();
	public static Map<String, Object> employerDataByEmployerNameAsJSON = new HashMap<>();

	public String[] createMultipleCandidatesForSingleEmployer(String[] randomCandidateName,
			String[] randomCandidateEmailId, String[] randomRequirementName, String employerName, String subStatusId,
			int candidatesCount) {
		String groupId = getGroupId(username, password, employerName);
		String billingCategory = getBillingCategory(username, password, groupId);
		String accessToken = getAuthToken(username, password);
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String[] applicationIdList = new String[candidatesCount];

		for (int i = 0; i < candidatesCount; i++) {
			Map<String, Object> candidateData = createCandidatesBodyParams(randomCandidateName[i],
					randomCandidateEmailId[i], randomRequirementName[i], billingCategory, groupId, subStatusId);

			String responseBody = expect().statusCode(302).given().with().formParams(candidateData).headers(header)
					.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody()
					.asString();

			applicationIdList[i] = responseBody.split("title")[1].replaceAll("[^0-9]", "");

			candidateDataByApplicationIdAsJSON.put(applicationIdList[i],
					APITestUtils.getAppConfigValueAsJson(candidateData));

		}

		return applicationIdList;
	}

	public String createEmployerWithOptions(List<String> chargeMode, List<String> chargeValue,
			int invoiceGenerationAfterDays, int payableAfterDays, List<Boolean> isTaxExempted, int billingDetailsCount,
			int employerAddressCount) {
		String recruiterId = getRecruiterId(username, password);
		String data[] = createEmployerBodyData(recruiterId, chargeMode, chargeValue, invoiceGenerationAfterDays,
				payableAfterDays, isTaxExempted, billingDetailsCount, employerAddressCount);
		String accessToken = getAuthToken(username, password);
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		expect().statusCode(200).given().with().body(data[1]).headers(header).relaxedHTTPSValidation().when()
				.post(baseURL + "/employerApi/groupDetails").getBody().asString();

		employerDataByEmployerNameAsJSON.put(data[0], data[1]);

		return data[0];
	}

	private String getAuthToken(String username, String password) {
		deviceId = "dev" + CommonAction.generateRandomStrings(6, "Number");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		String bodydata = APITestUtils.getAppConfigValueAsJson(map);
		Map<String, Object> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("accept", "application/json");
		header.put("deviceId", deviceId);
		header.put("clientId", clientId);
		String accessToken = "";
		accessToken = expect().statusCode(200).and().body(containsString(username)).and().statusLine("HTTP/1.1 200 OK")
				.given().headers(header).with().body(bodydata).relaxedHTTPSValidation().when()
				.post(authURL + "/rlogin/v1/user/session").getHeader("accessToken");
		return accessToken;
	}

	public String createRequirement(String username, String password) {
		String reqName = "monitora" + CommonAction.generateRandomStrings(9, "Alphanumeric");
		String reqTitle = "monitora. Title" + CommonAction.generateRandomStrings(9, "Alphanumeric");
		ArrayList<String> cityId = new ArrayList<String>();
		cityId.add("258");
		String accessToken = getAuthToken(username, password);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("action", "create");
		map.put("saveType", "1");
		map.put("projectId", "");
		map.put("project[visibilityStatus]", "2");
		// map.put("prefillFlag", "0");
		map.put("project[projectName]", reqName);
		// map.put("project[title]", reqTitle);
		// map.put("description", "assessment Test Job Description");
		// map.put("candidateProfile", "assessment candidateProfile Test Job
		// Description");
		map.put("project[salaryCurrency]", "Rupees");
		map.put("project[minSalary]", "80000");
		map.put("project[maxSalary]", "90000");
		map.put("project[minExp]", "0");
		map.put("project[maxExp]", "0");
		// map.put("keywords", "java");
		// map.put("cityIds",cityId);
		map.put("visSettingRad", "1");
		map.put("_splChkId", "PltDSPda3KgrGNmEb8IUz-uC9zpl9MS2vmj1GtXKaMM");
		System.out.println(reqName);

		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		// header.put("Content-Type", "application/x-www-form-urlencoded");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		// header.put("Authorization", "Basic
		// YXBwS2V5OjRhZGYxY2Q3YWY0ZTJmYzY2NzJjZjZmZDMyNDhlMWRiMDkzMTcwZDBjYzc4ZGEwZTIxNmEwNWFiY2QyOWJkNWU=");
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);

		// Response responseBody =
		// expect().statusCode(302).given().with().formParams(map).headers(header).when().post(baseURL
		// + "/project/create");
		// String responseBody =
		// expect().statusCode(302).given().with().formParams(map).headers(header)
		// .relaxedHTTPSValidation().when().post(baseURL +
		// "/project/create").getBody().asString();

		String body = expect().statusCode(400).given().with().formParams(map).headers(header).relaxedHTTPSValidation()
				.when().post(baseURL + "/project/create").getBody().asString();

		System.out.println(body);
		return reqName;
	}

	public String addCandidate(String username, String password, String reqId, String canMailId,
			String ReqsubStatusId) {
		String email = CommonAction.generateRandomStrings(9, "Alphanumeric");
		String accessToken = getAuthToken(username, password);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("createProjectClicked", "1");
		map.put("addCandidate", "1");
		map.put("candidateProfile[name]", "Candidate" + email);
		APITestOps.candidateName = "Candidate" + email;
		if (canMailId.equalsIgnoreCase("")) {
			map.put("candidateProfile[alternateEmails][0][email]", email + "@yopmail.com");
		} else {
			map.put("candidateProfile[alternateEmails][0][email]", canMailId);
		}

		map.put("candidateProfile[alternateEmails][0][isPrimary]", "1");
		map.put("candidateProfile[alternatePhones][0][isPrimary]", "1");
		map.put("candidateProfile[experienceYears]", "999");
		map.put("candidateProfile[experienceMonths]", "00");
		map.put("candidateProfile[annualSalaryLacs]", "-1");
		map.put("candidateProfile[annualSalaryThousands]", "-1");
		map.put("candidateProfile[annualSalaryCurrency]", "INR");
		map.put("candidateProfile[expectedCTCLacs]", "0");
		map.put("candidateProfile[expectedCTCThousands]", "0");
		map.put("candidateProfile[expectedCTCCurrency]", "INR");

		map.put("projectId", reqId);
		if (reqId.equalsIgnoreCase("")) {
			map.put("project[projectName]", "Project" + email);
			requirementName = "Project" + email;
			System.out.println(requirementName);
		} else {
			map.put("project[projectName]", "");
		}

		System.out.println(candidateName);

		map.put("project[minExp]", "-1");
		map.put("project[maxExp]", "-1");
		map.put("project[minSalary]", "-1");
		map.put("project[salaryCurrency]", "Rupees");
		map.put("project[maxSalary]", "-1");
		map.put("visSettingRad", "1");

		map.put("subStatusId", ReqsubStatusId);
		System.out.println(ReqsubStatusId);

		map.put("subSourceId", "-1");
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String responseBody = expect().statusCode(302).given().with().formParams(map).headers(header)
				.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody().asString();
		// System.out.println(responseBody);
		PropFileHandler.writeProperty("reqName", requirementName);
		PropFileHandler.writeProperty("candidateName", candidateName);

		candidateId = responseBody.split("title")[1].replaceAll("[^0-9]", "");
		PropFileHandler.writeProperty("candidateId", candidateId);
		return candidateId;
	}

	public String addCandidate(String username, String password, String reqId, String canMailId) {
		String email = CommonAction.generateRandomStrings(9, "Alphanumeric");
		String accessToken = getAuthToken(username, password);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("createProjectClicked", "1");
		map.put("addCandidate", "1");
		map.put("candidateProfile[name]", "Candidate-" + email);
		APITestOps.candidateName = "Candidate-" + email;
		if (canMailId.equalsIgnoreCase("")) {
			map.put("candidateProfile[alternateEmails][0][email]", email + "@yopmail.com");
		} else {
			map.put("candidateProfile[alternateEmails][0][email]", canMailId);
		}
		map.put("candidateProfile[alternateEmails][0][isPrimary]", "1");
		map.put("candidateProfile[alternatePhones][0][isPrimary]", "1");
		map.put("candidateProfile[experienceYears]", "999");
		map.put("candidateProfile[experienceMonths]", "00");
		map.put("candidateProfile[annualSalaryLacs]", "-1");
		map.put("candidateProfile[annualSalaryThousands]", "-1");
		map.put("candidateProfile[annualSalaryCurrency]", "INR");
		map.put("candidateProfile[expectedCTCLacs]", "0");
		map.put("candidateProfile[expectedCTCThousands]", "0");
		map.put("candidateProfile[expectedCTCCurrency]", "INR");
		map.put("projectId", reqId);
		if (reqId.equalsIgnoreCase("")) {
			map.put("project[projectName]", "Project" + email);
			APITestOps.requirementName = "Project" + email;
		} else {
			map.put("project[projectName]", "");
		}
		map.put("project[minExp]", "-1");
		map.put("project[maxExp]", "-1");
		map.put("project[minSalary]", "-1");
		map.put("project[salaryCurrency]", "Rupees");
		map.put("project[maxSalary]", "-1");
		map.put("visSettingRad", "1");
		map.put("subStatusId", getAppConfigValue("Users.RMS.ReqsubStatusId"));
		map.put("subSourceId", "-1");
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String responseBody = expect().statusCode(302).given().with().formParams(map).headers(header)
				.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody().asString();
		// System.out.println(responseBody);
		PropFileHandler.writeProperty("reqName", requirementName);
		PropFileHandler.writeProperty("candidateName", candidateName);

		candidateId = responseBody.split("title")[1].replaceAll("[^0-9]", "");
		PropFileHandler.writeProperty("candidateId", candidateId);
		return candidateId;
	}

	private String createEmployer(String username, String password, String recruiterId, String chargeMode,
			String chargeValue, int invoiceGenerationAfterDays, int payableAfterDays, boolean isTaxExempted) {
		int billingDetailsCount = 1;
		int employerAddressCount = 1;
		String randomGroup = CommonAction.generateRandomStrings(9, "Alphanumeric");
		String accessToken = getAuthToken(username, password);
		Map<String, Object> bodyData = new HashMap<>();
		bodyData.put("action", "save");
		bodyData.put("employerId", "");
		Map<Object, Object> data = new HashMap<>();
		Map<Object, Object> billingDetails = new HashMap<>();
		List<Map<Object, Object>> billingDetailList = new ArrayList<Map<Object, Object>>();
		for (int i = 1; i <= billingDetailsCount; i++) {
			Map<Object, Object> billingDetail = new HashMap<Object, Object>();
			billingDetail.put("id", null);
			billingDetail.put("invoiceRateName", "Bill-" + randomGroup);
			APITestOps.billingCategory = "Bill-" + randomGroup;
			billingDetail.put("value", chargeValue);
			APITestOps.billingValue = "" + chargeValue;
			billingDetail.put("chargeMode", chargeMode);
			APITestOps.billingMode = "" + chargeMode;
			billingDetail.put("isActive", true);
			billingDetail.put("invoiceGenerationAfterDays", invoiceGenerationAfterDays);
			APITestOps.invoiceGenAfterDays = "" + invoiceGenerationAfterDays;
			billingDetail.put("payableAfterDays", payableAfterDays);
			APITestOps.payableAfterDays = "" + payableAfterDays;
			billingDetailList.add(billingDetail);
		}
		billingDetails.put("billingDetails", billingDetailList);
		billingDetails.put("invoiceGenerationAfterDays", 0);
		billingDetails.put("payableAfterDays", 0);
		Map<Object, Object> employerAddress = new HashMap<>();
		List<Map<Object, Object>> employerAddressList = new ArrayList<Map<Object, Object>>();
		for (int i = 1; i <= employerAddressCount; i++) {
			Map<Object, Object> empAddress = new HashMap<Object, Object>();
			empAddress.put("id", null);
			empAddress.put("address", "Address-" + CommonAction.generateRandomStrings(9, "Alphanumeric"));
			empAddress.put("gstin", "32ppp11111z1345");
			empAddress.put("pan", "ppp11111z1");
			empAddress.put("stateCode", "32");
			empAddress.put("isActive", true);
			empAddress.put("hasGst", true);
			empAddress.put("isTaxExempted", isTaxExempted);
			billToAddress = "" + empAddress.get("address");
			employerAddressList.add(empAddress);
		}
		employerAddress.put("employerAddress", employerAddressList);
		Map<Object, Object> groupDetails = new HashMap<>();
		groupDetails.put("name", "Employer - " + randomGroup);
		APITestOps.employerName = "Employer - " + randomGroup;
		groupDetails.put("description", "");
		groupDetails.put("anonymousName", "");
		groupDetails.put("anonymousDescription", "");
		Map<Object, Object> recruiterSelection = new HashMap<>();
		Map<Object, Object> recruiterList = new HashMap<>();
		recruiterList.put("76866590", "hd5oct5@yopmail.com");
		recruiterList.put("76866707", "rmspro_consultant@naukri.com");
		recruiterList.put("76866990", "rmspro_cons_subuser1@yopmail.com");
		// recruiterSelection.put("recruiterList", recruiterList);
		List<String> selectedRecruiter = new ArrayList<>();
		selectedRecruiter.add(recruiterId);
		recruiterSelection.put("selectedRecruiter", selectedRecruiter);
		recruiterSelection.put("visibilityOption", 1);
		data.put("groupDetails", groupDetails);
		data.put("billingDetails", billingDetails);
		data.put("employerAddress", employerAddress);
		data.put("recruiterSelection", recruiterSelection);
		data.put("isInvoiceContractUpdated", true);
		data.put("isAddressUpdated", true);
		bodyData.put("data", data);
		String body = APITestUtils.getAppConfigValueAsJson(bodyData);
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		expect().statusCode(200).given().with().body(body).headers(header).relaxedHTTPSValidation().when()
				.post(baseURL + "/employerApi/groupDetails").getBody().asString();
		return "Employer - " + randomGroup;
	}

	public String getGroupId(String username, String password, String empName) {
		String accessToken = getAuthToken(username, password);
		System.out.println("Employer Name: " + empName);
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String response = expect().statusCode(200).given().formParam("searchQuery", "").with().headers(header)
				.relaxedHTTPSValidation().when().post(baseURL + "/employer/list/1/addedOn/desc/40/html/1").getBody()
				.asString();
		// System.out.println(response);
		String toCompile = "a title=\"" + empName + "\".+?empDetails-(.+?)\"";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(response);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "Group Id not Found !!!!!!!!";
		}
	}

	private String getBillingCategory(String username, String password, String groupId) {
		String accessToken = getAuthToken(username, password);
		String uri = baseURL + "/employerApi/groupDetails/" + groupId + "?action=edit&tab=billingDetails";
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String response = expect().statusCode(200).given().headers(header).relaxedHTTPSValidation().when().get(uri)
				.getBody().asString();
		// System.out.println(response);
		String toCompile = "\"billingId\":(.+?),";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(response);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "Billing Category Id not Found !!!!!!!!";
		}
	}

	private String getRecruiterId(String username, String password) {
		String accessToken = getAuthToken(username, password);
		String uri = baseURL + "/employerApi/groupDetails?action=add&tab=recruiterSelection";
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String response = expect().statusCode(200).given().headers(header).relaxedHTTPSValidation().when().get(uri)
				.getBody().asString();
		// System.out.println(response);
		String toCompile = "\"recruiterList\".+?\"(.+?)\"";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(response);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "Recruiter Id not Found !!!!!!!!";
		}
	}

	private String[] createEmployerBodyData(String recruiterId, List<String> chargeMode, List<String> chargeValue,
			int invoiceGenerationAfterDays, int payableAfterDays, List<Boolean> isTaxExempted, int billingDetailsCount,
			int employerAddressCount) {

		String timeStamp = "" + System.currentTimeMillis();
		Map<String, Object> bodyData = new HashMap<>();
		bodyData.put("action", "save");
		bodyData.put("employerId", "");
		Map<Object, Object> data = new HashMap<>();
		Map<Object, Object> billingDetails = new HashMap<>();
		List<Map<Object, Object>> billingDetailList = new ArrayList<Map<Object, Object>>();
		String randomGroup;
		for (int i = 1; i <= billingDetailsCount; i++) {
			randomGroup = CommonAction.generateRandomStrings(9, "Alphanumeric");
			Map<Object, Object> billingDetail = new HashMap<Object, Object>();
			billingDetail.put("id", null);
			billingDetail.put("invoiceRateName", "Bill-" + randomGroup);
			billingDetail.put("value", chargeValue.get(i - 1));
			billingDetail.put("chargeMode", chargeMode.get(i - 1));
			billingDetail.put("isActive", true);
			billingDetail.put("invoiceGenerationAfterDays", invoiceGenerationAfterDays);
			billingDetail.put("payableAfterDays", payableAfterDays);
			billingDetailList.add(billingDetail);
		}
		billingDetails.put("billingDetails", billingDetailList);
		billingDetails.put("invoiceGenerationAfterDays", 0);
		billingDetails.put("payableAfterDays", 0);
		Map<Object, Object> employerAddress = new HashMap<>();
		List<Map<Object, Object>> employerAddressList = new ArrayList<Map<Object, Object>>();
		for (int i = 1; i <= employerAddressCount; i++) {
			Map<Object, Object> empAddress = new HashMap<Object, Object>();
			empAddress.put("id", null);
			empAddress.put("address", "Address-" + CommonAction.generateRandomStrings(9, "Alphanumeric"));
			empAddress.put("gstin", "12ppp11111z1345");
			empAddress.put("pan", "ppp11111z1");
			empAddress.put("stateCode", "12");
			empAddress.put("isActive", true);
			empAddress.put("hasGst", true);
			empAddress.put("isTaxExempted", isTaxExempted.get(i - 1));
			employerAddressList.add(empAddress);
		}
		employerAddress.put("employerAddress", employerAddressList);
		Map<Object, Object> groupDetails = new HashMap<>();
		groupDetails.put("name", "Employer - " + timeStamp);
		groupDetails.put("description", "");
		groupDetails.put("anonymousName", "");
		groupDetails.put("anonymousDescription", "");
		Map<Object, Object> recruiterSelection = new HashMap<>();
		List<String> selectedRecruiter = new ArrayList<>();
		selectedRecruiter.add(recruiterId);
		recruiterSelection.put("selectedRecruiter", selectedRecruiter);
		recruiterSelection.put("visibilityOption", 1);
		data.put("groupDetails", groupDetails);
		data.put("billingDetails", billingDetails);
		data.put("employerAddress", employerAddress);
		data.put("recruiterSelection", recruiterSelection);
		data.put("isInvoiceContractUpdated", true);
		data.put("isAddressUpdated", true);

		bodyData.put("data", data);
		String body = APITestUtils.getAppConfigValueAsJson(bodyData);
		// System.out.println(body);
		// System.out.println("Employer - " + timeStamp);
		return new String[] { "Employer - " + timeStamp, body };
	}

	protected Map<String, Object> createCandidatesBodyParams(String randomCandidateName, String randomCandidateEmailId,
			String randomRequirementName, String billingCategory, String groupId, String subStatusId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("createProjectClicked", "1");
		map.put("addCandidate", "1");
		map.put("candidateProfile[name]", randomCandidateName);
		map.put("candidateProfile[alternateEmails][0][email]", randomCandidateEmailId);
		map.put("candidateProfile[alternateEmails][0][isPrimary]", "1");
		map.put("candidateProfile[alternatePhones][0][isPrimary]", "1");
		map.put("candidateProfile[experienceYears]", "999");
		map.put("candidateProfile[experienceMonths]", "00");
		map.put("candidateProfile[annualSalaryLacs]", "-1");
		map.put("candidateProfile[annualSalaryThousands]", "-1");
		map.put("candidateProfile[annualSalaryCurrency]", "INR");
		map.put("candidateProfile[expectedCTCLacs]", "0");
		map.put("candidateProfile[expectedCTCThousands]", "0");
		map.put("candidateProfile[expectedCTCCurrency]", "INR");
		map.put("projectId", "");
		map.put("project[projectName]", randomRequirementName);
		map.put("project[minExp]", "-1");
		map.put("project[maxExp]", "-1");
		map.put("project[minSalary]", "-1");
		map.put("project[salaryCurrency]", "Rupees");
		map.put("project[maxSalary]", "-1");
		map.put("visSettingRad", "2");
		map.put("subStatusId", subStatusId);
		map.put("subSourceId", "-1");
		map.put("group", groupId);
		map.put("billingCategory", billingCategory);
		return map;
	}

	/**
	 * To create Group using createGroup API
	 * 
	 * @author rachit.mehrotra
	 * @param username
	 * @param password
	 */
	public void createNewGroup(String username, String password) {
		String groupName = "GroupName" + GenericFunctions.generateRandomStrings(6, "String");
		String accessToken = getAuthToken(username, password);
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

	private static class APITestUtils {
		protected static String getAppConfigValueAsJson(Map<String, Object> map) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(map);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	/**
	 * Add candidate and requirement with a group Id
	 * 
	 * Created for Offer Approval
	 * 
	 * @author udit.khanna
	 * 
	 * @param username
	 * @param password
	 * @param reqId
	 * @param canMailId
	 * @param ReqsubStatusId
	 * @param group
	 * @return candidateId created
	 */
	public String addCandidate(String username, String password, String reqId, String canMailId, String ReqsubStatusId,
			String group) {
		String email = CommonAction.generateRandomStrings(9, "Alphanumeric");
		String accessToken = getAuthToken(username, password);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> propertyFileReturnValuesMap = new HashMap<String, String>();
		APITestOps.candidateName = "Candidate" + email;

		try {
			map.put("createProjectClicked", "1");
			map.put("addCandidate", "1");
			map.put("candidateProfile[name]", "Candidate" + email);
			if (canMailId.equalsIgnoreCase("")) {
				map.put("candidateProfile[alternateEmails][0][email]", email + "@yopmail.com");
			} else {
				map.put("candidateProfile[alternateEmails][0][email]", canMailId);
			}

			map.put("candidateProfile[alternateEmails][0][isPrimary]", "1");
			map.put("candidateProfile[alternatePhones][0][isPrimary]", "1");
			map.put("candidateProfile[experienceYears]", "999");
			map.put("candidateProfile[experienceMonths]", "00");
			map.put("candidateProfile[annualSalaryLacs]", "-1");
			map.put("candidateProfile[annualSalaryThousands]", "-1");
			map.put("candidateProfile[annualSalaryCurrency]", "INR");
			map.put("candidateProfile[expectedCTCLacs]", "0");
			map.put("candidateProfile[expectedCTCThousands]", "0");
			map.put("candidateProfile[expectedCTCCurrency]", "INR");
			map.put("projectId", reqId);

			if (reqId.equalsIgnoreCase("")) {
				map.put("project[projectName]", "Project" + email);
				APITestOps.requirementName = "Project" + email;
			} else {
				map.put("project[projectName]", "");
			}

			map.put("project[minExp]", "-1");
			map.put("project[maxExp]", "-1");
			map.put("project[minSalary]", "-1");
			map.put("project[salaryCurrency]", "Rupees");
			map.put("project[maxSalary]", "-1");
			map.put("visSettingRad", "1");
			map.put("subStatusId", ReqsubStatusId);
			map.put("subSourceId", "-1");
			map.put("group", group);
			Map<String, String> header = new HashMap<>();
			header.put("Accept", "application/json");
			header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
			header.put("clientId", clientId);
			header.put("deviceId", deviceId);
			String responseBody = expect().statusCode(302).given().with().formParams(map).headers(header)
					.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody()
					.asString();

			candidateId = responseBody.split("title")[1].replaceAll("[^0-9]", "");

			propertyFileReturnValuesMap.put("CandidateNameForApproval", APITestOps.candidateName);
			propertyFileReturnValuesMap.put("CandidateEmailForApproval", email + "@yopmail.com");
			propertyFileReturnValuesMap.put("CandidateIdForApproval", candidateId);
			propertyFileReturnValuesMap.put("RequirementNameForApproval", APITestOps.requirementName);
			fillCandidateDetailsInPropertyFile(propertyFileReturnValuesMap);
			TestNGLogUtility.pass("Candidate :" + candidateId + " added to requirement "
					+ map.get("project[projectName]").toString() + " to user " + username);
			return candidateId;
		} catch (Exception e) {
			TestNGLogUtility.fail("Add candidate API Failed, following are the arguments used:");
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				TestNGLogUtility.info(entry.getKey() + " : " + entry.getValue().toString());
			}
			return candidateId;
		}
	}

	/**
	 * fill Candidate Details In Offer Management Property File
	 * 
	 * @param ReturnValuesMap
	 */
	private void fillCandidateDetailsInPropertyFile(Map<String, String> returnValuesMap) {
		for (Map.Entry<String, String> entry : returnValuesMap.entrySet())
			ReadWritePropertyFile.setProperty(entry.getKey(), entry.getValue(),
					OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

    public String getCandidateIdWithEmployerOfRMSConsultant(String chargeMode, String chargeValue,
                                                            int invoiceGenerationAfterDays, int payableAfterDays, boolean isTaxExempted) {
        String recruiterId = getRecruiterId(username, password);
        String employerName = createEmployer(username, password, recruiterId, chargeMode, chargeValue,
                invoiceGenerationAfterDays, payableAfterDays, isTaxExempted);
        String groupId = getGroupId(username, password, employerName);
        String billingCategory = getBillingCategory(username, password, groupId);
        String applicationId = addCandidate(username, password, billingCategory, groupId);
        this.applicationId = applicationId;
        System.out.println("Application Id : " + applicationId);
        return applicationId;
    }
    
    /**
	 * @author ambar.gupta
	 * This method is used to add candidate(s) to an existing or new requirement using SaveBasicCandidate API
	 * For adding candidate to new requirement, do not pass ProjectID as new will be created 
	 * For adding candidate to existing requirement, ProcessID is mandatory and requirement name can also be passed
	 * EmailID and requirement name will be created randomly if not passed.
	 * @param username, password, projectID, reqName canMailId, ReqsubStatusId,
	 * @return HashMap passed to body of API
	 */
	public Map<String, Object> addCandidateInExistingOrNewRequirement(String username, String password, String projectID,String reqName, String canMailId,String ReqsubStatusId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> header = new HashMap<>();
		String random = CommonAction.generateRandomStrings(9, "Alphanumeric");
		String accessToken = getAuthToken(username, password);
		candidateName = "Candidate" + random;
		
		// Using Email if given. Otherwise setting random email.		
		if (canMailId.equalsIgnoreCase("")) 
			canMailId = "Email" + random + "@yopmail.com";
		else {
			if(!canMailId.contains("@")) {
				canMailId=canMailId+ random + "@yopmail.com";
			}
		}
			
		// Setting random requirement name if Process ID is null
		if (!projectID.equalsIgnoreCase(""))
			requirementName = reqName;
		else 
			requirementName = "Project" + random;
			
		map.put("createProjectClicked", "1");
		map.put("addCandidate", "1");
		map.put("candidateProfile[name]", candidateName);
		map.put("candidateProfile[alternateEmails][0][email]", canMailId);
		map.put("projectId", projectID);
		map.put("project[projectName]", requirementName);
		map.put("subStatusId", ReqsubStatusId);
		map.put("subSourceId", "-1");
		map.put("candidateProfile[alternateEmails][0][isPrimary]", "1");
		map.put("candidateProfile[alternatePhones][0][isPrimary]", "1");

		header.put("Accept", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		
		String responseBody = expect().statusCode(302).given().with().formParams(map).headers(header)
				.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody().asString();
		candidateId = responseBody.split("title")[1].replaceAll("[^0-9]", "");
		map.put("candidateId", candidateId);
		TestNGLogUtility.info("Candidate "+ map.get("candidateId").toString()+" added to requirement "+ map.get("project[projectName]").toString()+" to user "+ username);
		
		return  map;
	}
}