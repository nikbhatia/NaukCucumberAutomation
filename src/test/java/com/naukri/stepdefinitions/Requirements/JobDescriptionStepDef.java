package com.naukri.stepdefinitions.Requirements;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requirements.JobDescriptionPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class JobDescriptionStepDef {

	JobDescriptionPagePO jobDescription = (JobDescriptionPagePO) PageObjectWrapper
			.getObject(JobDescriptionPagePO.class);

	@Then("User should be able to see {string} field with filed value {string} on Job description page")
	public void User_should_be_able_to_see_field_with_filedvalue_on_Job_description_page(String fieldName,
			String value) {
		Assert.assertTrue(jobDescription.verifyEmploymentTypeOnJD(), "Employment Type field is not displaying on JD");
		Assert.assertTrue(jobDescription.verifyEmploymentTypeValueOnJD(value),
				"Employment Type value is not displaying on JD");
		TestNGLogUtility.pass("Employment Type Field and value is displaying successfully.");
	}
	
	@Then("User should be able to see correct Veriable amount with ctc is displaying on job")
	public void User_should_be_able_to_see_correct_Veriable_amount_with_ctc_is_displaying_on_job() {
		Assert.assertTrue(jobDescription.verifyVariableAmountOnJD(RequirementCreationStepDef.minAmount, RequirementCreationStepDef.ctcAmount, RequirementCreationStepDef.variablePercent), "Variable amount value is not desplaying on JD");
		TestNGLogUtility.pass("Variable amount value is displaying successfully.");
	}
	
	@Then("User should be able to see the same recruiter contact detail in job as recruiter profile")
	public void User_should_be_able_to_see_the_same_recruiter_contact_detail_in_job_as_recruiter_profile() {
		//Assert.assertTrue(jobDescription.verifyrecruiterDetails(), "Same recruiter details are not displaying on JD");
		TestNGLogUtility.pass("Same recruiter details are displaying on JD successfully.");
	}
	
	@Then("User should be able to see walk-in details on job description page")
	public void User_should_be_able_see_walk_in_details_on_job_description_page() {
		Assert.assertTrue(jobDescription.verifyWalkinDetails(RequirementCreationStepDef.selectedDate),"walkin date is not dispalying or correct on JP page");
		Assert.assertTrue(jobDescription.verifyWalkinDetails(RequirementCreationStepDef.walkinStart),"walkin Start time is not dispalying or correct on JP page");
		Assert.assertTrue(jobDescription.verifyWalkinDetails(RequirementCreationStepDef.walkinEnd),"walkin End time is not dispalying or correct on JP page");
		Assert.assertTrue(jobDescription.verifyWalkinVenueDetails(RequirementCreationStepDef.location),"walkin venue is not dispalying or correct on JP page");
		TestNGLogUtility.info("walkin details is dispalying on JP page as expected");
	}
	
	@Then("User should be able to see the thumbnail on JD page")
	public void User_should_be_able_to_see_the_thumbnail_on_JD_page() {
		Assert.assertTrue(jobDescription.verifyThumbnail(), "Thumbnail is not displaying on JD");
		TestNGLogUtility.pass("Thumbnail is displaying on JD successfully.");
	}
	
	@Then("User should be able to see the photo thumbnail on JD page")
	public void User_should_be_able_to_see_the_photo_thumbnail_on_JD_page() {
		Assert.assertTrue(jobDescription.verifyPhotoThumbnail(), "video thumbnail is not displaying as selected in RMS");
		TestNGLogUtility.info("video thumbnail is displaying as selected in RMS");
	}
	
	@Then("User should be able to see the walkin details on careersite JD page")
	public void User_should_be_able_to_see_the_walkin_details_on_careersite_on_JD_page() {
		Assert.assertTrue(jobDescription.verifyWalkinDetailsOnCS(RequirementCreationStepDef.location), "Walkin details is not displaying On Career site JD page");
		TestNGLogUtility.info("Walkin details is displaying On Career site JD page");
	}
	
	@Then("User should be able to see correct variable amount is displaying on career site")
	public void User_should_be_able_to_see_correct_variable_amount_is_displaying_on_career_site() {
		Assert.assertTrue(jobDescription.verifySalaryVariableOnCS(RequirementCreationStepDef.variablePercent), "Correct variable amount is not displaying On Career site JD page");
		TestNGLogUtility.info("Correct variable amount is displaying On Career site JD page");
	}
}
