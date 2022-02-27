Feature: HM Requirement Listing page

  @id:1 @HMRequisition @RMS @HMRequirement
  Scenario: To verify the presence of all status on requirement listing page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    Then Verify User see the Filter by "Status"
    And Verify User see text "Status (1)" on status filter
    When User click on filter by status
    Then Verify User see the checkbox "Open" label is "checked"
    And Verify User see the checkbox "Close" label is "unchecked"
    And Verify User see the checkbox "On Hold" label is "unchecked"

  @id:2 @HMRequisition @RMS @HMRequirement
  Scenario: To verify the absence of requirement source DD on requirement listing page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    Then Verify User does not see the reuirement source filter

  @id:3 @HMRequisition @RMS @HMRequirement
  Scenario: To verify the requirement search on the requirement listing page for HM
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    And User gets the name of top requirement
    When User type in the requirement name in the search bar
    And User click on the search button on requirement listing
    Then Verify User see the searched requirement on the listing page

  @id:4 @HMRequisition @RMS @HMRequirement
  Scenario: To verify the count across the different requirement source on requirement listing page
    Given I am logged in with "Enterprise" user "hiringmanager2"
    When User is on "requirementInbox" page
    Then Verify User see the Filter by "Status"
    And Verify User see text "Status (1)" on status filter
    When User click on filter by status
    When User "uncheck" the checkbox with the label "Open"
    And User record the total count of requirement in system
    When User click on filter by status
    And User "check" the checkbox with the label "Open"
    And User record the total count of requirement
    Then Verify User see the total number of requirement less than the number of requirement recorded in all the requirement status according to "Enterprise"
    When User click on filter by status
    And User "check" the checkbox with the label "Close"
    And User record the total count of requirement
    Then Verify User see the total number of requirement less than the number of requirement recorded in all the requirement status according to "Enterprise"
    When User click on filter by status
    And User "check" the checkbox with the label "On Hold"
    And User record the total count of requirement
    Then Verify User see the total number of requirement equal to the number of requirement recorded in all the requirement status

  @id:5 @HMRequisition @RMS @HMRequirement
  Scenario: Verify that HM does not see Modify,Search,Status change dd and More actions options under requirement
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    Then Verify that "Modify" button is not displayed on HM requirement listing
    And Verify that "Search" button is not displayed on HM requirement listing
    And Verify that "More Actions" button is not displayed on HM requirement listing
    And Verify that comment count is not displayed on HM requirement listing

  @id:6 @HMRequisition @RMS @HMRequirement
  Scenario: Verify presnece of refine requirement filter and sub filters under refine requirement filter
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    And User click on refine requirement filter on HM Requirement listing
    Then Verify "By Group" filter is present in refine requirement lightbox
    And Verify "Created By" filter is present in refine requirement lightbox
    And Verify "Refine Requirements" filter is present in refine requirement lightbox
    And Verify "Clear All " filter is present in refine requirement lightbox
    And Verify " Close" filter is present in refine requirement lightbox
    And Verify "Visible To" filter is not present in refine requirement lightbox
    And Verify "By Functional Area" filter is not present in refine requirement lightbox
    And Verify "By Industry" filter is not present in refine requirement lightbox

  @id:7 @HMRequisition @RMS @HMRequirement
  Scenario: Verify that only HM Spoc can close requirement
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And click on selection stage
    And I map "MansiTest" to "Prospect" stage
    And I added a single profile in requirement
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    Then Verify "Close" button is displayed for created requirement
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    When User is on "requirementInbox" page
    Then Verify "Close" button is not displayed for created requirement
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    And User click on "Close" button for requirement on HM Requirement listing
    Then User should be able to see the text "Are you sure you want to close this requirement ? Closing this Requirement will close all Live Jobs mapped to this Requirement" on lightbox
    And User should be able to see the text "Cancel" on lightbox
    When User click on Close button on lightbox
    And User click on filter by status
    And User "uncheck" the checkbox with the label "Open"
    And User record the total count of requirement
    And User click on filter by status
    And User "check" the checkbox with the label "Close"
    And User record the total count of requirement
    Then Verify "Close" button is not displayed for created requirement

  @id:8 @HMRequisition @RMS @HMRequirement
  Scenario: To verify the count of open Requirements on dashboard matched that in listing
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And User gets count of requirement from dashboard
    When User is on "requirementInbox" page
    Then Verify total count of requirments matches that on Dashboard

  @id:9 @HMRequisition @RMS @HMRequirement @done
  Scenario Outline: To verify that master profile search option is not present for hiring manager
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "<page>" page
    Then Verify user does not see master profile search bar

    Examples: 
      | page                   |
      | hiringManagerDashboard |
      | requirementInbox       |
      | HMAllApplication       |
