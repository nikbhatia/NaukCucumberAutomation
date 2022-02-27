package com.naukri.pageobjects.Assessment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * 
 * @author rounak.jain
 *
 */
public class AttachTestCandidatePO extends BaseAutomation {

	private final By TestStartBtn = By.xpath("//input[@value='Start Test']");
	private final By endTestBtn = By.xpath("//a[text()='End Test']");
	private final By endTestBTnConfirmation = By.xpath("(//a[text()='Yes'])[1]");
	private final By ResultStatusOnSrp = By
			.xpath("//div[@class='mt5']//strong[contains(text(),'Result:')]/following-sibling::span[2]");
	private final By ScoreStatusOnSrp = By
			.xpath("//div[@class='mt5']//strong[contains(text(),'Score:')]/following-sibling::span[2]");
	private final By DateStatusOnSrp = By.xpath("//div[@class='cle testTpl']//strong[2]");
	private final By eleSRPTupleTestName = By.xpath("(//div[@class='cle testTpl']//strong)[1]");
	private final By eleSRPTupleTestompletedOn = By.xpath("(//div[@class='cle testTpl']//strong)[2]");
	private final By eleCheckBoxHE = By.className("terms-checkbox");
	private final By chkboxCodility = By.xpath("//input[@id='agree-tos']/following-sibling::span");
	private final By btnStartTheTest = By.xpath("//button[contains(text(),'Start the test')]");
	private final By btnSkipTheTour = By.xpath("//button[contains(text(),'Skip this tour')]");
	private final By btnLetsStart = By.xpath("//button[contains(text(),'Let’s start')]");
	private final By btnSubmitCodility = By.id("submit-button");
	private final By btnConfirmSubmitCodility = By.xpath("//button[text()='Submit']");
	private final By btnSkipCodility = By.xpath("//button[text()='Skip']");
	private final By txtTestCompletedCodility = By.xpath("//*[contains(text(),'Thank you for completing your test!')]]");
	private final By eleEnterTestHE = By.xpath("//button[contains(text(),'Enter Test')]");
	private final By eleSubmitAndProceedHE = By.xpath("//button[contains(text(),'Submit and Proceed')]");
	private final By eleStartTestHE = By.id("show_problems_btn");
	private final By eleEndTestHE = By.xpath("//button[contains(text(),'End test')]");
	private final By eleConfirmEndTestHE = By.xpath("//div[contains(text(),'End test')]");
	private final By eleSubmitHE = By.xpath("//input[@type='submit']");
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);

	/**
	 * @author ambar.gupta 
	 * To attempt tests of various partners
	 * @param partnerName
	 */
	public void attemptTest(String partnerName) {
		
		switch (partnerName) {
		case "Naukri Assessments":
			API.refreshPageAndCheckElementIsDisplayed(TestStartBtn, 2);
			click(TestStartBtn);
			wait.waitForPageToLoadCompletely();
			wait.hardWait(2);
			click(endTestBtn);
			click(endTestBTnConfirmation);
			wait.waitForPageToLoadCompletely();
			break;
		case "HackerEarth":
			click(eleCheckBoxHE);
			click(eleEnterTestHE);
			click(eleSubmitAndProceedHE);
			wait.hardWait(60);
			click(eleStartTestHE);
			wait.waitForPageToLoadCompletely();
			click(eleEndTestHE);
			click(eleConfirmEndTestHE);
			wait.waitForPageToLoadCompletely();
			click(eleSubmitHE);
			break;
		case "Codility":
			click(chkboxCodility);
			click(btnStartTheTest);
			click(btnSkipTheTour);
			wait.hardWait(2);
			click(btnLetsStart);
			wait.hardWait(5);
			click(btnSubmitCodility);
			click(btnConfirmSubmitCodility);
			click(btnConfirmSubmitCodility);
			click(btnSkipCodility);

		default:
			break;
		}

	}

	/**
	 * To verify the result from SRP page
	 * 
	 * @return : if result exist
	 */
	public boolean verifyResultsOnSrp() {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		String testName = getText(eleSRPTupleTestName);
		String testCompletedOn = getText(eleSRPTupleTestompletedOn);
		String TestCompleteTuple = testName + " " + testCompletedOn;
		TestNGLogUtility.info(TestCompleteTuple + "Full tuple");
		String dateDisplayedOnSRP = getText(DateStatusOnSrp);
		Date newDate = new Date();
		String strDateFormat = "dd-MMMM-yyyy";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(newDate);
		String ExpectedDate = formattedDate.replaceAll("-", " ");
		API.refreshPageAndCheckElementIsDisplayed(ResultStatusOnSrp, 3);
		jsUtil.scrollDown(ResultStatusOnSrp);
		String FailedResult = getText(ResultStatusOnSrp);
		String ScoreOnSrp = getText(ScoreStatusOnSrp);
        TestNGLogUtility.info(FailedResult + " " + ScoreOnSrp +" "+ dateDisplayedOnSRP + " "+ExpectedDate );
        if (FailedResult.contains("Failed") && ScoreOnSrp.contains("0%")) {
			return true;
		} else
			return false;
	}

}
