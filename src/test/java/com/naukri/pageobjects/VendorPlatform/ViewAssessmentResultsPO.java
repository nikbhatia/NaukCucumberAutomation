package com.naukri.pageobjects.VendorPlatform;
import org.openqa.selenium.By;
import com.naukri.test.base.BaseAutomation;
import com.naukri.automation.util.*;

/**
 * 
 * @author ambar.gupta
 *
 */
public class ViewAssessmentResultsPO extends BaseAutomation {

	private By lblHeading = By.className("tabHeadTitle");
	private By txtSubHeading = By.className("tabHeadSubtitle");
	private By ddlTestNameDD = By.xpath("//div[contains(@class,'testNameDD')]");
	private By lblPartnerName = By.xpath("//div[@class='testDts']/span[1]");
	private By lblCreditsLeft = By.xpath("//div[@class='testDts']/span[2]");
	private By lblAttachedStage = By.xpath("//div[@class='testDts']/span[3]");
	private By linkEditSettings = By.xpath("//div[@class='pRel']/a[text()='Edit Test Settings']");
	private By linkExportToExcelTop = By.xpath("//div[@class='pRel']/a[text()='Export to Excel']");
	private By ddlViewMoreOptions = By.xpath("//i[contains(@class,'viewMoreOption')]");
	private By eleMoreOptionsList = By.xpath("//ul[contains(@class,'optionsDD')]/li/a[contains(text(),'${DDlistItem}')]");
	private By txtScreenText = By.className("noTestTitle");
	private By txtScreenSubText = By.className("noTestText");
	private By btnbackArrow = By.className("backArrow");
		
	/**
	 * @author ambar.gupta
	 * This function is verify heading on View Assessments page
	 * @return Whether heading is correct or not
	 */
	public boolean verifyViewAssessmentsPageHeading(String expectedHeading) {
		return getText(lblHeading).equals(expectedHeading);
	}

	/**
	 * @author ambar.gupta
	 * This function is verify sub heading on View Assessments page
	 * @return Whether sub heading is correct or not
	 */
	public boolean verifyViewAssessmentsPageSubHeading(String expectedSubheading) {
		return getText(txtSubHeading).equals(expectedSubheading);
	}

	/**
	 * @author ambar.gupta
	 * This function is verify test details and links/buttons on View Assessments page
	 * @param option to check and its expected value
	 * @return Whether value for option is correct or not
	 */
	public boolean verifyTestDetailsOnViewAssesmentsPage(String option, String ExpectedValue) {

		switch (option) {
		case "PartnerName":	
			return getText(lblPartnerName).equals(ExpectedValue);
		case "Stage":	
			return getText(lblAttachedStage).equals(ExpectedValue);
		case "TestName":	
			return getText(ddlTestNameDD).equals(ExpectedValue);
		default:{
			TestNGLogUtility.info("Wrong input to switch statement");
			return false;
		}
		}
	}

	/**
	 * @author ambar.gupta
	 * This function is verify Back Button Present or not
	 * @return Whether Back Button Present or not
	 */
	public boolean verifyBackButtonPresent() {
		return isDisplayed(btnbackArrow);
	}

	/**
	 * @author ambar.gupta
	 * This function verify Edit Test Settings present or not
	 * @return Whether Edit Test Settings present or not
	 */
	public boolean verifyEditTestSettingsPresent() {
		return isDisplayed(linkEditSettings);
	}

	/**
	 * @author ambar.gupta
	 * This function verify Export To Excel Present or not
	 * @return Whether Edit Export To Excel present or not
	 */
	public boolean verifyExportToExcelPresent() {
		return isDisplayed(linkExportToExcelTop);	
	}

	/**
	 * @author ambar.gupta
	 * This function hover On View More Options 
	 */
	public void hoverOnViewMoreOptions() {
		hover(ddlViewMoreOptions);
	}

	/**
	 * @author ambar.gupta
	 * This function verify View more options DD list
	 * @return Whether DD list item present or not 
	 */
	public boolean verifyMoreOptionsDDlistItemsForPartner(String partnerName, String ddItem) {
		System.out.println(getText(parameterizedLocator(eleMoreOptionsList, ddItem)));
		return isDisplayed(eleMoreOptionsList, ddItem);
	}

	/**
	 * @author ambar.gupta
	 * This function hover On View More Options 
	 */
	public boolean verifyViewAssessmentsPageSubText(String expected) {
		TestNGLogUtility.info(expected);
		TestNGLogUtility.info(getText(txtScreenSubText));
		return getText(txtScreenSubText).contains(expected);
	}
	
	/**
	 * @author ambar.gupta
	 * This function hover On View More Options 
	 */
	public boolean verifyViewAssessmentsPageText(String expected) {
		return getText(txtScreenText).equals(expected);
	}
	
}	