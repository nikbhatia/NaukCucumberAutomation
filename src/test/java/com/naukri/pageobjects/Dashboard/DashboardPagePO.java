package com.naukri.pageobjects.Dashboard;

import org.openqa.selenium.By;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Dashboard Page Object
 * @author rachit.mehrotra
 *
 */
public class DashboardPagePO extends PageObjectWrapper {
	
	By eleEventWidget = By.id("activityHead");
	By eleCandidateNameHolder = By.xpath("//p[contains(@title,'${candidateName}')]");
	By eleCandidateNameHolderBasisText = By.xpath("//p[text()='${candidateName}']");
	By eleCalenderOnEventWidget = By.xpath("//i[contains(text(),\"calendar\")]");
	By eleDatePickerOfCalender = By.xpath("//div[contains(@aria-label,'${dateString}')]");
	By eleTodayDateForCalender = By.xpath("//div[contains(@class,\"today\")]");
	By eleCrossIconOnCalender = By.xpath("//i[contains(text(),\"cross\")]");
	By eleMasterProfileSearch = By.id("headTopSearchBox");
	By eleGlobalSearchButton = By.id("advQuichSearchBtn");
	By eleNMoreNotification = By.xpath("//footer[contains(@class,'notifFooter link')]");
	By eleHMRemoveNotiForGrp = By.xpath("//p[text()='Hiring Manager/Interviewer removed']//parent::div//following-sibling::div//p[text()='${groupName}']");
	
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	
	/**
	 * To scroll down to the events widget
	 */
	public void navigateToEventsWidget() {
		jsUtil.scrollDown(eleEventWidget);
	}
	
	/**
	 * To verify the presence of the candidate name on interview event's widget
	 * @return boolean basis comparison
	 */
	public boolean verifyThePresenceOfCandidateOnInterviewWidget() {
		jsUtil.executeJavascript("arguments[0].scrollIntoView(true);", parameterizedLocator(eleCandidateNameHolderBasisText, AddASingleProfilePagePO.candidateName));
		return isDisplayed(parameterizedLocator(eleCandidateNameHolder, AddASingleProfilePagePO.candidateName));
	}
	
	/**
	 * To click on the event widget's calender icon
	 */
	public void clickOnEventCalender() {
		click(eleCalenderOnEventWidget);
	}
	
	/**
	 * To select the date of the event's widget calender on the recruiter dashboard
	 * @param daysToShift
	 */
	public void selectDateOnCalender(String daysToShift) {
		wait.waitForInvisibilityOfElement(10, 3, By.xpath("//div[@class = 'DayPicker-Day DayPicker-Day--active DayPicker-Day--disabled']"));
		if(daysToShift.equals("today")) {
			wait.waitForElementToBeClickable(eleTodayDateForCalender);
			click(eleTodayDateForCalender);
		}
		else {
			int presentDate = Integer.parseInt(getText(eleTodayDateForCalender));
			click(parameterizedLocator(eleDatePickerOfCalender, Integer.toString(presentDate+Integer.parseInt(daysToShift))));
		}
		click(eleCrossIconOnCalender);
	}
	
	/**
	 * To launch the HM dashboard
	 */
	public void launchHMDashboard() {
		genericFunctions.launchSpecificURL(URLBuilder.getURL("hiringManagerDashboard"));
		TestNGLogUtility.info("Hiring Manager Dashboard launched");
	}
	
	public void searchMasterProfileOnDashboard() {
		String masterProfileEmail = PropFileHandler.readProperty("Candidate Email");
		sendKeys(eleMasterProfileSearch,masterProfileEmail);
		TestNGLogUtility.info("Email searched for master profile " + masterProfileEmail);
		click(eleGlobalSearchButton);
		TestNGLogUtility.info("Global search button clicked");
	}

	/**
	 * @author gupta.mansi
	 * This method clicks on notification of HM removal for given group
	 * @param grpName
	 * @return true if notification found and clicked
	 */
	public boolean clickOnHMRemovedNotificationForGroup(String grpName)
	{
		boolean flag = false;
		wait.waitForPageToLoadCompletely();
		if(isDisplayed(parameterizedLocator(eleHMRemoveNotiForGrp, grpName))) {
			click(parameterizedLocator(eleHMRemoveNotiForGrp, grpName));
			switchToChildWindow();
			flag = true;}
		else
		{
			click(eleNMoreNotification);
			if(isDisplayed(parameterizedLocator(eleHMRemoveNotiForGrp, grpName))) {
				click(parameterizedLocator(eleHMRemoveNotiForGrp, grpName));
				switchToChildWindow();
				flag = true;}
			
		}
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if notification is displayed
	 * @param grpName
	 * @return
	 */
	public boolean verifyNotificationHeaderForGroup(String grpName)
	{
		boolean flag = false;
		wait.waitForPageToLoadCompletely();
		if(isDisplayed(parameterizedLocator(eleHMRemoveNotiForGrp, grpName))) {
			flag = true;}
		else
		{
			click(eleNMoreNotification);
			if(isDisplayed(parameterizedLocator(eleHMRemoveNotiForGrp, grpName))) {
				flag = true;}
			
		}
		return flag;
	}
	

}
