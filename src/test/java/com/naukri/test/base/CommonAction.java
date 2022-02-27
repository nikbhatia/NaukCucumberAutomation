package com.naukri.test.base;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.automation.util.WaitUtility;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;

public class CommonAction extends PageObjectWrapper {

	private static String TestDataFile = ".//src//test//resources//testdata//testDataAssessment.properties";

	public static By loginRegisterBtn = By.xpath("//li[text()='LOGIN/REGISTER']");
	public static By userNameTxt = By.id("userName");
	public static By passwordTxt = By.id("pass");
	public static By loginBtn = By.className("blue_btn");
	public static By recruitementSolnBtn = By.id("headerTwoRecruiter");
	public static By referralIjpLbl = By.cssSelector("li.gnb_w100 div.gnb_mTxt");
	public static By settingOption = By.cssSelector("a[href$='app/settings']");
	public static By jobsAndOptionsLbl = By.cssSelector("span.gnb_topIcon.gnb_jRes");
	public static By dashboardHeader = By.cssSelector("span.dashCap.wrapper");
	public static By dashboardBanner = By.cssSelector("div.bnrDiv");
	public static By dashboardMainCnt = By.cssSelector("div.mainCont");
	public static By naukriLogo = By.cssSelector("a.gnb_nLogo.gnb_fl");
	public static By GNBHeader = By.cssSelector("div.headGNBWrap");
	public static By mainGNB = By.cssSelector("ul.gnb_midSec.gnb_menu.gnb_noTransition");
	public static By rightSideGNB = By.cssSelector("ul.gnb_rghtSec.gnb_fr.gnb_menu.gnb_logged");
	public static By referralIJPOption = By.cssSelector("li.gnb_w100.gnb_mActive>div.gnb_subMenu.c2");
	public static By referralIJPDropdownOption = By.cssSelector("li.gnb_w100 li>a[href*='naukri']");
	public static By trackReferralLink = By.cssSelector("a[href*='trackJob/referralJob']");
	public static By createReferralEmailerLink = By.cssSelector(".gnb_subMenu.c2 a[href$='referral/new']");
	public static By trackIJPJobs = By.cssSelector("div.gnb_subMenu.c2 a[href$='trackJob/IJPJob']");
	public static By createIJPEmailerLink = By.cssSelector("a[href$='new?refIjpTab=I']");
	public static By dashboardOption = By.cssSelector("a[href$='dashboard/home']");
	public static By dashboardMsgBox = By.cssSelector("#msgBrdPanel");
	public static By manageReferralIJPJobLink = By.cssSelector("ul.gnb_groupBorder a[href$='referralJobs/manage']");
	public static By manageUser = By.cssSelector("a[href$='invites/users']");
	public static By referralReports = By.cssSelector("ul.gnb_groupBorder a[href$='referralReport']");
	public static By IJPReports = By.cssSelector("ul[class='gnb_groupBorder'] a[href$='IJPReports']");
	public static By empUserName = By.id("emailId");
	public static By empPassWrd = By.id("pwd");
	public static By empLoginBtn = By.id("loginBtn");
	public static By manageJobsAndResponses = By.cssSelector("div.gnb_subMenu.c2 a[href$='JobListing/default']");
	By usernameTextOnLogin = By.id("gnbSettingLinkUserNameTextId");
	By optionUnderOptionOfUsername = By.xpath("//a[text()='${optionName}']");
	private By eleRequirementName = By.xpath("//a[contains(text(),'${reqName}')]");
	private By textBox = By.xpath("//input[@id='${textBoxId}']");
	By eleDashboardIcon = By.xpath("//small[contains(@class,\"homeIc\")]");
	public By eleSetting=By.xpath("//div[@class='settingOuter']");
	public By eleLogout=By.xpath("//div[@class='subMenu']//a[contains(text(),'${name}')]");
	 By elePromotionPageCross = By.xpath("//span[@class='crossPage']");

	String PostingURL = "";
	String RecLogin = "";
	public String JobPostingFormGeneric = "/Job/new?subCategoryId=";

	final String clientId = "r3sndr01d";
	String hmId = "", deviceId = "";
	public static String applicationId, candidateName, requirementName;
	
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);

	// private static String appUrlFile =
	// ".//src//test//resources//testdata//application_URL.properties";
	// public static String username = ReadWritePropertyFile.getProperty("userName",
	// appUrlFile);
	// final String password = ReadWritePropertyFile.getProperty("password",
	// appUrlFile);
	// final String baseURL = ReadWritePropertyFile.getProperty("appURL",
	// appUrlFile);
	// final String authURL = ReadWritePropertyFile.getProperty("authURL",
	// appUrlFile);

	public void loginToReferral(String URL, String uname, String password) {
		driver.get(URL);
		TestNGLogUtility.info("Launched " + URL);
		getElement(loginRegisterBtn).click();
		TestNGLogUtility.info("User clicked on login/register button");
		getElement(userNameTxt).clear();
		getElement(userNameTxt).sendKeys(uname);
		getElement(passwordTxt).clear();
		getElement(passwordTxt).sendKeys(password);
		getElement(loginBtn).click();
		TestNGLogUtility.info("User clocked on login button");
		// List<WebElement> redirect = driver.findElements(By.id("headerTwoRecruiter"));
		// if (redirect.size() > 0) {
		// redirect.get(0).click();
		// }
	}

	public void loginToRMS(String URL, String uname, String password) {
		driver.get(URL);
		TestNGLogUtility.info("Launched " + URL);
		// getElement(loginRegisterBtn).click();
		TestNGLogUtility.info("User clicked on login/register button");
		getElement(userNameTxt).clear();
		getElement(userNameTxt).sendKeys(uname);
		getElement(passwordTxt).clear();
		getElement(passwordTxt).sendKeys(password);
		getElement(loginBtn).click();
		TestNGLogUtility.info("User clicked on login button");
		// getElement(recruitementSolnBtn).click();
		// List<WebElement> redirect = driver.findElements(By.id("headerTwoRecruiter"));
		// if (redirect.size() > 0) {
		// redirect.get(0).click();
		// }
		if(isDisplayed(elePromotionPageCross))
		{
			click(elePromotionPageCross);
			driver.get(URL);
		}
	}
        
        public void loginToRMSUsingURLBuilder(String URL, String uname, String password) {
                URL= URLBuilder.getURL(URL);
                driver.get(URL);
		TestNGLogUtility.info("Launched " + URL);		
		TestNGLogUtility.info("User clicked on login/register button");
		getElement(userNameTxt).clear();
		getElement(userNameTxt).sendKeys(uname);
		getElement(passwordTxt).clear();
		getElement(passwordTxt).sendKeys(password);
		getElement(loginBtn).click();
		driver.get(URL);
			if(isDisplayed(elePromotionPageCross))
				{
				click(elePromotionPageCross);
				driver.get(URL);
				}
		TestNGLogUtility.info("User clicked on login button");		
	}

	public void navigateToUrl(String URL) {
		driver.get(URL);
		wait.waitForPageToLoadCompletely();
	}
	
	public void goToPageURL(String stringURL) {
		driver.get(stringURL);
		wait.waitForPageToLoadCompletely();
	}

	public static String generateRandomStrings(int length, String type) {
		StringBuilder sb = new StringBuilder(length);
		if (type.equalsIgnoreCase("Number")) {
			final String strg = "0123456789";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("String")) {
			final String strg = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("Alphanumeric")) {
			final String strg = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else {
			System.err.println("Wrong type declared.");
		}
		return sb.toString();
	}

	public static String getDateInSpecificFormat(String patternToGet, String patternOfDate, String dateValue) {
		SimpleDateFormat formatter = new SimpleDateFormat(patternOfDate);
		SimpleDateFormat formatter2 = new SimpleDateFormat(patternToGet);
		Calendar cal = new GregorianCalendar();
		try {
			cal.setTime(formatter.parse(dateValue));
			return formatter2.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void verifyLandingPageBasedOnTextBoxId(String textBoxId) {
		getElement(textBox, textBoxId).click();
	}

    private static class APITestUtils {
		protected static String getDataAsJson(Map<String, Object> map) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(map);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public void clickNewRequirement() {
		final String reqName = PropFileHandler.readProperty("reqName");
		final String CandidateName = PropFileHandler.readProperty("candidateName");
		API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleRequirementName, reqName), 5);
		click(parameterizedLocator(eleRequirementName, reqName));
		wait.waitForPageToLoadCompletely();
		switchToChildWindow();

		String currentUrl = driver.getCurrentUrl();
		String[] reqId = currentUrl.split("dashboard/");
		PropFileHandler.writeProperty("reqId", reqId[1]);
		closeParentMoveToChild();
	}

	public void LoginToJobPostingForm(String Username, String Password, String JobType) {
		RecLogin = getAppConfigValue("URLs.RecLogin");
		PostingURL = getAppConfigValue("URLs.Posting");
		String SubCat = "";
		switch (JobType) {
		case "Premium":
			SubCat = "81";
			break;

		case "Hot":
			SubCat = "1";
			break;

		case "Classified":
			SubCat = "2";
			break;

		case "Private":
			SubCat = "3";
			break;

		case "IJP":
			SubCat = "3&IJP=1";
			break;

		case "Referral":
			SubCat = "3&referral=1";
			break;
		}
		loginToReferral(RecLogin, Username, Password);
		wait.hardWait(5);
		driver.get(PostingURL + JobPostingFormGeneric + SubCat);
	}

	public void hoverOnReferralIjpNavigation() {
		hover(referralIjpLbl);
		TestNGLogUtility.info("User hover on referral/Ijp option");
	}

	public void hoverOnJobsAndResponses() {
		hover(jobsAndOptionsLbl);
		TestNGLogUtility.info("User hover on jobs and responses");
	}

	public void clickOnSettingOption() {
		getElement(settingOption).click();
		TestNGLogUtility.info("User clicked on setting options");
	}

	public boolean verifyDashboardIsDisplay() {
		return getElement(dashboardHeader).isDisplayed() && getElement(dashboardBanner).isDisplayed()
				&& getElement(dashboardMainCnt).isDisplayed();
	}

	public boolean verifyNaukriLogo() {
		return getElement(naukriLogo).isDisplayed();
	}

	public boolean verifyGNBOfReferral() {
		return getElement(GNBHeader).isDisplayed() && getElement(mainGNB).isDisplayed()
				&& getElement(rightSideGNB).isDisplayed();
	}

	public boolean verifyReferralIJPOptionDisplay() {
		return getElement(referralIJPOption).isDisplayed();
	}

	public boolean verifyReferralJPDropdownOptions() {
		List<WebElement> elements = getElements(referralIJPDropdownOption);
		boolean options = false;
		int count = 0;
		String[] optionValues = { "Post a Referral Job", "Create Referral Mailer", "Track Referrals", "Post an IJP Job",
				"Create Internal Job Mailer", "Track Internal Jobs", "Dashboard", "Manage Referral / IJP Jobs",
				"Manage Users", "Referral Reports", "IJP Reports", "Settings" };
		for (WebElement e : elements) {
			if (e.getText().contains(optionValues[count])) {
				options = true;
			} else {
				options = false;
				break;
			}
			count++;
		}
		return options && elements.size() == optionValues.length;
	}

	public void clickOnTrackReferralJobLink() {
		getElement(trackReferralLink).click();
		TestNGLogUtility.info("User click on track referral job link");
	}

	public void clickOnCreateReferralEmailer() {
		getElement(createReferralEmailerLink).click();
		TestNGLogUtility.info("User clicked on create referral emailer link");
	}

	public void clickOnTrackIJPJobs() {
		wait.waitForPageToLoadCompletely();
		getElement(trackIJPJobs).click();
		TestNGLogUtility.info("User clicked on track IJP jobs options");
	}

	public void clickOnClickOnCretaeIJPMailer() {
		wait.waitForPageToLoadCompletely();
		getElement(createIJPEmailerLink).click();
		TestNGLogUtility.info("User clicked on create IJP mailer link");
	}

	public void clickOnDashboardLink() {
		wait.waitForPageToLoadCompletely();
		getElement(dashboardOption).click();
		TestNGLogUtility.info("User clicked on dashbaord option link");
	}

	public boolean verifyDashboardMessaeBox() {
		return getElement(dashboardMsgBox).isDisplayed();
	}

	public void clickOnManageReferralIJPJob() {
		wait.waitForPageToLoadCompletely();
		getElement(manageReferralIJPJobLink).click();
		TestNGLogUtility.info("User clicked on manage referral IJP job option");
	}

	public void clickOnManageUserOption() {
		wait.waitForPageToLoadCompletely();
		getElement(manageUser).click();
		TestNGLogUtility.info("User clicked on manage user option");
	}

	public void clickOnReferralReportOption() {
		wait.waitForPageToLoadCompletely();
		getElement(referralReports).click();
		TestNGLogUtility.info("[User clicked on referral reports options]");
	}

	public void clickOnIJPReports() {
		wait.waitForPageToLoadCompletely();
		getElement(IJPReports).click();
		TestNGLogUtility.info("User clicked on IJP reports");
	}

	public void clickOnManageJobsAndResponsesOption() {
		getElement(manageJobsAndResponses).click();
		TestNGLogUtility.info("User clicked on manage jobs and responses");
	}

	public boolean verifyEmployeeLoggedoutFromApp() {
		return getElement(empLoginBtn).isDisplayed() && getElement(empUserName).isDisplayed()
				&& getElement(empPassWrd).isDisplayed();
	}

	public void loginToEmployeeSite(String URL, String uName, String password) {
		driver.get(URL);
		TestNGLogUtility.info("User launched " + URL);
		getElement(empUserName).clear();
		getElement(empUserName).sendKeys(uName);
		getElement(empPassWrd).clear();
		getElement(empPassWrd).sendKeys(password);
		getElement(empLoginBtn).click();
		TestNGLogUtility.info("User logged into employee site");
	}
	
	/**
	 * To click on the link present under a username of the option
	 * @author rachit.mehrotra
	 * @param optionString
	 */
	public void clickOnOptionsOnUsername(String optionString) {
		wait.resetImplicitTimeout(1);
		mouseHoverAndClickToWebElement(getElement(usernameTextOnLogin), getElement(parameterizedLocator(optionUnderOptionOfUsername, optionString)));
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
	}
	
	/**
	 * To click on dashboard icon
	 * @author rachit.mehrotra
	 */
	public void clickOnDashboardIcon() {
		click(eleDashboardIcon);
	}

	/**
	 * This method is use to get Text By Visibility i.e if it is present
	 * @param by
	 * @author nikhil.bhatia
	 * @return text
	 */
	public String getTextByVisibility(By by){
		String str = "";
		if(isDisplayed(by)) {
			return getText(by);
		}
		return str;
	}
	/**
	 * This method is use to Switch to Default content from frame
	 * @author jatin.bisht
	 */
	public void SwitchToDefault() {
		switchToDefaultContent();
	}
	
	/**
	 * Method for generating the date in the format used in Application's Module
	 * @author rachit.mehrotra
	 * @return Formatted String of date
	 */
	public String getPresentDayDateInApplicationsFormat() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy" , Locale.ENGLISH);
		return simpleDateFormat.format(date);
	}

	/**
	 * This method is use to select logout from settings option
	 * @author avani
	 * @param option
	 */
	public void logoutFromSettingsOption(String option){
		wait.waitForPageToLoadCompletely();
		actionBuilderUtil.hoverByActionAlternate(eleSetting);
		click(parameterizedLocator(eleLogout,option));
	}
}
