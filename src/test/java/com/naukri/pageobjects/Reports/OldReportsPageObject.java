package com.naukri.pageobjects.Reports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

import scala.annotation.meta.getter;

public class OldReportsPageObject extends BaseAutomation{
	boolean flag=false;
	
	//locators of reports page
	By reportName = By.xpath("//a[contains(text(),'${reportName}')]");
	By requirementTimeline = By.id("creation");
	By activitiesTimeline = By.id("activities");
	By requirementTimelineOption = By.xpath("//div[@id=\"creationDateDiv\"]/a");
	By activityTimelineOption = By.xpath("//div[@id=\"activityDateDiv\"]/a");
	By moreOfRequirementCreation = By.xpath("//select[@id=\"creationDD\"]/parent::a");
	By moreOfActivityDate = By.xpath("//select[@id=\"activityDD\"]/parent::a");
	By listOfMoreOnRequirementTimeline = By.xpath("//select[@id=\"creationDD\"]/option");
	By listOfMoreOnActivityTimeline = By.xpath("//select[@id=\"activityDD\"]/option");
	By listOfColumn = By.xpath("//div[@id='columnIds']//input[@placeholder='Select Column']");
	By columnDdValue= By.xpath("//div[@id='dp_columnIds']//a/b");
	public By eleComparisonCheckBox=By.xpath("//input[@id='comparison']");
	public By eleDuration=By.xpath("//a[contains(text(),'${duration}')]");
	public By eleColumnInReport=By.xpath("//th[contains(text(),'${Requirement}')]");
	public By eleClearAll=By.xpath("//a[@id='clearReqId']");
	public By eleClearAllColumn=By.xpath("//a[@id='clearColId']");
	public By eleRecruiterColumn=By.xpath("//input[@id='showSelectRecuiterBox']");
	public By eleFooterMessage=By.xpath("//div[contains(text(),'${message}')]");
	public By elerecruiter=By.xpath("//input[@id='showSelectRecuiterBox']");
	public By eleSelectRecruiterDD=By.xpath("//b[contains(text(),'${recruiter}')]");
	/**
	 * To click on reports tab on reports listing page
	 * @author rachit.mehrotra
	 * @param reportName
	 */
	public void clickOnReportsTab(String reportName) {
		click(parameterizedLocator(this.reportName, reportName + " Report"));
	}
	
	/**
	 * To verify the presence of the radio button for time filter of requirement creation or activity selection date
	 * @author rachit.mehrotra
	 * @param labelText
	 * @return boolean
	 */
	public boolean verifyThePresenceOfRadioButtonWithLabel(String labelText) {
		if(labelText.equals("Show reports for Requirements created / re-opened")) {
			jsUtil.scrollDown(requirementTimeline);
			return isDisplayed(requirementTimeline);
		}
		else {
			jsUtil.scrollDown(activitiesTimeline);
			return isDisplayed(activitiesTimeline);
		}
	}
	
	/**
	 * To click on the radio button for time filter of requirement creation or activity selection date
	 * @author rachit.mehrotra
	 * @param labelText
	 */
	public void clickOnRadioButton(String labelText) {
		if(labelText.equals("Show reports for Requirements created / re-opened")) {
			jsUtil.scrollDown(requirementTimeline);
			click(requirementTimeline);
		}
		else {
			jsUtil.scrollDown(activitiesTimeline);
			click(activitiesTimeline);
		}
	}
	
	/**
	 * Compares the list of the options from feature to that present on UI for the timeline bar of requriement created and activities done
	 * @author rachit.mehrotra
	 * @param labelText
	 * @param stringOfOPtions
	 * @return boolean
	 */
	public boolean compareListOfOptionsOnTimeline(String labelText, String stringOfOPtions) {
		List<WebElement> listOfOptionWe = new ArrayList<WebElement>();
		switch (labelText) {
		case "requirement creation":
			listOfOptionWe = getElements(requirementTimelineOption);
			break;
		case "activities done":
			listOfOptionWe = getElements(activityTimelineOption);
			break;
		}
		List<String> listOfOptions = Arrays.asList(stringOfOPtions.split(","));
		for (int i = 0; i < listOfOptions.size(); i++) {
			if (!(listOfOptionWe.get(i).getText()).equals(listOfOptions.get(i).trim())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * To click on more option on basis of label text for requirement creation or activity done timeline
	 * @author rachit.mehrotra
	 * @param labelText
	 */
	public void clickOnMoreOption(String labelText) {
		switch (labelText) {
		case "requirement creation":
			wait.waitForElementToBeClickable(moreOfRequirementCreation);
			click(moreOfRequirementCreation);
			break;
		case "activities done":
			wait.waitForElementToBeClickable(moreOfActivityDate);
			click(moreOfActivityDate);
			break;
		}
	}
	/**
	 * Compares the list of the options from feature to that present on UI under the more option for the timeline bar of requriement created and activities done
	 * @author rachit.mehrotra
	 * @param labelOption
	 * @param stringOfOptions
	 * @return boolean
	 * @modif avani
	 */
	public boolean compareMoreListOfTimeLineBar(String labelOption, String stringOfOptions) {
		List<WebElement> listOfMoreOptionWe = new ArrayList<WebElement>();
		switch (labelOption) {
			case "requirement creation":
				listOfMoreOptionWe = getElements(listOfMoreOnRequirementTimeline);
				break;
			case "activities done":
				listOfMoreOptionWe = getElements(listOfMoreOnActivityTimeline);
				break;
		}
		List<String> listOfOptions = Arrays.asList(stringOfOptions.split(","));
		for (int i = 1; i < listOfMoreOptionWe.size(); i++) {
			if (!(listOfMoreOptionWe.get(i).getAttribute("label")).equals(listOfOptions.get(i-1).trim())) {

				return false;
			}
		}
		return true;
	}
	
	/**
	 * To click on column DD on reports page
	 * @author himanshu.dua
	 */
	public void clickOnColumnDD() {
		click(listOfColumn);
	}
	
	/**
	 * This method will verify field in column
	 * @author himanshu.dua 
	 * @param value
	 * @return
	 */
	public boolean verifyEmploymentTypeColumnInReport(String value) {
		sendKeys(listOfColumn, value);
		if(isDisplayed(columnDdValue))
			flag=getText(columnDdValue).trim().equals(value);
		return flag;
	}




	/**
	 * This method is use to click on comparison checkbox
	 * @author avani
	 */
	public void clickOnComparisonCheckbox(){
		wait.waitForPageToLoadCompletely();
		click(eleComparisonCheckBox);
	}

	/**
	 * This method is use to click on recruiter column and select recruiter
	 * from recuruiter column
	 * @param listOfRecruiter
	 * @author avani
	 */

	public void selectRecruitersFromRecruiterColumn(List<String> listOfRecruiter){
		click(eleRecruiterColumn);
		for(int i=0;i<listOfRecruiter.size();i++){
			sendKeys(elerecruiter,listOfRecruiter.get(i));
			click(parameterizedLocator(eleSelectRecruiterDD,listOfRecruiter.get(i)));}
	}
	/**
	 * This method is use to click on Select column and select column
	 * from Select column
	 * @param listOfCoulmn
	 * @author avani
	 */

	public void selectColumnFromSelectColumn(List<String> listOfCoulmn){
		click(eleClearAllColumn);
		click(listOfColumn);
		for(int i=0;i<listOfCoulmn.size();i++){
			sendKeys(listOfColumn,listOfCoulmn.get(i));
			click(parameterizedLocator(eleSelectRecruiterDD,listOfCoulmn.get(i)));}
	}
	/**
	 * This method is use to select duration for activity done
	 * @param duration
	 * @author avani
	 */
	public void selectDurationFOrActivityDone(String duration){
		click(parameterizedLocator(eleDuration,duration));
	}
	/**
	 * This method is use verify column on reports page
	 * @param column
	 * @author avani
	 */

	public boolean verifyColumnInReport(String column){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleColumnInReport,column)));
	}

	/**
	 * This method is use verify footer message on report page
	 * @param message
	 * @author avani
	 */
	public boolean verifyFooterMessage(String message){
		scrollToElement(parameterizedLocator(eleFooterMessage,message));
		return(isDisplayed(parameterizedLocator(eleFooterMessage,message)));
	}
	/**
	 * This method is click on Clear All option for recruiter Column
	 * @author avani
	 */
	public void clearAllRecruiter(){click(eleClearAll);
	}

}
