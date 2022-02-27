package com.naukri.pageobjects.Applications;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

/**
 * Interview Scheduling page object
 * @author rachit.mehrotra
 *
 */
public class InterviewSchedulingPagePO extends PageObjectWrapper{
	
	/**
	 * Advanced interview scheduling page object
	 * @author rachit.mehrotra
	 *
	 */
	public class AdvancedInterviewSchedulingPagePO extends PageObjectWrapper {
		
		By eleHiringManagerList = By.xpath("//input[contains(@placeholder,\"Type to search interviewers\")]");
		By eleSelectHiringManager = By.xpath("//li[contains(text(),'${hiringManager}')]");
		By eleInterviewVenue = By.xpath("//textarea[@placeholder=\"Type or search Location\"]");
		By eleScheduleInterview = By.id("saveInterviewSchedule");
		
		/**
		 * To click on HM list container
		 */
		public void clickOnHiringManagerList() {
			wait.waitForPageToLoadCompletely();
			click(eleHiringManagerList);
		}
		
		/**
		 * To click on HM name in the list
		 * @param hiringManagerName
		 */
		public void selectHiringManager(String hiringManagerName) {
			click(parameterizedLocator(eleSelectHiringManager, hiringManagerName));
		}
		
		/**
		 * To fill in the interview venue
		 * @param interviewVenue
		 */
		public void fillInInterviewVenue(String interviewVenue) {
			sendKeys(eleInterviewVenue, interviewVenue);
		}
		
		/**
		 * To click on schedule interview button
		 */
		public void clickOnScheduleInterviewButton() {
			click(eleScheduleInterview);
		}
	}
	
	/**
	 * Basic interview scheduling page object
	 * @author rachit.mehrotra
	 *
	 */
	public class BasicInterviewSchedulingPagePO extends PageObjectWrapper {
		
		By eleInterviewVenue = By.xpath("//input[contains(@name,\"VENUE\")]");
		By eleSetDateForInterview = By.xpath("//td[@class=\"currDate\"]");
		By eleCalendarIconInterview = By.xpath("//a[@class=\"calendar fr\"]");
		By eleSetHourForInterview = By.xpath("//input[@name=\"interviewTimeHH\"]");
		By eleSetMinutesForInterview = By.xpath("//input[@name=\"interviewTimeMM\"]");
		By ddSetAMPM = By.xpath("//select[@name='interviewTimeAmPm']");
		By eleAMPM = By.xpath("//select[@name='interviewTimeAmPm']//option[text()='${AMPM}']");
		By btnMonthNext = By.xpath("(//div[contains(@id,'calenCont')]//li)[4]");
		By btnFirstDate = By.xpath("//div[contains(@id,'calenCont')]//td[text()='1']");
		
		/**
		 * To fill in the interview venue
		 * @param interviewVenue
		 */
		public void fillInterviewVenue(String interviewVenue) {
			sendKeys(eleInterviewVenue, interviewVenue);
		}

		public void interviewDate() {
			click(eleCalendarIconInterview);
			click(eleSetDateForInterview);
		}
		
		public void setInterviewTime(String hour, String minutes) {
			sendKeys(eleSetHourForInterview, hour);
			sendKeys(eleSetMinutesForInterview, minutes);
		}
		
		/**
		 * @author gupta.mansi
		 * This method selects given value from AM PM drop down
		 * @param value - AM or PM
		 */
		public void setAMPM(String value)
		{
			click(ddSetAMPM);
			click(parameterizedLocator(eleAMPM, value));
		}
		
		/**
		 * @author gupta.mansi
		 * This method sets interview date as next month's first day
		 */
		public void setDateAsNextMonthFirst()
		{
			click(eleCalendarIconInterview);
			click(btnMonthNext);
			click(btnFirstDate);
			
		}
		
	}

}
