package com.naukri.stepdefinitions.VendorPlatform;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.MLH.MLHRequirementListingPagePO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.pageobjects.VendorPlatform.AttachAssessmentForPartnerPO;
import com.naukri.pageobjects.VendorPlatform.ViewAssessmentPO;
import com.naukri.stepdefinitions.Applications.SendAMessageStepDefs;
import com.naukri.stepdefinitions.Assessment.TestDetailsOnSrpAndCVDetailsStepDef;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class is use for view the assessment on Requirement Over View page
 * 
 * @author abhishek.dwivedi
 *
 */

public class VideoInterviewStepDef extends BaseAutomation {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = new APITestOps();
	ViewAssessmentPO objViewAssessment = (ViewAssessmentPO) PageObjectWrapper.getObject(ViewAssessmentPO.class);
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);
	AttachAssessmentForPartnerPO attach = (AttachAssessmentForPartnerPO) PageObjectWrapper.getObject(AttachAssessmentForPartnerPO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	RequirementPagePO objRequirementPage = (RequirementPagePO) PageObjectWrapper.getObject(RequirementPagePO.class);
	HashMap<String, String> hmapStageAndtestName = new HashMap<>();
	MLHRequirementListingPagePO requirementListingPageObject =  (MLHRequirementListingPagePO) PageObjectWrapper.getObject(MLHRequirementListingPagePO.class);
	List<String> lstTestName = new ArrayList<>();
	List<String> lstAllCandidateAddedToReq = new ArrayList<>();
	String reqName = "";
	String candidateName = "";
	MailBoxTabPO objMailBoxPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
	String candidateEmailId="";

	public static String mailSubject="",mailFound="",hangoutLink="";
	public static Map<String, String> hmapPreview=new HashMap<String, String>();
	SoftAssert softAssert=new SoftAssert();
	ViewAssessmentPO objViewAssessmentPO = (ViewAssessmentPO) PageObjectWrapper.getObject(ViewAssessmentPO.class);
	@Then("User move to the candidate to {string} stage")
	public void moveTocandidatetoStage(String interviewStage) {
		 objMailBoxPO.setStatus(interviewStage);
		 wait.hardWait(5);
	}
	
	@Then("I verify Configure Now link is visible")
	public void verifyConfigureNowLink() {
		objViewAssessment.isConfigureNowDisplayed();
		TestNGLogUtility.pass(" Configure Now link is visible");
	}

	@Then("User click on Interview Type dropdown and select {string} option")
	public void clickInterviewTypeAndSelect(String interviewStage) {
		objViewAssessment.clickInterviewTypeAndSelect(interviewStage);
		TestNGLogUtility.info(" click on Interview Type dropdown and select");
	}

	@Then("I verify Configure your account yellow strip is displayed")
	public void verifyConfigureYourAccountLink() {
		objViewAssessment.isConfigureYourAccoutDisplayed();
		TestNGLogUtility.pass(" Configure your account yellow strip is displayed");
	}
	@Then("User provide InterviewDate and time")
	public void provideInterviewDateAndTime() {
		objViewAssessment.setInterviewDateTime("11", "11");
		TestNGLogUtility.info(" provide InterviewDate and time");
	}
	@Then("User click on set Interview")
	public void clickSetInterview() {
		objMailBoxPO.clickOnsetInterviewStage();
		TestNGLogUtility.info(" click on set Interview ");
	}
	
	
	@Then("User verify ThreadSubject is displayed as {string} for Video Interview")
	public void verifyThreadSubjectInMail(String mailThreadSubject) {
		Assert.assertTrue(objMailBoxPO.isUpdatedThreadSubjectDisplayed(mailSubject));
		TestNGLogUtility.pass("Verify mail Subject is displayed is expected");
	}

	@Then("User get the text of MailSubject and send the Mail")
	public void getTheSubjectOfMailAndSendTheMail() {
		mailSubject=objViewAssessment.getTextMailSubject();
		objMailBoxPO.clickOnSendStatusChangeMail();
		wait.hardWait(3);
		TestNGLogUtility.info("  Get the text of MailSubject"+ mailSubject +" and send the Mail");
	}
	@Then("I get the Email id of the candidate")
	public void getCandidateEmailId() {
		candidateEmailId=objViewAssessmentPO.getTextEmailIdFromCVDetailPage();
		TestNGLogUtility.info("I get the Email id of the candidate");
	}
	
	@Then("I search the candidate on Application Inbox page with {string}")
	public void seachCandidateOnApplicationInboxPage(String str) {
		objViewAssessment.enterDetailInSearchBox(candidateEmailId);
		TestNGLogUtility.info("I search the candidate on Application Inbox page ");
	}
	@Then("I click on edit icon")
	public void clickEditIcon() {
		objViewAssessment.clickOnEditIcon();
		TestNGLogUtility.info("I click on edit icon ");
	}
	@Then("User verify success message is displayed")
	public void user_verify_success_message_is_displayed() {
		Assert.assertTrue(objViewAssessment.verifyPresenceOfSuccessMsg(), "Success message not found");
	}

	@Then("User verify the Interview type as {string}")
	public void user_verify_the_Interview_type_as(String interviewType) {
		Assert.assertTrue(objViewAssessment.verifyInterviewType(interviewType), "Expected Interview type not found");
	}

	@Then("User verify Hangout contact card is present on hovering on icon")
	public void user_verify_Hangout_contact_card_is_present_on_hovering_on_icon() {
		Assert.assertTrue(objViewAssessment.verifyPresenceOfContactCard(),"Contact card not found on hovering");
	}

	@Then("User verify heading of contact card")
	public void user_verify_heading_of_contact_card(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(objViewAssessment.verifyContactCardHeading(list.get(0)),"Incorrect heading on contact card");
	}

	@Then("User verify the interview link and copy icon")
	public void user_verify_the_interview_link_and_copy_icon(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(objViewAssessment.getContactCardInterviewLink().contains(list.get(0)),"Incorrect Hangout link");
		Assert.assertTrue(objViewAssessment.verifyContactCardCopyLink(),"Copy link icon not present");
	}
	
	@And("User get the hangout link from Contact card")
	public void user_get_the_hangout_link_from_Contact_card() {
		hangoutLink = objViewAssessment.getContactCardInterviewLink();
	}

	@Then("User verify {string} and {string} button are present")
	public void user_verify_send_to_candidate_and_Interviewer_button_are_present(String option1,String option2 ) {
		Assert.assertTrue(objViewAssessment.verifySendLinksOnContactCard(option1),"Send to candidate button not found");
		Assert.assertTrue(objViewAssessment.verifySendLinksOnContactCard(option2),"Send to intervierwer button not found");
	}

	@Then("User click on Send to candidate link")
	public void user_click_on_Send_to_candidate_link() {
		objViewAssessment.clickSendToCandidateFromContactCard();
	}
	
	@Then("User click on Send to Interviewer link")
	public void user_click_on_Send_to_Interviewer_link() {
		objViewAssessment.clickSendToInterviewerFromContactCard();
	}
	
	@And("User click on Send To candidate button in success message")
		public void User_click_on_Send_To_candidate_button_in_success_message() {
		wait.hardWait(3);
		objMailBoxPO.clickOnEmailCandidateButton();
	}
	
	@Then("User refresh the page until candidate visible")
	public void refresh_the_page_until_candidate_count_visible() {
		objViewAssessment.refreshPageUntilCandidateVisible();
	}
	

	@Then("User click on Forward to HM from success message strip")
	public void user_click_on_Forward_to_HM_from_success_message_strip() {
		objViewAssessment.clickFwdToHMFromSuccessMessage();
	}
	
	@Then("User get the text of MailSubject")
	public void user_get_the_text_of_MailSubject() {
		mailSubject=objViewAssessment.getTextMailSubject();
	}

	@Then("User click on Preview and Send")
	public void user_click_on_Preview_and_Send() {
		objViewAssessment.clickOnSendAndPreview();
	}

	@Then("User get all Interview details from {string}")
	public void user_get_all_Interview_details_from(String MailDetailsSource) {
	    objViewAssessment.getEmailDetailsToInterviewer(MailDetailsSource);
	}

	@Then("User Send the mail from Mail Preview")
	public void user_Send_the_mail_from_Mail_Preview() {
		objViewAssessment.clickSendMailFromMailPreview();
	}

	@Then("User launch mail content in browser")
	public void user_launch_mail_content_in_browser(DataTable dt) {
		List<String> list = dt.asList(String.class);
		objViewAssessment.openHTMlinBrowser(TestDetailsOnSrpAndCVDetailsStepDef.content,list.get(0));
	}
	
	@Then("User compare that mail Preview and Candidate Inbox mail content")
	public void user_compare_that_mail_Preview_and_Candidate_Inbox_mail_content() {
		hmapPreview.put("MailBody", SendAMessageStepDefs.hmapReturnData.get("MailBody"));
		if (!(mailFound==null)) {
			if (hmapPreview.isEmpty()) {
				hmapPreview = objViewAssessment.getEmailDetailsToInterviewer("CandidateMailbox");
			}
			softAssert.assertTrue(objViewAssessment.compareTwoHashMaps(objViewAssessment.openHTMlinBrowserAndGetContent(TestDetailsOnSrpAndCVDetailsStepDef.content), hmapPreview),"Mail content is same for Mail preview and Candidate mailbox");
			softAssert.assertAll();
			TestNGLogUtility.pass("The RMS Mail Preview and Candidate Personal Inbox mail content is matched successfully");
			wait.hardWait(3);
		} else {
			TestNGLogUtility.info("The Mail Not found so the step is skipped");
			mailFound="";
		}
	}	
	
	@And("I add Default Automatic mailer for {string} stage.")
	public void i_add_Default_Automatic_mailer_for_stage(String stage) {
	   Assert.assertTrue(objMailBoxPO.setDefaultAutomaticMailerForStage(stage).contains("Default Interview Status Change") , "Default automated mail not set for the stage");
	}
	
	@Then("User update the hangout link in the hashmap if changed")
	public void user_update_the_hangout_link_in_the_hashmap() {
		 Assert.assertTrue(objViewAssessment.updateHangoutLinkInhashMap(hangoutLink),"Hangout Link not updated");
	}

	@Then("User close the current tab and switch to parent tab")
	public void user_close_the_current_tab() {
		closeWindow();
		switchToParentWindow();
	}
	
	@Then("update subject for Automatic mailer")
	public void update_subject_for_Automatic_mailer() {
		mailSubject = "Interview Scheduled";
	}
	@Then("User compare that mail Preview and Candidate Inbox mail content for Interview details")
	public void user_compare_that_mail_Preview_and_Candidate_Inbox_mail_content_for_Interview_details() {	
	     Assert.assertTrue(objViewAssessment.verifyforwardMailPreviewwithCandidatePersonalMailBox(), "Mail content not same for Mail preview and recipient mailbox");
		 TestNGLogUtility.info("Mail content  same for Mail preview and Recipient mailbox");
	}
	
	@And("User uncheck Automatic mailer to HM checbox in settings")
	public void User_uncheck_Automatic_mailer_to_HM_checbox_in_settings_if_checked(){
		Assert.assertTrue(objViewAssessment.UncheckAutomaticMailerToHMCheckboxInSettings(),"Automatic mailer to HM checbox still checked");
	}
}
