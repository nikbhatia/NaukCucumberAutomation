Feature: Test Scenarios of candidate communication

  Author: nikhil.bhatia@naukri.com

  @id:1 @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: Verify Email for send message to candidate is displayed inside Mail Box for candidate commnucation
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Updated Subject      | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And I verify the mail count is changed
    Then User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then I see conversations between recruiter and candidate
    And Verify subject of mail as heading
    And Verify RequirementName is displayed
    And Verify ThreadSubject is displayed
    And Verify MailboxTabCount is displayed
    And Verify the arrow for incoming mail or outgoing mail.
    And Verify date and time of the email sent and recieved.
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|


  @id:2 @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: Verify Email for send Requirement to candidate is displayed inside Mail Box for candidate commnucation
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And User fill in the subject field as "Updated Subject"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Success! Mail has been sent." on application inbox
    And I verify the mail count is changed
    Then User click on mailboxtab
    Then I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|

  @id:3 @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: To verify Forward functionality for candidate Communication
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And User click on forward Mail option
    Then User should be redirected to the forward lightbox
    And User fill in the subject field as "Updated Subject"
    And User type in the forward mail body "testMailBodyText"
    Then User add To field as "nik@mailsac.com"
    And User click on Send button
    Then User click on mailboxtab
    And Verify ThreadSubject is not displayed as "Updated Subject"
    And I verify the mail count is not changed
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|

  @id:4 @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: To verify Request Document mails for candidate Communication
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I click on Request Document option
    And I click on Document List dropdown
    And I select option as "Select All"
    Then I click on Request Button
    And User fill in the subject field as "Updated Subject"
    And I click on Term and Condition check box
    And I click on "SEND MAIL"
    And I verify the mail count is changed
    Then User click on mailboxtab
    Then I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.
    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|

  @id:5  @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: Verify status change mail and reply all fuctionality on mailbox tab for Applied-Not Matching
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When I navigate to Settings page
    Then I remove Automatic mailer for "Applied-Not Matching" stage.
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I move the candidate to "Applied - Not Matching" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    Then User click on mailboxtab
    Then I apply filter "Status change email sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
    And I click on replyAll button from status change message
    Then I check email id's in To field
    Then I fill message body and send the message
    And Verify message is listing under same subject on top and hover message for recently sent is displayed
    And Verify mailBlock for status change "Applied - Not Matching" By Logged in recruiter
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

    Examples:
      | userType    |
      |Enterprise   |
      |Company      |
      |ProConsultant|


  @id:6 @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: Verify Interview scheduling mail on mailbox tab for Interview stage
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When I navigate to Settings page
    Then I remove Automatic mailer for "Interview-Round 1" stage.
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I move the Candidate to "Interview - Round 1" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And I verify the mail count is changed
    Then User click on mailboxtab
    Then I apply filter "Interview invite sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
    And I click on replyAll button from status change message
    Then I check email id's in To field
    Then I fill message body and send the message
    And Verify message is listing under same subject on top and hover message for recently sent is displayed
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

    Examples:
      | userType    |
      |Enterprise2  |
#     |Company      |
#     |ProConsultant|

  @id:7  @CandidateCommunication @Wip @Mailer @RMSCCInbox
 Scenario Outline: Verify status change mail and reply functionality on mailbox tab for applied matching
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When I navigate to Settings page
    Then I remove Automatic mailer for "Applied-Matching" stage.
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I move the candidate to "Applied - Matching" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And I verify the mail count is changed
    Then User click on mailboxtab
    Then I apply filter "Status change email sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
    And I click on replyAll button from status change message
    Then I check email id's in To field
    Then I fill message body and send the message
    And Verify message is listing under same subject on top and hover message for recently sent is displayed
    And Verify mailBlock for status change "Applied - Matching" By Logged in recruiter
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
#     |ProConsultant|

  @id:8  @CandidateCommunication @RMSCCInbox @AddedRecently
 Scenario Outline: Verify Super user is able to revoke permission for masking and unmasking candidate replies in mailbox tab
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I navigate to Settings page
    Then I click on Manage Profile
    And I "Revoke Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    When User Click on "View All Conversation" visible on the top
    Then User switches to new window
    And  Verify MailboxTab is displayed
    Then User click on mailboxtab
    And I click on replyAll button from status change message
    And Verify replyAll Button Is disabled

    Examples:
      | userType    |
      |Enterprise2  |
#      |Company      |
#      |ProConsultant|


  @id:9  @CandidateCommunication @RMSCCInbox @AddedRecently
 Scenario Outline: Verify Super user is able to grant permission for masking and unmasking candidate replies in mailbox tab
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I navigate to Settings page
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    When User Click on "View All Conversation" visible on the top
    Then User switches to new window
    And  Verify MailboxTab is displayed
    And User click on mailboxtab
    And I click on replyAll button from status change message
    Then I check email id's in To field
    And Verify replyAll Button Is enabled

    Examples:
      | userType    |
      |Enterprise2  |


  @id:10  @CandidateCommunication @RMSCCInbox @AddedRecently
 Scenario Outline: Verify Super user is able to enable permission for sub-user to send and view candidate emails in RMS
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I navigate to "Enterprise" Open Manage Permissions for any recruiter
    And I search subuser
    And I click on manage permissions for the searched recruiter
    Then I should be able to see "Log email conversations in RMS" in manage permission light box
    When I turn the "Log email conversations in RMS" permission button to "on"
    When  User is on "groupListing" page
    And   User add group with "enterprise2_subuser1@yopmail.com" as HR and also as HRSpoc, "mansi" as HM and "mansi" as HMSpoc
    And   User is on "addANewRequirement" page
    And   I create a requirement with "Visible to Only Me"
    And   User click on the tab "Edit" on requirement overview page
    And   User fill Group Details for a Requirement
      | GroupName | Visible to all in the group |
    And   User click on the tab "Next" on requirement overview page
    And   User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And   User chose "Functional Area" as "Banking / Insurance"
    And   User chose "Role" as "Cash Officer"
    And   User click on the tab "Save Requirement" on requirement overview page
    And   User click on More and Select Add Single Profile option on Requirement Overview Page
    And   I fill details of the candidate
    And   I click on Save button
    And   User updates the value of Url formed for cv detail page.
    And   User move to cv detail page of candidate.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Updated Subject      | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And   User logout from application
    And   User login to the application "CCInboxPage" using "Subuser" of "Enterprise2" user
    When I navigate to Settings page
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    Then User move to cv detail page of candidate.
    Then User click on mailboxtab
    And I click on replyAll button from status change message
    Then I check email id's in To field
    And Verify replyAll Button Is enabled

    Examples:
      | userType   |
      | Enterprise2|

  @id:11 @CandidateCommunication @RMSCCInbox @AddedRecently
  Scenario: Verify Sub-User is able to grant permission for masking and unmasking candidate replies in mailbox tab
    Given "Enterprise" user is on Settings Page with "Superuser"
    When I navigate to Settings page
    And I navigate to "Enterprise" Open Manage Permissions for any recruiter
    And I search subuser
    And I click on manage permissions for the searched recruiter
    Then I should be able to see "Log email conversations in RMS" in manage permission light box
    When I turn the "Log email conversations in RMS" permission button to "on"
    When  User is on "groupListing" page
    And   User add group with "enterprise2_subuser1@yopmail.com" as HR and also as HRSpoc, "mansi" as HM and "mansi" as HMSpoc
    And   User is on "addANewRequirement" page
    And   I create a requirement with "Visible to Only Me"
    And   User click on the tab "Edit" on requirement overview page
    And   User fill Group Details for a Requirement
      | GroupName | Visible to all in the group |
    And   User click on the tab "Next" on requirement overview page
    And   User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And   User chose "Functional Area" as "Banking / Insurance"
    And   User chose "Role" as "Cash Officer"
    And   User click on the tab "Save Requirement" on requirement overview page
    And   User click on More and Select Add Single Profile option on Requirement Overview Page
    And   I fill details of the candidate
    And   I click on Save button
    And   User updates the value of Url formed for cv detail page.
    And   User move to cv detail page of candidate.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Updated Subject      | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And   User logout from application
    And   User login to the application "CCInboxPage" using "Subuser" of "Enterprise2" user
    When I navigate to Settings page
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    Then User move to cv detail page of candidate.
    Then User click on mailboxtab
    And I click on replyAll button from status change message
    And Verify replyAll Button Is enabled


  @id:12  @CandidateCommunication @RMSCCInbox
  Scenario: Verify no mails to show when no mails exist for candidate
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "addSingleProfile" page
    When I fill details of the candidate
    And I click on Save button
    Then I should be directed to the CV details page
    And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page
    Then User click on mailboxtab
    And Verify no mails to show is displayed

  @id:13 @E2E @RMSCCInbox
  Scenario Outline: Verify Master profile and unmapped profile tuples and mails are present under mailbox tab in mapped appliation
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    And User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And I search for the candidate for master profile with "email"
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    Then I am able to see the add to requirement option
    When I click on the add to requirement option
    Then I should be able to see the lightbox with title "Add to Requirement"
    When I chose a requirement name from requirement DD
    And I click on Add button on layout
    And refresh the page
    And User click on candidate and move to candidate page
    And User click on the View button of Other Requirement box on the right side of CV Details page
    And User click on mailboxtab
    Then Verify no mails to show is displayed
    When User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And User click on mailboxtab
    Then user Verify "MasterProfile Block" is visible
    And User Verify Last active and No of emails is displayed on the tuple
    And user Verify "MasterProfile MailBox" is visible
    And user Verify "UnMappedProfile Block" is visible
    And user Verify "UnMappedProfile MailBox" is visible

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|

  @id:14 @RMSCCInbox
 Scenario Outline: To verify bulk send a message is tracked under mailbox tab
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User is on "applicationInbox" page
    When click on Select all candidate checkbox
    When User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    Then I should be able to see the success ribbon with a message as "Mail sent succesfully"
    And User click on candidate and move to candidate page
    Then User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|

  @id:15 @RMSCCInbox
 Scenario Outline: To verify bulk send a requirement is tracked under mailbox tab
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User is on "applicationInbox" page
    When click on Select all candidate checkbox
    When User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And User fill in the subject field as "Updated Subject"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Success! Mail has been sent." on application inbox
    And User click on candidate and move to candidate page
    Then User click on mailboxtab
    Then I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And Verify ThreadSubject is displayed as "Updated Subject"

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|

  @id:16  @CandidateCommunication @RMSCCInbox @NewlyAdded
  Scenario Outline: Verify signature under mailbox tab
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When I navigate to Settings page
    Then User clicks on Edit Signature
    And User sets the signature as "Regards,Lokesh"
    And click on save signature
    When User is on "applicationInbox" page
    And User click on candidate and move to candidate page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And User fill in the subject field as "Updated Subject"
    And click on "Include signature" on offer details page
    And I click on "PREVIEW"
    Then I should be able to see the message body and message subject on preview layout
    And I should be able to see the "SEND MAIL" and "CLOSE" buttons on the layout footer
    When I click on "SEND MAIL" button
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab for unmapped profile
    And Verify signature "Regards,Lokesh" is visible in mail under mailbox tab

    Examples:
      | userType    |
      |Enterprise2  |
      |Company      |
      |ProConsultant|


  @id:17  @CandidateCommunication @RMSCCInbox @NewlyAdded @AddedRecently
  Scenario Outline: Verify expand all and candidate tags under mailbox tab
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When User is on "applicationInbox" page
    And User click on candidate and move to candidate page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And User fill in the subject field as "Updated Subject"
    And click on "Include signature" on offer details page
    And I click on "PREVIEW"
    Then I should be able to see the message body and message subject on preview layout
    And I should be able to see the "SEND MAIL" and "CLOSE" buttons on the layout footer
    When I click on "SEND MAIL" button
    And I verify the mail count is changed
    Then User click on mailboxtab
    And I click on replyAll button from status change message
    Then I should be able to see DD with text tags
    When I click on tags DD
    Then I should be able to see "Candidate" group text
    Then User click on candidate email tag
    And Verify Expand All functionality
    And User click on mailboxtab
    And User Get the information for mail sent from mailbox tab for unmapped profile
    And Verify Message contains email id of candidate

    Examples:
      | userType    |
      |Enterprise2  |

  @id:18 @CandidateCommunication @RMSCCInbox @AddedRecently
  Scenario: Verify Super user is able to disable permission for sub-user to send and view candidate emails in RMS
    Given "Enterprise" user is on Settings Page with "Superuser"
    When I navigate to Settings page
    And I navigate to "Enterprise" Open Manage Permissions for any recruiter
    Then I search subuser
    And I click on manage permissions for the searched recruiter
    Then I should be able to see "Log email conversations in RMS" in manage permission light box
    When I turn the "Log email conversations in RMS" permission button to "off"
    When  User is on "groupListing" page
    And   User add group with "enterprise2_subuser1@yopmail.com" as HR and also as HRSpoc, "mansi" as HM and "mansi" as HMSpoc
    And   User is on "addANewRequirement" page
    And   I create a requirement with "Visible to Only Me"
    And   User click on the tab "Edit" on requirement overview page
    And   User fill Group Details for a Requirement
      | GroupName | Visible to all in the group |
    And   User click on the tab "Next" on requirement overview page
    And   User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And   User chose "Functional Area" as "Banking / Insurance"
    And   User chose "Role" as "Cash Officer"
    And   User click on the tab "Save Requirement" on requirement overview page
    And   User click on More and Select Add Single Profile option on Requirement Overview Page
    And   I fill details of the candidate
    And   I click on Save button
    And   User updates the value of Url formed for cv detail page.
    And   User move to cv detail page of candidate.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Updated Subject      | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And   User logout from application
    And  User login to the application "CCInboxPage" using "Subuser" of "Enterprise2" user
    When I navigate to Settings page
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    Then User move to cv detail page of candidate.
    Then User click on mailboxtab
    And I click on replyAll button from status change message
    And Verify replyAll Button Is disabled

  @id:14 @Wip @Mailer
  Scenario: To verify Bulk Forward mailers subject and content
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on All profiles page
    And User select the first candidate checkbox
    And User click on forward Mail option
    Then User should be redirected to the forward lightbox
    Then User add To field as "nik@mailsac.com"
    And User fill in the subject field as "Updated Subject"
    And User type in the forward mail body "testMailBodyText"
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.

  @id:15 @Wip @Mailer
  Scenario: To verify Bulk message mailers subject and content
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on All profiles page
    Then User searched mailid "nikhil@mailsac.com" from search bar at top of the page
    And User select the first profile checkbox
    And User click on message option
    Then User should be redirected to the message lightbox
    And User fill in the subject field as "Updated Subject"
    And User type in the mail body "testMailBodyText"
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    Then User navigate to CV Details Page of particular candidate
    Then User click on mailboxtab
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.

  @id:16 @Wip @Mailer
  Scenario: To verify Bulk send a requirement mailers subject and content
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on All profiles page
    Then User searched mailid "nikhil@mailsac.com" from search bar at top of the page
    And User select the first profile checkbox
    And User click on send a requirement option
    Then User should be redirected to the message lightbox
    And User fill in the subject field as "Updated Subject"
    And User type in the mail body "testMailBodyText"
    Then User select a requirement from dropdown to send
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    Then User navigate to CV Details Page of particular candidate
    Then User click on mailboxtab
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.

  @id:17 @Wip @Mailer
  Scenario: To verify Bulk status change mailers subject and content for Interview Round
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on Requirement Inbox page containing multiple applications.
    And User select the first application checkbox
    And User click on change status option
    Then User should be redirected to the status change lightbox
    Then User Change the status to "Interview-Round1"
    Then User click on Update Button.
    Then User click on Send Email Button
    And User fill in the subject field as "Updated Subject"
    And User type in the mail body "testMailBodyText"
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.

  @id:18 @Wip @Mailer
  Scenario: To verify Bulk status change mailers subject and content for Non-Interview Round
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on Requirement Inbox page containing multiple applications.
    And User select the first application checkbox
    And User click on change status option
    Then User should be redirected to the status change lightbox
    Then User Change the status to "Interview-Round1"
    Then User click on Update Button.
    Then User click on Send Email Button
    And User fill in the subject field as "Updated Subject"
    And User type in the mail body "testMailBodyText"
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.

  @id:19 @Wip @Mailer
  Scenario: To verify requirement notification mailers subject and content
    Given "Enterprise" user is on Settings Page with "Superuser"
    Then User click on add a new requirement
    And User select the first application checkbox
    And User fill all mandatory fields
    Then User select group as "something"
    Then User Change the visibility to "visible to all in the group"
    Then User click on checkbox for notify recruiters for assignment of requirement.
    Then User click on Add requirement
    And User will be redirected to additional details page
    And User fill the mandatory fields.
    And User click on save requirement button
    Then Open Personal MailBox for hr spoc of that group
    And Verify Content and subject sent to the hrspoc from RMS.

  @id:20   @Wip @Mailer
  Scenario: Verify Interview cancellation mail for Interview stage
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview - Round 1" Stage
    And User fill in the subject field as "Updated Subject"
    And User fill in the Body field of Mail Template
    And User verify the mail count is changed
    Then User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    And User click on reply button from status change message
    Then User fill message body and send the message
    And Verify message is listing under sise subject on top and hover message for recently sent is displayed
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.
    Then User reschedule the Interview by going on sise application
    Then User click on Set button
    Then Open Personal MailBox for hm
    And Verify Content and subject of cancellation mail sent to the hm from RMS.
    Then Open Personal MailBox for candidate
    And Verify Content and subject of cancellation mail sent to the candidate from RMS.

  @id:21   @Wip @Mailer
  Scenario: Verify Rejection mail on status-change stages
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Applied-Not Matching" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the candidate to "Applied - Not Matching" Stage
    Then User click on Send Email Button
    And User fill in the subject field as "Updated Subject"
    And User fill in the Body field of Mail Template
    And User verify the mail count is changed
    Then User click on reject button near status change drop down
    Then User click on Update Button.
    Then User click on Send Email Button
    And User fill in the subject field as "Updated Subject"
    And User type in the mail body "testMailBodyText"
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate for rejection from RMS.

  @id:22   @Mailer @Wip
  Scenario: Verify Advance Interview scheduling mailer for Interview stage to candidate
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview - Round 1" Stage
    And User see Advance Interview scheduling mailbox
    Then User select the Hiring Manager "hm@mailsac.com" from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    And User fill in the Body field of Mail Template
    Then User click on send Mail
    And User verify the mail count is changed
    Then User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    And User click on reply button from status change message
    Then User fill message body and send the message
    And Verify message is listing under sise subject on top and hover message for recently sent is displayed
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.
    And User move the Candidate to "Interview - Round 1" Stage
    And User see Advance Interview scheduling mailbox
    Then User select the Hiring Manager "hm@mailsac.com" from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    And User fill in the Body field of Mail Template
    Then User click on send Mail
    Then Open Personal MailBox for hm
    And Verify Content and subject of cancellation mail sent to the hm from RMS.
    Then Open Personal MailBox for candidate
    And Verify Content and subject of cancellation mail sent to the candidate from RMS.


  @id:23   @Mailer @Wip
  Scenario: Verify Automatic mailer for Non-Interview stage
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    Then User add Automatic mailer for "Applied-Matching" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Applied-Matching" Stage
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.


  @id:24   @Mailer @Wip
  Scenario: Verify Automatic mailer for Interview stage
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    Then User add Automatic mailer for "Interview-Round1-TelephonicRound" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1-TelephonicRound" Stage
    Then Open Personal MailBox for candidate
    And Verify Content and subject sent to the candidate from RMS.

  @id:25   @Mailer @Wip
  Scenario: Verify Hm Interview mail and Feedback Cron mailer for any Interview stage
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview - Round 1" Stage
    Then User Click on Forward to Hiring Manager
    Then User fill in the Mail id of hm in To  field
    And User fill in the subject field as "Updated Subject"
    And User fill in the Body field of Mail Template
    And User click on Send Button at the Bottom
    Then Open Personal MailBox for hm
    And Verify Content and subject of interview mail sent to the hm from RMS.
    Then Wait for 15 minutes after end of Interview or Hit the Cron
    Then Open Personal MailBox for hm
    And Verify Content and subject of feedback mail sent to the hm from RMS.

  @id:26   @Mailer @Wip
  Scenario: Verify Welcome mailer,security mailer for hm
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to NaukrUser page
    Then User click on manage sub users.
    Then User click on add user
    Then lightbox opens up for adding new user
    And User fill the necessary details like "email id" and role as "hiring manager"
    Then Open Personal MailBox for hiringmanager
    And Verify Content and subject sent to the hm for welcome mailer from RMS.
    Then Set Password for hm from mailer link
    Given User login into RMS as an "new hm" user
    Then Open Personal MailBox for hiringmanager
    And Verify Content and subject sent to the hm for security mailer from RMS.

  @id:27   @Mailer @Wip
  Scenario Outline: To Verify Super user is able to see mail for delinking of social account "<userType>"
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User navigate to Settings page
    And User navigate to link social account
    And User click on Link "<userType>"
    And User open the manage permissions for searched recruiter
    Then User should be able to see "Log email conversations in RMS" in manage permission light box
    When User turn the "Log email conversations in RMS" permission button to "on"
    And User login into RMS as an "Enterprise" subuser
    When User navigate to Settings page
    Then User click on Manage Profile
    And User "Grant Permission" to mask and unmask candidate mails
    Then User navigate to CV Details Page of particular candidate
    Then User click on mailboxtab
    And User click on reply button from status change message
    And Verify Reply Button Is enabled

    Examples:
      | userType      |
      | LinkedIn    |
      | Twitter       |
      | Facebook |

  @id:28  @Wip
  Scenario Outline: To verify recruiter is able to see updated locations for requirement on requirement tuple of cv details page
    Given User login into RMS as an "<userType>" user
    When User hover on Requirements Tab and click on Add A New Requirement
    Then User Fill mandatory details to create requirement
    Then User click on Add Requirement
    And  User Fill Education qualifications and Job Categorization
    When User select location for the requirement from drop-down
    Then User click on Save Requirement
    And  Verify  Requirement is created successfully
    Then User hover on More option and click on add single profile
    And  User Fill candidate nise and email address
    Then User click on Add Candidate
    And  Verify profile has been successfully created
    Then User click on mailboxtab
    And  Check location displayed on sticky requirement tuple
    Then User Click on Requirement link on the sise application page
    And  Verify User is on Requirement Dashboard
    Then User Click on Edit Button
    And  User Edit Locations to "Noida"
    Then User click on Next Button
    And  Verify User is on Other Details Page for Requirement
    Then User click on Save Requirement
    And  Verify User redirected to requirement dashboard
    Then  User click on number of mapped Applications
    When User open first mapped application for the requirement
    Then User click on mailboxtab
    And  User Verify Location is now updated on the sticky requirement tuple
    Examples:
      | userType     |
      | Enterprise   |
      | Company      |
      | ProConsultant|

  @id:29  @Wip
  Scenario Outline: To verify recruiter is able to see updated status of requirement  on requirement tuple of cv details page
    Given User login into RMS as an "<userType>" user
    When User hover on Requirements Tab and click on Add A New Requirement
    Then User Fill mandatory details to create requirement
    Then User click on Add Requirement
    And  User Fill Education qualifications and Job Categorization
    Then User click on Save Requirement
    And  Verify  Requirement is created successfully
    Then User hover on More option and click on add single profile
    And  User Fill candidate nise and email address
    Then User click on Add Candidate
    And  Verify profile has been successfully created
    Then User click on mailboxtab
    And  Check status of requirement displayed on sticky requirement tuple
    Then User Click on Requirement link on the sise application page
    And  Verify User is on Requirement Dashboard
    Then User hover on dropdown beside Status at the top and select requirement status as "<requirementStatus>" .
    And  User click on number of mapped Applications
    When User open first mapped application for the requirement
    Then User click on mailboxtab
    And  Verify Location is now updated on the sticky requirement tuple as "<requirementStatus>" .

    Examples:
      | requirementStatus   |  userType     |
      | Close               | Enterprise    |
      | Open                | Enterprise    |
      | On Hold             | Enterprise    |
      | Close               | Company       |
      | Open                | Company       |
      | On Hold             | Company       |
      | Close               | ProConsultant |
      | Open                | ProConsultant |
      | On Hold             | ProConsultant |


  @id:30  @Wip
  Scenario Outline: To verify recruiter is able to see updated Group for requirement on requirement tuple of cv details page
    Given User login into RMS as an "<userType>" user
    When User hover on Requirements Tab and click on Add A New Requirement
    Then User Fill mandatory details to create requirement
    When User select group from the drop-down
    Then User click on Add Requirement
    And  User Fill Education qualifications and Job Categorization
    Then User click on Save Requirement
    And  Verify Requirement is created successfully
    Then User hover on More option and click on add single profile
    And  User Fill candidate nise and email address
    Then User click on Add Candidate
    And  Verify profile has been successfully created
    Then User click on mailboxtab
    And  Check Group displayed on sticky requirement tuple
    Then User Click on Requirement link on the sise application page
    And  Verify User is on Requirement Dashboard
    Then User Click on Edit Button
    And  User Edit group by selecting it from drop-down
    Then User click on Next Button
    And  Verify User is on Other Details Page for Requirement
    Then User click on Save Requirement
    And  Verify User redirected to requirement dashboard
    Then  User click on number of mapped Applications
    When User open first mapped application for the requirement
    Then User click on mailboxtab
    And  User Verify Group is now updated on the sticky requirement tuple

    Examples:
      | userType     |
      | Enterprise   |
      | Company      |
      | ProConsultant|

  @id:31  @Wip
  Scenario Outline: To verify recruiter is able to see updated Requirement Nise for requirement on requirement tuple of cv details page
    Given User login into RMS as an "<userType>" user
    When User hover on Requirements Tab and click on Add A New Requirement
    And  User Fill requirement nise for requirement
    Then User Fill mandatory details to create requirement
    When User select group from the drop-down
    Then User click on Add Requirement
    And  User Fill Education qualifications and Job Categorization
    Then User click on Save Requirement
    And  Verify Requirement is created successfully
    Then User hover on More option and click on add single profile
    And  User Fill candidate nise and email address
    Then User click on Add Candidate
    And  Verify profile has been successfully created
    Then User click on mailboxtab
    And  Check Requirement Nise is displayed on sticky requirement tuple
    Then User Click on Requirement link on the sise application page
    And  Verify User is on Requirement Dashboard
    Then User Click on Edit Button
    And  User Edit Requirement Nise by filling in the text box
    Then User click on Next Button
    And  Verify User is on Other Details Page for Requirement
    Then User click on Save Requirement
    And  Verify User redirected to requirement dashboard
    Then  User click on number of mapped Applications
    When User open first mapped application for the requirement
    Then User click on mailboxtab
    And  User Verify Requirement Nise is now updated on the sticky requirement tuple
    Examples:
      | userType     |
      | Enterprise   |
      | Company      |
      | ProConsultant|

  @id:32  @Wip
  Scenario Outline: To verify recruiter is able to set signature and see signature in all messages sent on cv details page
    Given User login into RMS as an "<userType>" user
    When User navigate to Settings page
    Then User click on Edit Signature
    And Add signature as "Regards,RMSTesting"
    And User move to particular candidate details page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User click on mailboxtab
    And User open First Message at the Top and expand it .
    Then User Verify signature and mail body for the sise

    Examples:
      | userType     |
      | Enterprise   |
      | Company      |
      | ProConsultant|

  @id:33  @Wip @Mailer
  Scenario Outline: Verify Attachments,images for recruiter and candidate when Email for send message sent to candidate

    Given User login into RMS as an "<userType>" user
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User add Profile Picture for candidate and recruiter
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    Then User add Multiple attachments to mail
    When User click on "SEND MAIL" button
    Then User Open personal mailbox of candidate
    And Verify Mail is recieved to candidate with all attachment
    When Candidate Reply to recruiter mail
    Then User move to cv detail page of candidate
    And User verify the mail count is changed
    Then User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User Verify number of attchments visible without expansion
    When User click on message to expand
    Then Verify User see message body and link to download all attachments
    And User click on Download all attachments
    Then User verify Zip Created With valid Nise and contains all attachments sent
    Then User Open every attachment and verify it is opening or not
    And User verify Mail and Images for candidate and recruiter
    Then User move to "<personalMailbox>" of Candidate and preview all attachments recieved

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |


