package com.naukri.stepdefinitions.HiringManager;

import java.io.IOException;
import org.testng.Assert;
import com.naukri.pageobjects.HiringManager.BulkUploadPagePO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BulkUploadPageStepDef {
	
	CommonAction CommonActionObject = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	BulkUploadPagePO bulkUploadPagePOObject = new BulkUploadPagePO();
	@When("I upload file")
	public void upload() throws IOException 
	{
		bulkUploadPagePOObject.uploadFile();
	}
	
	@And("I add it to existing requirement")
	public void addToExistingRequirement()
	{
		bulkUploadPagePOObject.addToExistingRequirement();
	}
	
	@And("I upload it")
	public void uploadFiles()
	{
		bulkUploadPagePOObject.clickOnUploadFiles();
	}
	
	@Then("I verify success message as {string}")
	public void verifySuccessMessage(String message)
	{
		Assert.assertEquals(message, bulkUploadPagePOObject.getSuccessMessage());
	}
	
	@When("User click on Add New link on Bulk upload page")
	public void clickOnAddNewBtn() throws IOException 
	{
		bulkUploadPagePOObject.clickOnAddNewBtn();
	}

}
