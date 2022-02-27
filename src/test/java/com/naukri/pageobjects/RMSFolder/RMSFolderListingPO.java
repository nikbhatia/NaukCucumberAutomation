/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naukri.pageobjects.RMSFolder;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;

/**
 *
 * @author vikash.agrawal
 */
public class RMSFolderListingPO extends PageObjectWrapper {

    public static By folderNameTxt = By.xpath("//div[text()='${folderName}']");
    public static By folderCreatedDateTxt = By.xpath("//div[text()='${folderName}']/parent::div//span[contains(text(),'Created')]");
    public static By folderSharedWithTxt = By.xpath("//div[text()='${folderName}']/parent::div//span[@class='triggerText']");
    public static By folderShareWithCount = By.xpath("//div[text()='${folderName}']/ancestor::div[@class='folderListTuple__content']//span[@class='count']");
    public static By folderShareWithCandidtaeTxt = By.xpath("//div[text()='${folderName}']/ancestor::div[@class='folderListTuple__content']//span[@class='cusr-pntr']");
    public static By threeDotsOfFolder = By.xpath("//div[text()='${folderName}']/../..//span[@class='folderListTuple__content--menuWrapper cusr-pntr']//img");
    public static By threeDotDropdownOption = By.xpath("//div[text()='${option}']");
    public static By confirmBtn = By.cssSelector("button[class='confBtn yes']");

    public boolean verifyFolderNameIsDisplayingOnListingPage(String folderName) {
        return getElement(folderNameTxt, folderName).isDisplayed();
    }

    public boolean verifyFolderNameIsNotDisplayingOnListingPage(String folderName) {
        return elementVisibility(folderNameTxt, folderName);
    }

    public boolean verifyCreatedDateOnFolder(String folderName) {
        String date = "Created on ";
        String currentDate = getCurrentDate();
        if (currentDate.charAt(0) == '0') {
            currentDate = currentDate.substring(1, date.length());
        }
        date = date + currentDate + " .";
        return getElement(folderCreatedDateTxt, folderName).getText().equals(date);
    }

    public boolean verifyFolderSharedWithText(String folderName, String shareValue) {
        return getElement(folderSharedWithTxt, folderName).getText().equals(shareValue);
    }

    public boolean verifyFolderShareWithCountIsDisplaying(String folderName, String count) {
        return getElement(folderShareWithCount, folderName).getText().equals(count);
    }

    public boolean verifyFolderShareWithTextCandidateTextWithCountIsDisplaying(String folderName) {        
        return getElement(folderShareWithCandidtaeTxt, folderName).getText().contains("Candidates");
    }

    public void clickOnThreeDotOfAFolder(String folderName) {
        jsUtil.hoverByJS(getElement(threeDotsOfFolder, folderName));        
        getElement(threeDotsOfFolder, folderName).click();
        TestNGLogUtility.info("User clicked on three dots for " + folderName);
    }

    public void clickOnDeleteOptionOfDropdown(String option) {
        getElement(threeDotDropdownOption, option).click();
        TestNGLogUtility.info("User clicked on dropdown option " + option);
    }

    public void clickOnConfirmButton() {
        wait.hardWait(1);
        System.out.println("element: "+getElement(confirmBtn));
        getElement(confirmBtn).click();
        TestNGLogUtility.info("User clicked on confirm delete button");
    }
}
