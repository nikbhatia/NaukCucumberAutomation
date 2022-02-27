//package com.naukri.pageobjects.Reports;
//
//import java.util.ArrayList;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//
//import com.naukri.automation.util.TestNGLogUtility;
//import com.naukri.test.base.BaseAutomation;
//
//public class OrderofReportsPO extends BaseAutomation {
//
//	boolean flag = false;
//	int sizeOfReportsNameDD = 0;
//	Actions actions = new Actions(driver);
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	public String ReportNameThatIsMovedGetText = "";
//
//	public static By clickCustomize = By.xpath("//span[text()='Customize']");
//	public static By getCustomizeDDHeading = By.xpath("//div[text()='Arrange Widgets']");
//	public static By clickReportsNameDD = By.xpath("(//h2[@class='reportName'])[1]");
//	public static By getNoOfElementsInReportsNameDD = By.xpath("//li[@class='reportsDropdownLi ']//a[contains(@href,'/rms-reports')]");
//	public static By getNoOfElementsInCustomizeDD = By.xpath("//div[@id='reportsDragList']//li");
//	public static By clickOnSettings = By.xpath("//small[@class='mainSettingIc']");
//	public static By clickOnLogout = By.xpath("//a[text()='Logout']");
//	public static By recruiterActivity = By.xpath("//div[@id='reportsDragList']//div[text()='Recruiter Activity']");
//	public static By HmReport = By.xpath("//div[@id='reportsDragList']//div[text()='Hiring Manager Activity']");
//	public static By ReportTargetPositionToBeReOrdered = By.cssSelector("li[data-id='reqAgingReport']");
//	public static By ReportPositionToBeReOrdered = By.cssSelector("li[data-id='tatReport']");
//	public static By DragAndDropIcon = By.xpath("(//em[@class='dragger'])[2]");
//	public static By ReportNameThatIsMovedInDD = By.xpath("(//div[@id='reportsDragList'])//li[2]//div");
//	public static By getFirstReportOnDashboardExcludingSS = By.xpath("//h2[@class='reportName title']");
//	public static By clickOnApplyButton = By.xpath("//button[text()=' Apply']");
//	public static By getFirstReportOnDashboard = By.xpath("(//span[@class='reportTitle'])[1]");
//
//	public void clickOnCustomizeLinkOnDashboard() {
//		getElement(clickCustomize).click();
//		TestNGLogUtility.info("User clicked on Customize Link");
//	}
//
//	public boolean verifyCustomizeDDHeading() {
//		if (getElements(getCustomizeDDHeading).size() != 0)
//			flag = true;
//		return flag;
//	}
//
//	public void clickOnReportsnameDD() {
//		getElement(clickReportsNameDD).click();
//		TestNGLogUtility.info("User clicked on clickReportsNameDD");
//	}
//
//	public void getReportsNameDDElements() {
//		sizeOfReportsNameDD = getElements(getNoOfElementsInReportsNameDD).size();
//	}
//
//	public boolean verifyReportNamesinCustomizeDD() {
//		int sizeOfCustomizeDD = getElements(getNoOfElementsInCustomizeDD).size();
//		if (sizeOfReportsNameDD == sizeOfCustomizeDD + 1)
//			flag = true;
//		return flag;
//	}
//
//	public void logOutFromRMS() {
//		hover(clickOnSettings);
//		getElement(clickOnLogout).click();
//		TestNGLogUtility.info("User successfully logged out from RMS");
//	}
//
//	public boolean verifyRecruiterActivityReportForNonTL() {
//		flag = !(getElement(recruiterActivity).isDisplayed());
//		return flag;
//	}
//
//	public boolean verifyRecruiterActivityReportForTL() {
//		flag = getElement(recruiterActivity).isDisplayed();
//		return flag;
//	}
//
//	public boolean verifyHmReportForNonHrSpoc() {
//		flag = !(getElement(HmReport).isDisplayed());
//		return flag;
//	}
//
//	public void hoveronReportNameInDD() {
//		hover(ReportPositionToBeReOrdered);
//		TestNGLogUtility.info("User hovered over the report name that is to be dragged and repositioned");
//	}
//
//	public boolean verifyDragAndDropIconVisibility() {
//		flag = getElement(DragAndDropIcon).isDisplayed();
//		return flag;
//	}
//
//	public void ReportNameThatIsMoved() {
//		ReportNameThatIsMovedGetText = getElement(ReportNameThatIsMovedInDD).getText();
//	}
//
//	public void DragReportName() {
//		WebElement source = getElement(ReportPositionToBeReOrdered);
//		WebElement target = getElement(ReportTargetPositionToBeReOrdered);
//		 actions.dragAndDrop(source, target).build().perform();
//
////		actions.clickAndHold(source).pause(2000).moveToElement(target).release().build().perform();
//
//		// js.executeScript("arguments[0].innerText ='something'",
//		// ReportPositionToBeReOrdered);
//
//		TestNGLogUtility.info("User Dragged a row at another position");
//	}
//
//	public void clickOnApplyButton() {
//		getElement(clickOnApplyButton).click();
//		TestNGLogUtility.info("User clicked on Apply Button");
//	}
//
//	public boolean verifyNewOrder() {
//		ReportNameThatIsMovedGetText.equals(getElement(getFirstReportOnDashboardExcludingSS).getText());
//		return flag;
//	}
//
//	public boolean verifySaveAndScheduleOrder() {
//		if (getElement(getFirstReportOnDashboard).getText().equals("Saved & Scheduled Reports"))
//			flag = true;
//		return flag;
//	}
//
//	public boolean verifyReportsNameDdOrder() {
//		getElement(clickReportsNameDD).click();
//		int size = getElements(getNoOfElementsInReportsNameDD).size();
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 1; i <= size; i++) {
//			WebElement getReportNames = getElement(
//					By.xpath("(//li[@class='reportsDropdownLi ']//a[contains(@href,'/rms-reports')])[" + i + "]"));
//			list.add(getReportNames.getText());
//		}
//		if (list.get(0).equals("Saved & Scheduled") && (list.get(1).equals("Turn Around Time Reports"))
//				&& (list.get(2).equals("Stage Level TAT")) && (list.get(3).equals("Conversion Funnel Reports"))
//				&& (list.get(4).equals("Requirement Funnel")) && list.get(5).equals("Requirement Aging")
//				&& (list.get(6).equals("Requirement Creation")) && (list.get(7).equals("Source Performance"))
//				&& (list.get(8).equals("Vendor Performance")) && (list.get(9).equals("Recruitment Activity"))
//				&& (list.get(10).equals("Shared With")))
//			flag = true;
//		return flag;
//	}
//
//	public boolean verifycustomizeLinkForDashboard() {
//		if (getElements(clickCustomize).size() != 0)
//			flag = true;
//		return flag;
//	}
//
//	public boolean verifycustomizeLinkForTAT() {
//		if (getElements(clickCustomize).size() == 0)
//			flag = true;
//		return flag;
//	}
//
//}
