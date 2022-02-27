#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify Jobs Drop down is not visible  for send Requirement to candidate
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the first requirement in the requirement drop down in which candidate is not already mapped
#Then Verify Text is visible "Note: The candidate(s) will be added to selected requirement".
#And Verify I no longer see job drop down
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#Then User click on mailboxtab
#And Verify ThreadSubject is displayed as "Updated Subject"
#
#.
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify header under mailbox tab after mail for send Requirement sent to candidate from cv details page
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the first requirement in the requirement drop down in which candidate is not already mapped
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#Then User click on mailboxtab
#And Verify ThreadSubject is displayed as "Updated Subject"
#Then Verify visibility of Header stating “Job description for Requirement" "<Requirement name>" sent by "<Recruiter Name>" on "<DD-Mon-YY HH:MM>”.
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify header under mailbox tab after mail for send Requirement sent to candidate from srp page
#
#Given I login into RMS as an "<userType>" user
#When User is on "<pages>" page
#Then User select the first candidate checkbox
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the first requirement in the requirement drop down in which candidate is not already mapped
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#Then User click on mailboxtab
#And Verify ThreadSubject is displayed as "Updated Subject"
#Then Verify visibility of Header stating “Job description for Requirement" "<Requirement name>" sent by "<Recruiter Name>" on "<DD-Mon-YY HH:MM>”.
#
#Examples:
#| userType     | pages            |
#| Enterprise   | Application Inbox|
#| Enterprise   | Profile Inbox    |
#| Company      | Application Inbox|
#| Company      | Profile Inbox    |
#| ProConsultant| Application Inbox|
#| ProConsultant| Profile Inbox    |
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify application for candidate created when mail for send Requirement sent to candidate from cv details page
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the first requirement in the requirement drop down in which candidate is not already mapped
#Then Verify Text is visible "Note: The candidate(s) will be added to selected requirement".
#And Verify I no longer see job drop down
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify on top right corner candidate mapped to new requirement is visible
#When i click on view application
#And I move to newly created application
#Then User click on mailboxtab
#And Verify mail sent to candidate for requirement is visible
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify requirement name and recruiter name truncated if it exceeds one line (header)
#Given I login into RMS as an "<userType>" user having recruiter name of 50 char
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the requirement having length 200 char in the requirement drop down in which candidate is not already mapped
#Then Verify Text is visible "Note: The candidate(s) will be added to selected requirement".
#And Verify I no longer see job drop down
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#Then I click on mailbox tab
#Verify header under mailbox tab containing requirement name is truncated and recruiter name is truncated
#And I verify on top right corner candidate mapped to new requirement is visible
#When i click on view application
#And I move to newly created application
#Then User click on mailboxtab
#And Verify mail sent to candidate for requirement is visible
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify requirement name and recruiter name truncated if it exceeds one line (header)
#Given I login into RMS as an "<userType>" user having recruiter name of 50 char
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the requirement having length 10 char in the requirement drop down in which candidate is not already mapped
#Then Verify Text is visible "Note: The candidate(s) will be added to selected requirement".
#And Verify I no longer see job drop down
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#Then I click on mailbox tab
#Verify header under mailbox tab containing recruiter name is truncated
#And I verify on top right corner candidate mapped to new requirement is visible
#When i click on view application
#And I move to newly created application
#Then User click on mailboxtab
#And Verify mail sent to candidate for requirement is visible
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify requirement name truncated if it exceeds one line (header)
#Given I login into RMS as an "<userType>" user of 20 char
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the requirement having length 200 char in the requirement drop down in which candidate is not already mapped
#Then Verify Text is visible "Note: The candidate(s) will be added to selected requirement".
#And Verify I no longer see job drop down
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#Then I click on mailbox tab
#Verify header under mailbox tab containing requirement name is truncated
#And I verify on top right corner candidate mapped to new requirement is visible
#When i click on view application
#And I move to newly created application
#Then User click on mailboxtab
#And Verify mail sent to candidate for requirement is visible
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#
#@RMSEN-1237 @Wip @Mailer
#Scenario Outline: Verify application for candidate created when mail for send Requirement sent to candidate from srp page
#
#Given I login into RMS as an "<userType>" user
#When User is on "<pages>" page
#Then User select the first candidate checkbox
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#When I select the first requirement in the requirement drop down in which candidate is not already mapped
#Then Verify Text is visible "Note: The candidate(s) will be added to selected requirement".
#And Verify I no longer see job drop down
#And User fill in the subject field as "Updated Subject"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify on top right corner candidate mapped to new requirement is visible
#When i click on view application
#And I move to newly created application
#Then User click on mailboxtab
#And Verify mail sent to candidate for requirement is visible
#
#Examples:
#| userType     | pages            |
#| Enterprise   | Application Inbox|
#| Enterprise   | Profile Inbox    |
#| Company      | Application Inbox|
#| Company      | Profile Inbox    |
#| ProConsultant| Application Inbox|
#| ProConsultant| Profile Inbox    |
#
#
#@RMSEN-1239 @Wip
#Scenario Outline: Verify Reply to email ID Text box is not visible when recruiter creates new send requirement template
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on add a new template option
#When I select send a requirement option
#Then Verify Reply to mail id Text box is not visible
#And I fill Template name,subject and mail body
#Then I click on save button to save template
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1239 @Wip
#Scenario Outline: Verify Reply to email ID Text box is  visible with remove and revert option when recruiter open existing new send requirement template
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on modified on
#When I select send a requirement filter
#And I click on edit option of first template
#And verify reply to mailid is visible and greyed out
#Then verify remove from template link is visible and on hover message also reflects
#When I click on Remove from template option
#Then Verify Reply to textbox become empty
#And I click on Revert Option reply to text box is filled with same email id as earlier
#Then I click on save button
#And Verify Template saved successfully
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1239 @Wip
#Scenario Outline: Verify Remove option for Reply to text box removes email ID Text box is  visible when recruiter open existing new send requirement template
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on modified on
#When I select send a requirement filter
#And I click on edit option of first template
#And verify reply to mailid is visible and greyed out
#Then verify remove from template link is visible and on hover message also reflects
#When I click on Remove from template option
#Then Verify Reply to textbox become empty
#Then I click on save button
#And Open same mail template again
#Then Verify Reply to text box is not visible
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1239 @Wip
#Scenario Outline: Verify Reply to email ID Text box not visible when recruiter creates template from existing template having
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on add a new template option
#When I select send a requirement option
#Then Verify Reply to mail id Text box is not visible
#When I fill Template name and existing template having reply to mail id
#And Verify reply to mail id text box is not visible
#Then I click on save button to save template
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@RMSEN-1238 @Wip
#Scenario Outline: Verify Reply to email ID preferences if template selected contains reply to mail id
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#And I select a template having reply to mail id
#Then Verify Reply to mail id selected is same as for template
#And Verify I no longer see radio button for mail server
#Then Mail sent from reply to id selected from dropdown
#And Check drop down contains all the values configured mail id, recruiter mail id and Template reply to Email
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@Wip
#Scenario Outline: Verify valid email id checks for cc and reply to
#
#Given I login into RMS as an Enterprise user
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And User hover on the Email option on top panel of the inbox
#Then I should be able to see the Send A Requirement option in the hover list
#When I click the send a requirement option in hover list
#Then I should be redirected to send a requirement lightbox
#And I select a template having invalid reply to mail id
#Then Verify message "The email ID set in the template is invalid. Please choose a valid email ID"
#And Verify message when I fill email id as recipient "<recipient>" ,domain "<domain>" and topleveldomain "<topLevelDomain>" as "Please enter a valid email id"
#Then I open cc box by clicking on checkbox send copy of this mail
#And Verify message when I fill email id as recipient "<recipient>" ,domain "<domain>" and topleveldomain "<topLevelDomain>" as "Please enter a valid email id"
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button on sendRequirement
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#
#Examples:
#| recipient                         | domain           | topLevelDomain     |
#| 64 char                           | 253              | noSpecialChar      |
#| 65 char                           | 253              | noSpecialChar      |
#| 1 char                            | 253              | noSpecialChar      |
#| specialchar                       | 253              | noSpecialChar      |
#| specialchar                       | 253              | noSpecialChar      |
#| 1 char                            | 1                | noSpecialChar      |
#| 10 char                           | 254              | noSpecialChar      |
#| 65 char                           | 253              | noSpecialChar      |
#| 64 char                           | -                | noSpecialChar      |
#| 65 char                           | .                | noSpecialChar      |
#| 64 char                           | (a-z)(0-9)(A-Z)  | noSpecialChar      |
#| 64 char                           | (A-Z)(0-9)(a-z)  | noSpecialChar      |
#| 64 char                           | (0-9)(A-Z)(a-z)  | noSpecialChar      |
#| 64 char                           | (A-Z)(a-z)(0-9)  | noSpecialChar      |
#| consecutiveSpecialChar            | (a-z).(0-9)(A-Z) | noSpecialChar      |
#| (A-Z)(specialchar1)(specialchar2) | (a-z)-(0-9)(A-Z) | noSpecialChar      |
#| 64 char                           | (a-z)-(0-9)(A-Z) | noSpecialChar      |
#| 64 char                           | (a-z)(0-9).(A-Z) | noSpecialChar      |
#| 64 char                           | 253              | endWithSpecialChar |
#| 65 char                           | 253              | 1000char           |
#| 64 char                           | (a-z).(0-9)(A-Z) | noSpecialChar      |
#
