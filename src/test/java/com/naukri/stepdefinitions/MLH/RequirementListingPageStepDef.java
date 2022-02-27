package com.naukri.stepdefinitions.MLH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.HiringManager.ManageGroupPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.MLH.MLHRequirementListingPagePO;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.pageobjects.Requirements.RequirementListingPagePO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RequirementListingPageStepDef {

	// Variables
	static String groupName;
	public static String reqName;
	// Declaration
	CommonAction CommonActionObject = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	MLHRequirementListingPagePO mlhRequirementListingPagePO = (MLHRequirementListingPagePO) PageObjectWrapper.getObject(MLHRequirementListingPagePO.class);
	ManageGroupPagePO mangeGroupPageObject = new ManageGroupPagePO();
	RequirementListingPagePO requirementListingPagePO = (RequirementListingPagePO) PageObjectWrapper.getObject(RequirementListingPagePO.class);
	RequirementPagePO requirementPageObject = new RequirementPagePO();
	SoftAssert softAssert = new SoftAssert();

	@And("I go to requirement overview page of first requirement")
	public void goToRequirementOVerviewPAgeOfFirstRequirement() {
		mlhRequirementListingPagePO.clickTopRequirementName();
		TestNGLogUtility.info("I go to requirement overview page of first requirement");
	}

	@Then("I see {string} label")
	public void isLabelDisplayed(String label) {
		Assert.assertEquals(mlhRequirementListingPagePO.isFilterByLabelDisplayed(), label,"Test Failed: label is not displayed");
		TestNGLogUtility.pass("I see "+label+" label");
	}

	@And("I verify that {string} status is selected by default")
	public void isOpenSelectedByDefault(String status) {
		Assert.assertEquals(mlhRequirementListingPagePO.defaultStatusSelected(), status,"Test Failed: Default status is not same");
		TestNGLogUtility.pass("I verify that "+status+" status is selected by default");
	}

	@And("I verify that All source is selected by default")
	public void isAllSourcesSelectedByDefault() {
		// Value corresponding to All filter is 1
		Assert.assertEquals(mlhRequirementListingPagePO.defaultSourceSelected(), "1","Test Failed: Default source is not All");
		TestNGLogUtility.pass("I verify that All source is selected by default");
	}

	@And("I verify that Recruiter's filter is present")
	public void isRecruiterFilterPresent() {
		Assert.assertEquals(mlhRequirementListingPagePO.isRecruiterFilterDisplayed(), true,"Test Failed: Recruiter filter not displayed");
		TestNGLogUtility.pass("I verify that Recruiter's filter is present");
	}

	@And("I click on drop down for Source's filter drop down")
	public void clickOnSourceDD() {
		mlhRequirementListingPagePO.clickOnSourceDD();
		TestNGLogUtility.info("I click on drop down for Source's filter drop down");
	}

	@Then("I see name of all the Sources for a requirement")
	public void areAllSourcesDisplayed() {
		Assert.assertEquals(mlhRequirementListingPagePO.jobSourceDisplayed(), true,"Test Failed: All source not displayed");
		TestNGLogUtility.pass("I see name of all the Sources for a requirement");
	}

	@And("I click on drop down for Status's filter drop down")
	public void clickOnReqStatusDD() {
		mlhRequirementListingPagePO.clickOnStatusDD();
		TestNGLogUtility.info("I click on drop down for Status's filter drop down");
	}

	@Then("I see name of all the Status of a requirement")
	public void areAllStatusDisplayed() {
		Assert.assertEquals(mlhRequirementListingPagePO.areAllReqStatusDisplayedInFilter(), true,"Test Failed: All the status name is not displayed");
		TestNGLogUtility.pass("I see name of all the Status of a requirement");
	}

	@And("I create a requirement with {string}")
	public void createRequirementWithVisibilityOnlyToMe(String visibility) {
		reqName = "TestRequirement " + new Date().getTime();
		requirementPageObject.createRequirementWithNoGroup(reqName, visibility);
		TestNGLogUtility.info("I create a requirement "+reqName+" with visibility: "+visibility);
	}

	@And("I create a requirement with {string} with group")
	public void createRequirementWithGroupAndVisibilityOnlyToMe(String visibility) {
		reqName = "TestRequirement " + new Date().getTime();
		requirementPageObject.createRequirementWithGroup(groupName, reqName, visibility);
		TestNGLogUtility.info("I create a requirement "+reqName+" with visibility: "+visibility+" for group "+groupName);
	}

	@And("I create a requirement with {string} with existing group as {string}")
	public void createRequirementWithGroupAndVisibilityAllInTheGroup(String visibility, String groupName) {
		requirementPageObject.createRequirementWithGroup(groupName, reqName, visibility);
		TestNGLogUtility.info("I create a requirement "+reqName+" with visibility: "+visibility+" for group "+groupName);
	}

	@And("I created a group in which I mapped recruiters as HR")
	public void createGroup(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		List<String> hrNames = new ArrayList<String>();
		for (Map<String, String> traverseList : list)
			hrNames.add(traverseList.get("Username"));
		mangeGroupPageObject.addGroup(groupName, hrNames);
		TestNGLogUtility.info("I created a group "+groupName+" in which I mapped recruiters as HR");
	}

	@And("I create requirement with {string}")
	public void createRequirement(String visibility) {
		reqName = "TestRequirement " + new Date().getTime();
		requirementPageObject.createRequirementWithGroup(groupName, reqName, visibility);
		TestNGLogUtility.info("I create requirement with "+reqName+" for group "+groupName+" wit visibility "+visibility);
	}

	@When("I search the requirement")
	public void quickSearchRequirement() {
		mlhRequirementListingPagePO.quickSearchRequirement(reqName);
		TestNGLogUtility.info("I search the requirement");
	}

	@Then("I verify that requirement is present")
	public void verifyRequirementIsPresent() {
		softAssert.assertEquals(mlhRequirementListingPagePO.isRequirementTitleDisplayed(reqName), true,"Test Failed: Requirement not present");
		TestNGLogUtility.pass("Requirement is present");
	}

	@And("I verify that I see View only label under the requirement")
	public void verifyViewOnlyLabel() {
		softAssert.assertEquals(mlhRequirementListingPagePO.isViewOnlyLabelDisplayed(reqName), true,"Test Failed: View only label not displayed");
		TestNGLogUtility.pass("I see View only label under the requirement");
	}

	@And("I verify that I see comment button icon under the requirement raised by my reportee")
	public void verifyCommentButton() {
		softAssert.assertEquals(mlhRequirementListingPagePO.isCommentButtonDisplayed(reqName), true,"Test Failed: Comment button is not present");
		TestNGLogUtility.pass("I see comment button icon under the requirement raised by my reportee");
	}

	@And("I verify that I can add comment for the requirement")
	public void verifyThatICanAddComment() {
		mlhRequirementListingPagePO.addCommentForRequirement(reqName);
		softAssert.assertEquals(mlhRequirementListingPagePO.getTopComment(reqName), "Adding comment...","Test Failed: Unable to add comment");
		TestNGLogUtility.pass("I can add comment for the requirement");
	}

	@And("I verify that I can delete my comment")
	public void verifyThatICanDeleteMyComment() {
		int prevCommentCount = Integer.parseInt(mlhRequirementListingPagePO.getCommentCount(reqName));
		mlhRequirementListingPagePO.addCommentForRequirement(reqName);
		mlhRequirementListingPagePO.deleteTopComment(reqName);
		int latestCommentCount = Integer.parseInt(mlhRequirementListingPagePO.getCommentCount(reqName));
		softAssert.assertEquals(latestCommentCount, prevCommentCount,"Test failed: User cannot delete comment");
		TestNGLogUtility.pass("I can delete my comment");
	}

	@And("I verify that Search label is present")
	public void verifySearchLabelIsPresent() {
		softAssert.assertEquals(mlhRequirementListingPagePO.isSearchLabelDisplayed(reqName), true,"Test Failed: Search label is not present");
		TestNGLogUtility.pass("Search label is present");
	}

	@Then("I verify that I see {string} button is present")
	public void isButtonDisplayed(String buttonName) {
		Assert.assertTrue(mlhRequirementListingPagePO.isButtonDisplayed(reqName, buttonName),"Test Failed: "+buttonName+" is not present");
		TestNGLogUtility.pass("I verify that I see "+buttonName+" button is present");
	}

	@And("I verify that on clicking {string} button I am redirected to respective page with page title as {string}")
	public void verifyResdexClickRedirection(String buttonName, String pageTitle) {
		mlhRequirementListingPagePO.clickSearchButton(reqName, buttonName);
		softAssert.assertEquals(mlhRequirementListingPagePO.getTitleOfPage().trim(), pageTitle,"Test Failed: Error in redirecting");
		TestNGLogUtility.pass("I verify that on clicking "+buttonName+" button I am redirected to respective page with page title as "+pageTitle);
	}

	@And("I created a group in which I mapped {string} and {string} as HR")
	public void createAGroup(String hr1, String hr2) {
		groupName = "TestGroup " + new Date().getTime();
		List<String> hrs = Arrays.asList(hr1, hr2);
		mangeGroupPageObject.addGroup(groupName, hrs);
		TestNGLogUtility.info("I created a group: "+groupName+" in which I mapped "+hr1+" and as "+hr2+" as HR");
	}

	@Then("I verify that requirement is not present")
	public void verifyThatRequirementIsNotPresent() {
		Assert.assertEquals(mlhRequirementListingPagePO.isRequirementTitleDisplayed(reqName), false,"Test Failed: Requirement is present");
		TestNGLogUtility.pass("Requirement is not present");
	}

	@And("I created a group in which I mapped HRName as HR")
	public void createGroupWithHR(DataTable dt) {
		groupName = "TestGroup " + new Date().getTime();
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		List<String> hrNames = new ArrayList<String>();
		for (int count = 0; count < list.size(); count++) {
			if (!list.get(count).get("HRName").equals("NA")) {
				hrNames.add(list.get(count).get("HRName"));
			}
		}
		mangeGroupPageObject.addGroup(groupName, hrNames);
		TestNGLogUtility.info("I created a group: "+groupName+" in which I mapped HRName as HR");
	}

	@And("I verify that all call to action are present for Modify")
	public void verifyThatCallToActionArePresent() {
		RequirementCreationPagePO.requirementName = reqName;
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfModifyDD(reqName), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfCTAUnderModify(reqName,"Edit"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfCTAUnderModify(reqName,"Close"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfCTAUnderModify(reqName,"Post"), true);
		TestNGLogUtility.info("I verify that all call to action are present");
	}

	@And("I create requirement with {string} with {string}")
	public void createRequirementWithVisibilityToSelectedRecruiters(String visibility, String recruiter) {
		reqName = "TestRequirement " + new Date().getTime();
		requirementPageObject.createRequirementWithNoGroup(reqName, visibility, recruiter);
		TestNGLogUtility.info("I create requirement "+reqName+" with "+visibility+" with "+recruiter);
	}

	@And("I click on edit button")
	public void clickOnEditButtonForRequirement() {
		mlhRequirementListingPagePO.clickOnEditRequirementButtonFromReqListingPage(reqName);
		TestNGLogUtility.info("I click on edit button");
	}

	@And("I set visibility as {string}")
	public void editVisibilityOfRequirement(String visibility) {
		requirementPageObject.setVisibility(visibility);
		TestNGLogUtility.info("I set visibility as "+visibility);
	}

	@And("I save the requirement")
	public void saveRequirement() {
		requirementPageObject.clickOnAddRequirementButton();
		TestNGLogUtility.info("I save the requirement");
	}

	@When("I click on close button")
	public void clickOnCloseButton() {
		mlhRequirementListingPagePO.clickOnCloseRequirementButtonFromReqListingPage(reqName);
		TestNGLogUtility.info("I click on close button");
	}

	@Then("I verify {string} as error message")
	public void verifyErrorMessage(String message) {
		Assert.assertTrue(mlhRequirementListingPagePO.isMessageDislayed(message),"Test Failed: Message is not displayed" );
		TestNGLogUtility.pass("I verify "+message+" as error message");
	}
	
	@When("User hover on {string} for above requirement")
	public void hoverOnButton(String btnName)
	{
		RequirementCreationPagePO.requirementName = reqName;
		requirementListingPagePO.hoverOnRequirementOptions(btnName,"requirement created");
		TestNGLogUtility.info("User hover on "+btnName+" for above requirement");
	}
	
	@And("I verify that all call to action are present for More Actions")
	public void verifyCTAForMoreActions() 
	{
		RequirementCreationPagePO.requirementName = reqName;
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfMoreAction(reqName), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyOptionUnderMoreDD(reqName,"Edit"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyOptionUnderMoreDD(reqName,"Add Single Profile"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyOptionUnderMoreDD(reqName,"Download By Index"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyOptionUnderMoreDD(reqName,"Assign Vendor"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyOptionUnderMoreDD(reqName,"Get Apply Link"), true);
		TestNGLogUtility.info("I verify that all call to action are present for more actions");
	}
	
	@And("I verify that all call to action are present for status change under {string}")
	public void verifyStatusChangeCTA(String status)
	{
		RequirementCreationPagePO.requirementName = reqName;
		Assert.assertEquals(mlhRequirementListingPagePO.verifyCurrentStatusOfRequirement(reqName,status), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfStatusUnderCurrentStatus(reqName,status,"Close"), true);
		Assert.assertEquals(mlhRequirementListingPagePO.verifyPresenceOfStatusUnderCurrentStatus(reqName,status,"On Hold"), true);
		TestNGLogUtility.info("I verify that all call to action are present for more actions");
	}

}
