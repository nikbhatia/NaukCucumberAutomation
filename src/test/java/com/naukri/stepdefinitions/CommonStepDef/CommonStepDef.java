package com.naukri.stepdefinitions.CommonStepDef;
import com.naukri.automation.util.BillingAPI;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.automation.util.YamlReader;
import static com.naukri.automation.util.YamlReader.getAppConfigValue;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Assessment.AttachAssessmentPO;
import com.naukri.pageobjects.Assessment.CandidateAssessmentPO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.stepdefinitions.Assessment.AttachTestStepDef;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
public class CommonStepDef {
    public static String testName;
    GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    AddASingleProfilePagePO addASingleProfile = (AddASingleProfilePagePO) PageObjectWrapper
            .getObject(AddASingleProfilePagePO.class);
    CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
    CandidateAssessmentPO cadAssessment = (CandidateAssessmentPO) PageObjectWrapper
            .getObject(CandidateAssessmentPO.class);
    CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
    AttachAssessmentPO attachAssessmentTest = new AttachAssessmentPO();
    ManageWhiteLabelPO ManagewhiteLabelPOobj = new ManageWhiteLabelPO();
    
    public static String subscription="";
    @Given("I login into RMS as an {string} user")
    public void i_login_into_RMS_as_an_user(String subscriptionType) {
    	subscription=subscriptionType;
        genericFunctions.setUsernameAndPassword(subscriptionType, "Superuser");
    }
    @Given("User login to the application \"(.*)\" using \"(.*)\" of \"(.*)\" user")
    public void loginToApplication(String pageName, String userType, String user) {
        commonActions.loginToRMSUsingURLBuilder(pageName, getAppConfigValue("Users." + user + "." + userType + ".username"), getAppConfigValue("Users." + user + "." + userType + ".password"));
    }
//	@When("I am on add single profile page")
//	public void i_am_on_add_single_profile_page() {
//		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.addSingleProfile"));
//	}
    @And("I am on \"(.*)\" page")
    public void i_am_on_page(String url) {
        commonActions.goToPageURL(YamlReader.getAppConfigValue("URLs." + url));
    }
    @And("User is on \"(.*)\" page")
    public void UserIsOnPage(String moduleName) {
        commonActions.goToPageURL(URLBuilder.getURL(moduleName));
        TestNGLogUtility.info("User is on "+moduleName+" page");
    }
    @When("I fill in all the details of the candidate")
    public void i_fill_in_all_the_details_of_the_candidate() {
        addASingleProfile.addCandidateInformation();
        addASingleProfile.addRequirementDetailsForCandidate();
    }
    @When("I click on Save button")
    public void i_click_on_Save_button() {
        addASingleProfile.clickAddCandidateBtn();
    }
    @When("I click on status change drop down")
    public void i_click_on_status_change_drop_down() {
        cvDetailsPagePO.clickOnStatusChangeDD();
    }
    @When("User clicks on Candidate Assessment Tab")
    public void userClicksOnCandidateAssessmentTab() {
        cadAssessment.clickCandidateAssessmentTab();
    }
    @When("User clicks on add candidate assessment button")
    public void userClicksOnAddCandidateAssessmentButton() {
        cadAssessment.clickCandidateAssessmentButton();
    }
    @Then("Verify that user is able to see the test name in headings on Selected Assessment Test")
    public void verifyThatUserIsAbleToSeeTheTestNameInHeadings() {
        Assert.assertTrue(cadAssessment.verifyHeadings(AttachTestStepDef.testName),
                "Test case failed: As user is not able to see the name of test on Selected Assessment Test page");
    }
    @When("I click on {string} by hovering on username")
    public void i_click_on_by_hovering_on_username(String optionTab) {
        commonActions.clickOnOptionsOnUsername(optionTab);
    }
    @When("User navigate through GNB to {string} under {string}")
    public void user_navigate_through_GNB_to_under(String innerOptionOfDDKeyword, String gnbMainOptionLocatorKeyword) {
        genericFunctions.selectOptionFromRMSGNB(innerOptionOfDDKeyword, gnbMainOptionLocatorKeyword);
    }
    @When("I select a {string} from {string} option on Naukri GNB")
    public void i_select_a_from_option_on_Naukri_GNB(String innerSubOption, String mainGnbOption) {
        genericFunctions.selectOptionFromNaukriGNB(innerSubOption, mainGnbOption);
    }
    @And("user is on {string} page for added candidate")
    public void userIsOnPageForAddedCandidate(String url) {
        commonActions.goToPageURL(YamlReader.getAppConfigValue("URLs." + url) + "/" + BillingAPI.applicationId + "");
    }
    @When("User navigates to the dashboard page")
    public void user_navigates_to_the_dashboard_page() {
        commonActions.clickOnDashboardIcon();
    }
    @When("User click on GNB option \"(.*)\"")
    public void clickOnMainGNbOption(String mainGNBPageName) {
        genericFunctions.clickOnMainGNBOption(mainGNBPageName);
    }
    @Then("Verify that user is able to see in GNB dropdown \"(.*)\" option")
    public void verifyDropDownValueInGNB(String dropdownValue) {
        Assert.assertTrue(genericFunctions.verifyDropdownValueOfGNB(dropdownValue), "[Assertion Fail]: Dropdown value " + dropdownValue + " is not display");
        TestNGLogUtility.pass("[Assertion Fail]: Dropdown value " + dropdownValue + " is display");
    }
    
    @When("User rest the password to default password")
	public void User_rest_the_password_to_default_password() {
		String url=YamlReader.getAppConfigValue("URLs.PasswordChangePage");
		String userName=subscription.split("/")[0];
		String password=subscription.split("/")[1];
		genericFunctions.changePasswordFromRPToSamePassword(url, userName, password);
	}
	@When("User logout from application")
	public void User_logout_from_application() {
		genericFunctions.logout();
	}
	
	@When("user switch to frame about company")
	public void userSwitchToFrameAboutCompany() {
		ManagewhiteLabelPOobj.SwitchToAboutCompanyFrame();
	}
	@When("user switch to default frame")
	public void userSwitchToDefaultFrame() {
		commonActions.SwitchToDefault();
	}
    @And("User click on {string} from settings options")
    public void logoutFromSettingsOption(String option){
        commonActions.logoutFromSettingsOption(option);
        TestNGLogUtility.info("Clicked on"+ option+" from settings option");
    }
}