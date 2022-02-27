package com.naukri.pageobjects.Requisition;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.test.base.BaseAutomation;
import org.openqa.selenium.By;

import java.io.File;

public class RequisitionOverviewPO extends BaseAutomation {
    By eleRequisitionName = By.xpath("//div[text()='${string}']");
    By elejobTitle = By.xpath("//div[contains(@class,'jobTitle')]");
    By eleDescriptionBox = By.xpath("//div[text()='${string}']/following-sibling::div");
    By eleKeySkill = By.className("tabLIBlue");
    By eleExperience = By.xpath("(//span[@class='expIconWr']//span)[2]");
    By eleSalary = By.xpath("(//span[@class='salIconWr']//span)[3]");
    By eleLoc = By.xpath("//span[@class='locationIcon']/following-sibling::span");
    By eleReqSection = By.xpath("(//div[@class='rh_pageHead-row-item'])[${string}]");
    By eleRequisitionId = By.className("rh_requisition-id");
    By btnApprove = By.xpath("//li[@class='btn Approve']");
    By btnReject = By.xpath("//li[@class='btn Reject']");
    By eleCurrentApprovalStage= By.xpath("//div[text()='Current Approval Stage']/parent::div//div[@class='approverName']");
    By eleMessageOnOverview = By.xpath("//div[@class='msg']");
    By btnOverviewPage = By.xpath("//*[text()='${string}']");



    public boolean verifyRequisitionDetailsOnPage()
    {
        switchToChildWindow();
        wait.waitForVisibilityOfElement(parameterizedLocator(eleRequisitionName,"Requisition Name"));
        return isDisplayed(parameterizedLocator(eleRequisitionName,"Requisition Name")) &&
                getText(elejobTitle).contains("Testing Engineer") &&
                getText(parameterizedLocator(eleDescriptionBox,"Job Description")).contains("Job Description") &&
                getText(parameterizedLocator(eleDescriptionBox,"Desired Candidate Details")).contains("Candidate Profile") &&
                getText(eleKeySkill).contains("Selenium") && getText(eleExperience).contains("1 - 3") &&
                getText(eleSalary).contains("50,000 - 70,000") && getText(eleLoc).contains("Ahmedabad");
    }
    /**
     * file System Path till testdata folder
     *
     * @return path till testdata
     */
    public static String fileSystemPathTillTestData() {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "testdata" + File.separator;
        return filePath;
    }
    public boolean verifyReqSectionOnPage(String status)
    {
    	 String expectedGroupName = PropFileHandler.readProperty("FirstGroupName");
       
        return getText(parameterizedLocator(eleReqSection,"1")).contains("You") &&
                getText(parameterizedLocator(eleReqSection,"3")).contains(status) &&
                getText(parameterizedLocator(eleReqSection,"4")).contains(expectedGroupName.trim()) &&
                getText(parameterizedLocator(eleReqSection,"5")).contains("varun.singh@naukri.com");

    }
    public boolean verifyRequisitionIdONPage()
    {
        String expectedRequisitionId = "rs-" + ReadWritePropertyFile.getProperty("RequirementTrackingId",
                fileSystemPathTillTestData() + "Data.properties");
        return getText(eleRequisitionId).contains(expectedRequisitionId);
    }
    public boolean verifyRequisitionIdOnUrl()
    {
        String expectedRequisitionId = "rs-" + ReadWritePropertyFile.getProperty("RequirementTrackingId",
                fileSystemPathTillTestData() + "Data.properties");
        return getCurrentURL().contains(expectedRequisitionId);
    }
    public void clickApproveOnOverviewPage()
    {
    	//jsUtil.scrollUp();
        wait.waitForVisibilityOfElement(btnApprove);
//        jsUtil.clickByJS(btnApprove);
        getElement(btnApprove).click();
        wait.hardWait(2);
    }
    public void clickRejectOnOverviewPage()
    {
        switchToChildWindow();
        wait.waitForVisibilityOfElement(btnReject);
//        jsUtil.clickByJS(btnApprove);
        getElement(btnReject).click();
        wait.hardWait(2);

    }
    public boolean verifyStatusOfRequisiton(String status)
    {
    	switchToChildWindow();
    	wait.hardWait(2);
        return getText(parameterizedLocator(eleReqSection,"3")).contains(status);
    }
    public boolean verifyCurrentApprovalStage(String recName)
    {
        switchToChildWindow();
        scrollToElement(eleCurrentApprovalStage);
        //jsUtil.scrollDown(eleCurrentApprovalStage);
        return getText(eleCurrentApprovalStage).contains(recName);
    }
    public boolean verifyMessageOnOverviewPage(String message)
    {
        return getText(eleMessageOnOverview).contains(message);
    }
    public boolean verifyBtnVisibleOnOverviewPage(String btnText)
    {
        switchToChildWindow();
        return isDisplayed(parameterizedLocator(btnOverviewPage,btnText));
    }
    public void clickOnBtnOnRqOverviewPage(String button)
    {
        switchToChildWindow();
        click(parameterizedLocator(btnOverviewPage,button));
    }
}
