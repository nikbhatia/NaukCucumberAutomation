package com.naukri.pageobjects.Vendor;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.naukri.pageobjects.Reports.SaveAndSchedulePageObject;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import org.testng.Assert;


public class VendorPortalPO extends BaseAutomation {
	public static String vendorPortalFile = System.getProperty("user.dir") + "/src/test/resources/testdata/VendorPortalData.properties";


	public By spocName = By.xpath("//input[@placeholder='Add Name of the Vendor SPOC']");
	public By spocMail = By.xpath("//input[@placeholder='Add Email Id of the Vendor SPOC']");
	public By spocAdd = By.xpath("//button[text()='Add']");
	public By spocEdit = By.xpath("//button[text()='Edit']");
	public By pocShowMore = By.xpath("//div[text()='Points of Contact']/..//following-sibling::div//div[text()='+Show More']");
	public By deletePopUpButton = By.xpath("//button[text()='DELETE']");
	public By lnkClick = By.xpath("//a[text()='${buttonName}']");
	public By eleVendorSpocName=By.xpath("//div[text()='${vendorSpocName}']");
	public By eleVendorEditSpocName=By.xpath("//div[text()='${vendorEditSpocName}']");
	public By elePocName=By.xpath("//div[text()='${pocname}']");
	public By eleClickDeleteIcon=By.xpath("//div[text()='${vendorspocname}']//following-sibling::div/div[@class='icon-delete']");
	public By lblVendorSpocName=By.xpath("//div[text()='${vendorEditSpocName}']");
	public By eleClickEditIcon=By.xpath("//div[text()='${vendorSpocName}']//following-sibling::div/div[@class='icon-edit']");
	public By listMessagesTabs=By.xpath("//span[contains(text(),'Messages')]");
	public By listEditAssignmentDetailsTabs=By.xpath("//span[contains(text(),'Edit Assignment Details')]");
	public By listUnassignTabs=By.xpath("//span[contains(text(),'Unassign')]");
	public By listSendReminder=By.xpath("//a[contains(text(),'Send Reminder')]");
	public By eleRecruiterStatus=By.xpath("//div[@class='listHead']//following::div[contains(text(),'${INVITED}')]");
	public By iconDeleteForRecruiter=By.xpath("//div[@class='icon-delete']//preceding::div[contains(text(),'${status}')]");
	public By eleShowMore= By.xpath("//div[@class='widgetContainer manageRecruiter']//following::div[contains(text(),'${Show More}')]");
	public By enterEmailIds=By.xpath("//input[@placeholder='Enter Email Ids']");
	public By select=By.xpath("//div[@class='select-list']//span[contains(text(),'${recruitername}')]");

	VendorEmpanelmentPO vendorEmpanelmentPO = (VendorEmpanelmentPO) PageObjectWrapper.getObject(VendorEmpanelmentPO.class);
	SaveAndSchedulePageObject SaveAndScheduleObject = new SaveAndSchedulePageObject();
	String vendorSpocName,VendorSpocMail,vendorEditSpocName;
	List<WebElement> listOfRecruiter;


	/**
	 * To Verify message option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyMessageTab(String message) {
		return (message.equalsIgnoreCase(getText(listMessagesTabs)));
	}

	/**
	 * To Verify EditAssignmentDetails option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyEditAssignmentDetailsTab(String EditAssignmentDetails) {
		return (EditAssignmentDetails.equalsIgnoreCase(getText(listEditAssignmentDetailsTabs)));
	}

	/**
	 * To Verify unassign option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyUnassignTab(String Unassign) {
		return (Unassign.equalsIgnoreCase(getText(listUnassignTabs)));
	}
	/**
	 * To Verify Send Reminder option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifySendReminderTab(String SendReminder){
		return(SendReminder.equalsIgnoreCase(getText(listSendReminder)));
	}
	/**
	 * To click on manage User Tab
	 * @param buttonName
	 * @author avani
	 */
	public void vednorManageUserSetting(String buttonName) {
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(lnkClick, buttonName));
		wait.waitForPageToLoadCompletely();

	}
	/**
	 * To click on delete button in light box
	 * @author avani
	 */
	public void clickPopUpDeleteButton() {
		getElement(deletePopUpButton).click();
	}

	/**
	 * To click on edit button
	 * @author avani
	 */
	public void clickEditIcon() {
		jsUtil.clickByJS(parameterizedLocator(eleClickEditIcon,vendorSpocName));
	}

	/**
	 * To click on delete button
	 * @author avani
	 */
	public void clickDeleteIcon() {
		actionBuilderUtil.hoverClickByAction(parameterizedLocator(lblVendorSpocName,vendorEditSpocName));
		jsUtil.clickByJS(parameterizedLocator(eleClickDeleteIcon,vendorEditSpocName));
	}
	/**
	 * To add the details of vendor spoc
	 * @author avani
	 */
	public void addVendorSpoc() {
		vendorSpocName = (CommonAction.generateRandomStrings(10, "Alphanumeric")) + ("@yopmail.com");
		sendKeys(spocName,vendorSpocName);
		VendorSpocMail = (CommonAction.generateRandomStrings(10, "Alphanumeric")) + ("@yopmail.com");
		sendKeys(spocMail,VendorSpocMail);
		click(spocAdd);

	}

	/**
	 * To click on the name of Poc
	 * @author avani
	 */


	public void clickOnPocName() {
		actionBuilderUtil.hoverClickByAction(parameterizedLocator(elePocName,vendorSpocName));
	}

	/**
	 * To edit the name of POC
	 * @author avani
	 */
	public void editPoc() {
		vendorEditSpocName = (CommonAction.generateRandomStrings(10, "Alphanumeric")) + ("@yopmail.com");
		sendKeys(spocName,vendorEditSpocName);
		click(spocEdit);
	}

	/**
	 * To verify the the informatio of Vendor SPOC
	 * @return it will return true if all the details found as expected
	 * @author avani
	 */


	public boolean verifyVendorSpoc() {
		wait.waitForPageToLoadCompletely();
		List<WebElement> lstVendorSpoc = getElements(pocShowMore);
		if (lstVendorSpoc.size() > 0) {
			getElement(pocShowMore).click();
		}
		return isDisplayed(parameterizedLocator(eleVendorSpocName,vendorSpocName));
	}

	/**
	 * To verify the edited information of vendor
	 * @return Will return the result of edited information
	 * @author avani
	 */


	public boolean verifyEditedVendorSpoc() {
		wait.waitForPageToLoadCompletely();
		List<WebElement> lstVendorSpoc = getElements(pocShowMore);
		if (lstVendorSpoc.size() > 0) {
			getElement(pocShowMore).click();
		}

		return (isDisplayed(parameterizedLocator(eleVendorEditSpocName,vendorEditSpocName)));
	}
	/**
	 * This method is use to invite recruiter on Manage user page and click on Enter Email id
	 * @param listOfRecruiters
	 * @author avani
	 */

	public void inviteNewRecruiters(List<String>listOfRecruiters){
		for(int i=0;i<listOfRecruiters.size();i++){
			String recruiters=(listOfRecruiters.get(i).toString());
			sendKeys(enterEmailIds,recruiters);
			click(parameterizedLocator(select,recruiters));
			vendorEmpanelmentPO.clickButtonOnAnyPage("Enter Email Ids");}

	}

	/**
	 * This is used to click on Show More link on Manage User page
	 * @param ShowMore
	 * @author avani
	 */

	public void ClicksOnShowMoreLink(String ShowMore){
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(eleShowMore,ShowMore));
	}
	/**
	 * This is used to count no of Recruiter of given status
	 * @param status
	 * @author avani
	 */

	public void countOfRecruiter(String status){
		listOfRecruiter=getElements(eleRecruiterStatus,status);
		System.out.println("No of"+status+"recruiter is-->"+listOfRecruiter.size());
	}

	/**
	 * This method is use to verify delete icon against the recruiter of provided status
	 * @return Will return the result accordingly to the no of recruiter
	 * @param status
	 * @author avani
	 */
	public boolean verifyDeleteIconAgainstRecruiter(String status){
		if(listOfRecruiter.size()==1){
			return(verifyDeleteIconForOneRecruiter(status));
		}
		else{
			return(verifyDeleteIconForMoreThanOneRecruiter(status));}

	}
	/**
	 * This method is use to verify delete icon against the for one recruiter of provided status
	 * @return Will return the result true if the list is empty for Registered recruiter status
	 * @param status
	 * @author avani
	 */
	public boolean verifyDeleteIconForOneRecruiter(String status) {
		List<WebElement> listOfDeleteIcon = getElements(parameterizedLocator(eleClickDeleteIcon, status));
		System.out.println("No of delete icon-> " + listOfDeleteIcon.size() + " No Of " + status + " recruiter is->" + listOfRecruiter.size());
		return (listOfDeleteIcon.isEmpty());
	}
	/**
	 * This method is use to verify delete icon against the for one recruiter of provided status
	 * @return Will return the result true if the list is empty for Registered recruiter status
	 * @param status
	 * @author avani
	 */

	public boolean verifyDeleteIconForMoreThanOneRecruiter(String status){
		List<WebElement> listOfDeleteIcon=getElements(parameterizedLocator(eleClickDeleteIcon,status));
		System.out.println("No of delete icon->"+listOfDeleteIcon.size()+"No Of"+status+"recruiter is->"+listOfRecruiter.size());
		return(listOfDeleteIcon.size()==listOfRecruiter.size());
	}
	/**
	 * This method is use to delete the recruiters on Manage User page
	 * @param recruiters
	 * @author avani
	 */

	public void deleteRecruiters(String recruiters){
		actionBuilderUtil.hoverClickByAction(parameterizedLocator(iconDeleteForRecruiter,recruiters));
		jsUtil.clickByJS(parameterizedLocator(eleClickDeleteIcon,recruiters));
		SaveAndScheduleObject.clickOnDeleteButtonInDeleteCOnformationBox("YES");
		wait.waitForPageToLoadCompletely();
	}



}
