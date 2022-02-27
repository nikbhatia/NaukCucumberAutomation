package com.naukri.pageobjects.Reports;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class ActivityReportsPageObject extends BaseAutomation {

	boolean flag = false;
	String firstApplicationName = "", getValueOfAppliedFilter = "";
	ArrayList<String> lstAllValuesOfRequiredColumn = new ArrayList<String>();

	public static By lblFirstApplicationNameInDetailedReport = By.xpath("(//a[@class='linkColor'])[1]");
	public static By lblCandidateNameInDetailPage = By
			.xpath("//div[@id='basicDetailsSection']//div[@class='hText fl']");
	public static By lnkFirstValueInDataTable = By.xpath("(//div[contains(@class,'${columnToApplyFilterOn}')])[1]");
	public static By lblFilterChiptext = By.xpath("//div[@class='filterChip']//span[1]");
	public static By eleNoOfRowsInDataTable = By.xpath("//div[contains(@class,'${columnToApplyFilterOn}')]");
	public static By lblGetAllRecruiters = By.xpath("(//div[contains(@class,'${columnToApplyFilterOn}')])[${i}]");

	/**
	 * This method clicks on first application, provided there is data in the
	 * selected time duration
	 * 
	 * @author srissti.tyagi
	 * @return nameOfFirstApplication
	 */
	public String clickOnFirstApplicationInTheDetailedReport() {
		if (isDisplayed(lblFirstApplicationNameInDetailedReport)) {
			wait.waitForValignWrapperToDisappear(10, 5);
			click(lblFirstApplicationNameInDetailedReport);
			firstApplicationName = getText(lblFirstApplicationNameInDetailedReport);
			TestNGLogUtility.info("User clicked on first Application Name");
			switchToChildWindow();
		} else
			TestNGLogUtility.info("No application in the selected time duration");
		return firstApplicationName;
	}

	/**
	 * This method verifies that required application opens up when clicked from the
	 * report
	 * 
	 * @author srissti.tyagi
	 * @return booleanvalueForApplicationName
	 */
	public boolean verifyTheNameOfApplicationClickedFromReport(String firstApplicationName) {
		if (!firstApplicationName.equals("")) {
			if (getText(lblCandidateNameInDetailPage).contains(firstApplicationName))
				flag = true;
		} else
			flag = true;

		return flag;
	}

	/**
	 * This method allows the user to click on the first value of the required
	 * column to appky the filter of the same
	 * 
	 * @author srissti.tyagi
	 * @param columnToApplyFilterOn
	 * @return getValueOfAppliedFilter
	 */
	public String clickOnTheFirstValueOfRequiredColumn(String columnToApplyFilterOn) {
		click(parameterizedLocator(lnkFirstValueInDataTable, columnToApplyFilterOn));
		TestNGLogUtility.info("User clicked on required filter in the data table");
		getValueOfAppliedFilter = getText(parameterizedLocator(lnkFirstValueInDataTable, columnToApplyFilterOn));
		return getValueOfAppliedFilter;
	}

	/**
	 * This method verifies that the tag is visible after the value is clicked from
	 * the table
	 * 
	 * @author srissti.tyagi
	 * @param getValueOfAppliedFilter
	 * @return booleanValueFortagVisibility
	 */
	public boolean verifyTagVisibilityInCandidateActivityReport(String getValueOfAppliedFilter) {
		return (getText(lblFilterChiptext).equals(getValueOfAppliedFilter));
	}

	/**
	 * This method verifies that only the applied filters are visible
	 * 
	 * @param columnToApplyFilterOn
	 * @param getValueOfAppliedFilter
	 * @return booleanValueForFilteredResults
	 */
	public boolean verifyAllValuesOfRequiredColumn(String columnToApplyFilterOn, String getValueOfAppliedFilter) {
		int count = getElements(parameterizedLocator(eleNoOfRowsInDataTable, columnToApplyFilterOn)).size();
		for (int i = 1; i <= count; i++) {
			String txtRequiredValue = getText(
					parameterizedLocator(lblGetAllRecruiters, columnToApplyFilterOn, Integer.toString(i)));
			if (txtRequiredValue.contains(getValueOfAppliedFilter))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
