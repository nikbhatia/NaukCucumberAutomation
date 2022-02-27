package com.naukri.stepdefinitions.Applications;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.pageobjects.Applications.BulkStatusUpdatePO;
import com.naukri.pageobjects.Applications.BulkStatusUpdatePO.BulkStatusChangeLightboxPO;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BulkStatusUpdateStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	BulkStatusUpdatePO bulkStatusUpdatePO = (BulkStatusUpdatePO) PageObjectWrapper.getObject(BulkStatusUpdatePO.class);
	BulkStatusUpdatePO.BulkStatusChangeLightboxPO bulkStatusChangeLightboxPO = (BulkStatusUpdatePO.BulkStatusChangeLightboxPO) PageObjectWrapper
			.getInnerClassObject(BulkStatusUpdatePO.class, BulkStatusChangeLightboxPO.class);
	
	SoftAssert softAssert = new SoftAssert();

	@When("I am on application inbox page")
	public void i_am_on_application_inbox_page() {
		bulkStatusUpdatePO.getApplicationInbox();
	}

	@When("I click on the bulk status change button on the top panel without selecting any profile")
	public void i_click_on_the_bulk_status_change_button_on_the_top_panel_without_selecting_any_profile() {
		bulkStatusUpdatePO.click_bulkStatusUpdate();
	}

	@Then("I should see an error message {string}")
	public void i_should_see_an_error_message(String errorMessageDisplayed) {
		Assert.assertTrue(bulkStatusUpdatePO.errorMessageOnNoCheckboxSelected(errorMessageDisplayed));
	}

	@When("I select profile {int} on profile listing page")
	public void i_select_profile_on_profile_listing_page(int index) {
		bulkStatusUpdatePO.selectProfileCheckbox(index);
	}

	@When("I click on the bulk status update from the top panel")
	public void i_click_on_the_bulk_status_update_from_the_top_panel() {
		bulkStatusUpdatePO.setFirstCandidateName();
		bulkStatusUpdatePO.click_bulkStatusUpdate();
	}

	@Then("I should be able to see the status change drop down in the modal")
	public void i_should_be_able_to_see_the_status_change_drop_down_in_the_modal() {
		Assert.assertTrue(bulkStatusChangeLightboxPO.visibilityOfStatusChangeDropDown(),
				"Status change drop down is not visible on the lightbox");
	}

	@Then("I should be able to see the {string} checkbox")
	public void i_should_be_able_to_see_the_checkbox(String string) {
		Assert.assertTrue(bulkStatusChangeLightboxPO.visibilityOfMarkRejectedCheckbox(),
				"Mark as rejected checkbox is not visible");
	}

	@When("I select multiple profiles on the profile listing page")
	public void i_select_multiple_profiles_on_the_profile_listing_page() {
		bulkStatusUpdatePO.checkGlobalApplication();
	}

	@Then("I should be able to see the number of selected profiles in the status change pop up")
	public void i_should_be_able_to_see_the_number_of_selected_profiles_in_the_status_change_pop_up() {
		Assert.assertTrue(bulkStatusChangeLightboxPO.checkTheNumberOfApplicationCount(),
				"The count on the bulk status update lightbox is not equal to the count of profiles displayed on the webpage");
	}

	@When("I check the Mark as Rejected checkbox")
	public void i_check_the_Mark_as_Rejected_checkbox() {
		bulkStatusChangeLightboxPO.checkMarkRejectedCheckbox();
	}

	@When("I click on update on the layout")
	public void i_click_on_update_on_the_layout() {
		bulkStatusChangeLightboxPO.clickUpdateButtonOnLayout();
	}

	@Then("I should be able to see the status of the selected candidate as {string}")
	public void i_should_be_able_to_see_the_status_of_the_selected_candidate_as(String statusText) {
		Assert.assertTrue(bulkStatusUpdatePO.searchCandidateAndVerifyStatus(statusText),
				"Not displayed");
	}

	@When("I select the status of the profiles to {string}")
	public void i_select_the_status_of_the_profiles_to(String statusText) {
		bulkStatusChangeLightboxPO.selectStatusFromDropDownMenu(statusText);
	}

	@When("I click on the cancel button on the modal layout")
	public void i_click_on_the_cancel_button_on_the_modal_layout() {
		bulkStatusChangeLightboxPO.clickCancelButtonOnLightbox();
	}

	@Then("I should not see the success message {string}")
	public void i_should_not_see_the_success_message(String successMessage) {
		Assert.assertTrue(!bulkStatusUpdatePO.displayOfStatusChangeSuccessMessage(successMessage),
				"The success message for status update is displayed");
	}

	@Then("I should not see the option of bulk status change on the top panel and text {string}")
	public void i_should_not_see_the_option_of_bulk_status_change_on_the_top_panel_and_text(String textMessage) {
		Assert.assertTrue(bulkStatusChangeLightboxPO.warningTextGeneratedOnMultipleRequirements(textMessage),
				"The warning message is not displayed");
	}

	@Then("I should be able to see the success message as {string}")
	public void i_should_be_able_to_see_the_success_message_as(String successMessage) {
		softAssert.assertTrue(bulkStatusUpdatePO.displayOfStatusChangeSuccessMessage(successMessage), 
				"The message containers aren't displayedx");
		softAssert.assertTrue(bulkStatusUpdatePO.checkTheSuccessMessageContent(successMessage),
				"The message content is not as intended");
               softAssert.assertAll();
               TestNGLogUtility.pass(successMessage+ " is displaying");
	}
	
	@When("I select the suitable candidate checkbox")
	public void i_select_the_suitable_candidate_checkbox() {
	   bulkStatusUpdatePO.choseSelectedCandidate();
	}

}
