package com.naukri.stepdefinitions.Reports;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.ReportsCommonPageObject;
import com.naukri.stepdefinitions.Applications.AddASingleProfileStepDef;
import com.naukri.pageobjects.Reports.DashboardPageObject;
import com.naukri.test.base.BaseAutomation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ReportsCommonStepDef extends BaseAutomation {

	GenericFunctions csmGeneric = new GenericFunctions();
	ReportsCommonPageObject ReportsCommonObject = new ReportsCommonPageObject();
	DashboardPageObject dashboardPO = new DashboardPageObject();
	String reportName = "";
	public ArrayList<String> CustomStagesListFromReports = new ArrayList<String>();

	@Given("User logs in to Rms from \"(.*)\" account as a \"(.*)\"")
	public void loginToRmsFromSpecificSubscription(String subscriptionType, String userType) {
		csmGeneric.setUsernameAndPassword(subscriptionType, userType);
	}

	@When("User goes to the \"(.*)\" Report")
	public void navigateToSpecifiedReport(String reportName) {
		csmGeneric.launchSpecificURL(getAppConfigValue("ReportURLs." + reportName));
	}

	@When("User clicks on \"(.*)\" checkbox")
	public void clickOnShareOrScheduleCheckBox(String checkBoxToBeClicked) {
		ReportsCommonObject.clickOnShareOrScheduleCheckBoxOnSaveSchedulePopUp(checkBoxToBeClicked);
	}

	@When("User clicks on Save button in saveSchedulePopUp")
	public void clickOnSave() {
		ReportsCommonObject.clickOnSaveOnSaveSchedulePopUp();
	}

	@When("User switches to new window")
	public void userSwitchesToChildWindow() {
		switchToChildWindow();
	}

	@When("User switches to parent window")
	public void userSwitchesToParentWindow() {
		switchToParentWindow();
	}

	@Then("User verifies that Download Link is generated in the new window")
	public void verifyDownloadLink() {
		Assert.assertTrue(ReportsCommonObject.verifyDownloadLink(), "[Assertion Fail]: Download Link not Generated");
		TestNGLogUtility.pass("[Assertion Pass]: Download link generated");
	}

	@When("User clicks on SaveSchedule on detailed Report and return report name")
	public void clickOnSaveSchedule() {
		reportName = ReportsCommonObject.returnReportNameFromDetailedView();
	}

	@Then("Verify that the name of first report is the one that is saved above when the report is saved from detailed view")
	public void verifyReverseChronologicalOrderInDetailedReport() {
		Assert.assertTrue(ReportsCommonObject.verifyReverseChronologicalOrderInDetailedReport(reportName),
				"[Assertion Fail]: Reports are not saved in reverse chronolgical order");
		TestNGLogUtility.pass("[Assertion Pass]: Reports are saved in reverse chronological order");
	}

	@Then("User verifies that this particular Detailed Report has loaded")
	public void checkIfReportIsLoaded() {
		Assert.assertTrue(ReportsCommonObject.ReLoadingInCaseOfError(),
				"[Assertion Fail]: Reports couldn't be loaded even after multiple tries ");
		TestNGLogUtility.pass("[Assertion Pass]: Reports loaded -> Further actions can now be performed");
	}

	@When("User clicks on \"(.*)\" subTab in Detailed Report")
	public void clickOnRequiredSubtabInDetailedReport(String tabName) {
		ReportsCommonObject.clickOnMentionedTabInDetailedReport(tabName);
	}

	@When("User clicks on \"(.*)\" setting option available in \"(.*)\" Report")
	public void clickOnSecondSettingOptionForRequiredReport(String optionToBeSelected, String reportName) {
		ReportsCommonObject.clickOnSecondSettingOptionForCustomReports(optionToBeSelected, reportName);
	}

	@When("User clicks on Settings Icon in detailed report")
	public void clickOnSettingIconInDetailedReport() {
		ReportsCommonObject.clickOnSettingIconInAnyDetailedReport();
	}

	@When("User gets all the selected custom stages present in report")
	public void getAllSelectedStagesInCustomReport() {
		CustomStagesListFromReports = ReportsCommonObject.getTotalNumberAndListOfSelectedStages();
	}

	@When("User clicks on Apply button for custom Stages")
	public void clickOnApplyButtonForCustomStages() {
		ReportsCommonObject.clickOnApplyButtonForColumnSelectionForCustomStages();
	}

	@When("User selects a stage if maximum limit is not reached")
	public void selectOneCustomStage() {
		ReportsCommonObject.selectOneCustomStageForCheckingMaximumlimit();
	}

	@Then("Verify that only the stages that are selected in \"(.*)\" report are visible as column names")
	public void verifyColumnNamesAccordingToSelectionStages(String reportName) {
		Assert.assertTrue(
				ReportsCommonObject.verifyColumnNamesAccordingToSelectionStages(reportName,
						CustomStagesListFromReports),
				"[Assertion Fail]: Column names are not updated according to the selected stage");
		TestNGLogUtility.pass("[Assertion Pass]: Column names are updated according to the selected stage");
	}

	@When("User clicks on Filter Icon")
	public void clickOnFilterIcon() {
		ReportsCommonObject.clickOnFilterIconInDetailedReport();
	}

	@Then("User verifies the list of filters available for \"(.*)\" Report")
	public void verifyListOfFiltersForRequiredReport(String reportName, DataTable summaryElementsOnDashboardTable) {
		List<String> expectedListOfFilters = summaryElementsOnDashboardTable.asList(String.class);
		List<String> visibleListOfFilters = ReportsCommonObject.verifyFiltersList(reportName);
		Assert.assertEquals(expectedListOfFilters, visibleListOfFilters,
				"[Assertion Fail]: The list of filters is not as per the requirement ");
		TestNGLogUtility.pass("[Assertion Pass]: The list of filters is as per the requirement ");
	}

	@When("User selects \"(.*)\" setting")
	public void clickOnTheRepsectiveStageSettingInDetailedReport(String selectedStageSetting) {
		ReportsCommonObject.clickOnRequiredStageSettingFromDetailedReport(selectedStageSetting);
	}
	
	@Then("User should be able to see recent created requirement in the report")
	public void User_should_be_able_to_see_recent_created_requirement_in_the_report() {
		Assert.assertTrue(ReportsCommonObject.verifyCreatedRequirementConversionInReport(AddASingleProfileStepDef.requirementName), "Requirement is not displaying on Reports page.");
		TestNGLogUtility.pass("[Assertion Pass]: Created Requirement has been appearing in report successfully.");
	}
	
	@Then("User should be able to see recent created requirement in Stage Level Tat report")
	public void User_should_be_able_to_see_recent_created_requirement_in_stage_Level_the_report() {
		Assert.assertTrue(ReportsCommonObject.verifyCreatedRequirementInStageTATReport(AddASingleProfileStepDef.requirementName), "Requirement is not displaying on Reports page.");
		TestNGLogUtility.pass("[Assertion Pass]: Created Requirement has been appearing in report successfully.");
	}
	
	@Then("User should be able to see candidate count against \"(.*)\" Stage")
	public void User_should_be_able_to_see_recent_created_requirement_in_stage_Level_the_report(String stageName) {
		Assert.assertTrue(ReportsCommonObject.verifyCandidateCountAgainstStage(AddASingleProfileStepDef.requirementName, stageName), "Created Candidate count against stage is not displaying on Reports page.");
		TestNGLogUtility.pass("[Assertion Pass]: Created Candidate count against stage has been appearing in report successfully.");
	}
}
