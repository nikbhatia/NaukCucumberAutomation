package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.PageObjectWrapper;

public class ManageGroupPO extends PageObjectWrapper {

	/**
	 * @author jatin.bisht
	 */
	private By txtGroupName = By.className("txtInput");
    private By txtGroupDescription = By.className("txtAreaInput");
    private By btnNext = By.xpath("//button[text()='NEXT']");
	private By ddRec = By.xpath("(//span[text()='DownArrow'])[1]");
	private By ddHRspoc = By.xpath("//label[text()='Select HR SPOC ']/../following-sibling::div//span[text()='DownArrow']");
	private By chkHRspoc = By.xpath("(//ul/li/span)[2]");
	private By chkSelectAll = By.xpath("//label[@for='selectAll']");
	private By ddHM = By.xpath("(//span[text()='DownArrow'])[3]");
	private By ddHMspoc = By.xpath("//span[text()='Select Hiring manager(s) ']/../div//span[text()='DownArrow']");
	private By chckHMspoc = By.xpath("(//ul/li/span)[1]");
	private By btnAddApproval = By.xpath("//span[text()='ADD NEW']");
	private By txtApprovalName = By.xpath("//input[@placeholder[contains(.,'workflow')]]");
	private By txtStageName = By.xpath("//input[@placeholder[contains(.,'stage')]]");
	private By txtApproverId = By.xpath("//span[text()='Enter email Ids of approvers']");
	private By chkApproverId = By.xpath("(//ul/li/span)[1]");
	private By btnApproveSave = By.id("saveApprovalTemplate");
	private By txtOfferapproval =  By.xpath("//input[@placeholder='Search here']");
	private By chkOfferapproval = By.xpath("(//li/span)[1]");
	private By rhmTab= By.xpath("//div[text()='Recruiters and Interviewers']");	
	private By chk1Rec = By.xpath("(//label[contains(text(),'naukri.com')])[1]");
	private By btnSelectionstg = By.xpath("(//a[text()='Selection Stages'])[1]");
	private By btnAddselectionstg = By.id("link_open1");
	private By txtNewSelectionStg = By.xpath("//input[@id='newVal']");
	private By btnStageSave = By.xpath("//a[@class='confSaveBtn fl ml5']");
	private By eleMapInterviewerTab = By.cssSelector("span[class=title]");
//	private By iconAddInterviewerToStage = By.xpath("//div[text()='${newSelectionStg}']/../..//em[@class='userAdd mt3']");
	private By ddHmStg = By.className("dropArrowDD");
	private By chkselectAllstg = By.xpath("//li[@value='aSelectAll']");
	private By btnSaveHm = By.xpath("//button[text()='Save']");
	private By btnDelSystm = By.xpath("//a[@id='deltS']");
	private By btnAddSubStage = By.xpath("//a[text()='Add New Sub Stage']");
	private By txtSubStage = By.xpath("//input[@placeholder='Add a Substage']");
	private By btnDelGrp = By.xpath("(//a[text()='Delete'])[2]");
	private By btnFinalDelete = By.id("deleteButton");
	private By chk1Group = By.xpath("(//input[@type='checkbox'])[2]");
	private By chk2Group = By.xpath("(//input[@type='checkbox'])[3]");
	private By btnBulkDlt = By.xpath("(//a[text()='Delete'])[1]");
	private By txtSearchbar = By.id("searchEmployer");
	private By btnSearch = By.xpath("(//input[@type='submit'])[2]");
	private By txtAlreadyCreatedGroup = By.xpath("(//a[@class='__viewDetails'])[1]");
	private By lblSearchGroup=By.xpath("//a[text()='${searchGroup}']");
	private By lblErrorMsg=By.xpath("//*[text()='${errorMsg}']");
	private By lblSuccessMsg=By.xpath("//*[contains(text(),'${successMsg}')]");
	private By lblLabelName=By.xpath("(//*[text()='${labelName}'])[1]");	
	private By lblManageGroup=By.xpath("//div[text()='Manage Groups']");
	private By lnkCommonForLink=By.xpath("(//a[text()='${link}'])[1]");
	private By lblGroupName=By.xpath("//a[text()='${groupName}']");
	By eleSelectionStage = By.xpath("//a[contains(text(),'${groupName}')]/parent::div/following-sibling::ul//a[contains(text(),\"Selection Stages\")]");
	By eleAddSelectionStage =  By.id("link_open1");
	By eleAddNewSelectionStage = By.id("newVal");
	By eleSaveButtonForSelectionStage = By.id("addNew");
	By eleSelectionStageHolder = By.xpath("//div[contains(text(),'${selectionStage}')]");
	By eleContinueButton = By.id("cancel3");
	private By eleGroupInitials=By.xpath("//input[@class=\"txtInput grpInits\"]");
	private By eleOptionForGroup=By.xpath("(//ul[@class=\"ques_list cle\"]//a[text()='${string}'])[${string}]");
	private By eleAllTabCount=By.xpath("//div[@class=\"allTab activeTab\"]");
	private By eleSelectedTabCount=By.xpath("//div[@class=\"selectTab\"]");
	private By txtUnderLabelViewDetail = By.xpath("(//div[text()='${role}']//following-sibling::p)[1]");
	private By ddOfSelectionStage = By.xpath("//div[text()='${selectionStage}']/..//..//div//span[contains(@class,'icon')]");
	By lblSubStageName = By.xpath("//div[@id='stageSelectDiv']//div[text()='${subStageName}']");
	By eleAddInterviewer = By.xpath("(//div[text()='${stageName}']//parent::div//parent::div//a)[1]");
	By btnAddInterviewer = By.xpath("//div[text()='${stageName}']//..//..//a[@title='Add Interviewer(s)']");
	By txtPlaceholder = By.xpath("//*[@placeholder='${txt}']");
	By ddAddHM = By.id("selectHMForStage");
	By extraClickToCloseDDextraClickToCloseDD = By.xpath("//p[@class='text']");
	By btnSaveHM = By.xpath("//button[text()='Save']");
	By cbTopInterviewer = By.xpath("//ul[contains(@class,'dropdown ')]//li[@index='1']");
	By eleButtonForGroup = By.xpath("//a[text()='${grpName}']//parent::div//parent::div//a[text()='${btnName}']");
	
	public static String selectionStage = "";
	
	SettingsDashboardPO SettingPageActionObj = (SettingsDashboardPO) PageObjectWrapper.getObject(SettingsDashboardPO.class);
		
	
	/**
	 * this method add group name and group description when creating new group
	 */
	public void addGroupDetails(String groupName,String groupDetails, String groupInitials) {
		wait.waitForPageToLoadCompletely();
		getElement(txtGroupName).sendKeys(groupName);
		sendKeys(eleGroupInitials, groupInitials);
		getElement(txtGroupDescription).sendKeys(groupDetails);
	}
	
	/**
	 * select all recruiter, HR spoc and all HM,HM spoc 
	 */
	public void selectRecHm() {
		getElement(ddRec).click();
		getElement(chkSelectAll).click();
		getElement(rhmTab).click();
		getElement(ddHRspoc).click();
		getElement(chkHRspoc).click();
		getElement(ddHM).click();
		getElement(chkSelectAll).click();
		getElement(rhmTab).click();
		getElement(ddHMspoc).click();
		getElement(chckHMspoc).click();
	}

	/**
	 * @Author Jatin
	 * This method create new approval process and mapped to the new group from add group flow
	 */
	public void selectReqApproval(String approvalName) {
		wait.waitForPageToLoadCompletely();
		getElement(btnAddApproval).click();
		getElement(txtApprovalName).sendKeys(approvalName);
		getElement(txtStageName).sendKeys("firststage");
		getElement(txtApproverId).click();
		getElement(chkApproverId).click();
		wait.waitForPageToLoadCompletely();
		getElement(btnApproveSave).click();
		wait.waitForPageToLoadCompletely();
	}
	/**
	 * This method search created approval process and attach at offer approval process 
	 * @param approval process name which is already created
	 */
	
	public void selectOfferApproval(String approvalName) {
		wait.waitForVisibilityOfElement(txtOfferapproval);
		wait.waitForElementToBeClickable(txtOfferapproval);
		getElement(txtOfferapproval).sendKeys(approvalName);
		getElement(chkOfferapproval).click();		
	}
	
	public void clickOnBtn(String buttonName) {
		wait.waitForElementToBeClickable(By.xpath("//button[text()='"+buttonName+"']"));
		hover(By.xpath("//button[text()='"+buttonName+"']"));
		getElement(By.xpath("//button[text()='"+buttonName+"']")).click();
		wait.waitForPageToLoadCompletely();
	}
	
	public void ClickOnlinks(String link) {
		wait.waitForPageToLoadCompletely();
		getElement(lnkCommonForLink,link).click();
	    wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * This method verify group created is visible or not by group name 
	 * @param group name which is created
	 * @return true if created group is visible else return false
	 */
	public boolean verifyGroupAdd(String groupName) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblGroupName,groupName));
	}
			
	/**
	 * This method fill new group name 
	 * @param new generated group name 
	 */
	public void editGroupName(String newGroupName) {
		getElement(txtGroupName).clear();
		getElement(txtGroupName).sendKeys(newGroupName);
	}
	
	/**
	 * this method select only one recruiter
	 */
	public void newRecHm() {
		getElement(ddRec).click();
		getElement(chkSelectAll).click();
		getElement(chk1Rec).click();
		getElement(rhmTab).click();		
	}

	public void selectionStage() {
		getElement(btnSelectionstg).click();
	}
	
	/**
	 * adding new selection stage to new group
	 */
	public void addSelectionStage(String newSelectionStg) {
		getElement(btnAddselectionstg).click();
		getElement(txtNewSelectionStg).sendKeys(newSelectionStg);
		getElement(btnStageSave).click();			
	}
	
	/**
	 * This method adds all HM to new selection stage 
	 * @param name of new created selection stage
	 */
	public void addHmToStage(String newSelectionStg) {
		mouseHoverToWebElement(getElement(By.xpath("//div[text()='"+newSelectionStg+"']")));
		getElement(By.xpath("//div[text()='"+newSelectionStg+"']/../..//em[@class='userAdd mt3']")).click();
//		getElement(iconAddInterviewerToStage).click();
		getElement(eleMapInterviewerTab).click();
		getElement(ddHmStg).click();
		getElement(chkselectAllstg).click();
		getElement(eleMapInterviewerTab).click();
		getElement(btnSaveHm).click();
	}
	
	public boolean verifySelectionStage(String newSelectionStg) {
		return (isDisplayed(By.xpath("//div[text()='"+newSelectionStg+"']")));
	}
	

	public boolean verifyDelSelectionStage(String delSelectionStg) {
		return (isDisplayed(By.xpath("//div[text()='"+delSelectionStg+"']")));
	}
	
	/**
	 * This method is use to add new substage under new selection stage
	 * @author jatin.bisht
	 * @param new Selection stage name
	 * 
	 */
	public void addSubStage(String newSelectionStg ) {
		wait.waitForPageToLoadCompletely();
		getElement(By.xpath("//div[text()='"+newSelectionStg+"']")).click();
		getElement(btnAddSubStage).click();
		getElement(txtSubStage).sendKeys(newSelectionStg);
		getElement(btnStageSave).click();
	}
	
	/**
	 * @author jatin.bisht
	 * This method is use to delete new selection stage
	 * @param new Selection stage name 
	 */
	public void deleteNewStage(String newSelectionStg) {
		mouseHoverToWebElement(getElement(By.xpath("//div[text()='"+newSelectionStg+"']")));
		getElement(By.xpath("//div[text()='"+newSelectionStg+"']/./../preceding-sibling::div/a/em[contains(@class,'DelIcon')]")).click();
		wait.waitForPageToLoadCompletely();
		getElement(btnDelSystm).click();
	}
		
	public boolean verifyNavigateToManageGrp() {
		return (isDisplayed(lblManageGroup));
	}	
	
	public boolean labelVerify(String labelName) {		
		wait.waitForPageToLoadCompletely();				
		return isDisplayed(parameterizedLocator(lblLabelName,labelName));
	//	return getElement(lblLabelName,labelName).isDisplayed();
	}
	
	/**
	 * this method verify headings passed in string
	 * @param heading
	 * @return
	 */
	public boolean verifyHeadings(String heading) {
		wait.waitForPageToLoadCompletely();
		By headingName = By.xpath("(//*[contains(text(),'" + heading + "')])[1]");
		return isDisplayed(headingName);
	}
	
	/**
	 * This method is use to fill mandatory fields for group creation
	 * @param groupName
	 */
	public void mandatoryField(String groupName, String groupInitials) {
		getElement(txtGroupName).sendKeys(groupName);
		sendKeys(eleGroupInitials, groupInitials);
		getElement(btnNext).click();
		getElement(ddRec).click();
		getElement(chkSelectAll).click();
		getElement(rhmTab).click();
//		getElement(ddHM).click();
//		getElement(chkSelectAll).click();
	}
	
	/**
	 * this method is use to delete the new created group
	 */
	public void deleteGroup() {
		wait.waitForPageToLoadCompletely();
		getElement(btnDelGrp).click();
		getElement(btnFinalDelete).click();
	}
		
	/**
	 * this method is use to verify success message
	 * @param success message text
	 */
	public boolean verifySuccessMsg(String successMsg) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblSuccessMsg,successMsg));
	//	return getElement(lblSuccessMsg,successMsg).isDisplayed();
	}
	
	/**
	 * this method select first 2 groups for bulk action
	 */
	public void select2Groups() {
		getElement(chk1Group).click();
		getElement(chk2Group).click();		
	}
	
	public void bulkDelete() {
		getElement(btnBulkDlt).click();
		getElement(btnFinalDelete).click();
	}	
	
	/**
	 * this method get the name of group which is already created and send this name to add new group
	 */
	public void groupAlreadyExist() {
		String alreadyCreatedGrp= getElement(txtAlreadyCreatedGroup).getText();
		getElement(txtGroupName).sendKeys(alreadyCreatedGrp);
	}
	
	/**
	 * this method verifies error message is visible or not
	 * @param error message text
	 * @return method returns true if message is visible else false
	 */
	public boolean verifyErrorMsg(String errorMsg) {
		return isDisplayed(parameterizedLocator(lblErrorMsg,errorMsg));
	//return getElement(lblErrorMsg,errorMsg).isDisplayed();
	}
	
	/**
	 * this method search group with the help of search bar
	 * @param Group name which will use for searching the group
	 */
	public void searchGroup(String searchGroup) {
		getElement(txtSearchbar).sendKeys(searchGroup);
		getElement(btnSearch).click();
	}
	
	public boolean verifySearchGroup(String searchGroup) {
		return getElement(lblSearchGroup,searchGroup).isDisplayed();
	}
	
	/**
	 * Click on the selection stage of the added group
	 * @author rachit.mehrotra
	 */
	public void clickOnSelectionStagesBasedOnGroupName() {
		click(parameterizedLocator(eleSelectionStage, PropFileHandler.readProperty("GroupName")));
	}
	
	/**
	 * To add a new selection stage in the group
	 * @author rachit.mehrotra
	 * @param selectionStage
	 */
	public void addSelectionStageInGroup(String selectionStage) {
		this.selectionStage = selectionStage + GenericFunctions.generateRandomStrings(4, "String");
		jsUtil.scrollDown(eleAddSelectionStage);
		click(eleAddSelectionStage);
		wait.waitForVisibilityOfElement(eleAddNewSelectionStage);
		sendKeys(eleAddNewSelectionStage, this.selectionStage);
		click(eleSaveButtonForSelectionStage);
	}
	
	/**
	 * To verify the visibility of the selection stage added
	 * @author rachit.mehrotra
	 * @return boolean basis the comparison
	 */
	public boolean verifyPresenceOfSelectionStage() {
		return isDisplayed(parameterizedLocator(eleSelectionStageHolder, this.selectionStage));
	}
	
	/**
	 * To click on continue button
	 * @author rachit.mehrotra
	 */
	public void clickOnContinueButton() {
		click(eleContinueButton);
	}
	/** this method is used to verify requisition success message
	 * @return true if requisition template name is displayed 
	 */
	public boolean verifySuccessRequisitionMessage()
	{
		String reqTemplateName = PropFileHandler.readProperty("reqTemplateName");
		return isDisplayed(parameterizedLocator(lblSuccessMsg,reqTemplateName+" was created successfully"));
	}

	/**
	 * click Option For First Group
	 * 
	 * @param optionToBeClicked
	 * @param groupNum
	 * @author udit.khanna
	 */
	public void clickOptionForGroup(String optionToBeClicked, String groupNum) {
		click(parameterizedLocator(eleOptionForGroup, optionToBeClicked, groupNum));
	}

	/**
	 * click Dropdown On Edit Group
	 * 
	 * @author udit.khanna
	 * @param ddToBeClicked
	 */
	public void clickDropdownOnEditGroup(String ddToBeClicked) {
		if (ddToBeClicked.equalsIgnoreCase("Select Recruiters"))
			click(ddRec);
		else if (ddToBeClicked.equalsIgnoreCase("Select Interviewer(s) "))
			click(ddHM);
	}

	/**
	 * verify All Count Greater Than Selected
	 * 
	 * @return true if All count is greater than or equal to Selected count
	 * @author udit.khanna
	 */
	public boolean verifyAllCountGreaterThanSelected() {
		int allTabCount = Integer.parseInt(getText(eleAllTabCount).replaceAll("[^0-9]+", ""));
		int selectedTabCount = Integer.parseInt(getText(eleSelectedTabCount).replaceAll("[^0-9]+", ""));
		click(rhmTab);
		return allTabCount>=selectedTabCount;
	}
	
	/**
	 * @wip
	 * @author gupta.mansi
	 * This method is used to verify presence of users under label under view detail 
	 * @param userName
	 * @param labelName
	 * @return true if userName is present under labelName
	 */
	public boolean verifyUserUnderLabel(String userName, String labelName)
	{
		return getText(parameterizedLocator(txtUnderLabelViewDetail, labelName)).contains(userName);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to get the title text of add interviewer icon for given stage name
	 * @param stageName
	 * @return title text in String
	 */
	public String getTitleTextAddInterviewerOnSeletionStage(String stageName)
	{
		if (stageName.contains("-")) {
            String[] stage = stageName.split("-");
            click(parameterizedLocator(ddOfSelectionStage, stage[0].trim()));
            stageName = stage[1].trim();
        }
		jsUtil.scrollToElement(parameterizedLocator(lblSubStageName, stageName));
		mouseHoverToWebElement(getElement(lblSubStageName, stageName));
		return getAttribute(parameterizedLocator(eleAddInterviewer, stageName), "title");
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given icon on given selection stage
	 * @param stageName
	 * @param iconName
	 */
	public void clickOnIconForStageOnSelectionStage(String stageName,String iconName)
	{
		if (stageName.contains("-")) {
            String[] stage = stageName.split("-");
            click(parameterizedLocator(ddOfSelectionStage, stage[0].trim()));
            stageName = stage[1].trim();
        }
		jsUtil.scrollToElement(parameterizedLocator(lblSubStageName, stageName));
		mouseHoverToWebElement(getElement(lblSubStageName, stageName));
		getElement(btnAddInterviewer, stageName).click();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to verify placeholder text 
	 * @param text
	 * @return true if given placeholder text is displayed
	 */
	public boolean verifyPresenceOfPlaceholderText(String text)
	{
		return isDisplayed(parameterizedLocator(txtPlaceholder, text));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to select top interviewer check box from add interviewer drop down
	 */
	public void selectTopInterviewerFromAddInterviewerLB()
	{
		wait.waitForPageToLoadCompletely();
		click(extraClickToCloseDDextraClickToCloseDD);
		wait.waitForPageToLoadCompletely();
		click(ddAddHM);
		click(cbTopInterviewer);
		getElement(extraClickToCloseDDextraClickToCloseDD).click();
	}
	
	/**
	 *@author gupta.mansi
	 *This method is used to click on given btn for group
	 * @param grpName
	 * @param btnName
	 */
	public void clickOnBtnForGrpName(String grpName,String btnName)
	{
		click(parameterizedLocator(eleButtonForGroup, grpName,btnName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given interviewer name
	 */
	public void clickOnInterviewerNameInLB(String hmName)
	{
		click(ddAddHM);
		click(parameterizedLocator(lblLabelName, hmName));
		getElement(extraClickToCloseDDextraClickToCloseDD).click();
	}
	
}
