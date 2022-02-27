package com.naukri.stepdefinitions.HiringManager;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.HiringManager.FeedbackFormListingPagePO;
import com.naukri.pageobjects.Settings.ManageFeedbackFormPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import java.util.*;

public class FeedbackFormPageStepDef {

	GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	CommonAction objCommonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	FeedbackFormListingPagePO objFeedbackFormListingPagePO = new FeedbackFormListingPagePO();
	ManageFeedbackFormPO ManageFeedbackFormActionObj = new ManageFeedbackFormPO();
	SoftAssert softAssert = new SoftAssert();

	@When("User click on {string} link for feedback form")
	public void clickOnLinkOnFeedbackForm(String link) {
		objFeedbackFormListingPagePO.clickOnActionButton(link,PropFileHandler.readProperty("formName"));
		TestNGLogUtility.info("User click on given link for feedback form");
	}
	
	@When("User click on {string} link")
	public void clickOnLink(String link) {
		objFeedbackFormListingPagePO.clickOnLinkOnSettingsPage(link);
		TestNGLogUtility.info("User click on given link");
	}
	
	@And("User click on {string} link for default feedback form")
	public void clickOnButtonsForDefaultFeedbackForm(String buttonName)
	{
		objFeedbackFormListingPagePO.clickOnButtonOnDefaultFeedbackForm(buttonName);
		TestNGLogUtility.info("User click on given link for Default feedback form");
	}

	@Then("Verify that default feedback form name is {string}")
	public void verifyFormName(String formName) {
		Assert.assertEquals(objFeedbackFormListingPagePO.getTopFeedbackFormName(), formName);
		TestNGLogUtility.pass("Test case passed: Default feedbak form name is as expected");
	}

	@And("Verify that {string} is on top of list")
	public void verifyDefaultFormIsOnTop(String formName) {
		Assert.assertEquals(objFeedbackFormListingPagePO.getTopFeedbackFormName(), formName);
		TestNGLogUtility.pass("Test case passed: Default feedbak form is on top");
	}

	@When("User clicks on sort by {string}")
	public void clickOnSortByFormName(String sortByType) {
		objFeedbackFormListingPagePO.clickOnSortByBtn(sortByType);
		TestNGLogUtility.info("User clicks on Sort by "+sortByType);
	}

	@Then("Verify {string} button is displayed for default feedback form")
	public void verifyGivenButtonIsDisplayed(String linkType) {
		Assert.assertEquals(objFeedbackFormListingPagePO.isLinkDisplayed(linkType), true);
		TestNGLogUtility.pass("Test case passed: "+linkType+" is displayed");
	}

	@And("Verify {string} button is not displayed for default feedback form")
	public void verifyGivenButtonIsNotDisplayed(String linkType) {
		Assert.assertEquals(objFeedbackFormListingPagePO.isLinkDisplayed(linkType), false);
		TestNGLogUtility.pass("Test case passed: "+linkType+" is not displayed for default feedback form");
	}

	@And("Verify {string} is displayed below form name")
	public void verifTextUnderDefaultFeedbackFormName(String text1) {
		Assert.assertEquals(objFeedbackFormListingPagePO.ownerNameAndShareWithUnderFeedbackForm(), text1);
		TestNGLogUtility.pass("Test case passed: Text under feedback is same as expected");
	}

	@Then("Verify user see heading {string}")
	public void verifyFeedbackFormEditHeading(String text) {
		Assert.assertEquals(ManageFeedbackFormActionObj.getFeedbackFormHeader(), text);
		TestNGLogUtility.pass("Test case passed: Feedback heading of form is same as expected");
	}
	
	@And("User edits form title as {string}")
	public void editFormTitle(String title)
	{
		ManageFeedbackFormActionObj.fillFormTitle(title);
		TestNGLogUtility.info("User edits the form title name");
	}
	
	@And("User click on {string} button on form")
	public void clickOnButton(String btnName)
	{
		ManageFeedbackFormActionObj.clickOnGivenButton(btnName);
		TestNGLogUtility.info("User click on "+btnName+" button on form");
	}

	@And("Verify form tilte is {string}")
	public void verifyFeedbackFormTitle(String title)
	{
		String formTitleNameWithPreviewText = ManageFeedbackFormActionObj.getFeedbackFormHeader();
		String formTitleWithoutPreviewText = formTitleNameWithPreviewText.substring(0,formTitleNameWithPreviewText.lastIndexOf(" Preview"));
		Assert.assertEquals(formTitleWithoutPreviewText, title);
		TestNGLogUtility.pass("Test case passed: Edited title is displayed");
	}
	
	@Then("Verify that {string} button can be added in default feedback form")
	public void verifyAddOnHoldStateInDefaultForm(String state)
	{
		ManageFeedbackFormActionObj.addOnHoldStateInDefaultForm(state);
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(state), true);
		TestNGLogUtility.pass("Test case passed: User can add on hold button in default feedback form");
	}
	
	@Then("Verify {string} button is displayed")
	public void isOnHoldStateDisplayed(String stateName)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(stateName), true);
		TestNGLogUtility.pass("Test case passed: "+stateName+" is displayed");
	}
	
	@Then("Verify that {string} button can be removed")
	public void verifyOnHoldStateRemoval(String stateName)
	{
		ManageFeedbackFormActionObj.removeState(stateName);
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(stateName), false);
		TestNGLogUtility.pass("Test case passed: User can remove "+stateName);
	}
	
	@Then("Verify {string} button is not displayed")
	public void isOnHoldStateNotDisplayed(String stateName)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(stateName), false);
		TestNGLogUtility.pass("Test case passed: "+stateName+" is not displayed");
	}
	
	@And("User adds {string} button in default feedback form")
	public void addOnHoldButtonInDefaultForm(String stateName)
	{
		ManageFeedbackFormActionObj.addOnHoldStateInDefaultForm(stateName);
		TestNGLogUtility.info("User adds "+stateName+" in default feedback form");
	}
	
	@When("User click on {string} button")
	public void clickOnButtonOnListingPage(String button)
	{
		objFeedbackFormListingPagePO.clickOnButton(button);
		TestNGLogUtility.info("User clicks on "+button);
	}
	
	@And("Verify user cannot remove {string} state")
	public void verifyRemoveState(String stateName)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateRemoveBtnDispayed(stateName), false);
		TestNGLogUtility.pass("Test case passed: "+stateName+" cannot be removed");
	}
	
	@And("User removes {string} button in default feedback form")
	public void removeState(String stateName)
	{
		ManageFeedbackFormActionObj.removeState(stateName);
		TestNGLogUtility.info("User removes "+stateName+" button in default feedback form");
	}
	
	@Then("Verify that {string} state can be added")
	public void addOnHoldInFeedbackForm(String stateName)
	{
		ManageFeedbackFormActionObj.addOnHoldState(stateName);
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(stateName), true);
		TestNGLogUtility.pass("Test case passed: User can add "+stateName);
	}
	
	@When("User click on back arrow button")
	public void clickOnBackArrowBtn()
	{
		ManageFeedbackFormActionObj.clickOnBackArrowButtonFromPreviewPage();
		TestNGLogUtility.info("User click on back arrow button");
	}
	
	@Then("Verify that {string} state can be removed")
	public void removeBtnFromFeedbackForm(String stateName)
	{
		ManageFeedbackFormActionObj.removeState(stateName);
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(stateName), false);
		TestNGLogUtility.pass("Test case passed: User can remove "+stateName);
	}
	
	@And("User fills feedback form name")
	public void fillFeedbackFormName()
	{
		String formName = "Feedback "+ new Date().getTime();
		PropFileHandler.writeProperty("formName", formName);
		ManageFeedbackFormActionObj.fillFeedbackFormName(formName);
		TestNGLogUtility.info("User fills feedback form name as "+formName);
	}
	
	@And("User fills feedback form name as {string}")
	public void fillGivenFeedbackFormName(String formName)
	{
		ManageFeedbackFormActionObj.fillFeedbackFormName(formName);
		TestNGLogUtility.info("User fills given feedback form name");
	}
	
	@Then("User sees error as {string}")
	public void isErrorDisplayed(String error)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getErrorDisplayedOnHeader(), error);
		TestNGLogUtility.pass("Test case passed: Error is displayed");
	}
	
	@Then("Verify error as {string}")
	public void verifyStateNameError(String error)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getErrorDisplayedForIncorrectStateName(), error);
		TestNGLogUtility.pass("Test case passed: Error is displayed");
	}
	
	@And("User deletes all questions")
	public void deleteAllQuestionInFeedbackForm()
	{
		ManageFeedbackFormActionObj.deleteAllQuestions();
		TestNGLogUtility.info("User deletes all questions present in feedback form");
	}
	
	@Then("Verify {string} is displayed for state mapping")
	public void verifyDefaultMapping(String mapping)
	{
		int numberOfStates = ManageFeedbackFormActionObj.getNameOfAllStatesOfFeedbackForm().size();
		while(numberOfStates>0)
		{
			Assert.assertEquals(ManageFeedbackFormActionObj.getDefaultStateMappingText(ManageFeedbackFormActionObj.getNameOfAllStatesOfFeedbackForm().get(numberOfStates-1)), mapping);
			--numberOfStates;
		}
		TestNGLogUtility.pass("Test case passed: "+mapping+" is displayed");
	}
	
	@Then("Verify {string} is displayed")
	public void verifyTextDisplayed(String text)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getOverAllRatingTitle(), text);
		TestNGLogUtility.pass("Test case passed: Title is present");
	}
	
	@Then("Verify text {string} is displayed")
	public void verifySuccessMessage(String mgsTxt)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isTextDisplayed(mgsTxt),true);
		TestNGLogUtility.pass("Test case passed: "+mgsTxt+" text is displayed");
	}
	
	@When("User fills {string} as state name")
	public void fillStateName(String stateName)
	{
		ManageFeedbackFormActionObj.fillStateName(stateName);
		TestNGLogUtility.info("User fills state name as "+stateName);
	}
	
	@Then("Verify {string} state tag is created")
	public void verifyStateTag(String stateName)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isStateDisplayed(stateName), true);
		TestNGLogUtility.pass("Test case passed: State tag created");
		
	}
	
	@And("User click on {string} state on form")
	public void clickOnStateNameInFeedbackForm(String stateName)
	{
		ManageFeedbackFormActionObj.clickOnStateNameInFeedbackFormInPreview(stateName);
		TestNGLogUtility.info("User click on state");
	}
	
	@Then("User fills below as state name and verifies error")
	public void fillStateNameAndVerifyError(DataTable dt)
	{
		List<Map<String,String>> list = dt.asMaps(String.class,String.class);
		for(int listSize = 0;listSize<list.size();listSize++)
		{
			ManageFeedbackFormActionObj.fillStateName(list.get(listSize).get("State"));
			TestNGLogUtility.info("User filled "+list.get(listSize).get("State")+" as state name");
			Assert.assertEquals(ManageFeedbackFormActionObj.getErrorDisplayedForIncorrectStateName(), list.get(listSize).get("Error"));
			TestNGLogUtility.pass("Test case passed: Error message is displayed");
		}
		
	}
	
	@Then("Verify x coodinate of {string} is {string}")
	public void verifyXCoordinate(String btn,String cord)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.xCordOfAddQuestionBtn(btn), Integer.parseInt(cord));
		TestNGLogUtility.pass("Test case passed: X coordinate is same");
	}
	
	@Then("Verify no questions are present")
	public void verifyNoQuestionInFeedbackForm()
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getNumberOfQuestionsInFeedbackForm(),0);
		TestNGLogUtility.pass("Test case passed: Questions are not present");
	}
	
	@And("Verify form title is {string}")
	public void getFormTitle(String formTitle)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getFormTitle(), formTitle);
		TestNGLogUtility.pass("Test case passed: Form title is same as expected");

	}
	
	@And("User click on Change question type dd")
	public void clickOnChangeQuestionDD()
	{
		ManageFeedbackFormActionObj.clickOnChangeQuestionDD();
		TestNGLogUtility.info("User click on Change question type dd");
	}
	
	@When("User selects {string} question")
	public void selectQuestionType(String quesType)
	{
		ManageFeedbackFormActionObj.clickOnQuestionType(quesType);
		TestNGLogUtility.info("User selects given question type");
	}
	
	@When("User hover over {string} label")
	public void hoverOverAllRatingQues(String labelText)
	{
		ManageFeedbackFormActionObj.hoverOverMarkOverallRating(labelText);
		TestNGLogUtility.info("User hover over "+labelText);
	}
	
	@And("User hover over {string} button")
	public void hoverOverAddQues(String addBtn)
	{
		ManageFeedbackFormActionObj.hoverOverAddQuestionBtn(addBtn);
		TestNGLogUtility.info("User hover over "+addBtn);
	}
	
	@Then("Verify {string} state name {string} is displayed")
	public void verifyMsgWhenNoQuesMapped(String msg,String stateName)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getMsgWhenNoQuestMapped(stateName),msg+" "+stateName);
		TestNGLogUtility.pass("Test case passed: Message displayed is correct when no questions are mapped");
	}
	
	@And("User click on state question mapping dd for {string}")
	public void clickOnStateQuestionMappingdd(String stateName)
	{
		ManageFeedbackFormActionObj.clickOnStateMappingDD(stateName);
		TestNGLogUtility.info("User click on state question mapping dd for "+stateName);
	}
	
	@Then("Verify Mark as Overall Rating is selected")
	public void isOverAllRatingCheckBoxSelected()
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isMarkAsOverallRatingSelected(), true);
		TestNGLogUtility.pass("Test case passed: Mark as overall rating is selected");
	}
	
	@Then("Verify Mark as Overall Rating is unselected")
	public void isOverAllRatingCheckBoxUnselected()
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.isMarkAsOverallRatingSelected(), false);
		TestNGLogUtility.pass("Test case passed: Mark as overall rating is unselected");
	}
	
	@And("User unselects {string} questions from state mapping dd")
	public void unselectAllQuestionFromQustionMapping(String choice)
	{
		ManageFeedbackFormActionObj.chooseQuestionMapping(choice);
		TestNGLogUtility.info("User unselects "+choice+" questions from state mapping dd");
	}
	
	@When("User adds maximum limit {string} questions {string}")
	public void addMaxQuestions(String quesType,String maxLimit)
	{
		ManageFeedbackFormActionObj.addQuestions(quesType,Integer.parseInt(maxLimit));
		TestNGLogUtility.info("User adds maximum limit question");
	}
	
	@Then("Verify title {string} is displayed for Add Question button")
	public  void verifyAddQuestionTitle(String text)
	{
		Assert.assertEquals(ManageFeedbackFormActionObj.getAddQuesMaxTitle(), text);
		TestNGLogUtility.pass("Test case failed: Title is displayed");
	}
	
	@And("User adds single questions of every type")
	public void addQuestionOfEachType()
	{
		ManageFeedbackFormActionObj.addQuestions("Single Choice ",1);
		TestNGLogUtility.info("User adds Single Choice question");
		ManageFeedbackFormActionObj.addQuestions("Multiple Choice ",1);
		TestNGLogUtility.info("User adds Multiple Choice question");
		ManageFeedbackFormActionObj.addQuestions("Dropdown ",1);
		TestNGLogUtility.info("User adds Dropdown type question");
		ManageFeedbackFormActionObj.addQuestions("Short Paragraph ",1);
		TestNGLogUtility.info("User adds Short Paragraph type question");
		ManageFeedbackFormActionObj.addQuestions("Star Rating ",1);
		TestNGLogUtility.info("User adds Star Rating type question");
		ManageFeedbackFormActionObj.addQuestions("One Line Answer ",1);
		TestNGLogUtility.info("User adds One Line Answer type question");
		TestNGLogUtility.info("User addes question of each type");
	}

	//@wip
	@Then("Verify that on previewing default form same questions are present for states which were mapped")
	public void verifyQuestionsPrefilledFromDefaultForm()
	{
		objFeedbackFormListingPagePO.clickOnButtonOnDefaultFeedbackForm("Preview");
		List<String> quesInDefault = new ArrayList<String>(ManageFeedbackFormActionObj.getQuesListDisplayedOnPreview());
		ManageFeedbackFormActionObj.clickOnBackArrowButtonFromPreviewPage();
		objFeedbackFormListingPagePO.clickOnButton("Create Feedback Form");
		ManageFeedbackFormActionObj.clickOnGivenButton("PREVIEW");
		List<String> quesInNew = new ArrayList<String>(ManageFeedbackFormActionObj.getQuesListDisplayedOnPreview());
		Assert.assertEquals(quesInNew.size(), quesInDefault.size());
		for(int quesNo=0;quesNo<quesInDefault.size();quesNo++)
			Assert.assertEquals(quesInNew.get(quesNo),quesInDefault.get(quesNo));
		TestNGLogUtility.pass("Test case passed: Questions are same as questions in from Default Feedback Form");
	}
	
	@Then("Verify that all questions are displayed in state mapping dd for {string}")
	public void verifyAllQuestionArePresentInMappingDD(String stateName)
	{
		List<String> questions = new ArrayList<String>(ManageFeedbackFormActionObj.getQuesListDisplayedOnEdit());
		ManageFeedbackFormActionObj.clickOnStateMappingDD(stateName);
		List<String> quesMapping = new ArrayList<String>(ManageFeedbackFormActionObj.getQuesListDisplayedOnMappingDD());
		for(int temp=0;temp<questions.size();temp++)
			Assert.assertEquals(quesMapping.get(temp), questions.get(temp));
		TestNGLogUtility.pass("Test case passed: All questions are displayed in state mapping dd");
		
	}
	
	@And("User adds a question of {string} type")
	public void addSingleQuestion(String type)
	{
		ManageFeedbackFormActionObj.addQuestions(type,1);
		TestNGLogUtility.info("User adds a single question of "+type);
	}
	
	@And("Verify that only {string} states are present")
	public void verifyOnlyGivenStatesDisplayed(String stateName)
	{
		String[] stateNames = stateName.split(",");
		List<String> stateNameDisplayed = new ArrayList<String>(ManageFeedbackFormActionObj.getNameOfAllStatesOfFeedbackForm());
		Assert.assertEquals(stateNames.length, stateNameDisplayed.size(),"Number of states displayed are not same");
		for(int count=0;count<stateNameDisplayed.size();count++)
		{
			Assert.assertEquals(stateNameDisplayed.contains(stateNames[count]),true);
			TestNGLogUtility.pass(stateNames[count]+" state is displayed");
		}
	}
	
	@When("User prefill feedback form from top feedback form")
	public void prefillFeedbackForm()
	{
		ManageFeedbackFormActionObj.prefillFromTopForm();
		TestNGLogUtility.info("User prefill feedback form from top feedback form");
	}
	
	@And("Verify that same questions are present")
	public void verifyPresenceOfQuestions() 
	{
		TestNGLogUtility.info("Expected question list is: "+ManageFeedbackFormPO.feedbackQuestions);
		for(int temp=0;temp<ManageFeedbackFormPO.feedbackQuestions.size();temp++)
		{
			Assert.assertTrue(ManageFeedbackFormActionObj.verifyPresenceOfQuestionOnPreview(ManageFeedbackFormPO.feedbackQuestions.get(temp)));
		}
		TestNGLogUtility.pass("Same questions are present");
	}

}
