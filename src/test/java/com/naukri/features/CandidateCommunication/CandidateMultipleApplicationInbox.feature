Feature: To verify scenarios for visiility after linking of master,Unmapped and Mapped Profile

Background: To Create Master, Unmapped and Mapped Profile with single message
  Given User login into RMS as an "Enterprise" user
  When User is on "addSingleProfile" page
  When User fill details of the candidate
  And User click on Save button
  Then User should be directed to the CV details page
  And User hover on the Email option on top panel of the inbox
  Then User should be able to see the Message option in the hover list
  When User click on Message option
  And User fill in the body field
  And User fill in the subject field as "Updated Subject"
  When User click on "SEND MAIL" button
  When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
  Then User open first profile
  And User hover on the Email option on top panel of the inbox
  Then User should be able to see the Message option in the hover list
  When User click on Message option
  And User fill in the body field
  And User fill in the subject field as "Updated Subject"
  When User click on "SEND MAIL" button
  And User verify the mail count is changed
  Then User click on the add to requirement option
  And User choose First Requirement from the Requirement drop-down
  When User click on Add Button to map requirement to profile
  Then User verify Lightbox with success message for profile added to selected project is visible

  @wip @CCRequirement
  Scenario: Verify visibility of unmapped application tuple and actions on Mapped Profile
    And User click on mailboxtab
    Then User Scroll Down
    And Verify Unmappped Application Tuple is visible showing No of mails
    Then User click on Unmappped Application Tuple
    And User verify CreatedBy "CreatedBy",CreatedDate "CreatedDate" ,LastActive "LastActive" and No of Emails
    Then User click on first tuple of Unmapped Appplication containing mails
    And Verify No of mails shown under tuple and on the tuple are same
    Then User click on reply All Button
    And Verify message box opens up
    Then User click on cc option and add email id in the text box
    And User fill message body and click on Preview
    Then Verify Message Lightbox opens up
    And User click on send mail button
    Then Verify Message comes at the top
    When User click on Expand all button
    Then Verify To field for both messages is visible and cc field for message on top is visible

  @wip @CCRequirement
  Scenario: Verify visibility of master tuple and actions on Mapped Profile
    And User click on mailboxtab
    Then User Scroll Down
    And Verify Master Tuple is visible showing LastActive Date and no of mails
    Then User click on Master Tuple
    And Verify No of mails shown under tuple and on the tuple are same
    Then User click on reply All Button
    And Verify message box opens up
    Then User click on cc option and add email id in the text box
    And User fill message body and click on Preview
    Then Verify Message Lightbox opens up
    And User click on send mail button
    Then Verify Message comes at the top
    When User click on Expand all button
    Then Verify To field for both messages is visible and cc field for message on top is visible

  @wip @CCRequirement
  Scenario: Verify visibility of Unmapped Application tuple and actions on Master Profile
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User click on mailboxtab
    Then User Scroll Down
    And Verify Unmappped Application Tuple is visible showing No of mails
    Then User click on Unmappped Application Tuple
    And User verify CreatedBy "CreatedBy",CreatedDate "CreatedDate" ,LastActive "LastActive" and No of Emails
    Then User click on first tuple of Unmapped Appplication containing mails
    And Verify No of mails shown under tuple and on the tuple are same
    Then User click on reply All Button
    And Verify message box opens up
    Then User click on cc option and add email id in the text box
    And User fill message body and click on Preview
    Then Verify Message Lightbox opens up
    And User click on send mail button
    Then Verify Message comes at the top
    When User click on Expand all button
    Then Verify To field for both messages is visible and cc field for message on top is visible

  @wip @CCRequirement
  Scenario: Verify visibility of Requirement tuple and actions on Master Profile
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User click on mailboxtab
    Then User Scroll Down
    And  Verify Visibility of Requirement Tuple
    Then Verify RequirementStatus, Requirement name, Last Active, No of mails and Application status "Prospect" is visible
    Then User click on  tuple of Requirement containing mails
    Then User click on reply All Button
    And Verify message box opens up
    Then User click on cc option and add email id in the text box
    And User fill message body and click on Preview
    Then Verify Message Lightbox opens up
    And User click on send mail button
    Then Verify Message comes at the top
    When User click on Expand all button
    Then Verify To field for both messages is visible and cc field for message on top is visible

  @wip @CCRequirement
  Scenario: Verify visibility of Requirement tuple and actions on unmapped Profile
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User click on View Button to move to unmapped Profile
    And User click on mailboxtab
    Then User Scroll Down
    And  Verify Visibility of Requirement Tuple
    Then Verify RequirementStatus, Requirement name, Last Active, No of mails and Application status "Prospect" is visible
    Then User click on  tuple of Requirement containing mails
    Then User click on reply All Button
    And Verify message box opens up
    Then User click on cc option and add email id in the text box
    And User fill message body and click on Preview
    Then Verify Message Lightbox opens up
    And User click on send mail button
    Then Verify Message comes at the top
    When User click on Expand all button
    Then Verify To field for both messages is visible and cc field for message on top is visible

  @wip @CCRequirement
  Scenario: Verify visibility of master tuple and actions on unmapped Profile
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User click on View Button to move to unmapped Profile
    And User click on mailboxtab
    Then User Scroll Down
    And Verify Master Tuple is visible showing LastActive Date and no of mails
    Then User click on Master Tuple
    And Verify No of mails shown under tuple and on the tuple are same
    Then User click on reply All Button
    And Verify message box opens up
    Then User click on cc option and add email id in the text box
    And User fill message body and click on Preview
    Then Verify Message Lightbox opens up
    And User click on send mail button
    Then Verify Message comes at the top
    When User click on Expand all button
    Then Verify To field for both messages is visible and cc field for message on top is visible

  @wip @CCRequirement
  Scenario: Verify message Recieved from candidate on unmapped Profile with unread message verification
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User click on View Button to move to unmapped Profile
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User store the Url and open Personal Mailbox of candidate
    And User verify message is recieved and From mail id is masked containing hash
    Then User reply to Recruiter Mail from candidate personal Mailbox
    And User redirect to stored Url
    And User click on mailboxtab
    Then User verify mailcount for mail recieved is visible
    When User apply filter for mail recieved
    Then User verify Mail recieved is visible in blue background with Mark all as read and mark as read options
    And User click on mark all as read option
    Then Verify blue background of message disappears

  @wip @CCRequirement
  Scenario: Verify Reply button, Mark as Read on message Recieved from candidate on unmapped Profile
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User click on View Button to move to unmapped Profile
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User store the Url and open Personal Mailbox of candidate
    And User verify message is recieved and From mail id is masked containing hash
    Then User reply to Recruiter Mail from candidate personal Mailbox
    And User redirect to stored Url
    And User click on mailboxtab
    Then User verify mailcount for mail recieved is visible
    Then User verify Mail recieved is visible in blue background with Mark all as read and mark as read options
    And User click on mark as read option
    Then Verify blue background of message disappears
    Then User click on reply button
    And  User fill message body and send the message
    Then User verify message comes at the top with message on hover "This message is on its way. To confirm/ reply to this, please refresh the page"

  @wip @CCRequirement
  Scenario: Verify message Recieved from candidate on mapped Profile with unread message verification
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User store the Url and open Personal Mailbox of candidate
    And User verify message is recieved and From mail id is masked containing hash
    Then User reply to Recruiter Mail from candidate personal Mailbox
    And User redirect to stored Url
    And User click on mailboxtab
    Then User verify mailcount for mail recieved is visible
    When User apply filter for mail recieved
    Then User verify Mail recieved is visible in blue background with Mark all as read and mark as read options
    And User click on mark all as read option
    Then Verify blue background of message disappears

  @wip @CCRequirement
  Scenario: Verify Reply button, Mark as Read on message Recieved from candidate on mapped Profile
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User store the Url and open Personal Mailbox of candidate
    And User verify message is recieved and From mail id is masked containing hash
    Then User reply to Recruiter Mail from personal Mailbox
    And User redirect to stored Url
    And User click on mailboxtab
    Then User verify mailcount for mail recieved is visible
    Then User verify Mail recieved is visible in blue background with Mark all as read and mark as read options
    And User click on mark as read option
    Then Verify blue background of message disappears
    Then User click on reply button
    And  User fill message body and send the message
    Then User verify message comes at the top with message on hover "This message is on its way. To confirm/ reply to this, please refresh the page"

  @wip @CCRequirement
  Scenario: Verify message Recieved from candidate on master Profile with unread message verification
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User store the Url and open Personal Mailbox of candidate
    And User verify message is recieved and From mail id is masked containing hash
    Then User reply to Recruiter Mail from candidate personal Mailbox
    And User redirect to stored Url
    And User click on mailboxtab
    Then User verify mailcount for mail recieved is visible
    When User apply filter for mail recieved
    Then User verify Mail recieved is visible in blue background with Mark all as read and mark as read options
    And User click on mark all as read option
    Then Verify blue background of message disappears

  @wip @CCRequirement
  Scenario: Verify Reply button, Mark as Read on message Recieved from candidate on master Profile
    When User Enter EmailId of candidate in Master Profile search box at the top to search master profile
    Then User open first profile
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User fill in the body field
    And User fill in the subject field as "Updated Subject"
    When User click on "SEND MAIL" button
    And User verify the mail count is changed
    Then User store the Url and open Personal Mailbox of candidate
    And User verify message is recieved and From mail id is masked containing hash
    Then User reply to Recruiter Mail from candidate personal Mailbox
    And User redirect to stored Url
    And User click on mailboxtab
    Then User verify mailcount for mail recieved is visible
    Then User verify Mail recieved is visible in blue background with Mark all as read and mark as read options
    And User click on mark as read option
    Then Verify blue background of message disappears
    Then User click on reply button
    And  User fill message body and send the message
    Then User verify message comes at the top with message on hover "This message is on its way. To confirm/ reply to this, please refresh the page"
