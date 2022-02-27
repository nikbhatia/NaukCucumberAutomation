package com.naukri.stepdefinitions.Requirements;

import com.naukri.pageobjects.Requirements.ManageJobResponsesPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.When;

public class ManageJobResponsesStepDef {
	
	ManageJobResponsesPO mjrPage = (ManageJobResponsesPO) PageObjectWrapper.getObject(ManageJobResponsesPO.class);
	
	@When("User edit the recent created job on MJR")
	public void User_edit_the_recent_created_job_on_MJR() {
		mjrPage.clickOnEditLinkUnderJob(RequirementCreationStepDef.jobTitle);
	}

	@When("User edit the recent created job from jp on MJR")
	public void User_edit_the_recent_created_job_from_jp_on_MJR() {
		mjrPage.clickOnEditLinkUnderJob(JobPostingStepDef.jobHeadingFinal);
	}
}
