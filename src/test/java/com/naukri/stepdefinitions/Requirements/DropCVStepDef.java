package com.naukri.stepdefinitions.Requirements;

import com.naukri.pageobjects.Requirements.DropCVPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class DropCVStepDef {
    DropCVPO objDropCV = (DropCVPO) PageObjectWrapper
            .getObject(DropCVPO.class);

    @When("User clicks on Add a new category")
    public void userCLicksOnAddNewCategory() {
        objDropCV.clickONAddNewcategory();
    }

    @When("User enters name of category")
    public void enterNameOfCategory() {
        objDropCV.enterNameofCategory();
    }

    @When("User enters new email id to forward response")
    public void userEntersEmailIdToForwardResponse() {
        objDropCV.enterEmailIdToFOrwardResponse();
    }

    @Then("Verify email is added to forward response")
    public void verifyEmailAddedToForwardResponse() {
        Assert.assertTrue(objDropCV.verifyEmailSelected(), "email id is not displayed which is selected");
    }

    @When("user clicks on save custom category")
    public void userCLicksOnSaveCustomcategory() {
        objDropCV.clickSaveCategory();
    }

    @Then("verify category should be displayed under category listing")
    public void verifyCategoryDisplayedUnderCategoryListing() {
        Assert.assertTrue(objDropCV.verifyCategoryDisplayedUnderListing(), "category is not displayed under listimg page ");
    }

    @When("User selects first existing questionaire")
    public void userSelectsExistingQuestionaire() {
        objDropCV.usrSelectsExistingQuestionaireFRomDD();
    }

    @When("user clicks on {string} category")
    public void userCliksOnEditCategory(String option)
    {
        objDropCV.clickOnOptionListingpage(option);
    }
    @Then("Verify first questionaire name should be displayed")
    public void verifyFirstQuestionaireName()
    {
        Assert.assertTrue(objDropCV.verfiyFIrstQuestionairename(),"questionaire name is mot displayed");
    }
    @When("user removes the questionaire from category")
    public void userRemovesQuestionaireFromcategory()
    {
        objDropCV.removeQustionaireFRomCategory();
    }
    @Then("Verify Questionaire is removed and Add new button is visible")
    public void verifyQuestionairenOtDisplayedOnLightbox()
    {
        Assert.assertTrue(objDropCV.verifyQuestionaireNotDisplayedOnlIghtbox(),"questionair name still displayed even after it is removed");
    }
    @When("user selects any existing questionaire from DD on category creation")
    public void userSeleectsExistingQuestionionareFRomDD()
    {
        objDropCV.selectExistingQuestionaireOnLightbox();
    }
    @When("user enters category name under quick search")
    public void userEnterscategoryNameUnderQuickSearch()
    {
        objDropCV.searchCategoryOnPage();
    }
    @When("update the category name on lightbox")
    public void updateCategoryNameOnLightbox()
    {
        objDropCV.updateCategoryName();
    }
    @When("user confirms to close category")
    public void userConfirmsCLoseCategory()
    {
        objDropCV.closeCategoryCOnfirmation();
    }
    @Then("Verify category is closed and status is changed to reopen")
    public void verifyCategoryMarkedClosed()
    {
        Assert.assertTrue(objDropCV.verifyCategoryMarkedclosed(),"category not marked closed");
    }
    @Then("Verify career site and referral both are displayed on drop cv listing page")
    public void verifycareerSiteAndReferralOnDropCV()
    {
        Assert.assertTrue(objDropCV.verifyCareerSiteAndRefferalOnCV(),"career site and referral not displayed");
    }
    @When("user selects category with applications mapped {string}")
    public void userSelectscategoryWithApplicationsMapped(String category)
    {
        objDropCV.selectcategoryWithApplicationsMapped(category);
    }
    @Then("Verify project inbox page is displayed and application is visible")
    public void verifyProjectInboxPageDisplayed()
    {
        Assert.assertTrue(objDropCV.verifyProjectInboxPageDisplayed(),"project inbox page is not displayed");
    }
    @When("user click on recruitement solutions link")
    public void clickOnRecruitmentSolutionLink()
    {
        objDropCV.clickOnRecruitmentSolnLink();
    }
    @Then("verify requirement assigned notification is displayed on dashboard")
    public void verifyrequirementNotification()
    {
        Assert.assertTrue(objDropCV.verifyRequirementNotification(),"requirement is not displayed on dashboard");
    }
}
