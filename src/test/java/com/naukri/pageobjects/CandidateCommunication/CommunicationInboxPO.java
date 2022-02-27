package com.naukri.pageobjects.CandidateCommunication;


import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.MongoDBConnector;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.stepdefinitions.CandidateCommunication.MailBoxStepDef;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.naukri.automation.util.MongoDBConnector.UpdateValuesInMongoDocument;
import static com.naukri.automation.util.MongoDBConnector.getJSONObject;

/**
 * Communication Inbox Generic Functions
 *
 * @author nikhil.bhatia
 */

public class CommunicationInboxPO extends BaseAutomation {

    public By eleRequirementNameOnMailBox = By.xpath("//div[@class='rp__candidate-info-ext']//div[2]");
    public By txtSearch=By.xpath("//div[contains(@class,'dropdownMainContainer focus')]//input");
    public By eleSearchedText=By.xpath("//ul[contains(@class,'dropdown')]//li[contains(@title,'${textToBeSearched}')]|//ul[contains(@class,'dropdown')]//li[contains(@title,'Does not include Offers & Interview')]");    public By filterType=By.xpath("//span[contains(text(),'${Group}')]");
    public By buttonFilter= By.xpath("//button[contains(text(),'${Unread}')]");
    public By listfilterChip= By.xpath("//span[contains(text(),'${Group}')]//following::div[1]//div[@class='chip-label']");
    public By linkMore=By.xpath("//button[@class='fp__applied-filters-more']");
    public By listDDChecked=By.xpath("//li[contains(@class,'multi selected')]");
    public By eleFilterLightbox=By.xpath("//div[@class='modalBody']//following::div[text()='${name}']//following::button[1]");
    public By eleFilterName=By.xpath("//div[contains(@class,'afl__selection-sec-head')]//span[contains(text(),'${Group}')]");
    public By listFilterDD=By.xpath("//li[contains(@class,'multi')]");
    public By eleInboxHeading = By.xpath("//div[@class='fp__heading']");
    public By btnGenericXpath = By.xpath("//button[text()='${Text}']");
    public By eleMailboxLnkGNB = By.xpath("//a[text()='${Text}']");
    public By eleFirstTupleSentTab = By.xpath("//div[@class=\"app-list__item\"]/li[1]");
    public  By eleMoreLink=By.xpath("//button[@class='fp__applied-filters-more']");
    public By listChipOnCCPage=By.xpath("//div[@class='fp__applied-filters-chips']//div");
    public By elename=By.xpath("//li[contains(@title,'${AAA}')]");
    public By eleNotFound=By.xpath("//li[@class='notFound']");
    public By eleRequirementDetailsTab = By.xpath("//a[@id='smtabRequirement']");
    public By eleCandidateNameLeftFacet = By.xpath("(//div[@class='lp__application-name'])[1]");
    public By eleRequirementNameLeftFacet = By.xpath("(//div[@class='lp__application-desc'])[1]");
    public By eleSubjectLeftFacet = By.xpath("(//div[@class='lp__application-sub'])[1]");
    public By eleSubjectRightFacet = By.xpath("//div[@class='tdc__subject']");
    public By eleMailBodyRightFacet = By.xpath("//td[@id='mailBodyData']");
    public By eleCurrentDesignationRightFacet = By.xpath("//span[@class='rp__candidate-cd']");
    public By eleCandidateCurrentCompanyRightFacet = By.xpath("//span[@class='rp__candidate-cc']");
    public By eleRequirementLocationRightFacet = By.xpath("//div[@class='ellipsis rp__candidate-info-ext-city']/span");
    public By eleRequirementStatusRightFacet = By.xpath("//div[@class='ellipsis rp__candidate-info-ext-res']/span");
    public By eleCandidateCurrentStageRightFacet = By.xpath("//div[@class='rp__candidate-info-ext-status ellipsis']");
    public By eleRequirementNameRightFacet = By.xpath("//div[@class='ellipsis rp__candidate-info-ext-req']");
    public By eleCandidatePhoneNumberRightFacet = By.xpath("//span[@class='rp__candidate-ic-val']");
    public By eleFirstTupleLeftFacet = By.xpath("(//div[@class=\"app-list__item\"]/li)[1]//div");
    public By eleCandidateNameRightFacet = By.xpath("//div[@class=\"rp__candidate-name ellipsis\"]");
    public By eleFromFieldRightFacet = By.xpath("//div[@class=\"tm__header-sender\"]/span");
    public By eleToFieldRightFacet = By.xpath("//div[@class=\"tm__header-to\"]");
    public By eleCCFieldRightFacet = By.xpath("//div[@class=\"tm__header-cc\"]");
    public By eleRequirementIdDD=By.xpath("//a[contains(text(),'${req}')]");
    public By txtRequirementDDOnAddProfilePage=By.xpath("//div[@id='addToProjectSection']//following::div[@class='ddwn w451']//input[@class='srchTxt']");
    public By eleReplyAll = By.xpath("(//div[@class='tm__actions'])[1]/img");
    public By eleSuccessMessage = By.xpath("//div[@class='msg']");
    public By eleCandidatePhotoLeftFacet = By.xpath("(//img[@class='lp__application-image'])[1]");
    public By eleCandidatePhotoRightFacet = By.xpath("//img[@class='rp__application-photo']");
    public By eleReply = By.xpath("(//img[@title='Reply'])[1]");
    public By eleActiveTab = By.xpath("//button[@class='tab__item tab__item--active']");
    public By eleRightFacet = By.xpath("//div[@class='right-panel-main']");
    public By eleSearchSuggestions = By.xpath("//div[@class='sb__search-title']");
    public By eleSearchBar = By.xpath("//input[@class='fp__search']");
    public By lblCandidates = By.xpath("//div[contains(text(),'Candidates')]");
    public By lblSubjectLines = By.xpath("//div[contains(text(),'Subject Lines')]");
    public By eleFirstCandidateSuggestion = By.xpath("(//div[@class='sb__search-title'])[1]");
    public By eleFirstSubjectLineSuggestion = By.xpath("(//div[contains(text(),'Subject Lines')]//following::div[@class='sb__search-title'])[1]");
    public By lnkAllCandidateName = By.xpath("//div[contains(@title,'All candidates ')]");
    public By lnkAllSubjectLines = By.xpath("//div[contains(@title,'All subject ')]");
    public By eleSuggestionNotFound = By.xpath("//span[@class='sugNotFound']");
    public By eleCheckInDDList = By.xpath("//li[starts-with(@class,'multi selected  active') and @title='${name}']|//li[starts-with(@class,'multi selected') and @title='Does not include Offers & Interview']");    public By eleMore=By.xpath("//a[contains(text(),'More')]");
    public By eleAddSingleProfile=By.xpath("//a[@class='addSingleCandidate']");
    public By eleHighlightedCandidateNameLeftFacet = By.xpath("(//div[@class='lp__application-name'])[1]//span[@class='gci-h-light']");
    public By eleHighlightedSubjectLeftFacet = By.xpath("(//div[@class='lp__application-sub'])[1]//span[@class='gci-h-light']");
    public By eleHighlightedSubjectRightFacet = By.xpath("//div[@class='tdc__subject']//span[@class='gci-h-light']");
    public By eleTodayLeftFacet = By.xpath("//div[contains(text(),'Today')]");
    public By eleMailTimeLeftFacet = By.xpath("(//div[@class=\"lp__mail-time\"])[1]");
    public By eleMailTimeRightFacet = By.xpath("(//div[@class=\"tm__time\"])[1]");
    public By eleThreeDots = By.xpath("//img[@class = 'tm__body-parentMsg-ind']");
    public By eleMoveToNextMail = By.xpath("//span[@class = 'tm__body-pMsg-mail']");
    public By eleHighlightExistingMail = By.xpath("//span[@class = 'tm__body-pMsg-mail']");
    public By lblAttachment = By.xpath("//div[@class='tm__atchs-label']");
    public By eleDownloadLink = By.xpath("//span[@class='atcmnt-name']/following-sibling::img");
    public By eleAttachmentName = By.xpath("//span[@class='atcmnt-name']");
    public By eleMailDelayWarningStrip = By.xpath("//span[contains(text(),'Last mail is on its way.')]");
    public By eleHoverStatusChangeMail=By.xpath("//li[@title='${Does not include Offers & Interview}']");
    public By elefilter=By.xpath("//li[contains(text(),'${Status Change Email}')]");
    public By eleRequirementID= By.xpath("//div[@class='pb5 pt5']//a");
    public By eleRecentlyUsed=By.xpath("//li[contains(text(),'${Recently Used}')]");
    public By eleUnreadMail = By.xpath("(//div[@class=\"lp__unread-badge\"])[1]");
    public By eleAutomaticMailerStage= By.xpath("//div[contains(text(),'${Prospect}')]");
    public By eleRequirementNameOnCVDetail = By.xpath("//small[contains(@class,'viewIc')]/following-sibling::a");
    public By eleArrow=By.xpath("//small[contains(@class,'dropArrow mt5')]");
    public By eleRequirementStatus=By.xpath("//a[contains(text(),'${Open}')]");
    public By eleStatusOnCCPage=By.xpath("//span[contains(text(),'${Open}')]");
    public By eleCancelButton=By.xpath("//input[@id='CloseSingle']");

    public By getEleRequirementNameOnMailBox=By.xpath("//div[@title='${requirementname}'][1]");
    public By txtSubjectHeadingRightFacet=By.xpath("//div[@class='rp__bulk-thread-header']//div[contains(text(),'${subjetc}')]");
    public By txtSubjectHeading=By.xpath("//div[contains(text(),'${subject}')][1]");
    public By txtRecipients=By.xpath("//button[contains(text(),'${recipient}')][1]");
    public By eleRequirementName= By.xpath("//div[@class='pb5 pt5']//a[1]");
    public By eleCountOnMailRecipient=By.xpath("//p[contains(text(),'${count}')]");

    public By txtRecruiterForVisibility=By.xpath("//li[@class='frst']//input[@id='recIdsForVisibilitySetting']");
    public By eleDDRecruiterForVisibility= By.xpath("//li[@class='pickVal active']");






    //variables
    ArrayList<String>chipValues;
    ArrayList<String>chipValuesOnCCInboxPage=new ArrayList<>();
    public static Map<String, String> candidateInfoOnMailboxPage = new HashMap<>();
    Map<String, List<String>> hmapFilterData = new HashMap<>();
    public  static String RequirementName=null;

    GenericFunctions genericFunctions=(GenericFunctions)PageObjectWrapper.getObject(GenericFunctions.class);
    CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
    //MongoDBConnector mongoDBConnector = new MongoDBConnector();
    MailBoxTabPO mailBoxTabPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
    //MailBoxTabPO mailBoxTabPO = new MailBoxTabPO();
    AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);


    /**
     * This method is use to provide name in search text area and click on the same in DD
     * @param textToBeSearched
     * @author avani
     */

    public void clicksearcheditem(String textToBeSearched ){
        getElement(txtSearch).sendKeys(Keys.chord(Keys.CONTROL, "a"),textToBeSearched);
        click(parameterizedLocator(eleSearchedText,textToBeSearched));

    }

    /**
     * This method is use to verify both ,chip values from All filter lightbox and items selected from DD
     * @param listOfFilter
     * @author avani
     */
    public boolean verifyTheChipValuesAndFilterValues(List<String> listOfFilter){
        if(!chipValues.isEmpty())
            return(listOfFilter.containsAll(chipValues));
        else
            return false;
    }

    /**
     * This method is use to store the value of chips displayed in the third layer of the All Filter lightbox
     * @param filtername
     * @return true if chip exists else false
     * @author avani
     */
    public boolean storesTheValueOfFilterValue(String filtername){
        chipValues=new ArrayList<>();
        List<WebElement> li=getElements(parameterizedLocator(listfilterChip,filtername));
        if(!li.isEmpty()){
            for(int i=0;i<li.size();i++)
                chipValues.add(getText(li.get(i)));}
        else
            return false;
        return true;
    }
    /**
     * This method is use to click on filters on CC Inbox page
     * @param filtername
     * @author avani
     *
     */

    public void userClicksOnFilter(String filtername){
        switch (filtername) {
            case "SENT":
                wait.hardWait(5);
            case "INBOX":
            case "View All Conversation":
            case "Clear All":
            case "Unread":
            case "My Mails":
            case "All filters":
            case "Bulk":
                wait.waitForValignWrapperToDisappear(10,3);
                wait.waitForElementToBeClickable(parameterizedLocator(buttonFilter,filtername));
                click(parameterizedLocator(buttonFilter, filtername));
                break;
            case "Reply":
                wait.waitForValignWrapperToDisappear(10, 3);
                jsUtil.scrollToElement(eleReply);
                wait.waitForElementToBeClickable(eleReply);
                click(eleReply);
                wait.waitForPageToLoadCompletely();
                break;
            case "New Mail":
                wait.waitForValignWrapperToDisappear(10, 3);
                wait.waitForVisibilityOfElement(parameterizedLocator(btnGenericXpath, filtername));
                click(parameterizedLocator(btnGenericXpath, filtername));
                wait.waitForPageToLoadCompletely();
                break;
            case "ReplyAll":
                wait.waitForValignWrapperToDisappear(10, 3);
                wait.waitForElementToBeClickable(eleReplyAll);
                click(eleReplyAll);
                wait.waitForPageToLoadCompletely();
                break;
            case "LatestMail":
                wait.waitForValignWrapperToDisappear(10, 3);
                wait.waitForElementToBeClickable(eleFirstTupleLeftFacet);
                click(eleFirstTupleLeftFacet);
                wait.waitForPageToLoadCompletely();
                break;
            case "CandidateName":
                wait.waitForValignWrapperToDisappear(10, 3);
                wait.waitForElementToBeClickable(eleCandidateNameRightFacet);
                click(eleCandidateNameRightFacet);
                wait.waitForPageToLoadCompletely();
                break;
            case "Group":
            case "Employer":
            case "Requirement Name":
                click(parameterizedLocator(filterType, filtername));
                break;
        }
    }

    /**
     * This method is use to fill candidate info from Communication Inbox page
     * @author nikhil.bhatia
     * @return Map
     */
    public Map<String, String> fillCandidateInfoMailboxPage(boolean MappedApplication) {
        candidateInfoOnMailboxPage.put("CandidateName", getText(eleCandidateNameRightFacet));
        candidateInfoOnMailboxPage.put("CurrentCompany", commonAction.getTextByVisibility(eleCandidateCurrentCompanyRightFacet));
        candidateInfoOnMailboxPage.put("CandidatePhoneNumber", commonAction.getTextByVisibility(eleCandidatePhoneNumberRightFacet));
        candidateInfoOnMailboxPage.put("CurrentDesignation",commonAction.getTextByVisibility(eleCurrentDesignationRightFacet));
        candidateInfoOnMailboxPage.put("From",getText(eleFromFieldRightFacet));
        candidateInfoOnMailboxPage.put("Subject",getText(eleSubjectRightFacet));
        candidateInfoOnMailboxPage.put("MailBody",mailBoxTabPO.getMailBody());
        candidateInfoOnMailboxPage.put("TO",getText(eleToFieldRightFacet));
        candidateInfoOnMailboxPage.put("CurrentStage", commonAction.getTextByVisibility(eleCandidateCurrentStageRightFacet));
        candidateInfoOnMailboxPage.put("CC",commonAction.getTextByVisibility(eleCCFieldRightFacet));
        if(MappedApplication){
            candidateInfoOnMailboxPage.put("RequirementName", commonAction.getTextByVisibility(eleRequirementNameRightFacet));
            candidateInfoOnMailboxPage.put("RequirementStatus", commonAction.getTextByVisibility(eleRequirementStatusRightFacet));
            candidateInfoOnMailboxPage.put("RequirementLocation",commonAction.getTextByVisibility(eleRequirementLocationRightFacet));
        }
        else {
            candidateInfoOnMailboxPage.put("RequirementName","No Requirement Attached");
        }
        TestNGLogUtility.info("right facet map"+candidateInfoOnMailboxPage);
        return candidateInfoOnMailboxPage;
    }

    /**
     * This method is use to verify two maps having same keys and returns keys as results which are not equal
     * @param map1,map2
     * @author nikhil.bhatia
     * @return results
     */
    public List<String> mapComparison(Map<String, String> map1, Map<String, String> map2) {
        List<String> results = map1.entrySet().stream()
                .filter(e -> !e.getValue().equals(map2.get(e.getKey()))).map(e -> e.getKey()).collect(Collectors.toList());
        TestNGLogUtility.info("comparison results"+results);
        return results;
    }

    /**
     * This method is use to verify two maps having same keys
     * it returns true if both maps are equal else false
     * @param map1,map2
     * @author nikhil.bhatia
     * @return boolean
     */
    public boolean compareMaps(Map<String, String> map1, Map<String, String> map2) {
        List<String> results = mapComparison(map1,map2);
        return results.isEmpty();
    }

    /**
     * This method is use to store the list in hashmap against the specified filter and select the same values of list from the DD for specified filter
     * @param listFilter,filterType
     * @author avani
     */

    public void userselectsValueFromDD(List<String> listFilter,String filterType) {
        switch (filterType) {
            case "Group":
            case "Employer":
            case "Requirement Name":
            case "Others":
            case "Mail Type":
                hmapFilterData.put(filterType,listFilter);
                for (String value : listFilter)
                    clicksearcheditem(value);
                break;
            case "Unread":
                hmapFilterData.put(filterType, listFilter);
                break;


        }

    }

    /**
     * This method is use to compare the values ,selected from DD and chip displayed in the All Filter lightbox third layer for specified filter
     * @paramfilterType
     * @author avani
     */
    public void verifyValuesOfChipAndFilterDD(String filterType){
        switch (filterType) {
            case "Group":
            case "Employer":
            case "Requirement Name":
            case "Unread":
            case "Others":
            case "Mail Type":
                Assert.assertTrue(verifyTheChipValuesAndFilterValues(hmapFilterData.get(filterType)));
                TestNGLogUtility.pass("Value of " + filterType +" matched with chip values of All Filters---> "+hmapFilterData.get(filterType));
                break;
        }
    }

    /**
     * This method is use to delete the chip from the third layer of the All Filter
     * @param value
     * @return  true if the values are checked else false
     * @author avani
     */

    public void deletesTheValueFromLightBoxOfAllFilter(List<String> value) {
        for (int i = 0; i < value.size(); i++) {
            click(parameterizedLocator(eleFilterLightbox,value.get(i)));
            wait.waitForPageToLoadCompletely();
        }
    }


    /**
     * This method is use to check wether the provided value is checked or not
     * @param listOfCheckedValue
     * @return  true if the values are unchecked else false
     * @author avani
     */
    public boolean verifyCheckedValueFromListDD(List<String> listOfCheckedValue) {
        List<String> listOfCheckedValueInDDList=new ArrayList<>();
        for (int i = 0; i < listOfCheckedValue.size(); i++){
            getElement(txtSearch).sendKeys(Keys.chord(Keys.CONTROL, "a"),listOfCheckedValue.get(i));
            if(isDisplayed(parameterizedLocator(eleCheckInDDList,listOfCheckedValue.get(i))))
                listOfCheckedValueInDDList.add(listOfCheckedValue.get(i));}
        return(listOfCheckedValueInDDList.containsAll(listOfCheckedValue));
    }

    /**
     * This method is use to compare the given values if checked or not in the DD list
     * @param listOfCheckedValue
     * @return  true if the values are checked else false
     * @author avani
     */
    public boolean verifyCheckedValuesOfDDList(List<WebElement>listOfValue,List<String> listOfCheckedValue){
        List<String> listDDCheckedValue=new ArrayList<>();
        for(int j=0;j<listOfValue.size();j++){
            listDDCheckedValue.add(listOfValue.get(j).getAttribute("title"));}
        return(listOfCheckedValue.containsAll(listDDCheckedValue));
    }

    /**
     * This method is use to click on the options from the first layer of the All Filter lightbox
     * @param filtername
     * @return  true if the values are checked else false
     * @author avani
     */
    public void clickOnFilterInLightbox(String filtername){
        click(parameterizedLocator(buttonFilter, filtername));
    }


    /**
     * This method is use to verify if the specified element is displayed on the CC inbox page or not
     * @param valuename
     * @return  true if the values are displayed else false
     * @author avani
     */
    public boolean verifyValuesAreDisplayedOrNotOnCCPage(String valuename){
        switch(valuename){
            case"Group":
            case"Requirement Name":
            case"Applied Filters:":
                return(isDisplayed(parameterizedLocator(filterType,valuename)));
            case"Clear All":
            case"Unread":
            case"My Mails":
            case"All filters":
            case"Bulk":
            case"Individual":
                return(isDisplayed(parameterizedLocator(buttonFilter,valuename)));
            case"Mailbox":
                wait.waitForVisibilityOfElement(parameterizedLocator(eleMailboxLnkGNB,valuename));
                return(isDisplayed(parameterizedLocator(eleMailboxLnkGNB,valuename)));
            case"Recently Used":
                return(isDisplayed(parameterizedLocator(eleRecentlyUsed,valuename)));


        }
        return  false;
    }

    /**
     * This method is use to verify if the specified element is displayed in All Filter lightbox different layers or not
     * @param valuename,layer
     * @return  true if the values are displayed else false
     * @author avani
     */

    public boolean verifyValuesAreDisplayedOrNotInAllFilterLightbox(String valuename,String layer){
        if(layer.equalsIgnoreCase("third"))
            return(isDisplayed(parameterizedLocator(eleFilterName,valuename)));
        else
            return(isDisplayed(parameterizedLocator(buttonFilter,valuename)));
    }

    /**
     * This method is use to sort the provided list in the ascending order and compares the same
     * @param FilterDDListUnSorted
     * @return  true if the list is in ascending order else false
     * @author avani
     */
    public boolean sortTheListInAscendingOrderAndCompares(List<String> FilterDDListUnSorted){
        HashMap<String,List<String>> hmapForSorting=new HashMap<>();
        hmapForSorting.put("FilterUnSortedList",FilterDDListUnSorted);
        hmapForSorting.put("FilterSortedList",hmapForSorting.get("FilterUnSortedList").stream().sorted().collect(Collectors.toList()));
        TestNGLogUtility.info(hmapForSorting.get("FilterSortedList")+"\n"+hmapForSorting.get("FilterUnSortedList"));
        return(hmapForSorting.get("FilterSortedList")).equals(hmapForSorting.get("FilterUnSortedList"));
    }

    /**
     * This method is use to store the list elements and calls sortTheListInAscendingOrderAndCompares function to sort and compare the list
     * @return  true if the list is in ascending order else false
     * @author avani
     */
    public boolean verifyListIsInAlphabetical(){
        List<String> FilterDDListUnSorted=new ArrayList<>();
        List<WebElement> list=getElements(listFilterDD);
        for(int i=0;i<list.size();i++)
            FilterDDListUnSorted.add(list.get(i).getText().toLowerCase());
        return(sortTheListInAscendingOrderAndCompares(FilterDDListUnSorted));
    }

    /**
     * This method is use to update url for cv detail page in mongo for collection candidatecommunication
     *
     * @author nikhil.bhatia
     */
    public void setCvDetailUrlInMongo() {
        String url = getCurrentURL();
        String[] str = url.split("[/?]");
        String applicationId = str[str.length - 2];
        HashMap<String, String> KeyValuesToBeUpdated = new HashMap<>();
        KeyValuesToBeUpdated.put("Value", applicationId);
        UpdateValuesInMongoDocument("CandidateCommunication", KeyValuesToBeUpdated, "Id", "ApplicationId");
    }

    /**
     * This method is use to get url for cv detail page from mongo collection candidatecommunication
     * @return value for applicationId
     * @author nikhil.bhatia
     */
    public String getCvDetailUrlFromMongo()  {
        JSONObject document = getJSONObject("CandidateCommunication", "Id", "ApplicationId");
        return document.get("Value").toString();
    }

    /**
     * This method is use to get RequirementName present on right facet
     * @return value for applicationId
     * @author nikhil.bhatia
     */
    public String getRequirementName(){
        return getText(eleRequirementNameOnMailBox);
    }

    /**
     * This method is use to provide the name of filter value and check if the value is displayed in DD List or not
     * @return  true if provided value is displayed else false
     * @param name
     * @author avani
     */
    public boolean verifyUserIsAbleToSeeTheGroupNameInTheGroupDDList(String name){
        getElement(txtSearch).sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
        return(isDisplayed(parameterizedLocator(elename,name)));
    }


    /**
     * This method is use to verify if user provides any value which doesn't exist should get 'Not Found' in DD List
     * @return  true if 'Not Found' is displayed else false
     * @param value
     * @author avani
     */
    public boolean notExistsNameInSearchArea(String value){
        getElement(txtSearch).sendKeys(Keys.chord(Keys.CONTROL, "a"),value);
        return(isDisplayed(eleNotFound));
    }

    /**
     * This method is use to verify More link
     * @return  true if verifies the link
     * @param number
     * @author avani
     */
    public boolean verifyMoreLink(String number){
        String linkText=getElement(eleMoreLink).getText();
        return(linkText.equalsIgnoreCase("+ "+number+" More"));
    }

    /**
     * This method is use to verify chip List on CC Inbox Page
     * @return  true if chiplist is matched
     * @param listOfChips
     * @author avani
     */
    public boolean verifyChipListOnCCInboxPage(List<String> listOfChips){
        List<WebElement> listsOfChip=getElements(listChipOnCCPage);
        for(int i=0;i<listsOfChip.size();i++)
            chipValuesOnCCInboxPage.add(listsOfChip.get(i).getText());
        return(chipValuesOnCCInboxPage.containsAll(listOfChips));
    }


    /**
     * This method is use to verify left facet on CC Inbox Page
     * @return  true if details matched
     * @author nikhil.bhatia
     */
    public HashMap<String,String> fillLeftFacetDetails() {
        HashMap<String,String> comparableValuesLeftFacet = new HashMap<>();
        comparableValuesLeftFacet.put("CandidateName",getText(eleCandidateNameLeftFacet));
        comparableValuesLeftFacet.put("Subject",getText(eleSubjectLeftFacet));
        comparableValuesLeftFacet.put("RequirementName",getText(eleRequirementNameLeftFacet));
        TestNGLogUtility.info("left facet details " + comparableValuesLeftFacet);
        return comparableValuesLeftFacet;
    }

    /**
     * This method is use to provide requirement id in Requirement DD and select the same
     * on Add Single Profile Page
     * @author avani
     */

    public void selectAddSingleProfileOnRequirementOverView(){
        wait.waitForPageToLoadCompletely();
        actionBuilderUtil.hoverByActionAlternate(eleMore);
        click(eleAddSingleProfile);
    }

    /**
     * This method is use to get ImageUrl from left facet
     * @author nikhil.bhatia
     */
    public String getCandidatePhotoLeftFacet(){
        TestNGLogUtility.info("left facet image url : "+getAttribute(eleCandidatePhotoLeftFacet,"src").replaceFirst("\\?(.*?)\\&",""));
        return getAttribute(eleCandidatePhotoLeftFacet,"src").replaceFirst("\\?(.*?)\\&","");
    }

    /**
     * This method is use to get ImageUrl from right facet
     * @return candidate image url
     * @author nikhil.bhatia
     */
    public String getCandidatePhotoRightFacet(){
        TestNGLogUtility.info("right facet image url : "+getAttribute(eleCandidatePhotoRightFacet,"src").replaceFirst("\\?(.*?)\\&",""));
        return getAttribute(eleCandidatePhotoRightFacet,"src").replaceFirst("\\?(.*?)\\&","");
    }


    /**
     * This method is use to verify suggested results for a searched term on search bar are valid or not
     * @return true/ false, true if results are valid ,else false
     * @author nikhil.bhatia
     */
    public boolean verifySearchSuggestion(String searchTerm){
        wait.waitForVisibilityOfElement(eleSearchBar);
        sendKeys(eleSearchBar,searchTerm);
        List<WebElement> suggestions=getElements(eleSearchSuggestions);
        if(suggestions.isEmpty()){
            return false;
        }
        for (WebElement we : suggestions) {
            TestNGLogUtility.info("search suggestion matched ?"+we.getAttribute("title").toLowerCase().contains(searchTerm.toLowerCase()));
            if(!(we.getAttribute("title").toLowerCase()).contains(searchTerm.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is use to check if suggestion not found is displayed
     * @return true/false  true if displayed,otherwise false
     * @author nikhil.bhatia
     */
    public boolean verifySuggestionNotFoundIsDisplayed(){
        return isDisplayed(eleSuggestionNotFound);
    }

    /**
     * This method is use to wait for visibility and click On First Suggestion
     * for subject line /candidate name or any by element passed
     * @author nikhil.bhatia
     */
    public void clickOnFirstSuggestion(By by){
        wait.waitForVisibilityOfElement(by);
        click(by);
    }

    /**
     * This method is use to get placeholder from SearchBar
     * @return placeholder
     * @author nikhil.bhatia
     */
    public String getPlaceholderSearchBar() {
        return getAttribute(eleSearchBar, "placeholder");
    }
    /**
     * This method is use to verify recenlty used values in DD List
     * @return  true if recently used is matched
     * @param listRecentValues
     * @author avani
     */
    public boolean verifyRecentlyUsedValues(List<String> listRecentValues){
        List<WebElement> list=getElements(listFilterDD);
        List<String> listOfRecentlyUsedValues=new ArrayList<>();
        for(int i=0;i<3;i++){
            listOfRecentlyUsedValues.add(list.get(i).getText());}
        return(listRecentValues.containsAll(listOfRecentlyUsedValues));
    }

    /**
     * This method is use to Search mails,candidate name from cc inbox page
     * @param searchTerm
     * @author nikhil.bhatia
     */
    public void searchCCInbox(String searchTerm) {
        wait.waitForVisibilityOfElement(eleSearchBar);
        sendKeys(eleSearchBar, searchTerm);
        getElement(eleSearchBar).sendKeys(Keys.ENTER);
    }

    /**
     * This method is use to verify searched term is highlighted on left facet
     * @param searchTerm
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifyHighlightedSearchTermLeftFacet(String searchTerm) {
        if (isDisplayed(eleHighlightedCandidateNameLeftFacet) && isDisplayed(eleHighlightedSubjectLeftFacet))
            return (getText(eleHighlightedCandidateNameLeftFacet).equalsIgnoreCase(searchTerm) && getText(eleHighlightedSubjectLeftFacet).equalsIgnoreCase(searchTerm));
        else
            return false;
    }

    /**
     * This method is use to verify searched term is highlighted on right facet
     * @param searchTerm
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifyHighlightedSearchTermRightFacet(String searchTerm) {
        if (isDisplayed(eleHighlightedSubjectRightFacet))
            return getText(eleHighlightedSubjectRightFacet).equalsIgnoreCase(searchTerm);
        else
            return false;
    }

    /**
     * This method is use to verify Time On Left And RightFacet
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifyTimeOnLeftAndRightFacet() {
        if (isDisplayed(eleTodayLeftFacet)) {
            String timeLeftFacet = getText(eleMailTimeLeftFacet);
            System.out.println(timeLeftFacet);
            click(eleFirstTupleLeftFacet);
            wait.waitForPageToLoadCompletely();
            System.out.println(getText(eleMailTimeRightFacet));
            return getText(eleMailTimeRightFacet).split(",")[1].trim().equals(timeLeftFacet);
        } else
            return false;
    }

    /**
     * This method is use to verify three dots functionality for existing mails on RightFacet
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifyThreeDotsFunctionality() {
        wait.waitForVisibilityOfElement(eleThreeDots);
        click(eleThreeDots);
        wait.waitForVisibilityOfElement(eleMoveToNextMail);
        click(eleMoveToNextMail);
        return isDisplayed(eleHighlightExistingMail);
    }

    /**
     * This method is use to verify three dots functionality for existing mails on RightFacet
     * @return true/false true if attachment name is matched with download link
     * @author nikhil.bhatia
     */
    public boolean verifyAttachment(String attachmentName){
        if(isDisplayed(lblAttachment) && isDisplayed(eleDownloadLink))
            return getText(eleAttachmentName).equals(attachmentName);
        else
            return false;
    }

    /**
     * This method is use to verify Warning Strip Is Displayed on RightFacet
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifyWarningStripIsDisplayed(){
        return isDisplayed(eleMailDelayWarningStrip);
    }


    /**
     * This method is use to verify name of filter on hover
     * @param  Filtername,onhovervalue
     * @author avani
     */
    public boolean onHoverUserShouldSee(String onhovervalue,String Filtername){
        hover(parameterizedLocator(elefilter,Filtername));
        return(isDisplayed(parameterizedLocator(eleHoverStatusChangeMail,onhovervalue)));
    }


    /**
     * This method is use to get the requirement name from cv details page
     * @author avani
     */
    public void getTheRequirementAttachedWithCV(){
        wait.waitForPageToLoadCompletely();
        API.refreshPageAndCheckElementIsDisplayed((eleRequirementID),10);
        RequirementName=getElement(eleRequirementID).getAttribute("title");
        TestNGLogUtility.info("Requirement Name  On cv details page-->" +RequirementName);

    }
    /**
     * This method is use to provide filter value in the search bar of filter
     * @param value
     * @author avani
     */
    public void provideFilterValue(String value){
        if(value.equals("Requirement")){
            clicksearcheditem(RequirementName);
            TestNGLogUtility.info("Requirement--> "+RequirementName+ "Selected from Requirement DD");
        }
        else{
            clicksearcheditem(PropFileHandler.readProperty("GroupName"));
            TestNGLogUtility.info("Group--> "+PropFileHandler.readProperty("GroupName")+ "Selected from Group DD");}

    }

    /**
     * This method is use to verify Unread Mail Is Displayed on RightFacet
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean unreadMailIsDisplayed(){
        return isDisplayed(eleUnreadMail);
    }



    /**
     * This method is use to refresh the page until particular stage is not visible on the page
     * @param StageName
     * @author avani
     */
       public boolean refreshUntilMailerIsVisible(String StageName){
        wait.waitForPageToLoadCompletely();
        return(API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleAutomaticMailerStage,StageName),10));

    }
    /**
     * This method is use to click on the requirement on the cv details page
     * @author avani
     */
    public void clickOnRequirementOnCvDetailsPage() {
        wait.waitForPageToLoadCompletely();
        click(eleRequirementNameOnCVDetail);
        switchToChildWindow();
        wait.waitForPageToLoadCompletely();

    }
    /**
     * This method is use to change the status of the requirement
     * @param status
     * @author avani
     */
    public void changeRequirementStatus(String status){
        actionBuilderUtil.hoverByActionAlternate(eleArrow);
        click(parameterizedLocator(eleRequirementStatus,status));

    }

    /**
     * This method is use to verify the requirement status on CC page
     * @param Status
     * @author avani
     */
    public boolean verifyStatusOnCCPage(String Status){
        wait.waitForPageToLoadCompletely();
        return(isDisplayed(parameterizedLocator(eleStatusOnCCPage,Status)));
    }

    /**
     * This method is use to click on Cancel in confirmation on requirement overview page
     * @author avani
     */
    public void clickOnbuttoInBox(){
        wait.waitForPageToLoadCompletely();
        click(eleCancelButton);
        pageRefresh();
    }







    /**
     * This method is use to verify requirement name is displayed for bulk mail or not
     * @return true if requirement name is displayed else false
     * @author avani
     */
    public boolean verifyUserisAbleToSeeRequirementNameForBulkMail(){
        TestNGLogUtility.info("Requirement Name For Bulk ->"+PropFileHandler.readProperty("RequirementNameForBulk"));
        return(isDisplayed(parameterizedLocator(getEleRequirementNameOnMailBox,PropFileHandler.readProperty("RequirementNameForBulk"))));
    }


    /**
     * This method is use to verify wether user is able to see subject of mail as Mail Heading or not
     * @return true if subject is being displayed as Mail Heading else false
     * @author avani
     */
    public boolean verifyUserisAbleToSeeSubjectAsMailHeading(String mailtype) {
        switch (mailtype) {
            case "Left Facet":
                TestNGLogUtility.pass("Subject on Left Facet---"+ MailBoxStepDef.mailBodySubject);
                return (isDisplayed(parameterizedLocator(txtSubjectHeading,MailBoxStepDef.mailBodySubject)));
            case "Right Facet":
                TestNGLogUtility.pass("Subject on Right Facet---"+MailBoxStepDef.mailBodySubject);
                return (isDisplayed(parameterizedLocator(txtSubjectHeadingRightFacet,MailBoxStepDef.mailBodySubject)));
        }
        return false;
    }
    /**
     * This method is use to verify no of mail recipient number for bulk Mail
     * @return true if recipient number is same as expected else false
     * @author avani
     */

    public boolean verifyUserIsAbleToSeeRecipientsDetailsOnRightFacet(String numberOfRecipients,String facettype){
        switch (facettype){
            case "Right":
                return(isDisplayed(parameterizedLocator(txtRecipients,numberOfRecipients)));
            case "Left":
                return(isDisplayed(parameterizedLocator(txtSubjectHeading,numberOfRecipients)));
        }
        return false;
    }


    /**
     * This method is use to click on sent Mail for bulk on MailBox page
     * @author avani
     */

    public void clickOnTupleForWhichBulkMailIsSent(){
        click ((parameterizedLocator(txtSubjectHeading, MailBoxStepDef.mailBodySubject)));
        TestNGLogUtility.info("Clicked on the Subject->"+MailBoxStepDef.mailBodySubject);

    }
    /**
     * This method is use to get the requirement name from CV details page
     * @author avani
     */

    public void getTheRequirementNameFromCVDetailsPage(){
        String RequirementName=getElement(eleRequirementName).getAttribute("title");
        PropFileHandler.writeProperty("RequirementNameForBulk",RequirementName);
        TestNGLogUtility.info("Requirement Name from CV details page-->"+PropFileHandler.readProperty("RequirementNameForBulk"));
    }

    /**
     * This method is use to save the details of the page
     * @author avani
     */
    public void saveTheDetailsOfThePage(){
        String URL=driver.getCurrentUrl();
        PropFileHandler.writeProperty("PageDetailsForCCBulk",URL);
        TestNGLogUtility.info("Saved the SRP Page-->"+PropFileHandler.readProperty("PageDetailsForCCBulk"));

    }

    /**
     * This method is use to verify Heading of Mail Recipient Page
     * @author avani
     */
    public boolean verifyMailRecipientPageHeading(String errorMessage){
        genericFunctions.switchToWindow();
        return(isDisplayed(parameterizedLocator(txtSubjectHeading,errorMessage)));
    }
    /**
     * This method is use to verify the count of application on Mail Recipient page
     * @return true if count is same as expected else false
     * @author avani
     */
    public boolean verifyApplicationCountOnMailRecipientPage(String count){
        return(isDisplayed(parameterizedLocator(eleCountOnMailRecipient,count)));
    }
    /**
     * This method is use to load the SRP page
     * @author avani
     */
    public void loadTheSRPPageForCCBulk(){
        commonAction.navigateToUrl(PropFileHandler.readProperty("PageDetailsForCCBulk"));
        TestNGLogUtility.info("Loaded the SRP Page-->"+PropFileHandler.readProperty("PageDetailsForCCBulk"));
    }


    /**
     * This method is use to verify the message which comes when try to apply filter of group and Unread on bulk
     * @return  true if message is displayed else false
     * @author avani
     */
    public boolean userShouldSeeWhenSearchedWithGroupForBulk(String errorMessage){
        genericFunctions.switchToWindow();
        return(isDisplayed(parameterizedLocator(txtSubjectHeading,errorMessage)));
    }
    /**
     * This method is use to select the recruiter from DD on requirement overview from Set Visibility option
     * @author avani
     */

    public void selectRecruiterFromDDForVisibility(String recruiterName){
        sendKeys(txtRecruiterForVisibility,recruiterName);
        click(eleDDRecruiterForVisibility);
    }
    /**
     * This method is use to click on save option in Set visibility lightbox on Requirement Overview
     * @author avani
     */
    public void clickOnRequirementOverviewVisibilityLightbox(String linkname){
        click(parameterizedLocator(eleStatusOnCCPage,linkname));
    }


}




