package com.naukri.stepdefinitions.Reports;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.ConversionFunnelReportsPageObject;
import com.naukri.pageobjects.Reports.DashboardPageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ConversionFunnelReportsStepDef {

	// GenericFunctions csmGeneric = new GenericFunctions();
	ConversionFunnelReportsPageObject ConversionFunnelObject = new ConversionFunnelReportsPageObject();
	public String toolTipTextForRespectiveColumnName = "", reportName = "", firstRequirementname = "";
	DashboardPageObject dashboardPO = new DashboardPageObject();

	@When("User hovers on \"(.*)\" column name in detailed Report")
	public void hoverOnRequiredColumnNameInDetailedReport(String columnName) {
		toolTipTextForRespectiveColumnName = ConversionFunnelObject
				.hoverOnRequiredColumnNameInDetailedReport(columnName);
	}

	@Then("Verify the \"(.*)\" in \"(.*)\" Report in detailed View")
	public void verifyToolTipForColumnNameInRequiredDetailedReport(String expectedToolTipText, String reportName) {
		Assert.assertTrue(
				ConversionFunnelObject.verifyToolTipForRequiredColumnNameInDetailedReport(expectedToolTipText,
						reportName, toolTipTextForRespectiveColumnName),
				"[Assertion Fail]: Required tool tips are not visible ");
		TestNGLogUtility.pass("[Assertion Pass]: Required Tool Tips are visible ");
	}

	@When("User clicks on first requirement and return the requirement name")
	public void clickOnFirstRequirementInTheDetailedReport() {
		firstRequirementname = ConversionFunnelObject.clickOnFirstRequirementAndReturnTheNameClicked();
	}

	@Then("User verifies that clicking on Requirement Name opens the overview page of that requirement")
	public void verifyRequirementClickAction() {
		Assert.assertTrue(ConversionFunnelObject.verifyTheNameOfRequirementClickedFromReport(firstRequirementname),
				"[Assertion Fail]: Clicking on a requirement doesn't opens the overview page of that requirement");
		TestNGLogUtility
				.pass("[Assertion Pass]: Clicking on a requirement opens the overview page of that requirement");
	}

	@When("User clicks on Download on detailed Report")
	public void clickOnDownloadinDetailedReport() {
		ConversionFunnelObject.clickOnDownloadOnDetailedReport();
	}

	@When("User clicks on \"(.*)\" Filter option")
	public void clickOnFilterName(String filterName) {
		ConversionFunnelObject.clickOnRequiredFilterName(filterName);
	}

	@When("User selects \"(.*)\" filter label")
	public void selectFilterLabels(String labelName) {
		ConversionFunnelObject.selectRequiredFilterLabels(labelName);
	}

	@When("User clicks on Refine Filters")
	public void clickOnRefineFilterButton() {
		ConversionFunnelObject.clickOnRefineFilter();
	}

	@When("User clicks on \"(.*)\" subTab in detailed report")
	public void clickOnRequiredSubTabInDetailedView(String tabName) {
		ConversionFunnelObject.goToRequiredSubTab(tabName);
	}

	@Then("User verifies that the requirement shown after applying above filter have \"(.*)\" status")
	public void verifyRequirementStatusFilter(String statusToBeTested) {
		Assert.assertTrue(ConversionFunnelObject.verifyRequirementStatusFunction(statusToBeTested),
				"[Assertion Fail]: Requirements shown under applied filter are not as per the filter");
		TestNGLogUtility.pass("[Assertion Pass]: Status of requirement is as per the filters applied");
	}

	@Then("Verify that more than six stages cannot be selected")
	public void verifyMaxSelectableStages() {
		Assert.assertTrue(ConversionFunnelObject.verifyMaximumSelectableStagesInCustomReport(),
				"[Assertion Fail]: More than 6 stages can be selected");
		TestNGLogUtility.pass("[Assertion Pass]: More than 6 stages cannot be selected as per the requirement");
	}

	// @When("User selects (.*) setting")
	// public void clickOnTheRepsectiveStageSettingInDetailedReport(String
	// selectedStageSetting){
	// ConversionFunnelObject.clickOnRequiredStageSettingFromDetailedReport(selectedStageSetting);
	// }
	//
	// @Then("User verifies that overAllCountInSummaryWidget for all columns is the
	// summation of all fields")
	// public void verifyValuesForSummaryCounts(){
	// Assert.assertTrue(ConversionFunnelObject.verifySummaryCount(), "[Assertion
	// Fail]: The count in summary wodget is not the overall summation count ");
	// TestNGLogUtility.pass("[Assertion Pass]: The count in summary widget is the
	// summation for all values");
	// }
}
