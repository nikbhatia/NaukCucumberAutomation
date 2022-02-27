package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.test.base.BaseAutomation;

public class ManageApprovalProcessPO extends BaseAutomation {

	/**
	 * @author jatin.bisht
	 */

	private By txtApprovalName = By.xpath("//input[@placeholder[contains(.,'workflow')]]");
	private By txt1StageName = By.xpath("//input[@placeholder[contains(.,'stage')]]");
	private By txt2StageName = By.xpath("(//input[@placeholder[contains(.,'stage')]])[2]");
	private By txt1ApproverId = By.xpath("//span[contains(text(),'email Ids')]");
	private By txt2ApproverId = By.xpath("(//span[contains(text(),'email Ids')])[2]");
	private By chkApproverId = By.xpath("(//ul/li/span)[1]");
	private By lblApprovalProcessName = By.xpath("//*[text()='${approvalName}']");
	private By ddRequisitionApproval = By.xpath("(//span[text()='DownArrow'])[1]");
	private By ddOfferApproval = By.xpath("(//span[text()='DownArrow'])[2]");
	private By chkSelectGroup = By.xpath("(//label[contains(text(),'Group')])[1]");
	private By chkEveryoneAppMandatory = By.xpath("(//label[contains(text(),'Approval Mandatory')])");
	private By btnAddApprovalStage = By.xpath("//span[text()='ADD APPROVAL STAGE']");
	private By inpPrefillApprovalProcess = By.id("prefill_inputBox");
	private By eleSelectApprovalProcess = By.xpath("(//div[@class='searchSuggestionTuple'])[1]");
	private By btnBackArrow = By.xpath("//div[@class='btnBack']");
	private By liSecondPage = By.xpath("(//ul[@class='buttonCont']/li)[2]");
	private By inpSearchbarApporval = By.xpath("//input[contains(@placeholder,'Search by Processes')]");
	private By btnSearch = By.id("searchIcon");

	/**
	 * @author jatin.bisht This method generate random name and fill it in Approval
	 *         process name
	 */
	public void fillApprovalProcessName(String approvalName) {
		sendKeys(txtApprovalName, approvalName);
	}

	/**
	 * @author jatin.bisht This method fills only mandatory fields of Approval
	 *         process
	 */
	public void fillMandatoryFieldsOfApprovalProcess() {
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollDown(txt1StageName);
		sendKeys(txt1StageName, "first stage");
		jsUtil.scrollDown(txt1ApproverId);
		getElement(txt1ApproverId).click();
		getElement(chkApproverId).click();
	}

	/**
	 * @author jatin.bisht This method verifies the new created approval process is
	 *         visible or not
	 * @return
	 */
	public boolean verifyApprovalProcessAdded(String approvalName) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblApprovalProcessName, approvalName));
	}

	/**
	 * @author jatin.bisht This method fill all details for crreating approval
	 *         process like select group from requisition,offer approval add another
	 *         stage for approvers
	 */
	public void fillAllDetailsOfApprovalProcess() {
		getElement(ddRequisitionApproval).click();
		getElement(chkSelectGroup).click();
		getElement(ddRequisitionApproval).click();
		getElement(ddOfferApproval).click();
		getElement(chkSelectGroup).click();
		getElement(ddOfferApproval).click();
		sendKeys(txt1StageName, "first stage");
		jsUtil.scrollDown(txt1ApproverId);
		getElement(txt1ApproverId).click();
		getElement(chkApproverId).click();
		getElement(chkEveryoneAppMandatory).click();
		getElement(btnAddApprovalStage).click();
		sendKeys(txt2StageName, "Second stage");
		getElement(txt2ApproverId).click();
		getElement(chkApproverId).click();
	}

	/**
	 * @author jatin.bisht This method select group for requisition approval and
	 *         prefill approvers from existing approval process
	 */
	public void prefillFromExistingApprovalProcess() {
		getElement(ddRequisitionApproval).click();
		getElement(chkSelectGroup).click();
		getElement(ddRequisitionApproval).click();
		sendKeys(inpPrefillApprovalProcess, "a");
		wait.waitForPageToLoadCompletely();
		getElement(eleSelectApprovalProcess).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author jatin.bisht This method click on BackArrow or Back Button visible on
	 *         add new apporval process page
	 */
	public void clickOnBackArrow() {
		getElement(btnBackArrow).click();
	}

	/**
	 * @author jatin.bisht This method goes to second page then enter approval
	 *         process on searchbar and click on search icon
	 * @param approvalName
	 */
	public void enterApprovalProcessClickOnSearchbar(String approvalName) {
		getElement(liSecondPage).click();
		wait.waitForPageToLoadCompletely();
		sendKeys(inpSearchbarApporval, approvalName);
		wait.waitForPageToLoadCompletely();
		getElement(btnSearch).click();
	}

}
