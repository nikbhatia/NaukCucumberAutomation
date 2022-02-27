package com.naukri.stepdefinitions.Offer;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Offer.OfferGenerationPagePO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryListingPO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
//import com.naukri.pageobjects.Offer.OfferGenerationSalaryTable;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferGenerationsalaryListingStepDef {
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferGenerationSalaryListingPO offerGenerationSalaryPO = (OfferGenerationSalaryListingPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryListingPO.class);

//	@Given("I login into RMS as test2 user")
//	public void LoginToRMSWithTest2User()
//	{
//		genericFunctions.test2Login("jatin.bisht@naukri.com","P@ssw0rd0987");
//		//genericFunctions.loginToRMS("jatin.bisht@naukri.com","P@ssw0rd0987");
//	}
	@When("Navigate to Salary Rule Listing Page")
	public void navigateToSalaryRuleListingPage()
	{
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.SalaryBreakupListing"));
	}
	@When("click on Create Salary Breakup")
	public void clickOnCreateSalaryBreakup()
	{
		offerGenerationSalaryPO.clickOnCreateSalaryBreakup();
	}
	
	@Then("Salary template rule name should be listed on page")
	public void salaryTemplateNameDisplayedOnListingPage()
	{
		Assert.assertTrue(offerGenerationSalaryPO.salaryTemplateRuleNameVisible(),"template not displayed");	
	}
	@Then("template should be in drafted state")
	public void templateDraftedState()
	{
		Assert.assertTrue(offerGenerationSalaryPO.draftLabelDisplayed(),"Draft state is not displayed");
	}
	@Then("verify the last modified date and last edited by {string}")
	public void verifyLastModifiedDateAndLastEditedBy(String userName)
	{
		Assert.assertTrue(offerGenerationSalaryPO.verifyLastModifiedANdLastEdited(userName),"Last modified and last edited not displayed correctly");
	}
	@Then("verify by default only {int} templates are displayed")
	public void verifyDefaultTemplatesDisplayed(int number)
	{
		Assert.assertTrue(offerGenerationSalaryPO.verifyCountTemplatesDisplayed(number),"By default 40 templates are not displayed");
	}
	@When("select {int} templates from DD")
	public void selectNumberOfTemplatesFromDD(int number)
	{
		offerGenerationSalaryPO.selectNumberFromTemplateDD(number);
	}
	@Then("verify {int} templates are displayed")
	public void verifyNumberOfTemplates(int number)
	{
		Assert.assertTrue(offerGenerationSalaryPO.verifyCountTemplatesDisplayed(number),"All Templates not displayed as were selected");
	}
	
	@When("click on delete template from salary breakup listing page")
	public void deleteTemplateListingPage()
	{
		offerGenerationSalaryPO.deleteTemplateListingPage();
	}

	@Then("deleted template should not be displayed")
	public void  verifyTemplateNotDisplayed()
	{
		Assert.assertFalse(offerGenerationSalaryPO.verifyTemplateNotDisplayed(),"template visible even after it is deleted");
	}
	@When("click on edit salary breakup template")
	public void clickOnEditBtnListingPage()
	{
		offerGenerationSalaryPO.editTemplateListingPage();
	}
	
	@When("edit template name on listing page and enter duplicate template name")
	public void enterDuplicateTemplateName()
	{
		offerGenerationSalaryPO.enterDuplicateTemplateName();
	}
	@Then("verify error message of not allowing duplicate template name should be displayed ie {string}")
	public void verifyErrorMessageDuplicateTemplateName(String error)
	{
		Assert.assertTrue(offerGenerationSalaryPO.verifyDuplicateNameNotAllowed(error),"unique template name is not displayed");
	}
	@When("enter invalid chars as template name {string}")
	public void enterInvalidCharsAsTemplateName(String invalidChar)
	{
		offerGenerationSalaryPO.clickOnCancelButtonTemplate();
		offerGenerationSalaryPO.enterInvalidCharsAsTemplateName(invalidChar);
	}
	@Then("verify invalid chars should not be allowed {string}")
	public void verifyInValidCharNotAllowed(String msg)
	{
		offerGenerationSalaryPO.verifyErrorMsgOnListingPage(msg);
	}
	
	@And("I delete all salary templates")
	public void deleteAllSalarTemplates(){
		offerGenerationSalaryPO.deleteAllSalaryTemplates();
	}
	
	@And("I delete all Offer Doc templates")
	public void deleteAllOfferDocTemplates(){
		offerGenerationSalaryPO.deleteAllOfferDocTemplates();
	}
}
