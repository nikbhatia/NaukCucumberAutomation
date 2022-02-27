package com.naukri.stepdefinitions.Applications;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Applications.InterviewSchedulingPagePO;
import com.naukri.pageobjects.Applications.InterviewSchedulingPagePO.AdvancedInterviewSchedulingPagePO;
import com.naukri.pageobjects.Applications.InterviewSchedulingPagePO.BasicInterviewSchedulingPagePO;
import com.naukri.pageobjects.Settings.ManageDocumentsPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CVDetailStepDef {
	
	CVDetailsPagePO cvDetails = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	AdvancedInterviewSchedulingPagePO advancedInterview = (AdvancedInterviewSchedulingPagePO) PageObjectWrapper.getInnerClassObject(InterviewSchedulingPagePO.class, AdvancedInterviewSchedulingPagePO.class);
	BasicInterviewSchedulingPagePO basicInterview = (BasicInterviewSchedulingPagePO) PageObjectWrapper.getInnerClassObject(InterviewSchedulingPagePO.class, BasicInterviewSchedulingPagePO.class);
	
	@Then("User should be able to see the requirment name on the candidate page")
	public void user_should_be_able_to_see_the_requirment_name_on_the_candidate_page() {
		Assert.assertTrue(cvDetails.verifyThePresenceOfRequirement(), 
				"The requirement title is not visible");
		TestNGLogUtility.pass("The requirement title is visible");
	}
	
	@Then("User should be able to see the call actions dd on CV details page")
	public void user_should_be_able_to_see_the_call_actions_dd_on_CV_details_page() {
		Assert.assertTrue(cvDetails.verifyThePresenceOfCallActions(), 
				"The call actions drop down is not visible on the CV details page");
		TestNGLogUtility.pass("The call actions drop down is visible on the CV details page");
	}

	@When("User marks the contact status of candidate as {string}")
	public void user_marks_the_contact_status_of_candidate_as(String actionString) {
	   cvDetails.selectCallAction(actionString);
	}

	@Then("User should be able to see {string} as the status")
	public void user_should_be_able_to_see_as_the_status(String callStatus) {
		Assert.assertTrue(cvDetails.verifyTheSelectedCallStatus(callStatus), 
				callStatus + " is not visible");
		TestNGLogUtility.pass(callStatus + " is visible on the CV Details Page");
	}

	@When("User comments {string} on the application created")
	public void user_comments_on_the_application_created(String commentText) {
		cvDetails.fillInCommentsOnCVDetailsPage(commentText);
	}

	@Then("User should be able to see the {string} in comments section as the comment on index {int}")
	public void user_should_be_able_to_see_the_in_comments_section_as_the_comment_on_index(String expectedCommentText, Integer index) {
	   Assert.assertTrue(cvDetails.verifyTheCommentTextOnIndex(expectedCommentText, index), 
			   expectedCommentText + " is not visible on the list of comments at inxed " + index);
	   TestNGLogUtility.pass(expectedCommentText + " is visible on the list of comments at index " + index);
	}

	@When("User gives the star rating to the application as {int} stars")
	public void user_gives_the_star_rating_to_the_application_as_stars(int starRatingValue) {
		cvDetails.fillInStarRating(starRatingValue);
	}

	@Then("User should be able to see the star rating value as {string}")
	public void user_should_be_able_to_see_the_star_rating_value_as(String expectedStarRating) {
		Assert.assertTrue(cvDetails.verifyTheStarRating(expectedStarRating), 
				expectedStarRating + " is not visible on the CV details page");
		TestNGLogUtility.pass(expectedStarRating + " is visible on the CV details page");
	}
	
	@When("User sees the video interview promotion")
	public void user_sees_the_video_interview_promotion() {
		cvDetails.clickOnCloseButtonForVideoPromotion();
	}
	
	@When("User fills in the interview venue as {string}")
	public void user_fills_in_the_interview_venue_as(String interviewVenueCity) {
		basicInterview.fillInterviewVenue(interviewVenueCity);
	}
	
	@When("User clicks on Give Feedback button of added candidate CV details page")
	public void user_clicks_on_Give_Feedback_button_of_added_candidate_CV_details_page() {
		cvDetails.clickGiveFeedbackButton();
	}

	@When("User provides the star rating as {string} to the candidate")
	public void user_provides_the_star_rating_as_to_the_candidate(String expectedStarRating) {
	   cvDetails.giveStarRatingForHMFeedback(expectedStarRating);
	}

	@When("User provides the {string} as approved comment")
	public void user_provides_the_as_approved_comment(String commentText) {
		cvDetails.addCommentForHMFeedback(commentText);
	}
	
	@When("User approves Candidate by clicking on {string} button")
	public void user_approves_Candidate_by_clicking_on_button(String btnText) {
	    cvDetails.clickOnActionButtonForHMFeedback(btnText);
	}
	
	@When("User provides InterviewDate as current date")
	public void user_provides_InterviewDate_as_current_date() {
	    basicInterview.interviewDate();
	}

	@When("User provides the Interview time as {string} hours and {string} minutes")
	public void user_provides_the_Interview_time_as_hours_and_minutes(String hour, String minutes) {
	   basicInterview.setInterviewTime(hour, minutes);
	}

	@When("User navigates to the added candidate CV details page")
	public void user_navigates_to_the_added_candidate_CV_details_page() {
		cvDetails.launchApplicationDetailPageViaURL();
	}

	@Then("User should be able to see the Assessment Feedback Block")
	public void user_should_be_able_to_see_the_Assessment_Feedback_Block() {
		Assert.assertTrue(cvDetails.verifyThePresenceOfAssessmentDiv(), 
				"Assessment div is not present on the CV Details Page");
		TestNGLogUtility.pass("Assessment div is present on the CV Details Page");
	}

	@When("User click on the View button of Other Requirement box on the right side of CV Details page")
	public void user_clickonTheViewButtonOfOtherRequirementBoxOnTheRightSideOfCVDetailsPage() {
		cvDetails.clickOnViewButtonOnCVDetailsPage();
	}
	@Then("user Verify {string} is visible")
	public void user_Verify_is_visible(String profileName) {
	    Assert.assertTrue(cvDetails.isMasterAndUnMappedProfileMailBoxDisplayed(profileName));
	    TestNGLogUtility.pass("The "+profileName+" is displayed to the user");
	}
	
	@Then("User should be able to see the {string} same as that present in URL formed")
	public void user_should_be_able_to_see_the_same_as_that_present_in_URL_formed(String keyString) {
	    Assert.assertTrue(cvDetails.verifyThePresenceOfApplicationIdOnCVDetailsPage(keyString), 
	    		keyString+" correct value is not displayed");
	    TestNGLogUtility.pass(keyString+" correct value is displayed");
	}
	
	@Then("User should be able to see the source as {string}")
	public void user_should_be_able_to_see_the_source_as(String sourceString) {
		Assert.assertTrue(cvDetails.verifyThePresenceOfSourceString(sourceString), 
				sourceString + " is not visible");
		TestNGLogUtility.pass(sourceString + " is visible");
	}

	@Then("User should be able to see the upload symbol")
	public void user_should_be_able_to_see_the_upload_symbol() {
	   Assert.assertTrue(cvDetails.verifyThePresenceOfUploadIcon(), 
			   "Upload Icon is not visible");
	  TestNGLogUtility.pass("Upload Icon is visible");
	}
	
	@When("User clicks on Request Document link on action bar")
	public void user_clicks_on_Request_Document_link_on_action_bar() {
		cvDetails.clickOnRequestDocument();
	}

	@Then("User should be able to see the message {string}")
	public void user_should_be_able_to_see_the_message(String expectedMessageString) {
		Assert.assertTrue(cvDetails.verifyThePresenceOfDocumentManagementString(expectedMessageString), 
				expectedMessageString + " is not available");
		TestNGLogUtility.pass(expectedMessageString + " is available");
	}

	@Then("User should be able to see a text field with placeholder {string}")
	public void user_should_be_able_to_see_a_text_field_with_placeholder(String placeholderString) {
		Assert.assertTrue(cvDetails.verifyThePresenceOfUploadField(placeholderString), 
				placeholderString + " is not displayed");
		TestNGLogUtility.pass(placeholderString + " is displayed");
	}

	@Then("User should be able to see a {string} button on DMS widget")
	public void user_should_be_able_to_see_a_button_on_DMS_widget(String btnString) {
		Assert.assertTrue(cvDetails.verifyThePresenceOfDMSActionButtons(btnString), 
				btnString+" is not displayed");
		TestNGLogUtility.pass(btnString+" is displayed");
	}
	
	@When("User scrolls down to Attached Documents section")
	public void user_scrolls_down_to_Attached_Documents_section() {
	    cvDetails.scrollDownToAttachmentSection();
	}

	@When("User clicks on {string} link")
	public void user_clicks_on_link(String linkText) {
	    cvDetails.clickOnDMSLink(linkText);
	}

	@When("User clicks on text field for documents list")
	public void user_clicks_on_text_field_for_documents_list() {
	    cvDetails.clickOnRequestDocumentForCandidate();
	}

	@Then("User should be able to see the following options")
	public void user_should_be_able_to_see_the_following_options(DataTable dt) {
	    List<String> defaultDocumentOption = dt.asList(String.class);
	    Assert.assertTrue(cvDetails.verifyDefaultDocumentOption(defaultDocumentOption), 
	    		defaultDocumentOption+ " is not displayed");
	    TestNGLogUtility.pass(defaultDocumentOption+ " is displayed");
	}
	
	@Then("User should be able to see the added options from account settings page")
	public void user_should_be_able_to_see_the_added_options_from_account_settings_page() {
		Assert.assertTrue(cvDetails.verifyTheAddedDocumentAddition(), 
				"Document names " + ManageDocumentsPO.documentName + PropFileHandler.readProperty("documentName")+ " added are not visible");
		TestNGLogUtility.pass("Document names " + ManageDocumentsPO.documentName + PropFileHandler.readProperty("documentName")+ " added are visible");
	}
	
	@When("User clicks on {string} for Document")
	public void user_clicks_on_for_Document(String documentName) {
		cvDetails.clickOnDocumentName(documentName);
	}

	@Then("User should be able to see all the documents checkbox checked")
	public void user_should_be_able_to_see_all_the_documents_checkbox_checked() {
	    Assert.assertTrue(cvDetails.verifyTheCheckboxOfAllDocumentsChecked(), 
	    		"The list of document's checkbox is not selected");
	    TestNGLogUtility.pass("The list of document's checkbox is selected");
	}

	@Then("User should be able to see the placeholder of input field as {string} followed by the number of documents")
	public void user_should_be_able_to_see_the_placeholder_of_input_field_as_followed_by_the_number_of_documents(String expectedStringPlaceholder) {
	    Assert.assertTrue(cvDetails.verifyTheCorrectPlaceholder(expectedStringPlaceholder),
	    		"Placeholder for the request document input field is not correct");
	    TestNGLogUtility.pass("Placeholder for the request document input field is correct");
	}

	@When("User clicks on {string} button for Document")
	public void user_clicks_on_button_for_Document(String btnText) {
		cvDetails.clickOnRequestDocumentActionBtn(btnText);
	}
	
	@Then("User should be able to see the success message {string} for document request mail sent")
	public void user_should_be_able_to_see_the_success_message_for_document_request_mail_sent(String expectedStringMessage) {
	    Assert.assertTrue(cvDetails.verifyTheDocumentSuccessMessage(expectedStringMessage), 
	    		expectedStringMessage + " is not displayed");
	    TestNGLogUtility.pass(expectedStringMessage + " is displayed");
	}
	
	@Then("User should be able to see the message as {string} for DMS")
	public void user_should_be_able_to_see_the_message_as_for_DMS(String dmsMessageText) {
	   Assert.assertTrue(cvDetails.verifyTheDMSMessageText(dmsMessageText),
			   dmsMessageText+" is not visible");
	   TestNGLogUtility.pass(dmsMessageText+" is visible");
	}

	@Then("User should be able to see a link of Send Reminder for the DMS")
	public void user_should_be_able_to_see_a_link_of_Send_Reminder_for_the_DMS() {
	    Assert.assertTrue(cvDetails.verifyThePresenceOfSendReminder(), 
	    		"Send Reminder for DMS is not visible");
	    TestNGLogUtility.pass("Send Reminder for DMS is visible");
	}

	@When("User clicks on link of Send Reminder")
	public void user_clicks_on_link_of_Send_Reminder() {
	    cvDetails.clickOnSendReminder();
	}

	@Then("User should be able to see the text {string} appearing next to send reminder")
	public void user_should_be_able_to_see_the_text_appearing_next_to_send_reminder(String expectedReminderSentMsg) {
		Assert.assertTrue(cvDetails.verifyThePresenceOfMsgForSendReminder(expectedReminderSentMsg), 
				expectedReminderSentMsg+ " is not displayed");
		TestNGLogUtility.pass(expectedReminderSentMsg+ " is displayed");
	}

	@Then("User uploaded image should also be visible on the CV")
	public void user_uploaded_image_should_also_be_visible_on_the_CV() {
	   Assert.assertTrue(cvDetails.verifyThePresenceOfCandidateImage(), 
			   "Image not visible on the CV details page");
	   TestNGLogUtility.pass("Image visible on the CV details page");
	}
	
	@Then("User should be able to see the requirement name the application is mapped with")
	public void user_should_be_able_to_see_the_requirement_name_the_application_is_mapped_with() {
		Assert.assertTrue(cvDetails.verifyThePresenceOfRequirementNameOnCVDetailsPage(), 
				"Requirement name is not displayed correct on the applications page");
		TestNGLogUtility.pass("Requirement name is displayed correct on the applications page");
	}

	@Then("User should be able to see the status of the application which was recorded from master profile")
	public void user_should_be_able_to_see_the_status_of_the_application_which_was_recorded_from_master_profile() {
	    Assert.assertTrue(cvDetails.verifyTheStatusOfApplication(), 
	    		"The status of the application is not same as mapped with the candidate profile");
	    TestNGLogUtility.pass("The status of the application is same as mapped with the candidate profile");
	}
	

}
