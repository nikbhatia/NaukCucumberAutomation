package com.naukri.pageobjects.Reports;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.PageObjectWrapper;

public class GenericFunctions extends PageObjectWrapper {
    
    //locators for the webelements on the page
    public static By username_txt = By.id("userName");
    public static By password_txt = By.id("pass");
    public static By login_btn = By.xpath("//input[contains(@class , \"blue_btn\")]");
    By lnkViewAll = By.xpath("//a[text()=' View All ']//parent::div//parent::div//span[text()='${reportName}']");
    By btnReload = By.xpath("//a[text()='Reload']");
    
    //URLs of RMS
    public String dashboardURL = YamlReader.getAppConfigValue("URLs.adminDashboard");
    
    public void launchSpecificURL(String url) {
        driver.get(url);
        TestNGLogUtility.info(url + " launched");
    }
    
    // The method logs in to RMS
    public void loginToRMS(String url, String username , String password) {
        driver.get(url);
        TestNGLogUtility.info("User launched " + url);
        getElement(username_txt).click();
        getElement(username_txt).clear();
        getElement(username_txt).sendKeys(username);
        getElement(password_txt).clear();
        getElement(password_txt).sendKeys(password);
        getElement(login_btn).click();
        driver.get(url);
        TestNGLogUtility.info("User Logged into RMS to " + url);
    }
    
    /**
     * This method clicks on Reload button for report
     * @param reportName
     */
    public void reloadReportIfReloadDisplayed(String reportName)
    {
    	int temp = 4;
    	wait.waitForPageToLoadCompletely();
    	wait.waitForValignWrapperToDisappear(2, 4);
    	while(temp>0 && !isDisplayed(parameterizedLocator(lnkViewAll, reportName))) 
    	{
    		if(!isDisplayed(parameterizedLocator(lnkViewAll, reportName)))
    			if(isDisplayed(btnReload)) 
    			{
    				click(btnReload);
    				wait.waitForVisibilityOfElement(parameterizedLocator(lnkViewAll, reportName));
    				TestNGLogUtility.info("User reload report");
    			}
    		--temp;
    	}
    	wait.waitForValignWrapperToDisappear(2, 4);
    	
    }

}
