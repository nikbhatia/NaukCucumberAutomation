package com.naukri.pageobjects.Requirements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.CustomizeSelectionStagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.PageObjectWrapper;

import io.netty.handler.timeout.TimeoutException;

import static com.naukri.pageobjects.Requirements.RequirementCreationPagePO.requirementDetails;

/**
 * Requirement Overview Page
 * @author rachit.mehrotra
 *
 */
public class RequirementOverviewPagePO extends PageObjectWrapper {
	
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	AssessmentPartnerIntegrationPO objAssessmentPartnerIntegrationPO = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);
	Actions builder = new Actions(driver);
	boolean flag=false;
	
	By lstActionOptionsForJob = By.xpath("//div[text()='${string}   ']/ancestor::li[@class='cle jListWrap']//ul[@class='manage cle']/li");
	By eleAssignVendor = By.xpath("//a[contains(text(),\"Assign Vendor\")]");
	By eleVendorAssignmentSuccessMessage = By.id("vendorSuccess");
	By eleRequirementDetailsTab = By.id("smtabRequirement");
	By getRequisitionDetailsTab = By.id("smtabRequisition");
	By eleTabsHeadingOnRequirementOverview = By.xpath("//div[contains(text(),'${tabHeadingText}')]");
	By eleSalaryHolder = By.xpath("//p[contains(text(),'${replace}')]");
	By eleJobOptionOnRequirementOverview = By.xpath("//small[contains(@title,'${jobPlatformType}')]/parent::div/following-sibling::div//a[contains(text(),'${jobOption}')]");
	private By txtComments=By.id("smtabComments");
	private By lblCommentsProvided=By.xpath("//p[contains(.,'${commentsProvided}')]");
	private By btnViewOfNaukriPrivateJob=By.xpath("//ul[@class='manage cle']//li/a[text()='View']");
	private By btnLoginToApply=By.id("logToApp");
	private By txtUserName=By.xpath("//div[@class='drawer-wrapper']//form//input[@placeholder[contains(.,'Username')]]");
	private By txtPassword=By.xpath("//div[@class='drawer-wrapper']//form//input[@placeholder[contains(.,'password')]]");
	private By btnLogin=By.xpath("//button[@type='submit']");
	private By btnApplyOnNaukri=By.xpath("//div[@class='apply-button-container']//button[@class[contains(.,'apply-button')]]");
	private By eleApplyCount=By.xpath("(//small[@title='Naukri Private Job']/../following-sibling::div//a[contains(.,'${count}')])[1]");
	private  By txtCommentSection=By.id("commentsTextArea");
	private By btnAddComment=By.xpath("//a[@onclick[contains(.,'addComments')]]");
	private By btnPost=By.xpath("//div[@class[contains(.,'btnOuter')]]/a[text()='Post']");
	private By rdoRadioQuestions = By.xpath("//input[@type='radio']");
	private By chkCheckboxQuestions = By.xpath("//input[@type='checkbox']");
	private By ddlDropdownQuestionnaireList=By.xpath("//ul[contains(@id,'q')]/li[1]/a");
	private By dropdownQuestionsdesktop=By.xpath("//select/option[2]");
	private By textQuestionpwa=By.xpath("//input[@type='text']");
	private By textQuestiondesktop=By.xpath("//div[@id='imsLBCnt']//input[@type='text']");
	private By btnSubmitQuestionnaireButton=By.id("qusSubmit");
	private By btnSelectdate=By.xpath("(//div[@class=\"datepicker-days\"]//tr//td[contains(.,'10')])[1]");
	private By txtHomeCity=By.id("CUSTOM-CUSTOMHOMECITY");
	private By txtGraduationDate=By.xpath("(//div[@class=\"datepicker-days\"]//tr//td[contains(.,'10')])[1]");
	private By eleDatePicker=By.xpath("//div[@class[contains(.,'datepicker-dropdown')]]");
	private By eleQuestionnirePopUp=By.id("imsLBMain");
	private By btnEditOnRequirementOverViewPage=By.xpath("(//a[@id='addNwReq'])[1]");
	private By btnNext=By.id("buttonID");
	private By btnSaveRequirement=By.xpath("//input[@value='Save Requirement']");
	private By chkJobtitleOnUpdatePostedJobsPopUp=By.xpath("//input[@class[contains(.,'updateJobChk')]]");
	private By btnUpdateOnUpdatePostedJobsPopUp =By.id("choose_project");
	By selectionStageTab = By.id("smtabStages");
	By eleMainSelectionStageText = By.xpath("//div[contains(@id,\"stageSelectDiv\")]/div//div[contains(@class,\"acc_head_title\")]");
	By eleCountOfSelectionStage = By.xpath("//div[contains(@class,\"stageCount\")]");
	By eleSubStageCount = By.xpath("(//div[contains(@class,'stageCount dIb')])[${count}]");
	By eleMainSelectionStageLocator = By.xpath("//div[contains(@class,\"acc_head_title\") and contains(text(),'${selectionStage}')]");
	By eleSelectionSubStage = By.xpath("(//div[contains(text(),'${mainStage}')]/parent::div/following-sibling::div//div[contains(@class,\"subName\")])[${count}]");
	By eleSelectionSubStageContainer = By.xpath("//ul[contains(@class,\"sortable source\")]");
	By eleActionTypeButtonHolder = By.xpath("//a[contains(text(),'${actionType}')]");
	By eleViewQuestionnaire= By.xpath("//a[text()='View Questionnaire ']");
	By eleQuestionnaireName= By.xpath("//a[text()='View Questionnaire ']/preceding-sibling::strong");
	By eleTabsOnOverviewPage=By.xpath("//ul[@id='tabNavContainer']//a[contains(text(),'${tabNAme}')]");
	By elePreviewPage = By.xpath("//label[text()='${keyValue}']/following-sibling::p");
	By elefieldOnOverviewPage=By.xpath("//ul[@class='requireDetail']//div[contains(text(),'${value}')]");
	By elefieldValueOnOverviewPage=By.xpath("//ul[@class='requireDetail']//div[contains(text(),'${value}')]/following-sibling::p");
	By eleWalkinSectionfieldsOnOverviewPage=By.xpath("//strong[contains(text(),'${value}')]");
	By eleMapUrlOnOverviewPage=By.xpath("//a[contains(text(),'view on Map')]");
	By eleJobTitleOverviewPage= By.xpath("//div[text()='${jobTitle}']");
	By chkUpdatePostedJob = By.xpath("//small[@class='keyIc ml15 fl']/preceding-sibling::input");
	By btnUpdatePostedJobsSave = By.xpath("//input[@id='choose_project']");
	By btnResponseFilter = By.id("applyResponseFilter");
	By eleReqStatus = By.xpath("(//div[@class='fl projectStatus pRel']//a)[1]");
	By txtStageName = By.xpath("((//div[text()='${stageName}'])[2]//parent::div//parent::div)[1]");
	By ddStatusChange = By.xpath("//small[contains(@class,'dropArrow')]");
	By eleResponseFiltersTab = By.id("smtabFilters");
	By eleLocations = By.xpath("//div[contains(text(),\"Locations:\")]//following-sibling::p");
	By eleExpiredJob = By.xpath("//small[contains(@title,'${string}')]/parent::div/following-sibling::div//span[contains(text(),'Expired')]");
	By elecrossOnUpdateJobsLightbox = By.id("closeBtn3");
	By btnSaveVisibilty= By.id("submitReq");
	//By elevisibleTo = By.xpath("(//strong[text()=\"Visible to:\"]/preceding-sibling::br)[3]");
	By elevisibleTo = By.xpath("//strong[text()=\"Visible to:\"]/..");
	By btnSetVisibilty = By.id("setVisReq");
	By getProjectIdFromPage = By.id("projectId");
	By eleActionsOnOverview = By.xpath("//div[@class='btnOuter cle ']//a[contains(text(),'${string}')]");
	By eleSubOptionsOnOverview = By.xpath("//ul[@class='subNav']//a[text()='${string}']");
	By eleSelectionStage = By.xpath("//div[text()='${string}']/ancestor::div[contains(@class,'stageFld')]");
	By getTotalQuestionOnOverviewPage = By.xpath("//strong[text()='Q:']");
	By eleQuestionaireTab = By.id("smtabQuestionaire");
	By commentOnOverviewPage = By.xpath("//p[text()='${string}']");
	By eleResponseFilterValues = By.xpath("(//h6[text()='${string}']/following-sibling::p)[1]");
	//By eleRequirementStatus = By.xpath("(//div[contains(@class,'projectStatus')]//a)[1]");
	By StatusDDOnOverview = By.xpath("//ul[@class='subNav ']//a[text()='${string}']");
	By btnCloseRquirement = By.id("CloseSingle");
	By eleNotPostedkey = By.className("ready");
	By elePostedKey = By.xpath("//em[@class='publish']");
	By eleJobTitleNaukri = By.xpath("//h1[@class='jd-header-title']");
	By txtSelectRecruiterOverview = By.xpath("//input[@id='recIdsForVisibilitySetting' and @class='srchTxt'] ");
	By DDSelectRecruiterOverview= By.xpath("//ul[@class='DDsearch']");
	By chkselectRecruiterName = By.xpath("//li[@class='pickVal active']");
	By eleHistoryIcon = By.xpath("//a[contains(@class,'history')]");
	By eleHistoryRow = By.xpath("//ul[@class='subNav']//li[@class='ml5 mr5']");
	By eleFiltersSearchResultsPage = By.xpath("//span[@class='f11 c8']");
	By btntabOnOverview = By.xpath("//*[text()='${btnName}']");
	By eleReqDetailsDesc = By.xpath("//div[contains(text(),'${string}')]/following-sibling::*[position()=1]");
	By eleKeyword = By.xpath("//span[@class='tabLIBlue']");

	//variable
	final String vendorName = "vendorsent1";
	final String vendorNameHelperText = "vendorsent1";
	List<String> selectionStageMainText = new ArrayList<String>();
	LinkedHashMap<String, List<String>> selectionStageMappingRequirement = new LinkedHashMap<String, List<String>>();
	
	public static String requirementId = "";
	
	/**
	 * To verify the option list present under the jobs on the requirement overview page
	 * @author rachit.mehrotra
	 * @param optionList the list of option present in the feature file 
	 * @return boolean 
	 **/
	public boolean verifyListOfOptionPresentForAJob(String optionsList, String job) {
		List<String> listOfOptionsExpected = Arrays.asList(optionsList.split(","));
		List<WebElement> listOfOptionsOnUi = getElements(parameterizedLocator(lstActionOptionsForJob,job));
		for(int i = 0 ; i < listOfOptionsExpected.size() ; i++) {
			if(!listOfOptionsExpected.get(i).contains(listOfOptionsOnUi.get(i).getText()))
				return false;
		}
		return true;
	}

	/**
	 * To click the option of job depending on the job type
	 * @author rachit.mehrotra
	 * @param jobOption
	 * @param jobPlatformType
	 */
	public void clickOnJobOPtionForAJob(String jobOption, String jobPlatformType) {
		click(parameterizedLocator(eleJobOptionOnRequirementOverview, jobPlatformType, jobOption));
	}
	
	/**
	 * to click on assign vendor and fetch the requirement id out of the requirement overview page URL
	 */
	public void clickAssignVendorOnRequirmentOverviewPage() {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(getCurrentURL());
		requirementId = matcher.group(0);
		click(eleAssignVendor);
	}
	
	/**
	 * To verify the success message after assigning the requirement to vendor
	 * @param expectedSuccessMessage
	 * @return true/false basis the comparison
	 */
	public boolean verifyTheSuccessMessage(String expectedSuccessMessage) {
		return getText(eleVendorAssignmentSuccessMessage).contains(expectedSuccessMessage);
	}
	
	/**
	 * To click on the tabs of the requirement overview page
	 * @param tabname
	 */
	public void clickOnTabOnRequirementOverviewPage(String tabname) {
		wait.waitForPageToLoadCompletely();
		switch(tabname) {
		case "Requirement Details" : 
			click(eleRequirementDetailsTab);
			break;
		case "Comments" : 
			click(txtComments);
			break;
		case "Edit" : 
			click(btnEditOnRequirementOverViewPage);
			break;
		case "Next" : 
			click(btnNext);
			break;
		case "Save Requirement" : 
			click(btnSaveRequirement);
			break;
		case "Job Title" : 
			click(chkJobtitleOnUpdatePostedJobsPopUp);
			break;
		case "Update" : 
			click(btnUpdateOnUpdatePostedJobsPopUp);
			break;
		case "Selection Stages" :
			wait.waitForElementToBeClickable(selectionStageTab);
			click(selectionStageTab);
			wait.waitForPageToLoadCompletely();
			break;
		case "Response Filters":
			click(eleResponseFiltersTab);
			break;
		}
		wait.hardWait(10);
	}
	
	/**
	 * To verify the requirement heading available on the requirement details tab
	 * @param headingText
	 * @return true/false basis on comparison
	 */
	public boolean verifyTheTextOfTabsOnRequirementOverviewPage(String headingText) {
		return isDisplayed(parameterizedLocator(eleTabsHeadingOnRequirementOverview, headingText));
	}
	
	/**
	 * To verify the expected CTC on the requirement details page
	 * @param expectedText
	 * @return true/false basis comparison
	 */
	public boolean verifyTheTextOfSalaryForRequirementOnRequirementDetailsTab(String expectedText) {
		jsUtil.scrollToElement(parameterizedLocator(eleSalaryHolder, expectedText.replace("Annual CTC: ", "").trim()));
		return isDisplayed(parameterizedLocator(eleSalaryHolder, expectedText.replace("Annual CTC: ", "").trim())) && 
				getText(parameterizedLocator(eleSalaryHolder, expectedText.replace("Annual CTC: ", "").trim())).equals(expectedText);	
	}
	
	/**
	 * Inner class to manage the assign vendor lightbox
	 * @author rachit.mehrotra
	 *
	 */
	public class AssignVendorPagePO{
		By eleAssignVendorLightboxHeading = By.xpath("//span[contains(text(),\"Assign Requirement: \")]");
		By eleAssignVendorSpan = By.xpath("//span[contains(text(),\"Select Vendors\")]");
		By eleAssignVendorName = By.xpath("//input[contains(@placeholder,\"Search here\")]");
		By eleSuggestorForVendorName = By.xpath("//div[contains(@class,\"select-list\")]//label/div[contains(text(),'${vendorName}')]");
		By btnAssignVendor = By.xpath("//button[contains(text(),\"ASSIGN\")]");
		
		/**
		 * To verify the display of the vendor lightbox
		 * @param actualHeadingText
		 * @return true/false basis the comparison
		 */
		public boolean verifyTheDisplayOfAssignVendorLightbox(String actualHeadingText) {
			return isDisplayed(eleAssignVendorLightboxHeading) && getText(eleAssignVendorLightboxHeading).replaceAll("\n", "").contains(actualHeadingText);
		}
		
		/**
		 * To assign a requirement to vendor by selecting the vendor name
		 */
		public void assignRequirementToVendor() {
			wait.waitForValignWrapperToDisappear(10,3);
			click(eleAssignVendorSpan);
			sendKeys(eleAssignVendorName, vendorNameHelperText);
			click(parameterizedLocator(eleSuggestorForVendorName, vendorName));
		}
		
		/**
		 * To click assign vendor button on the vendor assignment lightbox
		 */
		public void clickAssignButton() {
			click(btnAssignVendor);
		}
		
	}
	/**
	 * To enter comments on Comment section of Requirement Overview page
	 * 
	 * @author abhishek.dwivedi
	 * @param comments given
	 */
	public void enterCommentsOnRequiremntOverviewPage(String comments) {
		sendKeys(txtCommentSection,comments);
		click(btnAddComment);
	}
	/**
	 * To verify the comment is visible on the page
	 * @author abhishek.dwivedi
	 * @param comment given
	 * @return true/false 
	 */
	public boolean isCommentDisplayed(String commentGiven) {
		return isDisplayed(lblCommentsProvided,commentGiven);
	}
	/**
	 * To click Naukri Premium Job view link on Requirement Overview page
	 * And switch to the window
	 * @author abhishek.dwivedi
	 */
	public void clickViewButtonOfNaukriPrivateJob() {
		click(btnViewOfNaukriPrivateJob);
		switchToChildWindow();
	}
	
	/**
	 * This method use to click on "Login  to apply" button 
	 * Then Enter user name and password and hit enter
	 * Click on Apply button to apply to this job
	 * And switch to the window
	 * @author abhishek.dwivedi
	 * @param username , password
	 */
	public void loginAndApplyForNaukriPrivateJob(String userName,String password) {
		wait.waitForPageToLoadCompletely();
		click(btnLoginToApply);
		sendKeys(txtUserName, userName);
		sendKeys(txtPassword, password);
		click(btnLogin);
		if(isDisplayed(eleQuestionnirePopUp)) {
			fillQuestionnaire();
		}
		switchToParentWindow();
		pageRefresh();
	}

	/**
	 * To verify count against Naukri private job is equal to one
	 * 
	 * @author abhishek.dwivedi
	 * 
	 * @return true/false
	 */
	public boolean isApplyCountIncreased() {
		objAssessmentPartnerIntegrationPO.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleApplyCount, "1"), 10);
		if (getText(parameterizedLocator(eleApplyCount, "1")).equals("1")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * To click Apply count against Naukri private job And switch to the window When
	 * count is equal to one
	 * 
	 * @author abhishek.dwivedi
	 * 
	 * @return true/false
	 */
	public boolean clickOnCountOfNaukriPrivateJob() {
		objAssessmentPartnerIntegrationPO.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleApplyCount, "1"), 10);
		if (getText(parameterizedLocator(eleApplyCount, "1")).equals("1")) {
			click(parameterizedLocator(eleApplyCount, "1"));
			switchToChildWindow();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * To click on Post button of Requirement Overview page
	 * 
	 * @author abhishek.dwivedi
	 */
	public void clickPostButton() {
		click(btnPost);

	}
	/**
	 * This method use to fill Questionnaire on Naukri paltform
	 * @author abhishek.dwivedi
	 */

	public void fillQuestionnaire() {
		try {

			if (getElements(rdoRadioQuestions).size() > 0) {
				for (WebElement webElement : getElements(rdoRadioQuestions)) {
					jsUtil.executeJavascript("arguments[0].click();", webElement);
				}
			}
			if (getElements(chkCheckboxQuestions).size() > 0) {
				for (WebElement webElement : getElements(chkCheckboxQuestions)) {
					jsUtil.executeJavascript("arguments[0].click();", webElement);
				}
			}
			if (getElements(textQuestionpwa).size() > 0) {
				for (WebElement webElement : getElements(textQuestionpwa)) {
					webElement.click();
					if (isDisplayed(eleDatePicker)) {
						click(btnSelectdate);
						wait.hardWait(3);
					} else {
						jsUtil.executeJavascript("arguments[0].value='Question Has been Answered';", webElement);
						wait.hardWait(3);
					}
				}
			}

			if (getElements(dropdownQuestionsdesktop).size() > 0) {
				for (WebElement webElement : getElements(dropdownQuestionsdesktop)) {
					if (webElement.isDisplayed()) {
						webElement.click();
					}
				}
			}
		click(btnSubmitQuestionnaireButton);
		}

		catch (TimeoutException e) {
		} finally {
			wait.resetImplicitTimeout(1000);
		}
	}
	
	/**
	 * To prepare the list of main selection stages on requirement overview page
	 * @author rachit.mehrotra
	 */
	public void prepareSelectionStageMainText() {
		List<WebElement> listOfElements = getElements(eleMainSelectionStageText);
		for(WebElement we : listOfElements)
			selectionStageMainText.add(getText(we));
	}
	
	/**
	 * To prepare the mapping of the main selection stage and their respective substages on the requirement overview page
	 * @author rachit.mehrotra
	 */
	public void prepareSelectionStageMap() {
		prepareSelectionStageMainText();
		int j = 0;
		for (int i = 0; i < selectionStageMainText.size(); i++) {
			List<String> subStageList = new ArrayList<String>();
			if (isDisplayed(parameterizedLocator(eleCountOfSelectionStage, selectionStageMainText.get(i)))) {
				j++;
				try {
					int internalSizeOfList = Integer.parseInt(getText(parameterizedLocator(eleSubStageCount, Integer.toString(j))).replace("Sub Stage(s)", "").trim());
					int counter = 0;
					click(parameterizedLocator(eleMainSelectionStageLocator, selectionStageMainText.get(i)));
					for (int k = 0; k < internalSizeOfList; k++) {
						counter++;
						String subStage = getText(parameterizedLocator(eleSelectionSubStage,selectionStageMainText.get(i), Integer.toString(counter)));
						TestNGLogUtility.info("substage " + subStage);
						subStageList.add(subStage);
					}
				} catch (NumberFormatException e) {
					subStageList.add(null);
				}
			} else {
				subStageList.add(null);
			}
			selectionStageMappingRequirement.put(selectionStageMainText.get(i), subStageList);
		}
		TestNGLogUtility.info("Selection Stages map created " + selectionStageMappingRequirement);
	}

	/**
	 * To verify the Selection Stages on settings page and requirement overview page
	 * @author rachit.mehrotra
	 * @return boolean basis comparison
	 */
	public boolean verifyEqualityOfSelectionStages() {
		for(Map.Entry<String,List<String>> entry : CustomizeSelectionStagePO.selectionStageMapping.entrySet()) {
			ArrayList<String> requirmentSelectionProcess = (ArrayList<String>) selectionStageMappingRequirement.get(entry.getKey());
			ArrayList<String> customizeSelectionProcess = (ArrayList<String>) CustomizeSelectionStagePO.selectionStageMapping.get(entry.getKey());
			for(int i = 0 ; i < requirmentSelectionProcess.size() ; i++) {
				if(requirmentSelectionProcess.get(i) == null && customizeSelectionProcess.get(i) == null) {
					TestNGLogUtility.info("Selection State " + entry.getKey());
					continue;
				}
				if(!requirmentSelectionProcess.get(i).contains(customizeSelectionProcess.get(i))) {
					TestNGLogUtility.info("requirement " + requirmentSelectionProcess.get(i));
					TestNGLogUtility.info("customize " + customizeSelectionProcess.get(i));
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * To redirect to requirement overview page 
	 * @author rachit.mehrotra
	 */
	public void redirectToRequirementCreated() {
		genericFunctions.launchSpecificURL(RequirementCreationPagePO.requirementOverviewPageURL);
	}
	
	/**
	 * To click on action button on requirement overview page
	 * @param actionType
	 */
	public void clickOnActionButtonForRequirement(String actionType) {
		click(parameterizedLocator(eleActionTypeButtonHolder, actionType));
	}
	
	/**
	 * To verify the selection stage added in settings is visible or not
	 * @return boolean basis comparison
	 */
	public boolean verifyTheSelectionStageAddedIsVisible() {
		return isDisplayed(parameterizedLocator(eleMainSelectionStageText, ManageGroupPO.selectionStage));
	}
	
	/**
	 * This method will verify Questionnaire Attached or not
	 * @return
	 */
	public boolean verifyAttachedQuestionnaireInRequirement(String questionnaireName) {
		if (isDisplayed(eleViewQuestionnaire)) {
			if(questionnaireName.contains(getText(eleQuestionnaireName)))
			flag=true;
		}
		return flag;
	}
	
	/**
	 * This method will click on any tab in requirement name by passing tab name
	 * @author himanshu.dua
	 * @param tabName
	 */
	public void clickOnTabsOnRequirementOverviewPage(String tabName) {
		click(parameterizedLocator(eleTabsOnOverviewPage, tabName));
		
	}
	/**
	 * This method is user for verify field and it's value on Requirement Overview page.
	 * @author himanshu.dua
	 * @param field
	 * @param value
	 * @return
	 */
	public boolean verifyfieldOnRequirementOverviewPage(String field, String value) {
			if(isDisplayed(parameterizedLocator(elefieldOnOverviewPage, field)))
				if(isDisplayed(parameterizedLocator(elefieldValueOnOverviewPage, field)))
					flag=getText(parameterizedLocator(elefieldValueOnOverviewPage, field)).trim().contains(value);
		return flag;
	}
	
	/**
	 * This method will verify the walkin details on requirement details page
	 * @param fieldName
	 * @return
	 */
	public boolean verifyWalkinFieldOnRequirementDetailsSection(String fieldName) {
		return isDisplayed(parameterizedLocator(eleWalkinSectionfieldsOnOverviewPage, fieldName));
	}
	
	/**
	 * This method will click on map URL on requirement details page
	 * @return
	 */
	public void clickOnMapUrl() {
		click(eleMapUrlOnOverviewPage);
	}
	
	/**
	 * This method will verify the walkin details on requirement details page
	 * @param fieldName
	 * @return
	 */
	public boolean verifyUrlOpenPage() {
		return getCurrentURL().contains("www.google.co.in/maps");
	}
	public boolean verifyJobTitleDisplayed(String jobTitle)
	{
		return isDisplayed(parameterizedLocator(eleJobTitleOverviewPage, jobTitle));
	}
	public void userMarksToUpdateJobOnReq()
	{
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(chkUpdatePostedJob);
		click(chkUpdatePostedJob);
		wait.waitForVisibilityOfElement(btnUpdatePostedJobsSave);
		click(btnUpdatePostedJobsSave);
		wait.hardWait(2);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to verify presence of Add Response filter under Response filter tab
	 * @return true if Add response button is present
	 */
	public boolean verifyPresenceOfAddResponseFilter()
	{
		return isDisplayed(btnResponseFilter);
	}

	public boolean checkStatusOfRequirement(String status)
	{
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(eleReqStatus);
		return getText(eleReqStatus).contains(status);
	}
	
//	/**
//	@wip
//	 * @author gupta.mansi
//	 * This method is used to drag given stage name to other given stage name on requirement overview page
//	 * @param stageNameToBeDragged
//	 * @param stageNameToDropDraggedStage
//	 * @throws AWTException 
//	 */
//	public void dragStage(String stageNameToBeDragged, String stageNameToDropDraggedStage) throws AWTException
//	{
//		Point point = getElement(txtStageName, stageNameToDropDraggedStage).getLocation();
//		Point pt = getElement(txtStageName, stageNameToBeDragged).getLocation();
//		int x = pt.getX();
//		int y = pt.getY();
//		int xx = point.getX();
//		int yy = point.getY();
//		Robot robot = new Robot();
//		robot.mouseMove(x, y);
//		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseMove(xx, yy);
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);
//				
//		wait.waitForElementToBeClickable(parameterizedLocator(txtStageName, stageNameToBeDragged));
//		builder.moveToElement(getElement(txtStageName, stageNameToBeDragged));
//		builder.clickAndHold(getElement(txtStageName, stageNameToBeDragged));
//		builder.release(getElement(txtStageName, stageNameToDropDraggedStage));
//		builder.build();
//		builder.perform();
//		builder.dragAndDrop(getElement(txtStageName, stageNameToBeDragged), getElement(txtStageName, stageNameToDropDraggedStage));
//	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to determine presence of status change dd on requirement overview page
	 * @return true iff dd is present
	 */
	public boolean presenceOfStatusChangeDD()
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(ddStatusChange);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Add Response Filters button
	 */
	public void addResponseFilter()
	{
		click(btnResponseFilter);
	}
	
	/**
	 * This method is used to return mapped locations with requirement
	 * @return Location mapped to requirement
	 */
	public String getLocations()
	{
		return getText(eleLocations).trim();
	}
	public boolean clickOnRequisitionDetailsTab() {
		return isDisplayed(getRequisitionDetailsTab);
	}

	public boolean verifyJobIsExpired(String job)
	{
		wait.waitForPageToLoadCompletely();
		wait.hardWait(4);
		//System.out.println(isDisplayed(parameterizedLocator(eleExpiredJob,job)));
		return getText(parameterizedLocator(eleExpiredJob,job)).contains("Expired");
	}
	public void clickOnCancelOnJobUpdate()
	{
		click(elecrossOnUpdateJobsLightbox);
	}
//	public void userSelectsVisibilityFromOverviewPage(String visibleTo)
//	{
//		click(btnSetVisibility);
//
//	}
	public void clickSaveVisibilty()
	{
		click(btnSaveVisibilty);
		wait.waitForPageToLoadCompletely();
	}
	public boolean verifyVisibleToAllRequirementDetails(String visibleTO)
	{
		return getText(elevisibleTo).contains(visibleTO);
	}
	public void clickOnSetVisibility()
	{
		click(btnSetVisibilty);
		wait.waitForVisibilityOfElement(btnSaveVisibilty);
	}
	public boolean verifyListOfTabsOnOverviewPage(String optionsList) {
		List<String> listOfOptionsExpected = Arrays.asList(optionsList.split(","));
		for(int i = 0 ; i < listOfOptionsExpected.size() ; i++) {
			if (!isDisplayed(parameterizedLocator(eleTabsOnOverviewPage, listOfOptionsExpected.get(i))))
				return false;
		}
		return true;
	}
	public boolean verifyAddSingleProfileURLDisplayed()
	{
		wait.waitForPageToLoadCompletely();
		String getProjectId = PropFileHandler.readProperty("projectIdRequirement");
		return getCurrentURL().contains("application/addCandidate?projectId="+getProjectId);
	}
	public void getProjectIdOfReq()
	{
		String projectid = getAttribute(getProjectIdFromPage,"value");
		PropFileHandler.writeProperty("projectIdRequirement",projectid);
	}
	public void clickOnMoreActionButton(String selectOption , String morBtn)
	{
		actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(eleActionsOnOverview,morBtn));
		click(parameterizedLocator(eleActionTypeButtonHolder, selectOption));
		//a[text()='Add Single Profile']
	}
	public void clickOnActionsBTnOnReqOverview(String moreBtn)
	{
		actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(eleActionsOnOverview,moreBtn));
		//click(parameterizedLocator(eleSubOptionsOnOverview,"Add Single Profile"));
	}
	public boolean verifyNewStageDisplayed(String stage)
	{
		scrollToElement(parameterizedLocator(eleSelectionStage,stage));
		return isDisplayed(parameterizedLocator(eleSelectionStage,stage));
	}
//	public boolean verifyAllcontentsOnRequirementDetails()
//	{
//		return isDisplayed(parameterizedLocator());
//	}
	public void clickViewQuestionaire()
	{
		click(eleViewQuestionnaire);
	}
	public boolean verifyQuestionsDisplayedOnOverview(String countQuestions)
	{
		switchToChildWindow();
		int totalActualQuestions = getElements(getTotalQuestionOnOverviewPage).size();
		return Integer.parseInt(countQuestions) == totalActualQuestions;
	}
	public void clickOnQuestionaireTab()
	{
		click(eleQuestionaireTab);
	}
	public boolean verifyCommentOnOverview(String comment)
	{
		return isDisplayed(parameterizedLocator(commentOnOverviewPage,comment));
	}
	public boolean verifyresponseFiltersOnPage()
	{
		return getText(parameterizedLocator(eleResponseFilterValues,"Functional Area")).contains("Banking / Insurance") &&
				getText(parameterizedLocator(eleResponseFilterValues,"Industry")).contains("Hotels/Restaurants/Airlines/Travel") &&
		getText(parameterizedLocator(eleResponseFilterValues,"Location")).contains("Delhi") &&
		getText(parameterizedLocator(eleResponseFilterValues,"Work Experience")).contains("2 to 3") &&
		getText(parameterizedLocator(eleResponseFilterValues,"Annual CTC")).contains("5,00,000 to 7,00,000");
	}
//	public boolean verifyRequirementStatusOnOverview(String status)
//	{
//		getText(eleRequirementStatus).contains(status);
//	}
	public void selectStatusOnOverview(String status)
	{
		wait.waitForVisibilityOfElement(eleReqStatus);
		jsUtil.executeJavascript("document.getElementsByClassName('subNav ')[0].style.display='block';");
		if(status.equals("Close")) {
			click(parameterizedLocator(StatusDDOnOverview, status));
			wait.waitForElementToBeClickable(btnCloseRquirement);
			click(btnCloseRquirement);
		}
		else {
			click(parameterizedLocator(StatusDDOnOverview, status));
		}
		wait.waitForPageToLoadCompletely();
	}
	public boolean verifyStatusOfReqOnOverviewPage(String postedOption)
	{
		if(postedOption.equals("Not Posted"))
		return getText(eleNotPostedkey).contains(postedOption);
		else
			return getText(elePostedKey).contains(postedOption);
	}
	public static String fileSystemPathTillTestData() {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator;
		return filePath;
	}
	public boolean verifyRequirementURLOnOveview()
	{
			String expectedreqId= ReadWritePropertyFile.getProperty("RequirementTrackingId", fileSystemPathTillTestData() + "Data.properties");
			return getCurrentURL().contains(expectedreqId);
	}
	public boolean verifyjobIsVisibleOnNaukri()
	{
		switchToChildWindow();
		wait.waitForVisibilityOfElement(eleJobTitleNaukri);
		 String expectedJobTitle = requirementDetails.get("jobTitle").toString();
		 return getText(eleJobTitleNaukri).contains(expectedJobTitle);
	}
	public void enterrecruiterNameUndervisibleTo(String recruiter)
	{
		click(DDSelectRecruiterOverview);
		sendKeys(txtSelectRecruiterOverview,recruiter);
		click(chkselectRecruiterName);
	}
	public boolean verifyHistoryRowOnOverviewPage()
	{
		hover(eleHistoryIcon);
		System.out.println(getElements(eleHistoryRow));
		return getElements(eleHistoryRow).size()==2;
	}
	public boolean verifySearchBasedOnFilter(String filter)
	{
		switchToChildWindow();
		List<String> listOfFilterExpected = Arrays.asList(filter.split(","));
		List<WebElement> listOfFiltersOnUi = getElements(eleFiltersSearchResultsPage);
		for(int i = 0 ; i < listOfFilterExpected.size() ; i++) {
			if(!(listOfFilterExpected.get(i).contains(listOfFiltersOnUi.get(i+1).getText().replace(":",""))))
				return false;
		}
		return true;
	}
	public boolean verifyRequirementDetailsOnPage()
	{
		return getText(parameterizedLocator(eleReqDetailsDesc,"Job Title/Designation")).contains(requirementDetails.get("jobTitle").toString()) &&
		getText(parameterizedLocator(eleReqDetailsDesc,"Employment Type")).contains("Full Time, Freelance/Homebased") &&
				getText(parameterizedLocator(eleReqDetailsDesc,"Job Description")).contains(requirementDetails.get("jobDescription").toString()) &&
				getText(parameterizedLocator(eleReqDetailsDesc,"Candidate Profile")).contains(requirementDetails.get("candidateDetail").toString()) &&
				getText(parameterizedLocator(eleReqDetailsDesc,"Other Salary")).contains("Other Salary Details") &&
				getText(parameterizedLocator(eleReqDetailsDesc,"Locations")).contains(requirementDetails.get("jobLocations").toString()) &&
				getText(eleKeyword).contains("java");
	}
	public boolean isButtonDisplayed(String buttonName)
	{
		switchToChildWindow();
		return isDisplayed(parameterizedLocator(btntabOnOverview, buttonName));
	}

}
