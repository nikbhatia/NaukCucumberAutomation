/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naukri.pageobjects.RMSFolder;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;

/**
 *
 * @author vikash.agrawal
 */
public class RMSFolderCreationPO extends PageObjectWrapper {

    public static By createFolderLightBox = By.cssSelector("div[class$='createEditFolder']");
    public static By folderHeading = By.cssSelector("div.modalHeading");
    public static By createFolderModelCloseBtn = By.cssSelector("a.modalCloseLink");
    public static By folderNameTitle = By.cssSelector("div.ceFolderMod__fieldTitle");
    public static By folderNameInputField = By.cssSelector("input.ceFolderMod__nameInput");
    public static By shareFolderWithTitle = By.cssSelector("span[class='shareFolder__fieldTitle']");
    public static By shareFolderDropdownBtn = By.cssSelector("img[alt='downArrow']");
    public static By shareFolderWithTxt = By.cssSelector("span.shareOptions__fieldTitle");
    public static By shareFolderWithListCard = By.cssSelector("div.popupListCard__card");
    public static By shareFolderWithDropDownValue = By.xpath("//div[@class='shareOptions__shareType_opt'][text()='${value}']");
    public static By createFolderBtn = By.cssSelector("button.primary-btn.block-btn");
    public static By cancelCreateFolderBtn = By.cssSelector("button.secondary-btn.noBorderBtn");
    public static By errorMessageTxt = By.cssSelector("div.err");
    public static By shareFolderChip = By.cssSelector("span.shareFolder__infoStrip");
    public static By folderCreationSuccessMessageTxt = By.cssSelector("div.snackbar--msg__content");

    String headingCreateFolder = "Create Folder";

    public boolean verifyCreateFolderLightBoxIsDisplaying() {
        return getElement(createFolderLightBox).isDisplayed();
    }

    public boolean verifyCreateFolderLightBoxIsNotDisplaying() {
        return elementVisibility(createFolderLightBox);
    }

    public boolean verifyTheURLOfFolderCreationPage(String moduleName) {
        String URL = driver.getCurrentUrl();
        return URLBuilder.getURL(moduleName).equals(URL);
    }

    public boolean verifyCreateFolderHeading() {
        return getElement(folderHeading).getText().equals(headingCreateFolder) && getElement(folderHeading).isDisplayed();
    }

    public boolean verifyCrossIconForCreateFolderIsDisplaying() {
        return getElement(createFolderModelCloseBtn).isDisplayed();
    }

    public void clickOnCrossIconOfCreateFolderLightBox() {
        getElement(createFolderModelCloseBtn).click();
        TestNGLogUtility.info("User clicked on cross icon of create folder light box");
    }

    public boolean verifyFolderNameTitleIsDisplaying() {
        return getElement(folderNameTitle).getText().equals("Folder Name") && getElement(folderNameTitle).isDisplayed();
    }

    public void enterFolderName(String name) {
        wait.waitForPageToLoadCompletely();
        getElement(folderNameInputField).click();
        getElement(folderNameInputField).clear();
        getElement(folderNameInputField).sendKeys(name);
        TestNGLogUtility.info("User enter the RMS folder name as " + name);
    }

    public boolean verifyPlaceHolderValueOfFolderName() {
        return getElement(folderNameInputField).getAttribute("placeholder").equals("Enter Folder Name") && getElement(folderNameInputField).isDisplayed();
    }

    public boolean verifySahreFolderWithTitleIsDisplaying() {
        return getElement(shareFolderWithTitle).getText().contains("Folder is shared with") && getElement(shareFolderWithTitle).isDisplayed();
    }

    public void clickOnShareFolderDropdownButton() {
        getElement(shareFolderDropdownBtn).click();
        TestNGLogUtility.info("User clicked on share folder dropdown button");
    }

    public boolean verifyShareFolderWithTextIsDisplaying(String shareWithText) {
        return getElement(shareFolderWithTxt).getText().equals(shareWithText) && getElement(shareFolderWithTxt).isDisplayed();
    }

    public boolean verifyShareFolderWithDropdownListIsDisplaying() {
        return getElement(shareFolderWithListCard).isDisplayed();
    }

    public boolean verifyShareFolderWithDropdownValueIsDisplaying(String value) {
        return getElement(shareFolderWithDropDownValue, value).isDisplayed();
    }

    public void selectShareFolderCategory(String value) {
        getElement(shareFolderWithDropDownValue, value).click();
        TestNGLogUtility.info("User selected the value " + value);
    }

    public boolean verifyCreateFolderButtonIsDisplayingAndDisabled() {
        return getElement(createFolderBtn).isDisplayed() && !(getElement(createFolderBtn).getAttribute("disabled").isEmpty());
    }

    public String verifyCreateFolderButtonIsDisplayingAndNotDisabled() {
        return getElement(createFolderBtn).getAttribute("disabled");
    }

    public void clickOnCreateFolderButton() {
        getElement(createFolderBtn).click();
        TestNGLogUtility.info("User clicked on create folder button");
    }

    public boolean verifyCancelButtonIsDisplaying() {
        return getElement(cancelCreateFolderBtn).isDisplayed();
    }

    public void clickOnCancelButton() {
        getElement(cancelCreateFolderBtn).click();
        TestNGLogUtility.info("User clicked on cancel button of create folder");
    }

    public boolean verifyErrorMessageTextIsDisplaying(String errorMessage) {
        return getElement(errorMessageTxt).getText().equals(errorMessage) && getElement(errorMessageTxt).isDisplayed();
    }

    public boolean verifyChipOfshareFolder(String shareFolderChipMsg) {
        return getElement(shareFolderChip).getText().equals(shareFolderChipMsg);
    }

    public boolean verifySuccessMessageIsDisplaying(String folderName) {
        String message = "Folder " + folderName + " has been successfully created";        
        return getElement(folderCreationSuccessMessageTxt).getText().equals(message) && getElement(folderCreationSuccessMessageTxt).isDisplayed();
    }
}
