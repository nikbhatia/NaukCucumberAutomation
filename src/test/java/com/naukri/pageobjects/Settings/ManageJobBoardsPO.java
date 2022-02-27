package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;

public class ManageJobBoardsPO extends BaseAutomation {


	private By btnHelp = By.xpath("//button[text()='Adding a Job Board']"); 
	private By lblBoardName=By.xpath("//div[@class='job-displayname']/h2[text()='${boardName}']");
	
	
	/**
	 * Adding a job board text is visible when clicking on HELP link on manage job board page
	 */
	public boolean verifyHelpLink() {		
		return isDisplayed(btnHelp);
	}
	
	/**
	 * All job boards are visible on Manage Job Boards page
	 */
	public boolean verifyAllBoardsDisplay(String boardName) {		 
		return getElement(lblBoardName,boardName).isDisplayed();	
	}	
}
