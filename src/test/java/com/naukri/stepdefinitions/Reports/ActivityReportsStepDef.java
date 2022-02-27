package com.naukri.stepdefinitions.Reports;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.ActivityReportsPageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActivityReportsStepDef {

	String firstApplicationName = "", getValueOfAppliedFilter = "";

	ActivityReportsPageObject ActivityReportsObject = new ActivityReportsPageObject();

	@When("User clicks on first candidate and return the candidate name")
	public void clickOnFirstApplicationInTheDetailedReport() {
		firstApplicationName = ActivityReportsObject.clickOnFirstApplicationInTheDetailedReport();
	}

	@Then("User verifies that clicking on candidate Name opens the CV Detail page of that candidate")
	public void verifyTheNameOfApplicationClickedFromReport() {
		Assert.assertTrue(ActivityReportsObject.verifyTheNameOfApplicationClickedFromReport(firstApplicationName),
				"[Assertion Pass]: Clicking on a candidate's name opens the detail page of that application");
		TestNGLogUtility.pass(
				"[Assertion Fail]: Clicking on a candidate's name doesn't opens the detail page of that application");
	}

	@When("User clicks on the first \"(.*)\" name")
	public void clickOnTheFirstValueOfRequiredColumn(String columnToApplyFilterOn) {
		getValueOfAppliedFilter = ActivityReportsObject.clickOnTheFirstValueOfRequiredColumn(columnToApplyFilterOn);
	}

	@Then("User verifies that the above clicked value is visible as the applied tag")
	public void verifyTagVisibilityInCandidateActivityReport() {
		Assert.assertTrue(ActivityReportsObject.verifyTagVisibilityInCandidateActivityReport(getValueOfAppliedFilter),
				"[Assertion Pass]: Clicking on a value in the table, applies the filter of the same");
		TestNGLogUtility
				.pass("[Assertion Fail]: Clicking on a value in the table, does not applies the filter of the same");
	}

	@Then("User verifies that no other \"(.*)\" is visible")
	public void verifyAllValuesOfRequiredColumn(String columnToApplyFilterOn) {
		Assert.assertTrue(
				ActivityReportsObject.verifyAllValuesOfRequiredColumn(columnToApplyFilterOn, getValueOfAppliedFilter),
				"[Assertion Pass]: No other values are visible in the required column when a particular filter is applied");
		TestNGLogUtility.pass(
				"[Assertion Fail]: Other values are visible in the required column when a particular filter is applied");
	}

}
