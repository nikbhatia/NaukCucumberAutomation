package com.naukri.stepdefinitions.MLH;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.naukri.automation.util.MongoDBConnector;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.MLH.OldReportDashboardPagePO;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class MLHOldReportsStepDef {
	
	OldReportDashboardPagePO objOldReportDash = (OldReportDashboardPagePO) PageObjectWrapper.getObject(OldReportDashboardPagePO.class);
	RequirementCreationPagePO objRequirementCreationPagePO=(RequirementCreationPagePO) PageObjectWrapper.getObject(RequirementCreationPagePO.class);
	HashMap<String, String>hmapValuesToBeUpdatedInMongoCollection=new HashMap<>();
	HashMap<String, String>hmapfilter=new HashMap<>();
	JSONObject testCaseData=new JSONObject();
	static String testCaseName="";
	HashMap<String, String> hmap = new HashMap<>();
	
	@Given("User is on generate {string} page")
	public void clickOnReportType(String reportType)
	{
		objOldReportDash.clickOnReportName(reportType);
		TestNGLogUtility.info("User click on "+reportType);
	}
	
	@When("User click on {string} tab")
	public void clickOnTab(String tabName)
	{
		objOldReportDash.clickOnTab(tabName);
		TestNGLogUtility.info("User click on "+tabName);
	}
	
	@And("User click on Generate Report button")
	public void clickOnGenerateReportButton()
	{
		objOldReportDash.clickOnGenerateReport();
		TestNGLogUtility.pass("User click on Generate Report button");
	}
	
	@And("User hover on {string}")
	public void hoverOverDownload(String anchorTxt)
	{
		objOldReportDash.hoverOver(anchorTxt);
		TestNGLogUtility.info("Hover over "+anchorTxt);
	}
	
	@When("User click on {string} download")
	public void clickOnDownload(String downloadType)
	{
		objOldReportDash.clickOnReportName(downloadType);
		TestNGLogUtility.info("User click on "+downloadType+" download");
	}
	
	@Then("Verify header of lightbox is {string}")
	public void verifyHeaderTxtOfLB(String txt)
	{
		Assert.assertTrue(objOldReportDash.isHeaderTxtDisplayed(txt));
		TestNGLogUtility.pass("Header txt is "+txt);
	}

	@SuppressWarnings("unchecked")
	@And("User fill values on Report page")
	public void userFillValuesOnReportPage(DataTable dt) throws ParseException {
		 testCaseName=dt.asList(String.class).get(0).toString();
		//this is WIP code 
		/*if (!(objRequirementCreationPagePO.requirementDetails.get("requirementName")==null)) {
			hmapValuesToBeUpdatedInMongoCollection.put("Requirements",objRequirementCreationPagePO.requirementDetails.get("requirementName").toString());
			MongoDBConnector.UpdateValuesInMongoDocument("MLHOldReports", hmapValuesToBeUpdatedInMongoCollection,"TestCaseName",testCaseName);

		} else if (!PropFileHandler.readProperty("GroupName").equals("")) {
			hmapValuesToBeUpdatedInMongoCollection.put("Group",	PropFileHandler.readProperty("GroupName").toString());
			MongoDBConnector.UpdateValuesInMongoDocument("MLHOldReports", hmapValuesToBeUpdatedInMongoCollection,"TestCaseName", testCaseName);
		}*/
		JSONObject testCaseData = MongoDBConnector.getJSONObject("MLHOldReports", "TestCaseName",testCaseName);
		/*System.out.println(testCaseData);
		for(int i=1;i<testCaseData.entrySet().size();i++) {
		JSONObject testCaseData1=(JSONObject) testCaseData.get("TC"+i);
		System.out.println("Values--"+ testCaseData1);
		}*/
		objOldReportDash.FillReportPageDetails(testCaseData);
	}
	
	@And("User store the report data in database")
	public void saveReportDataInMongoDBCOllection(DataTable dt)  {
		hmap = objOldReportDash.getReportDataInMap();
		testCaseName = dt.asList(String.class).get(0).toString();
		objOldReportDash.UpdateReportDataInMongo(testCaseName, hmap);
	}

	@SuppressWarnings("unchecked")
	@And("Verify the data in report is displayed successfully")
	public void userVerifyTheReportDataWithUI(DataTable dt)  {
		testCaseName = dt.asList(String.class).get(0).toString();
		JSONObject d1 = MongoDBConnector.getJSONObject("MLHOldReports", "TestCaseName", "Output" + testCaseName + "");
		JSONObject d2 = MongoDBConnector.getJSONObject("MLHOldReports", "TestCaseName", "Output" + testCaseName + "");
		objOldReportDash.compareUIReportDataWithStoredData(d1, d2);
	}

	@When("User update {string} details in database")
	public void user_update_details_in_database(String key, DataTable dt) {
		testCaseName = dt.asList(String.class).get(0).toString();
		JSONObject testCaseData = MongoDBConnector.getJSONObject("MLHOldReports", "TestCaseName","Output" + testCaseName + "");
		String value = testCaseData.get(key).toString();
		hmap.put(key, value);
		objOldReportDash.UpdateReportDataInMongo(testCaseName, hmap);
		// JSONObject testCaseData1 = MongoDBConnector.getJSONObject("MLHOldReports",
		// hmap, "TestCaseName", "Output"+testCaseName+"");
	}
}
