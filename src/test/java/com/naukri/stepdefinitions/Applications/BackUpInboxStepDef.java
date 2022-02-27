package com.naukri.stepdefinitions.Applications;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.Applications.InboxPagePO.AddToRequirementLightbox;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BackUpInboxStepDef {

	GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	InboxPagePO inboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
	AddToRequirementLightbox addToRequirementLightbox = (AddToRequirementLightbox) PageObjectWrapper.getInnerClassObject(InboxPagePO.class, AddToRequirementLightbox.class);

	@When("I navigate to backup inbox")
	public void i_navigate_to_backup_inbox() {
		genericFunction.launchSpecificURL(YamlReader.getAppConfigValue("URLs.backupInboxPage"));
	}

	@Then("I should be able to see the advance search link")
	public void i_should_be_able_to_see_the_advance_search_link() {
		Assert.assertTrue(inboxPagePO.presenceOfAdvanceSearch(), 
				"The advanced search link is not visible");
	}

	@Then("The advance search link should be clickable")
	public void the_advance_search_link_should_be_clickable() {
		Assert.assertTrue(inboxPagePO.checkTheClickableOfAdvancedSearchField(),
				"The advanced search is not clickable");
	}

	@Then("I should be able to see the expand link")
	public void i_should_be_able_to_see_the_expand_link() {
		Assert.assertTrue(inboxPagePO.checkThePresenceOfExpandLink(), 
				"The expand link is not visible");
	}

	@Then("The expand link should be clickable")
	public void the_expand_link_should_be_clickable() {
		Assert.assertTrue(inboxPagePO.checkThePresenceOfExpandLinkDiv(), 
				"The expand link is not clickable");
	}
	
	@Then("I should be able to see send a requirement and message options")
	public void i_should_be_able_to_see_send_a_requirement_and_message_options() {
		Assert.assertTrue(inboxPagePO.checkThePresenceOfEmailAndSendARequirementOption(), 
				"The requirement and message options are not available on message hover");
	}
	
	@When("I click on Send a Requirement")
	public void i_click_on_Send_a_Requirement() {
		inboxPagePO.clickSendARequirementFromMenu();
	}

	@Then("I should be able to see Send a Requirement Lightbox")
	public void i_should_be_able_to_see_Send_a_Requirement_Lightbox() {
		Assert.assertTrue(inboxPagePO.verifyTheSendARequirementLightbox(), 
				"The lightbox is not rendering");
	}
	
	@Then("I should be able to see the forward link present")
	public void i_should_be_able_to_see_the_forward_link_present() {
		Assert.assertTrue(inboxPagePO.presenceOfForwardOption(), 
				"The forward option is not visible on the backup page");
	}

	@Then("On clicking the forward link I should be able to see the forward lightbox")
	public void on_clicking_the_forward_link_I_should_be_able_to_see_the_forward_lightbox() {
		inboxPagePO.clickForwardOption();
		Assert.assertTrue(inboxPagePO.checkPresenceOfForwardLightbox(), 
				"The heading of the forward lightbox is not present");
	}
	
	@When("I click on forward option")
	public void i_click_on_forward_option() {
		inboxPagePO.clickForwardOption();
	}
	
	@Then("I should be able to see the download drop down")
	public void i_should_be_able_to_see_the_download_drop_down() {
		inboxPagePO.presenceOfDownloadOption();
	}

	@When("I click on download drop down")
	public void i_click_on_download_drop_down() {
		inboxPagePO.clickDownloadOption();
	}

	@Then("I must be able to see {string} and {string}")
	public void i_must_be_able_to_see_and(String dropDownOption1, String dropDownOption2) {
		inboxPagePO.checkPresenceOfDownloadOptionOnDownloadDropdown(dropDownOption1, dropDownOption2);
	}

	@When("I click on the {string} option")
	public void i_click_on_the_option(String downloadOption) {
		inboxPagePO.hoverOnDownloadOption();
		inboxPagePO.clickOnDownloadOption(downloadOption);
	}
	
	@Then("I should be able to see the checkbox for {string} on the download lightbox")
	public void i_should_be_able_to_see_the_checkbox_for_on_the_download_lightbox(String downloadType) {
		inboxPagePO.presenceForCheckboxSelectedResumeForDownloadLightbox();
	}

	@Then("I should be able to see the from index and to index field for {string}")
	public void i_should_be_able_to_see_the_from_index_and_to_index_field_for(String downloadType) {
		inboxPagePO.clickOnDownloadOption(downloadType);
		Assert.assertTrue(inboxPagePO.presenceForSelectedResume(), 
				"Fields not present");
	}
	
	@Then("I am able to see the add to requirement option")
	public void i_am_able_to_see_the_add_to_requirement_option() {
	   Assert.assertTrue(inboxPagePO.checkThePresenceOfAddToRequirementOption(), 
			   "The add to requirement option is not visible on backup inbox page");
	}

	@When("I click on the add to requirement option")
	public void i_click_on_the_add_to_requirement_option() {
		inboxPagePO.clickAddToRequirementOption();
	}

	@Then("I should be able to see the lightbox with title {string}")
	public void i_should_be_able_to_see_the_lightbox_with_title(String string) {
		Assert.assertTrue(addToRequirementLightbox.checkPresenceAddToRequirementTitle(), 
				"The requirement title is not visible");
	}

	@When("I chose a requirement name from requirement DD")
	public void i_chose_a_requirement_name_from_requirement_DD() {
		addToRequirementLightbox.clickOnRequirementDDOnRequirementLightbox();
		addToRequirementLightbox.selectFirstRequirementOption();
	}

	@When("I click on Add button on layout")
	public void i_click_on_Add_button_on_layout() {
		addToRequirementLightbox.clickAddToRequirement();
	}

	@Then("I should be able to see lightbox with the success message {string}")
	public void i_should_be_able_to_see_lightbox_with_the_success_message(String successString) {
		inboxPagePO.presenceOfSuccessMessage(successString);
	}
	
	@Then("I should be able to see the remove from backup option")
	public void i_should_be_able_to_see_the_remove_from_backup_option() {
	    Assert.assertTrue(inboxPagePO.checkPresenceOfRemoveFromBackup(),
	    		"The remove from the backup icon is not available");
	}

	@When("I read the name of the first candidate")
	public void i_read_the_name_of_the_first_candidate() {
		inboxPagePO.readFirstCandidateName();
	}

	@When("I click on remove from backup inbox")
	public void i_click_on_remove_from_backup_inbox() {
		inboxPagePO.hoverOnRemoveFromBackUp();
	}

	@Then("I should be able to see the options {string},{string} and {string}")
	public void i_should_be_able_to_see_the_options_and(String option1, String option2, String option3) {
	   List<String> actualWebOptions = Arrays.asList(option1, option2, option3);
	   Assert.assertTrue(inboxPagePO.checkForRemoveFromInbox(actualWebOptions), 
			   "The list displayed on the remove from backup is not same as intended");
	}

	@When("I select the option {string}")
	public void i_select_the_option(String removeOptionName) {
		inboxPagePO.clickOnOptionFromRemove(removeOptionName);
	}

	@Then("I should be able to see the success message {string}")
	public void i_should_be_able_to_see_the_success_message(String successMessageText) {
		inboxPagePO.checkForSuccessMessageOnRemovalFromBackup(successMessageText);
	}

	@Then("I should not be able to see the first candidate")
	public void i_should_not_be_able_to_see_the_first_candidate() {
	    Assert.assertTrue(inboxPagePO.checkForAbsenceOfFirstCandidateName(), 
	    		"The candidate name is still displayed in the backup inbox");
	}



}
