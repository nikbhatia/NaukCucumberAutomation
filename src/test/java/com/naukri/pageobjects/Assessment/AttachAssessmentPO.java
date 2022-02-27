package com.naukri.pageobjects.Assessment;

import java.util.ArrayList;
import java.util.Arrays;
import org.openqa.selenium.By;

import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * 
 * @author rounak.jain
 *
 */
public class AttachAssessmentPO extends BaseAutomation {

	private By selectionStage = By.id("smtabStages");
	private By SelectonStage = By.xpath("(//div[text()='${stagename}'])[2]");
	private By testiconOnMatching = By.xpath("(//a[contains(@onclick,'Matching')])[2]");
	private By subStageSelectionStageTab = By.xpath("//div[text()='${stagename}']");

	private By firstCategory = By.xpath("(//span[@class='categoryName'])[1]");
	private By firstTest = By.xpath("(//div[@class='tableRow  ']//label)[1]");
	private By selectOnTestListing = By.cssSelector("button.select.blockBtn");
	private By selectAttachTest = By.cssSelector("button.select.blockBtn");
	private By mappedTestOnDashboard = By.cssSelector("div.assessmentText");
	private By getNoOfTestInFirstcategory = By.xpath("(//span[@class='noOfTests'])[1]");
	private By getFirstFiveTests = By.xpath("//div[@class='tableRow  ']");
	private By getNoOfTestHiddenInCategory = By.xpath("//a[@class='moreText']");
	private By secondCategoryTuple = By.xpath("(//div[@class='categoryTupple'])[2]");
	private By listOfAllTests = By.cssSelector("div.tableRow  ");
	private By searchbar = By.cssSelector("div.searchInput input");
	private By searchResults = By.xpath("//div[@class='rowData']//label");
	private By gettestName = By.xpath("//div[@class='selectedAssessment']//span[2]");
	private By stageName = By.xpath("//span[@class='stageTitle']");
	private By defaultNoOfDays = By.xpath("//input[@class='inputDays ']");
	private By editButton = By.xpath("//small[@class='editIc ml5']");
	private By sendTestAutomaticallyChkBox = By.xpath("(//span[@class='checkmark'])[1]");
	private By changeTestConfigureTestSettings = By.xpath("//span[text()='Change Test']");
	private By getDefaultCountCandidates = By.xpath("//input[@class='noInput ']");
	private By noOfDaysConfigurationPage = By.xpath("//input[contains(@class,'inputDays')]");
	private By errorActivationPeriod = By.xpath("//div[@class='activationError assessError']");
	private By NoOfHoursConfigurationPage = By.xpath("//input[contains(@class,'inputHours')]");
	private By totalCreditsOnConfigurationPage = By.xpath("//span[@class='creditsLeft']");
	private By errorMsgTotalCredits = By.xpath("//div[@class='assessError']");
	private By labelOfPage = By.xpath("//h2[@class='header-title']");
	private By BackBtnConfigurationPage = By.xpath("//div[@class='btn-back']");
	private By BackBtnCofirmationBox = By.xpath("//button[@class='confBtn yes']");
	private By restrictMultipleTabCheckbox = By.xpath("(//span[@class='heading1'])[6]/../label/span");
	private By clickButton = By.xpath("//button[text()='${buttonName}']");

	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
	/**
	 * @author rounak.jain To click on button present on attach assessment by
	 *         selection stage
	 * @param buttonName : name of the button
	 */
	public void clickOnButton(String buttonName) {
		wait.waitForPageToLoadCompletely();
		getElement(clickButton, buttonName).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author rounak.jain To click selection stage on SelectionStages tab
	 */

	public void clickOnSelectionStages() {
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
		getElement(selectionStage).click();
	}

	/**
	 * @author rounak.jain To click on SelectionStages tab
	 * @param stagename : name of the stage
	 */

	public void clickOnStageOnSelectionStageTab(String stagename) {
		wait.waitForPageToLoadCompletely();
		getElement(SelectonStage, stagename).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author rounak.jain To click on sub stages of selection stage tab
	 * @param subStagename : name of the sub Stage
	 */

	public void clicksubStage(String subStagename) {
		mouseHoverToWebElement(getElement(subStageSelectionStageTab, subStagename));
	}

	/**
	 * @author rounak.jain To verify test icon on stages
	 */

	public boolean verifyTesticonVisibleOrNotOnApplied() {
		return getElement(testiconOnMatching).isDisplayed();
	}

	/**
	 * @author rounak.jain To click on test icon
	 */
	public void clickTestIconOnMatching() {
		getElement(testiconOnMatching).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author rounak.jain To select the test from test collections
	 */
	public String clickOnFirstTest() {
		API.refreshPageAndCheckElementIsDisplayed(firstCategory, 5);
		click(firstCategory);
		wait.waitForVisibilityOfElement(firstTest);
		String FirstTest = getElement(firstTest).getText();
		click(firstTest);
		return FirstTest;
	}

	/**
	 * @author rounak.jain To click on select button
	 */
	public void clickOnSelect() {
		wait.waitForPageToLoadCompletely();

		getElement(selectOnTestListing).click();

	}

	/**
	 * @author rounak.jain To click on attach test button
	 */
	public void clickAttachTest() {
		wait.waitForPageToLoadCompletely();
		getElement(selectAttachTest).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author rounak.jain To get the mapped test list from dashboard
	 */
	public String getTextmappedTestOnDashboard() {
		return getElement(mappedTestOnDashboard).getText();
	}

	/**
	 * @author rounak.jain To get the total no of test from a category
	 */

	public int getTotalNoOfTestInACategory() {
		String StringNoOfTestsInCategory = getElement(getNoOfTestInFirstcategory).getText();
		int IntNoOfTestsInCategory = Integer.parseInt(StringNoOfTestsInCategory.replaceAll("[^0-9]", ""));
		return IntNoOfTestsInCategory;
	}

	/**
	 * @author rounak.jain To get the total no of invisible test
	 */

	public boolean noOfTestsVisibleOnCategory() {
		return getElement(getNoOfTestInFirstcategory).isDisplayed();
	}

	/**
	 * @author rounak.jain To click on first category
	 */

	public void clickOnFirstCategory() {
		getElement(firstCategory).click();
		wait.waitForVisibilityOfElement(firstTest);

	}

	/**
	 * @author rounak.jain To get the name of category
	 */

	public String getFirstCategory() {
		return getElement(firstCategory).getText();
	}

	/**
	 * @author rounak.jain To verify the category
	 * @param categoryName :name of test category
	 * @return It will return if category exist
	 */
	public boolean verifyfieldsOfCategory(String categoryName) {

		ArrayList<String> ActualFieldsOfcategory = new ArrayList<String>();
		ArrayList<String> ExpectedFieldsOfcategory = new ArrayList<>(
				Arrays.asList(categoryName, "Time Taken", "Questions"));
		for (int i = 1; i <= ExpectedFieldsOfcategory.size(); i++) {
			ActualFieldsOfcategory.add(getElement(By.xpath("//div[@class='tableHeader']/span[" + i + "]")).getText());
		}
		return ActualFieldsOfcategory.equals(ExpectedFieldsOfcategory);

	}

	/**
	 * @author rounak.jain To verify if the number of test is visible
	 *  @return It will return a flag if no of test are equal to 5 
	 */

	public boolean verifyFirstFiveVisible() {
		if (driver.findElements(getFirstFiveTests).size() >= 5) {
			int NoOfTest = driver.findElements(getFirstFiveTests).size();
			return NoOfTest == 5;
		} else
			return true;
	}

	/**
	 * @author rounak.jain To verify the view more link after the selection of 5
	 *         test totalTest : total number of test
	 * @return It will retun if view more link exist
	 */

	public boolean verifyViewNMoreTests(int totalTest) {
		if (totalTest <= 5) {
			return true;
		} else {
			int ExpectedNoOfTestHidden = totalTest - 5;
			int n = ExpectedNoOfTestHidden / 100;
			int p = ExpectedNoOfTestHidden % 100;

			String NoOfTestHidden = getElement(getNoOfTestHiddenInCategory).getText();
			System.out.println("No of tests hidden " + NoOfTestHidden);
			int IntNoOfTestHidden = Integer.parseInt(NoOfTestHidden.replaceAll("[^0-9]", ""));
			System.out.println("Int no of test hidden" + IntNoOfTestHidden);
			System.out.println("Total no of splits" + n);
			System.out.println("remainder of test " + p);

			for (int i = 0; i <= n; i++) {
				System.out.println("into for ");
				if (ExpectedNoOfTestHidden > 100) {
					if (IntNoOfTestHidden == 100) {
						System.out.println("into first if");
						getElement(getNoOfTestHiddenInCategory).click();
						wait.waitForPageToLoadCompletely();
						jsUtil.scrollDown(secondCategoryTuple);
						wait.waitForPageToLoadCompletely();
						ExpectedNoOfTestHidden = ExpectedNoOfTestHidden - 100;
						System.out.println("Expected tests after clicking " + ExpectedNoOfTestHidden);
						if (ExpectedNoOfTestHidden == 0) {
							return true;
						}
					}
				} else if (ExpectedNoOfTestHidden <= 100) {
					if (ExpectedNoOfTestHidden == p) {
						getElement(getNoOfTestHiddenInCategory).click();
						jsUtil.scrollDown(secondCategoryTuple);
						wait.waitForPageToLoadCompletely();
						System.out.println("into else if condition");
						return true;
					}
				} else

				{
					return false;
				}
			}

			return false;
		}
	}

	/**
	 * @author rounak.jain To verify that all tests are displayed totalTest : total
	 *         number of test
	 * @param it will return the status true / false if total number of test is equal to expected
	 */

	public boolean verifyAllTestsDisplayed(int totalTest) {
		int TotalTestsDisplayed = driver.findElements(listOfAllTests).size();
		if (totalTest == TotalTestsDisplayed) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author rounak.jain To enter the value in search bar 
	 *@param demo : enter the keyword  to search
	 *        
	 */

	public void enterInSearchBar(String demo) {
		getElement(searchbar).sendKeys(demo);
	}

	/**
	 * @author rounak.jain To verify the search results on page 
	 * @param demo : enter the keyword to search
	 */

	public boolean verifySearchResultsOfTest(String demo) {
		wait.waitForPageToLoadCompletely();
		int searchResultsSize = driver.findElements(searchResults).size();
		System.out.println(searchResultsSize);
		for (int i = 1; i <= searchResultsSize; i++) {
			if (getElement(By.xpath("(//div[@class='rowData']//label)[" + i + "]")).getAttribute("for")
					.contains(demo)) {
				System.out.println("searching working fine");
				return true;
			}
		}
		return false;

	}

	/**
	 * @author rounak.jain To get the title of page
	 */

	public String getTitleOfPage() {
		return getPageTitle();
	}

	/**
	 * @author rounak.jain To verify the data against a test on configure test page
	 * @param testName : name of the test
	 * 
	 */
	public boolean validateStaticDataOnConfigurePage(String testName) {
		String testNameOnConfigurationPage = getElement(gettestName).getText();
		String stageNameOnConfigurationPage = getElement(stageName).getText();
		String defaultNoOfDaysConfigurationPage = getElement(defaultNoOfDays).getAttribute("value");
		if (testNameOnConfigurationPage.contains(testName) && stageNameOnConfigurationPage.contains("Matching")
				&& defaultNoOfDaysConfigurationPage.contains("10")) {
			return true;
		} else
			return false;
	}

	/**
	 * @author rounak.jain To click on edit test button
	 */
	public void clickEditTest() {
		wait.waitForPageToLoadCompletely();
		getElement(editButton).click();
	}

	/**
	 * @author rounak.jain To verify the check boxes on configure test page
	 */

	public boolean verifyCheckboxesOnConfigurationPage() {
		int i = 4;
		wait.waitForPageToLoadCompletely();
		String sendTestAutoCheckbox = getElement(By.xpath("(//span[@class='heading1'])[" + i + "]")).getText();
		String monitorUsingWebCam = getElement(By.xpath("(//span[@class='heading1'])[" + (i + 1) + "]")).getText();
		String restrictMultipleTabs = getElement(By.xpath("(//span[@class='heading1'])[" + (i + 2) + "]")).getText();
		String ActualSendTestAutoCheckboxTxt = "Trigger test automatically when candidate is moved to this stage";
		String ActualMonitorUisngWebCam = "Monitor Candidate using Webcam";
		String ActualRestrictMultipleTabs = "Restrict Candidate from Switching Tabs";

		if (sendTestAutoCheckbox.contains(ActualSendTestAutoCheckboxTxt)
				&& monitorUsingWebCam.contains(ActualMonitorUisngWebCam)
				&& restrictMultipleTabs.contains(ActualRestrictMultipleTabs)) {
			return true;
		} else
			return false;
	}

	/**
	 * @author rounak.jain To verify stage if stage is editable
	 */

	public boolean verifyStageisNotEditable() {
		boolean flag = isDisplayed(changeTestConfigureTestSettings);
		return flag;
	}

	/**
	 * @author rounak.jain To select the check box of trigger test automatically
	 */

	public void clickSendTestAutomatically() {
		getElement(sendTestAutomaticallyChkBox).click();
	}

	/**
	 * @author rounak.jain To get the default count of test configure from configure
	 *         test page
	 */

	public String getDefaultCountOnConfigurationPage() {
		String defaultCountOfCandidates = getElement(getDefaultCountCandidates).getAttribute("value");
		return defaultCountOfCandidates;
	}

	/**
	 * To enter the invalid days
	 * 
	 * @param noOfdays : total no of days test will be valid
	 */

	public void enterInvalidActivationPeriodDays(String noOfdays) {
		getElement(noOfDaysConfigurationPage).sendKeys(noOfdays);
	}

	/**
	 * To enter the activation period in day and hours
	 * @param days  : days to activate
	 * @param hours : hrs to activate
	 */

	public void EnterActivationPeriodInDayAndHour(String days, String hours) {
		wait.hardWait(2);
		getElement(noOfDaysConfigurationPage).sendKeys(days);
		getElement(NoOfHoursConfigurationPage).sendKeys(hours);
	}

	/**
	 * @author rounak.jain To get error of activation periods
	 */

	public String getErrorActivationPeriod() {
		return getElement(errorActivationPeriod).getText();
	}

	/**
	 * @author rounak.jain To clear the fields of activation fields
	 */

	public void clearActivationPeriod() {
		wait.hardWait(2);
		getElement(noOfDaysConfigurationPage).clear();
		getElement(NoOfHoursConfigurationPage).clear();
		getElement(NoOfHoursConfigurationPage).clear();
		wait.hardWait(2);
	}

	/**
	 * @author rounak.jain To verify in case user is entering the more credits then
	 *         available
	 */

	public void enterCountMoreThanCreditsAvailable() {
		System.out.println("yayyyy");
		String StringtotalCreditsAvailable = getElement(totalCreditsOnConfigurationPage).getText();
		String[] IntegrTotalCredits = StringtotalCreditsAvailable.split("(?<=\\D)(?=\\d)");
		System.out.println(IntegrTotalCredits[0] + "value of credits ");
		int IntTotalCredits = Integer.parseInt(IntegrTotalCredits[0]);

		int IntMoreThanTotalCredits = IntTotalCredits + 1;
		System.out.println(IntMoreThanTotalCredits);
		getElement(getDefaultCountCandidates).clear();
		String StringMoreThanTotalCredits = Integer.toString(IntMoreThanTotalCredits);
		System.out.println(StringMoreThanTotalCredits);
		getElement(getDefaultCountCandidates).sendKeys(StringMoreThanTotalCredits);
		System.out.println("total creditssssss.....");
	}

	/**
	 * @author rounak.jain To verify error message of invalid credit
	 */

	public String errorMsgGreaterThanTotalCredits() {
		return getElement(errorMsgTotalCredits).getText();
	}

	/**
	 * @author rounak.jain To enter the field of no of candidate
	 */

	public void enterNoOfCandidates(int candidates) {
		getElement(getDefaultCountCandidates).clear();
		getElement(getDefaultCountCandidates).sendKeys("" + candidates);
	}

	/**
	 * @author rounak.jain To get the label of configuration page
	 * @return it will return the label from configure test page
	 */

	public String labelConfigurationPage() {
		return getElement(labelOfPage).getText();
	}

	/**
	 * @author rounak.jain To get the activation period value
	 */

	public String getActivationValue() {
		return getElement(noOfDaysConfigurationPage).getAttribute("value");
	}

	/**
	 * @author rounak.jain To click on back button
	 */

	public void clickOnBackBtn() {
		getElement(BackBtnConfigurationPage).click();
	}

	/**
	 * @author rounak.jain To click on confirmation button
	 */

	public void clickConfirmationBtn() {
		getElement(BackBtnCofirmationBox).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author rounak.jain To click on restirct multiple tabs
	 */

	public void clickRestrictMultipleTabs() {
		getElement(restrictMultipleTabCheckbox).click();
	}

}
