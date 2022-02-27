package com.naukri.stepdefinitions.Offer;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Offer.offerDocTemplatePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferDocTemplateStepDef {
	offerDocTemplatePO offerDocObject = (offerDocTemplatePO) PageObjectWrapper.getObject(offerDocTemplatePO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

	@When("Navigate to Offer Doc Listing Page")
	public void navigateToSalaryRuleListingPage()
	{
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.offerDoclisting"));
	}
	@When("click on add new offer document template")
	public void clickAddNewOfferDocument() {
		offerDocObject.clickAddNewOfferDoc();
	}

	@When("enter offer doc template name")
	public void enterOfferDocTemplateName() {
		offerDocObject.enterOfferDocTemplateName();
	}

	@When("check whether salary breakup template exists in system or not , if not create one")
	public void createSalaryBreakupIfnotExists() {
		offerDocObject.ifSalarytemplateNotPresentCreate();
	}

	@When("select salary rule name from Salary Breakup rule name DD")
	public void selectSalaryRuleNameFromDD() {
		offerDocObject.SelectSalaryBreakupDD();
	}

	@When("click on save offer doc template")
	public void clickOnSaveOfferDocTemplate() {
		offerDocObject.clickOnSaveOfferDocTemplate();
	}

	@Then("verify offer doc template, salary breakup rule name, created by and last modified is displayed")
	public void verifyOfferDocRowOnListingPage() {
		Assert.assertTrue(offerDocObject.verifyOfferDocRowOnListingPage(),
				"offer doc entry on listing page is not correct");
	}

	@When("click on delete offer doc template on listing page")
	public void deleteOfferDocTemplateOnListingPage() {
		offerDocObject.deleteDocTemplate();
	}

	@Then("confirmation strip should be displayed on listing page")
	public void confirmationDocIsDeleted() {
		Assert.assertTrue(offerDocObject.deleteStripOnListingDisplayed(),
				"deletion strip is not displayed on listing page");
	}

	@Then("offer doc template should be deleted from listing page")
	public void offerDocTemplateShdBeDeletedListing() {
		Assert.assertFalse(offerDocObject.verifyOfferDOcTemplateNotDisplayed(),
				"offer doc template displayed even after deletion");
	}
	@When("click on Salary Breakup rule name DD")
	public void clickSalaryBreakupRuleFromDD()
	{
		offerDocObject.clickSalaryBreakupDD();
	}
	@When("select the created salary breakup template")
	public void selectCreatedSalaryBreakup()
	{
		offerDocObject.selectCreatedSalaryBreakup();
	}
	@Then("verify salary breakup name should not be displayed")
	public void verifySalaryBreakupTemplateNotDisplayed()
	{
		Assert.assertFalse(offerDocObject.verifySalaryBreakupNotDisplayedOnListing(),"salary breakup is displayed on doc listing page even after deleting breakup table");
	}
	@Then("verify salary breakup name should not be displayed in Salary Breakup rule name DD")
	public void verifySalaryBreakupNotDisplayedOnDD()
	{
		Assert.assertFalse(offerDocObject.verifySalaryBreakupNotDisplayedOnDD(),"Salary breakup should not be displayed when deleted");
	}
	@When("click on edit offer doc template on listing page")
	public void clickEditOfferDocIcon()
	{
		offerDocObject.clickEditOfferDocDOcListingPage();
	}
	@When("edit doc template name")
	public void editDocTemplateName()
	{
		offerDocObject.editDocTemplateName();
	}
	@When("select another salary rule name from Salary Breakup rule name DD")
	public void selectAnotherSalaryRuleName()
	{
		offerDocObject.selectAnotherRuleName();
	}
	
	@When("inline editing the created offer doc template name from listing page")
	public void editCreatedOfferDocTemplateNameFromListingPage() {
		offerDocObject.InlineEditCreatedTemplateFromListingPage();
	}

	@Then("verify offer doc template name is edited")
	public void verifyDocTemplateNameEdited() {
		Assert.assertTrue(offerDocObject.verifyDocTemplateNameEdited(),
				"template name is not edited on offer doc listing page");
	}

	@Then("verify the salary breakup template name is displayed")
	public void verifySalaryBreakupDisplayedUnderDD() {
		Assert.assertTrue(offerDocObject.verifySalaryBreakupNotDisplayedOnDD(),
				"salary breakup not displayed under DD");
	}
	
}