package com.naukri.pageobjects.Vendor;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import com.naukri.automation.util.PropFileHandler;
import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VendorRequirementOverviewAction extends BaseAutomation {

	public  By clickOnAssign = By.xpath("//button[text()='ASSIGN']");
	public  By unassignYes = By.id("changeUserStatus");
	public  By update =By.xpath("//button[@class='save blockBtn']");
	public  By messageBox = By.xpath("//textarea[@class='vmsgBox']");
	public  By clientMessage = By.xpath("//div[text()='First message to vendor']");
	public  By btnEditassignment=By.xpath("//span[contains(text(),'${vendorName}')]//following::span[contains(text(),'Edit Assignment Details')]");
	public  By btnUnassign=By.xpath("//span[contains(text(),'${vendorName}')]//following::span[contains(text(),'Unassign')]");
	public  By btnSendReminder=By.xpath("//span[contains(text(),'${vendorname}')]//following::a[contains(text(),'Send Reminder')]");
	public  By messages = By.xpath("//span[contains(text(),'${vendorname}')]//following::span[contains(text(),'Messages')]");
	public  By reassign = By.xpath("//span[contains(text(),'${vendorName}')]//following::span[text()='Re-assign']");
	public  By btnSend=By.id("emailVendor");
	public  By chipList=By.xpath("//div[contains(@class,'viewContainer')]//following::div[@class='vChip']");
	public  By eleSelectedVendor=By.xpath("//div[@class='vendorCount']");
	public  By iconCross=By.xpath("//span[@id='vendorSuccess']//preceding::a[@class='msgClose pt5']");
	public  By searchHere = By.xpath("//input[@placeholder='Search here']");
	public  By eleVendorSubmissionVendor = By.xpath("//div[contains(text(),'${vendorname}')]");
	public  By textInstructionArea=By.xpath("//textarea[contains(@class,'instruction mb20')]");
	public  By checkboxAttachQuestionnaire=By.xpath("//input[@id='qa']//following::label[1]");
	public  By icondrop=By.xpath("//span[contains(@class,'icon')]");
	public  By listQuestionnaire=By.xpath("//div[@id='assignVendor']//li[2]");
	public  By messageSuccess=By.xpath("//div[@class='psuccess']//following::span");
	public  By textMaxCv = By.xpath("//input[@placeholder='Add CV submission limit']");
	public static By btnAddNewVendor = By.xpath("//a[text()='${addnewvendor}']");
	List<WebElement> listChipOfVendor;

	/**
	 * This method is use to send the message to client
	 * @param vendorname
	 * @author avani
	 */
	public void sentMessage(String vendorname) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(messages,vendorname));
		sendKeys(messageBox,"First message to vendor");
	}
	/**
	 * This method is use to verify whether message sent to client is displayed or not
 	 * @return yes if displayed
      * @author avani
	 */

	public boolean messageVerification() {
		return(isDisplayed(clientMessage));
	}
	/**
	 * This method is use to click on unassign button when needed to unassign the already assigned requirement to vendor
	 * @param vendorname
	 * @author avani
	 */
	public void clickUnassign(String vendorname) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnUnassign,vendorname));
	}
	/**
	 * This method is use to click on yes button when needed to unassign the already assigned requirement to vendor
	 * @author avani
	 */
	public void clickYesUnassign() {
		getElement(unassignYes).click();
	}
	/**
	 * This method is use to click on ressign button when needed to reassign  requirement to vendor
	 * @param vendorname
	 * @author avani
	 */
	public void clickReassign(String vendorname) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(reassign,vendorname));
	}
	/**
	 * This method is use to click on verify whether the requirement has been reassigned or not
	 * @param vendorname
	 * @author avani
	 * @return true if reassugn displayed
	 */
	public boolean verifyReassign(String vendorname) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		return (isDisplayed(parameterizedLocator(reassign,vendorname)));
	}

	/**
	 * This method is use to click on assign requirement
	 * @author avani
	 */
	public void clickOnAssign() {
		getElement(clickOnAssign).click();
		wait.waitForPageToLoadCompletely();
		pageRefresh();
		wait.waitForPageToLoadCompletely();
	}
	/**
	 * This method is use to edit assigment details
	 * @param vendorname
	 * @author avani
	 */
	public void clickEditAssignment(String vendorname){
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnEditassignment,vendorname));
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is use to send Reminder to Vendor
	 * @param vendorname
	 * @author avani
	 */
	public void sendReminder(String vendorname){
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnSendReminder,vendorname));
	}
	/**
	 * This method is use to provide Cv number while assigning vendor to the requirement
	 * @param cvNumber
	 * @author avani
	 */

	public void addMaxCv(String cvNumber){
		sendKeys(textMaxCv,cvNumber);
	}

	/**
	 * This method is use to select and perform on Multiple actions available for vendor on Requirement Overview page
	 * @param optionname,vendorname
	 * @author avani
	 */

	public void vendorOptions(String optionname,String vendorname){
		wait.waitForPageToLoadCompletely();
		switch (optionname) {
			case "Edit Assignment Details":
				clickEditAssignment(vendorname);
				break;
			case "Unassign":
				clickUnassign(vendorname);
				clickYesUnassign();
				break;
			case "Reassign":
				clickReassign(vendorname);
				break;
			case "Send Reminder":
				sendReminder(vendorname);
				break;
			case "Message":
				sentMessage(vendorname);
				break;

		}}

	/**
	 * This method is use click on send button in send reminder confirmation box
	 * @author avani
	 */
	public void clickSendButton(){
		click(btnSend);}

	/**
	 * This method is use to click on select Vendor while assigning requirement to Vendor
	 * @param listOfVendorsToBeSelected
	 * @author avani
	 */
	public void assignMultipleVendor(List<String> listOfVendorsToBeSelected){
		for(int i=0;i<listOfVendorsToBeSelected.size();i++){
			String vendor=(listOfVendorsToBeSelected.get(i).toString());
			sendKeys(searchHere,vendor);
			click(parameterizedLocator(eleVendorSubmissionVendor,vendor));}
	}
	/**
	 * This method is use to add MaxCV,Questionnaire,Instructions while assigning requirement to Vendor
	 * @author avani
	 */
	public void addVendorDetails() {
		click(checkboxAttachQuestionnaire);
		click(icondrop);
		click(listQuestionnaire);
		sendKeys(textInstructionArea,"instructions");
	}
	/**
	 * This method is use to verify success message appears on Requirement overview page when vendor is added
	 * @author avani
	 */
	public boolean verifySuccessMessage(){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(messageSuccess, PropFileHandler.readProperty("VendorAddedSuccessMessage"))));
	}

	/**
	 * This method is use to verify the no of selected no is equal to the displayed in chiplist and  displayed on closed DD as Selected Vendor(no of vendor)
	 * @author avani
	 */
	public boolean verifySelectedVendor(){
		listChipOfVendor=getElements(chipList);
		return(("Selected Vendor ("+listChipOfVendor.size()+")").equalsIgnoreCase(getText(eleSelectedVendor)));
	}

	/**
	 * This method is use to verify selected vendor name should be same as in the chip list
	 * @author avani
	 */
	public boolean verifySelectedVendorName(List<String>listOfVendorsToBeSelected){
		return(listOfVendorsToBeSelected.containsAll(listChipOfVendor));
	}
	/**
	 * This method is use to click on cross icon on the message success strip
	 * @author avani
	 */

	public void clickOnCrossIconOnTheMessageSuccessStrip(){
		wait.waitForPageToLoadCompletely();
		click(iconCross);
	}
	/**
	 * This method use to click on assign vendor button on requirment overview page
	 * @param assignvendor
	 * @author avani
	 */
	public void clickOnAssignVendorOnRequirementOverviewPage(String assignvendor) {
		click(parameterizedLocator(btnAddNewVendor,assignvendor));
		wait.waitForPageToLoadCompletely();
	}

}
