package com.naukri.pageobjects.Requirements;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import kafka.security.auth.Read;
import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

import java.io.File;

public class addARequirementPO extends PageObjectWrapper{
    By eleAddToRequirementOnPanel = By.id("addToProjectTrig");
    By chkAddNewReq = By.id("chkCreateNew");
    By txtRequirementTitle = By.id("projectName");
    By btnAddToRequirement = By.id("download");
    By DDChooseFromReq = By.id("inp_projectList");
    By secondRequirementFromDD = By.xpath("(//ul[@id='ul_projectList']//li)[2]");
    By eleRequirement = By.xpath("(//div[@class='pt10']//a)[1]");
    By addToReqLightbox = By.xpath("//p[text()='Add to Requirement']");
    By eleApplicationCount = By.xpath("(//div[@class='proCount cle']//a)[1]");
    By getFirstEmailOnSRP = By.xpath("(//span[@id='emailIdForDisplay'])[1]");
    By requirementNameOnOverviewPage = By.xpath("//div[text()=' ${string} ']");
    By txtsearchOnResultsPage= By.id("keywordSearch");
    By btnSearchOnResultPage = By.id("searchKeyword");
    By eleRequirementIdOnOverviewPage = By.xpath("(//div[@class='hText fl']//span)[3]");
    By eleMoreOption = By.xpath("//div[@class='menu1 pRel fl']//a[text()=' More ']");
    By eleAddToReq = By.id("addToProjectTrig");

    public static String requirementOverviewPageURL = null;
    GenericFunctions genericFunctions = new GenericFunctions();

    public void clickAddToRequirement()
    {
    	wait.hardWait(2);
        hover(eleMoreOption);
    	wait.waitForVisibilityOfElement(eleAddToReq);
        click(eleAddToReq);
    }
    public void chooseSecondFromExistingReqDD()
    {
    	click(DDChooseFromReq);
    //	wait.waitForVisibilityOfElement(secondRequirementFromDD);
    	String getRequirementName = getText(secondRequirementFromDD).substring(0,getText(secondRequirementFromDD).indexOf(" | "));
    	ReadWritePropertyFile.setProperty("requirementTitleFRomAddToREq",getRequirementName,fileSystemPathTillTestData() + "Data.properties");
    	click(secondRequirementFromDD);
    }
    public void clickApplicationCount()
    {
    	wait.waitForVisibilityOfElement(eleApplicationCount);
    	click(eleApplicationCount);
        wait.waitForPageToLoadCompletely();
    }
    public static String fileSystemPathTillTestData() {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "testdata" + File.separator;
        return filePath;
    }
    public boolean addToRequirementLightboxVisible()
    {
        wait.waitForPageToLoadCompletely();
        return isDisplayed(addToReqLightbox);
    }
    public void clickOncheckAddNewReq()
    {
        wait.waitForVisibilityOfElement(chkAddNewReq);
        click(chkAddNewReq);
    }
    public void enterTxtReqTitle()
    {
        String requirementTitle = GenericFunctions.generateRandomStrings(6, "String");
        ReadWritePropertyFile.setProperty("requirementTitleFRomAddToREq",requirementTitle,fileSystemPathTillTestData() + "Data.properties");
        sendKeys(txtRequirementTitle,requirementTitle);
    }
    public void clickBtnAddToRequirement()
    {
        click(btnAddToRequirement);
        wait.waitForPageToLoadCompletely();
    }
    public void selectFirstReqfromDD() {
        click(DDChooseFromReq);
        wait.waitForVisibilityOfElement(secondRequirementFromDD);
        click(secondRequirementFromDD);
    }
    public boolean verifyNameOfRequirementOnLightbox()
    {
        wait.waitForVisibilityOfElement(eleRequirement);
        String expectedRequirementName = ReadWritePropertyFile.getProperty("requirementTitleFRomAddToREq",fileSystemPathTillTestData() + "Data.properties");
        String ActualRequirementTitle = getText(eleRequirement).split(" ")[1];
        String expectedRequirementIdCreated = getText(eleRequirement).split(" ")[0];
        ReadWritePropertyFile.setProperty("expectedRequirementIdCreated",expectedRequirementIdCreated , fileSystemPathTillTestData() + "Data.properties");
        return ActualRequirementTitle.contains(expectedRequirementName);
    }
    public void userNotesTheRequirementIdOfProject() 
    	{
    	String expectedRequirementIdCreated =getText(eleRequirementIdOnOverviewPage); 
    			//getText(eleRequirement).split(" ")[0];
        ReadWritePropertyFile.setProperty("RequirementIdOfPreviousReq",expectedRequirementIdCreated , fileSystemPathTillTestData() + "Data.properties");
    	}
    
    public void clickRequirementNameOnLightbox()
    {
        click(eleRequirement);
    }
    public void verifyRequirementIdOnPage()
    {
    	String expectedReqId = ReadWritePropertyFile.getProperty("expectedRequirementIdCreated", fileSystemPathTillTestData() + "Data.properties");
    }
    public void getTheFirstApplicationEmail()
    {
        String getapplicationEmailId= getAttribute(getFirstEmailOnSRP,"title");
        ReadWritePropertyFile.setProperty("expectedCandidateEmailId",getapplicationEmailId,fileSystemPathTillTestData() + "Data.properties");
    }
    public boolean redirectedTorequirementOverviewPageAfterAddtoreq()
    {
        String expectedRequirementName = ReadWritePropertyFile.getProperty("requirementTitleFRomAddToREq",fileSystemPathTillTestData() + "Data.properties");
        wait.waitForPageToLoadCompletely();
        return isDisplayed(parameterizedLocator(requirementNameOnOverviewPage,expectedRequirementName));
    }
    public boolean verifyCandidateDisplayedOnProjectInbox()
    {
        String candidateEmailId = ReadWritePropertyFile.getProperty("expectedCandidateEmailId",fileSystemPathTillTestData() + "Data.properties");
        switchToChildWindow();
        return genericFunctions.waitTillDesiredCandidateTupleIsPresent(candidateEmailId);
    }
    public boolean verifyNameoFExistingReq()
    {
    	String expectedRequirementName = ReadWritePropertyFile.getProperty("requirementTitleFRomAddToREq",fileSystemPathTillTestData() + "Data.properties");
    	 String ActualRequirementTitle = getText(eleRequirement).split(" ")[1];
    	 return expectedRequirementName.contains(ActualRequirementTitle);
    }	
    public boolean verifyTheRequirementIDDsiplayedIsCorrectOnPageAndURL()
    {
    	String expectedRequirementIdCreated = getText(eleRequirementIdOnOverviewPage); 
    	String reqintegerNo = expectedRequirementIdCreated.split("-")[2];
    	String reqTextAndYearComponent = expectedRequirementIdCreated.replace(reqintegerNo,"");
    	int PreviousRequirementCount = Integer.parseInt(reqintegerNo) -1;
    	String previousReqString = Integer.toString(PreviousRequirementCount);
    	String expectedPreviousSeries = reqTextAndYearComponent + previousReqString;
    	String expectedRequirementId =ReadWritePropertyFile.getProperty("RequirementIdOfPreviousReq", fileSystemPathTillTestData() + "Data.properties");
    	return expectedRequirementId.contains(expectedPreviousSeries);
    }
}
