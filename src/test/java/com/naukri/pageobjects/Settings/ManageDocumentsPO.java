package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

public class ManageDocumentsPO extends BaseAutomation {

/*
 * @author:- Jatin.bisht
 */
	 
	private By txtAddNewDocument = By.id("addNewDocumentValue");
	private By btnAddSymbol = By.id("addNewDocument");
	private By txtVerifyAddedDocument = By.xpath("//span[text()='${documentName}']");
	private By chkSelectFirstDocument = By.xpath("(//ul[@class='ChkboxEnb']/li)[1]"); 
	private By chkSelectSecondDocument = By.xpath("(//ul[@class='ChkboxEnb']/li)[2]");
	private By ddselectDocuments = By.id("inp_docTypeDD");
	By eleHeadingTitleOfManageDocumentLightbox = By.xpath("//p[contains(text(),'${expectedTitle}')]");
	By eleSelectDocumentDD = By.id("inp_docTypeDD");
	By eleSelectDocumentName = By.xpath("//a[contains(text(),'${documentName}')]");
	
	public static String documentName = null;
	
	/**
	 * @author jatin.bisht
	 * this method generates random name for document and enter it
	 */
	public void inputDocumentNames(String documentName) {
		getElement(txtAddNewDocument).sendKeys(documentName);
	}
	
	/**
	 * @author jatin.bisht
	 * This method click on Add(+) symbol on manage documents page 
	 */
	public void clickOnAddDocumentSymbol() {
		getElement(btnAddSymbol).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author jatin.bisht
	 * This method verified the new added document is visible or not
	 * @param documentName
	 */
	public boolean verifyNewAddedDocument(String documentName) {
		return isDisplayed(parameterizedLocator(txtVerifyAddedDocument,documentName));
	}

	/**
	 * @author jatin.bisht
	 * this methods open DD where already created documents are visible and select the already created documents
	 */
	public void selectAvailableDocuments() {
		getElement(ddselectDocuments).click();
		getElement(chkSelectFirstDocument).click();
		getElement(chkSelectSecondDocument).click();
	}
	
	/**
	 * @author jatin.bisht
	 * This method verifies the selected documents from DD are visible or not
	 */
	public boolean verifySelectedDocumentsAreVisible() {
		String firstDoc = getElement(chkSelectFirstDocument).getText();
		String secondDoc = getElement(chkSelectSecondDocument).getText();
		if (isDisplayed(parameterizedLocator(txtVerifyAddedDocument, firstDoc))&&isDisplayed(parameterizedLocator(txtVerifyAddedDocument, secondDoc))) {
		return true	;
		}else {
			return false;
		}
	}
	
	/**
	 * To verify the presence of title
	 * @param expectedTitle
	 * @return boolean
	 */
	public boolean checkThePresenceOfTitle(String expectedTitle) {
		return isDisplayed(parameterizedLocator(eleHeadingTitleOfManageDocumentLightbox, expectedTitle));
	}
	
	/**
	 * To click on select document
	 */
	public void clickOnSelectDoc() {
		click(eleSelectDocumentDD);
		TestNGLogUtility.info("Select Document DD clicked");
	}
	
	public void selectDocument(String documentName) {
		this.documentName=documentName;
		click(parameterizedLocator(eleSelectDocumentName, documentName));
		TestNGLogUtility.info("document name selected " +documentName);
	}
}
