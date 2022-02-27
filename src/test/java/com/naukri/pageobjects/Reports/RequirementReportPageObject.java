package com.naukri.pageobjects.Reports;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class RequirementReportPageObject extends BaseAutomation {

	boolean flag = false;
	ArrayList<String> lstSummaryElements = new ArrayList<String>();
	ArrayList<String> lstColumnNames = new ArrayList<String>();
	ArrayList<String> lstGraphicalDropDownOptions = new ArrayList<String>();

	public static By eleTimeDurationDropDown = By.xpath("//div[@id='timeFilterWrapper']");
	public static By eleNoOfSummaryElementsForRequirementAging = By.xpath("//p[@class='heading']");
	public static By lblSummaryElementsText = By.xpath("(//p[@class='heading'])[${i}]");
	public static By eleNoOfColumns = By
			.xpath("//div[@id='tableHeader']//div[contains(@class,'table-row-item')]//span");
	public static By lblTextForColumnName = By
			.xpath("(//div[@id='tableHeader']//div[contains(@class,'table-row-item')]//span)[${i}]");
	public static By eleGraphicalDropDownArrow = By.xpath("//h2[@class='graphDropdownTitle']");
	public static By lblDropDownElementsText = By.xpath("(//div[@class='labelWrappper'])[${i}]");
	public static By eleNoOfGraphicalDropDOwnOptions = By.xpath("//div[@class='labelWrappper']");
	public static By eleClearAll = By.xpath("//div[text()='CLEAR ALL']");

	/**
	 * This method will verify that time duration drop down is not visible in
	 * requirement aging report
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForVisibilityOfTimeDurationDropDown
	 */
	public boolean verifyTimeDurationNonVisibility() {
		return (!isDisplayed(eleTimeDurationDropDown));
	}

	/**
	 * This method returns the elements in the summary widget in requirement aging
	 * report
	 * 
	 * @author srissti.tyagi
	 * @return arrayListForRequirementAgingSummaryElement
	 */
	public List<String> verifySummaryElementsForRequirementAgingReport() {
		int noOfElements = getElements(eleNoOfSummaryElementsForRequirementAging).size();
		for (int i = 1; i <= noOfElements; i++)
			lstSummaryElements.add(getText(parameterizedLocator(lblSummaryElementsText, Integer.toString(i))));
		return lstSummaryElements;
	}

	/**
	 * This method will return the column names for requirement reports
	 * 
	 * @author srissti.tyagi
	 * @return arrayListForColumnNamed
	 */
	public List<String> verifyColumnNamesForRequirementReports() {
		int noOfElements = getElements(eleNoOfColumns).size();
		for (int i = 1; i <= noOfElements; i++) {
			lstColumnNames.add(getText(parameterizedLocator(lblTextForColumnName, Integer.toString(i))));
		}
		return lstColumnNames;
	}

	/**
	 * This method returns the options available in the Drop Down in graphical mode
	 * 
	 * @author srissti.tyagi
	 * @return arrayListForGraphicalDropDownValues
	 */
	public List<String> verifyGraphicalDropDownOptions() {
		int noOfElements = getElements(eleNoOfGraphicalDropDOwnOptions).size();
		for (int i = 1; i <= noOfElements; i++)
			lstGraphicalDropDownOptions
					.add(getText(parameterizedLocator(lblDropDownElementsText, Integer.toString(i))));
		return lstGraphicalDropDownOptions;
	}

	/**
	 * This method clicks on the drop down arrow in the graphical view of
	 * requirement creation report
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOngraphicalDropDown() {
		click(eleGraphicalDropDownArrow);
		TestNGLogUtility.info(" User clicked on the drop down option in graphical reports");

	}

	/**
	 * This method enables the user to click on the CLear All option after clicking
	 * on the filter icon
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnClearAll() {
		click(eleClearAll);
		TestNGLogUtility.info(" User clicked on the clear all option to clear all the filters");
	}

}
