package com.naukri.pageobjects.MLH;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.MongoDBConnector;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

/**
 * @author gupta.mansi
 * @author abhishek.dwivedi
 * 
 */
public class OldReportDashboardPagePO extends BaseAutomation{
	
	By lnkReportName = By.xpath("//a[text()='${reportName}']");
	By btnGenerateReport = By.id("generateReport");
	By txtHeaderLB = By.xpath("//strong[text()='${txt}']");
	private By ddlOnReportPage=By.xpath("//input[@type='text' and contains(@placeholder,'${dropdowntype}')]");
	private By chkVisibleOption=By.xpath("//ul[@class='ChkboxEnb']//b[contains(.,'${OptionValue}')]/..");
	private By btnButtonNameOnReportPage=By.xpath("//a[contains(@class,'Class') and contains(.,'${ButtonName}')]");
	private By chkCheckBoxNameOnReportPage=By.xpath("//input[@type='checkbox']/following-sibling::label[contains(.,'${CheckBoxName}')]/..//input");
	private By rdoRadioButtonNameOnReportPage=By.xpath("//input[@type='radio']/following-sibling::label[contains(.,'${RadioButtonName}')]/..//input");
	private By btnClearAll=By.xpath("(//h2[contains(.,'${DropDownName}')]/following-sibling::div//a[contains(.,'Clear All')])[1]");
	private By chkAll=By.xpath("(//h2[contains(.,'${DropDownName}')]/following-sibling::div//a[contains(.,'All')])[1]");
	private By lstReportColumnName=By.xpath("(//table[@id='reportTable']//tr)[2]//th");
	
	private By lblColumnData=By.xpath("//div[contains(@class,'tableWrapper')]//tbody//tr[contains(@class,'bold')]//td[${Index}]");
	
	private By eleColumnName=By.xpath("//div[contains(@class,'tableWrapper')]//tr//th[contains(.,'${ColumnName}')]/preceding-sibling::th");
	//private By eleColumnName=By.xpath(".//*[.='${CoulmnName}']/preceding-sibling::*");
	
	
	
	JSONArray value= new JSONArray();
	HashMap<String, String> hmap = new HashMap<>();
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given type of report name
	 * @param reportName
	 */
	public void clickOnReportName(String reportName)
	{
		click(parameterizedLocator(lnkReportName, reportName));
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given tab name
	 * @param tabName
	 */
	public void clickOnTab(String tabName)
	{
		jsUtil.executeJavascript("arguments[0].scrollIntoView(true);",parameterizedLocator(lnkReportName, tabName));
		click(parameterizedLocator(lnkReportName, tabName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Generate Report Button
	 */
	public void clickOnGenerateReport()
	{
		click(btnGenerateReport);
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to hover over given anchor text
	 * @param anchorToHover
	 */
	public void hoverOver(String anchorToHover)
	{
		mouseHoverAndClickToWebElement(getElement(lnkReportName, anchorToHover));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to return true if @param txt is displayed in lightbox header
	 * @param txt
	 * @return true if text is displayed
	 */
	public boolean isHeaderTxtDisplayed(String txt)
	{
		return isDisplayed(parameterizedLocator(txtHeaderLB, txt));
	}

	/**
	 * This method use to select the text from the drop down on Report page
	 * 
	 * @author abhishek.dwivedi
	 * @param textToBeEnter as Array , key
	 */
	public void selectValueFromDropDownofReportPage(String key, JSONArray textToBeEnter) {
		if (isDisplayed(parameterizedLocator(btnClearAll, key))) {
			click(parameterizedLocator(btnClearAll, key));
		}
		Iterator<?> it = textToBeEnter.iterator();
		while (it.hasNext()) {
			String value = it.next().toString();
			if (value.equals("All")) {
				click(parameterizedLocator(ddlOnReportPage, key));
				click(parameterizedLocator(chkAll, key));
				wait.hardWait(5);
			} else {
				getElement(ddlOnReportPage, key).clear();
				sendKeys(parameterizedLocator(ddlOnReportPage, key), value);
				click(parameterizedLocator(chkVisibleOption, value));
				wait.hardWait(5);
			}

		}
	}
/**
 * This method click on break up By option as provide by user
 * @author abhishek.dwivedi
 * @param button name which need to be clicked
 */
	public void clickButtonNameOnReportPage(String buttonNameType) {
		click(parameterizedLocator(btnButtonNameOnReportPage, buttonNameType));
	}
	
	/**
	 * This method use to click on checkbox visible on the Report page
	 * 
	 * @author abhishek.dwivedi
	 * @param key name , checkbox name
	 */

	public void clickCheckBoxOnReportPage(String keyName, String chkName) {
		if (!chkName.equals("false")) {
			click(parameterizedLocator(chkCheckBoxNameOnReportPage, keyName));
		}
	}
	
	/**
	 * This method use to click on radio button visible on the Report page
	 * 
	 * @author abhishek.dwivedi
	 * @param name of the radio button
	 */

	public void clickRadioOnReportPage(String radioButtonName) {
		if (!isSelected(parameterizedLocator(rdoRadioButtonNameOnReportPage, radioButtonName))) {
			click(parameterizedLocator(rdoRadioButtonNameOnReportPage, radioButtonName));
		}
	}

	/**
	 * This method use to fill Report page on the basis of data store in mongoDB
	 * tuple
	 * 
	 * @author abhishek.dwivedi
	 * 
	 * @param mongoCOllection data as Json object
	 */
	public void FillReportPageDetails(JSONObject testCaseData) {
		for (Object key : testCaseData.keySet()) {
			System.out.println("Key name is " + key.toString());
			switch (key.toString()) {
			case "Recruiter":
			case "Source":
			case "Requirement":
			case "Requirement Status":
			case "Group":
			case "Requirement Created By":
			case "Hiring Managers":
			case "HR Spocs":
				value = checkMongoDataAndReturn(testCaseData.get(key));
				selectValueFromDropDownofReportPage(key.toString(), value);
				TestNGLogUtility.info("Done");
				break;
			case "Show Breakup By":
			case "Report Type":
			case "View Report":
				clickButtonNameOnReportPage(testCaseData.get(key).toString());
				TestNGLogUtility.info("Done");

				break;
			case "Show reports for Requirements created / re-opened":
			case "Show reports for Activities done":
				if (testCaseData.get(key).toString().equals("true")) {
					clickRadioOnReportPage(key.toString());
				}
				TestNGLogUtility.info("Done");
			break;	
			case "TimePeriod":
				clickButtonNameOnReportPage(testCaseData.get(key).toString());
				TestNGLogUtility.info("Done");

				break;
			case "Comparison with previous period":
			case "Consider only the Latest Status of the Candidates as of today":
			case "Save this Report":
				clickCheckBoxOnReportPage(key.toString(), testCaseData.get(key).toString());
				break;

			}
		}

	}

	/**
	 * This method use to check if mongo data is Jsonobject or JsonArray and convert
	 * json object to Json Array
	 * @author abhishek.dwivedi
	 * @param MongoDBdocument key 
	 * @return value as JsonArray  
	 */
	@SuppressWarnings("unchecked")
	public JSONArray checkMongoDataAndReturn(Object mongoValueAgainstKey) {
		value = new JSONArray();
		Object valueObj =mongoValueAgainstKey;
		if (valueObj instanceof JSONArray) {
			value = (JSONArray) valueObj;
		} else {
			value.add(valueObj);
		}
		return value;
	}
	
	
	/**
	 * This method use to read the data from the report UI 
	 * and save the data along with key such as View, Downloaded etc
	 * @author abhishek.dwivedi
	 * @return Reportdata in Hashmap
	 */
	public HashMap<String, String> getReportDataInMap() {
		List<WebElement> lst = getElements(lstReportColumnName);
		for (int i = 2; i < lst.size(); i++) {
			String key = lst.get(i).getText();// viewed 
			int position = getElements(eleColumnName, key).size() + 1;
			String value = getElement(lblColumnData, String.valueOf(position)).getText();
			hmap.put(key, value);
		}
		TestNGLogUtility.info("Report Details added in Map "+hmap);
		return hmap;

	}

	/**
	 * Update/Save data in mongo collection related to Report
	 * @author abhishek.dwivedi
	 * @param test cases name, Key and Values pair in map which need to be updated in mongo document
	 */
	public void UpdateReportDataInMongo(String testCaseName, HashMap<String, String> hmapToBeUpdated) {
		hmapToBeUpdated = hmap;
		MongoDBConnector.UpdateValuesInMongoDocument("MLHOldReports", hmapToBeUpdated, "TestCaseName","Output" + testCaseName + "");
		TestNGLogUtility.info("Report Details updated in Mongo collection for " +"Output" + testCaseName + "");
	}

	/**
	 * Compare the Report data on UI to data store in mongo DB
	 * @author abhishek.dwivedi
	 * @param hmap1,hmap2
	 */
	public void compareUIReportDataWithStoredData(HashMap<String, String> hmap1, HashMap<String, String> hmap2) {
		List<WebElement> lst = getElements(lstReportColumnName);
	}
}
