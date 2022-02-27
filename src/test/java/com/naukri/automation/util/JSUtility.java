package com.naukri.automation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtility {

    private WebDriver driver;
    private WaitUtility wait;
    private WebElement element;

    public JSUtility(WebDriver driver, WaitUtility wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void executeJavascript(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }
    
    /**
     * To return the value of javascript variable present
     * @author rachit.mehrotra
     * @param script
     * @return String
     */
    public String executeJavascriptForJSVariables(String script) {
    	return (String) ((JavascriptExecutor) driver).executeScript("return " + script);
    }
    
    /**
     * To return the value of javascript variable present with long return type
     * @author rachit.mehrotra
     * @param script
     * @return boolean 
     */
    public long executeJavascriptForJSVariablesLongReturn(String script) {
    	return (long) ((JavascriptExecutor) driver).executeScript("return " + script);
    }
    
    public void executeJavascript(String script, By by) {
        element = wait.waitForVisibilityOfElement(by);
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public void executeJavascriptOnWebElement(String script, By by) {
        element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public void scrollDown(By by) {
        element = wait.waitForVisibilityOfElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-10000)");
    }
    
    public void scrollMid(By by) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, -100000)");
        hardWait(1);
        element = wait.waitForVisibilityOfElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        hardWait(1);
        jse.executeScript("window.scrollBy(0,-350)");
        hardWait(1);
    }

    public void sendKeysByJS(By by, String value) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        element = wait.waitForVisibilityOfElement(by);
        executor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    /**
     * 
     * @param This method will return text of any element provided
     * @return 
     */
    public String getTextByJS(String element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('" + element + "').text");
    }

    /**
     * 
     * @param This method will return text of any element provided using indexing
     * @return 
     */
    public String getTextByJS(String element, int count) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.querySelectorAll('" + element + "')[" + count + "].text");
    }

    public void clickByJS(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        element = wait.waitForVisibilityOfElement(by);
        executor.executeScript("arguments[0].click();", element);
    }

    public void hoverByJS(By by) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);";
        element = wait.waitForVisibilityOfElement(by);
        ((JavascriptExecutor) driver).executeScript(javaScript, element);
    }

    public void hoverByJS(WebElement element) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(javaScript, element);
    }

    public void hoverByJQuery(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        element = wait.waitForVisibilityOfElement(by);
        js.executeScript("arguments[0].onmouseover()", element);
    }

    private void hardWait(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method use webElement for Javascript executer
     * @author abhishek.dwivedi
     * @param script
     * @param element
     */
    public void executeJavascript(String script, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    /**
     * This method will used for scroll to element
     * @author himanshu.dua
     * @param by
     */
    public void scrollToElement(By by) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
            WebElement element = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
   
    /**
     * To get the encoded size of the image
     * @author rachit.mehrotra
     * @param uri
     * @return
     */
   public long getEncodedBodySize(String uri) {
	   return executeJavascriptForJSVariablesLongReturn("performance.getEntriesByName('"+uri+"')[0].encodedBodySize");
   }
   
   /**
    * To get the decoded size of the image
    * @author rachit.mehrotra
    * @param uri
    * @return
    */
   public long getDecodedBodySize(String uri) {
	   return executeJavascriptForJSVariablesLongReturn("performance.getEntriesByName('"+uri+"')[0].decodedBodySize");
   }
}
