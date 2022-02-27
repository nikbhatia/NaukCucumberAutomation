package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.DMSPagePO;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Document Management System Step Definitions
 * @author rachit.mehrotra
 *
 */
public class DMSStepDef {
	
	DMSPagePO dmsPagePO = (DMSPagePO) PageObjectWrapper.getObject(DMSPagePO.class);
	
	@Then("User should be able to see the {string} tag on the compose mail screen")
	public void user_should_be_able_to_see_the_tag_on_the_compose_mail_screen(String documentName) {
		Assert.assertTrue(dmsPagePO.verifyThePresenceOfDocumentTag(documentName), 
				"Tag of " + documentName + " is not visible");
		TestNGLogUtility.pass("Tag of " + documentName + " is visible");
	}

	@When("User clicks on legal acceptance checkbox")
	public void user_clicks_on_legal_acceptance_checkbox() {
	    dmsPagePO.clickOnLegalAcceptance();
	}
	
	@When("User clicks on {string} button for DMS")
	public void user_clicks_on_button_for_DMS(String btnText) {
		dmsPagePO.clickOnActionBtn(btnText);
	}
	
	@Then("User should be able to see the error message as {string} on DMS mail")
	public void user_should_be_able_to_see_the_error_message_as_on_DMS_mai(String errorMessage) {
	    Assert.assertTrue(dmsPagePO.verifyThePresenceOfErrorMessageForLegalAbsence(errorMessage), 
	    		errorMessage + " is not displayed on DMS mail");
	    TestNGLogUtility.pass(errorMessage + " is displayed on DMS mail");
	}
	
	@Then("User should be able to see the message as {string}")
	public void user_should_be_able_to_see_the_message_as(String actualText) {
	    Assert.assertTrue(dmsPagePO.verifyTheTextOfLegalDesc(actualText), 
	    		actualText+" is not visible");
	    TestNGLogUtility.pass(actualText+" is visible");
	}
	
	@When("User clicks on Request Documents link on mail screen")
	public void user_clicks_on_Request_Documents_link_on_mail_screen() {
		dmsPagePO.clickOnRequestDocument();
	}

	@When("User selects {string} from Document List on mail screen")
	public void user_selects_from_Document_List_on_mail_screen(String documentNameToBeSelected) {
	   dmsPagePO.clickOnDocumentName(documentNameToBeSelected);
	}
	
	@Then("User should be able to see the heading as {string}")
	public void user_should_be_able_to_see_the_heading_as(String expectedHeadingOfPreview) {
	    Assert.assertTrue(dmsPagePO.verifyTheHeadingOfPreview(expectedHeadingOfPreview), 
	    		expectedHeadingOfPreview + " is not visible for the heading");
	    TestNGLogUtility.pass(expectedHeadingOfPreview + " is visible for the heading text");
	}

	@Then("User should be able to see the signature as a part of message body")
	public void user_should_be_able_to_see_the_signature_as_a_part_of_message_body() {
	    Assert.assertTrue(dmsPagePO.verifyThePresenceOfSignature(), 
	    		SettingsDashboardPO.signatureText + " is not visible for preview");
	    TestNGLogUtility.pass(SettingsDashboardPO.signatureText + " is visible for preview");
	}

	@When("User clicks on the {string} on preview lightbox")
	public void user_clicks_on_the_on_preview_lightbox(String btnTextOfActionBtn) {
		dmsPagePO.clickOnActionBtnForDMSPreview(btnTextOfActionBtn);
	}
	
	@When("User checks the checkbox for include signature")
	public void user_checks_the_checkbox_for_include_signature() {
	    dmsPagePO.clickOnIncludeSignatureCheckbox();
	}


}

