package com.naukri.test.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.naukri.automation.util.WaitUtility;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <b>This Class inherits BaseAutomation and must be used to override, customize
 * selenium functionalities and create instance of PageObject classes to be used
 * in Step definition classes.</b>
 * <br>
 * <br>
 * <i>All PageObject Classes must inherit this class.</i>
 *
 * @version 1.0.0
 * @since 20/05/2019
 * @author Mohit Dagar <mohit.dagar@naukri.com>
 *
 */
public class PageObjectWrapper extends BaseAutomation {

    private static Map<String, Object> pageObjectMap = new HashMap<>();

    /**
     * This static method should only be used to get object of PageObject
     * Classes.
     *
     * @param pageObjectClass
     * @return Object - PageObjectClass
     */
    public static Object getObject(Class<?> pageObjectClass) {
        if (!pageObjectMap.containsKey(pageObjectClass.getCanonicalName())) {
            try {
                Constructor<?> constructor = Class.forName(pageObjectClass.getCanonicalName()).getDeclaredConstructor();
                constructor.setAccessible(true);
                Object instance = constructor.newInstance();
                PageFactory.initElements(driver, instance);
                pageObjectMap.put(pageObjectClass.getCanonicalName(), instance);
                return pageObjectClass.cast(instance);
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return pageObjectMap.get(pageObjectClass.getCanonicalName());
    }

    /**
     * This static method should only be used to get object of Inner Classes of
     * PageObject Classes.
     *
     * @param parentPOClass and its innerPOClass
     * @return Object - InnerPageObjectClass
     */
    public static Object getInnerClassObject(Class<?> parentPOClass, Class<?> innerPOClass) {
        Object parent = getObject(parentPOClass);
        if (!pageObjectMap.containsKey(innerPOClass.getCanonicalName())) {
            try {
                Constructor<?> constructor = Class.forName(parentPOClass.getCanonicalName() + "$" + innerPOClass.getSimpleName()).getDeclaredConstructor(Class.forName(parentPOClass.getCanonicalName()));
                constructor.setAccessible(true);
                Object instance = constructor.newInstance(parent);
                PageFactory.initElements(driver, instance);
                pageObjectMap.put(innerPOClass.getCanonicalName(), instance);
                return innerPOClass.cast(instance);
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return pageObjectMap.get(innerPOClass.getCanonicalName());
    }

    protected void hardClear(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
        element.sendKeys(Keys.DELETE);
    }

    protected void sendKeysClearWithActionClass(By element, String value) {
        try {
            wait.waitForVisibilityOfElement(element);
            jsUtil.scrollDown(element);
            hardClear(element);
            sendKeys(element, value);
        } catch (StaleElementReferenceException e) {
            wait.waitForVisibilityOfElement(element);
            jsUtil.scrollDown(element);
            hardClear(element);
            sendKeys(element, value);
        } catch (Exception e) {
            Assert.fail("Element " + element + " Not intreactable" + e.getMessage());
        }
    }

    protected List<By> getAllUnqiueLocatorsAsGroupedList(String str[]) {
        List<By> element = new ArrayList<>();
        for (String locator : str) {
            element.add(By.xpath(locator));
        }
        return element;
    }

    protected boolean allIsDisplayed(List<By> elements) {
        Iterator<By> iterator = elements.iterator();
        while (iterator.hasNext()) {
            if (!isDisplayed(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    protected boolean elementPresence(By token) {
        boolean display = false;
        try {
            driver.findElement(token);
            display = true;
        } catch (Exception e) {
            display = false;
        }
        return display;
    }

    /**
     * This method is for getting the current date in  17 Jul 2020 format
     * @return current date in  17 Jul 2020 format
     * @author vikash.agrawal
     */
    public static String getCurrentDate() {
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String formDate = formatter.format(date);
        return formDate;
        
    }

//	public boolean isDisplayed(By by) {
//		boolean flag = true;
//        try {
//            wait.resetImplicitTimeout(1);
//            wait.waitForVisibilityOfElement(by);
//            jsUtil.scrollDown(by);
//            try {
//                wait.waitForVisibilityOfElement(by);
//                if (!driver.findElement(by).isDisplayed()) {
//                    flag = false;
//                }
//            } catch (StaleElementReferenceException e) {
//                wait.waitForVisibilityOfElement(by);
//                if (!driver.findElement(by).isDisplayed()) {
//                    flag = false;
//                }
//            } catch (Exception e) {
//                flag = false;
//            }
//            return flag;
//        } catch (TimeoutException te) {
//            return false;
//        } finally {
//            wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
//        }
//	}
}
