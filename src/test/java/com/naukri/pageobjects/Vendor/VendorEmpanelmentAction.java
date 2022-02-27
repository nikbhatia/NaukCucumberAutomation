package com.naukri.pageobjects.Vendor;

import java.util.*;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.test.base.PageObjectWrapper;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.BaseAutomation;
import static com.naukri.automation.util.YamlReader.getAppConfigValue;

public class VendorEmpanelmentAction extends BaseAutomation {

	public static By txtNewVendorName = By.id("inputVendorName");
	public static By btnNewVendorMailId = By.id("inputVendorEmail");
	public static By btnNewVendorBackArrow = By.className("btnBack");
	public static By txtNewVendorPocName = By.id("inputPocName");
	public static By txtNewVendorPocEmail = By.id("inputPocEmail");
	public static By txtNewVendorPocPhone = By.id("inputPocPhone");

	public static By btnNewVendorCommonTabs = By.xpath("//div[contains(text(),'${TrackContractDetails}')]");
	public static By txtNewVendorContractName = By.id("inputContractName");
	public static By txtNewVendorContractRate = By.id("inputContractRate");
	public static By txtNewVendorPayableAfter = By.name("billingPayableAfter");
	public static By btnNewVendorVendorName = By.xpath("//div[text()='${vendorname}']");

	public static By eleVendorDetailsInPopUp = By.xpath("//div[text()='Invite Sent to']");
	public static By btnVendorCommon = By.xpath("//button[contains(text(),'${VendorCommon}')]");
	public static By iconNewVendorDocumentDownload = By.xpath("//span[contains(@class,'act-btn icon-${btnname}')]");

	public static By lblNewVendorUploadedDocumentList = By.xpath("//div[contains(@class,'list-data document-data')]");
	public static By btnNewVendorJsUplaodDocument = By.xpath("//div[@class='vendor-upload-btn']//input");
	public static By btnNewVendorFlatFee = By.xpath("//label[contains(text(),'${flatfee}')]");
	public static By eleBillingBracketName = By.xpath("//div[text()='${billingbracketname}']");

	public static By eleApplicableRate = By.xpath("//div[text()='${billingbracketname}']/following-sibling::div[1]");
	public static By eleNewVendorStatus=By.xpath("//div[text()='${vendorName}']/following-sibling::div[1]");
	public static By eleNewVendorPocName=By.xpath("//div[text()='${pocname}']");
	public static By eleContractDetailsInPopUp = By.xpath("//div[text()='Contract Details']");
	public static By eleAddDetailsAndInViteTab = By.xpath("(//div[text()='Add Details & Invite Vendor'])[1]");

	public static By listSetSources=By.xpath("//select[@id='setSrc']//option");
	public static By listRequirement=By.xpath("//div[@id='projectList']");
	public static By eleRequirement=By.xpath("//div[@id='dp_projectList']//ul//li[2]");
	public static By eleVendorAcceptedBy = By.xpath("//div[text()='${status}']");
	public static By eleExistVendorName= By.xpath("//div[@class='name ap-list-col-item']");
	public static By btnAddNewVendorManageVendorPage=By.xpath("//input[@value='${Add New Vendor}']");
	public static By lblVendorDuplicateMessage=By.xpath("//p[contains(text(),'${message}')]");
	public static By eleVendorTuple=By.xpath("//div[@class='listWrap advVendor'][1]");

	public static By txtSearchBox=By.xpath("//input[@placeholder='Search by Name']");
	public static By iconSearch=By.xpath("//input[@id='searchIcon']");
	public static By eleSearchedTuple= By.xpath("//span[contains(text(),'${VendorName}')]");
	public static By buttonDelete=By.xpath("//div[contains(text(),'Delete')][1]");
	public static By txtErrorMessage= By.xpath("//p[@class='erLbl']");
	public static By eleMenuOption=By.xpath("//div[@class='menu'][1]");
	public static By linkRestoreVendor=By.xpath("//a[contains(text(),'Restore Vendor')]");
	public static By btnOnPage = By.xpath("//span[contains(text(),'${buttonname}')]");



	GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	String vendorEmpanalmentAttachment = System.getProperty("user.dir") + "/src/test/resources/testdata/OfferManagement/attachemntVendor.docx";
	String attachmentName,attachedDocumentname;
	ArrayList<String> storedVendorName;
	/**
	 * This method use to fill New Vendor mailId on Add New Vendor page
	 * @param vendorMailId
	 * @author avani
	 */

	public void addNewVendorDetails(String vendorMailId) {
		sendKeys(btnNewVendorMailId, vendorMailId);
	}
	/**
	 * This method use to fill New Vendor name on Add New Vendor page
	 * @param vendorname
	 * @author avani
	 */
	public void addNewVendorName(String vendorname){
		sendKeys(txtNewVendorName, vendorname);
	}


	/**
	 * This method use to fill poc details on Add New Vendor Details Page
	 * @param PocName, PocEmail, PocPhone
	 * @author avani
	 */
	public void newVendorfillPocDetails(String PocName, String PocEmail, String PocPhone) {
		sendKeys(txtNewVendorPocName, PocName);
		sendKeys(txtNewVendorPocEmail, PocEmail);
		sendKeys(txtNewVendorPocPhone, PocPhone);
		wait.waitForVisibilityOfElement(txtNewVendorPocName);
		wait.waitForPageToLoadCompletely();
	}
	/**
	 * This method use to fill track contract details on Add New Vendor Details Page
	 * @param BillingBracketName
	 * @author avani
	 */
	public void fillTrackContractDetails(String BillingBracketName) {
		sendKeys(txtNewVendorContractName, BillingBracketName);
		sendKeys(txtNewVendorContractRate, PropFileHandler.readProperty("VendorContractRate"));
		sendKeys(txtNewVendorPayableAfter, PropFileHandler.readProperty("VendorPayableAfter"));
		wait.waitForPageToLoadCompletely();

	}

	/**
	 * This method use to verify vendor details from PopUp Box appears after clicking on specific vendor from listing on Manage Vendor Page
	 * @param vendorname
	 * @author avani
	 */
	public boolean vendorDetailsfromVendorListingPopUp(String vendorname) {
		click(parameterizedLocator(btnNewVendorVendorName, vendorname));
		return (isDisplayed(eleVendorDetailsInPopUp)&& isDisplayed(eleContractDetailsInPopUp));
	}
	/**
	 * This method use to verify view more link in pop when clicked on Vendor tuple
	 * @author avani
	 */
	public boolean verifyViewMore()
	{
		return (isDisplayed(parameterizedLocator(btnVendorCommon,"View More")));
	}

	/**
	 * This method use to check vendor status on Manage Vendor page
	 * @param status ,vendorName
	 * @author avani
	 */
	public boolean checkVendorStatus(String vendorName, String status) {
		wait.waitForPageToLoadCompletely();
		String VendorCurrentStatus =getElement(eleNewVendorStatus,vendorName).getText();
		return(VendorCurrentStatus.equalsIgnoreCase(status));
	}

	/**
	 * This method use to verify "Add Details and Invite" tab after clicking "Yes/No" while using "Back Navigation" on Add New Vendor page
	 * @author avani
	 */

	public boolean verifyAddDetailsAndInviteVendorTab() {
		return(isDisplayed(eleAddDetailsAndInViteTab));
	}
	/**
	 * This method use to verify if POC added successfully for new vendor on Add New Vendor page
	 * @param pocName
	 */

	public boolean verifyNewVendorPocAdd(String pocName) {
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleNewVendorPocName,pocName)));
	}


	/**
	 * This method use to click on Upload  Documents button and provide the attachment
	 * @author avani
	 */
	public void clickOnUploadDocumentsButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('vendor-doc-uploader').setAttribute('style','display:inline')");
		getElement(btnNewVendorJsUplaodDocument).sendKeys(vendorEmpanalmentAttachment);
	}


	/**
	 * This method use to verify the Uploaded document
	 * @return true or false
	 * @author avani
	 */
	public boolean verifyUploadedDocument() {
		attachedDocumentname = getElement(lblNewVendorUploadedDocumentList).getText();
		attachmentName = getAppConfigValue("TestData.VendorAttachment");
		return(attachmentName.equals(attachedDocumentname));
	}
	/**
	 * This method use to verify if the document has been deleted or not
	 * @return true or false
	 * @author avani
	 */
	public boolean verifyUserIsAbleToDeleteTheDocument()
	{
		return (!isDisplayed(lblNewVendorUploadedDocumentList));
	}
	/**
	 * This method use to verify flat fee applied for New Vendor
	 * @param BillingBracketName
	 * @return if flat fee added successfully
	 * * @author avani
	 */
	public boolean verifyFlatFee(String BillingBracketName) {
		return(isDisplayed(parameterizedLocator(eleApplicableRate,BillingBracketName)));
	}
	/**
	 * This method use to verify billing rate applied for new vendor on add new vendor page
	 * @param BillingBracketName
	 * @author avani
	 */
	public boolean verifyBillingRate(String BillingBracketName) {
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleBillingBracketName,BillingBracketName)));
	}

	/**
	 * This method use to click add billing rate/flat fee on add new vendor page track contract details section
	 * @param buttonName
	 * @author avani
	 */
	public void clickFlatFee(String buttonName) {
		click(parameterizedLocator(btnNewVendorFlatFee, buttonName));
	}

	/**
	 * This method use to click on button provided by user accordingly on the page
	 * @param buttonName
	 * @author avani
	 */
	public void clickButtonOnAnyPage(String buttonName){
		click(parameterizedLocator(btnOnPage, buttonName));
	}
	/**
	 * This method use to click track contract details on add new vendor page
	 * @author avani
	 */
	public void clickTrackContractDetails(String linkName) {
		click(parameterizedLocator(btnNewVendorCommonTabs,linkName));

	}
	/**
	 * This method use to click back navigation arrow on Add New Vendor page
	 * @author avani
	 */
	public void clickBackNavigationArrow() {
		click(btnNewVendorBackArrow);
	}
	/**
	 * This method use to click on download and delete document button on add new vendor upload document section
	 * @param btnname
	 * @author avani
	 */
	public void vendorEmpanalmentDownloadDocument(String btnname) {
		actionBuilderUtil.hoverClickByAction(lblNewVendorUploadedDocumentList);
		click(parameterizedLocator(iconNewVendorDocumentDownload, btnname));
	}
	/**
	 * This method use to click on Upload Vendor Documents section on add new vendor page
	 * @author avani
	 */
	public void clickOnUploadVendorDocumentsTab() {
		click(parameterizedLocator(btnNewVendorCommonTabs,"Upload Vendor Documents"));
	}

	/**
	 * This method is use to store the first two Vendor name listed on Manage Vendor page to check the duplicate functionality
	 * @author avani
	 */
	public void storeNameOFVendors(){
		List<WebElement>listVendorName=getElements(eleExistVendorName);
		storedVendorName=new ArrayList<>();
		storedVendorName.add(getText(listVendorName.get(0)));
		storedVendorName.add(getText(listVendorName.get(1)));
	}
	/**
	 * This method is use to click on Add New Vendor On Manage Vendor page
	 * @param button
	 * @author avani
	 */
	public void clickOnAddNewVendorButtonOnManageVendorPage(String button){
		click(parameterizedLocator(btnAddNewVendorManageVendorPage,button));
	}
	/**
	 * This method is use to verify wether the vendor is deleted successfully on Manage Vendor page or not
	 * @return true or false
	 * @author avani
	 */
	public boolean verifyVendorDeleted(String vendorname){
		return verifyVendorList(vendorname,eleExistVendorName);

	}
	/**
	 * This method use clicks the Edit button appears after clicking on vendor tuple on Manage Vendor page
	 * @author avani
	 */
	public void clickOnVendorTuple(){
		click(eleVendorTuple);
		genericFunction.switchToChildWindow();
	}
	/**
	 * This method use to edit the vendor name with existing vendor name to check the duplicate functionality
	 * @author avani
	 */
	public void editExistingVendorNameWithDuplicateName(){
		for(String ExistVendorName2 :storedVendorName)
			sendKeys(txtNewVendorName,"  "+ExistVendorName2+"  ");
	}
	/**
	 * This method is use to provide duplicate name on Add New Vendor page
	 * @author avani
	 */
	public void vendorDuplicateName(){
		for(String ExistVendorName :storedVendorName)
			sendKeys(txtNewVendorName,"  "+ExistVendorName+"  ");
	}
	/**
	 * This method checks the duplicate name error message comes when provide duplicate name
	 * @return  true or false
	 * @author avani
	 */
	public boolean verifyChecksForDuplicateName(){
		return(isDisplayed(parameterizedLocator(lblVendorDuplicateMessage,PropFileHandler.readProperty("VendorNameCheckerror"))));
	}

	/**
	 * This method is use to search the vendor on Manage Vendor page
	 * @author avani
	 */
	public void searchVendorByName(String vendorname){
		sendKeys(txtSearchBox,vendorname);

	}
	/**
	 * This method is use to sclick on Search icon on Manage Vendor Page
	 * @author avani
	 */
	public void clickOnSearchIcon(){
		click(iconSearch);
	}
	/**
	 * This method is use to click on specific vendor tuple on Manage Vendor page
	 * @author avani
	 */
	public void clickOnVendorTuple(String vendorname)
	{
		click(parameterizedLocator(eleSearchedTuple,vendorname));
	}

	/**
	 * This method is use to verify wether Invite Accepted By is displayed or not
	 * @return true if displayed
	 * @author avani
	 */
	public boolean verifyInviteAcceptedBY(String Status){
		return (isDisplayed(parameterizedLocator(eleVendorAcceptedBy,Status)));
	}
	/**
	 * This method is use to delete the added vendor on Manage Vendor page via delete option comes after hovering on vertical ellipsis
	 * @author avani
	 */
	public void deleteTheVendor(){
		wait.waitForPageToLoadCompletely();
		hover(eleMenuOption);
		click(buttonDelete);
	}
	/**
	 * This method to use to verify the error message when provided name of deleted Vendor name on edit page
	 * @return  true or false
	 * @author avani
	 */
	public boolean verifyDeletedVendorErrorMessage(String vendorname){
		wait.waitForPageToLoadCompletely();
		sendKeys(txtNewVendorName,vendorname);
		return(getText(txtErrorMessage).equalsIgnoreCase(PropFileHandler.readProperty("DeleteVendorErrorMessage")));
	}
	/**
	 * This method is use click on restore link comes for  deleted vendor on edit page and click on continue button on popup
	 * @author avani
	 */
	public void restoreTheDeletedVendor(String RestoreVendor){
		click(parameterizedLocator(linkRestoreVendor,RestoreVendor));
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(linkRestoreVendor,RestoreVendor));

	}
	/**
	 * This method is to use to verify wether the deleted vendor details have restored
	 * @return  true or false
	 * @author avani
	 */
	public boolean verifyDeletedVendorDetails(String vendorname)
	{
		return verifyVendorList(vendorname,eleExistVendorName);
	}
	/**
	 * This method is to use to select Requirement on Upload Multiple CV page
	 * @author avani
	 */
	public void selectRequirementAndSetSource(){
		click(listRequirement);
		click(eleRequirement);
	}
	/**
	 * This method is use to verify wether the vendor of "Invite Sent" status is not present in the list of set Source
	 * @return true or false
	 * @author avani
	 */
	public boolean verifySetSourceList(String vendorname){
		return verifyVendorList(vendorname,listSetSources);
	}
	/**
	 * This method to verify the vendor list on different pages
	 * @author avani
	 */
	public boolean verifyVendorList(String name,By by) {
		List<WebElement> vendorlist = getElements(by);
		for(int i=0;i<=vendorlist.size();i++){
			return(getText(vendorlist.get(i)).contains(name));}
		return false;}



}

