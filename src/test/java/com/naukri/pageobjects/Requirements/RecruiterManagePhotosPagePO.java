package com.naukri.pageobjects.Requirements;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

public class RecruiterManagePhotosPagePO extends PageObjectWrapper {
	By eleChooseFile = By.id("inpFile");
	By uploadBtn = By.xpath("//span[text()='Upload']");
	By sucessMessage = By.xpath("//div[contains(text(),'Photo uploaded successfully')]");
	By eleTotalImage = By.xpath("//div[@class='imgbox']");
	By eleAllPhotos = By.id("selectAlltop");
	By eleAllVideo = By.xpath("//div[@class='imgbox']");
	By eleButton = By.xpath("(//span[text()='${value}'])[1]");
	By eleUrlField = By.id("video_url");
	By eleAddUrlBtn = By.id("addVideoBtn");
	By eleDeleteConfirmationButton = By.xpath("//div[@id='delete']//button[@name='moveSubmit']");
	/**
	 * This method will check if photos are not uploaded or less than 6 it will upload photos.
	 * @author himanshu.dua
	 */
	public void chooseFile() {
		switchToChildWindow();
		//goToPageURL("https://recruit.test2.himanshu-dua-test2.cluster.infoedge.com/managePhoto/manage");
		int size = 0;
		if (isDisplayed(eleTotalImage)) {
			size = getElements(eleTotalImage).size();
		}
		if (size < 6)
			for (int i = 1; i <= 8 - size; i++) {
				String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\photos\\" + i
						+ ".jpg";
				System.out.println(filepath);
				getElement(eleChooseFile).sendKeys(filepath);
				System.out.println("ni chla");
				jsUtil.clickByJS(uploadBtn);
				wait.waitForVisibilityOfElement(sucessMessage);
			}
	}
	
	/**
	 * This method will select all the photos and return the driver to parent window
	 * @author himanshu.dua
	 */
	public void selectAllPhotoes() {
		click(eleAllPhotos);
		switchToParentWindow();
	}
	
	/**
	 * This function will return total video count
	 * @return
	 */
	public int totalAddedVideo() {
		System.out.println("total video-->> "+ getElements(eleAllVideo).size());
		return getElements(eleAllVideo).size();
	}

	/**
	 * This function delete all photos and videos
	 * @param button
	 */
	public void deleteAllVideos(String button) {
		click(eleAllPhotos);
		click(parameterizedLocator(eleButton,button));
		jsUtil.clickByJS(eleDeleteConfirmationButton);
	}
	
	/**
	 * This method will add video URL
	 * @param btn
	 * @param url
	 */
	public void addURL(String btn, String url) {
		click(parameterizedLocator(eleButton,btn));
		sendKeys(eleUrlField, url);
		jsUtil.clickByJS(eleAddUrlBtn);
	}
}
