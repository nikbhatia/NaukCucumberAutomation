package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageCVBackUpPO;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.pageobjects.Settings.ManageWatermarkPO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageWatermarkStepDefs {
	
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
//	APITestOps APITestObj = new APITestOps();

	ManageWatermarkPO ManageWatermarkPOobj= new ManageWatermarkPO();
	
	@When("user turn on add watermark setting and set it at default position and opacity")
	public void TurnOnAddWatermarkSetting() {
		ManageWatermarkPOobj.TurnOnAddWatermarkSettings();	
	}

}
