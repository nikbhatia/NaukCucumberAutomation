package com.naukri.stepdefinitions.Applications;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AdvanceSearchPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdvanceSearchStepDef {

	AdvanceSearchPO advSearch = (AdvanceSearchPO) PageObjectWrapper.getObject(AdvanceSearchPO.class);
	
	@When("User clicks on the advance search for {string}")
	public void user_clicks_on_the_advance_search(String advanceSearchIdentifier) {
	    advSearch.clickOnProfileAdvSearch(advanceSearchIdentifier);
	}

	@Then("User should be able to see the Profiles option on GNB as active")
	public void user_should_be_able_to_see_the_Profiles_option_on_GNB_as_active() {
	    Assert.assertTrue(advSearch.checkProfileOptionOfGNBAsActive(), "Profile Option of GNB is not active");
	    TestNGLogUtility.pass("Profile Section of GNB is active");
	}

	@Then("User should be able to see the component with heading {string}")
	public void user_should_be_able_to_see_the_component_with_heading(String advanceSearchHeading) {
	    Assert.assertTrue(advSearch.verifyThePresenceOfHeadingOnAdvanceSearchLayout(advanceSearchHeading), advanceSearchHeading+" is not displayed");
	    TestNGLogUtility.pass(advanceSearchHeading+" is displayed");
	}

	@Then("User should be able to see the component with division named as {string}")
	public void user_should_be_able_to_see_the_component_with_division_named_as(String divisionHeadingText) {
		Assert.assertTrue(advSearch.verifyThePresenceOfHeadingOnAdvanceSearchLayout(divisionHeadingText), divisionHeadingText+" is not displayed");
	    TestNGLogUtility.pass(divisionHeadingText+" is displayed");
	}

	@Then("User should be able to see the button as {string} on advance search layout")
	public void user_should_be_able_to_see_the_button_as_on_advance_search_layout(String buttonText) {
	    Assert.assertTrue(advSearch.verifyPresenceOfFindResume(buttonText), buttonText+" not visible on UI");
	    TestNGLogUtility.pass(buttonText+" visible on UI");
	}

	@Then("User should be able to see the Modified in drop down having values as")
	public void user_should_be_able_to_see_the_Modified_in_drop_down_having_values_as(io.cucumber.datatable.DataTable dataTable) {
	    Assert.assertTrue(advSearch.verifyModifiedListOfAction(dataTable.asList()), "Options expected were not found");
	    TestNGLogUtility.pass("All expected options on the UI were found in expected list");
	}
	
}
