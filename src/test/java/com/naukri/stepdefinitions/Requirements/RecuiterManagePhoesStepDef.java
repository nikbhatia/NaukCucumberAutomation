package com.naukri.stepdefinitions.Requirements;

import java.util.List;

import com.naukri.pageobjects.Requirements.RecruiterManagePhotosPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RecuiterManagePhoesStepDef {
	static int totalVideos=0;
	RecruiterManagePhotosPagePO recruiterManage= (RecruiterManagePhotosPagePO) PageObjectWrapper.getObject(RecruiterManagePhotosPagePO.class);
	
	@When("User upload more than 5 photos from system on recruiter page")
	public void User_upload_more_than_5_photos_from_system_on_recruiter_page() {
		recruiterManage.chooseFile();
	}
	
	@When("User select all the photoes from recruiter page")
	public void User_select_all_the_photoes_from_recruite_rpage() {
		recruiterManage.selectAllPhotoes();
	}
	
	@When("User count total Number of Added video")
	public void User_count_total_Number_Added_video() {
		totalVideos= recruiterManage.totalAddedVideo();
	}
	
	@When("User click on {string} button and add video urls")
	public void User_add_video_urls(String btn, DataTable dataTable) {
		List<String> Urls = dataTable.asList(String.class);
		for (String Url : Urls)
		recruiterManage.addURL(btn,Url);
	}
	
	@When("User click on {string} button for delete all the added video or photos")
	public void User_delete_all_the_added_video_or_photos(String btn) {
		recruiterManage.deleteAllVideos(btn);
	}
}
