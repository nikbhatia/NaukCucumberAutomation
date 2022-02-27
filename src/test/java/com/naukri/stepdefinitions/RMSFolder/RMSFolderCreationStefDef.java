/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naukri.stepdefinitions.RMSFolder;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.RMSFolder.RMSFolderCreationPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 *
 * @author vikash.agrawal
 */
public class RMSFolderCreationStefDef {

    RMSFolderCreationPO folderCreationPage = (RMSFolderCreationPO) PageObjectWrapper.getObject(RMSFolderCreationPO.class);

    @Then("Verify the URL of the \"(.*)\" page is correct")
    public void verifyCreateFolderPageURL(String moduleName) {
        Assert.assertTrue(folderCreationPage.verifyTheURLOfFolderCreationPage(moduleName), "[Assertion Fail]: URL of current page is not correct");
        TestNGLogUtility.pass("URL of current page is correct");
    }

    @And("Verify that create folder lightbox is displaying")
    public void verifyCreateFolderLightBoxIsDisplaying() {
        Assert.assertTrue(folderCreationPage.verifyCreateFolderLightBoxIsDisplaying(), "[Assertion Fail]: Create folder light box is not displaying");
        TestNGLogUtility.pass("Create folder light box is displaying");
    }

    @And("Verify the heading of the create folder light box")
    public void verifyHeadingOfTheCreateFolderLightBox() {
        Assert.assertTrue(folderCreationPage.verifyCreateFolderHeading(), "[Assertion Fail]: Heading of the create folder light box is not displaying");
        TestNGLogUtility.pass("Heading of the create folder light box is displaying");
    }

    @And("Verify the folder name title on create folder light box")
    public void verifyFolderNameTitleOnCreateFolderLightBox() {
        Assert.assertTrue(folderCreationPage.verifyFolderNameTitleIsDisplaying(), "[Assertion Fail]: Folder name title is not displaying");
        TestNGLogUtility.pass("Folder name title is displaying");
    }

    @And("Verify the place holder value of folder name input box on create folder light box")
    public void verifyFolderNameFieldAndPlaceHolderValue() {
        Assert.assertTrue(folderCreationPage.verifyPlaceHolderValueOfFolderName(), "[Assertion Fail]: Name field and place holder value is not displaying");
        TestNGLogUtility.pass("Name field and place holder value is displaying");
    }

    @And("Verify the share folder with title is displaying on create folder light box")
    public void verifyShareFolderWithTitleIsDisplaying() {
        Assert.assertTrue(folderCreationPage.verifySahreFolderWithTitleIsDisplaying(), "[Assertion Fail]: Share folder with title is not displaying");
        TestNGLogUtility.pass("Share folder with title is displaying");
    }

    @And("Verify that folder visibility is \"(.*)\"")
    public void verifyShareFolderVisibility(String visibility) {
        Assert.assertTrue(folderCreationPage.verifyShareFolderWithTextIsDisplaying(visibility), "[Assertion Fail]: Folder is not share with " + visibility);
        TestNGLogUtility.pass("Folder is share with" + visibility);
    }

    @When("User click on dropdown of share folder with on create folder light box")
    public void clickOnDropdownOfShareFolderWith() {
        folderCreationPage.clickOnShareFolderDropdownButton();
    }

    @Then("Verify that share folder dropdown list is displayig")
    public void verifyShareFolderDropdownListIsDisplaying() {
        Assert.assertTrue(folderCreationPage.verifyShareFolderWithDropdownListIsDisplaying(), "[Assertion Fail]: Share folder dropdown list is not displaying");
        TestNGLogUtility.pass("Share folder dropdown list is displaying");
    }

    @And("Verify that the value \"(.*)\" is displaying in the list")
    public void verifyDropdownListValueIsDisplaying(String value) {
        Assert.assertTrue(folderCreationPage.verifyShareFolderWithDropdownValueIsDisplaying(value), "[Assertion Fail]: Share folder with drop down value " + value + " is not displaying");
        TestNGLogUtility.pass("Share folder with drop down value " + value + " is not displaying");
    }

    @Then("Verify that share folder with dropdown list is not displaying")
    public void verifyShareFolderListDropDownIsNotDisplaying() {
        Assert.assertFalse(folderCreationPage.verifyShareFolderWithDropdownListIsDisplaying(), "[Assertion Fail]: Share folder dropdown list is displaying");
        TestNGLogUtility.pass("Share folder dropdown list is not displaying");
    }

    @And("Verify that create folder button is displaying and disabled")
    public void verifyCreateFolderButtonIsDisplaying() {
        Assert.assertTrue(folderCreationPage.verifyCreateFolderButtonIsDisplayingAndDisabled(), "[Assertion Fail]: Create folder button is not displaying");
        TestNGLogUtility.pass("Create folder button is displaying");
    }

    @And("Verify that cancel button on create folder light box is displaying")
    public void verifyCancelButtonIsDisplaying() {
        Assert.assertTrue(folderCreationPage.verifyCancelButtonIsDisplaying(), "[Assertion Fail]: Cancel button is not displaying");
        TestNGLogUtility.pass("Cancel button is displaying");
    }

    @When("User enter the name of folder as \"(.*)\" in the text field")
    public void enterFolderNameInInputField(String folderName) {
        folderCreationPage.enterFolderName(folderName);
    }

    @Then("Verify that create folder button is displaying and not disabled")
    public void verifyCreateFolderButtonIsNotDisabled() {
        Assert.assertTrue(folderCreationPage.verifyCreateFolderButtonIsDisplayingAndNotDisabled() == null, "[Assertion Fail]: Create folder button is diabled");
        TestNGLogUtility.pass("Create folder button is not diabled");
    }

    @When("User click on cancel button of create folder light box")
    public void clickOnCancelButtonOfCreateFolderLightBox() {
        folderCreationPage.clickOnCancelButton();
    }

    @Then("Verify that create folder light box is not displaying")
    public void verifyCreateFolderLightBoxIsNotDisplaying() {
        Assert.assertFalse(folderCreationPage.verifyCreateFolderLightBoxIsNotDisplaying(), "[Assertion Fail]: Create folder light box is displaying");
        TestNGLogUtility.pass("Create folder light box is not displaying");
    }

    @And("User click on cross icon of the light box")
    public void clickOnCrossIconOfCreateFolderLightBox() {
        folderCreationPage.clickOnCrossIconOfCreateFolderLightBox();
    }

    @And("User click on create folder button on light box")
    public void clickOnCrateFolderButton() {
        folderCreationPage.clickOnCreateFolderButton();
    }

    @Then("Verify that error message on create folder light box as \"(.*)\" is displaying")
    public void verifyErrorMessageOnCreateFolderLightBox(String errorMessage) {
        Assert.assertTrue(folderCreationPage.verifyErrorMessageTextIsDisplaying(errorMessage), "[Assertion Fail]: Error message is displaying as " + errorMessage);
        TestNGLogUtility.pass("Error message is displaying as " + errorMessage);
    }

    @And("User select the folder share with category value as \"(.*)\"")
    public void selectFolderShareWithCategory(String value) {
        folderCreationPage.selectShareFolderCategory(value);
    }

    @Then("Verify that user is able to see the share folder chip message as \"(.*)\"")
    public void verifyShareFolderMessage(String message) {
        Assert.assertTrue(folderCreationPage.verifyChipOfshareFolder(message), "[Assertion Fail]: Chip of share folder message is displaying as " + message);
        TestNGLogUtility.pass("Chip of share folder message is displaying as " + message);
    }

    @And("Verify that user is able to see the success message of folder \"(.*)\" creation")
    public void verifyFolderCreationSuccessMessage(String folderName) {
        Assert.assertTrue(folderCreationPage.verifySuccessMessageIsDisplaying(folderName), "[Assertion Fail]: Success message is not displaying for " + folderName);
        TestNGLogUtility.pass("Success message is displaying for " + folderName);
    }
}
