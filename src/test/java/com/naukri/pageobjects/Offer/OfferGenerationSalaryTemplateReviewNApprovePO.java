package com.naukri.pageobjects.Offer;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;

/**
 * @author udit.khanna
 *
 */
public class OfferGenerationSalaryTemplateReviewNApprovePO extends BaseAutomation {

	// locators
	public By inputLabels = By.xpath("//div[@class='input-wrapper']/label");
	public By inputLabelErrors = By.xpath("//div[@class='input-wrapper']/div[@class='ra-err-msg']");
	public By linkOnReviewPage = By.xpath("//div[contains(text(),'${string}')]");
	public By inputFieldForLabel = By
			.xpath("//label[@class='input-label' and text()='${string}']/following-sibling::input");
	public By txtErrorMessageforLabel = By
			.xpath("//label[@class='input-label' and text()='${string}']/following-sibling::div[@class='ra-err-msg']");
	public By dateLabelsOnReview = By
			.xpath("//label[contains(text(), \"${string}\")]/following-sibling::div//span[@class='selected-date ']");
	public By valuesforLabels = By.xpath("//label[contains(text(), \"${string}\")]/following-sibling::input");
	public By rowsInTable = By.xpath("//table[@id='instantOutputTable']//tr");
	public By tableFirstColumn = By.xpath("//table[@id='instantOutputTable']//tr[${string}]/td[1]");
	public By tableSecondColumn = By.xpath("//table[@id='instantOutputTable']//tr[${string}]/td[2]");
	public By txtFootnoteSymbolOnReview = By.xpath("//table[@id='outputFootnotes_footnotes']//td[1]");
	public By txtFootnoteDescriptionOnReview = By.xpath("//table[@id='outputFootnotes_footnotes']//td[2]");
	public By draftForFirstTemplate = By
			.xpath("(//span[@class='inline-name'])[1]/following-sibling::span[@class='sb-template-draft']");

	/**
	 * Verify all Input Fields on Review Page
	 * 
	 * @param list
	 * @return true if all Input Fields are present on Review Page
	 */
	public boolean verifyAllInputsInReviewPage(List<String> list) {
		jsUtil.scrollDown(By.xpath("(//div[@class='input-wrapper']/label)[5]"));
		List<WebElement> actualList = getElements(inputLabels);
		List<String> actualListText = new ArrayList<>();
		for (WebElement element : actualList) {
			actualListText.add(element.getText().toString());
		}
		return list.equals(actualListText);
	}

	/**
	 * Click Link On Review Page
	 * 
	 * @param linkText
	 */
	public void clickLinkOnReviewPage(String linkText) {
		getElement(linkOnReviewPage, linkText).click();
	}

	/**
	 * verify All Input Errors On Review Page
	 * 
	 * @param list
	 * @return true if All Input Errors are present On Review Page
	 */
	public boolean verifyAllInputErrorsOnReviewPage(List<String> list) {
		List<WebElement> actualList = getElements(inputLabelErrors);
		List<String> actualListText = new ArrayList<>();
		for (WebElement element : actualList) {
			actualListText.add(element.getText().toString());
		}
		return list.equals(actualListText);
	}

	/**
	 * Enter value in field depending on input type
	 * 
	 * @param inputType
	 * @param field
	 */
	public void enterValueInFieldOnReviewPage(String inputType, String field) {
		int length = 0;
		if (inputType.equalsIgnoreCase("string"))
			length = 10;
		else if (inputType.equalsIgnoreCase("number"))
			length = 4;
		getElement(inputFieldForLabel, field).sendKeys(CommonAction.generateRandomStrings(length, inputType));
	}

	/**
	 * Verify error message for field
	 * 
	 * @param field
	 *            Name
	 * @param list
	 *            of error messages
	 */
	public boolean verifyErrorMessageForField(String fieldName, List<String> list) {
		return getElement(txtErrorMessageforLabel, fieldName).getText().contains(list.get(0));
	}

	/**
	 * verify All Input And Output Fields
	 */
	public boolean verifyAllInputAndOutputFields() {
		HashMap<String, String> expectedValues = new HashMap<String, String>();
		HashMap<String, String> actualValues = new HashMap<String, String>();
		// expectedValues.putAll(getDateValues());
		expectedValues.putAll(getLabelValues());
		actualValues.putAll(getBreakupTableValues());
		return actualValues.equals(expectedValues);
	}

	/**
	 * get Breakup Table Values
	 * 
	 * @return map with breakup table values
	 */
	private Map<String, String> getBreakupTableValues() {
		HashMap<String, String> values = new HashMap<String, String>();
		for (int i = 1; i <= getElements(rowsInTable).size(); i++) {
			values.put(getElement(tableFirstColumn, Integer.toString(i)).getText(),
					getElement(tableSecondColumn, Integer.toString(i)).getText());
		}
		values.remove("Offered on");
		values.remove("Candidate's tentative joining date");
		return values;
	}

	/**
	 * get values from Label
	 * 
	 * @return map with label values
	 */
	private Map<String, String> getLabelValues() {
		String[] str = { "Offered Designation", "Label4", "Label1", "Label2", "Label3" };
		HashMap<String, String> map = new HashMap<>();
		map.put(str[0], getElement(valuesforLabels, str[0]).getAttribute("value"));
		map.put(str[1], getElement(valuesforLabels, str[1]).getAttribute("value"));
		map.put(str[2], getElement(valuesforLabels, str[2]).getAttribute("value"));
		map.put(str[3], computeValueforLabel(str[3], map.get(str[2]), map.get(str[1])));
		map.put(str[4], computeValueforLabel(str[4], map.get(str[2]), map.get(str[1])));
		return map;
	}

	/**
	 * Compute value for output labels
	 * 
	 * @param outputLabel
	 * @param inputLabel1
	 * @param inputLabel2
	 * @return computed value for output labels
	 */
	private String computeValueforLabel(String outputLabel, String inputLabel1, String inputLabel2) {
		int value = 0;
		if (outputLabel.equalsIgnoreCase("Label2")) {
			value = Integer.parseInt(inputLabel1) * 10;
		} else if (outputLabel.equalsIgnoreCase("Label3")) {
			value = Integer.parseInt(inputLabel1) * Integer.parseInt(inputLabel2);
		}
		return Integer.toString(value);
	}

	/**
	 * Get date inputs entered
	 * 
	 * @return map with label and date
	 */
	private HashMap<String, String> getDateValues() {
		String str1 = "Offered on", str2 = "Candidate's tentative joining date";
		HashMap<String, String> map = new HashMap<>();
		map.put(str1, convertDateFormat(getElement(dateLabelsOnReview, str1).getText().toString(), "yyyy-dd-mm"));
		map.put(str2, convertDateFormat(getElement(dateLabelsOnReview, str2).getText().toString(), "dd-mm-yyyy"));
		return map;
	}

	/**
	 * convert Date Format to another format
	 * 
	 * @param dateStr
	 * @return date in converted format
	 */
	@SuppressWarnings("finally")
	public String convertDateFormat(String dateStr, String dateFormat) {
		try {
			DateFormat srcDf = new SimpleDateFormat("dd MMM yyyy");
			Date date = srcDf.parse(dateStr);
			Timestamp ts = new Timestamp(date.getTime());
			DateFormat destDf = new SimpleDateFormat(dateFormat);
			dateStr = destDf.format(ts);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			return dateStr;
		}
	}

	/**
	 * verify Footnote Added To Breakup Table
	 * 
	 * @param expectedValue
	 * @return true if Footnote Added To Breakup Table
	 */
	public boolean verifyFootnoteAddedToBreakupTable(List<String> expectedValue) {
		boolean flag = true;
		for (int i = 0; i < expectedValue.size(); i++) {
			if (i == 0) {
				if (!getText(txtFootnoteSymbolOnReview).contains(expectedValue.get(i)))
					flag = false;
			} else {
				if (!getText(txtFootnoteDescriptionOnReview).contains(expectedValue.get(i)))
					flag = false;
			}
		}
		return flag;
	}

	/**
	 * verify Draft Label Not Displayed
	 * 
	 * @return true if Draft Label Not Displayed
	 */
	public boolean verifyDraftLabelNotDisplayed() {
		return !isDisplayed(draftForFirstTemplate);
	}

}
