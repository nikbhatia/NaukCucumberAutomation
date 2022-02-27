package com.naukri.pageobjects.Vendor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.test.base.BaseAutomation;

/**
 * 
 * @author rounak.jain
 *
 */
public class VendorSubmissionVerificationPO extends BaseAutomation {

	private By clientId = By.xpath("//input[@name='psp[clientId]']");
	private By selectCand = By
			.xpath("//span[@title='${vendorName}']/../../following-sibling::div//a[contains(text(),'New')]");

	/**
	 * To get the client Id of recruiter
	 */
	public void getClientId() {
		String clientIde = getElement(clientId).getAttribute("value");
		System.out.println(VendorPortalPO.vendorPortalFile);
		ReadWritePropertyFile.setProperty("clientId", clientIde.toString(), VendorPortalPO.vendorPortalFile);
	}

	/**
	 * To select the newely added candidate from vendor
	 */
	public void selectNewAddedCandidate(String vendorName) {
		getElement(selectCand, vendorName).click();
	}
}
