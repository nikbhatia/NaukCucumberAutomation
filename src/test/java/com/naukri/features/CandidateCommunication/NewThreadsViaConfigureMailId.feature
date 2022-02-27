Feature: Test Scenarios of Communication Inbox Page for forming new Thread via configured outgoing Email id in Sent Tab

  Author: nikhil.bhatia@naukri.com

  @id:1 @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify Email for send message to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Revoke Permission" to mask and unmask candidate mails
    And User sets Configured email id "qainfoedge1@gmail.com" with password "qanaukri@123"
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And User move to cv detail page of candidate.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And User Get the information about the candidate
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      | Message |
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When  User clicks on "SENT" Filter
    And   User Verify Details of first tuple on left facet

    Examples:
      | userType    |
      | Enterprise2 |

  @id:2 @RMSCCInboxE2E @Wip @Mailer @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify Email for send requirement to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User move to cv detail page of candidate.
    And User Get the information about the candidate
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
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      | Requirement |
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet

    Examples:
      | userType    |
      | Enterprise2 |

  @id:3 @RMSCCInboxE2E @Wip @Mailer @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify Email for Request Document to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User move to cv detail page of candidate.
    And User Get the information about the candidate
    And I click on Request Document option
    And I click on Document List dropdown
    And I select option as "Select All"
    Then I click on Request Button
    And User fill in the subject field as "Updated Subject"
    And I click on Term and Condition check box
    And I click on "SEND MAIL"
    And I verify the mail count is changed
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      | Documents Requested |
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    Then User Verify Header and Reminder for "Documents requested"

    Examples:
      | userType    |
      | Enterprise2 |

  @id:4 @RMSCCInboxE2E @Wip @Mailer @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify Email for status change to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I remove Automatic mailer for "Applied-Matching" stage.
    Then User move to cv detail page of candidate.
    And User Get the information about the candidate
    And I move the candidate to "Applied - Matching" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User Get the information about the candidate
    And I verify the mail count is changed
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And Verify mailBlock for status change "Applied - Matching" By Logged in recruiter

    Examples:
      | userType    |
      | Enterprise2 |

  @id:5 @RMSCCInboxE2E @Wip @Mailer @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify Email for Interview to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I remove Automatic mailer for "Interview-Round 1" stage.
    Then User move to cv detail page of candidate.
    And I move the Candidate to "Interview - Round 1" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User Get the information about the candidate
    And I verify the mail count is changed
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      | Interview Invite |
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And Verify mailBlock type "Interview" for "Face to face"

    Examples:
      | userType    |
      | Enterprise2 |

  @id:6 @RMSCCInboxE2E @Wip @Mailer @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify Email for offer to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When user click on "Offer Generation Module On/Off " offer generation link
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "off"
    Then User move to cv detail page of candidate.
    And User move the candidate to "Offers & Joining - Offered" stage.
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And User fill in the subject field as "Updated Subject"
    And I fill Offer Mail Body field
    Then I click Send Mail button on Attach Offer Letter
    And I verify the mail count is changed
    And User Get the information about the candidate
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      | Offers |
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    Then User Verify Header and Reminder for "Offers sent"

    Examples:
      | userType    |
      | Enterprise2 |

  @id:7 @RMSCCInboxE2E @Wip @Mailer @ConfiguredMail @RMSCCInbox
  Scenario Outline: Verify New Mail Thread is formed from Right Facet on CC Mailbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And User Click on "LatestMail" visible on the top
    When User clicks on "New Mail" Filter
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailSubject          | MailAttachment             | MailBody          |
      | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    When User clicks on "SENT" Filter
    And Verify Mail is listed under Left Facet

    Examples:
      | userType    |
      | Enterprise2 |

