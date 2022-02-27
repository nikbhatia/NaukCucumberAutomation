package com.naukri.stepdefinitions.HiringManager;

import org.testng.Assert;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.HiringManager.HMDashboardPagePO;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.pageobjects.Requirements.RequirementListingPagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMRequirementListingPageStepDef {
	
	RequirementListingPagePO requirementListingPagePO = (RequirementListingPagePO) PageObjectWrapper.getObject(RequirementListingPagePO.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	ManageGroupPO manageGroupPO = (ManageGroupPO) PageObjectWrapper.getObject(ManageGroupPO.class);
	HMDashboardPagePO hmDashboardPagePO = (HMDashboardPagePO) PageObjectWrapper.getObject(HMDashboardPagePO.class);
	static int totalRequirementCountDashboardForHM;
	
	@Then("Verify User does not see the Filter by {string}")
	public void userShouldNotSeeFilterBy(String filterText) 
	{
		   Assert.assertFalse(requirementListingPagePO.checkThePresenceOfStatusFilter(filterText),"The " + filterText + " is displayed");
		   TestNGLogUtility.pass("The " + filterText + " is not displayed");
	}
	
	@And("User gets the name of top requirement")
	public void userGetsNameOfTopRequirement()
	{
		RequirementCreationPagePO.requirementName = requirementListingPagePO.getNameOfTopRequirement();
		TestNGLogUtility.info("User gets the name of top requirement as "+RequirementCreationPagePO.requirementName);
	}
	
	@Then("Verify that {string} button is not displayed on HM requirement listing")
	public void verifyAbsenceOfButtonORequirementListing(String btnName)
	{
		Assert.assertFalse(cvDetailsPagePO.isButtonDisplayed(btnName), btnName+ " is displayed");
		TestNGLogUtility.pass(btnName+" is not displayed");
	}
	
	@And("Verify that comment count is not displayed on HM requirement listing")
	public void verifyAbsenceOfCommentBtn()
	{
		Assert.assertFalse(requirementListingPagePO.presenceOfCommentCountForTopRequirement(),"Comment count is displayed on HM requirement listing");
		TestNGLogUtility.pass("Comment count is not displayed on HM requirement listing");
	}
	
	@And("Verify {string} filter is present in refine requirement lightbox")
	public void verifyPresenceOfSubfilterUnderRefineReqFilter(String filterName)
	{
		Assert.assertTrue(requirementListingPagePO.presnceOfFilterUnderRefineRequirementOnRequirementListing(filterName), filterName+" filter is not present in refine requirement lightbox");
		TestNGLogUtility.pass(filterName+" filter is present in refine requirement lightbox");
	}
	
	@And("Verify {string} filter is not present in refine requirement lightbox")
	public void verifyAbsenceOfSubfilterUnderRefineReqFilter(String filterName)
	{
		Assert.assertFalse(requirementListingPagePO.presnceOfFilterUnderRefineRequirementOnRequirementListing(filterName), filterName+" filter is present in refine requirement lightbox");
		TestNGLogUtility.pass(filterName+" filter is not present in refine requirement lightbox");
	}
	
	@Then("Verify {string} button is displayed for created requirement")
	public void verifyPresenceOfBtnForCreatedRequirement(String btnName)
	{
		Assert.assertTrue(requirementListingPagePO.presenceOfButtonForRequirement(btnName,PropFileHandler.readProperty("RequirementName")), btnName+" button is not displayed for created requirement");
		TestNGLogUtility.pass(btnName+"  button is displayed for created requirement");
	}
	
	@Then("Verify {string} button is not displayed for created requirement")
	public void verifyAbsenceOfBtnForCreatedRequirement(String btnName)
	{
		Assert.assertFalse(requirementListingPagePO.presenceOfButtonForRequirement(btnName,PropFileHandler.readProperty("RequirementName")), btnName+" button is displayed for created requirement");
		TestNGLogUtility.pass(btnName+"  button is not displayed for created requirement");
	}
	
	@And("User click on {string} button for requirement on HM Requirement listing")
	public void clickOnBtnOnRequirementListing(String btnName)
	{
		requirementListingPagePO.clickOnButtonForRequirement(btnName,PropFileHandler.readProperty("RequirementName"));
		TestNGLogUtility.info("User click on "+btnName+" button for "+PropFileHandler.readProperty("RequirementName")+" on HM Requirement listing");
	}
	
	@Then("User should be able to see the text {string} on lightbox")
	public void verifyPresenceOfTextOnLB(String txt)
	{
		Assert.assertTrue(manageGroupPO.verifyErrorMsg(txt), "Text is not same as expected");
		TestNGLogUtility.pass(txt+"  is displayed");
	}
	
	@When("User click on Close button on lightbox")
	public void clickOnBtnOnLB()
	{
		requirementListingPagePO.clickOnCloseButtonOnCloseRequirementLightbox();
		TestNGLogUtility.info("User click on Close button on lightbox");
	}
	
	@And("User gets count of requirement from dashboard")
	public void getAllRequirementCountFromDashboard()
	{
		totalRequirementCountDashboardForHM = hmDashboardPagePO.getRequirementsCountFromDashboard();
		TestNGLogUtility.info("User gets count of requirement from dashboard");
	}
	
	@Then("Verify total count of requirments matches that on Dashboard")
	public void verifyTotalRequirementCount()
	{
		Assert.assertEquals(requirementListingPagePO.totalRecordCount(), totalRequirementCountDashboardForHM,"Total count of requirments "+requirementListingPagePO.totalRecordCount()+" does not matches that on Dashboard "+totalRequirementCountDashboardForHM);
		TestNGLogUtility.info("Total count of requirments matches that on Dashboard");
	}
	
	@Then("Verify User does not see the reuirement source filter")
	public void verifyAbsenceOfRequirementSourceFilter()
	{
		Assert.assertFalse(requirementListingPagePO.checkThePresenceOfSourceFilter(),"Requirement source filter is displayed");
		TestNGLogUtility.pass("Verify User does not see the reuirement source filter");
	}
	
	@Then("Verify User see the total number of requirement equal to the number of requirement recorded in all the requirement status")
	public void verifyAllStatusCount()
	{
		 Assert.assertTrue(requirementListingPagePO.checkForRequirementCountWhenAllSelected(), "The total system requirement is not equal to the number of requirements on status");
		    TestNGLogUtility.pass("The total system requirement is equal to the number of requirements on status");
	}
	
	@And("User click on refine requirement filter on HM Requirement listing")
	public void clickOnRefineRequirementFilter()
	{
		requirementListingPagePO.clickOnRefineRequirementFilter();
		TestNGLogUtility.info("User click on refine requirement filter on HM Requirement listing");
	}
	
	@And("User should not be able to see the text {string} on lightbox")
	public void verifyAbsenceOfText(String txt)
	{
		Assert.assertFalse(manageGroupPO.verifyErrorMsg(txt), "Text is displayed");
		TestNGLogUtility.pass(txt+" is not displayed");
	}
	
	@Then("Verify user does not see master profile search bar")
	public void verifyAbsenceOfMasterProfileSearchBar()
	{
		Assert.assertFalse(cvDetailsPagePO.verifyPresenceOfMasterProfileSearch(), "Master profile search bar is displayed");
		TestNGLogUtility.pass("User does not see master profile search bar");
	}
}
