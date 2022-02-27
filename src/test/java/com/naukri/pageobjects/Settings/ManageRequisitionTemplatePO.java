package com.naukri.pageobjects.Settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.naukri.test.base.BaseAutomation;

public class ManageRequisitionTemplatePO extends BaseAutomation {

	/**
	 * @author jatin.bisht
	 */
	String firstTemplateName;
	private By inpValue = By.cssSelector("input[value='${value}']");
	private By txtRequisitionTemplateName = By.cssSelector("input[name='requisitionTemplateName']");
	private By ddPrefillTemplate = By.cssSelector("input[name='prefill']");
	private By ddPrefilValue1 = By.cssSelector("li[index='1']");
	private By iconSort = By.cssSelector("img[class='sortIcon iconOnHover']");
	private By txtFirstTemplateName = By.xpath("(//div[@class='reqTemplateName'])[1]");
	private By txtJobTitle = By.xpath("//input[@class='jobTitleSuggestor ']");
	private By ddMinExp = By.id("minExp");
	private By ddMinExpValue = By.cssSelector("li[value='a0']");
	private By ddMaxExp = By.id("maxExp");
	private By txtKeySkills = By.cssSelector("input[class='keySkillsSuggestor']");
	private By ddKeyskillSuggestor = By.xpath("//span[text()='Mechanical ']");
	private By rdoMyGroups = By.xpath("//label[text()='My Groups']");
	private By ddSelectgroup = By.xpath("//span[contains(text(),'avail this template')]");
	private By ddSelectAllgroups = By.xpath("//label[text()='Select All']");
	private By txtJobDescription = By.xpath("(//div[@class='mailBodyWriter'])[1]");
	private By txtCandidateProfile = By.xpath("(//div[@class='mailBodyWriter'])[2]");
	private By ddMinSalary = By.id("minSalary");
	private By ddMinSalaryValue = By.cssSelector("li[index='1']");
	private By ddMaxSalary = By.id("maxSalary");
	private By ddLocation = By.id("cityLoc");
	private By txtVacancies = By.cssSelector("input[name='vacancies']");
	private By txtWorkLevel = By.xpath("//input[contains(@placeholder,'Worklevel')]");
	private By txtOtherInfo = By.xpath("//input[contains(@placeholder,'information')]");
	private By liListItemvalue = By.xpath("(//li[text()='${listItem}'])[1]");
	private By txtSearchBar = By.cssSelector("input[type='search']");
	private By btnSearch = By.id("searchIcon");
	private By btnCrossOnSuccessStrip = By.xpath("//span[@class='hideErrSucc']");
	private By lblSuccessMsg = By.xpath("//*[contains(text(),'${successMsg}')]");
	private By liListOfAction = By.xpath("//div[text()='${reqTemplateName}']/../div/ul/li");
	private By txtRequisitionTitle = By.id("requestName");
	private By ddSelectGroupRequisition = By.id("selectGroup");
	private By chkSelectGroup = By.xpath("(//select[@name='groupId']/option)[2]");
	private By ddSelectRecruiter = By.id("selectRecruiter");
	private By chkSelectRecruiter = By.xpath("(//select[@name='hrSpocId']/option)[2]");
	private By ddPrefillRequisition = By.xpath("//input[contains(@placeholder,'Copy from existing Requisitions')]");
	private By elePrefillFromRequisitionTemplate = By.xpath("(//div[@class='searchSuggestionTuple'])[1]");
	public By eleSalaryOnLightBox = By
			.xpath("//span[contains(@class,'salIconWr')]/span[contains(text(),'${value}% variable')]");
	public By elePreviewButtonOfanyRequisition = By
			.xpath("//div[@class='reqTemplateName' and text()='${reqisitionName}']/parent::div//li[text()='Preview']");
	 By ddSalaryAmount = By.xpath("//li[text()='${value}']");
	 By keywordStar = By.xpath("//div[contains(@class,'keySkillsWrapper ')]//span[@class='toIds' and text()='${value}']/span");

	/**
	 * @author jatin.bisht common method to click on input tag where value is equal
	 *         to " pass on string
	 */
	public void clickOnValuee(String value) {
		wait.waitForPageToLoadCompletely();
		getElement(inpValue, value).click();
	}

	/**
	 * @author jatin.bisht This method create requisition template by prefilling it
	 *         from other templates
	 * @param in this only templateName is provided
	 */
	public void createRequisitionTemplateByPrefilling(String reqTemplateName) {
		wait.waitForElementToBeClickable(txtRequisitionTemplateName);
		getElement(txtRequisitionTemplateName).sendKeys(reqTemplateName);
		wait.waitForPageToLoadCompletely();
		getElement(ddPrefillTemplate).click();
		getElement(ddPrefilValue1).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author jatin.bisht This method click on sorting icon of template name and
	 *         get the text of first template name
	 */
	public void clickOnSorting() {
		wait.waitForVisibilityOfElement(txtFirstTemplateName);
		firstTemplateName = getElement(txtFirstTemplateName).getText();
		hover(iconSort);
		getElement(iconSort).click();
	}

	/**
	 * @author jatin.bisht This method fills all madatory fields of requisition
	 *         template
	 */
	public void fillMandatoryFieldsOfReqTemplate(String reqTemplateName) {
		wait.waitForElementToBeClickable(txtRequisitionTemplateName);
		getElement(txtRequisitionTemplateName).sendKeys(reqTemplateName);
		getElement(txtJobTitle).sendKeys("Mechanical Engineer");
		getElement(ddMinExp).click();
		getElement(ddMinExpValue).click();
		getElement(ddMaxExp).click();
		getElement(ddMinExpValue).click();
		getElement(txtKeySkills).sendKeys("engi");
		getElement(ddKeyskillSuggestor).click();
	}

	/**
	 * @author jatin.bisht this method fill all fields of Requisition template
	 */
	public void fillAllFieldsReqTemplate(String reqTemplateName) {
		wait.waitForElementToBeClickable(txtRequisitionTemplateName);
		getElement(txtRequisitionTemplateName).sendKeys(reqTemplateName);
		wait.waitForPageToLoadCompletely();
		getElement(rdoMyGroups).click();
		getElement(ddSelectgroup).click();
		wait.waitForPageToLoadCompletely();
		getElement(ddSelectAllgroups).click();
		getElement(txtJobTitle).sendKeys("Hardware Engineer");
		getElement(txtJobDescription).sendKeys("Looking for a Hardware engineer");
		getElement(txtCandidateProfile).sendKeys("candidate should be Mechaninc");
		getElement(ddMinExp).click();
		getElement(ddMinExpValue).click();
		getElement(ddMaxExp).click();
		getElement(ddMinExpValue).click();
		getElement(txtKeySkills).sendKeys("engi");
		getElement(ddKeyskillSuggestor).click();
		getElement(ddMinSalary).click();
		getElement(ddMinSalaryValue).click();
		getElement(ddMaxSalary).click();
		getElement(ddMinSalaryValue).click();
		getElement(ddLocation).click();
		getElement(ddMinSalaryValue).click();
		getElement(txtVacancies).sendKeys("5");
//		getElement(txtWorkLevel).sendKeys("8A");
//		getElement(txtOtherInfo).sendKeys("this is other information");
	}

	/**
	 * @author jatin.bisht this method verifies that created requisition template is
	 *         visible or not
	 * @param reqTemplateName :- stores template name which we created.
	 */
	public boolean verifyRequisitionTemplateAdd(String reqTemplateName) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(By.xpath("//*[text()='" + reqTemplateName + "']"));
	}

	/**
	 * @author jatin.bisht This method is used click on various options on external
	 *         source (edit or delete)
	 * @param listItem
	 */
	public void clickOnListItems(String listItem) {
		getElement(liListItemvalue, listItem).click();
	}

	/**
	 * @author jatin.bisht this method verify the sorting after clicking on sorting
	 *         icon by comparing the first template name before and after sorting
	 * @return
	 */
	public boolean verifySortingTemplate() {
		String secondTemplateName = getElement(txtFirstTemplateName).getText();
		if (firstTemplateName.equalsIgnoreCase(secondTemplateName)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @author jatin.bisht This method enters same requisition template name which
	 *         already created when creating requisition template
	 */
	public void enterSameRequisitionTemplateName() {
		getElement(ddPrefillTemplate).click();
		String alreadyCreatedTemplate = getElement(ddPrefilValue1).getText();
		getElement(txtRequisitionTemplateName).sendKeys(alreadyCreatedTemplate);
	}

	/**
	 * @author jatin.bisht this method enters requisition name on search bar
	 * @param reqTemplateName Same requisition name which we created before
	 *                        searching
	 */
	public void enterReqTemplateNameOnsearch(String reqTemplateName) {
		sendKeys(txtSearchBar, reqTemplateName);
		getElement(btnSearch).click();
	}

	/**
	 * @author jatin.bisht This method click on CROSS (X) on success strip
	 */
	public void clickOnCrossOptionOnStrip() {
		getElement(btnCrossOnSuccessStrip).click();
	}

	/**
	 * @author jatin.bisht This method verifies that success message is not visible
	 * @param successMsg
	 */
	public boolean verifySuccessMsgNotVisible(String successMsg) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblSuccessMsg, successMsg));
	}

	/**
	 * @author jatin.bisht This method verifies list of action visible to the user
	 *         and edit should not be there
	 * @param reqTemplateName        
	 */
	public boolean getListOfAuthorisedActions(String reqTemplateName) {
		List<WebElement> lst = getElements(liListOfAction, reqTemplateName);
		int i;
		boolean flag = true;
		for (i = 0; i < lst.size(); i++) {
			if (lst.get(i).getText().equalsIgnoreCase("Edit")) {
				flag = false;
				break;
			}
		}
		if (i == lst.size()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * @author jatin.bisht This method fill Requisition Title,select group for whoch
	 *         requisition should be raised and select the Recruiter
	 * @param reqTemplateName
	 */
	public void fillReqNameGroupRecruiter(String reqTemplateName) {
		sendKeys(txtRequisitionTitle, reqTemplateName);
		getElement(ddSelectGroupRequisition).click();
		getElement(chkSelectGroup).click();
		wait.waitForPageToLoadCompletely();
		getElement(ddSelectRecruiter).click();
		getElement(chkSelectRecruiter).click();
	}

	/**
	 * @author jatin.bisht This method prefills from requisition template when raising requsition
	 */
	public void prefillFromRequisitionTemplate() {
		getElement(ddPrefillRequisition).click();
		getElement(elePrefillFromRequisitionTemplate).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * This method is used for verify Variable amount on Requisition Template
	 *
	 * @author himanshu.dua
	 */
	public boolean verifyVariableWithSalary(String variableAmount) {
		return isDisplayed(parameterizedLocator(eleSalaryOnLightBox, variableAmount));
	}
	
	/**
	 * This method will click on preview button of any requisition
	 */
	public void clickOnPreviewButton(String requisitionName) {
		click(parameterizedLocator(elePreviewButtonOfanyRequisition,requisitionName));
	}
	
	public void fillMinAndMaxSalary(String ctc, String amount) {
		if (ctc.contains("min"))
			getElement(ddMinSalary).click();
		else
			getElement(ddMaxSalary).click();
		getElement(parameterizedLocator(ddSalaryAmount, amount)).click();
	}

	public void fillKeyWord(String keyWords) {
		sendKeys(txtKeySkills, keyWords);
		getElement(txtKeySkills).sendKeys(Keys.ENTER);
	}

	/**
	 * This will click on star keyword
	 * @param keyword
	 */
	public void clickOnStarAgainstSkill(String keyword) {
		click(parameterizedLocator(keywordStar, keyword));
	}
	
	/**
	 * This will click on star keyword
	 * @param keyword
	 */
	public boolean verifytoolTip(String type, String keyword) {
		boolean flag = false;
		if (type.equals("Selected"))
			flag = getAttribute(parameterizedLocator(keywordStar, keyword), "title")
					.equals(keyword + " marked as \"must have\" keyword");
		else if (type.equals("Unselected"))
			flag = getAttribute(parameterizedLocator(keywordStar, keyword), "title")
					.equals("Mark " + keyword + " as \"must have\" keyword.");
		else if (type.equals("Disabled"))
			flag = getAttribute(parameterizedLocator(keywordStar, keyword), "title")
					.equals("Only 3 keywords can be marked as \"must have\"");
		return flag;
	}
}
