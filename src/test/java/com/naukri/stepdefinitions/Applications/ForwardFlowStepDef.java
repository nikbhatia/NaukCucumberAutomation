package com.naukri.stepdefinitions.Applications;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.MySQLConnector;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.ForwardFlowPagePO;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.stepdefinitions.Requirements.RequirementCreationStepDef;
import com.naukri.stepdefinitions.Settings.addNewTrackerStepDef;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ForwardFlowStepDef {

	InboxPagePO inboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
	ForwardFlowPagePO forwardflowPagePO = (ForwardFlowPagePO) PageObjectWrapper.getObject(ForwardFlowPagePO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	MySQLConnector mysql = (MySQLConnector) PageObjectWrapper.getObject(MySQLConnector.class);
	SoftAssert softAssert = new SoftAssert();

	// variables
	String productPageUrl = "new-rms-to-resdex-cv-transfer-policy";

	@Then("I should be able to see the forward option")
	public void i_should_be_able_to_see_the_forward_option() {
		Assert.assertTrue(inboxPagePO.presenceOfForwardOption(), "The forward option is not visible for the inbox");
	}

	@When("I click on the forward option")
	public void i_click_on_the_forward_option() {
		inboxPagePO.clickFirstCandidate();
		inboxPagePO.clickForwardOption();
	}

	@When("I click on the forward option for requirement inbox")
	public void i_click_on_the_forward_option_for_requirement_inbox() {
		inboxPagePO.clickFirstCandidate();
		inboxPagePO.clickForwardOnRequirementInbox();
	}

	@Then("User should be redirected to the forward lightbox")
	public void i_should_be_redirected_to_the_forward_lightbox() {
		Assert.assertTrue(forwardflowPagePO.verifyForwardLightboxTitle(), "The forward lightbox title is not visible");
	}

	@When("I click on view quota policy link")
	public void i_click_on_view_quota_policy_link() {
		forwardflowPagePO.clickOnViewQuotaPolicyLink();
	}

	@Then("I should be redirected to product promotion page")
	public void i_should_be_redirected_to_product_promotion_page() {
		genericFunctions.switchToWindow();
		Assert.assertTrue(forwardflowPagePO.verifyCurrentPageUrl(productPageUrl),
				"The redirection to the product promotion page has not happened.");
	}

	@Then("I should be able to see {string} on forward layout")
	public void i_should_be_able_to_see_on_forward_layout(String quotaPolicyTextDesc) {
		Assert.assertTrue(forwardflowPagePO.verifyTheTextOfQuotaPolicy(quotaPolicyTextDesc),
				"Text description of quota policy is either not visible or is not as expected");
	}

	@Then("I should be able to see {string} on forward as hyperlink")
	public void i_should_be_able_to_see_on_forward_as_hyperlink(String quotaPolicyHyperlinkDesc) {
		Assert.assertTrue(forwardflowPagePO.verifyTheTextOfQuotaLinkPolicy(quotaPolicyHyperlinkDesc),
				"Link description of quota policy is either not visible or is not as expected");
	}

	@Then("I should be able to see {string} on product promotion page")
	public void i_should_be_able_to_see_on_product_promotion_page(String firstHeadingOnProductPromotionPage) {
		Assert.assertTrue(forwardflowPagePO.verifyPresenceOfHeading(firstHeadingOnProductPromotionPage),
				"Heading description of quota policy is either not visible or is not as expected");
	}

	@When("I read all the list of template")
	public void i_read_all_the_list_of_template() {
		forwardflowPagePO.addForwardTemplateNameToListFromLightbox();
	}

	@When("I navigate to mail template listing page")
	public void i_navigate_to_mail_template_listing_page() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.mailTemplateListingPage"));
	}

	@When("I select Forward option from the drop down")
	public void i_select_Forward_option_from_the_drop_down() {
		forwardflowPagePO.selectForwardForDownload();
	}

	@When("I read the list of the mail templates")
	public void i_read_the_list_of_the_mail_templates() {
		forwardflowPagePO.readForwardTemplateFromMailTemplateListingPage();
	}

	@Then("I should be able to see the same list when which was present on lightbox.")
	public void i_should_be_able_to_see_the_same_list_when_which_was_present_on_lightbox() {
		Assert.assertTrue(
				forwardflowPagePO.compareTemplateList(forwardflowPagePO.listOfForwardTemplatesName,
						forwardflowPagePO.listOfForwardTemplateNamesFromSettingsPage),
				"Forward Template list available on lightbox and under template listing is not same");
	}

	@Then("I should be able to see {string} under to fiedl")
	public void i_should_be_able_to_see_under_to_fiedl(String dmarcPolicyData) {
		Assert.assertTrue(forwardflowPagePO.presenceOfDmarcNoticePage(dmarcPolicyData),
				"DMARC notice policy is not visible");
	}

	@Then("I should be able to see {string} label with input field.")
	public void i_should_be_ablet_to_see_label_with_input_field(String labelTextInput) {
		Assert.assertTrue(forwardflowPagePO.verifyUIOfForwardTemplate(labelTextInput), 
				"Labels and fields of the label aren't visible");
	}
	
	@When("User click on Send button")
	public void user_click_on_Send_button() {
	    forwardflowPagePO.clickSendForwardMailButton();
	}

	@Then("I should be able to validation error under the {string} field")
	public void i_should_be_able_to_validation_error_under_the_field(String fieldDescriptor) {
		String stringOutputFromValidationFunction = forwardflowPagePO.checkForValidationErrorMessage(fieldDescriptor);
		Assert.assertTrue(Boolean.parseBoolean(stringOutputFromValidationFunction.replace(fieldDescriptor, "")), 
				stringOutputFromValidationFunction.replace(stringOutputFromValidationFunction.replace(fieldDescriptor, ""), "")+" is not displayed");
	}

	@When("I click on {string} button for editor")
	public void i_click_on_button_for_editor(String buttonText) {
		forwardflowPagePO.clickOnTextEditingButtons(buttonText);
	}
	
	@Then("I should see {string} selected in DOM for the button")
	public void i_should_see_selected_in_DOM_for_the_button(String attributeValue) {
		 forwardflowPagePO.getAttributeOfButton(attributeValue);
	}
	
	@Then("I should be able to see the {string} for {string} field")
	public void i_should_be_able_to_see_the_for_field(String tagSegment, String forwardDiv) {
		softAssert.assertTrue(Boolean.parseBoolean(forwardflowPagePO.verifyTheTagList(tagSegment, forwardDiv)), 
				"Tags for " + tagSegment + " on " + forwardDiv + " aren't visible");
		softAssert.assertAll();
	}
	
	@Then("I should be able to see the {string} for {string} field for consultant")
	public void i_should_be_able_to_see_the_for_field_for_consultant(String tagSegment, String forwardDiv) {
		softAssert.assertTrue(Boolean.parseBoolean(forwardflowPagePO.verifyTheTagListForConsultant(tagSegment, forwardDiv)), 
				"Tags for " + tagSegment + " on " + forwardDiv + " aren't visible");
		softAssert.assertAll();
	}
	
	@When("I select all applications")
	public void i_select_all_applications() {
	    inboxPagePO.selectAllProfiles();
	}

	@Then("I should be able to see {string} under {string}")
	public void i_should_be_able_to_see_under(String informationMessageText, String divLocator) {
	   Assert.assertTrue(forwardflowPagePO.checkPresenceOfMessageOfAbsenceOfTags(informationMessageText, divLocator), 
			   "Message for absence of tags under multiple selection of profile is not visible for " + divLocator);
	}

	@Then("I should not be able to {string} against {string}")
	public void i_should_not_be_able_to_against(String tagsName, String divLocator) {
	    Assert.assertTrue(!forwardflowPagePO.checkInvisibilityOfTag(divLocator), 
	    		"Tags are visible against " + divLocator);
	}
	
	@When("I click on choose template DD")
	public void i_click_on_choose_template_DD() {
	    forwardflowPagePO.clickChooseTemplateDD();
	}

	@When("I select the template that I created")
	public void i_select_the_template_that_I_created() {
		forwardflowPagePO.clickOnSpecificTemplate();
	}

	@Then("I should be able to see the template name created")
	public void i_should_be_able_to_see_the_template_name_created() {
		Assert.assertTrue(forwardflowPagePO.verifyTemplateNameSelectedIsDisplayed(), "Template Name selected is not displayed ");
		TestNGLogUtility.pass("Template Name is visible");
	}

	@Then("I should see the subject I entered")
	public void i_should_see_the_subject_I_entered() {
		Assert.assertTrue(forwardflowPagePO.verifySubjectText(), "Subject for the template is not visible");
		TestNGLogUtility.pass("Subject field of the forward message template is same as that while creating the template");
	}
	

	@Then("I should see the mail body I entered")
	public void i_should_see_the_mail_body_I_entered() {
	    Assert.assertTrue(forwardflowPagePO.verifyBodyText(), "Body for the template is not visible");
	    TestNGLogUtility.pass("Forward Mail Body is visible");
	}
	
	@When("I click on prefill from templates")
	public void i_click_on_prefill_from_templates() {
	   forwardflowPagePO.clickChooseTemplateDD();
	}

	@When("I select a template from list")
	public void i_select_a_template_from_list() {
		forwardflowPagePO.selectNMailTemplate(1);
	}

	@Then("I should see the subject field filled")
	public void i_should_see_the_subject_field_filled() {
		Assert.assertTrue(forwardflowPagePO.getMailSubject().length() > 0, "Subject not filled");
		TestNGLogUtility.pass("Subject field filled by selecting the template");
	}

	@Then("I should see the body field filled")
	public void i_should_see_the_body_field_filled() {
	   Assert.assertTrue(forwardflowPagePO.getMailBody().length() > 0, "Mail Body is not filled");
	   TestNGLogUtility.pass("Forward mail body field filled by selecting the template");
	}
	
	@Then("I should see the masking checkbox present on the forward template with message {string}")
	public void i_should_see_the_masking_checkbox_present_on_the_forward_template_with_message(String maskingDetailsLabel) {
		Assert.assertTrue(forwardflowPagePO.verifyThePresenceOfMaskDetail(maskingDetailsLabel), 
				"The masking details are not present on the forward lightbox");
		TestNGLogUtility.pass("The masking details are present on forward lightbox");
	}
	
	@When("I check the masking checkbox on the forward lightbox")
	public void i_check_the_masking_checkbox_on_the_forward_lightbox() {
		forwardflowPagePO.clickTheMaskingCheckbox();
	}

	@Then("I should be able to see the message as {string}")
	public void i_should_be_able_to_see_the_message_as(String messageForMasking) {
	    Assert.assertTrue(forwardflowPagePO.checkThePresenceOfWarningTextbox(messageForMasking), 
	    		"The masking warning message is not present");
	    TestNGLogUtility.pass("Warning message for Masking is present");
	}
	
	@When("I {string} the checkbox of Customize CV name when forwarding to client")
	public void i_the_checkbox_of_Customize_CV_name_when_forwarding_to_client(String stateOfCheckbox) {
		forwardflowPagePO.changeTheStateOfEditNameOfCV(stateOfCheckbox);
	}
	
	@Then("I should not be able to see the available name format list")
	public void i_should_not_be_able_to_see_the_available_name_format_list() {
	    Assert.assertTrue(!forwardflowPagePO.presenceOfListOfEditCVNameAvailable(), 
	    		"The edit cv names list is present for the unchecked checkbox");
	    TestNGLogUtility.pass("The DD for edit name is not present");
	}

	@Then("I should be able to see the available name format list of length {int}")
	public void i_should_be_able_to_see_the_available_name_format_list_of_length(Integer actualSize) {
		Assert.assertTrue(forwardflowPagePO.presenceOfListOfEditCVNameAvailable(), 
				"The edit cv names list is not present for the unchecked checkbox");
		TestNGLogUtility.pass("The DD for edit name is present");
		Assert.assertTrue(forwardflowPagePO.lengthOfEditCVNameList(actualSize), 
				"The list size doesn't match the expected size");
		TestNGLogUtility.pass("The size of the list present is equal to intended");
	}

	@Then("I should be able to see the list as {string}")
	public void i_should_be_able_to_see_the_list_as(String listOfOptionsAvailable) {
	  Assert.assertTrue(forwardflowPagePO.verifyTheListOfOptions(listOfOptionsAvailable), 
			  "The options list didn't match the expected list");
	  TestNGLogUtility.pass("The list content matched the actual options of list");
	}

	@When("User fills in to field as {string}")
	public void user_fills_in_to_field_as(String toEmailString) {
	    forwardflowPagePO.fillInToField(toEmailString);
	}

	@When("User fills in the forward mail subject as {string} in forward lightbox")
	public void user_fills_in_the_forward_mail_subject_as_in_forward_lightbox(String mailSubjectText) {
		forwardflowPagePO.fillInForwardSubject(mailSubjectText);
	}

	@When("User fills in the forward mail body as {string} in forward lightbox")
	public void user_fills_in_the_forward_mail_body_as_in_forward_lightbox(String mailBodyText) {
		forwardflowPagePO.fillMailBodyText(mailBodyText);
	}
	
	@When("User fills in to field as {string} for master profile forward")
	public void user_fills_in_to_field_as_for_master_profile_forward(String toEmailId) {
	    forwardflowPagePO.fillInToEmailForMasterProfileForward(toEmailId);
	}
	
	@When("User click on {string} option against {string}")
	public void User_click_on_option_against(String section, String againstSection) {
	    forwardflowPagePO.clickOnSectionOnTag(section,againstSection );
	}
	
	@Then("User should be able to see {string} tag in {string} section against {string}")
	public void User_should_be_able_to_see_tag_in_section_against(String fieldName, String section, String againstSection) {
	  Assert.assertTrue(forwardflowPagePO.verifyfieldTagInSection(section, fieldName, againstSection),
			  fieldName+" tag is not available in " + section +" section");
	  TestNGLogUtility.pass(fieldName+" tag is available in " + section +" section");
	}
	
	@When("User select the tracker created on forward lightbox")
	public void User_select_the_tracker_created_on_lightbox() {
	    forwardflowPagePO.selectTemplate(addNewTrackerStepDef.trackerName);
	}
	
	@Then("User should see the tracker fields along with the correct data should be visible")
	public void User_should_see_the_tracker_fields_along_with_the_correct_data_should_be_visible(DataTable dataTable) {
		List<String> AllColumns = dataTable.asList(String.class);
		for (String value : AllColumns) {
			Assert.assertTrue(forwardflowPagePO.verifyTrackerColumnsOnPreview(value),
					"Column value " + value + " on tacker preview is not displaying");
			TestNGLogUtility.pass("Column value " + value + " on tacker preview is displaying successfully");
		}
	}
	
	@Then("User should be able to see the new tracker name should be prefilled DD")
	public void User_should_be_able_to_see_the_new_tracker_name_should_be_prefilled_DD() {
		Assert.assertTrue(forwardflowPagePO.verifyCreatedTemplate(addNewTrackerStepDef.trackerName), "The forward option is not visible for the inbox");
	}
	
	@When("User click on close button on update password popup")
	public void User_click_on_close_button_on_update_password_popup() {
		forwardflowPagePO.cancelUpdatePassword();
	}
	
	@When("User click on {string} tag in {string} section against {string}")
	public void User_click_on_see_tag_in_section_against(String fieldName, String section, String againstSection) {
	 forwardflowPagePO.clickTagInSection(section, fieldName, againstSection);
	}
	
	@Then("User should be able to see variable value on mailbody")
	public void User_should_be_able_to_see_variable_value_on_mailbody() {
		Assert.assertTrue(forwardflowPagePO.verifyVariableValueOnMail(RequirementCreationStepDef.variablePercent), "Correct variable value is not bring dispaying on email body");
		TestNGLogUtility.info("Correct variable value is bring dispaying on email body");
	}
	
	@When("User selects a file as an attachment")
	public void user_selects_a_file_as_an_attachment() {
	    forwardflowPagePO.addFileForAttachmentInForwardLightbox();
	}

	@Then("User should be able to see the name of file on forward lightbox")
	public void user_should_be_able_to_see_the_name_of_file_on_forward_lightbox() {
	    Assert.assertTrue(forwardflowPagePO.checkThePresenceOfNameOfFileAttached(), 
	    		"Attached file name is not displayed");
	    TestNGLogUtility.pass("Attached filename is displayed");
	}

	@When("User deletes the attached file from forward lightbox")
	public void user_deletes_the_attached_file_from_forward_lightbox() {
	    forwardflowPagePO.deleteDocumentAttached();
	}

	@Then("User should not be able to see the name of file on forward lightbox")
	public void user_should_not_be_able_to_see_the_name_of_file_on_forward_lightbox() {
		Assert.assertTrue(!forwardflowPagePO.checkThePresenceOfNameOfFileAttached(), 
	    		"Attached file name is displayed");
	    TestNGLogUtility.pass("Attached filename is not displayed");
	}
	
	@When("User clicks on preview button of forward lightbox")
	public void user_clicks_on_preview_button_of_forward_lightbox() {
	  forwardflowPagePO.clickOnPreviewButtonForForward();
	}

	@Then("User should be able to see {string} and forward mail subject entered")
	public void user_should_be_able_to_see_and_forward_mail_subject_entered(String subjectKey) {
	    Assert.assertTrue(forwardflowPagePO.verifyThePresenceOfSubjectKey(subjectKey), 
	    		subjectKey + ForwardFlowPagePO.subject + " is not displayed");
	    TestNGLogUtility.pass(subjectKey + ForwardFlowPagePO.subject + " is displayed");
	}

	@Then("User should be able to see forward mail body entered")
	public void user_should_be_able_to_see_forward_mail_body_entered() {
	    Assert.assertTrue(forwardflowPagePO.verifyTheContentOfBody(), 
	    		ForwardFlowPagePO.messageBody + " is not visible");
	    TestNGLogUtility.pass(ForwardFlowPagePO.messageBody + " is visible");
	}

	@When("User clicks on {string} on preview of forward lightbox")
	public void user_clicks_on_on_preview_of_forward_lightbox(String footerActionButtonText) {
	    forwardflowPagePO.selectTheFooterActionOnPreview(footerActionButtonText);
	}

	@When("User selects the template created with excel tracker forward")
	public void user_selects_the_template_created_with_excel_tracker_forward() {
	    forwardflowPagePO.selectTemplateCreated();
	}

	@Then("User should be able to see the excel tracker attached on forward template")
	public void user_should_be_able_to_see_the_excel_tracker_attached_on_forward_template() {
		Assert.assertTrue(forwardflowPagePO.checkThePrefillOfExcelTrackerOnForward(), 
				"The excel tracker is not as same that while creating the template");
		TestNGLogUtility.pass("The excel tracker is as same that while creating the template");
	}
	
	@Then("User should be able to see the error message as {string} under the to field")
	public void user_should_be_able_to_see_the_error_message_as_under_the_to_field(String errorText) {
	    Assert.assertTrue(forwardflowPagePO.verifyThePresenceOfErrorText(errorText), 
	    		errorText+ " is not visible under to field");
	    TestNGLogUtility.pass(errorText+ " is visible under to field");
	}
	
	@When("User clicks on Add Cc")
	public void user_clicks_on_Add_Cc() {
	   forwardflowPagePO.clickOnAddCC();
	}

	@Then("User should be able to see the cc field")
	public void user_should_be_able_to_see_the_cc_field() {
	    Assert.assertTrue(forwardflowPagePO.verifyThePresenceCCTextField(), 
	    		"CC field is not visible on the forward lightbox");
	    TestNGLogUtility.pass("CC field is visible on the forward lightbox");
	}

	@When("User fills in CC field as {string}")
	public void user_fills_in_CC_field_as(String ccTextAddress) {
	    forwardflowPagePO.fillInCCText(ccTextAddress);
	}

	@Then("User should be able to see the error message as {string} under the cc field")
	public void user_should_be_able_to_see_the_error_message_as_under_the_cc_field(String expectedErrorMessage) {
	    Assert.assertTrue(forwardflowPagePO.verifyTheErrorMessageUnderTheCCField(expectedErrorMessage), 
	    		expectedErrorMessage+ " is not visible under the CC field");
	    TestNGLogUtility.pass(expectedErrorMessage+ " is visible under the CC field");
	}
	
	@Then("User should be able to see the Senders Name text field")
	public void user_should_be_able_to_see_the_Senders_Name_text_field() {
	    Assert.assertTrue(forwardflowPagePO.verifyThePresenceOfSenderName(), 
	    		"Sender Name is not visible on forward lightbox");
	    TestNGLogUtility.pass("Sender Name is visible on forward lightbox");
	}

	@Then("User should be able to see prefiled text")
	public void user_should_be_able_to_see_prefiled_text() {
	    Assert.assertTrue(forwardflowPagePO.verifyPrefilledSenderName(), 
	    		"The senders name on the forward lightbox is not prefiled");
	    TestNGLogUtility.pass("The senders name on the forward lightbox is prefiled");
	}

	@When("User clears the text of Senders Name")
	public void user_clears_the_text_of_Senders_Name() {
	    forwardflowPagePO.clearTheSendersName();
	}
	
	@When("User fills the {string} of {int} characters in Senders Name field")
	public void user_fills_the_of_characters_in_Senders_Name_field(String textType, Integer textLength) {
	    forwardflowPagePO.fillInSendersName(textType, textLength);
	}
	
	@When("User should be able to see the preview button disabled on forward lightbox")
	public void user_should_be_able_to_see_the_preview_button_disabled_on_forward_lightbox() {
		Assert.assertTrue(forwardflowPagePO.checkTheDisabilityOfPreviewButton(), 
				"The forward lightbox preview button is not disabled");
		TestNGLogUtility.pass("The forward lightbox preview button is disabled");
	}
	
	@Then("User should also be able to see the signature read from the settings page")
	public void user_should_also_be_able_to_see_the_signature_read_from_the_settings_page() {
		Assert.assertTrue(forwardflowPagePO.verifyThePresenceOfSignature(), 
				"Recruiter Signature is not present in preview of forward flow");
		TestNGLogUtility.pass("Recruiter Signature is present in preview of forward flow");
	}
	
	@When("User clicks on the Include Signature checkbox of forward lightbox")
	public void userClicksOnTheIncludeSignatureCheckboxOfForwardLightbox() {
		forwardflowPagePO.clickOnIncludeSignature();
	}
	
	@When("User selects {string} from update status of profile on forward flow")
	public void user_selects_from_update_status_of_profile_on_forward_flow(String candidateStatus) {
	    forwardflowPagePO.selectStatusOfCandidateOnForward(candidateStatus);
	}
	
	@Then("User should be able to see the text {string} on forward lightbox template")
	public void user_should_be_able_to_see_the_text_on_forward_lightbox_template(String expectedTextString) {
	    Assert.assertTrue(forwardflowPagePO.verifyThePresenceOfStatusChangeOnUnmappedProfile(expectedTextString), 
	    				  expectedTextString + " is not visible");
	    TestNGLogUtility.pass(expectedTextString + " is visible");
	}
	
}

