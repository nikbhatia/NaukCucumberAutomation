Feature: VendorPortal

  Background:
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    When  User is on "ManageUsersPage" page

  @RMS   @RMSVendor @RMSVendorPortal @RMSVendorSubmission
  Scenario: Verify that user is able to Add,Edit and delete a Point of contact from VendorPortal
    And  User clicks on "Add Point of Contact" button in conformation box
    And  User added a Spoc on Vendor Portal
    Then User Verify that POC Added successfully
    When User click on Poc Name
    And User clicks on edit against POC Name
    And User edits the information of Spoc
    Then User Verify that POC edited successfully
    When User click on delete button
    Then User Verify that Poc deleted successfully


  @RMS   @RMSVendor @RMSVendorPortal @RMS34672 @RMSVendorSubmission
  Scenario: Verify that user should not be able to see delete icon for last Registered recruiter
    And  User clicks on "Invite Recruiters" button in conformation box
    And  User click on "Enter Email Ids" button on the page
    And  User Invites the below Recruiters
      |basicsubuser@yopmail.com|testingkafkauser33@yopmail.com|promotionuser@yopmail.com|aman22@yopmail.com|
    And  User clicks on "Assign" button in conformation box
    And  User Clicks on "Show More" Link in Invite recruiter section
    And  User counts the no of recruiter in "REGISTERED" status
    Then Verify if there is only one recuiter in "REGISTERED" state then user should not get delete icon other wise user should get delete against recruiter
    When User deletes the below Recruiters
      |basicsubuser@yopmail.com|testingkafkauser33@yopmail.com|promotionuser@yopmail.com|aman22@yopmail.com|
    Then Verify if there is only one recuiter in "REGISTERED" state then user should not get delete icon other wise user should get delete against recruiter
