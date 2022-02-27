#Author: gupta.mansi@naukri.com

Feature: Customize selection process scenarios
  Scenarios related to Global Selection stage

  Background: 
    Given User login to rms "settingsPage" using "superuser1" and "superuser1password" of "Enterprise" user

  @id:1 @HMRequisition
  Scenario: Verify that superuser cannot create Rejected stage
    Given user click on "Customize the Selection Process" link
    And user click on Add Selection Stage
    When user fill stage name as "Rejected"
    And user click on Save stage button
    Then Verify "Stage already exists" message is displayed
    When user fill stage name as "Reject"
    And user click on Save stage button
    Then Verify "New Stage added" message is displayed
    And user click on edit for "Reject" stage name button
    When user edits stage name as "Rejected"
    And user click on Save stage button
    And user click on "Rename Stage" from lightbox
    Then Verify "Stage already exists" message is displayed below stage name
    And user click on Cancel stage button
    When user click on delete for "Reject" stage name button
    And user click on "Delete from entire System" from lightbox
    Then Verify "Stage Deleted" message is displayed
    
  @id:2 @HMRequisition
  Scenario: Verify that superuser can create substage named Rejected
  Given user click on "Customize the Selection Process" link
  And user click on Add Selection Stage
    When user fill stage name as "Random Stage Name"
    And user click on Save stage button
    And user click on "Random Stage Name" stage name 
    And user click on Add Sub Stage for "Random Stage Name" stage
    When user fill substage name as "Rejected"
    And user click on Save stage button
    Then Verify "New Sub-stage added" message is displayed
    When user click on delete for "Random Stage Name" stage name button
    And user click on "Delete from entire System" from lightbox
    Then Verify "Stage Deleted" message is displayed
    
    
 
    
