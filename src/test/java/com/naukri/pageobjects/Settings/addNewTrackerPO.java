package com.naukri.pageobjects.Settings;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;

/**
 * @author raunak.b
 *
 */
public class addNewTrackerPO extends BaseAutomation {

	private ArrayList<String> ExpectedShareWithOptions = new ArrayList<>(Arrays.asList("None", "Everyone in Group"));
	private By btnAddNewTracker = By.cssSelector("input.blockBtn");
	private By txtTrackerName = By.cssSelector("input.txtInput");
	private By btnsaveTracker = By.xpath("//button[text()='Save']");
	private By btndeleteListingPage = By.xpath("//button[@class='borderBtn']/em");
	private By eleTrackersHeading = By.xpath("//span[@class=' strong']");
	private By chkShowMyTrackers = By.xpath("//div[@class='ml50']//label");
	private By eleLastModifiedHeading = By.xpath("//span[@class='modifiedOn  strong']");
	private By ddlemployer = By.xpath("//input[@id='employer']");
	private By ddlFirstEmployer = By.xpath("(//ul[@class='dropdown ']//li)[1]");
	private By eleTotalNoOfEmployers = By.xpath("(//em[@id='totalRecord'])[1]");
	private By eleHeadingAddNewTracker = By.xpath("//span[@class='lbHead-title ']");
	// private By ddlEmployerList = By.xpath("//ul[@class='dropdown ']");
	private By ddlShareWith = By.xpath("//input[@id='shareWith']");
	// private By ddlShareWithDDOptions =
	// By.xpath("//div[@class='dropDownPrimaryContainer dropdownShow']//li");
	// private By ddlNoneShareWith = By.xpath("//li[text()='None']");
	private By eleValidationMsg = By.xpath("(//div[@class='errLbl'])[3]");
	private By eleEditLabels = By.xpath("//a[text()='Edit Labels']");
	private By eleCountOptionsOnDD = By.xpath("//ul[@class='dropdown ']//li");
	private By eleSelectColumns = By.xpath("//label[text()='${string}']");
	private By eleShareWithOptions = By.xpath("//li[text()='${string}']");
	private By eleCustomLabels = By.xpath("//div[@title='${string}']/following-sibling::div/input");
	private By eleErrorCustomLabels = By
			.xpath("//div[text()='${string}']/ancestor::div[@class='row']//div[@class='errLbl']");
	private By btnSaveCustomLabels = By.xpath("(//button[text()='Save'])[2]");
	private By eleCustomLabelsHeadings = By.xpath("//div[@class='tableHeader']/div[text()='${string}']");
	private By eleCustomlabelsEdited = By.xpath("//ul[@class='listContainer']//label[text()='${string}']");
	private By tbSearchApplicationDetails = By.xpath("//input[@placeholder='Search Application Details']");
	private By eleFieldvalue = By.xpath("//div[@class='select-list-container']//ul//label[text()='${value}']");

	/**
	 * get total no of employees
	 * 
	 * @author raunak.b
	 * @return no of employers in system
	 */
	public String getTotalNoOfEmployers() {
		return getElement(eleTotalNoOfEmployers).getText();
	}

	/**
	 * @author raunak.b click on add tracker button
	 */
	public void clickAddTracker() {
		getElement(btnAddNewTracker).click();
	}

	/**
	 * @author raunak.b fill tracker name
	 * 
	 * @return tracker name
	 */
	public String fillTrackerName() {
		String randomTrackerName = CommonAction.generateRandomStrings(5, "String");
		sendKeys(txtTrackerName, randomTrackerName);
		return randomTrackerName;
	}

	/**
	 * @author raunak.b check selective fields
	 * 
	 * @param Name
	 * @param EmailId
	 * @param JobTitle
	 */
	public void checkselectiveFields(String Name, String EmailId, String JobTitle) {
		getElement(parameterizedLocator(eleSelectColumns, Name)).click();
		getElement(parameterizedLocator(eleSelectColumns, EmailId)).click();
		getElement(parameterizedLocator(eleSelectColumns, JobTitle)).click();
	}

	/**
	 * @author raunak.b click save tracker button
	 * 
	 */
	public void clickSaveBtn() {
		getElement(btnsaveTracker).click();
	}

	/**
	 * @author raunak.b verify add new tracker displayed
	 * 
	 * @param addNewTrackerText
	 * @return true if add a new tracker is displayed on listing page
	 */
	public boolean verifyAddANewTrackerDisplayed(String addNewTrackerText) {
		return getElement(btnAddNewTracker).getAttribute("value").contains(addNewTrackerText);
	}

	/**
	 * @author raunak.b verify delete button is displayed on tracker listing page
	 * 
	 * @param deletetxt
	 * @return true if delete button is displayed on tracker listing page
	 */
	public boolean verifyDeleteBtnDisplayed(String deletetxt) {
		return getElement(btndeleteListingPage).getText().contains(deletetxt);
	}

	/**
	 * @author raunak.b verify headings on tracker listing page
	 * 
	 * @param trackers
	 * @param showMyTrackers
	 * @param LastModified
	 * @return true if headers on tracker listing page are correct
	 */
	public boolean verifyHeadingsOnTrackerListingPage(String trackers, String showMyTrackers, String LastModified) {
		if (getElement(eleTrackersHeading).getText().contains(trackers)
				&& getElement(chkShowMyTrackers).getText().contains(showMyTrackers)
				&& getElement(eleLastModifiedHeading).getText().contains(LastModified)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @author raunak.b enter employer name
	 * 
	 * @return employer name
	 */
	public String enterEmployerName() {
		getElement(ddlemployer).click();
		wait.hardWait(2);
		String employerName = getElement(ddlFirstEmployer).getText();
		getElement(ddlFirstEmployer).click();
		return employerName;
	}

	/**
	 * @author raunak.b get heading of lightbox tracker
	 * 
	 * @return heading of tracker lightbox
	 */
	public String headingNewTracker() {
		return getElement(eleHeadingAddNewTracker).getText();
	}

	/**
	 * @author raunak.b click assign employer DD
	 * 
	 * @return true if assign employer DD is clickable
	 */
	public boolean clickAssignEmployerDD() {
		try {
			getElement(ddlemployer).click();
		} catch (Exception e) {
			if (e.getMessage().contains("clickable at point")) {
				// wait.hardWait(2);
				wait.waitForPageToLoadCompletely();
				return false;
			} else {
				// wait.hardWait(2);
				throw e;
			}
		}
		return true;
	}

	/**
	 * @author raunak.b count of employers visible on tracker lightbox
	 * @return count of employers visible on DD
	 */
	public String countOfEmployersVisible() {
		List<WebElement> optionCount = getElements(eleCountOptionsOnDD);
		int size = optionCount.size() - 1;
		String employerSize = Integer.toString(size);
		return employerSize;
	}

	/**
	 * @author raunak.b select employer name on tracker lightbox
	 * 
	 */
	public void selectEmployerName() {
		String employerName = getText(ddlFirstEmployer);
		getElement(ddlFirstEmployer).click();
		PropFileHandler.writeProperty("setEmployerName", employerName);
	}

	/**
	 * @author raunak.b verufy employer dd is disabled
	 * 
	 * @return true if employer DD is disabled
	 */
	public boolean verifyEmployerDDIsDisabled() {
		return clickAssignEmployerDD();
	}

	/**
	 * @author raunak.b click on share with on lightbox
	 * 
	 */
	public void clickOnShareWith() {
		getElement(ddlShareWith).click();
	}

	/**
	 * @author raunak.b verify DD share with options visible
	 * 
	 * @return true if share with DD options visible
	 */
	public boolean verifyEveryoneOnGroupAndNoOneVisible() {
		List<WebElement> optionShareWith = getElements(eleCountOptionsOnDD);
		List<String> list = new ArrayList<>();
		for (WebElement w : optionShareWith) {
			list.add(getText(w));
		}
		if (ExpectedShareWithOptions.equals(list)) {

			return true;
		} else
			return false;
	}

	/**
	 * @author raunak.b click on none
	 * 
	 * @param none
	 */
	public void clickOnNone(String none) {
		getElement(parameterizedLocator(eleShareWithOptions, none)).click();
	}

	/**
	 * @author raunak.b choose share with option
	 * 
	 * @param everyoneInGroup
	 */
	public void chooseShareWith(String everyoneInGroup) {
		getElement(parameterizedLocator(eleShareWithOptions, everyoneInGroup)).click();
	}

	/**
	 * @author raunak.b exceed word limit in first row
	 */
	public void ExceedWordLimitInFirstRow() {
		String ExceededWordLimitString = CommonAction.generateRandomStrings(52, "String");
		getElement(parameterizedLocator(eleCustomLabels, "Name")).click();
		getElement(parameterizedLocator(eleCustomLabels, "Name")).sendKeys(ExceededWordLimitString);
		wait.hardWait(2);
	}

	/**
	 * @author raunak.b verify word limit error
	 * @return true if word limit error displayed
	 */
	public boolean verifyWordLimitError() {
		return getElement(parameterizedLocator(eleErrorCustomLabels, "Name")).getText()
				.contains("Error: Max length allowed is 50 char");
	}

	/**
	 * @author raunak.b enter special chars
	 * @param specialChars
	 */
	public void enterSpecialChars(String specialChars) {
		getElement(parameterizedLocator(eleCustomLabels, "Email ID")).sendKeys(specialChars);
	}

	/**
	 * @author raunak.b verify validation message special chars
	 * @return true if validation message of special chars displayed
	 */
	public boolean verifyValidationMsgSpecialChars() {
		return getElement(eleValidationMsg).getText().contains("Error: Special Characters not allowed");
	}

	/**
	 * @author raunak.b verify edit coloumn name labels
	 * @return true if edit coloumn name labels displayed
	 */
	public boolean verifyEditColoumnNameLabels() {
		int i = 1;

		if (getElement(parameterizedLocator(eleCustomLabelsHeadings, "Default Labels")).isDisplayed()
				&& getElement(parameterizedLocator(eleCustomLabelsHeadings, "Custom Labels")).isDisplayed()
				&& getElement(parameterizedLocator(eleCustomLabelsHeadings, "Values")).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @author raunak.b click on edit labels
	 */
	public void clickOnEditLabels() {
		getElement(eleEditLabels).click();
	}

	/**
	 * @author raunak.b change labels of fields in tracker
	 * 
	 * @param label1
	 * @param label2
	 */
	public void changelabelsOfFields(String label1, String label2) {
		getElement(parameterizedLocator(eleCustomLabels, label1)).clear();
		getElement(parameterizedLocator(eleCustomLabels, label1)).sendKeys("Name1");
		wait.hardWait(3);
		getElement(parameterizedLocator(eleCustomLabels, label2)).clear();
		getElement(parameterizedLocator(eleCustomLabels, label2)).sendKeys("Email2");

	}

	/**
	 * @author raunak.b click save edit labels
	 * 
	 */
	public void clickSaveEditLabels() {
		getElement(btnSaveCustomLabels).click();
	}

	/**
	 * @author raunak.b verify labels are edited
	 * 
	 * @return true if labels edited are correct
	 */
	public boolean verifyLabelsAreEdited() {
		wait.hardWait(4);
		return getElement(parameterizedLocator(eleCustomlabelsEdited, "Name1")).isDisplayed()
				&& getElement(parameterizedLocator(eleCustomlabelsEdited, "Email2")).isDisplayed();

	}
	
	/**
	 * This method will enter field name in Search Application Details field
	 * @author himanshu.dua
	 */
	public void enterValueOnSearchApplicationDeatils(String fieldName) {
		click(tbSearchApplicationDetails);
		sendKeys(tbSearchApplicationDetails, fieldName);
	}
	
	/**
	 * This method will verify the field in Tracker List
	 * @author himanshu.dua
	 * @param field
	 * @return
	 */
	public boolean verifyfieldInTrackerList(String field) {
		return isDisplayed(parameterizedLocator(eleFieldvalue, field));
	}
}
