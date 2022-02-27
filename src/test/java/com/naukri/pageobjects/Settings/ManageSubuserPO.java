package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;

public class ManageSubuserPO extends BaseAutomation {
	
	By btnSave = By.xpath("//input[@id='editRecruiterBtn']");
	By btnEdit = By.xpath("//span[text()='${eId}' and contains(@class,'brD9')]//..//..//..//a[text()='${btn}']");
	By txtAreaName = By.xpath("//input[@id='name']");
	By txtError = By.xpath("//div[@id='name_err']");
	By txtName = By.xpath("//span[text()='${name}']");
	By btnCancel = By.xpath("//a[@id='editUserClose']");
	By btnHiringManage = By.id("hiringManagerListProfile");
	By btnRecruiter = By.id("recruiterListProfile");
	By ddReportingTo = By.xpath("//label[text()='Reporting To:']//..//div[@id='reportingTodd']");
	By txtReportingTo = By.xpath("//label[text()='Reporting To:']//..//span");
	By txtlabel = By.xpath("//label[text()='${label}']");
	By toggleRequisitionDetailSetting = By.id("requisitionVisibilitySwitch");
	By btnRequisitionDetailSetting = By.id("requisitionOnOff");
	By setRequisitionSetting = By.xpath("//input[@onclick='requisitionVisibilitySave();']");
	By toggleFeedbackVisibilitySettings = By.id("feedbackVisibilitySwitch");
	By btnFeedbackVisibilitySettings = By.id("feedbackOnOff");
	By setFeedbackVisibilitySettings = By.xpath("//input[@onclick='feedbackVisibilitySave();']");
	By toggleCTCVisibilitySettings = By.id("ctcSwitch");
	By btnCTCVisibilitySettings = By.id("on_off");
	By setCTCVisibilitySettings = By.xpath("//input[@onclick='CTCsave();']");
	By ddCTCVisibilitySetting = By.id("inp_ctcDrpDwn");
	
	By ddMNRReportingTo = By.xpath("//div[text()='${recEid}']//..//span[@class='dropArrowDD']");
	By txtAreaReportingTo = By.xpath("//input[@id='reportingManager${Eid}']");
	By btnCrossPhotoUploader = By.xpath("//span[@class='cross_photoUploader']");
	By btnSaveHierarchy = By.xpath("//button[text()='${btnName}']");
	By txtGeneric = By.xpath("//*[text()='${txt}']");
	By ddGroup = By.id("inp_groupSelListAndAddBtn");
	
	
	/**
	 * @author gupta.mansi
	 * This method is used to navigate to manage subuser page on recruit page
	 * Reference getURL() method from URL Builder
	 */
	public void navigateToPageMNRManageSubuser()
	{
		String baseURL = YamlReader.getAppConfigValue("URLs.recBaseURL");
		String environment = System.getProperty("testEnvironment");
        if (environment == null || environment.isEmpty()) {
            environment = ReadWritePropertyFile.getProperty("testEnvironment", BaseAutomation.configFile);
        }
        if (environment.equalsIgnoreCase("test")) {
            String nameSpace = System.getProperty("nameSpace");
            if ((nameSpace == null) || (nameSpace.isEmpty())) {
                nameSpace = ReadWritePropertyFile.getProperty("nameSpace", BaseAutomation.configFile);
            }
            baseURL = baseURL.replaceFirst("naukri-test2", nameSpace);
            TestNGLogUtility.info("URL: " + baseURL);
        }
        baseURL = baseURL + URLBuilder.getEndPoint("MNRManageSubuser");
        driver.get(baseURL);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on button for given Recruiter on manage sub-user page
	 * @param eId :email id of user
	 * @param btnName
	 */
	public void clickOnBtn(String eId,String btnName)
	{
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnEdit, eId, btnName));
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on save button on edit lightbox
	 */
	public void clickOnSave()
	{
		click(btnSave);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to fill the name of recruiter
	 * @param name 
	 */
	public void fillName(String name)
	{
		getElement(txtAreaName).clear();
		getElement(txtAreaName).sendKeys(name);
	}
	
	/**
	 * This method is used to return the text of error displayed
	 * @return
	 */
	public String getTextErrorDisplayed()
	{
		return getText(txtError);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to return the color of the border of input field name 
	 * @return color in hex format
	 */
	public String getBorderColor()
	{
		String color = getElement(txtAreaName).getCssValue("border");
		String[] rgbValue = color.substring(color.indexOf("(")+1, color.indexOf(")")).split(",");
		String hexValue = "#"+Integer.toHexString(Integer.parseInt(rgbValue[0].trim()))+Integer.toHexString(Integer.parseInt(rgbValue[1].trim()))+Integer.toHexString(Integer.parseInt(rgbValue[2].trim()));
		return hexValue;
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to return the name of the text displayed on recruiters page
	 * @param username
	 * @return true if name is displayed
	 */
	public boolean isNameOfSubuserDisplayed(String username)
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(txtName, username));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on cancel button from edit recruiter lb
	 */
	public void clickOnCancel()
	{
		getElement(btnCancel).click();;
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on HM Section
	 */
	public void clickOnHMSection()
	{
		click(btnHiringManage);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on recruiter section
	 */
	public void clickOnRecruiterSection()
	{
		click(btnRecruiter);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to return true if Reporting to DD is displayed in edit lightbox of Recruiter
	 * @return true if dd displayed else false
	 */
	public boolean isReportingToDDDiplayed()
	{
		return isDisplayed(ddReportingTo);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to return true if given label text is displayed
	 * @param labelName: name of the label
	 * @return true if label displayed
	 */
	public boolean isLabelDisplayed(String labelName)
	{
		return isDisplayed(parameterizedLocator(txtlabel, labelName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to reporting to dd for for user
	 * @param user name for which dd for reporting to is to be clicked
	 */
	public void clickOnMNRReortingToDD(String user)
	{
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollMid(parameterizedLocator(ddMNRReportingTo, user));
		click(parameterizedLocator(ddMNRReportingTo, user));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to fill reporting to
	 * @param reportingTo
	 * @param user name for which reporting to is to be set
	 */
	public void fillReportingTo(String reportingTo,String user)
	{
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollMid(parameterizedLocator(ddMNRReportingTo, user));
		getElement(ddMNRReportingTo, user).click();
		getElement(txtAreaReportingTo, user).sendKeys(reportingTo);
		getElement(txtAreaReportingTo, user).sendKeys(Keys.ENTER);
	}
	
	/**
	 * This method is used to return the text displayed for Reporting To
	 * @return reporting to text in string
	 */
	public String getReportingTo()
	{
		return getText(txtReportingTo);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to close upload photo box on manage subuser page on MNR
	 */
	public void closePhotoUploader()
	{
		click(btnCrossPhotoUploader);
		wait.waitForInvisibilityOfElement(2, 2, btnCrossPhotoUploader);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to toggle requisition detail setting
	 * @param value can be "on" or "off"
	 */
	public void toggleRequisitionDetailSetting(String value)
	{
		wait.waitForVisibilityOfElement(toggleRequisitionDetailSetting);
		String presentValue = getAttribute(btnRequisitionDetailSetting, "value").trim();
		if (!presentValue.equalsIgnoreCase(value)) {
			getElement(toggleRequisitionDetailSetting).click();
		}
		wait.waitForElementToBeClickable(setRequisitionSetting);
		getElement(setRequisitionSetting).click();
		wait.waitForPageToLoadCompletely();	
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to toggle feedback visibility setting
	 * @param value value can be "on" or "off"
	 */
	public void toggleFeedbackVisibilitySettings(String value)
	{
		wait.waitForVisibilityOfElement(toggleFeedbackVisibilitySettings);
		String presentValue = getAttribute(btnFeedbackVisibilitySettings, "value").trim();
		if (!presentValue.equalsIgnoreCase(value)) {
			getElement(toggleFeedbackVisibilitySettings).click();
		}
	}
	
	/**
	 * @author gupta.mansi
	 * This method click on save button for feedback visibility lb
	 */
	public void saveFeedbackVisibilitySetting(){
		wait.waitForElementToBeClickable(setFeedbackVisibilitySettings);
		getElement(setFeedbackVisibilitySettings).click();
		wait.waitForPageToLoadCompletely();	
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to toggle CTC visibility setting switch
	 * @param value: value can be "on" or "off"
	 */
	public void toggleCTCVisibilitySetting(String value)
	{
		wait.waitForVisibilityOfElement(toggleCTCVisibilitySettings);
		String presentValue = getAttribute(btnCTCVisibilitySettings, "value").trim();
		if (!presentValue.equalsIgnoreCase(value)) {
			getElement(toggleCTCVisibilitySettings).click();
		}
		wait.waitForElementToBeClickable(setCTCVisibilitySettings);
//		getElement(setCTCVisibilitySettings).click();
//		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method click on save button for CTC visibility lb
	 */
	public void saveCTCVisibilitySetting(){
		wait.waitForElementToBeClickable(setCTCVisibilitySettings);
		getElement(setCTCVisibilitySettings).click();
		wait.waitForPageToLoadCompletely();
	}
	
	
	/**
	 * @author gupta.mansi
	 * This method clicks on ctc visibility dd
	 */
	public void clickOnCTCVisibilityDD()
	{
		click(ddCTCVisibilitySetting);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given option from dd
	 * @param optionTxt
	 */
	public void clickOptionFromCTCDD(String optionTxt)
	{
		click(parameterizedLocator(txtGeneric, optionTxt));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Group dd
	 */
	public void clickOnGroupDDInLB()
	{
		wait.waitForVisibilityOfElement(ddGroup);
		click(ddGroup);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method searches given group name and click on its name
	 * @param grpName
	 */
	public void searchGroupAndClickOnName(String grpName)
	{
		wait.waitForVisibilityOfElement(ddGroup);
		click(ddGroup);
		getElement(ddGroup).sendKeys(grpName);
		click(parameterizedLocator(txtGeneric, grpName));
	}

}
