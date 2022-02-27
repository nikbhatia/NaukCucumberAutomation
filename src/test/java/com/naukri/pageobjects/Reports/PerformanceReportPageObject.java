package com.naukri.pageobjects.Reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class PerformanceReportPageObject extends BaseAutomation {

	boolean flag = false;
	int sumCount = 0;
	ArrayList<String> lstColumnNames = new ArrayList<String>();
	ArrayList<String> lstToolTips = new ArrayList<String>();
	ArrayList<String> lstExpectedConversionRates = new ArrayList<String>();
	ArrayList<String> lstVisibleConversionRates = new ArrayList<String>();

	public static By getTotalVendorsInTabular = By.xpath("//li[contains(@class,'list')]");
	public static By eleNoOfColumns = By.xpath("//div[@id='tableHead']//span");
	public static By lblTextForColumnName = By.xpath("(//div[@id='tableHead']//span)[${i}]");
	public static By eleNoOfToolTips = By.xpath("//div[@class='col ']");
	public static By lblToolTipText = By.xpath("(//div[@class='col '])[${i}]");
	public static By lblOverAllValues = By
			.xpath("(//div[@class='tableBodyWrapper']//li[1]//span[@class='valText'])[${i}]");
	public static By lblIndividualCellValues = By
			.xpath("(//li[contains(@class,'list')][${j}]//span[@class='valText'])[${i}]");
	public static By lblExpectedConversionRate = By
			.xpath("(//li[contains(@class,'list')][1]//span[@class='baseRow'])[${i}]");
	public static By eleHOverOnOverAllRow = By.xpath("//span[text()='OverAll']/ancestor::li[contains(@class,'list')]");
	public static By eleGetAllValuesForOverAllRow = By
			.xpath("(//li[contains(@class,'list')][1]//span[@class='valText'])[${j}]");

	/**
	 * This method verifies that the overall values in the all the columns is the
	 * summation of all values
	 * 
	 * @return booleanValueForSummation
	 * @author srissti.tyagi
	 */
	public boolean verifyOverAllValueInTabular() {
		int size = getElements(getTotalVendorsInTabular).size();
		if (size > 2) {
			ArrayList<Integer> overAll = new ArrayList<Integer>();
			ArrayList<Integer> summations = new ArrayList<Integer>();
			for (int i = 1; i <= 6; i++) {
				overAll.add(Integer.parseInt(getText(parameterizedLocator(lblOverAllValues, Integer.toString(i)))));
				sumCount = 0;
				for (int j = 2; j <= size - 1; j++)
					sumCount += Integer.parseInt(getText(
							parameterizedLocator(lblIndividualCellValues, Integer.toString(j), Integer.toString(i))));
				summations.add(sumCount);
			}
			if (overAll.equals(summations))
				flag = true;
		} else {
			TestNGLogUtility.info("There is no data for summation");
			flag = true;
		}
		return flag;
	}

	/**
	 * This method returns the name of all the columns present in performance
	 * reports
	 * 
	 * @return arrayListOfColumnNames
	 * @author srissti.tyagi
	 */
	public List<String> verifyColumnNamesForPerformanceReports() {
		int noOfElements = getElements(eleNoOfColumns).size();
		for (int i = 1; i <= noOfElements; i++) {
			lstColumnNames.add(getText(parameterizedLocator(lblTextForColumnName, Integer.toString(i))));
		}
		return lstColumnNames;
	}

	/**
	 * This method returns the list of conversion rates that are visible when user
	 * hovers on the over all row
	 * 
	 * @return arrayListOFVisibleConversionRates
	 * @author srissti.tyagi
	 */
	public ArrayList<String> getExpectedListForConversionValues() {
		hover(eleHOverOnOverAllRow);
		for (int i = 1; i <= 5; i++)
			lstExpectedConversionRates
					.add(getText(parameterizedLocator(lblExpectedConversionRate, Integer.toString(i))));
		return lstExpectedConversionRates;
	}

	/**
	 * This method returns the list of conversion rates calculated for the visible
	 * column values
	 * 
	 * @return arrayListForCalculatedConversionValue
	 * @author srissti.tyagi
	 */
	public ArrayList<String> getVisibleListForConversionValues() {
		double calculateFirstConversionRate;
		int afterRoundOffCalculateFirstConversionRate;
		ArrayList<Double> list = new ArrayList<Double>();
		for (int j = 1; j <= 6; j++)
			list.add(
					Double.parseDouble(getText(parameterizedLocator(eleGetAllValuesForOverAllRow, Integer.toString(j)))));
		double firstValue = list.get(0);
		for (int j = 1; j <= 5; j++) {
			calculateFirstConversionRate = (list.get(j) * 100) / firstValue;
			afterRoundOffCalculateFirstConversionRate = (int) Math.round(calculateFirstConversionRate);
			if (afterRoundOffCalculateFirstConversionRate >= 0 && afterRoundOffCalculateFirstConversionRate <= 100)
				lstVisibleConversionRates.add(String.valueOf(afterRoundOffCalculateFirstConversionRate) + "%");
			else {
				TestNGLogUtility.info("Recruiters skipped adding candidates to previous stage." + " As a result, " + j
						+ "th conversion rate could not be calculated.");
				lstVisibleConversionRates.add("");
			}
		}
		return lstVisibleConversionRates;
	}

	/**
	 * This method will verify the tool tips visible for performance reports
	 * 
	 * @param expectedToolTips
	 * @return booleanValueForToolTipsVerification
	 * @author srissti.tyagi
	 */
	public boolean verifyToolTipsForPerformanceReports(List<String> expectedToolTips) {
		int noOfElements = getElements(eleNoOfToolTips).size();
		for (int i = 1; i <= noOfElements; i++)
			lstToolTips.add(getAttribute(parameterizedLocator(lblToolTipText, Integer.toString(i)), "title"));
		for (int i = 0; i <= noOfElements - 1; i++) {
			if (lstToolTips.get(i).contains(expectedToolTips.get(i)))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}