package com.naukri.stepdefinitions.Settings;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.ManageSubuserPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageSubuserStepDefs {
	
	ManageSubuserPO objManageSubuser = new ManageSubuserPO();
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	static String name;
	
	@And("user click on {string} button for {string}")
	public void clickOnEditButton(String btnName,String eid)
	{
		objManageSubuser.clickOnBtn(eid, btnName);
		TestNGLogUtility.info("User clicked on "+btnName+" for "+eid);
	}
	
	@When("user click on save button on lb")
	public void clickOnSaveButtonOnLB()
	{
		objManageSubuser.clickOnSave();
		TestNGLogUtility.info("user click on save button on lb");
	}
	
	@And("user fills name")
	public void fillUserName()
	{
		 name = CommonAction.generateRandomStrings(7, "String");
		 objManageSubuser.fillName(name);
		 TestNGLogUtility.info("user fills name as "+name);
	}
	
	@And("user fills same name")
	public void fillSameName()
	{
		objManageSubuser.fillName(name);
		TestNGLogUtility.info("user fills same name as "+name);
	}
	
	@And("user fills name as {string}")
	public void fillNameAs(String userName)
	{
		name = userName;
		objManageSubuser.fillName(name);
		TestNGLogUtility.info("user fills name as "+name);
	}
	
	@Then("Verify error message {string} is displayed")
	public void verifyError(String errorMsg)
	{
		Assert.assertEquals(objManageSubuser.getTextErrorDisplayed(), errorMsg);
		TestNGLogUtility.pass(errorMsg+" is displayed");
	}
	
	@And("Verify name field is highlighted in {string}")
	public void verifyBorderColor(String color)
	{
		String[] colorHex = color.split("/");
		Assert.assertEquals(objManageSubuser.getBorderColor(), colorHex[0]);
		TestNGLogUtility.pass("Name field border is highligted in expected color");
	}
	
	@Then("Verify {string} username is displayed")
	public void verifyNameDisplayed(String name)
	{
		Assert.assertEquals(objManageSubuser.isNameOfSubuserDisplayed(name), true);
		TestNGLogUtility.pass("Username "+name+" is displayed");
	}
	
    @Given("User login to rms {string} using {string} and {string} of {string} user")
    public void loginToApplication(String pageName,String userType,String pass,String user){
    	commonActions.loginToRMSUsingURLBuilder(pageName, getAppConfigValue("HM."+user+"."+userType),getAppConfigValue("HM."+user+"."+pass));
    }
    
    @When("user click on Cancel button on lb")
    public void clickONCancel()
    {
    	objManageSubuser.clickOnCancel();
    	TestNGLogUtility.info("User click on cancel button");
    }
    
    @And("user click on Hiring Managers section")
    public void clickOnHMTab()
    {
    	objManageSubuser.clickOnHMSection();
    	TestNGLogUtility.info("user click on Hiring Managers section");
    }
    
    @And("user click on Recruiters section")
    public void clickOnRecruiterSection()
    {
    	objManageSubuser.clickOnRecruiterSection();
    	TestNGLogUtility.info("user click on Recruiters section");
    }
    
    @Then("Verify Reporting To dd is disbled")
    public void verifyReportingToDDDisabled()
    {
    	Assert.assertEquals(objManageSubuser.isReportingToDDDiplayed(),false);
    	TestNGLogUtility.pass("Reporting To dd is disbled");
    }
    
    @Then("Verify {string} label is displayed")
    public void isReportingToLabelDisplayed(String label)
    {
    	Assert.assertEquals(objManageSubuser.isLabelDisplayed(label),true);
    	TestNGLogUtility.pass(label+" label is displayed");
    }
    
    @Given("user is on Manage Sub-Users page on MNR")
    public void navigateToManageSubuserMNR()
    {
    	objManageSubuser.navigateToPageMNRManageSubuser();
    	TestNGLogUtility.info("user is on Manage Sub-Users page on MNR");
    }
    
    @And("user click on reporting to dd for {string}")
    public void clickOnReportingToDDMNR(String user)
    {
    	objManageSubuser.clickOnMNRReortingToDD(user);
    	TestNGLogUtility.info("user click on reporting to dd for "+user);
    }
    
    @And("user fills {string} as reporting to for {string}")
    public void fillReportingTo(String reportingTo,String user)
    {
    	objManageSubuser.fillReportingTo(reportingTo,user);
    	TestNGLogUtility.info("User fills Reporting to for "+user+" as "+reportingTo);
    }
    
    @Then("verify {string} is displayed for reporting to")
    public void verifyReportingTo(String reortingToName)
    {
    	Assert.assertEquals(objManageSubuser.getReportingTo(), reortingToName);
    	TestNGLogUtility.pass("Expected Reporting To is displayed");
    }
    
    @And("user click on cross for photo uploader")
    public void closePhotoUploader()
    {
    	objManageSubuser.closePhotoUploader();
    	TestNGLogUtility.info("user click on cross for photo uploader");
    }

}
