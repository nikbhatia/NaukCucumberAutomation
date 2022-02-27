package com.naukri.automation.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUtility {

	public int timeout;

    private WebDriver driver;
	private WebDriverWait wait;
	public static int defaultImplicitTimeout;
	public static int defaultExplicitTimeout;

	public WaitUtility(WebDriver driver, String implicitTimeout, String explicitTimeout) {
		this.driver = driver;
		this.defaultExplicitTimeout = Integer.parseInt(explicitTimeout);
		this.wait = new WebDriverWait(driver, Long.parseLong(explicitTimeout));
        WaitUtility.defaultImplicitTimeout = Integer.parseInt(implicitTimeout);
	}
	
	public void resetImplicitTimeout(int newTimeOut) {
		driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
	}

	public void waitForPageToLoadCompletely() {
        hardWait(2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*")));
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
	public void waitForInvisibilityOfElement(int maxTimeout, int maxRetryCount, By byObject) {
		resetImplicitTimeout(1);
		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds((long)maxTimeout));
		try {
			for(int i=1;i<=maxRetryCount;i++) {
				try {
				waits.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(byObject))));
				}catch (NoSuchElementException ne) {
					break;
				}catch (TimeoutException te) {
					continue;
				}		
			}
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
	}
	
	public WebElement waitForVisibilityOfElement(By locator) {
		WebElement element;
		try {
		element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element= wait.until(ExpectedConditions.visibilityOf(element));
		}catch (TimeoutException | NoSuchElementException se) {
			try {
			element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}catch (Exception e) {
				element=null;
//				Assert.fail(e.getMessage());
			}
		}
		return element;
	}
    
    public WebElement waitForElementToBeClickable(By locator) {
    	waitForVisibilityOfElement(locator);
        WebElement element;
        element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

	public void waitForValignWrapperToDisappear(int i, int j) {
		By by = By.xpath("//div[@class='valign-wrapper']");
		waitForInvisibilityOfElement(i, j, by);
	}
	
	/**
	 * This method is wait for processing-overlay loader
	 * @author himanshu.dua
	 * @param i
	 * @param j
	 */
	public void waitForProcessingToDisappear(int i, int j) {
		By by = By.xpath("//div[contains(@class,'processing-overlay')]");
		waitForInvisibilityOfElement(i, j, by);
	}
	
	/**
	 * This method is wait for overlay-processing loaders
	 * @author himanshu.dua
	 * @param i
	 * @param j
	 */
	public void waitForOverlayProcessingToDisappear(int i, int j) {
		By by = By.xpath("//div[contains(@class,'overlayerProgress')]");
		waitForInvisibilityOfElement(i, j, by);
	}
	
	/**
	 * This method is wait for guide-backdrop
	 * @author himanshu.dua
	 * @param i
	 * @param j
	 */
	public void waitForguide_backdropToDisappear(int i, int j) {
		By by = By.xpath("//div[contains(@id,'guide-backdrop')]");
		waitForInvisibilityOfGuide(i, j, by);
	}
	
	public void waitForInvisibilityOfGuide(int maxTimeout, int maxRetryCount, By byObject) {
		resetImplicitTimeout(1);
		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds((long)maxTimeout));
		try {
			for(int i=1;i<=maxRetryCount;i++) {
				try {
				driver.findElement(byObject).sendKeys(Keys.ESCAPE);
				waits.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(byObject))));
				}catch (NoSuchElementException ne) {
					break;
				}catch (TimeoutException te) {
					continue;
				}		
			}
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
	}
}
