@RMS @RMSOfferApproval @RMSOffer
Feature: To verify Offer Approval process

  Background:
    Given I login into RMS as "Enterprise.Super_user"
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
    And User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    When click on Add New offer Template
    And Enter offer approval template name
    And I save "first" Offer template name
    And Enter stage name "stage1"
    And Enter one approver as "Enterprise.Sub_user"
    And Click on save template
    When click on Add New offer Template
    And Enter offer approval template name
    And I save "second" Offer template name
    And Enter stage name "stage1"
    And Enter one approver as "Enterprise.Sub_user"
    And click on add approval stage
    And Enter second stage name "stage2"
    And Enter one approver in stage2 as "Enterprise.Super_user"
    And Click on save template
    And user click on "SAVE" button
    
  Scenario Outline: To verify all the offer templates mapped with the group are visible on Approval process DD in offer mail lightbox
    Given I save group ID for "<userType>"
    When User is on "settingsPage" page
    When user click on "Approval Settings" link
    And uncheck the switch Offer Approval is mandatory on settings page
    And click on set Approval Settings
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    Then I check all offer approval templates mapped are displayed

    Examples:
      | userType             |
      | Enterprise.Super_user |

  @TestOffer
  Scenario Outline: To verify Approval pending should be displayed when approval is not complete
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    Then I should see "Offer Approval Pending" status text in offer timeline
    When User is on "offerLogs" page
    Then verify offer status of candidate should be changed to "Approval Pending"

    Examples:
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify notification is received by stage two approvers when stage one approvers approve the offer
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    Then I should see approve and reject buttons on CV Details page

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify notification is not received by stage two approvers when stage one approvers rejects the offer
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "reject" the offer for the candidate
    And I should see "You have rejected this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    Then I should see "Offer Approval Rejected" offer status on CV Details page
    Then I should see "Offer Approval Rejected" status text in offer timeline

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify offer is approved by all approvers from CV Details page, then "Offer Approved by All" is displayed
    #Also covers this scenario
    #Scenario: To verify "Candidate's reply pending" is not displayed if recruiter does click "sent mail to candidate" after approval process
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I uncheck "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approved by All" offer status on CV Details page
    Then I should see "Offer Approved by All" status text in offer timeline

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @Mailer @Wip
  Scenario Outline: To verify offer is rejected by second approver from CV details page, then "Offer Approval Rejected" is displayed
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    And I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    And I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
#    Then I redirect to Next Approvers Personal Mailbox
#    And Verify Content and Subject for mailers.
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    And I "reject" the offer for the candidate
    And I should see "You have rejected this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approval Rejected" offer status on CV Details page
    Then I should see "Offer Approval Rejected" status text in offer timeline
#    Then I redirect to Next Approvers Personal Mailbox
#    And Verify Content and Subject for mailers.

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify offer tupple values on SRP after approval is sent
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    And I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    And I should see "Offer Approval Pending" status text on CV Details page
    And I navigate to application inbox
    And I search the candidate on application inbox page
    Then I should see all Offer Details on SRP page for the candidate

    Examples:
      | userType             |
      | Enterprise.Super_user |
	@TestOffer12345
  Scenario Outline: To verify offer is approved by all approvers from SRP page, then "Offer Approved by All" is displayed
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    And I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I uncheck "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    And I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I click Requirement name on CV details for the candidate
    #And I click applicant count on Requirement Overview
    #And I navigate to requirment inbox page
    #And I navigate to requirement overview page of Candidate
    And I get requirement ID from the page
    And I navigate to profile project inbox page for the candidate
    And I click "approve" button on Requirement Overview page
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to requirment inbox page
    And I navigate to profile project inbox page for the candidate
    And I click "approve" button on Requirement Overview page
    And I should see "You have approved this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approved by All" offer status on CV Details page
    Then I should see "Offer Approved by All" status text in offer timeline

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify offer is rejected by second approver from SRP page, then "Offer Approval Rejected" is displayed
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    And I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    And I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to requirment inbox page
    And I get requirement ID from the page
    And I navigate to profile project inbox page for the candidate
    And I click "approve" button on Requirement Overview page
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to requirment inbox page
    And I navigate to profile project inbox page for the candidate
    And I click "reject" button on Requirement Overview page
    And I should see "You have rejected this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approval Rejected" offer status on CV Details page
    Then I should see "Offer Approval Rejected" status text in offer timeline

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify if "Mail Automicatically to candidate once everyone approves" checkbox is checked, then "Candidate's reply pending" is displayed after all approvals are done
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Candidate's Reply Pending" offer status on CV Details page
    Then I should see "Candidate Reply Pending" status text in offer timeline

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @TestOffer
  Scenario Outline: To verify Offer is expired if status is change to some other stage after one approver approves the offer
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    #When User is on "settingsPage" page
    #When user click on "Manage Recruiters" link
   #	And I search subuser name "<subuserType>"
    #And I open the manage permissions for searched subuser
    #Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    #When I turn the "Allow User to Manage Offer" permission button to "on"
    #And I logout of RMS
    #And I login into RMS as "<subuserType>"
    #And I navigate to CV details for the candidate
    #And I "approve" the offer for the candidate
    #And I should see "You have approved this offer" message on CV Details page
    #And I logout of RMS
    #And I login into RMS as "<userType>"
    #And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on "Prospect" on DD
    Then I see "Are you sure you want to Change the Status ?" dialog box should open
    And I click "yes" on the dialog box
    And I should be able to see the status change message "Success! Application status has been successfully changed to Prospect" on CV Details Page
    Then I should see "Offer Expired" status in Offer details
    Then I should see "Offer Expired" status text in offer timeline
    When User is on "offerLogs" page
    Then verify offer status of candidate should be changed to "Expired"

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify "Offer Expired" is displayed to approver if status is change to some other stage after offer is sent for approval
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I click on status change drop down
    And I click on "Prospect" on DD
    Then I see "Are you sure you want to Change the Status ?" dialog box should open
    And I click "yes" on the dialog box
    And I should be able to see the status change message "Success! Application status has been successfully changed to Prospect" on CV Details Page
    Then I should see "Offer Expired" status in Offer details
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    Then I should see "Offer Expired" status in Offer details
    Then I should see "Offer Expired" status text in offer timeline

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify offer is expired if offer is edited after one approver approves the offer
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    And I click Edit Offer button
    Then I should see "Previous offer will no longer be valid. Generating this new offer will expire the offer that is already in process." message on Offer page

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify functionality of 'enquire about offer' from CV details page
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I click "Enquire about offer" link on Offer section
    Then I should see Enquire about offer layer

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify comment from 'Enquire about offer' is visible from CV details page
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I click "Enquire about offer" link on Offer section
    Then I should see Enquire about offer layer
    And I enter text in comments field in Enquire about offer layer
    And I click on "Send" in Enquire about offer layer
    Then I should see "Comment added and mailed to approvers" status message
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    Then I should see same comment for the candidate as entered by approver

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify user is able to 'send message' to approvers from CV details page
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I click SEND MESSAGE link in Offer Details Section
    And I enter text in SEND MESSAGE textbox
    And I click SEND MESSAGE link below textbox in Offer Section
    Then I should see same message is sent to the approver
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    Then I should see same message is sent to the approver

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify user is able to approve offer from enquire about offer lightbox
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I click "Enquire about offer" link on Offer section
    Then I should see Enquire about offer layer
    And I click "Approve" button on Enquire about offer layer
    Then I should see "Offer approved by you" message on CV Details page

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |
  @TestOffer
  Scenario Outline: To verify user is able to reject offer from enquire about offer lightbox
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I click "Enquire about offer" link on Offer section
    Then I should see Enquire about offer layer
    And I click "Reject" button on Enquire about offer layer
    Then I should see "Offer rejected by you" message on CV Details page
    When I logout of RMS
    And I login into RMS as "<userType>"
    When User is on "offerLogs" page
    Then verify offer status of candidate should be changed to "Approval Rejected"

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @testTagForApproval
  Scenario Outline: To verify approvers list is visible on CV details page ie 'show full approval'
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I click "Show Full Approval" link on Offer section
    Then I should see approvers "<userType>" and "<subuserType>" in the Show Full Approval layer

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @TestOffer
  Scenario Outline: To verify offer is rejected if recruiter rejects the offer from CV Details page
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I check "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I click Reject button on CV details page
    Then I should be able to see the status change message "Application status has been successfully changed to Rejected - Offers & Joining change - Offered" on CV Details Page
    Then I should see "Offer Rejected" status in Offer details
    Then I should see "Offer Rejected" status text in offer timeline
    When User is on "offerLogs" page
    Then verify offer status of candidate should be changed to "Rejected"

    Examples:
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify notification is received for offer approval
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I should see Offer notification for "Offer Approval Pending" on dashboard

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify approve/reject buttons should not be displayed for the approvers except stage 1 approvers until stage1 approvers approves the offer
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on first stage of offer
    And I should be directed to Offer Generation page
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I uncheck "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    And I should see "Offer Approval Pending" status text on CV Details page
    And I navigate to CV details for the candidate
    Then I should not see Approve or Reject buttons

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

	@checkTC
  Scenario Outline: To verify functionality of send mail to candidate once approved by all approvers
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I uncheck "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approved by All" offer status on CV Details page
    When click on Send to candidate after approved by all
    Then Mail body should be displayed on the offer lightbox
    When I click Send Mail button on Attach Offer Letter
    Then I should see "Candidate's Reply Pending" offer status on CV Details page

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify 'Approval Not Required' is not visible when 'Offer Approval is mandatory' is switched on
    Given I save group ID for "<userType>"
    And I am on the Settings page of RMS
    When user click on "Approval Settings" link
    And check the switch Offer Approval is mandatory on settings page
    And click on set Approval Settings
    And I am on the Settings page of RMS
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    Then I should not see "Approval Not Required" displayed in Select Approval Process dropdown

    Examples:
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of 'SEND NEW OFFER' link after offer approval has been rejected
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    And I uncheck "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
    And I "reject" the offer for the candidate
    And I should see "You have rejected this offer" message on CV Details page
    And I logout of RMS
    And I login into RMS as "<userType>"
    And I navigate to CV details for the candidate
    And I click "SEND NEW OFFER" link on Offer section
    Then I should be directed to Offer Generation page

    Examples:
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |