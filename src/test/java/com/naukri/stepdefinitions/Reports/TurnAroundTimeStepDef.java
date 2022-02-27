package com.naukri.stepdefinitions.Reports;

import java.util.ArrayList;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.TurnAroundTimePageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TurnAroundTimeStepDef {

	ArrayList<String> stagesListFromSettings = new ArrayList<String>();
	ArrayList<String> stagesListFromReports = new ArrayList<String>();

	TurnAroundTimePageObject TurnAroundTimeObject = new TurnAroundTimePageObject();

	@When("User gets all the selection stages present in RMS from settings page")
	public void getSelectionStagesFromRMSSettings() {
		stagesListFromSettings = TurnAroundTimeObject.getSelectionStagesFromRMSSettings();
	}

	@When("User gets the list of all the selections available in reports")
	public void getAllSelectionInStageLevelTATReport() {
		stagesListFromReports = TurnAroundTimeObject.getAllSelectionInStageLevelTATReport();
	}

	@Then("User verifies that all the parent stages are visible in the reports")
	public void verifyStageListForStageLevelTATReport() {
		Assert.assertEquals(stagesListFromSettings, stagesListFromReports,
				"[Assertion Fail]:  The stages list present in reports does not matches the list from RMS Settings page");
		TestNGLogUtility
				.pass("[Assertion Pass]: The stages list present in reports matches the list from RMS Settings page");
	}
}
