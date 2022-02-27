package com.naukri.stepdefinitions.Offer;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.pageobjects.Offer.OfferGenerationPagePO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.pageobjects.Offer.OfferValidationPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferGenerationStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferGenerationPagePO offerGenerationPO = (OfferGenerationPagePO) PageObjectWrapper
			.getObject(OfferGenerationPagePO.class);
	OfferValidationPagePO offerValidationPO = (OfferValidationPagePO) PageObjectWrapper
			.getObject(OfferValidationPagePO.class);

	@When("I click Next Button on Offer Details")
	public void i_click_Next_Button() {
		offerGenerationPO.clickNextOnOfferDetailsBtn();
	}

	@When("I attach Offer Letter on Attach Offer Letter page")
	public void i_attach_Offer_Letter_on_Attach_Offer_Letter_page() {
		offerGenerationPO.waitForUploadOfferLetterButton();
		offerGenerationPO.attachOfferLetterOnAttachOfferLetterPage("Less than 5 MB");
	}

	@When("I clear Offer Mail subject field")
	public void i_clear_Offer_Mail_subject_field() {
		offerGenerationPO.clearOfferMailSubject();
	}

	@When("I clear Offer Mail Body field")
	public void i_clear_Offer_Mail_Body_field() {
		offerGenerationPO.clearOfferMailBody();
	}

	@When("I should see Send Mail button is disabled")
	public void i_should_see_Send_Mail_button_is_disabled() {
		Assert.assertTrue(offerGenerationPO.verifySendMailButtonDisabled(), "Send Mail button is not disabled");
	}

	@When("I attach Offer Letter of more than 5 MB size on Attach Offer Letter page")
	public void i_attach_Offer_Letter_of_more_than_5_MB_size_on_Attach_Offer_Letter_page() {
		offerGenerationPO.waitForUploadOfferLetterButton();
		offerGenerationPO.attachOfferLetterOnAttachOfferLetterPage("More than 5 MB");
	}

	@Then("I should see error message {string} on Attach Offer letter page")
	public void i_should_see_error_message_on_Attach_Offer_letter_page(String errorMessage) {
		Assert.assertTrue(offerGenerationPO.verifyErrorMessageOnAttachOfferLetterPage(errorMessage),
				"Offer Letter of greater than 5 MB is getting attached.");
	}

	@SuppressWarnings("static-access")
	@When("I fill Offer Mail subject field")
	public void i_fill_Offer_Mail_subject_field() {
		offerGenerationPO.fillOfferMailSubject(genericFunctions.generateRandomStrings(10, "Alphanumeric"));
	}

	@SuppressWarnings("static-access")
	@When("I fill Offer Mail Body field")
	public void i_fill_Offer_Mail_Body_field() {
		offerGenerationPO.fillOfferMailBody(genericFunctions.generateRandomStrings(100, "Alphanumeric"));
	}

	@SuppressWarnings("static-access")
	@When("I click \"([^\"]*)\" link and enter template name")
	public void i_click_Save_Template_link_and_enter_template_name(String link) {
		genericFunctions.clickLinkUsingText(link);
		offerGenerationPO.enterOfferMailTemplateName(genericFunctions.generateRandomStrings(8, "Alphanumeric"));
	}

	@When("I click Send Mail button on Attach Offer Letter")
	public void i_click_Send_Mail_button_on_Attach_Offer_Letter() {
		Assert.assertTrue(offerGenerationPO.verifySendMailButtonIsEnabled(), "Send Mail button is disabled.");
		offerGenerationPO.clickSendMailOnAttachOfferLetter();
	}

	@When("I should see new Offer Template created on Manage Email Templates page")
	public void i_should_see_new_Offer_Template_created_on_Manage_Email_Templates_page() {
		offerGenerationPO.searchOfferLetterTemplate();
		Assert.assertTrue(offerGenerationPO.verifyOfferLetterTemplateOnSearchResult(),
				"Offer Letter Template not created");
	}

	@Then("I should see Attach Offer Details section is disabled")
	public void i_should_see_Attach_Offer_Details_section_is_diabled() {
		Assert.assertTrue(offerGenerationPO.verifyDisabledAttachOfferLetterSection(),
				"Attach Offer Letter section is not disabled");
	}

	@Then("I should see \"([^\"]*)\" status text on CV Details page")
	public void i_should_see_status_text_on_CV_Details_page(String statusMsg) {
		Assert.assertTrue(offerGenerationPO.verifyOfferMailSentToCandidate(statusMsg),
				"Offer status is not : " + statusMsg);
	}

	@Then("I click SEND REMINDER Button")
	public void I_click_SEND_REMINDER_Button() {
		offerGenerationPO.clickSendReminderButton();
	}

	@Then("I should be able to see message \"([^\"]*)\" for reminder sent on CV Details Page")
	public void i_should_be_able_to_see_message_for_reminder_sent_on_CV_Details_Page(String msg) {
		Assert.assertTrue(offerGenerationPO.verifyReminderMessageSent(msg), "Offer not sent to the candidate");
	}

	@Then("I click Edit Offer button")
	public void i_click_Edit_Offer_button() {
                offerGenerationPO.clickOnOfferEllipsis();
		offerGenerationPO.clickEditOfferButton();
	}

	@Then("I should see \"([^\"]*)\" message on Offer page")
	public void I_should_see_message_on_Offer_page(String editOfferMsg) {
		Assert.assertTrue(offerGenerationPO.verifyEditOfferPage(editOfferMsg), "User not navigated to Edit Offer page");
	}

	@SuppressWarnings("static-access")
	@When("I update all the details for Offer Generation")
	public void i_update_all_the_details_for_Offer_Generation() {
		offerValidationPO.addOfferedDesignation(genericFunctions.generateRandomStrings(10, "String"));
		offerValidationPO.addCandidatesJoiningSalary(genericFunctions.generateRandomStrings(6, "Number"));
		offerValidationPO.selectDateInCalendar("Offered on", 1);
		offerValidationPO.selectDateInCalendar(" tentative joining date", 10);
		offerValidationPO.saveValuesEnteredInDateFields();
	}

	@Then("I should see updated Offered details on CV Details page")
	public void I_should_see_updated_Offered_details_on_CV_Details_page() {
		Assert.assertTrue(offerGenerationPO.verifyOfferedDesignationOnCVDetails(), "Offered Designation not updated");
		Assert.assertTrue(offerGenerationPO.verifySalaryOnCVDetails(), "Salary is not updated");
	}

	@Then("I click \"([^\"]*)\" button on Attach Offer Letter page")
	public void I_click_button_on_Attach_Offer_Letter_page(String buttonTxt) {
		genericFunctions.clickLinkUsingText(buttonTxt);
	}

	@Then("I should see Mail Subject and Mail Body in the preview")
	public void I_should_see_Mail_Subject_and_Mail_Body_in_the_preview() {
		Assert.assertTrue(offerGenerationPO.verifySubjectInPreviewMail(),
				"Subject entered is not displayed on Offer Preview");
		Assert.assertTrue(offerGenerationPO.verifyOfferBodyInPreviewMail(),
				"Offer Mail Body entered is not displayed on Offer Preview");
	}

	@When("I click on second stage of offer")
	public void clickSecondStageOfOffer() {
		offerGenerationPO.clickSecondStageOfOffer();
	}

	@Then("Attach Offer Letter should not be displayed")
	public void attachOfferLetterNotDisplayed() {
		Assert.assertFalse(offerGenerationPO.verifyattachOfferLetterSectionDisplayed(),
				"attach offer letter is displayed even in untagged stage");
	}

	@When("I click on first stage of offer")
	public void clickFirstStageOfOffer() {
		offerGenerationPO.clickFirstStageOfOffer();
	}

	@When("click on {string} on offer details page")
	public void clickIncludeSignature(String includeSignature) {
		offerGenerationPO.clickIncludeSignature(includeSignature);
	}

	@Then("I should see signature in the preview")
	public void signatureInOfferPreview() {
		Assert.assertTrue(offerGenerationPO.signatureInOfferPreview(), "signature in offer preview is not displayed");
	}

	@Then("I should see \"([^\"]*)\" status text in offer timeline")
	public void i_should_see_status_text_in_Offer_Timeline(String statusMsg) {
		Assert.assertTrue(offerGenerationPO.verifyOfferStatusInOfferTimeline(statusMsg),
				"Offer status in offer timeline is not : " + statusMsg);
	}

	@When("click on {string} on attach offer page")
	public void prefillFromTemplateDD(String prefillFromOffer) {
		offerGenerationPO.clickPrefillFromOfferDD(prefillFromOffer);
	}

	@When("select email template name")
	public void selectEmailTemplateName() {
		offerGenerationPO.selectEmailTemplate();
	}

	@Then("verify mail body and mail subject on offer mail page")
	public void verifyMailBodySubjOnOfferMailPage() {
		offerGenerationPO.verifyMailBodyAndSubjectFromPrefilltemplate();
	}

	@When("I change currency dropdown to {string}")
	public void changeCurrencyDropdownValue(String currencyDDValue) {
		offerGenerationPO.changeCurrencyDropdownValue(currencyDDValue);
	}

	@Then("I should see {string} in {string} in Offer Details section")
	public void i_should_see_symbol_in_Offer_Details_section(String currencySymbol, String offerFieldLabel) {
		Assert.assertTrue(offerGenerationPO.verifySymbolInOfferDetailsSection(currencySymbol, offerFieldLabel),
				"'" + currencySymbol + "' symbol is not present in offer field: " + offerFieldLabel);
	}

	@Then("I should see {string} in {string} in Offer status section")
	public void i_should_see_symbol_in_Offer_Status_section(String currencySymbol, String offerFieldLabel) {
		Assert.assertTrue(offerGenerationPO.verifySymbolInOfferStatusSection(currencySymbol, offerFieldLabel),
				"'" + currencySymbol + "' symbol is not present in offer field: " + offerFieldLabel);
	}

	@And("I save previous offer details")
	public void I_save_previous_offer_details() {
		offerGenerationPO.savePreviousOfferDetailsInPropertyFile();
	}

	@And("I click {string} down arrow	on CV Details page")
	public void I_click_down_arrow_on_CV_Details_page(String strText) {
		offerGenerationPO.clickDownArrowInOfferSectionOnCVDetails(strText);
	}

	@Then("I should see previous offer details in Offer Details section")
	public void I_should_see_previous_offer_details_in_Offer_Details_section() {
		Assert.assertTrue(offerGenerationPO.verifyPreviousOfferDetailsInOfferDetails(),
				"Previous Offer Details not matching");
	}

	@When("click on skip attach offer letter")
	public void clickSkipAttachOfferLetter()
	{
		offerGenerationPO.clickSkipAttachOfferLetter();
	}
	@Then("I should see updated Offered details on offer strip")
	public void updatedOfferDetailsOnOfferStrip()
	{
		Assert.assertTrue(offerGenerationPO.verifyDesignationCVDetailsOnOfferStrip(), "Offered Designation not updated");
		Assert.assertTrue(offerGenerationPO.verifySalaryOnCVDetailsOfferStrip(), "Salary is not updated");
	}
	@Then("attach offer letter should not be displayed on the offer details page for untagged stage")
	public void attachOfferLetterNotDisplayedForUnTaggedStage()
	{
		Assert.assertFalse(offerGenerationPO.verifyAttachOfferLetterNotDisplayed(),"Attach offer letter not displayed in untagged stage");
	}
	@Then("verify offer status of candidate should be changed to {string}")
	public void verifyOfferStatus(String offerStatus)
	{
		Assert.assertTrue(offerGenerationPO.verifyOfferStatusofCandidate(offerStatus),"offer status is not changed to mailed");
	}
}
