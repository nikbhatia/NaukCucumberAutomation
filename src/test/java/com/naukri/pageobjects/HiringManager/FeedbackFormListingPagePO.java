package com.naukri.pageobjects.HiringManager;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naukri.test.base.BaseAutomation;

public class FeedbackFormListingPagePO extends BaseAutomation{
	
	private By lnkLinkName = By.xpath("(//a[text()='${button}'])[1]"); 
	private By btnDefaultFeedbackForm = By.xpath("(//li[@class='list'])[2]//a[text()='${button}']");
	private By wetopFeedbackFormName = By.xpath("(//li[@class='list'])[2]//div[@class='displayName']");
	private By btnSortBy = By.xpath("//div[text()='${type}']");
	private By weOwnerAndShareStatus = By.xpath("(//div[@class='addDetails'])[1]//span");
	private By btnOnFeedbackFormListing = By.xpath("//button[text()='${button}']");
	private By btnActionButton = By.xpath("//a[@title='${formName}']//..//..//a[text()='${action}']");
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on the button with @param name for default feedback form
	 * @param linkName
	 */
	public void clickOnButtonOnDefaultFeedbackForm(String buttonName)
	{
		wait.waitForPageToLoadCompletely();
		getElement(btnDefaultFeedbackForm,buttonName).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on link on settings page
	 * @param text of link to click
	 */
	public void clickOnLinkOnSettingsPage(String linkName)
	{
		wait.waitForPageToLoadCompletely();
		getElement(lnkLinkName,linkName).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to get the name of the form which is on top of list of forms
	 * @return the name of form which is on top of list
	 */
	public String getTopFeedbackFormName()
	{
		return getText(wetopFeedbackFormName);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on sort button for given type i.e sort b name or last modified date
	 * @param sortBy
	 */
	public void clickOnSortByBtn(String sortBy)
	{
		getElement(btnSortBy,sortBy).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to return true if given link is displayed on Feedback Form Listing Page
	 * @return true if link is displayed
	 */
	public boolean isLinkDisplayed(String buttonType)
	{
		return isDisplayed(parameterizedLocator(btnDefaultFeedbackForm,buttonType));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is return text written below default feedback form
	 * @return "Owner "+ ownerName +" Shared with "+ share type 
	 */
	public String ownerNameAndShareWithUnderFeedbackForm()
	{
		List<WebElement> ownerAndShareStatus = getElements(weOwnerAndShareStatus);
		return "Owner "+ownerAndShareStatus.get(0).getText()+" Shared with "+ownerAndShareStatus.get(1).getText();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on the button on feedback form listing page
	 * @param buttonName
	 */
	public void clickOnButton(String buttonName)
	{
		jsUtil.scrollToElement(parameterizedLocator(btnOnFeedbackFormListing, buttonName));
		jsUtil.scrollMid(parameterizedLocator(btnOnFeedbackFormListing, buttonName));
		click(parameterizedLocator(btnOnFeedbackFormListing, buttonName));
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given action button for given form name
	 * @param actionType e.g Edit, Delete
	 * @param formName
	 */
	public void clickOnActionButton(String actionType,String formName)
	{
		wait.waitForElementToBeClickable(parameterizedLocator(btnActionButton, formName, actionType));
		click(parameterizedLocator(btnActionButton, formName, actionType));
		wait.waitForPageToLoadCompletely();
	}
	
	
}
