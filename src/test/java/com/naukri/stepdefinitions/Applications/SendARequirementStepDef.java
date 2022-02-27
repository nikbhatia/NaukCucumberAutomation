package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.YamlReader;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.SendARequirementPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SendARequirementStepDef {
    
    SendARequirementPagePO sendRequirement = (SendARequirementPagePO) PageObjectWrapper
            .getObject(SendARequirementPagePO.class);
    GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    
    @Then("I should be able to see the Send A Requirement option in the hover list")
    public void i_should_be_able_to_see_the_Send_A_Requirement_option_in_the_hover_list() {
        Assert.assertTrue(sendRequirement.checkPresenceOfSendARequirementLink(),
                "The requirement link is not visible on the drop down on inbox page");
    }
    
    @Then("I should be able to see the Send A Requirement option in the hover list on CV details page")
    public void i_should_be_able_to_see_the_Send_A_Requirement_option_in_the_hover_list_on_CV_details_page() {
        Assert.assertTrue(sendRequirement.checkPresenceOfSendARequirementLinkOnCVDetailsPage(),
                "The requirement link is not visible on the drop down of CV Details Page");
    }
    
    @When("I click the send a requirement option in hover list")
    public void i_click_the_send_a_requirement_option_in_hover_list() {
        sendRequirement.clickSendARequirementOptionApplicationInbox();
    }
    
    @Then("I should be redirected to send a requirement lightbox")
    public void i_should_be_redirected_to_send_a_requirement_lightbox() {
        Assert.assertTrue(sendRequirement.checkVisibilityOfRequirementLightbox(), "[Assertion Fail]: Requirement light box is not display");
        TestNGLogUtility.pass("Requirement light box is display");
    }
    
    @When("I click on send a requirement option")
    public void i_click_on_send_a_requirement_option() {
        sendRequirement.clickOnSendARequirementOptionFromCVDetailsPage();
    }
    
    @Then("I see chose from template list not empty")
    public void i_see_chose_from_template_list_not_empty() {
        Assert.assertTrue(sendRequirement.checkSizeOfMailTemplateDD(),
                "The size of the requirement mail template on send a requirement lightbox is zero");
        TestNGLogUtility.pass("Requirement Template size on send a requirement lightbox is not zero");
    }
    
    @Given("I have the requriement mail templates from template listing page")
    public void i_have_the_requriement_mail_templates_from_template_listing_page() {
        genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.mailTemplateListingPage"));
        sendRequirement.populateRequirementMailTemplateListing();        
    }
    
    @Then("I should see all the templates listed as on template listing page")
    public void i_should_see_all_the_templates_listed_as_on_template_listing_page() {
        Assert.assertTrue(sendRequirement.verifyListOfRequirementTemplateList(sendRequirement.requirementMailTemplateListing,
                sendRequirement.requirementMailListTemplateLightbox),"[Assertion Fail]: Templates on manage template page and send requiremrnt are different");
        TestNGLogUtility.pass("Templates on manage template page and send requiremrnt are same");
    }
    
    @When("I clear the prefilled text in replyTo mail id")
    public void i_clear_the_prefilled_text_in_replyTo_mail_id() {
        sendRequirement.clearReplyToMailId();
    }
    
    @When("I add {string} as the text")
    public void i_add_as_the_text(String replyToMailId) {
        sendRequirement.addEmailToReplyToMailId(replyToMailId);
    }
    
    @Then("I should be able to see the error text {string}")
    public void i_should_be_able_to_see_the_error_text(String errorMessage) {
        sendRequirement.clickOnSendMailButton();
        Assert.assertTrue(sendRequirement.checkForErrorMessage(errorMessage),
                "The sender email error message is not visible");
    }
    
    @When("I type in the mail body {string}")
    public void i_type_in_the_mail_body(String mailBodyText) {
        sendRequirement.fillMailBody(mailBodyText);
    }
    
    @When("I click on {string} button on sendRequirement")
    public void i_click_on_button_on_sendRequirement(String buttonText) {
        sendRequirement.clickButtonOnLightboxFooter(buttonText);
    }
    
    @Then("I should be able to see {string} under the mail subject")
    public void i_should_be_able_to_see_under_the_mail_subject(String subjectErrorMessage) {
        Assert.assertTrue(sendRequirement.mailSubjectErrorMessage(subjectErrorMessage),
                "The subject message errora is either not visible or not correct");
    }
    
    @When("I type in the mail subject {string}")
    public void i_type_in_the_mail_subject(String mailSubjectText) {
        sendRequirement.addMailSubjectMessage(mailSubjectText);
    }
    
    @Then("I should be able to see {string} under the mail body")
    public void i_should_be_able_to_see_under_the_mail_body(String mailBodyErrorText) {
        Assert.assertTrue(sendRequirement.mailBodyErrorMessage(mailBodyErrorText),
                "The subject body error is either not visible or not correct");
    }
    
    @Then("I should be able to see the {string} and checkbox")
    public void i_should_be_able_to_see_the_and_checkbox(String textOfLabelToBeVisible) {
        Assert.assertTrue(sendRequirement.checkThePresenceOfSendACopyOnRequirementLightbox(textOfLabelToBeVisible),
                "Send copy of this mail is visible on send a requirement lightbox");
    }
    
    @When("I check the checkbox preceding {string}")
    public void i_check_the_checkbox_preceding(String labelText) {
        sendRequirement.checkSendACopyOfThisMailCheckbox();
    }
    
    @Then("I should be able to see the label {string} and checkbox")
    public void i_should_be_able_to_see_the_label_and_checkbox(String labelText) {
        sendRequirement.checkThePresenceOfSendMeACopyOnRequirementLightbox(labelText);
    }
    
    @Then("I should be able to see the text field with placeholder text {string}")
    public void i_should_be_able_to_see_the_text_field_with_placeholder_text(String placeholderOfTheField) {
        Assert.assertTrue(sendRequirement.checkThePresenceOfFieldForAdditionalCCAddress(placeholderOfTheField),
                "CC additional email field is not visible");
    }
    
    @When("I type {string} in the cc field")
    public void i_type_in_the_cc_field(String ccMailAddress) {
        sendRequirement.fillTheCCField(ccMailAddress);
    }
    
    @Then("I should be able to see the {string} as error message")
    public void i_should_be_able_to_see_the_as_error_message(String errorMessageOnCCValidation) {
        Assert.assertTrue(sendRequirement.checkForTheValidationOfCCMessage(errorMessageOnCCValidation),
                "The error message for CC is not available");
        TestNGLogUtility.pass("Error message for improper email id is visible");
    }
    
    @When("I select the first requirement in the requirement drop down")
    public void i_select_the_first_requirement_in_the_requirement_drop_down() {
        sendRequirement.clickRequirementDD();
        sendRequirement.selectFirstRequirementFromDD();
    }
    
    @When("I check Save this as a new template checkbox")
    public void i_check_Save_this_as_a_new_template_checkbox() {
        sendRequirement.checkSaveThisAsANewTemplate();
    }
    
    @Then("I should be able to see the template name text field")
    public void i_should_be_able_to_see_the_template_name_text_field() {
        Assert.assertTrue(sendRequirement.checkPresenceOfSaveThisAsNewTemplate(),
                "The input field for saving the template name is not available");
    }
    
    @When("I type in the template name {string}")
    public void i_type_in_the_template_name(String templateNameBase) {
        System.out.println("Test " + templateNameBase);
        if (templateNameBase.contains("@#$%^&*") || templateNameBase.equals("")) {
            sendRequirement.typeTheTemplateName(templateNameBase);
        } else if (templateNameBase.equals("previous used")) {
            sendRequirement.typeTheTemplateName(sendRequirement.requirementTemplateName);
        } else {
            String requirementTemplateNameStepDef = templateNameBase.concat(Long.toString(System.currentTimeMillis()));
            sendRequirement.typeTheTemplateName(requirementTemplateNameStepDef);
        }
    }
    
    @Then("I should be able to see the template name created from the send a requirement window")
    public void i_should_be_able_to_see_the_template_name_created_from_the_send_a_requirement_window() {
        sendRequirement.setToRequirementTemplate();
        Assert.assertTrue(
                sendRequirement.verifyThePresenceOfRequirementTemplateName(sendRequirement.requirementTemplateName),
                "The requirement template created is not visible");
    }
    
    @Then("I should be able to see {string} as error message under template name input box")
    public void i_should_be_able_to_see_as_error_message_under_template_name_input_box(String emptyTemplateNameErrorMessage) {
        Assert.assertTrue(sendRequirement.verifyTheErrorMessageForTemplateName(emptyTemplateNameErrorMessage),
                "The error message for null template name is not visible");
    }
    
    @When("I select the requirement tab")
    public void i_select_the_requirement_tab() {
        sendRequirement.setToRequirementTemplate();
    }
    
    @When("I read the first requirement title")
    public void i_read_the_first_requirement_title() {
        sendRequirement.readFirstRequirementTemplateName();
    }
    
    @Then("I should be able to see {string} on application inbox")
    public void i_should_be_able_to_see_on_application_inbox(String successMessageText) {
        Assert.assertTrue(sendRequirement.verifyThePresenceOfSuccessMessage(successMessageText),
                "Success Message after sending a requirement is not visible");
    }
    
    @Then("I should be able to see {string}")
    public void i_should_be_able_to_see(String previewLayoutHeaderDiv) {
        Assert.assertTrue(sendRequirement.verifyThePresenceOfMailDivLayout(previewLayoutHeaderDiv),
                "The preview layout is visible");
    }
    
    @Then("I should be able to see {string} on application inbox page")
    public void i_should_be_able_to_see_on_application_inbox_page(String stringText) {
        Assert.assertTrue(sendRequirement.getApplicationHeadText(stringText),
                "All applications is not visible");
    }
    
    @Then("I should be able to see the reply to field as disabled")
    public void i_should_be_able_to_see_the_reply_to_field_as_disabled() {
        Assert.assertTrue(sendRequirement.verifyTheDisabilityOfReplyToMailId(), 
        		"The reply to field is not disabled");
        TestNGLogUtility.pass("The reply to field is disabled");
    }
    
}
