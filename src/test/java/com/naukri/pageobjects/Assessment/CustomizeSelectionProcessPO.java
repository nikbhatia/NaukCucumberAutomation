package com.naukri.pageobjects.Assessment;

import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * 
 * @author rounak.jain
 *
 */
public class CustomizeSelectionProcessPO extends PageObjectWrapper {

	private By btnAddSelectionStage = By.xpath("(//a[text()='Add Selection Stage'])[1]");
	private By txtEnterSelectionStage = By.xpath("//input[@id='newVal' and contains(@class,'stageSubStageInput')]");
	private By btnDeleteButton = By.xpath("//a[contains(text(),'Delete')][1]");
	private By btnSaveButton = By.xpath("//a[text()='Save']");
	private By eleClickSelectionStg = By.xpath("//div[text()='${selStageName}']");
	private By billingCheckboxUnderOffer = By.xpath("//div[text()='Offers & Joining']/parent::div/following-sibling::div//label[text()='Offered']/following-sibling::div/input[1]");

	/*
	 * To click on add selection stages button
	 */
	public void clickAddSelectionStage() {
		getElement(btnAddSelectionStage).click();
	}

	/*
	 * To click on save button
	 */
	public void clickSaveButton() {
		getElement(btnSaveButton).click();
	}
	/*
	 * To add a selection stage
	 * 
	 * @param selStageName : name of the selection stage
	 */

	public void addSelectionStage(String selStageName) {
		getElement(txtEnterSelectionStage).sendKeys(selStageName);
	}

	/**
	 * To delete the selection stage
	 * 
	 * @param selStageName : name of the selection stage
	 */
	public void deleteSelectionStage(String selStageName) {
		clickSelctionStage(selStageName);
		getElement(By.xpath(
				"//div[text()='" + selStageName + "']/../preceding-sibling::div/a/em[contains(@class,'delIcon')]"))
						.click();
		;
		wait.hardWait(4);
		getElement(btnDeleteButton).click();
		wait.hardWait(4);
	}

	/**
	 * To click on the selction stage
	 * 
	 * @param selStageName : name of the selection stage
	 */

	public void clickSelctionStage(String selStageName) {
		wait.waitForPageToLoadCompletely();
		getElement(eleClickSelectionStg, selStageName).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * To verify the selection stages
	 * 
	 * @param selStageName: name of the selection stage
	 * @return it will return true if stage exist on selection stage tab
	 */
	public boolean verifySelectionStage(String selStageName) {
		return isDisplayed(By.xpath("//div[text()='" + selStageName + "']"));
	}

	/**
	 * To return the list of selection stage
	 * 
	 * @return : it will return the set of selection stage
	 */
	public LinkedHashSet<String> getGlobalSelectionStage() {
		List<WebElement> globalStage = driver
				.findElements(By.xpath("//strong[text()='Selection Process Preview']/../div[@id='tree']/span"));
		LinkedHashSet<String> stages = new LinkedHashSet<String>();
		for (int i = 1; i <= globalStage.size(); i++) {
			String parentStage = getElement(
					By.xpath(" //strong[text()='Selection Process Preview']/../div[@id='tree']/span[" + i + "]/span"))
							.getText();
			int subStageSize = driver
					.findElements(By.xpath("//strong[text()='Selection Process Preview']/../div[@id='tree']/span[" + i
							+ "]/following-sibling::ul[1]/li/span"))
					.size();
			if (subStageSize > 0) {
				for (int j = 1; j <= subStageSize; j++) {
					String subStageName = driver.findElement(
							By.xpath("//strong[text()='Selection Process Preview']/../div[@id='tree']/span[" + i
									+ "]/following-sibling::ul[1]/li[" + j + "]/span[1]"))
							.getText();
					stages.add(parentStage + "-" + subStageName);
				}
			} else {
				stages.add(parentStage);
			}

		}

		System.out.println(stages);
		return stages;

	}

	public boolean isBillingStageSelected() {
		hover(billingCheckboxUnderOffer);
		String attribute = getAttribute(billingCheckboxUnderOffer, "value");
		if(attribute.contains("TRUE")) {
			return true;
		}else {
			return false;
		}
//		return isDisplayed(By.xpath("//div[text()='Offers & Joining']/parent::div/following-sibling::div//label[text()='Offered']/following-sibling::div/input[@value='TRUE']"));

	}
}
