package com.naukri.stepdefinitions.MLH;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.HiringManager.ManageGroupPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.MLH.MLHRequirementListingPagePO;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.pageobjects.Vendor.VendorRequirementOverviewPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequisitionOverviewPageStepDef {
	
	//Variable
	static String candidateEmailID;
	
	CommonAction CommonActionObject = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageGroupPagePO mangeGroupPageObject = new ManageGroupPagePO();
	MLHRequirementListingPagePO requirementListingPageObject = new MLHRequirementListingPagePO();
	RequirementPagePO requirementPageObject = new RequirementPagePO();
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	RequirementOverviewPagePO requirementOverviewPagePO = (RequirementOverviewPagePO) PageObjectWrapper.getObject(RequirementOverviewPagePO.class);
	ManageGroupPO manageGroupPO = (ManageGroupPO) PageObjectWrapper.getObject(ManageGroupPO.class);
	VendorRequirementOverviewPO vendorRequirementOverviewPO = (VendorRequirementOverviewPO) PageObjectWrapper.getObject(VendorRequirementOverviewPO.class);
	SoftAssert softAssert = new SoftAssert();
	
	
	@Then("Verify that {string} button is not displayed on requirement overview page")
	public void verifyAbsenceOfTab(String tabName)
	{
		Assert.assertFalse(cvDetailsPagePO.isButtonDisplayed(tabName));
		TestNGLogUtility.pass(tabName+" is not displayed on overview page");	
	}
	
	@Then("Verify that Apply Response Filters button is not displayed under Response Filters tab")
	public void verifyAbsenceOfButton()
	{
		Assert.assertFalse(requirementOverviewPagePO.verifyPresenceOfAddResponseFilter(), "Apply Response Filters button is displayed under Response Filters tab");
		TestNGLogUtility.pass("Verify that Apply Response Filters button is not displayed under Response Filters tab");
	}
	
	@And("Verify that {string} title is not displayed")
	public void verifyTitleAbsence(String title)
	{
		Assert.assertFalse(manageGroupPO.labelVerify(title),"Test failed: "+title+" is present");
		TestNGLogUtility.pass(title+" is displayed");
	}
	
//	@When("User click and hold {string} stage and drags it to {string} stage")
//	public void dragAndDropSelectionStage(String stageNameToBeDragged, String stageNameToDropDraggedStage) throws AWTException
//	{
//		requirementOverviewPagePO.dragStage(stageNameToBeDragged, stageNameToDropDraggedStage);
//		TestNGLogUtility.info("User click and hold "+stageNameToBeDragged+" stage and drags it to "+stageNameToDropDraggedStage+" stage");
//	}
	
	@Then("Verify that user cannot change status of requirement from overview page")
	public void verifyAbsenceOfStatusChangeDD()
	{
		Assert.assertFalse(requirementOverviewPagePO.presenceOfStatusChangeDD(),"Test Failed: Status change dd was present");
		TestNGLogUtility.pass("User cannot change status of requirement from overview page");
	}
	
	@Then("Verify message textarea is not displayed for vendor message on requirement overview")
	public void verifyAbsenceOfMessageBox()
	{
		Assert.assertFalse(vendorRequirementOverviewPO.verifyPresenceOfMessageBox(),"Test failed: MessageBox displayed");
		TestNGLogUtility.pass("Message textarea is not displayed for vendor message on requirement overview");
	}
	
	@And("Verify that {string} button is displayed on requirement overview page")
	public void verifyPresenceOfButton(String button)
	{
		Assert.assertTrue(cvDetailsPagePO.isButtonDisplayed(button));
		TestNGLogUtility.pass(button+" is displayed on overview page");	
	}

}
