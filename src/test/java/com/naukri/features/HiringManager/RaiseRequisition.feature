Feature: Raise Requisition

  @id:0 @RaiseRequisition @HMRequisition
  Scenario: This scenario verifies all the errors while submitting blank requisition form
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And I turn "on" Requisition Approval Mandatory toggle bar
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    When User click on Add Requisition button
    Then User verify below error messages
      | Requirement Title can not be blank.       |
      | Job Title / Designation can not be blank. |
      | Select the required minimum experience.   |
      | Keywords can not be blank.                |
      | Select the required Group.                |
      | Select the required Recruiter.            |
      | Select the required Group.                |
      | Select the required approval process      |

  @id:1 @RaiseRequisition @HMRequisition @Smoke
  Scenario: Verify errors displyed on filling incorrect values
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    When User enter Requisition Title as "<>"
    Then Verify error text "Requirement Title should begin with a letter (A-Z) or a numeral (0-9) or a dot (.)" is displayed
    When User enter Job Title as "@TESTER"
    Then Verify error text "Job Title/ Designation should begin with a letter (A-Z) or a numeral (0-9) or a dot (.)" is displayed
    When User enter Job Title as "<>"
    Then Verify error text "HTML tags are not supported in this field." is displayed
    When User enter Minimum Work Experience as "1"
    Then Verify error text "Select the required maximum experience." is displayed
    When User enter Key Skills as
      | <>? |
    Then Verify error text "HTML tags are not supported in this field." is displayed
    When User enter Vacancy as "vacancy"
    Then Verify error text "Only numbers are allowed." is displayed
    When User enter Vacancy as "0"
    Then Verify error text "Enter a numeric value between 1 and 9998" is displayed

  @id:2 @RaiseRequisition @HMRequisition
  Scenario: Verify HM Spoc cannot raise requisition if approval process not present in gorup and approval is mandatory
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "groupListing" page
    And User add group with "Mansi Gupta" as HR and also as HRSpoc, "MansiHM" as HM and "MansiHM" as HMSpoc
    And User is on "settingsPage" page
    And I turn "on" Requisition Approval Mandatory toggle bar
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    When HM Spoc creates requisition with no approval process
    Then User verify below error messages
      | Select the required approval process |

  @id:3 @RaiseRequisition @HMRequisition
  Scenario: Verifies error displayed if Maximum CTC is not filled and only Minimum CTC is filled and requisition is submitted
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And User enter Requisition Title as "Requisition Title"
    And User selects top group
    And User prefills the requisition from top suggestion
    When User enter Annual CTC as "Maximum Salary"
    And I click on "AddRequisition" button
    Then I verify "Salary:Max Salary should not be empty." as error message

  @id:4 @HMRequisition @RaiseRequisition
  Scenario: No approval dropdown is present if Hiring Manager Spoc raises a requisition for a Group that do not have Approval Process.
    Given I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "groupListing" page
    And User add group with "Mansi Gupta" as HR and also as HRSpoc, "MansiHM" as HM and "MansiHM" as HMSpoc
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And I click on Select Group dropdown
    When User select created group
    Then Verify "No approval processes mapped to this group" message against "Select Approval Process:  " label

  @id:5 @RaiseRequisition @HMRequisition
  Scenario: Hiring Manager sees the name of group in which he is HMSpoc
    Given I am logged in with "Enterprise" user "superuser1"
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    When I click on Select Group dropdown
    Then I see the name of group in which i am HM Spoc in drop down

  @wip 
  Scenario: This scenario verifies that Requisition template label and Previously raised requisition label is displayed under Prefill section
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And click on groups section
    And select any other group on requirement creation page
    When User click on Prefill from other Prefill from existing Requisitions or Templates DD
    Then user should be able to see the label "Requisition template"
    Then user should be able to see the label "Previously raised requisition"

  @wip
  Scenario: Verify that details filled while raising requisitions are displayed on Requisition overview page
  And User is on "RMSRaiseRequisition" page
    And User fill in the requisition group as top group
    And User fill in the requisition title
    And User fill in the requisition job title
    And User fill in the requisition Job Description
    And User fill in the requisition Candidate Description
    And User select the requisition currency of CTC as "USD"
    And User fill in the requisition "minCTC" as "30,000"
    And User fill in the requisition "maxCTC" as "35,000"
    And User fill in the requisition "minExp" as "2" years of experience
    And User fill in the requisition "maxExp" as "3" years of experience
    And User fill in the requisition keywords as "java"
    And User fill in the requisition job location as "Delhi,Ahmedabad"
    And User click on Add Requisition button
    When User click on requisition name
    Then Verify filled fields are displayed on Requisition detail page

  @wip
  Scenario: To verify prefill from requirement functionality
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRaiseRequisition" page
    And User fill in the requisition group as top group
    And User fill in the requisition title
    And User fill in the requisition job title
    And User fill in the requisition Job Description
    And User fill in the requisition Candidate Description
    And User select the requisition currency of CTC as "USD"
    And User fill in the requisition "minCTC" as "30,000"
    And User fill in the requisition "maxCTC" as "35,000"
    And User fill in the requisition "minExp" as "2" years of experience
    And User fill in the requisition "maxExp" as "3" years of experience
    And User fill in the requisition keywords as "java"
    And User fill in the requisition job location as "Delhi,Ahmedabad"
    And User click on Add Requisition button
    And User is on "RMSRaiseRequisition" page
    And User click on Prefill from other Prefill from existing Requisitions or Templates DD
    And select first requisition from prefill from other existing Requisitions or Templates DD
    Then verify the fields prefilled from previous requisition
