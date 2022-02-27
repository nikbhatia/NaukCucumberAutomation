package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.pageobjects.Offer.NewOfferGenerationPO;
import com.naukri.pageobjects.Offer.OfferApprovalProcessPO;
import com.naukri.pageobjects.Offer.OfferSettingsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class NewOfferGenerationStepDef {
	NewOfferGenerationPO NewOfferObject = (NewOfferGenerationPO) PageObjectWrapper.getObject(NewOfferGenerationPO.class);

	@When("uncheck the switch Offer generation module on settings page")
	public void uncheckSwitchOfferGenerationModule()
	{
		NewOfferObject.uncheckSwitchOfferGenerationModuleSettingsPage();
	}
	@When("click on set offer generation settings")
	public void setOfferGenerationSettings()
	{
		NewOfferObject.setOfferGenerationSettings();
	}
}