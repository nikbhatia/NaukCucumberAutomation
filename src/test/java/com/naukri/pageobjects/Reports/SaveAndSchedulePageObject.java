package com.naukri.pageobjects.Reports;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class SaveAndSchedulePageObject extends BaseAutomation {

	boolean flag = false;
	String firstReportName = "", emailIdText = "";
	ArrayList<String> optionsAgainstSavedReport = new ArrayList<String>();
	ArrayList<String> listForColumnNames = new ArrayList<String>();
	ArrayList<String> listOfAppliedFiltersInSavedReport = new ArrayList<String>();
	DashboardPageObject dashboardPO = new DashboardPageObject();
	ReportsCommonPageObject reportsCommonPO = new ReportsCommonPageObject();

	public static By eleToGetTotalRecruiters = By.xpath("(//em[@id='totalRecord'])[1]");
	public static By txtmailTextAreaInSaveSchedulePopUp = By.xpath("//input[@class='mailTextF']");
	public static By eleToGetTotalCountOfSuggestions = By.xpath("//div[@class='searchSuggestionSection borBot']//div");
	public static By eleForErrorMsgForInvalidId = By
			.xpath("//label[@class='shared entityLabel']//p[@class='errorMsg']");
	public static By lnkForFirstReportFromList = By.xpath("(//a[@class='linkColor'])[1]");
	public static By eleForIconEllipsesOnListingPage = By.xpath("(//div[@class='tableActionsWrapper']//img)[1]");
	public static By eleToVerifyElementsofEllipses = By.xpath("(//div[@class='actionsWrapper'])[1]//li");
	public static By columnNames = By.xpath("//li[@class='table-header-row list ']//span");
	public static By eleToDownloadOnListingPage = By.xpath("(//ul[@class='actionsList'])[1]//li[text()='Download']");
	public static By btnToSaveReportInSaveSchedulePopUp = By.xpath("//div[@class='popSave']");
	public static By eleToGetNameOfSavedReportNameFromDetailedView = By.xpath("//h2[@class='reportName']");
	public static By eleToGetfirstReportFromDasboard = By.xpath("(//div[@class='savedReportTile']//a)[1]");
	public static By eleToChooseMailFromDD = By.xpath("//div[@class='searchSuggestionTuple'][1]");
	public static By eleToGetSharedEmailID = By.xpath("//span[@class='toIds']");
	public static By eleToGetfirstSharedWithFieldOnListingPage = By
			.xpath("(//div[@class='tableShareWithWrapper'])[1]//span");
	public static By lnkForscondReportFromList = By.xpath("(//a[@class='linkColor'])[2]");
	public static By lblFrequencyOption = By.xpath("//label[@for='${frequencyOption}']");
	public static By lblSuccessMessageConfirmation = By.xpath("(//p[contains(text(),'scheduled successfully.')])[1]");
	public static By eleScheduleIcon = By.xpath("(//img[@class='scheduleIcon'])[1]");
	public static By eleVisibleSelectedTimeDuration = By.xpath("//span[@class='selectedLabel']");
	public static By eleRequiredOptionAgainstSavedReport = By
			.xpath("(//ul[@class='actionsList'])[1]//li[text()='${elementToBeClicked}']");
	public static By eleSettingTextInSavedSchedulePopUp = By.xpath("(//span[@class='entityLabel'])[2]");
	public static By eleNoOfFilterChips = By.xpath("//div[@class='filterChip']");
	public static By lblEditPopUp = By.xpath("//span[contains(text(),'Edit')]");
	public static By btnDeleteConfirmation = By.xpath("//button[text()='${buttonToBeClicked}']");
	public static By chkSearchedEmailId = By.xpath("(//div[@class='searchSuggestionTuple'])[1]");
	public static By eleFilterChipToBeRemoved = By
			.xpath("//span[text()='${filterToBeRemoved}']/ancestor::div[@class='filterChip']//img");
	public static By btnSaveFiltersInAlreadySavedReport = By.xpath("//div[@class='filterModifySave']");

	/**
	 * This method returns the total number of recruiters that are present in RMS
	 * system
	 * 
	 * @author srissti.tyagi
	 * @return totalNoOfRecruitersFromRmsSettings
	 */
	public int getTotalNoOfRecruitersFromSettingspage() {
		String totalRecruiters = getText(eleToGetTotalRecruiters);
		return (Integer.parseInt(totalRecruiters));
	}

	/**
	 * This method verifies that all the users for a client are visible in the list
	 * 
	 * @author srissti.tyagi
	 * @param noOfRecruiters
	 * @return
	 */
	public boolean verifyTheNumberOfRecruitersWhileSharingTheReport(int noOfRecruiters) {
		sendKeys(txtmailTextAreaInSaveSchedulePopUp, "s");
		int count2 = getElements(eleToGetTotalCountOfSuggestions).size();
		return (count2 == noOfRecruiters + 1);
	}

	/**
	 * This method enables the user to click on the text area where the user can
	 * enter the mail ID for sharing a report
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnMailTextAreaInSaveSchedulePopUp() {
		click(txtmailTextAreaInSaveSchedulePopUp);
		TestNGLogUtility.info("User clicked on MailTextArea in SaveSchedule PopUp");
	}

	/**
	 * This method enables the user to enter the wrong value in the mail ID text box
	 * 
	 * @author srissti.tyagi
	 */
	public void enterValueForMailIdInSaveSchedulePopUp() {
		sendKeys(txtmailTextAreaInSaveSchedulePopUp, "s");
		TestNGLogUtility.info("User entered a wrong mail Id for scheduling a report");
	}

	/**
	 * This method enables verifies that error message is shown when invalid email
	 * is entered
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForErrorMessageVisibility
	 */
	public boolean verifyErrorMessageForInvalidMailInSaveSchedulePopUp() {
		return (isDisplayed(eleForErrorMsgForInvalidId));

	}

	/**
	 * This method enables the user to click on the type of frequency option to
	 * schedule the report
	 * 
	 * @author srissti.tyagi
	 * @param frequencyOption
	 */
	public void clickOnRespectiveFrequencyWhileSchedulingTheReport(String frequencyOption) {
		getElement(lblFrequencyOption, frequencyOption).click();
	}

	/**
	 * This method helps user verify that confirmation message is displayed when a
	 * report is scheduled
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForConfirmationMessageVisibility
	 */
	public boolean verifyConfirmationMessageWhenReportIsScheduled() {
		return (isDisplayed(lblSuccessMessageConfirmation));
	}

	/**
	 * This method verifies the presence of clock icon against a scheduled report
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueOfScheduledIconVisibility
	 */
	public boolean verifySchedulediconForRecentReport() {
		return (isDisplayed(eleScheduleIcon));
	}

	/**
	 * This method enables the user to hover on the first saved report row
	 * 
	 * @author srissti.tyagi
	 */
	public void hoverOnFirstReportOnTheSavedScheduledList() {
		hover(lnkForFirstReportFromList);
		TestNGLogUtility.info("User hovered on the first saved report name on listing page");
	}

	/**
	 * This method enables the user to hover on the ellipses icon of the saved
	 * report
	 * 
	 * @author srissti.tyagi
	 */
	public void mouseHoverOnEllipsesOnListingPage() {
		click(eleForIconEllipsesOnListingPage);
		TestNGLogUtility.info("User hovered on the icon ellipses of the first saved report name on listing page");
	}

	/**
	 * This method return the list of option that are visible when the user hovers
	 * over the icon ellipses for any saved report
	 * 
	 * @author srissti.tyagi
	 * @return listOfElementsVisibleWhenHoveredOnIconEllipses
	 */
	public List<String> verifyEllipsesElementsForRequiredReport() {
		int count = getElements(eleToVerifyElementsofEllipses).size();
		for (int i = 1; i <= count; i++) {
			optionsAgainstSavedReport.add(getText(By.xpath("(//ul[@class='actionsList'][1]//li)[" + i + "]")));
		}
		return optionsAgainstSavedReport;
	}

	/**
	 * This method enables the user to click on the first saved report
	 * 
	 * @author srissti.tyagi
	 */
	public void clickonFirstReportFromList() {
		click(lnkForFirstReportFromList);
		wait.waitForValignWrapperToDisappear(10, 5);
		TestNGLogUtility.info("User clicked on the first saved report name on listing page");
	}

	/**
	 * This method verifies that the time duration that was saved is visible in the
	 * report
	 * 
	 * @author srissti.tyagi
	 * @param expectedTimeDuration
	 * @return
	 */
	public boolean verifySelectedTimeDurationInSavedReport(String expectedTimeDuration) {
		return (getText(eleVisibleSelectedTimeDuration).contains(expectedTimeDuration));
	}

	/**
	 * This method verifies the column names on the listing page
	 * 
	 * @author srissti.tyagi
	 * @return listOfColumnNames
	 */
	public ArrayList<String> verifyColumnNamesForListingPage() {
		int count = getElements(columnNames).size();
		for (int i = 1; i <= count - 1; i++)
			listForColumnNames.add(getText(By.xpath("(//li[@class='table-header-row list ']//span)[" + i + "]")));
		return listForColumnNames;
	}

	/**
	 * This method enables the user to click on any option when user hovers on the
	 * icon ellipses against the saved report
	 * 
	 * @author srissti.tyagi
	 * @param elementToBeClicked
	 */
	public void clickRequiredOptionOnListingPage(String elementToBeClicked) {
		getElement(eleRequiredOptionAgainstSavedReport, elementToBeClicked).click();
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * This method verifies the presence of required setting that was selected while
	 * saving a report
	 * 
	 * @author srissti.tyagi
	 * @param settingToBeConfirmed
	 * @return booleanValueForPresenceOfSelectedSetting
	 */
	public boolean verifyFirstStageInSchedulePopUp(String settingToBeConfirmed) {
		return (getText(eleSettingTextInSavedSchedulePopUp).contains(settingToBeConfirmed));
	}

	/**
	 * This method verifies the tags of filters in the saved report
	 * 
	 * @author srissti.tyagi
	 * @return listOfTagsOfFiltersVisible
	 */
	public ArrayList<String> verifyTagsInSavedReportForAppliedFilter() {
		listOfAppliedFiltersInSavedReport.clear();
		wait.waitForValignWrapperToDisappear(10, 5);
		int noOfFiltersApplied = getElements(eleNoOfFilterChips).size();
		for (int i = 1; i <= noOfFiltersApplied; i++) {
			listOfAppliedFiltersInSavedReport
					.add(getText(By.xpath("(//div[@class='filterChip']//span[1])[" + i + "]")));
		}
		return listOfAppliedFiltersInSavedReport;
	}

	/**
	 * This metod verifies the visibility of edit pop -up
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForVisibilityOfEditPopUp
	 */
	public boolean verifyEditPopUp() {
		return (isDisplayed(lblEditPopUp));
	}

	/**
	 * This method verifies that user is able to edit the report successfully
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueForEditedReportNameSuccess
	 */
	public boolean verifyReportIsEdited() {
		String changedReportName = "ChangedName" + dashboardPO.timestamp();

		getElement(ReportsCommonPageObject.txtReportNameFieldInSaveSchedulePopUp).clear();
		sendKeys(ReportsCommonPageObject.txtReportNameFieldInSaveSchedulePopUp, changedReportName);
		click(btnToSaveReportInSaveSchedulePopUp);

		wait.waitForValignWrapperToDisappear(10, 5);
		TestNGLogUtility.info("Report name is edited to : " + changedReportName);
		firstReportName = getFirstReportNameFromList();
		if (firstReportName.equals(changedReportName))
			flag = true;

		return flag;
	}

	/**
	 * This method enables the user to get the name of first saved report from
	 * listing page
	 * 
	 * @author srissti.tyagi
	 * @return nameOfFirstSavedReport
	 */
	public String getFirstReportNameFromList() {
		firstReportName = getElement(lnkForFirstReportFromList).getAttribute("title");
		return firstReportName;
	}

	/**
	 * THis method verifies that correct report has opened when clicking from
	 * listing or dashboard page
	 * 
	 * @author srissti.tyagi
	 * @param firstReportName
	 * @return booleanValueForSuccessOfCorrectReportOpening
	 */
	public boolean verifySavedReportHasOpenedSuccessfully(String firstReportName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		return (getAttribute(eleToGetNameOfSavedReportNameFromDetailedView, "title").equals(firstReportName));
	}

	/**
	 * This method enables the user to get the name of first saved report from
	 * Dashboard of reports
	 * 
	 * @author srissti.tyagi
	 * @return nameOfFirstSavedReportOnDashboard
	 */
	public String getFirstReportNameFromDashboard() {
		firstReportName = getAttribute(eleToGetfirstReportFromDasboard, "title");
		return firstReportName;
	}

	/**
	 * This method enables the user to click on the first report from dashboard
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnFirstReportFromDashboard() {
		click(eleToGetfirstReportFromDasboard);
		wait.waitForValignWrapperToDisappear(10, 5);
		TestNGLogUtility.info("User clicked on the first saved report name on dashboard");
	}

	/**
	 * This method enables the user to click the first mail Id from the list of
	 * options available and return the text of the chosen mailId
	 * 
	 * @author srissti.tyagi
	 * @return chosenEmailId
	 */
	public String chooseMailIdFromDdOptions() {
		sendKeys(txtmailTextAreaInSaveSchedulePopUp, "s");
		click(eleToChooseMailFromDD);
		emailIdText = getText(eleToGetSharedEmailID);
		TestNGLogUtility.info("User chose a mailId from the available options");
		return emailIdText;
	}

	/**
	 * This method verifies that correcr emailId is visible on the listiing page
	 * 
	 * @author srissti.tyagi
	 * @param emailIdText
	 * @return booleanValueForPresenceOfExpectedMailID
	 */
	public boolean verifyVisibilityOfEmailId(String emailIdText) {
		String sharedWithField = getText(eleToGetfirstSharedWithFieldOnListingPage);
		return (sharedWithField.contains(emailIdText));
	}

	/**
	 * This method verifies that duplicate reports are not saved
	 * 
	 * @author srissti.tyagi
	 * @return booleanValueToVerifyThatNameOfFirstTwoReportsAreDifferent
	 */
	public boolean verifyDuplicateReports() {
		String firstReportName = getAttribute(lnkForFirstReportFromList, "title");
		String secondReportName = getAttribute(lnkForscondReportFromList, "title");
		return (!(firstReportName.equals(secondReportName)));

	}

	/**
	 * This method will enable the user to click on the Delete option in the Delete
	 * confirmation box, while deleting a saved report
	 * 
	 * @author srissti.tyagi
	 * @param buttonToBeClicked
	 */
	public void clickOnDeleteButtonInDeleteCOnformationBox(String buttonToBeClicked) {
		getElement(btnDeleteConfirmation, buttonToBeClicked).click();
		TestNGLogUtility.info("User clicked on the " + buttonToBeClicked + " button ");
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * THis method verifies that the user is able to delete the report
	 * 
	 * @author srissti.tyagi
	 * @param firstReportName
	 * @return booleanValueForSucessfulDeletionOfSavedReport
	 */
	public boolean verifySavedReportDeletion(String firstReportName) {
		return (!getAttribute(lnkForFirstReportFromList, "title").equals(firstReportName));
	}

	/**
	 * THis method enables the user to select one particular mail for sharing a
	 * report
	 * 
	 * @author srissti.tyagi
	 * @param mailIdOfUserToBeSelected
	 */
	public void selectParticularUserForSharingReport(String mailIdOfUserToBeSelected) {
		sendKeys(txtmailTextAreaInSaveSchedulePopUp, mailIdOfUserToBeSelected);
		click(chkSearchedEmailId);
		TestNGLogUtility.info("User selected the required mail Id");
	}

	/**
	 * THis method enables the user to clear the applied filters in a saved report
	 * 
	 * @author srissti.tyagi
	 * @param filterToBeRemoved
	 */
	public void ClearAppliedFilter(String filterToBeRemoved) {
		getElement(eleFilterChipToBeRemoved, filterToBeRemoved).click();
		wait.waitForValignWrapperToDisappear(10, 5);
		TestNGLogUtility.info("User cleared the " + filterToBeRemoved + " filter");
	}

	/**
	 * This method enables the user to click on save Button after an existing filter
	 * is removed or a new filter is applied in the saved report
	 * 
	 * @author srissti.tyagi
	 */
	public void clickOnSaveFilterOptionInSavedReport() {
		click(btnSaveFiltersInAlreadySavedReport);
		wait.waitForValignWrapperToDisappear(10, 5);
	}

	/**
	 * This method verifies that save option is not visible to a user who has not
	 * created that report, when user clears some filter
	 * 
	 * @author srissti.tyagi
	 * @return
	 */
	public boolean verifySaveOptionVisibilityForSharedReport() {
		return (!isDisplayed(btnSaveFiltersInAlreadySavedReport));
	}
}
