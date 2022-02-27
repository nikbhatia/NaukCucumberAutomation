package com.naukri.stepdefinitions.HiringManager;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AllProfilePagePO;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.HiringManager.HMDashboardPagePO;
import com.naukri.pageobjects.HiringManager.HMFeedbackPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMAllApplicationPageStepDef {
	
	AllProfilePagePO allProfilePagePO = (AllProfilePagePO) PageObjectWrapper.getObject(AllProfilePagePO.class);
	HMDashboardPagePO hmDashboardPagePO = (HMDashboardPagePO) PageObjectWrapper.getObject(HMDashboardPagePO.class);
	HMFeedbackPagePO hmFeedbackPagePO = (HMFeedbackPagePO) PageObjectWrapper.getObject(HMFeedbackPagePO.class);
	InboxPagePO inboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
	static int allApplicationDasboardCount;

	@Then("Verify user does not see side cluster")
	public void verifyAbsenceOfSideFacets()
	{
		Assert.assertFalse(allProfilePagePO.presenceOfSideFacets(), "Side facets are displayed");
		TestNGLogUtility.pass("User does not see side cluster");
	}
	
	@And("User gets count of application from dashboard")
	public void getAllApplicationCountFromDashboard()
	{
		allApplicationDasboardCount = hmDashboardPagePO.getApplicationsCountFromDashboard();
		TestNGLogUtility.info("User gets count of application from dashboard "+allApplicationDasboardCount);
	}
	
	@Then("Verify user sees same count of applications as on dashboard")
	public void verifyCountOnAllApplicationPage()
	{
		Assert.assertEquals(hmFeedbackPagePO.getTotalFeedbackCountForPipelineStageOnPendingReviewPage(), allApplicationDasboardCount,"Expected count "+allApplicationDasboardCount+" is not same as actual count");
		TestNGLogUtility.pass("Expected count is same as actual count");
	}
	
	@Then("Verify user does not see {string} bar")
	public void verifyAbsenceOfBar(String searchBar)
	{
		Assert.assertFalse(inboxPagePO.visibilityOfGlobalLocalSearch(searchBar), "Search bar is displayed");
		TestNGLogUtility.pass("User does not see search bar of type: "+searchBar);
	}
	
	@And("User click on last page from pagination")
	public void clickOnLastPage()
	{
		allProfilePagePO.clickOnLastPage();
		TestNGLogUtility.info("User click on last page from pagination");
	}
	
	@When("User click on comment icon on inbox for last application")
	public void clickOnCommentIconForLastApplicationOnPage()
	{
		inboxPagePO.clickOnCommentIconOnInboxForLastApplication();
		TestNGLogUtility.info("User click on comment icon on inbox for last application");
	}
}
