package com.naukri.pageobjects.HiringManager;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class HMDashboardPagePO extends PageObjectWrapper {
	By requirementsCount = By.xpath("//a[@href='/project/list']//span[@id = 'reqCount']");
	By applicationsCount = By.id("candidateCount");
	By pendingReviewsCount = By.xpath("//span[contains(@class,'pendingCount')]"); 
	By requisitionsAwaitingYourApprovalBox = By.className("br1Light req"); 
	By requisitionsAwaitingApprovalCount = By.xpath("//div[@class = 'innerTpl']//span[@id = 'reqCount']");
	By approveFromDashboard = By.xpath("(//a[text()='Approve'])[1]");
	By afterApproveFromDashboard = By.xpath("(//span[contains(text(),'Approved')]");
	By pipelineStagesArePresent = By.xpath("//div[contains(@class,'accordion')]");
	By gnbDashboard = By.xpath("//a[@class = 'menu' and @href = '/admin/homePage']");
	By gnbRequirements = By.xpath("//a[@class = 'menu' and @href = '/project/list']");
	By gnbRequisitions = By.xpath("//a[@class = 'menu' and text() = 'Requisitions']");
	By subMenuRaiseRequisition = By.xpath("//div[@class = 'subMenu']//a[text() = 'Raise Requisition']");
	By subMenuAllRequisitions = By.xpath("//div[@class = 'subMenu']//a[text() = 'All Requisitions']");
	By giveFeedbackFromDashboardCount = By.xpath("//div[@class = 'pendingCount pAbs pendCount']");
	By giveFeedbackFromDashboardButton = By.xpath("(//span[@class = 'pr3 clear giveFeedbackBtn'])[1]");
	By feedbackStageOfCandidate = By.xpath("(//span[@class = 'bgGray mr3'])[1]");
	By pipelineStagesCountWE = By.xpath("//a[contains(@class,'c6 f11 fr count p3 selectedTab')]");
	By pipelineStageWE = By.xpath("//span[contains(@class,'fl mt2 acc_head_title')]");
	By pipelineSubStagesCount = By.xpath("//a[contains(@class,'c6 fr f11 count p3 selectedTab')]");
	By lnkFirstPipelineSubStage = By.xpath("(//div[contains(@class,'subStageT')]//a[contains(@href,'/profile/feed/pending')])[1]");
	By pipelineSubStageWE = By.xpath("//span[contains(@class,'mt2 fl f11')]");
	By substagesOfGivenSatgeWE = By.xpath("//span[text()='${helpText}']//parent::div//parent::div//span[contains(@class,'mt2 fl f11')]");
	By substagesCountOfGivenStageWE = By.xpath("//span[text()='${helpText}']//parent::div//parent::div//a[contains(@class,'c6 fr f11 count p3 selectedTab')]");
	By countOfGivenSubstageLnk = By.xpath("//span[text()='{helpText}']//parent::div//a");
	By lblRequisition = By.xpath("//li[@class='menu']//a[text()='Requisitions']");
	By lnkRaiseRequisition = By.xpath("//li[@class='menu']//a[text()='Raise Requisition']");
	By pipelineStagesDD = By.xpath("//i[@class='accArrow']");
	By lnkCountOfGivenSubstage = By.xpath("//span[text()='${substageName}']//following-sibling::a");
	By txtFisrstSelectionStage = By.xpath("//span[text()='${string}']");
	By eleCandidateNameHolder = By.xpath("//strong[contains(text(),'${candidateName}')]");
	By txtEid = By.xpath("//span[@title='${eId}']");
	By txtRaiseRequisiton = By.xpath("//h1[text()='Raise Hiring Requisition']");
	By lnkRequirementCount = By.xpath("//span[@id='reqCount']");
	By lnkApplicationCount = By.xpath("//span[@id='candidateCount']");
	By lnlUpcomingInterview = By.xpath("//span[contains(@class,'upcomingInterviewCount')]");
	By lnkPendingReviewCountSectionCount = By.xpath("//div[contains(@class,'pendingCount')]");
	By lnkUpcomingInterviewSectionCount = By.xpath("//div[contains(@class,'upcomingInterviewCount')]");
	By ddGiveFeedbackForApplicationId = By.xpath("//div[@id='feedbackPendingDiv_${appID}']//span[contains(text(),'Give Feedback')]");
	By eleApplicationUnderUpcomingInterviewSection = By.xpath("//strong[text()='Upcoming Interviews']/../../..//a[contains(@href,'${appID}')]");
	By btnGiveFeedbackForApplicationId = By.xpath("//span[@data-appid='${appId}']");
	By txtGeneric = By.xpath("//*[text()='${txt}']");
	String env = ReadWritePropertyFile.getProperty("testEnvironment", configFile);
	List<WebElement> allPipelineStagesWebelementList = new ArrayList<WebElement>();
	List<String> nameOfStage = new ArrayList<String>();
	List<Integer> countOfStage = new ArrayList<Integer>();
	List<WebElement> correspondingStageCountWebelementList = new ArrayList<WebElement>();
	HashMap<String, Integer> stageAndItsCount = new HashMap<String, Integer>();
	HashMap<String, WebElement> stageAndItsCountWebelement = new HashMap<String, WebElement>();
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);
	
	/**
	 * This method is used to get the count of all requirement from dashboard
	 * @return
	 * @author gupta.mansi
	 */
	public int getRequirementsCountFromDashboard() {
		return Integer.parseInt(getText(requirementsCount));
	}
	/**
	 * This method used to get the total application count 
	 * @return
	 * @author gupta.mansi
	 */
	public int getApplicationsCountFromDashboard() {
		return Integer.parseInt(getText(applicationsCount));
	}
	/**
	 * This method is used to get the count all pending reviews from dashboard
	 * @return pending review count as int
	 * @author gupta.mansi
	 */
	public int getpendingReviewsCountFromDashboard() {
		wait.waitForPageToLoadCompletely();
		return Integer.parseInt(getText(pendingReviewsCount));
	}
	/**
	 * This method is used to get the count of upcoming interview from dashboard
	 * @return count of upcoming interview as int
	 */
	public int getupcomingInterviewsCountFromDashboard() {
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(lnlUpcomingInterview);
		return Integer.parseInt(getText(lnlUpcomingInterview));
	}
	/**
	 * This method is used to get count of requisition awaiting your approval
	 * @return requisition awaiting your approval as int
	 * @author gupta.mansi
	 */
	public int getRequisitionsAwaitingYourApprovalCountFromDashboard() {
		return Integer.parseInt(getText(requisitionsAwaitingApprovalCount));
	}
	
	/**
	 * This method returns true if there are any feedback to give on pipeline stage
	 * @return
	 */
	public boolean isAnyPipelineStageIsThereForFeedback() {
		if (getElements(pipelineStagesArePresent).size() != 0) {
			return true;
		} else
			return false;
	}
	
	/**
	 * This method is used to check whether requisition pending for approval section is displayed
	 * @return
	 */
	public boolean isPendingApprovalDisplayedOnDashboard() {
		return isDisplayed(requisitionsAwaitingYourApprovalBox);
	}
	
	/**
	 * This method is used to click on approve button for top requisition from dashboard
	 */
	public void approveTopRequisitionFromDashboard() {
		click(approveFromDashboard);
	}
	
	/**
	 * This method is used to check whether requisition approved is displayed after requisition is approved
	 * @return
	 */
	public boolean requisitionApprovedDisplayedAfterClickingApproveButton() {
		return isDisplayed(afterApproveFromDashboard);
	}
	
	/**
	 * This method return true when Dashboard link is displayed on GNB
	 * @return
	 */
	public boolean isDashboardVisibleOnGnb() {
		return isDisplayed(gnbDashboard);
	}
	
	/**
	 * This method return true when Requirements link is displayed on GNB
	 * @return
	 */
	public boolean isRequirementsVisibleOnGnb() {
		return isDisplayed(gnbRequirements);
	}
	
	/**
	 * This method return true when Requisition link is displayed on GNB
	 * @return
	 */
	public boolean isRequisitionsVisibleOnGnb() {
		return isDisplayed(gnbRequisitions);
	}
	
	/**
	 * This method return true when Raise Requisition link is displayed on GNB
	 * @return
	 */
	public boolean isRaiseRequirementsVisibleOnHoverOverRequisitions() {
		hover(gnbRequisitions);
		return isDisplayed(subMenuRaiseRequisition);
	}
	
	/**
	 * This method return true when All Requisition link is displayed on GNB on hovering over Requisitions
	 * @return
	 */
	public boolean isAllRequisitionsVisibleOnHoverOverRequisitions() {
		hover(gnbRequisitions);
		return isDisplayed(subMenuAllRequisitions);
	}
	/**
	 * This method is used to get the name of all pipeline stages for feedback pending
	 * @author gupta.mansi
	 */
	public void nameOfAllPipelineStages() {
		allPipelineStagesWebelementList = getElements(pipelineStageWE);
		ListIterator<WebElement> iterator = allPipelineStagesWebelementList.listIterator();
		while (iterator.hasNext()) {
			nameOfStage.add(iterator.next().getText());
		}
	}
	/**
	 * This method is used to get name of first pipeline stage of pending feedback
	 * @return
	 */
	public String getNameOfFirstPipelineStage() {
		nameOfAllPipelineStages();
		return nameOfStage.get(0);
	}
	/**
	 * This method stores number of feedback pending for all the stages in a list
	 * named countOfStage
	 * @author gupta.mansi
	 */
	public void countOfCorrespondingPipelineStages() {
		correspondingStageCountWebelementList = getElements(pipelineStagesCountWE);
		ListIterator<WebElement> iterator = correspondingStageCountWebelementList.listIterator();
		while (iterator.hasNext()) {
			countOfStage.add(Integer.parseInt(iterator.next().getText()));
		}
	}
	/**
	 * This method returns the pending feedback number displayed for first pipeline stage
	 * @return number of pending feedback for first pipeline stage
	 */
	public int getCountOfFirstPipelineStage() {
		countOfCorrespondingPipelineStages();
		return countOfStage.get(0);
	}
	/**
	 * This method returns summation of all the pending feedback for all the pipeline stages
	 * @return summation of all the pending feedback count for pipeline stages
	 */
	public int sumOfCountOfAllPipelineStages() {
		countOfCorrespondingPipelineStages();
		return countOfStage.stream().reduce(0, (a, b) -> a + b);
	}
	/**
	 * This method stores name of pipeline stage with its pending feedback count in a map named stageAndItsCount
	 * @author gupta.mansi
	 */
	public void stageNameAndItsCount() {
		nameOfAllPipelineStages();
		countOfCorrespondingPipelineStages();
		ListIterator<String> iteratorForNameOfStage = nameOfStage.listIterator();
		ListIterator<Integer> iteratorForCountOfStage = countOfStage.listIterator();
		while (iteratorForNameOfStage.hasNext() && iteratorForCountOfStage.hasNext()) {
			stageAndItsCount.put(iteratorForNameOfStage.next(), iteratorForCountOfStage.next());
		}
	}
	/**
	 * This method is used to get all the stage name and webelements for pending count
	 * @author gupta.mansi
	 */
	public void stageNameAndCountWebelement() {
		nameOfAllPipelineStages();
		correspondingStageCountWebelementList = getElements(pipelineStagesCountWE);
		ListIterator<WebElement> iteratorForStageWebelementList = correspondingStageCountWebelementList.listIterator();
		ListIterator<String> iteratorForNameOfStage = nameOfStage.listIterator();
		while (iteratorForNameOfStage.hasNext() && iteratorForStageWebelementList.hasNext()) {
			stageAndItsCountWebelement.put(iteratorForNameOfStage.next(), iteratorForStageWebelementList.next());
		}
	}
	/**
	 * This method is used to get the number of pending feedbacks for given pipeline stage 
	 * @param stage name           
	 * @return count of pending feedback for given stage
	 */
	public int getCountOfGivenStage(String stage) {
		stageNameAndCountWebelement();
		return Integer.parseInt(stageAndItsCountWebelement.get(stage).getText());
	}
	/**
	 * This method clicks on feedback pending count for given pipeline stages
	 * @param stage name          
	 */
	public void clickOnCountOfGivenStage(String stage) {
		stageNameAndCountWebelement();
		stageAndItsCountWebelement.get(stage).click();
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * This method is used to get count of pending reviews of first displayed stage
	 * @return
	 * @author gupta.mansi
	 */
	public int getCountOfFirstSubstage()
	{
		clickOnDDOfFirstStage();
		return Integer.parseInt(getText(lnkFirstPipelineSubStage));
	}
	
	/**
	 * This method is used to click on dd of stage for pending review section
	 * @author gupta.mansi
	 */
	public void clickOnDDOfFirstStage()
	{
		click(pipelineStagesDD);
	}
	
	/**
	 * This method is used to click on count of pending reviews for give stage
	 * @author gupta.mansi
	 */
	public void clickOnCountOfFirstSubstage()
	{
		clickOnDDOfFirstStage();
		click(lnkFirstPipelineSubStage);
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * This method is used to goto raise requirement page from dashboard
	 * @author gupta.mansi
	 */
	public void gotoRaiseRequirementPageFromDashboard()
	{
		hover(lblRequisition);
		click(lnkRaiseRequisition);
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(txtRaiseRequisiton);
	}
	
	/**
	 * This method is used to click on count of pending reviews for given substage
	 * @param subSatageName
	 * @author gupta.mansi
	 */
	public void clickOnCountOfGivenSubstage(String subSatageName)
	{
		getElement(txtFisrstSelectionStage,PropFileHandler.readProperty("FirstSelectionStageName")).click();
		getElement(lnkCountOfGivenSubstage,subSatageName).click();
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author rachit.mehrotra
	 * To verify the presence of candidate name on HM Dashboard
	 * @return true if candidate is displayed under interview section on dashboard
	 */
	public boolean verifyThePresenceOfCandidateName() {
		return isDisplayed(parameterizedLocator(eleCandidateNameHolder, AddASingleProfilePagePO.candidateName));
	}
	
	/**
	 * @author rachit.mehrotra
	 * To click on candidate name on the upcoming interview section
	 */
	public void clickOnCandidateName() {
		click(parameterizedLocator(eleCandidateNameHolder, AddASingleProfilePagePO.candidateName));
		TestNGLogUtility.info(AddASingleProfilePagePO.candidateName + " clicked");
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if given mail id is present on the page
	 * @param eId:email id
	 * @return true if present else false
	 */
	public boolean verifyCandidateIspresentOnFeedbackPendingPage(String eId)
	{
		return API.refreshPageAndCheckElementIsDisplayed((parameterizedLocator(txtEid, eId)),5);
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if given mail id is not present on the page
	 * @param eId:email id
	 * @return true if present else false
	 */
	public boolean verifyCandidateIsAbsentOnFeedbackPendingPage(String eId)
	{
		return refreshPageAndCheckElementIsNotDisplayed((parameterizedLocator(txtEid, eId)),5);
	}
	
	/**
     * This method is used to absence of element after page refresh
     * if element found, it will break from the loop.
     *  @author gupta.mansi
     *  @param element to be checked and maxReloadAttempt in integer
	 *  @return Whether element found with the maximum reload attempts or not
     */
	
	public boolean refreshPageAndCheckElementIsNotDisplayed(By by, int maxReloadAttempts) {
        for (int i = 0; i < maxReloadAttempts; i++) {
            if (isDisplayed(by)) {
                pageRefresh();
                wait.waitForPageToLoadCompletely();
                TestNGLogUtility.info("Page Refreshed as element found");
            }
            else
                return true;
        }
		return false;
    }
	
	/**
	 * @author gupta.mansi
	 * This method closes current tab and navigates to parent window
	 */
	public void closeCurrentWindowAndSwitchToParent()
	{
		closeWindow();
		switchToParentWindow();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on count for given type from widget on HM dashboard
	 * @param countToClickName
	 */
	public void clickOnCountFromWidgetFromHMDashboard(String countToClickName)
	{
		switch(countToClickName)
		{
			case "Requirements":
				wait.waitForElementToBeClickable(lnkRequirementCount);
				click(lnkRequirementCount);
				break;
			case "Applications":
				wait.waitForElementToBeClickable(lnkApplicationCount);
				click(lnkApplicationCount);
				break;
			case "Pending Reviews":
				wait.waitForElementToBeClickable(pendingReviewsCount);
				click(pendingReviewsCount);
				break;
			case "Upcoming Interviews":
				wait.waitForElementToBeClickable(lnlUpcomingInterview);
				click(lnlUpcomingInterview);
				break;
			case "Pending Reviews / Feedback":
				wait.waitForElementToBeClickable(lnkPendingReviewCountSectionCount);
				click(lnkPendingReviewCountSectionCount);
				break;
			case "Upcoming Interviews Section":
				wait.waitForElementToBeClickable(lnkUpcomingInterviewSectionCount);
				click(lnkUpcomingInterviewSectionCount);
				break;
		}
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true is Give Feedback dd is displayed for given application id on dashboard
	 * @param appId-application id
	 * @return
	 */
	public boolean isGiveFeedbackDDForApplicationIdDisplayed(String appId)
	{
		return isDisplayed(parameterizedLocator(ddGiveFeedbackForApplicationId, appId));
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if application is displayed under upcoming interview section
	 * @param appID
	 */
	public boolean isApplicationDisplayedUnderUpcomingInterviewSection(String appID)
	{
		return isDisplayed(parameterizedLocator(eleApplicationUnderUpcomingInterviewSection,appID));
	}
	
	/**
	 * @author gupta.mansi
	 * This method clicks on application name for given aplication id
	 * @param appId
	 */
	public void clickOnApplicationIDFromUpcomingSection(String appId)
	{
		click(parameterizedLocator(eleApplicationUnderUpcomingInterviewSection,appId));
		switchToChildWindow();
	}
	
	/**
	 * @author gupta.mansi
	 * This method click on count of Application from dashboard
	 */
	public void clickOnApplicationCountFromDashboard()
	{
		click(applicationsCount);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given text
	 * @param text
	 */
	public void genericClick(String text)
	{
		jsUtil.scrollMid(parameterizedLocator(txtGeneric, text));
		click(parameterizedLocator(txtGeneric, text));
	}
	
}