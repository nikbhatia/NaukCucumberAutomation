package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.pageobjects.Offer.OfferApprovalPagePO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryTemplateReviewNApprovePO;
import com.naukri.pageobjects.Offer.OfferNewFlowPagePO;
import com.naukri.pageobjects.Offer.OfferSettingsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

/**
 * @author udit.khanna
 *
 */
public class OfferNewFlowStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferNewFlowPagePO offerNewFlowObject = (OfferNewFlowPagePO) PageObjectWrapper
			.getObject(OfferNewFlowPagePO.class);
	OfferGenerationSalaryTemplateReviewNApprovePO offerGenerationSalaryTemplateReviewnApprovePO = (OfferGenerationSalaryTemplateReviewNApprovePO) PageObjectWrapper
			.getObject(OfferGenerationSalaryTemplateReviewNApprovePO.class);
	OfferApprovalPagePO offerApprovalPO = (OfferApprovalPagePO) PageObjectWrapper.getObject(OfferApprovalPagePO.class);
	APITestOps apiTestOps = (APITestOps) PageObjectWrapper.getObject(APITestOps.class);
	

	@Then("I should see new offer layer")
	public void I_should_see_new_offer_layer(){
		Assert.assertTrue(offerNewFlowObject.verifyNewOfferLayer(), "Offer new layer did not open.");
	}
	
	@And("I turn the {string} offer generation permission button to {string}")
	public void I_turn_the_offer_generation_permission_button_to(String permissionId, String permissionStatus){
		offerNewFlowObject.changeStatusOfOfferGenerationPermission(permissionId, permissionStatus);
	}
	
	@And("user click on {string} offer generation link")
	public void userClickOnLink(String link) {
		offerNewFlowObject.links(link);
	}
	
	@Then("I should see message {string} on new Offer layer")
	public void I_should_see_message_on_new_Offer_layer(String message){
		Assert.assertTrue(offerNewFlowObject.verifyMessageOnNewOfferLayer(message), message + " is not visible on new offer layer");
	}
	
	@And("I click {string} link in message in new Offer layer")
	public void I_click_link_in_message_in_new_Offer_layer(String linkTxt) {
		offerNewFlowObject.clickLinkInMessageInNewOfferLayer(linkTxt);
	}
	
	@Then("I should be navigated to Salary Rule listing page")
	public void I_should_be_navigated_to_Salary_Rule_listing_page(){
		Assert.assertTrue(offerNewFlowObject.verifyNavigatedToSalaryRuleListing(), "Not navigated to Salary Rule Listing page");
	}
	
	@And("I create a new salary template in {string} state")
	public void I_create_a_new_salary_template_in_state(String state) {
		offerNewFlowObject.createNewSalaryTemplateInState(state);
	}
	
	@And("I click Select Salary-Breakup Template dropdown on new offer layer")
	public void I_click_dropdown_on_new_offer_layer() {
		offerNewFlowObject.clickSelectSalaryBreakupTemplateDropdownOnNewOfferLayer();
	}
	
	@Then("I should see confirm salary template in Select Salary-Breakup Template dropdown")
	public void I_should_see_confirm_salary_template_in_dropdown(){
		Assert.assertTrue(offerNewFlowObject.verifyConfirmSalaryTemplateInDropdown(), "Confirm Salary template not present in Select Salary-Breakup Template dropdown");
	}
	
	@Then("I should not see draft salary template in Select Salary-Breakup Template dropdown")
	public void I_should_not_see_draft_salary_template_in_dropdown(){
		Assert.assertTrue(offerNewFlowObject.verifyDraftSalaryTemplateInDropdownIsNotDisplayed(), "Draft Salary template is present in Select Salary-Breakup Template dropdown");
	}
	
	@And("I select confirm salary template in Select Salary-Breakup Template dropdown")
	public void I_select_confirm_salary_template_in_dropdown() {
		offerNewFlowObject.clickConfirmedSalaryBreakupTemplateDropdownOnNewOfferLayer();
	}
	
	@Then("I should see all inputs on the first stepper of Offer layer")
	public void I_should_see_all_inputs_on_the_first_stepper_of_Offer_layer(DataTable dt){
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyAllInputsInReviewPage(list), "New Offer layer does not contain all Inputs.");
	}
	
	@Then("I should see validation error for all fields on the first stepper of Offer layer")
	public void I_should_see_validation_error_for_all_fields_on_the_first_stepper_of_Offer_layer(DataTable dt){
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyAllInputErrorsOnReviewPage(list), "Error for inputs on new offer layer are not correct.");
	}
	
	@Then("I should see radio buttons on second stepper of new Offer layer")
	public void I_should_see_radio_buttons_on_second_stepper_of_new_Offer_layer(DataTable dt){
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerNewFlowObject.verifyradioButtonsOnSecondStepper(list), "Dropdowns not displayed in second stepper of new offer layer.");
	}
	
	@And("I click {string} radio button on new offer layer")
	public void I_click_radio_button_on_new_offer_layer(String radioBtnTxt) {
		offerNewFlowObject.clickRadioBtnOnNewOfferLayer(radioBtnTxt);
	}
	
	@Then("I should see Zoho editor on second stepper")
	public void I_should_see_Zoho_editor_on_second_stepper(){
		Assert.assertTrue(offerNewFlowObject.verifyZohoEditorIsDisplayed(), "Zoho Editor is not displayed.");
	}
	
	@Then("I should see {string} error message on scond stepper of new offer layer")
	public void I_should_see_error_message_on_scond_stepper_of_new_offer_layer(String errorMsgTxt){
		Assert.assertTrue(offerNewFlowObject.verifyErrorMsgOnSecondStepperOfNewOfferLayer(errorMsgTxt), "Error message: " + errorMsgTxt + " is not displayed.");
	}
	
	@Then("I should be navigated to Offer Document listing page")
	public void I_should_be_navigated_to_Offer_Document_listing_page(){
		Assert.assertTrue(offerNewFlowObject.verifyNavigatedToOfferDocumentListing(), "Not navigated to Offer Document listing.");
	}
	
	@And("I create a new Offer Document")
	public void I_create_a_new_Offer_Document() throws Exception {
		offerNewFlowObject.createNewOfferDocument();
	}
	
	@And("I click Select Offer Letter Template dropdown")
	public void I_click_Select_Offer_Letter_Template_dropdown() {
		offerNewFlowObject.clickSelectOfferLetterTemplateDD();
	}
	
	@Then("I should see new offer document created in dropdown options")
	public void I_should_see_new_offer_document_created_in_dropdown_options(){
		Assert.assertTrue(offerNewFlowObject.verifyNewOfferDocumentCreatedInDropdownOptions(), "Offer Document not visible in dropdown.");
	}
	
	@And("I click new offer document created in dropdown")
	public void I_click_new_offer_document_created_in_dropdown() {
		offerNewFlowObject.clickNewOfferDocumentCreatedDD();
	}
	
	@Then("I should see attached offer letter and download button on third stepper")
	public void I_should_see_attached_offer_letter_and_download_button_on_third_stepper(){
		Assert.assertTrue(offerNewFlowObject.verifyAttachedOfferLetterAndDownloadBtn(), "Offer Document not attached on third stepper.");
	}
	
	@And("I click on Generate and Attach Offer Letter button")
	public void I_click_on_Generate_and_Attach_Offer_Letter_button() {
		offerNewFlowObject.clickGenerateAndAttachOfferLetterBtn();
	}
	
	@And("I click {string} stepper")
	public void I_click_stepper(String stepperTxt) {
		offerNewFlowObject.clickStepper(stepperTxt);
	}
	
	@Then("I should be directed back to second stepper of new offer layer")
	public void I_should_be_directed_back_to_second_stepper_of_new_offer_layer(){
		Assert.assertTrue(offerNewFlowObject.verifyDirectedBackToSecondStepper(), "Not Directed back to second stepper.");
	}
	
	@Then("I should see {string} dialog box")
	public void I_should_see_dialog_box(String dialogBoxTxt){
		Assert.assertTrue(offerNewFlowObject.verifyDialogBoxVisibility(dialogBoxTxt), "Dialog box with text '" + dialogBoxTxt + "' is not visible.");
	}
	
	@Then("I should see {string} in previous offer information")
	public void I_should_see_in_previous_offer_information(String previousOfferInfoTxt){
		Assert.assertTrue(offerNewFlowObject.verifyPreviousOfferInfo(previousOfferInfoTxt), "Previous offer information not updated on new offer layer.");
	}
	
	@Then("I add candidate using API for \"([^\"]*)\" without any group")
	public void I_add_candidate_using_API(String subscriptionType) {
		String[] userAndPass = OfferSettingsPagePO.getUsernameAndPasswordForOffer(subscriptionType);
		String subStatusId = offerApprovalPO.getSubStatusIdForAddCandidate();
		String candidateId = apiTestOps.addCandidate(userAndPass[0], userAndPass[1], "", "", subStatusId, "");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(!candidateId.equals(null), "Candidate not created using addCandidate API.");
	}
	
	@And("I click on Compose Mail link")
	public void I_click_on_Compose_Mail_link() {
		offerNewFlowObject.clickComposeMailLink();
	}
	
	@And("I click Fill Offer Details link on CV details page")
	public void I_click_Fill_Offer_Details_link_on_CV_details_page() {
		offerNewFlowObject.clickFillOfferDetailsLinkOnCVDetails();
	}
	
	@And("I click Send to Candidate button")
	public void I_click_Send_to_Candidate_button() {
		offerNewFlowObject.clickSendToCandidateLinkOnCVDetails();
	}
	
	@Then("I should be directed to {string} tab of Offer Old Flow")
	public void I_should_be_directed_to_tab_of_Offer_Old_Flow(String tabText){
		Assert.assertTrue(offerNewFlowObject.verifyRedirectedOnOfferOldFlow(tabText), "User not directed to tab: " + tabText + " of Old Offer flow.");
	}
	
	@Then("I should see candidate on profile project inbox page")
	public void I_should_see_candidate_on_profile_project_inbox_page(){
		Assert.assertTrue(offerNewFlowObject.verifyCandidateVisibleOnProfileProjectInbox(), "Candidate not visible on profile project inbox.");
	}
	
	@Then("I should be directed to {string} tab of Offer New Flow")
	public void I_should_be_directed_to_tab_of_Offer_New_Flow(String tabText){
		Assert.assertTrue(offerNewFlowObject.verifyRedirectedOnOfferNewFlow(tabText), "User not directed to tab: " + tabText + " of New Offer flow.");
	}
}

