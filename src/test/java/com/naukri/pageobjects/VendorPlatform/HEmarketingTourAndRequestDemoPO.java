package com.naukri.pageobjects.VendorPlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naukri.test.base.BaseAutomation;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 * @author ambar.gupta
 *
 */
public class HEmarketingTourAndRequestDemoPO extends BaseAutomation{
	private By lblHeadingHEmarketingTourPage = By.xpath("(//div[@class='proHeader']/div)[1]");	
	private By lblSubHeadingsHEmarketingTourPage = By.xpath("//*[text()='${Headings}']");
	private By lblHeaderHEthreeStepsPage = By.xpath("//span[text()='How to configure HackerEarth in RMS?']");
	private By lblFooterHEthreeStepsPage = By.xpath("//span[text()='Configure HackerEarth Assessment Integration Now']");
	private By lblViewTestResults = By.xpath("//span[text()='View test results']");
	private By btnSuperUserbtnsUpperSet = By.xpath("//div[@class='superUserBtns']/a[text()='${buttonName}']");
	private By btnSendInterestUpper = By.xpath("//div[@class='subuserBtns']/a");
	private By btnSuperUserbtnsLowerSet = By.xpath("//div[@class='proHeader']/div/a[text()='${buttonName}']");
	private By btnSendInterestLower = By.xpath("//div[@class='sendIntSec']/a");
	private By btnHEmarketingPagecloseX = By.xpath("//a[@class='crossPage']");
	private By lblSuccessMessageSendInterest = By.className("interestSendSuccess");
	
	/**
	 *  HackerEarth Request Demo Page Elements
	 *  RD stands for - Request Demo page
	 */
	
	private By lblRequestaDemo = By.xpath("//div[@class='proHeader']/div[1]");
	private By lblForPartnerAssessment = By.xpath("//div[@class='proHeader']/div[2]");
	private By btnHErequestDemoPagecloseX = By.xpath("//span[@class='crossPage']");
	private By lblFieldnames = By.xpath("//div[@class='field-title' and text()='${fieldName}']");
	private By btnbutton =  By.xpath("//div[text()='${buttonName}']");
	private By txtboxRDfullName = By.name("name");
	private By txtboxRDworkEmailAddress = By.name("email");
	private By txtboxRDdesignation = By.name("designation");
	private By txtboxRDcompanyName = By.name("companyName");
	private By txtboxRDphoneNumber = By.name("phoneNumber");
	private By btnRequestNow = By.xpath("//div[text()=' REQUEST NOW ']");
	private By eleRDmandatoryFields = By.xpath("//input[contains(@rel,'required')]/following-sibling::p[text()='This field is mandatory.' ]");
	private By lblThisFieldIsMandatory = By.xpath("//input[contains(@rel,'required')]/following-sibling::p[text()='This field is mandatory.' ]");
	private By elePhoneNumberError = By.id("phoneNumber_err");
	private By eleEmailError = By.id("email_err");
	private By eleToAppendInReqField = By.xpath("By.xpath('.//preceding-sibling::div/span[text()='*']')");
	
	//Demo Success Page	
	private By lblDemoRequestedSuccessfully = By.xpath("//div[@class='title'][text()='Demo requested successfully.']");
	private By eleDemoReqSuccessImage = By.xpath("//img[@class='symbol']");
	
	
	/**
	 * To validate button displayed
	 * @return Whether  button displayed or not
	 * 
	 */
	public boolean verifyHeadingOnTourPage(String heading) {
		return getElement(lblHeadingHEmarketingTourPage).getText().equals(heading);
	}
	
	/**
	 * To verify required elements are present on Request Demo page
	 * 
	 * @return True/false
	 * @param elementName : name of the element whose presence is to be verified
	 */
	
	public boolean verifyElementsOnRequestDemoPage(String fieldName) 
	{
		return getElement(lblFieldnames, fieldName).isDisplayed();        
	}
	
	
	/**
	 * To verify success message in case of Send Interest
	 * 
	 * @return True/false
	 * @param elementName : name of the element whose presence is to be verified
	 */
	
	public boolean verifySuccessMessageInCaseOfSendInterest(String message) 
	{
		wait.hardWait(3);
		List<WebElement> list=new ArrayList<WebElement>();
		list = getElements(lblSuccessMessageSendInterest);
		if(list.get(0).getText().trim().equals(list.get(1).getText().trim()))
		return list.get(0).getText().trim().equals(message) ;
		else
			return false;
	}
	
	/**
	 * To validate button displayed
	 * @return Whether  button displayed or not
	 * 
	 */
	public boolean verifyRequestNowButtonPresence(String buttonName) {
		wait.waitForPageToLoadCompletely();
		return getElement(btnbutton, buttonName).isDisplayed();
	}
	
	
	/**
	 * To validate Request Demo Page's Header displayed
	 * @return Whether Header displayed or not
	 * 
	 */
	public boolean verifyHeaderLabelPresenceAtRequestDemoPage() {
		wait.waitForPageToLoadCompletely();
		if(isDisplayed(lblRequestaDemo) && isDisplayed(lblForPartnerAssessment))
			return true;
		return false;
	}
	
	
	
	
	
	/**
	 * @author ambar.gupta
	 * To click on buttons of static pages
	 * 
	 */
	public void clickOnStaticPagesButtons(String element) {
		wait.waitForPageToLoadCompletely();
		switch(element) {
		case "REQUEST A DEMO":{
			getElement(btnSuperUserbtnsUpperSet, element).click();			
			break;
		}
		case "CONFIGURE HACKEREARTH":{
			getElement(btnSuperUserbtnsUpperSet, element).click();			
			break;
		}
		case "Send Interest":{
			getElement(btnSendInterestUpper).click();
			break;
		}
		case "SendInterestLower":{
			getElement(btnSendInterestLower).click();
			break;
		}
		case "RequestADemoLower":{
			getElement(btnSuperUserbtnsLowerSet, "REQUEST A DEMO").click();
			switchToChildWindow();
			break;
		}
		case "ConfigureHackerEarthLower":{
			getElement(btnSuperUserbtnsLowerSet, "CONFIGURE HACKEREARTH").click();
			break;
		}	
		}
	}
	
	/**
	 * @author ambar.gupta
	 * To verify label of buttons of static pages
	 * 
	 */
	public boolean verifyStaticPagesButton(String element) {
		wait.waitForPageToLoadCompletely();
		switch(element) {
		case "REQUEST A DEMO":{
			return isDisplayed(btnSuperUserbtnsUpperSet, element);
		}
		case "CONFIGURE HACKEREARTH":{
			return isDisplayed(btnSuperUserbtnsUpperSet, element);
		}
		case "SEND INTEREST":{
			return isDisplayed(btnSendInterestUpper);
		}
		case "SendInterestLower":{
			return isDisplayed(btnSendInterestLower);
		}
		case "RequestADemoLower":{
			return isDisplayed(btnSuperUserbtnsLowerSet, "REQUEST A DEMO");
		}
		case "ConfigureHackerEarthLower":{
			return isDisplayed(btnSuperUserbtnsLowerSet, "CONFIGURE HACKEREARTH");
		}
		default:
			return false;
		}
	}
	
	/**
	 * To verify required elements are present on configure HE window
	 * 
	 * @return True/false
	 * @param elementName : name of the element whose presence is to be verified
	 */
	public boolean verifylabelsAndElementsOnStaticPages(String headings) {
		return isDisplayed(lblSubHeadingsHEmarketingTourPage, headings);		
	}
	
	
	/**
	 * This method is used to request a demo from HE by filling and submitting all details in the form 
	 * @author ambar.gupta
	 * @param String fullName, workEmailAddress, designation, companyName, phoneNumber
	 */
	public void requestDemoHE(String fullName, String workEmailAddress, String designation, String companyName, String phoneNumber ) {
		wait.waitForPageToLoadCompletely();
		switchToChildWindow();
		getElement(txtboxRDfullName).sendKeys(fullName);
		getElement(txtboxRDworkEmailAddress).sendKeys(workEmailAddress);
		getElement(txtboxRDdesignation).sendKeys(designation);
		getElement(txtboxRDcompanyName).sendKeys(companyName);
		getElement(txtboxRDphoneNumber).sendKeys(phoneNumber);
		getElement(btnRequestNow).click();
		wait.waitForPageToLoadCompletely();
	}
	
	
	/**
	 * @author ambar.gupta
	 * To close HE Marketing Tour page
	 */
	public void HE_closeMarketingTourPage() {
		wait.waitForPageToLoadCompletely();
		getElement(btnHEmarketingPagecloseX).click();
		wait.waitForPageToLoadCompletely();
	}
	
	
	/**
	 * @author ambar.gupta
	 * To close HE Request Demo page
	 */
	public void HE_closeRequestDemoPage() {
		wait.waitForPageToLoadCompletely();
		getElement(btnHErequestDemoPagecloseX).click();
		wait.waitForPageToLoadCompletely();
	}
	/**
	 * @author ambar.gupta
	 * This method is used to verify error message for required fields
	 * Required: Request Demo page must be in default state
	 * @return Whether error message 'This Field Is Mandatory' present for all required elements or not
	 */
	
	public boolean verifyErrorMsgForRequiredFields() {
		List<WebElement> requiredFieldsErrMsg=new ArrayList<WebElement>();
		requiredFieldsErrMsg = getElements(lblThisFieldIsMandatory);
		
		wait.waitForPageToLoadCompletely();
		getElement(btnRequestNow).click();
		
		for (WebElement ErrMsg : requiredFieldsErrMsg)
		{
			if(!ErrMsg.isDisplayed())
			{
				return false;
			}
		}
		return true;
		
	}
	
	
	
	/**
	 * @author ambar.gupta
	 * This method is used to validate Email format
	 * @return Whether given Email is in correct format or not
	 */
	
	public boolean validateEmailFormat(String Email) {
		WebElement txtboxEmail = getElement(txtboxRDworkEmailAddress);
		txtboxEmail.sendKeys(Email);
		if (txtboxEmail.getAttribute("class").equals("field ok"))
			return true;
		return false;
	}
	
	
	/**
	 * @author ambar.gupta
	 * This method is used to validate phone number format
	 * @return Whether given phone number is in correct format or not
	 */
	
	public boolean validatePhoneNumberFormat(String phoneNumber) {
		WebElement txtboxEmail = getElement(txtboxRDphoneNumber);
		txtboxEmail.sendKeys(phoneNumber);
		if (txtboxEmail.getAttribute("class").equals("field ok"))
			return true;
		return false;
	}
	
	/**
	 * @author ambar.gupta
	 * This method is used to validate error message for Invalid Email
	 * @param: String Email
	 * required: Argument Email must be in valid otherwise method returns false
	 * @return Whether Error message for Invalid Email is correct or not
	 */
	
	public boolean validateInvalidEmailErrorMsg(String Email) {
		
		if(!validateEmailFormat(Email))
		{
			if(Email == "")
			{
				if(getElement(eleEmailError).getText().equals("This field is mandatory."))
					return true;
				return false;
			}
			else
				if(getElement(eleEmailError).getText().equals("Please enter a valid Email Address"))
					return true;
				return false;
				
							
							
		}
		else 
			logMessage("[ERROR]: Please Enter Invalid Email to validate error message: Method returning false as Email is Valid");
			
			return false;
		}
	
	/**
	 * @author ambar.gupta
	 * This method is used to validate error message for Invalid Phone Number
	 * @param: String Email
	 * required: Argument Phone number must be invalid otherwise method returns false
	 * @return Whether Error message for Invalid Phone Number is correct or not
	 */
	
	public boolean validateInvalidPhoneNumberErrorMsg(String phoneNumber) {
		
		if(!validatePhoneNumberFormat(phoneNumber))
		{
			if(phoneNumber == "")
			{
				if(getElement(eleEmailError).getText().equals("This field is mandatory."))
					return true;
				return false;
			}
			else
				if(getElement(elePhoneNumberError).getText().equals("Please enter a valid phone number"))
					return true;
				return false;						
							
		}
		else
			logMessage("[ERROR]:Please Enter Invalid Phone number to validate error message: Method returning false as Email is Valid");
			return false;
		}
		
	/**
	 * @author ambar.gupta
	 * This method is used to verify all mandatory fields are marked with '*'
	 * @return Whether all mandatory fields are marked with '*' or not
	 */
	
	public Map<String, String> verifyRequiredFieldsMarkedWithAsterik()
	{
		List<WebElement> requiredFields=new ArrayList<WebElement>();
		Map< String,String> hm =  new HashMap< String,String>();
		requiredFields = getElements(eleRDmandatoryFields);
		for (WebElement reqField : requiredFields)
		{
			WebElement asterikTag = reqField.findElement(eleToAppendInReqField);
			if(!asterikTag.isDisplayed())
			{
				hm.put(asterikTag.getAttribute("name"), "Asterick Absent");
				continue;
			}
			hm.put(asterikTag.getAttribute("name"), "Asterick Present");
		}
		return hm;
		
	}
	/**
	 * To verify required elements are present on Request Demo Success Page
	 * 
	 * @return True/false
	 */
	
	public boolean verifyElementsOnRequestDemoSuccessPage() 
	{
		return getElement(lblDemoRequestedSuccessfully).isDisplayed() && getElement(eleDemoReqSuccessImage).isDisplayed();
	}
	
}