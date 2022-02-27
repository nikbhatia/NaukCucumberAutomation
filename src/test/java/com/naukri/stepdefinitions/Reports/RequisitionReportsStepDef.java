package com.naukri.stepdefinitions.Reports;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.RequisitionReportsPageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RequisitionReportsStepDef {

	RequisitionReportsPageObject RequisitionReportsObject = new RequisitionReportsPageObject();

	@When("User clicks on the \"(.*)\" mode of the Report")
	public void clickOnTheRequiredModeInReport(String modeType) {
		RequisitionReportsObject.clickOnTheRequiredModeType(modeType);
	}

	@Then("User verifies the options available for first setting option in \"(.*)\" Report in Detailed Report")
	public void verifyOptionsForFirstSettingIconinRequisitionReports(String reportName,
			DataTable optionsListExpectedTable) {

		List<String> ExpectedCalculationOptionsList = optionsListExpectedTable.asList(String.class);
		List<String> CalculatioonOptionsSettingsListFromReports = RequisitionReportsObject
				.verifyOptionsForFirstSettingIconinDetailedReport(reportName);
		Assert.assertEquals(ExpectedCalculationOptionsList, CalculatioonOptionsSettingsListFromReports,
				"[Assertion Fail]: " + reportName + " doesn't have the required stages");
		TestNGLogUtility.pass("[Assertion Pass]: " + reportName + " has the required stages");

	}

	@Then("User verifies the options available custom stages in settings option in \"(.*)\" Report in Detailed Report")
	public void verifyCustomStagesListForRequisitionReports(String reportName, DataTable columnListExpectedTable) {
		List<String> ExpectedColumnList = columnListExpectedTable.asList(String.class);
		List<String> columnListFromReports = RequisitionReportsObject
				.verifyCustomStagesListInDetailedReportForRequisitionReports(reportName);
		Assert.assertEquals(ExpectedColumnList, columnListFromReports,
				"[Assertion Fail]: " + reportName + " doesn't have the required column list");
		TestNGLogUtility.pass("[Assertion Pass]: " + reportName + " has the required list for custom column names");
	}

	@Then("Verify that data in detailed report is visible according to the \"(.*)\" subtab")
	public void verifysubTabclickinDetailedReport(String tabName) {
		Assert.assertTrue(RequisitionReportsObject.verifysubTabclickforRequiredReportInDetailedView(tabName),
				"[Assertion Fail]:  Data is not visible according to the selected subTab");
		TestNGLogUtility.pass("[Assertion Pass]: Data is visible according to the selected subtab");
	}

	@Then("User verifies that no settings icon is visible in requisition Overview Report in Graphical Mode")
	public void verifyGraphicalModeSettingOption() {
		Assert.assertTrue(RequisitionReportsObject.verifyThatNoSettingOptionIsVisibleInGraphicalMode(),
				"[Assertion Fail]:  Settings option is visible in the graphical mode");
		TestNGLogUtility.pass("[Assertion Pass]: As expected, settings option is not visible in the graphical mode");
	}

	@Then("User verifies the summary elements of \"(.*)\" Report in detailed view")
	public void verifySummaryElementsInDetailedReport(String reportName, DataTable columnListExpectedTable) {
		List<String> expectedSummaryElements = columnListExpectedTable.asList(String.class);
		List<String> SummaryElementsFromReports = RequisitionReportsObject
				.verifySummaryElementsForSpecifiedDetailedReport(reportName);
		Assert.assertEquals(expectedSummaryElements, SummaryElementsFromReports,
				"[Assertion Fail]: " + reportName + " doesn't have the required summary elements");
		TestNGLogUtility.pass("[Assertion Pass]: " + reportName + " has the required list for summary elements");
	}

	@Then("User verifies the Division label in Requisition Overview Report in detailed view")
	public void verifyDivisionOptionInDetailedReport() {
		Assert.assertTrue(RequisitionReportsObject.verifyDivisionOptionsInDetailedReport(),
				"[Assertion Fail]:  Division Options are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Division Options are as per the requirement");
	}

	@When("User selects \"(.*)\" time duration")
	public void userSelectsRequiredTimeDuration(String selectedTimeDuration) {
		RequisitionReportsObject.selectRequiredTimeDuration(selectedTimeDuration);
	}

	@Then("User verifies that options visible in the Division Label are according to \"(.*)\" time duration")
	public void verifyOptionsForDivisionLable(String selectedTimeDuration) {
		Assert.assertTrue(
				RequisitionReportsObject
						.verifyThatDivisionOptionsAreVisibleAccordingToTheSelectedTimeDuration(selectedTimeDuration),
				"[Assertion Fail]:  The options for division are not visible according to the selected time duration");
		TestNGLogUtility
				.pass("[Assertion Pass]: The options for division are visible according to the selected time duration");
	}

}