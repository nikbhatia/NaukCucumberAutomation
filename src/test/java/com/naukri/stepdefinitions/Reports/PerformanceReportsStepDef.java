package com.naukri.stepdefinitions.Reports;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Reports.PerformanceReportPageObject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class PerformanceReportsStepDef {

	PerformanceReportPageObject PerformanceReportObject = new PerformanceReportPageObject();
	ArrayList<String> lstExpectedConversionRates = new ArrayList<String>();
	ArrayList<String> lstVisibleConversionRates = new ArrayList<String>();

	@Then("User verifies that over all count for all columns is the summation of all fields")
	public void verifyOverAllValueInTabular() {
		Assert.assertTrue(PerformanceReportObject.verifyOverAllValueInTabular(),
				"[Assertion Fail]: OverAll count is not the summation of required columns");
		TestNGLogUtility.pass("[Assertion Pass]: OverAll count is the expected summation of required columns");
	}

	@Then("User verifies the column names for Performance Reports")
	public void verifyColumnNamesForPerformanceReports(DataTable columnNamesForPerformanceReports) {
		List<String> expectedColumnNames = columnNamesForPerformanceReports.asList(String.class);
		List<String> visibleColumnNames = PerformanceReportObject.verifyColumnNamesForPerformanceReports();
		Assert.assertEquals(expectedColumnNames, visibleColumnNames,
				"[Assertion Fail]:  Column Names are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Column Names are as per the requiremnt");
	}

	@Then("User verifies the tool tips for the performance reports")
	public void verifyToolTipsForPerformanceReports(DataTable toopTipsForPerformanceReports) {
		List<String> expectedToolTips = toopTipsForPerformanceReports.asList(String.class);
		Assert.assertTrue(PerformanceReportObject.verifyToolTipsForPerformanceReports(expectedToolTips),
				"[Assertion Fail]: Tool Tips are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Tool Tips are as per the requiremnt");
	}

	@When("User gets the expected values of conversion percentage")
	public void getExpectedListForConversionValues() {
		lstExpectedConversionRates = PerformanceReportObject.getExpectedListForConversionValues();
	}

	@When("User gets the visible values of conversion percentage")
	public void getVisibleListForConversionValues() {
		lstVisibleConversionRates = PerformanceReportObject.getVisibleListForConversionValues();
	}

	@Then("Verify that conversion rate is correct according to selected Stage")
	public void verifyConversionRate() {
		Assert.assertEquals(lstExpectedConversionRates, lstVisibleConversionRates,
				"[Assertion Fail]: Conversion rate is not correct according to settings selected");
		TestNGLogUtility.pass("[Assertion Pass]: Conversion rate is similar to the expected values");
	}

}
