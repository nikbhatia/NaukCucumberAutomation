package com.naukri.pageobjects.VendorPlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;

import com.naukri.test.base.BaseAutomation;
import java.util.ArrayList;
import java.util.List;
import com.naukri.automation.util.*;
import com.naukri.test.base.PageObjectWrapper;

/**
 * 
 * @author ambar.gupta
 *
 */
public class HackerEarthSitePO extends BaseAutomation {

	private By eleLoginButtonHE = By.xpath("//div[contains(@class,'button')]/span[text()='Login']");
	private By btnAddCandToInvite = By.xpath("//button[contains(@class,'invite-button')]");
	private By eleUsernameHE = By.name("email");
	private By elePasswordHE = By.name("password");
	private By eleSubmitButtonHE = By.name("signin");
	private By eleCreateNewTestHE = By.xpath("//a[text()='Create new test']");
	private By eleCreateCustomTestHE = By.xpath("//*[@class='title'][text()='Custom']");
	private By eleTestName = By.xpath("//div[@class='topbar']/div[@class='title']");
	private By eleAddQuestions = By.xpath("//a[text()='Add questions']");
	private By eleChooseFromLibrary = By.xpath("//button[text()='Choose from library']");	
	private By eleFirstQuestion = By.xpath("(//div[@class='checkbox checkbox-mcq'])[1]");
	private By eleAddSelected = By.xpath("//div[text()='Add selected']");
	private By elePublishTest = By.xpath("//a[text()='Publish Test']");
	private By elePublish = By.xpath("//a[text()='Publish']");
	private By eleClone = By.xpath("//a[@target='duplicate-test-modal']");
	private By eleDelete = By.xpath("//a[@target='delete-test-modal']");
	private By txtBoxDuplicateTestName = By.xpath("//div[@id='duplicate-test-modal']/div/form/div/input[@id='id_title']");
	private By btnCreateHE = By.xpath("//a[text()='Create']");
	private By btnConfirmDeleteTest = By.xpath("//div[@id='delete-test-modal']/div/a[text()='Delete']");
	private By btnInviteCandidates = By.id("invite-candidates-link");
	private By btnAddCandForInvite = By.xpath("//button[contains(@class,'invite-button')]");
	private By btnConfirmInviteCandidates = By.xpath("//button[text()='Invite candidates']");
	private By txtBoxEmailInput = By.className("email-input");
	private By btnSaveAndProceed = By.xpath("//button[text()='Save and proceed']");
	private By eleInviteSuccess =By.className("inline-message-header-content");
	private By eleEditEndDate = By.xpath("(//div[@class='edit-cta'])[2]");
	private By eleSelectCurrentDate = By.xpath("//div[contains(@class,'day--today')]");
	private By eleSaveEndDate = By.xpath("//button[text()='Save']");
	private By eleTestsWithZeroCand = By.xpath("//div[contains(@class,'candidates-attended')]/span[text()='No candidates have been invited yet.']");
	private By txtZeroInvites = By.xpath("//div[*/span[text()='No candidates were invited to this test.']]/parent::div/preceding-sibling::a");
	private By txtOneInvite = By.xpath("//div[*/span[text()='1 candidate has been invited and has not taken the test.']]/parent::div/preceding-sibling::a");
	/**
	 * @author ambar.gupta
	 * This function is used to login to HackerEarth
	 *@param userName and password
	 */
	public void LoginToPartner(String userName, String password) {
		wait.waitForPageToLoadCompletely();
		sendKeys(eleUsernameHE, userName);
		sendKeys(elePasswordHE, password);
		click(eleSubmitButtonHE);
		wait.waitForPageToLoadCompletely();
	}
	
	
	/**
	 * @author ambar.gupta
	 * This function is used to click on clone button in test overview 
	 */
	public void clickOnCloneTest() {
		wait.waitForPageToLoadCompletely();
		click(eleClone);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to fill Name And Create Test
	 * @param testName
	 */
	public void fillNameAndCreateTest(String testName) {
		sendKeys(txtBoxDuplicateTestName, testName);
		click(btnCreateHE);
		wait.waitForPageToLoadCompletely();
		wait.hardWait(8);
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to go to test overview from test name
	 * @param testName
	 */
	public void goToTestURLfromName(String testName) {
		String testNameUrl = testName.replaceAll(" ", "-");
		String URL = "https://app.hackerearth.com/recruiter/"+testNameUrl+"/test-overview/";
		goToPageURL(URL);
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to delete test
	 * @param testName
	 */
	public void deleteTestfromHE(String testName) {
		wait.waitForPageToLoadCompletely();
		click(eleDelete);
		wait.waitForVisibilityOfElement(btnConfirmDeleteTest);
		click(btnConfirmDeleteTest);
		wait.waitForPageToLoadCompletely();	
		wait.hardWait(30);
	}

	/**
	 * @author ambar.gupta
	 * This function is used to click On Publish Test 
	 */
	public void clickOnPublishTest() {
		wait.waitForPageToLoadCompletely();
		click(elePublishTest);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author ambar.gupta
	 * This function is used to click On Publish Test 
	 */
	public void clickOnPublish() {
		wait.waitForPageToLoadCompletely();
		click(elePublish);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to click On Invite candidates 
	 */
	public void clickOnInvitesCandidates() {
		wait.waitForPageToLoadCompletely();
		click(btnInviteCandidates);
		wait.waitForPageToLoadCompletely();
	}


	/**
	 * @author ambar.gupta
	 * This function is used to delete test from HackerEarth
	 * @param userName, password and test name to be deleted
	 */
	public void deleteTestFromHackerEarth(String userName, String password, String testName) {
		wait.waitForPageToLoadCompletely();
		goToTestURLfromName(testName);
		wait.waitForPageToLoadCompletely();
		if(!isDisplayed(eleDelete)) {
			LoginToPartner(userName, password);
			wait.waitForPageToLoadCompletely();
		}
		click(eleDelete);
		click(btnConfirmDeleteTest);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author ambar.gupta
	 * This function is used to invite candidate for the test
	 * @param testToInvite and candidate email
	 * @return whether successfully invited or not
	 */
	public boolean inviteCandidateForTestFromHE(String testToInvite, String candidateEmail) {
		wait.waitForPageToLoadCompletely();
		click(btnInviteCandidates);
		wait.waitForPageToLoadCompletely();
		click(btnAddCandForInvite);
		sendKeys(txtBoxEmailInput, candidateEmail);
		click(btnSaveAndProceed);
		click(btnConfirmInviteCandidates);
		return getText(eleInviteSuccess).contains("1 candidate(s) successfully invited");
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to set End date as current date for a test
	 */
	public void setEndDateAndTimeAsCurrent() {
		wait.waitForPageToLoadCompletely();
		wait.hardWait(2);
		jsUtil.clickByJS(eleEditEndDate);
		jsUtil.clickByJS(eleSelectCurrentDate);
		jsUtil.clickByJS(eleSaveEndDate);
		wait.hardWait(10);
	}

	/**
	 * @author ambar.gupta
	 * This function is used to delete unused tests for HackerEarth. It is not used in daily automation
	 */
	public void deleteUnusedTests(String userName, String password) {
		goToPageURL("https://app.hackerearth.com/recruiter/all-tests/completed/");
		LoginToPartner(userName, password);
		//jsUtil.scrollDown(eleTestsWithZeroCand);
		List<WebElement> list=new ArrayList<WebElement>();
		list = getElements(txtZeroInvites);
		for(int i=0; i<list.size();i++) {
		         WebElement element = list.get(i);
		         String a=element.getAttribute("href");
		         jsUtil.executeJavascript("window.open()");
		 		switchToChildWindow();
		         goToPageURL(a);
		        wait.waitForPageToLoadCompletely();
		click(eleDelete);
		if(isDisplayed(btnConfirmDeleteTest))
		click(btnConfirmDeleteTest);
		wait.waitForPageToLoadCompletely();
		closeWindow();
		switchToParentWindow();
		}
		
		
		
	}
	
	
		}
		