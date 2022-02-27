@tag
Feature: SavedScheduleReportsSmoke
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user

  @id:1 @SavedScheduledReport @Rms @RmsReports
  Scenario: To verify that user is not able to schedule the report with a wrong emailId and to verify the list of recruiters visible while sharing the report
    When User goes to the "ManageRecruiters" Page
    When User gets the list of all the recruiters
    When User goes to the "RequirementTAT" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on SaveSchedule on detailed Report and return report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Mail text area
    When User enters a wrong mail ID
    When User clicks on Save button in saveSchedulePopUp
    Then Verify that user is able to see the Error message for invalid EmailId
    When User clicks on Mail text area
    When User clicks on "Share this report" checkbox
    When User clicks on Mail text area
    Then Verify that the options in list while scheduling contains all recruiter names

  @id:2 @SavedScheduledReport @Rms @RmsReports
  Scenario: Verify that confirmation message is displayed when reports are scheduled monthly and to Verify the elements for scheduled report on listing page and also verify the scheduled clock icon
    When User goes to the "RequirementTAT" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on "monthly" frequency in SaveSchedulePopUp
    And User clicks on Save button in saveSchedulePopUp
    Then Verify that confirmation message is displayed when the report is scheduled
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that Required Scheduled icon is visible against the recent scheduled report
    When User mousehovers on the first saved report name on listing page
    When User mousehovers on icon ellipses against a saved report on listing page
    Then Verify that options in the ellipses of savedOrScheduled report are DropDown are as per the requirement
      | Download |
      | Edit     |
      | Delete   |
    When User clicks on first Report from list
    When User switches to new window
    Then User verifies that time duration of the saved report should be "Current Month"

  @id:3 @SavedScheduledReport @Rms @RmsReports
  Scenario: To verify the column names on savedScheduled listing page Verify that the report can be downloaded from listing page
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the coloumn names of listing page are as per the requirement
      | Report Name |
      | Type        |
      | Created On  |
      | Created By  |
      | Shared With |
    When User mousehovers on the first saved report name on listing page
    When User mousehovers on icon ellipses against a saved report on listing page
    When User clicks on "Download" on listing page
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:4 @SavedScheduledReport @Rms @RmsReports
  Scenario: Verify that Settings and filters information is displayed when a report is saved or scheduled and to also verify that report can be downloaded when the saved report is opened
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Settings Icon in detailed report
    When User selects "conversionReportFirststage" setting
    When User clicks on Filter Icon
    And User clicks on "Requirement status" Filter option
    And User selects "Open" filter label
    And User clicks on Refine Filters
    When User clicks on SaveSchedule on detailed Report and return report name
    Then Verify that "First Stage" should be visible in the SaveSchedule popup
    And User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on first Report from list
    And User switches to new window
    Then User verifies that expected filters that are applied are visible as tag in the saved report
      | Open |
    When User clicks on Download on detailed Report
    And User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:5 @SavedScheduledReport @Rms @RmsReports
  Scenario: Verify the elements for saved report on listing page and to verify the edit functionality of the saved report
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    When User mousehovers on the first saved report name on listing page
    When User mousehovers on icon ellipses against a saved report on listing page
    Then Verify that options in the ellipses of savedOrScheduled report are DropDown are as per the requirement
      | Download       |
      | Share/Schedule |
      | Delete         |
    When User clicks on "Share/Schedule" on listing page
    Then Verify that Edit pop-up opens up
    Then Verify that user is able to Edit any saved report

  @id:6 @SavedScheduledReport @Rms @RmsReports
  Scenario: To Verify if the saved and scheduled reports are loaded when opened from dashboard page as well as listing page.
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User goes to the "Dashboard" Report
    And User gets the first saved report name from Dashboard
    And User clicks on first report from the SaveSchedule report widget
    And User switches to new window
    Then Verify that the expected saved report has opened

  @id:7 @SavedScheduledReport @Rms @RmsReports
  Scenario: Verify that Correct emailId is visible on listing page when the report is shared and to also verify that dupliacte reports are not saved when scheduling a report and to verify that user is able to delete a saved report
    When User goes to the "RequirementAging" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Mail text area
    And User chooses a mailID from the available DD options and also get the mail ID Text of the chosen one
    And User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the Id in the first sharedWith field is same as the emailIdText chosen earlier
    Then Verify that the names of first two reports should be different
    When User gets the first saved report name from List
    When User mousehovers on the first saved report name on listing page
    When User mousehovers on icon ellipses against a saved report on listing page
    When User clicks on "Delete" on listing page
    When User clicks on "Delete" button on the delete conformation box
    When User verifies that the report has been deleted successfully

  @id:8 @SavedScheduledReport @Rms @RmsReports
  Scenario: Verify the functionalities of a report that is shared with another RMS user
    When User goes to the "RequirementAging" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Share this report" checkbox
    And User selects email "enterprise2_subuser1@yopmail.com" from the available list of RMS users
    And User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on first Report from list
    And User switches to new window
    Then User verifies that expected filters that are applied are visible as tag in the saved report
      | Open    |
      | On Hold |
    When User clears the "Open" applied filter
    And User clicks on Save option for saving the new filters in the saved report
    Then User verifies that expected filters that are applied are visible as tag in the saved report
      | On Hold |
    When User goes to the "RMSLogout" Page
    When User login to the application "rmsDashboardPage" using "Subuser" of "Enterprise2" user
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    When User mousehovers on the first saved report name on listing page
    When User mousehovers on icon ellipses against a saved report on listing page
    Then Verify that options in the ellipses of savedOrScheduled report are DropDown are as per the requirement
      | Download |
    When User clicks on first Report from list
    And User switches to new window
    Then User verifies that expected filters that are applied are visible as tag in the saved report
      | On Hold |
    When User clears the "On Hold" applied filter
    Then User verifies that no save option is visible to the person who has not created the report

