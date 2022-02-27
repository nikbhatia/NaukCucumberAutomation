package com.naukri.pageobjects.HiringManager;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.naukri.test.base.BaseAutomation;

public class AllRequisitionPagePO extends BaseAutomation {

	Actions action = new Actions(driver);
	RaiseRequisitionPagePO RaiseRequisitionPagePOObject = new RaiseRequisitionPagePO();
	By weReqReadyForCreation = By.xpath("//div[contains(text(),'Ready for Creation')]");
	By weReqAwaitingOthersApproval = By.xpath("//div[contains(text(),'Others Approval')]");
	By weReqRaisedByYou = By.xpath("//div[contains(text(),'Raised by You')]");
	By weReqAwaitingYourApproval = By.xpath("//div[contains(text(),'Requisitions Awaiting Your Approval')]");
	By weAllOtherReq = By.xpath("//div[contains(text(),'Other Requisitions')]");
	By weReqActionedByYou = By.xpath("//div[contains(text(),'Actioned by You')]");
	By txtAddComment = By.xpath("//textarea[@class='commentInputBox']");
	By btnAddComment = By.xpath("//input[@value='Add Comment']");
	By addCommentBtn = By.xpath("//div[contains(text(),'${helpText}')]/../../..//li[contains(text(),'Comment')]");
	By txtTopComment = By.xpath("(//div[@class='commentBody'])[1]");
	By txtTopCommentOnOverview = By.xpath("(//li[@class='cl_list-item']//p)[1]");
	By btnRaiseRequisition = By.xpath("//input[contains(@value,'Raise a Requisition')]");
	By txtReqCreationSuccessMsg = By.xpath("//div[@class='msg']");
	By txtSelectedReqTypeCount = By.xpath("//li[@class='tabBlockLI selected']//div[@class='countDiv']");
	By btnReinitiateRequisition = By.xpath("//input[@id='buttonID']");
	By btnAddRequirement = By.xpath("//input[@id='buttonID']");
	By txtAreaSearchRequisition = By.xpath("//input[@class='textBox']");
	By btnCreateRequirement = By.xpath("//div[text()='${reqName}']/../../..//a[text()='Create Requirement']");
	By txtAllComment = By.xpath("//div[@class='commentBody']");
	By btnApproveRequisition = By.xpath("//div[contains(text(),'${requisitionName}')]/../../..//li[@class='Approve']");
	By btnReInitiateRequisition = By.xpath("//div[contains(text(),'${requisitionName}')]/../../..//a[@class='Re-initiate']");
	By btnRejectRequisition = By.xpath("//div[contains(text(),'${requisitionName}')]/../../..//li[@class='Reject']");
	By txtStatusOfRequisition = By.xpath("(//div[contains(text(),'${reqName}')]/../../../..//div[contains(@class,'statusDiv')])[1]");
	By lnkRequisitionName = By.xpath("//div[text()='${string}']");
	By txtRaiseRequisitionCommentOnLB = By.xpath("//span[text()='Other information:']//following-sibling::span");
	By txtReqId = By.xpath("//div[text()='${reqName}']/../..//div[@class='reqIDSec']");
	By requisitionName = By.xpath("//div[contains(@class,'processName')and text()='${value}']/parent::a");
	By txtReqName = By.xpath("//div[text()='${reqName}']");
	By btnUnderRequirementName = By.xpath("//div[text()='${reqName}']/../../..//a[text()='${btnName}']");
	By btnWithdraw = By.xpath("//div[contains(text(),'${helpText}')]/../../..//li[text()='Withdraw']");
	By eleWithdrawLB = By.xpath("//div[contains(@class,'ConfirmationBox')]");
	By txtWithdrawLBHeader = By.xpath("//div[contains(@class,'ConfirmationBox')]//child::span[contains(@class,'confTitle')]");
	By txtWithdrawLBBody = By.xpath("//div[contains(@class,'ConfirmationBox')]//child::p[contains(@class,'confDesc')]");
	By btnWithdarawLBYes = By.xpath("//div[contains(@class,'ConfirmationBox')]//child::button[contains(@class,'yes')]");
	By btnWithdarawLBNo = By.xpath("//div[contains(@class,'ConfirmationBox')]//child::button[contains(@class,'no')]");
	By iconWithdrawLBCross = By.xpath("//div[contains(@class,'ConfirmationBox')]//child::span[contains(@class,'confCancel')]");
	List<String> allComments = new ArrayList<String>();
	By btnCommentOnOverview = By.xpath("//div[@class='tn_nav-item ']");
	By btnAddCommentOnOverview = By.className("commentBtn");
	By txtRequisitionComment = By.id("requisition-comments");

	
	/**
	 * This method checks whether Add comment button is displayed for raised
	 * requisition.
	 * @author gupta.mansi
	 * @param Requisition Name
	 */
	public void isAddCommentBtnIsDisplayedForGivenReq(String reqName) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		isDisplayed(parameterizedLocator(addCommentBtn, reqName));
	}
	
	/**
	 * This method is used to click on given requisition name
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void clickOnRequisitionName(String reqName)
	{
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(lnkRequisitionName,reqName));
		getElement(lnkRequisitionName,reqName).click();
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to add comment by HM Spoc for requisition raised by him
	 * @param reqName
	 *            -- Name of requisition for which we have to add comment
	 * @comment --- Comment to add
	 * @author gupta.mansi
	 */
	public void addCommentForRequisitionByHMSpoc(String reqName, String comment) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(weReqRaisedByYou);
		click(weReqRaisedByYou);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		getElement(addCommentBtn, reqName).click();
		wait.waitForElementToBeClickable(txtAddComment);
		click(txtAddComment);
		getElement(txtAddComment, reqName).sendKeys(comment);
		wait.waitForElementToBeClickable(parameterizedLocator(btnAddComment, reqName));
		getElement(btnAddComment, reqName).click();
		wait.hardWait(1);
		driver.navigate().to(getCurrentURL());
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(weReqRaisedByYou);
		click(weReqRaisedByYou);
		wait.waitForPageToLoadCompletely();

	}

	/**
	 * This method is used to add comment by HR Spoc for requisitions ready for
	 * creation who don't have approval process
	 * @author gupta.mansi
	 * @param reqName
	 * @param comment
	 */
	public void addCommentForRequisitionWithNoApprovalByHRSopc(String reqName, String comment) {
		click(weReqReadyForCreation);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		getElement(addCommentBtn, reqName).click();
		wait.waitForElementToBeClickable(txtAddComment);
		getElement(txtAddComment).sendKeys(comment);
		click(btnAddComment);
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		wait.waitForPageToLoadCompletely();

	}
	public void addCommentOnOverviewPage(String reqName, String comment)
	{
		switchToChildWindow();
		click(btnCommentOnOverview);
		click(txtRequisitionComment);
		sendKeys(txtRequisitionComment,comment);
		click(btnAddCommentOnOverview);
	}

	/**
	 * This method is used to add comment by HR Spoc for requisition who have
	 * approval process but not approved
	 * @author gupta.mansi
	 * @param reqName
	 * @param comment
	 */
	public void addCommentForRequisitionWithApprovalPendingByHRSpoc(String reqName, String comment) {
		wait.waitForPageToLoadCompletely();
		click(weReqAwaitingOthersApproval);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		getElement(addCommentBtn, reqName).click();
		wait.waitForElementToBeClickable(txtAddComment);
		getElement(txtAddComment).sendKeys(comment);
		click(btnAddComment);
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		wait.waitForPageToLoadCompletely();

	}

	/**
	 * This method is used to add comment for requisition pending approval by
	 * approver
	 * @param reqName
	 * @param comment
	 * @author gupta.mansi
	 */
	public void addCommentForRequisitionPendingApprovalByApprover(String reqName, String comment) {
		wait.waitForPageToLoadCompletely();
		click(weReqAwaitingYourApproval);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		getElement(addCommentBtn, reqName).click();
		wait.waitForElementToBeClickable(txtAddComment);
		getElement(txtAddComment).sendKeys(comment);
		click(btnAddComment);
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		wait.waitForPageToLoadCompletely();

	}

	/**
	 * This method is used to get top comment for HM Spoc
	 * @param reqName
	 * @return
	 * @author gupta.mansi
	 */
	public String getTopCommentForHMSpoc(String reqName) {
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		action.moveToElement(getElement(addCommentBtn, reqName)).click().build().perform();
		// click(parameterizedLocator(addCommentBtn, reqName));
		// getElement(addCommentBtn,reqName).click();
		wait.waitForVisibilityOfElement(txtTopComment);
		return getText(txtTopComment);
	}
	public boolean verifyCommentOnPage(String comment)
	{
		return getText(txtTopCommentOnOverview).contains(comment);
	}

	/**
	 * This method is used to get top comment of requisition with no approval
	 * process for HR Spoc
	 * @param reqName
	 * @return
	 * @author gupta.mansi
	 */
	public String getTopCommentForHRSpocWithNoApprovalPending(String reqName) {
		jsUtil.scrollDown(txtTopComment);
		return getText(txtTopComment);
	}

	/**
	 * This method is used to go on the given requisition state section Requisition
	 * state can be -- Requisitions Awaiting Your Approval, Requisitions Ready for
	 * Creation, Requisitions Raised by You Requisitions Awaiting Others Approval
	 * and All Other Requisitions
	 * @param reqState
	 * @author gupta.mansi
	 */
	public void gotoGivenReqState(String reqState) {
		wait.waitForPageToLoadCompletely();
		switch (reqState) {
		case "Requisitions Awaiting Your Approval":
			wait.waitForElementToBeClickable(weReqAwaitingYourApproval);
			click(weReqAwaitingYourApproval);
			break;
		case "Requisitions Ready for Creation":
			wait.waitForElementToBeClickable(weReqReadyForCreation);
			//click(weReqReadyForCreation);
			getElement(weReqReadyForCreation).click();
			break;
		case "Requisitions Raised by You":
			wait.waitForElementToBeClickable(weReqRaisedByYou);
			click(weReqRaisedByYou);
			break;
		case "Requisitions Awaiting Others Approval":
			wait.waitForElementToBeClickable(weReqAwaitingOthersApproval);
			click(weReqAwaitingOthersApproval);
			break;
		case "All Other Requisitions":
			wait.waitForElementToBeClickable(weAllOtherReq);
			click(weAllOtherReq);
			break;

		}
	}

	/**
	 * This method is used to get the status of Raised Requisition
	 * @param reqName
	 * @return This method returns status of Requisition which can be -- Approval
	 *         Pending, Open, Approval Completed, Pending For Requirement Withdrawn
	 *         and Approval Rejected
	 * @author gupta.mansi
	 */
	public String getStatusOfRequisition(String reqName) {
		wait.waitForPageToLoadCompletely();
		wait.hardWait(2);
		return getText(parameterizedLocator(txtStatusOfRequisition, reqName));
	}

	/**
	 * This method is used to click add comment button for requisition which are
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void clickAddCommentBtnForRequisitionReadyForCreation(String reqName) {
		wait.waitForElementToBeClickable(weReqReadyForCreation);
		click(weReqReadyForCreation);
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		getElement(addCommentBtn, reqName).click();
	}
	public void clickCommentSRaisedRequisitionOverviewPage()
	{
		switchToChildWindow();
		click(btnCommentOnOverview);
	}

	/**
	 * This method is used to click add comment for requisition pending approval
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void clickAddCommentForRequisitionPendingApproval(String reqName) {
		click(weReqAwaitingOthersApproval);
		wait.waitForElementToBeClickable(parameterizedLocator(addCommentBtn, reqName));
		getElement(addCommentBtn, reqName).click();
	}

	/**
	 * This method is used to click on given type of tab for requisition like
	 * requisition ready for creation etc
	 * @param status
	 * @param user
	 * @author gupta.mansi
	 */
	public void clickOnSection(String status, String user) {
		switch (user) {
		case "Approver":
			switch (status) {
			case "Approval Pending":
				click(weReqAwaitingYourApproval);
				break;
			case "Open":
				click(weAllOtherReq);
				break;
			case "Withdrawn":
				click(weAllOtherReq);
				break;
			case "Approval Completed":
				click(weAllOtherReq);
				break;
			}
			break;
		case "HRSpoc":
			switch (status) {
			case "Approval Completed":
				click(weReqReadyForCreation);
				break;
			case "Pending For Requirement":
				click(weReqReadyForCreation);
				break;
			case "Approval Pending":
				click(weReqAwaitingOthersApproval);
				break;
			case "Open":
				click(weAllOtherReq);
				break;
			case "Withdrawn":
				click(weAllOtherReq);
				break;
			}
			break;
		}

	}

	/**
	 * This method is used used to click raise requisition button
	 * @author gupta.mansi
	 */
	public void clickRaiseRequisitionButton() {
		click(btnRaiseRequisition);
	}

	/**
	 * This method is used to get requisition creation success message 
	 * @return text displayed in String 
	 * @author gupta.mansi
	 */
	public String getReqCreationSuccessMsg() {
		wait.waitForPageToLoadCompletely();
		return getText(txtReqCreationSuccessMsg);
	}

	/**
	 * This method is used get count of requisition raised by you
	 * @return count of requisition raised by you
	 * @author gupta.mansi
	 */
	public String getReqRaisedByYouCount() {
		click(weReqRaisedByYou);
		wait.hardWait(1);
		return getText(txtSelectedReqTypeCount);
	}

	/**
	 * This method is used to get count of requisition ready for creation
	 * @return count of requisition ready for creation
	 * @author gupta.mansi
	 */
	public String getReqReadyForCreationCount() {
		click(weReqReadyForCreation);
		wait.hardWait(1);
		return getText(txtSelectedReqTypeCount);
	}

	/**
	 * This method is used to approve requisition awaiting your approval
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void approveRequisitionAwaitingYourApproval(String reqName) {
		click(weReqAwaitingYourApproval);
		wait.waitForElementToBeClickable(parameterizedLocator(btnApproveRequisition, reqName));
		getElement(btnApproveRequisition, reqName).click();
		wait.hardWait(2);
	}

	/**
	 * This method is used to reject requisition awaiting your approval
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void rejectRequisitionAwaitingYourApproval(String reqName) {
		click(weReqAwaitingYourApproval);
		wait.waitForElementToBeClickable(parameterizedLocator(btnRejectRequisition, reqName));
		getElement(btnRejectRequisition, reqName).click();
		wait.hardWait(2);
	}

	/**
	 * This method is used to click re-initiate requisition button for given
	 * requisition
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void clickReinitiateRaisedReq(String reqName) {
		click(weReqRaisedByYou);
		getElement(btnReInitiateRequisition, reqName).click();
	}

	/**
	 * This method is used to re-initiate requisition
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void reinitiateReq(String reqName) {
		clickReinitiateRaisedReq(reqName);
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(btnReinitiateRequisition);
		wait.waitForElementToBeClickable(btnReinitiateRequisition);
		click(btnReinitiateRequisition);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to get comment count of raised requisition 
	 * @param reqName
	 * @return
	 * @author gupta.mansi
	 */
	public int getCommentCountOfRaisedReqForHMSpoc(String reqName) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(weReqRaisedByYou);
		click(weReqRaisedByYou);
		String[] commentCount = getText(parameterizedLocator(addCommentBtn, reqName)).split(" ");
		return Integer.parseInt(commentCount[0]);
	}

	/**
	 * This method is used to get all comment count for hmspoc
	 * @param reqName
	 * @return
	 * @author gupta.mansi
	 */
	public List<String> getAllCommentOfRaisedReqForHMSpoc(String reqName) {
		click(weReqRaisedByYou);
		getElement(addCommentBtn, reqName).click();
		List<WebElement> weComments = getElements(txtAllComment);
		for (WebElement i : weComments) {
			allComments.add(getText(i));
		}

		return allComments;
	}

	/**
	 * This method clicks on create requirement button for given requirement
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void clickCreateRequirementBtnForRequisition(String reqName) {
		click(weReqReadyForCreation);
		wait.waitForVisibilityOfElement(parameterizedLocator(btnCreateRequirement, reqName));
		getElement(btnCreateRequirement, reqName).click();
	}

	/**
	 * This method is used to create requirement from requisition 
	 * @param reqName
	 */
	public void createRequirementFromRequisition(String reqName) {
		clickCreateRequirementBtnForRequisition(reqName);
		switchToChildWindow();
		click(btnAddRequirement);
	}

	/**
	 * This method is used to search requisition by requisition name
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void searchRequisition(String reqName) {
		getElement(txtAreaSearchRequisition).sendKeys(reqName);
		getElement(txtAreaSearchRequisition).sendKeys(Keys.ENTER);

	}
	
	/**
	 * This method is used to get comment which was added on raise requisition page while raising requisition 
	 * @return comment
	 */
	public String getRaiseRequisitionComment()
	{
		return getText(txtRaiseRequisitionCommentOnLB);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to get the requisition id from requisition listing page for given requirement name
	 * @param reqName
	 * @return {String} requisition id
	 */
	public String getReqId(String reqName)
	{
		return getText(parameterizedLocator(txtReqId, reqName));
	}
	/**
	 * This method is used to open requisition 
	 * @param reqName
	 */
	public void clickOnRequisition(String reqName) {
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(requisitionName, reqName));
		switchToChildWindow();
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if button is present below requirement name
	 * @param reqName and btnName
	 * @return true if button is present below requirement name
	 */
	public boolean isButtonDisplayedForRequirement(String reqName,String btnName)
	{
		return isDisplayed(parameterizedLocator(btnUnderRequirementName,reqName,btnName));
		
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true if requisition name is displayed
	 * @param reqName
	 * @return true if requisition name is displayed else false
	 */
	public boolean isRequisitionNameDisplayed(String reqName)
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(txtReqName, reqName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method click on withdraw button for given Requirement name
	 * @param reqName
	 */
	public void clickOnWithdraw(String reqName)
	{
		click(parameterizedLocator(btnWithdraw, reqName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given button from withdraw lightbox
	 * @param button name
	 */
	public void clickOnButtonOnWithdrawLB(String button)
	{
		switch(button)
		{
			case "YES":
				click(btnWithdarawLBYes);
				wait.waitForPageToLoadCompletely();
				break;
			case "NO":
				click(btnWithdarawLBNo);
				wait.waitForPageToLoadCompletely();
				break;
			case "✕":
				click(iconWithdrawLBCross);
				wait.waitForPageToLoadCompletely();
				break;
		}
	}
	
	/**
	 * @author gupta.mansi
	 * This method return 
	 * @param placement
	 * @return
	 */
	public String getTextFromWithdrawLB(String placement)
	{
		String flag = null;
		switch(placement)
		{
			case "Header":
				flag = getText(txtWithdrawLBHeader);
				break;
			case "Body":
				flag = getText(txtWithdrawLBBody);
				break;
		}
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true when given Button is displayed on withdraw LB
	 * @param buttonName
	 * @return
	 */
	public boolean isButtonDisplayedInWithdrawLB(String buttonName)
	{
		boolean flag = false;
		switch(buttonName)
		{
			case "YES":
				flag = isDisplayed(btnWithdarawLBYes);
				break;
			case "NO":
				flag = isDisplayed(btnWithdarawLBNo);
				break;
			case "✕":
				flag = isDisplayed(iconWithdrawLBCross);
				break;
		}
		return flag;
	}
}
