Feature: Requisition

  @id:0 @RequisitionListing @HMRequisition @RMS
  Scenario: Verify that user is able to create a group in which user map HRSpoc, HMSpoc, HRs, HMs and requisition approval process and turn off Approval mandatory button
    Given I am logged in with "Enterprise" user "superuser1"
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout

  @id:1 @RequisitionListing @HMRequisition @RMS
  Scenario: HM Spoc is able to add comment for the requisition with no approval process and While raising requisition, instead of Comments, label would 'Other information' and Placeholder will be 'Enter other information relevant for approvers and recruiters'
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    Then HM Spoc sees "Other information:" label instead of Comment
    And HM Spoc sees placeholder as "Enter other information relevant for approvers and recruiters"
    When HM Spoc creates requisition with no approval process
    Then I see add comment button below requisition name
    And HM Spoc is able to add comment for requisition as "Comment added by HM Spoc"
    And User is able to see added comment on top as "Comment added by HM Spoc"
    When I click on requisition name
    Then I verify comment

  @id:2 @RequisitionListing @HMRequisition @RMS @Smoke
  Scenario: Comment posted by HR Spoc must be visible to HM Spoc for the raised requisition with no approval process
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    When I go to "Requisitions Raised by You" section
    Then I see that the Status of requirement as "Pending For Requirement"
    When I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And HR Spoc adds comment for the requisition with no approval process as "Comment added by HR Spoc"
    And I logout
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    When I click on comments for raised requisition ready for creation
    Then HM Spoc must be able to see "Comment added by HR Spoc" comment added by HR Spoc against requisition

  @id:3 @RequisitionListing @HMRequisition @RMS
  Scenario: Comment posted by HM Spoc must be visible to HR Spoc for the raised requisition with no approval process
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And HM Spoc is able to add comment for requisition as "Comment added by HM Spoc"
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    When I click on comments for raised requisition ready for creation
    Then HR Spoc must be able to see comment "Comment added by HM Spoc" added by HM Spoc against requisition

  @id:4 @RequisitionListing @HMRequisition @RMS
  Scenario: Comment posted by HM Spoc must be visible to HR Spoc for the raised requisition with approval process
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process
    And HM Spoc is able to add comment for requisition as "Comment added by HM Spoc"
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    When I click on comments for raised requisition with pending approval
    Then HR Spoc must be able to see comment "Comment added by HM Spoc" added by HM Spoc against requisition

  @id:5 @RequisitionListing @HMRequisition @RMS
  Scenario: Comment posted by HR Spoc must be visible to HM Spoc for the raised requisition with approval process
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    When HR Spoc adds comment for the requisition as "Comment added by HR Spoc"
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    When I click on comments for raised requisition with pending approval
    Then HM Spoc must be able to see "Comment added by HR Spoc" comment added by HR Spoc against requisition

  @id:6 @RequisitionListing @HMRequisition @RMS
  Scenario: Comment added by approver will be visible to HM Spoc and HR Spoc
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process
    And I logout
    And I am logged in with "Enterprise" user "approver1"
    And User is on "RMSRequisitionList" page
    And Approver adds comment for the requisition as "Comment added by Approver1"
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    When I click on comments for raised requisition with pending approval
    Then HM Spoc must be able to see "Comment added by Approver1" comment added by approver against requisition
    When I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I click on comments for raised requisition with pending approval
    Then HR Spoc must be able to see "Comment added by Approver1" comment added by approver against requisition

  @id:7 @RaiseRequisition @HMRequisition @RMS @RequisitionListing
  Scenario: Raise requisition from Dashboard
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When I goto raise requisition page from dashboard
    And HM Spoc creates requisition with no approval process
    Then I should get requisition raised success message

  @id:8 @RaiseRequisition @HMRequisition @RMS @RequisitionListing
  Scenario: Raise requisition from All Requisition page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    When I click on Raise Requisition button
    And HM Spoc creates requisition with no approval process
    Then I should get requisition raised success message

  @id:9 @RequisitionListing @HMRequisition @RMS
  Scenario: If Hiring Manager Spoc raises a requisition for a Group with no Approval Process then count will increase for Requisitions Raised by You and Requisitions Ready for Creation
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    And I get the count of requisitions for Requisitions Raised by You and Requisitions Ready for Creation
    And User is on "RMSRaiseRequisition" page
    When HM Spoc creates requisition with no approval process
    Then I see that count is increased for Requisitions Raised by You and Requisitions Ready for Creation

  @id:10 @RequisitionListing @HMRequisition @Mailer @Wip @RMS
  Scenario: Comments for requisition before rejection of requisition will remain after reinitiation of requisition
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process
    And HM Spoc is able to add comment for requisition as "Comment added by HM Spoc"
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And HR Spoc adds comment for the requisition as "Comment added by HR Spoc"
    And I logout
    And I am logged in with "Enterprise" user "approver1"
    And User is on "RMSRequisitionList" page
    And Approver adds comment for the requisition as "Comment added by Approver1"
    And Approver rejects the requisition
    And I logout
    #    Then Open Personal MailBox for Approver
    #   And Verify Content and subject sent to the Approver from RMS.
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    And refresh the page
    And I go to "Requisitions Raised by You" section
    And I get comment count of requisition
    And I get all comments of requistion
    When I reinitiate requisition
    Then I see that current comment count is same as comment count before reinitiating requisition
    And I see that comments are also same as before

  @id:11 @RequisitionListing @HMRequisition @RMS
  Scenario: Requisitions with no approval process which have status as open, will also have Add Comment/ N Comment button
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    And User is on "RMSRequisitionList" page
    And I go to "All Other Requisitions" section
    Then I see add comment button below requisition name

  @id:12 @RequisitionListing @HMRequisition @Mailer @Wip @RMS
  Scenario: On Requisition Listing page, the second comment added will be added on the top of first comment
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I click on comments for raised requisition ready for creation
    When HM Spoc is able to add comment for requisition as "First Comment"
    And HM Spoc is able to add comment for requisition as "Second Comment"
    Then HM verifies that "Second Comment" is stacked over "First Comment"

  #   Then Open Personal MailBox for hrspoc
  #   And Verify Content and subject sent to the hrspoc from RMS.
  @id:13 @RequisitionListing @RMS @HMRequisition
  Scenario: Verify that HR Spoc cannot create requirement from rejected requisition
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process
    And I logout
    And I am logged in with "Enterprise" user "approver1"
    And User is on "RMSRequisitionList" page
    And Approver rejects the requisition
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    When I go to "Requisitions Awaiting Others Approval" section
    Then I see that the Status of requirement as "Approval Rejected"
    And Verify that "Create Requirement" button is not displayed for requirement

  @id:14 @RequisitionListing @HMRequisition @RMS
  Scenario: If Hiring Manager Spoc raises a requisition for a Group that do not have approval process then it goes to HRSpoc.
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    When I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    Then Verify created requisition is displayed
    And Verify that "Create Requirement" button is displayed for requirement
    And I see that the Status of requirement as "Pending For Requirement"

  @id:15 @RequisitionListing @HMRequisition @RMS
  Scenario: Verify that HR Spoc cannot create requirement from withdrawn requisition
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    When User click on "Withdraw" button under Requirement
    And User click on "YES" button
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    When I go to "All Other Requisitions" section
    Then I see that the Status of requirement as "Withdrawn"
    And Verify that "Create Requirement" button is not displayed for requirement
    When I go to "Requisitions Ready for Creation" section
    Then Verify created requisition is not displayed

  @id:16 @RequisitionListing @HMRequisition @RMS
  Scenario: Verify light box text displayed when user click on withdraw Requisition
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    When User click on "Withdraw" button under Requirement
    Then Verify "Header" of lb is "Do you want to withdraw this Requisition?"
    And Verify "Body" of lb is "The requisition will be permanently withdrawn."
    And Verify "YES" button is displayed on withdraw LB
    And Verify "NO" button is displayed on withdraw LB
    And Verify "✕" button is displayed on withdraw LB
    When User click on "YES" button
    Then Verify "The Requisition has been successfully deleted." success message is displayed
    When I go to "Requisitions Raised by You" section
    And I see that the Status of requirement as "Withdrawn"

  @id:17 @RequisitionListing @HMRequisition @RMS
  Scenario: Verify that HR other that HR Spoc does not see create requirement button once requirement is raised for requisition
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    And I am logged in with "Enterprise" user "subuser1"
    And User is on "RMSRequisitionList" page
    When I go to "All Other Requisitions" section
    Then Verify that "Create Requirement" button is not displayed for requirement

  @id:18 @RequisitionListing @HMRequisition @RMS
  Scenario: Verify that when Requisition Details Settings is off then recruiters does not see requisition details on requirement overview page
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And User is on "settingsPage" page
    And user click on "Requisition Details Settings" link
    And User turn "off" Requisition Details Settings
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    Then Verify that user does not see "Requisition Details" tab on overview page
    And I logout
    And I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    When User clicks on created requirement name
    Then Verify that user does not see "Requisition Details" tab on overview page

  @id:19 @wip
  Scenario: Verify that HRSpoc can create requirement only after approval of requisition
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Awaiting Others Approval" section
    Then I see that the Status of requirement as "Approval Pending"
    And Verify that "Create Requirement" button is not displayed for requirement
    And I logout
    And I am logged in with "Enterprise" user "approver1"
    And User is on "RMSRequisitionList" page
    And Approver approves the requisition
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    Then I see that the Status of requirement as "Approval Completed"
    When I create requirement for raised requisition
    And User is on "RMSRequisitionList" page
    And I go to "All Other Requisitions" section
    Then I see that the Status of requirement as "Open"

  @wip
  Scenario: Verify Superuser can delete every stakeholders comment from requisition

  @wip
  Scenario: Verify that one stakeholder cannot delete comment of another stakeholder

  @wip
  Scenario: Verify that user can delete their own comment

  @wip
  Scenario: Verify same data is displayed which is filled while raising requisition
