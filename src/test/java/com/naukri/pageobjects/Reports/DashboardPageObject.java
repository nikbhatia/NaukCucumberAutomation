package com.naukri.pageobjects.Reports;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;
import org.openqa.selenium.WebElement;

import java.util.*;

public class DashboardPageObject extends BaseAutomation {

	boolean flag = false, loaderFlag = false;
	public String reportName = "", firstreportName = "", getInfoIconToolTiptext = "";
	ArrayList<String> stagesListFromSettings = new ArrayList<String>();
	ArrayList<String> stagesListFromReport = new ArrayList<String>();
	ArrayList<String> expectedListOfSummaryElements = new ArrayList<String>();
	ArrayList<String> getSummaryElements = new ArrayList<String>();

	public static By reportNameToBeSaved = By.xpath("//input[@id='reportName']");
	public static By checkSchedule = By.xpath("//label[@for='scheduleFor']");
	public static By firstSavedReportFromList = By.xpath("(//a[@class='linkColor'])[1]");
	public static By eleReportsNameDropDown = By.xpath("//div[@class='dropdownWrapper ']//h2[@class='reportName']");
	public static By getAllReportsName = By.xpath("(//ul[contains(@class,'reportsList show')])/li");
	// public static By getAllReportsURL =
	// By.xpath("(//ul[contains(@class,'reportsList show')])//a");
	public static By getAllReportsURL = By.cssSelector("ul.reportsList.show a");
	public static By getreportNamesInOrder = By.xpath("(//ul[contains(@class,'reportsList')])[1]//a");
	public static By NoDataForSelectedTimeDuration = By.xpath("(//p[text()='No Data exists for your selection.'])[1]");
	public static By saveAndScheduleReportName = By.xpath("//a[contains(text(),'Saved & Scheduled')]");
	public static By totalNoOfStagesInCustomReport = By.xpath("//li[contains(@class,'showCustomStageDD')]//li");
	public static By eleSaveScheduleReportName = By.xpath(
			"//*[text()='${reportNameToBeScheudled}']/ancestor::div[@class='widgetWrapper']//div[text()='Save/Schedule']");
	public static By eleEllipsesForReportToBeActionedUpon = By
			.xpath("//*[text()='${reportName}']/ancestor::div[@class='widgetWrapper']//img[contains(@src,'Ellipsis')]");
	public static By lnkViewReport = By.xpath(
			"//*[text()='${reportNameToBeViewed}']/ancestor::div[@class='widgetWrapper']//a[contains(text(),'View All')]");

	/**
	 * This method verifies if the report has already loaded , if not, then user
	 * tries to reload it
	 *
	 * @param reportName
	 * @return
	 */
	public boolean verifyIfReportIsLoaded(String reportName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		By checkForErrorMsgOnDashboard = By.xpath(
				"//div[text()='" + reportName + "']/..//p[contains(text(),'error while trying to generate Report')]");
		if (!isDisplayed(checkForErrorMsgOnDashboard)) {
			TestNGLogUtility.info("Report has already loaded ");
			loaderFlag = true;
		} else {
			TestNGLogUtility.info("Report couldn't be loaded at once, will try to reload now");
			loaderFlag = ReLoadingInCaseOfErrorOnDashboard(reportName, checkForErrorMsgOnDashboard);
		}
		return loaderFlag;
	}

	/**
	 * This method tries to reload the report again if it fails to load initially
	 *
	 * @param checkForErrorMsgOnDashboard
	 * @return
	 */
	public boolean ReLoadingInCaseOfErrorOnDashboard(String reportName, By checkForErrorMsgOnDashboard) {
		By clickOnReLoadOnDashboard = By.xpath("//div[text()='" + reportName + "']/..//a[text()='Reload']");
		for (int i = 1; i <= 2; i++) {
			getElement(clickOnReLoadOnDashboard).click();
			TestNGLogUtility.info("User clicked on the reload link ");
			wait.waitForValignWrapperToDisappear(10, 5);
			if (!isDisplayed(checkForErrorMsgOnDashboard)) {
				loaderFlag = true;
				break;
			} else {
				continue;
			}
		}
		return loaderFlag;
	}

	/**
	 * This method clicks on the icon ellipses
	 * 
	 * @author srissti.tyagi
	 * @param reportName
	 */
	public void clickOnIconEllipsesForRespectiveReport(String reportName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		click(parameterizedLocator(eleEllipsesForReportToBeActionedUpon, reportName));
		TestNGLogUtility.info("User clicked on Icon Ellipses on dashboard for the required report");
	}

	/**
	 * This method first clicks on the ellipses and then on the download option
	 * against a particular report on the dashboard
	 *
	 * @param reportNameToBeDowloaded
	 */
	public void clickOnDownloadForRespectiveReport(String reportNameToBeDowloaded) {

		By clickOnReportToBeDownloaded = By.xpath("//*[text()='" + reportNameToBeDowloaded
				+ "']/ancestor::div[@class='widgetWrapper']//div[text()='Download this Report']");
		click(clickOnReportToBeDownloaded);
		TestNGLogUtility.info("User clicked on Download on dashboard for the required report");
	}

	/**
	 * This method first clicks on the ellipses and then on the Save and Schedule
	 * option against a particular report on the dashboard
	 *
	 * @param reportNameToBeScheudled
	 */
	public String clickOnSaveScheduleAndReturnreportName(String reportNameToBeScheudled) {
		reportName = "New Report" + timestamp();
		wait.waitForValignWrapperToDisappear(10, 5);
		click(parameterizedLocator(eleSaveScheduleReportName, reportNameToBeScheudled));
		click(reportNameToBeSaved);
		sendKeys(reportNameToBeSaved, reportName);
		TestNGLogUtility
				.info("Report name : " + reportName + " is generated, entered and returned in the respective field ");
		return reportName;
	}

	/**
	 * This method provides the time instance for saving a report with unique name
	 *
	 * @return
	 */
	public String timestamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h-mm-ss");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	/**
	 * THis method verifies that reports are saved in the reverse chronological
	 * order , that is , the report that was saved most recently should be visible
	 * at the top
	 *
	 * @return
	 */
	public boolean verifyReverseChronologicalOrder(String reportName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		firstreportName = getAttribute(firstSavedReportFromList, "title");
		return (reportName.equals(firstreportName));
	}

	/**
	 * This method enables the User to click on the Drop Down option for viewing All
	 * Reports Name
	 */
	public void clickOnReportsnameDropDown() {
		wait.waitForElementToBeClickable(eleReportsNameDropDown);
		actionBuilderUtil.hoverClickByAction(eleReportsNameDropDown);
		if (!isDisplayed(saveAndScheduleReportName))
			actionBuilderUtil.hoverClickByAction(eleReportsNameDropDown);
		TestNGLogUtility.info("User clicked on the drop down of <-All Reports-> names");
	}

	/**
	 * This method will click on ViewAll link against the respective report on
	 * dashbaord
	 * 
	 * @author srissti.tyagi
	 * @param reportNameToBeViewed
	 */
	public void clickViewAllForRespectiveReport(String reportNameToBeViewed) {
		wait.waitForValignWrapperToDisappear(10, 5);
		click(parameterizedLocator(lnkViewReport, reportNameToBeViewed));
		TestNGLogUtility.info("User clicked on View All on dashboard for the required report");
	}

	/**
	 * This method verifies that the report opens whenever it is clicked from
	 * viewAll link or any other place
	 *
	 * @param reportName
	 * @return
	 */
	public boolean verifyRespectiveReportOpens(String reportName) {
		return (isDisplayed(By.xpath("//h2[contains(text(),'" + reportName + "')]")));
	}

	/**
	 * This method will click on the settings icon on dashboard against a particular
	 * report name
	 *
	 * @param reportName
	 */
	public void clickOnSettingsIconOnDashboard(String reportName) {
		By clickOnEllipsesForReportToBeActionedUpon = By.xpath("//*[text()='" + reportName
				+ "']/ancestor::div[@class='widgetWrapper']//span[contains(@class,'icn-edit')]");
		scrollToElement(clickOnEllipsesForReportToBeActionedUpon);
		click(clickOnEllipsesForReportToBeActionedUpon);
		TestNGLogUtility.info("User clicked on Stages Settings icon");
	}

	/**
	 * This method will verify the elements that are visible when user clik on the
	 * settings icon for a particular report
	 *
	 * @param reportName
	 * @return
	 */
	public boolean verifySettingsElementsForRequiredReportOnDashboard(String reportName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		boolean flag1 = false;
		if (reportName.equals("Requirement Funnel")) {
			flag = verifyStageInformation("conversionReportPrevstage", "conversionReportFirststage");
		} else if (reportName.equals("Stage Level Funnel")) {
			if (getText(By.xpath("//li[@class='showCalculationDD']")).equals("Conversion Funnel Calculation Settings")
					&& getText(By.xpath("//li[@class='showCustomStageDD']"))
							.equals("Choose custom stages to display")) {
				click(By.xpath("//li[@class='showCalculationDD']"));
				flag1 = verifyStageInformation("customConversionReportPrevstage", "customConversionReportFirststage");
				click(By.xpath("//li[@class='showCustomStageDD']"));
				getTheListOfCustomStagePresentInReports();
				System.out.println("stagesListFromSettings-->> "+ stagesListFromSettings);
				System.out.println("stagesListFromReport-->> "+stagesListFromReport);
				flag = verifyTheListOfCustomStages(stagesListFromSettings, stagesListFromReport) && flag1;
			}
		}
		return flag;
	}

	/**
	 * This method will verify that the reports has all the stages that are present
	 * in the system
	 *
	 * @return
	 */
	public boolean verifyTheListOfCustomStages(ArrayList<String> stagesListFromSettings,
			ArrayList<String> stagesListFromReport) {
		return (stagesListFromSettings.equals(stagesListFromReport));
	}

	/**
	 * This method will get all the custom stages present in the reports
	 */
	public ArrayList<String> getTheListOfCustomStagePresentInReports() {
		int count = getElements(By.xpath("//li[contains(@class,'showCustomStageDD')]//span[@title]")).size();
		for (int i = 1; i <= count; i++) {
			By by=By.xpath("(//li[contains(@class,'showCustomStageDD')]//span[@title])[" + i + "]");
			scrollToElement(by);
			String stageName = getText(by).trim();
			stagesListFromReport.add(stageName);
		}
		return stagesListFromReport;
	}

	/**
	 * This method will get all the parent stages present in the system
	 */
	public ArrayList<String> getAllCustomStagesFromSettingPage() {
		int count = getElements(By.xpath("//div[contains(@class,'mainlist')]")).size();
		for (int i = 1; i <= count; i++) {
			String stageName = getElement(By.xpath("(//div[contains(@class,'acc_head_title')])[" + i + "]")).getText().trim();
			stagesListFromSettings.add(stageName);
		}
		return stagesListFromSettings;
	}

	/**
	 * This method will verify the option on the basis of conversion rates
	 *
	 * @param previousStage
	 * @param firstStage
	 * @return
	 */
	public boolean verifyStageInformation(String previousStage, String firstStage) {
		return (getText(By.xpath("//input[@id='" + previousStage + "']/..//label")).equals("From previous stage")
				&& getText(By.xpath("//input[@id='" + firstStage + "']/..//label")).equals("From first stage"));
	}

	/**
	 * This method will hover over the information icon to obtain the tooltip text
	 *
	 * @param reportName
	 * @return
	 */
	public String hoverOnRequirementInfoIcon(String reportName) {
		wait.waitForValignWrapperToDisappear(2, 4);
		By hoverOnInfoIconAgainstReportName = By.xpath("//*[text()='" + reportName
				+ "']/ancestor::div[@class='widgetWrapper']//span[contains(@class,'dashboardTooltipIcon')]");
		hover(hoverOnInfoIconAgainstReportName);
		click(hoverOnInfoIconAgainstReportName);
		TestNGLogUtility.info("User hovered on the info icon against the required report");
		return getInfoIconToolTiptext;
	}

	/**
	 * This method will verify the information on the tooltip when user hovers over
	 * the info icon against a particular report on dashboard
	 *
	 * @param reportName
	 * @param getInfoIconToolTiptext
	 * @return
	 */
	public boolean verifyInfoIconHoverData(String InfoIconForRespectiveReport, String getInfoIconToolTiptext) {
		return (getInfoIconToolTiptext.equals(PropFileHandler.readProperty(InfoIconForRespectiveReport)));
	}

	/**
	 * This method clicks on the required subtab for a particular report on the
	 * dashboard
	 *
	 * @param tabName
	 * @param reportName
	 */
	public void clickOnRequiredSubTabForRequiredReportOnDashboard(String tabName, String reportName) {
		By clickOnRequiredSubtabElement = By.xpath("//*[text()='" + reportName
				+ "']/ancestor::div[@class='stickyWrapper']//following-sibling::div//div[text()='" + tabName + "']");
		if (getAttribute(clickOnRequiredSubtabElement, "class").contains("Active")) {
			TestNGLogUtility.info(" User already on " + tabName + " Tab ");
		} else {
			click(clickOnRequiredSubtabElement);
			wait.waitForValignWrapperToDisappear(10, 5);
			TestNGLogUtility.info(" User clicked on " + tabName + " Tab");
		}
	}

	/**
	 * This method will verify that the subtab clicks on the dashboard works as per
	 * the requirement
	 *
	 * @param tabName
	 * @param reportName
	 * @return
	 */
	public boolean verifysubTabclickforRequiredReportOnDashboard(String tabName, String reportName) {
		By verifysubTabClick = By.xpath("//*[text()='" + reportName
				+ "']/ancestor::div[@class='widgetWrapper']//span[text()='" + tabName + "']");
		return (elementVisibility(verifysubTabClick));
	}

	/**
	 * This method will verify the summary elements of a particular report on the
	 * dashboard
	 *
	 * @param reportName
	 * @return
	 */
	public List<String> verifySummaryElementsOnDashboard(String reportName) {
		String summarytextOnDashboard = "";
		if (reportName.equals("Requirement Funnel")) {
			int noOfElements = getElements(By.xpath(
					"//*[text()='" + reportName + "']/ancestor::div[@class='reportHeader']//p[@class='stepLabel']"))
							.size();
			for (int i = 1; i <= noOfElements; i++) {
				summarytextOnDashboard = getText(By.xpath("(//*[text()='" + reportName
						+ "']/ancestor::div[@class='reportHeader']//p[@class='stepLabel'])[" + i + "]"));
				getSummaryElements.add(summarytextOnDashboard);
			}
		} else if (reportName.equals("Requirement Aging")) {
			int noOfElements = getElements(By.xpath("//p[@class='heading']")).size();
			for (int i = 1; i <= noOfElements; i++) {
				summarytextOnDashboard = getText(By.xpath("(//p[@class='heading'])[" + i + "]"));
				getSummaryElements.add(summarytextOnDashboard);
			}
		} else if (reportName.equals("Requirement Creation") || reportName.equals("Requisition Overview")
				|| reportName.equals("Requirement TAT") || reportName.equals("Recruitment Activity")
				|| reportName.equals("Hiring Manager Activity")) {
			int noOfElements = getElements(By.xpath(
					"//*[text()='" + reportName + "']/ancestor::div[@class='widgetWrapper']//div[@class='widgetName']"))
							.size();
			for (int i = 1; i <= noOfElements; i++) {
				summarytextOnDashboard = getText(By.xpath("(//*[text()='" + reportName
						+ "']/ancestor::div[@class='widgetWrapper']//div[@class='widgetName'])[" + i + "]"));
				getSummaryElements.add(summarytextOnDashboard);
			}
		}
		return getSummaryElements;
	}

	/**
	 * This method will hover on the required column name and get the tool tip for
	 * that column name for a respective report on dashboard
	 *
	 * @param columnName
	 * @param reportName
	 * @return
	 */
	public String hoverOnRequiredColumnNameForRequiredReportOnDashboard(String columnName, String reportName) {
		String toolTipTextForRespectiveColumnName = "";
		By hoverOnColumnName = By.xpath("//*[text()='" + reportName
				+ "']/ancestor::div[@class='widgetWrapper']//span[text()='" + columnName + "']");
			scrollToElement(hoverOnColumnName);
		if (isDisplayed(hoverOnColumnName)) {
			hover(hoverOnColumnName);
			TestNGLogUtility.info("User hovered on the <- " + columnName + " -> column name");
			toolTipTextForRespectiveColumnName = getAttribute(By.xpath("//*[text()='" + reportName
					+ "']/ancestor::div[@class='widgetWrapper']//span[text()='" + columnName + "']/.."), "title");
			;
		} else {
			TestNGLogUtility.info("Column : " + columnName + " is not visible / selected");
		}
		return toolTipTextForRespectiveColumnName;
	}

	/**
	 * This method will verify the tool tip text for the column names on dashboard
	 *
	 * @param expectedToolTipText
	 * @param reportName
	 * @param toolTipTextForRespectiveColumnName
	 * @return
	 */
	public boolean verifyToolTipForRequiredColumnNameInRequiredReportOnDashboard(String expectedToolTipText,
			String reportName, String toolTipTextForRespectiveColumnName) {
		if (isDisplayed(NoDataForSelectedTimeDuration)) {
			if (reportName.equals("RequirementFunnel")) {
				if (toolTipTextForRespectiveColumnName.trim().equals(PropFileHandler.readProperty(expectedToolTipText).trim())) {
					flag = true;
				}
			}
		} else {
			flag = true;
		}
		return flag;
	}

	public List<String> getNameOfAllReportsVisible() {
		List<String> allReportsName = new ArrayList<String>();
		for (WebElement we : getElements(getAllReportsName)) {
			allReportsName.add(we.getText());
		}
		TestNGLogUtility.info("List of all reports name created");
		return allReportsName;
	}

	public Map<String, String> getNameAndUrlOfAllClickableReports() {
		Map<String, String> allReportsUrlWithName = new LinkedHashMap<>();
		int reportSize = getElements(getAllReportsURL).size();
		String actual = getAllReportsURL.toString();
		String modified = actual.substring(actual.indexOf(':') + 1, actual.length());
		for (int count = 0; count < reportSize; count++) {
			allReportsUrlWithName.put(jsUtil.getTextByJS(modified, count),
					getElements(getAllReportsURL).get(count).getAttribute("href"));
		}
		TestNGLogUtility.info("Hash Map with Report Name and URL created");
		return allReportsUrlWithName;
	}

	/**
	 * This method will get the tab names for a specific report on the dashboard
	 * 
	 * @param reportName
	 * @return
	 */
	public List<String> verifyTabsOnDashboard(String reportName) {
		ArrayList<String> getTabNamesList = new ArrayList<String>();
		int getNoOfTabs = getElements(By.xpath(
				"//*[text()='" + reportName + "']/ancestor::div[@class='widgetWrapper']//div[contains(@class,'tb')]"))
						.size();
		for (int i = 1; i <= getNoOfTabs; i++) {
			String getTabNames = getText(By.xpath("(//*[text()='" + reportName
					+ "']/ancestor::div[@class='widgetWrapper']//div[contains(@class,'tb')])[" + i + "]"));
			getTabNamesList.add(getTabNames);
		}
		return (getTabNamesList);
	}

	/**
	 * This method will verify if teh time division option is visible in a specific
	 * report on dashboard
	 * 
	 * @param reportName
	 * @return
	 */
	public boolean verifyDivisionLabelForSpecificReportOnDashboard(String reportName) {
		return (isDisplayed(By.xpath(
				"//*[text()='" + reportName + "']/ancestor::div[@class='widgetWrapper']//span[@class='selectTDKey']")));
	}
	
	
	

}
