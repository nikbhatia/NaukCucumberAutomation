package com.naukri.stepdefinitions.Taxonomy.Location;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.pageobjects.Taxonomy.Location.TaxonomyAddASingleProfilePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author udit.khanna
 * @author gupta.mansi
 */
public class TaxonomyAddASingleProfileStepDef {

	TaxonomyAddASingleProfilePO taxonomyAddASingleProfilePO = (TaxonomyAddASingleProfilePO) PageObjectWrapper.getObject(TaxonomyAddASingleProfilePO.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	RequirementOverviewPagePO requirementOverviewPagePO = (RequirementOverviewPagePO) PageObjectWrapper.getObject(RequirementOverviewPagePO.class);
	public List<String> selectedLocationList = new ArrayList<>();
	
	@Then("User sees {string} added as location value")
	public void verifyLocationValueAdded(String valueAdded){
		Assert.assertTrue(taxonomyAddASingleProfilePO.verifyLocationValueAdded(valueAdded), valueAdded + " tag is not added.");
	}
	
	@Then("User sees {string} as {string} on CV details page")
	public void verifyFieldValueAddedOnCVDetails(String valueAdded, String field){
		Assert.assertTrue(taxonomyAddASingleProfilePO.verifyFieldValueAddedOnCVDetails(field, valueAdded), valueAdded + " value is not added in field: " + field);
	}

	@Then("User sees {string} added as location on Requirement Overview")
	public void verifyLocationForRequirement(String location)
	{
		Assert.assertEquals(requirementOverviewPagePO.getLocations(),location);
		TestNGLogUtility.pass("User sees "+location+" added as location on Requirement Overview");
	}
	
	@When("User checks 1 option from dropdown in Top Metropolitan Cities")
	public void selectTopLocation()
	{
		String selectedLoc = taxonomyAddASingleProfilePO.selectFromTopMetroCities("1");
		selectedLocationList.add(selectedLoc);
		TestNGLogUtility.info("User checks "+selectedLoc+" option from dropdown in Top Metro City");
	}
	
	@Then("User sees selected city is shown checked in the dropdown")
	public void verifyIsSelectedLocations()
	{
		Assert.assertEquals(selectedLocationList.size(), taxonomyAddASingleProfilePO.getSelectedLocation().size(),"All selected locations are not selected");
		List<String> actualSelected = new ArrayList<>(taxonomyAddASingleProfilePO.getSelectedLocation());
		for(int temp=0;temp<taxonomyAddASingleProfilePO.getSelectedLocation().size();temp++)
		{
			Assert.assertEquals(selectedLocationList.get(temp), actualSelected.get(temp));
		}
	}
	
	@Then("User sees {string} text in Job Location Field")
	public void verifyJobLocPlaceholder(String location)
	{
		Assert.assertEquals(taxonomyAddASingleProfilePO.getCurrentLocation(),location);
		TestNGLogUtility.pass("User sees "+location+" text in Job Location Field");
	}
	
	@Then("User sees {string} is highlighted and selected")
	public void verifyLocationSelectedAndHighlighted(String location)
	{
		Assert.assertTrue(taxonomyAddASingleProfilePO.getSelectedLocation().contains(location));
		TestNGLogUtility.pass(location+" is selected");
	}
}
