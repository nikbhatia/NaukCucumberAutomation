package com.naukri.pageobjects.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naukri.test.base.BaseAutomation;

/**
 * 
 * @author rounak.jain
 *
 */
public class AssessmentAdminDashboardPO extends BaseAutomation {

	public static By NoOFCandidatesOnReqDashboard = By.xpath("(//div[@class='proCount cle']//a)[1]");

	/**
	 * To navigate on a particular url
	 * @author rounak.jain
	 * @param url : url to navigate
	 */
	public void navigateToDashboard(String url) {
		goToPageURL(url);
	}

	/**
	 * To get the count of credit available of an user
	 * @author rounak.jain
	 * @param labelName : Name of the label
	 * @return
	 */
	public String getCountOfCreditsDashboard(String labelName) {
		return getElement(By.xpath("//span[text()='" + labelName + "']/following-sibling::span")).getText();
	}

	/**
	 * to click on number of candidate
	 */
	public void clickOnNoOFCandidates() {
		getElement(NoOFCandidatesOnReqDashboard).click();
	}

	/**
	 * @author rounak.jain To refresh the page
	 */

	public void refreshPage() {
		pageRefresh();
	}

	/**
	 * To verify the total credits on dashboard
	 * 
	 * @param actualCredits   : Credits should available
	 * @param expectedCredits : Credits are available
	 * @return result
	 */
	public boolean compareExpectedAndActualPendingCreditCountWhenNotConsumed(String actualCredits,
			String expectedCredits) {

		int IntExpectedTestCreditsPending = Integer.parseInt(expectedCredits) + 1;
		int IntActualtestCreditsPending = Integer.parseInt(actualCredits);

		if (IntActualtestCreditsPending == IntExpectedTestCreditsPending) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To verify the total count of test on dashboard
	 * 
	 * @param actualCredits   : Credits should available
	 * @param expectedCredits : Credits are available
	 * @return result
	 */

	public boolean compareExpectedAndActualCreditCountWhenConsumed(String actualCredits, String expectedCredits) {
		int IntExpectedTestCreditsPending = Integer.parseInt(expectedCredits);
		int IntActualtestCreditsPending = Integer.parseInt(actualCredits);

		if (IntActualtestCreditsPending == IntExpectedTestCreditsPending) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To verify the total credits on dashboard after consume of credits
	 * 
	 * @param actualCredits   : Credits should available
	 * @param expectedCredits : Credits are available
	 * @return result
	 */
	public boolean compareExpectedAndActualAvailableCreditCountWhenConsumed(String actualCredits,
			String ExpectedCredits) {
		int IntExpectedTestCreditsAvailable = Integer.parseInt(ExpectedCredits) - 1;
		int IntActualtestCreditsAvailable = Integer.parseInt(actualCredits);

		if (IntActualtestCreditsAvailable == IntExpectedTestCreditsAvailable) {
			return true;
		} else {
			return false;
		}

	}

}
