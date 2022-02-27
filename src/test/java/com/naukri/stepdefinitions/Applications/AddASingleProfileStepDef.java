package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.TestNgXmlPanel;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Applications.ExcelUploadPagePO;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.stepdefinitions.HiringManager.HMRequisitionPageStepDef;
import com.naukri.stepdefinitions.Requirements.RequirementCreationStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddASingleProfileStepDef {

	AddASingleProfilePagePO addASingleProfile = (AddASingleProfilePagePO) PageObjectWrapper.getObject(AddASingleProfilePagePO.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	ExcelUploadPagePO excelUpload = (ExcelUploadPagePO) PageObjectWrapper.getObject(ExcelUploadPagePO.class);
	RequirementCreationPagePO requirementCreation = (RequirementCreationPagePO) PageObjectWrapper.getObject(RequirementCreationPagePO.class);
	SoftAssert softAssert = (SoftAssert) PageObjectWrapper.getObject(SoftAssert.class);
	static String candidateEmail="";
	public static String requirementName="";
	
	@When("I enter the {string} characters in the candidate name")
	public void i_enter_the_characters_in_the_candidate_name(String candidateName) {
		addASingleProfile.enterTheCandidateName(candidateName);
	}

	@When("I click on Add Candidate button")
	public void i_click_on_Add_Candidate_button() {
		addASingleProfile.clickAddCandidateBtn();
	}

	@Then("I should be able to see the error message as {string} under candidate name")
	public void i_should_be_able_to_see_the_error_message_as_under_candidate_name(String errorMessage) {
		Assert.assertTrue(addASingleProfile.verifyTheErrorMessage(errorMessage),
				errorMessage + " is not displayed as expected");
		TestNGLogUtility.pass(errorMessage + " is displayed as expected");
	}

	@Then("I should not be able to see the error message as {string} under candidate name")
	public void i_should_not_be_able_to_see_the_error_message_as_under_candidate_name(String errorMessage) {
		Assert.assertTrue(!addASingleProfile.verifyTheErrorMessage(errorMessage),
				errorMessage + " is displayed as expected");
		TestNGLogUtility.pass(errorMessage + " is not displayed as expected");
	}

	@When("I enter the name of {string} in the candidate name")
	public void i_enter_the_name_of_in_the_candidate_name(String lengthOfCandidateName) {
		addASingleProfile.enterTheCandidateNameOfGivenCharacterLength(lengthOfCandidateName);
	}

	@When("I fill in the email of the candidate")
	public void i_fill_in_the_email_of_the_candidate() {
		addASingleProfile.fillInCandidateEmail();
	}

	@Then("I should be redirected to the CV details page")
	public void i_should_be_redirected_to_the_CV_details_page() {
		Assert.assertTrue(cvDetailsPagePO.verifyRedirectedOnCVDetailsPage(),
				"The redirection to the CV details page is not successful");
		TestNGLogUtility.pass("The redirection to the CV details page is successful");
	}

	@Then("I should be able to see {string} on CV details page")
	public void i_should_be_able_to_see_on_CV_details_page(String successMessage) {
		Assert.assertTrue(cvDetailsPagePO.verifySuccessStatusMessage(successMessage),
				successMessage + " is not displayed on CV details page");
		TestNGLogUtility.pass(successMessage + " is displayed on CV details page");
	}

	@Then("I should be able to see the candidate name I entered while creation")
	public void i_should_be_able_to_see_the_candidate_name_I_entered_while_creation() {
		Assert.assertTrue(cvDetailsPagePO.verifyTheLengthOfText(),
				"The correct candidate name on CV Details Page is not visible ");
		TestNGLogUtility.pass("The correct candidate name on CV Details Page is visible ");
	}

	@When("I enter the {string} address in the email field")
	public void i_enter_the_address_in_the_email_field(String emailId) {
		addASingleProfile.fillInCandidateEmail(emailId);
	}

	@Then("I must see an error message as {string} under candidate's email field")
	public void i_must_see_an_error_message_as_under_candidate_s_email_field(String expectedErrorMessage) {
		Assert.assertTrue(addASingleProfile.verifyTheEmailErrorMessage(expectedErrorMessage),
				"The error message is not same as " + expectedErrorMessage);
		TestNGLogUtility.pass("The error message is same as " + expectedErrorMessage);
	}

	@When("I should be able to see the candidate email I entered while creation")
	public void i_should_be_able_to_see_the_candidate_email_I_entered_while_creation() {
		Assert.assertTrue(cvDetailsPagePO.verifyTheEmailIdTextOnCVDetailsPage(),
				"The email id entered during creation is not visible on details page");
		TestNGLogUtility.pass("The email id entered during creation is visible on details page");
	}

	@When("I enter {string} in the candidate phone")
	public void i_enter_in_the_candidate_phone(String mobileNumber) {
		addASingleProfile.fillInTheMobileNumber(mobileNumber);
	}

	@Then("I must see an error message as {string} under candidate's phone number")
	public void i_must_see_an_error_message_as_under_candidate_s_phone_number(String errorMessage) {
		Assert.assertTrue(addASingleProfile.verifyErrorMessageForContactNumber(errorMessage),
				"The error message displayed is not same as " + errorMessage);
		TestNGLogUtility.pass("The error message displayed is not same as " + errorMessage);
	}

	@Then("I should see the candidate mobile number of {int} digits I entered while creation")
	public void i_should_see_the_candidate_mobile_number_of_digits_I_entered_while_creation(
			Integer lengthOfMobileNumber) {
		Assert.assertTrue(cvDetailsPagePO.verifyTheLengthOfMobileNumberStored(lengthOfMobileNumber),
				"The mobile number displayed is not correct");
		TestNGLogUtility.pass("The mobile number displayed is correct");
	}

	@When("I fill in {string} in profile summary")
	public void i_fill_in_in_profile_summary(String profileSummaryText) {
		addASingleProfile.addProfileSummary(profileSummaryText);
	}

	@Then("I must be able to see the {string} as an error message")
	public void i_must_be_able_to_see_the_as_an_error_message(String profileSummaryErrorMessageText) {
		Assert.assertTrue(addASingleProfile.verifyTheProfileSummaryErrorMessage(profileSummaryErrorMessageText),
				"The error message is not displayed");
		TestNGLogUtility.pass("The error message is displayed.");
	}

	@When("I should be able to see the {string} in profile summary of CV details page")
	public void i_should_be_able_to_see_the_in_profile_summary_of_CV_details_page(String profileSummaryText) {
		Assert.assertTrue(cvDetailsPagePO.verifyTheTextOfProfileSummary(profileSummaryText),
				"The profile summary text is not visible on the CV Details page");
		TestNGLogUtility.pass("The correct profile summary text is visible on the CV Details Page");
	}

	@When("I fill in the summary of {int} characters in profile summary")
	public void i_fill_in_the_summary_of_characters_in_profile_summary(Integer lengthOfSummary) {
		addASingleProfile.addProfileSummary(lengthOfSummary);
	}

	@When("I should be able to see the in profile summary of CV details page of length {int}")
	public void i_should_be_able_to_see_the_in_profile_summary_of_CV_details_page_of_length(
			Integer lengthOfSummaryExpected) {
		Assert.assertTrue(cvDetailsPagePO.verifyTheTextOfProfileSummary(lengthOfSummaryExpected),
				"The summary message is not of length " + lengthOfSummaryExpected);
		TestNGLogUtility.pass("The summary message is not of length " + lengthOfSummaryExpected);

	}

	@When("I fill secondary email of the candidate")
	public void i_fill_secondary_email_of_the_candidate() {
		addASingleProfile.fillAnotherEmail();
	}

	@Then("I should be able to see the secondary email I entered while creation")
	public void i_should_be_able_to_see_the_secondary_email_I_entered_while_creation() {
		Assert.assertTrue(cvDetailsPagePO.verifyThePresenceOfSecondaryMail(), "The secondary mail is not visible");
		TestNGLogUtility.pass("The secondary mail is visible");
	}
	
	@When("I fill in the contact of the candidate")
	public void i_fill_in_the_contact_of_the_candidate() {
	    addASingleProfile.fillInContactNumber();
	}

	@When("I fill in the secondary of the candidate")
	public void i_fill_in_the_secondary_of_the_candidate() {
	  addASingleProfile.fillInSecondaryNumber();
	}

	@Then("I should be able to see the primary contact number I entered while creation")
	public void i_should_be_able_to_see_the_primary_contact_number_I_entered_while_creation() {
		Assert.assertTrue(cvDetailsPagePO.verifyThePresenceOfMobileNumber(), 
				"The primary contact number of the candidate is not visible");
		TestNGLogUtility.pass("The primary contact number of the candidate is visible");
	}

	@Then("I should be able to see the secondary contact number I entered while creation")
	public void i_should_be_able_to_see_the_secondary_contact_number_I_entered_while_creation() {
	   Assert.assertTrue(cvDetailsPagePO.verifyThePresenceOfSecondaryMobileNumber(), 
			   "The secondary contact number of the candidate is not visible");
	   TestNGLogUtility.pass("The primary contact number of the candidate is visible");
	}
	
	@Then("I should be able to see the text {string}")
	public void i_should_be_able_to_see_the_text(String expectedText) {
	   Assert.assertTrue(addASingleProfile.verifyTheUploadLogsText(expectedText), 
			   "The upload logs is visible");
	   TestNGLogUtility.pass("The upload logs is visible");
	}
	
	@When("I click on {string} on add a single profile")
	public void i_click_on_on_add_a_single_profile(String linkText) {
	   addASingleProfile.clickOnLinkPresent(linkText);
	}
	
	@Then("I should be able to see the main text as {string} under email import")
	public void i_should_be_able_to_see_the_main_text_as_under_email_import(String expectedMainText) {
	   Assert.assertTrue(addASingleProfile.verifyTheMainTextForEmail(expectedMainText), 
			   "The expected main text is not visible");
	   TestNGLogUtility.pass("The expected main text is visible");
	}

	@Then("I should be able to see the list text as {string} and {string} under email import")
	public void i_should_be_able_to_see_the_list_text_as_and_under_email_import(String expectedOption1, String expectedOption2) {
	   Assert.assertTrue(addASingleProfile.verifyTheListOptionsForEmail(expectedOption1,expectedOption2), 
			   "The expected list of options is not visible for the email");
	   TestNGLogUtility.pass("The expected list of options is visible for the email");
	}

	@When("I click on email import links")
	public void i_click_on_email_import_links() {
	  addASingleProfile.clickOnEmailImportLink();
	}

	@Then("I should be able to see the email import page with heading {string}")
	public void i_should_be_able_to_see_the_email_import_page_with_heading(String headingText) {
	   Assert.assertTrue(addASingleProfile.verifyThePresenceOfManageRecruiter(headingText), 
			   headingText + " is not visible");
	   TestNGLogUtility.pass(headingText + " is visible");
	}

	@Then("I should be able to see text {string} under Add Profiles via Bulk Upload")
	public void i_should_be_able_to_see_text_under_Add_Profiles_via_Bulk_Upload(String expectedOption) {
	   Assert.assertTrue(addASingleProfile.verifyThePresenceOfListUnderBulkUpload(expectedOption), 
			   expectedOption + " is not visibile under bulk upload option");
	   TestNGLogUtility.pass(expectedOption + " is visibile under bulk upload option");
	}

	@When("I click on add profiles via bulk upload")
	public void i_click_on_add_profiles_via_bulk_upload() {
	   addASingleProfile.clickOnBulkUploadLink();
	}

	@Then("I should be able to see {string} as the page heading for the bulk CV upload")
	public void i_should_be_able_to_see_as_the_page_heading_for_the_bulk_CV_upload(String expectedHeadingText) {
		 Assert.assertTrue(addASingleProfile.verifyThePresenceOfBulkUpload(expectedHeadingText), 
		    		"The bulk upload heading page is not working");
		    TestNGLogUtility.pass("The bulk upload heading page is not working");
	}

	@Then("I should be able to see text {string} under Add Multiple Profiles")
	public void i_should_be_able_to_see_text_under_Add_Multiple_Profiles(String expectedOption) {
	    Assert.assertTrue(addASingleProfile.verifyThePresenceOfListUnderMultipleUpload(expectedOption), 
	    		expectedOption + " is not displayed on add a single profile page");
	    TestNGLogUtility.pass(expectedOption + " is displayed on add a single profile page");
	}

	@When("I click on add multiple profiles")
	public void i_click_on_add_multiple_profiles() {
	   addASingleProfile.clickOnMultipleUploadLink();
	}

	@Then("I should be able to see text {string} under Add Profile via excel upload")
	public void i_should_be_able_to_see_text_under_Add_Profile_via_excel_upload(String expectedOption) {
		Assert.assertTrue(addASingleProfile.verifyTheTextPresentUnderEmail(expectedOption), 
				expectedOption + " is not displayed on the excel uplaod");
		TestNGLogUtility.pass(expectedOption + " is displayed under the excel upload");
	}

	@When("I click on excel upload")
	public void i_click_on_excel_upload() {
		addASingleProfile.clickOnExcelUploadOnSingleUpload();
	}
	
	@Then("I should be able to see the page with heading {string} on excel upload")
	public void i_should_be_able_to_see_the_page_with_heading_on_excel_upload(String expectedHeading) {
	   Assert.assertTrue(excelUpload.verifyThePresenceOfExcelUploadHeading(expectedHeading), 
			   expectedHeading+ " is not visible");
	   TestNGLogUtility.pass(expectedHeading+ " is visible");
	}
	
	@When("User clicks on Add New")
	public void user_clicks_on_Add_New() {
	   addASingleProfile.clickOnAddRequirement();
	}

	@Then("User should be able to see the {string} for add requirement widget")
	public void user_should_be_able_to_see_the_for_add_requirement_widget(String expectedHeadingForAddRequirementDiv) {
		Assert.assertTrue(addASingleProfile.checkForPresenceOfAddNewRequirementDiv(expectedHeadingForAddRequirementDiv), 
				expectedHeadingForAddRequirementDiv +" is not displayed");
		TestNGLogUtility.pass(expectedHeadingForAddRequirementDiv +" is displayed");
	}

	@When("User fills in the requirement title for add a single profile")
	public void user_fills_in_the_requirement_title_for_add_a_single_profile() {
	   requirementName=addASingleProfile.fillInRequirementTitleAddNewProfile();
	   HMRequisitionPageStepDef.reqName = requirementName;
	   RequirementCreationStepDef.requirementName=requirementName;
	}

	@When("User fills in the reference code for add a single profile")
	public void user_fills_in_the_reference_code_for_add_a_single_profile() {
		requirementCreation.fillInReferenceCodeForRequirement();
	}
	
	@When("User fill in the random email of the candidate")
	public void User_fill_in_random_the_email_of_the_candidate() {
		String email="email" + System.currentTimeMillis() + "@yopmail.com";
		candidateEmail=addASingleProfile.fillInCandidateRandomEmail(email);
	}
	
	@When("User fill in the already created email of the candidate")
	public void User_fill_in_already_created_email_of_the_candidate() {
		addASingleProfile.fillInCandidateRandomEmail(candidateEmail);
	}
	
	@When("User fills in {string} as Current Designation")
	public void user_fills_in_as_Current_Designation(String designationString) {
	   addASingleProfile.fillInCurrentDesignation(designationString);
	}

	@When("User fills in {string} as Current Company")
	public void user_fills_in_as_Current_Company(String companyString) {
	  addASingleProfile.fillInCurrentCompany(companyString);
	}

	@When("User fills in {string} as Current Location")
	public void user_fills_in_as_Current_Location(String locationString) {
	   addASingleProfile.fillInCurrentLocation(locationString);
	}

	@When("User checks in {string} as preferred location")
	public void user_checks_in_as_preferred_location(String preferredString) {
	    addASingleProfile.selectPreferredLocation(preferredString);
	}

	@When("User fills in {string} as Functional Area")
	public void user_fills_in_as_Functional_Area(String functionalArea) {
		addASingleProfile.fillInFunctionalArea(functionalArea);
	}

	@When("User fills in {string} as Role")
	public void user_fills_in_as_Role(String roleString) {
	   addASingleProfile.fillInTheRole(roleString);
	}

	@When("User fills in {string} as Industry")
	public void user_fills_in_as_Industry(String industryString) {
	    addASingleProfile.fillInIndustry(industryString);
	}

	@When("User selects {int} years and {int} months as total experience")
	public void user_selects_years_and_months_as_total_experience(Integer yearOfExp, Integer monthOfExp) {
	   addASingleProfile.fillInExperience(yearOfExp, monthOfExp);
	}

	@When("User selects {int} lakhs and {int} thousands as annual salary")
	public void user_selects_lakhs_and_thousands_as_annual_salary(Integer currentLakhs, Integer currentThousands) {
	   addASingleProfile.fillInCurrentCTC(currentLakhs, currentThousands);
	}

	@When("User selects {int} lakhs and {int} thousands as expected salary")
	public void user_selects_lakhs_and_thousands_as_expected_salary(Integer expectedLakhs, Integer expectedThousands) {
	   addASingleProfile.fillInExpectedCTC(expectedLakhs,expectedThousands);
	}
	
	@Then("User should be able to see the {string} same as {string} from property file")
	public void user_should_be_able_to_see_the_same_as_from_property_file(String labelString, String labelStringForPropFile) {
		softAssert.assertTrue(addASingleProfile.verifyKeyForAProperty(labelString, labelStringForPropFile), "Correct value is not displayed on the UI for " + labelString);
		softAssert.assertAll();
		TestNGLogUtility.pass("Correct value is displayed on the UI for " + labelString);
	}
	
	@When("User comments {string} on the application at the creation")
	public void user_comments_on_the_application_at_the_creation(String commentText) {
		addASingleProfile.addCommentWhileCreation(commentText);
	}
	
	@When("User select the CV in {string} extension for single upload")
	public void user_select_the_CV_in_extension_for_single_upload(String documentExtension) {
	    addASingleProfile.selectTheCVToUpload(documentExtension);
	}

	@Then("User should be able to see the {string} same as resume")
	public void user_should_be_able_to_see_the_same_as_resume(String keyOfMapCreated) {
	   Assert.assertTrue(addASingleProfile.verifyTheParsingOfUploadCV(keyOfMapCreated), 
			   "Right data for key " + keyOfMapCreated + " is not visible");
	   TestNGLogUtility.pass("Right data for key " + keyOfMapCreated + " is visible");
	}
	
	@When("User uploads the image of candidate")
	public void user_uploads_the_image_of_candidate() {
	    addASingleProfile.uploadTheCandidateImage();
	}
	
	@When("User selects the candidate status as {string} while creating the candidate")
    public void user_selects_the_candidate_status_as_while_creating_the_candidate(String statusString) {
        addASingleProfile.changeStatusWhileCreation(statusString);
    }
	
	@Then("User should be able to correct calculated variable")
	public void User_should_able_to_correct_calculated_variable() {
		String expectedVariable=requirementCreation.calculateVeriableAmount(RequirementCreationStepDef.variablePercent, RequirementCreationStepDef.minAmount, RequirementCreationStepDef.ctcAmount);
		Assert.assertTrue(addASingleProfile.verifyVariableAmountOnUpload(expectedVariable), "Correct variable value is not displayed on upload");
		TestNGLogUtility.pass("Correct value is displayed on the upload");
	}
}
