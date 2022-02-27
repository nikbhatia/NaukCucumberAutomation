package com.naukri.pageobjects.Taxonomy.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.test.base.PageObjectWrapper;


/**
 *
 * @author udit.khanna
 */
public class TaxonomyAddASingleProfilePO extends PageObjectWrapper {
	
	public static String uploadFilePath,emailId;

	public By eleCurrentLocationCand = By.xpath("//div[@id='basicDetailsOfCandidate']//input[@id='locSuggestor']");
	public By eleFieldValueToBeChecked = By.xpath("//em[text()='${string}']/following-sibling::span");
	public By eleCurrentLocationRequirement = By.xpath("//div[@id='createProject']//input[@id='locSuggestor']");
	public By eleMetroLocation = By.xpath("//div[@id='sa-dd-scrolllocSuggestor']//li[@index='${index}']");
	public By eleSelectedLoc = By.xpath("(//div[@id='sa-dd-scrolllocSuggestor']//li[contains(@class,'selected')])['${num}']");
	public By eleFileUpload = By.xpath(".//input[@type='file']");
	public By eleJobSuggester = By.id("sa-dd-scrolllocSuggestor");
	/**
	 * verify Location Value Added
	 * 
	 * @param valueAdded
	 * @return
	 */
	public boolean verifyLocationValueAdded(String valueAdded) {
		return getAttribute(eleCurrentLocationCand, "value").equals(valueAdded);
	}

	/** verify field Value Added On CV Details
	 * @param field
	 * @param valueAdded
	 * @return
	 */
	public boolean verifyFieldValueAddedOnCVDetails(String field, String valueAdded) {
		return getText(parameterizedLocator(eleFieldValueToBeChecked, field)).contains(valueAdded);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on Job Location DD for requirement
	 */
	public void clickOnRequirementJobLocation(String sectionName)
	{
		switch(sectionName) {
		case "Requirement":
			jsUtil.scrollDown(eleCurrentLocationRequirement);
			click(eleCurrentLocationRequirement);
			wait.waitForVisibilityOfElement(eleJobSuggester);
			break;
		case "Candidate":
			jsUtil.scrollDown(eleCurrentLocationCand);
			click(eleCurrentLocationCand);
			wait.waitForVisibilityOfElement(eleJobSuggester);
			break;
		}
		
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to fill value in job location dd for requirement 
	 * @param valueToBeEntered
	 */
	public void enterValueInDDField(String valueToBeEntered,String sectionName) {
		wait.hardWait(2);
		switch(sectionName){
		case "Requirement":
			sendKeys(eleCurrentLocationRequirement, valueToBeEntered);
			break;
		case "Candidate":
			sendKeys(eleCurrentLocationCand, valueToBeEntered);
			break;
		}
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to select top metro city of given index
	 * @param index: At 0 index: heading from 0 onwards to 8 top metro cities
	 * @return String: selected city
	 */
	public String selectFromTopMetroCities(String index)
	{
		jsUtil.scrollToElement(eleCurrentLocationRequirement);
		click(eleCurrentLocationRequirement);
		if(!isDisplayed(eleJobSuggester))
		{
			click(eleCurrentLocationRequirement);
			wait.waitForVisibilityOfElement(eleJobSuggester);
		}
		click(parameterizedLocator(eleMetroLocation, index));
		return getAttribute(parameterizedLocator(eleMetroLocation, index), "title");
	}
	
	/**
	 * @author gupta.mansi
	 * This method return selected location from drop down
	 * @return List<String>: selected location from drop down
	 */
	public List<String> getSelectedLocation()
	{
		List<String> selectedLocation = new ArrayList<>();
		for(int temp=1;temp<=getElements(eleSelectedLoc).size();temp++)
		{
			selectedLocation.add(getAttribute(parameterizedLocator(eleSelectedLoc, String.valueOf(temp)),"title"));
		}
		return selectedLocation;
	}
	
	/**
	 * @author gupta.mansi
	 * This method return file path of upload folder
	 * @return file path of upload folder
	 */
    public static String fileSystemPath() {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "testdata" + File.separator + "Upload" + File.separator;
        return filePath;
    }

    /**
     * wip for uploads other that single upload
     * @author gupta.mansi
     * To upload given type of file for different type of uploads
     * @param uploadType
     * @param fileType
     * @param locType
     */
	public void uploadFile(String fileType ,String locType, String uploadType) {
		uploadFilePath = getUploadFilePath(uploadType,fileType,locType);
		switch(uploadType)
		{
		case "SingleUpload":
		case "MultiUpload":
			getElement(eleFileUpload).sendKeys(uploadFilePath);
			wait.hardWait(10);
			wait.waitForProcessingToDisappear(10, 6);
			break;
		case "ExcelUpload":
			updateExcelFile(uploadType,fileType,locType);
			getElement(eleFileUpload).sendKeys(uploadFilePath);
			wait.hardWait(5);
			break;
		}
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to update email id in given excel file
	 * @param fileType
	 * @param locType
	 * @param uploadType
	 */
	public void updateExcelFile(String fileType ,String locType, String uploadType)
	{
		emailId = "TestEid"+System.currentTimeMillis()+"@yopmail.com";
		try {
			FileInputStream inputStream = new FileInputStream(uploadFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet  sheet = workbook.getSheet("ExcelUpload");
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell = row.getCell(1);
			TestNGLogUtility.info("Before updating value of emailId "+cell.getStringCellValue());
			cell.setCellValue(emailId);
			TestNGLogUtility.info("After updating value of emailId "+cell.getStringCellValue());
			inputStream.close();
			FileOutputStream output_file =new FileOutputStream(uploadFilePath); 
			workbook.write(output_file);
			workbook.close();
			output_file.close();
			TestNGLogUtility.info("Excel file has been generated successfully."); }
			catch(Exception e) {
				TestNGLogUtility.info("Exception trown");
				e.printStackTrace();}
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns path of the file for give params
	 * @uploadType: SingleUpload,ExcelUpload,BulkUpload
	 * @fileType: PDF,DOCX,DOC,XLSX,XLS,RTF etc
	 * @locType: National, NationalTail, International etc
	 */
	public String getUploadFilePath(String uploadType,String fileType, String locType)
	{
		return fileSystemPath()+YamlReader.getAppConfigValue(uploadType+"."+fileType+"."+locType);
	}
	
	/**
	 * @author gupta.mansi
	 * This method return current location filled on add a single profile page
	 * @return String
	 */
	public String getCurrentLocation()
	{
		jsUtil.scrollDown(eleCurrentLocationCand);
		return getAttribute(eleCurrentLocationCand, "placeholder");
	}


}
