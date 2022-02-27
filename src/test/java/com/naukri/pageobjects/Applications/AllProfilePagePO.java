package com.naukri.pageobjects.Applications;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

public class AllProfilePagePO extends PageObjectWrapper{
	public By emailOption= By.id("emailIdForDisplay");
	public By cbFirstCandidate= By.xpath("(//div[@class='candDet newTuple']//input)[1]");
	private By btnlastPage = By.xpath("(//ul[contains(@class,'pList')]//li[last()-1])[1]");
	By eleSideFacets = By.id("facetDisplayDiv");
	
	/**
	 * This method will verify Candidate email is present by comparing email
	 * @param candidateEmail
	 * @return
	 */
	public boolean verifyCandidateIsPresentOnPage(String candidateEmail) {
		return getAttribute(emailOption, "title").trim().equalsIgnoreCase(candidateEmail);
	}
	
	/**
	 * This Method will click on first candidate on all Application page
	 */
	public void clickOnFirstCandidateCheckbox() {
		click(cbFirstCandidate);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to verify presence of side facets on page
	 * @return true if side cluster is displayed on page else false
	 */
	public boolean presenceOfSideFacets()
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleSideFacets);
	}
	
	/**
	 * @author gupta.mansi
	 * This method clicks on last page of All Application page
	 */
	public void clickOnLastPage()
	{
		wait.waitForPageToLoadCompletely();
		click(btnlastPage);
	}
	
}
