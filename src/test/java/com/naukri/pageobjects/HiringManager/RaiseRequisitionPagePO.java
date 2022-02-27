package com.naukri.pageobjects.HiringManager;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.naukri.test.base.BaseAutomation;

public class RaiseRequisitionPagePO extends BaseAutomation {

	By txtRequisitionTitle = By.xpath("//input[@id='requestName']");
	By lblRequisitionTitleErrMsg = By.xpath("//div[@id='requestName_err']");
	By 	txtJobTitle = By.xpath("//input[@name='jobTitle']");
	By lblJobTitleErrMsg = By.xpath("//div[@id='jobTitle_err']");
	By txtJobDescription = By.xpath("(//div[@id='request_det']//div[@class='jqte_editor'])[1]");
	By lblJobDescriptionErrMsg = By.xpath("//div[@id='description_editor_err']");
	By txtCandidateDetail = By.xpath("//div[@id='showCandDetail']//div[@class='jqte_editor']");
	By lblCandidateDetailErrMsg = By.xpath("//div[@id='candidateProfile_editor_err']");
	By ddMinWorkExp = By.xpath("//select[@id='minExp']");
	By ddMaxWorkExp = By.xpath("//select[@id='maxExp']");
	By lblMinWorkExpErrMsg = By.xpath("//div[@id='experience_err']");
	By clickKeyskills = By.id("keywordDiv");
	By txtKeyskills = By.xpath("//input[@id='keywordInp']");
	By weKeyskills = By.xpath("//span[@class='tagTxt tagit-label']");
	By lblKeywordErrMsg = By.xpath("//div[@id='tagValArr_err']");
	By lblCtcErrMsg = By.xpath("//div[@id='salary_err']");
	By ddMaxCtc = By.xpath("//select[@id='maxSalary']");
	By ddCurrency = By.xpath("//select[@id='salaryCurrency']");
	By btnRemoveAllKeywords = By.xpath("//a[@id='tagRemove']");
	By weAllKeywords = By.xpath("//span[@class='tagTxt tagit-label']");
	By ddJobLocation = By.xpath("//input[@id='inp_cityIds']");
	By btnClearAllLoc = By.xpath("//a[@id='clearId_cityIds']");
	By lblJobLocationErrMsg = By.xpath("//div[@id='othercity_err']");
	By chkInternationalLoc = By.xpath("//input[@id='fillIntrLoc']");
	By ddInternationalLoc = By.xpath("//input[@id='inp_internationalLocation']");
	By txtInternationalOtherLoc = By.xpath("//input[@id='otherCountry']");
	By btnSaveOtherLoc = By.xpath("//a[@id='saveIntLoc']");
	By btnCancelOtherLoc = By.xpath("//div[@id='otherCountryDiv']//a[text()='Cancel']");
	By txtVacancies = By.xpath("//input[@id='vacancies']");
	By lblVacancyErrMsg = By.xpath("//div[@id='vacancies_err']");
	By ddGroup = By.xpath("//select[@id='selectGroup']");
	By lblGroupErrMsg = By.xpath("//div[@id='selectGroup_err']");
	By ddRecruiter = By.xpath("//select[@id='selectRecruiter']");
	By lblRecruiterErrMsg = By.xpath("//div[@id='selectRecruiter_err']");
	By mandatApprovalStar = By.xpath("//span[@id='reqMandStar']");
	By lblApprovalProcess = By.xpath("//div[@id='approvalProcessLabel']");
	By ddApprovalProcess = By.xpath("//input[@id='inp_approvalProcess']");
	By lblAprrovalProcessErrMsg = By.xpath("//div[@id='inp_approvalProcess_err']");
	By weCustomFields = By.xpath("//div[@id='custom_det']");
	By ddCustomDispalyName = By.xpath("//select[@id='124-2-1bf2afaa0d444c64a90a97bbe7adf19a']");
	By radioCustomTypeOfHire = By.xpath("//input[@id='124-2-63ddb50b12744c768c9919876ebf41eb_option1']");
	By txtAreaCustomEmpName = By.xpath("//input[@id='124-2-f4ab70050e5448c4bae880c74fd2bce9']");
	By radioCustomJobBudgeted = By.xpath("//input[@id='124-2-86def1d22efe472c9f40d49c6fd7c306_option1']");
	By weAdditionalFields = By.xpath("//div[@id='additional_det']");
	By btnCalender = By.xpath("//a[@id='124-4-6917dc7eb4ad41419e39ef72e8afb33b_date_calIc']");
	By btnCurrnentDate = By.xpath("//td[@class='today day']");
	By rdoEmploymentFullTime = By.xpath("//input[@name='employmentType' and @value='1']");
	By rdoEmploymentPartTime = By.xpath("//input[@name='employmentType' and @value='2']");
	By rdoEmploymentContract = By.xpath("//input[@name='employmentType' and @value='3']");
	By rdoVacancyNewPos = By.xpath("//input[@name='vacancyType' and @value='1']");
	By rdoVacancyReplacement = By.xpath("//input[@name='vacancyType' and @value='2']");
	By txtWorkLvl = By.xpath("//input[@id='workLevel']");
	By txtAdditionalOtherInfo = By.xpath("//input[@placeholder='Enter other information relevant for approvers and recruiters']");
	By lblOtherInfo = By.xpath("//label[text()='Other information: ']");
	By btnAddRequisition = By.xpath("//input[@id='buttonID']");
	By topApprovalProcess = By.xpath("//li[@class='pickVal active']");
	By lblKeywords = By.xpath("//label[@for='Keywords']");
	By lblJobLocation = By.xpath("//label[@for='Job Location']");
	By txtPrefillReq = By.xpath("//div[@id='ul_requestList']//a[text()='${requisitionName}']");
	By lblMinSalary = By.xpath("//select[@id='minSalary']//option[@value='${minSalary}']");
	By txtJobLoc = By.xpath("//a[text()='${jobLoc}']");
	By lblMaxSalary = By.xpath("//select[@id='maxSalary']//option[text()='${maxSalary}']");
	By lblRecruiterName = By.xpath("//select[@id='selectRecruiter']//option[text()='${recName}']");
	By lblFirstRecruiter = By.xpath("(//select[@id='selectRecruiter']//option)[2]");
	By txtSlelectGroupName = By.xpath("//option[contains(text(),'${groupName}')]");
	By txtSelectMaxWorkEx = By.xpath("//select[@id='maxExp']//option[@value='${maxWorkExp}']");
	By txtSelectMinWorkEx = By.xpath("//select[@id='minExp']//option[@value='${minWorkExp}']");
	By txtSelectApprovalProcess = By.xpath("//a[contains(text(),'${approvalProcess}')]");
	By divReqListingPage = By.xpath("//div[text()='List of Requisitions']");
	By txtCustomDisplayName = By.xpath("//option[@value='${helpTxt}']");
	private By eleFirstGroupInDD = By.xpath("(//select[@id='selectGroup']//option)[2]");
	private By txtDisplayed = By.xpath("//div[text()='${textMsg}']");
	private By txtAreaVacancy = By.xpath("//input[@id='vacancies']");
	private By txtTopRequisitionName = By.xpath("(//div[contains(@class,'process')])[1]");
	private By eleExtraClick = By.xpath("//div[@class='oh']");
	private By labelTextFields = By.xpath("//label[text()=${fielsName}']");
	private By txtAgainstLabel = By.xpath("//label[text()='${label}']/parent::div/child::div/child::div");
	private By ddPrefillFromReq = By.xpath("//div[@id='prefillRequisition']//input");
	private By txtTopPrefillSuggestion = By.xpath("(//div[contains(@class,'searchSuggestionTuple')])[1]");
	private By getTxtTopRequisitionName = By.xpath("(//div[contains(@class,'process')])[1]");
	By txtAreaSearchRequisition = By.xpath("//input[@class='textBox']");
	By eleRequisitionIdOnSearchResults = By.xpath("//div[@class='reqIDSec']//span");
	

	/**
	 * This method is used to fill requisition form without approval process
	 * attached 
	 * @param reqName
	 * @param grpName
	 * @author gupta.mansi
	 */
	public void fillRequisitionFormWithoutApprovalProcess(String reqName, String grpName) {
		List<String> keySkill = Arrays.asList("Selenium");
		fillRequisitionTitle(reqName);
		selectGroup(grpName);
		fillJobTitle("Testing Engineer");
		fillJobDetail("Job Description");
		fillCandidateDetail("Candidate Profile");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillMinSalary("50000");
		fillMaxSalary("70,000");
		fillJobLoc("Jamalpur");
		fillKeySkills(keySkill);
//		if (isCustomDetailsDisplayed()) {
//			fillCustomDetails();
//		}

		if (isAdditionalDetailsDisplayed()) {
			fillOtherInformation();
		}
		addRequisition();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to fill requisition form with approval process
	 * @author gupta.mansi
	 * @param reqName
	 * @param grpName
	 * @param approvalName
	 */
	public void fillRequisitionFormWithApprovalProcess(String reqName, String grpName, String approvalName) {
		List<String> keySkill = Arrays.asList("Selenium");
		fillRequisitionTitle(reqName);
		selectGroup(grpName);
		selectApproval(approvalName);
		fillJobTitle("Testing Engineer");
		fillJobDetail("Job Description");
		fillCandidateDetail("Candidate Profile");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillKeySkills(keySkill);
		fillMinSalary("50000");
		fillMaxSalary("70,000");
		fillJobLoc("Ahmedabad");
		if (isCustomDetailsDisplayed()) {
			fillCustomDetails();
		}

		if (isAdditionalDetailsDisplayed()) {
			fillOtherInformation();
		}
		addRequisition();
		wait.waitForPageToLoadCompletely();
	}
	public void fillRequisitionWithApprovalProcessAndSpcificToOnAccount(String grpName, String approvrName)
	{
		List<String> keySkill = Arrays.asList("Selenium");
		fillRequisitionTitle("Requisition Name");
		selectGroup(grpName);
		selectfirstRecruiterName();
		selectApproval(approvrName);
		fillJobTitle("Testing Engineer");
		fillJobDetail("Job Description");
		fillCandidateDetail("Candidate Profile");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillKeySkills(keySkill);
		fillMinSalary("50000");
		fillMaxSalary("70,000");
		fillJobLoc("Ahmedabad");
		addRequisition();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to fill custom details in requisition form
	 */
	public void fillCustomDetails() {
		customDisplayName("a");
		click(radioCustomTypeOfHire);
		getElement(txtAreaCustomEmpName).sendKeys("Filling custom details emp name");
		click(radioCustomJobBudgeted);
	}

	/**
	 * This method is used to fill requisition tile 
	 * @author gupta.mansi
	 * @param reqName
	 */
	public void fillRequisitionTitle(String reqName) {
		getElement(txtRequisitionTitle).clear();
		getElement(txtRequisitionTitle).sendKeys(reqName);
		getElement(txtRequisitionTitle).sendKeys(Keys.ENTER);
	}

	/**
	 * This method is used to get Requisition title error message
	 * @author gupta.mansi
	 * @return
	 */
	public String getRequisitionTitleErrMSg() {
		return getText(lblRequisitionTitleErrMsg);
	}

	/**
	 * This method is used to fill job title
	 * @author gupta.mansi
	 * @param jobTitle
	 */
	public void fillJobTitle(String jobTitle) {
		getElement(txtJobTitle).clear();
		getElement(txtJobTitle).sendKeys(jobTitle);
		getElement(txtJobTitle).sendKeys(Keys.ENTER);
		wait.hardWait(1);
	}

	/**
	 * This method is used to get Job title error message 
	 * @author gupta.mansi
	 * @return
	 */
	public String getJobTitleErrMSg() {
		return getText(lblJobTitleErrMsg);
	}

	/**
	 * This method is used to fill job detail
	 * @author gupta.mansi
	 * @param jobDetail
	 */
	public void fillJobDetail(String jobDetail) {
		getElement(txtJobDescription).sendKeys(jobDetail);
	}

	/**
	 * This method is used to get job detail error message
	 * @author gupta.mansi
	 * @return
	 */
	public String getJobDetailErrMSg() {
		return getText(lblJobDescriptionErrMsg);
	}

	/**
	 * This method is used to fill candidate details 
	 * @author gupta.mansi
	 * @param candidateDetail
	 */
	public void fillCandidateDetail(String candidateDetail) {
		getElement(txtCandidateDetail).sendKeys(candidateDetail);
	}

	/**
	 * This method is used to get candidate detail error message
	 * @author gupta.mansi
	 * @return Candidate Detail Error Message
	 */
	public String getCandidateDetailErrMsg() {
		return getText(lblCandidateDetailErrMsg);
	}

	/**
	 * This method is used to fill minimum work experience of candidate
	 * @author gupta.mansi
	 * @param minWorkEx
	 */
	public void fillMinWorkEx(String minWorkEx) {
		click(ddMinWorkExp);
		wait.waitForElementToBeClickable(parameterizedLocator(txtSelectMinWorkEx, minWorkEx));
		getElement(txtSelectMinWorkEx, minWorkEx).click();
	}

	/**
	 * This method is used to fill maximum work experience of a candidate
	 * @author gupta.mansi
	 * @param maxWorkEx
	 */
	public void fillMaxWorkEx(String maxWorkEx) {
		click(ddMaxWorkExp);
		wait.waitForElementToBeClickable(parameterizedLocator(txtSelectMaxWorkEx, maxWorkEx));
		getElement(txtSelectMaxWorkEx, maxWorkEx).click();
	}

	/**
	 * This method is used to get Work experience error message
	 * @author gupta.mansi
	 * @return
	 */
	public String getWorkExErrMsg() {
		return getText(lblMinWorkExpErrMsg);
	}

	/**
	 * This method is used to fill key-skills
	 * @author gupta.mansi
	 * @param keySkills
	 */
	public void fillKeySkills(List<String> keySkills) {
		jsUtil.scrollDown(clickKeyskills);
		click(clickKeyskills);
		for (String keySkill : keySkills) {
			getElement(txtKeyskills).sendKeys(keySkill);
			wait.hardWait(1);
			getElement(txtKeyskills).sendKeys(Keys.ENTER);

		}
		wait.hardWait(1);
//		click(txtKeyskills);
	}
	
	/**
	 * This method is used to click on remove all keyword button
	 * @author gupta.mansi
	 */
	public void removeAllKeywords() {
		getElement(btnRemoveAllKeywords).click();
	}

	/**
	 * This method is used to check whether a given group name is displayed or not
	 * @author gupta.mansi
	 * @param groupName
	 * @return true or false
	 */
	public boolean isGroupDisplayed(String groupName) {
		return isDisplayed(parameterizedLocator(txtSlelectGroupName, groupName));
	}

	/**
	 * This method is used to select group from DD
	 * @author gupta.mansi
	 * @param grpName
	 */
	public void selectGroup(String grpName) {
		getElement(ddGroup).click();
		wait.waitForElementToBeClickable(parameterizedLocator(txtSlelectGroupName, grpName));
		wait.hardWait(1);
		getElement(txtSlelectGroupName, grpName).click();
		wait.waitForPageToLoadCompletely();
		click(eleExtraClick);

	}

	/**
	 * This method is used to select approval process
	 * @author gupta.mansi
	 * @param approvalName
	 */
	public void selectApproval(String approvalName) {
		wait.waitForVisibilityOfElement(ddApprovalProcess);
		getElement(ddApprovalProcess).click();
		wait.waitForElementToBeClickable(parameterizedLocator(txtSelectApprovalProcess, approvalName));
		getElement(txtSelectApprovalProcess, approvalName).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to check whether approval process is mandatory or not
	 * @author gupta.mansi
	 * @return
	 */
	public boolean isApprovalMandatory() {
		if (getElements(mandatApprovalStar).size() != 0)
			return true;

		else
			return false;
	}

	/**
	 * This method is used to check whether approval dd is displayed or not
	 * @author gupta.mansi
	 * @return
	 */
	public boolean isApprovalDDDisplayed() {
		if (getElements(ddApprovalProcess).size() != 0)
			return true;
		else
			return false;
	}

	/**
	 * This method is used to check whether custom details field are present in
	 * requisition form
	 * @author gupta.mansi
	 * @return true or false
	 */
	public boolean isCustomDetailsDisplayed() {
		if (getElements(weCustomFields).size() != 0)
			return true;
		else
			return false;
	}

	public boolean isAdditionalDetailsDisplayed() {
		if (getElements(weAdditionalFields).size() != 0)
			return true;
		else
			return false;
	}

	/**
	 * This method is used to select value from DD for custom display name
	 * @author gupta.mansi
	 * @param value
	 */
	public void customDisplayName(String value) {
		getElement(ddCustomDispalyName).click();
		wait.waitForElementToBeClickable(parameterizedLocator(txtCustomDisplayName, value));
		getElement(txtCustomDisplayName, value).click();
		;
	}

	/**
	 * This method is used to select today's date in custom detail date select field
	 * @author gupta.mansi
	 */
	public void customSelectTodaysDate() {
		getElement(btnCalender).click();
		getElement(btnCurrnentDate).click();
	}

	/**
	 * This method is use to get other information text area placeholder
	 * @author gupta.mansi
	 * @return
	 */
	public String getOtherInformationTextAreaPlaceholder() {
		return getAttribute(txtAdditionalOtherInfo, "placeholder");
	}

	/**
	 * This method is use to get other information label displayed
	 * @author gupta.mansi
	 * @return
	 */
	public String getOtherInformationDisplayedLabel() {
		return getText(lblOtherInfo);
	}

	/**
	 * This method is used to fill other information in requisition form
	 * @author gupta.mansi
	 */
	public void fillOtherInformation() {
		getElement(txtAdditionalOtherInfo).sendKeys("1) Other Information Given By HM");
	}

	/**
	 * This method is used to save requisition form
	 * @author gupta.mansi
	 */
	public void addRequisition() {
		jsUtil.scrollDown(btnAddRequisition);
		wait.waitForElementToBeClickable(btnAddRequisition);
		click(btnAddRequisition);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to click on group dd
	 */
	public void clickonGroupDD() {
		jsUtil.scrollDown(ddGroup);
		wait.waitForElementToBeClickable(ddGroup);
		click(ddGroup);
	}

	/**
	 * This method is used to fill job location of candidate
	 * @author gupta.mansi
	 * @param jobLoc
	 */
	public void fillJobLoc(String jobLoc) {
		click(ddJobLocation);
		getElement(txtJobLoc, jobLoc).click();
		click(lblJobLocation);
	}

	/**
	 * This method is used to fill minimum salary of candidate
	 * @author gupta.mansi
	 * @param minSalary
	 */
	public void fillMinSalary(String minSalary) {
		getElement(lblMinSalary, minSalary).click();
	}

	/**
	 * This method is used to fill maximum salary
	 * @author gupta.mansi
	 * @param maxSalary
	 */
	public void fillMaxSalary(String maxSalary) {
		getElement(lblMaxSalary, maxSalary).click();
		wait.waitForElementToBeClickable(parameterizedLocator(lblMaxSalary, maxSalary));
		getElement(lblMaxSalary, maxSalary).click();
		wait.waitForInvisibilityOfElement(2, 3, parameterizedLocator(lblMaxSalary, maxSalary));
	}

	/**
	 * This method is used to select first recruiter name from drop down
	 */
	public void selectfirstRecruiterName() {
		click(ddRecruiter);
		getElement(lblFirstRecruiter).click();
	}

	/**
	 * This method is used to select given recruiter from drop down
	 * @param recruiterName
	 */
	public void selectRecruiter(String recruiterName) {
		click(ddRecruiter);
		getElement(lblRecruiterName, recruiterName).click();
	}

	/**
	 * This method is used to fill requisition form from pre-fill templates
	 * @param templateName
	 */
	public void selectPrefillTemplate(String templateName) {
		click(ddPrefillFromReq);
		getElement(txtPrefillReq, templateName).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to fill requisition form from pre-fill template and also
	 * fills group and recruiter name
	 * @param templateName
	 * @param groupName
	 */
	public void fillRequisitionFormWithGroup(String templateName, String groupName) {
		selectGroup(groupName);
		selectPrefillTemplate(templateName);
		selectfirstRecruiterName();
	}
	
	/**
	 * create Requisition With No Approval And first Group in DD
	 * @author udit.khanna
	 */
	public void createRequisitionWithNoApprovalAndFirstGroupInDD() {
		fillRequisitionTitle("Requisition Name");
		selectFirstGroupInDD();
		fillJobTitle("Testing Engineer");
		fillJobDetail("Job Description");
		fillCandidateDetail("Candidate Profile");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillKeySkills(Arrays.asList("Selenium"));
		fillMinSalary("50000");
		fillMaxSalary("70,000");
		fillJobLoc("Ahmedabad");
		addRequisition();
		wait.waitForPageToLoadCompletely();
	}
	
	
	/**
	 *  select First Group In DD
	 *  @author udit.khanna
	 */
	public void selectFirstGroupInDD(){
		clickonGroupDD();
		String firstGroupName = getText(eleFirstGroupInDD);
		click(eleFirstGroupInDD);
		wait.waitForProcessingToDisappear(10, 3);
		PropFileHandler.writeProperty("FirstGroupName",firstGroupName);
	}
	public void fillRequisitionFormWithoutAnyApprovalProcess(String reqName) {
		fillRequisitionTitle(reqName);
		fillJobTitle("Testing Engineer");
		fillJobDetail("Job Description");
		fillCandidateDetail("Candidate Profile");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		//fillJobLoc("Weir");
		selectFirstGroupInDD();
		if (isCustomDetailsDisplayed()) {
			fillCustomDetails();
		}

		if (isAdditionalDetailsDisplayed()) {
			fillOtherInformation();
		}
	}

	/**
	 * This method is used to fill requisition form without approval process
	 * attached 
	 * @param reqName
	 * @param grpName
	 */
	public void fillRequisitionfields(String reqName, String grpName) {
		fillRequisitionTitle(reqName);
	}	
	/**
	 * @author gupta.mansi
	 * This method return true if text in param is displayed
	 * @param txtMsg
	 * @return true if text displayed else false
	 */
	public boolean isGivenTextDisplayed(String txtMsg)
	{
		wait.waitForPageToLoadCompletely();
		click(eleExtraClick);
		wait.waitForVisibilityOfElement(parameterizedLocator(txtDisplayed, txtMsg));
		return isDisplayed(parameterizedLocator(txtDisplayed, txtMsg));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to fill vacancy
	 * @param vacancy
	 */
	public void fillVacancy(String vacancy)
	{
		getElement(txtAreaVacancy).clear();
		getElement(txtAreaVacancy).sendKeys(vacancy);
	}

	/**
	 * @author gupta.mansi
	 * This method return the name of the requisition displayed on top on Requisition Listing page
	 * @return String Requisition name
	 */
	public String getTheNameOfTopRequisition()
	{
		return getText(txtTopRequisitionName);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to create requisition from prefilling it and selection first group
	 * @param reqName
	 */
	public void createRequisitionWithTopTemplateAndFirstGroupInDD(String reqName) {
		fillRequisitionTitle(reqName);
		selectFirstGroupInDD();
		prefillFromTopRequistion();
		addRequisition();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method return text displayed against given label
	 * @param label
	 * @return text
	 */
	public String getTextDisplayedAgainstLabel(String label)
	{
		return getText(parameterizedLocator(txtAgainstLabel, label));
	}
	
	/**
	 * @author gupta.mansi
	 * This method clicks on prefill dd and selects to suggestion template or requisition 
	 */
	public void prefillFromTopRequistion()
	{
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(ddPrefillFromReq);
		click(ddPrefillFromReq);
		wait.waitForVisibilityOfElement(txtTopPrefillSuggestion);
		click(txtTopPrefillSuggestion);
		click(eleExtraClick);
	}

	/** create Requisition With No Approval And First Group In DD And Location Selected
	 * @param location
	 * @author udit.khanna
	 */
	public void createRequisitionWithNoApprovalAndFirstGroupInDDAndLocationSelected() {
		fillRequisitionTitle("Requisition Name");
		selectFirstGroupInDD();
		wait.hardWait(2);
		fillJobTitle("Testing Engineer");
		fillJobDetail("Job Description");
		fillCandidateDetail("Candidate Profile");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillKeySkills(Arrays.asList("Selenium"));
		fillMinSalary("50000");
		fillMaxSalary("70000");
		fillJobLoc("Ahmedabad");
		
		addRequisition();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * This method is used to click on prefill dd on raise requisition page
	 */
	public void clickPrefillFromOtheirRequisitionOrTemplateDD()
	{
		click(ddPrefillFromReq);
	}

	public void clickOnRequisitionOnListingPage()
	{
		wait.waitForElementToBeClickable(getTxtTopRequisitionName);
		click(getTxtTopRequisitionName);
	}
	public static String fileSystemPathTillTestData() {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator;
		return filePath;
	}
	public void userSearchedRequisitionWIthID()
		{
			String requisitionID = "rs-" + ReadWritePropertyFile.getProperty("RequirementTrackingId",
				fileSystemPathTillTestData() + "Data.properties");
			click(txtAreaSearchRequisition);
			getElement(txtAreaSearchRequisition).sendKeys(requisitionID);
			//click(By.id("searchIcon"));
			wait.hardWait(3);
			getElement(txtAreaSearchRequisition).sendKeys(Keys.ENTER);
		}

	public boolean verifyRequisitionSearchableFromID()
	{
		wait.waitForVisibilityOfElement(eleRequisitionIdOnSearchResults);
		String requisitionID = "rs-" + ReadWritePropertyFile.getProperty("RequirementTrackingId",
				fileSystemPathTillTestData() + "Data.properties");
		return getText(eleRequisitionIdOnSearchResults).contains(requisitionID);
	}

}
