package com.naukri.stepdefinitions.CandidateCommunication;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.SendAMessagePagePO;
import com.naukri.pageobjects.CandidateCommunication.CommunicationInboxPO;
import com.naukri.stepdefinitions.Applications.SendAMessageStepDefs;
import com.naukri.stepdefinitions.MLH.RequirementListingPageStepDef;
import com.naukri.stepdefinitions.Settings.ManageGroupStepDef;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nikhil.bhatia
 */

public class CommunicationInboxStepDef  {

    CommunicationInboxPO objCommunicationInboxPO =  new CommunicationInboxPO();
    //CommunicationInboxPO objCommunicationInboxPO = (CommunicationInboxPO) PageObjectWrapper.getObject(CommunicationInboxPO.class);
    SendAMessageStepDefs sendAMessageStepDefs = (SendAMessageStepDefs) PageObjectWrapper.getObject(SendAMessageStepDefs.class);

    String groupName= ManageGroupStepDef.groupName;
    String reqName= RequirementListingPageStepDef.reqName;

    @And("User enter {string} name in search box and select the same")
    public void userselectsValueFromDD(String filterType, DataTable dt) {
        List<String> listFilter=dt.asList(String.class);
        objCommunicationInboxPO.userselectsValueFromDD(listFilter,filterType);

    }

    @When("User clicks on {string} Filter")
    public void userClicksOnFilter(String filtername) {
        objCommunicationInboxPO.userClicksOnFilter(filtername);
    }

    @When("User stores the values of {string} filter from the third layer of All Filter")
    public void storesTheValueOfFilterValue(String filtername) {
        Assert.assertTrue(objCommunicationInboxPO.storesTheValueOfFilterValue(filtername),"chip value is empty for "+filtername+" in the third layer of ALl Filter lightbox");
        TestNGLogUtility.info("Stored the value of" + filtername);

    }

    @Then("User Verify values of chip and {string} filter")
    public void verifyValuesOfChipValuesAndFilterValues(String filterType) {
        objCommunicationInboxPO.verifyValuesOfChipAndFilterDD(filterType);
     }

    @And("User deletes below values from All filters lightbox")
    public void deletesTheValueFromLightBoxOfAllFilter(DataTable dt){
        List<String> list=dt.asList(String.class);
        objCommunicationInboxPO.deletesTheValueFromLightBoxOfAllFilter(list);
        TestNGLogUtility.info("Deleted Values-->"+list);
    }

    @Then("User verifies below items should be {string} in DD list")
    public  void uncheckedItemsVerify(String typename,DataTable dt){
        List<String> listOfUncheckedValue=dt.asList(String.class);
        switch (typename){
            case"unchecked":
                Assert.assertFalse(objCommunicationInboxPO.verifyCheckedValueFromListDD(listOfUncheckedValue));
                TestNGLogUtility.pass("Values Passed From Feature File not selected in DD List-->"+listOfUncheckedValue);
                break;
            case"checked":
                Assert.assertTrue(objCommunicationInboxPO.verifyCheckedValueFromListDD(listOfUncheckedValue));
                TestNGLogUtility.pass("Values Passed From Feature File-->"+listOfUncheckedValue);
                break;
        }
    }


    @And("User clicks on {string} Filter in the first layer of All Filter lightbox")
    public void clickOnFilterLightbox(String filtername){
        objCommunicationInboxPO.clickOnFilterInLightbox(filtername);
        TestNGLogUtility.info("Clicked on the  " + filtername+ " in the ALl Filters Lightbox");
    }

    @Then("User Verifies {string} is displayed on CC Inbox page")
    public void verifyValuesAreDisplayedOrNotOnCCPage(String valuename){
        Assert.assertTrue(objCommunicationInboxPO.verifyValuesAreDisplayedOrNotOnCCPage(valuename),valuename+" is not displayed on CC page");
        TestNGLogUtility.pass(valuename+" is Displayed on the page");
    }

    @Then("User Verifies {string} is displayed in {string} layer of All Filter Lightbox")
    public void verifyValuesAreDisplayedOrNotInAllFilterLightbox(String valuename,String layername){
        Assert.assertTrue(objCommunicationInboxPO.verifyValuesAreDisplayedOrNotInAllFilterLightbox(valuename,layername),valuename+" is not displayed in the "+layername+" layer of All filter lightbox");
        TestNGLogUtility.pass(valuename+" is displayed in the "+layername+" of All Filters Lightbox");

    }

    @Then("User Verify DD list is in alphabetical order")
    public void verifyListIsAlphabetical(){
        Assert.assertTrue(objCommunicationInboxPO.verifyListIsInAlphabetical(),"List is not in the ascending order");
        TestNGLogUtility.pass("Verified Alphabetical Order");
    }

    @And("User Verify results contains requirement name {string} on right facet.")
    public void verifyRequirementName(String expectedRequirementName){
        if(CommunicationInboxPO.RequirementName.equals(null)){
            CommunicationInboxPO.RequirementName=expectedRequirementName;
        }
        Assert.assertEquals(CommunicationInboxPO.RequirementName,objCommunicationInboxPO.getRequirementName(),"Requirement Name for which filter is applied is not visible on right facet in mail");
        TestNGLogUtility.pass("Requirement Name for which filter is applied is visible on right facet in mail");

    }

    @Then("User Verify User is able to see {string} name in the DD List")
    public void verifyUserIsAbleToSeeTheGroupNameInTheGroupDDList(String filtertype) {
        switch (filtertype){
            case"Group":
                Assert.assertTrue(objCommunicationInboxPO.verifyUserIsAbleToSeeTheGroupNameInTheGroupDDList(groupName),groupName+ " is not found in DD list");
                TestNGLogUtility.info("User provided the "+groupName+" in the DD Search area");
                break;
            case"Requirement Name":
                Assert.assertTrue(objCommunicationInboxPO.verifyUserIsAbleToSeeTheGroupNameInTheGroupDDList(reqName),reqName+ " is not found in DD list");
                TestNGLogUtility.info("User provided the "+reqName+" in the DD Search area");
                break;
        }

    }

    @And("User verify when provides name in search area which doesn't exists should get not found in DD List")
    public void notExistsNameInSearchArea(DataTable dt){
        List<String> notExistsName=dt.asList();
        for(String value:notExistsName){
            Assert.assertTrue(objCommunicationInboxPO.notExistsNameInSearchArea(value),"Name Exists in the DD List");
            TestNGLogUtility.pass("Name not Found in the DD List");}
    }

    @Then("Verify user is able to see {string} link on CC Inbox Page")
    public void verifyMoreLink(String number){
        Assert.assertTrue(objCommunicationInboxPO.verifyMoreLink(number),"Values is not displayed on CC Inbox Page");
        TestNGLogUtility.pass("Verified +" +number+" More link");}

    @And("Verify below chiplist is displayed on CC Inbox page")
    public void verifyChipListOnCCInboxPage(DataTable dt){
        List<String> listOfChip=dt.asList();
        Assert.assertTrue(objCommunicationInboxPO.verifyChipListOnCCInboxPage(listOfChip),listOfChip+"Chips are not displayed on CC Inbox page");
        TestNGLogUtility.pass("Verified +" +listOfChip+" More link");}


    @And("User click on More and Select Add Single Profile option on Requirement Overview Page")
    public void selectTheRequirementOnAddSingleProfilePage()
    { objCommunicationInboxPO.selectAddSingleProfileOnRequirementOverView();
        TestNGLogUtility.info("Selected AddSingleProfile On RequirementOverView");
    }

    @And("User selects {string} from the DD List")
    public void userClicksOnTheValueFromTheDDList(String value){
        objCommunicationInboxPO.provideFilterValue(value);

    }

    @And("Verify Mail is listed under Left Facet")
    public void verifyNewThreadFormation(){
        String subject = objCommunicationInboxPO.fillLeftFacetDetails().get("Subject");
        Assert.assertEquals(subject,sendAMessageStepDefs.hmapReturnData.get("MailSubject"));
    }
    @And("User Verifies below values should be displyed in recently used section in DD List")
    public void verifyRecentlyUsedValues(DataTable dt){
        List<String> listOfRecentlyUsedValues=dt.asList();
        Assert.assertTrue(objCommunicationInboxPO.verifyRecentlyUsedValues(listOfRecentlyUsedValues),"Recent searches doesn't match with parameters passed");
        TestNGLogUtility.pass("Verified values is displyed in recently used section in DD List");
    }
    @And("Verify on hover user should see {string} on {string}")
    public void onHoverUserShouldSee(String onhovervalue,String Filtername){
        Assert.assertTrue(objCommunicationInboxPO.onHoverUserShouldSee(onhovervalue,Filtername));
        TestNGLogUtility.info("User is able to see the value on hover");
    }

    @And("Verify Unread mail is displayed on latest mail present in left facet")
    public void verifyUnreadMail(){
        Assert.assertTrue(objCommunicationInboxPO.unreadMailIsDisplayed(),"Unread mail is not displayed on left facet");
        TestNGLogUtility.pass("Unread mail is displayed on left facet");
    }




    @And("Verify requirement name for bulk mail for {string}")
    public void verifyUserisAbleToSeeRequirementNameForBulkMail(String mailtype){
        switch (mailtype){
            case "Requirement Mail":
                Assert.assertFalse(objCommunicationInboxPO.verifyUserisAbleToSeeRequirementNameForBulkMail(),"Requirement Name is not same as expected");
                TestNGLogUtility.pass("Requirement Name is not displayed for Requirement Mail");
                break;
            case "Other":
                Assert.assertTrue(objCommunicationInboxPO.verifyUserisAbleToSeeRequirementNameForBulkMail(),"Requirement Name is not same as expected");
                TestNGLogUtility.pass("Requirement Name is displayed as Expected");
                break;
        }
    }


    @And("Verify User is able to see subject as Mail Heading for {string}")
    public void verifyUserisAbleToSeeSubjectAsMailHeading(String mailtype){
        Assert.assertTrue(objCommunicationInboxPO.verifyUserisAbleToSeeSubjectAsMailHeading(mailtype),"Heading is not same as heading");
        TestNGLogUtility.pass("User is able to see subject as Mail Heading for -->"+ mailtype);

    }


    @And("Verify User is able to see {string} no of recipients on the {string} facet")
    public void verifyUserIsAbleToSeeRecipientsDetailsOnRightFacet(String numberOfRecipients,String facet){
        Assert.assertTrue(objCommunicationInboxPO.verifyUserIsAbleToSeeRecipientsDetailsOnRightFacet(numberOfRecipients,facet),"Number of Recipient is different from expectation");
        TestNGLogUtility.pass("Number of Recipient is same as expected");
    }


    @And("User click on tuple for which bulk mail is sent")
    public void clickOnTupleForWhichBulkMailIsSent(){
        objCommunicationInboxPO.clickOnTupleForWhichBulkMailIsSent();
    }

    @And("User get the requirement name from Cv details page")
    public void getTheRequirementNameFromCVDetailsPage(){
        objCommunicationInboxPO.getTheRequirementNameFromCVDetailsPage();
    }

    @And("User saves the details of the page for CC Bulk")
    public void saveTheDetailsOfThePage(){
        objCommunicationInboxPO.saveTheDetailsOfThePage();
    }

    @When("Verify User is able to see {string} heading on MailRecipient page")
    public void verifyMailRecipientPageHeading(String linkname){
        Assert.assertTrue(objCommunicationInboxPO.verifyMailRecipientPageHeading(linkname));
        TestNGLogUtility.pass("User is able to see-->"+linkname);
    }

    @And("Verify User is able to see {string} application count on MailRecipient page")
    public void verifyApplicationCountOnMailRecipientPage(String count){
        Assert.assertTrue(objCommunicationInboxPO.verifyApplicationCountOnMailRecipientPage(count));
        TestNGLogUtility.pass("Application count on MailRecipient Page is-->"+count);
    }

    @And("User loads the SRP page for CC Bulk")
    public void loadTheSRPPageForCCBulk(){
        objCommunicationInboxPO.loadTheSRPPageForCCBulk();
    }

    @And("User should be able to see {string} when searched with group")
    public void userShouldSeeWhenSearchedWithGroupForBulk(String errormessage){
        Assert.assertTrue(objCommunicationInboxPO.userShouldSeeWhenSearchedWithGroupForBulk(errormessage));
    }

    @And("User selects {string} from recruiters DD on requirement overview page")
    public void selectRecruiterFromDDForVisibility(String recuriterName){
        objCommunicationInboxPO.selectRecruiterFromDDForVisibility(recuriterName);
    }

    @And("User clicks {string} button on requirement overview Visibility lightbox")
    public void clickOnRequirementOverviewVisibilityLightbox(String linkname){
        objCommunicationInboxPO.clickOnRequirementOverviewVisibilityLightbox(linkname);
    }


    @And("Verify User is not able to see subject as Mail Heading for {string}")
    public void verifyUserisNotAbleToSeeSubjectAsMailHeading(String mailtype){
        Assert.assertFalse(objCommunicationInboxPO.verifyUserisAbleToSeeSubjectAsMailHeading(mailtype),"Heading is not same as heading");
        TestNGLogUtility.pass("User is not able to see subject as Mail Heading for -->"+ MailBoxStepDef.mailBodySubject);

    }
}
