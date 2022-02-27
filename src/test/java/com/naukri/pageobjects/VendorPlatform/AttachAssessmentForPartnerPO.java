package com.naukri.pageobjects.VendorPlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import com.google.common.collect.Ordering;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.WaitUtility;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author abhishek.dwivedi, ambar.gupta 
 *
 */
public class AttachAssessmentForPartnerPO extends BaseAutomation {
	
	private final By btnSendAssessment = By.xpath("//button[text()='SEND ASSESSMENT']");
	private final By btnCreateNewTest = By.xpath("//a[text()='Create New Test']");
	private final By rdoHackerEarth = By.xpath("//span[@class='customRadio vendorRadio']/label[@for='hackerearth']/div");
	private final By rdoNaukriAssessments = By.xpath("//span[@class='customRadio vendorRadio']/label[@for='ER']/div");
	private final By rdoTestName = By.xpath("//label[text()='${testName}']/preceding-sibling::input");
	private final By lblAttachAssessment = By.xpath("//*[text()='Attach Assessment']");
	private final By lblSendAnewAssessment = By.xpath("//div[text()='Send a New Assessment']");
	private final By lblSubHeadingAttachSendPage = By.xpath("//div[@class='tabHeadSubtitle']/p");
	private final By lblSelectPartnerAssessment = By.xpath("//div[@class='selectPartner']/p");
	private final By eleSelectTest = By.xpath("//span[@class = 'stepper current ']");
	private final By eleConfigureTestSettings = By.xpath("//*[text()='2. Configure Test Settings']");
	private final By btnNext = By.xpath("//div[@class='foot']/button[text()='NEXT']");
	private final By btncANCEL = By.xpath("//div[@class='foot']/button[text()='CANCEL']");
	private final By eleSearchIcon = By.xpath("//div[@class='searchInput']/span");
	private final By eleSearchTextbox = By.xpath("//div[@class='searchInput']/input");
	private final By btnBackbutton = By.xpath("//div[@class='btnBack']");
	private final By eleBackButtonArrow = By.xpath("//span[@class='backArrow']");
	private final By eleFirstStageDropdownExpandArrow = By.xpath("(//span[@class='icon'])[1]");
	private final By eleExpandStage = By.xpath("//span[@class='icon']/following-sibling::div[text()='${Stage}']");
	private final By eleAttachInSubStages = By.xpath("(//div[@class='acord_cont open'])/ul/li/span/a[@title='Add Assessment Test to this selection stage']");
	private final By eleSubStageByName = By.xpath("//div[text()='${subStage}']/preceding-sibling::span/a[@title='Add Assessment Test to this selection stage']");
	private final By eleAttachIconStage = By.xpath("//div[text()='${Stage}']/parent::div/preceding-sibling::div/a[@class='br1 assessDiv']");
	private final By eleSubstages = By.xpath("//div[@class='acord_cont open'])/ul/li/div[@class='subName']");
	private final By eleSubstage = By.xpath("(//div[@class='acord_cont open'])/ul/li/div[text()='${Substage}']");
	private final By eleAttachForParticularSubstage = By.xpath("//div[text()='${Substage}']/preceding-sibling::span/a[@title='Add Assessment Test to this selection stage']");
	private final By eleSubstagesForParticularStage = By.xpath("(//div[text()='${Stage}']/following-sibling::div/div)[1]");
	private final By eleSubstagesForStages = By.xpath("//div[@class='acc_head_title']/following-sibling::div/div");
	private final By lblTestDetailsHE = By.xpath("//span[text()='${TestDetailsLabel}']");
	private final By eleTestRows = By.xpath("//li[contains(@class,'table-data-row')]");
	private final By eleSelectTestWithNameHE = By.xpath("//li[contains(@class,'table-data-row')]/div/span/label[text()='${HETestName}']");
	private final By eleFirstHETest = By.xpath("(//li[contains(@class,'table-data-row')]/div/span/label)[1]");
	private final By eleHETests = By.xpath("//li[@class='table-data-row list  undefined']/div/span/label");
	private final By elePreviewFirstTestHE = By.xpath("(//div[@class='editPrev']/span/a)[1]");
	private final By eleEditFirstTestHE = By.xpath("(//div[@class='editPrev']/span/a)[2]");
	private final By eleTooltipPreviewHE = By.xpath("//ul[@class='notification']/following-sibling::div[3]/div/span[1]");
	private final By eleTooltipEditHE = By.xpath("//ul[@class='notification']/following-sibling::div[4]/div/span[1]");
	private final By elePartnersAttachAssessment = By.xpath("//div/span[@class='platformName']");
	private final By elePartnerSelectionWithName = By.xpath("//div/span[@class='platformName'][text()= '${partnerName}']");
	private final By eleCategoryTupleER = By.xpath("//div[@class='categoryTupple']");
	private final By eleCategoryTupleforParticularCategoryER = By.xpath("//div[@class='categoryTupple']/div/span[text()='${categoryName}']");
	private final By eleNoOfTestsForPartculatCategory = By.xpath("(//div[@class='categoryTupple']/div/span[text()='${categoryName}'])/following-sibling::span[@class=\"noOfTests\"]");
	private final By eleNoOfTests = By.xpath("//div[@class='categoryTupple']/div/span[2]");
	private final By eleCategoryName = By.xpath("//div[@class='tableHeader']/span[@class='categoryName']");
	private final By lblTimeTaken = By.className("timeTaken");
	private final By lblQuestions = By.className("questions");
	private final By eleUpArrow = By.xpath("//em[@class='icon'][text()='UpArrow']");
	private final By eleNoofTestRows = By.className("tableRow");
	private final By firstTestInExpandedCategory = By.xpath("(//div[@class='tableRow  ']/div/span/span/label)[1]");
	private final By SelectTestInExpandedCategory = By.xpath("//div[@class='tableRow  ']/div/span/span/label[text()='${testName}']");
	private final By eleItsDisabled = By.className("itsDisabled");
	private final By eleKnowMoreLink = By.xpath("//a[text()='Know more']");
	private final By lblSelectAssessment = By.className("selectAssessment");
	private final By eleDisabledTest = By.xpath("//div/div[contains(@class,'itsDisabled')]/span//label[text()='${testName}']");
	private final By eleStageDisabled = By.xpath("//li/div/div[text()='${Stage}']");
	private final By btnCreateTest = By.xpath("//button[@class='blockBtn'][text()='CREATE TEST']");
	private final By lblNoTestsTitle = By.className("noTestTitle");
	private final By lblNoTestsText = By.className("noTestText");
	//Step2
	private final By lblHeadingStep2 = By.xpath("//*[text()='${element}']");
	private final By eleselectStage = By.id("selectStageDD");
	private final By selectAStage = By.xpath("//ul[@class='dropdown ']/li/div/div[text()='${stageName}']");
	private final By eleHoverMsgForAlreadyAttachedorSent = By.xpath("//div[@class='tooltipContentStyle']/span[1]");
	private final By btnattachTest = By.id("attachTest");
	private final By chkboxTriggerAutomatic= By.xpath("//label[@for='automaticMail']");
	private final By chkboxWebcamProctoring= By.xpath("//label[@for='webcamProctoring']");
	private final By txtboxCandAllowed = By.xpath("//input[@class='noInput ']");
	//Requirement listings page
	private final By eleFirstRequirement = By.xpath("(//div[@class='topHead']/a)[1]");
	private final By eleSelectionStages = By.id("smtabStages");
	private final By eleApplicationCount = By.xpath("//div[@class='proCount cle']/p/a");
	private final By eleRequirementName = By.xpath("//a[contains(text(),'${reqName}')]");
	//RequirementOveriew/SRP page
	private final By eleReqName = By.xpath("//div[contains(@class,'hText')]");
	private final By eleReqId = By.xpath("//div[contains(@class,'hText')]//span[@class='quesPara']");
	private final By btnAttachAssessment = By.xpath("//div[@id='attachAssessmentButton']/a");
	private final By eleSuccessmsg = By.className("etxt");
	private final By eleCandidateAssessmentsTab = By.xpath("//a[text()='Candidate Assessments ']");
	private final By eleAttachedTestAtStage = By.xpath("//div[text()='${subStage}']/following-sibling::div/div[@class='assessmentText']");
	private final By eleEditAssessmentIconOnsubstage = By.xpath("(//div[text()='${substage}']/following-sibling::div/div/small)[1]");
	private final By eleDeleteAssessmentIconOnsubstage = By.xpath("(//div[text()='${substage}']/following-sibling::div/div/small)[2]");
	private final By eleDelTestIconOnstageWithNoSubstage = By.xpath("(//div[text()='${stage}']/following-sibling::div/small)[2]");
	private final By btnDeleteAssessment = By.id("delTestSuccess");
	private final By eleStageInSelectionStages = By.xpath("//div[@class='acc_head_title'][text()='${stage}']");
	private By eleRequirementOverview = By.xpath("//a[text()='Requirement Overview']");
	
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
	
	/**
	 * @author ambar.gupta
	 * This function is get value of text box for number of candidates allowed
	 * @return Number Of Candidates Allowed value in string
	 */
	public String getValueOfNumberOfCandidatesAllowed() {
		return getElement(txtboxCandAllowed).getAttribute("value");
	}
	
	/**
	 * @author ambar.gupta
	 * This function is to click On Delete Assessment Icon On Stage
	 */
	public void clickOnYesDeleteAssessment() {
		getElement(btnDeleteAssessment).click();
	}
                                                                                                                       
	/**
	 * @author ambar.gupta
	 * This function is to check presence on Attach Icon on stage with no substage
	 * @param stage 
	 * @return Whether attach icon present or not.
	 */
	public boolean checkPresenceOfAttachIconOnStageWithNoSubstage(String stage) {
		return elementVisibility(eleAttachIconStage, stage);
	}
	
	/**
	 * @author ambar.gupta
	 * This function is to click On Delete Assessment Icon On Stage
	 */
	public void clickOnDeleteAssessmentOnStage(String stage) {
		getElement(eleDelTestIconOnstageWithNoSubstage, stage).click();
	}
	/**
	 * @author ambar.gupta
	 * This function is to click On Delete Assessment Icon On SubStage
	 * @param sub stage
	 */
	public void clickOnDeleteAssessmentOnSubStage(String subStage) {
		getElement(eleDeleteAssessmentIconOnsubstage, subStage).click();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is to verify automatic trigger tests check box checked or not.
	 * @return whether automatic trigger tests check box checked or not
	 */
	public boolean verifyAutomaticTriggerCheckedOrNot() {
		return elementVisibility(txtboxCandAllowed);
	}
	
	/**
	 * @author ambar.gupta
	 * This function is check automatic trigger tests checkbox 
	 */
	public void checkAutomaticTriggerCheckBox() {
		getElement(chkboxTriggerAutomatic).click();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is check automatic trigger tests checkbox 
	 */
	public void clickonReqOverviewButton() {
		wait.waitForPageToLoadCompletely();
		getElement(eleRequirementOverview).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is to  pass the number of candidates allowed for automatic trigger
	 * @param Number of candidates allowed for automatic trigger
	 */
	public void PassCandidatesAllowedForAutomaticTrigger(String maxCandidates) {
		jsUtil.scrollDown(txtboxCandAllowed);
		getElement(txtboxCandAllowed).clear();
		getElement(txtboxCandAllowed).sendKeys(maxCandidates);
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to verify whether particular test attached at stage or sub stage
	 * @param substage and test name 
	 * @return whether particular test attached at stage or sub stage
	 */
	public boolean verifyTestAttachedAtstageOrSubstage(String substage, String testName) {
		String actualTestName[] = getElement(eleAttachedTestAtStage, substage).getText().split(":");
		return actualTestName[1].trim().equals(testName);
	}
	
	
	/**
	 * @author ambar.gupta
	 * This function is used to click on Attach Icon for a stage with no substages
	 * @param stage to be clicked
	 */
	public void clickOnAttachIconOnStageWithNoSubstages(String stage) {

		jsUtil.scrollDown(parameterizedLocator(eleStageInSelectionStages,stage));
		hover(parameterizedLocator(eleStageInSelectionStages,stage));
		click(parameterizedLocator(eleAttachIconStage, stage));
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to click on Edit Assessment Icon on substages
	 * @param sub stage at which edit assessment to be clicked
	 */
	public void clickOnEditAssessmentIconOnSubstages(String subStage) {
		wait.hardWait(4);
		getElement(eleEditAssessmentIconOnsubstage, subStage).click();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to click on Attach Icon for a given stage and its substage
	 * @param stage and sub stage on which attach icon to be clicked
	 */
	public void clickOnAttachIconOnSubStageForStage(String stage, String subStage) {
		expandStageDropdown(stage);
	    hoverOnSubstage(subStage);
		getElement(eleSubStageByName, subStage).click();
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks if partner's list is sorted or not
	 * @return Whether partner's list is sorted or not
	 */
	public boolean isPartnerListSorted() {
		List<WebElement> partners = new ArrayList<WebElement>();
		List<String> partnerNames = new ArrayList<String>();
		partners = getElements(elePartnersAttachAssessment);
		for (WebElement partner : partners)
		{
			partnerNames.add(partner.getText());
		}
		return  Ordering.natural().isOrdered(partnerNames);
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to click on a particular category or first category in ER tests and return no of tests in category tuple
	 * @return no of tests in category tuple
	 */
	public int clickOncategory() {
		return clickOncategory("");
	}
	
	public int clickOncategory(String categoryName) {
		String noOfTestsInCategory[], tests;
		if(categoryName == "")
		{
			
			 tests = wait.waitForVisibilityOfElement(eleNoOfTests).getText();
			 noOfTestsInCategory = tests.split(" ");
			 wait.hardWait(1);
			click(eleCategoryTupleER);
			return Integer.parseInt(noOfTestsInCategory[0]);
		}
		else
		{
			 tests = getElement(eleNoOfTestsForPartculatCategory,categoryName ).getText();
			 noOfTestsInCategory = tests.split(" ");
			getElement(eleCategoryTupleforParticularCategoryER, categoryName).click();
			return Integer.parseInt(noOfTestsInCategory[0]);
		}
	}	
	
	/**
	 * @author ambar.gupta 
	 * This method used to select a particular or first test in a particular or first category  in ER tests 
	 * @param String categoryName, String testName (optional)
	 */
	public void selectTestInACategory() {
		selectTestInACategory("", "");
	}
	
	public void selectTestInACategory(String categoryName, String testName) {
		if(categoryName == "")
		{
			getElement(eleCategoryTupleER).click();
			if(testName == "")
				click(firstTestInExpandedCategory);
			else {
				sendKeys(eleSearchTextbox, testName);
			wait.hardWait(2);
				click(parameterizedLocator(SelectTestInExpandedCategory,testName));
			}
		}
			
		else
		{
			getElement(eleCategoryTupleforParticularCategoryER, categoryName).click();
			if(testName == "")
				getElement(firstTestInExpandedCategory).click();
			else {
				sendKeys(eleSearchTextbox, testName);
			wait.hardWait(2);
				getElement(SelectTestInExpandedCategory,testName).click();
			}
		
		}
	}
	
	/**
	 * To verify test labels in the expanded category in ER
	 * @author ambar.gupta
	 * @return True/false
	 * @param elementName : name of the element whose presence is to be verified
	 */
	public boolean verifyTestLabelsInExpandedCategory(String element) {
		switch (element) {
		case "Questions":
			return getElement(lblQuestions).getText().equals("Questions");
		case "TimeTaken":
			return getElement(lblTimeTaken).getText().equals("Time Taken");
		case "UpArrow":
			return isDisplayed(eleUpArrow);
		case "CategoryName":
			return isDisplayed(eleCategoryName);
		default:
			return false;
		}
	}
	/**
	 * To verify test labels Configure Test Settings tab for partners
	 *@author ambar.gupta
	 * @return True/false
	 * @param elementName : name of the element whose presence is to be verified
	 */
	public boolean verifyLabelsInConfigureTestSettingsTab(String element, String partner) {
		return isDisplayed(lblHeadingStep2, element);
	}
	
	/**
	 * @author ambar.gupta
	 *To verify Candidate Assessments tab is removed
	 * @return True/false
	 * 
	 */
	public boolean verifyCandidateAssessmentsTabRemoved() {
		
		return elementVisibility(eleCandidateAssessmentsTab);
	}
	
	/**
	 * @author ambar.gupta
	 *To verify button and text in case no tests created for partner
	 * @return True/false
	 * 
	 */
	public boolean verifyButtonAndLabelInNoTestsCaseForPartners(String partner, String element) {
		
		switch(element) {
		case "CREATE TEST":
			return isDisplayed(btnCreateTest);
		case "No Tests Label":{
			logMessage("[INFO]"+ getElement(lblNoTestsTitle).getText());
			return getElement(lblNoTestsTitle).getText().equals("No tests created on "+partner);
		}
		case "No Tests Sub Label":{
			logMessage("[INFO]"+ getElement(lblNoTestsText).getText());
			return getElement(lblNoTestsText).getText().equals("You have not created any tests on "+partner+". Once you create tests on "+partner+" they all will appear here and you can screen candidates easily from within RMS");
		}
		default:
			return false;
		}
	}
	/**
	 * To verify required elements are present on AttachAssessment Page
	 * 
	 * @return True/false
	 * @param elementName : name of the element whose presence is to be verified
	 */
	public boolean verifyElementsOnAttachAssessmentPage(String element) {
		switch (element) {
		case "SelectTest":{
			if(isDisplayed(eleSelectTest))
			return getText(eleSelectTest).equals("1. Select Test");
			else
				return false;
		}
		case "ConfigureTestSettings":
			return getElement(eleConfigureTestSettings).getText().equals("2. Configure Test Settings");
		case "BackButton":
			return isDisplayed(btnBackbutton);
		case "BackButtonArrow":
			return isDisplayed(eleBackButtonArrow);
		case "SelectAssessmentPartner":
			return getElement(lblSelectPartnerAssessment).getText().equals("Select Assessment Partner");
		case "rdoHackerEarth":
			return isDisplayed(rdoHackerEarth);
		case "rdoNaukriAssessments":
			return isDisplayed(rdoNaukriAssessments);
		case "CancelButton":
			return isDisplayed(btncANCEL);
		case "NextButton":
			return isDisplayed(btnNext);
		case "SearchIcon":
			return isDisplayed(eleSearchIcon);
		case "SearchTextbox":
			return isDisplayed(eleSearchTextbox);
		
		default:
			return false;
		}
	}
	
	
	/**
	 * @author ambar.gupta 
	 * To verify number of tests are present as shown in category tuple
	 * @return true/false
	 */
	public boolean verifyNumberOfTestsForExpandedCategory() {
	int noOfTestsInCategoryTuple = clickOncategory();
	int noOfTestsInReal = getNumberOfTestsInExpandedCategory();
	return noOfTestsInCategoryTuple == noOfTestsInReal ;
	}
	
	
	/**
	 * @author ambar.gupta 
	 * To find number tests in the expanded category
	 * @return No of tests in the expanded category
	 */
	public int getNumberOfTestsInExpandedCategory() {
		wait.waitForPageToLoadCompletely();
		List<WebElement> partners = new ArrayList<WebElement>();
		partners = getElements(eleNoofTestRows);
		return partners.size();
	}
	
	/**
	 * @author ambar.gupta To find number of partners shown
	 * @return No of partner added
	 */
	public int getNumberOfPartnersShown() {
		wait.waitForPageToLoadCompletely();
		List<WebElement> partners = new ArrayList<WebElement>();
			partners = getElements(elePartnersAttachAssessment);
			return partners.size();		
	}
	/**
	 * @author ambar.gupta 
	 * This method used validate dynamic SubHeading on Attach Assessment page
	 * @return Requirement name
	 */
	public boolean validatDynamicSubHeadingOnAttachAssessmentPage(String requirementName) {
		
		String expectedSubHeader = "Add Assessment for requirement "+requirementName+" at the desired selection stage";
		String actualSubHeader = getElement(lblSubHeadingAttachSendPage).getText();
		return expectedSubHeader.equals(actualSubHeader);
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used validate Heading on Attach Assessment page
	 * @return true/false
	 */
	public boolean validatHeadingOnAttachAssessmentPage() {
		return getElement(lblAttachAssessment).isDisplayed();
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used validate Heading on Send Assessment page
	 * @return true/false
	 */
	public boolean validatHeadingOnSendAssessmentPage() {
		return isDisplayed(lblSendAnewAssessment);
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used return placeholder for dropdown
	 * @return placeholder value
	 */
	public String getPlaceHolderFromDropDown() {
		return getElement(eleselectStage).getAttribute("placeholder");
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used get Requirement name from Overview/SRP page
	 * @return Requirement name
	 */
	public String getRequirementName() {
		String reqText[] = getText(eleReqName).split(":");
		return reqText[1].replace(getText(eleReqId),"").trim();
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used to verify Hover message for a stage on which test is already attached
	 * @param stage name and usedStageMsg that comes on hovering
	 * @return true/false
	 */
	public boolean verifyHoverMsgOnUsedStage(String stage, String usedStageMsg) {
		mouseHoverToWebElement(getElement(eleStageDisabled, stage));
		//String HoverMsg = PropFileHandler.readProperty("HoverMsgForUsedStagePart1") + "\n" + PropFileHandler.readProperty("HoverMsgForUsedStagePart2");
		return getElement(eleHoverMsgForAlreadyAttachedorSent).getText().contains(usedStageMsg);
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used to verify Hover message for a stage on which test is already attached
	 * @param test name, alreadyAttachedSentMsg that comes on hovering on test name.
	 * @return true/false
	 */
	public boolean verifyHoverMsgOnAttachedTest(String testName, String alreadyAttachedSentMsg) {
		mouseHoverToWebElement(getElement(eleDisabledTest, testName));
		return getElement(eleHoverMsgForAlreadyAttachedorSent).getText().equals(alreadyAttachedSentMsg);
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used to verify Preview icon displayed on hovering on test
	 * @return true/false
	 */
	public boolean verifyPreviewIconDisplayedOnHoveringTest() {
		mouseHoverToWebElement(getElement(eleTestRows));
		return isDisplayed(elePreviewFirstTestHE);
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to verify Edit icon displayed on hovering on test
	 * @return true/false
	 */
	public boolean verifyEditIconDisplayedOnHoveringTest() {
		mouseHoverToWebElement(getElement(eleTestRows));
		return isDisplayed(eleEditFirstTestHE);
	}
	    
	/**
	 * @author ambar.gupta 
	 * This method used to validate Test Details Labels for HackerEarth
	 * @param partnerName
	 * @return true/false
	 */
	public boolean validateTestDetailsLabels(String partnerName) {
		boolean testName = isDisplayed(lblTestDetailsHE, "Test Name");
		boolean Duration = isDisplayed(lblTestDetailsHE, "Duration");
		boolean Questions = isDisplayed(lblTestDetailsHE, "# Questions");
		boolean TotalScore = isDisplayed(lblTestDetailsHE, "Total Score");
		boolean TestStartsOn = isDisplayed(lblTestDetailsHE, "Test Starts On");
		boolean TestEndsOn = isDisplayed(lblTestDetailsHE, "Test Ends On");
		boolean TestCreatedOn = isDisplayed(lblTestDetailsHE, "Test Created On"); 
		
		switch (partnerName) {
		case "HackerEarth":
			return testName && Duration && Questions && TotalScore && TestStartsOn && TestEndsOn;
		case "Codility":
			return testName && Duration && Questions && TotalScore && TestCreatedOn;
		default:
			return false;
		}
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to check the presence of Attach button for the expanded stage
	 * @return number of Attach icons in the stage
	 */
	
	public int numberOfAttachIconsInExpandedStage()
	{
		List<WebElement> list=new ArrayList<WebElement>();
		list = getElements(eleAttachInSubStages);
		return list.size();
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used to find number of substages for a particular stage
	 * @return number of stages
	 */
	public int numberOfsubstagesInStage(String Stage)
	{
		String count = getElement(eleSubstagesForParticularStage, Stage).getText();
		String c[]=count.split(" ");
		
		return Integer.parseInt(c[0]);
	}
	
	public int numberOfsubstagesInStage()
	{
		String count = getElement(eleSubstagesForStages).getText();
		String c[]=count.split(" ");
		return Integer.parseInt(c[0]);
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used to hover and click on attach button in a particular substage
	 */
	public void hoverAndClickOnAttachInSubstage() {
		hoverAndClickOnAttachInSubstage("");
	}
	
	public void hoverAndClickOnAttachInSubstage(String Substage) {
		if(Substage == "")
			mouseHoverAndClickToWebElement(getElement(eleSubstages),getElement(eleAttachInSubStages));
		else
			mouseHoverAndClickToWebElement(getElement(eleSubstage, Substage),getElement(eleAttachForParticularSubstage, Substage));
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to hover on a particular substage or first substage of a stage
	 */
	public void hoverOnSubstage() {
		hoverOnSubstage("");
	}
	
	public void hoverOnSubstage(String Substage) {
		if(Substage == "")
			mouseHoverToWebElement(getElement(eleSubstages));
		else
			mouseHoverToWebElement(getElement(eleSubstage, Substage));
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to expand the stage if name given otherwise expand the first stage
	 */
	public void expandStageDropdown() {
		expandStageDropdown("");
	}
	public void expandStageDropdown(String Stage)
	{
		wait.waitForPageToLoadCompletely();
		wait.hardWait(5);
		if(Stage == "")
			getElement(eleFirstStageDropdownExpandArrow).click();
		else
			
		  try {
			  getElement(eleExpandStage, Stage).click();
	        } catch(StaleElementReferenceException e) {
	        	logMessage("[INFO] Encountered StaleElementReferenceException");
	        	pageRefresh();
	        	wait.waitForPageToLoadCompletely();
	        	getElement(eleExpandStage, Stage).click();
	        }
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method used to click on a particular category or first category in ER tests and return no of tests in category tuple
	 * @return no of tests in category tuple
	 */
	public void selectHETest() {
		selectHETest("");
	}
	
	public void selectHETest(String HETestName) {
		if(HETestName == "")
		{
			 click(eleFirstHETest);
		}
		else
		{
			sendKeys(eleSearchTextbox, HETestName);
			wait.hardWait(2);
			click(parameterizedLocator(eleSelectTestWithNameHE, HETestName));
		}
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method use to click on first requirement in requirement listings page
	 */
	public void clickFirstRequirementInRequirementListings() {
		wait.waitForPageToLoadCompletely();
		getElement(eleFirstRequirement).click();
	}
	
	
	/**
	 * @author ambar.gupta 
	 * This method is used to move to SRP page from requirement
	 */
	public void moveToSRPfromRequirement() {
		click(eleApplicationCount);
		switchToChildWindow();
	}
	
	/**
	 * @author ambar.gupta 
	 * This method is used to move to first requirement on the listings page
	 */
	public void moveToFirstRequirement() {
		wait.waitForPageToLoadCompletely();
		getElement(eleFirstRequirement).click();
		switchToChildWindow();
	}
	/**
	 * @author ambar.gupta 
	 * This method is used to move to newly created requirement or first one on the listings page
	 */
	public void moveToNewlyCreatedOrFirstRequirement(String reqName) {
		if(reqName == "")
			moveToFirstRequirement();
		else {
			API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleRequirementName, reqName), 5);
			click(parameterizedLocator(eleRequirementName, reqName));
			switchToChildWindow();
			closeParentMoveToChild();
			wait.waitForPageToLoadCompletely();
		}
	}
	/**
	 * @author ambar.gupta 
	 * This method use to click on Selection stages tab
	 */
	public void clickOnSelectionStagesTab() {
		wait.waitForElementToBeClickable(eleSelectionStages);
		click(eleSelectionStages);
	}
	
	/**
	 * @author ambar.gupta 
	 * This method use to check presence and visibility of Attach Assessment button
	 */
	public boolean checkPresenceOfAttachAssessmentButton() {
		if(elementVisibility(btnAttachAssessment))
			return isDisplayed(btnAttachAssessment);
		else
			return false;
	}
	
	/**
	 * @author abhishek.dwivedi 
	 * This method use to click on Attach Assessment button 
	 */
	public void clickAttachAssessment() {
		click(btnAttachAssessment);
	}
	/**
	 * @author abhishek.dwivedi
	 *  This method use to click on Send Assessment button on requirement Inbox page
	 */
	public void clickSendAssessmentOnRequirementInbox() {
		getElement(btnSendAssessment).click();
	}
	
	/**
	 * @author ambar.gupta
	 *  This method use to click on Attach Test button
	 */
	public void clickOnAttachTestButton() {
		click(btnattachTest);
	}
	/**
	 * @author ambar.gupta
	 *  This method use to click on Send Test button
	 */
	public void clickOnSendTestButton() {
		click(btnSendAssessment);
		switchToActiveElement();
	}
	/**
	 * @author abhishek.dwivedi 
	 * This method use to click on Send Assessment button
	 *         on requirement Inbox page
	 */
	public void clickCreateNewTest() {
		getElement(btnCreateNewTest).click();
	}
	
	/**
	 * @author abhishek.dwivedi 
	 * This method use to click on Send Assessment button
	 *         on requirement Inbox page
	 */
	public boolean validatePresenceOfCreateNewTest() {
		return elementVisibility(btnCreateNewTest);
	}
	
	/**
	 * @author ambar.gupta	
	 * This method is used to click on Assessment partner radio button
	 */
	public void selectAssessmentPartnerOption(String partnerName) {
		wait.resetImplicitTimeout(20);
		wait.waitForVisibilityOfElement(eleSearchTextbox);
		getElement(elePartnerSelectionWithName, partnerName).click();
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
	}
	/**
	 * This function will click on the select Stage Drop down on Configure test Settings page.
	 * page
	 */
	public void clickSelectedStageDD() {
		wait.waitForVisibilityOfElement(eleselectStage);
		wait.waitForElementToBeClickable(eleselectStage).click();
	}
	/**
	 * This function will select a stage on Configure test Settings page.
	 */
	public void selectStage(String stageName) {
		click(parameterizedLocator(selectAStage, stageName));
	}
	
	/**
	 * @author ambar.gupta
	 * This function click on Next button
	 */
	public void clickNextButton() {
		click(btnNext);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to verify success message after attaching test
	 */
	public boolean verifySuccessMessageForAttach(String testName) {
		String expected = "Success! "+testName+" is now attached to this requirement.";
		return getElement(eleSuccessmsg).getText().equals(expected);
	}	
	
	/**
	 * @author abhishek.dwivedi 
	 * This method use to Select TestName on the basis of selected Assessment partner
	 */
	public void selectTestBasedOnPartner(String testName) {
		getElement(rdoTestName, testName).click();
	}
	
	/**
	 * @author abhishek.dwivedi 
	 * This method use to click on Send Assessment button
	 *         on requirement Inbox page
	 */
	public void clickOnKnowMoreInHoverMessage() {
		hover(eleItsDisabled);
		wait.waitForVisibilityOfElement(eleKnowMoreLink).click();
		switchToChildWindow();
	}
	
	/**
	 * @author ambar.gupta
	 * This method use to check whether test is disabled or not
	 *         
	 */
	public boolean verifyTestDisabledOrNot(String testName){
		sendKeys(eleSearchTextbox, testName);
		wait.hardWait(2);
		return getElement(eleDisabledTest, testName).isDisplayed();
	}
	
	/**
	 * @author ambar.gupta
	 * This method use to check whether test is enabled or not
	 *         
	 */
	public boolean verifyStageDisabledOrNot(String stage){
		return getElement(eleStageDisabled, stage).isDisplayed();
	}
	
	/**
	 * This function is to verify the stage is displayed or not while attaching test
	 * @return It will return true if stage present in DD
	 */
	public boolean verifySelectionStagesInDD(String stageName) {

		return isDisplayed(selectAStage,stageName);
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used validate dynamic SubHeading on Send Assessment page
	 * @return Requirement name
	 */
	public boolean validatDynamicSubHeadingOnSendAssessmentPage(String requirementName) {
		
		String expectedSubHeader = "Select and send an assessment for requirement "+requirementName;
		String actualSubHeader = getText(lblSubHeadingAttachSendPage);
		return expectedSubHeader.equals(actualSubHeader);
	}
	    
	/**
	 * @author ambar.gupta 
	 * This method used validate dynamic SubHeading on Edit Assessment page
	 * @return Requirement name
	 */
	public boolean validatDynamicSubHeadingOnEditAssessmentPage(String requirementName, String testName) {
		
		String expectedSubHeader = "Edit Settings of "+testName+" for requirement "+requirementName;
		String actualSubHeader = getText(lblSubHeadingAttachSendPage);
		return expectedSubHeader.equals(actualSubHeader);
	}

	/**
	 * @author ambar.gupta 
	 * This method returns number of tests in HackerEarth
	 * @return number of tests in HackerEarth
	 */
	public int getNumberOfTestsinHE() {
		return getElements(eleHETests).size();
	}
	
}