package com.naukri.stepdefinitions.Taxonomy.Location;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Taxonomy.Location.TaxonomyAddASingleProfilePO;
import com.naukri.pageobjects.Taxonomy.Location.TaxonomyExcelUpload;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaxonomyRequirementUploadStepDef {
	
	TaxonomyAddASingleProfilePO taxonomyAddASingleProfilePO = (TaxonomyAddASingleProfilePO) PageObjectWrapper.getObject(TaxonomyAddASingleProfilePO.class);
	TaxonomyExcelUpload taxonomyExcelUpload = (TaxonomyExcelUpload) PageObjectWrapper.getObject(TaxonomyExcelUpload.class);
	
	@When("User clicks on Job Location drop down for {string}")
	public void clickOnJobLocationReqDD(String sectionName)
	{
		taxonomyAddASingleProfilePO.clickOnRequirementJobLocation(sectionName);
		TestNGLogUtility.info("User clicks on Job Location drop down for requirement");
	}
	
	@When("User enters {string} in Job Location field for {string}")
	public void enterValueInJobLocationDD(String value,String sectionName)
	{
		taxonomyAddASingleProfilePO.enterValueInDDField(value, sectionName);
		TestNGLogUtility.info("User enters: "+value+" as job location for "+sectionName);
	}
	
	@And("User uploads a resume of {string} type with {string} location for {string}")
	public void uploadProfile(String fileType,String locType,String uploadType)
	{
		taxonomyAddASingleProfilePO.uploadFile(fileType,locType,uploadType);
		TestNGLogUtility.info("User uploads a resume of "+fileType+" type with "+locType+" location for "+uploadType);
	}
	
	@And("User click on Upload Files button")
	public void clickOnUpload()
	{
		taxonomyExcelUpload.clickUpload();
		TestNGLogUtility.info("User click on Upload Files button");
	}
	
	@Then("User verify that profile is added successfully")
	public void verifySuccessfulUpload()
	{
		Assert.assertTrue(taxonomyExcelUpload.verifyProfileIsUploaded());
		TestNGLogUtility.pass("Profile is uploaded successfully");
	}

}
