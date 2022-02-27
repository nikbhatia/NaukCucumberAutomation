package com.naukri.stepdefinitions.Requirements;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.stepdefinitions.Applications.AddASingleProfileStepDef;
import com.naukri.stepdefinitions.HiringManager.HMRequisitionPageStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RequirementCreationStepDef {

	RequirementCreationPagePO requirementCreationPagePO = (RequirementCreationPagePO) PageObjectWrapper
			.getObject(RequirementCreationPagePO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	RequirementOverviewPagePO requirementOverviewPagePO = (RequirementOverviewPagePO) PageObjectWrapper
			.getObject(RequirementOverviewPagePO.class);

	public static String requirementName = "", questionnaireName = "", variablePercent = "", ctcAmount = "",
			jobTitle = "", minAmount = "", selectedDate = "", durationDays = "", contactNumber = "", location = "",
			walkinStart = "", walkinEnd = "", videoURL = "", jobDescription = "", otherSalary = "",
			candidateDetails = "";
	int selected = 0, deselected = 0;

	String url = "https://www.google.co.in/maps?q=28.5133043,77.3720099";

	@When("User select a {string} from {string} option")
	public void i_select_a_from_option(String subOptionOfGNB, String mainOptionOfGNB) {
		genericFunctions.selectOptionFromRMSGNB(subOptionOfGNB, mainOptionOfGNB);
	}

	@When("User fill in the requirement title")
	public void i_fill_in_the_requirement_title() {
		requirementName = requirementCreationPagePO.fillRequirementName();
		HMRequisitionPageStepDef.reqName = requirementName;
	}

	@When("User fill in the job title")
	public void i_fill_in_the_job_title() {
		jobTitle = requirementCreationPagePO.fillJobTitle();
	}

	@When("User fill in the Job Description")
	public void i_fill_in_the_Job_Description() {
		jobDescription = requirementCreationPagePO.fillInJD();
	}

	@When("User fill in the Candidate Description")
	public void i_fill_in_the_Candidate_Description() {
		candidateDetails = requirementCreationPagePO.fillCandidateDetails();
	}

	@When("User select the currency of CTC as {string}")
	public void i_select_the_currency_of_CTC_as(String currencyType) {
		requirementCreationPagePO.selectCurrencyOfSalary(currencyType);
	}

	@When("User fill in the {string} as {string}")
	public void i_fill_in_the_as(String ctcType, String ctcValue) {
		ctcAmount = requirementCreationPagePO.fillTheCTC(ctcType, ctcValue);
		if (ctcType.equals("minCTC"))
			minAmount = ctcAmount;
	}


	@When("User fill in the more salary details for {string} user")
	public void i_fill_in_the_more_salary_details_for_user(String migrationStatusOfUser) {
		otherSalary = requirementCreationPagePO.addMoreSalaryDetails(migrationStatusOfUser);
	}

	@When("User fill in the {string} as {string} years of experience")
	public void i_fill_in_the_as_years_of_experience(String expType, String expValue) {
		requirementCreationPagePO.fillTheExp(expType, expValue);
	}

	@When("User fill in the keywords as {string}")
	public void i_fill_in_the_keywords_as(String skills) {
		requirementCreationPagePO.fillTheKeywords(skills);
	}

	@When("User fill in the job location as {string}")
	public void i_fill_in_the_job_location_as(String jobLocation) {
		requirementCreationPagePO.fillInTheJobLocations(jobLocation);
	}

	@When("User click on {string} button on requirement creation")
	public void i_click_on_button_on_requirement_creation(String btnText) {
		requirementCreationPagePO.clickOperationButton(btnText);
	}

	@When("User post a {string}")
	public void user_post_a(String jobPlatformType) {
		requirementCreationPagePO.postJobToRequirement(jobPlatformType);
	}

	@When("User select {string} field as {string}, {string} as {string} and Choose Specialization as {string}")
	public void i_select_field_as_as_and_Choose_Specialization_as(String degreeStandard, String choiceOfDegreeString,
			String degreeStandardString, String degreeString, String specializationString) {
		requirementCreationPagePO.selectDegree(degreeStandard, choiceOfDegreeString, degreeStandardString, degreeString,
				specializationString);
	}

	@Then("Verify User see the {string} under the label You have selected as {string}")
	public void i_should_be_able_to_see_the_under_the_label_You_have_selected_as(String labelString,
			String degreeString) {
		Assert.assertTrue(requirementCreationPagePO.checkLabelForEducation(labelString, degreeString),
				"The label for the " + degreeString + " course is not visible");
		TestNGLogUtility.pass("The education tags are visible");
	}

	@When("User select {string}")
	public void i_select(String replacementRelation) {
		requirementCreationPagePO.clickOnCourseRelationOfCourses(replacementRelation);
	}

	@When("User chose {string}")
	public void User_chose(String ppgselector) {
		requirementCreationPagePO.selectPpgSelector(ppgselector);
	}

	@When("User chose {string} as {string}")
	public void User_chose_as(String requirementAttributeKey, String requirementAttributeValue) {
		requirementCreationPagePO.fillInRequirementDD(requirementAttributeKey, requirementAttributeValue);
	}

	@When("User check for the companyname and about company for {string} user")
	public void user_check_for_the_companyname_and_about_company_for_user(String migrationStatusOfUser) {
		requirementCreationPagePO.fillInCompanyNameAndAboutDetails(migrationStatusOfUser);
	}

	@Then("Verify User see a layer with title {string}")
	public void user_should_be_able_to_see_a_layer_with_title(String titlePlaceHolder) {
		Assert.assertTrue(requirementCreationPagePO.presenceOfQuestionnaireLightbox(titlePlaceHolder),
				"The questionnaire title is not visible");
		TestNGLogUtility.pass("The questionnaire lightbox is visible");
	}

	@When("User click on {string} on the questionnaire preview")
	public void i_click_on_on_the_questionnaire_preview(String buttonLocatorText) {
		requirementCreationPagePO.clickOnQuestionnaireAction(buttonLocatorText);
	}

	@Then("Verify User redirected to requirement overview page")
	public void i_should_be_redirected_to_requirement_overview_page() {
		Assert.assertTrue(requirementCreationPagePO.redirectionToRequirementOverviewPage(),
				"The requirement overview page is not displayed");
		TestNGLogUtility.pass("The requirement overview is visible");
	}

	@When("User click on Save and Post Requirement on requirement page")
	public void i_click_on_Save_and_Post_Requirement_on_requirement_page() {
		requirementCreationPagePO.addRequirementButtonClick();
	}

	@Then("Verify User see the {string} edit page")
	public void i_should_be_able_to_see_the_edit_page(String jobOrRequirementIdentifier) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheEditPageOfRequirementOrJob(jobOrRequirementIdentifier),
				"The " + jobOrRequirementIdentifier + " tab is not visible or active");
		TestNGLogUtility.pass("The " + jobOrRequirementIdentifier + " tab is not visible or active");
	}

	@Then("Verify User see the job description text in job description field")
	public void i_should_be_able_to_see_the_job_description_text_in_job_description_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyTheJobDescriptionText(),
				"The job description on editing the job is not correctly displayed");
		TestNGLogUtility.pass("The job description on editing the job is correctly displayed");
	}

	@Then("Verify User see the candidate profile text in candidate profile field")
	public void i_should_be_able_to_see_the_candidate_profile_text_in_candidate_profile_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyTheCandidateDetails(),
				"The candidate details on editing the job is not correctly displayed");
		TestNGLogUtility.pass("The candidate details on editing the job is correctly displayed");
	}
	
	@Then("Verify User see the error message {string} for requirement title")
	public void i_should_be_able_to_see_the_error_message_for_requirement_title(String actualErrorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheRequirementTitleError(actualErrorMessage),
				"The requirement title error message on being empty is not visible");
		TestNGLogUtility.pass("The requirement title error message on being empty is visible");
	}

	@Then("Verify User see the error message {string} for job title")
	public void i_should_be_able_to_see_the_error_message_for_job_title(String actualErrorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheJobTitleError(actualErrorMessage),
				"The job title error message on being empty is not visible");
		TestNGLogUtility.pass("The job title error message on being empty is visible");
	}

	@Then("Verify User see the error message {string} for {string} for salary")
	public void i_should_be_able_to_see_the_error_message_for_for_salary(String actualErrorMessage, String salaryType) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheSalaryErrorMessage(actualErrorMessage, salaryType),
				salaryType + " error message on being empty is not visible");
		TestNGLogUtility.pass(salaryType + " error message on being empty is visible");
	}

	@Then("Verify User see the error message {string} for {string} for experience")
	public void i_should_be_able_to_see_the_error_message_for_for_experience(String actualErrorMessage, String workExperienceType) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheWorkExperienceErrorMessage(actualErrorMessage,workExperienceType), 
				workExperienceType + " error message on being empty is not visible");
		TestNGLogUtility.pass(workExperienceType + " salary error message on being empty is visible");
	}

	@Then("Verify User see the error message {string} for keyword field")
	public void i_should_be_able_to_see_the_error_message_for_keyword_field(String actualErrorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheKeywordError(actualErrorMessage),
				"The keyword error message on being empty is not visible");
		TestNGLogUtility.pass("The keyword error message on being empty is not visible");
	}

	@Then("Verify User see the error message {string} for location field")
	public void i_should_be_able_to_see_the_error_message_for_location_field(String actualErrorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheLocationError(actualErrorMessage),
				"The location error message on being empty is not visible");
		TestNGLogUtility.pass("The location error message on being empty is not visible");
	}
	
	@When("User fill {string} in about company for {string}")
	public void i_fill_in_about_company_for(String aboutCompanyText, String migrationStatus) {
		requirementCreationPagePO.fillInAboutCompany(aboutCompanyText, migrationStatus);
	}

	@When("User click on label About Company")
	public void i_click_on_label_About_Company() {
		requirementCreationPagePO.clickOnAboutCompanyLabel();
	}

	@Then("Verify User see {string} message below the About Company textbox")
	public void i_should_see_message_below_the_About_Company_textbox(String errorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyTheErrorMessageOfAbtCompanyEditore(errorMessage),
				errorMessage + " is not displayed under about company section");
		TestNGLogUtility.pass(errorMessage + " is displayed under about company section");
	}
	
	@When("User click on Industy label")
	public void i_click_on_Industy_label() {
		requirementCreationPagePO.clickOnIndustryLabel();
	}

	@Then("Verify User see the error message {string} under the Industry field")
	public void i_should_be_able_to_see_the_error_message_under_the_Industry_field(String expectedErrorMessage) {
		Assert.assertTrue(requirementCreationPagePO.presenceOfErrorMessageForIndustry(expectedErrorMessage),
				expectedErrorMessage + " is not displayed under the Industry field");
		TestNGLogUtility.pass(expectedErrorMessage + " is not displayed under the Industry field");
	}

	@Then("Verify User see the error message {string} under the Functional Area")
	public void i_should_be_able_to_see_the_error_message_under_the_Functional_Area(String expectedErrorMessage) {
		Assert.assertTrue(requirementCreationPagePO.presenceOfErrorMessageForFunctionalArea(expectedErrorMessage),
				expectedErrorMessage + " is not displayed under the Functional Area field");
		TestNGLogUtility.pass(expectedErrorMessage + " is not displayed under the Functional Area field");
	}
	
	@When("User check the checkbox of Show Salary to jobseekers")
	public void i_check_the_checkbox_of_Show_Salary_to_jobseekers() {
		requirementCreationPagePO.selectShowSalaryToJobSeekers();
	}

	@When("User fills in the {string} as the group attached to the requirement")
	public void user_fills_in_the_as_the_group_attached_to_the_requirement(String groupName) {
		requirementCreationPagePO.selectTheGroupForRequirement(groupName);
	}

	@When("User selects {string} as the visibility mode of requirement")
	public void user_selects_as_the_visibility_mode_of_requirement(String modeOfVisibility) {
		requirementCreationPagePO.setTheVisibilityStatusOfCandidate(modeOfVisibility);
	}

	@When("User add a new requirment with {string} group")
	public void user_add_a_new_requirment_with_group(String groupName) {
		genericFunctions.selectOptionFromRMSGNB("Add A New Requirement", "Requirements");
		requirementName=requirementCreationPagePO.createARequirement("5,00,000", "7,00,000", "2", "5", "Java", "Delhi,Ahmedabad", groupName);
		PropFileHandler.writeProperty("RequirementName",requirementName);
		TestNGLogUtility.info("Created Requirement name is "+ requirementName);
	}

	@Then("User click on Preview button on requirement page")
	public void clickPreviewOnRequirementPage() {
		requirementCreationPagePO.clickPreviewOnRequirementPage();
	}

	@Then("User click on Post button on Preview Requirement page")
	public void clickPostOnPreviewRequirementPage() {
		requirementCreationPagePO.clickPostOnPreviewRequirementPage();
	}

	@When("User select the questionnaire from list")
	public void user_select_the_questionnaire_from_list() {
		questionnaireName = requirementCreationPagePO.selectQuestionnaireFromList();
		System.err.println(questionnaireName);
	}

	@Then("User should able to see success message of requirement creation")
	public void verifyReqCreationSuccessMessage() {
		Assert.assertTrue(requirementCreationPagePO.presenceOfSuccessMessageOfRequirementCreation(),
				"Requirement is not created successfully");
		TestNGLogUtility.pass("Requirement is created successfully");
	}

	@Then("User is able to see text below Annual CTC {string}")
	public void User_is_able_to_see_text_below_Annual_CTC(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableTextOnCreationPage(text),
				"Text under Annual Amount for variable is not displaying");
		TestNGLogUtility.pass("Text under Annual Amount for variable is displaying successfully");
	}

	@Then("User is able to see change text and that should be link")
	public void User_is_able_to_see_change_text_and_that_should_be_link() {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableChangeLinkOnCreationPage(),
				"Change link under Annual Amount for variable is not displaying");
		TestNGLogUtility.pass("Change link under Annual Amount for variable is displaying successfully");
	}

	@When("User click on {string} link under Annual CTC")
	public void user_click_on_link_under_Annual_CTC(String name) {
		requirementCreationPagePO.clickVariableChangeLinkOnCreationPage();
	}

	@Then("User should be able to see {string} field")
	public void User_should_be_able_to_see_field(String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableTextFieldOnCreationPage(field),
				"Veriable field under Annual Amount is not displaying");
		TestNGLogUtility.pass("Veriable field under Annual Amount is displaying successfully");
	}

	@Then("{string} field should be non mandatory")
	public void field_should_be_non_mandatory(String field) {
		Assert.assertFalse(requirementCreationPagePO.verifyVariableFieldIsNotMandatory(),
				"Variable field under Annual Amount is displaying as mandatory");
		TestNGLogUtility.pass("Variable field under Annual Amount is not displaying as mandatory");
	}

	@When("User enter {string} in veriable field")
	public void User_enter_in_veriable_field(String value) {
		variablePercent = requirementCreationPagePO.enterVariableAmountOnCreationPage(value);
	}

	@Then("User should not be able to see {string} value in variable field")
	public void User_should_not_be_able_to_see_value_in_variable_field(String type) {
		Assert.assertFalse(requirementCreationPagePO.verifyVariableValueIsDisplaying(variablePercent),
				"Variable value " + type + " is displaying.");
		TestNGLogUtility.pass("Variable value " + type + " is not displaying successfully.");
	}

	@Then("User should be able to see {string} value in variable field")
	public void User_should_be_able_to_see_value_in_variable_field(String type) {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableValueIsDisplaying(variablePercent),
				"Variable value " + type + " is not displaying.");
		TestNGLogUtility.pass("Variable value " + type + " is displaying successfully.");
	}

	@Then("User should not be able to see text {string} against variable field")
	public void User_should_not_be_able_to_see_text_against_variable_field(String text) {
		Assert.assertFalse(requirementCreationPagePO.verifyTextAgainstVariableField(text),
				"Variable text '" + text + "' is displaying.");
		TestNGLogUtility.pass("Variable text '" + text + "' is not displaying successfully.");
	}

	@Then("User should be able to see text {string} against variable field")
	public void User_should_be_able_to_see_text_against_variable_field(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyTextAgainstVariableField(text),
				"Variable text '" + text + "' is not displaying.");
		TestNGLogUtility.pass("Variable text '" + text + "' is displaying successfully.");
	}

	@Then("User should be able to see RS.M-RS.N is variable")
	public void User_should_be_able_to_see_is_variable() {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableAmountAgainstVariableField(variablePercent, minAmount,
				ctcAmount), "Variable amount as per variable percentage amount is not displaying.");
		TestNGLogUtility.pass("Variable amount as per variable percentage amount is displaying successfully.");
	}

	@When("User add keyword as")
	public void User_add_keyword_as(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			requirementCreationPagePO.fillTheKeywords(skill);
	}

	@Then("User should be able to see correct Annual CTC with variable on preview page")
	public void User_should_be_able_to_see_correct_Annual_CTC_with_variable_on_preview_page() {
		String expectedVariable = requirementCreationPagePO.calculateVeriableAmount(variablePercent, minAmount,
				ctcAmount);
		Assert.assertTrue(requirementCreationPagePO.verifyVariableFieldAndValueOnPreviewPage(expectedVariable),
				"Variable amount is not displaying on preview page.");
		TestNGLogUtility.pass("Variable amount is displaying on preview page successfully.");
	}

	@Then("User should be able to see correct Annual CTC with variable on requirement detail page")
	public void User_should_be_able_to_see_correct_Annual_CTC_with_variable_on_Requirment_page() {
		String expectedVariable = requirementCreationPagePO.calculateVeriableAmount(variablePercent, minAmount,
				ctcAmount);
		Assert.assertTrue(
				requirementCreationPagePO.verifyVariableFieldAndValueOnRequirementOverviewPage(expectedVariable),
				"Variable amount is not displaying on preview page.");
		TestNGLogUtility.pass("Variable amount is displaying on preview page successfully.");
	}

	@When("User click on the star on keyword chip")
	public void User_click_on_the_star_on_keyword_chip(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			requirementCreationPagePO.clickOnStarOnKeywordChip(skill);
	}

	@Then("veriable percetage and amount should be same as mentioned in Requisition")
	public void veriable_percetage_and_amount_should_be_same_as_mentioned_in_Requisition() {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableValueIsDisplaying(variablePercent),
				"Variable amount is not displaying on add requirement page.");
		TestNGLogUtility.pass("Variable amount is displaying on add requirement page successfully.");
	}

	@When("User click recent created requirement name")
	public void User_click_recent_created_requirement_name() {
		requirementCreationPagePO.clickOnRequirementName(AddASingleProfileStepDef.requirementName);
	}

	@Then("User should be able to see {string} star on keyword skill chip")
	public void User_should_be_able_to_see_star_on_keyword_skill_chip(String state, DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			Assert.assertTrue(requirementCreationPagePO.verifyStarIconOnKeywordChip(skill, state),
					state + " Star on keyword is not displaying as expected");
		TestNGLogUtility.pass(state + " Star on keyword is displaying as expected.");
	}

	@Then("User should be able to see {string} tooltip")
	public void User_should_be_able_to_see_tooltip(String state, DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			Assert.assertTrue(requirementCreationPagePO.verifyStarIconToolTip(skill, state),
					"Tool tip on " + state + " star is not displaing as expected.");
		TestNGLogUtility.pass("Tool tip on " + state + " star is displaing as expected.");
	}

	@Then("User should be able to see text {string} under keyword field")
	public void User_should_be_able_to_see_text_under_keyword_field(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyTextUnderKeywordField(text),
				"Text under the keyword field is not dispalying");
		TestNGLogUtility.pass("Text under the keyword field is not dispalying");
	}

	@Then("User should be able to see {string} on right side of keyword field")
	public void User_should_be_able_to_see_on_right_side_of_keyword_field(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyRemoveAllTags(text), text + " is not displaying");
		TestNGLogUtility.pass(text + " is displaying sucessfully.");
	}

	@Then("User should be able to see keyword value and must have star on chip")
	public void User_should_be_able_see_keyword_value_and_must_have_star_on_chip(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			Assert.assertTrue(requirementCreationPagePO.verifyStarOnKeywordChipOnPreview(skill),
					"star icon on keyword chip is not displaying as expected.");
		TestNGLogUtility.pass("star icon on keyword chip is not displaying as expected.");
	}

	@Then("User should be able to see keyword value and doesn't has must have star on chip")
	public void User_should_be_able_see_keyword_value_and_doesnt_must_have_star_on_chip(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills) {
			Assert.assertTrue(requirementCreationPagePO.verifyKeywordChipOnPreview(skill),
					"keyword chip for skill" + skill + " is not displaying as expected.");
			TestNGLogUtility.pass("keyword chip for skill" + skill + " is displaying as expected.");
		}
	}

	@Then("User should be able to see {string} link with {string} field")
	public void User_should_be_able_to_see_link_with_field(String link, String field) {
		Assert.assertTrue(requirementCreationPagePO.verifylinkinContactDetails(field, link),
				link + " is not displaying as expected.");
		TestNGLogUtility.pass(link + " is displaying as expected.");
	}

	@Then("User should be able to see Attach NaukriRecruiter Profile field disabled")
	public void User_should_be_able_to_see_Attach_NaukriRecruiter_Profile_field_disabled(String link, String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyNaukriRecruiterFieldIsDisabled(),
				"Attached NaukriRecruiter Profile is not disabled as expected.");
		TestNGLogUtility.pass("Attached NaukriRecruiter Profile is disabled as expected.");
	}

	@Then("User should be able to see {string} field as mandatory")
	public void User_should_be_able_to_see__field_as_mandatory(String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyContactDetailsIsMandatory(field),
				"Contact detail " + field + " is not disabled as mandatory.");
		TestNGLogUtility.pass("Contact detail " + field + " is disabled as mandatory.");
	}

	@When("User uncheck {string} checkbox")
	public void User_unchck_checkbox(String jobType) {
		requirementCreationPagePO.unselectJobTypeSelectedCheckbox(jobType);
	}

	@Then("User should not be able to see {string} field as mandatory")
	public void User_should_not_be_able_to_see__field_as_mandatory(String field) {
		Assert.assertFalse(requirementCreationPagePO.verifyContactDetailsIsMandatory(field),
				"Contact detail " + field + " is disabled as mandatory.");
		TestNGLogUtility.pass("Contact detail " + field + " is not disabled as mandatory.");
	}

	@When("User click on {string} link with {string} field")
	public void User_click_on_link_with_field(String link, String field) {
		requirementCreationPagePO.clicklinkinContactDetails(field, link);
	}

	@Then("User should be redirected on the naukri recruiter profile page in new tab")
	public void User_should_be_redirected_on_the_naukri_recruiter_profile_page_in_new_tab() {
		Assert.assertTrue(requirementCreationPagePO.verifyAddProfilePageOnNewTab(),
				"User is not redirecting on the MNR page.");
		TestNGLogUtility.pass("User is redirecting on the MNR page successfully.");
	}

	@Then("User should be able to see only recruiter profile fileds updated and show data in fields if available")
	public void User_should_be_able_to_see_only_recruiter_profile_fileds_updated_and_show_data_in_fields_if_available() {
		/**
		 * To DO
		 */
		Assert.assertTrue(requirementCreationPagePO.verifyNaukriRecruiterDetailsAfterRefresh("email"),
				"User is not able to see recruiter details after refresh");
		TestNGLogUtility.pass("User is able to see recruiter details after refresh successfully.");
	}

	@When("User add keyword in single profile as")
	public void User_add_keyword_In_single_profile_as(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
			requirementCreationPagePO.fillTheKeywordsInSingleProfile(skill);
	}

	@When("User click on Show salary to job seeker checkbox")
	public void User_click_on_Show_salary_to_job_seeker_checkbox() {
		requirementCreationPagePO.clickOnShowCtcToJobSeeker();
	}

	@When("User Select {string} photos from drop down list")
	public void User_Select_photos_from_drop_down_list(String count) {
		selected = Integer.valueOf(count);
		requirementCreationPagePO.selectPhotosFromList(Integer.valueOf(count));
	}

	@Then("User should be able to see rest of the list's checkboxes disabled")
	public void User_should_be_able_see_rest_of_the_lists_checkboxes_disabled() {
		Assert.assertTrue(requirementCreationPagePO.verifyPhotosDisabled(), "More than 5 photos are not disbaled");
		TestNGLogUtility.info("More than 5 photos are disbaled as expected");
	}

	@When("User deselect one selected checkboxes")
	public void User_deselect_one_selected_checkboxes() {
		deselected = 1;
		requirementCreationPagePO.unselectPhotoFromList(deselected);
	}

	@Then("User should be able to see rest checkbox are enabled")
	public void User_should_be_able_to_see_rest_checkbox_are_enabled() {
		Assert.assertTrue(requirementCreationPagePO.verifyPhotosEnabled(),
				"All photos are not enabled when less than 5 photos selected");
		TestNGLogUtility.info("All photos are not enabled when less than 5 photos selected");
	}

	@When("User hover on disabled checkbox")
	public void User_hover_on_disabled_checkbox() {
		requirementCreationPagePO.hoverOnDisabledCheckbox();
	}

	
	@Then("User should be able to see disabled photos tooltip {string}")
	public void User_should_be_able_to_see_disable_photos_tooltip(String message) {
		Assert.assertTrue(requirementCreationPagePO.verifyTooltipOnDisabledPhotosCheckboxes(message),
				"Correct Tooltip" + message + "is not displaying");
		TestNGLogUtility.info("Correct Tooltip" + message + "is displaying");
	}

	@Then("User should be able to see selected photos on requirement preview")
	public void User_should_be_able_to_see_selected_photos_on_requirement_preview() {
		int total = selected - deselected;
		Assert.assertTrue(requirementCreationPagePO.verifyPhotoesCountOnPreview(total),
				"Correct number of photos are not displaying.");
		TestNGLogUtility.info("Correct number of photos are displaying.");
	}

	@Then("User should be able to view added photos")
	public void User_should_be_able_to_view_added_photos() {
		Assert.assertTrue(requirementCreationPagePO.verifyUserCanViewPhotoesOnPreviewPage(),
				"User cannot view all the added photoes.");
		TestNGLogUtility.info("User can view all the added photoes.");
	}

	@When("User choose first address")
	public void User_choose_first_address() {
		requirementCreationPagePO.selectFirstAddress();
	}

	@When("User select {string} option")
	public void User_Select_option(String option) {
		requirementCreationPagePO.selectEducationalOption(option);
	}

	@When("User click on continue button")
	public void User_click_on_continue_button() {
		requirementCreationPagePO.clickOnContinueBtnOnGraducationNotRequiredPopUp();
	}

	@Then("User verify continue pop-up and its text {string}")
	public void User_verify_continue_popup_and_it_text(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyGraducationNotRequiredPopUpandText(text),
				"Continue popup or its text is not visible as expected");
		TestNGLogUtility.info("Continue popup or its text is visible as expected");
	}

	@Then("User should be able to see {string} radio buttons disabled and tooltip is {string} displaying")
	public void User_should_be_able_to_see_radio_buttons_disabled_and_tooltip_is_displaying(String degree,
			String tooltip) {
		Assert.assertTrue(requirementCreationPagePO.verifyPostgraduationAndDoctorateDisabled(degree, tooltip),
				degree + " is not disabled as expected");
		TestNGLogUtility.info(degree + " is disabled and its tooltip is displaying as expected");
	}

	@When("User select {string} degree {string} and {string} subject")
	public void User_select_and_option(String degree, String course, String subject) {
		requirementCreationPagePO.educationalCourseAndSubject(degree, course, subject);
	}

	@Then("User should be able to see {string} dropdown value {string}")
	public void User_should_be_able_to_see_dropdown_displaying(String type, String value) {
		Assert.assertTrue(requirementCreationPagePO.verifyEducationSpecializations(type, value),
				"Education specailization values are not disaplying correct.");
		TestNGLogUtility.info("Education specailization values are disaplying correct.");
	}

	@Then("User is able to see value {string}")
	public void User_should_be_able_to_see_value(String value) {
		Assert.assertTrue(requirementCreationPagePO.verifyDefaultEducationSpecializations(value),
				"Default Education specailization values are not disaplying correct.");
		TestNGLogUtility.info("Default Education specailization values are disaplying correct.");
	}

	@Then("User should be able to see by default first option is selected")
	public void User_should_be_able_to_see_by_default_first_option_is_selected() {
		Assert.assertTrue(requirementCreationPagePO.verifyFirstOptionIsSelected(),
				"Default first Education specailization radio button is not selected.");
		TestNGLogUtility.info("Default first Education specailization radio button is not selected.");
	}

	@Then("User should not be able to see {string} radio buttons disabled and tooltip is {string} displaying")
	public void User_should_not_be_able_to_see_radio_buttons_disabled_and_tooltip_is_displaying(String degree,
			String tooltip) {
		Assert.assertTrue(requirementCreationPagePO.verifyPostgraduationAndDoctorateEnabled(degree, tooltip),
				degree + " is disabled as " + degree + " field is not enabled");
		TestNGLogUtility.info(degree + " is not displayed as " + degree + " field is enabled as expected");
	}

	@Then("User should be able to see any dropdown after Doctorate field")
	public void User_should_not_be_able_to_see_any_dropdown_after_Doctorate_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyDefaultEducationSpecializationsIsDisplaying(),
				"Default Education specailization is displaying which is not expected.");
		TestNGLogUtility.info("Default Education specailization is not dispaying as expected.");
	}

	@When("User click on cancel button")
	public void User_click_on_cancel_button() {
		requirementCreationPagePO.clickOnCancelLinkOnContinuePopup();
	}

	@When("User click on close button")
	public void User_click_on_close_button() {
		requirementCreationPagePO.clickOnCloseLinkOnContinuePopup();
	}

	@Then("User should be able to see Walk-in Start Date field")
	public void User_should_be_able_to_see_Walkin_Start_Date_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinStartDateDisplaying(),
				"Walkin start date field is not displaying.");
		TestNGLogUtility.info("Walkin start date field is displaying as expected.");
	}

	@Then("User should be able to see Start Date field mandatory")
	public void User_should_be_to_see_Start_Date_field_mandatory() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinStartDateIsMandatory(),
				"Walkin start date is not displaying mandatory.");
		TestNGLogUtility.info("Walkin start date is displaying mandatory as expected.");
	}

	@Then("User should be able to see hint text {string} in start date field")
	public void User_should_be_able_to_see_Hint_text_in_field(String placeholder) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinStartDateHintText(placeholder),
				"Walkin start date hitn is not displaying.");
		TestNGLogUtility.info("Walkin start date hint is displaying as expected.");
	}

	@Then("User should be able to see error message {string} if field is blank")
	public void User_should_be_able_to_see_error_message_if_field_is_blank(String errorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinStartDateErrorIsDisplaying(errorMessage),
				"Walkin start date error message is not displaying.");
		TestNGLogUtility.info("Walkin start date error message is displaying as expected.");
	}

	@Then("User should be able to see older date disabled")
	public void User_should_be_able_to_see_older_date_disabled() {
		Assert.assertTrue(requirementCreationPagePO.verifyPreviousDateDisabled(),
				"Walkin previous date is not displaying disabled.");
		TestNGLogUtility.info("Walkin previous date is displaying disabled as expected.");
	}

	@When("User select any date in future")
	public void User_select_any_date_in_future() {
		selectedDate = requirementCreationPagePO.selectAnyNextDate();
	}

	@When("User click on calendar icon on walkin")
	public void User_click_on_calendar_icon_on_walkin() {
		requirementCreationPagePO.clickOnWalkinCalendar();
	}

	@Then("User should be able to select the start date and see text {string}")
	public void User_should_be_able_to_select_the_start_date(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkingDurationText(selectedDate, durationDays, text),
				"Walkin start date is not selected as expected.");
		TestNGLogUtility.info("Walkin start date is selected as expected");
	}

	@Then("User should be able to see Duration Days field")
	public void User_should_be_able_to_see_Duration__field() {
		Assert.assertTrue(requirementCreationPagePO.verifyDurationDD(), "Walkin duration DD is not displaying.");
		TestNGLogUtility.info("Walkin duration DD is displaying as expected.");
	}

	@Then("Duration Days should not be blank")
	public void Duration_should_not_be_blank() {
		Assert.assertTrue(requirementCreationPagePO.verifyDurationDDDefaultValue(1),
				"Walkin Duration DD default value is not displaying blank.");
		TestNGLogUtility.info("Walkin Duration DD default value is displaying blank.");
	}

	@Then("User should be able to see by default value {int}")
	public void User_should_be_able_to_see_by_default_value_1(int value) {
		Assert.assertTrue(requirementCreationPagePO.verifyDurationDDDefaultValue(value),
				"Walkin Duration DD default value is not displaying.");
		TestNGLogUtility.info("Walkin Duration DD default value is displaying as expected.");
	}

	@Then("User should be able select any interger values from {int} to {int} from drop down")
	public void user_should_be_able_select_any_interger_values_from_to_both_inclusive_from_drop_down(Integer started,
			Integer end) {
		Assert.assertTrue(requirementCreationPagePO.verifyDurationDdValues(started, end),
				"Walkin Duration DD default values are not displaying as expected.");
		TestNGLogUtility.info("Walkin Duration DD default values are displaying as expected.");
	}

	@When("User select {string} from duration drop down")
	public void User_select_from_duration_drop_down(String days) {
		durationDays = days;
		requirementCreationPagePO.selectDurationDays(days);
	}

	@Then("User should be able to see Walk-in timing drop down start field")
	public void User_should_be_able_to_see_Walk_in_timing_drop_down_start_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinTimeDdIsDisplaying(),
				"Walkin Timing DD is not displaying.");
		TestNGLogUtility.info("Walkin Timing DD is displaying as expected.");
	}

	@Then("User should be able to see values range from ‘{int}:{int} AM’ to ‘{int}:{int} PM’ and interval of {int} min")
	public void user_should_be_able_to_see_values_range_from_AM_to_PM_and_interval_of_min(Integer int1, Integer int2,
			Integer int3, Integer int4, Integer int5) {
		Assert.assertTrue(requirementCreationPagePO.verifyStartTimeDifference(),
				"Walkin Start Timing difference is not 30 minutes in DD.");
		Assert.assertTrue(requirementCreationPagePO.verifyEndTimeDifference(),
				"Walkin End Timing difference is not 30 minutes in DD.");
		TestNGLogUtility.info("Walkin Timing difference is 30 minutes in DD as expected.");
	}

	@Then("User should be able to see by default value is {double} AM")
	public void user_should_be_able_to_see_by_default_value_is_AM(Double double1) {
		Assert.assertTrue(requirementCreationPagePO.verifyDefaultSetTiming(),
				"Walkin default Timing in DD is not displaying.");
		TestNGLogUtility.info("Walkin default Timing in DD is displaying as expected.");
	}

	@When("User select End time {string} less then Start time {string}")
	public void user_select_End_time_less_then_Start_time(String endTime, String stratTime) {
		requirementCreationPagePO.selectStartTime(stratTime);
		requirementCreationPagePO.selectEndTime(endTime);
	}

	@Then("User should not be able to see empty field")
	public void user_should_not_be_able_to_see_empty_field() {
		Assert.assertFalse(requirementCreationPagePO.verifyDefaultSetTiming(),
				"Walkin default Timing in DD is not displaying blank as expected.");
		TestNGLogUtility.info("Walkin default Timing in DD is displaying blank as expected");
	}

	@Then("User should be able to see error message for timing dd {string}")
	public void User_should_be_able_to_see_error_message_for_timing_dd(String errorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinTimeErrorMessage(),
				"Walkin Timing error message is not displaying.");
		TestNGLogUtility.info("Walkin Timing error message is displaying as expected.");
	}

	@Then("User should be able to see Contact Person text field")
	public void User_should_be_able_to_see_Person_text_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPerson(),
				"Walkin contact person field is being not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person field is being displaying as expected.");
	}

	@Then("User should be able to see hint text {string} in contact person field")
	public void User_should_be_able_to_see_hint_text_in_contact_person_field(String hintText) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonPlaceholder(hintText),
				"Walkin contact person field hint is being not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person field hint text is being displaying as expected.");
	}

	@Then("User should be able to see contact person error message \"(.*?)\"$")
	public void User_should_be_able_to_see_contact_person_error_message(String errormessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonErrorMessage(errormessage),
				"Walkin contact person field hint is being not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person field hint text is being displaying as expected.");
	}

	@Then("User should be able to see contact person field as non mandatory field")
	public void User_should_be_able_to_see_contact_person_field_as_non_mandatory_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonMandatory(),
				"Walkin contact person field is displaying mandatory as expected.");
		TestNGLogUtility.info("Walkin contact person field hint text is being displaying as expected.");
	}

	@When("User should be able to enter any {string} in contact person Name")
	public void User_should_be_able_to_enter_any_in_contact_person_Name(String name) {
		String value = genericFunctions.generateRandomStrings(8, name);
		requirementCreationPagePO.enterContactPersonName(value);
	}

	@When("User enter any {string} special symbol")
	public void User_enter_any_special_symbol(String name) {
		String value = genericFunctions.generateSpecialMetionedSymbolRandomStrings(8, name);
		requirementCreationPagePO.enterContactPersonName(value);
	}

	@Then("User should not be able to see contact person error message \"(.*?)\"$")
	public void User_should_not_be_able_to_see_contact_person_error_message(String errormessage) {
		Assert.assertFalse(requirementCreationPagePO.verifyWalkinContactPersonErrorMessage(errormessage),
				"Walkin contact person field hint is being not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person field hint text is being displaying as expected.");
	}

	@Then("User should be able to see Contact Number text field")
	public void User_should_be_able_to_see_Contact_Number_text_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonNumber(),
				"Walkin contact person Number field is not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person Number field is displaying as expected.");
	}

	@Then("User should be able to see hint text {string} in Walk-in Contact Number field")
	public void User_should_be_able_to_see_hint_text_in_Walkin_Contact_Number_field(String hintText) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonNumberPlaceholder(hintText),
				"Walkin contact person Number field hint text is not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person Number field hint text is displaying as expected.");
	}

	@When("User enter {string} value in Walk-in Contact Number field")
	public void User_enter_value_in_Walkin_Contact_Number_field(String name) {
		String value = genericFunctions.generateRandomStrings(10, name);
		requirementCreationPagePO.enterContactPersonNumber(value);
	}

	@Then("User should be see an error message for Walk-in Contact Number field {string}")
	public void User_should_see_an_error_message_for_Walk_Contact_Number_field(String errorMessage) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonNumberErrorMessage(errorMessage),
				"Walkin contact person Number field hint text is not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person Number field hint text is displaying as expected.");
	}

	@Then("User should not be see an error message for Walk-in Contact Number field {string}")
	public void User_should_not_see_an_error_message_for_Walk_Contact_Number_field(String errorMessage) {
		Assert.assertFalse(requirementCreationPagePO.verifyWalkinContactPersonNumberErrorMessage(errorMessage),
				"Walkin contact person Number field hint text is not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person Number field hint text is displaying as expected.");
	}

	@Then("User should be able to see contact number note")
	public void User_should_able_to_see_contact_number_note() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactNumberNoteIsDisplaying(),
				"Walkin contact person Number field Note is not displaying as expected.");
		TestNGLogUtility.info("Walkin contact person Number field Note is displaying as expected.");
	}

	@When("User enter number upto {int} digits")
	public void User_should_be_able_to_number_upto_15_digits(int count) {
		contactNumber = genericFunctions.generateRandomStrings(count, "Number");
		requirementCreationPagePO.enterContactPersonNumber(contactNumber);
	}

	@Then("User should be able to enter number upto {int} digits")
	public void User_should_be_able_to_number_upto_digits(int count) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonNumberlength(),
				"Walkin contact person Number field is not accepting more than 15 digit.");
		TestNGLogUtility.info("Walkin contact person Number field is accepting more than 15 digit.");
	}

	@Then("User should be able to enter number is same")
	public void User_should_be_able_to_number_is_same() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonNumberIsSame(contactNumber),
				"Walkin contact person entered Number is not same");
		TestNGLogUtility.info("Walkin contact person entered Number is same.");
	}

	@Then("User should not be able to enter number is same")
	public void User_should_not_be_able_to_number_is_same() {
		Assert.assertFalse(requirementCreationPagePO.verifyWalkinContactPersonNumberIsSame(contactNumber),
				"Walkin contact person entered Number is not same");
		TestNGLogUtility.info("Walkin contact person entered Number is same.");
	}

	@Then("User should be able to see walkin duration field text {string}")
	public void User_should_be_able_to_walkin_duration_field_text(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinStartDateTextIsDisplaying(text),
				"Walkin duration field text is not displaying");
		TestNGLogUtility.info("Walkin duration field text is displaying");
	}

	@Then("User should be able to see contact person field text {string}")
	public void User_should_be_able_to_contact_person_field_text(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonTextIsDisplaying(text),
				"Walkin contact person field text is not displaying");
		TestNGLogUtility.info("Walkin contact person field text is displaying");
	}

	@Then("User should be able to see contact person number field text {string}")
	public void User_should_be_able_to_contact_person_number_field_text(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactPersonNumberTextIsDisplaying(text),
				"Walkin contact person number field text is not displaying");
		TestNGLogUtility.info("Walkin contact person number field text is displaying");
	}

	@Then("User should be able to see contact person number field as non mandatory field")
	public void User_should_be_able_to_see_person_number_field_as_non_mandatory_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinContactNumberMandatory(),
				"Walkin contact person Number field is not displaying as non mandatory field.");
		TestNGLogUtility.info("Walkin contact person Number field is displaying as non mandatory field.");
	}

	@Then("User should be see an error message for venue field {string}")
	public void User_should_be_see_an_error_message_for_venue_field(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueFieldErrorIsDisplaying(text),
				"Walkin venue field error message is not displaying");
		TestNGLogUtility.info("Walkin venue field error message is displaying as expected.");
	}

	@Then("User should be able to see Venue text field")
	public void User_should_able_to_see_Venue_text_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueFieldIsDisplaying(),
				"Walkin venue field is not displaying");
		TestNGLogUtility.info("Walkin venue field is displaying as expected.");
	}

	@Then("User should be able to see hint text {string} in venue field")
	public void User_should_be_able_to_see_hint_text_in_the_field(String hintText) {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueFieldIsDisplaying(),
				"Walkin venue field is not displaying");
		TestNGLogUtility.info("Walkin venue field is displaying as expected.");
	}

	@Then("User should be able to see field as mandatory field")
	public void User_should_be_able_to_field_as_mandatory_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueFieldIsMandatory(),
				"Walkin venue field is not displaying as mandatory");
		TestNGLogUtility.info("Walkin venue field is displaying as mandatory.");
	}

	@Then("User should be able to see Google Map URL open text field")
	public void User_should_be_able_to_see_Google_Map_URL_open_text_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueFieldIsMandatory(),
				"Walkin venue field is not displaying as mandatory");
		TestNGLogUtility.info("Walkin venue field is displaying as mandatory.");
	}

	@When("User enter URL in google map field")
	public void User_enter_URL_in_google_map_field() {
		requirementCreationPagePO.enterUrlInGoogleOpenField(url);
	}

	@Then("User should be able to see same URL in this field")
	public void User_should_be_able_to_see_same_URL_in_this_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleOpenFieldValue(url),
				"Google open field value is not same as entered.");
		TestNGLogUtility.info("Google open field value is same as entered.");
	}

	@Then("User should be able to see open field text {string}")
	public void User_should_be_able_to_see_open_field_text(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleOpenFieldTextIsDisplaying(text),
				"Google open field text is not displaying as expected");
		TestNGLogUtility.info("Google open field text is displaying as expected.");
	}

	@When("User click recent created requirement name from JP")
	public void User_click_recent_created_requirement_name_From_JP() {
		requirementCreationPagePO.clickOnRequirementName(JobPostingStepDef.requirementName);
	}

	@Then("User should be able to see same {string} as {string}")
	public void User_should_be_able_to_see_same_as(String field, String empType) {
		Assert.assertTrue(requirementCreationPagePO.selectedEmplyementValue(empType),
				"Selected Employement is not correct");
		TestNGLogUtility.info("Selected Employement is correct as expected.");
	}

	@Then("User should not be able to see veriable field on details page")
	public void User_should_not_be_able_to_veriable_field_on_details_page() {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableFieldIsNotDisplayingOnReqDetailsPage(),
				"Variable field is displaying on Requiremenmt details.");
		TestNGLogUtility.info("Variable field is not displaying on Requiremenmt details.");
	}

	@Then("User should be able to see {string} field in walkin section")
	public void User_should_be_able_to_see_field_in_walkin_section(String label) {
		Assert.assertTrue(requirementCreationPagePO.verifywalkinDateLabelIsDisplaying(label),
				"Walkin satrt date label is not dispalying");
		TestNGLogUtility.info("Walkin satrt date label is dispalying as expected");
	}

	@Then("User should be able to see drop down on the field")
	public void User_should_be_able_see_drop_down_on_the_field() {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueAddressDdIsDisplayed(),
				"Walkin venue address dropdown is not dispalying");
		TestNGLogUtility.info("Walkin venue address dropdown is dispalying as expected");
	}

	@When("User click on the venue drop down")
	public void User_click_the_venue_drop_down() {
		requirementCreationPagePO.clickOnVenueAddressListDd();
	}

	@Then("User should be able to see list of saved venues")
	public void User_should_be_able_to_see_list_of_saved_venues() {
		Assert.assertTrue(requirementCreationPagePO.verifySavedAddressList(),
				"Walkin venue address dropdown list is not dispalying");
		TestNGLogUtility.info("Walkin venue address dropdown list is dispalying as expected");
	}

	@Then("User should be see an error message for venue field {string} when left blank")
	public void User_should_be_an_error_message_for_venue_field_when_left_blank(String errorMsg) {
		Assert.assertTrue(requirementCreationPagePO.verifyVenueFieldErrorIsDisplaying(errorMsg),
				"Walkin venue address dropdown error message is not dispalying");
		TestNGLogUtility.info("Walkin venue address dropdown error message is dispalying as expected");
	}

	@Then("User should be able to see {string} link Google Map URL open text field")
	public void User_should_be_able_to_see_link_Google_Map_URL_open_text_field(String link) {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleUrlLinkIsDisplaying(link),
				"Walkin 'Search on Google Map' link is not dispalying");
		TestNGLogUtility.info("Walkin 'Search on Google Map' link is dispalying as expected");
	}

	@Then("User should see info tooltip text {string}")
	public void User_should_see_info_tooltip_text(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleUrlLinkIconToolTipTextIsDisplaying(text),
				"Walkin 'Search on Google Map' info icon tooltip is not dispalying or correct");
		TestNGLogUtility.info("Walkin 'Search on Google Map' info icon tooltip is dispalying as expected");
	}

	@Then("User should be able to see info icon with {string} link")
	public void User_should_be_able_to_see_info_icon_with_link(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleUrlLinkIconImageIsDisplaying(),
				"Walkin 'Search on Google Map' info icon is not dispalying or correct");
		TestNGLogUtility.info("Walkin 'Search on Google Map' info icon is dispalying as expected");
	}

	@Then("User should be able to see {string} as link with {string} tooltip")
	public void User_should_be_able_to_see_as_link_with_tooltip(String text, String tooltip) {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleUrlLinkIconToolTipTextLinkIsDisplaying(text),
				"Walkin 'Search on Google Map' info icon tooltip is not dispalying or correct");
		TestNGLogUtility.info("Walkin 'Search on Google Map' info icon tooltip is dispalying as expected");
	}

	@Then("User should be able to see {string} link {string}")
	public void User_should_be_able_to_see_link(String text, String tooltip) {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleUrlLinkIconToolTipTextLinkValue(text, tooltip),
				"Walkin 'Search on Google Map' info icon tooltip know more link is not dispalying or correct");
		TestNGLogUtility
				.info("Walkin 'Search on Google Map' info icon tooltip know more link is dispalying as expected");
	}

	@Then("User should be able to see layer of google maps")
	public void User_should_be_able_to_see_layer_of_google_maps() {
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleLocationLayerIsDisplaying(),
				"'Search on Google Map' google layer is not dispalying or correct");
		TestNGLogUtility.info("'Search on Google Map' google layer is dispalying as expected");
	}

	@When("User enter text {string} in venue field")
	public void User_enter_text_in_venue_field(String venue) {
		location = venue;
		requirementCreationPagePO.enterLocationInVenue(venue);
	}

	@When("User click on Search on Google Maps link in walkin")
	public void User_click_on_Search_Google_Mapslink_in_walkin() {
		requirementCreationPagePO.clickOnSearchGoogleLink();
	}

	@Then("User should be able to see text on layer of google maps which entered in venue field")
	public void User_should_be_able_to_see_text_on_layer_of_google_maps_which_entered_in_venue_field() {
		Assert.assertTrue(requirementCreationPagePO.verifylocationSearchValueOnGoogleLayer(location),
				"'Search on Google Map' google layer is not dispalying or correct");
		TestNGLogUtility.info("'Search on Google Map' google layer is dispalying as expected");
	}

	@When("User select the location on Google map")
	public void User_select_the_location_on_Google_map() {
		requirementCreationPagePO.selectFirstGoogleLocationOption();
	}

	@When("User click on USE THIS LOCATION button")
	public void User_click_on_USE_LOCATION_button() {
		requirementCreationPagePO.clickOnUseThisLocationBtn();
	}

	@Then("Google URL of this location should be pasted in Google URL field")
	public void Google_URL_of_this_location_should_be_pasted_in_Google_URL_field() {
		url = "https://www.google.co.in/maps?q";
		Assert.assertTrue(requirementCreationPagePO.verifyGoogleOpenFieldValue(url),
				"Location link value is not dispalying or correct");
		TestNGLogUtility.info("location link value is dispalying as expected");
	}

	@When("User select start time as {string} and End time {string}")
	public void User_select_start_time_as_and_End_time(String startTime, String endTime) {
		walkinStart = startTime;
		walkinEnd = endTime;
		requirementCreationPagePO.selectWalkinStartOrEndTime(startTime, endTime);
	}

	@Then("User should be able to see walk-in details on preview page")
	public void User_should_be_able_to_see_walk_in_details_on_preview_page() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinDetailOnPreviewPage(selectedDate),
				"walkin date is not dispalying or correct");
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinDetailOnPreviewPage(walkinStart),
				"walkin Start time is not dispalying or correct");
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinDetailOnPreviewPage(walkinEnd),
				"walkin End time is not dispalying or correct");
		TestNGLogUtility.info("walkin details is dispalying on preview page as expected");
	}

	@Then("User should be able to see walk-in details on overview page")
	public void User_should_be_able_to_see_walk_in_details_on_overview_page() {
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinDetailsOnReqDetailsPage(selectedDate),
				"walkin date is not dispalying or correct");
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinDetailsOnReqDetailsPage(walkinStart),
				"walkin Start time is not dispalying or correct");
		Assert.assertTrue(requirementCreationPagePO.verifyWalkinDetailsOnReqDetailsPage(walkinEnd),
				"walkin End time is not dispalying or correct");
		TestNGLogUtility.info("walkin details is dispalying on overview page as expected");
	}

	@Then("User should not be able to see {string} under phone number field")
	public void User_should_not_be_able_to_see_under_phone_number_field(String text) {
		Assert.assertTrue(requirementCreationPagePO.verifyContactPhoneNumberTextIsNotDisplayed(),
				"Note text under phone number is displaying which is not expected.");
		TestNGLogUtility.info("Note text under phone number is not displaying as expected");
	}

	@Then("User should be able to see Add Video URL drop down field and {string} link in branding options")
	public void User_should_be_able_to_see_Video_URL_drop_down_field_in_branding_options(String link) {
		Assert.assertTrue(requirementCreationPagePO.verifyAddVideoLinkIsPresent(link),
				"Add Video link is not displaying.");
		Assert.assertTrue(requirementCreationPagePO.verifyAddVideoDdIsPresent(),
				"Add Video drop down is not displaying.");
		TestNGLogUtility.info("Add Video drop down and link is displaying as expected");
	}

	@Then("Add Video URL drop down field should be non mandatory")
	public void Add_Video_URL_drop_down_field_should_be_non_mandatory() {
		Assert.assertTrue(requirementCreationPagePO.verifyAddVideoLinkIsNonMandatory(),
				"Add Video DD is not displaying non mandatory which is not expected.");
		TestNGLogUtility.info("Add Video DD is displaying non mandatory as expected");
	}

	@Then("Add Video URL drop down field should be displayed after {string} field")
	public void Add_Video_URL_drop_field_should_be_displayed_after_field(String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyAddVideoLinkAfterPresentaion(field),
				"Add Video DD is not displaying After presentation");
		TestNGLogUtility.info("Add Video DD is displaying After presentation as expected");
	}

	@When("User click on Add Video URL drop down field")
	public void User_click_on_Add_Video_URL_drop_down_field() {
		requirementCreationPagePO.clickOnAddVideoDD();
	}

	@Then("User should be able to see all the videos link added by Superuser")
	public void User_should_be_able_to_see_all_the_videos_link_added_by_Superuser() {
		Assert.assertTrue(requirementCreationPagePO.verifyTotalAddedVideo(RecuiterManagePhoesStepDef.totalVideos),
				"Total videos are not dispalyig in videos DD");
		TestNGLogUtility.info("Total videos are dispalyig in videos DD as expected");
	}

	@When("select first video URL from list")
	public void select_first_video_URL_from_list() {
		videoURL = requirementCreationPagePO.selectFirstVideoFromList();
	}

	@Then("User should be able to see thumbnail of corresponding URL")
	public void User_should_be_able_to_see_thumbnail_of_corresponding_URL() {
		Assert.assertTrue(requirementCreationPagePO.verifyAddedVideoThumbnail(), "Videos thumbnail is not dispalyig");
		TestNGLogUtility.info("Videos thumbnail is not dispalyig as expected");
	}

	@When("User should be able to click on thumbnail")
	public void User_should_able_to_click_on_thumbnail() {
		requirementCreationPagePO.clickOnVideoThumbnail();
	}

	@Then("User should be land on video URL in a new Tab")
	public void User_should_be_land_video_in_a_new_Tab() {
		Assert.assertTrue(requirementCreationPagePO.verifyVideoPlayingAfterClickOnThumbnail(videoURL),
				"Video is not playing after clicking on thumbnail in a new tab");
		TestNGLogUtility.info("Video is playing after clicking on thumbnail in a new tab as expected");
	}

	@Then("Attached video should be remove and no video should be attached with job")
	public void Attached_video_should_be_remove_and_no_video_should_be_attached_with_job() {
		Assert.assertFalse(requirementCreationPagePO.verifyAddedVideoThumbnail(), "Videos thumbnail is not dispalyig");
		TestNGLogUtility.info("Videos thumbnail is not dispalyig as expected");
	}

	@When("User remove the video link from video dropdown")
	public void User_remove_the_video_link_from_video_dropdown() {
		requirementCreationPagePO.RemoveSelectedVideo();
	}

	@Then("User should be rediected on the Naukri add video URL {string}")
	public void User_should_be_rediected_on_the_Naukri_add_video_URL(String url) {
		Assert.assertTrue(requirementCreationPagePO.verifyRedirectNaukriVideoAddedURL(url),
				"User is not redirect on the correct URL");
		TestNGLogUtility.info("User is redirect on the correct URL as expected");
	}

	@Then("User should be able to see {string} link in branding options with {string} field")
	public void User_should_be_able_to_see_link_in_branding_options_with_field(String link, String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyRefreshListLink(field, link),
				"Refresh link is not displaying as expected");
		TestNGLogUtility.info("Refresh link is displaying as expected as expected");
	}

	@When("User click on {string} link against {string} field")
	public void User_click_on_link_against_field(String link, String field) {
		requirementCreationPagePO.clickOnRefreshLinkAgainstField(field, link);
	}

	@Then("User should be able to see all the attached {string} on preview page as thumbnail")
	public void User_should_be_able_to_see_on_preview_page_as_thumbnail(String type) {
		Assert.assertTrue(requirementCreationPagePO.verifyMediaOnPreview(type),
				type + " thumbnail is not displaying on preview page as expected");
		TestNGLogUtility.info(type + " thumbnail is displaying on preview page as expected as expected");
	}

	@Then("User should be able to see text {string} on attached {string}")
	public void User_should_be_able_to_see_text_on_attached(String text, String type) {
		Assert.assertTrue(requirementCreationPagePO.verifyViewAndDownloadTextOnMediaHover(type, text),
				text + " on " + type + " thumbnail is not displaying on preview page as expected");
		TestNGLogUtility
				.info(text + " on " + type + " thumbnail is displaying on preview page as expected as expected");
	}

	@When("User click on {string} thumbnail")
	public void User_click_on_thumbnail(String type) {
		requirementCreationPagePO.clickOnViewAndDownloadTextOnMediaFromPreviewPage(type);
	}

	@Then("User should be able to see {string} in Job description section")
	public void User_should_be_able_to_see_in_Job_description_section(String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyJDFieldsAreDisplaying(field),
				field + " is not displaying on preview page in job description field as expected");
		TestNGLogUtility.info(field + " is displaying on preview page in job description field as expected");
	}

	@Then("User should be able to see {string} correct value on preview page")
	public void User_should_be_able_to_see_correct_value_on_preview_page(String field) {
		String value = "";
		if (field.contains("Roles"))
			value = jobDescription;
		else if (field.contains("Desired"))
			value = candidateDetails;
		else if (field.contains("Perks"))
			value = otherSalary;
		Assert.assertTrue(requirementCreationPagePO.verifyJdValuesOnPreview(field, value),
				field + " is not displaying on preview page in job description field.");
		TestNGLogUtility.info(field + " is displaying on preview page in job description field as expected");
	}

	@Then("User should not be able to see {string} in Job description section")
	public void User_should_not_be_able_to_see_in_Job_description_section(String field) {
		Assert.assertFalse(requirementCreationPagePO.verifyJDFieldsAreDisplaying(field),
				field + " is displaying on preview page in job description field");
		TestNGLogUtility.info(field + " is not displaying on preview page in job description field as expected");
	}

	@Then("User should be able to see {string} on preview page")
	public void User_should_be_able_to_see_on_preview_page(String field) {
		String value = "";
		if (field.contains("Job"))
			value = jobDescription;
		else if (field.contains("Candidate"))
			value = candidateDetails;
		else if (field.contains("Other"))
			value = otherSalary;
		Assert.assertTrue(requirementCreationPagePO.verifyJdValuesOnPreviewForClassified(field, value),
				field + " value is not displaying on preview page in " + field + " field");
		TestNGLogUtility.info(field + " value is displaying on preview page in " + field + " field as expected");
	}

	@Then("User should be able to see field {string} filled value {string} on JP form on RMS preview page")
	public void User_should_be_able_see_field_filled_value_on_JP_form_on_RMS_preview_page(String field, String value) {
		Assert.assertTrue(requirementCreationPagePO.verifyJdValuesOnPreview(field, value), field
				+ " same value is not displaying on preview page in " + field + " field which is filled on JP form");
		TestNGLogUtility.info(
				field + " same value is displaying on preview page in " + field + " field which is filled on JP form");
	}

	@Then("User should be able to see {string} value {string} on preview page for CL job")
	public void User_should_be_able_to_see_on_preview_page_for_cl(String field, String value) {
		Assert.assertTrue(requirementCreationPagePO.verifyJdValuesOnPreviewForClassified(field, value),
				field + " value is not displaying on preview page in " + field + " field");
		TestNGLogUtility.info(field + " value is displaying on preview page in " + field + " field as expected");
	}

	@Then("User should be able to see value {string} in {string} section")
	public void User_should_be_able_to_see_on_value_for_cl(String value, String field) {
		Assert.assertTrue(requirementCreationPagePO.verifyCLJobEditorValues(field, value),
				field + " value is not displaying on preview page in " + field + " field");
		TestNGLogUtility.info(field + " value is displaying on preview page in " + field + " field as expected");
	}

	@When("User remove text from Candidate profile")
	public void User_remove_in_the_Candidate_profile() {
		requirementCreationPagePO.removeCandidateDetails();
	}

	@When("User remove text from Other details for {string}")
	public void User_remove_text_from_Other_details(String user) {
		requirementCreationPagePO.removeMoreSalaryDetails(user);
	}

	@Then("User should not be able to see {string} value {string} on preview page for CL job")
	public void User_should_not_be_able_to_see_on_preview_page_for_cl(String field, String value) {
		Assert.assertFalse(requirementCreationPagePO.verifyJdValuesOnPreviewForClassified(field, value),
				field + " value is displaying on preview page in " + field + " field which is not accepted");
		TestNGLogUtility.info(field + " value is not displaying on preview page in " + field + " field as expected");
	}

	@When("User click on Next button on requirement page")
	public void User_click_on_Next_button_on_requirement_page() {
		requirementCreationPagePO.clickOnNextBtn();
	}
	
	@When("User click recent created requirement name from rms")
	public void User_click_recent_created_name_from_rms() {
		requirementCreationPagePO.clickOnRequirementName(RequirementCreationStepDef.requirementName);
	}
	
	@When("User select {string} option from education specialization")
	public void User_select_option_from_education_specialization(String index) {
		requirementCreationPagePO.selectEducationSpecializations(index);
	}

	@When("User click on Prefill from other Requirement")
	public void user_clic_prefill_from_other_req()
	{
		requirementCreationPagePO.clickPrefillFromOtherRequirement();
	}
	@Then("Verify the count of requirements on the prefill from other requirement DD")
	public void verify_count_prefill_other_req()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyCountOnPrefillOtherReqDD(),"Requirement count is incorrect");
	}
	@When("User click on Requirement Overview button on success message")
	public void user_click_requirement_overview_button_success_message()
	{
		requirementCreationPagePO.clickRequirementOverviewSuccessMessage();
	}
	@When("User click on preview on second page of requiremnt creation")
	public void user_click_preview_on_second_page_requirement_creation()
	{
		requirementCreationPagePO.previewSecondPageRequirementCreation();
	}
	@When("User clicks on save requirement from preview page")
	public void click_on_save_requirement()
	{
		requirementCreationPagePO.clickOnSaveRequirementPreviewPage();
	}
	
	@Then("User should be able to see error message {string}")
	public void User_should_be_able_to_see_error_message(String message) {
		Assert.assertTrue(requirementCreationPagePO.presenceOferrorMessageOfRequirementCreationWithoutHmSpoc(message),"Requirement creation expected error message is not being displayed");
		TestNGLogUtility.pass("Requirement creation expected error message is being displayed successfully");

	}
	@Then("Verify the contents of job {string}")
	public void verify_the_contents_of_job_location(String loc)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyContentsOfJobLoc(loc),"Job location is not selected");
	}
	@When("User fill in the international job location as {string}")
	public void user_fill_in_the_international_job_location(String loc)
	{
		requirementCreationPagePO.checkInternationalLocation();
		requirementCreationPagePO.selectInternationalLocFromDD(loc);
		requirementCreationPagePO.clickOnSaveLoc();
	}
	@When("User click on clear all locations")
	public void user_clicks_on_clear_all_locations()
	{
		requirementCreationPagePO.clearLocation();
	}
	@Then("Verify no location should be displayed")
	public void verifyNoLocDisplayedAfterClear()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyNoLocPresentIntextbox(),"locations present even after deleting all loc on textbar");
	}
	@Then("Verify the contents of international locations as {string}")
	public void verify_contents_international_locations_textbar(String internationalLoc)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyContentsOfJobLoc(internationalLoc),"international loc selected is not dispplayed");
	}
	@When("User fill in the international job location as {string}  with city name {string}")
	public void user_fill_international_job_location_and_city_name(String intCountry, String city)
	{
		requirementCreationPagePO.entersCityNameWithInternationalLoc(intCountry, city);
	}
//	@When("User click on save location")
//	public void click_On_Save_Location()
//	{
//		requirementCreationPagePO.clickOnSaveLocBtn();
//	}
	@Then("Verify the international locations selected {string}  with city name {string}")
	public void verify_international_loc_with_city_name(String internationalLoc , String city)
	{
		Assert.assertTrue(requirementCreationPagePO.VerifyEnteredInternationalLocAndCityName(internationalLoc,city),"international location with city anme is not displayed");
	}
	@Then("Verify the headings on DD {string}")
	public void verify_the_headings_prefill_DD(String headings)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyHeadigsONPrefillDD(headings),"headings on prefill options not displayed");
	}
	@Then("verify no groups section should be displayed on requirement creation page")
	public void verify_no_groups_displayed_eapps_account()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyGroupDDNOtDisplayed(),"groups dd is displayed for eapps account");
	}
	@When("get the count of groups on page")
	public void getCountOFGroups()
	{
		requirementCreationPagePO.getTotalCountOfGroups();
	}
	@When("click on cross for group selection stages")
	public void click_on_cross_group_selectionstages()
	{
		requirementCreationPagePO.clickOnCrossSelectionStages();
	}
	@When("click on groups section")
	public void click_on_groups_section()
	{
		requirementCreationPagePO.clickOnGroupsSelection();
	}
	@Then("verify {string} is displayed on add requirement page")
	public void verifyHiringOnReqPage(String hiringFor)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyHiringforReqPage(hiringFor),"hiring for is not displayed");
	}
	@Then("verify the count of groups present in DD")
	public void verifyTheCountOfGroupsPresentInDD()
	{
		requirementCreationPagePO.verifyCountOfGroups();
	}
	@When("select the group created")
	public void selectGroupCreated()
	{
		requirementCreationPagePO.selectGroup();
	}
	@When("user click on requirement name on cv details page")
	public void user_click_on_requirement_name_on_cv_details_page()
	{
		requirementCreationPagePO.userNavigatedtoREqOverviewFRomCVDetails();	
	}
	@When("click on {string} in visibility DD")
	public void click_on_visible_to_selected_people(String visibility)
	{
		requirementCreationPagePO.setTheVisibilityStatusOfCandidate(visibility);
		TestNGLogUtility.info("User set visibility as "+visibility);
	}
	@Then("Verify the subrecruiters {string}")
	public void verify_subrecruiter_Attached_group(String recruiterName)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyRecruiterNameOnReqCreation(recruiterName),"recruiter name is not displayed");
	}
	@Then("verify the hiring manager {string}")
	public void verify_the_hiring_manager(String hiringManager)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyHMOnReqCreation(hiringManager),"hiring manager displayed is not correct");
	}
	@When("click on maxExp")
	public void clickOnMaxExp()
	{
		requirementCreationPagePO.clickOnMaxExpDD();
	}
	@Then("verify the count of max experience {string}")
	public void verifyCountOfMaxExp(String countExpected)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyCountOfWkExp(countExpected), "work exp displayed isincorrect");
	}
	@When("User enters no of vacancies as {string}")
	public void userEntersNoOfVacancies(String noOfVacancies)
	{
	requirementCreationPagePO.UserEntersNoOfVacancies(noOfVacancies);
	}
	@When("User enters reference no as {string}")
	public void userEntersReferenceNo(String refCode)
	{
	requirementCreationPagePO.userEntersRefCode(refCode);
	}
	@Then("Verify User see the {string} as {string} and {string} as {string} on preview page")
	public void verifyUserVacancyAndRefCodeOnPreviewPage(String vacancy , String vacancyNo , String reference , String refCode)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyUserVacancyAndRefCode(vacancy,vacancyNo,reference,refCode),"vacancy and ref code is not correctly displayed on preview");
	}
	@When("select first requirement from prefill from other requirements DD")
	public void selectFirstRequirementFromPrefillFromOtherRequirementsDD()
	{
		requirementCreationPagePO.selectFirstRequirementFromPrefillFromOtherReq();
	}
	@Then("verify the fields prefilled from previous requirement")
	public void verifyFieldsPrefilledFromPreviousReq()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyFieldsPrefilledFromPreviousReq(),"req details do not match with the prefilled requirement");
	}
	@Then("verify 3 tabs are visible on requirement creation ie {string}, {string}, {string}")
	public void verifyTabsHeadingOnRequirementCreation(String heading1, String heading2, String heading3)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyHeadingOnRequirementCreation(heading1,heading2,heading3),"requirement headings displayed not correct");
	}
	@When("User enters the requirement name previously used")
	public void duplicateReqName()
	{
		requirementCreationPagePO.enterDuplicateReqName();
	}
	@When("User clicks on custom filter to apply on responses checkbox")
	public void customFilterOnResponsesCheckbox()
	{
		requirementCreationPagePO.customFiltersChkbox();
	}

	@Then("Verify currency {string} persists on editing requirement")
	public void currencyPeristsonEdit(String currency)
	{
		requirementCreationPagePO.verifyCurrencyPersistsOnEdit(currency);
	}
	@When("select any other group on requirement creation page")
	public void selectOtherGroupOnReqCreationPage()
	{
		requirementCreationPagePO.selectOtherGroupOnReqCreationPage();
	}
	@When("User enters {string} website")
	public void userEntersWebsite(String website)
	{
		requirementCreationPagePO.userEntersWebsite(website);
	}
	@When("User enters {string} contact person")
	public void userEntersCOntactPerson(String contactPerson)
	{
		requirementCreationPagePO.userEntersContactPerson(contactPerson);
	}

	@When("User enters {string} phone number")
	public void userEntersPhoneNumber(String phoneNumber)
	{
		requirementCreationPagePO.enterPhoneNumber(phoneNumber);
	}
	@Then("Verify User see the {string} website , {string} contact person, {string} phone no on preview page")
	public void verifyUserContactDetailsOnPreview(String companyWebsite, String contactPerson , String PhoneNumber)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyContactDetailsOnPreview(companyWebsite,contactPerson,PhoneNumber),"details dont match");
	}
	@Then("Verify User see the {string} , {string} , {string} , {string} , {string} on preview page")
	public void verify_user_see_outcome_preview_page(String expectedOutcome, String minExp, String maxExp, String keywords, String location)
	{
		requirementCreationPagePO.previewRequirement(expectedOutcome, minExp, maxExp, keywords, location);
	}
	@When("User clicks on Add new questionaire")
	public void user_clicks_on_add_new_questionaire()
	{
		
		requirementCreationPagePO.clickOnAddNewQuestionaire();
		//requirementCreationPagePO.selectQuestionnaireFromList();
	}
	@Then("User verify the questionaire lightbox is opened")
	public void verifyQuestionaireLightboxOpened()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyQuestionLightboxDisplayed(),"questionaire lightbox is not opened");
	}
	@When("User enters questionaire name")
	public void userEnterQuestionaireName()
	{
		requirementCreationPagePO.userEnterQuestionaireName();
	}
	@When("User clicks on Add New Question")
	public void addNewQuestion()
	{
		requirementCreationPagePO.addNewQuestion();
	}
	@When("User enters Question and selects {string}")
	public void enterQuestionAndSelectAnsOption(String radioOption)
	{
		requirementCreationPagePO.enterQuestionAndSelectAnsOption(radioOption);
	}
	@When("User enters {string} and {string} under answers")
	public void enterTwoAnsToQuestioniare(String ans1, String ans2)
	{
		requirementCreationPagePO.enterTwoAnsToQuestionaire(ans1,ans2);
	}
	@When("User enters {string} ,{string},{string} under answers")
	public void enterThreeAnsToQuestionaire(String ans1, String ans2, String ans3)
	{
		requirementCreationPagePO.enterThreeAnsToQuestionaire(ans1,ans2,ans3);
	}
	@When("User clicks on Save Question")
	public void saveQuestionOnQuestionaire()
	{
		requirementCreationPagePO.UserSaveQuestionOnQuestionaire();
	}
	@When("User clicks on Save questionaire")
	public void userClicksOnSaveQuestionaire()
	{
		requirementCreationPagePO.userClicksOnsaveQuestionaire();
	}
	@Then("User verifies the questionaire name on requirement creation page")
	public void user_verify_questionaire_lightbox_opened()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyQuestionaireName(),"questionaire is not created");
	}
	@When("User removes the keywords")
	public void userRemovesKeywordsOnCreationPage()
	{
		requirementCreationPagePO.clickOnClearKeyword();
	}
	@Then("verify keywords textbox is empty")
	public void verifyKeywordsTextboxIsEmpty()
	{
		Assert.assertFalse(requirementCreationPagePO.verifyKeywordTextBoxEmpty(),"remove keyword functionality not working");
	}
	@When("User select questionaire created above from existing questionaire")
	public void userSelectQuestionaireCreatedAbove()
	{
		requirementCreationPagePO.userSelectQuestionaireCreatedAboveFromExisting();
	}

	@Then("verify that one question is created")
	public void questionDisplayedAgainstSelectedQuestionaire()
	{
		Assert.assertTrue(requirementCreationPagePO.OneQuestionDisplayedAgainstQuestionaire(),"questionaire question is not displayed");
	}
	@Then("verify {string} , {string} and delete icon is displayed")
	public void optionsAgainstEveryQuestion(String option1, String option2)
	{
		Assert.assertTrue(requirementCreationPagePO.optionssAgainstEveryQuestion(option1,option2),"Edit , Duplicate and delete not displayed");
	}
	@When("User clicks on delete icon on question")
	public void clickOnDeleteIconOnQuestion()
	{
		requirementCreationPagePO.clickOnDeleteIconOnQues();
	}
	@Then("Verify no question should be displayed")
	public void noQuestionIsDisplayed()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyNoQuestionDisplayed(),"question is not deleted from lightbox");
	}
	@Then("Verify {string} error displayed on questionaire name")
	public void verifyErrorDisplayedOnQuestionaireName(String errorQuestionaire)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyErrorDisplayedOnQuestionaireName(errorQuestionaire),"error displayed on questionaire is not correct");
	}
	@Then("Verify {string} error displayed for question name")
	public void verifyValidationForEmptyQues(String errorQustionName)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyValidationForEmptyQues(errorQustionName),"error message displayed is not correct");
	}
	@Then("Verify {string} error displayed for answer name")
	public void verifyValidationAnsName(String errorAnsName)
	{
		Assert.assertTrue(requirementCreationPagePO.verifyValidationAnsName(errorAnsName),"error message displayed is not correct for ans textbox");
	}
	@When("User opens all the 10 textboxes")
	public void userEnters10AnsForAQuestion()
	{
		requirementCreationPagePO.userEntermaxNoOfAnsPossible();
	}
	@Then("verify Only 10 answers could be displayed for a question")
	public void verifyOnly10AnsCouldBeDisplayed()
	{
		Assert.assertFalse(requirementCreationPagePO.verifyOnly10AnsCOuldBeDisplayed(),"more than 10 ans could be displayed here");
	}
	@When("User click on cancel on lightbox")
	public void userClicksOnCancelOnLightbox()
	{
		requirementCreationPagePO.cancelOnQuestionaireLightbox();
	}
	@Then("verify no questionaire is displayed")
	public void verifyNoQuestionaireIsDisplayed()
	{
		Assert.assertFalse(requirementCreationPagePO.verifyQuestionLightboxDisplayed(), "questionaire lightbox is not closed");
	}
	@When("User clicks on Mandatory question")
	public void userClicksOnMandatoryQuestion()
	{
		requirementCreationPagePO.userClicksonMandatoryQuestion();
	}
	@When("User clicks on {string} button on question")
	public void userClicksOnElementOnQueestionTuple(String option)
	{
		requirementCreationPagePO.userClicksOnOptionOnQuestionType(option);
	}
	@Then("Verify Mandatory question is checked")
	public void verifyMandatoryQuestionIsChecked()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyMandatoryQuestionchecked(),"mandatory question is not checked");
	}
	@Then("Edit Question should be displayed on lightbox")
	public void editQuesShouldBeDisplayed()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyQuestionDisplayedOnEdit(),"on edit question not displayed");
	}
	@When("Change the question on edit")
	public void changeTheQuestionOnEdit()
	{
		requirementCreationPagePO.enterQuestionOnEdit();
	}
	@Then("Verify duplicate question is displayed on lightbox")
	public void verifyDuplicateQuestionIsDisplayednLightbox()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyQuestionDisplayedOnEdit(),"duplicate functiontionality not working");
	}
	@And("Verify only single jobs being posted of {string} on requirement overview page")
	public void verifySingleJobIsBeingPostedRequirementOverviewPage(String nameOfJobPosted){
		Assert.assertTrue(requirementCreationPagePO.verifySingleJobIsBeingPostedRequirementOverviewPage(nameOfJobPosted),"Not able to see job-->"+nameOfJobPosted);
		TestNGLogUtility.pass("Single Job of-->"+nameOfJobPosted+" is being posted on requirement Overview ");
	}
	
	@Then("User should be able to see correct Annual CTC with variable on requsition preview page")
	public void User_should_be_able_to_see_correct_Annual_CTC_with_variable_on_Requisition_preview_page() {
		Assert.assertTrue(requirementCreationPagePO.verifyVariableValueOnReqisitionPreviewPage(variablePercent),
				"Variable amount is not displaying on requisition preview page.");
		TestNGLogUtility.pass("Variable amount is displaying on requisition preview page successfully.");
	}
	
	@Then("User should not be able to see {string} field on preview page for CL job")
	public void User_should_not_be_able_to_see_field_on_preview_page_for_cl(String field) {
		Assert.assertFalse(requirementCreationPagePO.verifyJdFieldOnPreviewForClassified(field),
				field + " is displaying on preview page which is not accepted");
		TestNGLogUtility.info(field + " is not displaying on preview page as expected");
	}
	
	
	@When("Click On cancel button on update job popup")
	public void clickOnCancelButtonOnUpdateJobPopup()
	{
		requirementCreationPagePO.clickOnCancelButtonOnUpdatePopup();
	}
	
	
	@Then("User should be able to see {string} label")
	public void UserShouldBeAbleToSeeLabel(String value) {
		Assert.assertTrue(requirementCreationPagePO.verifyAddedVideoUrlLabel(value),
				"Correct " + value + " lable is not displaying as expected.");
		TestNGLogUtility.info("Correct " + value + " lable is displaying as expected.");
	}
	
	@Then("User should not be able to select second video from list")
	public void User_should_not_be_able_to_select_second_video_from_list() {
		Assert.assertFalse(requirementCreationPagePO.verifyVideoUrlDdValue(),
				"User is able to select another value from DD.");
		TestNGLogUtility.info("User is not able to select another value from DD as expected.");
	}
	
	@When("User fill name {string} in contact person Name")
	public void User_fill_in_contact_person_Name(String name)
	{
		requirementCreationPagePO.enterContactPersonName(name);
	}
	
	@When("User fill Number {string} value in Walk-in Contact Number field")
	public void User_fill_Number_value_in_Walkin_Contact_Number_field(String number)
	{
		requirementCreationPagePO.enterContactPersonNumber(number);
	}
	
	@Then("User should be able to see correct Keyskills on requsition preview page")
	public void User_should_be_able_to_see_correct_Keyskills_on_Requisition_preview_page(DataTable dataTable) {
		List<String> skills = dataTable.asList(String.class);
		for (String skill : skills)
		Assert.assertTrue(requirementCreationPagePO.verifyKeyskillValueOnReqisitionPreviewPage(skill),
				"Keyskills is not displaying on requisition preview page.");
		TestNGLogUtility.pass("Keyskills is displaying on requisition preview page successfully.");
	}
	
	@Then("User should be able to see {string} field as mandatory and error message {string} is displaying")
	public void User_should_be_able_to_see_field_as_mandatory_and_error_message_is_displaying(String field, String msg) {
		Assert.assertTrue(requirementCreationPagePO.verifyErrorMessageForContactDetails(msg),
				"Contact detail " + field + " error message " + msg + " is not displaying as mandatory.");
		TestNGLogUtility.pass("Contact detail " + field + " error message " + msg +" is dispaying as mandatory.");
	}
	
	@When("User clear Company Name and About company")
	public void clear_CompanyName_and_About_company()
	{
		requirementCreationPagePO.clearComapnyText();
		requirementCreationPagePO.clearAboutCompanyText();
	}
	
	@When("User fill the group name on req creation page")
	public void user_fill_group_name_on_req_creaation_page()
	{
		requirementCreationPagePO.selectGroup();
	}
	@When("user selects visibilty settings to {string}")
	public void setVisibleSettings(String visibiltySet )
	{
		requirementCreationPagePO.setTheVisibilityStatusOfCandidate(visibiltySet);
	}

	@When("User select any group while creating requirement")
	public void userSelectAnyGroupInRequirement()
	{
		requirementCreationPagePO.selectTheGroupForRequirement("PleaseDontEditOrDeletethis");
	}

	@Then("Verify User redirected to requirement overview page after requisition is raised")
	public void verifyUserRedirectedToOverviewAfterRequisitionRaised()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyRedirectedOverviewPageAfterequisitionRaised(),"user not redirected to requirement overview page");
	}
	@When("User updates the requirement on first page")
	public void userUpdatesFirstPageOfRequirement()
	{
		requirementCreationPagePO.userUpdatesFirstpageOfRequirement();
	}
	@When("User clicks on Save project on response filter page")
	public void userClicksOnSaveProjectTab3()
	{
		requirementCreationPagePO.clickOnSaveTab3();
	}
	@Then("verify requirement status is {string}")
	public void verifyREquirementStatusOnOverview(String status)
	{
		Assert.assertTrue(requirementOverviewPagePO.checkStatusOfRequirement(status),"status displayed is not correct");
	}

}

