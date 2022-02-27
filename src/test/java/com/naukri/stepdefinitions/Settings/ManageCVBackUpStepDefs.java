package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageCVBackUpPO;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageCVBackUpStepDefs {
	
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageCVBackUpPO ManageCVBackUpPOobj= new ManageCVBackUpPO();

	
	@And("user select different criteria for auto backUp setting")
	public void userSelectDifferentActions() {
		ManageCVBackUpPOobj.selectDifferentActions();
	}
	
	@When("user click on \"([^\"]*)\" other than button,link")
	public void userClickOnText(String common) {
		ManageCVBackUpPOobj.clickOnText(common);
	}
	
}
