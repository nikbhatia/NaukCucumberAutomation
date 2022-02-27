package com.naukri.pageobjects.Offer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.naukri.test.base.BaseAutomation;

import scala.collection.mutable.HashMap;

/**
 * @author udit.khanna
 *
 */
public class OfferGenerationSalaryTemplateOutputPO extends BaseAutomation {

	// variables
	private HashMap<String, String> expectedIdentifiedFields = new HashMap<>();
	private HashMap<String, String> actualIdentifiedFields = new HashMap<>();

	// CONSTANTS
	static final String REVIEWNAPPROVESUBHEADING_TXT = "During actual offer generation, "
			+ "recruiter will be presented the below input fields. "
			+ "View and confirm that all salary components are correct.";
	static final String FIRSTCELL_TXT = "Offered on";

	// locators
	public By breakupTableCell_0_1 = By.id("breakupTable_0_1");
	public By breakupTableCell_1_0 = By.id("breakupTable_1_0");
	public By breakupTableCell_1_1 = By.id("breakupTable_1_1");
	public By MenuOption = By.xpath("//div[@class='menu-icon dsb-icons-config']");
	public By optionsInMenuOption = By
			.xpath("//div[@id='alt-menu-cont']/div[starts-with(@class, 'alteration-menu__option')]/span[1]");
	public By styleOptionsInMenuOption = By.xpath("//div[@id='alt-menu-cont']//div[@data-value='${style}']");
	public By fontColorDDInMenuOption = By.xpath("//div[@class='color-box-arrow altm-icons-config']");
	public By fontColorInMenuFontColorOption = By.xpath("//div[@class='cp-option' and @data-value='#283E56:#fff']");
	public By rowsInBreakupTable = By.xpath("//table[@id='breakupTable']//tr");
	public By linkOnOutputPage = By.xpath("//*[contains(text(),'${string}')]");
	public By tagsInInsertTagsMenu = By.xpath("//div[@id='alt-menu-scrollbar']//div[@class='alteration-menu__option']");
	public By linkInMenuOption = By.xpath("//div[@id='alt-menu-scrollbar']//div[contains(text(),'${string}')]");
	public By txtModalHeading = By.xpath("//div[@class='modalHeading']");
	public By footnoteSymbol = By.id("symbol");
	public By footnoteDescription = By.id("description");
	public By buttonXpath = By.xpath("//button[contains(text(), '${string}')]");
	public By txtFootnoteSymbol = By.xpath("//table[@id='breakupTable_footnotes']//td[1]");
	public By txtFootnoteDescription = By.xpath("//table[@id='breakupTable_footnotes']//td[2]");
	public By CTCErrorMessage = By.xpath("//input[@id='cellReference']/ancestor::div//div[@class='ext-error-msg']");
	public By ctcDropdown = By.id("cellReference");
	public By dropdownValues = By.xpath("//li[text()='${string}']");
	public By reviewNApproveSubHeading = By.xpath("//div[@class='sub_heading']");
	public By firstRowDragIcon = By.xpath("//td[@id='breakupTable_1_0']/div[@class='drag-icon']");
	public By secondRowDragIcon = By.xpath("//td[@id='breakupTable_2_0']");
	public By eleInputSourceForNewInput = By.xpath("//td[@id='inputsTableEditRow_${string}_1']");
	public By rdoInputSourceType = By.xpath("//label[text()='${string}']");
	public By ddlSheetName = By.id("sheet-name");
	public By txtCellReferenceField = By.xpath("//span[text()='Cell Reference']/following-sibling::div/input");
	public By lblWarningMessage = By.xpath("//div[@class='msg']");
	public By eleInputTableRows = By.xpath("//table[@id='inputsTable']//tr");
	public By BtnCancelOnInputSource = By.xpath("//div[@class='rm-cancel-button']");

	/**
	 * Verify if all fields are being identified
	 * 
	 * @return true if all fields are identified
	 */
	public boolean verifySystemIdentifiedFields() {
		loadExpectedIdentifiedFields();
		for (int i = 1; i <= 7; i++) {
			actualIdentifiedFields.put(getText(By.xpath("//td[@id='breakupTable_" + i + "_1']")),
					getText(By.xpath("//td[@id='breakupTable_" + i + "_2']")));
		}
		return expectedIdentifiedFields.equals(actualIdentifiedFields);
	}

	/**
	 * Load map with expected values in the field
	 * 
	 */
	private void loadExpectedIdentifiedFields() {
		expectedIdentifiedFields.put("Offered Designation", "[Input:Offered Designation]");
		expectedIdentifiedFields.put("Offered on", "[Input:Offered on]");
		expectedIdentifiedFields.put("Candidate's tentative joining date",
				"[Input:Candidate's tentative joining date]");
		expectedIdentifiedFields.put("Label4", "[Input:Label4]");
		expectedIdentifiedFields.put("Label1", "[Input:Label1]");
		expectedIdentifiedFields.put("Label2", "[Sheet1:B3]");
		expectedIdentifiedFields.put("Label3", "[Sheet1:B4]");
	}

	// /**
	// * Click first cell then click menu option
	// */
	// public void clickMenuOptionToAddColumns() {
	// click(breakupTableCell_0_1);
	// jsUtil.clickByJS(MenuOption);
	// }

	/**
	 * Click menu option
	 */
	public void clickMenuOption(String string) {
		if (string.equalsIgnoreCase("column")) {
			click(breakupTableCell_0_1);
			jsUtil.clickByJS(MenuOption);
		} else if (string.equalsIgnoreCase("inside cell")) {
			click(breakupTableCell_1_1);
			jsUtil.clickByJS(MenuOption);
		} else if (string.equalsIgnoreCase("row"))
			click(breakupTableCell_1_0);

	}

	/**
	 * Click Link on output screen
	 */
	public void clickLinkOnOutputScreen(String linkText) {
		// click(By.xpath("//div[contains(text(),'" + linkText + "')]"));
		getElement(linkOnOutputPage, linkText).click();
	}

	/**
	 * Verify if a link option is not available
	 */
	public void verifyIfLinkIsNotAvailable(String linkText) {
		Assert.assertTrue(!isDisplayed(By.xpath("//div[contains(text(),'" + linkText + "')]")),
				linkText + " option is displayed");
	}

	/**
	 * Delete all rows from output screen
	 */
	public void deleteAllRowsFromOutputScreen() {
		for (int i = 0; i < 6; i++) {
			clickMenuOption("row");
			clickLinkOnOutputScreen("Delete Row");
		}
	}

	// /**
	// * Click Menu Option to add Row
	// */
	// public void clickMenuOptionToAddRow() {
	// click(breakupTableCell_1_0);
	// }
	//
	// /**
	// * Click Menu option for inside cell
	// */
	// public void clickMenuOptionForInsideCell() {
	// click(breakupTableCell_1_1);
	// jsUtil.clickByJS(MenuOption);
	// }

	/**
	 * Verify Options in Menu option for inside cell
	 */
	public boolean verifyOptionsInMenuOptionForInsideCell(List<String> list) {
		List<WebElement> actualList = getElements(optionsInMenuOption);
		List<String> actualListText = new ArrayList<String>();
		for (WebElement ele : actualList) {
			actualListText.add(ele.getText());
		}
		return list.equals(actualListText);
	}

	/**
	 * Click a style from the menu option
	 * 
	 * @param style
	 */
	public void clickStyleInMenuOption(String style) {
		String dataValue = getDataValueFromStyle(style);
		if (style.equalsIgnoreCase("Font color")) {
			// jsUtil.clickByJS(fontColorDDInMenuOption);
			// jsUtil.clickByJS(fontColorInMenuFontColorOption);
			click(fontColorDDInMenuOption);
			click(fontColorInMenuFontColorOption);
		} else
			getElement(styleOptionsInMenuOption, dataValue).click();
	}

	/**
	 * get data value on the basis of style
	 * 
	 * @param style
	 * @return data value
	 */
	private String getDataValueFromStyle(String style) {
		if (style.equalsIgnoreCase("bold"))
			return "B";
		else if (style.equalsIgnoreCase("Italics"))
			return "I";
		else if (style.equalsIgnoreCase("Underline"))
			return "U";
		else if (style.equalsIgnoreCase("Left align"))
			return "L";
		else if (style.equalsIgnoreCase("Center align"))
			return "C";
		else if (style.equalsIgnoreCase("Right align"))
			return "R";
		else
			return null;
	}

	/**
	 * verify if style has been applied to the cell
	 * 
	 * @param style
	 * @return true if style is applied to cell
	 */
	public boolean verifyStyleAppliedToCell(String style) {
		return getAttribute(breakupTableCell_1_1, "style").contains(getStyleAttributeValue(style));
	}

	/**
	 * get Style Attribute value on the basis of style
	 * 
	 * @param style
	 * @return style attribute value
	 */
	private String getStyleAttributeValue(String style) {
		if (style.equalsIgnoreCase("bold"))
			return "font-weight: 700";
		else if (style.equalsIgnoreCase("Italics"))
			return "italic";
		else if (style.equalsIgnoreCase("Underline"))
			return "underline";
		else if (style.equalsIgnoreCase("Left align"))
			return "left";
		else if (style.equalsIgnoreCase("Center align"))
			return "center";
		else if (style.equalsIgnoreCase("Right align"))
			return "right";
		else if (style.equalsIgnoreCase("Font color"))
			return "background-color: rgb(40, 62, 86); color: rgb(255, 255, 255);";
		else
			return null;
	}

	/**
	 * verify if a row is added to output screen
	 * 
	 * @return true if row added
	 */
	public boolean verifyRowAddedToOutput() {
		return (getElements(rowsInBreakupTable).size() == 9);
	}

	/**
	 * Verify the list of tags in Insert Tag Menu Option
	 * 
	 * @param list
	 * @return true if all tags present
	 */
	public boolean verifyAvailableTagsInInsertTagMenuOption(List<String> list) {
		List<WebElement> actualList = getElements(tagsInInsertTagsMenu);
		List<String> actualListText = new ArrayList<String>();
		for (WebElement ele : actualList) {
			actualListText.add(ele.getAttribute("data-value").toString());
		}
		return list.equals(actualListText);
	}

	/**
	 * Verify tag is inserted in the first Inside cell
	 * 
	 * @param tagValue
	 * @return true if tag value inserted
	 */
	public boolean verifyTagInserterdInFirstInsideCell(String tagValue) {
		return getText(breakupTableCell_1_1).contains(tagValue);
	}

	/**
	 * Click link in Menu Option on Output Screen
	 * 
	 * @param linkText
	 */
	public void clickLinkInMenuOptionOnOutputScreen(String linkText) {
		getElement(linkInMenuOption, linkText).click();
	}

	/**
	 * verify a Layer Opens On Output Screen
	 * 
	 * @param linkText
	 * @return true if layer is opened
	 */
	public boolean verifyLayerOpensOnOutputScreen(String linkText) {
		return getText(txtModalHeading).contains(linkText);
	}

	/**
	 * Add symbol to footnote
	 * 
	 * @param symbol
	 */
	public void addFootnoteSymbolOnTheLayer(String symbol) {
		sendKeys(footnoteSymbol, symbol);
	}

	/**
	 * Add Footnote text
	 * 
	 * @param list
	 */
	public void addFootnoteTextOnTheLayer(List<String> list) {
		getElement(footnoteDescription).clear();
		for (String str : list) {
			getElement(footnoteDescription).sendKeys(str);
			getElement(footnoteDescription).sendKeys("\n");
		}
	}

	/**
	 * Click button
	 * 
	 * @param replacement
	 *            text for the button
	 */
	public void clickButton(String buttonText) {
		wait.waitForPageToLoadCompletely();
		getElement(buttonXpath, buttonText).click();
	}

	/**
	 * Verify footnote has been added
	 * 
	 * @param list
	 * @return true if footnote is added
	 */
	public boolean verifyFootnoteHasBeenAdded(List<String> list) {
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				if (!getText(txtFootnoteSymbol).contains(list.get(i)))
					flag = false;
			} else {
				if (!getText(txtFootnoteDescription).contains(list.get(i)))
					flag = false;
			}
		}
		return flag;
	}

	/**
	 * Verify footnote has been removed
	 * 
	 * @return true if footnote is removed
	 */
	public boolean verifyFootnoteRemoved() {
		return !isDisplayed(txtFootnoteSymbol);
	}

	/**
	 * Verify contents of the cell are cleared
	 * 
	 * @return true if cell is cleared
	 */
	public boolean verifyContentsAreCleared() {
		return getText(breakupTableCell_1_1).equals("");
	}

	/**
	 * Verify error message is displayed for CTC field
	 * 
	 * @param errorMsg
	 * @return true if error message for CTC is correct
	 */
	public boolean verifyErrorMessageForCTCField(String errorMsg) {
		return getText(CTCErrorMessage).contains(errorMsg);
	}

	/**
	 * Select string in CTC dropdown
	 * 
	 * @param dDString
	 */
	public void selectStringInCTCDropdown(String dDString) {
		selectValueInDD(ctcDropdown, dDString);
	}

	/**
	 * Select a value in the drop down
	 * 
	 * @param by
	 *            of the drop down
	 * @param value
	 *            To Be Selected
	 */
	public void selectValueInDD(By by, String valueToBeSelected) {
		try {
			click(by);
			jsUtil.scrollDown(parameterizedLocator(dropdownValues, valueToBeSelected));
			getElement(dropdownValues, valueToBeSelected).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verify if Review and Approve page is opened
	 * 
	 * @return true if Review and Approve page is opened
	 */
	public boolean verifyReviewAndApprovePageOpened() {
		return getText(reviewNApproveSubHeading).equalsIgnoreCase(REVIEWNAPPROVESUBHEADING_TXT);
	}

	/**
	 * select String As Input Source
	 * 
	 * @param string
	 *            to be selected
	 */
	public void selectStringAsInputSource(String inputSource) {
		int numberOfRowsInInputTable = getElements(eleInputTableRows).size();
		getElement(eleInputSourceForNewInput, Integer.toString((numberOfRowsInInputTable - 1))).click();
		jsUtil.scrollDown(BtnCancelOnInputSource);
		getElement(rdoInputSourceType, inputSource).click();
	}

	/**
	 * select Sheetname And Cell Reference As Input for Fill from spreadsheet
	 * option
	 * 
	 * @param sheetName
	 * @param cellReference
	 */
	public void selectSheetnameAndCellReferenceAsInput(String sheetName, String cellReference) {
		selectValueInDD(ddlSheetName, sheetName);
		sendKeys(txtCellReferenceField, cellReference);
	}

	/**
	 * click Link On Input Screen
	 * 
	 * @param linkText
	 */
	public void clickLinkOnInputScreen(String linkText) {
		clickLinkOnOutputScreen(linkText);
	}

	/**
	 * verify Warning Message
	 * 
	 * @param warningMsgText
	 * @return true if warning message is same
	 */
	public boolean verifyWarningMessage(String warningMsgText) {
		wait.hardWait(1);
		wait.waitForVisibilityOfElement(lblWarningMessage);
		return getText(lblWarningMessage).equalsIgnoreCase(warningMsgText);
	}

	/**
	 * scroll Down To Cancel Btn For Input Source
	 */
	public void scrollDownToCancelBtnForInputSource() {
		jsUtil.scrollDown(BtnCancelOnInputSource);
	}

}
