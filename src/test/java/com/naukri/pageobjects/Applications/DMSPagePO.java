package com.naukri.pageobjects.Applications;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Document Management System Page Object Class
 * @author rachit.mehrotra
 *
 */
public class DMSPagePO extends PageObjectWrapper {
	
	By eleTagForDocument = By.xpath("//span[contains(text(),'${documentType}')]");
	By eleLegalAcceptanceChck = By.xpath("//label[contains(@for,\"legalAcceptance\")]");
	By eleActionBtn = By.xpath("//button[contains(text(),'${actionBtnText}')]");
	By eleErrorMessage = By.xpath("//div[contains(text(),'${errorMessage}')]");
	By eleRequestDocument = By.xpath("//span[contains(text(),\"Request Documents\")]");
	By eleRequestDocumentNameHolder = By.xpath("//label[contains(text(),'${documentName}')]");
	By elePreviewMailHeadingHolder = By.xpath("//p[contains(text(),'${headingText}')]");
	By elePreviewMailBody = By.id("mailBodyData");
	By eleSendActionButton = By.xpath("//input[@value=\"SEND MAIL\"]");
	By eleCloseActionButton = By.xpath("//a[text()=\"CLOSE\"]");
	By eleIncludeSigntaure = By.id("includeSign");
	By eleIncludeSignatureLabel = By.xpath("//label[text()=\"Include signature\"]");

	/**
	 * Verify the presence of tag of document
	 * @param documentName
	 * @return boolean
	 */
	public boolean verifyThePresenceOfDocumentTag(String documentName) {
		return isDisplayed(parameterizedLocator(eleTagForDocument, documentName));
	}
	
	/**
	 * To check the legal acceptance message
	 */
	public void clickOnLegalAcceptance(){
		jsUtil.scrollDown(eleLegalAcceptanceChck);
		click(eleLegalAcceptanceChck);
	}
	
	/**
	 * To click on action button
	 * @param btnText
	 */
	public void clickOnActionBtn(String btnText) {
		click(parameterizedLocator(eleActionBtn, btnText));
	}
	
	/**
	 * To verify the error message for legal acceptance
	 * @param errorMessage
	 * @return boolean
	 */
	public boolean verifyThePresenceOfErrorMessageForLegalAbsence(String errorMessage) {
		return isDisplayed(parameterizedLocator(eleErrorMessage, errorMessage));
	}
	
	/**
	 * To verify the legal description text
	 * @param actualText
	 * @return boolean
	 */
	public boolean verifyTheTextOfLegalDesc(String actualText) {
		return getText(eleLegalAcceptanceChck).equals(actualText);
	}
	
	/**
	 * Click on request document
	 */
	public void clickOnRequestDocument() {
		click(eleRequestDocument);
		TestNGLogUtility.info("Request document clicked on mail page");
	}
	
	/**
	 * To click on document name of the list
	 * @param documentNameForSelection
	 */
	public void clickOnDocumentName(String documentNameForSelection) {
		click(parameterizedLocator(eleRequestDocumentNameHolder, documentNameForSelection));
		TestNGLogUtility.info("Document with name " + documentNameForSelection + " is clicked");
	}
	
	/**
	 * To verify the presence of preview heading
	 * @param expectedPreviewText
	 * @return boolean
	 */
	public boolean verifyTheHeadingOfPreview(String expectedPreviewText) {
		return isDisplayed(parameterizedLocator(elePreviewMailHeadingHolder, expectedPreviewText));
	}
	
	/**
	 * To verify the presence of signature in preview
	 * @return boolean
	 */
	public boolean verifyThePresenceOfSignature() {
		return getText(elePreviewMailBody).contains(SettingsDashboardPO.signatureText);
	}
	
	/**
	 * To click on action button of preview
	 * @param buttonText
	 */
	public void clickOnActionBtnForDMSPreview(String buttonText) {
		By by = buttonText.contains("SEND MAIL") ? eleSendActionButton : eleCloseActionButton;
		jsUtil.scrollDown(by);
		scrollToElement(by);
		click(by);
	}
	
	/**
	 * To click on include signature
	 */
	public void clickOnIncludeSignatureCheckbox() {
		jsUtil.scrollDown(eleIncludeSigntaure);
		if(!Boolean.parseBoolean(getAttribute(eleIncludeSigntaure, "value"))) 
			click(eleIncludeSignatureLabel);
	}
	
}
