package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.ApplicationLogsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;

public class ApplicationLogsStepDef {
	
	ApplicationLogsPagePO applicationLogs = (ApplicationLogsPagePO) PageObjectWrapper.getObject(ApplicationLogsPagePO.class);
	
	@Then("I should be able to see the page with heading {string}")
	public void i_should_be_able_to_see_the_page_with_heading(String headingText) {
	   Assert.assertTrue(applicationLogs.verifyThePresenceOfApplicationLogsHeading(headingText), 
			   "Application Logs page is not visible");
	   TestNGLogUtility.pass("Application Logs page is not visible");
	}

}
