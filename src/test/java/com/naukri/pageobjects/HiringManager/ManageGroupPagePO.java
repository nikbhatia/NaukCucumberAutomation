package com.naukri.pageobjects.HiringManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

public class ManageGroupPagePO extends BaseAutomation {

	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);
	CommonAction commonActionObject = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	
	By btnAddGroup = By.xpath("//a[text()='Add Group']");
	By txtGroupName = By.className("txtInput");
	By btnNext = By.xpath("//button[text()='NEXT']");
	By extraClick = By.xpath("//div[@class='head']");
	By ddlHR = By.xpath("//div[contains(@class,'HRList')]//div[contains(@class,'multiSelectBar')]//span[@class='select-toggler']");
	By txtHR = By.xpath("//div[contains(@class,'HRList')]//div[contains(@class,'multiSelectBar')]//input");
	By chkHR = By.xpath("//div[@class='select-list']//label");
	By ddlHRSpoc = By.xpath("//div[contains(@class,'HRList')]//div[contains(@class,'singleSelectBar')]//span[@class='select-toggler']");
	By ddlHM = By.xpath("(//div[contains(@class,'HMList')]//div[contains(@class,'multiSelectBar')]//span[@class='select-toggler'])[1]");
	By txtHM = By.xpath("//div[contains(@class,'HMList')]//div[contains(@class,'multiSelectBar')]//input");
	By chkHM = By.xpath("//div[@class='select-list']//label");
	By ddlHMSpoc = By.xpath("(//div[contains(@class,'HMList')]//div[contains(@class,'multiSelectBar')]//span[@class='select-toggler'])[2]");
	By btnSaveGroup = By.xpath("//button[@id='saveGroupSettings']");
	By lblFirstStageName = By.xpath("(//div[@class='acc_head_title'])[1]");
	By ddlOfFirstSelectionStage = By.xpath("(//span[@class='icon'])[1]");
	By btnAddNewSubstage = By.xpath("(//a[text()='Add Sub Stage'])[1]");
	By txtAddNewSubStageName = By.xpath("//form[@name='editSubStage']//input");
	By btnSaveSubStage = By.xpath("//a[@id='saveStage']");
	By txtAddHM = By.id("selectHMForStage");
	By extraClickToCloseDDextraClickToCloseDD = By.xpath("//p[@class='text']");
	By btnSaveHM = By.xpath("//button[text()='Save']");
	By btnAddNewApprovelProcess = By.xpath("//span[text()='ADD NEW']");
	By txtApprovalName = By.xpath("//div[@class='process-field']//input[@class='textBox']");
	By txtStageName = By.xpath("//input[@placeholder[contains(.,'stage')]]");
	By txtApprove = By.xpath("//span[text()='Enter email Ids of approvers']");
	By txtApproverId = By.xpath("//input[@placeholder='Enter email Ids of approvers']");
	By btnApproveSave = By.id("saveApprovalTemplate");
	By lblSubStageName = By.xpath("//div[@id='stageSelectDiv']//div[text()='${subStageName}']");
	By lblStageName = By.xpath("//div[text()='${StageName}']");
	//By btnAddHM = By.xpath("//div[text()='${stageName}']//..//..//a[@title='Add Hiring Manager']");
	By btnAddInterviewer = By.xpath("//div[text()='${stageName}']//..//..//a[@title='Add Interviewer(s)']");
	By btnAddFeedbackFormForSubstage = By.xpath("//div[text()='${substageName}']//parent::li//a[@title='Attach Feedback Form']//parent::span");
	By btnAddFeedbackForm = By.xpath("//div[text()='${stageName}']//..//..//a[@title='Attach Feedback Form']");
	By txtAreaSearchFeedbackForm = By.xpath("//input[@id='inp_feedbackList']");
	By firstFeedbackForm = By.xpath("(//div[@id='ul_feedbackList']//a)[1]");
	By txtGroupInitials = By.xpath("//div[text()='Group Initials']");
	By inputGroupInitials = By.xpath("//div[text()='Group Initials']//..//input");
	private By ddOfSelectionStage = By.xpath("//div[text()='${selectionStage}']/..//..//div//span[@class='icon']");
	static String approvaProcessName = CommonAction.generateRandomStrings(5, "String");
	By eleEditButtonGroup=By.xpath("//a[text()='${groupName}']/parent::div/following-sibling::ul//a[@class='editEmployerClick']");
	By eleHmSpocCheckbox=By.xpath("//div[contains(@class,'HM')]//label[text()='${hmSpoc}']/preceding-sibling::input");
	By eleHmSpoc=By.xpath("//div[contains(@class,'HM')]//label[text()='${hmSpoc}']");
	//By ddHMspoc = By.xpath("//span[contains(text(),'HM SPOC')]/../div//span[text()='DownArrow']");
	By ddHMspoc = By.xpath("//div[contains(@class,'HM')]//div[contains(@class,'advanceSelect')]//span[text()='DownArrow']");
	private By txtSelectedApprovalProcess = By.xpath("//div[text()='SELECTED (0)']");
	private By eleGroupName = By.xpath("//a[text()='${grpName}']");
	private By inputFeedbackFormName = By.xpath("//input[@id='inp_feedbackList']");
	private By eleFooterCreateGroup = By.xpath("//div[@class='foot']");
	private By chkHRSpoc = By.xpath("//li//span[text()='${hrSpoc}']");
	private By chkHMSpoc = By.xpath("//input[@type='checkbox']//parent::span//label[text()='${hmSpoc}']");
	private By txtGroupInitialErr = By.xpath("//p[text()='Initials entered already exist']");
	/**
	 * This method is used to create group with one Hiring Manager, HRSpoc, one HR
	 * and one HMSpoc 
	 * @author gupta.mansi
	 * @param grpName
	 * @param hmName
	 * @param hrName
	 * @param hmSpocName
	 * Requisition Approval For HM Automation
	 */

	public void addGroup(String grpName, String hmName, String hrName, String hmSpocName) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(btnAddGroup);
		getElement(btnAddGroup).click();
		TestNGLogUtility.info("User clicks on Add Group button");
		if(!isDisplayed(txtGroupName)) {
			pageRefresh();
			getElement(btnAddGroup).click();
			TestNGLogUtility.info("User clicks on Add Group button again");}
		getElement(txtGroupName).sendKeys(grpName);
		TestNGLogUtility.info("User filles group name as "+grpName);
		getElement(inputGroupInitials).clear();
		String randGroupInitials  = GenericFunctions.generateRandomStrings(5,"Alphanumeric");
		sendKeys(inputGroupInitials,randGroupInitials);
		TestNGLogUtility.info("User fills group initials as "+randGroupInitials);
		fillIntialsIfError();
		wait.waitForPageToLoadCompletely();
		getElement(btnNext).click();
		TestNGLogUtility.info("User clicks on Next button");
		wait.waitForPageToLoadCompletely();
		getElement(ddlHR).click();
		getElement(txtHR).sendKeys(hrName);
		getElement(chkHR).click();
		TestNGLogUtility.info("User fills HR as "+hrName);
		getElement(extraClick).click();
		getElement(ddlHRSpoc).click();
		getElement(parameterizedLocator(chkHRSpoc, hrName)).click();
		TestNGLogUtility.info("User fills HRSpoc as "+hrName);
		getElement(extraClick).click();
		getElement(ddlHM).click();
		getElement(txtHM).sendKeys(hmName);
		TestNGLogUtility.info("User fills HM as "+hmName);
		getElement(chkHM).click();
		getElement(extraClick).click();
		getElement(ddlHMSpoc).click();
		getElement(parameterizedLocator(chkHMSpoc, hmSpocName)).click();
		TestNGLogUtility.info("User fills HMSpoc as "+hmName);
		wait.hardWait(1);
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(btnNext);
		getElement(btnNext).click();
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(btnSaveGroup);
		wait.waitForInvisibilityOfElement(2, 2, eleFooterCreateGroup);
		wait.waitForElementToBeClickable(btnSaveGroup);
		getElement(btnSaveGroup).click();
		TestNGLogUtility.info("User click on Save Group button");
		wait.waitForPageToLoadCompletely();
		
	}

	/**
	 * This method is used to add group with given recruiters only
	 * @param grpName
	 * @param hrNames
	 * @author gupta.mansi
	 */
	public void addGroup(String grpName, List<String> hrNames) {
		wait.waitForValignWrapperToDisappear(2, 2);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(btnAddGroup);
		getElement(btnAddGroup).click();
		wait.waitForValignWrapperToDisappear(2, 2);
		if(!isDisplayed(txtGroupName)) {
			pageRefresh();
			getElement(btnAddGroup).click();
			wait.waitForValignWrapperToDisappear(2, 2);}
		getElement(txtGroupName).sendKeys(grpName);
		getElement(inputGroupInitials).clear();
		String randGroupInitials  = GenericFunctions.generateRandomStrings(5,"Alphanumeric");
		sendKeys(inputGroupInitials,randGroupInitials);
		TestNGLogUtility.info("User fills group initials as "+randGroupInitials);
		fillIntialsIfError();
		wait.waitForPageToLoadCompletely();
		getElement(btnNext).click();
		TestNGLogUtility.info("User clicks on Next button");
		wait.waitForPageToLoadCompletely();
		fillHRName(hrNames);
		getElement(extraClick).click();
		wait.hardWait(1);
		wait.waitForValignWrapperToDisappear(2, 2);
		getElement(btnNext).click();
		wait.waitForPageToLoadCompletely();
		wait.waitForInvisibilityOfElement(2, 2, eleFooterCreateGroup);
		wait.waitForValignWrapperToDisappear(2, 2);
		click(btnSaveGroup);
		wait.waitForPageToLoadCompletely();
		TestNGLogUtility.info("User click on Save Group button");
	}

	/**
	 * This is used to add sub stage to a selection stage
	 * @author gupta.mansi
	 * @param grpName
	 */
	public void addSelectionSubStages(String grpName) {
		getElement(ddlOfFirstSelectionStage).click();
		getElement(btnAddNewSubstage).click();
		getElement(txtAddNewSubStageName).sendKeys(grpName);
		getElement(btnSaveSubStage).click();
	}

	/**
	 * After creating a group, get the name of the first selection stage displayed
	 * for the group.
	 * @author gupta.mansi
	 * @return name of the selection stage
	 */
	public String getNameOfFirstSelectionStage() {
		return getElement(lblFirstStageName).getText();
	}

	/**
	 * This is used to add hiring manager to a selection stage(not substage)
	 * @author gupta.mansi and @author abhishek.dwivedi
	 * @param hmName
	 * @param grpName
	 */
	public void addHiringManagerToSelectionStage(String hmName, String stageName) {
		if (stageName.contains("-")) {
            String[] stage = stageName.split("-");
            click(parameterizedLocator(ddOfSelectionStage, stage[0].trim()));
            stageName = stage[1].trim();
        }
		jsUtil.scrollToElement(parameterizedLocator(lblSubStageName, stageName));
		mouseHoverToWebElement(getElement(lblSubStageName, stageName));
		getElement(btnAddInterviewer, stageName).click();
		wait.waitForPageToLoadCompletely();
		click(extraClickToCloseDDextraClickToCloseDD);
		getElement(txtAddHM).sendKeys(hmName);
		getElement(txtAddHM).sendKeys(Keys.ENTER);
		getElement(extraClickToCloseDDextraClickToCloseDD).click();
		getElement(btnSaveHM).click();

	}

	/**
	 * This method is used to attach feedback form to given selection stage (not substage)
	 * @param feedbackForm
	 * @param subStageName
	 */
	public void addFeedbackFormToSelectionStage(String subStageName) {
		mouseHoverToWebElement(getElement(lblSubStageName, subStageName));
		getElement(btnAddFeedbackForm, subStageName).click();
		wait.waitForVisibilityOfElement(firstFeedbackForm);
		click(firstFeedbackForm);
		wait.hardWait(1);
	}

	/**
	 * This method is used to create group with any number of given HM, HR, HR Spoc and approval process
	 * and HM Spoc
	 * @param grpName
	 * @param hrNames
	 * @param hrSpoc
	 * @param hmNames
	 * @param hmSpoc
	 * @flag This value decides to fill approval process, if true then attach approval and if false then not
	 * @param appoversId
	 */
	public void addGroupCustomize(String grpName, List<String> hrNames, List<String> hrSpoc, List<String> hmNames, List<String> hmSpoc, boolean flag, List<String> appoversId, String approvalName) {
		commonActionObject.goToPageURL(URLBuilder.getURL("groupListing"));
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(btnAddGroup);
		getElement(btnAddGroup).click();
		TestNGLogUtility.info("User clicks on Add Group button");
		if(!isDisplayed(txtGroupName)) {
			pageRefresh();
			getElement(btnAddGroup).click();
			TestNGLogUtility.info("User clicks on Add Group button again");}
		getElement(txtGroupName).sendKeys(grpName);
		getElement(inputGroupInitials).clear();
		String randGroupInitials  = GenericFunctions.generateRandomStrings(5,"Alphanumeric");
		sendKeys(inputGroupInitials,randGroupInitials);
		TestNGLogUtility.info("User fills group initials as "+randGroupInitials);
		fillIntialsIfError();
		wait.waitForPageToLoadCompletely();
		getElement(btnNext).click();
		TestNGLogUtility.info("User clicks on Next button");
		wait.waitForPageToLoadCompletely();
		fillHRName(hrNames);
		getElement(extraClick).click();
		selectHRSpoc(hrSpoc);
		getElement(extraClick).click();
		selectInterviewers(hmNames);
		getElement(extraClick).click();
		selectHM(hmSpoc);
		wait.waitForPageToLoadCompletely();
		getElement(btnNext).click();
		TestNGLogUtility.info("User clicks on Next button");
		wait.waitForPageToLoadCompletely();
		if(flag == true)
		{
			click(txtSelectedApprovalProcess);
			click(btnAddNewApprovelProcess);
			approvalProcess(appoversId, approvalName);
			wait.waitForPageToLoadCompletely();
		}
		wait.waitForPageToLoadCompletely();
		getElement(btnNext).click();
		wait.waitForElementToBeClickable(btnSaveGroup);
		wait.hardWait(1);
		wait.waitForInvisibilityOfElement(2, 2, eleFooterCreateGroup);
		wait.waitForElementToBeClickable(btnSaveGroup);
		click(btnSaveGroup);
		TestNGLogUtility.info("User click on Save Group button");
		wait.hardWait(1);
		wait.waitForPageToLoadCompletely();
		PropFileHandler.writeProperty("GroupName", grpName);
		
	}

	/**
	 * This method is used to create approval template
	 * @param appoversId
	 */
	public void approvalProcess(List<String> appoversId, String approvalName) {
		wait.waitForVisibilityOfElement(txtApprovalName);
		getElement(txtApprovalName).sendKeys(approvalName);
		getElement(txtStageName).sendKeys("firststage");
		getElement(txtApprove).click();
		for (String id : appoversId) {
			getElement(txtApproverId).sendKeys(id);
			getElement(txtApproverId).sendKeys(Keys.ENTER);
		}
		getElement(By.xpath("//p[@class='field-help']")).click();
		getElement(btnApproveSave).click();
		wait.waitForPageToLoadCompletely();

	}
	/**
	 * This method is used for click on edit button under the group
	 * @param groupName
	 */
	public void clickOnEditlinkUnderGroup(String groupName) {
		click(parameterizedLocator(eleEditButtonGroup, groupName));
	}
	
	/**
	 * This method is used for add or remove hmSpoc from group 
	 * @param action
	 * @param hmSpoc
	 */
	public void addOrRemoveHm(String action, String hmSpoc) {
		getElement(btnNext).click();
		click(ddHMspoc);
		if(action.equalsIgnoreCase("Add"))
			if(!getElement(parameterizedLocator(eleHmSpocCheckbox,hmSpoc)).isEnabled())
				click(parameterizedLocator(eleHmSpoc,hmSpoc));
		if(action.equalsIgnoreCase("Remove"))
			if(getElement(parameterizedLocator(eleHmSpocCheckbox,hmSpoc)).isEnabled())
				click(parameterizedLocator(eleHmSpoc,hmSpoc));
	}
	
	/**
	 * @author gupta.mansi
	 * Returns true if given group name is displayed
	 * @param groupName
	 * @return
	 */
	public boolean isCreatedGroupDisplayedOnPage(String groupName)
	{
		return API.refreshPageAndCheckElementIsDisplayed((parameterizedLocator(eleGroupName, groupName)),2);
	}

	/**
	 * @author gupta.mansi
	 * This method click on given link on manage group page
	 * @param name
	 */
	public void clickOnLinkOnManageGroupPage(String name)
	{
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(eleGroupName, name));
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method maps given feedback form on given stage
	 * @param stageName
	 * @param formName
	 */
	public void addFeedbackFormToSelectionStage(String stageName,String formName) {
		if (stageName.contains("-")) {
            String[] stage = stageName.split("-");
            click(parameterizedLocator(ddOfSelectionStage, stage[0].trim()));
            stageName = stage[1].trim();
        }
		jsUtil.scrollToElement(parameterizedLocator(lblSubStageName, stageName));
		mouseHoverToWebElement(getElement(lblSubStageName, stageName));
		getElement(btnAddFeedbackForm, stageName).click();
		wait.waitForVisibilityOfElement(firstFeedbackForm);
		getElement(parameterizedLocator(inputFeedbackFormName, formName)).click();
		getElement(parameterizedLocator(inputFeedbackFormName, formName)).sendKeys(formName);
		getElement(parameterizedLocator(inputFeedbackFormName, formName)).sendKeys(Keys.ENTER);
		wait.waitForVisibilityOfElement(firstFeedbackForm);
		click(firstFeedbackForm);
		wait.hardWait(1);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to fill HR Names in group
	 * @param hrNames
	 */
	public void fillHRName(List<String> hrNames)
	{
		getElement(ddlHR).click();
		for (String nameOfHR : hrNames) {
			getElement(txtHR).sendKeys(nameOfHR);
			getElement(chkHR).click();
			TestNGLogUtility.info("User adds "+nameOfHR+" as HR");
		}
		getElement(extraClick).click();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to select given hr spoc
	 * @param hrSpoc
	 */
	public void selectHRSpoc(List<String> hrSpoc)
	{
		getElement(ddlHRSpoc).click();
		for (String nameOfHRSpoc : hrSpoc) {
			getElement(parameterizedLocator(chkHRSpoc, nameOfHRSpoc)).click();
			TestNGLogUtility.info("User adds "+nameOfHRSpoc+" as HRSpoc");
		}
		getElement(extraClick).click();
	}
	
	/**
	 * @author gupta.mansi
	 * This method selects given Interviewers formerly HM
	 * @param hmNames
	 */
	public void selectInterviewers(List<String> hmNames)
	{
		getElement(ddlHM).click();
		for (String nameOfHM : hmNames) {
			getElement(txtHM).sendKeys(nameOfHM);
			getElement(chkHM).click();
			TestNGLogUtility.info("User adds "+nameOfHM+" as HM");
		}
		getElement(extraClick).click();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to select HM (formerly HMSpoc)
	 * @param hmSpoc
	 */
	public void selectHM(List<String> hmSpoc)
	{
		getElement(ddlHMSpoc).click();
		for (String nameOfHMSpoc : hmSpoc) {
			getElement(parameterizedLocator(chkHMSpoc, nameOfHMSpoc)).click();
			TestNGLogUtility.info("User adds "+nameOfHMSpoc+" as HMSpoc");
		}
	}
	
	/**
	 * This method is used to fill group initials if error is displayed for group initials
	 * @author gupta.mansi
	 */
	public void fillIntialsIfError()
	{
		wait.waitForPageToLoadCompletely();
		wait.hardWait(2);
		if(isDisplayed(txtGroupInitialErr))
		{
			getElement(inputGroupInitials).clear();
			String randGroupInitials  = GenericFunctions.generateRandomStrings(5,"Alphanumeric");
			sendKeys(inputGroupInitials,randGroupInitials);
			TestNGLogUtility.info("User fills group initials as "+randGroupInitials);
		}
		wait.waitForValignWrapperToDisappear(2, 2);
	}
	
}
