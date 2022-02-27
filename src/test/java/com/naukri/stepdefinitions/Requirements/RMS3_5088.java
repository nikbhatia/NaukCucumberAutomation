package com.naukri.stepdefinitions.Requirements;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RMS3_5088 {

	RequirementCreationPagePO requirementCreation = (RequirementCreationPagePO) PageObjectWrapper
			.getObject(RequirementCreationPagePO.class);

	@Then("User should be able to see {string} filed on the add requirement form")
	public void user_should_be_able_to_see_filed_on_the_add_requirement_form(String fieldName) {
		Assert.assertTrue(requirementCreation.presenceOfEmploymentTypeOnRequirementCreationPage(),
				"Emplyment Type Drop Down is not displaying on Requirement Creation page.");
		TestNGLogUtility.pass("Employment Type DD is displaying on Requirement creation successfully.");
	}

	@Then("User should be able to see {string} filed as Mandatory field")
	public void User_should_be_able_to_see_filed_as_Mandatory_field(String fieldName) {
		Assert.assertTrue(requirementCreation.verifyFieldIsMandatory(fieldName),
				"Emplyment Type Drop Down is not displaying as mandatory on Requirement Creation page.");
		TestNGLogUtility.pass("Employment Type DD is displaying as mandatory on Requirement creation successfully.");
	}

	@Then("User should be able to see {string} filed after Job Title/Designation field")
	public void User_should_be_able_to_see_filed_after_Job_TitleDesignation_field(String fieldName) {
		Assert.assertTrue(requirementCreation.verifyEmploymentTypeAfterJobDesignation(fieldName),
				"Emplyment Type Drop Down is not displaying after Job designation on Requirement Creation page.");
		TestNGLogUtility
				.pass("Employment Type DD is displaying after Job designation on Requirement creation successfully.");
	}

	@Then("User should be able to see all options with correct sequence")
	public void User_should_be_able_to_see_all_options_with_correct_sequence(DataTable dataTable) {
		List<String> AllSections = dataTable.asList(String.class);
		int placeNumber = 1;
		for (String section : AllSections) {
			Assert.assertTrue(requirementCreation.verifyEmploymentTypeDdValue(section, placeNumber),
					section + " is not displaed as expected in Employment Type DD");
			placeNumber++;
			TestNGLogUtility.pass(section + " is displayed as expected in Employment Type DD");
		}
	}
	
	@Then("User should be able to see {string} field with filed value {string}")
	public void User_should_be_able_to_see_filed_with_filed_value(String fieldName, String employmentType) {
		Assert.assertTrue(requirementCreation.verifyEmploymentTypeValueOnPreviewPage(employmentType),
				"Correct Emplyment Type value is not displaying on Requirement preview page.");
		TestNGLogUtility
				.pass(" Correct Employment value is displaying on Requirement preview page successfully.");
	}
	
	@When("User click on {string} field")
	public void user_clicks_on_Employment_Type_DD(String option) {
		requirementCreation.clickEmploymentTypeDD();
	}
	
	@When("User select an option {string} from list")
	public void user_select_Option_from_list(String option) {
		requirementCreation.clickEmploymentTypeOptionfromList(option);
	}
	
	@Then("User should be able to see walkin details section on preview")
	public void User_should_be_able_see_walkin_details_section(DataTable dataTable) {
		List<String> fieldNames = dataTable.asList(String.class);
		for (String fieldName : fieldNames) {
		Assert.assertTrue(requirementCreation.verifyWalkinFieldOnPreview(fieldName), "Correct " + fieldName +" is not displaying on Requirement Preview page"); 
		TestNGLogUtility.pass("Correct " + fieldName +" is displaying on Requirement Preview page");
		}
	}
	
	
	@Then("User should be able to see walkin details on preview page")
	public void User_should_be_able_to_see_walkin_on_preview_page(DataTable dataTable) {
		List<String> values = dataTable.asList(String.class);
		for (String value : values) {
		Assert.assertTrue(requirementCreation.verifyWalkinValueOnPreview(value), "Correct value " + value +" is not displaying on Requirement Preview page"); 
		TestNGLogUtility.pass("Correct value " + value +" is displaying on Requirement Preview page");
		}
	}
}
