package com.naukri.pageobjects.Taxonomy.Location;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.PageObjectWrapper;

/**
 *
 * @author udit.khanna
 */
public class TaxonomyRaiseRequisitionPO extends PageObjectWrapper {

	private By DDToBeClicked = By.xpath("//input[@id='${value}']");
	private By eleDDValuesToBeVerified = By.xpath("//ul[@class='dropdown ']//li");
	private By eleAdditionalDetails = By.id("additional_det");
	private By eleSearchIcon = By.xpath("//div[@class='fdw__search-icon']/img");
	private By eleFirstCheckboxInDD = By.xpath("//ul[@class=\"dropdown \"]/li");
	private By eleTagAdded = By.xpath("//span[@class='cityCustomTag']");
	private By eleAddOptionsForDD = By.xpath("//button[@class=\"addLocation\"]");
	private By btnToBeClicked = By.xpath("//button[contains(text(),'${string}')]");
	private By eleLabelsInLayer = By.xpath("//div[@class=\"label\"]");
	private By eleLayerHeading = By.xpath("//div[@class=\"modalHeading\"]");
	private By eleFieldTxtToBeVerified = By.xpath("//div[text()='${string}']/following-sibling::input");
	private By eleErrorMsg = By.xpath("//div[@class=\"errLbl\"]");
	private By eleDDFieldToBeClicked = By.xpath("//div[@class=\"label\" and text()='${string}']/following-sibling::div/input");
	private By ddStateCountryLoc = By.id("locParent");
	private By eleOptionToBeClickedInDD = By.xpath("(//div[@id='sa-dd-scrolllocParent']//li)[${string}]");
	private By eleJobLocationDD = By.xpath("(//div[@id=\"sa-dd-scrolllocSuggestor\"]//li)[${string}]");
	private By eleCrossIconForTag = By.xpath("//span[@class=\"crossId\"]");
	private By eleOptionSelectedInDD = By.xpath("//span[text()='${string}']/ancestor::li");
	private By eleAdditionalDetailLabel = By.id("additional_det");
	private By labelJobDetail = By.xpath("//label[@for='Job Location']");
	private By eleStatusMsg = By.xpath("//div[@id=\"statusRibbon\"]//div[@class=\"msg\"]");
	private By eleLocationOnRequisitionOverview = By.xpath("//span[@class=\"locationIcon\"]/following-sibling::span");
	By eleStateNames = By.id("sa-dd-scrolllocParent");

	// variables
	List<String> ddValues;
	String requisitionId = "";
	
	// objects
		GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

	/**
	 * click DropDown using ID
	 * 
	 * @param dropDownId
	 */
	public void clickDropDown(String dropDownId) {
		wait.hardWait(2);
		click(parameterizedLocator(DDToBeClicked, dropDownId));
	}

	/**
	 * verify Values As Checkboxes
	 * 
	 * @param str
	 * @param cityList
	 * @return
	 */
	public boolean verifyValuesAsCheckboxes(String str, List<String> cityList) {
		getDdTextValues();
		TestNGLogUtility.info("Comparing the dropdown values.");
		TestNGLogUtility.info("Expected Values : " + cityList.toString());
		if (ddValues.containsAll(cityList))
			return true;
		else
			return false;
	}

	/**
	 * verify Value In Dropdown
	 * 
	 * @param str
	 * @return
	 */
	public boolean verifyValueInDropdown(String str) {
		getDdTextValues();
		return ddValues.contains(str);
	}

	/**
	 * get DD Text Values using 'title' attribute and save values in list
	 * 'ddValues'
	 */
	public void getDdTextValues() {
		ddValues = new ArrayList<>();
		List<WebElement> ddElementsToBeVerified = getElements(eleDDValuesToBeVerified);
		for (WebElement element : ddElementsToBeVerified) {
			ddValues.add(element.getAttribute("title"));
		}
		TestNGLogUtility.info(ddValues.toString());
	}

	/**
	 * enter Value In DD Field
	 * 
	 * @param ddId
	 * @param valueToBeEntered
	 */
	public void enterValueInDDField(String ddId, String valueToBeEntered) {
		wait.hardWait(2);
		sendKeys(parameterizedLocator(DDToBeClicked, ddId), valueToBeEntered);
		wait.hardWait(2);
	}

	/**
	 * check first Check Box In DD
	 */
	public void checkCheckBoxInDD() {
		wait.hardWait(2);
		wait.waitForVisibilityOfElement(eleFirstCheckboxInDD);
		click(eleFirstCheckboxInDD);
	}

	/**
	 * @param tagValue
	 * @return
	 */
	public boolean verifyTagAdded(String tagValue) {
		wait.hardWait(2);
		return getAttribute(eleTagAdded, "title").contains(tagValue);
	}

	/**
	 * verify Max Suggestion Values
	 * 
	 * @param maxSuggestions
	 * @return
	 */
	public boolean verifyMaxSuggestionValues(int maxSuggestions) {
		getDdTextValues();
		return ddValues.size() == maxSuggestions;
	}

	/**
	 * verify Options To Add City are visible
	 * 
	 * @param noOfSuggestions
	 * @param list
	 * @return
	 */
	public boolean verifyOptionsToAdd(int noOfSuggestions, List<String> list) {
		List<WebElement> ddElementsToBeVerified = getElements(eleAddOptionsForDD);
		List<String> textValueforOption = new ArrayList<>();
		for (WebElement element : ddElementsToBeVerified) {
			textValueforOption.add(element.getAttribute("title"));
		}

		return textValueforOption.contains(list) || textValueforOption.size() == noOfSuggestions;
	}

	/**
	 * click Option For Adding City
	 * 
	 * @param optionToBeClicked
	 */
	public void clickOptionForAddingCity(String optionToBeClicked) {
		wait.hardWait(2);
		wait.waitForVisibilityOfElement(parameterizedLocator(btnToBeClicked, optionToBeClicked));
		click(parameterizedLocator(btnToBeClicked, optionToBeClicked));
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * verify Layer And its Contents
	 * 
	 * @param layerTitle
	 * @param list
	 * @return
	 */
	public boolean verifyLayerAndContents(String layerTitle, List<String> list) {
		List<WebElement> elementsToBeVerified = getElements(eleLabelsInLayer);
		List<String> labelsInLayer = new ArrayList<>();
		for (WebElement element : elementsToBeVerified) {
			labelsInLayer.add(element.getText());
		}

		return getText(eleLayerHeading).contains(layerTitle) || labelsInLayer.containsAll(list);
	}

	/**
	 * verify Text In Field
	 * 
	 * @param txtToBeVerified
	 * @param fieldLabelValue
	 * @return
	 */
	public boolean verifyTextInField(String txtToBeVerified, String fieldLabelValue) {
		return getAttribute(parameterizedLocator(eleFieldTxtToBeVerified, fieldLabelValue), "value")
				.contains(txtToBeVerified);
	}

	/**
	 * clear Field
	 * 
	 * @param strValue
	 */
	public void clearField(String strValue) {
		clearField(parameterizedLocator(eleFieldTxtToBeVerified, strValue));
	}

	/**
	 * verify Error Msg On Layer
	 * 
	 * @param errorMsg
	 * @return
	 */
	public boolean verifyErrorMsgOnLayer(String errorMsg) {
		return getText(eleErrorMsg).contains(errorMsg);
	}

	/**
	 * enter Value In Field In Layer
	 * 
	 * @param fieldName
	 * @param valueToBeEntered
	 */
	public void enterValueInFieldInLayer(String fieldName, String valueToBeEntered) {
		sendKeys(parameterizedLocator(eleFieldTxtToBeVerified, fieldName), valueToBeEntered);
	}

	/**
	 * select Option From DD In Layer
	 * 
	 * @param noOfOption
	 * @param dDName
	 */
	public void selectOptionFromDDInLayer(int noOfOption, String dDName) {
		click(parameterizedLocator(eleDDFieldToBeClicked, dDName));
		if(!isDisplayed(eleStateNames))
		{
			click(parameterizedLocator(eleDDFieldToBeClicked, dDName));
			wait.waitForVisibilityOfElement(eleStateNames);
		}
		click(parameterizedLocator(eleOptionToBeClickedInDD, Integer.toString(noOfOption)));
	
	}

	/**
	 * check Option In Job Location DD
	 * 
	 * @param noOfOption
	 */
	public void checkOptionInJobLocationDD(int noOfOption) {
		wait.hardWait(2);
		click(parameterizedLocator(eleJobLocationDD, Integer.toString(noOfOption)));
	}

	/**
	 * click Cross Icon For Tag
	 */
	public void clickCrossIconForTag() {
		click(eleCrossIconForTag);
	}

	/**
	 * verify Tag Removed
	 * 
	 * @param tagValue
	 * @return
	 */
	public boolean verifyTagRemoved(String tagValue) {
		return !isDisplayed(eleTagAdded);
	}

	/**
	 * verify Option Is Checked In DD
	 * 
	 * @param tagValue
	 * @return
	 */
	public boolean verifyOptionIsCheckedInDD(String tagValue) {
		return getAttribute(parameterizedLocator(eleOptionSelectedInDD, tagValue), "class").contains("selected");
	}

	/**
	 * uncheck Option In DD
	 * 
	 * @param optionToBeUnchecked
	 */
	public void uncheckOptionInDD(String optionToBeUnchecked) {
		click(parameterizedLocator(eleOptionSelectedInDD, optionToBeUnchecked));
	}

	/**
	 * @author gupta.mansi
	 * click Outside Job Location DD
	 */
	public void clickOutsideJobLocationDD() {
		click(labelJobDetail);
	}

	/**
	 *  save Requisition Id To Local
	 */
	public void saveRequisitionIdToLocal() {
		wait.waitForVisibilityOfElement(eleStatusMsg);
		String statusMsg = getText(eleStatusMsg);
		String [] subString = statusMsg.split("\\[");
		requisitionId = (subString[1].split("\\]"))[0];
	}

	/**
	 *  navigate To Requisition Overview Using Req Id
	 */
	public void navigateToRequisitionOverviewUsingReqId() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.RequisitionOverview") + "/" + requisitionId);
	}

	/** verify Location On Requisition Overview
	 * @param lcnToBeVerified
	 * @return
	 */
	public boolean verifyLocationOnRequisitionOverview(String lcnToBeVerified) {
		return getText(eleLocationOnRequisitionOverview).contains(lcnToBeVerified);
	}

}
