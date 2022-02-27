package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.pageobjects.Settings.ManageQuestionnairePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

 /**
 * @author udit.khanna
 *
 */
public class ManageQuestionnaireStepDef {
	
	ManageQuestionnairePO manageQuestionnairePO = (ManageQuestionnairePO) PageObjectWrapper.getObject(ManageQuestionnairePO.class);
	
	@And("User delete any questionnaire if already present")
	public void deleteAllQuestionnaireIfPresent(){
		manageQuestionnairePO.deleteAllQuestionnaireIfPresent();
	}
	
	@Then("User should see {string} lightbox")
	public void verifyLightBoxOpened(String lightBoxText){
		Assert.assertTrue(manageQuestionnairePO.verifyLightBoxOpened(lightBoxText), "Light Box didn't open");
	}
	
	@And("User adds random Questionnaire Name")
	public void addRandomQuestionnaireName(){
		manageQuestionnairePO.addRandomQuestionnaireName();
	}
	
	@And("User adds a Question {string} to questionnaire")
	public void addQuestionToQuestionnaire(String questionText){
		manageQuestionnairePO.addQuestionToQuestionnaire(questionText);
	}
	
	@And("User selects {string} radio button for Choose Answer Types")
	public void selectRadioBtnForChooseAnswerTypes(String radioBtnType){
		manageQuestionnairePO.selectRadioBtnForChooseAnswerTypes(radioBtnType);
	}
	
	@And("User adds options for the answer")
	public void addOptionsForAnswer(DataTable dt){
		List<String> list = dt.asList();
		manageQuestionnairePO.addOptionsForAnswer(list);
	}
	
	@Then("User should see message {string} for questionnaire")
	public void verifyStatusMessageOfQuestionnaire(String statusMsg){
		Assert.assertTrue(manageQuestionnairePO.verifyStatusMessageOfQuestionnaire(statusMsg), statusMsg + " message is not displayed");
	}
	
}
