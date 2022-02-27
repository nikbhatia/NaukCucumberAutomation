//package com.naukri.stepdefinitions.Reports;
//
//import static com.naukri.automation.util.YamlReader.getAppConfigValue;
//
//import org.testng.Assert;
//
//import com.naukri.automation.util.GenericFunctions;
//import com.naukri.automation.util.TestNGLogUtility;
//import com.naukri.pageobjects.Reports.OrderofReportsPO;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class OrderofReportsSD {
//
//	GenericFunctions csmGeneric = new GenericFunctions();
//	OrderofReportsPO OrderofReportsObject = new OrderofReportsPO();
//	SaveAndScheduleSD SaveAndScheduleSD = new SaveAndScheduleSD();
//
//	@When("I am on the (.*) Page")
//	public void navigateToRequiredPage(String pageName) {
//		csmGeneric.loginToRMS(getAppConfigValue("URLs." + pageName),
//				getAppConfigValue("Users.EnterpriseSuperuser.Username1"),
//				getAppConfigValue("Users.EnterpriseSuperuser.Password1"));
//	}
//
//	@Given("I am on (.*) Reports")
//	public void loginRMS(String ReportName) {
//		if (ReportName.equals("DashboardFunnel")) {
//			csmGeneric.loginToRMS(getAppConfigValue("ReportURLs.Dashboard"),
//					getAppConfigValue("Users.ConsultantSuperuser.Username1"),
//					getAppConfigValue("Users.ConsultantSuperuser.Password1"));
//		}
//		else if (ReportName.equals("Requirement Funnel")|| ReportName.equals("Stage Level Funnel")) {
//			csmGeneric.loginToRMS(getAppConfigValue("ReportURLs." + ReportName),
//					getAppConfigValue("Users.ConsultantSuperuser.Username1"),
//					getAppConfigValue("Users.ConsultantSuperuser.Password1"));
//		}
//		else
//		{
//		csmGeneric.loginToRMS(getAppConfigValue("ReportURLs." + ReportName),
//				getAppConfigValue("Users.EnterpriseSuperuser.Username1"),
//				getAppConfigValue("Users.EnterpriseSuperuser.Password1"));
//		}
//		if (ReportName.equals("Dashboard")||ReportName.equals("DashboardFunnel"))
//			SaveAndScheduleSD.waitForReportsToLoad();
//		else
//			SaveAndScheduleSD.checkIfReportIsLoaded();
//	}
//
//	@Given("I am on the (.*) Reports on Dashboard")
//	public void loginRMSOnDashboard(String ReportName) {
//		if (ReportName.equals("Requirement Funnel")|| ReportName.equals("Stage Level Funnel")) {
//			csmGeneric.loginToRMS(getAppConfigValue("ReportURLs.Dashboard"),
//					getAppConfigValue("Users.ConsultantSuperuser.Username1"),
//					getAppConfigValue("Users.ConsultantSuperuser.Password1"));
//		}
//		else {
//			csmGeneric.loginToRMS(getAppConfigValue("ReportURLs.Dashboard"),
//					getAppConfigValue("Users.EnterpriseSuperuser.Username1"),
//					getAppConfigValue("Users.EnterpriseSuperuser.Password1"));
//		}
//		SaveAndScheduleSD.checkIfReportIsLoadedOnDashboard(ReportName);
//	}
//
//	@When("I click on Customize link")
//	public void clickOnCustomizeLink() {
//		OrderofReportsObject.clickOnCustomizeLinkOnDashboard();
//	}
//
//	@Then("Verify that DD list with ArrangeWidgets heading is visible on click")
//	public void verifyCustomizeDD() {
//		Assert.assertTrue(OrderofReportsObject.verifyCustomizeDDHeading(),
//				"[Assertion Fail]: ExpecetedDD dosn't opens");
//		TestNGLogUtility.pass("[Assertion Pass]: Expected DD with expected Heading opens");
//	}
//
//	@When("I click on ReportsNameDD")
//	public void clickOnReportsnameDD() {
//		OrderofReportsObject.clickOnReportsnameDD();
//	}
//
//	@When("I get the elements from ReportsNameDD")
//	public void getReportsNameDDElements() {
//		OrderofReportsObject.getReportsNameDDElements();
//	}
//
//	@Then("Verify that DD list has all the reports name except for SaveSchedule")
//	public void verifyReportNames() {
//		Assert.assertTrue(OrderofReportsObject.verifyReportNamesinCustomizeDD(),
//				"[Assertion Fail]: ExpecetedDD dosn't opens");
//		TestNGLogUtility.pass("[Assertion Pass]: Expected DD with expected Heading opens");
//	}
//
//	@When("I logout from RMS")
//	public void logOut() {
//		OrderofReportsObject.logOutFromRMS();
//	}
//
//	@When("I login to RMS from a (.*) Subuser and land on (.*) page")
//	public void login(String subuser, String pageName) {
//		csmGeneric.loginToRMS(getAppConfigValue("ReportURLs." + pageName),
//				getAppConfigValue("Users." + subuser + ".Username"),
//				getAppConfigValue("Users." + subuser + ".Password"));
//		//SaveAndScheduleSD.waitForReportsToLoad();
//	}
//
//	@Then("Verify that Recruiter Activity Report is not visible for NonTL")
//	public void recruiterActivityReportNonTL() {
//		Assert.assertTrue(OrderofReportsObject.verifyRecruiterActivityReportForNonTL(),
//				"[Assertion Fail]: RecruiterActivity Report ordering option is visible for NON TL ");
//		TestNGLogUtility.pass("[Assertion Pass]: RecruiterSctivity Report ordering option is NOT visible for NON TL ");
//	}
//
//	@Then("Verify that Recruiter Activity Report is visible for TL")
//	public void recruiterActivityReportTL() {
//		Assert.assertTrue(OrderofReportsObject.verifyRecruiterActivityReportForTL(),
//				"[Assertion Fail]: RecruiterActivity Report ordering option is not visible for TL ");
//		TestNGLogUtility.pass("[Assertion Pass]: RecruiterSctivity Report ordering option is visible for TL ");
//	}
//
//	@Then("Verify that HMReport Report is not visible for NonHrSpoc")
//	public void HMReportVisibility() {
//		Assert.assertTrue(OrderofReportsObject.verifyHmReportForNonHrSpoc(),
//				"[Assertion Fail]: HM Report ordering option is visible for NON HRSPOC ");
//		TestNGLogUtility.pass("[Assertion Pass]: HMReport Report ordering option is NOT visible for NON HRSPOC ");
//	}
//
//	@When("I hover on any report name")
//	public void hoverOnReportName() {
//		OrderofReportsObject.hoveronReportNameInDD();
//	}
//
//	@When("I get the Report name that is reordered")
//	public void ReportNameThatIsMoved() {
//		OrderofReportsObject.ReportNameThatIsMoved();
//	}
//
//	@Then("Verify that DragAndDrop icon is visible on hovering")
//	public void dragAndDropIcon() {
//		Assert.assertTrue(OrderofReportsObject.verifyDragAndDropIconVisibility(),
//				"[Assertion Fail]: DragAndDrop icon is not visible when hovered over the report name ");
//		TestNGLogUtility.pass("[Assertion Pass]: DragAndDrop icon is visible when hovered over the report name ");
//	}
//
//	@When("I Drag one row to another place")
//	public void DragReportName() {
//		OrderofReportsObject.DragReportName();
//	}
//
//	@When("I click on Apply")
//	public void clickOnApply() {
//		OrderofReportsObject.clickOnApplyButton();
//	}
//
//	@Then("Verify that Order is changed")
//	public void verifyNewOrder() {
//		Assert.assertTrue(OrderofReportsObject.verifyNewOrder(),
//				"[Assertion Fail]: Report moved to first position is not visible at first position");
//		TestNGLogUtility.pass("[Assertion Pass]: Report moved to first position is visible at first position");
//	}
//
//	@Then("I verify that SavedAndScheduledIs visible at top")
//	public void saveAndScheduleOrder() {
//		Assert.assertTrue(OrderofReportsObject.verifySaveAndScheduleOrder(),
//				"[Assertion Fail]: SaveAndSchedule is not the first report widget as expected");
//		TestNGLogUtility.pass("[Assertion Pass]: SaveAndSchedule is the first report widget as expected");
//	}
//
//	@Then("Verify that ReportsNameDD remains same")
//	public void reportsNameDdOrder() {
//		Assert.assertTrue(OrderofReportsObject.verifyReportsNameDdOrder(),
//				"[Assertion Fail]: The order in the Reports name DD is changed due to customize DD");
//		TestNGLogUtility.pass(
//				"[Assertion Pass]: The order in the Reports name DD remains same irrespective of the customize DD");
//	}
//
//	@Then("I verify that Customize link is visible here")
//	public void customizeLinkForDashboard() {
//		Assert.assertTrue(OrderofReportsObject.verifycustomizeLinkForDashboard(),
//				"[Assertion Fail]: Customize Link is not visible on dahsboard");
//		TestNGLogUtility.pass("[Assertion Pass]: Customize Link is visible on dahsboard");
//	}
//
//	@Then("I verify that Customize link is not visible here")
//	public void customizeLinkForTAT() {
//		Assert.assertTrue(OrderofReportsObject.verifycustomizeLinkForTAT(),
//				"[Assertion Fail]: Customize Link is visible on  TAT report");
//		TestNGLogUtility.pass("[Assertion Pass]: Customize Link is not visible on  TAT report");
//	}
//}
