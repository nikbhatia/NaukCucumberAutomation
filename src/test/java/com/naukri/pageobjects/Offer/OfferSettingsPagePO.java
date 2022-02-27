package com.naukri.pageobjects.Offer;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;

/**
 * @author udit.khanna
 *
 */
public class OfferSettingsPagePO extends BaseAutomation {

	// locators
	public By offerSectionOnSettings = By.xpath("//div[contains(text(), 'Offer Generation Settings')]");
	public By offerSectionBeforeManageSources = By.xpath(
			"//div[contains(text(), 'Offer Generation Settings')]/following-sibling::div[contains(text(), 'Manage Sources')]");
	public By subUserSearchBox = By.id("quickSearchRecruiter");
	public By searchButton = By.id("quickSearchSumit");
	public By txtOfferGenerationOnOffLayer = By.id("offerGenerationModuleHelpText");

	// signature on settings page
	public By editSignatureSettingsPage = By.id("signLink");
	public By iframeSignature = By.xpath("//iframe[@id='sigBodyEditor']");
	public By textUnderSignature = By.xpath("//body");
	public By saveSignature = By.xpath("//button[@id='saveSigBtn']");

	// status Change Email template page
	public By selectCategoryStatusChangeDD = By.xpath("//select[@name='category']");
	public By selectCategoryTypeStatusChange = By.xpath("//option[contains(text(),'${string}')]");
	public By txtTemplateName = By.id("mailTemplateName");
	public By txtSubject = By.id("mailTemplateSubject");
	public By txtBody = By.xpath("//iframe[@id='mailTemplateBody']");
	public By saveEmailTemplate = By.xpath("//input[@id='saveMailTemplateBtn']");
	private By eleManagePermissionLinkForSubUser = By.xpath("//div[starts-with(@id,'rec_')]//a[text()='Manage Permissions']");

	// variables
	public static String subUser = "";

	/**
	 * Verify if Offer Section is present on Settings Page
	 * 
	 * @param offerSection
	 */
	public void verifyOfferSectionPresentOnSettingsPage(String offerSection) {
		Assert.assertTrue(getText(offerSectionOnSettings).contains(offerSection),
				"Offer Section not present on Settings page");
	}

	/**
	 * Verify Offer Section is just above Manage Sources
	 * 
	 * @param offerSection
	 * @param manageSourcesSection
	 */
	public void verifyOfferSectionJustAboveManageSources(String offerSection, String manageSourcesSection) {
		Assert.assertTrue(getText(offerSectionBeforeManageSources).contains(manageSourcesSection),
				"Offer Section is not before Manage Sources Section");
	}

	/**
	 * Verify offer section not present on settings page
	 * 
	 * @param offerSection
	 */
	public void verifyOfferSectionNotPresentOnSettingsPage(String offerSection) {
		Assert.assertTrue(!elementVisibility(offerSectionOnSettings), "Offer Section is present on Settings page");
	}

	/**
	 * To set the username and password for a particular subscription of RMS
	 * 
	 * OverLoaded method to support different userType
	 * 
	 * @param subscriptionType
	 *            Example: Enterprise.Superuser
	 * @author udit.khanna
	 */
	public static String[] getUsernameAndPasswordForOffer(String subscriptionType) {
		String appConfigPath = "Offer.";
		String[] usernameAndPassword = new String[2];

		if (subscriptionType.contains("Enterprise")) {
			appConfigPath = appConfigPath + "Enterprise.";
		} else if (subscriptionType.contains("Company")) {
			appConfigPath = appConfigPath + "Company.";
		} else if (subscriptionType.contains("ProConsultant")) {
			appConfigPath = appConfigPath + "ProConsultant.";
		} else if (subscriptionType.contains("Eapps")) {
			appConfigPath = appConfigPath + "Eapps.";
		}

		if (subscriptionType.contains("Superuser"))
			appConfigPath = appConfigPath + "Superuser.";
		else if (subscriptionType.contains("Super_user"))
			appConfigPath = appConfigPath + "Super_user.";
		else if (subscriptionType.contains("Subuser"))
			appConfigPath = appConfigPath + "Subuser.";
		else if (subscriptionType.contains("Sub_user"))
			appConfigPath = appConfigPath + "Sub_user.";

		usernameAndPassword[0] = YamlReader.getAppConfigValue(appConfigPath + "username");
		if (subscriptionType.contains("Enterprise.Superuser") | subscriptionType.contains("Enterprise.Subuser") | subscriptionType.contains("Eapps.Superuser")) {
			usernameAndPassword[1] = YamlReader.getAppConfigValue(appConfigPath + "password");
		} else {
			usernameAndPassword[1] = YamlReader.getAppConfigValue("Password");
		}
		return usernameAndPassword;
	}

	/**
	 * Search a recruiter on Manage Permissions page
	 * 
	 * @param subuserType
	 */
	public void searchRecruiter(String subuserType) {
		String[] username = getUsernameAndPasswordForOffer(subuserType);
		subUser = username[0];
		sendKeys(subUserSearchBox, username[0]);
		click(searchButton);
	}

	/**
	 * Check if redirected to a certain page
	 * 
	 * @param page
	 */
	public void checkRedirectedToPage(String pageName) {
		wait.waitForPageToLoadCompletely();
		Assert.assertTrue(getPageTitle().equalsIgnoreCase(pageName), "User is not navigated to page: " + pageName);
	}

	/**
	 * Verify Sub Headings for Offer Layer
	 * 
	 * @param subHeading
	 */
	public void verifyOfferLayerSubHeadingText(String subHeading) {
		Assert.assertTrue(getText(txtOfferGenerationOnOffLayer).contains(subHeading),
				"Layer does not have subHeading: " + subHeading);
	}

	/**
	 * click edit signature on settings page
	 * 
	 */
	public void clickEditSignature() {
		click(editSignatureSettingsPage);
	}

	/**
	 * enter text under signature body
	 * 
	 */
	public void enterTextUnderSignatureBody() {
		String TextSignature = GenericFunctions.generateRandomStrings(5, "Alphanumeric");
		ReadWritePropertyFile.setProperty("textUnderSignatureBody", TextSignature,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		switchToFrame(iframeSignature);
		getElement(textUnderSignature).clear();
		getElement(textUnderSignature).sendKeys(TextSignature);
	}

	/**
	 * click save signature
	 * 
	 */
	public void clickSaveSignature() {
		// click(saveSignature);
		switchToDefaultContent();
		wait.waitForVisibilityOfElement(saveSignature);
		jsUtil.clickByJS(saveSignature);
		// getElement(saveSignature).click();
	}

	/**
	 * click category DD Email Template
	 * 
	 */
	public void clickCategoryDDEmailTemplate() {
		click(selectCategoryStatusChangeDD);
	}

	/**
	 * select offer and joining round
	 * 
	 * @param offerRound
	 */
	public void selectOfferAndJoiningRound(String offerRound) {
		click(parameterizedLocator(selectCategoryTypeStatusChange, offerRound));
	}

	/**
	 * fill mandatory fields status change category
	 * 
	 */
	public void fillmandatoryFieldsStatusChangeCategory() {
		String templateName = "Template" + CommonAction.generateRandomStrings(8, "String");
		String mailSubject = "Subject" + CommonAction.generateRandomStrings(8, "String");
		String mailBody = "MailBody" + CommonAction.generateRandomStrings(8, "String");
		ReadWritePropertyFile.setProperty("EmailSubject", mailSubject,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		ReadWritePropertyFile.setProperty("EmailBody", mailBody,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		ReadWritePropertyFile.setProperty("EmailTemplateName", templateName,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		getElement(txtTemplateName).sendKeys(templateName);
		getElement(txtSubject).sendKeys(mailSubject);
		getElement(txtBody).sendKeys(mailBody);
	}

	/**
	 * save email template
	 * 
	 */
	public void saveEmailTemplate() {
		click(saveEmailTemplate);
	}

	/**
	 * open Manage Permission For User
	 */
	public void openManagePermissionForUser() {
//		click(eleManagePermissionLinkForSubUser);
		jsUtil.clickByJS(eleManagePermissionLinkForSubUser);
	}
}
