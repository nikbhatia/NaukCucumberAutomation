package com.naukri.pageobjects.Assessment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;
import static com.naukri.automation.util.YamlReader.getAppConfigValue;
import java.io.File;

/**
 * 
 * @author rounak.jain
 *
 */

public class TestDetailsOnSrpAndCVDetailsPO extends BaseAutomation {
	public static By infoTuple = By.xpath("//a[text()='${linkname}']");
	public static By cvdInfoTuple = By.xpath("//a[text()='${linkname}']");
	public static By outerArrow = By.cssSelector("span.outerArow");
	public static By bulkSelectChkBox = By.xpath("//input[@class='srpTopChk fl']");
	public static By StatusChangeButton = By.xpath("//a[@id='mulipleStatusChange']");
	public static By reminderSent = By.xpath("//strong[text()='Reminder Sent']");
	public static By yesOrNo = By.xpath("(//button[text()='${YesorNo}'])[3]");
	public static By attemptthetest = By.linkText("Start Test");
	public static By filterNameAsseement = By.xpath("//a[text()='${filterName}']");
	
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);

	/**
	 * To refresh the page
	 */
	public void refreshPage() {
		pageRefresh();
	}

	/**
	 * To check the result on SRP page
	 * 
	 * @param linkname : name of the link
	 * @return If tuple displays on SRP Page displayed
	 */
	public boolean checkTupleSRP(String linkname) {
		API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(infoTuple, linkname), 4);
		return getElement(infoTuple, linkname).isDisplayed();
	}

	/**
	 * To click on Tuples on SRP
	 * 
	 * @param linkname: name of the link
	 */
	public void clickLinkonTupleOnSRP(String linkname) {
		API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(infoTuple, linkname), 4);
		wait.hardWait(3);
		jsUtil.clickByJS(parameterizedLocator(infoTuple, linkname));
	}

	/**
	 * TO check the tuples on SRP page
	 * 
	 * @param linkname: name of the link
	 * @param candidateName : name of the candidate
	 * @return If tuple displays on CV Details Page displayed
	 */
	public boolean checkTupleCV(String linkname, String candidateName) {
		pageRefresh();
		return getElement(infoTuple, linkname.trim()).isDisplayed();
	}

	/**
	 * To navigate on SRP Page
	 */

	public void navigateToSrpPage() {
		String appUrl = getAppConfigValue("URLs.appURL");
		final String reqId = PropFileHandler.readProperty("reqId");
		driver.get(appUrl + "/profile/project/inbox/" + reqId);
		wait.waitForPageToLoadCompletely();
		API.refreshPageAndCheckElementIsDisplayed(outerArrow, 5);
	}

	/**
	 * To navigate on CV details page of a candidate
	 */
	public void navigateToCVDetailsPage() {
		String appUrl = getAppConfigValue("URLs.appURL");
		final String candidateId = PropFileHandler.readProperty("candidateId");
		driver.get(appUrl + "/application/viewApplication/" + candidateId);
	}

	/**
	 * To click on the Status DD
	 * 
	 * @param status : Status name
	 */
	public void statusChangeDD(String status) {
		API.refreshPageAndCheckElementIsDisplayed(outerArrow, 5);
		getElement(outerArrow).click();
//		getElement(statusName, status).click();		
		getElement((By.xpath("//a[text()='" + status + "']/span[contains(text(),'- Matching')]"))).click();
	}

	/**
	 * To click on the reminder response
	 * 
	 * @param resYesOrNo : Response of Pop up
	 */
	public void selectResponseSendReminder(String resYesOrNo) {
		getElement(yesOrNo, resYesOrNo).click();
	}

	/**
	 * 
	 * To verify the Reminder sent link on SRP
	* @return It will return the status of reminder sent tuple on SRP Page
	 */

	public boolean VerifyReminderSentLink() {
		return getElement(reminderSent).isDisplayed();
	}

	/**
	 * To launch the test
	 */

	public void launchTest(String content) {
		String StorageFileLocation = System.getProperty("user.dir") + File.separator + "assessmentTest.html";
		TestNGLogUtility.info("Test URL: "+StorageFileLocation);
		String osName = System.getProperty("os.name");
		TestNGLogUtility.info("OS Name: "+osName);
		TestNGLogUtility.info(content);
		if(osName.toLowerCase().contains("win"))
			goToPageURL("file:\\"+StorageFileLocation);
		else
			goToPageURL("data:text/html;charset=utf-8," + content);
		click(attemptthetest);
		switchToChildWindow();
		closeParentMoveToChild();
	}
}
