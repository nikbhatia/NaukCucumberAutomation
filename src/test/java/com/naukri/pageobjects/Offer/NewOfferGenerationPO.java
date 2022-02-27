package com.naukri.pageobjects.Offer;

import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;

/**
 * @author raunak.b
 *
 */
public class NewOfferGenerationPO extends BaseAutomation {
	private By offerGenerationSwitchStateOn = By.xpath("//a[@id='offerGenerationModuleSwitch']//input[@value='on']");
	private By offerGenerationSwitch = By.xpath("//a[@id='offerGenerationModuleSwitch']");
	private By setSwitchSettings = By.xpath("(//input[@value='Set'])[1]");

	/**uncheck switch offer generation module settings page 
	 * 
	 */
	public void uncheckSwitchOfferGenerationModuleSettingsPage() {
		if (elementVisibility(offerGenerationSwitchStateOn)) {
			click(offerGenerationSwitch);
		}
	}

	/**set offer generation  settings 
	 * 
	 */
	public void setOfferGenerationSettings() {
		click(setSwitchSettings);
	}
}