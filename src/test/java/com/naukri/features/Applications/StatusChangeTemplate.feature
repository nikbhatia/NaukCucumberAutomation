#
#@Wip @RMSEN-1325
#Scenario Outline: To verify reply to for automated mailers when Template contains reply to mail id
#Given I login into RMS as "<userType>"
#When I navigate to Settings page
#Then I add Automatic mailer for non-Interview stage with template having reply to mail id
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#And Verify reply to mail id when candidate reply to that mail is same as in template set at non-interview stage
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @Mailer @RMSEN-1325
#Scenario Outline: To verify reply to for automated mailers when Template doesn't contains reply to mail id and outgoing mail is configured
#Given I login into RMS as "<userType>"
#When I navigate to Settings page
#Then I add Automatic mailer for non-Interview stage with template having reply to mail id
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#And Verify reply to mail id when candidate reply to that mail is same as configured mail id
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @Mailer @RMSEN-1325
#Scenario Outline: To verify reply to for automated mailers when Template doesn't contains reply to mail id and no outgoing mail is configured
#Given I login into RMS as "<userType>"
#When I navigate to Settings page
#Then I add Automatic mailer for non-Interview stage with template having reply to mail id
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#And Verify reply to mail id when candidate reply to that mail is same as logged in recruiter mail id
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @Mailer @RMSEN-1325
#Scenario Outline: To verify reply to in rejection cases for automated mailers when Template contains reply to mail id
#Given I login into RMS as "<userType>"
#When I navigate to Settings page
#Then I add Automatic mailer for rejection in non-Interview stage with template having reply to mail id
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#Then I login with respective HM for the requirement candidate is in
#And I move to application Page for candidate
#Then I reject the candidate
#And I move to personalMailbox of candidate
#Then Verify From containing company name and mail id as info@notifications.naukrirms.com
#And Verify reply to mail id when candidate reply to that mail is same as in template set at non-interview stage
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @Mailer @RMSEN-1325
#Scenario Outline: To verify reply to in rejection cases for automated mailers when Template doesn't contains reply to mail id and outgoing mail is configured
#Given I login into RMS as "<userType>" HM
#When I navigate to Settings page
#Then I add Automatic mailer for rejection in non-Interview stage with template having reply to mail id
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#Then I login with respective HM for the requirement candidate is in
#And I move to application Page for candidate
#Then I reject the candidate
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#Then Verify From containing company name and mail id as info@notifications.naukrirms.com
#And Verify reply to mail id when candidate reply to that mail is same as configured mail id set for HR Spoc
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @Mailer @RMSEN-1325
#Scenario Outline: To verify reply to for automated mailers when Template doesn't contains reply to mail id and no outgoing mail is configured
#Given I login into RMS as "<userType>"
#When I navigate to Settings page
#Then I add Automatic mailer for rejection in non-Interview stage with template that doesn't contain any reply to mail id
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#Then I login with respective HM for the requirement candidate is in
#And I move to application Page for candidate
#Then I reject the candidate
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#Then Verify From containing company name and mail id as info@notifications.naukrirms.com
#And Verify reply to mail id when candidate reply to that mail is same as of HRSpoc aligned to requirement
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @RMSEN-1327
#Scenario Outline: To verify header of email conatins company logo for automated mailers in case of status change mailer
#Given I login into RMS as "<userType>"
#Then I save logo in white label settings
#When I navigate to Settings page
#Then I add Automatic mailer for non-Interview stage
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#And Verify header of mail contains same logo as added
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@Wip @RMSEN-1327
#Scenario Outline: To verify header of email conatins company name for automated mailers in case of status change mailer
#Given I login into RMS as "<userType>"
#Then I remove logo in white label settings
#And I add company name in white label settings
#When I navigate to Settings page
#Then I add Automatic mailer for non-Interview stage
#When User is on "applicationInbox" page
#And I open cv detail page of first candidate
#And I move the Candidate to non-interview round Stage
#And I verify the mail count is changed
#And I move to personalMailbox of candidate
#And Verify header of mail contains same company name as added
#Then I redirected to cv detail page of candidate
#And User click on mailboxtab
#Then I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-1326 @Wip
#Scenario Outline: Verify deleted stages are not visible when recruiter creates template for status change non-interview rounds
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on add a new template option
#When I select status change option
#Then Verify in category dropdown there is no deleted stage
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
#@RMSEN-1326 @Wip
#Scenario Outline: Verify Templates for deleted stages are visible on listing page for email templates
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on modified on
#When I select status change filter
#Then Verify deleted stage template are visible in the list as were earlier
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@RMSEN-1326 @Wip
#Scenario Outline: Verify Template for deleted stages are  visible when recruiter creates template for status change from existing Template mapped with deleted stage
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on add a new template option
#When I select status change option
#Then Verify in category dropdown there is no deleted stage
#When I fill Template name and existing template mapped with deleted stage
#And Verify reply to mail id text box is not visible and other info filled up as in existing template
#Then I click on save button to save template
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#
#
#@RMSEN-4154 @Wip
#Scenario Outline: Verify Reply to email ID Text box is not visible when recruiter creates new status change template
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on add a new template option
#When I select status change option
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
#@RMSEN-4154 @Wip
#Scenario Outline: Verify Reply to email ID Text box is visible with remove and revert option when recruiter open existing status change template
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on modified on
#When I select status change filter
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
#@RMSEN-4154 @Wip
#Scenario Outline: Verify functionality of Remove option for (Reply to text box removes email ID Text box) is visible when recruiter open existing status change template
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on modified on
#When I select status change filter
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
#@RMSEN-4154 @Wip
#Scenario Outline: Verify Reply to email ID Text box not visible when recruiter creates template from existing template having
#
#Given I login into RMS as an "<userType>" user
#When I navigate to mail template listing page
#Then I click on add a new template option
#When I select status change option
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
#@RMSEN-4153 @RMSEN-1327 @Wip
#Scenario Outline: Verify Reply to email ID preferences ,(given outgoing mail id is configured )if template selected contains reply to mail id
#
#Given I login into RMS as an "<userType>" user
#Then I remove company logo from white label settings
#And I add company name in white label settings
#When User is on "applicationInbox" page
#And I move to first candidate cv details page
#And I change status on any non interview stage
#Then I should be able to see email candidate option
#When I click the email candidate option
#Then I should be redirected to status change lightbox
#Then I check checkox for company logo is checked by default
#And I select a template having reply to mail id
#Then Verify Reply to mail id selected is same as for template
#And Verify I no longer see radio button for mail server
#Then Mail sent from reply to id selected from dropdown
#And Check drop down contains all the values configured mail id, recruiter mail id and Template reply to Email
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#Then I move to personal mailbox of candidate and check header of email contains company name
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-4153 @RMSEN-1327 @Wip
#Scenario Outline: Verify Reply to email ID preferences if template selected doen'tvcontains reply to mail id and configured mail id doesn't exist
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#Then I add company logo from white label settings
#And I add company name in white label settings
#And I move to first candidate cv details page
#And I change status on any non interview stage
#Then I should be able to see email candidate option
#When I click the email candidate option
#Then I should be redirected to status change lightbox
#Then I check checkox for company logo is checked by default
#And I select a template does not have reply to mail id
#Then Verify Reply to mail id default selected in logged in recruiter mail id
#And Verify I no longer see radio button for mail server
#Then Mail sent from reply to id selected from textbox and not drop down
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#Then I move to personal mailbox of candidate and check header of email contains company logo
#
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#
#@RMSEN-4153  @Wip
#Scenario Outline: Verify Reply to email ID preferences for bulk ,(given outgoing mail id is configured )if template selected contains reply to mail id
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#And I click on checkbox for first candidate
#And I change status on any non interview stage
#Then I should be able to see email candidate option
#When I click the email candidate option
#Then I should be redirected to status change lightbox
#Then I check checkox for compnay logo is checked by default
#And I select a template having reply to mail id
#Then Verify Reply to mail id selected is same as for template
#And Verify I no longer see radio button for mail server
#When I see Default Reply to mail id selected is same as in selected template
#Then Mail sent from reply to id selected from dropdown
#And Check drop down contains all the values configured mail id, recruiter mail id and Template reply to Email
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button
#Then I should be able to see "Success! Mail has been sent." on application inbox
#And I verify the mail count is changed
#
#Examples:
#| userType     |
#| Enterprise   |
#| Company      |
#| ProConsultant|
#
#@RMSEN-4153  @Wip
#Scenario Outline: Verify Reply to email ID preferences for bulk ,(given outgoing mail id is configured )
#
#Given I login into RMS as an "<userType>" user
#When User is on "applicationInbox" page
#And I click on checkbox for first candidate
#And I change status on any non interview stage
#Then I should be able to see email candidate option
#When I click the email candidate option
#Then I should be redirected to status change lightbox
#Then I check checkox for company logo is checked by default
#Then Verify Reply to mail id selected is configured mail id
#And Verify I no longer see radio button for mail server
#Then Mail sent from reply to id selected from dropdown
#And Check drop down contains both the values configured mail id and recruiter mail id
#And I type in the mail body "testMailBodyText"
#And I click on "Send" button
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
#
