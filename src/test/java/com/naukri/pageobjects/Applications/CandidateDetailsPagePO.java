package com.naukri.pageobjects.Applications;

import org.openqa.selenium.By;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.WaitUtility;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Candidate details page object class
 * @author rachit.mehrotra
 *
 */
public class CandidateDetailsPagePO extends PageObjectWrapper {
	
	CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	
	public final String urlOfCandidateDetailsPage = "/application/viewCandidate/";
	public static String statusOfApplicationMapped;
	
	By eleSuccessMessageString = By.xpath("//span[contains(text(),'${successMessage}')]");
	By eleForwardIcon = By.xpath("//a[text()=\" Forward\"]");
	By eleAttachIcon = By.xpath("//a[text()=\"Attach\"]");
	By eleTextHolderForDocumentSection = By.xpath("//*[contains(text(),'${text}')]");
	By eleUploadFileBtn = By.xpath("//button[contains(text(),'${buttonText}')]");
	By eleCancelFileBtn = By.xpath("(//a[contains(text(),'${buttonText}')])[4]");
	By eleRequirementWidgetTitle = By.xpath("//div[contains(@class,\"dupReqHead\")]/strong");
	By eleRequirementNameOnRequirementWidget = By.xpath("//a[contains(@title,'${requirementTitle}')]");
	By eleRequirementViewOption = By.xpath("//a[contains(@title,'${requirementName}')]/parent::div/parent::div/following-sibling::div//a[contains(text(),'${linkText}')]");
	By eleStatusOfApplicationLinked = By.xpath("//a[contains(@title,'${requirementName}')]/parent::div/preceding-sibling::div/strong");
	By eleCurrentStatusOfCandidate = By.xpath("//span[contains(@class,\"interTxt\")]");
	By eleStarRatingFetch = By.xpath("//input[contains(@id,\"starRating\")]");
	By eleQualificationSuccessMessage = By.xpath("//span[@id=\"SuccessmsgBx\"]/span");
	By eleActionButtonText = By.xpath("//div[contains(@class,\"candBtns\")]//a[contains(text(),'${btnText}')]");
	By eleRequestDocument = By.id("scrollToRequest");
	By eleDateGetterPlaceholder = By.xpath("//span[contains(text(),'${dateLabel}')]");
	By eleEducationDegreeLink = By.xpath("//span[contains(text(),'${pageSection}')]/parent::div/a[contains(text(),'${link}')]");
	By eleAddCertificateLink = By.id("certEditButton");
	
	public boolean verifyThePresenceOfCandidateDetailsPage() {
		return getCurrentURL().contains(urlOfCandidateDetailsPage);
	}
	
	public boolean verifyThePresenceOfSuccessMessage(String expectedString) {
		return isDisplayed(parameterizedLocator(eleSuccessMessageString, expectedString));
	}
	
	public void clickOnForwardForCandidateDetailsPage() {
		click(eleForwardIcon);
	}
	
	public void clickOnAttachButton() {
		click(eleAttachIcon);
	}

	public boolean verifyTheTextPresenceOfDocumentsSection(String text) {
		return isDisplayed(parameterizedLocator(eleTextHolderForDocumentSection, text));
	}
	
	public boolean verifyThePresenceOfButtonInDocumentSection(String buttonText) {
		System.out.println(parameterizedLocator(eleCancelFileBtn, buttonText));
		boolean flag = buttonText.equals("Upload File") ? 
				isDisplayed(parameterizedLocator(eleUploadFileBtn, buttonText)) :
				isDisplayed(parameterizedLocator(eleCancelFileBtn, buttonText));
		return flag;
	}
	
	public boolean verifyThePresenceOfTitle(String expectedWidgetTitle) {
		return expectedWidgetTitle.equals(getText(eleRequirementWidgetTitle));
	}
	
	public boolean verifyTheRequirementNameInRequirementWidget() {
		return isDisplayed(parameterizedLocator(eleRequirementNameOnRequirementWidget, PropFileHandler.readProperty("requirementNameForApplication")));
	}
	
	public boolean verifyTheLinkPresenceOfRequirement(String linkText) {
		return isDisplayed(parameterizedLocator(eleRequirementViewOption, PropFileHandler.readProperty("requirementNameForApplication"), linkText));
	}
	
	public void recordTheStatusOfApplicationMapped() {
		statusOfApplicationMapped = getText(parameterizedLocator(eleStatusOfApplicationLinked, PropFileHandler.readProperty("requirementNameForApplication")));
	}
	
	public void clickOnLinkUnderRequirementInRequirementWidget(String linkText) {
		click(parameterizedLocator(eleRequirementViewOption, PropFileHandler.readProperty("requirementNameForApplication"), linkText));
		switchToChildWindow();
	}
	
	public boolean checkTheAbsenceOfStatusDD() {
		boolean flag=true;
		wait.resetImplicitTimeout(1);
		flag = isDisplayed(eleCurrentStatusOfCandidate);
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		return flag;
	}
	
	public boolean checkTheAbsenceOfStarRating() {
		boolean flag = true;
		wait.resetImplicitTimeout(1);
		flag = isDisplayed(eleStarRatingFetch);
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		return flag;
	}
	
	public boolean verifyTheExpectedSuccessMessageOnQualificationAddition(String expectedSuccessString) {
		return getText(eleQualificationSuccessMessage).equals(expectedSuccessString);
	}
	
	public boolean verifyThePresenceOfActionButton(String btnText) {
		return isDisplayed(parameterizedLocator(eleActionButtonText, btnText));
	}
	
	public boolean verifyTheAbsenceOfRequestDocumentLink() {
		return isDisplayed(eleRequestDocument);
	}
	
	/**
	 * To verify the date
	 * @param dateLabelString
	 * @return boolean basis comparison
	 */
	public boolean verifyThePresentDayDate(String dateLabelString) {
		return getText(parameterizedLocator(eleDateGetterPlaceholder, dateLabelString)).replace(dateLabelString, "").trim()
				.contains(commonAction.getPresentDayDateInApplicationsFormat());
	}
	
	/**
	 * Check the presence of the link of the education tab
	 * @param link
	 * @param sectionOfPage
	 * @return boolean on basis of presence
	 */
	public boolean verifyThePresenceOfLinkUnderSection(String link, String sectionOfPage) {
		boolean flag;
		wait.resetImplicitTimeout(1);
		flag = isDisplayed(parameterizedLocator(eleEducationDegreeLink, link, sectionOfPage));
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		return flag;
	}
	
	/**
	 * To check the visibility of add certificate
	 * @return boolean on basis of the presence
	 */
	public boolean checkTheVisibilityOfAddCertificate() {
		return isDisplayed(eleAddCertificateLink);
	}
}
