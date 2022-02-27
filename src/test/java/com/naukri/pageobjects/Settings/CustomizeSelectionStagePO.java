package com.naukri.pageobjects.Settings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Customize Selection Stage Page Object
 * @author rachit.mehrotra
 *
 */
public class CustomizeSelectionStagePO extends PageObjectWrapper{
	
	By eleCustomizeSelectionStageHolder = By.xpath("//div[contains(text(),'${selectionStageText}')]");
	By eleMainStage = By.xpath("//div[contains(@id,\"globalSelectionList\")]/div//div[contains(@class,\"acc_head_title\")]");
	By eleSubStageCount = By.xpath("(//div[contains(@class,'subStageCnt')])[${count}]");
	By eleCountOfSelectionStage = By.xpath("//div[contains(text(),'${selectionStage}')]/following-sibling::div");
	By eleSelectionSubStage = By.xpath("(//div[contains(text(),'${mainStageText}')]/parent::div/following-sibling::div//li/label)[${counterOfSubStage}]");
	By eleMainSelectionStageLocator = By.xpath("//div[contains(text(),'${stageForTest}')]");
	By eleSelectionSubStageContainer = By.xpath("//ul[contains(@class,\"sortable source\")]");
	By btnAddSelectionStage = By.xpath("(//a[text()='Add Selection Stage'])[1]");
	By txtInputStageName = By.xpath("//input[@id='newVal' and contains(@class,'stageSubStageInput')]");
	By txtInputSubStageName = By.xpath("//input[@id='lablSubStg']");
	By btnSave = By.xpath("(//a[text()='Save'])[1]");
	By btnCancel = By.xpath("//a[@id='cancelStage']");
	By txtStageName = By.xpath("//div[text()='${stageName}']");
	By btnEditStageName = By.xpath("//div[text()='${stageName}']/../..//em[contains(@class,'editIc')]");
	By btnDeleteStageName = By.xpath("//div[text()='${stageName}']/../..//em[contains(@class,'delIcon')]");
	By btnOnDeleteLB = By.xpath("//a[text()='${button}']");
	By txtSuccessMessage = By.xpath("//span[@id='SuccessmsgBx']");
	By eleSuccessMesaageParent = By.xpath("//span[@id='SuccessmsgBx']/parent::div");
	By txtErrorMessage = By.xpath("//span[@id='ErrmsgBx']//span");
	By eleErrorMesaageParent = By.xpath("//span[@id='ErrmsgBx']/parent::div");
	By txtInputEditStageName = By.xpath("//input[@id='lablStg' and contains(@class,'stageSubStageInput')]");
	By txtErrorMessageBelowStageName = By.xpath("//i[@id='lablStg_err']//span");
	By btnAddSubStage = By.xpath("//div[text()='${stageName}']/../..//a[text()='Add Sub Stage']");
	By btnAddStageLB = By.xpath("//a[text()='Add Stage']");
	public static LinkedHashMap<String,List<String>> selectionStageMapping = new LinkedHashMap<String, List<String>>();
	List<String> selectionStageTextList = new ArrayList<String>();
	
	/**
	 * To verify the presence of the customize selection stage heading's presence
	 * @author rachit.mehrotra
	 * @param expectedString
	 * @return boolean basis comparison
	 */
	public boolean verifyThePresenceOfSelectionStageText(String expectedString) {
		return isDisplayed(parameterizedLocator(eleCustomizeSelectionStageHolder, expectedString));
	}
	
	/**
	 * To prepare the list of selection stages
	 * @author rachit.mehrotra
	 */
	private void prepareListForMainSelectionStage() {
		List<WebElement> listOfWebElementOfSelectionStage = getElements(eleMainStage);
		for(WebElement we : listOfWebElementOfSelectionStage)
			selectionStageTextList.add(getText(we));
	}
	
	/**
	 * To prepare the mapping of the selection main text and their respective substages
	 * @author rachit.mehrotra
	 */
	public void prepareSelectionStageMap() {
		prepareListForMainSelectionStage();
		int j = 0;
		for(int i = 0 ; i < selectionStageTextList.size(); i++) {
			List<String> subStageList = new ArrayList<String>();
			if(isDisplayed(parameterizedLocator(eleCountOfSelectionStage, selectionStageTextList.get(i)))) {
				j++;
				int internalSizeOfList = Integer.parseInt(getText(parameterizedLocator(eleSubStageCount, Integer.toString(j))).replace("Sub Stage(s)", "").trim());
				int counter = 0;
				click(parameterizedLocator(eleMainSelectionStageLocator, selectionStageTextList.get(i)));
				for(int k = 0 ; k < internalSizeOfList ; k++ ) {
					counter++;
					String substage = getText(parameterizedLocator(eleSelectionSubStage, selectionStageTextList.get(i), Integer.toString(counter)));
					TestNGLogUtility.info("substage " + substage);
					subStageList.add(substage);
				}
			} else {
				subStageList.add(null);
			}
			selectionStageMapping.put(selectionStageTextList.get(i), subStageList);
		}
		TestNGLogUtility.info("Selection Stages map created " + selectionStageMapping);
	}
	
	/**
	 * @author gupta.mansi 
	 * This method click on edit icon for given stage name
	 * @param stageName
	 *            name of the stage in String
	 */
	public void clickOnEditStageName(String stageName) {
		mouseHoverToWebElement(getElement(txtStageName, stageName));
		getElement(btnEditStageName, stageName).click();
		wait.waitForVisibilityOfElement(txtInputEditStageName);
	}
	
	/**
	 * @author gupta.mansi
	 * This method click on delete button for given stage name
	 * @param stageName
	 */
	public void clickOnDeleteStageName(String stageName){
		mouseHoverToWebElement(getElement(txtStageName, stageName));
		getElement(btnDeleteStageName, stageName).click();
	}
	
	/**
	 * @author gupta.mansi
	 * This method clicks on given named button on delete stage light box
	 * @param buttonName It can be 'Delete from entire System' or 'Cancel' or 'Delete from Global only'
	 */
	public void clickOnButtonOnDeleteLB(String buttonName)
	{
		click(parameterizedLocator(btnOnDeleteLB, buttonName));
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method fills the given string in stage name
	 * @param stageName
	 */
	public void fillStageName(String stageName)
	{
		getElement(txtInputStageName).clear();
		getElement(txtInputStageName).sendKeys(stageName);
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true if success message is displayed
	 * @return true if success message is displayed
	 */
	public boolean isSuccessMessageDisplayed()
	{
		boolean flag = false;
		if(!getElement(eleSuccessMesaageParent).getAttribute("style").contains("none"))
			return flag = true;
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true if error message is displayed
	 * @return true if error message is displayed
	 */
	public boolean isErrorMessageDisplayed()
	{
		boolean flag = false;
		if(!getElement(eleErrorMesaageParent).getAttribute("style").contains("none"))
			return flag = true;
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method return the text of message displayed
	 * @return
	 */
	public String getMessageDisplayed()
	{
		if(isErrorMessageDisplayed())
			return getText(txtErrorMessage);
		else
			return getText(txtSuccessMessage);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Add Selection stage button
	 */
	public void clickAddSelectionStageButton() {
		getElement(btnAddSelectionStage).click();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Save stage
	 */
	public void clickSaveButton()
	{
		getElement(btnSave).click();
		wait.waitForPageToLoadCompletely();
		if(isDisplayed(btnAddStageLB))
		{
			getElement(btnAddStageLB).click();
			wait.waitForPageToLoadCompletely();
		}
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to edit given stage name
	 * @param stageName
	 */
	public void fillEditedStageName(String stageName)
	{
		getElement(txtInputEditStageName).clear();
		getElement(txtInputEditStageName).sendKeys(stageName);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is user to get the error message displayed below stage name
	 * @return stage error
	 */
	public String getErrorMessageBelowStageName()
	{
		return getText(txtErrorMessageBelowStageName);
	}

	/**
	 * @author gupta.mansi
	 * This method is used to click on Cancel button for stage
	 */
	public void clickOnStageCancel()
	{
		click(btnCancel);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * This method is used to click on given stage's name
	 * @param stageName
	 */
	public void clickOnStageName(String stageName)
	{
		click(parameterizedLocator(txtStageName, stageName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Add Substage button
	 * @param stageName
	 */
	public void clickOnAddSubStage(String stageName)
	{
		click(parameterizedLocator(btnAddSubStage, stageName));
	}
	
	public void fillSubstageName(String subStageName)
	{
		getElement(txtInputSubStageName).clear();
		getElement(txtInputSubStageName).sendKeys(subStageName);
	}
}
