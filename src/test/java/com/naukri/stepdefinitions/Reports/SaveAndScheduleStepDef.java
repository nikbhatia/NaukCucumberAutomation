package com.naukri.stepdefinitions.Reports;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.SaveAndSchedulePageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class SaveAndScheduleStepDef {

	GenericFunctions csmGeneric = new GenericFunctions();
	SaveAndSchedulePageObject SaveAndScheduleObject = new SaveAndSchedulePageObject();
	String reportName = "", firstReportName = "", emailIdText = "";
	int noOfRecruiters = 0;

	@When("User clicks on Mail text area")
	public void clickOnMailTextAreaInSaveSchedulePopUp() {
		SaveAndScheduleObject.clickOnMailTextAreaInSaveSchedulePopUp();
	}

	@When("User enters a wrong mail ID")
	public void enterWrongValueForMailIdInSaveScheulePopUp() {
		SaveAndScheduleObject.enterValueForMailIdInSaveSchedulePopUp();
	}

	@Then("Verify that user is able to see the Error message for invalid EmailId")
	public void testErrorMessageForInvalidMail() {
		Assert.assertTrue(SaveAndScheduleObject.verifyErrorMessageForInvalidMailInSaveSchedulePopUp(),
				"[Assertion Fail]: No error message for wrong mail Id");
		TestNGLogUtility.pass("[Assertion Pass]: Expected error message is visible ");
	}

	@When("User clicks on first Report from list")
	public void clikcOnFirstSavedReportFromList() {
		SaveAndScheduleObject.clickonFirstReportFromList();
	}

	@Then("User verifies that time duration of the saved report should be \"(.*)\"")
	public void testSelectedTimeDurationInSavedReport(String expectedTimeDuration) {
		Assert.assertTrue(SaveAndScheduleObject.verifySelectedTimeDurationInSavedReport(expectedTimeDuration),
				"[Assertion Fail]: The time duration duration visible in the saved report is the one that was chosen while saving the report");
		TestNGLogUtility.pass(
				"[Assertion Pass]: The time duration duration visible in the saved report is not the one that was chosen while saving the report ");
	}

	@Then("User verifies that expected filters that are applied are visible as tag in the saved report")
	public void testTagsForAppliedFilterInSavedReport(DataTable expectedAppliedFilterListDataTable) {
		List<String> expectedAppliedFilterList = expectedAppliedFilterListDataTable.asList(String.class);
		List<String> visibleAppliedFiltersList = SaveAndScheduleObject.verifyTagsInSavedReportForAppliedFilter();
		Assert.assertEquals(expectedAppliedFilterList, visibleAppliedFiltersList,
				"[Assertion Fail]: The applied filter is not visible in the saved report");
		TestNGLogUtility.pass("[Assertion Pass]: The applied filter is visible in the saved report");
	}

	@When("User chooses a mailID from the available DD options and also get the mail ID Text of the chosen one")
	public void chooseFirstMailIdToShareTheReportAndReturnTextForTheChosenId() {
		emailIdText = SaveAndScheduleObject.chooseMailIdFromDdOptions();
	}

	@Then("Verify that the Id in the first sharedWith field is same as the emailIdText chosen earlier")
	public void testCorrectEmailIdVisibilityOnListingPage() {
		Assert.assertTrue(SaveAndScheduleObject.verifyVisibilityOfEmailId(emailIdText),
				"[Assertion Fail]: Correct Shared emailID is visible");
		TestNGLogUtility.pass("[Assertion Pass]: Expected Id is visible in the shared list");
	}

	@When("User gets the first saved report name from List")
	public void getFirstReportNameFromList() {
		firstReportName = SaveAndScheduleObject.getFirstReportNameFromList();
	}

	@Then("Verify that the expected saved report has opened")
	public void testSavedReportHasOpenedSuccessfully() {
		Assert.assertTrue(SaveAndScheduleObject.verifySavedReportHasOpenedSuccessfully(firstReportName),
				"[Assertion Fail]: Expected saved report cannot be opened");
		TestNGLogUtility.pass("[Assertion Pass]: Expected saved report opened ");
	}

	@When("User gets the first saved report name from Dashboard")
	public void getFirstReportNameFromDashboard() {
		firstReportName = SaveAndScheduleObject.getFirstReportNameFromDashboard();
	}

	@When("User clicks on first report from the SaveSchedule report widget")
	public void clickOnFirstSavedReportFromDashboard() {
		SaveAndScheduleObject.clickOnFirstReportFromDashboard();
	}

	@Then("Verify that the names of first two reports should be different")
	public void testThatDuplicateReportsAreNotSaved() {
		Assert.assertTrue(SaveAndScheduleObject.verifyDuplicateReports(),
				"[Assertion Fail]: On saving one requirement aging reports, more than 1 are visible on SaveSchedule widget");
		TestNGLogUtility.pass("[Assertion Pass]: User is able to save the report as expected ");
	}

	@When("User clicks on \"(.*)\" frequency in SaveSchedulePopUp")
	public void clickOnRespectiveFrequencyToScheduleReport(String frequencyOption) {
		SaveAndScheduleObject.clickOnRespectiveFrequencyWhileSchedulingTheReport(frequencyOption);
	}

	@Then("Verify that confirmation message is displayed when the report is scheduled")
	public void testConfirmationMessageForScheduledReport() {
		Assert.assertTrue(SaveAndScheduleObject.verifyConfirmationMessageWhenReportIsScheduled(),
				"[Assertion Fail]: Confirmation Message is not displayed when a report is saved ");
		TestNGLogUtility.pass("[Assertion Pass]: Confirmation message is displayed when a report is saved ");
	}

	@When("User mousehovers on the first saved report name on listing page")
	public void hoverOnFirstReportFromList() {
		SaveAndScheduleObject.hoverOnFirstReportOnTheSavedScheduledList();
	}

	@When("User mousehovers on icon ellipses against a saved report on listing page")
	public void hoverOnEllipsesOnListingPageAgainstFirstSavedReport() {
		SaveAndScheduleObject.mouseHoverOnEllipsesOnListingPage();
	}

	@When("User clicks on \"(.*)\" on listing page")
	public void clickDownloadOnListingPageAgainstFirstSavedReport(String elementToBeClicked) {
		SaveAndScheduleObject.clickRequiredOptionOnListingPage(elementToBeClicked);
	}

	@Then("Verify that \"(.*)\" should be visible in the SaveSchedule popup")
	public void testCorrectSettingIsVisibleInSchedulePopUp(String settingToBeConfirmed) {
		Assert.assertTrue(SaveAndScheduleObject.verifyFirstStageInSchedulePopUp(settingToBeConfirmed),
				"[Assertion Fail]: Required Settings information is not visible in the save/schedule popup");
		TestNGLogUtility.pass("[Assertion Pass]: Selected Stage Settings are visible in the save/schedule pop-up");
	}

	@Then("Verify that the coloumn names of listing page are as per the requirement")
	public void testColumnNamesForListingPage(DataTable expectedColumnNamesDataTable) {
		List<String> expectedColumnNames = expectedColumnNamesDataTable.asList(String.class);
		List<String> visibleListOfColumnNames = SaveAndScheduleObject.verifyColumnNamesForListingPage();
		Assert.assertEquals(expectedColumnNames, visibleListOfColumnNames,
				"[Assertion Fail]: Column names are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Column names are as per the requirement");
	}

	@Then("Verify that Required Scheduled icon is visible against the recent scheduled report")
	public void testScheduledClockIconAgainstScheduledReport() {
		Assert.assertTrue(SaveAndScheduleObject.verifySchedulediconForRecentReport(),
				"[Assertion Fail]: Scheduled Clock Icon is not visible on the dashboard widget");
		TestNGLogUtility.pass("[Assertion Pass]: Scheduled Clock Icon is visible on the dashboard widget");
	}

	@Then("Verify that options in the ellipses of savedOrScheduled report are DropDown are as per the requirement")
	public void testOptionsAvailableUnderEllipsesElementsForRequiredSavedReport(
			DataTable summaryElementsOnDashboardTable) {
		List<String> expectedListOfOptions = summaryElementsOnDashboardTable.asList(String.class);
		List<String> visibleListOfOptions = SaveAndScheduleObject.verifyEllipsesElementsForRequiredReport();
		Assert.assertEquals(expectedListOfOptions, visibleListOfOptions,
				"[Assertion Fail]: Ellipses Elements of the required Report are not as per the requirement ");
		TestNGLogUtility.pass("[Assertion Pass]: Ellipses Elements of required Reports are as per the requirement");
	}

	@When("User gets the list of all the recruiters")
	public void getAllRecruitersFromSettingspage() {
		noOfRecruiters = SaveAndScheduleObject.getTotalNoOfRecruitersFromSettingspage();
	}

	@When("User clicks on \"(.*)\" button on the delete conformation box")
	public void clickOnDeleteButtonInDeleteConformationBox(String buttonToBeClicked) {
		SaveAndScheduleObject.clickOnDeleteButtonInDeleteCOnformationBox(buttonToBeClicked);
	}

	@Then("Verify that the options in list while scheduling contains all recruiter names")
	public void testRecruitersListPresentInShareOptionInSaveSchedulePopUp() {
		Assert.assertTrue(SaveAndScheduleObject.verifyTheNumberOfRecruitersWhileSharingTheReport(noOfRecruiters),
				"[Assertion Fail]: Recruiters list provided in the scheduling Mail list does not contains all the recruiters");
		TestNGLogUtility.pass(
				"[Assertion Pass]: Recruiters list provided in the schedulingMail list contains all the recruiters");
	}

	@Then("User verifies that the report has been deleted successfully")
	public void testDeletionOfSavedReport() {
		Assert.assertTrue(SaveAndScheduleObject.verifySavedReportDeletion(firstReportName),
				"[Assertion Fail]: The report has not been deleted successfully");
		TestNGLogUtility.pass("[Assertion Pass]: The report has been deleted successfully");
	}

	@Then("Verify that Edit pop-up opens up")
	public void testEditPopUpVisibility() {
		Assert.assertTrue(SaveAndScheduleObject.verifyEditPopUp(), "[Assertion Fail]: Edit pop-up does Not opens up");
		TestNGLogUtility.pass("[Assertion Pass]: Edit pop-up opened");
	}

	@Then("Verify that user is able to Edit any saved report")
	public void testFuctionalityOfEditingTheReportIsWorkingSuccessfully() {
		Assert.assertTrue(SaveAndScheduleObject.verifyReportIsEdited(),
				"[Assertion Fail]: User is not able to edit a saved report");
		TestNGLogUtility.pass("[Assertion Pass]: User is able to edit a saved report");
	}

	@When("User selects email \"(.*)\" from the available list of RMS users")
	public void selectParticularUserForSharingReport(String mailIdOfUserToBeSelected) {
		SaveAndScheduleObject.selectParticularUserForSharingReport(mailIdOfUserToBeSelected);
	}

	@When("User clears the \"(.*)\" applied filter")
	public void ClearAppliedFilterInSavedReport(String filterToBeRemoved) {
		SaveAndScheduleObject.ClearAppliedFilter(filterToBeRemoved);
	}

	@When("User clicks on Save option for saving the new filters in the saved report")
	public void clickOnSaveFilterOptionInSavedReport() {
		SaveAndScheduleObject.clickOnSaveFilterOptionInSavedReport();
	}

	@Then("User verifies that no save option is visible to the person who has not created the report")
	public void testSaveOptionVisibilityForSharedReportForUserWhoHasNotCreatedThisReport() {
		Assert.assertTrue(SaveAndScheduleObject.verifySaveOptionVisibilityForSharedReport(),
				"[Assertion Fail]: Save Button for saving the filters is visible to user who has not saved the report");
		TestNGLogUtility.pass(
				"[Assertion Pass]: Save Button for saving the filters is not visible to user who has not saved the report, as expected");
	}
}
