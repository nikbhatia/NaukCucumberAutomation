package com.naukri.stepdefinitions.Settings;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Assessment.CustomizeSelectionProcessPO;
import com.naukri.pageobjects.Settings.CustomizeSelectionStagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomizedSelectionProcessStepDefs {

	SoftAssert softAssert= new SoftAssert();
    CustomizeSelectionProcessPO customizeSelectionProcessPO = (CustomizeSelectionProcessPO) PageObjectWrapper.getObject(CustomizeSelectionProcessPO.class);
    CustomizeSelectionStagePO customizeSelectionStagePO = (CustomizeSelectionStagePO) PageObjectWrapper.getObject(CustomizeSelectionStagePO.class);
    
    @And("user click on {string} Stage")
    public void userClickOnStage(String selectionStageName) {
    customizeSelectionProcessPO.clickSelctionStage(selectionStageName);
    }

    @Then("user validate that Billing Stage should be selected")
    public void userValidateThatBillingStageShouldBeSelected() {
        Assert.assertTrue(customizeSelectionProcessPO.isBillingStageSelected(), "Billing Stage is not selected !!!");

    }
    
    @And("user click on Add Selection Stage")
    public void clickOnButton()
    {
    	customizeSelectionStagePO.clickAddSelectionStageButton();
    	TestNGLogUtility.info("User clicked on Add Selection Stage");
    }
    
    @When("user fill stage name as {string}")
    public void fillStageName(String stageName)
    {
    	customizeSelectionStagePO.fillStageName(stageName);
    	TestNGLogUtility.info("user fill stage name as "+stageName);
    }
    
    @And("user click on Save stage button")
    public void clickOnSave()
    {
    	customizeSelectionStagePO.clickSaveButton();
    	TestNGLogUtility.info("User clicked on Save");
    }
    
    @Then("Verify {string} message is displayed")
    public void messageDisplayed(String message)
    {
    	//Assert.assertEquals(customizeSelectionStagePO.getMessageDisplayed(), message);
    	softAssert.assertEquals(customizeSelectionStagePO.getMessageDisplayed(), message);
    	TestNGLogUtility.pass(message+" message is displayed");
    }
    
    @And("user click on {string} from lightbox")
    public void clickButtonInLB(String btnName)
    {
    	customizeSelectionStagePO.clickOnButtonOnDeleteLB(btnName);
    	TestNGLogUtility.info("user click on "+btnName+" from lightbox");
    	softAssert.assertAll();
    }
    
    @And("user click on edit for {string} stage name button")
    public void clickOnEditStage(String stageName)
    {
    	customizeSelectionStagePO.clickOnEditStageName(stageName);
    	TestNGLogUtility.info("user click on edit for "+stageName+" stage name button");
    }
    
    @When("user click on delete for {string} stage name button")
    public void clickOnDeleteStage(String stageName)
    {
    	customizeSelectionStagePO.clickOnDeleteStageName(stageName);
    	TestNGLogUtility.info("user click on delete for "+stageName+" stage name button");
    }
    
    @When("user edits stage name as {string}")
    public void editStageName(String newStageName)
    {
    	customizeSelectionStagePO.fillEditedStageName(newStageName);
    	TestNGLogUtility.info("user edits stage name as "+newStageName);
    }
    
    @Then("Verify {string} message is displayed below stage name")
    public void verifyErrorMessageIsDisplayed(String errorMessage)
    {
    	Assert.assertEquals(customizeSelectionStagePO.getErrorMessageBelowStageName(), errorMessage);
    	TestNGLogUtility.pass(errorMessage+" message is displayed");
    }
    
    @And("user click on Cancel stage button")
    public void clickOnCancelButtonForStage()
    {
    	customizeSelectionStagePO.clickOnStageCancel();
    	TestNGLogUtility.info("user click on Cancel stage button");
    }
    
    @And("user click on {string} stage name")
    public void clickOnStageName(String stageName)
    {
    	customizeSelectionStagePO.clickOnStageName(stageName);
    	TestNGLogUtility.info("user click on "+stageName+" stage name");
    }
    
    @And("user click on Add Sub Stage for {string} stage")
    public void clickOnAddSubStage(String stageName)
    {
    	customizeSelectionStagePO.clickOnAddSubStage(stageName);
    	TestNGLogUtility.info("user click on Add Sub Stage");
    }
    
    @When("user fill substage name as {string}")
    public void fillSubStageName(String subStageName)
    {
    	customizeSelectionStagePO.fillSubstageName(subStageName);
    	TestNGLogUtility.info("user fill substage name as "+subStageName);
    }

}