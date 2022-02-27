package com.naukri.automation.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.naukri.test.base.BaseAutomation.jsUtil;

public class ActionBuilderUtility {
	private WebDriver driver;
	private WaitUtility wait;
	private WebElement element;
	private String browserName;

	public ActionBuilderUtility(WebDriver driver, WaitUtility wait, String browserName) {
		this.driver=driver;
		this.wait = wait;
		this.browserName = browserName;
	}
	
	public void hoverByAction(By by) {
		Actions hoverOver = new Actions(driver);
		wait.waitForVisibilityOfElement(by);
		if (browserName.contains("Firefox")||browserName.contains("firefox")||browserName.contains("ff")||browserName.contains("FF")) {
			hoverOver.moveToElement(driver.findElement(by)).build().perform();
		} else {
			for (int i = 0; i < 3; i++) {
				hoverOver.moveToElement(driver.findElement(by)).clickAndHold().build().perform();
			}
		} 
	}
	
	public void hoverByActionAlternate(By by) {
		Actions hoverOver = new Actions(driver);
		wait.waitForVisibilityOfElement(by);
		if (browserName.contains("Firefox")||browserName.contains("firefox")||browserName.contains("ff")||browserName.contains("FF")) {
			hoverOver.moveToElement(driver.findElement(by)).build().perform();
		} else {
			for (int i = 0; i < 3; i++) {
				wait.hardWait(1);
				hoverOver.moveByOffset(0, 100).moveToElement(driver.findElement(by)).perform();
			}
		} 
	}
	
	public void sendKeysByAction(By by, String text) {
        Actions actions = new Actions(driver);
        element = wait.waitForVisibilityOfElement(by);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
    }
	
	public void clickByAction(By by) {
        Actions actions = new Actions(driver);
        element = wait.waitForVisibilityOfElement(by);
        actions.moveToElement(element).click(element).build().perform();
    }
	
	public void hoverClickByAction(By by) {
		Actions hoverClick = new Actions(driver);
		element = wait.waitForVisibilityOfElement(by);
		hoverClick.moveToElement(element).click().build().perform();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to perform right click on the element
	 * @param locator of By type
	 */
	
	public void contextClickByAction(By by)
	{
		Actions build = new Actions(driver);
		element = wait.waitForVisibilityOfElement(by);
		build.moveToElement(element).contextClick().build().perform();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to move by offset from element And perform click
	 * @param locator of By type, x coordinate of offset, y coordinate of offset
	 */
	
	public void movebyoffsetFromElementAndClick(By by, int xOffset, int yOffset)
	{
		Actions build = new Actions(driver);
		element = wait.waitForVisibilityOfElement(by);
		build.moveToElement(element).moveByOffset(xOffset, yOffset).click().build().perform();
	}

	public void hardClear(WebElement element) {
		Actions actions= new Actions(driver);
		actions.doubleClick(element).build().perform();
		element.sendKeys(Keys.DELETE);
	}

	public void sendKeysClearWithActionClass(By by, String value) {
		try {
			element = wait.waitForVisibilityOfElement(by);
			jsUtil.scrollDown(by);
			hardClear(element);
			element.sendKeys(value);
		} catch (StaleElementReferenceException e) {
			element = wait.waitForVisibilityOfElement(by);
			jsUtil.scrollDown(by);
			hardClear(element);
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail(e.getMessage() + "Element " + element + " Not intreactable");
		}
	}
	public void sendKeysByAction(By by, Keys k) {
        Actions actions = new Actions(driver);
        element = wait.waitForVisibilityOfElement(by);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(k);
        actions.build().perform();
    }
}
