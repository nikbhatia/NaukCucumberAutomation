#ture: To verify the forward flow of RMS
#
  #@RMS @RMSForwardFlow @id:1
  #Scenario Outline: To verify the presence and functionality of forward flow icon from application inbox
    #Given I login into RMS as an "Enterprise" user
    #When User is on "<inboxPage>" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #Examples:
      #| inboxPage           |
      #| applicationInbox    |
      #| profileListingInbox |
      #| backupInboxPage     |
#
  #@RMS @RMSForwardFlow @id:4
  #Scenario: To verify the presence and functionality of forward flow icon from requirement inbox
    #Given I login into RMS as an "Enterprise" user
    #When User is on "requirementInbox" page
    #And I go to requirement which has atleast one application
    #Then I should be able to see the forward option
    #When I click on the forward option for requirement inbox
    #Then User should be redirected to the forward lightbox
#
  #@RMS @RMSForwardFlow @id:5
  #Scenario: To verify view quota policy link on forward lightbox
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see " Note!  Resdex CVs moved to RMS after 21st May 2019 will consume additional CV access as per the Resdex policy. " on forward layout
    #And I should be able to see "View Quota Policy" on forward as hyperlink
    #When I click on view quota policy link
    #Then I should be redirected to product promotion page
    #And I should be able to see "Important Update: New Resdex to RMS CV Transfer Policy	" on product promotion page
#
  #@RMS @RMSForwardFlow @id:6
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
#
  #@RMS @RMSForwardFlow @id:6
  #Scenario: To verify the presence of DMARC information text under reply to mail id
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see " Note!  For all senders other than those using their own mail client, mails will be sent from naukriRMS.com to honour DMARC policies" under to fiedl
#
  #@RMS @RMSForwardFlow @id:7
  #Scenario: To verifty the visibilty of to, subject, mail body, include signature, save template, add company logo and update status field
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see "to" label with input field.
    #And I should be able to see "subject" label with input field.
    #And I should be able to see "mail body" label with input field.
    #And I should be able to see "Include Signature" label with input field.
    #And I should be able to see "save template" label with input field.
    #And I should be able to see "add company logo" label with input field.
    #And I should be able to see "update status field" label with input field.
#
  #@RMS @RMSForwardFlow @id:8
  #Scenario: To verify validation errors in forward lightbox
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #When User click on Send button
    #Then I should be able to validation error under the "to" field
    #And I should be able to validation error under the "subject" field
    #And I should be able to validation error under the "body" field
#
  #@RMS @RMSForwardFlow @id:9
  #Scenario: To verify text editing functionality of body editor
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #When I click on "bold" button for editor
    #Then I should see "bold" selected in DOM for the button
    #When I click on "italic" button for editor
    #Then I should see "italic" selected in DOM for the button
    #When I click on "underline" button for editor
    #Then I should see "underline" selected in DOM for the button
    #When I click on "ordered list" button for editor
    #Then I should see "ordered list" selected in DOM for the button
    #When I click on "unordered list" button for editor
    #Then I should see "unordered list" selected in DOM for the button
#
  #@RMS @RMSForwardFlow @id:10
  #Scenario: To verify text editing functionality of body editor
    #Given I login into RMS as an "ProConsultant" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #When I click on "bold" button for editor
    #Then I should see "bold" selected in DOM for the button
    #When I click on "italic" button for editor
    #Then I should see "italic" selected in DOM for the button
    #When I click on "underline" button for editor
    #Then I should see "underline" selected in DOM for the button
    #When I click on "ordered list" button for editor
    #Then I should see "ordered list" selected in DOM for the button
    #When I click on "unordered list" button for editor
    #Then I should see "unordered list" selected in DOM for the button
#
  #@RMS @RMSForwardFlow @id:11
  #Scenario: To verify the tag list in forward lightbox
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see the "Recruiter Tags" for "subject" field
    #And I should be able to see the "Requirement Tags" for "subject" field
    #And I should be able to see the "Recruiter Tags" for "body" field
    #And I should be able to see the "Requirement Tags" for "body" field
#
  #@RMS @RMSForwardFlow @id:12
  #Scenario: To verify the tag list in forward lightbox
    #Given I login into RMS as an "Company" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see the "Recruiter Tags" for "subject" field
    #And I should be able to see the "Requirement Tags" for "subject" field
    #And I should be able to see the "Recruiter Tags" for "body" field
    #And I should be able to see the "Requirement Tags" for "body" field
#
  #@RMS @RMSForwardFlow @id:13
  #Scenario: To verify the tag list in forward lightbox
    #Given I login into RMS as an "ProConsultant" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see the "Recruiter Tags" for "subject" field
    #And I should be able to see the "Requirement Tags" for "subject" field for consultant
    #And I should be able to see the "Recruiter Tags" for "body" field
    #And I should be able to see the "Requirement Tags" for "body" field for consultant
#
  #@RMS @RMSForwardFlow @id:14
  #Scenario: To verify the absence of tags in case of multiple forward
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I select all applications
    #And I click on forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Choose Template"
    #And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Mail Body"
    #And I should not be able to "Insert Tags" against "subject"
    #And I should not be able to "Insert Tags" against "body"
#
  #@RMS @RMSForwardFlow @id:15
  #Scenario: To verify the absence of tags in case of multiple forward
    #Given I login into RMS as an "ProConsultant" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I select all applications
    #And I click on forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Choose Template"
    #And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Mail Body"
    #And I should not be able to "Insert Tags" against "subject"
    #And I should not be able to "Insert Tags" against "body"
#
  #@RMS @RMSForwardFlow @id:16
  #Scenario: To verify the absence of tags in case of multiple forward
    #Given I login into RMS as an "Company" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I select all applications
    #And I click on forward option
    #Then User should be redirected to the forward lightbox
    #And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Choose Template"
    #And I should be able to see "Note!  Templates with tags will not be available for multiple profiles forwarded from 'All Profiles/Applications" under "Mail Body"
    #And I should not be able to "Insert Tags" against "subject"
    #And I should not be able to "Insert Tags" against "body"
#
  #@RMS @RMSForwardFlow @id:17
  #Scenario: To verify prefil from template functionality
    #Given I login into RMS as an "Enterprise" user
    #When I navigate to mail template listing page
    #And I click on add a new template option
    #And I select the "Forward" option
    #And I click on Next button on template selection popup
    #And I fill in the "template name" of the mail
    #And I fill in the "subject" of the mail
    #And I fill in the "body" of the mail
    #And I click on save button on the lightbox
    #And I navigate to application inbox
    #Then I should be able to see the forward option
    #When I select all applications
    #And I click on forward option
    #Then User should be redirected to the forward lightbox
    #When I click on choose template DD
    #And I select the template that I created
    #Then I should be able to see the template name created
    #And I should see the subject I entered
    #And I should see the mail body I entered
#
  #@RMS @RMSForwardFlow @id:18
  #Scenario: To verify prefill from forward template
    #Given I login into RMS as an "Enterprise" user
    #When User is on "applicationInbox" page
    #Then I should be able to see the forward option
    #When I click on the forward option
    #Then User should be redirected to the forward lightbox
    #When I click on prefill from templates
    #And I select a template from list
    #Then I should see the subject field filled
    #And I should see the body field filled
