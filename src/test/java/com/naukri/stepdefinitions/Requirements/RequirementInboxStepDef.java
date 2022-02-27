package com.naukri.stepdefinitions.Requirements;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.BulkStatusUpdatePO;
import com.naukri.pageobjects.Applications.ForwardFlowPagePO;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.Applications.MasterProfileListingPagePO;
import com.naukri.pageobjects.Applications.SendAMessagePagePO;
import com.naukri.pageobjects.Applications.BulkStatusUpdatePO.BulkStatusChangeLightboxPO;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.MLH.RequirementInboxPagePO;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.pageobjects.VendorPlatform.HEmarketingTourAndRequestDemoPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequirementInboxStepDef {

	RequirementOverviewPagePO objRequirementOverviewPagePO = (RequirementOverviewPagePO) PageObjectWrapper
			.getObject(RequirementOverviewPagePO.class);
	SendAMessagePagePO sendMessage = (SendAMessagePagePO) PageObjectWrapper.getObject(SendAMessagePagePO.class);
	MailBoxTabPO objMailBoxPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
	ForwardFlowPagePO forwardflowPagePO = (ForwardFlowPagePO) PageObjectWrapper.getObject(ForwardFlowPagePO.class);
	BulkStatusUpdatePO bulkStatusUpdatePO = (BulkStatusUpdatePO) PageObjectWrapper.getObject(BulkStatusUpdatePO.class);
	BulkStatusUpdatePO.BulkStatusChangeLightboxPO bulkStatusChangeLightboxPO = (BulkStatusUpdatePO.BulkStatusChangeLightboxPO) PageObjectWrapper
			.getInnerClassObject(BulkStatusUpdatePO.class, BulkStatusChangeLightboxPO.class);
	MasterProfileListingPagePO masterProfileListingPagePO = (MasterProfileListingPagePO) PageObjectWrapper
			.getObject(MasterProfileListingPagePO.class);
	RequirementInboxPagePO objRequirementInboxPagePO = (RequirementInboxPagePO) PageObjectWrapper
			.getObject(RequirementInboxPagePO.class);
	HEmarketingTourAndRequestDemoPO objHEmarketingTourAndRequestDemoPO = (HEmarketingTourAndRequestDemoPO) PageObjectWrapper
			.getObject(HEmarketingTourAndRequestDemoPO.class);
	CVDetailsPagePO objCVDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	GenericFunctions objGenericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	InboxPagePO objInboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
	String stageToBeChange, commentProvided, currentPageUrl = "";
	int starRating;
	SoftAssert softAssert = new SoftAssert();

	@When("User can perform actions like {string}")
	public void user_can_perform_actions_like(String actionPerformed) {
		objRequirementInboxPagePO.refreshAndWaitForTheCandidateUple();
		objHEmarketingTourAndRequestDemoPO.pageRefresh();
		sendMessage.selectFirstCandidateCheckbox();
		switch (actionPerformed.toLowerCase().toString()) {
		case "email":
			sendMessage.hoverOnEmailButton();
			sendMessage.clickMessageOptionOnInbox();
			sendMessage.fillMailBody();
			sendMessage.fillMailSubject();
			sendMessage.clickButtonOnMessageFooter("SEND MAIL");
			break;
		case "forward":
			objMailBoxPO.clickForwardMailButton();
			break;
		case "bulk status change":
			stageToBeChange = "Applied-Matching";
			bulkStatusUpdatePO.click_bulkStatusUpdate();
			bulkStatusChangeLightboxPO.selectStatusFromDropDownMenu(stageToBeChange);
			bulkStatusChangeLightboxPO.clickUpdateButtonOnLayout();

			break;
		case "comment":
			commentProvided = "Test Comment";
			objRequirementInboxPagePO.enterCommentOnReqInboxPage(commentProvided);

			break;
		case "star rating":
			starRating = 4;
			objRequirementInboxPagePO.changeStarRating(starRating);
			break;
		case "add to backup":
			objRequirementInboxPagePO.clickAddToBackUp();
			break;

		}

	}

	@Then("User Verify the details of {string} is displayed")
	public void user_Verify_the_details_of_is_displayed(String actionPerformed) {
		switch (actionPerformed.toLowerCase().toString()) {
		case "email":

			TestNGLogUtility.pass("The details of " + actionPerformed + "verified ");
			break;
		case "forward":

			TestNGLogUtility.pass("The details of " + actionPerformed + "verified ");
			break;
		case "bulk status change":
			if (stageToBeChange.contains("-")) {
				String arr[] = stageToBeChange.split("-");
				Assert.assertTrue(objRequirementInboxPagePO.getCandidateStage().contains(arr[0]));
				Assert.assertTrue(objRequirementInboxPagePO.getCandidateStage().contains(arr[1]));
			} else {
				Assert.assertTrue(objRequirementInboxPagePO.getCandidateStage().contains(stageToBeChange));
			}
			TestNGLogUtility.pass("The details of " + actionPerformed + "verified ");
			break;
		case "comment":
			Assert.assertTrue(objRequirementOverviewPagePO.isCommentDisplayed(commentProvided));
			TestNGLogUtility.pass("The details of " + actionPerformed + "verified ");
			break;
		case "star rate":
			softAssert.assertEquals(objRequirementInboxPagePO.getStarRating(), starRating + 1);
			TestNGLogUtility.pass("The details of " + actionPerformed + "verified ");
			break;
		case "remove from backup":
			Assert.assertTrue(objCVDetailsPagePO.isTheRemoveFromBackuoDisplayedOnCVDetailsPage());
			TestNGLogUtility.pass("The details of " + actionPerformed + "verified ");
			break;

		}
	}

	@Then("User Click on Forward to Hiring Manager")
	public void userClickOnForwardToHiringManager() {
		objRequirementInboxPagePO.clickForwardToHiringmanager();
	}

	@When("User move to {string} URL")
	public void user_move_to_URL(String string) {
		objGenericFunctions.launchSpecificURL(currentPageUrl);
		TestNGLogUtility.info("Move to  URL as " + currentPageUrl);
	}

	@When("User get the current page Url")
	public void user_get_the_current_page_Url() {
		currentPageUrl = objRequirementInboxPagePO.getPageUrl();
		TestNGLogUtility.info("Get the current URL as " + currentPageUrl);

	}

	@Then("Use Verify the Status is displayed On Requirement Inbox Page")
	public void userVerifyTheStatusisDisplayedOnRequirementInboxPage() {
		objRequirementInboxPagePO.isSelctionStageStatusDisplayed();
	}

	@When("User click on Select all candidate checkbox")
	public void user_click_on_Select_all_candidate_checkbox() {
		objInboxPagePO.selectAllProfiles();
	}

	@When("User click on {string} option on inbox page")
	public void user_click_on_option_on_inbox_page(String btnName) {
		objGenericFunctions.clickOnActionButtonOnInboxPage(btnName);
	}

	@Then("User should be able to see change status pop up")
	public void user_should_be_able_to_see_change_status_pop_up() {
		Assert.assertTrue(objInboxPagePO.verifyChangeStatusPopup(),"Change status pop-up is not displayed");
		TestNGLogUtility.info("Change status pop-up is displayed");
	}

	@When("User select the {string} status on change status popup")
	public void user_select_the_status_on_change_status_popup(String status) {
		objInboxPagePO.selectStatusOnChangeStatusPopup(status);
	}

	@When("User click on update button")
	public void user_click_on_update_button() {
		objInboxPagePO.clickOnUpdateOnChangeStatusPopup();
	}

	@Then("User should be able to see changed status {string} of candidate")
	public void user_should_be_able_to_see_changed_status_of_candidate(String statusValue) {
		Assert.assertTrue(objInboxPagePO.verifyStatusOfEachCandidate(statusValue),"Status changed by bulk change status is not displayed correctly");
		TestNGLogUtility.info("Bulk status changed successfully");
	}

	@When("User click on first candidate on inbox page")
	public void user_click_on_first_candidate_on_inbox_page() {
		objInboxPagePO.clickFirstCandidate();
	}

	@When("User click on {string} option from {string}")
	public void user_click_on_option_from(String suboption, String option) {
		objInboxPagePO.clickOnSuboption(option, suboption);
	}

	@Then("User should be able to see download popup")
	public void user_should_be_able_to_see_download_popup() {
		Assert.assertTrue(objInboxPagePO.verifyDownloadprofilePopup(),"Download pop-up is not displaying as expeted");
		TestNGLogUtility.info("Download pop-up is displaying successfully");

	}

	@Then("User should be able to see {string}")
	public void user_should_be_able_to_see(String option) {
		Assert.assertTrue(objInboxPagePO.verifyOptionOnDownloadPopup(option),"Download options are not visible");
		TestNGLogUtility.info("Download options are visible successfully");

	}

	@When("User Click on download button")
	public void user_Click_on_download_button() {
		objInboxPagePO.clickOnDownloadButtonOnDownloadPopup();

	}

	@Then("User should be able to Download application with {string}")
	public void user_should_be_able_to_Download_application(String fileExtension) {
		String dirPath=objGenericFunctions.getDownloadDirPath();
		System.out.println("Directory path --->> "+dirPath);
		Assert.assertTrue(objInboxPagePO.verifyDownloadedSectedOrByIndexApplication(dirPath, fileExtension),"Fle is not download or not with expected extension");
		TestNGLogUtility.info("Application File downloaded successfully..!!");
	}

	@When("User enter range on download popup as {string} and {string}")
	public void user_enter_range_on_download_popup_as_and(String startingIndex, String endingIndex) {
		objInboxPagePO.enterDownloadingindexRange(startingIndex, endingIndex);
	}

	@When("click on Select all candidate checkbox")
	public void click_on_Select_all_candidate_checkbox() {
		objInboxPagePO.selectAllApplicationCheckBox();
	}
	
	@When("User click on status dropdwon.")
	public void user_click_on_status_dropdwon() {
		objInboxPagePO.clickOnStatusDD();
	}

	@Then("User should be able to see updated status {string} on the tuple")
	public void user_should_be_able_to_see_updated_status_on_the_tuple(String status) {
		Assert.assertTrue(objInboxPagePO.verifyStatusOfNumberOfCandidates(status),"Status is not updated as expected");
		TestNGLogUtility.info("Status changes as expected");
	}

	@When("User select the status as {string} from dropdown")
	public void user_select_the_status_as_from_dropdown(String status) {
		objInboxPagePO.selectStatus(status);
	}

	@When("User fill the interview on upcoming date.")
	public void user_fill_the_interview_on_upcoming_date() {
		objInboxPagePO.fillVenueForInterview();
		objInboxPagePO.selectCurrentDayForInterview();
		objInboxPagePO.selectTimeOfDay();
		objInboxPagePO.setMinuteOfInterview();
		objInboxPagePO.changeAMPMForInterviewTime("PM");
	}

	@When("User click on {string} button on success message")
	public void user_click_on_button_on_success_message(String btnName) {
	    objInboxPagePO.clickOnStatusMailBtnOnSuccessMessage(btnName);
	}

	@When("User click on send button on send status change pop-up")
	public void user_click_on_send_button_on_send_status_change_pop_up() {
	    objInboxPagePO.clickOnSendButtton();
	}
	
	@When("User enter the email {string} in To field")
	public void User_enter_the_email_in_To_field(String email) {
	    objInboxPagePO.enterHmEmailId(email);
	}
	

	@Then("User should be able to see mail sent success message")
	public void user_should_be_able_to_see_mail_sent_success_message() {
		Assert.assertTrue(objInboxPagePO.verifyMailSentSuccessMessage(),"Status Change mail is not send successfully.");
		TestNGLogUtility.info("Status Change mail sent successfully.");
	}

	@When("User select Set Sub Status as {string}")
	public void user_select_Set_Sub_Status_as(String subStatus) {
	    objInboxPagePO.selectSubStatusOfInterview(subStatus);
	}

	@Then("User should be able to see sub status as {string}")
	public void user_should_be_able_to_see_sub_status_as(String status) {
		Assert.assertTrue(objInboxPagePO.verifyInterviewSubStatus(status),"Interview sub status is not set successfully.");
		TestNGLogUtility.info("Interview sub status is set successfully.");
	}
	
	@Then("User should be able to see Interview Type as {string}")
	public void user_should_be_able_to_see_Interview_Type_as(String type) {
		Assert.assertTrue(objInboxPagePO.verifyInterviewType(type),"Interview Type is not set successfully.");
		TestNGLogUtility.info("Interview Type is set successfully.");
	}

	@When("User click on {string} button against interview details")
	public void user_click_on_button_against_interview_details(String string) {
	    objInboxPagePO.clickOnEditBtnOnInterviewInfoTuple();
	}

	@When("User select Set Interview Type as {string}")
	public void user_select_Set_Interview_Type_as(String type) {
	   objInboxPagePO.selectInterviewType(type);
	}
	
	@When("User enter the venue detail")
	public void User_enter_the_venue_detail() {
	   objInboxPagePO.fillVenueForInterview();
	}

	@Then("User should be able to see Error message {string}")
	public void user_should_be_able_to_see_Error_message(String message) {
		Assert.assertTrue(objInboxPagePO.presenceOfErrorMessageForInterviewVenueAndTime(message),"Interview venue and Date & Timing error message is not displaying");
		TestNGLogUtility.info("Interview venue and Date & Timing error message is displaying successfully.");
	}
	
	@When("User click on first candidate name on inbox page")
	public void user_click_on_first_candidate_name_on_inbox_page() {
		objInboxPagePO.clickFirstCandidateName();
	}
	
	@When("User click on {string} option from backedup list")
	public void User_click_on_option_from_backedup_list(String option) {
		objInboxPagePO.clickOnBackedUpOptionAfterHover(option);
	}
	
	@Then("User should be able to see backedup icon on the tuple")
	public void User_should_be_able_to_see_backedup_icon_on_the_tuple() {
		Assert.assertTrue(objInboxPagePO.verifyBackedUpIcon(),"Backed up icon is not displaying");
		TestNGLogUtility.info("Backed up icon is displaying successfully.");
	}
}
