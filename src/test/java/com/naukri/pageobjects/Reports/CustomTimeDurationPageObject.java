package com.naukri.pageobjects.Reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class CustomTimeDurationPageObject extends BaseAutomation {

	boolean flag = false;
	ArrayList<String> lstExpectedTimeDurations = new ArrayList<String>();
	ArrayList<String> lstObservedTimeDurations = new ArrayList<String>();

	String previousMonth = "", secondLastMonth = "";
	String CurrentDate = "", previousDate = "", selectedFromDate = "", selectedToDate = "";

	public static By eleTimeDurationLabel = By.xpath("//span[@class='selectedLabel']");
	public static By eleNoOfTimeDurationOptions = By.xpath("//ul[@class='reportsList show']//li//span[2]");
	public static By lblExpectedTimeDuration = By.xpath("(//ul[@class='reportsList show']//li//span[2])[${i}]");
	public static By lblRequiredTimeDurationOption = By
			.xpath("//li//span[contains(text(),'${requiredTimeDurationOption}')]");
	public static By lblSelectedTimeDuration = By.xpath("//p[@class='helpInfo']");
	public static By eleReportTimePeriodDropDown = By.xpath("//div[@class='select-controller']");
	public static By lblRequiredReportTimePeriodOption = By
			.xpath("//div[@class='select-list']//span[text()='${requiredReportTimePeriod}']");
	public static By eleNoOfFrequencyOptions = By.xpath("//label[@class='fancySelectLabel']");
	public static By lblTextOfFrequencyOption = By.xpath("(//label[@class='fancySelectLabel'])[${i}]");
	public static By eleChooseDatePicker = By.xpath("//div[@id='dueDateDatePicker']");
	public static By eleSelectFromDate = By.xpath("//div[contains(@class,'${elementToBeSelected}')]//input");
	public static By lblSelectedTimeDurationText = By.xpath("//p[@class='helpInfo']");
	public static By btnApplyForTimeDuration = By.xpath("//div[@id='timeFilterWrapper']//button[text()='Apply']");

	/**
	 * This method will click on the time duration Drop Down at the top right of the
	 * page
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnTimeDurationDropDown() {
		wait.waitForValignWrapperToDisappear(10, 3);
		click(eleTimeDurationLabel);
		TestNGLogUtility.info("User clicked on the Time Duration Drop Down");
	}

	/**
	 * This method will verify that time duration options are visible as expected
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForExpectedTimeDurationOptions
	 */
	public boolean verifyTimeDurationDropDownElements() {
		int count = getElements(eleNoOfTimeDurationOptions).size();
		lstExpectedTimeDurations = getExpectedTimeDurations();
		for (int i = 1; i <= count; i++)
			lstObservedTimeDurations.add(getText(parameterizedLocator(lblExpectedTimeDuration, Integer.toString(i))));
		if (lstObservedTimeDurations.equals(lstExpectedTimeDurations))
			flag = true;
		return flag;
	}

	/**
	 * This method calculates varioud months and quarters and stores them in the
	 * array list which is the list for expected time durations
	 * 
	 * @author srissti.tyagi
	 * @return lstExpectedTimeDurations
	 */
	public ArrayList<String> getExpectedTimeDurations() {
		DateFormat yearDateFormat = new SimpleDateFormat("YY");
		Calendar calculateCurrentYear = Calendar.getInstance();
		calculateCurrentYear.add(Calendar.YEAR, 0);
		String currentYearText = yearDateFormat.format(calculateCurrentYear.getTime());
		DateFormat quarterdateformat = new SimpleDateFormat("MMM");
		Calendar calCurrentQuarterFirstMonth = Calendar.getInstance();
		calCurrentQuarterFirstMonth.set(Calendar.MONTH, calCurrentQuarterFirstMonth.get(Calendar.MONTH) / 3 * 3);
		Calendar calCurrentQuarterLastMonth = Calendar.getInstance();
		calCurrentQuarterLastMonth.set(Calendar.MONTH, calCurrentQuarterLastMonth.get(Calendar.MONTH) / 3 * 3 + 2);
		lstExpectedTimeDurations
				.add("Current Quarter: " + quarterdateformat.format(calCurrentQuarterFirstMonth.getTime()) + "-"
						+ quarterdateformat.format(calCurrentQuarterLastMonth.getTime()) + "'" + currentYearText);

		Calendar calPreviousQuarterFirstMonth = Calendar.getInstance();
		calPreviousQuarterFirstMonth.set(Calendar.MONTH, calPreviousQuarterFirstMonth.get(Calendar.MONTH) / 3 * 3 - 3);
		Calendar calPreviousQuarterLastMonth = Calendar.getInstance();
		calPreviousQuarterLastMonth.set(Calendar.MONTH, calPreviousQuarterLastMonth.get(Calendar.MONTH) / 3 * 3 + -1);
		if (quarterdateformat.format(calPreviousQuarterLastMonth.getTime()).equals("Dec")) 
			lstExpectedTimeDurations
					.add("Previous Quarter: " + quarterdateformat.format(calPreviousQuarterFirstMonth.getTime()) + "-"
							+ quarterdateformat.format(calPreviousQuarterLastMonth.getTime()) + "'" + (Integer.valueOf(currentYearText)-1));
		 else
			lstExpectedTimeDurations
					.add("Previous Quarter: " + quarterdateformat.format(calPreviousQuarterFirstMonth.getTime()) + "-"
							+ quarterdateformat.format(calPreviousQuarterLastMonth.getTime()) + "'" + currentYearText);

		DateFormat dateformat = new SimpleDateFormat("MMMM YYYY");
		Calendar calculateMonths = Calendar.getInstance();
		calculateMonths.add(Calendar.MONTH, 0);
		lstExpectedTimeDurations.add("Current Month: " + (dateformat.format(calculateMonths.getTime())));
		calculateMonths.add(Calendar.MONTH, -1);
		lstExpectedTimeDurations.add((dateformat.format(calculateMonths.getTime())));
		calculateMonths.add(Calendar.MONTH, -1);
		lstExpectedTimeDurations.add((dateformat.format(calculateMonths.getTime())));

		return lstExpectedTimeDurations;
	}

	/**
	 * This method will click on the required time duration option
	 * 
	 * @author srissti.tyagi
	 * @param requiredTimeDurationOption
	 */
	public void clickOnRequiredTimeDuration(String requiredTimeDurationOption) {
		click(parameterizedLocator(lblRequiredTimeDurationOption, requiredTimeDurationOption));
		TestNGLogUtility.info("User clicked on " + requiredTimeDurationOption + "time duration option");
	}

	/**
	 * This method will verify that the selected time duration is visible in the
	 * table text
	 * 
	 * @param selectedTimeDuration
	 * @return booleanValueForTImeDurationVisibility
	 */
	public boolean verifySelectedTimeDurationIsVisible(String selectedTimeDuration) {
		return (getText(lblSelectedTimeDuration).contains(selectedTimeDuration));
	}

	/**
	 * This method will click on time period drop down in the save schedule popUp
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnReportTimePeriodDropDown() {
		click(eleReportTimePeriodDropDown);
		TestNGLogUtility.info("User clicked on Report Time Period Drop Down Option");
	}

	/**
	 * This method will click on the required time period option in the save
	 * schedule pop up
	 * 
	 * @author srissti.tyagi
	 * @param requiredReportTimePeriod
	 */
	public void clickOnRequiredReportTimePeriod(String requiredReportTimePeriod) {
		click(parameterizedLocator(lblRequiredReportTimePeriodOption, requiredReportTimePeriod));
		TestNGLogUtility.info("User selected the " + requiredReportTimePeriod + " time period option");
	}

	/**
	 * THis method will return the list of visible frequency options after selecting
	 * a particular time period in the save schedule pop up
	 * 
	 * @author srissti.tyagi
	 * @return visibleListOfFrequencies
	 */
	public List<String> verifyFrequencyOptions() {
		ArrayList<String> visibleListOfFrequencies = new ArrayList<String>();
		int count = getElements(eleNoOfFrequencyOptions).size();
		for (int i = 1; i <= count; i++)
			visibleListOfFrequencies.add(getText(parameterizedLocator(lblTextOfFrequencyOption, Integer.toString(i))));
		return visibleListOfFrequencies;
	}

	/**
	 * This method will select custom "from" and custom "to" dates
	 * 
	 * @author srissti.tyagi
	 */
	public void selectCustomDurationDates() {
		DateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
		Calendar calCurrentDate = Calendar.getInstance();
		calCurrentDate.add(Calendar.DAY_OF_YEAR, 0);
		CurrentDate = (dateformat.format(calCurrentDate.getTime()));
		// click(eleChooseDatePicker);
		selectedFromDate = selectDate(CurrentDate, "fromDateSelect");
		System.out.println("selected date-->>  "+selectedFromDate);
		TestNGLogUtility.info("User chose the current FROM date which is : " + selectedFromDate);
		selectedToDate = selectDate(CurrentDate, "toDateSelect");
		System.out.println("selectedToDate0--->> "+selectedToDate);
		TestNGLogUtility.info("User chose the current TO date which is : " + selectedToDate);
		click(btnApplyForTimeDuration);
		TestNGLogUtility.info("User clicked on Apply button on CustomDates");
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * This method will select the date, by removing the read only attribute and
	 * providing the required date as input
	 * 
	 * @param dateToBeSelected
	 * @param elementToBeSelected
	 * @return selectedDate
	 * @author srissti.tyagi
	 */
	public String selectDate(String dateToBeSelected, String elementToBeSelected) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String selectedDate = "";
		WebElement webElementSelectFromDate = driver
				.findElement(parameterizedLocator(eleSelectFromDate, elementToBeSelected));
		js.executeScript("arguments[0].removeAttribute('readonly','readonly')", webElementSelectFromDate);
		js.executeScript("arguments[0].value = '';", webElementSelectFromDate);
		// js.executeScript("arguments[0].value = '" + dateToBeSelected + "';",
		// webElementSelectFromDate);
		click(parameterizedLocator(eleSelectFromDate, elementToBeSelected));
		getElement(eleSelectFromDate, elementToBeSelected).sendKeys(Keys.BACK_SPACE);
		getElement(eleSelectFromDate, elementToBeSelected).sendKeys(Keys.SHIFT,Keys.HOME);
		getElement(eleSelectFromDate, elementToBeSelected).sendKeys(Keys.BACK_SPACE);
		//wait.hardWait(4);
		sendKeys(parameterizedLocator(eleSelectFromDate, elementToBeSelected), dateToBeSelected);
		selectedDate = getAttribute(parameterizedLocator(eleSelectFromDate, elementToBeSelected), "value");
		return selectedDate;
	}

	/**
	 * This method will verify that selected custom dates are visible in the table
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForCustomDateVisibility
	 */
	public boolean verifySelectedCustomTimeDuration() {
		if (getText(lblSelectedTimeDurationText).contains(selectedFromDate)
				&& getText(lblSelectedTimeDurationText).contains(selectedToDate))
			flag = true;
		return flag;
	}
}
