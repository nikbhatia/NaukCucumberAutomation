package com.naukri.pageobjects.Billing;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

public class MailPagePO extends PageObjectWrapper {
	
	By mailSubject = By.xpath("//input[@class='mailsubject']");
    By mailBody = By.xpath("//div[@class='mailBodyWriter']");
    By sendMailBtn = By.xpath("//button[contains(text(),'Send')]");
	
	public void selectValueFromDDInViewContainer(String ddLabel, String value) {
		wait.waitForValignWrapperToDisappear(10, 3);
		click(By.xpath("//div[@class='viewContainer']//*[text()='" + ddLabel + "']"));
		wait.waitForValignWrapperToDisappear(10, 3);
		click(By.xpath(goToDDValueInViewContainer(ddLabel, value)));
		wait.waitForValignWrapperToDisappear(10, 3);
	}

	private String goToDDValueInViewContainer(String labelName, String value) {
		return "//div[@class='viewContainer']//*[text()=\"" + labelName + "\"]/following::span[contains(text(),\""
				+ value + "\")]/parent::li";
	}

	public String getSubjectMailPage() {
		String mailSubj = getAttribute(mailSubject, "value");
		return mailSubj;
	}

	public String getBodyMailPage() {
		return getText(mailBody);
	}
	
	 public void enterMailBody(String mailBodytext) {
	    	wait.waitForValignWrapperToDisappear(10, 3);
	    	wait.waitForVisibilityOfElement(mailBody);
	        sendKeys(mailBody,mailBodytext);
	    }
	 
	 public void selectFinancialMailTagsForMailBody(String option, String subText) {
			hover(By.xpath("//span[@class = \"tagToggler\"]/span"));
			click(By.xpath("//span[@class = \"tagToggler\"]//..//ul[@class = \"tagCategory\"]//li[contains(text(), '"+option+"')]"));
			click(By.xpath("//li[contains(text() , '"+subText+"')]"));
		}
	 
	 public void clickOnSendButton() {
	        click((sendMailBtn));
	        wait.waitForValignWrapperToDisappear(10, 3);
	    }
}
