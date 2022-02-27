package com.naukri.automation.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

/**
 * Utility file for asserting on list of elements
 * @author rachit.mehrotra
 */
public class AssertionUtil {
	
	private WebDriver driver;
	
	public AssertionUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	SoftAssert softAssert= new SoftAssert();
	
	public void softAssertTrueListOfElements(List<Boolean> presenceOfWebElement, List<String> nameOfWebElement) {
		if(presenceOfWebElement.size() == nameOfWebElement.size()) {
			for(int i = 0 ; i < presenceOfWebElement.size() ; i++) {
				softAssert.assertTrue(presenceOfWebElement.get(i), 
						"The element with locator name "+nameOfWebElement.get(i)+ " is not displayed");
			}
		}
		else {
			System.err.println("The size of the element name and the presence is not same");
			return;
		}
		softAssert.assertAll();
	}

}
