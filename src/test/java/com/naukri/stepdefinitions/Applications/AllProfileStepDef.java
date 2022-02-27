package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AllProfilePagePO;
import com.naukri.stepdefinitions.Requirements.RequirementCreationStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllProfileStepDef {
	RequirementCreationStepDef requirementCreation = (RequirementCreationStepDef) PageObjectWrapper.getObject(RequirementCreationStepDef.class);
	GenericFunctions genericFunction= (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	AddASingleProfileStepDef addASingleProfile = (AddASingleProfileStepDef) PageObjectWrapper.getObject(AddASingleProfileStepDef.class);
	AllProfilePagePO allProfilePO = (AllProfilePagePO) PageObjectWrapper.getObject(AllProfilePagePO.class);
	
	@When("User {string} recently created candiate in recent created requirement")
	public void user_recently_created_candiate_in_recent_created_requirement(String btnName) {
		genericFunction.chooseRequirementFromList(requirementCreation.requirementName,btnName);
	}
	
	@When("User click on {string} button on inbox page")
	public void user_click_on_button_on_inbox_page(String btnName) {
		allProfilePO.clickOnFirstCandidateCheckbox();
		genericFunction.clickOnActionButtonOnInboxPage(btnName);
	}
	
	@Then("user should be able to see the added candidate on {string} page")
	public void user_should_be_able_to_see_the_added_candidate_on_page(String PageName) {
		Assert.assertTrue(genericFunction.waitTillDesiredCandidateTupleIsPresent(addASingleProfile.candidateEmail),"Added candidaye is not being displyed on All application page.");
		TestNGLogUtility.pass("Added candidate is displayed as expected on "+ PageName +" page");
	}
	
	@Then("verify that user should be able to see the block message")
	public void verify_that_user_should_be_able_to_see_the_block_message() {
		Assert.assertTrue(genericFunction.verifyBlockProfilepopUp(),"Block profile pop-up is not displayed as expected");
		TestNGLogUtility.pass("Block profile pop-up is displayed as expected");
	}
	
	@Then("verify that user should be able to add candidate")
	public void verify_that_user_should_be_able_to_add_candidate() {
		Assert.assertTrue(genericFunction.verifyAddedProfilepopUp(),"Added profile profile pop-up is not displayed as expected");
		TestNGLogUtility.pass("Added profile pop-up is displayed as expected");
	}
}
