package com.naukri.pageobjects.VendorPlatform;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

import io.cucumber.datatable.DataTable;

import com.naukri.automation.util.PropFileHandler;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.naukri.automation.util.*;

/**
 * 
 * @author ambar.gupta
 *
 */

public class AssessmentPartnerIntegrationPO extends BaseAutomation {

	private final By lblHeading = By.xpath("//span[@class=\"pageTitle pb5\"]");
	private final By lblSubHeading = By.xpath("//span[@class=\"pageSubtitle\"]");
	private final By lblHackerEarth = By.xpath("//div[@class='title' and text()='HackerEarth']");
	private final By lblNaukriAssessment = By.xpath("//div[@class='title' and text()='Naukri Assessment']");
	private final By eleAllPartnerslbl = By.xpath("//div[@class='title']");
	private final By btnPartnerConfiguration = By.xpath("//button[text()='${buttonName}']");
	private final By eleLearnMorelink = By.xpath("//div[text()='${PartnerName}']/following::a[text()='Learn more'][1]");
	private final By eleThreeSimpleStepsLink = By.xpath("//div[text()='${PartnerName}']/following::a[text()='3 simple steps'][1]");
	private final By lblHEConfigWindow = By.xpath("//div[text()='Configure HackerEarth']");
	private final By lblHEClientID = By.xpath("//div[text()='Client ID']");
	private final By lblHEClientSecret = By.xpath("//div[text()='Client Secret']");
	private final By lblConfigureLightbox = By.xpath("//div[@class='ques']");
	private final By eleHEClientIDPlaceholder = By.xpath("//input[@placeholder='Enter Client ID from HackerEarth']");
	private final By eleHE_ClientSecretPlaceholder = By.xpath("//input[@placeholder='Enter Client Secret from HackerEarth']");
	private final By txtboxHEClientID = By.name("client_id");
	private final By txtboxHE_ClientSecret = By.name("client_secret");
	private final By txtboxCod_api_key = By.name("api_key");
	private final By eleHEmodalBodyContent = By.xpath("//div[@class ='modalBodyContent']/div[1]");
	private final By btnHEConfigure = By.id("configure-he");
	private final By btnHECancel = By.id("cancel-config-he");
	private final By eleHELearnHowToConfigure = By.xpath("//a[text()='Learn how to configure']");
	private final By btnHEconfigPagecloseX = By.xpath("//a[@class='modalCloseLink']");
	private final By eleRequestDemo = By.xpath("//a[text()='Request a demo'][1]");
	private final By elePartnerNames = By.xpath("//div[@class=\"title\"]");
	private final By lblPartnerConfigured = By.xpath("//div[text()='${PartnerName}']/parent::div//span[text()='Configured']");
	private final By successErrorMessageHE = By.xpath("//div[@class='msg']");
	private final By lblConfigured = By.xpath("//span[text()='Configured']");
	private final By txtSubHeadingPartners = By.xpath("//div[@class='title'][text()='${partnerName}']/following-sibling::div[@class='subText']");
	private final By txtDescriptionPartners = By.xpath("//div[@class='title'][text()='${partnerName}']/following-sibling::div[@class='desc']");
	private final By linkPartnerDescription = By.xpath("//div[@class='title'][text()='${partnerName}']/following-sibling::div[@class='desc']/a[text()='${linkName}']");
	//Settings Page Elements
	private final By eleManageIntegrationSettings = By.xpath("//*[text()='Manage Integration']");
	private final By eleAssessmentPartnerIntegrationSettings = By.xpath("//a[text()='Assessment Partner Integration']");

	/**
	 * @author ambar.gupta To find number of partners added
	 * @return No of partner added
	 */

	public int getNumberOfPartnersAdded() {
		wait.waitForPageToLoadCompletely();
		List<WebElement> partners = new ArrayList<WebElement>();
		partners = getElements(eleAllPartnerslbl);
		return partners.size();

	}

	/**
	 * @author ambar.gupta To find number of partners added
	 * @return No of partner configured
	 */

	public int getNumberOfConfiguredPartners() {
		wait.waitForPageToLoadCompletely();
		List<WebElement> configuredPartners = new ArrayList<WebElement>();
		configuredPartners = getElements(lblConfigured);
		return configuredPartners.size();

	}

	
	/**
	 * To verify Assessment Partner Integration page label
	 * 
	 * @return True/false
	 */

	public boolean verifyAssessmentPartnerIntegrationPageHeader() {
		wait.waitForPageToLoadCompletely();
		String Heading = PropFileHandler.readProperty("HeaderAssessmentPartnerListing");
		String SubHeading = PropFileHandler.readProperty("SubHeaderAssessmentPartnerListing");
		return (getElement(lblHeading).getText().equals(Heading) && getElement(lblSubHeading).getText().equals(SubHeading));
	}

	/**
	 * To click on button to configure partners For Example, buttonName can be
	 * 'Configure Naukri Assessment', 'Configure HackerEarth' etc.
	 * @param buttonName : name of the button
	 */

	public void clickOnConfigurePartnerButton(String buttonName) {
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnPartnerConfiguration, buttonName));
		wait.waitForPageToLoadCompletely();
		switchToActiveElement();
	}
	
	/**
	 * @author ambar.gupta
	 * To configure the given partner
	 * 'Configure Naukri Assessment', 'Configure HackerEarth' etc.
	 * @param partnerName , list containing configuration fields for the partner
	 */

	public void ConfigurePartner(String partnerName, DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		switch (partnerName) {
		case "HackerEarth":
			configureHE(list.get(0).get("client_id"), list.get(0).get("client_secret"));
			break;
		case "Codility":
			configureCodility(list.get(0).get("Api key"));
			break;
		default:
			TestNGLogUtility.info("Please enter correct partner to configure");
			break;
		}		
	}

	/**
	 * To click on '3 steps link' for particular partner
	 * 
	 * @param PartnerName : name of the partner whose '3 steps link' is to be clicked
	 *                    
	 */

	public void clickOnThreeSimpleStepstlink(String PartnerName) {
		wait.waitForPageToLoadCompletely();
		getElement(eleThreeSimpleStepsLink, PartnerName).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To click on 'Learn more' for particular partner
	 * 
	 * @param PartnerName : name of the partner whose 'Learn more' is to be clicked
	 */

	public void clickOnLearnMoreLink(String PartnerName) {
		wait.waitForPageToLoadCompletely();
		getElement(eleLearnMorelink, PartnerName).click();
		switchToChildWindow();
		
	}

	/**
	 * To verify required elements are present on configure HE window
	 * 
	 * @return True/false
	 * @param element : name of the element whose presence is to be verified
	 */

	public boolean verifyElementsOnConfigureHEWindow(String element) {
		switch (element) {
		case "HE_ConfigWindowLabel":
			return isDisplayed(lblHEConfigWindow);
		case "HE_ClientID_label":
			return isDisplayed(lblHEClientID);
		case "HE_ClientSecretLabel":
			return isDisplayed(lblHEClientSecret);
		case "HE_ClientID_textbox":
			return isDisplayed(txtboxHEClientID);
		case "HE_ClientSecret_textbox":
			return isDisplayed(txtboxHE_ClientSecret);
		case "HE_modalBodyContent":
			return isDisplayed(eleHEmodalBodyContent);
		case "HE_Configure_button":
			return isDisplayed(btnHEConfigure);
		case "HE_Cancel_button":
			return isDisplayed(btnHECancel);
		case "HE_LearnHowToConfigure_link":
			return isDisplayed(eleHELearnHowToConfigure);
		case "HEClientIDPlaceholder":
			return isDisplayed(eleHEClientIDPlaceholder);
		case "HEClientSecretPlaceholder":
			return isDisplayed(eleHE_ClientSecretPlaceholder);
		default:
			return false;
		}
	}

	/**
	 * To configure HE using client ID and Password
	 * 
	 * @param clientID , secret
	 */

	public void configureHE(String clientID, String secret) {
		wait.waitForPageToLoadCompletely();
		sendKeys(txtboxHEClientID, clientID);
		sendKeys(txtboxHE_ClientSecret, secret);
		click(btnHEConfigure);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author ambar.gupta
	 * To configure Codility using client ID and Password
	 * @param Api_key
	 */

	public void configureCodility(String Api_key) {
		wait.waitForPageToLoadCompletely();
		sendKeys(txtboxCod_api_key, Api_key);
		click(btnHEConfigure);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To click on cancel button
	 */

	public void clickOnCancelButton() {
		wait.waitForPageToLoadCompletely();
		getElement(btnHECancel).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To click on configure button
	 */

	public void clickOnConfigureButton() {
		wait.waitForPageToLoadCompletely();
		getElement(btnHEConfigure).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To verify HE configuration light box page label
	 * 
	 * @return true/false
	 */

	public boolean verifyHEPagelabel() {
		wait.waitForPageToLoadCompletely();
		return (getElement(lblHEConfigWindow).getText().equals("Configure HackerEarth"));
	}

	/**
	 * To click on 'Learn how to configure' link
	 */

	public void HE_LearnHowToConfigureLink() {
		wait.waitForPageToLoadCompletely();
		getElement(eleHELearnHowToConfigure).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To close HE configuration Light Box
	 */

	public void HE_closeConfigurationLightBox() {
		wait.waitForPageToLoadCompletely();
		getElement(btnHEconfigPagecloseX).click();
		wait.waitForPageToLoadCompletely();
	}
		
	/**
	 * To click on first 'Request A Demo' in Partner Listings Page
	 * 
	 */

	public void clickOnRequestADemoForAnyPartner() {
		wait.waitForPageToLoadCompletely();
		getElement(eleRequestDemo).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * To click on 'Manage Integration' in Settings Page
	 * 
	 */

	public void clickOnManageIntegration() {
		wait.waitForPageToLoadCompletely();
		click(eleManageIntegrationSettings);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * To click on 'Assessment Partner Integration' in Settings Page
	 * 
	 */

	public void clickOnAssessmentPartnerIntegrationInSettings() {
		wait.waitForPageToLoadCompletely();
		click(eleAssessmentPartnerIntegrationSettings);
		wait.waitForPageToLoadCompletely();
	}
	
	
	/**
	 * Verify 'Assessment Partner Integration' in Settings Page
	 * @return Whether link resent or not
	 */

	public boolean VerifyAssessmentPartnerIntegrationInSettings() {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleAssessmentPartnerIntegrationSettings);		
	}
	
	/**
	 * Verify 'Manage Integration' in Settings Page
	 * @return Whether link present or not
	 */

	public boolean VerifyManageIntegrationInSettings() {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleManageIntegrationSettings);
	}
	
	
	/**
	 * @author ambar.gupta
	 * This function checks if partner's list is sorted or not
	 * @return Whether partner's list is sorted or not
	 */
	public boolean isPartnerListSorted() {
		List<WebElement> partners = new ArrayList<WebElement>();
		List<String> partnerNames = new ArrayList<String>();
		partners = getElements(eleAllPartnerslbl);
		for (WebElement partner : partners)
		{
			partnerNames.add(partner.getText());
		}
		return  Ordering.natural().isOrdered(partnerNames);
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks if a particular partner is present or not
	 * @return Whether particular partner present or not
	 */
	public boolean isPartnerPresent(String PartnerNameToSearch) {
		List<WebElement> partners = new ArrayList<WebElement>();
		partners = getElements(eleAllPartnerslbl);
		for (WebElement partner : partners)
		{
			if(partner.getText().equals(PartnerNameToSearch))
				return true;
		}
		return  false;
	}

	/**
	 * @author ambar.gupta
	 * This function verifies that manage integration and assessment partner integration lands on same page or not
	 * @return Whether manage integration and assessment partner integration lands on same page or not
	 */
	
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	public boolean VerifyBothManageIntegrationAndAssessmentPartnerIntegrationLandOnSamePage() {
		clickOnManageIntegration();
		wait.waitForPageToLoadCompletely();
		String URL1= getCurrentURL();
		goToPageURL(URLBuilder.getURL("settingsPage"));
		clickOnAssessmentPartnerIntegrationInSettings();
		wait.waitForPageToLoadCompletely();
		String URL2= getCurrentURL();
		if(URL1.equals(URL2))
			return true;
		else
			return false;
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks content related to HackerEarth in Partner Listing's page
	 * @return Whether content related to HackerEarth is correct or not
	 */

	public boolean deletePartnerFromClientAccountTableifConfigured(Document toDel) {
		if(ValidatePartnerConfigured("HackerEarth"))
		{
			String deleteString = MongoDBConnector.deleteDocument("clientAccount",toDel );
			logMessage("[INFO] "+ deleteString);
			pageRefresh();
		}
		wait.waitForPageToLoadCompletely();
		return getElement(btnPartnerConfiguration, "Configure HackerEarth").isDisplayed();
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks whether Partner is configured or not
	 * @return Whether Partner is configured or not
	 */

	public boolean ValidatePartnerConfigured(String partnerName) {
		TestNGLogUtility.info("elementVisibility(lblPartnerConfigured,partnerName)  "+ elementVisibility(lblPartnerConfigured,partnerName) );
		List<WebElement> list=new ArrayList<WebElement>();
		wait.hardWait(1);
		list = getElements(lblPartnerConfigured,partnerName);
		if(list.size()>0)
			return true;
		else
			return false;
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks whether Partner is configured or not
	 * @return Whether Partner is configured or not
	 */
	
	public Document createBsonDocumentFromKeyValues(List<Map<String, String>> list) {
		
		Document doc=new Document();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get("Key").equals("clientId"))
			doc.put(list.get(i).get("Key"), Integer.parseUnsignedInt(list.get(i).get("Value")));
			else
				doc.put(list.get(i).get("Key"), list.get(i).get("Value"));
		}
		
		return doc;
	}
	
	
	/**
	 * @author ambar.gupta
	 * This function checks whether particular document is present in clientAccount table 
	 * @return Whether particular document is present in clientAccount table
	 */
	public long ValidateDocumentInClientAccountTable(Document toCheck) {
		logMessage("[Info] Document to check in MongoDB " + toCheck.toString());
		return MongoDBConnector.verifyNumberOfDocumentInCollection("clientAccount",toCheck );
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks number of fields in  configuration light box for given partner
	 * @param partnerName
	 * @return whether Number of fields in  configuration light box correct or not
	 */
	public boolean numberOfFieldsInconfigurationLightbox(String partnerName) {
		List<WebElement> list=new ArrayList<WebElement>();
		list = getElements(lblConfigureLightbox);

		switch(partnerName){
			case "HackerEarth" :
				return list.size() == 2 ;
			case "Codility" :
				return list.size() == 1 ;
			default:
				return false;
		}
	}
	
	/**
	 * @author ambar.gupta
	 * This function checks Configure Button For Naukri Assessments
	 * @return Whether Configure Button For Naukri Assessments present or not
	 */
	public boolean VerifyConfigureButtonForNaukriAssessments() {
		List<WebElement> list=new ArrayList<WebElement>();
		list = getElements(btnPartnerConfiguration, "Configure Naukri Assessments");
		if(list.size()==0)
			return false;
		else
			return true;
	}
	
	/**
	 * @author ambar.gupta
	 * This function Verifies Success Message for HE
	 * @return Whether Success Message for HE is correct or not
	 */
	public boolean VerifySuccessMessageHE() {
		String SuccessMsg = PropFileHandler.readProperty("SuccessMessageHE");
		if(getElement(successErrorMessageHE).getText().equals(SuccessMsg))
			return true;
		else
			return false;
	}
	
	
	/**
	 * @author ambar.gupta
	 * This function Verifies Error Message for HE
	 * @param errorMessage
	 * @return Whether Error Message for HE is correct or not
	 */
	public boolean VerifyErrorMessageHE(String errorMessage) {
		if(getElement(successErrorMessageHE).getText().equals(errorMessage))
			return true;
		else
			return false;
	}
	
	/**
     * This method is used to verify presence of element by refreshing the page again and again
     * if element found, it will break from the loop.
     *  @author abhishek.dwivedi ambar.gupta
     *  @param by, maxReloadAttempts
	 *  element to be checked and maxReloadAttempt in integer
	 *  @return Whether element found with the maximum reload attempts or not
     */
	
	public boolean refreshPageAndCheckElementIsDisplayed(By by, int maxReloadAttempts) {
        for (int i = 0; i < maxReloadAttempts; i++) {
            if (!isDisplayed(by)) {
                pageRefresh();
                wait.waitForPageToLoadCompletely();
                TestNGLogUtility.info("Page Refreshed as element not found");
            }
            else
                return true;
        }
		return false;
    }


	/**
	 * @author ambar.gupta
	 * This function Verifies text for Assessments partners on Settings page
	 * @param textType,partnerName, JSONObject data
	 * @return Whether Error Message for HE is correct or not
	 */
	public boolean verifyTextContentForPartners(String textType, String partnerName, JSONObject data) {

		switch (textType) {
			case "SubText":
				return getText(getElement(txtSubHeadingPartners, partnerName)).contains(data.get(textType + partnerName).toString());
			case "Description":
				return getText(getElement(txtDescriptionPartners, partnerName)).contains(data.get(textType + partnerName).toString());
			default:
				TestNGLogUtility.info("Text can be either SubText or Description only");
				return false;
		}
	}

	/**
	 * @author ambar.gupta
	 * This function verifies whether links for partners correct or not
	 * @param partnerName
	 * @return Whether links for partners correct or not
	 */
	public boolean verifyLinksForPartnerInDescription(String partnerName) {

		switch (partnerName) {
			case "HackerEarth":
				return isDisplayed(parameterizedLocator(linkPartnerDescription,partnerName,"Learn more")) && isDisplayed(parameterizedLocator(linkPartnerDescription,partnerName,"3 simple steps"));
			case "Codility":
			case "Naukri Assessments":
				return isDisplayed(parameterizedLocator(linkPartnerDescription,partnerName,"Request a demo"));
			default:
				TestNGLogUtility.info("Please enter correct partner to configure");
				return false;
		}

	}
}