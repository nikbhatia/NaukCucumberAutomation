package com.naukri.pageobjects.Reports;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class ConversionFunnelReportsPageObject extends BaseAutomation {

	boolean flag = false, loaderflag = false;
	boolean firstClosedRequirementFlag = false;
	boolean verifyFilterWarning = false;
	int selectedSatges = 0;
	String reportName = "", firstRequirementname = "";
	ArrayList<String> stagesListFromSettings = new ArrayList<String>();
	ArrayList<String> CustomStagesListFromReports = new ArrayList<String>();
	DashboardPageObject dashboardPO = new DashboardPageObject();

	public static By NoDataForSelectedTimeDurationMessage = By
			.xpath("(//p[text()='No Data exists for your selection.'])[1]");
	public static By refineFilterButton = By.xpath("//div[text()=' Refine ']");
	public static By firstVisibleRequirement = By.xpath("(//a[contains(@href,'project/dashboard')])[1]");
	public static By totalNoOfRequirements = By.xpath("//a[contains(@href,'project/dashboard')]");
	public static By totalNoOfColumnsSelected = By.xpath("//p[@class='quantity']");
	public static By RequirementSearch = By.xpath("//input[@id='keywords']");
	public static By requirementSearchIcon = By.xpath("//form[@id='search']//input[@type='submit']");
	public static By firstOptionInSetting = By.xpath("//li[@class='showCalculationDD']");
	public static By totalNoOfStagesInCustomReport = By.xpath("//ul[@class='dropdown ']//li");
	public static By checkForErrorMsg = By.xpath("//p[contains(text(),'error while trying to generate Report')]");
	public static By iconEllipsesForDetailedReport = By.xpath("//img[contains(@src,'Ellipsis')]");
	public static By firstRequirementNameInDetailedReport = By.xpath("(//a[@class='linkColor'])[1]");
	public static By getRequirementNameOnOverviewPage = By.xpath("//div[@class='hText fl']");
	// public static By clickDownloadOnListingPage =
	// By.xpath("(//ul[@class='actionsList'])[1]//li[text()='Download']");
	public static By downloadFromDetailedReport = By.xpath("//div[text()='Download this Report']");
	public static By eleStageName = By.xpath("(//ul[@class='dropdown ']//li)[${i}]");

	/**
	 * This method verifies that the columns have the required tool tips in
	 * requirement Funnel Report
	 * 
	 * @param columnName
	 * @param reportName
	 * @return
	 */
	public boolean verifyToolTipForRequiredColumnNameInDetailedReport(String expectedToolTipText, String reportName,
			String toolTipTextForRespectiveColumnName) {
		if (!(isDisplayed(NoDataForSelectedTimeDurationMessage))) {
			flag = (toolTipTextForRespectiveColumnName.equals(PropFileHandler.readProperty(expectedToolTipText)));
		} else
			flag = true;
		System.out.println("printing again : " + toolTipTextForRespectiveColumnName + "and " + expectedToolTipText);
		return flag;
	}

	/**
	 * This method will enable the user to click on a particular filter after
	 * clicking on filters icon
	 * 
	 * @param filterName
	 */
	public void clickOnRequiredFilterName(String filterName) {
		click(By.xpath("//div[text()='" + filterName + "']"));
		TestNGLogUtility.info("User clicked on " + filterName + " filter");
	}

	/**
	 * This method will enable the user to click on a filter value after clicking on
	 * a particular filter category
	 * 
	 * @param labelName
	 */
	public void selectRequiredFilterLabels(String labelName) {
		click(By.xpath("//label[text()='" + labelName + "']"));
		TestNGLogUtility.info("User clicked on  " + labelName + " label");
	}

	/**
	 * This method enables the user to click on the Refine button to apply the
	 * selected filters
	 */
	public void clickOnRefineFilter() {
		click(refineFilterButton);
		TestNGLogUtility.info("User clicked on Refine Button to apply the filters");
		if (getElements(By.xpath("//p[contains(text(),'Something went wrong on our end')]")).size() != 0
				|| getElements(checkForErrorMsg).size() != 0)
			verifyFilterWarning = true;
	}

	/**
	 * This method will verify if any requirement is visible with the applied filter
	 * in the selected time duration
	 * 
	 * @return
	 */
	public String verifyClosedRequirementVisible() {
		String firstClosedRequirement = "";
		if (isDisplayed(firstVisibleRequirement)) {
			firstClosedRequirement = getText(firstVisibleRequirement);
			TestNGLogUtility.info(" First closed requirement is " + firstClosedRequirement);
			firstClosedRequirementFlag = true;
		}
		return firstClosedRequirement;
	}

	/**
	 * This method enables the user to verify that the results shown after applying
	 * the required filter is correct, provided that some results were shown after
	 * applying that particular filter and no error was thrown after applying the
	 * filter
	 * 
	 * @param statusToBeTested
	 * @return
	 */
	public boolean verifyRequirementStatusFunction(String statusToBeTested) {
		String firstClosedRequirement = verifyClosedRequirementVisible();
		if (firstClosedRequirementFlag == true && verifyFilterWarning == false) {
			goToPageURL(getAppConfigValue("URLs.RequirementListingPage"));
			click(RequirementSearch);
			sendKeys(RequirementSearch, firstClosedRequirement);
			click(requirementSearchIcon);
			if (getText(By.xpath("(//ul[@class='manage cle'])[1]//a[text()='" + statusToBeTested + "']"))
					.equals(statusToBeTested))
				flag = true;
		} else {
			TestNGLogUtility.info(" No " + statusToBeTested + " requirements yet");
			flag = true;
		}
		return flag;
	}

	/**
	 * This method enables the user to click on the required subtab in the report :
	 * which can be requirement , Group/Employers or Recruiters
	 * 
	 * @param tabName
	 */
	public void goToRequiredSubTab(String tabName) {
		By clickOnRequiredSubtabElement = By.xpath("//div[@id='root']//*[text()='" + tabName + "']");
		if (getAttribute(clickOnRequiredSubtabElement, "class").contains("Active"))
			TestNGLogUtility.info(" User already on " + tabName + " Tab ");
		else {
			click(By.xpath("//div[text()='" + tabName + "']"));
			wait.waitForValignWrapperToDisappear(10, 3);
			TestNGLogUtility.info(" User clicked on " + tabName + " Tab");
		}
	}

	/**
	 * This method will check for the no of selected and total stages in the report
	 * and then further verify that user is not able to select more than 6 stages
	 * 
	 * @return
	 */
	public boolean verifyMaximumSelectableStagesInCustomReport() {
		int totalSelectedCount = 0, notSelectedCount = 0;
		int count = getElements(totalNoOfStagesInCustomReport).size();
		for (int i = 1; i <= count; i++) {
			By stageName = By.xpath("(//ul[@class='dropdown ']//li)[" + i + "]");
			String className = getAttribute(stageName, "class");
			if (className.contains("multi selected"))
				totalSelectedCount++;
			else
				notSelectedCount++;
		}

		if (totalSelectedCount == 6) {
			flag = verifyMaxStages(count, notSelectedCount);
		}

		else if (totalSelectedCount < 6) {
			for (int i = 1; i <= count; i++) {
				By stageName = By.xpath("(//ul[@class='dropdown ']//li)[" + i + "]");
				String toBeSelectedClassName = getAttribute(stageName, "class");
				if (!toBeSelectedClassName.contains("selected")) {
					WebElement toBeselectedStage = getElement(By.xpath("(//ul[@class='dropdown ']//li)[" + i + "]"));
					toBeselectedStage.click();
					totalSelectedCount++;
					notSelectedCount--;
					if (totalSelectedCount == 6) {
						flag = verifyMaxStages(count, notSelectedCount);
						break;
					} else
						continue;
				}
			}
		}
		return flag;
	}

	/**
	 * This method will verify that user is not able to select more than 6 stages
	 * 
	 * @param count
	 * @param notSelectedCount
	 * @return
	 */
	public boolean verifyMaxStages(int count, int notSelectedCount) {
		String disabledClassName = "";
		int disabledClassCount = 0;
		for (int i = 1; i <= count; i++) {
			disabledClassName = getAttribute(parameterizedLocator(eleStageName, Integer.toString(i)), "class");
			if (disabledClassName.contains("disabled")&& !disabledClassName.contains("disabled multi selected "))
				disabledClassCount++;
		}
		return (disabledClassCount == notSelectedCount);
	}

	/**
	 * This method enables the user to hover over any column in the required report
	 * and store the required tool tip for that column
	 * 
	 * @param columnName
	 */
	public String hoverOnRequiredColumnNameInDetailedReport(String columnName) {
		String toolTipTextForRespectiveColumnName = "";
		By hoverOnColumnName = By.xpath("//div[@id='tableHead']//*[contains(text(),'" + columnName + "')]");
		// if (isDisplayed(hoverOnColumnName)) {
		hover(hoverOnColumnName);
		TestNGLogUtility.info("User hovered on the <- " + columnName + " -> column name");
		toolTipTextForRespectiveColumnName = getAttribute(
				By.xpath("//*[contains(text(),'" + columnName + "')]/ancestor::div[@class='col ']"), "title");
		// } else {
		// TestNGLogUtility.info("Column : " + columnName + " is not visible /
		// selected");
		// }
		return toolTipTextForRespectiveColumnName;
	}

	/**
	 * This method clicks on first requirement, provided there is data in the
	 * selected time duration
	 * 
	 * @return
	 */
	public String clickOnFirstRequirementAndReturnTheNameClicked() {
		if (isDisplayed(firstRequirementNameInDetailedReport)) {
			wait.waitForValignWrapperToDisappear(10, 3);
			click(firstRequirementNameInDetailedReport);
			firstRequirementname = getText(firstRequirementNameInDetailedReport);
			TestNGLogUtility.info("User clicked on first Requirement Name");
			switchToChildWindow();
		} else {
			flag = true;
			TestNGLogUtility.info("No requirement in the selected time duration");
		}
		return firstRequirementname;
	}

	/**
	 * This method verifies that required requirement opens up when clicked from the
	 * report
	 * 
	 * @return
	 */
	public boolean verifyTheNameOfRequirementClickedFromReport(String firstRequirementname) {
		if (!firstRequirementname.equals("")) {
			if (getText(getRequirementNameOnOverviewPage).contains(firstRequirementname))
				flag = true;
		} else
			TestNGLogUtility.info("No requirement in the selected time duration");
		return flag;
	}

	/**
	 * This method enables the user to click on the download option available in the
	 * detailed view of any report
	 */
	public void clickOnDownloadOnDetailedReport() {
		click(iconEllipsesForDetailedReport);
		click(downloadFromDetailedReport);
		TestNGLogUtility.info("User clicked on Download on the report that is visible");

	}

	// public void clickOnRequiredStageSettingFromDetailedReport(String
	// selectedStageSetting) {
	// String getCheckedAttribute = "";
	// boolean checkedAttributeFlag = true;
	// if (selectedStageSetting.equals("customConversionReportFirststage")) {
	// click(By.xpath("//span[text()='Conversion Funnel Calculation Settings']"));
	// TestNGLogUtility.info("User clicked on Conversion Funnel Calculation Settings
	// ");
	// } else
	// TestNGLogUtility.info("User is already on Settings Option ");
	// getCheckedAttribute = getElement(By.xpath("//input[@id='" +
	// selectedStageSetting + "']"))
	// .getAttribute("checked");
	// System.out.println("check if element is present or not === " +
	// getCheckedAttribute);
	// if (getCheckedAttribute != null)
	// checkedAttributeFlag = false;
	// System.out.println("value of checkedAttributeFlag is === " +
	// checkedAttributeFlag);
	// if (checkedAttributeFlag) {
	// getElement(By.xpath("//input[@id='" + selectedStageSetting + "']")).click();
	// wait.waitForValignWrapperToDisappear(10, 5);
	// TestNGLogUtility.info("User clicked on " + selectedStageSetting + " setting
	// ");
	// } else
	// TestNGLogUtility.info(selectedStageSetting + " setting is already selected
	// ");
	// }

	//
	// /**
	// * This method verifies the summary counts for all the columns
	// * @return
	// */
	// public boolean verifySummaryCount() {
	// int sumCount=0;
	// int noOfRequirements = getElements(totalNoOfRequirements).size();
	// if(noOfRequirements>0) {
	// ArrayList<Integer> summaryCount = new ArrayList<Integer>();
	// ArrayList<Integer> summations = new ArrayList<Integer>();
	// int NoOfColumns = getElements(totalNoOfColumnsSelected).size();
	// for (int i = 1; i <= NoOfColumns; i++) {
	// By getsummaryCount = By.xpath("(//p[@class='quantity'])["+i+"]");
	// summaryCount.add(Integer.parseInt(getText(getsummaryCount)));
	// }
	// for (int i = 1; i <= NoOfColumns; i++) {
	// sumCount = 0;
	// for (int j = 1; j <= noOfRequirements; j++) {
	// By count =
	// By.xpath("(//li[contains(@class,'list')]["+j+"]//span[@class='valText'])["+i+"]");
	// sumCount+= Integer.parseInt(getText(count));
	// }
	// summations.add(sumCount);
	// }
	// for (int i = 0; i <= NoOfColumns-1; i++) {
	// if(summaryCount.get(i).equals(summations.get(i)) )
	// flag = true;
	// }
	// }
	// else
	// flag = true;
	// return flag;
	// }
	//
}
