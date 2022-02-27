package com.naukri.pageobjects.Reports;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class RequisitionReportsPageObject extends BaseAutomation {

	boolean flag = false;
	ArrayList<String> stagesListFromReports = new ArrayList<String>();
	ArrayList<String> calculationOptionsSettingsListFromReports = new ArrayList<String>();

	public static By settingsIcon = By.xpath("//span[contains(@class,'icn-edit')]");
	public static By dropDownArrowForTimeSelection = By
			.xpath("//div[@id='timeFilterWrapper']//h2//img[@class='dropdownArrow']");
	public static By selectedDivisionOption = By.xpath("//span[@class='selectTDValue']");

	/**
	 * This method will enable the user to click on the required view mode of the
	 * report , which could be tabular or graphical
	 * 
	 * @param modeType
	 */
	public void clickOnTheRequiredModeType(String modeType) {
		By clickOnRequiredSubtabElement = By.xpath("//span[text()='" + modeType + "']");
		if (getAttribute(clickOnRequiredSubtabElement, "class").contains("Active"))
			TestNGLogUtility.info(" User already on " + modeType + " Tab ");
		else {
			click(clickOnRequiredSubtabElement);
			wait.waitForValignWrapperToDisappear(10, 6);
			TestNGLogUtility.info(" User clicked on " + modeType + " Tab");
		}
	}

	/**
	 * This method enables the user to verify the list of options visible for
	 * calculation settings
	 * 
	 * @param reportName
	 * @return
	 */
	public List<String> verifyOptionsForFirstSettingIconinDetailedReport(String reportName) {
		int noOfElements = getElements(By.xpath("//label[@class='radio-label']")).size();
		for (int i = 1; i <= noOfElements; i++)
			calculationOptionsSettingsListFromReports
					.add(getText(By.xpath("(//label[@class='radio-label'])[" + i + "]")));
		return calculationOptionsSettingsListFromReports;
	}

	/**
	 * This method enables the user to verify the list of custom column names
	 * present in requisition reports
	 * 
	 * @param reportName
	 * @return
	 */
	public List<String> verifyCustomStagesListInDetailedReportForRequisitionReports(String reportName) {
		int noOfElements = getElements(By.xpath("//ul[@class='dropdown ']//span[@title]")).size();
		for (int i = 1; i <= noOfElements; i++) {
			By getStageName = By.xpath("(//li[@value]//span[@title])[" + i + "]");
			jsUtil.scrollDown(getStageName);
			stagesListFromReports.add(getText(getStageName));
		}
		return stagesListFromReports;

	}

	/**
	 * This method enables the user to verify that the tab that was selected should
	 * be visible in the report
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean verifysubTabclickforRequiredReportInDetailedView(String tabName) {
		By verifysubTabClick = By.xpath("//span[text()='" + tabName + "']");
		return (elementVisibility(verifysubTabClick));
	}

	/**
	 * This method enables the user to verify that no setting icon option is visible
	 * to user where it is not required to be visible
	 * 
	 * @return
	 */
	public boolean verifyThatNoSettingOptionIsVisibleInGraphicalMode() {
		return (!isDisplayed(settingsIcon));
	}

	/**
	 * This method enables the user to verify the summary elements for a specific
	 * report in the detailed view
	 * 
	 * @param reportName
	 * @return
	 */
	public List<String> verifySummaryElementsForSpecifiedDetailedReport(String reportName) {
		int noOfElements = getElements(By.xpath("//div[@class='widgetName']")).size();
		for (int i = 1; i <= noOfElements; i++) {
			By getStageName = By.xpath("(//div[@class='widgetName'])[" + i + "]");
			stagesListFromReports.add(getText(getStageName));
		}
		return stagesListFromReports;
	}

	/**
	 * This method enables the user to verify that option of division is visible in
	 * the required detailed report
	 * 
	 * @return
	 */
	public boolean verifyDivisionOptionsInDetailedReport() {
		return (isDisplayed(By.xpath("//div[contains(text(),'Only showing activity of requisitions ')]"))
				&& isDisplayed(By.xpath("//span[text()='Division: ']")));
	}

	/**
	 * This method enables the user to select a particular time duration in the
	 * detailed report
	 * 
	 * @param selectedTimeDuration
	 */
	public void selectRequiredTimeDuration(String selectedTimeDuration) {
		click(dropDownArrowForTimeSelection);
		click(By.xpath("//span[contains(text(),'" + selectedTimeDuration + "')]"));
		TestNGLogUtility.info(" User selects the required time duration ");
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * This method enables the user to verify that the time division labels are
	 * visible according to the select time division
	 * 
	 * @param selectedTimeDuration
	 * @return
	 */
	public boolean verifyThatDivisionOptionsAreVisibleAccordingToTheSelectedTimeDuration(String selectedTimeDuration) {
		click(selectedDivisionOption);
		if (selectedTimeDuration.equals("Current Quarter"))
			flag = isDisplayed(By.xpath("//span[text()='Weekly']"))
					&& isDisplayed(By.xpath("//span[text()='Monthly']"));
		else if (selectedTimeDuration.equals("Current Quarter"))
			flag = isDisplayed(By.xpath("//span[text()='Weekly']"))
					&& !isDisplayed(By.xpath("//span[text()='Monthly']"));
		return flag;
	}

}