package com.naukri.automation.util;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BillingAPI {
	
	public static String username = YamlReader.getAppConfigValue("Users.ProConsultant.Superuser.username");
	public static String password = YamlReader.getAppConfigValue("Users.Password");
//	final String baseURL = "https://rms.naukri.com";
//	final String authURL = "https://recruit.naukri.com";
	

	final String baseURL= YamlReader.getAppConfigValue("API.baseURL");
	final String authURL= YamlReader.getAppConfigValue("API.authURL");
	
	final String clientId = "r3sndr01d";
	String hmId = "", deviceId = "";
	public static String applicationId, candidateName, requirementName, billingCategory, employerName, billingValue,
			billingMode, invoiceGenAfterDays, payableAfterDays, billToAddress;
	public static Map<String, Object> candidateDataByApplicationIdAsJSON = new HashMap<>();
	public static Map<String, Object> employerDataByEmployerNameAsJSON = new HashMap<>();

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
	
	public String[] createMultipleCandidatesForSingleEmployer(String[] randomCandidateName, String[] randomCandidateEmailId, String[] randomRequirementName, String employerName, String subStatusId, int candidatesCount) {
		String groupId = getGroupId(username, password, employerName);
		String billingCategory = getBillingCategory(username, password, groupId);
		String accessToken = getAuthToken(username, password);
		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");
		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);
		String[] applicationIdList = new String[candidatesCount];
		
		for(int i=0;i<candidatesCount;i++) {
		Map<String, Object> candidateData= createCandidatesBodyParams(randomCandidateName[i], randomCandidateEmailId[i], randomRequirementName[i], billingCategory, groupId, subStatusId);
		
		String responseBody = expect().statusCode(302).given().with().formParams(candidateData).headers(header)
				.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody().asString();
		
		applicationIdList[i]=responseBody.split("title")[1].replaceAll("[^0-9]", "");
		
		candidateDataByApplicationIdAsJSON.put(applicationIdList[i], BillingApi.getDataAsJson(candidateData));
		
		}
		
		return applicationIdList;
	}
	
	public String createEmployerWithOptions(List<String> chargeMode,
			List<String> chargeValue, int invoiceGenerationAfterDays, int payableAfterDays, List<Boolean> isTaxExempted,
			int billingDetailsCount, int employerAddressCount)
	{
		String recruiterId = getRecruiterId(username, password);
		String data[]=createEmployerBodyData(recruiterId,chargeMode,chargeValue,invoiceGenerationAfterDays,payableAfterDays,isTaxExempted,billingDetailsCount,employerAddressCount);
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
		deviceId = "dev" + GenericFunctions.generateRandomStrings(6, "Number");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		String bodydata = BillingApi.getDataAsJson(map);

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

	private String addCandidate(String username, String password, String billingCategory, String groupId) {
		String email = GenericFunctions.generateRandomStrings(9, "Alphanumeric");
		String accessToken = getAuthToken(username, password);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("createProjectClicked", "1");
		map.put("addCandidate", "1");
		map.put("candidateProfile[name]", "Candidate-" + email);
		BillingAPI.candidateName = "Candidate-" + email;
		TestNGLogUtility.info("Candidate Name " + BillingAPI.candidateName);
		map.put("candidateProfile[alternateEmails][0][email]", email + "@yopmail.com");
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
		map.put("project[projectName]", "Req-" + email);
		BillingAPI.requirementName = "Req-" + email;
		map.put("project[minExp]", "-1");
		map.put("project[maxExp]", "-1");
		map.put("project[minSalary]", "-1");
		map.put("project[salaryCurrency]", "Rupees");
		map.put("project[maxSalary]", "-1");
		map.put("visSettingRad", "1");
		map.put("subStatusId", "29374");
		map.put("subSourceId", "-1");
		map.put("group", groupId);
		map.put("billingCategory", billingCategory);

		Map<String, String> header = new HashMap<>();
		header.put("Accept", "application/json");

		header.put("Authorization", "Oauth oauth_consumer_key=AT,oauth_token=" + accessToken);
		header.put("clientId", clientId);
		header.put("deviceId", deviceId);

		String responseBody = expect().statusCode(302).given().with().formParams(map).headers(header)
				.relaxedHTTPSValidation().when().post(baseURL + "/application/saveCandidateBasic").getBody().asString();
		if(!expect().statusCode(302).toString().equals(302)) 
			TestNGLogUtility.info(responseBody);
		return responseBody.split("title")[1].replaceAll("[^0-9]", "");

	}

	private String createEmployer(String username, String password, String recruiterId, String chargeMode,
			String chargeValue, int invoiceGenerationAfterDays, int payableAfterDays, boolean isTaxExempted) {
		int billingDetailsCount = 1;
		int employerAddressCount = 1;
		String randomGroup = GenericFunctions.generateRandomStrings(9, "Alphanumeric");
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
			BillingAPI.billingCategory = "Bill-" + randomGroup;
			billingDetail.put("value", chargeValue);
			BillingAPI.billingValue = "" + chargeValue;
			billingDetail.put("chargeMode", chargeMode);
			BillingAPI.billingMode = "" + chargeMode;
			billingDetail.put("isActive", true);
			billingDetail.put("invoiceGenerationAfterDays", invoiceGenerationAfterDays);
			BillingAPI.invoiceGenAfterDays = "" + invoiceGenerationAfterDays;
			billingDetail.put("payableAfterDays", payableAfterDays);
			BillingAPI.payableAfterDays = "" + payableAfterDays;
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
			empAddress.put("address", "Address-" + GenericFunctions.generateRandomStrings(9, "Alphanumeric"));
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
		BillingAPI.employerName = "Employer - " + randomGroup;
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
		String body = BillingApi.getDataAsJson(bodyData);

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

	private String getGroupId(String username, String password, String empName) {
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
			TestNGLogUtility.info("group id " + matcher.group(1));
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
		
		
		String response = expect().given().headers(header).relaxedHTTPSValidation().when().get(uri)
				.getBody().asString();
		System.out.println("response " + response);
		String toCompile = "\"billingId\":(.+?),";
		Pattern pattern = Pattern.compile(toCompile);
		Matcher matcher = pattern.matcher(response);
		if (matcher.find()) {
			TestNGLogUtility.info("billing categoty " + matcher.group(1));
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

	private String[] createEmployerBodyData(String recruiterId, List<String> chargeMode,
			List<String> chargeValue, int invoiceGenerationAfterDays, int payableAfterDays, List<Boolean> isTaxExempted,
			int billingDetailsCount, int employerAddressCount) {
		
		String timeStamp = ""+System.currentTimeMillis();
		Map<String, Object> bodyData = new HashMap<>();
		bodyData.put("action", "save");
		bodyData.put("employerId", "");
		Map<Object, Object> data = new HashMap<>();

		Map<Object, Object> billingDetails = new HashMap<>();

		List<Map<Object, Object>> billingDetailList = new ArrayList<Map<Object, Object>>();
		String randomGroup;
		for (int i = 1; i <= billingDetailsCount; i++) {
			randomGroup = GenericFunctions.generateRandomStrings(9, "Alphanumeric");
			Map<Object, Object> billingDetail = new HashMap<Object, Object>();
			billingDetail.put("id", null);
			billingDetail.put("invoiceRateName", "Bill-" + randomGroup);
			billingDetail.put("value", chargeValue.get(i-1));
			billingDetail.put("chargeMode", chargeMode.get(i-1));
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
			empAddress.put("address", "Address-" + GenericFunctions.generateRandomStrings(9, "Alphanumeric"));
			empAddress.put("gstin", "12ppp11111z1345");
			empAddress.put("pan", "ppp11111z1");
			empAddress.put("stateCode", "12");
			empAddress.put("isActive", true);
			empAddress.put("hasGst", true);
			empAddress.put("isTaxExempted", isTaxExempted.get(i-1));
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
		String body = BillingApi.getDataAsJson(bodyData);
		//System.out.println(body);
		//System.out.println("Employer - " + timeStamp);
		return new String[] {"Employer - " + timeStamp,body};
	}
	
	
	
	protected Map<String, Object> createCandidatesBodyParams(String randomCandidateName, String randomCandidateEmailId, String randomRequirementName, String billingCategory, String groupId, String subStatusId) {
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
	
	private static class BillingApi {

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

}
