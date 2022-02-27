Feature: Vendor Message Section

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:User is able to submit requirement
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise2" user
    When  User Add single profile with new requirement

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when vendor submits profile than user is able to see new Vendor Messages Heading,Name of Vendor as Subhead on Enterprise Cv details page
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User Select Specific Requirement on Vendor Portal
    And User submit candidate on Vendor portal
    And Vendor submit the resume of candidate
    And  User refresh the page till the time vendor candidate submitted is not displayed
    And  User click on Submitted Candidate Name
    And User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    Then Verify User is able to see "Employer Messages" on cv details page
    And Verify User is able to see "Naukri RMS" on cv details page
    And Verify User is able to see "Type your message to the employer" in placeholder for vendor message box

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSTabFeature @RMSNewMessageSectionAgain
  Scenario:Verify when vendor submits profile than user is able to see new Vendor Messages Heading,Name of Vendor as Subhead on Enterprise Cv details page
    Given  User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And  User Select specific requirement on Requirement list page
    And  User click on application count
    And  User clicks on the vendor submitted candidate on SRP Page
    And User reload the page.
    And Verify User is able to see "Vendor Messages" on cv details page
    And Verify User is able to see "prashant.emlh@yopmail.com" on cv details page
    And Verify User is able to see "Type your message to vendor" in placeholder for vendor message box


  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when vendor sends message from cv details page it should be visible in the send section and sender name should be Me(Vendor) on Vendor Cv details page and name of vendor as registered should be display in sender's section at recruiter's end
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed
    And User click on Submitted Candidate Name
    And User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    And User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor CV details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    And Verify "This Message is From Vendor CV details Page" message is displayed for vendor
    And Verify "Me(Vendor)" is displayed in the sender name
    When User click on "Go Back to Naukri/RMS" on vendorportal
    And  User click on "Logout" from settings options
    And User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And User Select specific requirement on Requirement list page
    And User click on application count
    And  User clicks on the vendor submitted candidate on SRP Page
    Then Verify "Prashant ka name b change krke badha dia (Vendor)" is displayed in the sender name


  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when vendor sends message from cv details page it should be visible on the SRP page message section as well
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed
    And User click on Submitted Candidate Name
    And User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    And User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor CV details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    And Verify "This Message is From Vendor CV details Page" message is displayed for vendor
    And User close the current tab and switch to parent tab
    And User clicks on message icon below the candidate submitted by vendor
    And Verify "This Message is From Vendor CV details Page" message is displayed for vendor

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when vendor sends message from the SRP page message it should be visible in the send messages on Cv details  page
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed
    And User clicks on message icon below the candidate submitted by vendor
    And User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor SRP details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    And User click on Submitted Candidate Name
    And User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    And Verify "This Message is From Vendor SRP details Page" message is displayed for vendor



  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify recruiter is able to send message from vendor message section available on cv details page for the candidate submitted by vendor
    Given  User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User click on application count
    And   User clicks on the vendor submitted candidate on SRP Page
    And   Verify User is able to see "Vendor Messages" on cv details page
    And   Verify User is able to see "prashant.emlh@yopmail.com" on cv details page
    And   Verify User is able to see "Type your message to vendor" in placeholder for vendor message box
    And   Verify "This Message is From Vendor CV details Page" message is displayed for vendor
    And   User click on "Type your message to vendor" on cv details page for vendor message
    And   User sends "This Message is From Recruiter CV details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    Then Verify "This Message is From Recruiter CV details Page" message is displayed for vendor
    And  Verify "Me" is displayed in the sender name
    When  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And  User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And  User Select Specific Requirement on Vendor Portal
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed
    And User click on Submitted Candidate Name
    And User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    Then Verify "Avinash Singh (Naukri RMS)" is displayed in the sender name

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when recruiter sends message from cv details page it should be visible on the CV details page on Vendor's end
    Given  User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    When  User Select specific requirement on Requirement list page
    And  User click on application count
    And   User clicks on the vendor submitted candidate on SRP Page
    And   User click on "Type your message to vendor" on cv details page for vendor message
    And   User sends "This Message is From Recruiter CV details Page" message to recruiter
    And   User clicks on "Send" button in conformation box
    And  User click on "Logout" from settings options
    And  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    And User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User Select Specific Requirement on Vendor Portal
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And User refresh the page till the time vendor candidate submitted is not displayed
    And User click on Submitted Candidate Name
    And User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    And Verify "This Message is From Recruiter CV details Page" message is displayed for vendor

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when recruiter submits profile than user is not able to see new Vendor Messages Heading,Name of Vendor as Subhead on Enterprise Cv details page
    Given  User login to the application "addSingleProfile" using "Superuser" of "Enterprise2" user
    When I fill in all the details of the candidate
    And I click on Save button
    And User reload the page.
    Then Verify User is not able to see "Vendor Messages" on cv details page
    And Verify User is not able to see "Changing Vendor Name For testing" on cv details page






  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify user is able to see the notification of Vendor message Sent via SRP Page
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User Select Specific Requirement on Vendor Portal
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And  User refresh the page till the time vendor candidate submitted is not displayed
    And User clicks on message icon below the candidate submitted by vendor
    And User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor SRP details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    When User click on "Go Back to Naukri/RMS" on vendorportal
    And  User click on "Logout" from settings options
    And User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    And User click on more on notification on rmsDashboardPage
    And  Verify user is able to see "Message from vendor prashant.emlh@yopmail.com" notification for Vendor
    And User click on notification "Message from vendor prashant.emlh@yopmail.com" recieved when vendor sends message to recruiter

  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify user is able to see the notification of Vendor message Sent via Cv details Page
    Given User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User Select Specific Requirement on Vendor Portal
    And User clicks on "Submitted" on requirement overview page on vendorPortal
    And  User refresh the page till the time vendor candidate submitted is not displayed
    And User click on Submitted Candidate Name
    And  User refresh the page till the time vendor candidate submitted is not displayed on CV details page
    And User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor CV details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    And Verify "This Message is From Vendor CV details Page" message is displayed for vendor
    When User click on "Go Back to Naukri/RMS" on vendorportal
    And  User click on "Logout" from settings options
    And User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    And User click on more on notification on rmsDashboardPage
    And  Verify user is able to see "Message from vendor prashant.emlh@yopmail.com" notification for Vendor
    And User click on notification "Message from vendor prashant.emlh@yopmail.com" recieved when vendor sends message to recruiter




 



  @RMS   @RMSVendor @RMSVendorSubmission @RMSVendorMerge @RMSNewMessageSectionAgain
  Scenario:Verify when vendor submits profile than user is able to see new Vendor Messages Heading,Name of Vendor as Subhead on Enterprise Cv details page
    Given  User login to the application "rmsDashboardPage" using "Vendor" of "Enterprise2" user
    When User select a "Connected Employers" from "Requirements" option
    And User click on "Naukri RMS" employer
    And User reload the page.
    And User Select Specific Requirement on Vendor Portal
    And User submit candidate on Vendor portal
    And Vendor submit the resume of candidate
    And  User refresh the page till the time vendor candidate submitted is not displayed
    And User clicks on message icon below the candidate submitted by vendor
    Then Verify the count of message should be '0'
    When User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor SRP details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    Then Verify the count of message should be '1'
    When User click on "Type your message to the employer" on cv details page for vendor message
    And User sends "This Message is From Vendor SRP details Page" message to recruiter
    And User clicks on "Send" button in conformation box
    Then Verify the count of message should be '2'

