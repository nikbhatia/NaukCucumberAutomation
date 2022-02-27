package com.naukri.pageobjects.Reports;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

import scala.annotation.meta.getter;

public class ReportsCommonPageObject extends BaseAutomation {

	DashboardPageObject dashboardPO = new DashboardPageObject();
	ArrayList<String> CustomStagesListFromReports = new ArrayList<String>();
	String reportName = "", firstreportName = "";
	int selectedSatges = 0;
	boolean loaderflag = false, flag = false;

	public static By btnSaveInSaveSchedulePopUp = By.xpath("//div[@class='popSave']");
	public static By lnkReportDownload = By.xpath("//div[@id='_bodyContent']");
	public static By eleTotalNoOFilters = By.xpath("//div[@class='filterList']//div[contains(@class,'filter')]");
	public static By eleIconEllipsesForDetailedReport = By.xpath("//img[contains(@src,'Ellipsis')]");
	public static By eleSaveOrScheduleOptionInEllipsis = By.xpath("//div[contains(text(),'Save/Schedule')]");
	public static By txtReportNameFieldInSaveSchedulePopUp = By.xpath("//input[@id='reportName']");
	public static By eleCheckForErrorMsg = By.xpath("//p[contains(text(),'error while trying to generate Report')]");
	public static By lnkToReloadTheReport = By.xpath("//a[text()='Reload']");
	public static By eleFirstOptionInSettingForStageLevelFunnel = By.xpath("//div[@class='radioDropdownWrapper']/..");
	public static By eleSecondOptionInSettingForStageLevelFunnel = By
			.xpath("//div[contains(@class,'dropdownMainContainer')]");
	public static By btnSettingsIcon = By.xpath("//span[contains(@class,'icn-edit')]");
	public static By btnFilterIcon = By.xpath("//span[contains(@class,'icn-filter')]");
	public static By eleTotalNoOfStagesInCustomReport = By.xpath("//ul[@class='dropdown ']//li");
	public static By btnApplyForCustomStageSelection = By
			.xpath("//div[contains(@class,'dropDownPrimaryContainer')]//button[text()='Apply'] ");
	public static By lblNoDataForSelectedTimeDurationMessage = By
			.xpath("(//p[text()='No Data exists for your selection.'])[1]");
	public static By chkShareOrScheduleOptionInSaveSchedulePopUp = By.xpath("//label[text()='${checkBoxToBeClicked}']");
	public static By eleRequiredSubTab = By.xpath("//div[text()='${tabName}']");
	public static By eleSettingsIcon = By.xpath("//span[@class='dropArrowDD']");
	public static By chkUnselectedCustomStage = By.xpath("(//li[@class='multi '])[1]");
	public static By eleToCheckRequiredSettingSelection = By.xpath("//input[@id='${selectedStageSetting}']");
	public static By lblToClickOnRequiredSetting = By.xpath("//label[@for='${selectedStageSetting}']");
	public static By eleNoOfColumnsForStageLevelFunnelReport = By.xpath("//p[@class='stepLabel']");
	public static By eleNoOfColumnsForRequisitionTatReport = By.xpath("//div[@id='tableHeader']//div[@class]//span[2]");
	public static By eleNoOfColumnsForHmReport = By.xpath("//div[contains(@id,'tableHead')]//span");
	public static By lblColumnNameForRequisitionTatReport = By
			.xpath("(//div[@id='tableHeader']//div[@class]//span[2])[${i}]");
	public static By lblColumnNameForHmReport = By.xpath("(//div[contains(@id,'tableHead')]//span)[${i}]");
	public static By firstSavedReportFromList = By.xpath("(//a[@class='linkColor'])[1]");
	public static By lblAllStagesVisible = By.xpath("(//ul[@class='dropdown ']//li)[${i}]");
	public static By lblAlreadySelectedStages = By.xpath("(//ul[@class='dropdown ']//span[@title])[${i}]");
	public static By eleAllRequirementName= By.xpath("//ul[@class='conversionReportListingContainer']//a");
	public static By eleSpecificRequirementName= By.xpath("(//ul[@class='conversionReportListingContainer']//a)[${value}]");
	public static By eleTotalStageCount=By.xpath("//div[@id='tableHeader']//div[contains(@class,'table-row-item col')]");
	public static By eleStageName=By.xpath("//div[@id='tableHeader']//div[contains(@class,'table-row-item col')][${value}]");
	public static By eleStageCandidateCount=By.xpath("//a[text()='${reqName}']/ancestor::li//div[@class='table-row-item'][${value}]");
	public static By eleRequirementCount=By.xpath("//div[@class='tableNameColumn']//a");
	public static By eleRequirementName=By.xpath("(//div[@class='tableNameColumn']//a)[${value}]");

	/**
	 * This method clicks on the schedule checkbox that is visible on the save and
	 * schedule popup
	 * 
	 * @author srissti.tyagi
	 * @param checkBoxToBeClicked
	 */
	public void clickOnShareOrScheduleCheckBoxOnSaveSchedulePopUp(String checkBoxToBeClicked) {
		getElement(chkShareOrScheduleOptionInSaveSchedulePopUp, checkBoxToBeClicked).click();
		TestNGLogUtility.info("User clicked on " + checkBoxToBeClicked + " checkbox");
	}

	/**
	 * This method clicks on the Save button after user has entered the mandatory
	 * fields - in order to save or schedule or share a report
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnSaveOnSaveSchedulePopUp() {
		click(btnSaveInSaveSchedulePopUp);
		TestNGLogUtility.info("User clicked on Save button on the pop up");
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * This method will verify that Download link is generated when the user
	 * switched to new window after clicking on download option
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForDownloadLinkVIsibility
	 */
	public boolean verifyDownloadLink() {
		return (isDisplayed(lnkReportDownload));
	}

	/**
	 * This method enables the user to click on save or schedule option in the
	 * detailed view of any report and also enter a unique name for saving the
	 * report
	 * 
	 * @author srissti.tyagi
	 * @return reportNameEnteredInSaveSchedulePopUp
	 */
	public String returnReportNameFromDetailedView() {
		wait.waitForValignWrapperToDisappear(10, 5);
		reportName = "New Report" + dashboardPO.timestamp();
		click(eleIconEllipsesForDetailedReport);
		click(eleSaveOrScheduleOptionInEllipsis);
		wait.waitForValignWrapperToDisappear(10, 3);
		sendKeys(txtReportNameFieldInSaveSchedulePopUp, reportName);
		TestNGLogUtility
				.info("Report name : " + reportName + " is generated, entered and returned in the respective field ");
		return reportName;
	}

	/**
	 * This method first verifies if the report has loaded, if not then it tries to
	 * reload the report
	 * 
	 * @author srissti.tyagi
	 * @throws InterruptedException
	 */
	public boolean ReLoadingInCaseOfError() {
		wait.waitForValignWrapperToDisappear(10, 5);
		if (!isDisplayed(eleCheckForErrorMsg)) {
			TestNGLogUtility.info("Report has already loaded ");
			loaderflag = true;
		} else {
			TestNGLogUtility.info("Report couldn't be loaded at once, will try to reload now");
			loaderflag = ReLoadingInCaseOfErrorinDetailedReport();
		}
		return loaderflag;
	}

	/**
	 * This method tries to reload the report again if it fails to load initially
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForErrorMessageIfReportFailsToLOadEvenAFterMultipleTries
	 */
	public boolean ReLoadingInCaseOfErrorinDetailedReport() {
		for (int i = 1; i <= 2; i++) {
			click(lnkToReloadTheReport);
			TestNGLogUtility.info("User clicked on the reload link ");
			wait.waitForValignWrapperToDisappear(10, 5);
			if (!isDisplayed(eleCheckForErrorMsg)) {
				loaderflag = true;
				break;
			} else
				continue;
		}
		return loaderflag;
	}

	/**
	 * This method enables the user to click on the required tab in the detailed
	 * report
	 * 
	 * @author srissti.tyagi
	 * @param tabName
	 */
	public void clickOnMentionedTabInDetailedReport(String tabName) {
		if (getElement(eleRequiredSubTab, tabName).getAttribute("class").contains("Active")) {
			TestNGLogUtility.info(" User already on " + tabName + " Tab ");
		} else {
			getElement(eleRequiredSubTab, tabName).click();
			wait.waitForValignWrapperToDisappear(10, 5);
			TestNGLogUtility.info(" User clicked on " + tabName + " Tab");
		}
	}

	/**
	 * This method will enable the user to click on the option of Select Custom
	 * Columns, under the settings icon
	 * 
	 * @author srissti.tyagi
	 * @param optionToBeSelected
	 * @param reportName
	 */
	public void clickOnSecondSettingOptionForCustomReports(String optionToBeSelected, String reportName) {
		if (optionToBeSelected.equals("first"))
			click(eleFirstOptionInSettingForStageLevelFunnel);
		else if (optionToBeSelected.equals("second"))
			click(eleSecondOptionInSettingForStageLevelFunnel);
		TestNGLogUtility.info("  User clicked on " + optionToBeSelected + " Setting option ");
	}

	/**
	 * This method enables the user to click on the settings icon
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnSettingIconInAnyDetailedReport() {
		if (getElements(eleSettingsIcon).size() != 0) {
			jsUtil.executeJavascript(
					"document.getElementById('advanceSelectDD').setAttribute('style', 'display:inline');");
			jsUtil.clickByJS(By.id("advanceSelectDD"));
		} else
			click(btnSettingsIcon);
	}

	/**
	 * This method will get all the stages that have been already selected
	 * 
	 * @author srissti.tyagi
	 */
	public ArrayList<String> getTotalNumberAndListOfSelectedStages() {
		CustomStagesListFromReports.clear();
		int count = getElements(eleTotalNoOfStagesInCustomReport).size();
		for (int i = 1; i <= count; i++) {
			String className = "";
			className = getAttribute(parameterizedLocator(lblAllStagesVisible, Integer.toString(i)), "class");
			if (className.contains("multi selected")) {
				selectedSatges++;
				By selectedStageName = parameterizedLocator(lblAlreadySelectedStages, Integer.toString(i));
				jsUtil.scrollDown(selectedStageName);
				CustomStagesListFromReports.add(getText(selectedStageName).toLowerCase());
			}
		}
		return CustomStagesListFromReports;
	}

	/**
	 * This method helps the user click on the apply button to refine the results
	 * based on custom selections
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnApplyButtonForColumnSelectionForCustomStages() {
		getElement(btnApplyForCustomStageSelection).click();
		TestNGLogUtility.info(" User clicked on Apply Button for Custom Stages");
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * This method will enable the user to select one more stage , if maximum no of
	 * stages, which is 6, has not already been selected
	 * 
	 * @author srissti.tyagi
	 */
	public void selectOneCustomStageForCheckingMaximumlimit() {
		if (selectedSatges < 6) {
			click(chkUnselectedCustomStage);
			TestNGLogUtility.info(" User selected the first unselected stage");
		} else
			TestNGLogUtility.info(" User has already selected the maximum no of stages");
	}

	/**
	 * This method will verify that only those stages are visible as a column which
	 * have been selected by the user from settings option in this report
	 * 
	 * @author srissti.tyagi
	 * @param CustomStagesListFromReports
	 * @return
	 */
	public boolean verifyColumnNamesAccordingToSelectionStages(String reportName,
			ArrayList<String> CustomStagesListFromReports) {
		ArrayList<String> columnNameList = new ArrayList<String>();
		int noOfColumns = 0;
		wait.waitForValignWrapperToDisappear(10, 5);
		if (!(isDisplayed(lblNoDataForSelectedTimeDurationMessage))) {
			if (reportName.equals("Requisition TAT")) {
				noOfColumns = getElements(eleNoOfColumnsForRequisitionTatReport).size();
				for (int i = 1; i <= noOfColumns; i++)
					columnNameList.add(
							getText(parameterizedLocator(lblColumnNameForRequisitionTatReport, Integer.toString(i)))
									.toLowerCase());
			} else {
				noOfColumns = getElements(eleNoOfColumnsForHmReport).size();
				for (int i = 2; i <= noOfColumns; i++)
					columnNameList.add(
							getText(parameterizedLocator(lblColumnNameForHmReport, Integer.toString(i))).toLowerCase());
			}
			flag = (CustomStagesListFromReports.equals(columnNameList));
		} else {
			TestNGLogUtility.info(" Either reports cound't be loaded after selecting stages or "
					+ "there is no data for the selected stages in the selected time period ");
			flag = true;
		}
		return flag;
	}

	/**
	 * This method enables the user to click on the filter icon visible in detailed
	 * report
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnFilterIconInDetailedReport() {
		click(btnFilterIcon);
		TestNGLogUtility.info("User clicked on Filter Icon");
	}

	/**
	 * This method verifies the list of filter options visible which vary report to
	 * report
	 * 
	 * @author srissti.tyagi
	 * @param reportName
	 * @return listOfFilterCategories
	 */
	public List<String> verifyFiltersList(String reportName) {
		int noOfFilters = getElements(eleTotalNoOFilters).size();
		ArrayList<String> filtersList = new ArrayList<String>();
		for (int i = 1; i <= noOfFilters; i++) {
			By filterName = By.xpath("(//div[@class='filterList']//div[contains(@class,'filter')])[" + i + "]");
			filtersList.add(getText(filterName));
		}
		return filtersList;
	}

	/**
	 * This method will enable the user to click on the required calculation setting
	 * for any report in the detailed view, provided that setting is not already
	 * chosen
	 * 
	 * @author srissti.tyagi
	 * @param selectedStageSetting
	 */
	public void clickOnRequiredStageSettingFromDetailedReport(String selectedStageSetting) {
		String attributeValue = "";
		attributeValue = getElement(eleToCheckRequiredSettingSelection, selectedStageSetting).getAttribute("checked");
		if (attributeValue == null) {
			click(parameterizedLocator(lblToClickOnRequiredSetting, selectedStageSetting));
			wait.waitForValignWrapperToDisappear(10, 3);
			TestNGLogUtility.info("User clicked on " + selectedStageSetting + " stage ");
		} else
			TestNGLogUtility.info("User already on the required setting ");
	}

	/**
	 * THis method verifies that reports are saved in the reverse chronological
	 * order , that is , the report that was saved most recently should be visible
	 * at the top
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForTestingThatScheduledReportIsVisibleOnListingPage
	 */
	public boolean verifyReverseChronologicalOrderInDetailedReport(String reportName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		firstreportName = getAttribute(firstSavedReportFromList, "title");
		System.out.println("reportName--> "+ reportName);
		System.out.println("firstreportName-->> "+ firstreportName);
		return (reportName.equals(firstreportName));
	}
	
	/**
	 * This method will verify Created requirement is displaying in Generated report
	 * @author himanshu.dua
	 * @param reqName
	 * @return
	 */
	public boolean verifyCreatedRequirementConversionInReport(String reqName) {
		int size=getElements(eleAllRequirementName).size();
		scrollToElement(parameterizedLocator(eleSpecificRequirementName, Integer.toString(size)));
		wait.waitForValignWrapperToDisappear(10, 3);
		size=getElements(eleAllRequirementName).size();
		System.out.println(size);
		for(int i=size; i>0; i--) {
			if(getText(parameterizedLocator(eleSpecificRequirementName, Integer.toString(i))).trim().equals(reqName)){
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public boolean verifyCandidateCountAgainstStage(String requiremntName, String stageName) {
		int stageNumber=0;
		int size= getElements(eleTotalStageCount).size();
		for(int i=1;i<=size;i++) {
			if(getText(parameterizedLocator(eleStageName,Integer.toString(i))).trim().equals(stageName)) {
				stageNumber=i;
				break;
			}
		}
		return !getText(parameterizedLocator(eleStageCandidateCount, requiremntName, Integer.toString(stageNumber))).trim().equals("-");
	}
	
	/**
	 * This method will verify Created requirement is displaying in Generated report
	 * @author himanshu.dua
	 * @param reqName
	 * @return
	 */
	public boolean verifyCreatedRequirementInStageTATReport(String reqName) {
		int size=getElements(eleRequirementCount).size();
		scrollToElement(parameterizedLocator(eleRequirementName, Integer.toString(size)));
		wait.waitForValignWrapperToDisappear(10, 3);
		size=getElements(eleRequirementCount).size();
		System.out.println(size);
		for(int i=size; i>0; i--) {
			if(getText(parameterizedLocator(eleRequirementName, Integer.toString(i))).trim().equals(reqName)){
				flag=true;
				break;
			}
		}
		return flag;
	}
}
