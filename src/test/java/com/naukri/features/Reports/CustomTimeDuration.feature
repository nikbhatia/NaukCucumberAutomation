@tag
Feature: Pre-Configured ReportsTimeDuration
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"

  @id:1 @ReportsTimeDuration @Rms @RmsReports
  Scenario: To verify that user is able to change the time duration and text is also displayed accordingly,
    To verify the visibility of monthly and quartely duration options and frequency options in SaveAndSchedule,
    and to verify the options available for Time Duration DropDow

    When User goes to the "RecruitmentActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Time Duration DropDown
    When User selects "Current Quarter" from Time Duration DropDown
    When User clicks on Time Duration DropDown
    Then User verifies the elements of the time duration DropDown
    When User selects "Current Quarter" from Time Duration DropDown
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that user is able to select "Current Quarter" and text is displayed accordingly
    When User clicks on Time Duration DropDown
    When User selects "Current Month" from Time Duration DropDown
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that user is able to select "Current Month" and text is displayed accordingly
    When User clicks on SaveSchedule on detailed Report and return report name
    When User clicks on "Schedule this report" checkbox
    When User clicks on Report Time Period Options
    When User selects "Quarterly" Report Time Period
    Then User Verifies the Frequency Options
      | Daily     |
      | Weekly    |
      | Monthly   |
      | Quarterly |
    When User clicks on Report Time Period Options
    When User selects "Monthly" Report Time Period
    Then User Verifies the Frequency Options
      | Daily   |
      | Weekly  |
      | Monthly |

  @id:2 @ReportsTimeDuration @Rms @RmsReports
  Scenario: To verify that user is able to change the custom time duration and text is also displayed accordingly
    When User goes to the "RecruitmentActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Time Duration DropDown
    When User selects "Current Quarter" from Time Duration DropDown
    When User clicks on Time Duration DropDown
    When User selects "Choose Custom Time Period" from Time Duration DropDown
    When User selects the custom from and to Dates
    Then Verify that data is visible according to custom time duration selected
