package com.naukri.stepdefinitions.Requirements;

import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.pageobjects.Requirements.addARequirementPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class addARequirementStepDef {
    addARequirementPO addToRequirementPO = (addARequirementPO) PageObjectWrapper.getObject(addARequirementPO.class);
    @When("User clicks on  Add To Requirement from panel")
    public void userCLicksOnaddARequirementFromPanel()
    {
        addToRequirementPO.clickAddToRequirement();
    }
    @Then("Verify Add to requirement lightbox is visible")
    public void verifyAddToRequirementLightboxVisible()
    {
        Assert.assertTrue(addToRequirementPO.addToRequirementLightboxVisible(),"add to requirement lightbox is not displayed");
    }
    @When("User click on Add a new Requirement checkbox")
    public void userClickOnAddANewRequirementCheckbox()
    {
        addToRequirementPO.clickOncheckAddNewReq();
    }

    @When("User enters name of the requirement")
    public void userEnterNameOFRequirement()
    {
        addToRequirementPO.enterTxtReqTitle();
    }

    @When("User clicks {string} on  Add a requirement lightbox")
    public void userClicksOnAddOnREquirementLightbox(String add)
    {
        addToRequirementPO.clickBtnAddToRequirement();
    }

    @Then("User verifies name of the new requirement is displayed on the lightbox")
    public void userVerifiesNameOfNewRequirement()
    {
        Assert.assertTrue(addToRequirementPO.verifyNameOfRequirementOnLightbox(),"req name is not displayed");
    }

    @When("User clicks on the requirement name on the lightbox")
    public void userClicksOnNewReqNameOnLightbox()
    {
        addToRequirementPO.clickRequirementNameOnLightbox();
    }

//    @Then("Verify User lands on the new requirement overview page")
//    public void verifyUserLandsOnNewRequirementOverviewPage()
//    {
//
//    }
    @When("User gets the Candidate email id of the first candidate")
    public void getTheFirstApplicationEmail()
    {
        addToRequirementPO.getTheFirstApplicationEmail();
    }

    @When("User clicks on the application count on requirement overview page")
    public void userClicksOnApplicationCountOnRequiremntOverviePage()
    {
        addToRequirementPO.clickApplicationCount();

    }
    @Then("Verify User redirected to requirement overview page with requirement name")
    public void verifyUserRedirectedToOverviewPage()
    {
       Assert.assertTrue(addToRequirementPO.redirectedTorequirementOverviewPageAfterAddtoreq(),"Not redirected to correct requirement overview page");
    }
    @Then("Profile should be displayed on srp page")
    public void verifyCandidateDisplayedOnProjectInbox()
    {
    Assert.assertTrue(addToRequirementPO.verifyCandidateDisplayedOnProjectInbox(),"Candidate email id displayed is not correct");
    }

    @When("User selects second requirement from Existing requirments")
    public void userSelectsFirstRequirementFromExistingRequirements()
    {
    	addToRequirementPO.chooseSecondFromExistingReqDD();
    }

    @When("User notes the requirement id of the requirement")
    public void userNotesTheRequirementIdOfReq()
    {
    	addToRequirementPO.userNotesTheRequirementIdOfProject();
    }

    @Then("Verify the requirement id displayed is correct both on the page and in URL")
    public void verifyTheRequirementIDDsiplayedIsCorrectOnPageAndURL()
    {
    	Assert.assertTrue(addToRequirementPO.verifyTheRequirementIDDsiplayedIsCorrectOnPageAndURL(),"requirement id not displayed correctly");
    }
    @Then("User verifies name of the existing requirement is displayed on the lightbox")
    public void verifyNameOfExistingRequirement()
    {
    	Assert.assertTrue(addToRequirementPO.verifyNameoFExistingReq(),"name of requirement is not correct");
    }

}
