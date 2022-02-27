package com.naukri.pageobjects.Requirements;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

/**
 * Manage Job & Responses page object class
 * 
 * @author Himanshu Dua
 *
 */
public class ManageJobResponsesPO extends PageObjectWrapper {

	By linkEditJobUnderJobName = By.xpath(
			"(//table[@id='tabJob']//td/a[contains(text(),'${jobName}')]/following-sibling::p//a[contains(text(),'Edit')])[1]");
	By jobTitle=By.xpath("(//a[contains(text(),'${jobName}')])[1]");
	
	/**
	 * To click on edit job link under Job link
	 */
	public void clickOnEditLinkUnderJob(String jobName) {
		System.out.println("jobName-->> "+jobName);
		hover(parameterizedLocator(jobTitle, jobName));
		click(parameterizedLocator(linkEditJobUnderJobName, jobName));
	}

}
