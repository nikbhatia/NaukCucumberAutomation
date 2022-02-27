package com.naukri.stepdefinitions.Offer;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Offer.OfferApprovalPagePO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.pageobjects.Offer.OfferSettingsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferApprovalStepDef {

	OfferApprovalPagePO offerApprovalPO = (OfferApprovalPagePO) PageObjectWrapper.getObject(OfferApprovalPagePO.class);
	AddASingleProfilePagePO addASingleProfile = (AddASingleProfilePagePO) PageObjectWrapper
			.getObject(AddASingleProfilePagePO.class);
	OfferSettingsPagePO offerSettings = (OfferSettingsPagePO) PageObjectWrapper.getObject(OfferSettingsPagePO.class);
	APITestOps apiTestOps = (APITestOps) PageObjectWrapper.getObject(APITestOps.class);

	@When("I fill information about candidate")
	public void I_fill_information_about_candidate() {
		offerApprovalPO.addCandidateDetails();
		// addASingleProfile.addCandidateInformation();
	}

	@When("I map candidate to {string} requirement")
	public void I_map_candidate_to_requirement(String reqName) {
		offerApprovalPO.addRequirementToSingleProfile(reqName);
	}

	@When("I click on Select Approval Process dropdown")
	public void I_click_on_Select_Approval_Process_dropdown() {
		offerApprovalPO.clickSelectApprovalProcessDropdown();
	}

	// @Then("I check all offer approval templates mapped are displayed")
	// public void
	// I_check_all_offer_approval_templates_mapped_are_displayed(DataTable dt) {
	// List<String> list = dt.asList(String.class);
	// Assert.assertTrue(offerApprovalPO.checkAllOfferApprovalTemplatesDisplayed(list),
	// "");
	// }
	@Then("I check all offer approval templates mapped are displayed")
	public void I_check_all_offer_approval_templates_mapped_are_displayed() {
		Assert.assertTrue(offerApprovalPO.checkAllOfferApprovalTemplatesDisplayed(),
				"All offer approval templates are not displayed.");
	}

	@Then("I add candidate using API for \"([^\"]*)\"")
	public void I_add_candidate_using_API(String subscriptionType) {
		String[] userAndPass = OfferSettingsPagePO.getUsernameAndPasswordForOffer(subscriptionType);
		String groupId = offerApprovalPO.getGroupIdForAddCandidate();
		String subStatusId = offerApprovalPO.getSubStatusIdForAddCandidate();
		String candidateId = apiTestOps.addCandidate(userAndPass[0], userAndPass[1], "", "", subStatusId, groupId);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(!candidateId.equals(null), "Candidate not created using addCandidate API.");
		TestNGLogUtility.fail("Add candidate API Failed, following are the arguments used:");
		TestNGLogUtility.fail(userAndPass[0] + " " + userAndPass[1] + " " + subStatusId + " " + groupId);
	}

	@When("I navigate to CV details for the candidate")
	public void I_navigate_to_CV_details_for_the_candidate() {
		offerApprovalPO.navigateToCVDetailsForTheCandidate();
	}

	@When("I select {string} approval process from dropdown")
	public void I_select_approval_process_from_dropdown(String firstOrSecond) {
		String approvalProcess = ReadWritePropertyFile.getProperty(firstOrSecond + "ApprovalTemplateName",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		offerApprovalPO.selectApprovalProcess(approvalProcess);
	}

	@When("I {string} the offer for the candidate")
	public void I_the_offer_for_the_candidate(String buttonType) {
		offerApprovalPO.clickButtonOnCVDetailsPage(buttonType);
	}

	@When("I should see approve and reject buttons on CV Details page")
	public void I_should_see_approve_and_reject_buttons_on_CV_Details_page() {
		Assert.assertTrue(offerApprovalPO.verifyApproveAndRejectButtonsDisplayed(),
				"Approve and Reject buttons are not displayed.");
	}

	@When("I should see {string} message on CV Details page")
	public void I_should_see_message_on_CV_Details_page(String msg) {
		Assert.assertTrue(offerApprovalPO.verifyApproveAndRejectMsgDisplayedOnCVDetails(msg),
				"Message not displayed on CV Details page.");
	}

	@When("I should see {string} offer status on CV Details page")
	public void I_should_see_offer_status_on_CV_Details_page(String statusMsg) {
		Assert.assertTrue(offerApprovalPO.verifyOfferStatusOnCVDetailsPage(statusMsg), "Status is not : " + statusMsg);
	}

	@When("I search the candidate on application inbox page")
	public void I_search_the_candidate_on_application_inbox_page() {
		offerApprovalPO.searchCandidateOnApplicationInboxPage();
	}

	@When("I should see all Offer Details on SRP page for the candidate")
	public void I_should_see_all_Offer_Details_on_SRP_page_for_the_candidate() {
		Assert.assertTrue(offerApprovalPO.verifyAllOfferDetailsOnSRPPageForCandidate(),
				"Offer Details do not match as entered while moving to Offer Round.");
	}

	// @When("I open the requirement created using API")
	// public void I_open_the_requirement_created_using_API() {
	// offerApprovalPO.openRequirementCreatedUsingAPI();
	// }

	// @When("I click on Applications for the requirement")
	// public void I_click_on_Applications_for_the_requirement() {
	// offerApprovalPO.clickApplicationsForRequirement();
	// }

	@When("I click {string} button on Requirement Overview page")
	public void I_click_button_on_Requirement_Overview_page(String btnToBeClicked) {
		offerApprovalPO.clickApproveOrRejectButtonOnRequirementOverview(btnToBeClicked);
	}

	@When("I navigate to profile project inbox page for the candidate")
	public void I_navigate_to_profile_project_inbox_page_for_the_candidate() {
		offerApprovalPO.navigateToProfileProjectInbox();
	}

	@When("I navigate to requirment inbox page")
	public void I_navigate_to_requirment_inbox_page() {
		offerApprovalPO.navigateToRequirementInbox();
	}

	@When("I get requirement ID from the page")
	public void I_get_requirement_ID_from_the_page() {
		offerApprovalPO.getRequirementIdFromPageAndSaveToPropertyFile();
	}

	@When("I add candidate to the requirement")
	public void addCandidateToRequirement() {
		offerApprovalPO.addCandidateToReq();
	}

	@When("I check {string} checkbox on Attach Offer Letter page")
	public void I_check_checkbox_on_Attach_Offer_Letter_page(String checkboxTxt) {
		offerApprovalPO.checkCheckBoxOnAttachOfferLetterPage(checkboxTxt);
	}

	@When("I see {string} dialog box should open")
	public void I_see_dialog_box_should_open(String dialogBoxTxt) {
		Assert.assertTrue(offerApprovalPO.verifyDialogBoxOpened(dialogBoxTxt),
				"Dialog box with text '" + dialogBoxTxt + "' is not displayed.");
	}

	@When("I click {string} on the dialog box")
	public void I_click_on_the_dialog_box(String dialogBoxBtnTxt) {
		offerApprovalPO.clickButtonInDialogBox(dialogBoxBtnTxt);
	}

	@When("I should see {string} status in Offer details")
	public void I_should_see_status_in_Offer_details(String offerStatusTxt) {
		Assert.assertTrue(offerApprovalPO.verifyOfferStatusTextInOfferDetails(offerStatusTxt), "");
	}

	@When("I uncheck {string} checkbox on Attach Offer Letter page")
	public void I_uncheck_checkbox_on_Attach_Offer_Letter_page(String checkboxTxt) {
		offerApprovalPO.unCheckCheckBoxOnAttachOfferLetterPage(checkboxTxt);
	}

	@When("I click {string} link on Offer section")
	public void I_click_link_on_Offer_section(String linkText) {
		offerApprovalPO.clickLinkOnCVDetailsPageInOfferSection(linkText);
	}

	@When("I should see Enquire about offer layer")
	public void I_should_see_Enquire_about_offer_layer() {
		Assert.assertTrue(offerApprovalPO.verifyEnquireAboutOfferLayer(), "Enquire about offer section not displayed.");
	}

	@When("I enter text in comments field in Enquire about offer layer")
	public void I_enter_text_in_comments_field_in_Enquire_about_offer_layer() {
		offerApprovalPO.enterTextInCommentsFieldInEnquireAboutOfferLayer();
	}

	@When("I click on {string} in Enquire about offer layer")
	public void I_click_on_in_Enquire_about_offer_layer(String btnText) {
		offerApprovalPO.clickButtonInEnquireAboutOfferLayer(btnText);
	}

	@When("I should see {string} status message")
	public void I_should_see_status_message(String statusMsgText) {
		Assert.assertTrue(offerApprovalPO.verifyOfferStatusMessage(statusMsgText),
				statusMsgText + " status not visible.");
	}

	@When("I should see same comment for the candidate as entered by approver")
	public void I_should_see_same_comment_for_the_candidate_as_entered_by_approver() {
		Assert.assertTrue(offerApprovalPO.verifySameCommentForTheCandidate(),
				"Same comment text is not visible for the offer.");
	}

	@When("I click SEND MESSAGE link in Offer Details Section")
	public void I_click_SEND_MESSAGE_link_in_Offer_Details_Section() {
		offerApprovalPO.clickSendMessageLinkInOfferDetails();
	}

	@When("I enter text in SEND MESSAGE textbox")
	public void I_enter_text_in_SEND_MESSAGE_textbox() {
		offerApprovalPO.enterTextInSendMessageTextbox();
	}

	@When("I click SEND MESSAGE link below textbox in Offer Section")
	public void I_click_SEND_MESSAGE_link_below_textbox_in_Offer_Section() {
		offerApprovalPO.clickSendMessageLinkBelowTextboxInOfferDetails();
	}

	@When("I should see same message is sent to the approver")
	public void I_should_see_same_message_is_sent_to_the_approver() {
		Assert.assertTrue(offerApprovalPO.verifySameMessageSentToApprover(), "Same Message not sent to approver.");
	}

	@When("I click {string} button on Enquire about offer layer")
	public void I_click_button_on_Enquire_about_offer_layer(String btnText) {
		offerApprovalPO.clickButtonInEnquireAboutOfferLayer(btnText);
	}

	@When("I should see approvers {string} and {string} in the Show Full Approval layer")
	public void I_should_see_approvers_in_the_Show_Full_Approval_layer(String approver1, String approver2) {
		List<String> list = Arrays.asList(approver1, approver2);
		Assert.assertTrue(offerApprovalPO.verifyApproversInShowFullApprovalLayer(list),
				"All approvers not listed in Show Full Approval Layer.");
	}

	@When("I click Reject button on CV details page")
	public void I_click_Reject_button_on_CV_details_page() {
		offerApprovalPO.clickRejectButtonOnCVDetailsPage();
	}

	@When("I should see Offer notification for {string} on dashboard")
	public void I_should_see_Offer_notification_for_Approval_pending_on_dashboard(String verifyText) {
		Assert.assertTrue(offerApprovalPO.verifyOfferNotificationOnDashboardForApprovalPending(verifyText),
				"Offer Approval Pending notification not visible on Daashboard.");
	}

	@When("I should not see Approve or Reject buttons")
	public void I_should_not_see_Approve_or_Reject_buttons() {
		Assert.assertTrue(offerApprovalPO.verifyApproveRejectButtonNotDisplayed(),
				"Approve and Reject buttons are displayed on CV details for stage 2 approver.");
	}

	@When("click on Send to candidate after approved by all")
	public void clickOnSendToCandidateAfterApprovedByAll() {
		offerApprovalPO.clickOnSendToCandidateAfterApprovedByAll();
	}

	@Then("Mail body should be displayed on the offer lightbox")
	public void mailBodyDisplayedOnOfferLightbox() {
		Assert.assertTrue(offerApprovalPO.mailBodyDisplayedOnOfferLightbox(),
				"mail body is displayed on offer lightbox");
	}

	@When("check the switch Offer Approval is mandatory on settings page")
	public void checkSwitchOfferApprovalIsMandatorySettingsPage() {
		offerApprovalPO.checkSwitchOfferApprovalMandatory();
	}

	@When("click on set Approval Settings")
	public void clickOnSetApprovalSettings() {
		offerApprovalPO.clickOnSetApprovalSettings();
	}

	@When("uncheck the switch Offer Approval is mandatory on settings page")
	public void UnCheckSwitchOfferApprovalIsMandatorySettingsPage() {
		offerApprovalPO.unCheckSwitchOfferApprovalMandatory();
	}

	@Then("I save group ID for \"([^\"]*)\"")
	public void I_save_group_ID(String subscriptionType) {
		String[] userAndPass = OfferSettingsPagePO.getUsernameAndPasswordForOffer(subscriptionType);
		String groupId = apiTestOps.getGroupId(userAndPass[0], userAndPass[1],
				PropFileHandler.readProperty("groupName"));
		offerApprovalPO.saveGroupIdToPropertyFileUsingAPI(groupId);
	}

	@Then("I should not see {string} displayed in Select Approval Process dropdown")
	public void I_should_not_see_displayed_in_Select_Approval_Process_dropdown(String text) {
		Assert.assertTrue(offerApprovalPO.verifyTextNotDisplayedInSelectApprovalProcessDropdown(text),
				text + " is displayed in Select Approval Process dropdown");
	}

	@And("I add candidate to the requirement using API for \"([^\"]*)\"")
	public void I_add_candidate_to_the_requirement_using_API(String subscriptionType) {
		String[] userAndPass = OfferSettingsPagePO.getUsernameAndPasswordForOffer(subscriptionType);
		String requirementId = offerApprovalPO.getRequiremnentIdForAddCandidate();
		String candidateId = apiTestOps.addCandidate(userAndPass[0], userAndPass[1], requirementId, "", "");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(!candidateId.equals(null), "Candidate not created using addCandidate API.");
	}

	@When("I change the status of the candidates to {string}")
	public void I_change_the_status_of_the_candidates_to_string(String statusText) {
		offerApprovalPO.changeStatusOfCandidate(statusText);
	}

	@Then("verify 2 profiles are displayed on project inbox page")
	public void verifyBothProfilesCreatedInReq() {
		Assert.assertTrue(offerApprovalPO.verifyBothProfilesCreated(), "both  profiles are not created");
	}

	@And("I click Requirement name on CV details for the candidate")
	public void clickRequirementNameOnCVDetails() {
		offerApprovalPO.clickRequirementNameOnCVDetails();
	}

	@And("I click applicant count on Requirement Overview")
	public void clickApplicationCountOnRequirementOverview() {
		offerApprovalPO.clickApplicationCountOnRequirementOverview();
	}
	
	@And("I search for requirement on Requirement Listing page")
	public void searchForRequirementOnReqListing(){
		offerApprovalPO.searchForRequirementOnReqListing();
	}

}
