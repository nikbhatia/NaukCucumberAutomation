package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CandidateDetailsPagePO;
import com.naukri.pageobjects.Applications.MasterProfileListingPagePO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CandidateDetailsStepDef {
	
	MasterProfileListingPagePO masterProfileListingPO = (MasterProfileListingPagePO) PageObjectWrapper.getObject(MasterProfileListingPagePO.class);
	CandidateDetailsPagePO candidateDetaislPagePO = (CandidateDetailsPagePO) PageObjectWrapper.getObject(CandidateDetailsPagePO.class);
	
	@When("User clicks on the name of the candidate on the SRP page")
	public void user_clicks_on_the_name_of_the_candidate_on_the_SRP_page() {
		masterProfileListingPO.clickOnMasterProfileCandidateName();
	}

	@Then("User should be redirected to the candidate details page")
	public void user_should_be_redirected_to_the_candidate_details_page() {
	    Assert.assertTrue(candidateDetaislPagePO.verifyThePresenceOfCandidateDetailsPage(), 
	    		"Candidate's Detail Page is not visible");
	    TestNGLogUtility.pass("Candidate's Detail Page is visible");
	}

	@Then("I should be able to see the success ribbon with a message as {string} on CandidateDetailsPage")
	public void i_should_be_able_to_see_the_success_ribbon_with_a_message_as_on_CandidateDetailsPage(String expectedString) {
		Assert.assertTrue(candidateDetaislPagePO.verifyThePresenceOfSuccessMessage(expectedString), 
				expectedString+ " is not displayed");
		TestNGLogUtility.pass(expectedString+ " is displayed");
	}
	
	@When("User clicks on the forward option on candidate details page")
	public void user_clicks_on_the_forward_option_on_candidate_details_page() {
		candidateDetaislPagePO.clickOnForwardForCandidateDetailsPage();
	}

	@When("User clicks on the Attach button")
	public void user_clicks_on_the_Attach_button() {
	    candidateDetaislPagePO.clickOnAttachButton();
	}

	@Then("User should be able to see the Attached Documents section")
	public void user_should_be_able_to_see_the_Attached_Documents_section() {
	    Assert.assertTrue(candidateDetaislPagePO.verifyTheTextPresenceOfDocumentsSection("Attached Documents"), 
	    		"Attached Documents is not visible");
	    TestNGLogUtility.pass("Attached Documents is visible");
	}

	@Then("User should be able to see the informational text {string} under the document drop down")
	public void user_should_be_able_to_see_the_informational_text_under_the_document_drop_down(String text) {
		Assert.assertTrue(candidateDetaislPagePO.verifyTheTextPresenceOfDocumentsSection(text), 
				text + " is not displayed");
		TestNGLogUtility.pass(text + " is not displayed");
	}

	@Then("User should be able to see the button with text {string}")
	public void user_should_be_able_to_see_the_button_with_text(String buttonText) {
		Assert.assertTrue(candidateDetaislPagePO.verifyThePresenceOfButtonInDocumentSection(buttonText), 
				buttonText + " is not visible");
		TestNGLogUtility.pass(buttonText+" is visible");
	}
	
	@Then("User should be able to see the {string} on requirement widget")
	public void user_should_be_able_to_see_the_on_requirement_widget(String expectedWidgetTitle) {
	    Assert.assertTrue(candidateDetaislPagePO.verifyThePresenceOfTitle(expectedWidgetTitle), 
	    		expectedWidgetTitle+" is not visible on the candidate details page");
	    TestNGLogUtility.pass(expectedWidgetTitle+" is not visible on the candidate details page");
	}

	@Then("User should be able to see the name of the requirement to which the application was mapped")
	public void user_should_be_able_to_see_the_name_of_the_requirement_to_which_the_application_was_mapped() {
	    Assert.assertTrue(candidateDetaislPagePO.verifyTheRequirementNameInRequirementWidget(), 
	    		"Correct requirement name is not visible");
	    TestNGLogUtility.pass("Correct requirement name is not visible");
	}

	@Then("User should be able to see the link with text {string} under the requirement")
	public void user_should_be_able_to_see_the_link_with_text_under_the_requirement(String linkText) {
	   	Assert.assertTrue(candidateDetaislPagePO.verifyTheLinkPresenceOfRequirement(linkText), 
	   			linkText+" is not visible");
	   	TestNGLogUtility.pass(linkText+" is visible");
	}

	@When("User records the status of the application linked to the master profile")
	public void user_records_the_status_of_the_application_linked_to_the_master_profile() {
		candidateDetaislPagePO.recordTheStatusOfApplicationMapped();
	}

	@When("User clicks on the click with text {string} under the requirement")
	public void user_clicks_on_the_click_with_text_under_the_requirement(String linkText) {
	    candidateDetaislPagePO.clickOnLinkUnderRequirementInRequirementWidget(linkText);
	}
	
	@Then("User should not be able to see the star rating widget on the candidate details page")
	public void user_should_not_be_able_to_see_the_star_rating_widget_on_the_candidate_details_page() {
		Assert.assertFalse(candidateDetaislPagePO.checkTheAbsenceOfStarRating(), 
				"Status Change DD is visible on the candidate details page");
		TestNGLogUtility.pass("Status Change DD is not visible on the candidate details page");
	}
	
	@Then("User should not be able to see the status drop down on the candidate details page")
	public void user_should_not_be_able_to_see_the_status_drop_down_on_the_candidate_details_page() {
		Assert.assertFalse(candidateDetaislPagePO.checkTheAbsenceOfStatusDD(), 
				"Status Change DD is visible on the candidate details page");
		TestNGLogUtility.pass("Status Change DD is not visible on the candidate details page");
	}
	
	@Then("User should be able to see the success message as {string} for added qualification")
	public void user_should_be_able_to_see_the_success_message_as_for_added_qualification(String expectedSuccessMessage) {
	    Assert.assertTrue(candidateDetaislPagePO.verifyTheExpectedSuccessMessageOnQualificationAddition(expectedSuccessMessage), 
	    		expectedSuccessMessage+" is not displayed");
	    TestNGLogUtility.pass(expectedSuccessMessage+" is not displayed");
	}
	
	@Then("User should not be able to see the {string} button on the candidate details page")
	public void user_should_not_be_able_to_see_the_button_on_the_candidate_details_page(String btnText) {
		Assert.assertFalse(candidateDetaislPagePO.verifyThePresenceOfActionButton(btnText), 
				btnText+" is visible on the candidate details page");
		TestNGLogUtility.pass(btnText+" is not visible on the candidate details page");
	}
	
	@Then("User should not be able to see the Request documents link on the candidate details page")
	public void user_should_not_be_able_to_see_the_Request_documents_link_on_the_candidate_details_page() {
	    Assert.assertFalse(candidateDetaislPagePO.verifyTheAbsenceOfRequestDocumentLink(),
	    		"Request Document link is visible");
	    TestNGLogUtility.pass("Request Document link is not visible");
	}

	@Then("User should be able to see the {string} date of present day")
	public void user_should_be_able_to_see_the_date_of_present_day(String dateLabelString) {
		Assert.assertTrue(candidateDetaislPagePO.verifyThePresentDayDate(dateLabelString), 
				dateLabelString+" is not visible with the current date");
		TestNGLogUtility.pass(dateLabelString+" is visible with the current date");
	}
	
	@Then("User should not be able to see {string} under {string} on details page")
	public void user_should_not_be_able_to_see_under_on_details_page(String link, String sectionOfPage) {
	    Assert.assertFalse(candidateDetaislPagePO.verifyThePresenceOfLinkUnderSection(link, sectionOfPage),
	    		link + " is displayed under " + sectionOfPage + " section");
	    TestNGLogUtility.pass(link + " is not displayed under " + sectionOfPage + " section");
	}
	
	@Then("User should not be able to see Add Certificate under Education on details page")
	public void user_should_not_be_able_to_see_Add_Certificate_under_on_details_page() {
	    Assert.assertTrue(candidateDetaislPagePO.checkTheVisibilityOfAddCertificate(),
	    		"Add certificate link is not visible");
	    TestNGLogUtility.pass("Add certificate link is visible");
	}


}
