package com.naukri.stepdefinitions.Reports;

import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.internal.Yaml;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Reports.OldReportsPageObject;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class OldReportsStepDef {
	
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OldReportsPageObject oldReportsPagePO = (OldReportsPageObject) PageObjectWrapper.getObject(OldReportsPageObject.class);

	@Given("I am on Reports page")
	public void i_am_on_Reports_page() {
	    genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.ReportsPage"));
	}

	@When("I click on {string} report")
	public void i_click_on_report(String reportName) {
		oldReportsPagePO.clickOnReportsTab(reportName);
	}

	@Then("I should be able to see {int} radio button with labels {string} and {string}")
	public void i_should_be_able_to_see_radio_button_with_labels_and(Integer countOfLabel, String label1, String label2) {
	   Assert.assertTrue(oldReportsPagePO.verifyThePresenceOfRadioButtonWithLabel(label1), 
			   label1+" is not displayed");
	   Assert.assertTrue(oldReportsPagePO.verifyThePresenceOfRadioButtonWithLabel(label2), 
			   label2+" is not displayed");
	}

	@When("I click on radio button {string}")
	public void i_click_on_radio_button(String labelText) {
	    oldReportsPagePO.clickOnRadioButton(labelText);
	}
	
	@Then("I should be able to see the {string} timeline bar with options {string}")
	public void i_should_be_able_to_see_the_timeline_bar_with_options(String labelOption, String stringOfOptions) {
	   Assert.assertTrue(oldReportsPagePO.compareListOfOptionsOnTimeline(labelOption, stringOfOptions), 
			   labelOption + " list is not available fully");
	}
	
	@When("I click on more of {string}")
	public void i_click_on_more_of(String labelOption) {
	   oldReportsPagePO.clickOnMoreOption(labelOption);
	}

	@Then("I should be able to see the {string} more list {string}")
	public void i_should_be_able_to_see_the_more_list(String labelOption, String stringOfOptions) {
	   Assert.assertTrue(oldReportsPagePO.compareMoreListOfTimeLineBar(labelOption, stringOfOptions),
			   labelOption + " more options list mismatched");
	}
	
	@When("I select any option from the more list")
	public void i_select_any_option_from_the_more_list() {
	    
	}

	@Then("I should be able to see the more option changed to the value selected from the list")
	public void i_should_be_able_to_see_the_more_option_changed_to_the_value_selected_from_the_list() {
	}

	@Then("I click on replaced option")
	public void i_click_on_replaced_option() {
	}
	
	@When("User click on Select Columns in Report drop down")
	public void User_click_on_Select_Columns_in_Report_drop_down() {
	    oldReportsPagePO.clickOnColumnDD();
	}
	
	@Then("User should be able to see {string} column in the list")
	public void i_should_be_able_to_see_the_more_list(String ddOption) {
	   Assert.assertTrue(oldReportsPagePO.verifyEmploymentTypeColumnInReport(ddOption),
			   ddOption + " is not available in column list");
	   TestNGLogUtility.pass(ddOption + " is available in column list successfully");
	}

	@And("User clicks on comparison checkbox")
	public void clickOnComparisonCheckbox(){
		oldReportsPagePO.clickOnComparisonCheckbox();
		TestNGLogUtility.info("Clicked on Comparison Checkbox");
	}

	@And("User select below recruiter from recruiter column")
	public void selectRecruitersFromRecruiterColumn(DataTable dt){
		List<String> lst=dt.asList();
		oldReportsPagePO.selectRecruitersFromRecruiterColumn(lst);
		TestNGLogUtility.info("Selected All Recruiters");
	}

	@And("User select below column from Select column")
	public void selectColumnFromSelectColumn(DataTable dt){
		List<String> lst=dt.asList();
		oldReportsPagePO.selectColumnFromSelectColumn(lst);
		TestNGLogUtility.info("Selected All Recruiters");
	}

	@And("User Selects {string} for Activities Done")
	public void selectDurationForActivityDone(String duration){
		oldReportsPagePO.selectDurationFOrActivityDone(duration);
		TestNGLogUtility.info("Selected "+ duration +" for activity done");
	}

	@And("User verify {string} column is displayed in report")
	public void verifyColumnInReport(String column){
		oldReportsPagePO.verifyColumnInReport(column);
		TestNGLogUtility.info( column +" is displayed");
	}

	@And("User Verify {string} is visible in footer of report page")
	public void verifyFooterMessage(String message){
		oldReportsPagePO.verifyFooterMessage(message);
		TestNGLogUtility.info( message +" -->is displayed");
	}

	@And("User Clears All Recruiters")
	public void clearAllRecruiter(){
		oldReportsPagePO.clearAllRecruiter();
		TestNGLogUtility.info( "Clicked on Clear All For All Recruiters");
	}
	
}
