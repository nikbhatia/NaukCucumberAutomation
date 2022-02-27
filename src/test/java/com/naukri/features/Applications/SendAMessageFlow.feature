@RMS @RMSMessage
Feature: To verify the send message flow of RMS

  @id:4 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of "Send Message" link provided on the application inbox page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    Then I should be redirected to the message layout page containing fields Reply To, Cc, Mail a copy to me, Prefill from Template, Subject, Include signature, Requested documents, Attached, Mail body, Preview and send mail

  @id:5 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of "Send Message" link provided on Requirement Inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    Then I should be redirected to the message layout page containing fields Reply To, Cc, Mail a copy to me, Prefill from Template, Subject, Include signature, Requested documents, Attached, Mail body, Preview and send mail

  @id:6 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of "Send Message" link provided on View Application page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    When I am on CV details page for the first candidate
    And I hover on the Email option on top panel of the CV details page
    Then User should be able to see the Message option in the hover list on CV details page
    When User click on Message option on CV Details Page
    Then I should be redirected to the message layout page containing fields Reply To, Cc, Mail a copy to me, Prefill from Template, Subject, Include signature, Requested documents, Attached, Mail body, Preview and send mail

  @id:7 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the error message when I click Send message link without selecting any application
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"

  @id:8 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the values shows in the mail template drop down when I choose send message option
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I am on CV details page for the first candidate
    And I hover on the Email option on top panel of the CV details page
    Then User should be able to see the Message option in the hover list on CV details page
    When User click on Message option on CV Details Page
    Then I should be able to see the "Prefill from Template"
    And I should be able to see the list of the templates available

  @id:9 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the validation of subject text box provided in the send message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I click on "SEND MAIL"
    Then I should be able to see the error message below the mail subject line
    And I should see error text as "This field cannot be left blank."

  @id:10 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the validation of mail body text box provided in the send message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the subject field
    And I click on "SEND MAIL"
    Then I should see error text as "This field cannot be left blank."

  @id:11 @RMS @RMSApplications
  Scenario: To verify the validation of CC email address text box which is provided in the send message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the CC field with text "AB"
    And I click on "SEND MAIL"
    Then I should be able to the invalid email address error "Please enter a valid Email"

  @id:12 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of "Save this as a new template" check box provided in the send message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on the option Save Template
    Then I should be able to see the text box with the placeholder "Type Template name here"
    When I type the name of the template in the text box
    And I click on "SEND MAIL"
    And I navigate to template listing page
    Then I should be able to see the template name created from the message window

  @id:13 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of the Send link provided in the send message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on "SEND MAIL"
    Then I should be able to see the success ribbon with a message as "Mail sent succesfully"

  @id:14 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of the cancel link provided in the send Message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on Back Arrow
    Then I should not be able to see the success ribbon with a message as "Mail sent succesfully"

  @id:15 @RMS @RMSMessage @RMSApplications
  Scenario: To verify the functionality of the Preview and Send link provided in the send Message light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on "PREVIEW"
    Then I should be able to see the message body and message subject on preview layout
    And I should be able to see the "SEND MAIL" and "CLOSE" buttons on the layout footer
    When I click on "SEND MAIL" button
    Then I should be able to see the success ribbon with a message as "Mail sent succesfully"

  @id:16 @RMS @RMSMessage @RMSApplications
  Scenario: To verify presence of tag in send message flow for a single candidate
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    Then I should be able to see DD with text tags
    When I click on tags DD
    Then I should be able to see "Candidate" group text
    And I should be able to see "Recruiter" group text
    When I click on "Recruiter" group text
    Then I should be able to see list of "Recruiter" tags
    When I click on "Candidate" group text
    Then I should be able to see list of "Candidate" tags

  @id:17 @RMS @RMSMessage @RMSApplications
  Scenario: To verify presence of tag in send message flow for a single candidate
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I select all applications
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    Then I should be able to see DD with text tags
    When I click on tags DD
    Then I should be able to see "Candidate" group text
    And I should be able to see "Recruiter" group text
    When I click on "Recruiter" group text
    Then I should be able to see list of "Recruiter" tags
    When I click on "Candidate" group text
    Then I should be able to see list of "Candidate" tags
