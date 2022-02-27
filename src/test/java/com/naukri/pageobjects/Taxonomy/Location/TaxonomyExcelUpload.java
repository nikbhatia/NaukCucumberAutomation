package com.naukri.pageobjects.Taxonomy.Location;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;

public class TaxonomyExcelUpload  extends PageObjectWrapper{
	
	private By btnUpload = By.id("uploadFile");
	public By btnLatestStatus = By.id("viewLatestStatus");
	public By txtSuccessMessage = By.xpath("//span[text()=' Profile Creation Process is now complete.']");
	public By txtUploadProgressMsg = By.xpath("//p[text()='Profile Creation in process. Refresh the screen to view the latest numbers.']");
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Upload Files button
	 */
	public void clickUpload()
	{
		jsUtil.scrollDown(btnUpload);
		click(btnUpload);
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if profile is updated successfully
	 * @return true if profile is updated successfully
	 */
	public boolean verifyProfileIsUploaded()
	{
		 return clickAndCheckElement(btnLatestStatus,btnLatestStatus,5) && isDisplayed(txtSuccessMessage) && !isDisplayed(txtUploadProgressMsg);
	}
	
	/**
	 * This method click on given element and waits for invisibility of eleTocheck
	 * @param elementToClick
	 * @param eleToCheck
	 * @param numberOfAttempts
	 * @return true is eleToCheck is present
	 */
	public boolean clickAndCheckElement(By elementToClick,By eleToCheck, int numberOfAttempts)
	{
		for (int i = 0; i < numberOfAttempts; i++) {
            if (isDisplayed(eleToCheck)) {
                click(elementToClick);
                wait.waitForPageToLoadCompletely();
                TestNGLogUtility.info("File upload successfull");
            }
            else
                return true;
        }
		return false;
	}
	

}
