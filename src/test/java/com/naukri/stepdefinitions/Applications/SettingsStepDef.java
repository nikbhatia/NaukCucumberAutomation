package com.naukri.stepdefinitions.Applications;

import com.naukri.pageobjects.Applications.SettingsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SettingsStepDef {
	
	SettingsPagePO settingsPagePO = (SettingsPagePO) PageObjectWrapper.getObject(SettingsPagePO.class);
	
	@When("I click on add a new template option")
	public void i_click_on_add_a_new_template_option() {
	   settingsPagePO.clickOnAddNewTemplate();
	}

	@When("I select the {string} option")
	public void i_select_the_option(String mailTemplateName) {
	    settingsPagePO.selectMailTemplateOption(mailTemplateName);
	}

	@When("I click on Next button on template selection popup")
	public void i_click_on_Next_button_on_template_selection_popup() {
		settingsPagePO.clickNextOnMailTemplatePopUp();
	}

	@When("I fill in the {string} of the mail")
	public void i_fill_in_the_of_the_mail(String mailTextDiv) {
		settingsPagePO.fillInMailTemplateField(mailTextDiv);
	}

	@When("I click on save button on the lightbox")
	public void i_click_on_save_button_on_the_lightbox() {
	    settingsPagePO.clickOnSaveOnMailTemplate();
	}

	

}
