/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naukri.automation.util;

import com.naukri.test.base.BaseAutomation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vikash.agrawal
 */
public class URLBuilder {

    public static Map<String, String> endPoints = new HashMap<String, String>();

    public static void setEndPoint() {
        endPoints.put("rmsDashboardPage", "/admin/dashboard");
        endPoints.put("billingDashboard", "/billing/dashboard");
        endPoints.put("applicationInbox", "/profile/application/inbox");
        endPoints.put("requirementInbox", "/project/list");
        endPoints.put("templateListingPage", "/mailTemplate/list");
        endPoints.put("settingsPage", "/admin/settings");
        endPoints.put("backupInboxPage", "/profile/inbox/BackedUp");
        endPoints.put("excelUploadPage", "/uploadCandidate/excelUploadAdd");
        endPoints.put("multipleFilesUploadPage", "/uploadCandidate/multiUploaderForm");
        endPoints.put("bulkUploadPage", "/uploadCandidate/bulkUpload");
        endPoints.put("advancedSearchURL", "/profile/search");
        endPoints.put("profileListingInbox", "/profile/inbox");
        endPoints.put("logoutPage", "/logout");
        endPoints.put("addSingleProfile", "/application/addCandidate");
        endPoints.put("cvDetailsPage", "/application/viewApplication");
        endPoints.put("groupListing", "/employer/list");
        endPoints.put("candidateDetailsPage", "/application/viewCandidate/");
        endPoints.put("VendorPortal", "/vendorportal/5099656");
        endPoints.put("RMSHMRequisitionList", "/requisition/showList");
        endPoints.put("RMSRequisitionList", "/requisition/list");
        endPoints.put("RMSRaiseRequisition", "/request/create");
        endPoints.put("addANewRequirement", "/project/create");
        endPoints.put("SelectionProcessSettings", "/status/manageApplicationStatus");
        endPoints.put("approvalTemplateListing", "/approvalTemplate/showList");
        endPoints.put("SalaryBreakupListing", "/offerGeneration/salary-breakup/list");
        endPoints.put("ProfileProjectInbox", "/project/inbox");
        endPoints.put("offerLogs", "/offers/logs");
        endPoints.put("ManageRecruiters", "/recruiter/manage?_REF=S");
        endPoints.put("ReportsPage", "/reports/scheduleList");
        endPoints.put("offerDoclisting", "/offerGeneration/offer-document-template/list");
        endPoints.put("clientTracker", "/downloadTracker/list");
        endPoints.put("reportsDashboard", "/rms-reports/dashboard");
        endPoints.put("reportsSaveSchedule", "/rms-reports/list");
        endPoints.put("RequirementTAT", "/rms-reports/tat");
        endPoints.put("reportsStageLevelTAT", "/rms-reports/custom-tat");
        endPoints.put("reportsRequisitionTAT", "/rms-reports/requisitionTat");
        endPoints.put("reportsRequisitionOverview", "/rms-reports/requisitionOverview");
        endPoints.put("reportsRequirementFunnel", "/rms-reports/conversion");
        endPoints.put("reportsStageLevelFunnel", "rms-reports/custom-conversion");
        endPoints.put("reportsRequirementAging", "/rms-reports/requirementAging");
        endPoints.put("reportsRequirementCreation", "/rms-reports/requirementCreation");
        endPoints.put("reportsSourcePerformance", "/rms-reports/sourcePerformance");
        endPoints.put("reportsVendorPerformance", "/rms-reports/vendorPerformance");
        endPoints.put("reportsHiringManagerActivity", "/rms-reports/hmReport");
        endPoints.put("reportsCandidateActivity", "/rms-reports/candidateActivity");
        endPoints.put("reportsRecruitmentActivity", "/rms-reports/recruitmentActivity");
        endPoints.put("createFolder", "/folder/list/create");
        endPoints.put("hiringManagerDashboard", "/HiringManager/dashboard");
        endPoints.put("CCInboxPage","/mail/inbox");
        endPoints.put("MNRManageSubuser", "/company/subuser");
        endPoints.put("specificCVDetailPage","/application/viewApplication/261497");
        endPoints.put("ManageUsersPage","/vendorportal/5099656/users");
        endPoints.put("mailerSettings","/admin/mailerSettings");
        endPoints.put("HMAllApplication", "/profile/feed");
    }



    public static String getEndPoint(String moduleName) {
        setEndPoint();
        return endPoints.get(moduleName);
    }
    /**
     * @author vikash.agrawal
     * @param moduleName
     * @return Page URL {String} This method will return page URL according to
     * the module name, if environment is test then it will replace the name
     * space according to the Maven value or configuration file
     */
    public static String getURL(String moduleName) {
        String baseURL = YamlReader.getAppConfigValue("URLs.baseURL");
        String environment = System.getProperty("testEnvironment");
        if (environment == null || environment.isEmpty()) {
            environment = ReadWritePropertyFile.getProperty("testEnvironment", BaseAutomation.configFile);
        }
        if (environment.equalsIgnoreCase("test")) {
            String nameSpace = System.getProperty("nameSpace");
            if ((nameSpace == null) || (nameSpace.isEmpty())) {
                nameSpace = ReadWritePropertyFile.getProperty("nameSpace", BaseAutomation.configFile);
            }
            baseURL = baseURL.replaceFirst("naukri-test2", nameSpace);
            TestNGLogUtility.info("URL: " + baseURL);
        }
        baseURL = baseURL + getEndPoint(moduleName);
        return baseURL;
    }
}
