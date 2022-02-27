package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.BaseAutomation;

/**
 * @author raunak.b
 *
 */
public class manageTrackerListingPagePO extends BaseAutomation {
	private By eleSearchByName = By.xpath("//input[@placeholder='Search by Name']");
	private By eleSearchIcon = By.xpath("//input[@id='searchIcon']");
	private By eleSearchedTracker = By.xpath("//div[@class='blueTxt']");
	private By eleUncategorisedTrackerLabel = By.xpath("//span[@class='caption_strong_med ']");
	private By eleShareWithListingPage = By.xpath("(//div[@class='mt5']//span)[2]");
	private By eleNoResultsFoundOnListingPageMessage = By.xpath("//div[@class='listItem noResult']//span");
	private By eleDeleteConfirmation = By.xpath("//button[@class='confBtn yes']");
	private By eleAssignEmployerLabel = By.xpath("//div[@class='ml66 ']//label");
	private By eleEditTracker = By.xpath("//a[text()='Edit']");
	private By txtEmployerName = By.xpath("(//div[@class='dropdownMainContainer']//input)[1]");
	private By eleEditColoumnName = By.xpath("//a[@class='ml20']");
	private By eleEditLabels = By.xpath("//a[text()='Edit Labels']");
	private By eleTrackerListingPage = By.xpath("(//a[text()='${string}'])[1]");

	/**
	 * @author raunak.b enter quick search on manage tracker listing page
	 * 
	 */
	public void enterQuickSearch() {
		String tracker = PropFileHandler.readProperty("setTrackerName");
		getElement(eleSearchByName).sendKeys(tracker);
		wait.waitForPageToLoadCompletely();
		getElement(eleSearchIcon).click();
	}

	/**
	 * @author raunak.b verify tracker is displayed on listing page
	 * 
	 * @return true if tracker is displayed on listing page
	 */
	public boolean verifyTrackerIsDisplayed() {
		wait.hardWait(5);
		String ActualTrackerName = getElement(eleSearchedTracker).getText();
		String ExpectedTrackerName = PropFileHandler.readProperty("setTrackerName");
		return ActualTrackerName.contains(ExpectedTrackerName);

	}

	/**
	 * @author raunak.b verify category label is visible on listing page
	 * 
	 * @param categoryLabel
	 * @return true if category label is visible on listing page
	 */
	public boolean verifycategoryLabelVisible(String categoryLabel) {
		wait.hardWait(5);
		String ActualLabel = getText(eleUncategorisedTrackerLabel);
		return ActualLabel.contains(categoryLabel);

	}

	/**
	 * @author raunak.b verify share edit delete displayed on listing page
	 * 
	 * @param Share
	 * @param Edit
	 * @param Delete
	 * @return true if all options are displayed
	 */
	public boolean verifyShareEditDeleteDisplayed(String Share, String Edit, String Delete) {
		if (getElement(parameterizedLocator(eleTrackerListingPage, Share)).isDisplayed()
				&& getElement(parameterizedLocator(eleTrackerListingPage, Edit)).isDisplayed()
				&& getElement(parameterizedLocator(eleTrackerListingPage, Delete)).isDisplayed()) {
			return true;
		} else
			return false;
	}

	/**
	 * @author raunak.b click on option edit , delete or share on listing page
	 * 
	 * @param btnName
	 */
	public void clickOnButton(String btnName) {
		wait.waitForPageToLoadCompletely();
		getElement(parameterizedLocator(eleTrackerListingPage, btnName)).click();
		if (btnName.contains("Delete")) {
			getElement(eleDeleteConfirmation).click();
			wait.waitForPageToLoadCompletely();
		}
	}

	/**
	 * @author raunak.b check visibilty of share edit and delete buttons
	 * 
	 * @param share
	 * @param edit
	 * @param delete
	 * @return true if share , delete , edit visible on listing page
	 */
	public boolean checkVisibiltyOfShareEditDeleteBtns(String share, String edit, String delete) {
		wait.hardWait(5);
		return getElement(parameterizedLocator(eleTrackerListingPage, share)).isDisplayed()
				&& getElement(parameterizedLocator(eleTrackerListingPage, edit)).isDisplayed()
				&& getElement(parameterizedLocator(eleTrackerListingPage, delete)).isDisplayed();

	}

	/**
	 * @author raunak.b verify shared with everyone
	 * 
	 * @return true if shared with everyone is displayed
	 */
	public boolean verifySharedWithEveryone() {
		wait.waitForPageToLoadCompletely();
		return getElement(eleShareWithListingPage).getText().contains("Everyone");
	}

	/**
	 * @author raunak.b verify no results visible on listing page
	 * 
	 * @return true if no results visible
	 */
	public String verifyNoResultsVisible() {
		return getElement(eleNoResultsFoundOnListingPageMessage).getText();
	}

	/**
	 * @author raunak.b verify label employer name
	 * 
	 * @return true if label employer name is displayed
	 */
	public String verifyLabelEmployerName() {
		return getElement(eleAssignEmployerLabel).getText();
	}

	/**
	 * @author raunak.b verify tracker does not exists
	 * 
	 * @return true if no results found is displayed
	 */
	public boolean verifyTrackerDOesNotExists() {
		return getElement(eleNoResultsFoundOnListingPageMessage).getText().equals("No Results found");

	}

	/**
	 * @author raunak.b verufy edit labels is visible
	 * 
	 * @return true if edit labels is visible
	 */
	public boolean verifyEditLabelsVisible() {
		return elementVisibility(eleEditLabels);
	}

	/**
	 * @author raunak.b click edit tracker
	 * 
	 */
	public void clickEditTracker() {
		getElement(eleEditTracker).click();
		wait.hardWait(4);
	}

	/**
	 * @author raunak.b get employer name
	 * 
	 * @return string employer name
	 */
	public String getEmployerName() {
		return getElement(txtEmployerName).getAttribute("title");
	}

	/**
	 * @author raunak.b edit colomn name label visible
	 * 
	 * @return true if coloumn name label is visible
	 */
	public boolean editColoumnnameLabelVisible() {
		return getElement(eleEditColoumnName).getText().contains("Edit Tracker Column Name");
	}

	/**
	 * @author raunak.b click on edit coloumn name
	 */
	public void clickOnEditColoumnname() {
		getElement(eleEditColoumnName).click();
	}

}
