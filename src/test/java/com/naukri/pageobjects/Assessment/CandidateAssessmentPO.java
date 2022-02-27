package com.naukri.pageobjects.Assessment;

import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.naukri.test.base.BaseAutomation;

/**
 * @author rounak.jain
 *
 */
public class CandidateAssessmentPO extends BaseAutomation {


	By tabCandidateAssessment = By.id("smtabAssessments");
	By btnCandAssessment = By.xpath("//a[text()='Add Candidate Assessment' and @class ='blue_btn']");
	By tabAddCandidateAssessment = By.xpath("//a[text()='Add Candidate Assessment' and @class='btn fl']");
	
	By selectedStage = By.xpath("//input[@placeholder='Select a stage']");
	By yesOrNo = By.xpath("//button[text()='${YesorNo}']");
	By deleteTest = By.id("delTestSuccess");
	By selectAStage = By.xpath("//ul[@class='dropdown ']/li[text()='${stageName}']");
	By eleSelectionStageDD = By.xpath("//ul[@class='dropdown ']/li");
	By headingName = By.xpath("//*[contains(text(),'${heading}')]");


	/** Candidate Assessment Tab **/

	/**
	 * This function will click in candidate assessment tab
	 */
	public void clickCandidateAssessmentTab() {
		wait.waitForVisibilityOfElement(tabCandidateAssessment);
		click(tabCandidateAssessment);
		wait.waitForProcessingToDisappear(10,3);
	}

	/**
	 * This function will click on the candidate assessment button available on
	 * Requirement overview page
	 */
	public void clickCandidateAssessmentButton() {
		click(btnCandAssessment);
	}

	/**
	 * This function will click on the candidate assessment button available on
	 * candiate assessment tab
	 */
	public void clickCandidateAssessmentLink() {
		getElement(tabAddCandidateAssessment).click();
	}

	/**
	 * This function will verify the candidate assessment button available on
	 * candiate assessment tab
	 * @return It will return the visibility of candidate assessment button
	 */
	public boolean verifyAddCandidateButtonOnPage() {
		return isDisplayed(btnCandAssessment);
	}

	/**
	 * This function will verify the headings on any page 
	 * @param heading = Name of the heading
	 * @return It will return true if heading present on the page
	 */
	public boolean verifyHeadings(String heading) {
		wait.waitForVisibilityOfElement(parameterizedLocator(headingName,heading));
		return isDisplayed(parameterizedLocator(headingName,heading));
	}

	/**
	 * This function will click on the selected Stage Drop down on select a test
	 * page
	 */
	public void clickSelectedStageDD() {
		wait.waitForVisibilityOfElement(selectedStage);
		getElement(selectedStage).click();
	}

	/**
	 * This function will select a stage on select a test page
	 */
	public void selectStage(String stageName) {
		getElement(selectAStage, stageName).click();
		
	}

	/**
	 * This function is capturing all the values from select stage dd and storing
	 * into a linked hash set
	 * @return It will return the list of stages
	 */
	public LinkedHashSet<String> getAllSelectionStageFromDD() {

		List<WebElement> stagesDD = getElements(eleSelectionStageDD);
		LinkedHashSet<String> stages = new LinkedHashSet<String>();
		String str;
		for (int i = 1; i <= stagesDD.size(); i++) {
			str = getElement(By.xpath("//ul[@class='dropdown ']/li[" + i + "]")).getText();
			stages.add(str);
		}
		System.out.println(stages);
		return stages;
	}

	/**
	 * This function is to verify the stage is displaying or not on Configure Test
	 * Settings
	 * @return It will return true if stage present in DD
	 */
	public boolean verifySelectStagesInDD(String stageName) {

		return isDisplayed(By.xpath("//li[text()='" + stageName + "']"));
	}

	/**
	 * To Check whether the selected test is present on Candidate assessment tab or
	 * not 
	 * @param stageName : Name of the stage where test is attached
	 * @param testName  : Name of the attached test
	 * @return true the selected test is present on Candidate assessment tab
	 */
	public boolean testOnCandidateAssessmentTab(String testName, String stageName) {
		return isDisplayed(By.xpath("//span[text()='" + testName
				+ "']/../ul/li[text()='Edit']/../preceding-sibling::span[text()='" + stageName + "']"));
	}

	/**
	 * To click on the links present on test for modification like
	 * edit/delete/preview
	 * 
	 * @author Rounak Jain
	 */
	public void clickOnTestsLinks(String testName, String status) {
		getElement(By.xpath("//span[text()='" + testName + "']/../ul/li[text()='" + status + "']")).click();
	}

	/**
	 * To Verify if test is there in inactive test list
	 * 
	 * @author Rounak Jain
	 * @param testName : Name of the attached test
	 * @return it will verify the inactive test 
	 */
	public boolean verifyInactiveTest(String testName) {
		return isDisplayed(
				By.xpath("//div[text()='Inactive Tests ']/following-sibling::div//span[text()='" + testName + "']"));
	}

	/**
	 * To select the option Yes or no in pop up
	 * 
	 * @author Rounak Jain
	 * @param resYesOrNo : Select the option yes or no
	 */
	public void selectYorN(String resYesOrNo) {
		getElement(yesOrNo, resYesOrNo).click();
	}

	/**
	 * To click on the remove button for a test
	 * 
	 * @author Rounak Jain
	 * @param resYesOrNo : Select the option yes or no
	 */
	public void acceptRemoveConfirmation() {
		getElement(deleteTest).click();
	}
}
