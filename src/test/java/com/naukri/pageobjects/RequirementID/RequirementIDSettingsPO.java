package com.naukri.pageobjects.RequirementID;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.test.base.PageObjectWrapper;

public class RequirementIDSettingsPO extends PageObjectWrapper {
	private By eleManageRequirementPageTitle = By.xpath("//div[@class='tabHeadTitle']");
	private By eleManageRequirementPageSubTitle = By.xpath("//div[@class='tabHeadSubtitle']");
	private By btnToBeClicked = By.xpath("//button[text()='${string}']");
	private By eleSettingsonPage = By.xpath("//a[text()='${string}']");
	private By eleComponentsOnManageRequirementIDPage = By.xpath("//span[@class=\"dd-label\"]");
	private By eleDDonReqID = By.xpath("//input[@id='${string}']//following-sibling::span");
	private By eleOptionsInDD = By.xpath("//ul[@class=\"dropdown \"]/li");
	private By eleCompanyNameField = By.id("companyName");
	private By btnSaveOnWhiteLabelSettings = By.id("saveSettings");
	private By eleSampleRequirementID = By.xpath("//span[@class=\"rqmt-id-format\"]//span[@class=\"sample-id\"]");
	private By eleReviewGrpLinkOnRequirementIDSettingsPage = By.xpath("//span[@class=\"review-grp-btn \"]");
	private By eleFirstGrpInitials = By.xpath("(//div[@class=\"grp-details \"]//input[@class=\"grp-init-inp \"])[1]");
	private By lblCustomiseYourId = By.xpath("//span[text()='Customise your ID']");
	private By eleTextFieldForComponent = By.xpath("//span[text()='${String}']//parent::div//following-sibling::input");
	private By eleValidationMsgOnRedIdPage = By.xpath("//div[@class=\"cstmErr\"]");
	private By eleResetCheckbox = By.xpath("//input[@id=\"resetCounter\"]//following-sibling::label");
	private By eleSampleRequisitionID = By.xpath("//span[@class=\"rqs-id-format\"]//span[@class=\"sample-id\"]");
	private By btnOnReqIdPage = By.xpath("//button[contains(text(),'${string}')]");
	private By eleSnackBarOnSettings = By.xpath("//div[@class=\"snackbar--msg__content\"]");
	private By eleCancelConfirmationBox = By.xpath("//div[@class=\"confHead\"]");
	private By eleMsgOnReqIdPage = By.xpath("//div[@class=\"msg\"]");
	private By eleGroupInitials = By.xpath("//input[starts-with(@class,\"grp-init-inp\")]");
	private By eleLightBoxText = By.xpath("//div[text()='${string}']");
	private By eleFirstGroupInitials = By.xpath("(//input[starts-with(@class,\"grp-init-inp\")])[2]");
	private By eleDefaultGroupInitials = By.xpath("(//input[starts-with(@class,\"grp-init-inp\")])[1]");
	private By eleMsgOnGrpInitialsLightBox = By.xpath("//div[text()='${string}']");
	private By eleRequirementCreationFromRequisitionSuccessMsg = By.xpath("//span[@title='Requisition Name']");
	private By eleRequirementCreationSuccessMsg = By.xpath("//span[contains(text(), \" The Requirement '\")]/span");
	private By eleRequirementIdOnCVDetails = By.xpath("//a[starts-with(@title, 'Requirement Name')]/span");
	By eleTopRequisitionId = By.xpath("(//div[contains(@class,'reqIDSec')])[1]");
	private By txtTopRequisitionName = By.xpath("(//div[contains(@class,'process')])[1]");

	// Class objects
	GenericFunctions genericFunctions = new GenericFunctions();

	/**
	 * file System Path till testdata folder
	 * 
	 * @return path till testdata
	 */
	public static String fileSystemPathTillTestData() {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator;
		return filePath;
	}

	/**
	 * verify Manage Requirement Page Heading
	 * 
	 * @param pageTitleTxt
	 * 
	 * @return true if page title matches
	 */
	public boolean verifyManageRequirementPageHeading(String pageTitleTxt) {
		return getText(eleManageRequirementPageTitle).equalsIgnoreCase(pageTitleTxt);
	}

	/**
	 * verify Manage Requirement Page Sub-Heading
	 * 
	 * @param pageSubTitleTxt
	 * 
	 * @return true if page sub title matches
	 */
	public boolean verifyManageRequirementPageSubHeading(String pageSubTitleTxt) {
		return getText(eleManageRequirementPageSubTitle).equalsIgnoreCase(pageSubTitleTxt);
	}

	/**
	 * click Btn using text
	 * 
	 * @param btnTxt
	 */
	public void clickBtn(String btnTxt) {
		click(parameterizedLocator(btnToBeClicked, btnTxt));
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * Verify settings present on the page
	 * 
	 * @param settingsText
	 * @return true if settings are present
	 */
	public boolean verifySettingsVisibility(String settingsText) {
		return isDisplayed(parameterizedLocator(eleSettingsonPage, settingsText));
	}

	/**
	 * verify Components On Manage Requirement ID Page
	 * 
	 * @param list
	 * @return true if lists match
	 */
	public boolean verifyComponentsOnManageRequirementIDPage(List<String> list) {
		List<WebElement> actualList = getElements(eleComponentsOnManageRequirementIDPage);
		List<String> actualListText = new ArrayList<String>();
		for (WebElement ele : actualList) {
			actualListText.add(ele.getText());
		}
		return list.equals(actualListText);
	}

	/**
	 * click on DD based on text entered
	 * 
	 * @param ddTxt
	 */
	public void clickDDonReqIDPage(String ddTxt) {
		String idForDD = "";
		if (ddTxt.equalsIgnoreCase("Text Component")) {
			idForDD = "textComp";
		} else if (ddTxt.equalsIgnoreCase("Year Component")) {
			idForDD = "yearComp";
		} else if (ddTxt.equalsIgnoreCase("Numeric Component")) {
			idForDD = "numericComp";
		} else
			idForDD = null;

		click(parameterizedLocator(eleDDonReqID, idForDD));
	}

	/**
	 * verify options present in any DD
	 * 
	 * @param list
	 *            values expected
	 * @return true if actual list equals expected list
	 */
	public boolean verifyOptionsInDD(List<String> list) {
		List<WebElement> actualList = getElements(eleOptionsInDD);
		List<String> actualListText = new ArrayList<String>();
		for (WebElement ele : actualList) {
			actualListText.add(ele.getText());
		}
		return list.equals(actualListText);
	}

	/**
	 * enter Text In Company Name
	 * 
	 * @param companyNameTxt
	 */
	public void enterTxtInCompanyName(String companyNameTxt) {
		sendKeys(eleCompanyNameField, companyNameTxt);
	}

	/**
	 * click Save Btn On White Label Settings
	 */
	public void clickSaveBtnOnWhiteLabelSettings() {
		click(btnSaveOnWhiteLabelSettings);
	}

	/**
	 * click On Value From DD
	 * 
	 * @param ddTxt
	 */
	public void clickOnValueFromDD(String ddTxt) {
		List<WebElement> listElements = getElements(eleOptionsInDD);
		for (WebElement element : listElements) {
			if (element.getText().equalsIgnoreCase(ddTxt)) {
				element.click();
				break;
			}
		}
	}

	// /**
	// * verify Str In Sample Req ID
	// *
	// * @param str
	// * @return true if Sample ID contains text
	// */
	// public boolean verifyStrInSampleReqID(String str) {
	// return getText(eleSampleRequirementID).contains(str);
	// }

	/**
	 * verify Link text On Requirement ID Settings Page
	 * 
	 * @param linkTxt
	 * @return true if text matches
	 */
	public boolean verifyLinkOnRequirementIDSettingsPage(String linkTxt) {
		return getText(eleReviewGrpLinkOnRequirementIDSettingsPage).equalsIgnoreCase(linkTxt);
	}

	/**
	 * click Review Group Name Initials Link
	 */
	public void clickReviewGroupNameInitialsLink() {
		click(eleReviewGrpLinkOnRequirementIDSettingsPage);
	}

	/**
	 * edit Grp Initials Of First Grp
	 * 
	 * @param string
	 *            to be set as group initial
	 */
	public void editGrpInitialsOfFirstGrp(String string) {
		sendKeys(eleFirstGrpInitials, string);
	}

	/**
	 * verify Group Initials Pop Up has Closed
	 * 
	 * @return true if popup gets closed
	 */
	public boolean verifyGroupInitialsPopUpClosed() {
		return isDisplayed(lblCustomiseYourId);
	}

	/**
	 * verify Text field Is Displayed On Req Id Page
	 * 
	 * @param componentStr
	 * @return true id text field is present
	 */
	public boolean verifyTextfieldIsDisplayedOnReqIdPage(String componentStr) {
		return isDisplayed(parameterizedLocator(eleTextFieldForComponent, componentStr));
	}

	/**
	 * verify Validation Msg For Txt Field On Req Id Page
	 * 
	 * @param validationMsg
	 * @return true if msg matches
	 */
	public boolean verifyValidationMsgForTxtFieldOnReqIdPage(String validationMsg) {
		wait.waitForElementToBeClickable(eleValidationMsgOnRedIdPage);
		return getText(eleValidationMsgOnRedIdPage).contains(validationMsg);
	}

	/**
	 * enter Char In Text Field In Req ID
	 * 
	 * @param strToBeEntered
	 * @param txtField
	 *            for which txt to be entered
	 */
	public void enterCharInTextFieldInReqID(String strToBeEntered, String txtField) {
		sendKeys(parameterizedLocator(eleTextFieldForComponent, txtField), strToBeEntered);
	}

	/**
	 * verify Sample Id Has Txt Entered In Txt Field
	 * 
	 * @param componentTxt
	 * @return true if sample ID has text entered
	 */
	public boolean verifySampleIdHasTxtEnteredInTxtField(String componentTxt) {
		String strEntered = getElement(parameterizedLocator(eleTextFieldForComponent, componentTxt))
				.getAttribute("value");
		return getText(eleSampleRequirementID).contains(strEntered);
	}

	/**
	 * verify Sample Id Not Have Component
	 * 
	 * @param componentTxt
	 * @return true if Sample ID does not contain component
	 */
	public boolean verifySampleIdNotHaveComponent(String componentTxt) {
		if (componentTxt.equals("Text Component")) {
			String[] sampleId = getText(eleSampleRequirementID).split("-");
			return sampleId.length == 2;
		} else if (componentTxt.equals("Year Component")) {
			String[] sampleId = getText(eleSampleRequirementID).split("-");
			return !(sampleId[1].contains("y"));
		} else
			return false;
	}

	/**
	 * verify Checkbox Txt On Req ID Page
	 * 
	 * @param list
	 *            of texts to be matched
	 * @return true if texts match
	 */
	public boolean verifyCheckboxTxtOnReqIDPage(List<String> list) {
		boolean flag = true;
		for (String str : list) {
			flag = flag & getText(eleResetCheckbox).contains(str);
		}
		return flag;
	}

	/**
	 * verify Sub Component text In Sample Id
	 * 
	 * @param component
	 * @param subComponent
	 * @return true is sub component text present
	 */
	public boolean verifySubComponentInSampleId(String component, String subComponent) {
		String[] sampleId = getText(eleSampleRequirementID).split("-");
		if (component.equals("Text Component")) {
			return sampleId[0].contains(subComponent);
		} else if (component.equals("Year Component")) {
			if (subComponent.contains("Calendar Year")) {
				int currentYear = genericFunctions.getCurrentYear() - 2000;
				return sampleId[1].contains("y" + currentYear);
			} else if (subComponent.contains("Financial Year")) {
				int currentYear = genericFunctions.getCurrentYear() - 2000 + 1;
				return sampleId[1].contains("fy" + currentYear);
			}
		} else if (component.equals("Numeric Component")) {
			if (subComponent.contains("Start From 001")) {
				return sampleId[2].contains("001");
			} else if (subComponent.contains("Custom Number")) {
				String valueInNumericComponent = getAttribute(
						parameterizedLocator(eleTextFieldForComponent, "Numeric Component"), "value");
				return sampleId[2].contains(valueInNumericComponent);
			}
		}
		return false;
	}

	/**
	 * verify Sample Requirement Id
	 * 
	 * @param list
	 * @return true if all components are displayed in Sample Requirement ID
	 */
	public boolean verifySampleRequirementId(List<String> list) {
		String[] sampleId = getText(eleSampleRequirementID).split("-");
		int currentYear = genericFunctions.getCurrentYear() - 2000;
		String valueInNumericComponent = getAttribute(
				parameterizedLocator(eleTextFieldForComponent, "Numeric Component"), "value");
		return (sampleId[0].contains(list.get(0)) & sampleId[1].contains(list.get(1) + currentYear)
				& sampleId[2].contains(valueInNumericComponent));
	}

	/**
	 * verify Sample Requisition Id
	 * 
	 * @param list
	 * @return true if all components are displayed in Sample Requisition ID
	 */
	public boolean verifySampleRequisitionId(List<String> list) {
		String[] sampleId = getText(eleSampleRequisitionID).split("-");
		int currentYear = genericFunctions.getCurrentYear() - 2000;
		String valueInNumericComponent = getAttribute(
				parameterizedLocator(eleTextFieldForComponent, "Numeric Component"), "value");
		return (sampleId[1].contains(list.get(0)) & sampleId[2].contains(list.get(1) + currentYear)
				& sampleId[3].contains(valueInNumericComponent));
	}

	/**
	 * verify Button On Requirement Id
	 * 
	 * @param list
	 * @return true if buttons are visible on Requirement ID page
	 */
	public boolean verifyButtonOnRequirementId(List<String> list) {
		boolean flag = true;
		for (String str : list) {
			flag = flag & isDisplayed(btnOnReqIdPage, str);
		}
		return flag;
	}

	/**
	 * save Sample Requirement N Requisition Id To Properties File
	 */
	public void saveSampleRequirementNRequisitionIdToPropertiesFile() {
		wait.hardWait(2);
		ReadWritePropertyFile.setProperty("RequirementTrackingId", getText(eleSampleRequirementID),
				fileSystemPathTillTestData() + "Data.properties");
		ReadWritePropertyFile.setProperty("RequisitionTrackingId", getText(eleSampleRequisitionID),
				fileSystemPathTillTestData() + "Data.properties");
	}

	/**
	 * verify Same Sample Ids as in Data.properties
	 * 
	 * @return true if Sample Ids match
	 */
	public boolean verifySameSampleIds() {
		return (getText(eleSampleRequirementID).equals(ReadWritePropertyFile.getProperty("RequirementTrackingId",
				fileSystemPathTillTestData() + "Data.properties")))
				& (getText(eleSampleRequisitionID).equals(ReadWritePropertyFile.getProperty("RequisitionTrackingId",
						fileSystemPathTillTestData() + "Data.properties")));
	}

	/**
	 * verify Msg On Snack Bar On Settings Page
	 * 
	 * @return true if msg matches
	 */
	public boolean verifyMsgOnSnackBarOnSettingsPage(String msgOnSnackBar) {
		return getText(eleSnackBarOnSettings).contains(msgOnSnackBar);
	}

	/**
	 * verify if Cancel Confirmation Box Is Displayed
	 * 
	 * @return true if box is displayed
	 */
	public boolean verifyCancelConfirmationBoxIsDisplayed() {
		return isDisplayed(eleCancelConfirmationBox);
	}

	/**
	 * verify User Directed To Page
	 * 
	 * @param URL
	 *            to be directed
	 * @return true if URL user is directed matches param URL
	 */
	public boolean verifyUserDirectedToPage(String url) {
		return getCurrentURL().contains(url);
	}

	/**
	 * verify Msg On Req Id Page
	 * 
	 * @param msg
	 *            to be validated
	 * @return true if msg is displayed
	 */
	public boolean verifyMsgOnReqIdPage(String msg) {
		return getText(eleMsgOnReqIdPage).equalsIgnoreCase(msg);
	}

	/**
	 * make First Two Group Initials Same
	 */
	public void makeFirstTwoGroupInitialsSame() {
		List<WebElement> list = getElements(eleGroupInitials);
		for (int i = 1; i < list.size() & i <= 2; i++) {
			list.get(i).clear();
			list.get(i).sendKeys("grou");
		}
	}

	/**
	 * verify Light Box On Req Id Page
	 * 
	 * @param lightBoxText
	 * @return true if light box opened
	 */
	public boolean verifyLightBoxOnReqIdPage(String lightBoxText) {
		return isDisplayed(parameterizedLocator(eleLightBoxText, lightBoxText));
	}

	/**
	 * clear Default Group Initials
	 */
	public void clearDefaultGroupInitials() {
		hardClear(eleDefaultGroupInitials);
	}

	/**
	 * set Default Group Initials
	 */
	public void setDefaultGroupInitials() {
		sendKeys(eleDefaultGroupInitials, GenericFunctions.generateRandomStrings(5, "Alphanumeric"));
	}

	/**
	 * set Same Group Initials As Default Group Initials
	 */
	public void setSameGroupInitialsAsDefaultGroupInitials() {
		sendKeys(eleFirstGroupInitials, getAttribute(eleDefaultGroupInitials, "value"));
	}

	/**
	 * verify Msg On Group Initials Light Box
	 * 
	 * @param msg
	 * @return true if msg is displayed on Group Initials Light Box
	 */
	public boolean verifyMsgOnGroupInitialsLightBox(String msg) {
		return getElements(eleMsgOnGrpInitialsLightBox, msg).size() == 2;
	}

	/**
	 * verify Requisition Id In Requisition Creation Success Msg
	 * 
	 * @return true if success msg contains Requisition Id
	 */
	public boolean verifyRequisitionIdInSuccessMsg() {
		String RequisitionTrackingId = ReadWritePropertyFile
				.getProperty("RequisitionTrackingId", fileSystemPathTillTestData() + "Data.properties").toLowerCase();
		return getText(eleMsgOnReqIdPage).toLowerCase().contains(RequisitionTrackingId);
	}

	/**
	 * get Requisition Id From Properties File
	 * 
	 * @return requisition ID
	 */
	public String getRequisitionIdFromPropertiesFile() {
		return "rs-" + ReadWritePropertyFile.getProperty("RequirementTrackingId",
				fileSystemPathTillTestData() + "Data.properties");
	}
	
	public boolean verifyRequisitionIsCreatedWithIdOnListingPage()
	{
		String expectedRequisitionId = "rs-" + ReadWritePropertyFile.getProperty("RequirementTrackingId",
				fileSystemPathTillTestData() + "Data.properties");
		return getText(eleTopRequisitionId).contains(expectedRequisitionId) && getText(txtTopRequisitionName).contains("Requisition Name");
	}
	/**
	 * verify Requirement ID Same As Requisition Id
	 * 
	 * @return true if requirement ID similar to Requisition ID
	 */
	public boolean verifyRequirementIDSameAsRequisitionId() {
		return getText(eleRequirementCreationFromRequisitionSuccessMsg).contains(ReadWritePropertyFile
				.getProperty("RequirementTrackingId", fileSystemPathTillTestData() + "Data.properties"));
	}

	/**
	 * verify Requirement ID Same As that set in settings
	 * @param page on which Req ID to be verified
	 * 
	 * @return true if requirement ID Same As that set in settings
	 */
	public boolean verifyRequirementIDSameAsSetInSettings(String page) {
	    wait.waitForPageToLoadCompletely();
		String textToBeGet = null;
		if(page.equals("Requisition Id"))
			textToBeGet = getText(eleRequirementCreationFromRequisitionSuccessMsg);
		else if(page.equals("Requirement Creation"))
			textToBeGet = getText(eleRequirementCreationSuccessMsg);
		else if(page.equals("CV Details"))
			textToBeGet = getText(eleRequirementIdOnCVDetails);
		else if(page.equals("SRP page"))
			textToBeGet = getText(eleRequirementIdOnCVDetails);
		
		return textToBeGet.contains(ReadWritePropertyFile
				.getProperty("RequirementTrackingId", fileSystemPathTillTestData() + "Data.properties"));
	}

	/**
	 * search Candidate On Srp Using Email Id
	 */
	public void searchCandidateOnSrpUsingEmailId() {
		genericFunctions.waitTillDesiredCandidateTupleIsPresent(AddASingleProfilePagePO.emailId);
	}

}