Feature: To verify the forward flow of RMS

  @RMS @RMSForwardFlow @id:1 @RMSApplications
  Scenario Outline: To verify the presence and functionality of forward flow icon from application inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "<inboxPage>" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    Examples: 
      | inboxPage           |
      | applicationInbox    |
      | profileListingInbox |
      | backupInboxPage     |

  @RMS @RMSForwardFlow @id:2 @RMSApplications
  Scenario: To verify the presence and functionality of forward flow icon from requirement inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    Then I should be able to see the forward option
    When I click on the forward option for requirement inbox
    Then User should be redirected to the forward lightbox

  @RMS @RMSForwardFlow @id:3 @RMSApplications
  Scenario: To verify view quota policy link on forward lightbox
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see " Note!  Resdex CVs moved to RMS after 21st May 2019 will consume additional CV access as per the Resdex policy. " on forward layout
    And I should be able to see "View Quota Policy" on forward as hyperlink
    When I click on view quota policy link
    Then I should be redirected to product promotion page
    And I should be able to see "Important Update: New Resdex to RMS CV Transfer Policy	" on product promotion page

  #Depricating for time being to find better approach
  #@RMS @RMSForwardFlow @id:4 @RMSApplications
  #Scenario: To verify the list of forward templates available under the template list of forward
  #Given I login into RMS as an "Enterprise" user
  #When User is on "applicationInbox" page
  #Then I should be able to see the forward option
  #When I click on the forward option
  #Then User should be redirected to the forward lightbox
  #When I read all the list of template
  #And I navigate to mail template listing page
  #When I select Forward option from the drop down
  #And I read the list of the mail templates
  #Then I should be able to see the same list when which was present on lightbox.
  
  @RMS @RMSForwardFlow @id:5 @RMSApplications
  Scenario: To verify the presence of DMARC information text under reply to mail id
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see " Note!  For all senders other than those using their own mail client, mails will be sent from naukriRMS.com to honour DMARC policies" under to fiedl

  @RMS @RMSForwardFlow @id:6 @RMSApplications
  Scenario: To verifty the visibilty of to, subject, mail body, include signature, save template, add company logo and update status field
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see "to" label with input field.
    And I should be able to see "subject" label with input field.
    And I should be able to see "mail body" label with input field.
    And I should be able to see "Include Signature" label with input field.
    And I should be able to see "save template" label with input field.
    And I should be able to see "add company logo" label with input field.
    And I should be able to see "update status field" label with input field.

  @RMS @RMSForwardFlow @id:7 @RMSApplications
  Scenario: To verify validation errors in forward lightbox
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    When User click on Send button
    Then I should be able to validation error under the "to" field
    And I should be able to validation error under the "subject" field
    And I should be able to validation error under the "body" field

  @RMS @RMSForwardFlow @id:8 @RMSApplications
  Scenario: To verify text editing functionality of body editor
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    When I click on "bold" button for editor
    Then I should see "bold" selected in DOM for the button
    When I click on "italic" button for editor
    Then I should see "italic" selected in DOM for the button
    When I click on "underline" button for editor
    Then I should see "underline" selected in DOM for the button
    When I click on "ordered list" button for editor
    Then I should see "ordered list" selected in DOM for the button
    When I click on "unordered list" button for editor
    Then I should see "unordered list" selected in DOM for the button

  @RMS @RMSForwardFlow @id:9 @RMSApplications
  Scenario: To verify text editing functionality of body editor
    Given I login into RMS as an "ProConsultant" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    When I click on "bold" button for editor
    Then I should see "bold" selected in DOM for the button
    When I click on "italic" button for editor
    Then I should see "italic" selected in DOM for the button
    When I click on "underline" button for editor
    Then I should see "underline" selected in DOM for the button
    When I click on "ordered list" button for editor
    Then I should see "ordered list" selected in DOM for the button
    When I click on "unordered list" button for editor
    Then I should see "unordered list" selected in DOM for the button

  @RMS @RMSForwardFlow @id:10 @RMSApplications
  Scenario: To verify the tag list in forward lightbox
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see the "Recruiter Tags" for "subject" field
    And I should be able to see the "Requirement Tags" for "subject" field
    And I should be able to see the "Recruiter Tags" for "body" field
    And I should be able to see the "Requirement Tags" for "body" field

  @RMS @RMSForwardFlow @id:11 @RMSApplications
  Scenario: To verify the tag list in forward lightbox
    Given I login into RMS as an "Company" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see the "Recruiter Tags" for "subject" field
    And I should be able to see the "Requirement Tags" for "subject" field
    And I should be able to see the "Recruiter Tags" for "body" field
    And I should be able to see the "Requirement Tags" for "body" field

  @RMS @RMSForwardFlow @id:12 @RMSApplications
  Scenario: To verify the tag list in forward lightbox
    Given I login into RMS as an "ProConsultant" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see the "Recruiter Tags" for "subject" field
    And I should be able to see the "Requirement Tags" for "subject" field for consultant
    And I should be able to see the "Recruiter Tags" for "body" field
    And I should be able to see the "Requirement Tags" for "body" field for consultant

  @RMS @RMSForwardFlow @id:13 @RMSApplications
  Scenario: To verify the absence of tags in case of multiple forward
    Given I login into RMS as an "ProConsultant" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I select all applications
    And I click on forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Choose Template"
    And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Mail Body"
    And I should not be able to "Insert Tags" against "subject"
    And I should not be able to "Insert Tags" against "body"

  @RMS @RMSForwardFlow @id:14 @RMSApplications
  Scenario: To verify the absence of tags in case of multiple forward
    Given I login into RMS as an "ProConsultant" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I select all applications
    And I click on forward option
    Then User should be redirected to the forward lightbox
    And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Choose Template"
    And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Mail Body"
    And I should not be able to "Insert Tags" against "subject"
    And I should not be able to "Insert Tags" against "body"

  @RMS @RMSForwardFlow @id:17 @RMSApplications @test
  Scenario: To verify prefill from forward template
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    When I click on prefill from templates
    And I select a template from list
    Then I should see the subject field filled
    And I should see the body field filled

  @RMS @RMSForwardFlow @id:18 @RMSApplications
  Scenario Outline: To verify the masking option present in consultant account
    Given I login into RMS as an "ProConsultant" user
    When I click on "Account Settings" by hovering on username
    And I navigate to the whitelabel settings.
    And I click on tab "Mail" on whitelabel settings
    And I uncheck all the checkboxes with label "Mask candidate name as present in RMS.", "Email ID and Phone Number of Candidates in CV", "Also mask the current company (as present in candidate profile in RMS) of the candidate."
    And I check the checkbox with label "<permissionName>"
    And I click on "Save" button on the footer
    And User navigate through GNB to "All Profiles" under "Profiles"
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    And I should see the masking checkbox present on the forward template with message "<messageDisplayedOnForwardTemplate>"
    When I check the masking checkbox on the forward lightbox
    Then I should be able to see the message as "Warning!: Candidate details will also be masked in excel and mail body as set by the superuser."
    Examples: 
      | permissionName                                                                                                                                           | messageDisplayedOnForwardTemplate             |
      | Mask candidate name as present in RMS.                                                                                                                   | Mask Candidate Name as set by the superuser.  |
      | Email ID and Phone Number of Candidates in CV,Mask primary and secondary email ID and phone no. of the candidate as present in candidate profile in RMS. | Mask Contact Details as set by the superuser. |
      | Email ID and Phone Number of Candidates in CV,Mask all email IDs and all phones present anywhere on the CV                                               | Mask Contact Details as set by the superuser. |

  @RMS @RMSForwardFlow @id:19 @RMSApplications
  Scenario: To verify the list of edit CV name before forward for consultant
    Given I login into RMS as an "ProConsultant" user
    When User navigate through GNB to "All Profiles" under "Profiles"
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When I "uncheck" the checkbox of Customize CV name when forwarding to client
    Then I should not be able to see the available name format list
    When I "check" the checkbox of Customize CV name when forwarding to client
    Then I should be able to see the available name format list of length 6
    And I should be able to see the list as "Serial-Number_First-Name_Last-Name,CV_First-Name_Last-Name,CV_Full-Name_Current-Designation,CV_Full-Name_Current-Company,CV_Full-Name_Current-Designation_Current-Company,CV_Full-Name_Current-Location_Consultant-Name"

  @RMS @RMSForwardFlow @id:20 @RMSApplications @test
  Scenario: To verify the success message of the forward flow from application inbox
    Given I login into RMS as an "Enterprise" user
    When User navigate through GNB to "All Profiles" under "Profiles"
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:21 @RMSApplications @test
  Scenario: To verify the reattachment of file on forward lightbox
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User selects a file as an attachment
    Then User should be able to see the name of file on forward lightbox
    When User deletes the attached file from forward lightbox
    Then User should not be able to see the name of file on forward lightbox
    When User selects a file as an attachment
    Then User should be able to see the name of file on forward lightbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:22 @RMSApplications
  Scenario: To verify the preview functionality and send from preview of Forward Flow
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User clicks on preview button of forward lightbox
    Then User should be able to see "Subject :" and forward mail subject entered
    And User should be able to see forward mail body entered
    When User clicks on "SEND MAIL" on preview of forward lightbox
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:23 @RMSApplications @test
  Scenario: To verify the preview functionality and close from preview of Forward Flow
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User clicks on preview button of forward lightbox
    Then User should be able to see "Subject :" and forward mail subject entered
    And User should be able to see forward mail body entered
    When User clicks on "CLOSE" on preview of forward lightbox
    Then User should be redirected to the forward lightbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:24 @RMSApplications
  Scenario: To verify the pre fill of excel tracker while using the forward template
    Given User login to the application "templateListingPage" using "Superuser" of "Enterprise" user
    When user click on "Add a New Template  " link
    And user select template type "Forward"
    Then user should be able to see the label "Forward"
    When user fill mandatory fields for other template
    And User selects the "2nd" excel tracker
    And user click on "Save" value
    Then verify created template is visible to user
    When User navigate through GNB to "All Profiles" under "Profiles"
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When I click on choose template DD
    And User selects the template created with excel tracker forward
    Then User should be able to see the excel tracker attached on forward template

  @RMS @RMSForwardFlow @id:25 @RMSApplications
  Scenario: To verify the validation error of to field for text
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    When User click on Send button
    Then User should be able to see the error message as "Invalid Email Id" under the to field
    When User fills in to field as "testacount@yopmail.com"
    When User click on Send button
    Then User should be able to see the error message as "Invalid Email Id" under the to field

  @RMS @RMSForwardFlow @id:26 @RMSApplications
  Scenario: To verify the CC functionality on forward flow template
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    When User clicks on Add Cc
    Then User should be able to see the cc field
    When User fills in CC field as "testaccount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:27 @RMSApplications
  Scenario: To verify the CC validation on forward flow template
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    When User clicks on Add Cc
    Then User should be able to see the cc field
    When User fills in CC field as "testaccount"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    When User click on Send button
    Then User should be able to see the error message as "Invalid Email Id" under the cc field

  @RMS @RMSForwardFlow @id:28 @RMSApplications
  Scenario: To verify the functionality of sender's name field in forward flow
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    Then User should be able to see the Senders Name text field
    And User should be able to see prefiled text
    When User clears the text of Senders Name
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:29 @RMSApplications
  Scenario Outline: To verify the validation of length and text in senders name field
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    Then User should be able to see the Senders Name text field
    When User clears the text of Senders Name
    When User fills the "<TypeOfText>" of 50 characters in Senders Name field
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."
    Examples: 
      | TypeOfText   |
      | String       |
      | Number       |
      | Alphanumeric |

  @RMS @RMSForwardFlow @id:30 @RMSApplications
  Scenario: To verify the disability of the preview button forward lightbox
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User should be able to see the preview button disabled on forward lightbox
    When User fills in the forward mail subject as "Forward Subject" in forward lightbox
    Then User should be able to see the preview button disabled on forward lightbox
    When User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User clicks on preview button of forward lightbox
    Then User should be able to see "Subject :" and forward mail subject entered
    And User should be able to see forward mail body entered
    When User clicks on "SEND MAIL" on preview of forward lightbox
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:31 @RMSApplications
  Scenario: To verify the include signature functionality of forward flow
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When User click on "Edit Signature" link on settings page
    Then User should be able to see a pop up with heading "Edit Signature"
    When User records the signature from the popup
    When User navigate through GNB to "All Profiles" under "Profiles"
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User should be able to see the preview button disabled on forward lightbox
    When User fills in the forward mail subject as "Forward Subject" in forward lightbox
    Then User should be able to see the preview button disabled on forward lightbox
    When User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User clicks on the Include Signature checkbox of forward lightbox
    And User clicks on preview button of forward lightbox
    Then User should be able to see "Subject :" and forward mail subject entered
    And User should be able to see forward mail body entered
    And User should also be able to see the signature read from the settings page
    When User clicks on "SEND MAIL" on preview of forward lightbox
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSForwardFlow @id:32 @RMSApplications
  Scenario: To verify the status change functionality from forward flow
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User selects "Applied-Matching" from update status of profile on forward flow
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."
    And User should see the status of candidate should be updated to "Applied - Matching" on inbox page

  @RMS @RMSForwardFlow @id:33 @RMSApplications
  Scenario: To verify the text information for status change DD present on forward lightbox on
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    Then User should be able to see the text "Note: If an application is not mapped to a requirement, change in status will not reflect on the application." on forward lightbox template

