package com.naukri.pageobjects.Requirements;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.naukri.automation.util.ReadWritePropertyFile;
import org.codehaus.groovy.classgen.genArrayAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.WaitUtility;
import com.naukri.pageobjects.Applications.UploadMultipleCVPagePO;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Requirement lisitng page object method
 * 
 * @author rachit.mehrotra
 *
 */
public class RequirementListingPagePO extends PageObjectWrapper {
	GenericFunctions genericFunction = (GenericFunctions) getObject(GenericFunctions.class);

	By eleRequirementStatusDiv = By.id("reqStatus");
	By ddlRequirementStatus = By.id("inp_reqStatus");
	By eleRequirementStatusFilter = By.xpath("//ul[@id=\"ul_reqStatus\"]//a[contains(text(),'${requirementFilter}')]");
	By ddRequirementSource = By.id("inp_reqSource");
	By eleRequirementSource = By.xpath("//ul[@id=\"ul_reqSource\"]/li");
	By eleRequirementName = By.xpath("//a[text()=' ${requirementName} ']");
	By eleRequirementSearchBar = By.id("keywords");
	By eleRequirementSearchButton = By.xpath("//form[@id=\"search\"]//input[contains(@class,\"qSearch \")]");
	By eleSourceCountForRequirement = By
			.xpath("//a[contains(text(),'${requirementName}')]/parent::div/following-sibling::div//a");
	By eleStatusGraphForRequirement = By
			.xpath("//a[contains(text(),'${requirementName}')]/ancestor::div[contains(@class,\"listWrap\")]/a");
	By eleRequirementOptionsOnListingPage = By.xpath(
			"//a[contains(text(),'${requirementName}')]/ancestor::div[@class=\"listWrap\"]//a[contains(text(),'${optionName}')]");
	By eleRequirementSubOptionOnOptionList = By
			.xpath("//a[contains(text(),'${mainOption}')]/following-sibling::ul//a[contains(text(),'${subOption}')]");
	By lstOfOptionsUnderTheOptionForRequirementListing = By.xpath(
			"//a[contains(text(),'${requirementName}')]/ancestor::div[@class='listWrap']//ul//a[contains(text(),'${optionName}')]//following-sibling::ul/li");
	By downloadByIndexHeader = By.xpath("//span[contains(@class,\"lbHead-title\")]");
	By eleTotalRequirementCount = By.id("totalRecord");
	By elePageLoader = By.xpath("//div[contains(@class,' processing-overlay processing-overlay-40')]");
	By eleFirstRequirementName = By.xpath("(//div[contains(@class,\"topHead\")]/a)['${count}']");
	By eleRequirementNewCount = By.xpath(
			"//a[contains(text(),'${requirementName}')]/ancestor::div[contains(@class,\"listWrap\")]/div[@class=\"profile\"]/p");
	By eleNotificationOnDashboard = By.xpath("//p[text()='${string}']");
	By eleCountForNotificationOnDashboard = By.xpath("//p[text()='${string}']//preceding-sibling::a");
	By eleMenuIconForNotificationCount = By
			.xpath("//h6[text()='Requirements created in last 30 days']//parent::div//i[text()='menuV']");
	By eleNotificationToBeSelected = By.xpath("//label[text()='${string}']");
	By eleRequirementApplicationCount = By.xpath(
			"//a[contains(text(),'${requirementName}')]/ancestor::div[@class='listWrap']//em[contains(@id,'appCount')]");
	
	By eleTopRequirement = By.xpath("(//div[contains(@class,'topHead')]//a)[1]");
	By eleCommentCountForTopRequirement = By.xpath("(//span[contains(@id,'commentCountDisplay')])[1]");
	By btnRefineRequirement = By.id("refine_project");
	By eleRefineBlock = By.id("refineblock");
	By btnUnderReqName = By.xpath("//a[@title='${reqName}']//parent::div//parent::div//a[text()='${btnName}']");
	By btnCloseReqOnLB = By.id("CloseSingle");
	By txtLabelName = By.xpath("//a[text()='${label}']");
	By eleCommentListingPage = By.xpath("//a[@title='${requirementName}']/ancestor::div[@class='listWrapa']//a[@class='ubCommentIcon']");
	By commentTextBox = By.id("commentsTextArea");
	By btnAddComment = By.xpath("//a[text()='Add Comment']");
	By btnDeleteComment = By.xpath("//a[@class='delIcon mt3 ml3 fl']");
	By noOfApplicationsFirstReq= By.xpath("(//div[@class='profile']//a/em)[1]");
	By eledDownlaodLightbox = By.xpath("//span[@class='lbHead-title ']");
	By eleCloseFirstReq = By.xpath("(//a[@class='closeSingleProject'])[1]");
	By statusReqIsClosed = By.xpath("//a[@title='${string}']/ancestor::div[@class='topHead']/following-sibling::ul//a[text()='Closed']");
	By eleSourcesOnReqListing = By.xpath("//a[@title='${string}']//ancestor::div[@class='topHead']/following-sibling::div//a");
	By eleOptionsOnJobListing = By.xpath("//a[@title='${string}']//ancestor::div[@class='listWrap']/following-sibling::div//ul[@class='manage cle']/li");
	By eleJobTypeListingPage= By.xpath("//div[text()='${jobTitle}']");
	By txtjobTitleOnListing = By.xpath("//div[contains(text(),'${jobTitle}')]");
	By PageCountFilter = By.xpath("//div[@class='pBlock fr']//select");
	By RequirementsOnFirstListingPage = By.className("topHead");
	By firstFilterUnderRefineReq = By.xpath("(//ul[@id='refinedata']//input)[1]");
	By countFirstReqFilter = By.xpath("(//ul[@id='refinedata']//small)[1]");
	By refineRequirementBtn = By.xpath("//a[text()='Refine Requirements']");
	By pageSizeRequirementsListing = By.xpath("//div[text()='Showing 1 to ${string} of ']");
	By totalCountRequirement = By.xpath("//em[@id='totalRecord']");
	By ddSuggestionRequirement = By.xpath("//div[@class=' suggestions']//b");
	By groupHeaderOnListingPage = By.xpath("//div[@class='qFilter cle']//div[text()='${string}']");
	By countOfRecuitersOnListingPage = By.xpath("//a[@title='${string}']/ancestor::div[@class='topHead']/following-sibling::div//ul[@class='dashHead cle']//a");
	By eleCloseReq = By.xpath("//a[contains(text(),' ${requirementName} ')]/ancestor::div[@class=\"listWrap\"]//a[@class='closeSingleProject']");
	
	// variables
	int totalRequirements, totalRequirementPerStatus = 0;
	static String requirementNameOnListingName, countOnDashboard;

	public static String fileSystemPathTillTestData() {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator;
		return filePath;
	}

	/**
	 * To check the presence of the requirement status filter on requirement listing
	 * page
	 * 
	 * @author rachit.mehrotra
	 * @param filterText
	 * @return boolean of presence/absence of status filter
	 */
	public boolean checkThePresenceOfStatusFilter(String filterText) {
		return isDisplayed(eleRequirementStatusDiv);
	}

	/**
	 * To check the default requirement status filter on requirement listing page
	 * 
	 * @author rachit.mehrotra
	 * @param statusFilterText
	 * @return boolean of default status of requirement is selected or not
	 */
	public boolean checkTheDefaultStatusFilterText(String statusFilterText) {
		return jsUtil.executeJavascriptForJSVariables("document.getElementById('inp_reqStatus').value")
				.replaceAll(" ", "").equals(statusFilterText.replace(" ", ""));
	}

	/**
	 * To click on the requirement status filter
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnRequirementStatusFilter() {
		click(eleRequirementStatusDiv);
	}

	/**
	 * To change the default status of requirement status filter
	 * 
	 * @author rachit.mehrotra
	 * @param filterName
	 * @param filterState
	 * @return boolean depending on the status of requirement filter
	 */
	public boolean checkTheDefaultStateOfRequirementFilter(String filterName, String filterState) {
		String checkedStatus = getAttribute(parameterizedLocator(eleRequirementStatusFilter, filterName), "class");
		if ((filterState.equals("checked") && checkedStatus.equals("chkd"))
				|| (filterState.equals("unchecked") && checkedStatus.equals("")))
			return true;
		return false;
	}

	/**
	 * To verify the default requirement source filter on requirement listing page
	 * 
	 * @author rachit.mehrotra
	 * @param defaultRequirementSource
	 * @return boolean for the selection of default status of requirement source
	 */
	public boolean verifyTheDefaultTextOnRequirementSourceFilter(String defaultRequirementSource) {
		return getAttribute(ddRequirementSource, "title").contains(defaultRequirementSource);
	}

	/**
	 * To click on the requirement source DD
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnRequirementSourceDD() {
		click(ddRequirementSource);
	}

	/**
	 * To verify the list of requirement source list on requirement listing page
	 * 
	 * @author rachit.mehrotra
	 * @param expectedRequirementSourceString
	 * @return boolean depending on the comparison of actual list and the list of
	 *         sources of the requirement source
	 */
	public boolean compareTheListOfRequirementSource(String expectedRequirementSourceString) {
		List<String> expectedRequirementSourceList = Arrays.asList(expectedRequirementSourceString.split(","));
		List<WebElement> lstrequirementSourceListWebElement = getElements(eleRequirementSource);
		for (int i = 0; i < expectedRequirementSourceList.size(); i++) {
			if (!getText(lstrequirementSourceListWebElement.get(i)).equals(expectedRequirementSourceList.get(i))) {
				TestNGLogUtility.info("expected " + expectedRequirementSourceList.get(i));
				TestNGLogUtility.info("actual " + lstrequirementSourceListWebElement.get(i).getText());
				return false;
			}
		}
		return true;
	}

	/**
	 * To check the visibility of the requirement created on the requirement listing
	 * page
	 * 
	 * @author rachit.mehrotra
	 * @return boolean basis visibility of the requirement
	 */
	public boolean checkTheVisibilityOfRequirementName() {
		int pageRefreshCount = 0;

		pageRefresh();
		wait.waitForVisibilityOfElement(parameterizedLocator(eleRequirementName, RequirementCreationPagePO.requirementName));
		while(!isDisplayed(parameterizedLocator(eleRequirementName, RequirementCreationPagePO.requirementName)) && pageRefreshCount < 3) {
				pageRefresh();
				pageRefreshCount+=1;
		}
		return isDisplayed(parameterizedLocator(eleRequirementName, RequirementCreationPagePO.requirementName));
	}

	/**
	 * to fill the requirement name in requirement search filter
	 * 
	 * @author rachit.mehrotra
	 */
	public void typeInRequirementNameInRequirementSearchFilter() {
		sendKeys(eleRequirementSearchBar, RequirementCreationPagePO.requirementName);
	}
	public void typeINRequirementIdInRequirementSearchFilter()
	{
		String getRequirementId = ReadWritePropertyFile
				.getProperty("RequirementTrackingId", fileSystemPathTillTestData() + "Data.properties");
		sendKeys(eleRequirementSearchBar,getRequirementId);
	}

	/**
	 * to click on the search button for quick search of requirement on requirement
	 * listing
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnSearchForRequirement() {
		click(eleRequirementSearchButton);
	}

	/**
	 * To verify the source count basis requirement name
	 * 
	 * @author rachit.mehrotra
	 * @param expectedSourceCount
	 * @return true/false depending the comparisson
	 */
	public boolean verifyTheSourceCountForRequirementOnRequirementListing(String expectedSourceCount) {
		boolean flag = false;
		if (expectedSourceCount.equals("0"))
			flag = isDisplayed(
					parameterizedLocator(eleSourceCountForRequirement, RequirementCreationPagePO.requirementName));
		return flag;
	}

	/**
	 * To click on the status graph basis requirement name
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnStatusRequirementBasisRequirementName() {
		click(parameterizedLocator(eleStatusGraphForRequirement, RequirementCreationPagePO.requirementName));
	}

	/**
	 * To check the state of status graph of requirement basis status filter
	 * 
	 * @author rachit.mehrotra
	 * @param expectedState
	 * @return true/false basis the state of the requirement
	 */
	public boolean checkTheStateOfRequirementStatusGraph(String expectedState) {
		if (expectedState.equals("disabled"))
			return getAttribute(
					parameterizedLocator(eleStatusGraphForRequirement, RequirementCreationPagePO.requirementName),
					"class").contains("opacityInact");
		return false;
	}

	/**
	 * To hover on the requirement name basis requirement creation
	 * 
	 * @author rachit.mehrotra
	 * @param requirementOption
	 * @param requirementType
	 */
	public void hoverOnRequirementOptions(String requirementOption, String requirementType) {
		//driver.navigate().refresh();
		wait.waitForPageToLoadCompletely();
		wait.resetImplicitTimeout(1);
		if (requirementType.equals("requirement created")) {
			TestNGLogUtility
					.info("created display " + isDisplayed(parameterizedLocator(eleRequirementOptionsOnListingPage,
							RequirementCreationPagePO.requirementName, requirementOption)));
			actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(eleRequirementOptionsOnListingPage,
					RequirementCreationPagePO.requirementName, requirementOption));
		}
		if (requirementType.equals("requirement listed"))
			actionBuilderUtil.hoverByActionAlternate(parameterizedLocator(eleRequirementOptionsOnListingPage,
					requirementNameOnListingName, requirementOption));
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
	}

	/**
	 * To click on submenu option of requirement's option basis name on requirement
	 * listing page
	 * 
	 * @param requirementSubOption
	 * @param requirementMainOption
	 * @param requirementType
	 */
	public void clickOnRequirementOptionSubMenu(String requirementSubOption, String requirementMainOption,
			String requirementType) {
		//more actions , add single profile , rquirement created
		hoverOnRequirementOptions(requirementType, requirementMainOption);
		click(parameterizedLocator(eleRequirementSubOptionOnOptionList, requirementSubOption, requirementMainOption));
	}

	/**
	 * To compare the list of actual option and UI option for each action for a
	 * requirement basis requirement name
	 * 
	 * @author rachit.mehrotra
	 * @param expectedOptionResult
	 * @param mainOption
	 * @param requirementType
	 * @return true/false basis comparison
	 */
	public boolean compareTheListOfOptions(String expectedOptionResult, String mainOption, String requirementType) {
		hoverOnRequirementOptions(mainOption, requirementType);
		List<String> listOfExpectedOptions = Arrays.asList(expectedOptionResult.split(","));
		List<WebElement> listOfActualOptions = null;
		if (requirementType.equals("requirement created")) {
			listOfActualOptions = getElements(parameterizedLocator(lstOfOptionsUnderTheOptionForRequirementListing,
					RequirementCreationPagePO.requirementName, mainOption));
			TestNGLogUtility.info("actual list size of options = " + listOfActualOptions.size());
		}
		if (requirementType.equals("requirement listed")) {
			wait.waitForVisibilityOfElement(parameterizedLocator(lstOfOptionsUnderTheOptionForRequirementListing,
					requirementNameOnListingName, mainOption));
			listOfActualOptions = getElements(parameterizedLocator(lstOfOptionsUnderTheOptionForRequirementListing,
					requirementNameOnListingName, mainOption));
		}
		for (int i = 0; i < listOfExpectedOptions.size(); i++) {
			if (!getText(listOfActualOptions.get(i)).equals(listOfExpectedOptions.get(i))) {
				TestNGLogUtility.info("Expected Option " + listOfExpectedOptions.get(i));
				TestNGLogUtility.info("Actual Option " + getText(listOfActualOptions.get(i)));
				return false;
			}
		}
		return true;
	}

	/**
	 * To check the download by index presence as a sub option
	 * 
	 * @author rachit.mehrotra
	 * @return true/false basis presence
	 */
	public boolean presenceOfDownloadByIndexOnRequirementListing() {
		return isDisplayed(downloadByIndexHeader);
	}

	/**
	 * To check/uncheck the status filter on the basis of filter
	 * 
	 * @author rachit.mehrotra
	 * @param checkStatus
	 * @param checkboxLabel
	 */
	public void changeStateOfStatusFilterOnRequirementListingPage(String checkStatus, String checkboxLabel) {
		String checkedStatus = getAttribute(parameterizedLocator(eleRequirementStatusFilter, checkboxLabel), "class");
		TestNGLogUtility.info("checked status is " + checkedStatus);
		if ((checkStatus.equals("check") && checkedStatus.equals(""))
				|| (checkStatus.equals("uncheck") && checkedStatus.equals("chkd"))) {
			TestNGLogUtility.info(checkboxLabel + " is clicked");
			click(parameterizedLocator(eleRequirementStatusFilter, checkboxLabel));
		}
	}

	/**
	 * To check the requirement count listed on the requirement listing page
	 * 
	 * @author rachit.mehrotra
	 * @param count
	 */
	public void recordTotalCount(int count) {
		wait.waitForInvisibilityOfElement(10, 3, elePageLoader);
		if (count == 0)
			totalRequirements = Integer.parseInt(getText(eleTotalRequirementCount));
		if (count == 1)
			totalRequirementPerStatus = Integer.parseInt(getText(eleTotalRequirementCount));
	}

	/**
	 * To check the requirement total count without any filter and with all 3
	 * filters
	 * 
	 * @author rachit.mehrotra
	 * @return true/false basis comparison and presence of the requirement on
	 *         listing page
	 */
	public boolean checkForRequirementCount(String account) {
		if(account.equals("ProConsultant"))
		{
			return (totalRequirements == totalRequirementPerStatus);
		}
		else
		return (totalRequirements > totalRequirementPerStatus);
	}

	/**
	 * To read the first requirement name on the requiement listing page
	 * 
	 * @author rachit.mehrotra
	 */
	public void readTheRequirementName() {
		requirementNameOnListingName = getText(parameterizedLocator(eleFirstRequirementName, "1"));
	}

	public boolean checkForPresenceOfMultipleUploadRequirementCreated() {
		int i = 0;
		if (!isDisplayed(
				parameterizedLocator(eleRequirementName, UploadMultipleCVPagePO.requirementNameOfMultipleUpload))
				&& i < 10) {
			pageRefresh();
			i++;
		}
		return isDisplayed(
				parameterizedLocator(eleRequirementName, UploadMultipleCVPagePO.requirementNameOfMultipleUpload));
	}

	public boolean checkForThePresenceOfNewCount(String requirementName, int newCount) {
		System.out.println("requirement name " + requirementName + "count " + newCount);
		refreshForCountOfApplications(requirementName);
		String newCountString = getText(parameterizedLocator(eleRequirementNewCount, requirementName)).replace("New ",
				"");
		return Integer.parseInt(newCountString) == newCount;
	}

	public void refreshForCountOfApplications(String requirementName) {
		int i = 0;
		while (i < 10) {
			if (Integer.parseInt(getText(parameterizedLocator(eleRequirementApplicationCount, requirementName))) == 0) {
				wait.hardWait(1);
				pageRefresh();
				i++;
				if (Integer
						.parseInt(getText(parameterizedLocator(eleRequirementApplicationCount, requirementName))) == 0
						&& i == 10)
					Assert.assertTrue(false,
							"Application count is not being displayed against the requirement on requirement listing page.");
			} else {
				return;
			}
		}
	}

	/**
	 * add Notification On Dashboard If Not Present
	 * 
	 * @param notificationOnDashboard
	 * @author udit.khanna
	 */
	public void addNotificationOnDashboardIfNotPresent(String notificationOnDashboard) {
		if (isDisplayed(eleNotificationOnDashboard, notificationOnDashboard))
			;
		else {
			click(eleMenuIconForNotificationCount);
			click(parameterizedLocator(eleNotificationToBeSelected, notificationOnDashboard));
		}
	}

	/**
	 * click Count On Notofication On Dashboard
	 * 
	 * @param notificationOnDashboard
	 * @author udit.khanna
	 */
	public void clickCountOnNotoficationOnDashboard(String notificationOnDashboard) {
		countOnDashboard = getText(parameterizedLocator(eleCountForNotificationOnDashboard, notificationOnDashboard));
		click(parameterizedLocator(eleCountForNotificationOnDashboard, notificationOnDashboard));
		switchToChildWindow();
	}

	/**
	 * total Count On DashBoard Match On Req Listing
	 * 
	 * @return true is count matches
	 * @author udit.khanna
	 */
	public boolean totalCountOnDashBoardMatchOnReqListing() {
		return getText(eleTotalRequirementCount).trim().equalsIgnoreCase(countOnDashboard);
	}

	/**
	 * This method will click on application count switch on new tab
	 * 
	 * @param requirementName
	 */
	public void clickOnApplicationCount(String requirementName) {
		refreshForCountOfApplications(requirementName);
		click(parameterizedLocator(eleRequirementApplicationCount, requirementName));
		genericFunction.switchToChildWindow();
	}

	public void clickOnRequirementName(String reqName) {
		wait.hardWait(5);
		driver.navigate().refresh();
		wait.waitForPageToLoadCompletely();
		if(!isDisplayed(parameterizedLocator(eleRequirementName,reqName)))
		{
			driver.navigate().refresh();
			wait.waitForPageToLoadCompletely();
		}
		wait.waitForElementToBeClickable(parameterizedLocator(eleRequirementName,reqName));
		click(parameterizedLocator(eleRequirementName, reqName));
		genericFunction.switchToChildWindow();
	}
	
	/**
	 * @author gupta.mansi
	 * This method return name of top requirement
	 * @return name of top req in String
	 */
	public String getNameOfTopRequirement()
	{
		wait.waitForPageToLoadCompletely();
		return getText(eleTopRequirement);
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true if comment count is displayed for requirement
	 * @return true if comment count is displayed for requirement
	 */
	public boolean presenceOfCommentCountForTopRequirement()
	{
		return isDisplayed(eleCommentCountForTopRequirement);
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if given button is displayed on requirement listing page
	 * @param filterName
	 * @return true if given button is displayed on requirement listing page
	 */
	public boolean presnceOfFilterUnderRefineRequirementOnRequirementListing(String filterName)
	{
		boolean flag = false;
		switch(filterName)
		{
			case "By Group":
			case "Created By":
			case "Visible To":
			case "By Functional Area":
			case "By Industry":
			case "Refine Requirements":
			case "Clear All ":
			case " Close":
				flag =  isDisplayed(parameterizedLocator(txtLabelName, filterName));
		}
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method clicks on refine reuirement filter
	 */
	public void clickOnRefineRequirementFilter()
	{
		wait.waitForPageToLoadCompletely();
		//jsUtil.clickByJS(btnRefineRequirement);
		jsUtil.executeJavascript("document.getElementById('refine_project').click();");
		wait.waitForVisibilityOfElement(eleRefineBlock);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given button under given requirement name on requirement listing page
	 * @param btnName
	 * @param requirementName
	 */
	public void clickOnButtonForRequirement(String btnName,String requirementName)
	{
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnUnderReqName,requirementName,btnName));
	}
	public void clickOnButtonForCreatedReqOnListingPage(String btn)
	{
		clickOnButtonForRequirement(btn, RequirementCreationPagePO.requirementName);
	}

	/**
	 * @author gupta.mansi
	 * This method return true if given button is displayed under given requirement name
	 * @param btnName
	 * @param requirementName
	 * @return true if given button is displayed under given requirement name
	 */
	public boolean presenceOfButtonForRequirement(String btnName, String requirementName)
	{
		return isDisplayed(parameterizedLocator(btnUnderReqName,requirementName,btnName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on close button from close requirement lightbox
	 */
	public void clickOnCloseButtonOnCloseRequirementLightbox()
	{
		click(btnCloseReqOnLB);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * Total count of records on page
	 * @return count of record on page in int
	 */
	public int totalRecordCount()
	{
		return Integer.parseInt(getText(eleTotalRequirementCount).trim());
	}
	
	/**
	 * @author gupta.mansi
	 * To check the presence of the requirement source filter on requirement listing page
	 * @param filterText
	 * @return boolean of presence/absence of status filter
	 */
	public boolean checkThePresenceOfSourceFilter() {
		return isDisplayed(ddRequirementSource);
	}
	
	/**
	 * To check the requirement total count without any filter and with all 3
	 * filters
	 * @author gupta.mansi
	 * @return true/false basis comparison and presence of the requirement on
	 *         listing page
	 */
	public boolean checkForRequirementCountWhenAllSelected() {
		return (totalRequirements == totalRequirementPerStatus);
	}

	public boolean verifyCategorizationOfRequirement()
	{
		wait.waitForPageToLoadCompletely();
		return 	isDisplayed(btnRefineRequirement);
	}
	public boolean verifyCategorizationFilters(String fil1, String fil2, String fil3, String fil4, String fil5)
	{
		return isDisplayed(parameterizedLocator(txtLabelName,fil1)) && isDisplayed(parameterizedLocator(txtLabelName,fil2)) &&
				(isDisplayed(parameterizedLocator(txtLabelName,fil3)) || isDisplayed(parameterizedLocator(txtLabelName,"By Employer"))) && isDisplayed(parameterizedLocator(txtLabelName,fil4)) &&
				isDisplayed(parameterizedLocator(txtLabelName,fil5)) ;
	}
	public void userClicksOnCommentsIconReqCreated()
	{
		String getRequirementTitle = ReadWritePropertyFile.getProperty("createdRequirementName",fileSystemPathTillTestData() + "Data.properties");
		//click(parameterizedLocator(eleCommentListingPage, getRequirementTitle));
		click(eleCommentCountForTopRequirement);
		}
	public void enterComment()
	{
		wait.waitForVisibilityOfElement(commentTextBox);
		String commentOnRequirement = "Test comment1";
		sendKeys(commentTextBox, commentOnRequirement);
		wait.waitForElementToBeClickable(btnAddComment);
		click(btnAddComment);
	}
	public boolean verifyTheCountOfCommentOnListingPage(String countOfComment)
	{
		wait.hardWait(2);
		return getText(eleCommentCountForTopRequirement).contains(countOfComment);
	}
	public void deleteCommentOnTopReq()
	{
		click(btnDeleteComment);
	}
	public boolean verifyApplicationCountOnListingPage(String appCount)
	{
		driver.navigate().refresh();
		return getText(parameterizedLocator(eleRequirementApplicationCount, RequirementCreationPagePO.requirementName)).contains(appCount);
		
	}
	public boolean verifyDownloadByIndexLightbox()
	{
		return getText(eledDownlaodLightbox).contains("Download");
	}
	public void userMarksReqAsClosed()
	{
		wait.waitForElementToBeClickable(parameterizedLocator(eleCloseReq,RequirementCreationPagePO.requirementName));
		click(parameterizedLocator(eleCloseReq,RequirementCreationPagePO.requirementName));
		clickOnCloseButtonOnCloseRequirementLightbox();
	}
	public boolean verifyStatusOfRequirementIsClosed()
	{
		driver.navigate().refresh();
		return isDisplayed(parameterizedLocator(statusReqIsClosed,RequirementCreationPagePO.requirementName));
	}
	public void userClicksOnSourcesUnderReq()
	{
		click(parameterizedLocator(eleSourcesOnReqListing,RequirementCreationPagePO.requirementName));
		wait.hardWait(2);
	}
	public boolean verifyListOfOptionPresentForAJob(String optionsList) {
		List<String> listOfOptionsExpected = Arrays.asList(optionsList.split(","));
		List<WebElement> listOfOptionsOnUi = getElements(parameterizedLocator(eleOptionsOnJobListing,RequirementCreationPagePO.requirementName));
		for(int i = 0 ; i < listOfOptionsExpected.size() ; i++) {
			if(!listOfOptionsExpected.get(i).contains(listOfOptionsOnUi.get(i).getText()))
				return false;
		}
		return true;
	}
	public boolean verifyjobTypeOnListingPage(String job)
	{
		return isDisplayed(parameterizedLocator(eleJobTypeListingPage, job));
	}
	public boolean verifyUpdatedJobOnListingPage()
	{
		String jobTitle = "Updated Job Title";
		return isDisplayed(parameterizedLocator(txtjobTitleOnListing,jobTitle));
	}
	public void selectRequirementCountOnPage(String count)
	{
		WebElement we  = getElement(PageCountFilter);
		Select selectCount = new Select(we);
		selectCount.selectByValue(count);

	}
	public boolean verifyRequirementCountOnListing(String count)
	{
		wait.waitForVisibilityOfElement(parameterizedLocator(pageSizeRequirementsListing,count));
		return getElements(RequirementsOnFirstListingPage).size()== Integer.parseInt(count);
	}
	public void clickOnFirstFilterOnRefineRequirement()
	{
		click(firstFilterUnderRefineReq);
		String expectedCountRequirement = getElement(countFirstReqFilter).getText().replaceAll("[()]","");
		ReadWritePropertyFile.setProperty("filterCOuntReqExpected",expectedCountRequirement,fileSystemPathTillTestData()+ "Data.properties");
	}
	public void refineRequirementsOnListingPage()
	{
		wait.waitForVisibilityOfElement(refineRequirementBtn);
		jsUtil.clickByJS(refineRequirementBtn);
	}
	public boolean verifyRequirementCOuntOnListingPage()
	{
		wait.waitForPageToLoadCompletely();
		String actual = ReadWritePropertyFile.getProperty("filterCOuntReqExpected",fileSystemPathTillTestData()+ "Data.properties");
		return getText(totalCountRequirement).trim().contains(actual);
	}
//	public boolean verifyUserSearchedResultsDisplayed()
//	{
//		wait.hardWait(5);
//		String a = getText(ddSuggestionRequirement);
//		System.out.println(a);
//		String b = RequirementCreationPagePO.requirementName;
//		System.out.println(b);
//		return a.contains(b);
//	}
	public boolean verifyGroupsNotDisplayedOnListingpage()
	{
		return isDisplayed(parameterizedLocator(groupHeaderOnListingPage,"Group")) || isDisplayed(parameterizedLocator(groupHeaderOnListingPage,"Employer"));
	}
	public boolean verifyCountOfVisibilty(String count)
	{
		return getText(parameterizedLocator(countOfRecuitersOnListingPage,RequirementCreationPagePO.requirementName)).contains(count);
	}
	public boolean verifyreqVisibleToOnlySuperUser()
	{
		return isDisplayed(parameterizedLocator(countOfRecuitersOnListingPage,RequirementCreationPagePO.requirementName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method click name of top requirement
	 */
	public void clickNameOfTopRequirement()
	{
		wait.waitForPageToLoadCompletely();
		click(eleTopRequirement);
		switchToChildWindow();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to navigate to requirement overview page from requirement inbox page
	 */
	public void navigateToRequirementOverviewFromReqInbox()
	{
		if(getCurrentURL().contains("/profile/project/inbox/"))
		{
			click(parameterizedLocator(txtLabelName, "Overview"));
			wait.waitForPageToLoadCompletely();
		}
	}
	public boolean checkVisibiltyOfRequirement()
	{
		wait.hardWait(2);
		driver.navigate().refresh();
		return isDisplayed(parameterizedLocator(eleRequirementName, RequirementCreationPagePO.requirementName));
	}
	public void selectTheRequirementCreated()
	{
		click(parameterizedLocator(eleRequirementName,RequirementCreationPagePO.requirementName));
		switchToChildWindow();
	}
	public void typeINRequirementIdInRequisitionIdSearchFilter()
	{
		String getRequirementId = ReadWritePropertyFile
				.getProperty("RequisitionTrackingId", fileSystemPathTillTestData() + "Data.properties");
		sendKeys(eleRequirementSearchBar,getRequirementId);
	}

	

}

