package com.naukri.pageobjects.Applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.testng.TestNG;

import com.naukri.automation.util.BillingAPI;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;

public class ViewApplicationDetailPagePO extends PageObjectWrapper {

    private By stageStatusChangeDD = By.xpath("//a[contains(text(),'Reject')]/preceding-sibling::a/div");
    By eleOfferedOnDateCalender =By.xpath("//div[@class='offerDetail']//*[text()='${labelName}']/following::*[contains(@class,'calenderIcon')][1]");
    By eleDateInCalender = By.xpath("//div[@class='offerDetail' or @class='layOverContainer']//div[contains(@class,'DayPicker-Day') and (@aria-disabled = 'false' and text()='${date}')]");

    GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    BillingAPI billingApi = (BillingAPI) PageObjectWrapper.getObject(BillingAPI.class);

    public void goToViewApplicationDetailPage(String applicationId) {
        goToPageURL(ReadWritePropertyFile.getProperty("appURL", appUrlFile) + "/application/viewApplication/"
                + applicationId + "");
    }

    public void generateCandidateIdWithEmployerOfRMSConsultantviaAPI(String chargeMode, String chargeValue,int invoiceGenerationAfterDays, int payableAfterDays, String isTaxExempted) {
        String applicationId = billingApi.getCandidateIdWithEmployerOfRMSConsultant(chargeMode, chargeValue,invoiceGenerationAfterDays, payableAfterDays, Boolean.parseBoolean(isTaxExempted));
        goToViewApplicationDetailPage(applicationId);
    }

    public void changeCandidateStageStatus(String stage, String subStage) {
        jsUtil.scrollUp();
        hover(stageStatusChangeDD);
        mouseHoverAndClickToWebElement(getElement(stageStatusChangeDD));
        if(subStage.equalsIgnoreCase("")) {
            mouseHoverAndClickToWebElement(getElement(By.xpath("//ul[contains(@class,'statusNav')]/li/a[contains(text(),'" + stage
                    + "')]")));
        }else {
            mouseHoverAndClickToWebElement(getElement(By.xpath("//ul[contains(@class,'statusNav')]/li/a[contains(text(),'" + stage
                    + "')]/span[contains(text(),'" + subStage + "')]")));
        }
        wait.hardWait(5);
    }

    private String goToTextAreaOrInputTextBoxInViewContainer(String labelName, String fieldType) {
        return "//div[@class='offerDetail']//*[contains(text(),\"" + labelName + "\")]/following::" + fieldType + "[1]";
    }

    @SuppressWarnings("deprecation")
    private String selectDateInCalender(String dateToSelect) {
        SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(dateToSelect);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(currentDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(date);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        // System.out.println(diffMonth);
        if (diffMonth <= 0) {
            int x = diffMonth * -1;
            for (int i = 0; i < x; i++) {
                click(By.xpath("//div[@class='offerDetail' or @class='layOverContainer']//span[contains(@aria-label,'Previous Month')]"));
            }
            jsUtil.scrollDown(parameterizedLocator(eleDateInCalender, ""+date.getDate()));
            click(parameterizedLocator(eleDateInCalender, ""+date.getDate()));

        } else {
            for (int i = 0; i < diffMonth; i++) {
                click(By.xpath("//div[@class='offerDetail' or @class='layOverContainer']//span[contains(@aria-label,'Next Month')]"));
            }
            click(By.xpath(
                    "//div[@class='offerDetail' or @class='layOverContainer']//div[contains(@class,'DayPicker-Day') and (@aria-disabled = 'false' and text()='"
                            + date.getDate() + "')]"));
        }

        return dateToSelect;
    }

    @SuppressWarnings("deprecation")
    public String selectDateInCalender(String labelName, int daysToShift) {
        if (labelName.equalsIgnoreCase("special")){
            labelName="Candidate's tentative joining date";
            jsUtil.scrollDown(parameterizedLocator(eleOfferedOnDateCalender, labelName));
            click(parameterizedLocator(eleOfferedOnDateCalender, labelName));
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, daysToShift);
            SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
            TestNGLogUtility.info("date calculated " + formatter.format(cal.getTime()));
            return selectDateInCalender(formatter.format(cal.getTime()));
        }
        else if(labelName.equals("Paid On"))
        {
            click(By.xpath("//div[@class='layOverContainer']//*[text()=\"" + labelName
                    + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, daysToShift);
            SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
            return selectDateInCalender(formatter.format(cal.getTime()));
        }
        else if (getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, "span")))
                .contains("Choose Date")) {
            click(By.xpath("//div[@class='offerDetail']//*[text()=\"" + labelName
                    + "\"]/following::i[contains(@class,'calenderIcon')][1]"));
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, daysToShift);
            SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
            return selectDateInCalender(formatter.format(cal.getTime()));
        }
        else {
            click(By.xpath("//div[@class='offerDetail']//*[text()=\"" + labelName
                    + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
            String selected_date = getText(
                    By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, "span")));
            SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy");
            Calendar cal = Calendar.getInstance();
            try {
                cal.set(Calendar.DATE, format.parse(selected_date).getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.DATE, daysToShift);
            return selectDateInCalender(format.format(cal.getTime()));
        }

    }

    public String fillTextAreaOrInputTextBoxInViewContainer(String value, String labelName, String fieldType) {
        if(labelName.equalsIgnoreCase("Candidate's Billable salary")) {
            jsUtil.scrollDown(By.xpath(goToTextAreaOrInputTextBoxInViewContainer("Candidate's joining salary", fieldType)));
        }
        sendKeys(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)), value);
        return value;
    }

    public void moveCandidateToBillingStage(String designation, String joiningSalary, int offeredDateShiftFromToday, String billabeSalary, int tentativeJoiningDateShiftFromToday) {
        wait.waitForValignWrapperToDisappear(10, 3);
        fillTextAreaOrInputTextBoxInViewContainer(designation, "Offered Designation", "input");
        fillTextAreaOrInputTextBoxInViewContainer(joiningSalary, "Candidate's joining salary", "input");
        selectDateInCalender("Offered on", offeredDateShiftFromToday);
        fillTextAreaOrInputTextBoxInViewContainer(billabeSalary, "Candidate's Billable salary", "input");
        selectDateInCalender("Candidate's tentative joining date", tentativeJoiningDateShiftFromToday);
        clickOnElementInFooter("Next");
        clickOnElementInFooter("Skip");
    }

    private String goToDDValueInViewContainer(String labelName, String value) {
        return "//div[@class='offerDetail']//*[text()=\"" + labelName + "\"]/following::span[contains(text(),\""
                + value + "\")]/parent::li";
    }

    public void selectValueFromDDInViewContainer(String ddLabel, String value, String ddClassType) {
        click(By.xpath("(//div[@class='offerDetail']//*[text()=\"" + ddLabel + "\"]/following::div[contains(@class,\""
                + ddClassType + "\")]/div[@class=\"select-controller\"])[1]"));
        click(By.xpath(goToDDValueInViewContainer(ddLabel, value)));
    }

    public String goToElementContainingTextInFooter(String labelName) {
        return "//div[@class='foot']//*[text()='" + labelName + "']";
    }

    public void clickOnElementInFooter(String textValue) {
        hover(By.xpath(goToElementContainingTextInFooter(textValue)));
        click(By.xpath(goToElementContainingTextInFooter(textValue)));
        if(textValue.equalsIgnoreCase("Skip")) {
            wait.hardWait(5);
        }
    }

    public String getElementValueOfStageStatusChange(String label) {
        String value;
        if (label.contains("Offer made for")) {
            value = getText(By.xpath("(//*[contains(text(),'" + label + "')]/descendant::span)[1]"));
        } else {
            value = getText(By.xpath("(//*[contains(text(),'" + label + "')]/following-sibling::span)[1]"));
        }
        return value;
    }
}
