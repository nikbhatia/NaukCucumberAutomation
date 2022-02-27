package com.naukri.test.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.naukri.automation.util.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

/**
 * <b>This Class contains all basic selenium functionalities and behaves as the
 * parent class of PageObjectWrapper.</b> <br>
 * <br>
 * <i>Do not make changes to this class, instead override it's functionalities
 * in PageObjectWrapper if required.</i>
 *
 * @version 1.0.0
 * @since 20/05/2019
 * @author Mohit Dagar <mohit.dagar@naukri.com>
 *
 */
public class BaseAutomation {

	public static String parentWindowHandle;
	public static WebDriver driver;
	public static WaitUtility wait;
	public static JSUtility jsUtil;
	public static ActionBuilderUtility actionBuilderUtil;
	public static TestNGLogUtility log;
	public static String browserName;
	public static AssertionUtil assertUtil;
	public static APIUtil apiTestUtil;
	
	public static String configFile = System.getProperty("user.dir") + File.separator + "configuration.properties";
	public static String testdataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "testdata" + File.separator;
	public static String appUrlFile;

	protected BaseAutomation() {
	}

	public BaseAutomation(WebDriver driver, String implicitTimeout, String explicitTimeout, String browserName) {
		BaseAutomation.driver = driver;
		PageFactory.initElements(driver, this);
		BaseAutomation.browserName = browserName;
		BaseAutomation.wait = new WaitUtility(driver, implicitTimeout, explicitTimeout);
		BaseAutomation.jsUtil = new JSUtility(driver, wait);
		BaseAutomation.assertUtil = new AssertionUtil(driver);
		BaseAutomation.actionBuilderUtil = new ActionBuilderUtility(driver, wait, browserName);
		BaseAutomation.log = new TestNGLogUtility();
		BaseAutomation.apiTestUtil = new APIUtil();
	}

	/**
	 * This method navigates to the sepcified URL and waits till the page is loaded
	 * completely.
	 *
	 * @param stringURL
	 */
	protected void goToPageURL(String stringURL) {
		driver.get(stringURL);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method returns title of currently opened page.
	 *
	 * @return String - Title of Page
	 */
	protected String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * This method logs string message with TestNG Reporter and returns the logged
	 * message.
	 *
	 * @param logMessage
	 * @return String - Logged message in TestNG Reporter
	 */
	protected String logMessage(String logMessage) {
		Reporter.log(logMessage, true);
		return logMessage;
	}

	/**
	 * This method returns the currently opened URL as String.
	 *
	 * @return String - Current URL
	 */
	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	protected void switchToFrame(By by) {
		WebElement element;
		element = wait.waitForVisibilityOfElement(by);
		driver.switchTo().frame(element);
	}

	protected void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}

	protected void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}

	protected void switchToDefaultContent() {
		driver.switchTo().defaultContent();
		wait.hardWait(2);
		TestNGLogUtility.info("Switching to default content...");
	}

	/**
	 * This method waits for the element to be clickable and clicks the provided
	 * WebElement using provided 'By' object. Similar method using JS and
	 * ActionBuilder are in separate classes.
	 * @param by
	 */
	protected void click(By by) {
		WebElement element;
		try {
			element = wait.waitForElementToBeClickable(by);
			element.click();
		} catch (StaleElementReferenceException se) {
			element = wait.waitForElementToBeClickable(by);
			jsUtil.scrollDown(by);
			element.click();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * This method uses Action Class for hover on provided WebElement using it's
	 * 'By' object. Similar method using JS is in separate class.
	 *
	 * @param by
	 */
	protected void hover(By by) {
		actionBuilderUtil.hoverByAction(by);
	}

	/**
	 * This methods clears the WebElement Field and Fill the specified String Text
	 * after waiting for the WebElement to be visible. Similar method using JS and
	 * ActionBuilder are in separate classes.
	 *
	 * @param by
	 * @param stringText
	 */
	protected void sendKeys(By by, String stringText) {
		WebElement webelement;
		try {
			webelement = wait.waitForVisibilityOfElement(by);
			webelement.click();
			webelement.clear();
			webelement.sendKeys(stringText);
		} catch (StaleElementReferenceException se) {
			webelement = wait.waitForVisibilityOfElement(by);
			jsUtil.scrollDown(by);
			webelement.click();
			webelement.clear();
			webelement.sendKeys(stringText);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * This methods returns TRUE/FALSE as boolean for the visibility of the
	 * WebElement after waiting for its visibility.
	 *
	 * @param by
	 * @return boolean - Visibility
	 */
	protected boolean isDisplayed(By by) {
		boolean flag = true;
		WebElement element;
		WebDriverWait waits = new WebDriverWait(driver, WaitUtility.defaultExplicitTimeout);
		try {
			wait.resetImplicitTimeout(1);
			element = waits.until(ExpectedConditions.presenceOfElementLocated(by));
			waits.until(ExpectedConditions.visibilityOf(element));
			try {
				element = waits.until(ExpectedConditions.presenceOfElementLocated(by));
				waits.until(ExpectedConditions.visibilityOf(element));
				if (!driver.findElement(by).isDisplayed()) {
					flag = false;
				}
			} catch (StaleElementReferenceException e) {
				element = waits.until(ExpectedConditions.presenceOfElementLocated(by));
				waits.until(ExpectedConditions.visibilityOf(element));
				if (!driver.findElement(by).isDisplayed()) {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
			return flag;
		} catch (TimeoutException te) {
			return false;
		} finally {
			wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		}
	}

	/**
	 * This method returns Text as String for the specified WebElement using 'By'
	 * after waiting for its visibility.
	 *
	 * @param by
	 * @return String - Text of WebElement
	 */
	protected String getText(By by) {
		String value = null;
		WebElement element;
		try {
			element = wait.waitForVisibilityOfElement(by);
			value = element.getText();
		} catch (StaleElementReferenceException e) {
			element = wait.waitForVisibilityOfElement(by);
			jsUtil.scrollDown(by);
			value = element.getText();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return value;
	}

	protected String getText(WebElement webElement) {
		String value = null;
		try {
			value = webElement.getText();
		} catch (StaleElementReferenceException e) {
			value = webElement.getText();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return value;
	}

	protected boolean isSelected(By by) {
		boolean flag = false;
		WebElement element;
		try {
			element = wait.waitForVisibilityOfElement(by);
			if (!element.isSelected()) {
				flag = false;
			}
		} catch (StaleElementReferenceException e) {
			element = wait.waitForVisibilityOfElement(by);
			if (!element.isSelected()) {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	protected WebElement getElement(By by) {
		return getElement(by, "");
	}

	/**
	 * @author Vikash Agrawal This method is for dynamic parameter value in locator
	 *         one parameter for single value pipe separated for two parameters For
	 *         single parameter use like "TestParameter" For double parameter use
	 *         like "Test|Parameter"
	 */
	protected WebElement getElement(By by, String replacementValue) {
		WebElement element;
		try {
			if (replacementValue.contains("|")) {
				String[] replace = replacementValue.split(Pattern.quote("|"));
				by = parameterizedLocator(by, replace[0], replace[1]);
			} else {
				by = parameterizedLocator(by, replacementValue);
			}
			element = wait.waitForVisibilityOfElement(by);
		} catch (StaleElementReferenceException | NoSuchElementException e) {
			element = wait.waitForVisibilityOfElement(by);
		}
		return element;
	}

	protected List<WebElement> getElements(By by) {
		return getElements(by, "");
	}

	protected List<WebElement> getElements(By by, String replacementValue) {
		List<WebElement> elements;
		try {
			by = parameterizedLocator(by, replacementValue);
			elements = driver.findElements(by);
		} catch (StaleElementReferenceException | NoSuchElementException e) {
			elements = driver.findElements(by);
		}
		return elements;
	}

	protected By parameterizedLocator(By by, String param) {
		if (!param.isEmpty()) {
			String loc = by.toString().replaceAll("\'", "\\\"");
			String type = loc.split(":", 2)[0].split(",")[0].split("\\.")[1];
			String variable = loc.split(":", 2)[1].replaceFirst("\\$\\{.+?\\}", param);
			return getBy(type, variable);
		} else {
			return by;
		}
	}

	protected By parameterizedLocator(By by, String param1, String param2) {
		if (!param1.isEmpty()) {
			by = parameterizedLocator(by, param1);
		}
		if (!param2.isEmpty()) {
			by = parameterizedLocator(by, param2);
		}
		return by;
	}

	protected By getBy(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "id":
			return By.id(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		case "css":
		case "cssSelector":
			return By.cssSelector(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "classname":
			return By.className(locatorValue);
		case "linktext":
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

	/**
	 * This method returns value of provided attribute of specified WebElement using
	 * 'By' after waiting for its visibility.
	 *
	 * @param by
	 * @param attributeName
	 * @return String - Attribute Value
	 */
	protected String getAttribute(By by, String attributeName) {
		String value = null;
		WebElement element;
		try {
			element = wait.waitForVisibilityOfElement(by);
			value = element.getAttribute(attributeName);
		} catch (StaleElementReferenceException e) {
			element = wait.waitForVisibilityOfElement(by);
			jsUtil.scrollDown(by);
			value = element.getAttribute(attributeName);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return value;
	}

	protected void acceptAlert() {
		int time = WaitUtility.defaultImplicitTimeout;
		try {
			switchToAlert().accept();
			logMessage("Alert Accepted..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		wait.resetImplicitTimeout(time);
	}

	protected void dismissAlert() {
		int time = WaitUtility.defaultImplicitTimeout;
		try {
			switchToAlert().dismiss();
			logMessage("Alert Dissmissed..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		wait.resetImplicitTimeout(time);
	}

	public boolean elementVisibility(By elementToken) throws NoSuchElementException {
		return elementVisibility(elementToken, "");
	}

	public boolean elementVisibility(By elementToken, String replacement) throws NoSuchElementException {
		boolean flag = false;
		wait.resetImplicitTimeout(2);
		try {
			@SuppressWarnings("unused")
			WebElement elem = driver.findElement(parameterizedLocator(elementToken, replacement));
			flag = true;
		} catch (Exception excp) {
		}
		wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		return flag;
	}

	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToChildWindow() {
		parentWindowHandle = driver.getWindowHandle();
		for (String childWindowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(childWindowHandle);
		}
	}

	protected void switchToParentWindow() {
		driver.switchTo().window(parentWindowHandle);
	}

	protected void closeWindow() {
		driver.close();
	}

	public void pageRefresh() {
		driver.navigate().refresh();
		logMessage("[INFO]: PAGE GOT REFRESHED...");
		wait.waitForPageToLoadCompletely();
	}

	protected void clickUsingActions(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).click(e).build().perform();
	}

	public void mouseHoverToWebElement(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}
	
	public void mouseHoverAndClickToWebElement(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element).build().perform();
	}

	public void mouseHoverAndClickToWebElement(WebElement elementToHover, WebElement elementToClick) {
		Actions builder = new Actions(driver);
		builder.moveToElement(elementToHover).click(elementToClick).build().perform();
	}

	protected void closeParentMoveToChild() {
		driver.switchTo().window(parentWindowHandle);
		driver.close();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 * This methods returns TRUE/FALSE as boolean for the visibility of the
	 * WebElement after waiting for its visibility.
	 *
	 * @param by, replacementValue
	 * @return boolean - Visibility
	 */
	protected boolean isDisplayed(By by,String replacementValue) {
		boolean flag = true;
		WebElement element;
		WebDriverWait waits = new WebDriverWait(driver, WaitUtility.defaultExplicitTimeout);
		try {
			
			wait.resetImplicitTimeout(1);
			if (replacementValue.contains("|")) {
				String[] replace = replacementValue.split(Pattern.quote("|"));
				by = parameterizedLocator(by, replace[0], replace[1]);
			} else {
				by = parameterizedLocator(by, replacementValue);
			}
			element = waits.until(ExpectedConditions.presenceOfElementLocated(by));
			waits.until(ExpectedConditions.visibilityOf(element));
			try {
				element = waits.until(ExpectedConditions.presenceOfElementLocated(by));
				waits.until(ExpectedConditions.visibilityOf(element));
				if (!driver.findElement(by).isDisplayed()) {
					flag = false;
				}
			} catch (StaleElementReferenceException e) {
				element = waits.until(ExpectedConditions.presenceOfElementLocated(by));
				waits.until(ExpectedConditions.visibilityOf(element));
				if (!driver.findElement(by).isDisplayed()) {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
			return flag;
		} catch (TimeoutException te) {
			return false;
		} finally {
			wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
		}
	}
		
	public void switchToActiveElement() {
		driver.switchTo().activeElement();
	}
	
	public void rightOrContextClick(By by) {
		actionBuilderUtil.contextClickByAction(by);
	}
	
	public void movebyoffsetAndClick(By by, int xOffset, int yOffset) {
		actionBuilderUtil.movebyoffsetFromElementAndClick(by, xOffset, yOffset);
	}

	protected List <By> getAllUnqiueLocatorsAsGroupedList(String str[]){
		List <By> element = new ArrayList<>();
		for(String locator : str) {
			element.add(By.xpath(locator));
		}
		return element;
	}

	protected boolean allIsDisplayed(List<By> elements) {
		Iterator<By> iterator = elements.iterator();
		while (iterator.hasNext()) {
			if(!isDisplayed(iterator.next())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method will select the value from drop down by visible text
	 * @param by
	 * @param visibleText
	 */
	protected void selectByVisibleText(By by, String visibleText) {
		Select select;
		try {
			select= new Select(wait.waitForElementToBeClickable(by));
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	 /**
     * This method will used for scroll to element
     * @author himanshu.dua
     * @param by
     */
	public void scrollToElement(By by) {
		jsUtil.scrollToElement(by);
	}
	
	/**
	 * This methods clears the WebElement Field after waiting for the WebElement
	 * to be visible.
	 *
	 * @param by
	 * 
	 * @author udit.khanna
	 */
	protected void clearField(By by) {
		WebElement webelement;
		try {
			webelement = wait.waitForVisibilityOfElement(by);
			webelement.click();
			webelement.clear();
		} catch (StaleElementReferenceException se) {
			webelement = wait.waitForVisibilityOfElement(by);
			jsUtil.scrollDown(by);
			webelement.click();
			webelement.clear();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	public boolean  waitForElementtoBeDisplayedAfterRefresh(By byobject) {
		String refreshcounter = ReadWritePropertyFile.getProperty("refreshCounter", BaseAutomation.configFile).toString();
			for (int i = 0; i < Integer.parseInt(refreshcounter); i++) {
				if(!isDisplayed(byobject))
				{
					driver.navigate().refresh();
					wait.waitForPageToLoadCompletely();
					jsUtil.scrollUp();
				}
				else
					return true;
			}
			return false;
	}
}