package com.naukri.pageobjects.Settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.test.base.PageObjectWrapper;

public class ManageQuestionnairePO extends PageObjectWrapper {

	private By deleteLinkOnManageQuestionnaire = By.xpath("//ul[@id=\"questionnaireList\"]//a[text()='Delete']");
	private By deleteBtnOnLightBox = By.id("deleteButton");
	private By eleLightBoxParagraphTxt = By.xpath("//p[contains(text(),'${string}')]");
	private By eleQuestionnaireName = By.id("questionnairName");
	private By eleQuestionName = By.id("question_name");
	private By eleRadioButtonType = By.xpath("//ul[@id=\"ansType_Id\"]/li[text()='${string}']");
	private By eleLisOfOptionsToAdd = By.xpath("(//div[@id=\"enterAns_Id\"]//li//input)[${string}]");
	private By eleStatusMsgForQuestionnaire = By.xpath("//div[@id=\"questionnaireListing\"]//span[text()='${string}']");

	// variables
	static String questionnaireName = "";

	/**
	 * delete All Questionnaire If Present
	 * 
	 * @author udit.khanna
	 */
	public void deleteAllQuestionnaireIfPresent() {
		while (isDisplayed(deleteLinkOnManageQuestionnaire)) {
			click(deleteLinkOnManageQuestionnaire);
			click(deleteBtnOnLightBox);
			wait.waitForPageToLoadCompletely();
		}
	}

	/**
	 * verify Light Box Opened
	 * 
	 * @param lightBoxText
	 * @return true if lightbox paragraph text is displayed
	 * @author udit.khanna
	 */
	public boolean verifyLightBoxOpened(String lightBoxText) {
		return isDisplayed(parameterizedLocator(eleLightBoxParagraphTxt, lightBoxText));
	}

	/**
	 * add Random Questionnaire Name
	 * 
	 * @author udit.khanna
	 */
	public void addRandomQuestionnaireName() {
		questionnaireName = "Questionnaire " + GenericFunctions.generateRandomStrings(10, "Alphanumeric");
		sendKeys(eleQuestionnaireName, questionnaireName);
	}

	/**
	 * add Question To Questionnaire
	 * 
	 * @param questionText
	 * @author udit.khanna
	 */
	public void addQuestionToQuestionnaire(String questionText) {
		sendKeys(eleQuestionName, questionText);
	}

	/**
	 * select Radio Btn For Choose Answer Types
	 * 
	 * @param radioBtnType
	 * @author udit.khanna
	 */
	public void selectRadioBtnForChooseAnswerTypes(String radioBtnType) {
		click(parameterizedLocator(eleRadioButtonType, radioBtnType));
	}

	/**
	 * add Options For Answer
	 * 
	 * @param list
	 *            of options to be added
	 * @author udit.khanna
	 */
	public void addOptionsForAnswer(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			sendKeys(parameterizedLocator(eleLisOfOptionsToAdd, String.valueOf(i+1)), list.get(i));
		}
	}

	/**
	 * verify Status Message Of Questionnaire
	 * 
	 * @param statusMsg
	 * @return true if message is displayed
	 * @author udit.khanna
	 */
	public boolean verifyStatusMessageOfQuestionnaire(String statusMsg) {
		return isDisplayed(parameterizedLocator(eleStatusMsgForQuestionnaire, statusMsg));
	}

}
