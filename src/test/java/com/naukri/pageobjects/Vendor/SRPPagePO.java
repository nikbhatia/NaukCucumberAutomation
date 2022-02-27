package com.naukri.pageobjects.Vendor;

import org.openqa.selenium.By;
import com.naukri.test.base.BaseAutomation;
/**
 * 
 * @author rounak.jain
 *
 */
public class SRPPagePO extends BaseAutomation {

	private By candOnSrp = By.xpath("//a[text()='${candidateName}']");
	/**
	 * To verify if candidate exist on SRP Page
	 * @param candidateName : name of the candidate 
	 * @return It will return true if candidate exist on srp page
	 */
	public boolean verifyCandidateAtSrp(String candidateName) {
		switchToChildWindow();
		return isDisplayed(By.xpath("//a[text()='candidateName']"));
	}
}
