package com.naukri.stepdefinitions.Requirements;

import org.testng.Assert;
import org.testng.reporters.jq.TestNgXmlPanel;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requirements.VendorHelperPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VendorHelperStepDef {
	
	VendorHelperPagePO vendorHelperPagePO = (VendorHelperPagePO) PageObjectWrapper.getObject(VendorHelperPagePO.class); 
	
	@When("I click on the vendor name")
	public void i_click_on_the_vendor_name() {
		vendorHelperPagePO.clickOnEmployerNameOnVendorDashboard();
	}

	@Then("I must be redirected to the list of requirements with heading {string}")
	public void i_must_be_redirected_to_the_list_of_requirements_with_heading(String expectedTitleOfPage) {
		Assert.assertTrue(vendorHelperPagePO.verifyTheListOfRequirementPageForVendorPortal(expectedTitleOfPage),
				"Expected title of the requirement listing page is not " + expectedTitleOfPage);
		TestNGLogUtility.pass("Expected title of the requirement listing page is not " + expectedTitleOfPage);
	}

	@When("I click on the requirement name of the requirement created above")
	public void i_click_on_the_requirement_name_of_the_requirement_created_above() {
		vendorHelperPagePO.clickOnRequirementNameCreated();
	}
	
	@When("I click on the submit candidate button")
	public void i_click_on_the_submit_candidate_button() {
		vendorHelperPagePO.clickOnSubmitCandidateButton();
	}

	@Then("I should be able to see the interface with heading {string} for a vendor")
	public void i_should_be_able_to_see_the_interface_with_heading_for_a_vendor(String expectedVendorLightboxTitle) {
		Assert.assertTrue(vendorHelperPagePO.verifyThePresenceOfVendorLightbox(expectedVendorLightboxTitle),
				"The expected title of the vendor lightbox page is not " + expectedVendorLightboxTitle);
		TestNGLogUtility.pass("The expected title of the vendor lightbox page is " + expectedVendorLightboxTitle);
	}

}
