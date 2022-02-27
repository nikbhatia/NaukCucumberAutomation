Feature: RMS Pre-Configured Reports Dashboard
  Author: srissti.tyagi@naukri.com
  Modified By: lokesh.agrawal@naukri.com

  @id:1 @RmsReports @RmsReportsSmoke @Rms @Smoke
  Scenario: To verify presence of all Reports with URL on Dashboard All Reports DropDown for Enterprise Account
    Given User logs in to Rms from "Enterprise" account as a "Superuser"
    When User goes to the "Dashboard" Report
    And User clicks on the Drop Down list of reports name
    Then User verifies Name of All Visible Reports
      | All Reports               |
      | Saved & Scheduled         |
      | Turn Around Time Reports  |
      | Conversion Funnel Reports |
      | Requisition Overview      |
      | Requirement Reports       |
      | Performance Reports       |
      | Activity Reports          |
    And User verifies name and navigation URL of reports
      | All Reports                | https://rms.naukri.com/rms-reports/dashboard?recentReportsDashboard=0           |
      | Saved & Scheduled          | https://rms.naukri.com/rms-reports/list?recentReportsDashboard=0                |
      | Requirement TAT            | https://rms.naukri.com/rms-reports/tat?recentReportsDashboard=0                 |
      | Stage Level TAT            | https://rms.naukri.com/rms-reports/custom-tat?recentReportsDashboard=0          |
      | Requisition TAT            | https://rms.naukri.com/rms-reports/requisitionTat?recentReportsDashboard=0      |
      | Requirement Funnel         | https://rms.naukri.com/rms-reports/conversion?recentReportsDashboard=0          |
      | Stage Level Funnel         | https://rms.naukri.com/rms-reports/custom-conversion?recentReportsDashboard=0   |
      | Requisition Overview       | https://rms.naukri.com/rms-reports/requisitionOverview?recentReportsDashboard=0 |
      | Requirement Aging          | https://rms.naukri.com/rms-reports/requirementAging?recentReportsDashboard=0    |
      | Requirement Creation       | https://rms.naukri.com/rms-reports/requirementCreation?recentReportsDashboard=0 |
      | Overall Source Performance | https://rms.naukri.com/rms-reports/sourcePerformance?recentReportsDashboard=0   |
      | Vendor Performance         | https://rms.naukri.com/rms-reports/vendorPerformance?recentReportsDashboard=0   |
      | Recruitment Activity       | https://rms.naukri.com/rms-reports/recruitmentActivity?recentReportsDashboard=0 |
      | Hiring Manager Activity    | https://rms.naukri.com/rms-reports/hmReport?recentReportsDashboard=0            |
      | Candidate Activity Report  | https://rms.naukri.com/rms-reports/candidateActivity?recentReportsDashboard=0   |

  @id:2 @RmsReports @Rms
  Scenario: To verify presence of all Reports with URL on Dashboard All Reports DropDown for ProConsultant Account
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"
    When User goes to the "Dashboard" Report
    And User clicks on the Drop Down list of reports name
    Then User verifies Name of All Visible Reports
      | All Reports               |
      | Saved & Scheduled         |
      | Turn Around Time Reports  |
      | Conversion Funnel Reports |
      | Requirement Reports       |
      | Performance Reports       |
      | Activity Reports          |
      | Invoicing Reports         |
    And User verifies name and navigation URL of reports
      | All Reports                | https://rms.naukri.com/rms-reports/dashboard?recentReportsDashboard=0           |
      | Saved & Scheduled          | https://rms.naukri.com/rms-reports/list?recentReportsDashboard=0                |
      | Requirement TAT            | https://rms.naukri.com/rms-reports/tat?recentReportsDashboard=0                 |
      | Stage Level TAT            | https://rms.naukri.com/rms-reports/custom-tat?recentReportsDashboard=0          |
      | Requirement Funnel         | https://rms.naukri.com/rms-reports/conversion?recentReportsDashboard=0          |
      | Stage Level Funnel         | https://rms.naukri.com/rms-reports/custom-conversion?recentReportsDashboard=0   |
      | Requirement Aging          | https://rms.naukri.com/rms-reports/requirementAging?recentReportsDashboard=0    |
      | Requirement Creation       | https://rms.naukri.com/rms-reports/requirementCreation?recentReportsDashboard=0 |
      | Overall Source Performance | https://rms.naukri.com/rms-reports/sourcePerformance?recentReportsDashboard=0   |
      | Vendor Performance         | https://rms.naukri.com/rms-reports/vendorPerformance?recentReportsDashboard=0   |
      | Recruitment Activity       | https://rms.naukri.com/rms-reports/recruitmentActivity?recentReportsDashboard=0 |
      | Candidate Activity Report  | https://rms.naukri.com/rms-reports/candidateActivity?recentReportsDashboard=0   |
      | Pending Invoices Report    | https://rms.naukri.com/rms-reports/invoices?recentReportsDashboard=0            |
      | Cash Flow Report           | https://rms.naukri.com/rms-reports/cash-flow?recentReportsDashboard=0           |
      | Tax Report                 | https://rms.naukri.com/rms-reports/tax-collection?recentReportsDashboard=0      |

  @id:3 @RmsReports @Rms @Smoke
  Scenario: To verify presence of all Reports with URL on Dashboard All Reports DropDown for Company Account
    Given User logs in to Rms from "Company" account as a "Superuser"
    When User goes to the "Dashboard" Report
    And User clicks on the Drop Down list of reports name
    Then User verifies Name of All Visible Reports
      | All Reports               |
      | Saved & Scheduled         |
      | Turn Around Time Reports  |
      | Conversion Funnel Reports |
      | Requirement Reports       |
      | Performance Reports       |
      | Activity Reports          |
    And User verifies name and navigation URL of reports
      | All Reports                | https://rms.naukri.com/rms-reports/dashboard?recentReportsDashboard=0           |
      | Saved & Scheduled          | https://rms.naukri.com/rms-reports/list?recentReportsDashboard=0                |
      | Requirement TAT            | https://rms.naukri.com/rms-reports/tat?recentReportsDashboard=0                 |
      | Stage Level TAT            | https://rms.naukri.com/rms-reports/custom-tat?recentReportsDashboard=0          |
      | Requirement Funnel         | https://rms.naukri.com/rms-reports/conversion?recentReportsDashboard=0          |
      | Stage Level Funnel         | https://rms.naukri.com/rms-reports/custom-conversion?recentReportsDashboard=0   |
      | Requirement Aging          | https://rms.naukri.com/rms-reports/requirementAging?recentReportsDashboard=0    |
      | Requirement Creation       | https://rms.naukri.com/rms-reports/requirementCreation?recentReportsDashboard=0 |
      | Overall Source Performance | https://rms.naukri.com/rms-reports/sourcePerformance?recentReportsDashboard=0   |
      | Vendor Performance         | https://rms.naukri.com/rms-reports/vendorPerformance?recentReportsDashboard=0   |
      | Recruitment Activity       | https://rms.naukri.com/rms-reports/recruitmentActivity?recentReportsDashboard=0 |
      | Candidate Activity Report  | https://rms.naukri.com/rms-reports/candidateActivity?recentReportsDashboard=0   |

  @wip
  Scenario: To verify presence of all Reports with URL on Dashboard All Reports DropDown for Hiring Manager
    Given User logs in to Rms from "Enterprise" account as a "hmSpoc"
    When User goes to the "Dashboard" Report
    And User clicks on the Drop Down list of reports name
    Then User verifies Name of All Visible Reports
      | All Reports               |
      | Saved & Scheduled         |
      | Turn Around Time Reports  |
      | Conversion Funnel Reports |
      | Requisition Overview      |
      | Requirement Reports       |
    And User verifies name and navigation URL of reports
      | All Reports                | https://rms.naukri.com/rms-reports/dashboard           |
      | Saved & Scheduled          | https://rms.naukri.com/rms-reports/list                |
      | Requirement TAT            | https://rms.naukri.com/rms-reports/tat                 |
      | Stage Level TAT            | https://rms.naukri.com/rms-reports/custom-tat          |
      | Requisition TAT            | https://rms.naukri.com/rms-reports/requisitionTat      |
      | Requirement Funnel         | https://rms.naukri.com/rms-reports/conversion          |
      | Stage Level Funnel         | https://rms.naukri.com/rms-reports/custom-conversion   |
      | Requisition Overview       | https://rms.naukri.com/rms-reports/requisitionOverview |
      | Requirement Aging          | https://rms.naukri.com/rms-reports/requirementAging    |
      | Requirement Creation       | https://rms.naukri.com/rms-reports/requirementCreation |
      | Overall Source Performance | https://rms.naukri.com/rms-reports/sourcePerformance   |
      | Vendor Performance         | https://rms.naukri.com/rms-reports/vendorPerformance   |
      | Recruitment Activity       | https://rms.naukri.com/rms-reports/recruitmentActivity |
      | Hiring Manager Activity    | https://rms.naukri.com/rms-reports/hmReport            |
      | Candidate Activity Report  | https://rms.naukri.com/rms-reports/candidateActivity   |

  @id:4 @ConversionFunnnelReport @RmsReports @Rms
  Scenario: To verify the functionalities of Requirement FUnnel report on the dashboard
    Given User logs in to Rms from "Company" account as a "Superuser"
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Funnel" report has loaded first on dashboard
    Then User verifies the summary elements of "Requirement Funnel" Report on dashboard
      | Sourced     |
      | Contacted   |
      | Forwarded   |
      | Interviewed |
      | Offered     |
      | Joined      |
    When User hovers on the info icon against the "Requirement Funnel" Report on Dashboard
    Then User verifies the information visible when hovered over the "infoIconTooltipforRequirementFunnel" Report on Dashboard
    When User hovers on "contacted" column name in "Requirement Funnel" Report on dashboard
    Then Verify the "contactedColumnToolTip" in "Requirement Funnel" Report on dashboard
    When User hovers on "forwarded" column name in "Requirement Funnel" Report on dashboard
    Then Verify the "forwardedColumnToolTip" in "Requirement Funnel" Report on dashboard
    When User hovers on "interviewed" column name in "Requirement Funnel" Report on dashboard
    Then Verify the "interviewedColumnToolTip" in "Requirement Funnel" Report on dashboard
    When User hovers on "offered" column name in "Requirement Funnel" Report on dashboard
    Then Verify the "offeredColumnToolTip" in "Requirement Funnel" Report on dashboard
    When User hovers on "joined" column name in "Requirement Funnel" Report on dashboard
    Then Verify the "joinedColumnToolTip" in "Requirement Funnel" Report on dashboard
    When User clicks on "Requirements" subTab for "Requirement Funnel" report on dashboard
    Then Verify that data in "Requirement Funnel" report is visible according to the "Requirements" subtab
    When User clicks on "Groups" subTab for "Requirement Funnel" report on dashboard
    Then Verify that data in "Requirement Funnel" report is visible according to the "Groups" subtab
    When User clicks on Settings Icon for "Requirement Funnel" Report on Dashboard
    Then User verifies the elements under Settings Icon in "Requirement Funnel" Report on Dashboard
    When User clicks on Icon Ellipses for "Requirement Funnel" Report on dashboard
    When User clicks on SaveSchedule option for "Requirement Funnel" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Funnel" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requirement Funnel" Report
    Then User verifies that "Requirement Funnel" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Funnel" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requirement Funnel" Report on dashboard
    When User clicks on DownloadThisReport option for "Requirement Funnel" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:5 @ConversionFunnnelReport @RmsReports @Rms
  Scenario: To verify that Stage Level Funnel Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"
    When User goes to the "SelectionProcessSettings" Page
    When User gets all the stages present in the system
    When User goes to the "Dashboard" Report
    Then User verifies that the "Stage Level Funnel" report has loaded first on dashboard
    When User clicks on Settings Icon for "Stage Level Funnel" Report on Dashboard
    Then User verifies the elements under Settings Icon in "Stage Level Funnel" Report on Dashboard
    When User clicks on "Requirements" subTab for "Stage Level Funnel" report on dashboard
    Then Verify that data in "Stage Level Funnel" report is visible according to the "Requirements" subtab
    When User clicks on "Employers" subTab for "Stage Level Funnel" report on dashboard
    Then Verify that data in "Stage Level Funnel" report is visible according to the "Employers" subtab
    When User clicks on Icon Ellipses for "Stage Level Funnel" Report on dashboard
    When User clicks on SaveSchedule option for "Stage Level Funnel" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Stage Level Funnel" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Stage Level Funnel" Report
    Then User verifies that "Stage Level Funnel" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Stage Level Funnel" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Stage Level Funnel" Report on dashboard
    When User clicks on DownloadThisReport option for "Stage Level Funnel" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:6 @PerformanceReport @RmsReports @Rms
  Scenario: To verify that Overall Source Performance Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"
    When User goes to the "Dashboard" Report
    Then User verifies that the "Overall Source Performance" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Overall Source Performance" Report on dashboard
    When User clicks on SaveSchedule option for "Overall Source Performance" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Overall Source Performance" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Overall Source Performance" Report
    Then User verifies that "Overall Source Performance" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Overall Source Performance" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Overall Source Performance" Report on dashboard
    When User clicks on DownloadThisReport option for "Overall Source Performance" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:7 @PerformanceReport @RmsReports @Rms
  Scenario: To verify that Vendor Performance Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"
    When User goes to the "Dashboard" Report
    Then User verifies that the "Vendor Performance" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Vendor Performance" Report on dashboard
    When User clicks on SaveSchedule option for "Vendor Performance" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Vendor Performance" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Vendor Performance" Report
    Then User verifies that "Vendor Performance" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Vendor Performance" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Vendor Performance" Report on dashboard
    When User clicks on DownloadThisReport option for "Vendor Performance" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:8 @RequirementReport @RmsReports @Rms
  Scenario: To verify that Requirement Aging Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Aging" report has loaded first on dashboard
    Then User verifies the summary elements of "Requirement Aging" Report on dashboard
      | 0-1 month  |
      | 1-3 month  |
      | 3-6 month  |
      | 6-12 month |
      | >1 year    |
    When User clicks on Icon Ellipses for "Requirement Aging" Report on dashboard
    When User clicks on SaveSchedule option for "Requirement Aging" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Aging" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requirement Aging" Report
    Then User verifies that "Requirement Aging" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Aging" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requirement Aging" Report on dashboard
    When User clicks on DownloadThisReport option for "Requirement Aging" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:9 @RequirementReport @RmsReports @Rms
  Scenario: To verify that Requirement Creation Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Creation" report has loaded first on dashboard
    Then User verifies the summary elements of "Requirement Creation" Report on dashboard
      | Requirements Created |
      | Groups               |
      | Requirements Closed  |
      | Groups               |
    Then User verifies the tabs visible in "Requirement Creation" Report on dashboard
      | GROUPS     |
      | RECRUITERS |
    Then User verifies the Division label in "Requirement Creation" Report on dashboard
    When User clicks on Icon Ellipses for "Requirement Creation" Report on dashboard
    When User clicks on SaveSchedule option for "Requirement Creation" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Creation" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requirement Creation" Report
    Then User verifies that "Requirement Creation" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement Creation" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requirement Creation" Report on dashboard
    When User clicks on DownloadThisReport option for "Requirement Creation" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:10 @RequisitionReport @RmsReports @Rms
  Scenario: To verify that Requisition Overview Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requisition Overview" report has loaded first on dashboard
    Then User verifies the summary elements of "Requisition Overview" Report on dashboard
      | Requisitions Created             |
      | Requisition Pending For Approval |
      | Requisition Withdrawn            |
      | Requirements Created             |
    Then User verifies the tabs visible in "Requisition Overview" Report on dashboard
      | GROUPS  |
      | HR SPOC |
    Then User verifies the Division label in "Requisition Overview" Report on dashboard
    When User clicks on Icon Ellipses for "Requisition Overview" Report on dashboard
    When User clicks on SaveSchedule option for "Requisition Overview" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requisition Overview" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requisition Overview" Report
    Then User verifies that "Requisition Overview" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requisition Overview" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requisition Overview" Report on dashboard
    When User clicks on DownloadThisReport option for "Requisition Overview" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:11 @RequisitionReport @RmsReports @Rms
  Scenario: To verify that Requisition TAT Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requisition TAT" report has loaded first on dashboard
    Then User verifies the tabs visible in "Requisition TAT" Report on dashboard
      | REQUISITIONS |
      | GROUPS       |
    When User clicks on Icon Ellipses for "Requisition TAT" Report on dashboard
    When User clicks on SaveSchedule option for "Requisition TAT" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requisition TAT" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requisition TAT" Report
    Then User verifies that "Requisition TAT" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requisition TAT" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requisition TAT" Report on dashboard
    When User clicks on DownloadThisReport option for "Requisition TAT" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:12 @TatReport @RmsReports @Rms
  Scenario: To verify that Requirement TAT Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement TAT" report has loaded first on dashboard
    Then User verifies the summary elements of "Requirement TAT" Report on dashboard
      | Days To Source The First Candidate    |
      | Days To Contact The First Candidate   |
      | Days To Forward The First Candidate   |
      | Days To Interview The First Candidate |
    Then User verifies the tabs visible in "Requirement TAT" Report on dashboard
      | REQUIREMENTS |
      | GROUPS       |
    When User clicks on Icon Ellipses for "Requirement TAT" Report on dashboard
    When User clicks on SaveSchedule option for "Requirement TAT" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement TAT" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requirement TAT" Report
    Then User verifies that "Requirement TAT" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Requirement TAT" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requirement TAT" Report on dashboard
    When User clicks on DownloadThisReport option for "Requirement TAT" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:13 @TatReport @RmsReports @Rms
  Scenario: To verify that Stage Level TAT Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"
    When User goes to the "Dashboard" Report
    Then User verifies that the "Stage Level TAT" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Stage Level TAT" Report on dashboard
    When User clicks on SaveSchedule option for "Stage Level TAT" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Stage Level TAT" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Stage Level TAT" Report
    Then User verifies that "Stage Level TAT" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Stage Level TAT" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Stage Level TAT" Report on dashboard
    When User clicks on DownloadThisReport option for "Stage Level TAT" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:14 @ActivityReport @RmsReports @Rms
  Scenario: To verify that Recruitment Activity Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Recruitment Activity" report has loaded first on dashboard
    Then User verifies the summary elements of "Recruitment Activity" Report on dashboard
      | Sourced     |
      | Contacted   |
      | Forwarded   |
      | Interviewed |
      | Offered     |
      | Joined      |
    Then User verifies the tabs visible in "Recruitment Activity" Report on dashboard
      | REQUIREMENTS |
      | GROUPS       |
      | RECRUITERS   |
    When User clicks on Icon Ellipses for "Recruitment Activity" Report on dashboard
    When User clicks on SaveSchedule option for "Recruitment Activity" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Recruitment Activity" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Recruitment Activity" Report
    Then User verifies that "Recruitment Activity" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Recruitment Activity" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Recruitment Activity" Report on dashboard
    When User clicks on DownloadThisReport option for "Recruitment Activity" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:15 @ActivityReport @RmsReports @Rms
  Scenario: To verify that Hiring Manager Activity Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User goes to the "Dashboard" Report
    Then User verifies that the "Hiring Manager Activity" report has loaded first on dashboard
    Then User verifies the summary elements of "Hiring Manager Activity" Report on dashboard
      | Requisition Raised            |
      | Requisition Approved          |
      | Requisition Approval Pending  |
      | Interview Feedback Provided   |
      | Interview Feedback Pending    |
      | Offer Letter Approval Pending |
    When User clicks on Icon Ellipses for "Hiring Manager Activity" Report on dashboard
    When User clicks on SaveSchedule option for "Hiring Manager Activity" on dashboard and enter the unique report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Hiring Manager Activity" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Hiring Manager Activity" Report
    Then User verifies that "Hiring Manager Activity" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Hiring Manager Activity" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Hiring Manager Activity" Report on dashboard
    When User clicks on DownloadThisReport option for "Hiring Manager Activity" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:16 @ActivityReport @RmsReports @Rms
  Scenario: To verify that Candidate Activity Report Report can be downloaded, scheduled and viewed in detail from dashboard
    Given User logs in to Rms from "Company" account as a "Superuser"
    When User goes to the "Dashboard" Report
    Then User verifies that the "Candidate Activity Report" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Candidate Activity Report" Report on dashboard
    When User clicks on SaveSchedule option for "Candidate Activity Report" on dashboard and enter the unique report name
    When User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above
    When User goes to the "Dashboard" Report
    Then User verifies that the "Candidate Activity Report" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Candidate Activity Report" Report
    Then User verifies that "Candidate Activity Report" Report opens up
    When User goes to the "Dashboard" Report
    Then User verifies that the "Candidate Activity Report" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Candidate Activity Report" Report on dashboard
    When User clicks on DownloadThisReport option for "Candidate Activity Report" Report on dashboard
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
