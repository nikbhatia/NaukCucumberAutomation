package com.naukri.stepdefinitions.Vendor;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.pageobjects.Vendor.SRPPagePO;
import com.naukri.pageobjects.Vendor.VendorPortalPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.Then;

public class SRPPageStepDef {

	SRPPagePO srpPage = (SRPPagePO) PageObjectWrapper.getObject(SRPPagePO.class);

	@Then("Verify that User is able to see the submitted candidate at SRP Page")
	public void verifyThatUserIsAbleToSeeTheSubmittedCandidateAtSRPPage() {
		srpPage.verifyCandidateAtSrp(ReadWritePropertyFile.getProperty("vendorCandidateName", VendorPortalPO.vendorPortalFile));
	}
}
