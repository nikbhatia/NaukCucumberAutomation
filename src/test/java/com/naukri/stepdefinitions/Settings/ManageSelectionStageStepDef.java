package com.naukri.stepdefinitions.Settings;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.CustomizeSelectionStagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Customize Selection Stage Step Definitions
 * @author rachit.mehrotra
 *
 */
public class ManageSelectionStageStepDef {
	
	CustomizeSelectionStagePO customizeSelectionStage = (CustomizeSelectionStagePO) PageObjectWrapper.getObject(CustomizeSelectionStagePO.class);

	@Then("User should be redirected to {string} page")
	public void user_should_be_redirected_to_page(String expectedText) {
	   Assert.assertTrue(customizeSelectionStage.verifyThePresenceOfSelectionStageText(expectedText), 
			   expectedText + " is not visible");
	   TestNGLogUtility.pass(expectedText + " is not visible");
	}

	@When("User records the selection stages of the system")
	public void user_records_the_selection_stages_of_the_system() {
		customizeSelectionStage.prepareSelectionStageMap();
	}
	
}
