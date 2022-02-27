/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naukri.stepdefinitions.RMSFolder;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.RMSFolder.RMSFolderListingPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

/**
 *
 * @author vikash.agrawal
 */
public class RMSFolderListingStepDef {
    
    RMSFolderListingPO folderListingPage = (RMSFolderListingPO) PageObjectWrapper.getObject(RMSFolderListingPO.class);
    
    @Then("Verify that user is able to see the folder name on folder listing page as \"(.*)\"")
    public void verifyFolderNameIsDisplaying(String folderName) {
        Assert.assertTrue(folderListingPage.verifyFolderNameIsDisplayingOnListingPage(folderName), "[Assertion Fail]: Folder name is not displaying on folder listing page as" + folderName);
        TestNGLogUtility.pass("Folder name is displaying on folder listing page as" + folderName);
    }
    
    @And("Verify that user is able to see create folder date on folder listing page for \"(.*)\"")
    public void verifyCreateFolderDateOnFolderListingPage(String folderName) {
        Assert.assertTrue(folderListingPage.verifyCreatedDateOnFolder(folderName), "[Assertion Fail]: Create folder date on folder listing page is not displaying for " + folderName);
        TestNGLogUtility.pass("Create folder date on folder listing page is displaying for " + folderName);
    }
    
    @And("Verify that user is able to see the shared with category as \"(.*)\" for folder \"(.*)\"")
    public void verifySharedWithCategoryOfFolder(String sharedWith, String folderName) {
        Assert.assertTrue(folderListingPage.verifyFolderSharedWithText(folderName, sharedWith), "[Assertion Fail]: Folder is not shared with " + sharedWith);
        TestNGLogUtility.pass("Folder is shared with " + sharedWith);        
    }
    
    @And("Verify that user is able to see the count as \"(.*)\" of candidate for folder \"(.*)\"")
    public void verifyCadidateCountIsDispalying(String count, String folderName) {
        Assert.assertTrue(folderListingPage.verifyFolderShareWithCountIsDisplaying(folderName, count), "[Assertion Fail]: Count value is not correct as " + count);
        TestNGLogUtility.pass("Count value is correct as " + count);
    }
    
    @And("Verify that user is able to see the candidate text for folder \"(.*)\"")
    public void verifyCandidateTextIsDisplaying(String folderName) {
        Assert.assertTrue(folderListingPage.verifyFolderShareWithTextCandidateTextWithCountIsDisplaying(folderName), "[Assertion Fail]: Candidate text is not displaying");
        TestNGLogUtility.pass("Candidate text is displaying");
    }
    
    @And("User click on three dots for a folder \"(.*)\"")
    public void clickOnThreeDotsForAFolder(String folderName) {
        folderListingPage.clickOnThreeDotOfAFolder(folderName);
    }
    
    @And("User select the option \"(.*)\" from the dropdown")
    public void selectOptionFromDropDown(String option) {
        folderListingPage.clickOnDeleteOptionOfDropdown(option);
    }
    
    @And("User click on confirm button to delete folder")
    public void clickOnConfirmButtonToDelete() {
        folderListingPage.clickOnConfirmButton();
    }
    
    @Then("Verify that user is not able to see the folder \"(.*)\"")
    public void verifyFolderIsNotDisplaying(String folderName) {
        Assert.assertFalse(folderListingPage.verifyFolderNameIsNotDisplayingOnListingPage(folderName), "[Assertion Fail]: Folder is displaying");
        TestNGLogUtility.pass("Folder is not displaying");
    }
    
}
