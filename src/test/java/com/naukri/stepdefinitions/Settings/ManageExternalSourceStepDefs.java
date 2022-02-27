package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageCVBackUpPO;
import com.naukri.pageobjects.Settings.ManageExternalSourcePO;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageExternalSourceStepDefs {
	
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
//	APITestOps APITestObj = new APITestOps();

	ManageExternalSourcePO ManageExternalSourcePOobj = new ManageExternalSourcePO();
	
	
	@And("user fill external source name")
	public void fillExternalSource() {
		String externalSourceName = "External S" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("externalSourceName", externalSourceName);
		ManageExternalSourcePOobj.fillExternalSourceName(externalSourceName);
	}
	
	@Then("verify created external source is visible to user")
	public void verifyManageExternalSourceAdded() {
		String externalSourceName = PropFileHandler.readProperty("externalSourceName");
		Assert.assertTrue(ManageExternalSourcePOobj.verifyManageExternalSourceAdd(externalSourceName),
				"Test case failed : user is not able to see new added External Source "+externalSourceName+"" );
	}
	
	@When("user click on \"([^\"]*)\" option on manage external source listing page")
	public void clickOnOptionExternalSource(String optionOnExternalSource) {
		ManageExternalSourcePOobj.clickOnOptionsExternalSource(optionOnExternalSource);
	}
	
	@And("user input new external source name")
	public void fillNewExternalSource() {
		String externalSourceName = "New External" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("externalSourceName", externalSourceName);
		ManageExternalSourcePOobj.fillNewExternalSourceName(externalSourceName);
	}
	
	@And("user fill same external source name which is already created")
	public void fillSameExternalSourceName() {
		String externalSourceName = PropFileHandler.readProperty("externalSourceName");
		PropFileHandler.writeProperty("externalSourceName", externalSourceName);
		ManageExternalSourcePOobj.fillNewExternalSourceName(externalSourceName);
	}
	
}
