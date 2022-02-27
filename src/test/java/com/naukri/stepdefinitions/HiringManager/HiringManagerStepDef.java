package com.naukri.stepdefinitions.HiringManager;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.HiringManager.HMDashboardPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Hiring Manager Step Definitions 
 * @author rachit.mehrotra
 *
 */
public class HiringManagerStepDef {
	
	HMDashboardPagePO hmDashboard = (HMDashboardPagePO) PageObjectWrapper.getObject(HMDashboardPagePO.class);

	@Then("User finds the candidate under section Upcomimg Interviews")
	public void user_finds_the_candidate_under_section_Upcomimg_Interviews() {
		Assert.assertTrue(hmDashboard.verifyThePresenceOfCandidateName(),"Candidate Name is not present under the Upcoming Interview Section");
		TestNGLogUtility.pass("Candidate Name is present under the Upcoming Interview Section");
	}

	@When("User clicks on the candidate name")
	public void user_clicks_on_the_candidate_name() {
		hmDashboard.clickOnCandidateName();
	}

}
