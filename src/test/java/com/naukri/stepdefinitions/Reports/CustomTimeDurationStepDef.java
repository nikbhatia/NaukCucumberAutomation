package com.naukri.stepdefinitions.Reports;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.CustomTimeDurationPageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CustomTimeDurationStepDef {

	CustomTimeDurationPageObject CustomTimeDurationObject = new CustomTimeDurationPageObject();

	@When("User clicks on Time Duration DropDown")
	public void clickOnTimeDurationDropDown() {
		CustomTimeDurationObject.clickOnTimeDurationDropDown();
	}

	@Then("User verifies the elements of the time duration DropDown")
	public void verifyTimeDurationDropDownElements() {
		Assert.assertTrue(CustomTimeDurationObject.verifyTimeDurationDropDownElements(),
				"[Assertion Fail]: Time duration DD elements are not as per the requirement ");
		TestNGLogUtility.pass("[Assertion Pass]: Time duration DD elements are as per the requirement ");
	}

	@When("User selects \"(.*)\" from Time Duration DropDown")
	public void clickOnRequiredTimeDuration(String requiredTimeDurationOption) {
		CustomTimeDurationObject.clickOnRequiredTimeDuration(requiredTimeDurationOption);
	}

	@When("User clicks on Report Time Period Options")
	public void clickOnReportTimePeriodDropDown() {
		CustomTimeDurationObject.clickOnReportTimePeriodDropDown();
	}

	@When("User selects \"(.*)\" Report Time Period")
	public void clickOnRequiredReportTimePeriod(String requiredReportTimePeriod) {
		CustomTimeDurationObject.clickOnRequiredReportTimePeriod(requiredReportTimePeriod);
	}

	@Then("User Verifies the Frequency Options")
	public void verifyFrequencyOptions(DataTable expectedFrequencies) {
		List<String> expectedListOfFrequencies = expectedFrequencies.asList(String.class);
		List<String> visibleListOfFrequencies = CustomTimeDurationObject.verifyFrequencyOptions();
		Assert.assertEquals(expectedListOfFrequencies, visibleListOfFrequencies,
				"[Assertion Fail]: The list of frequencies is not as per the requirement ");
		TestNGLogUtility.pass("[Assertion Pass]: The list of frequencies is as per the requirement ");
	}

	@When("User selects the custom from and to Dates")
	public void selectCustomDurationDates() {
		CustomTimeDurationObject.selectCustomDurationDates();
	}

	@Then("Verify that user is able to select \"(.*)\" and text is displayed accordingly")
	public void verifySelectedTimeDurationIsVisible(String selectedTimeDuration) {
		Assert.assertTrue(CustomTimeDurationObject.verifySelectedTimeDurationIsVisible(selectedTimeDuration),
				"[Assertion Fail]: The text is not displayed according to the selected time duration option");
		TestNGLogUtility.pass("[Assertion Pass]: The text is displayed according to the selected time duration option");
	}

	@Then("Verify that data is visible according to custom time duration selected")
	public void verifySelectedCustomTimeDuration() {
		Assert.assertTrue(CustomTimeDurationObject.verifySelectedCustomTimeDuration(),
				"[Assertion Fail]: User cannot select Custom Time Duration DD or the text is not displayed accordingly");
		TestNGLogUtility
				.pass("[Assertion Pass]: User can select Custom Time Duration DD and text is displayed accordingly");
	}
}
