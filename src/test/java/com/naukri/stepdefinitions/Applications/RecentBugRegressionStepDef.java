package com.naukri.stepdefinitions.Applications;

import com.naukri.automation.util.APIUtil;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Applications.SettingsPagePO;
import com.naukri.pageobjects.Applications.SettingsPagePO.GroupListingPagePO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class RecentBugRegressionStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	AddASingleProfilePagePO addASingleProfile = (AddASingleProfilePagePO) PageObjectWrapper.getObject(AddASingleProfilePagePO.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	APIUtil apiUtil = (APIUtil) PageObjectWrapper.getObject(APIUtil.class);
	GroupListingPagePO groupListingPagePO = (GroupListingPagePO) PageObjectWrapper.getInnerClassObject(SettingsPagePO.class, GroupListingPagePO.class);

	@Then("I should be directed to the CV details page")
	public void i_should_be_directed_to_the_CV_details_page() {
		Assert.assertTrue(cvDetailsPagePO.verifyRedirectedOnCVDetailsPage(),
				"The user is not getting redirected to CV Details Page");
	}

	@Then("I should be able to see the success message {string} on CV Details Page")
	public void i_should_be_able_to_see_the_success_message_on_CV_Details_Page(String successMessage) {
		Assert.assertTrue(cvDetailsPagePO.verifySuccessStatusMessage(successMessage),
				"The Success Message for creation of profile is not visible");
	}

	@Then("I should be able to view the filled information on the CV detail page")
	public void i_should_be_able_to_view_the_filled_information_on_the_CV_detail_page() {
		Assert.assertTrue(cvDetailsPagePO.verifyVisibilityOfRequirementTitle(),
				"The requirement title is not visible or different requirement name");
		Assert.assertTrue(cvDetailsPagePO.verifyTheVisibilityOfCandidateemail(),
				"The email is not visible or different email");
		Assert.assertTrue(cvDetailsPagePO.verifyTheVisibilityOfCandidateContact(),
				"The contact is not visible or different contact");
		Assert.assertTrue(cvDetailsPagePO.verifyTheSelectionStage(),
				"The selection stage of the candidate is not same");
	}

	@When("I click on the edit option")
	public void i_click_on_the_edit_option() {
		cvDetailsPagePO.clickEditProfileButton();
	}

	@When("I update the mobile number")
	public void i_update_the_mobile_number() {
		cvDetailsPagePO.editContactNumber();
	}

	@When("I click on the save button")
	public void i_click_on_the_save_button() {
		cvDetailsPagePO.clickSaveDetailsButton();
	}

	@Then("I should able to see the success message {string}")
	public void i_should_able_to_see_the_success_message(String successMessage) {
		Assert.assertTrue(cvDetailsPagePO.verifyThePresenceOfEditSuccessMessage(successMessage),
				"The edit success message is not visible");
	}

	@Then("I should be able to see the updated contact number")
	public void i_should_be_able_to_see_the_updated_contact_number() {
		Assert.assertTrue(cvDetailsPagePO.compareEditContact(), "The edited contact number is not visible");
	}
	
	@When("I am on Add a new group page")
	public void i_am_on_Add_a_new_group_page() {
	    genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.groupListing"));
	    groupListingPagePO.clickAddNewGroupBtn();
	}

	@When("I fill in the group name and group description")
	public void i_fill_in_the_group_name_and_group_description() {
	   groupListingPagePO.fillGroupName();
	   groupListingPagePO.fillGroupDescription();
	}

	@When("I click on {string} button on manage group layout")
	public void i_click_on_button_on_manage_group_layout(String btnText) {
	    groupListingPagePO.clickOnFooterButtonOnLayout(btnText);
	}

	@When("I select {string} and {string} as recruiters")
	public void i_select_and_as_recruiters(String recruiterName1, String recruiterName2) {
	   List<String> recruiterName = Arrays.asList(recruiterName1,recruiterName2);
	   groupListingPagePO.selectRecruiterForGroup(recruiterName);
	}

	@When("I select {string} as HM.")
	public void i_select_as_HM(String hmName1) {
	   List<String> hiringManagerName = Arrays.asList(hmName1);
	   groupListingPagePO.selectHMForGroup(hiringManagerName);
	}

	@When("I select the group created to requirement")
	public void i_select_the_group_created_to_requirement() {
		addASingleProfile.selectGroupForNewRequirement(SettingsPagePO.groupName);
	}

	@When("I select the requirement visibility to {string}")
	public void i_select_the_requirement_visibility_to(String visibilityOption) {
		addASingleProfile.selectVisibilityOption(visibilityOption);
	}

	@When("I get access token")
	public void i_get_access_token() {
		apiUtil.createNewGroup("lokesh.agrawal@naukri.com","P@ssw0rd0987");
	}

	@When("I click on {string} on DD")
	public void i_click_on_on_DD(String statusText) {
	   cvDetailsPagePO.changeStatusOfCandidate(statusText);
	}
	
	@Then("I should be able to see the success message {string} On CV details Page")
	public void i_should_be_able_to_see_the_success_message_On_CV_details_Page(String successMessage) {
	    Assert.assertTrue(cvDetailsPagePO.validateStatusChangeSuccessMessage(successMessage), 
	    		"The success message for status change of candidate is not visible");
	}


	@When("I navigate to CV Details Page of candidate added")
	public void i_navigate_to_CV_Details_Page_of_candidate_added() {
	    genericFunctions.launchSpecificURL(CVDetailsPagePO.candidateDetailsPageUrl);
	}

	@Then("I should see the current status of the candidate as {string}")
	public void i_should_see_the_current_status_of_the_candidate(String statusText) {
	   Assert.assertTrue(cvDetailsPagePO.verifyStatusOfCandidate(statusText), 
			   "Status of candidate is not " + statusText);
	}

	@Then("I should see the status change information {string}")
	public void i_should_see_the_status_change_information(String recruiterNameText) {
	    Assert.assertTrue(cvDetailsPagePO.statusChangeHistory(recruiterNameText.replace(" ", "")), 
	    		""+ recruiterNameText + " is not visible for change in status");
	}

}
