package com.naukri.pageobjects.Requirements;

import org.openqa.selenium.By;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.test.base.PageObjectWrapper;

public class JobDescriptionPagePO extends PageObjectWrapper {
	boolean flag = false;

	By eleEmployementType = By.xpath("//div[@class='other-details']//label[text()='Employment Type']");
	By eleEmplayementValue = By
			.xpath("//div[@class='other-details']//label[text()='Employment Type']/following-sibling::span/span");

	By eleVariableValue = By.xpath("//div[@class='salary']//span");
	By eleWalkinDetails = By.xpath("//div[@class='walkin']//span[contains(.,'${value}')]");
	By eleWalkinVenueDetails = By.xpath("//div[@class='venue']//span[contains(.,'${value}')]");
	By eleThumbnail = By.xpath("//div[@class='photo-video']//img[@alt='thumbnail']");
	By elePhotoThumbnail = By.xpath("(//div[@class='photo-video']//img[@alt='thumbnail'])[${value}]");
	By eleWalkinDetailsOnCS = By.xpath("//span[contains(text(),'11.30 AM onwards')]");
	By eleWalkinLocationDetailsOnCS = By.xpath("//p[contains(text(),'${location}')]");
	By eleSalaryVariableDetailsOnCS = By.xpath("//span[contains(text(),'Including Variable: ${value}%')]");
	
	/**
	 * This method verify Employment type is available on JD page
	 * 
	 * @return
	 */
	public boolean verifyEmploymentTypeOnJD() {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleEmployementType);
	}

	/**
	 * This method verify Employment type value is available on JD page
	 * 
	 * @return
	 */
	public boolean verifyEmploymentTypeValueOnJD(String value) {
		wait.waitForPageToLoadCompletely();
		return getText(eleEmplayementValue).trim().equals(value);
	}

	/**
	 * This method verify Employment type value is available on JD page
	 * 
	 * @return
	 */
	public boolean verifyVariableAmountOnJD(String min, String max, String variable) {
		wait.waitForPageToLoadCompletely();
		String expected= "₹ "+min+" - "+max+" P.A. (Including Variable: "+variable+"%)";
		return getText(eleVariableValue).equals(expected);
	}

	/**
	 * This method verify Employment type value is available on JD page
	 * 
	 * @return
	 *//*
		 * public boolean verifyrecruiterDetails(String expectedDetails) {
		 * wait.waitForPageToLoadCompletely();
		 * 
		 * return isDisplayed(parameterizedLocator(eleVariableValue, value)); }
		 */
	
	/**
	 * This method will verify the walkin details
	 * @param value
	 * @return
	 */
	public boolean verifyWalkinDetails(String value) {
		return isDisplayed(parameterizedLocator(eleWalkinDetails, value));
	}
	
	/**
	 * This method will verify the walkin venue details
	 * @param value
	 * @return
	 */
	public boolean verifyWalkinVenueDetails(String value) {
		return isDisplayed(parameterizedLocator(eleWalkinVenueDetails, value));
	}
	
	/**
	 * This method will verify the Thumbnail on Job description page
	 * @return
	 */
	public boolean verifyThumbnail() {
		scrollToElement(eleThumbnail);
		return isDisplayed(eleThumbnail);
	}
	
	/**
	 * This method will verify the photo Thumbnail on Job description page
	 * @return
	 */
	public boolean verifyPhotoThumbnail() {
		flag = true;
		for (int i = 1; i <= 3; i++) {
			scrollToElement(parameterizedLocator(elePhotoThumbnail, String.valueOf(i)));
			if (!isDisplayed(parameterizedLocator(elePhotoThumbnail, String.valueOf(i)))) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method will verify walkin details on CS page.
	 * @param location
	 * @return
	 */
	public boolean verifyWalkinDetailsOnCS(String location) {
		return isDisplayed(eleWalkinDetailsOnCS) && isDisplayed(parameterizedLocator(eleWalkinLocationDetailsOnCS, location));
	}
	
	/**
	 * This method will verify Salary Variable on CS page.
	 * @param location
	 * @return
	 */
	public boolean verifySalaryVariableOnCS(String variable) {
		return isDisplayed(parameterizedLocator(eleSalaryVariableDetailsOnCS, variable));
	}
}
