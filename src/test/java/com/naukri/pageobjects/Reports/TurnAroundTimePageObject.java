package com.naukri.pageobjects.Reports;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.stepdefinitions.Reports.SaveAndScheduleStepDef;
import com.naukri.test.base.BaseAutomation;

public class TurnAroundTimePageObject extends BaseAutomation {

	boolean flag = false;
	ArrayList<String> stagesListFromReport = new ArrayList<String>();
	ArrayList<String> stagesListFromSettings = new ArrayList<String>();

	public static By eleTotalNoOfParentStages = By.xpath("//div[contains(@class,'mainlist')]");
	public static By eleTotalNoOfStagesInReport = By.xpath("//ul[@class='dropdown ']//li");
	public static By lblNameOfParentStageOnSettingsPage = By.xpath("(//div[contains(@class,'acc_head_title')])[${i}]");
	public static By lblNameOfSelectionStageOnReportsPage = By
			.xpath("(//ul[@class='dropdown ']//span[@class='selectLabel'])[${i}]");

	/**
	 * This method will get all the parent stages present in the system
	 * 
	 * @return arrayListForCustomStagesFromSettingsPage
	 * @author srissti.tyagi
	 */
	public ArrayList<String> getSelectionStagesFromRMSSettings() {
		int count = getElements(eleTotalNoOfParentStages).size();
		for (int i = 1; i <= count; i++)
			stagesListFromSettings
					.add(getText(parameterizedLocator(lblNameOfParentStageOnSettingsPage, Integer.toString(i))).trim());
		return stagesListFromSettings;
	}

	/**
	 * This method will get all the custom stages present in the reports
	 * 
	 * @return arrayListForCustomStagesFromReportsPage
	 * @author srissti.tyagi
	 */
	public ArrayList<String> getAllSelectionInStageLevelTATReport() {
		int count = getElements(eleTotalNoOfStagesInReport).size();
		for (int i = 1; i <= count; i++) {
			scrollToElement(parameterizedLocator(lblNameOfSelectionStageOnReportsPage, Integer.toString(i)));
			stagesListFromReport
					.add(getText(parameterizedLocator(lblNameOfSelectionStageOnReportsPage, Integer.toString(i))).trim());
		}
			return stagesListFromReport;
	}

}
