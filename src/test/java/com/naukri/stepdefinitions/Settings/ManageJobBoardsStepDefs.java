package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;

import io.cucumber.datatable.DataTable;

public class ManageJobBoardsStepDefs {
	
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
//	APITestOps APITestObj = new APITestOps();

	ManageJobBoardsPO ManageJobBoardsActionObj = new ManageJobBoardsPO();
	
	
	
	@Then("verify user is navigated to Adding a Job Board")
	public void VerifyHelpLinks() {
	Assert.assertTrue(ManageJobBoardsActionObj.verifyHelpLink(),
			"Test case failed : As user is not able to see help link for job boards");
	}
	
	
	@Then("verify user able to see the below listed job boards")
	public void verifyJobBoards(DataTable boardName) {
		List <String> lst = boardName.asList(String.class);
		for (int i =0;i<lst.size();i++) {
			Assert.assertTrue(ManageJobBoardsActionObj.verifyAllBoardsDisplay(lst.get(i)),
					"Test case failed : As user is not able to see all job boards");
		}				
	}
	
}