Feature: Test Scenarios of Requisition Listing Page

  Author: nikhil.bhatia@naukri.com

  @id:1   @RMS @RMSRequisitionListing @RMSRequisition
  Scenario: Verify search when Requisition not found on Requisition listing Page
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    When I click on search button with Requisition that does not exist for the client
    Then I see Requisition not found with clear link
    When I click on the clear button
    And Verify that after clicking on clear button all Tabs are visible.

  @id:2   @RMS @RMSRequisitionListing @RMSRequisition
  Scenario: Verify highlighted text on search when you search Requisition on Requisition listing page
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    When I click on search button by filling valid Request Name on Requisition listing page.
    And verify that the text with the search Request Name if exist should be highlighted and listed on top in tuple.

  @id:3   @RMS @RMSRequisitionListing @RMSRequisition
  Scenario: Verify highlighted text on search when you search By RequisitionId on Requisition listing page
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    Then I search with RequisitionId that exist.
    And verify that the RequisitionId with the search keyword if exist should be highlighted and listed on top in tuple.

  @id:4   @RMS @RMSRequisitionListing @RMSRequisition
  Scenario: Verify highlighted text and link on search Requisition
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    When I search with text by typing first three words irrespective of complete Requisition
    Then I see link to the similar names of Requisition in the search bar
    Then I click on link with results
    And Verify it shows the result with text that you entered and clicked.

  @id:5   @RMS @RMSRequisitionListing @RMSRequisition1
  Scenario: Verify user is able to raise a request with approval template attach to it
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    When I click on raise request and fill required details with group and Approval Template
    Then Verify Requisition is visible at the top in tab requisition raised by you and verify Approval status and pending approvers name
    Then I Comment on the Requisition
    And Verify Comment is visible on the page
    Then I delete the comment from Requisition
    And Verify Comment is deleted

  @id:6  @RMS @RMSRequisitionListing @RMSRequisition1 @Smoke
  Scenario: Verify user is able to raise a request without approval template attach to it
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    When I switch to tab "Requisitions Raised by You"
    When I click on raise request and fill required details without approval Template
    And Verify Requisition is visible at the top in tab requisition raised by you
    Then I Comment on the Requisition
    And Verify Comment is visible on the page
    Then I delete the comment from Requisition
    And Verify Comment is deleted
    When I switch to tab "Requisitions Awaiting Others Approval"
    Then I click on send Reminder
    And Verify Reminder sent successfully

  @id:7   @RMS @RMSRequisitionListing @RMSRequisition
  Scenario: Verify requisition pending for Requirement is visible
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    When I switch to tab "Requisitions Ready for Creation"
    Then Verify I see status as "Pending For Requirement" or "Approval Completed" under "Requisitions Ready for Creation"

  @id:8   @RMS @RMSRequisitionListing @RMSRequisition
  Scenario: Verify Pagination on Requisition listing page
    Given I login into RMS as an "HiringManager" user
    When I navigate to Requisition listing page.
    And Verify that number we are selecting through pagination and the tuples as result we are getting are correct for all tabs
      | Requisitions Awaiting Your Approval   |
      | Requisitions Ready for Creation       |
      | Requisitions Awaiting Others Approval |
      | Requisitions Raised by You            |
      | Requisitions Actioned by You          |




