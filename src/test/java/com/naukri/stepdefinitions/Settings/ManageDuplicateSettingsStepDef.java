package com.naukri.stepdefinitions.Settings;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.AddDuplicateSettingPO;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageDuplicateSettingsStepDef {
	AddDuplicateSettingPO addDuplicateSettingPO = new AddDuplicateSettingPO();
	
	@Then("verify user should land on {string} page successfully")
	public void verify_user_should_land_on_page_successfully(String pageName) {
	    Assert.assertTrue(addDuplicateSettingPO.verifyDuplicateSettingsPage(pageName), "User is not redirect on Duplicate Settings page successfully.");
	    TestNGLogUtility.pass(pageName + " page is displayed as expected");
	   
	}

	@When("User click on {string} button on duplicate settings page")
	public void user_click_on_button_on_duplicate_settings_page(String btnName) {
	    addDuplicateSettingPO.clickOnAddNewDuplicateSettingButton(btnName);	   
	}

	@When("User choose source as {string} from list on duplicate setting page")
	public void user_choose_source_as_from_list_on_duplicate_setting_page(String SourceType) {
	    addDuplicateSettingPO.clickOnSourceType(SourceType);
	}

	@When("User click on {string} Employer\\/Group radio button.")
	public void user_click_on_Employer_Group_radio_button(String optionName) {
		addDuplicateSettingPO.clickOnSourceType(optionName);
	}

	@When("User select {string} option from list on duplicate setting page")
	public void user_select_option_from_list_on_duplicate_setting_page(String option) {
		addDuplicateSettingPO.selectOptionFromDropdown(option);
	}

	@When("User click on {string} button on duplicate settings page for saving settings")
	public void User_click_on_button_on_duplicate_settings_page_for_saving_settings(String btnName) {
		addDuplicateSettingPO.clickOnButtonWithText(btnName);
	}
	
	@Then("created candidate should be displayed on the {string}")
	public void created_candidate_should_be_displayed_on_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
}
