package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.UploadMultipleCVPagePO;
import com.naukri.pageobjects.Requirements.RequirementListingPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadMultipleCVStepDef {
	
	UploadMultipleCVPagePO uploadMultipleCVPagePO = (UploadMultipleCVPagePO) PageObjectWrapper.getObject(UploadMultipleCVPagePO.class);
	RequirementListingPagePO requirementListingPagePO = (RequirementListingPagePO) PageObjectWrapper.getObject(RequirementListingPagePO.class);

	@Then("I should be able to see {string} as the page heading for the multiple CV upload")
	public void i_should_be_able_to_see_as_the_page_heading_for_the_multiple_CV_upload(String headingText) {
		Assert.assertTrue(uploadMultipleCVPagePO.checkThePresenceOfMultipleUploadPageHeading(headingText),
				"The heading text of the multiple upload page is not as expected");
		TestNGLogUtility.pass("The heading text of the multiple upload page is as expected");
	}

	@When("I select the CV in {string} extension for bulk upload")
	public void i_select_the_CV_in_extension_for_bulk_upload(String resumeFileExtension) {
		uploadMultipleCVPagePO.selectTheCVToUpload(resumeFileExtension);
	}

	@When("I click on {string} for creating new requirement to map the uploaded CV")
	public void i_click_on_for_creating_new_requirement_to_map_the_uploaded_CV(String requirementMappingMethod) {
		uploadMultipleCVPagePO.mapCVToRequirement(requirementMappingMethod);
	}

	@When("I fill in the requirement title with {string}")
	public void i_fill_in_the_requirement_title_with(String requirementTitle) {
		uploadMultipleCVPagePO.fillInTheRequirementTitle(requirementTitle);
	}

	@When("I click on Upload Files on the multiple upload CV page")
	public void i_click_on_Upload_Files_on_the_multiple_upload_CV_page() {
		uploadMultipleCVPagePO.clickOnUploadFileButton();
	}
	
	@Then("I should be able to see the success message of multiple uploaded CV as {string}")
	public void i_should_be_able_to_see_the_success_message_of_multiple_uploaded_CV_as(String actualSuccessMessage) {
		Assert.assertTrue(uploadMultipleCVPagePO.checkThePresenceOfSuccessUploadMessage(actualSuccessMessage), 
				"The success message of the page is either not visible or not showing the correct message");
		TestNGLogUtility.pass("The success message of the page is visible and showing the correct message");
	}

	@When("I click on {string} for the CVs uploaded")
	public void i_click_on_for_the_CVs_uploaded(String string) {
		uploadMultipleCVPagePO.clickOnViewUploadLogsButton();
	}

	@Then("I must be able to see {string} under the {string}")
	public void i_must_be_able_to_see_under_the(String countOfApplications, String columnOfLogs) {
		Assert.assertTrue(uploadMultipleCVPagePO.checkThePresenceOfCorrectCountForCorrectColumn(countOfApplications, columnOfLogs), 
				"Count " + countOfApplications + " under column " + columnOfLogs + " is not correct");
		TestNGLogUtility.pass("Count " + countOfApplications + " under column " + columnOfLogs + " is correct");
	}

	@Then("I should be able to see the requirement created during multiple upload")
	public void i_should_be_able_to_see_the_requirement_created_during_multiple_upload() {
		Assert.assertTrue(requirementListingPagePO.checkForPresenceOfMultipleUploadRequirementCreated(), 
				"The requirement created during the multiple upload is not visible");
		TestNGLogUtility.pass("The requirement created during the multiple upload is visible");
	}
}
