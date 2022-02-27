package com.naukri.pageobjects.MLH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.interactions.MouseMoveToLocation;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.test.base.BaseAutomation;

public class MLHRequirementListingPagePO extends BaseAutomation {

	// locators
	By txtPageTitle = By.xpath("//title");
	By ddReqStatus = By.xpath("//input[@id='inp_reqStatus']");
	By ddRecruiter = By.xpath("//div[@id='mlhDD']");
	By ddSource = By.xpath("//input[@id='inp_reqSource']");
	By ddReqFilter = By.xpath("//a[@id='refine_project']");
	By btnCloseSelectedReq = By.xpath("//form[@name='paging']//a[contains(@class,'close')]");
	By btnSearchSelectedReq = By.xpath("//input[@id='searchSelectedReq']");
	By btnCloseReqFilter = By.xpath("//a[@id='reqStatus_4']");
	By btnOnHoldReqFilter = By.xpath("//a[@id='reqStatus_6']");
	By btnOpenReqFilter = By.xpath("//a[contains(@id,'reqStatus_1')]");
	By txtAreaSearchRecruiter = By.xpath("//input[@class='treeDD_serachInput']");
	By txtAreaComment = By.xpath("//textarea[@id='commentsTextArea']");
	By txtAreaQuickSearchRequirement = By.xpath("//input[@id='keywords']");
	By btnReqComment = By.xpath("//a[@title='${reqName}']/../..//a[contains(@id,'comntOuter')]");
	By btnAddComment = By.xpath("//a[text()='Add Comment']");
	By chkBoxReq = By.xpath("//a[@title='${reqName}']/../../..//input[contains(@id,'chk_')]");
	By lblGetViewOnly = By.xpath("//a[@title='${reqName}']/../..//span[text()='View Only']");
	By ddSearch = By.xpath("//input[@id='chk_${reqId}']//parent::div//a[text()='Search']//small[contains(@class,'dropArrow ')]");
	By btnSearchMyDatabase = By.xpath("//a[text()='${reqName}']/../..//a[text()='My Database']");
	By btnSearchType = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='${srcType}']");
	By lblGetNumberOfApplications = By.xpath("//em[@id='appCount${reqId}']");
	By iconGraphIc = By.xpath("//input[@id='chk_${reqId}']//parent::div//a[@class='graphIc ']");
	By lblRequirementTitle = By.xpath("//a[text()='${requirementTitle}']");
	By lblModify = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Modify']");
	By lnkEditUnderModify = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Modify']//following-sibling::ul//a[text()='Edit']");
	By lnkCloseUnderModify = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Modify']//following-sibling::ul//a[text()='Close']");
	By lnkPostUnderModify = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Modify']//following-sibling::ul//a[text()='Post']");
	By lblSearch = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Search']");
	By lnkResdexUnderSearch = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Search']//following-sibling::ul//a[text()='Resdex']");
	By lnkMyDatabaseUnderSearch = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='Search']//following-sibling::ul//a[text()='My Database']");
	By lblRequirementStatus = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='${reqStatus}']");
	By btnChangeRequirementStatus = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='${fromStatus}']//following-sibling::ul//a[text()='${toStatus}']");
	By lblMoreActions = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='More Actions ']");
	By linkEditUnderMoreActions = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='More Actions ']//following-sibling::ul//a[text()='Edit']");
	By lnkAddSingleProfileUnderMoreActions = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='More Actions ']//following-sibling::ul//a[text()='Add Single Profile']");
	By lnkDownloadByIndexUnderMoreActions = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='More Actions ']//following-sibling::ul//a[text()='Download By Index']");
	By lnkAssignVendorUnderMoreActions = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='More Actions ']//following-sibling::ul//a[text()='Assign Vendor']");
	By lnkGetApplyLinkUnderMoreActions = By.xpath("//a[contains(text(),'${reqName}')]/../..//a[text()='More Actions ']//following-sibling::ul//a[text()='Get Apply Link']");
	By lblGetCommentCount = By.xpath("//a[contains(text(),'${reqName}')]/../../ul//span[contains(@id,'commentCountDisplay_')]");
	By lblFilterBy = By.xpath("//div[@class='reqLisitngFilterText']");
	By lblSelectedReqStatus = By.xpath("//li[contains(@class,'pickVal')]//a[@class='chkd']");
	By weDefaultReqSource = By.xpath("//input[@id='hid_reqSource']");
	By weSourcesList = By.xpath("(//ul[@id='ul_reqSource']//li)[${count}]");
	By weStatusList = By.xpath("(//ul[@id='ul_reqStatus']//li)[${count}]");
	By txtTopCommentOfReq = By.xpath("((//li[contains(@class,'element-box-bb')])[1]//p)[2]");
	By btnDltTopComment = By.xpath("(//li[contains(@class,'element-box-bb')])[1]//a");
	By lblErrorMsg = By.xpath("//span[text()=' ${errorMsg}']");
	By btnCloseReqPopup = By.xpath("//input[@id='CloseSingle']");
	By lnkTopRequirement = By.xpath("(//ul[@id='ques_list']//li//div//div//div)[1]//a");
	By ddStatusChange = By.xpath("//a[contains(text(),'${reqName}')]/../..//*[text()='${status}']//small");
	By txtStatusReq = By.xpath("//a[contains(text(),'${reqName}')]/../..//*[text()='${status}']");
	By txtCloseUnderStatusChang = By.xpath("(//a[contains(text(),'${reqName}')]/../..//*[text()='Close'])[2]");

	// All Job Sources
	String[] allSources = PropFileHandler.readProperty("allSources").split(",");
	List<String> expectedSourceList = Arrays.asList(allSources);
	List<String> actualSourceList = new ArrayList<String>();

	// All Requirement Status
	String[] allStatus = PropFileHandler.readProperty("allStatus").split(",");
	List<String> expectedStatus = Arrays.asList(allStatus);
	List<String> actualStatus = new ArrayList<String>();

	/**
	 * This method is used to click on top requirement name to go requirement
	 * overview page from All Requirement Listing page And to switch to Requirement
	 * Overview page
	 * @author gupta.mansi
	 */
	public void clickTopRequirementName() {
		wait.waitForElementToBeClickable(lnkTopRequirement);
		click(lnkTopRequirement);
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to get the names of all the jobs source in a list
	 * @author gupta.mansi
	 */
	public void actualJobSourceList() {
		for (int count = 1; count <= allSources.length; count++) {
			actualSourceList.add(getText(getElement(weSourcesList, String.valueOf(count))));
		}
	}

	/**
	 * This method is used to check whether all the job sources are present or not
	 * in drop down
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean jobSourceDisplayed() {
		actualJobSourceList();
		if (actualSourceList.isEmpty())
			return false;
		else if (actualSourceList.size() != expectedSourceList.size())
			return false;
		else
			return actualSourceList.containsAll(expectedSourceList);

	}

	/**
	 * This method is used to check whether filter by label is displayed or not
	 * @return String label Displayed
	 * @author gupta.mansi
	 */
	public String isFilterByLabelDisplayed() {
		wait.waitForPageToLoadCompletely();
		return getText(lblFilterBy);
	}

	/**
	 * This method is used to get the text of default selected requirement status
	 * @return String Default Selected Status
	 * @author gupta.mansi
	 */
	public String defaultStatusSelected() {
		wait.waitForElementToBeClickable(ddReqStatus);
		click(ddReqStatus);
		return getText(lblSelectedReqStatus);
	}

	/**
	 * This method is used to get the text of default selected source filter
	 * @return String default selected filter name
	 * @author gupta.mansi
	 */
	public String defaultSourceSelected() {
		wait.waitForElementToBeClickable(ddSource);
		click(ddSource);
		return getAttribute(weDefaultReqSource, "value");
	}

	/**
	 * This method is used to check whether recruiter filter is displayed or not 
	 * @return boolean true if filter is displayed
	 * @author gupta.mansi
	 */
	public boolean isRecruiterFilterDisplayed() {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(ddRecruiter);
	}

	/**
	 * This method is used to click on source filter dd
	 * @author gupta.mansi
	 */
	public void clickOnSourceDD() {
		click(ddSource);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to click on status filter dd
	 * @author gupta.mansi
	 */
	public void clickOnStatusDD() {
		click(ddReqStatus);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to check whether all the requirement status filters are
	 * present under requirement status dd
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean areAllReqStatusDisplayedInFilter() {
		for (int count = 1; count <= allStatus.length; count++)
			actualStatus.add(getText(getElement(weStatusList, String.valueOf(count))));
		if (actualStatus.isEmpty())
			return false;
		else if (actualStatus.size() != expectedStatus.size())
			return false;
		else
			return actualStatus.containsAll(expectedStatus);
	}

	/**
	 * This method is used to quick search the requirement
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void quickSearchRequirement(String reqName) {
		getElement(txtAreaQuickSearchRequirement).click();
		getElement(txtAreaQuickSearchRequirement).sendKeys(reqName);
		getElement(txtAreaQuickSearchRequirement).sendKeys(Keys.ENTER);
	}

	/**
	 * This method is used to check whether given requirement name is displayed on
	 * listing page or not
	 * @param reqName
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean isRequirementTitleDisplayed(String reqName) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblRequirementTitle, reqName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to verify presence of given link under Modify dd
	 * @param reqName
	 * @param btnName
	 * @return true if given button name is present under modify dd
	 */
	public boolean verifyPresenceOfCTAUnderModify(String reqName,String btnName)
	{
		boolean flag = false;
		wait.waitForPageToLoadCompletely();
		actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(lblModify, reqName));
		switch(btnName)
		{
		case "Edit":
			flag = isDisplayed(parameterizedLocator(lnkEditUnderModify, reqName));
			break;
		case "Close":
			flag = isDisplayed(parameterizedLocator(lnkCloseUnderModify, reqName));
			break;
		case "Post":
			flag = isDisplayed(parameterizedLocator(lnkPostUnderModify, reqName));
			break;
		}
		return flag;
	}

	/**
	 * @author gupta.mansi
	 * This method return true if Modify is present for given requirement
	 * @param reqName
	 * @return true if Modify is present for given requirement
	 */
	public boolean verifyPresenceOfModifyDD(String reqName)
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblModify, reqName));
	}
	
	/**
	 * This method is used to verify presence of links under requirement name for More Actions DD
	 * @param reqName: Name of Requirement
	 * @param btnName: Name of button
	 * @return true if given button is present for requirement under More Actions dd
	 */
	public boolean verifyOptionUnderMoreDD(String reqName,String btnName)
	{
		boolean flag = false;
		actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(lblMoreActions, reqName));
		switch(btnName)
		{
		case "Edit":
			flag = isDisplayed(parameterizedLocator(linkEditUnderMoreActions, reqName));
			break;
		case "Add Single Profile":
			flag = isDisplayed(parameterizedLocator(lnkAddSingleProfileUnderMoreActions, reqName));
			break;
		case "Download By Index":
			flag = isDisplayed(parameterizedLocator(lnkDownloadByIndexUnderMoreActions, reqName));
			break;
		case "Assign Vendor":
			flag = isDisplayed(parameterizedLocator(lnkAssignVendorUnderMoreActions, reqName));
			break;
		case "Get Apply Link":
			flag = isDisplayed(parameterizedLocator(lnkGetApplyLinkUnderMoreActions, reqName));
			break;
		}
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if More Actions dd is present under given requirement name
	 * @param reqName
	 * @return true if More Actions DD is present
	 */
	public boolean verifyPresenceOfMoreAction(String reqName)
	{
		return isDisplayed(parameterizedLocator(lblMoreActions, reqName));
	}

	/**
	 * @author gupta.mansi
	 * This method return true if given status is displayed under requirement name's current status dd
	 * @param reqName
	 * @param currStatus
	 * @param status
	 * @return true if given status is displayed under requirement name's current status dd
	 */
	public boolean verifyPresenceOfStatusUnderCurrentStatus(String reqName,String currStatus,String status)
	{
		boolean flag = false;
		actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(ddStatusChange, reqName, currStatus));
		switch(status)
		{
		case "Open":
			flag = isDisplayed(parameterizedLocator(txtStatusReq, reqName,status));
			break;
		case "On Hold":
			flag = isDisplayed(parameterizedLocator(txtStatusReq, reqName,status));
			break;
		case "Close":
			flag = isDisplayed(parameterizedLocator(txtCloseUnderStatusChang, reqName));
			break;
		}
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to verify current status of requirement
	 * @param reqName
	 * @param currStatus
	 * @return true is current status is displayed
	 */
	public boolean verifyCurrentStatusOfRequirement(String reqName,String currStatus)
	{
		return isDisplayed(parameterizedLocator(ddStatusChange, reqName, currStatus));
	}

	/**
	 * This method clicks on edit requirement button under modify dd from
	 * requirement listing page for given requirement
	 * @param reqName
	 */
	public void clickOnEditRequirementButtonFromReqListingPage(String reqName) {
		wait.waitForPageToLoadCompletely();
		actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(lblModify, reqName));
		click(parameterizedLocator(lnkEditUnderModify, reqName));
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method checks whether view only label is displayed under requirement
	 * name on requirement listing page
	 * @param reqName
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean isViewOnlyLabelDisplayed(String reqName) {
		return isDisplayed(parameterizedLocator(lblGetViewOnly, reqName));
	}

	/**
	 * This methods checks whether comment button is displayed under requirement
	 * name
	 * @param reqName
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean isCommentButtonDisplayed(String reqName) {
		return isDisplayed(parameterizedLocator(btnReqComment, reqName));
	}

	/**
	 * This method is used to add comment on requirement from requirement listing
	 * page
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void addCommentForRequirement(String reqName) {
		getElement(btnReqComment, reqName).click();
		wait.hardWait(2);
		wait.waitForVisibilityOfElement(txtAreaComment);
		click(txtAreaComment);
		wait.hardWait(3);
		getElement(txtAreaComment).sendKeys("Adding comment...");
		wait.waitForElementToBeClickable(btnAddComment);
		click(btnAddComment);
		wait.hardWait(3);
		getElement(btnReqComment, reqName).click();
	}

	/**
	 * This method is used to get the count of comments for requirement
	 * @param reqName
	 * @return comment count (String)
	 * @author gupta.mansi
	 */
	public String getCommentCount(String reqName) {
		return getText(parameterizedLocator(lblGetCommentCount, reqName));
	}

	/**
	 * This method is used to click the top comment on requirement on requirement
	 * listing page
	 * @param reqName
	 */
	public void deleteTopComment(String reqName) {
		getElement(btnReqComment, reqName).click();
		wait.hardWait(4);
		wait.waitForVisibilityOfElement(txtAreaComment);
		click(btnDltTopComment);
		wait.hardWait(4);
		getElement(btnReqComment, reqName).click();
	}

	/**
	 * This method is used to get the top comment for requirement on requirement
	 * listing page
	 * @param
	 * @return String
	 * @author gupta.mansi
	 */
	public String getTopComment(String reqName) {
		getElement(btnReqComment, reqName).click();
		wait.hardWait(4);
		wait.waitForVisibilityOfElement(txtAreaComment);
		String topComment = getText(txtTopCommentOfReq);
		getElement(btnReqComment, reqName).click();
		return topComment;
	}

	/**
	 * This method is used to verify whether search button is displayed or not
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean isSearchLabelDisplayed(String reqName) {
		return isDisplayed(parameterizedLocator(lblSearch, reqName));
	}


	/**
	 * This method verifies whether Resdex or My Database search buttons are present
	 * or not
	 * @param reqName
	 * @param btnType
	 * @author gupta.mansi
	 */
	public boolean isButtonDisplayed(String reqName, String btnType) {
		return isDisplayed(parameterizedLocator(btnSearchType, reqName, btnType));
	}

	/**
	 * This method is used to click on search button for given requirement
	 * @param reqName
	 * @param btnType
	 */
	public void clickSearchButton(String reqName, String btnType) {
		click(parameterizedLocator(btnSearchType, reqName, btnType));
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method returns the title of the page
	 * @return String
	 * @author gupta.mansi
	 */
	public String getTitleOfPage() {
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
		String pageTitle = getPageTitle();
		switchToParentWindow();
		return pageTitle;
	}

	/**
	 * This method clicks on close button under modify dd from requirement listing
	 * page
	 * @param reqName
	 */
	public void clickOnCloseRequirementButtonFromReqListingPage(String reqName) {
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(lnkCloseUnderModify, reqName));
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(btnCloseReqPopup);
		click(btnCloseReqPopup);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This message is returns true if error message is displayed
	 * @param message
	 */
	public boolean isMessageDislayed(String message) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblErrorMsg, message));
	}

}
