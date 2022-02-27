package com.naukri.pageobjects.Offer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementRect;
import org.testng.internal.YamlParser;

import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;

import net.bytebuddy.implementation.bytecode.Throw;

/**
 * Page Object class consists of page objects used for Offer Permission
 * 
 * @author rachit.mehrotra
 *
 */
/**
 * @author udit.khanna
 *
 */
public class OfferPermissionPagePO extends BaseAutomation {

	// manage subuser locators
	public By manageSubRecruiters = By.xpath("//a[text()=\"Manage Recruiters\"]");
	public By manageSubUsers = By.xpath("//a[text()=\"Manage Sub Users\"]");
	public By recruiterSearchBox = By.id("quickSearchRecruiter");
	public By recruiterSearchIcon = By.id("quickSearchSumit");
	public By managePermissionForTheSearchedSubrecruiter = By
			.xpath("//span[text()=\"enterprise_subuser1@naukri.com  \"]/../../../..//a[text()=\"Manage Permissions\"]");
	public By subUserSearchBox = By.id("quickSearchRecruiter");
	public By searchButton = By.id("quickSearchSumit");
	public By setButtonOnPermissionsLayout = By.xpath("//form[@id = \"recruiterPermForm\"]//input[@value=\"Set\"]");

	// application inbox locator
	public By offerLetterCluster = By.id("//a/span[contains(text(),\"Offer Letter Status\")]");
	public By ddlStatusOnStatusChangeDropdown = By.xpath("//div[@id='itm']//a[contains(text(),'Offer')]/span");

	// CV details page locators
	public By statusChangeDropDownMenu = By.xpath("//a[text() = \" Reject \"]/..//span[@class = \" outerArow\"]");
	public By offerStatusOptions = By.xpath("//li[@class = \"isOfferStage\"]");
	public By rejectButton = By.xpath("//a[text()=' Reject ']");

	// Customize the Selection Process page locators
	public By offerStageSelectionStage = By.xpath("//div[contains(text(), 'Offer')]");
	public By btnAddSubStageForOfferStage = By
			.xpath("//ul[@data-state='_OFFERS_AND_JOINING']//a[contains(@class, 'addNewSubStage')]");
	public By txtAddASubStageOffer = By.id("lablSubStg");
	public By btnSaveSubStageOffer = By.id("saveStage");
	public By newSubStage = By.xpath("//label[text()='" + subStageOffer + "']");
	public By newSubStageDeleteIcon = By
			.xpath("//label[text()=\"" + subStageOffer + "\"]/parent::li//a[@class='delLi']");
	public By offerSubStageList = By.xpath("//ul[@data-state='_OFFERS_AND_JOINING']//li[@class='mt5 oh']");
	public By offerSecondStageSelectionStage = By.xpath("//li[@key='1']//input[@value='TRUE']");
	public By offerFirstStageSelectionStage = By.xpath("//li[@key='0']//input[@value='FALSE']");
	
	// All Application page locators
	public By firstCandidateCheckBox = By.xpath("(//input[@name='profileIds[]'])[1]");
	public By changeStatusLink = By.id("mulipleStatusChange");
	public By ddlStatusOnUpdateStatusPopUp = By.xpath("//select[@id='statusListDD']/option[contains(text(),'Offer')]");
	public By eleOfferPermission = By.xpath("(//li/div/div[contains(text(),'${string}')])[1]");

	// variables
	public static String subusername = YamlReader.getAppConfigValue("Users.Enterprise.Subuser.username");
	private static final String offerStageDisableMsg = "You do not have permissions to change status of this candidate.";
	public static String subStageOffer = "";

	/**
	 * To click on offer permissions based on subscription
	 * 
	 * @author rachit.mehrotra
	 * @param subscriptionType
	 */
	public void clickOnManagePermissions(String subscriptionType) {
		switch (subscriptionType) {
		case "Consultant":
			click(manageSubUsers);
			break;
		case "Enterprise":
			click(manageSubRecruiters);
			break;
		}
	}

	/**
	 * To click manage offer permissions for a subuser basis index
	 * 
	 * @author rachit.mehrotra
	 * @param index
	 */
	public void clickOnManagePermissionForASubuser(int index) {
		StringBuilder xpathBuilder = new StringBuilder();
		xpathBuilder.append("(//a[text()=\"Manage Permissions\"])[");
		xpathBuilder.append(Integer.toString(index));
		xpathBuilder.append("]");
		click(By.xpath(xpathBuilder.toString()));
	}

	/**
	 * To verify the presence of offer permission for a particular user
	 * 
	 * @author rachit.mehrotra
	 * @param offerPermissionName
	 * @return boolean
	 */
	public boolean checkForPresenceOfOfferPermission(String offerPermissionName) {
		wait.waitForVisibilityOfElement(parameterizedLocator(eleOfferPermission, offerPermissionName));
		return getElement(eleOfferPermission, offerPermissionName).isDisplayed();
//		return isDisplayed(By.xpath("(//li/div/div[contains(text(),\"" + offerPermissionName + "\")])[1]"));
	}

	/**
	 * To search recruiter from a list
	 * 
	 * @author rachit.mehrotra
	 */
	public void searchRecruiter() {
		sendKeys(subUserSearchBox, subusername);
		click(searchButton);
	}

	/**
	 * To click manage permissions for a particular user
	 * 
	 * @author rachit.mehrotra
	 * @param username
	 */
	public void clickManagePermissionsToSpecificUser(String username) {
		click(By.xpath("//span[text() = \"" + username + "\"]/../../../..//li/a[text()=\"Manage Permissions\"]"));
	}

	/**
	 * To change status of offer permission basis permission name and status of
	 * permission
	 * 
	 * @param permissionName
	 * @param statusOfPermission
	 */
	public void changeStatusOfUserPermission(String permissionName, String statusOfPermission) {
		String permissionNameXpath = "//form[@name='recruiterPermForm']//div[contains(text(),\"" + permissionName
				+ "\")]/../preceding-sibling::a/input";
		String presentStatusOfPermission = getAttribute(
		 By.xpath("(//div[contains(text(),\"" + permissionName + "\")]/../preceding-sibling::a/input)[1]"), 
		 "value");
		if (!presentStatusOfPermission.equalsIgnoreCase(statusOfPermission)) {
			 jsUtil.clickByJS(
			By.xpath("(//div[contains(text(),\"" + permissionName +"\")]/../preceding-sibling::a/input)[1]"));
		}
		if (getAttribute(By.xpath(permissionNameXpath), "value").equalsIgnoreCase(statusOfPermission))
			click(setButtonOnPermissionsLayout);
		
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To verify the presence of offer letter clutter on facets in inboxes
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean offerLetterClusterVisibility() {
		return isDisplayed(offerLetterCluster);
	}

	/**
	 * To change the status
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickChangeStatusOuterArrow() {
		click(statusChangeDropDownMenu);
	}

	/**
	 * To verify offer status stages disabled for a non permitted user
	 * 
	 * @author udit.khanna
	 * @return
	 */
	public boolean checkOfferStatusTitle() {
		String titleOfOfferStatus = "You do not have permissions to change status of this candidate.";
		List<WebElement> offerList = getElements(offerStatusOptions);
		for (int i = 1; i <= offerList.size(); i++) {
			StringBuilder offerListCandidate = new StringBuilder();
			offerListCandidate.append("(");
			offerListCandidate.append(offerStatusOptions.toString());
			offerListCandidate.append(")[");
			offerListCandidate.append(Integer.toString(i));
			offerListCandidate.append("]");
			jsUtil.scrollDown(By.xpath(offerListCandidate.toString()));
			if (!getAttribute(By.xpath(offerListCandidate.toString()), "title").equalsIgnoreCase(titleOfOfferStatus)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * scroll Down to offer permission text
	 * 
	 * @author rachit.mehrotra
	 * @param offerPermissionText
	 */
	public void scrollDownToOfferPermissionText(String offerPermissionText) {
		jsUtil.scrollDown(By.xpath("(//li/div/div[contains(text(),\"" + offerPermissionText + "\")])[1]"));
	}

	/**
	 * Check if Offer Stage is disabled
	 * 
	 * @author udit.khanna
	 * @return true, if offer stage disabled
	 */
	public boolean checkOfferStageIsDisabled() {
		// if Candidate not in Offer Stage then check Offer Round message
		if (offerStageDisableMsg.contains(getAttribute(offerStatusOptions, "title"))) {
			System.out.println("Not in offer: " + getAttribute(offerStatusOptions, "title"));
			return offerStageDisableMsg.contains(getAttribute(offerStatusOptions, "title"));
		}
		// If Candidate already in Offer Stage then check msg in Reject Button
		else if (offerStageDisableMsg.contains(getAttribute(rejectButton, "title"))) {
			System.out.println("Already in offer: " + getAttribute(rejectButton, "title"));
			return offerStageDisableMsg.contains(getAttribute(rejectButton, "title"));
		} else {
			return false;
		}

	}

	/**
	 * Add sub-stage to Offer Round
	 * 
	 * @param subStage
	 * @author udit.khanna
	 */
	public void addSubStageToOfferRound(String subStage) {
		click(offerStageSelectionStage);
		jsUtil.scrollDown(btnAddSubStageForOfferStage);
		click(btnAddSubStageForOfferStage);
		subStageOffer = subStage;
		sendKeys(txtAddASubStageOffer, subStage);
		click(btnSaveSubStageOffer);
	}

	/**
	 * Checks the checkbox of the first candidate
	 * 
	 * @author udit.khanna
	 */
	public void checkFirstCandidateCheckbox() {
		click(firstCandidateCheckBox);
	}

	/**
	 * Click Change Status button for seslected candidate
	 * 
	 * @author udit.khanna
	 */
	public void clickChangeStatus() {
		click(changeStatusLink);
	}

	/**
	 * Checks if new sub-stage is present in Offer Stage In Update Status Dropdown
	 * 
	 * @return true If sub-stage present
	 * @author udit.khanna
	 */
	public boolean checkNewSubStageInUpdateStatusDropdown() {
		boolean flag = false;
		for (WebElement element : getElements(ddlStatusOnUpdateStatusPopUp)) {
			if (element.getText().contains(subStageOffer)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * Delete added sub-stage to Offer Round
	 * 
	 * @author udit.khanna
	 */
	public void deleteSubStageFromOfferRound() {
		click(offerStageSelectionStage);
		int numSubStagesOffer = getElements(offerSubStageList).size();
		// Display delete icon for last added stage
		String jsCommandDisplayDeleteIconAndClick = "document.querySelectorAll('.open li')[" + (numSubStagesOffer - 1)
				+ "].querySelector('.btnGp').classList.remove('dn');";
		jsUtil.executeJavascript(jsCommandDisplayDeleteIconAndClick);
		click(By.xpath("//label[text()=\"" + subStageOffer + "\"]/parent::li//a[@class='delLi']"));
	}

	/**
	 * Checks if new sub-stage is present in Offer Stage In Status Change Drop down
	 * 
	 * @return true If sub-stage present
	 * @author udit.khanna
	 */
	public boolean checkNewSubStageInStatusChangeDropdown() {
		boolean flag = false;
		for (WebElement element : getElements(ddlStatusOnStatusChangeDropdown)) {
			if (element.getText().contains(subStageOffer)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	/**click on offer stage on customize selection stage 
	 * 	
	 */
	public void clickOnOfferStageOnSettingsPage()
	{
		click(offerStageSelectionStage);
	}
	/**uncheck Second Stage Of Offer on selection stage 
	 * 
	 */
	public void uncheckSecondStageOnOffer()
	{
		if(elementVisibility(offerSecondStageSelectionStage))
		click(offerSecondStageSelectionStage);
	}
	/**check first stage on offer selection stages
	 * 
	 */
	public void checkFirstStageOnOfferSelectionStages()
	{
		if(elementVisibility(offerFirstStageSelectionStage))
			click(offerFirstStageSelectionStage);
	}
	
	/**
	 * To verify the absence of offer permission for a particular user
	 * 
	 * @param offerPermissionName
	 * @return true if permission is not displayed
	 */
	public boolean checkForAbsenceOfOfferPermission(String offerPermissionName) {
		return (!isDisplayed(parameterizedLocator(eleOfferPermission, offerPermissionName)));
	}
}
