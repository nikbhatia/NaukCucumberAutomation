package com.naukri.pageobjects.Settings;

import com.naukri.automation.util.TestNGLogUtility;
import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SettingsDashboardPO extends BaseAutomation {

    private By settingsNameAsSubHead = By.xpath("(//div[contains(@class,'subHead p10 bgF6')])");
    private By settingsName = By.xpath("//div[@class='row']/div[@class='bold']/a");
    private By whiteLabelSettings = By.xpath("//a[contains(text(),'Manage White labelling Settings')]");
    By eleManageEmailTemplate = By.xpath("//a[text()='Manage Email Templates']");
    By eleManageEmployer = By.xpath("//a[contains(text(),'Manage Employer ')]");
    By eleInvoiceSettings = By.xpath("invoicesetting");
    By eleCustomizeSelectionStage = By.xpath("//a[contains(text(),\"Customize the Selection Process\")]");
    By eleCancelLinkForEditSignature = By.xpath("//div[contains(@id,\"ltBoxForSignature\")]//a[contains(text(),\"Cancel\")]");
    By settingsNameUnderText = By.xpath("//div[@class='row']//p");
    
    public static String signatureText = "";
    
    public void clickOnSettingsPageLink(String linkName) {
        getElement(By.xpath("//a[contains(text(),'" + linkName + "')]")).click();
    }
    
    /**
     * This method get all the sub headings from setting page and compare it with names which are provided in feature file
     * @author Lokesh.agrawal
     */
	public List<String> getNameOfAllSettingsAsSubHead() {
		List<String> allSettingsSubHeadName = new ArrayList<String>();
		for (WebElement we : getElements(settingsNameAsSubHead)) {
			allSettingsSubHeadName.add(we.getText());
		}
		TestNGLogUtility.info("List of all Settings Name in Sub Head created");
		return allSettingsSubHeadName;
	}
	
	/**
	 * This method will return all names of headings visible on setting page and compare it with names which are provided in feature file
	 * @author jatin.bisht
	 */
	public List<String> getNameOfAllSettings(){
		List<String> allSettingsName = new ArrayList<String>();
		for(WebElement web : getElements(settingsName)) {
			allSettingsName.add(web.getText());
		}
		TestNGLogUtility.info("List of all Settings Names in  created");
		return allSettingsName;
	}
	
	/**
	 * To click on white label settings options
	 * @author rachit.mehrotra
	 */
	public void clickOnWhiteLabelSettings() {
		click(whiteLabelSettings);
	}
	
	public void clickOnManageEmailTemplate() {
		click(eleManageEmailTemplate);
	}
	
	public void clickOnManageEmployer() {
		click(eleManageEmployer);
	}
	
	public void clickOnInvoiceSettings() {
		click(eleInvoiceSettings);
	}
	
	public void clickOnSelectionStage() {
		click(eleCustomizeSelectionStage);
	}
	
	/**
	 * For the lightbox of the edit signature
	 * @author rachit.mehrotra
	 *
	 */
	public class EditSingnaturePO extends PageObjectWrapper {
		
		By elePopUpHeadingHolder = By.xpath("//h2[contains(text(),'${headingText}')]");
		By eleSignatureFrame = By.id("sigBodyEditor");
		By eleSignatureFrameBody = By.tagName("body");
		
		/**
		 * To verify the presence of heading text
		 * @param expectedHeadingString
		 * @return
		 */
		public boolean verifyThePresenceOfSignatureLightbox(String expectedHeadingString) {
			return isDisplayed(parameterizedLocator(elePopUpHeadingHolder, expectedHeadingString));
		}
		
		/** 
		 * To get the signature of the recruiter
		 */
		public void getRecruiterSignature() {
			switchToFrame(eleSignatureFrame);
			signatureText = getElement(eleSignatureFrameBody).getText();
			switchToDefaultContent();
			TestNGLogUtility.info("recruiter signature " + signatureText);
			click(eleCancelLinkForEditSignature);
			TestNGLogUtility.info("Cancel for edit signature lightbox clicked");
		}
	}
}
