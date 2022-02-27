package com.naukri.stepdefinitions.Taxonomy.Location;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Taxonomy.Location.TaxonomyAddASingleProfilePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaxonomyUploadsStepDef {
	
	AddASingleProfilePagePO addASingleProfile = (AddASingleProfilePagePO) PageObjectWrapper.getObject(AddASingleProfilePagePO.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	TaxonomyAddASingleProfilePO taxonomyAddASingleProfilePO = (TaxonomyAddASingleProfilePO) PageObjectWrapper.getObject(TaxonomyAddASingleProfilePO.class);
	
	@When("User select the CV in {string} extension for single upload with location as {string}")
	public void uploadCV(String docType, String location)
	{
		addASingleProfile.selectTheCVToUpload(docType,location);
		TestNGLogUtility.info("User select the CV in "+docType+" extension for single upload with location as "+location);
	}
	
	@Then("User sees current location as {string} on CV Deatil page")
	public void verifyCurrentLocation(String location)
	{
		Assert.assertEquals(cvDetailsPagePO.getCurrentLocation(), location);
		TestNGLogUtility.pass("User sees current location as "+location+" on CV Deatil page");
	}
	
	@Then("User should be able to see the Current Location as blank")
	public void verifyBlankCurrentLocation()
	{
		Assert.assertEquals(taxonomyAddASingleProfilePO.getCurrentLocation(),"Start typing locations");
		TestNGLogUtility.info("User should be able to see the Current Location as blank");
	}
}
