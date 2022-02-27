package com.naukri.stepdefinitions.Offer;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Offer.OfferValidationPagePO;

import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferValidationStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferValidationPagePO offerValidation = (OfferValidationPagePO) PageObjectWrapper
			.getObject(OfferValidationPagePO.class);

	/*@Given("I login into RMS as an \"([^\"]*)\" user")
	public void i_login_into_RMS_as_an_user(String subscriptionType) {
		genericFunctions.setUsernameAndPassword(subscriptionType, "Superuser");
	}
*/
	/*@When("I am on add single profile page")
	public void i_am_on_add_single_profile_page() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.addSingleProfile"));
	}*/

	/*@When("I fill in all the details of the candidate")
	public void i_fill_in_all_the_details_of_the_candidate() {
		offerValidation.addCandidateInformation();
		offerValidation.addRequirementDetailsForCandidate();
	}*/

	/*@When("I click on Save button")
	public void i_click_on_Save_button() {
		offerValidation.clickAddCandidateBtn();
	}*/

	/*@Then("I should be directed to the CV details page")
	public void i_should_be_directed_to_the_CV_details_page() {
		Assert.assertTrue(offerValidation.verifyRedirectedOnCVDetailsPage(),
				"The user is not getting redirected to CV Details Page");
	}*/

	/*@Then("I should be able to see the success message {string} on CV Details Page")
	public void i_should_be_able_to_see_the_success_message_on_CV_Details_Page(String successMessage) {
		Assert.assertTrue(offerValidation.verifySuccessStatusMessage(successMessage),
				"The Success Message for creation of profile is not visible");
	}*/

	@When("I should be able to see the status change message {string} on CV Details Page")
	public void i_should_be_able_to_see_the_status_change_message_on_CV_Details_Page(String successMessage) {
		Assert.assertTrue(offerValidation.validateStatusChangeSuccessMessage(successMessage),
				"The success message for status change of candidate is not visible");
	}

	/*@When("I click on status change drop down")
	public void i_click_on_status_change_drop_down() {
		offerValidation.clickOnStatusChangeDD();
	}*/

	/*@When("I click on {string} on DD")
	public void i_click_on_on_DD(String statusText) {
		offerValidation.changeStatusOfCandidate(statusText);
	}*/

	@Then("I should be directed to Offer Generation page")
	public void i_should_be_directed_to_Offer_Generation_page() {
		Assert.assertTrue(offerValidation.verifyRedirectedOnOfferGenerationPage(),
				"The user is not getting redirected to Offer Generation Page");
	}

	@SuppressWarnings("static-access")
	@When("I fill in all the details for Offer Generation")
	public void i_fill_in_all_the_details_for_Offer_Generation() {
		offerValidation.addOfferedDesignation(genericFunctions.generateRandomStrings(10, "String"));
		offerValidation.addCandidatesJoiningSalary(genericFunctions.generateRandomStrings(6, "Number"));
		offerValidation.selectDateInCalendarInOfferGenerationOld("Offered on", 1);
		offerValidation.selectDateInCalendarInOfferGenerationOld(" tentative joining date", 10);
		offerValidation.saveValuesEnteredInDateFields();
	}

	@When("I click on Cancel Offer button")
	public void i_click_on_Cancel_Offer_button() {
		offerValidation.clickAddCancelOfferBtn();
	}

	/*@Then("I should see the current status of the candidate as {string}")
	public void i_should_see_the_current_status_of_the_candidate(String statusText) {
		Assert.assertTrue(offerValidation.verifyStatusOfCandidate(statusText),
				"Status of candidate is not " + statusText);
	}*/

	@Then("I should see offered date is prefilled as current date")
	public void i_should_see_offered_date_is_prefilled_as_current_date() {
		Assert.assertTrue(
				offerValidation.verifyOfferedDateSameAsCurrentDate(genericFunctions.getCurrentDate("dd MMM yyyy")),
				"Offered Date is not prefilled as Current Date: " + genericFunctions.getCurrentDate("dd MMM yyyy"));
	}

	@SuppressWarnings("static-access")
	@When("I enter alphanumericals and numbers in Salary textbox")
	public void i_enter_alphanumericals_and_numbers_in_Salary_textbox() {
		offerValidation.addAlphanumericsAndNumrericsInSalaryTextBox(genericFunctions.generateRandomStrings(5, "String")
				+ genericFunctions.generateRandomStrings(5, "Number"));
	}

	@Then("I should see only numbers are allowed in salary textbox")
	public void i_should_see_only_numbers_are_allowed_in_salary_textbox() {
		Assert.assertTrue(offerValidation.verifySalaryTextboxIsNumeric(), "Salary textbox contains alphanumerics");
	}
	@When("Enter designation and joining salary on offer details page")
	public void enterDesignationAndJoiningSalary()
	{
		offerValidation.addOfferedDesignation(genericFunctions.generateRandomStrings(10, "String"));
		offerValidation.addCandidatesJoiningSalary(genericFunctions.generateRandomStrings(6, "Number"));
	}
	@When("clear designation field and salary field")
	public void clearDesignationAndSalary()
	{
		offerValidation.clearDesignation();
		offerValidation.clearJoiningSalary();
	}
	@Then("verify validation messages of designation and joining salary {string}")
	public void verifyValidationDesignationSalary(String errorOfferDetails)
	{
		Assert.assertTrue(offerValidation.verifyValidationDesignationAndSalary(errorOfferDetails),"correct on offer details page is incorrect");
	}
	@When("select offered date ahead of joining date")
	public void selectOfferedDateJoiningDate()
	{
		offerValidation.addOfferedDesignation(genericFunctions.generateRandomStrings(10, "String"));
		offerValidation.addCandidatesJoiningSalary(genericFunctions.generateRandomStrings(6, "Number"));
		offerValidation.selectDateInCalendar("Offered on", 1);
		offerValidation.selectDateInCalendar(" tentative joining date", 2);
		offerValidation.selectDateInCalendar("Offered on", 3);
	}
	@Then("verify choose date should be displayed under {string}")
	public void verifyChooseDateDisplayedUnderCandidateJoiningDate(String labelOnOfferDetailsPage)
	{
		Assert.assertTrue(offerValidation.verifyJoiningDateIsNotSelected(labelOnOfferDetailsPage),"candidate's tentative joining date is not correct");
	}
	
}
