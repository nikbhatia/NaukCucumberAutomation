package com.naukri.stepdefinitions.Reports;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.RequirementReportPageObject;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RequirementReportStepDef {

	RequirementReportPageObject RequirementReportObject = new RequirementReportPageObject();

	@Then("Verify that time duration dropDown is not visible in this report")
	public void verifyTimeDurationNonVisibility() {
		Assert.assertTrue(RequirementReportObject.verifyTimeDurationNonVisibility(),
				"[Assertion Fail]: Duration DropDown is visibe when it should not be visible");
		TestNGLogUtility.pass("[Assertion Pass]: Duration DropDown not visible as per the requirement ");
	}

	@Then("User verifies the time duration options in the summary widget of Requirement Aging Report")
	public void verifySummaryElementInRequirementAging(DataTable summaryElementsForRequirementAging) {
		List<String> expectedSummaryElementsInRequirementAgingReport = summaryElementsForRequirementAging
				.asList(String.class);
		List<String> visibleRequirementAgingSummaryElements = RequirementReportObject
				.verifySummaryElementsForRequirementAgingReport();
		Assert.assertEquals(expectedSummaryElementsInRequirementAgingReport, visibleRequirementAgingSummaryElements,
				"[Assertion Fail]:  Summary elements are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Summary elements are as per the requiremnt");
	}

	@Then("Verify the elements in the column names of Requirement Report")
	public void verifyColumnNamesForRequirementReports(DataTable columnNamesForRequirementReports) {
		List<String> expectedColumnNames = columnNamesForRequirementReports.asList(String.class);
		List<String> visibleColumnNames = RequirementReportObject.verifyColumnNamesForRequirementReports();
		Assert.assertEquals(expectedColumnNames, visibleColumnNames,
				"[Assertion Fail]:  Column Names are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Column Names are as per the requiremnt");
	}

	@Then("Verify the Drop Down options available in Graphical view of Requirement Creation Report")
	public void verifyGraphicalDropDownOptions(DataTable graphicalDropDownOptions) {
		List<String> expectedGraphicalDropDownOptions = graphicalDropDownOptions.asList(String.class);
		List<String> visibleGraphicalDropDownOptions = RequirementReportObject.verifyGraphicalDropDownOptions();
		Assert.assertEquals(expectedGraphicalDropDownOptions, visibleGraphicalDropDownOptions,
				"[Assertion Fail]: The drop down options are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: The drop down options are as per the requirement");
	}

	@When("User clicks on the Drop Down option available at the top left of the graph")
	public void clickOngraphicalDropDown() {
		RequirementReportObject.clickOngraphicalDropDown();
	}

	@When("User clicks on Clear All option to clear all the filters")
	public void clickOnClearAll() {
		RequirementReportObject.clickOnClearAll();
	}

}
