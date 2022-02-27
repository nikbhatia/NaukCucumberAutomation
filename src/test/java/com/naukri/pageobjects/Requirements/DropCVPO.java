package com.naukri.pageobjects.Requirements;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.WaitUtility;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class DropCVPO extends PageObjectWrapper {

    By btnAddNewCategory = By.id("createCategory");
    By txtCategoryName = By.id("categoryName");
    By txtNewEmail = By.id("addNewEmailValueCS");
    By btnNewEmail = By.id("addNewEmailCS");
    By eleEmailSelected = By.className("tagTxt");
    By btnSaveCategory = By.id("dropCvSave");
    By eleCategoryNameListing = By.xpath("//a[@title='${string}']");
    String newEmail = "test"+ System.currentTimeMillis()+"@yopmail.com";
    By ddQuestionaire = By.id("inp_createQuestionnairedd");
    By eleFIrstQuestionaire = By.xpath("(//ul[@id='ul_createQuestionnairedd']//a)[1]");
    By eleOptionOnListingpage = By.xpath("//a[text()='${string}']/ancestor::div[@class='listWrap']//a[text()='${string}']");
    By eleQuestionaireOnLightbox = By.id("questName");
    By eleremoveQuestionaire = By.id("removeQuest");
    By eleAddNewQuestionaire = By.id("c_quest");
    By DDExistingQuestionaireOnLightbox = By.id("inp_createQuestionnaireddCreateCat");
    By eleFirstQuestionaireOnLigghtbox = By.xpath("(//ul[@id='ul_createQuestionnaireddCreateCat']//a)[1]");
    By txtQuickSearch = By.xpath("//input[@id='keywords']");
    By btnSearchOnListing = By.xpath("(//input[@class='qSearch sub'])[2]");
    By btnCloseCategory = By.id("CloseSingle");
    By btnReopenCategory = By.xpath("//a[text()='${string}']/ancestor::div[@class='topHead']/following-sibling::p//a");
    By eleDropCVs = By.xpath("//ul[@class='tabing fl']//a");
    By eleSelectApplicationsInOneCategory = By.xpath("//div[@class='profile']//a[contains(@href,'153254')]");
    By eleRequirementNameOnDashboard = By.xpath("(//p[@class='info'])[1]");
    By lnkRecruitmentSolun= By.id("headerTwoRecruiter");
    


    public void clickONAddNewcategory()
    {
        click(btnAddNewCategory);
    }
    public void enterNameofCategory()
    {
        String categoryName = "Test_Category Name " + System.currentTimeMillis();
        sendKeys(txtCategoryName,categoryName);
        PropFileHandler.writeProperty("NameOfCategory",categoryName);
    }
    public void enterEmailIdToFOrwardResponse()
    {
        sendKeys(txtNewEmail,newEmail);
        click(btnNewEmail);
    }
    public boolean verifyEmailSelected()
    {
        return getText(eleEmailSelected).contains(newEmail);
    }
    public void clickSaveCategory()
    {
        click(btnSaveCategory);
    }
    public boolean verifyCategoryDisplayedUnderListing()
    {
        String categoryName = PropFileHandler.readProperty("NameOfCategory");
        return waitForElementtoBeDisplayedAfterRefresh(parameterizedLocator(eleCategoryNameListing,categoryName));

    }
    public void usrSelectsExistingQuestionaireFRomDD()
    {
        click(ddQuestionaire);
        String ExistingFirstCategory = getText(eleFIrstQuestionaire);
        PropFileHandler.writeProperty("firstQuestionaireName",ExistingFirstCategory);
        
        click(eleFIrstQuestionaire);

    }
    public void clickOnOptionListingpage(String option)
    {
        String categoryName = PropFileHandler.readProperty("NameOfCategory");
        click(parameterizedLocator(eleOptionOnListingpage,categoryName,option));
    }
    public static String fileSystemPathTillTestData() {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "testdata" + File.separator;
        return filePath;
    }
    public boolean verfiyFIrstQuestionairename()
    {
        String questionaireNameExpected = ReadWritePropertyFile.getProperty("questionaireName",fileSystemPathTillTestData() + "Data.properties");
        return questionaireNameExpected.contains(getText(eleQuestionaireOnLightbox));
    }
    public void removeQustionaireFRomCategory()
    {
        click(eleremoveQuestionaire);
    }
    public boolean verifyQuestionaireNotDisplayedOnlIghtbox()
    {
        return !isDisplayed(eleQuestionaireOnLightbox) && isDisplayed(eleAddNewQuestionaire);
    }
    public void selectExistingQuestionaireOnLightbox()
    {
        click(DDExistingQuestionaireOnLightbox);
        click(eleFirstQuestionaireOnLigghtbox);
    }
    public void searchCategoryOnPage() {
        jsUtil.scrollUp();
        String categoryName = PropFileHandler.readProperty("NameOfCategory");
        click(txtQuickSearch);
        sendKeys(txtQuickSearch,categoryName);
        click(btnSearchOnListing);
    }
    public void updateCategoryName()
    {
        String categoryName = "Updated_Category Name " + System.currentTimeMillis();
        clearField(txtCategoryName);
        sendKeys(txtCategoryName,categoryName);
        PropFileHandler.writeProperty("NameOfCategory",categoryName);
    }
    public void closeCategoryCOnfirmation()
    {
        click(btnCloseCategory);
    }
    public boolean verifyCategoryMarkedclosed()
    {
        //String categoryName = "Test_Category Name " + System.currentTimeMillis();
        String categoryName = PropFileHandler.readProperty("NameOfCategory");
        return isDisplayed(parameterizedLocator(btnReopenCategory,categoryName));
    }
    public boolean verifyCareerSiteAndRefferalOnCV()
    {
        List<WebElement> listOfOptionsOnUi = getElements(eleDropCVs);
          return   listOfOptionsOnUi.get(0).getText().contains("Careersite") && listOfOptionsOnUi.get(1).getText().contains("Referral");
        }
        public void selectcategoryWithApplicationsMapped(String category)
        {
            jsUtil.scrollUp();
            click(txtQuickSearch);
            sendKeys(txtQuickSearch,category);
            click(btnSearchOnListing);
            click(eleSelectApplicationsInOneCategory);
        }
        public boolean verifyProjectInboxPageDisplayed()
        {
            switchToChildWindow();
            return getCurrentURL().contains("profile/project/inbox/153254");
        }
        public boolean verifyRequirementNotification()
        {
            wait.waitForPageToLoadCompletely();
            return getText(eleRequirementNameOnDashboard).contains(RequirementCreationPagePO.requirementName);
        }
        public void clickOnRecruitmentSolnLink()
        {
           click(lnkRecruitmentSolun);
        }

}
