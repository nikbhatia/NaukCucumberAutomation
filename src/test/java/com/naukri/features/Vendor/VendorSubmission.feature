Feature: Vendor Candidate Submission




  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSVendorNewSubmission @E2E
  Scenario: Verify that recruiter is able to see all the options available for vendor on requirement overview page of recruiter
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise2" user
    When  User Add single profile with new requirement
    Then  Verify the new options for Vendor
      |Messages|Edit Assignment Details|Unassign|Send Reminder |


  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSVendorNewSubmission @E2E
  Scenario: Verify that vendor is able to submit candidate against the requirement assigned by recruiter
    Given  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When   User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    And  User submit candidate on Vendor portal
    And  Vendor submit the resume of candidate
    Then Verify that Vendor is able to view the Success message


  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSVendorNewSubmission @E2E
  Scenario: Verify that Employer is able to change the stage of candidate to"Applied - Matching" and Vendor is able to see it in pipeline
    And   User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And  User Select specific requirement on Requirement list page
    And  User click on application count
    And   User clicks on the vendor submitted candidate on SRP Page
    And   User Move the Candidate profile  to "Applied - Matching"
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed

    Then  Verify that user is able to see updated staging "Applied - Matching" in pipeline

  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSVendorNewSubmission @E2E
  Scenario: Verify that Employer is able to change the stage of candidate to "Interview - Round 1" and Vendor is able to see it in pipeline
    Given   User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User click on application count
    And   User clicks on the vendor submitted candidate on SRP Page
    And   User Move the Candidate profile  to "Interview - Round 1"
    And   User Set The Interview Details
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed

    Then  Verify that user is able to see updated staging "Interview - Round 1" in pipeline

  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to see vendor's options and able to click on the same
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User Clicks on "Edit Assignment Details" for "prashant.emlh@y..." on Requirement Overview page
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "UPDATE" button in conformation box
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    And  User is able to click on below options
      |Requirement Details|Messages|Instructions|Questionnaire|


  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to send message via message tab on vendor portal
    Given  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    When  User is able to click on below options
      |Messages|
    And  User sends message to employer "Hi,This is Vendor" from Vendor Portal
    And  User clicks on "Send" button in conformation box
    Then User Verify the message "Hi,This is Vendor"

  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to verify the subheadings inside Instruction tab
    Given  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    When  User is able to click on below options
      |Instructions|
    And  Verify "Instructions" is displayed as Subheading
    And  Verify "Maximum Number of CVs Allowed" is displayed as Subheading
    And  Verify "Last Day of Submission" is displayed as Subheading


  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to verify the no of max cv is same as send by recruiter inside Instruction tab
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User Clicks on "Edit Assignment Details" for "prashant.emlh@y..." on Requirement Overview page
    And  User adds maxCv "40" for Vendor on Assign Requirement To Vendor
    And  User clicks on "UPDATE" button in conformation box
    Then Verify the success message is displayed on Requirement Overview page
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    When  User is able to click on below options
      |Instructions|
    Then  Verify "Maximum Number of CVs Allowed" is displayed as Subheading
    And  Verify "40" is displayed inside "Maximum Number of CVs Allowed" tab sent by recuriter

  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to verify the instruction send by recruiter  is displayed inside Instruction tab
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    When User is able to click on below options
      |Instructions|
    Then Verify "Instructions" is displayed as Subheading
    And Verify "instructions" is displayed inside "Instructions" tab sent by recuriter

  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to verify the message sent by recruiter on vendorPortal under message tab and recruiter name as well
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User Clicks on "Edit Assignment Details" for "prashant.emlh@y..." on Requirement Overview page
    And  User adds maxCv "40" for Vendor on Assign Requirement To Vendor
    And  User clicks on "UPDATE" button in conformation box
    Then Verify the success message is displayed on Requirement Overview page
    When User Clicks on "Message" for "prashant.emlh@y..." on Requirement Overview page
    And  User clicks on "Send" button in conformation box
    Then Verify that message added to Overview Page
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    When  User is able to click on below options
      |Messages|
    Then  Verify "First message to vendor" is displayed inside "Message" tab sent by recuriter
    And  Verify user is able to see recruiter name "Avinash Singh" in the message tab

  @RMS   @RMSVendor @RMSVendorSubmission @RMSNewMessageSection @RMSSubmission @RMSVendorNewSubmission
  Scenario: Verify that on Vendor Portal user is able to verify the placeholder message inside message tab on Vendor Portal
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User Clicks on "Message" for "prashant.emlh@y..." on Requirement Overview page
    And  User clicks on "Send" button in conformation box
    Then Verify that message added to Overview Page
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    Then  Verify user is able to see below options
      |Requirement Details|Messages|Instructions|Questionnaire|
    When  User is able to click on below options
      |Messages|
    And  Verify User is able to see "Start typing your message to the client here. They will receive a notification for your message." in placeholder in message text box



