package com.naukri.stepdefinitions.Settings;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.ManageEmployerPO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;

public class ManageGroupStepDef {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
//	APITestOps APITestObj = new APITestOps();

	SettingsDashboardPO SettingGroupActionObject = new SettingsDashboardPO();
	ManageGroupPO ManageGroupActionObject = new ManageGroupPO();
	ManageEmployerPO manageEmployerPO = new ManageEmployerPO();
	public static String groupName;

	@And("user fill all fields in Group Details")
	public void groupDetails() {
		groupName = "Group" + CommonAction.generateRandomStrings(10, "String");
		PropFileHandler.writeProperty("groupName", groupName);
		String groupInitials = GenericFunctions.generateRandomStrings(5, "Alphanumeric");
		String groupDetails = "description is " + CommonAction.generateRandomStrings(10, "String");
		ManageGroupActionObject.addGroupDetails(groupName, groupDetails, groupInitials);
	}

	@And("user Select Recruiters & Hiring Managers and fill all other details")
	public void selectRecHM() {
		ManageGroupActionObject.selectRecHm();
	}

	@And("user create and Select Requisition Approval Process")
	public void createselectReqApproval() {
		String approvalName = "approval" + CommonAction.generateRandomStrings(10, "String");
		PropFileHandler.writeProperty("approvalName", approvalName);
		ManageGroupActionObject.selectReqApproval(approvalName);
	}

	@And("user click on \"([^\"]*)\" button")
	public void clickOnButton(String buttonName) {
		ManageGroupActionObject.clickOnBtn(buttonName);
	}

	@Then("verify Page having {string} textbox open")
	public void verifyPageHavingTextboxOpen(String textBoxId) {
		commonActions.verifyLandingPageBasedOnTextBoxId(textBoxId);
	}

	@And("user Select Offer Approval Process")
	public void selectOfferApprovall() {
		String approvalName = PropFileHandler.readProperty("approvalName");
		ManageGroupActionObject.selectOfferApproval(approvalName);

	}

	@And("user click on {string} link")
	public void userClickOnLink(String link) {
		ManageGroupActionObject.ClickOnlinks(link);
	}

	@Then("verify created Group is added")
	public void verifyGroupAdded() {
		String groupName = PropFileHandler.readProperty("groupName");
		Assert.assertTrue(ManageGroupActionObject.verifyGroupAdd(groupName),
				"Test case failed : As user is not able to see new added Group"+groupName+"");
	}


	@And("user enter new Group Name")
	public void edittGroupName() {
		String newGroupName = "NewGroup" + CommonAction.generateRandomStrings(10, "String");
		PropFileHandler.writeProperty("newGroupName", newGroupName);
		ManageGroupActionObject.editGroupName(newGroupName);
	}

	@And("user Select new Recruiters & Hiring Managers")
	public void newRecHM() {
		ManageGroupActionObject.newRecHm();
	}

	@Then("verify edited Group")
	public void verifyEdittGroup() {
		String newGroupName = PropFileHandler.readProperty("newGroupName");
		Assert.assertTrue(ManageGroupActionObject.verifyGroupAdd(newGroupName),
				"Test case failed : As user is not able to see edited group"+newGroupName+"");
	}

	@And("user click on Selection Stages")
	public void selectionStgBtn() {
		ManageGroupActionObject.selectionStage();
	}

	@When("user Add new Selection Stage")
	public void addSelectionStg() {
		String newSelectionStg = PropFileHandler.readProperty("groupName");
		ManageGroupActionObject.addSelectionStage(newSelectionStg);
	}

	@And("user Add Hiring Manager to the new Stage")
	public void addHmToStg() {
		String newSelectionStg = PropFileHandler.readProperty("groupName");
		ManageGroupActionObject.addHmToStage(newSelectionStg);
	}

	@Then("verify new Selection Stage is visible in list")
	public void verifySelectionStg() {
		String newSelectionStg = PropFileHandler.readProperty("groupName");
		Assert.assertTrue(ManageGroupActionObject.verifySelectionStage(newSelectionStg),
				"Test case failed : As user is not able to see new selection stage");
	}

	@Then("verify new selection stage is not visible in list")
	public void verifyDelSelectionStg() {
		String newSelectionStg = PropFileHandler.readProperty("groupName");
		Assert.assertFalse(ManageGroupActionObject.verifyDelSelectionStage(newSelectionStg),
				"Test case failed : User is still able to see deleted selection stage");
	}

	@When("user Add new Sub Stage & attach FeedbackForm")
	public void addSubStg() {
		String newSelectionStg = PropFileHandler.readProperty("groupName");
		ManageGroupActionObject.addSubStage(newSelectionStg);
	}

	@Then("verify user is navigated to Manage Groups Page")
	public void verifyToManageGrp() {
		Assert.assertTrue(ManageGroupActionObject.verifyNavigateToManageGrp(),
				"Test case failed : As user is not able to see Manage Groups page");
	}

	@And("user delete new stage")
	public void deletNewstg() {
		String newSelectionStg = PropFileHandler.readProperty("groupName");
		ManageGroupActionObject.deleteNewStage(newSelectionStg);
	}

	@Then("verify that user is able to see the listed headings on page")
	public void verifyThatUserIsAbleToSeeTheListedHeadingsOnPage(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(ManageGroupActionObject.verifyHeadings(list.get(i)),
					"Test case failed : As user is not able to see the heading " + list.get(i) + "");
		}
	}
	
	
	@And("user fill mandatory field to add group")
	public void mandatoryFields() {
		String groupName = "Group" + CommonAction.generateRandomStrings(9, "String");
		PropFileHandler.writeProperty("groupName", groupName);
		String groupInitials = GenericFunctions.generateRandomStrings(5, "Alphanumeric");
		ManageGroupActionObject.mandatoryField(groupName,groupInitials);
	}

	@And("user click on delete button under the group")
	public void deleteGrp() {
		ManageGroupActionObject.deleteGroup();
	}

	@When("user select checkbox for 2 or more groups")
	public void select2Group() {
		ManageGroupActionObject.select2Groups();
	}

	@And("click on bulk delete button")
	public void bulkDel() {
		ManageGroupActionObject.bulkDelete();
	}
	
	@Then("verify success message \"([^\"]*)\"")
	public void verifySuccessMsgs(String successMsg) {
		Assert.assertTrue(ManageGroupActionObject.verifySuccessMsg(successMsg),
				"Test case failed : As user is not able to see the success message"+successMsg+"");
	}

	@And("user fill group name which already exist")
	public void groupAlreadyExistt() {
		ManageGroupActionObject.groupAlreadyExist();
	}

	@Then("verify user able to see error message \"([^\"]*)\"")
	public void verifyErrorMsgg(String errorMsg) {
		Assert.assertTrue(ManageGroupActionObject.verifyErrorMsg(errorMsg),
				"Test case failed : As user is not able to see error message"+errorMsg+"");
	}

	@And("user type group name in search bar")
	public void searchGroupName() {
		String searchGroup = PropFileHandler.readProperty("groupName");
//		PropFileHandler.writeProperty("searchGroup", searchGroup);
		ManageGroupActionObject.searchGroup(searchGroup);
	}

	@Then("verify searched group is visible")
	public void verifySearch() {
		String groupName = PropFileHandler.readProperty("groupName");
		Assert.assertTrue(ManageGroupActionObject.verifySearchGroup(groupName),
				"Test case failed : As user is not able to see searched group"+groupName+"");
	}

	@Then("user should be able to see the label \"([^\"]*)\"" )
	public void verifyLabel(String labelName) {
		Assert.assertTrue(ManageGroupActionObject.labelVerify(labelName),
				"Test case failed : As user is not able to see the label"+labelName+"");
	}

	@Then("Verify Billing Details tab should not be displayed")
	public void verifyBillingDetailsTabShouldNotBeDisplayed() {
		Assert.assertFalse(manageEmployerPO.verifyBillingDetailsTabIsDisplayed(), "Billing Details tab is displayed in company account !!!!");

	}
	
	@When("User adds the selection stage {string} in the group created")
	public void user_adds_the_selection_stage_in_the_group_created(String selectionStageText) {
		ManageGroupActionObject.clickOnSelectionStagesBasedOnGroupName();
		ManageGroupActionObject.addSelectionStageInGroup(selectionStageText);
	}
	
	@Then("User should be able to see the stage added")
	public void user_should_be_able_to_see_the_stage_added() {
	    Assert.assertTrue(ManageGroupActionObject.verifyPresenceOfSelectionStage(), 
	    		"Selection stage added is not visible");
	    TestNGLogUtility.pass("Selection stage is visible");
	}
	

	@When("User clicks on continue button on the selection stage lightbox")
	public void user_clicks_on_continue_button_on_the_selection_stage_lightbox() {
		ManageGroupActionObject.clickOnContinueButton();
	}
	@Then("verify success message of requisition creation")
	public void verifySuccessMessageOfRequisitionCreation()
	{
		Assert.assertTrue(ManageGroupActionObject.verifySuccessRequisitionMessage(),"requisition created message not displayed");
	}
	
	@And("User clicks {string} for group number {int} in the list")
	public void clickOptionForFirstGroup(String optionToBeClicked, int groupNum){
		ManageGroupActionObject.clickOptionForGroup(optionToBeClicked, Integer.toString(groupNum));
	}
	
	@And("User clicks on {string} dropdown on Edit Group")
	public void clickDropdownOnEditGroup(String ddToBeClicked){
		ManageGroupActionObject.clickDropdownOnEditGroup(ddToBeClicked);
	}
	
	@Then("User should see ALL count should be greater than SELECTED")
	public void verifyAllCountGreaterThanSelected()	{
		Assert.assertTrue(ManageGroupActionObject.verifyAllCountGreaterThanSelected(),"SELECTED count is less than ALL count.");
	}

}
