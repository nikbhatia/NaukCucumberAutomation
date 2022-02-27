package com.naukri.automation.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import com.naukri.test.base.PageObjectWrapper;

/**
 * Class comprises of the functions which are commonly used across automation
 *
 * @author rachit.mehrotra
 */
public class GenericFunctions extends PageObjectWrapper {

	// locators for the web elements on the page
	public static By username_txt = By.id("userName");
	public static By password_txt = By.id("pass");
	public static By login_btn = By.xpath("//input[contains(@class , \"blue_btn\")]");
	public By userName = By.id("gnbSettingLinkUserNameTextId");
	public By btnAction = By.xpath("(//a[contains(.,'${BtnAction}')])[1]");
	public By tbSelectRequirement = By.xpath("//input[contains(@id,'inp_projectList')]");
	public By btnAdd = By.xpath("//input[@value='${BtnName}']");
	public By blockedProfilePopUp = By.xpath("//p[text()='1 Blocked  Profiles']");
	public By candidateTuple = By.xpath("(//div[@class='srchTup mb-10'])[1]");
	public By tbAdvanceSearch = By.xpath("//input[@id='keywordSearch']");
	public By successfulAddedProfilePopUp = By.xpath("//p[contains(text(),'0 Blocked and 1')]");
	public By requirementFromList = By.xpath("(//div[@class='drop']//li/a)");
	public By firstRequirementFromList = By.xpath("(//div[@class='drop']//li/a)[${size}]");
	By eleProcessOverlay = By.xpath("//div[contains(@class, \"processing-overlay\")]");

	
	public By RPOldPassword_Txt=By.xpath("//input[@id='oldPassword']");
	public By RPNewPassword_Txt=By.xpath("//input[@id='newPassword']");
	public By RPConfirmPassword_Txt=By.xpath("//input[@id='reTypeNewPassword']");
	public By RPSaveSettings_WE=By.xpath("//input[@id='saveSetting']");
	
	// locators of GNB
	By gnbMainOptionLocator = By.xpath("//ul[contains(@class,\"navigation\")]//a[text()='${gnbOption}']");
	By gnbSubOptionLocator = By.xpath("//div[contains(@class,\"subMenu\")]//a[contains(text(),'${gnbSubOption}')]");

	// locators of Naukri GNB
	By eleNaukriGNBMainOptionLocator = By
			.xpath("//div[contains(@class,\"gnb_mTxt\") and contains(text(),'${mainGNBOption}')]");
	By eleNaukriGNBSubMainOptionLocator = By.xpath(
			"//div[contains(@class,\"gnb_mTxt\") and contains(text(),'${mainGNBOption}')]/parent::a/following-sibling::div//a[contains(text(),'${gnbSubMainOption}')]");
	By eleNuakriPopUPCloseCross=By.xpath("//em[@class='iconCrossLb']");
	By eleNuakriPopUP=By.xpath("(//div[@id='ltTitle'])[1]");
	
	// URLs of RMS
	public String dashboardURL = YamlReader.getAppConfigValue("URLs.adminDashboard");
	public By requirementCreationWidget = By.xpath("//h6[contains(text(),\"Requirements created\")]");
	// class variables
	String username = "";
	String password = "";
	String subscriptionType = "";
	Calendar cal = Calendar.getInstance();
	public static String resumeFileName = "resume";
	public static File file;

	/**
	 * To generate random strings
	 *
	 * @param length
	 * @param type
	 * @return static String
	 */
	public static String generateRandomStrings(int length, String type) {
		StringBuilder sb = new StringBuilder(length);
		if (type.equalsIgnoreCase("Number")) {
			final String strg = "0123456789";
			SecureRandom rndm = new SecureRandom();
			sb.append(strg.charAt(rndm.nextInt(strg.length()-1)+1));
			for (int i = 1; i < length; i++)
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
		} else if (type.equalsIgnoreCase("special")) {
			final String strg = "<([{\\\\^-=$!|]})?*+_:';,~@#>";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("float")) {
			final String strg = "0123456789";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
			sb.append(".");
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else {
			System.err.println("Wrong type declared.");
		}
		return sb.toString();
	}

	/**
	 * To check is a String is Numeric or not, removes any special characters in the
	 * string
	 *
	 * @param string
	 * @return true if numeric
	 * @author udit.khanna
	 */
	public static boolean checkStringIsNumeric(String string) {
		return string.replaceAll("[^a-zA-Z0-9]", "").matches("-?\\d+(\\.\\d+)?");
	}

	/**
	 * To launch a specific URL passed in as the parameter to function
	 *
	 * @param url
	 * @author rachit.mehrotra
	 */
	public void launchSpecificURL(String url) {
		driver.get(url);
		TestNGLogUtility.info(url + " launched");
	}

	/**
	 * To set the username and password for a particular subscription of RMS
	 *
	 * @param subscriptionType
	 * @param userType
	 * @author rachit.mehrotra
	 */
	public void setUsernameAndPassword(String subscriptionType, String userType) {
		if (subscriptionType.contains("@")) {
			if(subscriptionType.contains("/")) {
				TestNGLogUtility.info("username " + subscriptionType.split("/")[0]);
				TestNGLogUtility.info("password " + subscriptionType.split("/")[1]);
				loginToRMS(subscriptionType.split("/")[0], subscriptionType.split("/")[1]);
			}
			else {
			TestNGLogUtility.info("username " + subscriptionType.split("\\|")[0]);
			TestNGLogUtility.info("password " + subscriptionType.split("\\|")[1]);
			loginToRMS(subscriptionType.split("\\|")[0], subscriptionType.split("\\|")[1]);
			}
		} else {
			this.subscriptionType = subscriptionType;
			switch (subscriptionType) {
			case "Enterprise":
				switch (userType) {
				case "Superuser":
					username = YamlReader.getAppConfigValue("Users.Enterprise.Superuser.username");
					break;
				case "Subuser":
					username = YamlReader.getAppConfigValue("Users.Enterprise.Subuser.username");
					break;
				case "hmSpoc":
					username = YamlReader.getAppConfigValue("Users.hmSpocUserName");
					break;

				}
				break;
			case "Company":
				switch (userType) {
				case "Superuser":
					username = YamlReader.getAppConfigValue("Users.Company.Superuser.username");
					break;
				case "Subuser":
					username = YamlReader.getAppConfigValue("Users.Company.Subuser.username");
					break;
				}
				break;
			case "ProConsultant":
				switch (userType) {
				case "Superuser":
					username = YamlReader.getAppConfigValue("Users.ProConsultant.Superuser.username");
					break;
				case "Subuser":
					username = YamlReader.getAppConfigValue("Users.ProConsultant.Subuser.username");
					break;
				}
				break;
			case "HiringManager":
				username = YamlReader.getAppConfigValue("Users.HiringManager.Superuser.username");
				break;
			case "JobPostingNonMigrated":
				switch (userType) {
				case "Superuser":
					username = YamlReader.getAppConfigValue("Users.JobPostingNonMigrated.username");
					break;
				}
			}
			if (subscriptionType.equals("JobPostingNonMigrated"))
				password = YamlReader.getAppConfigValue("Users.JobPostingNonMigrated.password");
			else
				password = YamlReader.getAppConfigValue("Password");
			loginToRMS(username, password);
		}
	}

    /**
     * To login to specific RMS subscription of RMS using the previous helper
     * method
     *
     * @param username
     * @param password
     * @author rachit.mehrotra
     */
    public void loginToRMS(String username, String password) {
        driver.get(YamlReader.getAppConfigValue("URLs.baseURL"));
        TestNGLogUtility.info("User launched " + YamlReader.getAppConfigValue("URLs.baseURL"));
        getElement(username_txt).click();
        getElement(username_txt).clear();
        getElement(username_txt).sendKeys(username);
        getElement(password_txt).clear();
        getElement(password_txt).sendKeys(password);
        getElement(login_btn).click();
        wait.waitForPageToLoadCompletely();
        TestNGLogUtility.info("User Logged into RMS to " + YamlReader.getAppConfigValue("URLs.adminDashboard"));
        driver.get(YamlReader.getAppConfigValue("URLs.adminDashboard"));
    }

	/**
	 * To logout of RMS
	 *
	 * @author rachit.mehrotra
	 */
	public void logout() {
		driver.get(URLBuilder.getURL("logoutPage"));
		//driver.get(YamlReader.getAppConfigValue("URLs.logoutUrl"));
	}

	/**
	 * To switch tabs
	 *
	 * @author rachit.mehrotra
	 */
	public void switchToWindow() {
		TestNGLogUtility.info("Switched to child window");
		switchToChildWindow();
		System.out.println(driver.getCurrentUrl());
	}

	/**
	 * To check the absence of an element
	 *
	 * @param by
	 * @return boolean
	 * @author rachit.mehrotra
	 */
	public boolean checkInvisibilityOfElement(By by) {
		wait.resetImplicitTimeout(1);
		boolean flag = true;
		try {
			driver.findElement(by);
		} catch (Exception e) {
			flag = false;
		}
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		return flag;
	}

	/**
	 * To get day of week
	 *
	 * @return integer
	 * @author rachit.mehrotra
	 */
	public int getDateOfMonth() {
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * To get month of year
	 *
	 * @return integer
	 * @author rachit.mehrotra
	 */
	public int getMonthOfYear() {
		return cal.get(Calendar.MONTH);
	}

	/**
	 * To get current year
	 *
	 * @return integer
	 * @author rachit.mehrotra
	 */
	public int getCurrentYear() {
		return cal.get(Calendar.YEAR);
	}

	/**
	 * To get hour of day
	 *
	 * @return integer
	 * @author rachit.mehrotra
	 */
	public int getHourOfDay() {
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Get the current system date
	 *
	 * @param dateFormat
	 * @return
	 * @author udit.khanna
	 */
	public String getCurrentDate(String dateFormat) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date dateobj = new Date();
		return (df.format(dateobj)).toString();
	}

	// The method logs in to RMS
	public void loginToRMS(String url, String username, String password) {
		driver.get(url);
		TestNGLogUtility.info("User launched " + url);
		getElement(username_txt).click();
		getElement(username_txt).clear();
		getElement(username_txt).sendKeys(username);
		getElement(password_txt).clear();
		getElement(password_txt).sendKeys(password);
		getElement(login_btn).click();
		driver.get(url);
		TestNGLogUtility.info("User Logged into RMS to " + url);
	}

	/**
	 * Clicks a link using text
	 *
	 * @param linkText
	 * @author udit.khanna
	 */
	public void clickLinkUsingText(String linkText) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(By.xpath("//a[text()='" + linkText + "']"));
		getElement(By.xpath("//a[text()='" + linkText + "']")).click();
	}

	/**
	 * This Method will add candidate in a pre created requirement
	 * 
	 * @author himanshu.dua
	 * @param requirementName
	 */
	public void chooseRequirementFromList(String requirementName, String btnName) {
		int i=1;
		click(tbSelectRequirement);
		sendKeys(tbSelectRequirement, requirementName);
		wait.hardWait(2);
		try {
			int size=getElements(requirementFromList).size();
			for(i=1;i<=size;i++) {
				if(getText(parameterizedLocator(firstRequirementFromList, String.valueOf(i))).contains(requirementName))
					click(parameterizedLocator(firstRequirementFromList, String.valueOf(i)));
					break;
			}
		}
		catch (StaleElementReferenceException e) {
			wait.hardWait(2);
			click(parameterizedLocator(firstRequirementFromList, String.valueOf(i)));
		}
		wait.hardWait(6);
		click(parameterizedLocator(btnAdd, btnName));
		wait.waitForOverlayProcessingToDisappear(10, 3);
	}

    /**
     * Method to generate random Number of specific length
     *
     * @param length
     * @author abhishek.dwivedi
     */
    public int generateRandomDigits(int length) {
        int m = (int) Math.pow(10, length - 1);
        return m + new Random().nextInt(9 * m);
    }

    /**
     * This method clicks on any sunoption present in the DD of main option on
     * RMS GNB
     *
     * @author rachit.mehrotra
     * @param innerOptionOfDDKeyword
     * @param gnbMainOptionLocatorKeyword
     */
    public void selectOptionFromRMSGNB(String innerOptionOfDDKeyword,String gnbMainOptionLocatorKeyword) {
    	wait.resetImplicitTimeout(1);
    	jsUtil.scrollUp();
    	wait.waitForValignWrapperToDisappear(10, 3);
    	click(parameterizedLocator(gnbMainOptionLocator, gnbMainOptionLocatorKeyword));
    	TestNGLogUtility.info("Clicked on main GNB option " + gnbMainOptionLocatorKeyword);
    	click(parameterizedLocator(gnbSubOptionLocator, innerOptionOfDDKeyword));
    	TestNGLogUtility.info("Clicked on Inner GNB option " + innerOptionOfDDKeyword);
    	wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
    	wait.waitForInvisibilityOfElement(10, 3, eleProcessOverlay);
    }

    /**
     * To create a doc file as a resume for cv upload flow
     *
     * @author rachit.mehrotra
     * @param resumeDocExtension
     * @param resumeContent
     */
    public void createResumeFileInDocFormat(String resumeDocExtension,HashMap<String,String>resumeContent) {
    	 file = new File(System.getProperty("user.dir") + resumeFileName + generateRandomDigits(4)+ resumeDocExtension);
    	FileOutputStream fileOutputStream;
    	try {
    		fileOutputStream = new FileOutputStream(file);
    		if(!file.exists())
    			file.createNewFile();
    		String resumeContentString = "Name :" + resumeContent.get("Name") + "\n" + "Email: " + resumeContent.get("Email") + "\n" + "Phone: " + resumeContent.get("Phone");
    		if(resumeContent.containsKey("Current Location"))
    		{
    			resumeContentString = resumeContentString + "\n" + "Current Location: "+ resumeContent.get("Current Location");
    		}
    		byte[] resumeContentInByte = resumeContentString.getBytes(); 
    		fileOutputStream.write(resumeContentInByte);
    		TestNGLogUtility.info("File Created!");
    		fileOutputStream.flush();
    		fileOutputStream.close();
    		TestNGLogUtility.info("Stream Closed");
    	} catch(IOException io) {
    		TestNGLogUtility.info("IO exception thrown   ");
    		io.printStackTrace();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

    /**
     * This method clicks on any sunoption present in the DD of main option on
     * Naukri GNB
     *
     * @author rachit.mehrotra
     * @param innerOptionOfDDKeyword
     * @param gnbMainOptionLocatorKeyword
     */
    public void selectOptionFromNaukriGNB(String innerOptionOfDDKeyword, String gnbMainOptionLocatorKeyword) {
    	wait.resetImplicitTimeout(1);
    	if(isDisplayed(eleNuakriPopUP))
    		click(eleNuakriPopUPCloseCross);
        hover(parameterizedLocator(eleNaukriGNBMainOptionLocator, gnbMainOptionLocatorKeyword));
        TestNGLogUtility.info("Clicked on the main GNB option of Naukri " + gnbMainOptionLocatorKeyword);
        click(parameterizedLocator(eleNaukriGNBSubMainOptionLocator, gnbMainOptionLocatorKeyword, innerOptionOfDDKeyword));
        TestNGLogUtility.info("Clicked on inner sub GNB option " + innerOptionOfDDKeyword);
        wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
        wait.hardWait(10);
    }

    /**
     * This method will click on Action buttons on CV detail page like Email,
     * Forward, Add to requirement etc....
     *
     * @param value
     */
    public void clickOnActionButtonOnInboxPage(String value) {
        click(parameterizedLocator(btnAction, value));
    }

    /**
     * This method will verify the Block message after profile adding in created
     * requirement
     *
     * @return
     */
    public boolean verifyBlockProfilepopUp() {
        return isDisplayed(blockedProfilePopUp);
    }

    /**
     * This method will search candidate with email and verify candidate is
     * present
     *
     * @param candidateEmail
     * @return
     */
    public boolean waitTillDesiredCandidateTupleIsPresent(String candidateEmail) {
        boolean flag = false;
        int iterator = 1;
        click(tbAdvanceSearch);
        sendKeys(tbAdvanceSearch, candidateEmail);
        getElement(tbAdvanceSearch).sendKeys(Keys.ENTER);
        while (!isDisplayed(candidateTuple) && iterator < 5) {
            pageRefresh();
            click(tbAdvanceSearch);
            sendKeys(tbAdvanceSearch, candidateEmail);
            getElement(tbAdvanceSearch).submit();
            iterator += 1;
        }
        if (isDisplayed(candidateTuple)) {
            flag = true;
        }
        return flag;
    }

    /**
     * This method will verify the Block message after profile adding in created
     * requirement
     *
     * @return
     */
    public boolean verifyAddedProfilepopUp() {
        wait.waitForValignWrapperToDisappear(10, 3);
        return isDisplayed(successfulAddedProfilePopUp);
    }

    /**
     * This method is to click on main GNB option according to GNB name
     *
     * @author vikash.agrawal
     * @param mainGNBOptionName(main GNB option name)
     */
    public void clickOnMainGNBOption(String mainGNBOptionName) {
        wait.waitForPageToLoadCompletely();
        click(parameterizedLocator(gnbMainOptionLocator, mainGNBOptionName));
        TestNGLogUtility.info("Clicked on main GNB option " + mainGNBOptionName);
    }

    /**
     * This method is to verify the GNB options under drop down
     *
     * @param GNBValue
     * @return true and false
     */
    public boolean verifyDropdownValueOfGNB(String GNBValue) {
        return getElement(gnbSubOptionLocator, GNBValue).isDisplayed();
    }
    
    /**
     * This method will reset password on default
     * @author himanshu.dua
     * @param url
     * @param Username
     * @param Password
     */
    public void changePasswordFromRPToSamePassword(String url,String Username, String Password) {
		try {
		driver.get(url);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(RPOldPassword_Txt);
		click(RPOldPassword_Txt);
		sendKeys(RPOldPassword_Txt, Password);
		wait.waitForElementToBeClickable(RPNewPassword_Txt);
		click(RPNewPassword_Txt);
		sendKeys(RPNewPassword_Txt, Password);
		wait.waitForElementToBeClickable(RPConfirmPassword_Txt);
		click(RPConfirmPassword_Txt);
		sendKeys(RPConfirmPassword_Txt, Password);
		wait.waitForElementToBeClickable(RPSaveSettings_WE);
		click(RPSaveSettings_WE);
		wait.waitForPageToLoadCompletely();
		System.out.println("Password changed for: " + Username);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
    
    /**
	 * This function will return download folder path
	 * @author himanshu.dua
	 * 
	 * @return
	 */
	public static String getDownloadDirPath() {
		String dirPath="";
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").contains("Windows"))
			dirPath= System.getProperty("user.home")+"\\Downloads";
		if(System.getProperty("os.name").contains("Cent") || System.getProperty("os.name").contains("Linux"))
			dirPath= System.getProperty("user.home")+"/Downloads";
		return dirPath;
	}
	
	/**
	 * This method will return Number in Indian Currency format
	 * @author himanshu.dua
	 * @param value
	 * @return
	 */
	public static String format(int value) {
	    if(value < 1000) {
	        return new DecimalFormat("###").format(value);
	    } else {
	        double hundreds = value % 1000;
	        int other = (int) (value / 1000);
	        return new DecimalFormat(",##").format(other) + ',' + new DecimalFormat("000").format(hundreds);
	    }
	}
	
	public static String getTimeDifferenct(String startTime, String endTime) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		startTime=startTime.replace(".", ":");
		endTime=endTime.replace(".", ":");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(startTime);
			d2 = format.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diff = d2.getTime() - d1.getTime();
		return String.valueOf(diff / (60 * 1000));
	}
	
	public static String generateSpecialMetionedSymbolRandomStrings(int length, String type) {
		StringBuilder sb = new StringBuilder(length);
	 if (type.equalsIgnoreCase("Mentioned")) {
			final String strg = "@-()&,./`[]_'\"!*'";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("Not Mentioned")) {
			final String strg = "<{^=$|}?+:';~#>";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		}else {
			System.err.println("Wrong type declared.");
		}
		return sb.toString();
	}
}
