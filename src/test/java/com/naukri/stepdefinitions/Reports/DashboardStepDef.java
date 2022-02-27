package com.naukri.stepdefinitions.Reports;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Reports.DashboardPageObject;
import com.naukri.test.base.BaseAutomation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

public class DashboardStepDef extends BaseAutomation {

	GenericFunctions csmGeneric = new GenericFunctions();
	DashboardPageObject DashboardObject = new DashboardPageObject();
	ArrayList<String> stagesListFromSettings = new ArrayList<String>();
	ArrayList<String> stagesListFromReport = new ArrayList<String>();
	String reportName = "", getInfoIconToolTiptext = "", toolTipTextForRespectiveColumnName = "";
	private Map<String, String> reportsOnDashboard;

	@Then("User verifies the tabs visible in \"(.*)\" Report on dashboard")
	public void verifyTabsForSpecificReportOnDashboard(String reportName, DataTable tabNamesOnDashboardTable) {
		List<String> tabNamesOnDashboard = tabNamesOnDashboardTable.asList(String.class);
		List<String> tabNamesOnDashboardVisible = DashboardObject.verifyTabsOnDashboard(reportName);

		Assert.assertEquals(tabNamesOnDashboard, tabNamesOnDashboardVisible,
				"[Assertion Fail]:  The tabs are not as per the requirement for the mentioned report on dashboard\"");
		TestNGLogUtility
				.pass("[Assertion Pass]: The tabs are as per the requirement for the mentioned report on dashboard");
	}

	@Then("User verifies the Division label in \"(.*)\" Report on dashboard")
	public void verifyDivisionLabelOnDashboard(String reportName) {
		Assert.assertTrue(DashboardObject.verifyDivisionLabelForSpecificReportOnDashboard(reportName),
				"[Assertion Fail]:  Time Division Options are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Time Division options are as pe rthe requirement");
	}

	@Then("User verifies that the \"(.*)\" report has loaded first on dashboard")
	public void checkIfReportIsLoadedOnDashboard(String reportName) {
		Assert.assertTrue(DashboardObject.verifyIfReportIsLoaded(reportName),
				"[Assertion Fail]: " + reportName + "Report couldn't be loaded even after multiple tries ");
		TestNGLogUtility
				.pass("[Assertion Pass]: " + reportName + " Report loaded -> Further actions can now be performed");
	}

	@When("User clicks on Icon Ellipses for \"(.*)\" Report on dashboard")
	public void clickOnIconEllipsesForRespectiveReport(String reportname) {
		DashboardObject.clickOnIconEllipsesForRespectiveReport(reportname);
	}

	@When("User clicks on DownloadThisReport option for \"(.*)\" Report on dashboard")
	public void clickOnDownloadForRespectiveReport(String reportnameToBeDowloaded) {
		DashboardObject.clickOnDownloadForRespectiveReport(reportnameToBeDowloaded);
	}

	@When("User clicks on SaveSchedule option for \"(.*)\" on dashboard and enter the unique report name")
	public void clickOnSaveScheduleAndReturnReportNameFromDashboard(String reportNameToBeScheudled) {
		reportName = DashboardObject.clickOnSaveScheduleAndReturnreportName(reportNameToBeScheudled);
	}

	@Then("Verify that the name of first report is the one that is saved above")
	public void verifyReverseChronologicalOrder() {
		Assert.assertTrue(DashboardObject.verifyReverseChronologicalOrder(reportName),
				"[Assertion Fail]: Reports are not saved in reverse chronolgical order");
		TestNGLogUtility.pass("[Assertion Pass]: Reports are not saved in reverse chronological order");
	}

	@When("User clicks on the Drop Down list of reports name")
	public void clickOnReportsnameDD() {
		DashboardObject.clickOnReportsnameDropDown();
	}

	@When("User clicks on ViewAll Link for \"(.*)\" Report")
	public void clickViewAllForRespectiveReport(String reportnameToBeViewed) {
		DashboardObject.clickViewAllForRespectiveReport(reportnameToBeViewed);
	}

	@Then("User verifies that \"(.*)\" Report opens up")
	public void verifyReportOpensWhenClickedFromDropDown(String ReportName) {
		Assert.assertTrue(DashboardObject.verifyRespectiveReportOpens(ReportName),
				"[Assertion Fail]: " + ReportName + " Report doesn't opens from dashboard");
		TestNGLogUtility.pass("[Assertion Pass]: User is able to see the " + ReportName + " report");
	}

	@When("User clicks on Settings Icon for \"(.*)\" Report on Dashboard")
	public void clickOnSettingsIconOnDashboard(String reportName) {
		DashboardObject.clickOnSettingsIconOnDashboard(reportName);
	}

	@Then("User verifies the elements under Settings Icon in \"(.*)\" Report on Dashboard")
	public void verifySettingsElementsForRequiredReport(String reportName) {
		Assert.assertTrue(DashboardObject.verifySettingsElementsForRequiredReportOnDashboard(reportName),
				"[Assertion Fail]: Elements under the setting icon are not as per the requirement for " + reportName
						+ " report");
		TestNGLogUtility.pass("[Assertion Pass]: Elements under the setting icon are as per the requirement for "
				+ reportName + " report");
	}

	@When("User hovers on the info icon against the \"(.*)\" Report on Dashboard")
	public void hoverOnRequirementInfoIconOnDashboard(String reportName) {
		getInfoIconToolTiptext = DashboardObject.hoverOnRequirementInfoIcon(reportName);
	}

	@Then("User verifies the information visible when hovered over the \"(.*)\" Report on Dashboard")
	public void verifyInfoIconHoverData(String InfoIconForRespectiveReport) {
		DashboardObject.verifyInfoIconHoverData(InfoIconForRespectiveReport, getInfoIconToolTiptext);
	}

	@When("User clicks on \"(.*)\" subTab for \"(.*)\" report on dashboard")
	public void clickOnRequiredSubtabOnDashboard(String tabName, String reportName) {
		DashboardObject.clickOnRequiredSubTabForRequiredReportOnDashboard(tabName, reportName);
	}

	@Then("Verify that data in \"(.*)\" report is visible according to the \"(.*)\" subtab")
	public void verifysubTabclickOnDashboard(String reportName, String tabName) {
		Assert.assertTrue(DashboardObject.verifysubTabclickforRequiredReportOnDashboard(tabName, reportName),
				"[Assertion Fail]:  Data is not visible according to the selected subTab");
		TestNGLogUtility.pass("[Assertion Pass]: Data is visible according to the selected subtab");
	}

	@Then("User verifies the summary elements of \"(.*)\" Report on dashboard")
	public void verifySummaryElements(String reportName, DataTable summaryElementsOnDashboardTable) {
		List<String> summaryElementsOnDashboard = summaryElementsOnDashboardTable.asList(String.class);
		List<String> summaryElementsOnDashboardVisible = DashboardObject.verifySummaryElementsOnDashboard(reportName);
		Assert.assertEquals(summaryElementsOnDashboard, summaryElementsOnDashboardVisible,
				"[Assertion Fail]:  Summary elements are not as per the requirement");
		TestNGLogUtility.pass("[Assertion Pass]: Summary elements are as per the requiremnt");
	}

	@When("User hovers on \"(.*)\" column name in \"(.*)\" Report on dashboard")
	public void hoverOnRequiredColumnNameOnDashboard(String columnName, String reportName) {
		toolTipTextForRespectiveColumnName = DashboardObject
				.hoverOnRequiredColumnNameForRequiredReportOnDashboard(columnName, reportName);
	}

	@Then("Verify the \"(.*)\" in \"(.*)\" Report on dashboard")
	public void verifyToolTipForRequiredColumnNameOnDashboard(String expectedToolTipText, String reportName) {
		Assert.assertTrue(
				DashboardObject.verifyToolTipForRequiredColumnNameInRequiredReportOnDashboard(expectedToolTipText,
						reportName, toolTipTextForRespectiveColumnName),
				"[Assertion Fail]: Required tool tips are not visible on the " + expectedToolTipText + " column");
		TestNGLogUtility
				.pass("[Assertion Pass]: Required Tool Tips are visible on the " + expectedToolTipText + " column");
	}

	@When("User goes to the \"(.*)\" Page")
	public void navigateToRequiredPage(String pageName) {
		csmGeneric.launchSpecificURL(YamlReader.getAppConfigValue("URLs." + pageName));
	}

	@When("User gets all the stages present in the system")
	public void getAllCustomStagesInSystem() {
		stagesListFromSettings = DashboardObject.getAllCustomStagesFromSettingPage();
	}

	@When("User gets all the custom stages present in report")
	public void getAllStagesInCustomReport() {
		stagesListFromReport = DashboardObject.getTheListOfCustomStagePresentInReports();
	}

	@Then("User verifies that all the parent stages are visible in the list for StageLevelFunnel Report")
	public void verifyCustomStagesList(ArrayList<String> stagesListFromSettings,
			ArrayList<String> stagesListFromReport) {
		Assert.assertTrue(DashboardObject.verifyTheListOfCustomStages(stagesListFromSettings, stagesListFromReport),
				"[Assertion Fail]: Custom Stages list doesn't include all the stages");
		TestNGLogUtility.pass("[Assertion Pass]: Custom Stages list includes all the stages ");
	}

	@And("User verifies name and navigation URL of reports")
	public void userVerifiesNameAndNavigationURLOfReports(DataTable reportTable) {
		Map<String, String> reportsURLOnDashboard = reportTable.asMap(String.class, String.class);
		Map<String, String> reportsURLOnDashboardVisibile = DashboardObject.getNameAndUrlOfAllClickableReports();
		Assert.assertEquals(reportsURLOnDashboardVisibile, reportsURLOnDashboard);
		TestNGLogUtility.pass("[Assertion Pass]: Correct reports name with URLs are visible from All Reports DropDown");
	}

	@Then("User verifies Name of All Visible Reports")
	public void userVerifiesNameOfAllVisibleReports(DataTable allReportsNameTable) {
		List<String> AllReportsName = allReportsNameTable.asList(String.class);
		List<String> AllReportsNameVisible = DashboardObject.getNameOfAllReportsVisible();
		Assert.assertEquals(AllReportsName, AllReportsNameVisible);
		TestNGLogUtility.pass("[Assertion Pass]: Correct reports name are visible from All Reports DropDown");
	}
}