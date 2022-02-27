package com.naukri.pageobjects.Applications;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import static com.naukri.test.base.BaseAutomation.driver;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.support.ui.Select;

/**
 * page Object Class comprises of all the methods required to interact with Bulk status update option on inboxes
 * @author rachit.mehrotra
 *
 */
public class BulkStatusUpdatePO extends PageObjectWrapper {
	
	//locators for application listing page
	public By bulkStatusUpdate = By.id("mulipleStatusChange");
	public By errorCheckboxMsg = By.id("errorCheckBoxMsg");
	public By numberOfApplicationOnPresentPage = By.xpath("(//input[@id = \"currentPage\"]/../div)[1]");
	public By applicationGlobalCheckbox = By.xpath("//div[@id = \"srpBulkActionsStatus\"]/preceding-sibling::input");
	public By firstCandidateName = By.xpath("(//input[@name=\"profileIds[]\"])[1]/following-sibling::strong/a");
	public By successStatusChange = By.xpath("//div[@class = \"psuccess\"]//strong");
	public By bodyOfFollowingMessage = By.xpath("//div[@class = \"psuccess\"]//span/span");
	
	//Bulk status update lightbox locators
	public By dropDownOnBulkStatusChange = By.xpath("//div[contains(@class , 'bulkStatusContainer')]//select[contains(@id , 'statusListDD')]");
	public By markAsRejectedCheckbox = By.id("isRejected");
	public By globalApplicationCountOnBulkStatusLightbox = By.xpath("//div[contains(@class , 'bulkStatusContainer')]//p");
	public By updateButtonOnLightBox = By.id("bulkStatusUpdateBtn");
	public By cancelButtonOnLightbox = By.xpath("//button[@id = \"bulkStatusUpdateBtn\"]/following-sibling::a");
	public By bulkStatusChangeWarning = By.id("statusWarn");
	public By prospectList = By.xpath("//span[text()=\"Prospect\"]");
    public By statucDD = By.cssSelector("select#statusListDD");
    private By ddlStatusOnReqInboxPage=By.xpath("//div[@class='bulkStatusContainer']//div[@id='statusListDD']//input[@type='text']");
    private By eleSelectionStage=By.xpath("//ul[@id='ul_statusListDD']//li/a[contains(.,'${stageName}')]");
    By eleProcessingOverlay = By.xpath("//div[contains(@class,\"processing-overlay\")]");
    By eleProfileSelectionCheckbox = By.xpath("(//input[@name= 'profileIds[]'])[${indexOfCheckbox}]");
	
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	
	//variables
	String firstCandidateNameValue;
	
	/**
	 * To get the specific URL of application inbox
	 * @author rachit.mehrotra
	 */
	public void getApplicationInbox() {
		//driver.get(YamlReader.getAppConfigValue("URLs.applicationInbox"));
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.applicationInbox"));
	}
	
	/**
	 * To click on bulk status update option present in inboxes
	 * @author rachit.mehrotra
	 */
	public void click_bulkStatusUpdate() {
		getElement(bulkStatusUpdate).click();
	}
	
	/**
	 * To verify the presence of error message while selecting the bulk status update option while no candidate is selected
	 * @author rachit.mehrotra
	 * @param messageToBeDisplayed
	 * @return boolean
	 */
	public boolean errorMessageOnNoCheckboxSelected(String messageToBeDisplayed) {
		return getElement(errorCheckboxMsg).getText().contains(messageToBeDisplayed);
	}
	
	/**
	 * To select a particular candidate profile basis index in inbox of that profile
	 * @author rachit.mehrotra
	 * @param index
	 */
	public void selectProfileCheckbox(int index) {
		click(parameterizedLocator(eleProfileSelectionCheckbox, Integer.toString(index)));
	}
	
	/**
	 * To select all profiles from a particular inbox
	 * @author rachit.mehrotra
	 */
	public void checkGlobalApplication() {
		click(applicationGlobalCheckbox);
	}
	
	/**
	 * To get the number of profiles displayed on a particular page for inbox
	 * @author rachit.mehrotra
	 * @return String
	 */
	public String getTextForPagination() {
		String str =  getText(numberOfApplicationOnPresentPage);
		char [] pageLength = new char[2];
		str.getChars(13, 15, pageLength, 0);
		String pageLengthString = new String(pageLength);                
		return pageLengthString;
	}
	
	/**
	 * To get the first candidate name
	 * @author rachit.mehrotra
	 */
	public void setFirstCandidateName() {
		firstCandidateNameValue = getText(firstCandidateName);
	}
	
	/**
	 * To search candidate and check the current status of candidate
	 * @author rachit.mehrotra
	 * @param statusText
	 * @return boolean
	 */
	public boolean searchCandidateAndVerifyStatus(String statusText) {
		wait.waitForInvisibilityOfElement(10, 3, eleProcessingOverlay);
		String statusOfCandidate = getText(By.xpath("(//input[@name=\"profileIds[]\"])/following-sibling::strong/a[text()=\"" + firstCandidateNameValue+"\"]/../../../..//*[@class=\" interTxt\"]"));
		return statusOfCandidate.contains(statusText);
	}
	
	public boolean displayOfStatusChangeSuccessMessage(String successMessage) {
		return (isDisplayed(successStatusChange) && isDisplayed(bodyOfFollowingMessage));
	}
	
	/**
	 * To check the success message content
	 * @author rachit.mehrotra
	 * @param successMessageFromUI
	 * @return boolean
	 */
	public boolean checkTheSuccessMessageContent(String successMessageFromUI) {
		String successMessageText = getText(successStatusChange) +" "+ getText(bodyOfFollowingMessage);                
		return successMessageText.contains(successMessageFromUI);
	}
	
	/**
	 * To chose selected candidate basis status
	 * @author rachit.mehrotra
	 */
	public void choseSelectedCandidate() {
		List<WebElement> prospectCandidate = getElements(prospectList);
		for(int i = 0 ; i < prospectCandidate.size() ; i++) {
			if(prospectCandidate.get(i+1).getText().contains("Prospect")) {
				System.out.println("(//span[@title=\"Prospect\"]/ancestor::div[contains(@class,'hiringStat cle')]/preceding-sibling::div//input)["+Integer.toString(i+1)+"]");
				click(By.xpath("(//span[@title=\"Prospect\"]/ancestor::div[contains(@class,'hiringStat cle')]/preceding-sibling::div//input)["+Integer.toString(i+1)+"]"));
				break;
			}
		}
	}
	
	/**
	 * Inner class comprises of bulk status change lightbox page object
	 * @author rachit.mehrotra
	 *
	 */
	public class BulkStatusChangeLightboxPO {
		
		/**
		 * To verify the presence of status change drop down
		 * @author rachit.mehrotra
		 * @return boolean
		 */
		public boolean visibilityOfStatusChangeDropDown() {
			return elementVisibility(dropDownOnBulkStatusChange);
		}
		
		/**
		 * To verify the presence of rejected checkbox
		 * @author rachit.mehrotra
		 * @return boolean
		 */
		public boolean visibilityOfMarkRejectedCheckbox() {
			return elementVisibility(markAsRejectedCheckbox);
		}
		
		/**
		 * To select the status from bulk status update DD basis status string
		 * @author rachit.mehrotra
		 * @param status
		 */
		public void selectStatusFromBulkStatusUpdateDropDown(String status) {
			driver.findElement(By.xpath(markAsRejectedCheckbox+"/option[text()='"+status+"']")).click();
		}
		
		/**
		 * To verify the number of applications count present on lightbox
		 * @author rachit.mehrotra
		 * @return boolean
		 */
		public boolean checkTheNumberOfApplicationCount() {
			wait.waitForVisibilityOfElement(globalApplicationCountOnBulkStatusLightbox);
			TestNGLogUtility.info(getText(globalApplicationCountOnBulkStatusLightbox));
			TestNGLogUtility.info("Recieved Count " + getText(globalApplicationCountOnBulkStatusLightbox));
			return getText(globalApplicationCountOnBulkStatusLightbox).contains(getTextForPagination());
		}
		
		/**
		 * To click on mark as Rejected checkbox
		 * @author rachit.mehrotra
		 */
		public void checkMarkRejectedCheckbox() {
			click(markAsRejectedCheckbox);
			TestNGLogUtility.info("Reject checkbox is " + getElement(markAsRejectedCheckbox).isSelected());
		}
		
		/**
		 * To click on update button layout
		 * @author rachit.mehrotra
		 */
		public void clickUpdateButtonOnLayout() {
			TestNGLogUtility.info("clicked on update button");
			click(updateButtonOnLightBox);
			wait.hardWait(1);
		}
		
		/**
		 * To select status from DD basis statusText
		 * 
		 * @author rachit.mehrotra
		 * @param statusText
		 */
		public void selectStatusFromDropDownMenu(String statusText) {
			if (isDisplayed(ddlStatusOnReqInboxPage)) {
				click(ddlStatusOnReqInboxPage);
				click(parameterizedLocator(eleSelectionStage, statusText));
			} else {
				Select dd = new Select(getElement(statucDD));
				dd.selectByVisibleText(statusText);
			}
			TestNGLogUtility.info("User clicked on staus DD");
		}

		/**
		 * To click cancel button on lightbox
		 * @author rachit.mehrotra
		 */
		public void clickCancelButtonOnLightbox() {
			click(cancelButtonOnLightbox);
		}
		
		/**
		 * To verify the text of warning message on bulk status update lightbox
		 * @author rachit.mehrotra
		 * @param warningMessageFromUI
		 * @return boolean
		 */
		public boolean warningTextGeneratedOnMultipleRequirements(String warningMessageFromUI) {
			return getText(bulkStatusChangeWarning).contains(warningMessageFromUI);
		}
	}
}
