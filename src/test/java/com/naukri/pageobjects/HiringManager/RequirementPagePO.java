package com.naukri.pageobjects.HiringManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

public class RequirementPagePO extends BaseAutomation {

	CommonAction commonActionObject = new CommonAction();
	RequirementCreationPagePO requirementCreation = (RequirementCreationPagePO) PageObjectWrapper.getObject(RequirementCreationPagePO.class);

	By txtRequirementTitle = By.xpath("//input[@id='projectName']");
	By txtReqList = By.id("inp_projectList");
	By DesignationTxt = By.xpath("//input[@id='title']");
	By JobDescriptionTxt = By.xpath("//div[@id='editButdescription_editor']/..//iframe[@id='description_editor']");
	By ddlMinSalary = By.xpath("//select[@id='minSalary']");
	By lblSelectSalary = By.xpath("//option[@value='50000']");
	By ddlMaxSalary = By.xpath("//select[@id='maxSalary']");
	By ddMinWorkExp = By.xpath("//select[@id='minExp']");
	By ddMaxWorkExp = By.xpath("//select[@id='maxExp']");
	By lblWorkEx = By.xpath("//option[@value='1']");
	By txtKeywords = By.xpath("//div[@id='keywordDiv']");
	By ddlJobLoc = By.xpath("//input[@id='inp_cityIds']");
	By chkJobLoc = By.xpath("//a[text()='Silchar']");
	By ddlGroup = By.xpath("//input[@id='inp_hiringFordd']");
	By extraClick = By.xpath("//h1[text()='Additional Details']");
	By visibilityDD = By.xpath("//select[@id='visToMe']");
	By visibleOnlyToMe = By.xpath("//select[@id='visToMe']//option[@value='2']");
	By visibleToAll = By.xpath("//select[@id='visToMe']//option[@value='1']");
	By visibleToSelected = By.xpath("//select[@id='visToMe']//option[@value='3']");
	By ddSelectRecruiter = By.xpath("//input[@id='inp_selListAndAddBtn']");
	By selectRecruitersForVisibilityCB = By.xpath("//a[text()='${recruiterName}']");
	By txtSelectMaxWorkEx = By.xpath("//select[@id='maxExp']//option[@value='${maxWorkExp}']");
	By txtSelectMinWorkEx = By.xpath("//select[@id='minExp']//option[@value='${minWorkExp}']");
	By ddJobLocation = By.xpath("//input[@id='inp_cityIds']");
	By lblJobLocation = By.xpath("//label[@for='Job Location']");
	By lblVisibilitySetting = By.xpath("//label[text()='Visibility Setting: ']");
	By txtJobLoc = By.xpath("//a[text()='${jobLoc}']");
	By ddGroup = By.xpath("//input[@id='inp_hiringFordd']");
	By txtSlelectGroupName = By.xpath("//a[contains(text(),'${groupName}')]");
	By clickKeyskills = By.xpath("//a[@id='hlpTxtTag']");
	By txtKeyskills = By.xpath("//input[@id='keyword']");
	By lblKeywords = By.xpath("//label[@for='Keywords']");
	By btnAddRequirement = By.xpath("//input[@id='buttonID']");
	By ddlIndustry = By.xpath("//input[@id='inp_industrydd']");
	By ddlFunctionalArea = By.xpath("//input[@id='inp_fareadd']");
	By ddlJobRole = By.xpath("//input[@id='inp_froledd']");
	By btnSaveRequirement = By.xpath("//input[@value='Save Requirement']");
	By lblMinSalary = By.xpath("//select[@id='minSalary']//option[@value='${minSalary}']");
	By lblMaxSalary = By.xpath("//select[@id='maxSalary']//option[@value='${maxSalary}']");
	By pathMore = By.xpath("//span[contains(@class,'moreIc')]");
	By pathAddSingleProfile = By.xpath("//ul[@class='subNav']//a[@class='addSingleCandidate']");
	By txtEmail = By.xpath("//input[@id='emilBlock_0']");
	By btnSaveCandidate = By.xpath("//input[@id='editCandBasicButton']");
	By btnCreateRequirementFromRequisition = By.xpath("//div[text()='${reqName}']/../../..//a[text()='Create Requirement']");
	By txtAreaQuickSearchRequirement = By.xpath("//input[@id='keywords']");
	By btnRequirementOverview = By.xpath("//a[text()='Requirement Overview']");
	By txtAreaJD = By.xpath("//body");
	By eleProcessingOverlay = By.xpath("//div[contains(@class,'processing-overlay')]");
	/**
	 * This method create a requirement from pre-fill requirement. It also saved the
	 * requirement it to Requirement Id
	 * @author gupta.mansi
	 * @param grpName
	 * @param requirementName
	 * @param prefillRequirementName
	 */
	public void createRequirement(String grpName, String requirementName, String prefillRequirementName) {

		commonActionObject.navigateToUrl(URLBuilder.getURL("addANewRequirement"));
		TestNGLogUtility.info("User is on create a requirement page");
		getElement(txtRequirementTitle).sendKeys(requirementName);
		getElement(txtReqList).click();
		getElement(txtReqList).clear();
		getElement(txtReqList).clear();
		getElement(txtReqList).click();
		getElement(txtReqList).sendKeys(prefillRequirementName);
		wait.hardWait(1);
		getElement(txtReqList).sendKeys(Keys.ENTER);
		wait.waitForPageToLoadCompletely();
		requirementCreation.clickEmploymentTypeDD();
		requirementCreation.clickEmploymentTypeOptionfromList("Full Time, Freelance/Homebased");
		jsUtil.scrollToElement(ddlGroup);
		wait.waitForElementToBeClickable(ddlGroup);
		getElement(ddlGroup).click();
		getElement(ddlGroup).clear();
		getElement(ddlGroup).sendKeys(grpName);
		getElement(ddlGroup).sendKeys(Keys.ENTER);
		wait.waitForOverlayProcessingToDisappear(2, 4);
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollToElement(btnAddRequirement);
		wait.waitForElementToBeClickable(btnAddRequirement);
		wait.waitForProcessingToDisappear(1, 3);
		wait.waitForInvisibilityOfElement(2, 2, eleProcessingOverlay);
		getElement(btnAddRequirement).click();
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(btnRequirementOverview);
		click(btnRequirementOverview);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method returns requirement Id from requirement creation's job posting
	 * page
	 * @return String
	 */
	public String getRequirementIdWhenCreatingRequirement() {
		try {
			URL aURL = new URL(getCurrentURL());
			String[] queryParams = aURL.getQuery().split("&");
			String[] idAndValue = queryParams[0].split("=");
			PropFileHandler.writeProperty("RequirementId", idAndValue[1]);
			return idAndValue[1];

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "Unable to find requirement Id";
		}
	}

	/**
	 * This method creates a requirement
	 * @param grpName
	 * @param requirementName
	 * @param visibility
	 * @author gupta.mansi
	 */
	public void createRequirementWithGroup(String grpName, String requirementName, String visibility, String... recruiterNames) {
		getElement(txtRequirementTitle).sendKeys(requirementName);
		requirementCreation.clickEmploymentTypeDD();
		requirementCreation.clickEmploymentTypeOptionfromList("Full Time, Freelance/Homebased");
		fillJobTitle("Job Title");
		fillJobDescription("Job Detail");
		fillMinSalary("50000");
		fillMaxSalary("70000");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillKeySkills(new ArrayList<String>(Arrays.asList("Java")));
		fillJobLoc("Ahmedabad");
		selectGroup(grpName);
		setVisibility(visibility, recruiterNames);
		getElement(btnAddRequirement).click();
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(btnRequirementOverview);
		click(btnRequirementOverview);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method creates requirement with no group filled
	 * @param requirementName
	 * @param prefillRequirementName
	 * @param visibility
	 * @return reqId
	 * @author gupta.mansi
	 */
	public String createRequirementWithNoGroup(String requirementName, String visibility, String... recruiterNames) {
		getElement(txtRequirementTitle).sendKeys(requirementName);
		requirementCreation.clickEmploymentTypeDD();
		requirementCreation.clickEmploymentTypeOptionfromList("Full Time, Freelance/Homebased");
		fillJobTitle("Job Title");
		fillJobDescription("Job Detail");
		fillMinSalary("50000");
		fillMaxSalary("70000");
		fillMinWorkEx("1");
		fillMaxWorkEx("3");
		fillKeySkills(new ArrayList<String>(Arrays.asList("Java")));
		fillJobLoc("Ahmedabad");
		setVisibility(visibility, recruiterNames);
		getElement(btnAddRequirement).click();
		wait.waitForPageToLoadCompletely();
		String reqId = getRequirementIdWhenCreatingRequirement();
		wait.waitForVisibilityOfElement(btnRequirementOverview);
		click(btnRequirementOverview);
		wait.waitForPageToLoadCompletely();
		return reqId;

	}

	/**
	 * This method is used to fill key skills
	 * @author gupta.mansi
	 * @param keySkills
	 */
	public void fillKeySkills(List<String> keySkills) {
		// click(clickKeyskills);
		for (String i : keySkills) {
			click(clickKeyskills);
			getElement(txtKeyskills).sendKeys(i);
			getElement(txtKeyskills).sendKeys(Keys.ENTER);
		}
		click(lblKeywords);
	}

	/**
	 * This method is used to fill job location
	 * @param jobLoc
	 * @author gupta.mansi
	 */
	public void fillJobLoc(String jobLoc) {
		click(ddJobLocation);
		getElement(txtJobLoc, jobLoc).click();
		click(lblJobLocation);
	}

	/**
	 * This method is used to select group name from dd
	 * @param grpName
	 * @author gupta.mansi
	 */
	public void selectGroup(String grpName) {
		jsUtil.scrollDown(ddGroup);
		click(ddGroup);
		wait.waitForElementToBeClickable(parameterizedLocator(txtSlelectGroupName, grpName));
		getElement(txtSlelectGroupName, grpName).click();
		wait.waitForPageToLoadCompletely();

	}

	/**
	 * This method is used to fill maximum salary
	 * @param maxSalary
	 * @author gupta.mansi
	 */
	public void fillMaxSalary(String maxSalary) {
		getElement(lblMaxSalary, maxSalary).click();
		wait.waitForElementToBeClickable(parameterizedLocator(lblMaxSalary, maxSalary));
		getElement(lblMaxSalary, maxSalary).click();
		wait.waitForInvisibilityOfElement(2, 3, parameterizedLocator(lblMaxSalary, maxSalary));
	}

	/**
	 * This method is used to fill minimum salary
	 * @param minSalary
	 * @author gupta.mansi
	 */
	public void fillMinSalary(String minSalary) {
		getElement(lblMinSalary, minSalary).click();
	}

	/**
	 * This method is used to fill maximum work experience
	 * @param maxWorkEx
	 * @author gupta.mansi
	 */
	public void fillMaxWorkEx(String maxWorkEx) {
		click(ddMaxWorkExp);
		wait.waitForElementToBeClickable(parameterizedLocator(txtSelectMaxWorkEx, maxWorkEx));
		getElement(txtSelectMaxWorkEx, maxWorkEx).click();
	}

	/**
	 * This method is used to fill minimum work experience
	 * @param minWorkEx
	 * @author gupta.mansi
	 */
	public void fillMinWorkEx(String minWorkEx) {
		click(ddMinWorkExp);
		wait.waitForElementToBeClickable(parameterizedLocator(txtSelectMinWorkEx, minWorkEx));
		getElement(txtSelectMinWorkEx, minWorkEx).click();
	}

	/**
	 * This method is used to select the visibility for the requirement
	 * @param visibility
	 * @param recruiterNames
	 */
	public void setVisibility(String visibility, String... recruiterNames) {
		wait.hardWait(4);
		wait.waitForElementToBeClickable(lblVisibilitySetting);
		click(lblVisibilitySetting);
		click(visibilityDD);
		switch (visibility) {
		case "Visible to Only Me":
			click(visibleOnlyToMe);
			break;
		case "Visible to All in Group":
			click(visibleToAll);
			break;
		case "Visible to Selected People":
			click(visibleToSelected);
			jsUtil.scrollMid(ddSelectRecruiter);
			click(ddSelectRecruiter);
			for (String recruiterName : recruiterNames)
				getElement(selectRecruitersForVisibilityCB, recruiterName).click();
			break;
		}
	}

	/**
	 * This method is used to fill job title
	 * @param jobTitle
	 * @author gupta.mansi
	 */
	public void fillJobTitle(String jobTitle) {
		getElement(DesignationTxt).sendKeys(jobTitle);
		getElement(DesignationTxt).sendKeys(Keys.ENTER);
	}

	/**
	 * This method is used to fill job description
	 * @param jobDetail
	 * @author gupta.mansi
	 */
	public void fillJobDescription(String jobDetail) {
		jsUtil.scrollDown(JobDescriptionTxt);
		switchToFrame(JobDescriptionTxt);
		getElement(txtAreaJD).sendKeys(jobDetail);
		switchToDefaultContent();
	}

	/**
	 * This method adds a single profile from Requirement overview page
	 * @author gupta.mansi
	 * @param reqId
	 */
	public void addSingleProfile(String reqId, String candidateEmailId) {
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollUp();
		actionBuilderUtil.hoverByActionAlternate(pathMore);
		click(pathMore);
		getElement(pathAddSingleProfile).click();
		wait.waitForPageToLoadCompletely();
		getElement(txtEmail).sendKeys(candidateEmailId);
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollDown(btnSaveCandidate);
		mouseHoverToWebElement(getElement(btnSaveCandidate));
		click(btnSaveCandidate);
	}

	/**
	 * This method is used to logout of rms
	 * @author gupta.mansi
	 */
	public void logout() {
		goToPageURL("https://login.recruit.naukri.com/Login/smLogout");
	}

	/**
	 * This method is used to create requirement from requisition
	 * @param requisitionName
	 * @author gupta.mansi
	 */
	public void createRequirementFromRequisition(String requisitionName) {
		wait.waitForPageToLoadCompletely();
		getElement(btnCreateRequirementFromRequisition, requisitionName).click();
		switchToChildWindow();
		requirementCreation.clickEmploymentTypeDD();
		requirementCreation.clickEmploymentTypeOptionfromList("Full Time, Freelance/Homebased");
		getElement(btnAddRequirement).click();
		RequirementCreationPagePO.requirementDetails.put("requirementName", requisitionName);
		PropFileHandler.writeProperty("requirementNameCreatedAfterRequisition",requisitionName);
	}

	/**
	 * This method is used to quick search requirement
	 * @param reqName
	 * @author gupta.mansi
	 */
	public void quickSearchRequirement(String reqName) {
		getElement(txtAreaQuickSearchRequirement).click();
		getElement(txtAreaQuickSearchRequirement).sendKeys(reqName);
		getElement(txtAreaQuickSearchRequirement).sendKeys(Keys.ENTER);
	}

	/**
	 * This method clicks on add/next requirement button
	 */
	public void clickOnAddRequirementButton() {
		wait.waitForElementToBeClickable(btnAddRequirement);
		click(btnAddRequirement);
		wait.waitForPageToLoadCompletely();
	}

}
