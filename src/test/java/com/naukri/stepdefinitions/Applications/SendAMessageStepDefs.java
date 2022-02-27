package com.naukri.stepdefinitions.Applications;


import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.SendAMessagePagePO;
import com.naukri.pageobjects.Applications.SendAMessagePagePO.PreviewMessagePagePO;
import com.naukri.stepdefinitions.CandidateCommunication.MailBoxStepDef;
import com.naukri.stepdefinitions.VendorPlatform.VideoInterviewStepDef;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendAMessageStepDefs extends BaseAutomation{

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	SendAMessagePagePO sendMessage = (SendAMessagePagePO) PageObjectWrapper.getObject(SendAMessagePagePO.class);
	PreviewMessagePagePO previewMessage = (PreviewMessagePagePO) PageObjectWrapper.getInnerClassObject(SendAMessagePagePO.class, PreviewMessagePagePO.class);
	public static HashMap<String, String>hmapReturnData=new HashMap<String,String>();
	@When("User hover on the Email option on top panel of the inbox")
	public void user_hover_on_the_Email_option_on_top_panel_of_the_inbox() {
		sendMessage.hoverOnEmailButton();
	}

	@Then("User should be able to see the Message option in the hover list")
	public void user_should_be_able_to_see_the_Message_option_in_the_hover_list() {
		Assert.assertTrue(sendMessage.presenceOfMessageOption(),
				"The message option is not present in the mail drop down");
	}

	@When("I am on CV details page for the first candidate")
	public void i_am_on_CV_details_page_for_the_first_candidate() {
		sendMessage.clickOnFirstCandidate();
	}

	@When("I hover on the Email option on top panel of the CV details page")
	public void i_hover_on_the_Email_option_on_top_panel_of_the_CV_details_page() {
		sendMessage.hoverOnEmailFromCVDetailsPage();
	}

	@Then("User should be able to see the Message option in the hover list on CV details page")
	public void i_should_be_able_to_see_the_Message_option_in_the_hover_list_on_CV_details_page() {
		Assert.assertTrue(sendMessage.presenceOfMessageOptionOnCVDetailsPage(),
				"The message option is not visible on the CV details page");
	}

	@When("User select the first candidate checkbox")
	public void user_select_the_first_candidate_checkbox() {
		sendMessage.selectFirstCandidateCheckbox();
	}

	@When("User click on Message option")
	public void user_click_on_Message_option() {
		sendMessage.clickMessageOptionOnInbox();
	}

	@Then("I should be redirected to the message layout page containing fields Reply To, Cc, Mail a copy to me, Prefill from Template, Subject, Include signature, Requested documents, Attached, Mail body, Preview and send mail")
	public void i_should_be_redirected_to_the_message_layout_page_containing_fields_Reply_To_Cc_Mail_a_copy_to_me_Prefill_from_Template_Subject_Include_signature_Requested_documents_Attached_Mail_body_Preview_and_send_mail() {
		// sendMessage.validatePresenceOfElementsOnMailTemplate();
		sendMessage.validatePresenceOfElementsOnMailTemplate();
	}

	@When("User click on Message option on CV Details Page")
	public void i_click_on_Message_option_on_CV_Details_Page() {
		sendMessage.clickMessageOptionOnCvDetailsPage();
	}

	@Then("I should be able to see the error message {string}")
	public void i_should_be_able_to_see_the_error_message(String errorMessage) {
		Assert.assertTrue(sendMessage.checkNoCandidateSelectedErrorMessage(errorMessage),
				"The error message for no profile selected is not visible");
		TestNGLogUtility.pass("Error Message is visible");
	}

	@Then("I should be able to see the {string}")
	public void i_should_be_able_to_see_the(String prefillLabelText) {
		Assert.assertTrue(sendMessage.verifyPrefillTemplatePresence(), "Prefill from Templates is not present");
	}

	@Then("I should be able to see the list of the templates available")
	public void i_should_be_able_to_see_the_list_of_the_templates_available() {
		Assert.assertTrue(sendMessage.sizeOfPrefillFromTemplates(), "The prefill from templates list is empty");
	}

	@When("I click on {string}")
	public void i_click_on(String buttonText) {
		sendMessage.clickButtonOnMessageFooter(buttonText);
	}

	@Then("I should be able to see the error message below the mail subject line")
	public void i_should_be_able_to_see_the_error_message_below_the_mail_subject_line() {
		Assert.assertTrue(sendMessage.presenceOfSubjectErrorMessageAndText(), 
				"The subject error message is not visible");
	}

	@Then("I should see error text as {string}")
	public void i_should_see_error_text_as(String actualErrorTextMessage) {
		sendMessage.errorTextMessage(actualErrorTextMessage);
	}
	
	@When("I fill in the CC field with text {string}")
	public void i_fill_in_the_CC_field_with_text(String ccTextInput) {
		sendMessage.fillInCCField(ccTextInput);
	}

	@Then("I should be able to the invalid email address error {string}")
	public void i_should_be_able_to_the_invalid_email_address_error(String ccErrorMessage) {
		sendMessage.checkTheCCErrorText(ccErrorMessage);
	}
	
	@When("I fill in the subject field")
	public void i_fill_in_the_subject_field() {
		sendMessage.fillMailSubject();
	}

	@When("I fill in the body field")
	public void i_fill_in_the_body_field() {
		sendMessage.fillMailBody();
	}
	
	@When("I click on the option Save Template")
	public void i_click_on_the_option_Save_Template() {
	   sendMessage.clickOnSaveTemplateButton();
	}

	@Then("I should be able to see the text box with the placeholder {string}")
	public void i_should_be_able_to_see_the_text_box_with_the_placeholder(String placeholder) {
		sendMessage.presenceSaveTemplateField(placeholder);
	}

	@When("I type the name of the template in the text box")
	public void i_type_the_name_of_the_template_in_the_text_box() {
		sendMessage.fillTemplateName();
	}

	@When("I navigate to template listing page")
	public void i_navigate_to_template_listing_page() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.templateListingPage"));
	}

	@Then("I should be able to see the template name created from the message window")
	public void i_should_be_able_to_see_the_template_name_created_from_the_message_window() {
		Assert.assertTrue(sendMessage.checkVisibilityOfTemplateOnTemplateListingPage(),
				"The template created is not visible on the template listing page");
	}
	
	@Then("I should be able to see the success ribbon with a message as {string}")
	public void i_should_be_able_to_see_the_success_ribbon_with_a_message_as(String successMessage) {
		Assert.assertTrue(sendMessage.messageSentSuccessMessagePresence(successMessage), 
				"The success message is not visible");
	}
	
	@When("I click on Back Arrow")
	public void i_click_on_Back_Arrow() {
		sendMessage.clickBackArrowButton();
	}

	@Then("I should not be able to see the success ribbon with a message as {string}")
	public void i_should_not_be_able_to_see_the_success_ribbon_with_a_message_as(String successMessage) {
		Assert.assertTrue(!sendMessage.messageSentSuccessMessagePresence(successMessage), 
				"The success message is visible");
	}
	
	@Then("I should be able to see the message body and message subject on preview layout")
	public void i_should_be_able_to_see_the_message_body_and_message_subject_on_preview_layout() {
		previewMessage.verifySubjectAndBodyOnPreview();
	}

	@Then("I should be able to see the {string} and {string} buttons on the layout footer")
	public void i_should_be_able_to_see_the_and_buttons_on_the_layout_footer(String buttonOne, String buttonTwo) {
		Assert.assertTrue(previewMessage.verifyThePresenceOfButtonsOnPreview(), 
				"The buttons are not visible on footer");
	}

	@When("I click on {string} button")
	public void i_click_on_button(String btnText) {
	  previewMessage.previewSendMail(btnText);
	}
	
	@Then("I should be able to see DD with text tags")
	public void i_should_be_able_to_see_DD_with_text_tags() {
	    Assert.assertTrue(sendMessage.verifyPresenceOfTagsDD(), 
	    		"Tags DD is not visible for message lighbox under send a message a flow");
	}

	@When("I click on tags DD")
	public void i_click_on_tags_DD() {
	    sendMessage.clickTagsDD();
	}

	@Then("I should be able to see {string} group text")
	public void i_should_be_able_to_see_group_text(String groupName) {
	   Assert.assertTrue(sendMessage.verifyPresenceOfGroupText(groupName), 
			   "Group name " + groupName + " is not visible under tags DD");
	}

	@When("I click on {string} group text")
	public void i_click_on_group_text(String groupName) {
	    sendMessage.clickGroupText(groupName);
	}

	@Then("I should be able to see list of {string} tags")
	public void i_should_be_able_to_see_list_of_tags(String groupName) {
	   Assert.assertTrue(sendMessage.compareTagList(groupName), 
			   "Tags against " + groupName + " aren't visible under tags DD");
	}


	@And("I go to requirement which has atleast one application")
	public void iGoToRequirementWhichHasAtleastOneApplication() {
		sendMessage.clickOnRequirementListingCount();
	}

	@When("User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment")
	public void user_send_email_with_MailTo_Mail_CC_Mail_Subject_Mail_Body_and_Mail_Attachment(io.cucumber.datatable.DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (Map<String, String> data : list) {
			hmapReturnData=sendMessage.sendEmail(data);
			VideoInterviewStepDef.mailSubject=hmapReturnData.get("MailSubject");
			MailBoxStepDef.mailSubject=hmapReturnData.get("MailSubject");
			hmapReturnData.forEach((k, v) -> {TestNGLogUtility.info(k + ": " + v);});
		}
		TestNGLogUtility.info("The mail send successfully.........");
	}

}
