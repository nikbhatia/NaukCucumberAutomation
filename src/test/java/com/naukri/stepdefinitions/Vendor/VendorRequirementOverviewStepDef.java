package com.naukri.stepdefinitions.Vendor;



import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import io.cucumber.datatable.DataTable;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;

import com.naukri.pageobjects.Vendor.VendorRequirementOverviewPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;


public class VendorRequirementOverviewStepDef {

	VendorRequirementOverviewPO vendorRequirementOverviewActionPO = (VendorRequirementOverviewPO) PageObjectWrapper.getObject(VendorRequirementOverviewPO.class);
	GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	List<String> listOfVendorsToBeSelected;

	@And("User clicks on {string} Link on Requirement Overview Page")
	public void clickOnAddNewVendor(String linkName) {
		vendorRequirementOverviewActionPO.clickOnAssignVendorOnRequirementOverviewPage(linkName);
		TestNGLogUtility.info("clicked on  "+linkName+ " on requirement Overview page");
	}

	@And("User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor")
	public void addVendorDetails() {
		vendorRequirementOverviewActionPO.addVendorDetails();
		TestNGLogUtility.info("Requirement added to vendor");
	}
	@Then("Verify the success message is displayed on Requirement Overview page")
	public void verifyTheSuccessMessageIsDisplayedOnRequirementOverviewPage() {
		Assert.assertTrue(vendorRequirementOverviewActionPO.verifySuccessMessage());
		TestNGLogUtility.info("Verified Message before refresh");
	}
	@Then("Verify the success message should not displayed on Requirement Overview page after refresh")
	public void verifyTheSuccessMessageAfterRefresh(){
		genericFunction.pageRefresh();
		Assert.assertFalse(vendorRequirementOverviewActionPO.verifySuccessMessage());
		TestNGLogUtility.info("Verified Message after refresh");
	}

	@And("User Clicks on {string} for {string} on Requirement Overview page")
	public void userClicksOnEditAssignmentDetailsForOnRequirementOverviewPage(String optionname,String vendorname) {
		vendorRequirementOverviewActionPO.vendorOptions(optionname,vendorname);
		TestNGLogUtility.info("Clicked on " +optionname+ " on requirement overview page for  " +vendorname);

	}
	@Then("Verify that option to Reassign the requirement is available for {string} on Requirement Overview page")
	public void verifyUnassignReq(String vendorname) {
		Assert.assertTrue(vendorRequirementOverviewActionPO.verifyReassign(vendorname), "Test case failed : As option to reassign the requirement is not available");
		TestNGLogUtility.info("Reassign is available for "+vendorname);
	}
	@And("User clicks on send button in send reminder confirmation box")
	public void userClicksOnSendButtonInSendReminderConfirmationBox() {
		vendorRequirementOverviewActionPO.clickSendButton();
		TestNGLogUtility.info("clicked on send button in send reminder confirmation box ");

	}
	@And("User adds maxCv {string} for Vendor on Assign Requirement To Vendor")
	public void addMaxCv(String cvNumber ){
		vendorRequirementOverviewActionPO.addMaxCv(cvNumber);
	}
	@Then("Verify that message added to Overview Page")
	public void verifyClientMessageatOverview() {
		Assert.assertTrue(vendorRequirementOverviewActionPO.messageVerification(), "Test case failed : As client message is not displayed at overview page");
		TestNGLogUtility.info("Verified that message added to Overview Page");
	}

	@And("User adds below vendors on Assign Requirement to Vendor Page")
	public void userAddsOnAssignRequirementToVendorPage(DataTable dt) {
		listOfVendorsToBeSelected = dt.asList(String.class);
		vendorRequirementOverviewActionPO.assignMultipleVendor(listOfVendorsToBeSelected);
	}

	@Then("User Verify the count of vendors in closed DD should be same as of the chip count")
	public void verifySelectedVendorsNoOfVendorsShouldBeDisplayedInClosedDD() {
		Assert.assertTrue(vendorRequirementOverviewActionPO.verifySelectedVendor());
		TestNGLogUtility.pass("Verified the count of vendors in closed DD should be same as of the chip count");
	}

	@And("User verify the names of Vendor selected and displayed in chip list should be same")
	public void userVerifyTheNamesOfVendorSelectedAndDisplayedInChipListShouldBeSame() {
		Assert.assertTrue(vendorRequirementOverviewActionPO.verifySelectedVendorName(listOfVendorsToBeSelected));
		TestNGLogUtility.pass("Verified the count of vendors in closed DD should be same as of the chip count");
	}

	@When("User clicks on cross icon on the strip of success message")
	public void userClicksOnCrossIconOnTheStripOfSuccessMessage() {
		vendorRequirementOverviewActionPO.clickOnCrossIconOnTheMessageSuccessStrip();
	}

	@Then("User Verify below vendors are visible on Requirement Overview page")
	public void verifyVendorsVisibleOnRequirementOverviewPage(DataTable dt){
		List<String> listOfVendors = dt.asList(String.class);
		Assert.assertTrue(vendorRequirementOverviewActionPO.verifyVendorsVisibleOnRequirementOverviewPage(listOfVendors));
		TestNGLogUtility.pass("Vendors are visibleon requirement overview page");
	}
	@And("User clicks on assign vendor from more actions present below the requirement on all requirements page")
	public void selectAssignVendorFromAllRequirementsPage(){
		vendorRequirementOverviewActionPO.selectAssignVendorFromAllRequirementsPage();
		TestNGLogUtility.info("Clicked on Assign Vendor from all requirements page");
	}



	@And("User clicks on sources on all requirements page")
	public void clickOnSourcesOnAllRequirementsPage(){
		vendorRequirementOverviewActionPO.clickOnSourcesOnAllRequirementsPage();
		TestNGLogUtility.info("Clicked on sources on all requirements page");
	}
}
