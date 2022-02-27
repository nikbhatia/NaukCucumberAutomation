package com.naukri.stepdefinitions.Dashboard;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Dashboard.DashboardPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardStepDef {
	
	DashboardPagePO dashboardPage = (DashboardPagePO) PageObjectWrapper.getObject(DashboardPagePO.class);
	
	@When("User scrolls down to the Events section")
	public void user_scrolls_down_to_the_Events_section() {
		dashboardPage.navigateToEventsWidget();
	}

	@Then("User should be able to see the Candidate present under the interview section")
	public void user_should_be_able_to_see_the_Candidate_present_under_the_interview_section() {
	    Assert.assertTrue(dashboardPage.verifyThePresenceOfCandidateOnInterviewWidget(), 
	    		"The candidate is not visible on the dashboard event's section");
	    TestNGLogUtility.pass("The candidate is visible on the dashboard event's section");
	}
	
	@When("User clicks on the calender icon of Events Widget")
	public void user_clicks_on_the_calender_icon_of_Events_Widget() {
		dashboardPage.clickOnEventCalender();
	}

	@When("User selects the date as {string}")
	public void user_selects_the_date_as(String daysToShift) {
	    dashboardPage.selectDateOnCalender(daysToShift);
	}
	
	@When("User should be redirected to the HM dashboard page")
	public void user_should_be_redirected_to_the_HM_dashboard_page() {
		dashboardPage.launchHMDashboard();
	}

	
}
