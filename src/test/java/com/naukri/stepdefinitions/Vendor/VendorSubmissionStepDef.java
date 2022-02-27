package com.naukri.stepdefinitions.Vendor;

import com.naukri.automation.util.*;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.Offer.OfferValidationPagePO;
import com.naukri.pageobjects.Vendor.VendorPortalPO;
import com.naukri.pageobjects.Vendor.VendorSubmissionVerificationPO;
import com.naukri.test.base.CommonAction;
import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import org.bouncycastle.util.test.Test;
import org.testng.Assert;

import com.naukri.pageobjects.Vendor.VendorSubmissionPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendorSubmissionStepDef {
	VendorSubmissionPO vendorSubmissionPO = (VendorSubmissionPO) PageObjectWrapper.getObject(VendorSubmissionPO.class);
	MailBoxTabPO objMailBoxPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
	VendorPortalPO vendorPortalPO=(VendorPortalPO)PageObjectWrapper.getObject(VendorPortalPO.class);

	public String vendorRequirementname="",reqName="";
	public static JSUtility jsUtil;

	@When("User Add single profile with new requirement")
	public void addSingleProfileWithRequirement(){
		vendorRequirementname="TestAddSingle"+new Date().getTime();
		PropFileHandler.writeProperty("RequirementAssignedToVendor",vendorRequirementname);
		vendorSubmissionPO.addSingleProfileWithRequirement(vendorRequirementname);
	}

	@Then("Verify the new options for Vendor")
	public void verifyTabs(DataTable dt){
		List<String> lst = dt.asList(String.class);
		String message=(lst.get(0).toString());
		Assert.assertTrue(vendorPortalPO.verifyMessageTab(message));
		String EditAssignmentDetails=(lst.get(1).toString());
		Assert.assertTrue(vendorPortalPO.verifyEditAssignmentDetailsTab(EditAssignmentDetails));
		String Unassign=(lst.get(2).toString());
		Assert.assertTrue(vendorPortalPO.verifyUnassignTab(Unassign));
		TestNGLogUtility.info("Verified Vendor New Option");
		String SendReminder=(lst.get(3).toString());
		Assert.assertTrue(vendorPortalPO.verifySendReminderTab(SendReminder));
		TestNGLogUtility.pass("Verified Vendor New Option");
	}

	@Then("Go to Requirement List page and select the specific requirement")
	public void selectSpecificRequirement()
	{ vendorSubmissionPO.selectSpecificRequirement(PropFileHandler.readProperty("RequirementAssignedToVendor"));
		TestNGLogUtility.info("Selected the specific requirement ");
	}

	@And("Add requirement  to Vendor")
	public void addRequirementToVendor() {
		vendorSubmissionPO.addRequirementToVendor();
		TestNGLogUtility.info("Requirement added to vendor");
	}

	@Then("User Verify that Employer is able to view the Success message")
	public void verifyTheSuccessMessage()
	{
		Assert.assertTrue(vendorSubmissionPO.verifyTheSuccessMessage(),"Test case failed:Not able to verify");
		TestNGLogUtility.pass("Employer is able to view the Success message");
	}

	@And("User submit candidate on Vendor portal")
	public void verifyRequirementAndMoveToSubmitCandidate()
	{
		vendorSubmissionPO.verifyRequirementAndMoveToSubmitCandidate();
		TestNGLogUtility.info("Selected specific requirement and move to submit  candidate ");
	}

	@And("User Select Specific Requirement on Vendor Portal")
	public void selectSpecificRequirementOnVendorPortal(){
		vendorSubmissionPO.selectSpecificRequirementOnVendorPortal(PropFileHandler.readProperty("RequirementAssignedToVendor"));


	}
	@And("User Select specific requirement on Requirement list page")
	public void selectSpecificRequiremnetOnListPage(){
		vendorSubmissionPO.selectSpecificRequiremnetOnListPage(PropFileHandler.readProperty("RequirementAssignedToVendor"));
		TestNGLogUtility.info("Selected specific requirement from list of requirement page");

	}

	@And("User click on application count")
	public void clickOnApplicationCount(){
		vendorSubmissionPO.clickOnApplicationCount();
		TestNGLogUtility.info("Clicked on Application count against the vendor");
	}

	@And("User clicks on the vendor submitted candidate on SRP Page")
	public void selectSpecificRequirementAndClickOnCandidate_Profile()
	{
		Assert.assertTrue(vendorSubmissionPO.waitForTheApplicationOnSRPPage());
		vendorSubmissionPO.clickOnProfileOnSRPPage();
		TestNGLogUtility.info(" Clicked profile on SRP page");
	}

	@And("Vendor submit the resume of candidate")
	public void vendorCadSubmission() throws Exception {
		vendorSubmissionPO.vendorFormSubmit();
		TestNGLogUtility.info("Submitted candidate info");
	}
	@Then("Verify that Vendor is able to view the Success message")
	public void verifyApplicationSubmitMessage() {
		Assert.assertTrue(vendorSubmissionPO.verifyCandidateSubmitSuccessfully());
		TestNGLogUtility.pass("Vendor is able to view the success message");
	}

	@And("User Move the Candidate profile  to {string}")
	public void moveCandidateToStaging(String Staging){
		objMailBoxPO.setStatus(Staging);
		TestNGLogUtility.info("Moved Candidate to staging");
	}

	@And("User Set The Interview Details")
	public void setTheInterviewDetails()
	{
		vendorSubmissionPO.setInterviewDetails();
	}


	@Then("Verify that user is able to see updated staging {string} in pipeline")
	public void verifyUpdatedStagingInPipeline(String Staging)
	{
		Assert.assertTrue(vendorSubmissionPO.verifyUpdatedStagingInPipeline(PropFileHandler.readProperty("VendorCandidateName"),Staging));
		TestNGLogUtility.pass("User able to see staging in pipeline");
	}
	@Then("Verify user is able to see below options")
	public void verifyOptionsOnVendorRequirementOverviewPage(DataTable dt){
		List<String> lst = dt.asList(String.class);
		String requirement=(lst.get(0).toString());
		Assert.assertTrue(vendorSubmissionPO.verifyRequirementDetailsTab(requirement));
		String message=(lst.get(1).toString());
		Assert.assertTrue(vendorSubmissionPO.verifyMessageTab(message));
		String instructions=(lst.get(2).toString());
		Assert.assertTrue(vendorSubmissionPO.verifyInstructionsTab(instructions));
		String questionnaire=(lst.get(3).toString());
		Assert.assertTrue(vendorSubmissionPO.verifyQuestionnaireTab(questionnaire));
		TestNGLogUtility.pass("Verified Vendor Options on Vendor Portal");
	}
	@And("User is able to click on below options")
	public void verifyOptionsIsClickableOnVendorRequirementOverviewPage(DataTable dt){
		List<String> lst = dt.asList(String.class);
		vendorSubmissionPO.verifyOptionsIsClickableOnVendorRequirementOverviewPage(lst);
	}

	@And("User sends message to employer {string} from Vendor Portal")
	public void sendMessageToVendor(String message){
		vendorSubmissionPO.sendMessageFromVendorPortal(message);
		TestNGLogUtility.info("Sent Message To Employer-->"+message);
	}

	@And("User Verify the message {string}")
	public void userVerifyTheMessageSent(String messageVerify){
		Assert.assertTrue(vendorSubmissionPO.userVerifyTheMessageSent(messageVerify));
		TestNGLogUtility.pass("Message Sent To Employer->"+messageVerify+" is Verified");
	}
	@And("Verify {string} is displayed as Subheading")
	public void userVerifySubHeadingInsideTheTab(String name){
		Assert.assertTrue(vendorSubmissionPO.userVerifySubHeadingInsideTheTab(name));
		TestNGLogUtility.pass("User Verify->"+name+" is displayed");
	}

	@And("Verify {string} is displayed inside {string} tab sent by recuriter")
	public void userVerifyInformationSentByrecruiterInsideTheTab(String name,String tab){
		switch (tab){
			case "Message":
				Assert.assertTrue(vendorSubmissionPO.userVerifyInformationSentByrecruiterInsideTheMessageTab(name));
				break;
			case "Instructions":
				Assert.assertTrue(vendorSubmissionPO.userVerifyInformationSentByrecruiterInsideTheTab(name));
				break;
			case "Maximum Number of CVs Allowed":
				Assert.assertTrue(vendorSubmissionPO.userVerifyInformationSentByrecruiterInsideTheTab(name));
				break;

		}
		TestNGLogUtility.pass("User Verify->"+name+" is displayed inside "+ tab);
	}


	@And("Verify User is able to see {string} in placeholder in message text box")
	public void verifyPlaceholderMessageInsideTextBoxOnVendorPortal(String message){
		Assert.assertTrue(vendorSubmissionPO.verifyPlaceholderMessageInsideTextBoxOnVendorPortal(message));
		TestNGLogUtility.pass("User Verify->"+message+" is displayed in message text box placeholder ");
	}

	@And("Verify user is able to see recruiter name {string} in the message tab")
	public void verifyUserIsAbleToSeeRecruiterName(String name){
		Assert.assertTrue(vendorSubmissionPO.userVerifyInformationSentByrecruiterInsideTheTab(name));
		TestNGLogUtility.pass("User Verify recruiter->"+name+" is displayed in message tab ");
	}

	@And("User refresh the page till the time vendor candidate submitted is not displayed")
	public void refreshTillTheCandidateIsNotDisplayed(){
		Assert.assertTrue(vendorSubmissionPO.refreshTillTheCandidateIsNotDisplayed());
		TestNGLogUtility.pass("Refreshed till Vendor Candidate is not displayed");
	}

	@And("User click on {string} employer")
	public void clickEmployer(String employername)
	{
		vendorSubmissionPO.clickEmployer(employername);
		TestNGLogUtility.info("Clicked on" + employername);
	}


	@And("User click on {string} on vendorportal")
	public void clickOnNaukriRMS(String name)
	{vendorSubmissionPO.clickOnNaukriRMS(name);
	TestNGLogUtility.info("Clicked on" + name);
	}

	@And("User clicks on {string} on requirement overview page on vendorPortal")
	public void clickOnSubmittedOnVendorPortal(String name){
		vendorSubmissionPO.clickOnSubmitted(name);
		TestNGLogUtility.info("Clicked on" + name + " requirement overview page on vendorportal");
	}

	@And("User click on Submitted Candidate Name")
	public void clickOnSubmittedCandidateName(){
		vendorSubmissionPO.clickOnSubmittedCandidateName();
	}

	@And("User clicks on message icon below the candidate submitted by vendor")
	public void clickOnMessageIconOnSRPPage(){
		vendorSubmissionPO.clickOnMessageIconOnSRPPage();
	}

	@And("Verify User is able to see {string} on cv details page")
	public void verifyDetailsOnCvDetailsPage(String name){
		Assert.assertTrue(vendorSubmissionPO.verifyDetailsOnCvDetailsPage(name));
		TestNGLogUtility.pass(name +" --> is Displayed on cv details page");
	}

	@And("Verify User is able to see {string} in placeholder for vendor message box")
	public void verifyMessageInPlaceholder(String message){
		Assert.assertTrue(vendorSubmissionPO.verifyMessageInPlaceholder(message));
		TestNGLogUtility.pass(message +" --> is Displayed in placeholder");
	}

	@And("User click on {string} on cv details page for vendor message")
	public void clickOnMessageBox(String message){
		vendorSubmissionPO.clickOnMessageBox(message);
		TestNGLogUtility.pass(message +" -->clicked");
	}

	@And("User sends {string} message to recruiter")
	public void sendMessageToRecruiter(String message){
		vendorSubmissionPO.sendMessageToRecruiter(message);
		TestNGLogUtility.pass("Sent the message");
	}

	@And("Verify {string} message is displayed for vendor")
	public void verifyMessageSentToRecruiter(String message){
		Assert.assertTrue(vendorSubmissionPO.verifyMessageSentToRecruiter(message));
		TestNGLogUtility.pass("Message is displayed ");
	}
	@And("Verify User is not able to see {string} on cv details page")
	public void verifyDetailsOnCvDetailsPageShouldNotCome(String name){
		Assert.assertFalse(vendorSubmissionPO.verifyDetailsOnCvDetailsPage(name));
		TestNGLogUtility.pass(name +" --> is Displayed on cv details page");
	}

	@And("Verify {string} is displayed in the sender name")
	public void verifySenderNameOnCvDetailsPage(String SenderNameDetails){
		vendorSubmissionPO.verifySenderNameOnCvDetailsPage(SenderNameDetails);
	}

	@Then("Verify the count of message should be {string}")
	public void verifyTheCountOfMessages(String number){
		vendorSubmissionPO.verifyTheCountOfMessages(number);
		TestNGLogUtility.pass("Message count is->"+number+ "Verified");
	}






	@And("User refresh the page till the time vendor candidate submitted is not displayed on CV details page")
	public void refreshTillTheTimeVendorCandidateIsNotDisplayed(){
		Assert.assertTrue(vendorSubmissionPO.refreshTillTheTimeVendorCandidateIsNotDisplayed());
		TestNGLogUtility.info("Submitted Candidate is displayed on CV details Page");
	}

	@And("Verify user is able to see {string} notification for Vendor")
	public void verifyNotificationForVendor(String notificationName){
		Assert.assertTrue(vendorSubmissionPO.verifyNotificationForVendor(notificationName));
	}

	@And("User click on more on notification on rmsDashboardPage")
	public void clickOnMoreOnNotification(){
		vendorSubmissionPO.clickOnMoreNotificationRMSDashboard();
		TestNGLogUtility.info("Clicked on More on Dashboard notification");
	}

	@And("User click on notification {string} recieved when vendor sends message to recruiter")
	public void clickOnNotificatioRecievedWhenVendorSendMessage(String notificationName){
		vendorSubmissionPO.clickOnNotificatioRecievedWhenVendorSendMessage(notificationName);
	}

	@And("User fills the company name as {string} for vendor messages")
	public void changeCompanyName(String companyName){
		vendorSubmissionPO.changeCompanyName(companyName);
	}

}
