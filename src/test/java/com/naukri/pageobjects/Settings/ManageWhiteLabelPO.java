package com.naukri.pageobjects.Settings;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.record.LbsDataSubRecord;
import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;

public class ManageWhiteLabelPO extends BaseAutomation {



	private By txtCompanyName = By.id("companyName");

	private By FrameAboutCompany = By.id("aboutCompany_editor");
	private By txtAboutCompany = By.xpath("//style[contains(text(),'import url')]/parent::head/parent::html//body");
	private By btnSelectColor = By.xpath("//*[text()=' Blue Sand ']");
	private By btnSelectColor2= By.xpath("//*[text()=' Spring ']"); 
	private By btnSave= By.id("saveSettings");
	By careersiteTab = By.id("careerTab");
	By mailTab = By.id("mailTab");
	By maskCandidateNameChckbox = By.id("maskCandidateNameOnly");
	By maskCandidateDetailChckbox = By.id("maskCandidateDetails");
	By maskCandidateCompanyChckbox = By.id("maskCompanyName");
	By maskingDetailDivSection = By.xpath("//div[contains(text(),\"CV Masking - Mask Name, Contact Details and Company Name\")]");
	By saveButton = By.xpath("(//input[@id=\"saveSettings\"])[2]");
	By cancelButton = By.xpath("//div[@class=\"whtCnt\"]//a[text()=\"Cancel\"]");
	By permissionDataOnSettingsPage = By.xpath("//label[contains(text(), '${permissionText}')]");
	By maskingRadioPrimary = By.id("maskingDetails1");
	By maskingRadioAllEmail = By.id("maskingDetails2");
	private By txtCustomeURL = By.id("internalUrl");
	private By btnRemoveForCutomURL = By.xpath("//div[@id='existingDomainName']//a");
	String companyName="";
	String aboutCompany="";
	private By txtCompanyNameOnRequirementDetailPage = By.xpath("//input[@id='companyName']");
	private By txtAboutCompanyOnRequirementDetailPage = By.xpath("//textarea[@id='aboutCompanyDesc']");
	private By txtCompanyTagLine = By.id("companyTagLine");
	/**
	 * This method fills company name on white listing page
	 * @author jatin.bisht
	 */
	public void fillCompanyName() {
		companyName="NAUKRI RMS";
		getElement(txtCompanyName).clear();
		sendKeys(txtCompanyName,companyName);
		getElement(txtCompanyTagLine).clear();
		sendKeys(txtCompanyTagLine, "One of the Best");
	}
	/**
	 * @author jatin.bisht
	 */
	public void fillAboutCompany() {
		aboutCompany="Very Good Company";
		getElement(txtAboutCompany).clear();
		sendKeys(txtAboutCompany,aboutCompany);
	}
	/**
	 * @author jatin.bisht
	 */
	public void chooseTheme() {
		getElement(btnSelectColor).click();
		getElement(btnSelectColor2).click();
		getElement(btnSave).click();
	}
	/**
	 * @author jatin.bisht
	 */
	public void SwitchToAboutCompanyFrame() {
		switchToFrame(FrameAboutCompany);
	}
	
//	/**
//	 * All job boards are visible on Manage Job Boards page
//	 */
//	public boolean verifyAllBoardsDisplay(String boardName) {		 
//		return getElement(lblBoardName,boardName).isDisplayed();	
//	}	
	
	/**
	 * To click on tabs present on white label settings page
	 * @author rachit.mehrotra
	 * @param tabname
	 */
	public void clickOnTabsOnWhiteLabelSettings(String tabname) {
		switch(tabname) {
		case "Mail" :
			click(mailTab);
			break;
		case "CareerSite Tab" : 
			click(careersiteTab);
			break;
		}
	}
	
	/**
	 * To verify the selected state of the check box
	 * @author rachit.mehrotra
	 * @param labelText
	 * @return boolean depending on the selection state
	 */
	private boolean checkTheStateOfMaskingCheckboxes(String labelText) {
		System.out.println("labelText " + labelText);
		String attributeText;
		jsUtil.scrollDown(maskingDetailDivSection);
		switch (labelText) {
		case "Mask candidate name as present in RMS.":
			attributeText = getAttribute(maskCandidateNameChckbox, "checked");
			if (attributeText == null) {
				return false;
			} else {
				return true;
			}
		case "Email ID and Phone Number of Candidates in CV":
			attributeText = getAttribute(maskCandidateDetailChckbox, "checked");
			if (attributeText == null) {
				return false;
			} else {
				return true;
			}
		case "Also mask the current company (as present in candidate profile in RMS) of the candidate.":
			attributeText = getAttribute(maskCandidateCompanyChckbox, "checked");
			if (attributeText == null) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * To select the masking button
	 * @author rachit.mehrotra
	 * @param labelText
	 */
	public void selectTheMaskingCheckbox(String labelText) {
		String labelTextIndentifier = labelText.split(",")[0];
		if (!checkTheStateOfMaskingCheckboxes(labelTextIndentifier)) {
			click(parameterizedLocator(permissionDataOnSettingsPage, labelTextIndentifier));
		}
		if(labelText.split(",", 1) == null) {
		String subOption = labelText.split(",")[1];
			if (subOption.contains("Mask primary and secondary email ID and phone no. of the candidate as present in candidate profile in RMS. "))
				click(maskingRadioPrimary);
			if(subOption.contains("Mask all email IDs and all phones present anywhere on the CV"))
				click(maskingRadioAllEmail);
		}
	}
	
	/**
	 * To click on the footer option of SAVE/CANCEL
	 * @author rachit.mehrotra
	 * @param optionText
	 */
	public void clickOnFooterOption(String optionText) {
		if(optionText.equals("Save")) {
			click(saveButton);
		}
		if(optionText.contains("Cancel")) {
			wait.waitForElementToBeClickable(cancelButton);
			click(cancelButton);
		}
	}
	
	/**
	 * To uncheck all the checkboxes of masking present
	 * @author rachit.mehrotra
	 * @param optionText1
	 * @param optionText2
	 * @param optionText3
	 */
	public void uncheckAllTheMaskingCheckbox(String optionText1, String optionText2, String optionText3) {
		if(checkTheStateOfMaskingCheckboxes(optionText1))
			click(maskCandidateNameChckbox);
		if(checkTheStateOfMaskingCheckboxes(optionText2))
			click(maskCandidateDetailChckbox);
		if(checkTheStateOfMaskingCheckboxes(optionText3))
			click(maskCandidateCompanyChckbox);
	}

	/**
	 * THis method use to fill the custom URL for white label setting
	 * 
	 * @author abhishek.dwivedi
	 * @param customURL
	 */
	public void fillCustomURL(String customURL) {
		if (isDisplayed(btnRemoveForCutomURL)) {
			click(btnRemoveForCutomURL);
			wait.hardWait(2);
		}
		getElement(txtCustomeURL).clear();
		System.out.println();
		sendKeys(txtCustomeURL, customURL);
	}

	/**
	 * THis method use to click on remove button after the custom URL for white
	 * label setting is done
	 * 
	 * @author abhishek.dwivedi
	 * 
	 */
	public void clickRemoveButtonToDisableCustomeURL() {
		click(btnRemoveForCutomURL);
	}
	/**
	 * Remove about company and company name
	 * @author abhishek.dwivedi
	 */
	public void clearTextCompanyNameAndAboutCompany() {
		getElement(txtCompanyName).clear();
		getElement(txtAboutCompany).clear();
	}

	/**
	 * Element like about company and company name displayed on the page
	 * 
	 * @author abhishek.dwivedi
	 */
	public boolean isElementOfWhiteLabelDisplayedOnThePage(String elementName) {
		boolean flag = false;
		switch (elementName) {
		case "Company Name":
			flag = getAttribute(txtCompanyNameOnRequirementDetailPage,"value").contains(companyName);
			break;
		case "About Company":
			flag = getText(txtAboutCompanyOnRequirementDetailPage).contains(aboutCompany);
			break;
		}
		return flag;
	}

	/**
	 * Adding a job board text is visible when clicking on HELP link on manage job
	 * board page
	 */
	public void fillCompanyDetails(String updatedCompanyName, String updatedAboutCompany) {
		getElement(txtCompanyName).clear();
		companyName = updatedCompanyName;
		sendKeys(txtCompanyName, companyName);
		getElement(txtAboutCompany).clear();
		aboutCompany = updatedAboutCompany;
		sendKeys(txtAboutCompany, aboutCompany);
	}
}
