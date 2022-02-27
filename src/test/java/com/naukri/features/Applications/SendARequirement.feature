Feature: To verify send requirement flow

  @id:1 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availability of "Send a Requirement" link on the application inbox page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox

  @id:2 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availability of "Send a Requirement" link on the requirement inbox page
    Given I login into RMS as an "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox

  @id:3 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availability of "Send Requirement" link on CV details page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I am on CV details page for the first candidate
    And I hover on the Email option on top panel of the CV details page
    Then I should be able to see the Send A Requirement option in the hover list on CV details page
    When I click on send a requirement option
    Then I should be redirected to send a requirement lightbox

  @id:4 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the error message displayed on not selecting any profile in application inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When I click the send a requirement option in hover list
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"

  @id:5 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the error message displayed on not selecting any profile in application inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When I click the send a requirement option in hover list
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"

  @id:6 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availability of "Send a Requirement" link on the requirement inbox page
    Given I login into RMS as an "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"

  @id:7 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availibility of chose template in send a requirement flow from application inbox
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "All Applications" from "Profiles" option
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    And I see chose from template list not empty

  @id:8 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availability of "Send a Requirement" link on the requirement inbox page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "All Requirements" from "Requirements" option
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    And I see chose from template list not empty

  @id:9 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the availability of "Send Requirement" link on CV details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "All Applications" from "Profiles" option
    And I am on CV details page for the first candidate
    And I hover on the Email option on top panel of the CV details page
    Then I should be able to see the Send A Requirement option in the hover list on CV details page
    When I click on send a requirement option
    Then I should be redirected to send a requirement lightbox
    And I see chose from template list not empty

  @id:10 @RMS @SendARequirement @RMSApplications
  Scenario: To verify validation in case of replyTo mail Id
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I am on CV details page for the first candidate
    And I hover on the Email option on top panel of the CV details page
    Then I should be able to see the Send A Requirement option in the hover list on CV details page
    When I click on send a requirement option
    Then I should be redirected to send a requirement lightbox
    And I should be able to see the reply to field as disabled

  @id:11 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the validation imposed on the subject text
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Required Field can not be left blank" under the mail subject

  @RMS @SendARequirement @RMSApplications
  Scenario: To verify the validation imposed on the subject text
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I type in the mail subject "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Required Field can not be left blank" under the mail body

  @id:12 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the presence the send a copy to me
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    And I should be able to see the "Send copy of this email" and checkbox
    When I check the checkbox preceding "Send copy of this email"
    Then I should be able to see the label "Send me a copy as well (bcc)" and checkbox
    And I should be able to see the text field with placeholder text "Enter additional email (CC) in comma separated"

  @id:13 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the validation present on the CC list
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    And I should be able to see the "Send copy of this email" and checkbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I check the checkbox preceding "Send copy of this email"
    Then I should be able to see the label "Send me a copy as well (bcc)" and checkbox
    And I should be able to see the text field with placeholder text "Enter additional email (CC) in comma separated"
    When I type "CC" in the cc field
    And I click on "Send" button on sendRequirement
    Then I should be able to see the "Please enter a valid email Id" as error message

  @id:14 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the save as a template flow
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I check Save this as a new template checkbox
    Then I should be able to see the template name text field
    When I type in the template name ""
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Required Field can not be left blank" as error message under template name input box
    When I type in the template name "@#$%^&*"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Special characters other than . # @ - , $ & / are not allowed" as error message under template name input box
    When I type in the template name "templateName"
    And I click on "Send" button on sendRequirement
    And I navigate to template listing page
    Then I should be able to see the template name created from the send a requirement window

  @id:15 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the duplicate name functionality in send a requirement template
    Given I login into RMS as an "Enterprise" user
    When I navigate to template listing page
    And I select the requirement tab
    And I read the first requirement title
    And User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I check Save this as a new template checkbox
    Then I should be able to see the template name text field
    When I type in the template name "previous used"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Template with the same name exists. Please use a different name" as error message under template name input box

  @id:16 @RMS @SendARequirement @RMSApplications
  Scenario: To verify the appearance of success ribbon after requirement send mail
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Success! Mail has been sent." on application inbox

  @id:17 @RMS @SendARequirement @RMSApplications
  Scenario: To verify preview option of send a requirement
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Preview & Send" button on sendRequirement
    Then I should be able to see "Mail Preview - Send a Requirement"

  @id:18 @RMS @SendARequirement @RMSApplications
  Scenario: To verify preview option of send a requirement
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Cancel" button on sendRequirement
    Then I should be able to see " All Applications " on application inbox page
