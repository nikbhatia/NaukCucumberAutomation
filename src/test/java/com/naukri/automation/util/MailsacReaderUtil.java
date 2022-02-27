package com.naukri.automation.util;

import org.openqa.selenium.By;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

public class MailsacReaderUtil extends BaseAutomation{

    GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

    String mailsacUrl = "https://mailsac.com/";
    String inviteMailString = "Click Here to get linked to this company";
    String dirtyUrl = null;

    public By messageSubjectLocator = By.xpath("//tr[contains(@ng-repeat , 'msg')]/td[contains(text(),'${messageSubject}')]");
    public By messageSenderAddress = By.xpath("//tr[contains(@ng-repeat , 'msg')]//strong[contains(text(),'${senderAddress}')]");
    public By unblockLinksAndImages = By.xpath("//a[contains(text(),\"Unblock links and images\")]");
    public By clickOnLinkForMail = By.xpath("//strong[contains(text(),'${inviteLinkText}')]");

    public void launchInbox(String email) {
        genericFunctions.launchSpecificURL(mailsacUrl+"/inbox/"+email);
    }

    public void navigateToEmail(String indentifierText,int flag) {
        By by = null;
        if(flag == 0) {
            by = parameterizedLocator(messageSubjectLocator, indentifierText);
        } else {
            by = parameterizedLocator(messageSenderAddress, indentifierText);
        }
        jsUtil.scrollDown(by);
        click(by);
    }

    public void getDirtyUrl() {
        dirtyUrl = getAttribute(unblockLinksAndImages, "href");
    }

    public void openMessageWithDirtyURL() {
        driver.navigate().to(dirtyUrl);
    }

    public void clickOnInviteLinkFromNaukri() {
        getElement(clickOnLinkForMail, inviteMailString).click();
    }

}
