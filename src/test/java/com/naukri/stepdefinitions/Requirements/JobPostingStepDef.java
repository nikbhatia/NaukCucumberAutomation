package com.naukri.stepdefinitions.Requirements;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requirements.JobPostingPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class JobPostingStepDef {
	static String jobHeadingFinal = "", requirementName = "", email = "";

	JobPostingPagePO jobPosting = (JobPostingPagePO) PageObjectWrapper.getObject(JobPostingPagePO.class);
	SoftAssert softAssert = new SoftAssert();

	
	@When("User click on the next button of the job edit page")
	public void i_click_on_the_next_button_of_the_job_edit_page() {
		jobPosting.clickOnNextButtonForEditJob();
	}

	@When("User fill Job Posting heading as {string}")
	public void user_fill_Job_Posting_heading_as(String jobHeading) {
		jobHeadingFinal = jobHeading + GenericFunctions.generateRandomStrings(6, "String");
		jobPosting.filljobPostingHeading(jobHeadingFinal);
	}

	@When("User fill Employment Type as {string}")
	public void user_fill_Employment_Type_as(String employementType) {
		jobPosting.selectEmployementType(employementType);
	}

	@When("User fill Job Description {string} as {string}")
	public void user_fill_Job_Description_as(String field, String jd) {
		jobPosting.filljobDescription(field, jd);

	}

	@When("User fill Key skills as {string}")
	public void user_fill_Key_skills_as(String keySkill) {
		jobPosting.fillKeywordOnJp(keySkill);
	}

	@When("User select key skills {string} as must have key skill")
	public void user_select_key_skills_as_must_have_key_skill(String keyskill) {
		jobPosting.makeKeyskillMustHave(keyskill);
	}

	@When("User fill work experience {string} as {string}")
	public void user_fill_work_experience_min_as(String fieldName, String value) {
		jobPosting.selectFieldValue(fieldName, value);
	}

	@When("User fill Annual Salary  {string} as {string}")
	public void user_fill_Annual_Salary_as(String fieldName, String value) {
		if (fieldName.contains("Min"))
			RequirementCreationStepDef.minAmount = value;
		RequirementCreationStepDef.ctcAmount = value;
		jobPosting.selectFieldValue(fieldName, value);
	}

	@When("User fill variable as {string} percent")
	public void user_fill_variable_as_percent(String value) {
		RequirementCreationStepDef.variablePercent = value;
		jobPosting.fillVariable(value);
	}


	@When("User fill {string} as {string}")
	public void user_fill_as(String fieldName, String value) {
		jobPosting.selectFieldValue(fieldName, value);
	}

	@When("User fill Reference code as {string}")
	public void user_fill_Reference_code_as(String refCode) {
		jobPosting.fillrefcode(refCode);
	}

	@When("User fill Number of vacancy as {string}")
	public void user_fill_Number_of_vacancy_as(String vacancy) {
		jobPosting.fillVacancyField(vacancy);
	}

	@When("User fill {string} Qualification in {string} as {string}")
	public void user_fill_Qualification_in_as(String fieldName, String degree, String subject) {
		jobPosting.selectEducation(fieldName, degree, subject);
	}

	@When("User select walk-in details")
	public void user_select_walk_in_details() {
		jobPosting.selectWalkin("2");

	}

	@When("User fill requirement name")
	public void user_fill_requirement_name() {
		requirementName = jobPosting.fillRequireemntName();
	}

	@When("User select job refresh schedule as {string} after {string} days")
	public void user_select_job_refresh_schedule_as_after_days(String refreshType, String days) {
		jobPosting.selectRefreshschedule(refreshType, days);
	}

	@When("User select Receive matching applies on email checkbox and fill the email ID")
	public void user_select_Receive_matching_applies_on_email_checkbox_and_fill_the_email_ID() {
		email = "mail_" + GenericFunctions.generateRandomStrings(6, "Alphanumeric") + "@yopmail.com";
		jobPosting.enterAmrMail(email);
	}

	@When("User click on {string} button and post the job")
	public void user_click_on_button_and_post_the_job(String string) {
		jobPosting.clickOnPreviewAndPostButton();
	}

	@Then("User should be able to see employement type as {string} on JP page")
	public void User_should_be_able_to_see_employement_type_as_on_JP_page(String employmentType) {
		Assert.assertTrue(jobPosting.verifyEmploymentType(employmentType),
				"Employment Type is not same as filled at RMS end");
		TestNGLogUtility.info("Employment Type is same as filled at RMS end");
	}

	@Then("User should be able to see correct variable on JP page")
	public void User_should_be_to_see_correct_variable_on_JP_page() {
		Assert.assertTrue(jobPosting.verifyVeriable(Integer.valueOf(RequirementCreationStepDef.variablePercent)),
				"Same values is not displaying as filled");
		TestNGLogUtility.info("Same values is displaying as filled");
	}

	@Then("User should be able to see correct keyskills on JP")
	public void User_should_be_able_see_correct_keyskills_on_JP(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			Assert.assertTrue(jobPosting.verifyKeyskills(skill), "Same Keyskill values are not displaying as filled");
		TestNGLogUtility.info("Same Keyskill values are displaying as filled");
	}

	@Then("User should be able to see correct must have keyskills on JP")
	public void User_should_be_able_see_correct_must_have_keyskills_on_JP(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			Assert.assertTrue(jobPosting.verifyKeyskillsMustHave(skill),
					"Same mush have keyskill values are not displaying as filled");
		TestNGLogUtility.info("Same must have keyskill values are displaying as filled");
	}

	@Then("User should be able to see all walk-in details on JP form")
	public void User_should_be_able_to_see_all_walkin_details_on_JP_form() {
		Assert.assertTrue(jobPosting.verifyWalkinStartDate(RequirementCreationStepDef.selectedDate),
				"Correct walkin start date is not displaying as filled");
		Assert.assertTrue(jobPosting.verifyWalkinDuration(RequirementCreationStepDef.durationDays),
				"Correct walkin duration are not displaying as filled");
		Assert.assertTrue(jobPosting.verifyWalkinTiming(RequirementCreationStepDef.walkinStart),
				"Correct walkin start timing are not displaying as filled");
		Assert.assertTrue(jobPosting.verifyWalkinTiming(RequirementCreationStepDef.walkinEnd),
				"Correct walkin end timing are not displaying as filled");
		TestNGLogUtility.info("Same must have keyskill values are displaying as filled");
	}

	@When("User click on company details edit button")
	public void User_click_on_company_details_edit_button() {
		jobPosting.clickOnCompanyDetailsEditBtn();

	}

	@Then("User should be able to see video thumbnail on the job")
	public void User_should_be_able_to_see_video_thumbnail_on_the_job() {
		Assert.assertTrue(jobPosting.verifyVideoThumbnail(), "video thumbnail is not displaying as selected in RMS");
		TestNGLogUtility.info("video thumbnail is displaying as selected in RMS");
	}

	@Then("User should be able to see photo thumbnail on the job")
	public void User_should_be_able_to_see_photo_thumbnail_on_the_job() {
		Assert.assertTrue(jobPosting.verifyPhotoThumbnail(), "video thumbnail is not displaying as selected in RMS");
		TestNGLogUtility.info("video thumbnail is displaying as selected in RMS");
	}
	
	@Then("User should be able to see {string} in Job description section on JP form")
	public void User_should_be_able_to_see_in_Job_description_section_on_JP_form(String field) {
		String value="";
		if(field.contains("Roles"))
			value=RequirementCreationStepDef.jobDescription;
		else if(field.contains("Desired"))
			value=RequirementCreationStepDef.candidateDetails;
		else if(field.contains("Perks"))
			value=RequirementCreationStepDef.otherSalary;
		Assert.assertTrue(jobPosting.verifyjobDescriptionValues(field,value), field+" value is not displaying correct on JP form in JD section.");
		TestNGLogUtility.info(field+" value is not displaying correct on JP form in JD section.");
	}
	
	@When("User fill Job Description {string} as {string} for CL job")
	public void user_fill_Job_Description_as_for_CL_job(String field, String jd) {
		jobPosting.fillClassifiedJD(field, jd);
	}
	
	@Then("User should be able to see {string} value on jp form")
	public void User_should_be_able_to_see_in_value_on_JP_form(String field) {
		String value="";
		if(field.contains("Job"))
			value=RequirementCreationStepDef.jobDescription;
		else if(field.contains("Candidate"))
			value=RequirementCreationStepDef.candidateDetails;
		Assert.assertTrue(jobPosting.verifyClassifiedJD(field,value), field+" value is not displaying correct on JP form in JD section.");
		TestNGLogUtility.info(field+" value is not displaying correct on JP form in JD section.");
	}
	
	@Then("User should not be able to see {string} in Job description section on JP form")
	public void User_should_not_be_able_to_see_in_Job_description_section_on_JP_form(String field) {
		String value="";
		if(field.contains("Roles"))
			value=RequirementCreationStepDef.jobDescription;
		else if(field.contains("Desired"))
			value=RequirementCreationStepDef.candidateDetails;
		else if(field.contains("Perks"))
			value=RequirementCreationStepDef.otherSalary;
		Assert.assertFalse(jobPosting.verifyjobDescriptionValues(field,value), field+" value is not displaying correct on JP form in JD section.");
		TestNGLogUtility.info(field+" value is not displaying correct on JP form in JD section.");
	}
	
	@When("User clear Job Description {string} field")
	public void user_clear_Job_Description_field(String field) {
		jobPosting.removeJobDescription(field);
	}
	
	@Then("User should be able to see education specialization text as {string} on JP form")
	public void User_should_be_able_to_see_education_specialization_text_on_JP_form(String text) {
		Assert.assertTrue(jobPosting.verifyEducationSpecialization(text), "Education Specialization is not displaying as selcted in RMS");
		TestNGLogUtility.info("Education Specialization is displaying as selcted in RMS");
	}
	
	@When("User fill company details as {string}")
	public void user_fill_company_details_as(String details) {
		jobPosting.fillCompanyDetails(details);
	}
	
	@Then("User should not be able to see {string} value {string} in Job description section on JP form")
	public void User_should_not_be_able_to_see_value_in_Job_description_section_on_JP_form(String field, String value) {
		Assert.assertFalse(jobPosting.verifyjobDescriptionValues(field,value), field+" value is not displaying correct on JP form in JD section.");
		TestNGLogUtility.info(field+" value is not displaying correct on JP form in JD section.");
	}
}
