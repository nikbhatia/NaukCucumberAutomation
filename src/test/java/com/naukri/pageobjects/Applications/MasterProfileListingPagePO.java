package com.naukri.pageobjects.Applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Dashboard.DashboardPagePO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Page Object class comprises of all page object definition required for master profile listing page
 * @author rachit.mehrotra
 */

public class MasterProfileListingPagePO extends PageObjectWrapper {
	
	//Objects 
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	DashboardPagePO dashboardPagePO = (DashboardPagePO) PageObjectWrapper.getObject(DashboardPagePO.class);
	CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	
	//Locators
	//One is used for indexing as when duplicacy service is down there can more than one master profile
	public By commentIconOnListing_btn = By.xpath("(//a[contains(@id , \"comntOuter\")])[1]");
	public By commentTextArea_text = By.id("commentsTextArea");
	public By addComment_btn = By.xpath("//a[contains(text(),\"Add Comment\")]");
	public By commentCount = By.xpath("(//span[contains(@id,\"commentCountDisplay\")])[1]");
	public By commentTextList = By.xpath("//ul[contains(@class , \"commentList\")]/li/p");
	By eleCandidateNameHolder = By.xpath("//a[contains(@title,'${candidateName}')]");
	By eleStrongCandidate = By.xpath("//strong[contains(text(),'${replacementTag}')]");
	By eleErrorMessage = By.id("errorCheckBoxMsg");
	By eleForwardOption = By.id("rpSendForwardEmail");
	By eleStarRating = By.xpath("//div[contains(@id,\"starRating\")]");
	By eleStatusChange = By.xpath("//div[contains(@class,\"interOuter\")]");
	By eleComment = By.xpath("//a[contains(@id,\"comntOuter\")]");
	By eleAddCommentText = By.id("commentsScroll");
	By eleCommentTextHolder = By.xpath("//p[contains(text(),'${commentText}')]");
	By eleAddToRequirement = By.id("addToProjectTrig");
	By eleAddToRequirementOnCandidateTupple = By.xpath("//a[contains(@id,\"triggerAddSingleCandidate\")]");
	By elePersonalProfileIcon = By.xpath("//small[contains(@class,\"prsnlDb\")]");
	By elePersonalProfileToolTipContainer = By.xpath("//small[contains(@class,\"prsnlDb\")]/parent::span");
	By eleCountOfApplications = By.id("totalRecord");
	By eleSortBySelect = By.xpath("//span[contains(text(),\"Sort by\")]/following-sibling::select");
	By elePageSizeSelect = By.xpath("(//span[contains(text(),\"Show\")]/following-sibling::select)[${count}]");
	By eleSearchBar = By.id("keywordSearch");
	By eleSearchBtn = By.id("searchKeyword");
	By eleCurrentKeyHolder = By.xpath("//em[contains(text(),'${test}')]/following-sibling::span/span");
	By eleCallStatusMenu = By.xpath("//div[contains(@class,\"interDrop\")]");
	By eleCallStatusOption = By.xpath("//a[contains(text(),'${option}')]");
	By eleFacetTextHolder = By.xpath("//span[contains(text(),'${facetText}')]");
	By eleFilterCount = By.xpath("//label[text()='${filterText}']/span");
	By eleFilterCheckbox = By.xpath("//label[text()='${filterText}']/input");
	By elePrivateCVsCount = By.xpath("//label[text()=\" Private CVs\"]/span");
	By elePrivateCVsCheckbox = By.xpath("//label[text()=\" Private CVs\"]/input");
	By eleDateGetterPlaceholder = By.xpath("//span[contains(text(),'${dateFormat}')]/small");
	
	private List<String> salaryList = Arrays.asList("Less than 1 Lakh","1 to 3 Lakhs","3 to 7 Lakhs","7 to 14 Lakhs","14 to 28 Lakhs","28 Lakhs or more");
	
	//Variables
	public static List<String> commentAgainstMasterProfileList = new ArrayList<String>();
	final int maximumTimeForWaitForMasterProfile = 60;
	public int timerCount = 0;
	int localTimer = 1;
	int localCommentCount = 0;
	int commentCountInt = 0;
	static int pageCount;
	String highlightClassName = "h-light";
	/**
	 * To wait for presence of master profile
	 * @author rachit.mehrotra
	 * @param masterProfileSearchKeyword
	 */
	public void waitForMasterProfileToLoad(String masterProfileSearchKeyword) {
		while(!((genericFunctions.checkInvisibilityOfElement(By.xpath("//span[text()=\""+AddASingleProfilePagePO.emailId+"\"]")) || genericFunctions.checkInvisibilityOfElement(By.xpath("//span[text()=\""+AddASingleProfilePagePO.contactNumber+"\"]")))
				&& (timerCount<maximumTimeForWaitForMasterProfile))) {
			wait.hardWait(localTimer);
			timerCount+=localTimer;
			cvDetailsPagePO.fillGlobalSearchText(masterProfileSearchKeyword);
		}
	}
	
	/**
	 * To fill comment on master profile through master profile listing page
	 * @author rachit.mehrotra
	 * @param masterProfileSearchKeyword
	 */
	public void fillCommentText(String masterProfileSearchKeyword) {
		waitForMasterProfileToLoad(masterProfileSearchKeyword);
		String commentText = "comment " + Long.toString(System.currentTimeMillis());
		click(commentIconOnListing_btn);
		sendKeys(commentTextArea_text, commentText);
		commentAgainstMasterProfileList.add(commentText);
		click(addComment_btn);
		localCommentCount++;
	}
	
	/**
	 * To check for comment count basis master profile
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkForCommentCount() {
		cvDetailsPagePO.fillGlobalSearchText(AddASingleProfilePagePO.emailId);
		wait.waitForPageToLoadCompletely();
		boolean flag = (localCommentCount == Integer.parseInt(getText(commentCount)));
		if(!flag) {
			TestNGLogUtility.info("Count from UI " + getText(commentCount));
			TestNGLogUtility.info("Count from list " + localCommentCount);
		}
		return flag;
	}
	
	/**
	 * To verify the comment content
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkCommentContext() {
		List<WebElement> listOfComments = getElements(commentTextList);
		int commentListSize = commentAgainstMasterProfileList.size();
		TestNGLogUtility.info("commentListSize " + commentListSize);
		for(int i = 0 ; i < listOfComments.size() ; i++) {
			if(!getText(listOfComments.get(i)).equalsIgnoreCase(commentAgainstMasterProfileList.get(i))) {
				return false;
			}
			commentListSize--;
		}
		return true;
	}
	
	/**
	 * To navigate to master profile CV details page
	 * @author rachit.mehrotra
	 */
	public void clickOnCandidateNameToNavigate() {
		click(By.xpath("(//span[contains(text(),\""+AddASingleProfilePagePO.emailId+"\")]/ancestor::div[contains(@class,\"srchTup\")])//strong[contains(@class , \"fl \")]/a"));
	}
	
	/**
	 * To match the comments against a particular profile stored as a list
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkCommentsFromListingPage() {
		List<WebElement> listOfCommentsFromCVDetailsPage = getElements(commentTextList);
		int commentListSize = commentAgainstMasterProfileList.size();
		for(int i = 0 ; i < listOfCommentsFromCVDetailsPage.size() ; i++) {
			if(!getText(listOfCommentsFromCVDetailsPage.get(i)).equalsIgnoreCase(commentAgainstMasterProfileList.get(i))) {
				return false;
			}
			commentListSize--;
		}
		return true;
	}
	
	/**
	 * To compare master profile cv details page URL 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean comparePageURL() {
		switchToChildWindow();
		return driver.getCurrentUrl().contains(YamlReader.getAppConfigValue("URLs.candidateDetailsPage"));
	}

	public boolean verifyThePresenceOfMasterProfile() {
		int counter = 0;
		String candidateName = PropFileHandler.readProperty("candidateName");
		TestNGLogUtility.info("Candidate name fetched from property file is " + candidateName);
		boolean visibilityParam = isDisplayed(parameterizedLocator(eleCandidateNameHolder, candidateName));
		while(!visibilityParam && counter < 5) {
			counter+=1;
			dashboardPagePO.searchMasterProfileOnDashboard();
		}
		return visibilityParam;
	}
	
	public boolean verifyThePresenceOfErrorMessage(String expectedStringMessage) {
		return isDisplayed(parameterizedLocator(eleStrongCandidate, expectedStringMessage.split("!")[0])) &&
				getText(eleErrorMessage).trim().contains(expectedStringMessage.split("!")[1].trim());
	}
	
	public void clickOnForwardOptionForMasterProfile() {
		click(eleForwardOption);
	}
	
	public boolean verifyThePresenceOfStatusStripOnMasterProfile() {
		return isDisplayed(eleStatusChange);
	}
	
	public boolean verifyThePresenceOfStarRating() {
		return isDisplayed(eleStarRating);
	}
	
	public boolean verifyThePresenceOfComment() {
		return isDisplayed(eleComment);
	}
	
	public void clickOnCommentOption() {
		click(eleComment);
	}
	
	public boolean verifyThePresenceOfAddComment() {
		return isDisplayed(eleAddCommentText);
	}
	
	public void fillInCommentText(String commentString) {
		sendKeys(commentTextArea_text, commentString);
		TestNGLogUtility.info("comment text input " + commentString);
	}
	
	public void clickOnAddCommentButton() {
		commentCountInt++;
		click(addComment_btn);
	}
	
	public boolean verifyTheTextOfComment(String expectedComment) {
		return getText(parameterizedLocator(eleCommentTextHolder, expectedComment)).equals(expectedComment);
	}
	
	public boolean verifyIncrementedCommentCount() {
		return commentCountInt == Integer.parseInt(getText(commentCount));
	}
	
	public void clickOnAddToRequirement() {
		click(eleAddToRequirement);
		TestNGLogUtility.info("Add to requirement clicked");
	}
	
	public void clickOnAddToRequirementOnCandidateTupple() {
		click(eleAddToRequirementOnCandidateTupple);
	}
	
	public boolean verifyThePresenceOfPersonalIcon() {
		return isDisplayed(elePersonalProfileIcon);
	}
	
	public boolean verifyTheToolTipForPersonal(String expectedToolTip) {
		return getAttribute(elePersonalProfileToolTipContainer, "title").equals(expectedToolTip);
	}
	
	public void getPageCount() {
		wait.waitForProcessingToDisappear(10, 3);
		pageCount = Integer.parseInt(getText(eleCountOfApplications));
		TestNGLogUtility.info("pageCount " + pageCount);
	}
	
	public void changeTheSortType(String sortingKey) {
		selectByVisibleText(eleSortBySelect, sortingKey);
		TestNGLogUtility.info("Sorting Set to " + sortingKey);
	}
	
	public boolean verifyApplicationCountOfPageAfterFilter() {
		return Integer.parseInt(getText(eleCountOfApplications)) == pageCount;
	}
	
	public void changeThePageSize(String pageSize, String presenceOfPageSize) {
		wait.waitForProcessingToDisappear(10, 5);
		selectByVisibleText(parameterizedLocator(elePageSizeSelect, presenceOfPageSize), pageSize);
		TestNGLogUtility.info("page size changed to " + pageSize);
	}
	
	public void fetchValueAndSearchFromPropertyFileBasedOnKey(String key) {
		String value = PropFileHandler.readProperty(key);
		searchKeyword(value);
	}
	
	public void searchKeyword(String keywordToBeSearched) {
		sendKeys(eleSearchBar, keywordToBeSearched);
		click(eleSearchBtn);
	}
	
	public boolean verifyHighlightingBasedOnKey(String key) {
		wait.waitForProcessingToDisappear(10, 3);
		return getAttribute(parameterizedLocator(eleCurrentKeyHolder, key), "class").equals(highlightClassName);
	}
	
	public void selectTheDesiredContactOption(String contactOption) {
		actionBuilderUtil.hoverByActionAlternate(eleCallStatusMenu);
		click(parameterizedLocator(eleCallStatusOption, contactOption));
	}
	
	public boolean verifyTheContactStatus(String expectedString) {
		return getText(eleCallStatusMenu).contains(expectedString);
	}
	
	public void clickOnFacet(String facetText) {
		click(parameterizedLocator(eleFacetTextHolder, facetText));
		TestNGLogUtility.info("facet clicked " + facetText);
	}
	
	public boolean verifyPresenceOfNumberAgainstFilter(int countOfApplications,String propertyFileKey) {
		String propertyFileValue = PropFileHandler.readProperty(transformStringOfPropertyFileKey(propertyFileKey));
		if(propertyFileKey.contains("annual salary")) 
			propertyFileValue = transformationOfSalary(propertyFileValue);
		return Integer.parseInt(getText(parameterizedLocator(eleFilterCount, " "+propertyFileValue))) == countOfApplications;
	}
	
	public void clickOnFilterChecbox(String propertyFileKey) {
		String propertyFileValue = PropFileHandler.readProperty(transformStringOfPropertyFileKey(propertyFileKey));
		if(propertyFileKey.contains("annual salary")) 
			propertyFileValue = transformationOfSalary(propertyFileValue);
		click(parameterizedLocator(eleFilterCheckbox, " "+propertyFileValue));
		TestNGLogUtility.info("Clicked on checkbox");
	}
	
	private String transformStringOfPropertyFileKey(String toBeTransformed) {
		if(toBeTransformed.contains(" ")) {
			String secondPortionOfString = toBeTransformed.split(" ")[1];
			toBeTransformed = toBeTransformed.split(" ")[0]+
					Character.toString(Character.toUpperCase(secondPortionOfString.charAt(0)))+
					secondPortionOfString.substring(1,secondPortionOfString.length());
		}
		return toBeTransformed;
	}
	
	private String transformationOfSalary(String propertyFileValue) {
		int salaryInLakhs = Integer.parseInt(propertyFileValue.split("\\.")[0]);
		if(salaryInLakhs < 0)
			propertyFileValue = salaryList.get(0);
		else if(salaryInLakhs>28)
			propertyFileValue = salaryList.get(6);
		else {
			for(int i = 1 ; i < salaryList.size() ; i++) {
				String cleanString = salaryList.get(i).replace("Lakhs", "");
				int lowerBound = Integer.parseInt(cleanString.split("to")[0].replaceAll(" ", ""));
				int upperBound = Integer.parseInt(cleanString.split("to")[1].replaceAll(" ", ""));
				if(salaryInLakhs >= lowerBound && salaryInLakhs < upperBound) {
					propertyFileValue = salaryList.get(i);
					break;
				}
			}	
		}
		return propertyFileValue;
	}
	
	public boolean verifyTheCountOfPrivateApplication(int countOfApplications) {
		return Integer.parseInt(getText(elePrivateCVsCount)) == countOfApplications;
	}
	
	public void clickOnCheckboxForPrivateApplications() {
		click(elePrivateCVsCheckbox);
	}
	
	public void clickOnMasterProfileCandidateName() {
		click(parameterizedLocator(eleCandidateNameHolder, PropFileHandler.readProperty("candidateName")));
		switchToChildWindow();
	}
	
	public boolean verifyThePresentDayDate(String dateLabelString) {
		return getText(parameterizedLocator(eleDateGetterPlaceholder, dateLabelString)).replace(dateLabelString, "").trim()
				.equals(commonAction.getPresentDayDateInApplicationsFormat());
	}
}
