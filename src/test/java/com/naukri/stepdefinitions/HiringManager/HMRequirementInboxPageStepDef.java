package com.naukri.stepdefinitions.HiringManager;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.stepdefinitions.Requirements.RequirementCreationStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class HMRequirementInboxPageStepDef {
	
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	InboxPagePO inboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
	ManageGroupPO manageGroupPO = (ManageGroupPO) PageObjectWrapper.getObject(ManageGroupPO.class);
	
	@And("Verify that {string} button is not displayed on requirement inbox page")
	public void verifyAbsenceOfButton(String buttonName)
	{
		Assert.assertFalse(cvDetailsPagePO.isButtonDisplayed(buttonName), buttonName+ " is displayed");
		TestNGLogUtility.pass(buttonName+" is not displayed");
	}
	
	@And("Verify that {string} button is displayed on requirement inbox page")
	public void verifyPresenceOfButton(String buttonName)
	{
		Assert.assertTrue(cvDetailsPagePO.isButtonDisplayed(buttonName), buttonName+ " is not displayed");
		TestNGLogUtility.pass(buttonName+" is displayed");
	}
	
	@Then("Verify user does not see bulk action gnb")
	public void verifyAbsenceOfBulkActionGNB()
	{
		Assert.assertFalse(inboxPagePO.verifyBulkStatusGNB(),"User does see bulk action gnb");
		TestNGLogUtility.pass("User does not see bulk action gnb");
	}
	
	@And("Verify user does not see bulk action checkbox")
	public void verifyAbsenceOfBulkActionCheckBox()
	{
		Assert.assertFalse(inboxPagePO.verifyPresenceOfBulkSelectCheckBox(),"User does see bulk action checkbox");
		TestNGLogUtility.pass("User does not see bulk action checkbox");
	}
	
	@Then("Verify requirement name is not displayed")
	public void verifyAbsenceOfRequirement()
	{
		Assert.assertFalse(manageGroupPO.labelVerify(" "+RequirementCreationStepDef.requirementName+" "),"Test case failed : As user is not able to see the requirement");
		TestNGLogUtility.info("Requirement name is displayed on requirement listing page");
	}
	
	@Then("Verify requirement name is displayed")
	public void verifyPresenceOfRequirement()
	{
		Assert.assertTrue(manageGroupPO.labelVerify(" "+RequirementCreationStepDef.requirementName+" "),"Test case failed : As user is not able to see the requirement");
		TestNGLogUtility.info("Requirement name is displayed on requirement listing page");
	}

}
