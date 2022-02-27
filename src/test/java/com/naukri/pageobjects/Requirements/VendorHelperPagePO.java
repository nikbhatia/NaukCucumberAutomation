package com.naukri.pageobjects.Requirements;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

/**
 * Vendor Page PO only the part which is required for the requirement's module
 * @author rachit.mehrotra
 *
 */
public class VendorHelperPagePO extends PageObjectWrapper {
	
	//Locators
	By eleEmployerName = By.cssSelector("div[class='employerName ap-list-col-item']");
	By eleRequirementListingTitle = By.xpath("//div[@class=\"reqListTitle\"]");
	By eleRequirementName = By.xpath("//a[contains(text(),'${requirementName}')]");
	By eleVendorLightboxTitle = By.xpath("//div[contains(@class,\"tabHeadTitle\")]");
	By eleSubmitCandidate = By.xpath("//a[contains(text(),'Submit Candidates')]");
	By eleCandidateEmail = By.xpath("//input[contains(@placeholder,\"Enter Candidate's email\")]");
	By eleCandidatePhoneNumber = By.xpath("//input[contains(@placeholder,\"Your current mobile no\")]");
	By eleCandidateLocation = By.xpath("//span[contains(text(),\"Enter Your Current Location/City\")]");
	By eleCandidateLocationText = By.xpath("//input[contains(@placeholder,\"Enter Your Current Location/City\")]");
	By eleFirstCandidateLocationSuggestor = By.xpath("(//span[text()='${locationSuggestor}'])[1]");
	By eleCTCLakhs = By.xpath("//input[contains(@placeholder,\"lacs\")]");
	By eleCTCLakhsList = By.xpath("//input[contains(@placeholder,\"lacs\")]");
	By eleCTCLakhsFirstOption = By.xpath("//span[text()='${lakhs}']");
	By eleCTCThousands = By.xpath("//input[contains(@placeholder,\"thousands\")]");
	By eleCTCThousandsList = By.xpath("//input[contains(@placeholder,\"thousands\")]");
	By eleCTCThousandsFirstOption = By.xpath("//span[text()='${thousands}']");
	By elePreferredLocation = By.xpath("//span[contains(text(),'Search here')]");
	By elePrefferedLocationList = By.xpath("//input[contains(@placeholder,\"Search here\")]");
	By eleFirstOptionOfPreffered = By.xpath("//label[contains(text(),\"Anywhere in North India\")]");
	By eleUG = By.xpath("//span[contains(text(),'Select UG Course')]");
	By eleUgList = By.xpath("//input[contains(@placeholder,\"Select UG Course\")]");
	By eleFirstOptionOfUG = By.xpath("//span[contains(text(),'Not Pursuing Graduation')]");
	By eleUGSpec = By.xpath("//span[contains(text(),'Select UG Spec')]");
	By eleUgSpecList = By.xpath("//input[contains(@placeholder,\"Select UG Spec\")]");
	By eleFirstOptionOfUGSpece = By.xpath("//span[contains(text(),'Not Pursuing Graduation')]");
	By eleCurrentDesignation = By.xpath("//input[contains(@placeholder,\"Your Designation in your current organization\")]");
	By eleCurrentCompany = By.xpath("//input[contains(@placeholder,\"Enter current company name\")]");
	
	/**
	 * To click on the employer name on vendor dashboard
	 */
	public void clickOnEmployerNameOnVendorDashboard() {
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
		actionBuilderUtil.clickByAction(eleEmployerName);
	}
	
	/**
	 * To verify the list of requirement present on the vendor page
	 * @param expectedRequirementList
	 * @return true/false basis the comparison
	 */
	public boolean verifyTheListOfRequirementPageForVendorPortal(String expectedRequirementList) {
		return getText(eleRequirementListingTitle).contains(expectedRequirementList);
	}
	
	/**
	 * To click on the requirement name created 
	 */
	public void clickOnRequirementNameCreated() {
		click(parameterizedLocator(eleRequirementName, RequirementCreationPagePO.requirementName));
		switchToChildWindow();
	}
	
	/**
	 * To click on the submit candidate on the requirement overview page for vendor portal
	 */
	public void clickOnSubmitCandidateButton() {
		click(eleSubmitCandidate);
		switchToChildWindow();
	}
	
	/**
	 * To verify the presence of the lightbox title for vendor
	 * @param expectedVendorLightboxTitle
	 * @return true/false basis the comparison
	 */
	public boolean verifyThePresenceOfVendorLightbox(String expectedVendorLightboxTitle) {
		return getText(eleVendorLightboxTitle).equals(expectedVendorLightboxTitle);
	}
}
