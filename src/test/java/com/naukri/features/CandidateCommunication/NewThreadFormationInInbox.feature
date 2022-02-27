Feature: Test Scenarios of Communication Inbox Page for forming new Thread in Sent Tab

  Author: nikhil.bhatia@naukri.com

  @id:1 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email for send message to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
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
    And I verify the mail count is changed
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      |Message|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When  User clicks on "SENT" Filter
    And   User Verify Details of first tuple on left facet
    And   User Click on "LatestMail" visible on the top
    And   User Verify Mail Details on right facet
    Examples:
      | userType    |
      | Enterprise2 |

  @id:2 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email for send requirement to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
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
      |Requirement|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
    Examples:
      | userType    |
      | Enterprise2 |

  @id:3 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email for Request Document to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
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
      |Documents Requested|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
    Then User Verify Header and Reminder for "Documents requested"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:4 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email for status change to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When I navigate to Settings page
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
#    When  User clicks on "All Filters" Filter
#    And  User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
#    When User enter "Mail Type" name in search box and select the same
#         |Status Change Email|
#    When  User stores the values of "Mail Type" filter from the third layer of All Filter
#    Then  User Verify values of chip and "Mail Type" filter
#    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
    And Verify mailBlock for status change "Applied - Matching" By Logged in recruiter
    Examples:
      | userType    |
      | Enterprise2 |

  @id:5 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email for Interview to candidate is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    When I navigate to Settings page
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
      |Interview Invite|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
    And Verify mailBlock type "Interview" for "Face to face"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:6 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
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
      |Offers|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
    Then User Verify Header and Reminder for "Offers sent"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:7 @RMSCCInboxE2E @Mailer @Wip @RMSCCInbox
  Scenario Outline: To Assessment test and Reminder email functionality for candidate communication
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    When I click on Requirement Name on candidate page
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    Then Verify that user is able to see the test name in headings on Selected Assessment Test
    And User attach a test on "Applied-Matching" stage when using selction stage DD to select stage
    And click on attach test
    And User close Requirement Detail page and switch to  candidate detail page
    And Move candidate to following stage
      | Applied |
    When click on folllowing tuple Link
      | Send Test |
    And User Get the information about the candidate
    And I verify the mail count is changed
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      |Assessments|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
#    Then User Verify Header and Reminder for "Assessments sent"
    Examples:
      | userType   |
      | Enterprise |

  @id:8 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify New Mail Thread is formed from Right Facet on CC Mailbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
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

  @id:9 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify when we click on View all conversation from Right Facet Mailbox tab is selected
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    When User Click on "View All Conversation" visible on the top
    Then User switches to new window
    And  Verify MailboxTab is displayed
    Examples:
      | userType    |
      | Enterprise2 |

  @id:10 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify when we click on Candidate Name from Right Facet Profile tab is selected
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    When User Click on "CandidateName" visible on the top
    Then User switches to new window
    And  Verify ProfileTab is displayed
    Examples:
      | userType    |
      | Enterprise2 |

  @id:11 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Reply all functionality from Right Facet on mail Thread
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:12 @RMSCCInbox @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify if a recruiter has candidate Inbox enabled, Inbox tab will be selected by default on mailbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    And Verify "INBOX" tab is selected by default
    And Verify right facet is empty
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:13 @RMSCCInbox @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify if a recruiter has candidate Inbox disabled, Sent tab will be selected by default on mailbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Revoke Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    And Verify "SENT" tab is selected by default
    And Verify right facet is empty
    And User Click on "LatestMail" visible on the top
    And User Click on "ReplyAll" visible on the top
    And Verify replyAll Button Is disabled
    Examples:
      | userType    |
      | Enterprise2 |

#  @id:14 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
#  Scenario Outline: Verify Reply functionality via Inbox Tab from Right Facet on mail Thread
#    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
#    Then I click on Manage Profile
#    And I "Grant Permission" to mask and unmask candidate mails
#    And  User Verifies "Mailbox" is displayed on CC Inbox page
#    When User click on GNB option "Mailbox"
#    And  User verifies search for search term "Candidate"
#    When User clicks on "INBOX" Filter
#    And  User Click on "LatestMail" visible on the top
#    And  User Click on "Reply" visible on the top
#    Then I fill message body and send the message
#    And  Verify success message strip is shown "Mail sent successfully"
#    Examples:
#      | userType    |
#      | Enterprise2 |

  @id:15 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Reply all functionality via Inbox Tab from Right Facet on mail Thread
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "INBOX" Filter
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:16 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: To verify image of candidate on cv detail and cc mailbox page are identical
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User move to cv detail page of candidate.
    When User click on "Edit" link against "Candidate Details" on CV detail page
    When User uploads the image of candidate
    And  User click on "Save" button.
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User check the candidate profile image on cv detail page
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When User clicks on "SENT" Filter
    And  User verify candidate image on left facet and cv detail
    And  User Click on "LatestMail" visible on the top
    And  User verify candidate image on right facet and cv detail
    Examples:
      | userType     |
      | Enterprise2  |

  @id:17 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify search suggestions and results on left facet for candidate name
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    Then User click on GNB option "Mailbox"
    And  User verifies placeholder in search bar "Search by candidate name or subject line"
    And  User verifies search suggestions for search term "tes"
    And  User Click on first suggestion for candidate name
    When User clicks on "SENT" Filter
    Then User verifies result on left facet contains searched term "tes" in candidate name
    Examples:
      | userType    |
      | Enterprise2 |

  @id:18 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify search suggestions and results on left facet for subject line
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    Then User click on GNB option "Mailbox"
    And  User verifies placeholder in search bar "Search by candidate name or subject line"
    And  User verifies search suggestions for search term "tes"
    And  User Click on first suggestion for subject line
    When User clicks on "SENT" Filter
    Then User verifies result on left facet contains searched term "tes" in subject line
    Examples:
      | userType   |
      | Enterprise |

  @id:19 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify search suggestions and results for candidate name via link in search bar on cc mailbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    Then User click on GNB option "Mailbox"
    And  User verifies placeholder in search bar "Search by candidate name or subject line"
    And  User verifies search suggestions for search term "tes"
    And  User Click on link for all results in candidate name
    When User clicks on "SENT" Filter
    Then User verifies result on left facet contains searched term "tes" in candidate name
    Examples:
      | userType   |
      | Enterprise |

  @id:20 @RMSCCInbox @Wip @Mailer @recentCC2
  Scenario Outline: Verify search suggestions and results for subject line via link in search bar on cc mailbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    Then User click on GNB option "Mailbox"
    And  User verifies placeholder in search bar "Search by candidate name or subject line"
    And  User verifies search suggestions for search term "tes"
    And  User Click on link for all results in subject line
    When User clicks on "SENT" Filter
    Then User verifies result on left facet contains searched term "tes" in subject line
    Examples:
      | userType   |
      | Enterprise |

  @id:21 @RMSCCInbox @Wip @Mailer
  Scenario Outline: Verify searched term not found on cc mailbox page in search bar
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    Then User click on GNB option "Mailbox"
    And  User verifies placeholder in search bar "Search by candidate name or subject line"
    And  User searched for search term that does not exist in candidate name and subject line
    And  User verifies message for result not found
    Examples:
      | userType   |
      | Enterprise |

  @id:22 @RMSCCInbox @Wip @Mailer @recentCC2
  Scenario Outline: Verify highlighting of candidate name ,subject on left and right facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject           | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Candidate Subject -   | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    Then User click on GNB option "Mailbox"
    And  User verifies placeholder in search bar "Search by candidate name or subject line"
    And  User verifies search for search term "Candidate"
    When User clicks on "SENT" Filter
    Then User verifies result on left facet contains searched term "Candidate" in subject line
    And  Verify "Candidate" is highlighted in left facet
    And  User Click on "LatestMail" visible on the top
    And  Verify "Candidate" is highlighted in right facet
    And  Verify Date and Time displayed on left and right facet for mail are identical
    Examples:
      | userType    |
      | Enterprise2 |

  @id:23 @RMSCCInbox @Wip @Mailer @recentCC2
  Scenario Outline: Verify unmapped and search filter for Unmapped Profile on CC Inbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill details of the candidate
    And I click on Save button
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    And User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Candidate Subject - | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Get the information about the candidate for unmapped profile
    And I verify the mail count is changed
    When User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    Then User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Unmapped applications |
    And  User clicks on "Apply" button in conformation box
    And User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet for unmapped profile
    And  User verifies search for search term "Candidate"
    When User clicks on "SENT" Filter
    Then User verifies result on left facet contains searched term "Candidate" in subject line
    And  Verify "Candidate" is highlighted in left facet
    And  User Click on "LatestMail" visible on the top
    And  Verify "Candidate" is highlighted in right facet
    Examples:
      | userType    |
      | Enterprise2 |

  @id:24 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email for send requirement to unmapped profile is displayed under Sent Tab on communication Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill details of the candidate
    And I click on Save button
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
    And  User Get the information about the candidate for unmapped profile
    When User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    Then User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Unmapped applications |
    And  User clicks on "Apply" button in conformation box
    And User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And Verify Date and Time displayed on left and right facet for mail are identical
    Examples:
      | userType    |
      | Enterprise2 |

  @id:25 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Reply all functionality for unmapped profile on Right Facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Unmapped applications |
    And  User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:26 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Reply all functionality for master profile on Right Facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Master Profile |
    And  User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    Examples:
      | userType    |
      | Enterprise  |

  @id:27 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Reply all functionality for My Mails filter on Right Facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | My Mails |
    And  User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    Examples:
      | userType    |
      | Enterprise2 |

  @id:28 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify New Mail Thread is formed from Right Facet after applying filter my mails on CC Mailbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | My Mails |
    And  User clicks on "Apply" button in conformation box
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

  @id:29 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify New Mail Thread is formed from Right Facet for master profile on CC Mailbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Master Profile |
    And  User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Click on "LatestMail" visible on the top
    When User clicks on "New Mail" Filter
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailSubject          | MailAttachment             | MailBody          |
      | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    When User clicks on "SENT" Filter
    And Verify Mail is listed under Left Facet
    Examples:
      | userType   |
      | Enterprise |

  @id:30 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify New Mail Thread is formed from Right Facet for unmapped profile on CC Mailbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Unmapped applications |
    And  User clicks on "Apply" button in conformation box
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

  @id:31 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify three dots functionality on cc mailbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject              | MailAttachment             | MailBody                   |
      |        | CC@yopmail.com | Three dots functionality | OfferLetterPathLessThan5MB | Three dots functionality.. |
    And I verify the mail count is changed
    Then User click on mailboxtab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And  User Click on "ReplyAll" visible on the top
    And  User change the subject for the mail to "changed Subject"
    Then I fill message body and send the message
    And  Verify success message strip is shown "Mail sent successfully"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And  User replied to second mail in mail thread
    Then I fill message body and send the message
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And Verify three dots functionality for existing mails
    Examples:
      | userType    |
      | Enterprise2 |

  @id:32 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify name for attachment sent and download link while sending a mail is displayed on cc mailbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    When User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    And Verify "TestOfferLetterSample.docx" name for attachment sent and download link visible on cc mailbox page
    Examples:
      | userType    |
      | Enterprise2 |

  @id:33 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify mail is not visible to subuser, if it does not have visibility for requirement
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
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
    And I verify the mail count is changed
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    When I logout of RMS
    And "Enterprise" user is on Settings Page with "Subuser1"
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
    And   User verify mail not found on left facet cc mailbox page
    Examples:
      | userType    |
      | Enterprise2 |

  @id:34 @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify time on left and right facet is same and no warning strip is displayed on right facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And  User is on "addSingleProfile" page
    And  I fill in all the details of the candidate
    And  I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And  User move to cv detail page of candidate.
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Get the information about the candidate
    And  I verify the mail count is changed
    Then User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      | Message |
    When User stores the values of "Mail Type" filter from the third layer of All Filter
    Then User Verify values of chip and "Mail Type" filter
    And  User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And  User Verify Details of first tuple on left facet
    And  User Click on "LatestMail" visible on the top
    And  User verify warning strip for time mismatch on left and right facet is not displayed
    Examples:
      | userType    |
      | Enterprise2 |

  @id:35 @RMSCCInbox @Wip @Mailer @recentCC2
  Scenario Outline: Verify Mails on Master Profile after deletion via unmapped profile not visible on CC Inbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill details of the candidate
    And I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    And User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject               | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for unmapped | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And I search for the candidate for master profile with "email"
    And User click on candidate and move to candidate page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject             | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for master | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Get the information about the candidate for unmapped profile
    And  I verify the mail count is changed
    When User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And User move to cv detail page of candidate.
    And  User click on delete button present on cv detail page
    Then User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Master Profile |
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User verify mail not found on left facet cc mailbox page
    Examples:
      | userType    |
      | Enterprise  |

  @id:36 @RMSCCInbox @Wip @Mailer @recentCC2
  Scenario Outline: Verify Mails on Master Profile after deletion via mapped profile not visible on CC Inbox page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And  I fill in all the details of the candidate
    And I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    And User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And I search for the candidate for master profile with "email"
    And User click on candidate and move to candidate page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Get the information about the candidate for unmapped profile
    And  I verify the mail count is changed
    When User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And User move to cv detail page of candidate.
    And  User click on delete button present on cv detail page
    Then User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Master Profile |
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User verify mail not found on left facet cc mailbox page
    Examples:
      | userType    |
      | Enterprise  |

  @id:37 @RMSCCInbox @Wip @Mailer @recentCC2
  Scenario Outline: Verify Email sent to candidate is not displayed on cc mailbox page after deletion of unmapped profile
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  I click on Manage Profile
    And  I "Grant Permission" to mask and unmask candidate mails
    And  User is on "addSingleProfile" page
    And  I fill details of the candidate
    And  I click on Save button
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    And  User click on Message option
    And  User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject         | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Candidate Subject - | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Get the information about the candidate for unmapped profile
    And  I verify the mail count is changed
    When User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And  User click on delete button present on cv detail page
    Then User click on GNB option "Mailbox"
    When  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      | Mails on Unmapped applications |
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User verify mail not found on left facet cc mailbox page
    Examples:
      | userType    |
      | Enterprise2 |

  @id:38  @RMSCCInboxE2E @Wip @Mailer @RMSCCInbox
  Scenario Outline: Verify Email sent to candidate is not displayed on cc mailbox page after deletion of mapped profile
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And User Get the information about the candidate
    And I verify the mail count is changed
    Then User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And User click on delete button present on cv detail page
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
    And   User verify mail not found on left facet cc mailbox page
    Examples:
      | userType    |
      | Enterprise2 |


  @id:39 @RMS @RMSCCInboxFilterPage  @FilterTestCase @RequirementCreatedThanMailWithoutGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Send Message
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And User move to cv detail page of candidate.
    And  User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User Get the information about the candidate
    And  User Get the information for mail sent from mailbox tab
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Message|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:40 @RMS @RMSCCInboxFilterPage  @FilterTestCase @RequirementCreatedThanMailWithoutGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Send a Requirement
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User move to cv detail page of candidate.
    And  User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:41 @RMS @RMSCCInboxFilterPage  @FilterTestCase  @RequirementCreatedThanMailWithoutGroup @CheckFlows @RMSCCInbox @CheckAgain
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Interview Invite
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  I navigate to Settings page
    And  I remove Automatic mailer for "Interview-Round 1" stage.
    And  User move to cv detail page of candidate.
    And  User get the requirement attached with the cv
    And  I move the Candidate to "Interview - Round 1" Stage
    And  User fill in the subject field as "Updated Subject"
    Then  I uncheck checkbox for cc to send mail successfully
    And  I fill in the Body field of Mail Template
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Interview invite sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Interview Invite|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |



  @id:42 @RMS @RMSCCInboxFilterPage  @FilterTestCase @RequirementCreatedThanMailWithoutGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Document Requested
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User move to cv detail page of candidate.
    And  User get the requirement attached with the cv
    And I click on Request Document option
    And I click on Document List dropdown
    And I select option as "Select All"
    Then I click on Request Button
    And  I fill in the subject field
    And I click on Term and Condition check box
    And I click on "SEND MAIL"
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Documents Requested|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:44 @RMS @RMSCCInboxFilterPage  @FilterTestCase @RequirementCreatedThanMailWithoutGroup @CheckFlows  @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Status Change
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And I navigate to Settings page
    And  I remove Automatic mailer for "Applied-Matching" stage.
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And I move the candidate to "Applied - Matching" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User reload the page.
    And User click on mailboxtab
    Then I apply filter "Status change email sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Status Change Email|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |


  @id:45 @RMS @RMSCCInboxFilterPage  @FilterTestCase @RequirementCreatedThanMailWithGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Status Change
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User is on "groupListing" page
   And  User add group with "jatinHR2@yopmail.com" as HR and also as HRSpoc, "mansi" as HM and "mansi" as HMSpoc
    And  User is on "addANewRequirement" page
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the tab "Edit" on requirement overview page
    And User fill Group Details for a Requirement
      | GroupName | Visible to all in the group |
    And User click on the tab "Next" on requirement overview page
    And User click on the tab "Save Requirement" on requirement overview page
    And  User click on More and Select Add Single Profile option on Requirement Overview Page
    And  I fill details of the candidate
    And  I click on Save button
    And User updates the value of Url formed for cv detail page.
    And User move to cv detail page of candidate.
    And User is on "settingsPage" page
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And I navigate to Settings page
    And  I remove Automatic mailer for "Applied-Matching" stage.
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And I move the candidate to "Applied - Matching" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Status change email sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User Get the information about the candidate
    And  User Get the information for mail sent from mailbox tab
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    And  User selects "Group" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Status Change Email|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Verify Details of first tuple on left facet
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:46 @RMS @RMSCCInboxFilterPage @FilterTestCase @MyMails @RequirementCreatedThanMailWithGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Offers
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When user click on "Offer Generation Module On/Off " offer generation link
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "off"
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And User move the candidate to "Offers & Joining - Offered" stage.
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And  I fill in the subject field
    And I fill Offer Mail Body field
    Then I click Send Mail button on Attach Offer Letter
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Offers sent" from "Mail Type" and "Mails Sent" from "All Mails" with attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    And  User selects "Group" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Offers|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:47 @RMS @RMSCCInboxFilterPage  @MyMails @RequirementCreatedThanMailWithGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Document Requested
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And I click on Request Document option
    And I click on Document List dropdown
    And I select option as "Select All"
    Then I click on Request Button
    And  I fill in the subject field
    And I click on Term and Condition check box
    And I click on "SEND MAIL"
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    And  User selects "Group" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Documents Requested|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:48 @RMS @RMSCCInboxFilterPage  @MyMails @RequirementCreatedThanMailWithGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Interview Invite
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  I navigate to Settings page
    And  I remove Automatic mailer for "Interview-Round 1" stage.
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And I move the Candidate to "Interview - Round 1" Stage
    And User fill in the subject field as "Updated Subject"
    Then I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Interview invite sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    And  User selects "Group" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Interview Invite|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:49 @RMS @RMSCCInboxFilterPage  @MyMails @RequirementCreatedThanMailWithGroup @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Send Message
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    And  User selects "Group" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Message|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:50 @RMS @RMSCCInboxFilterPage  @RequirementCreatedThanMailWithGroup @CheckFlows @RMSCCInbox @MyMails
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Send a Requirement
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    And  User selects "Group" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:52 @RMS @RMSCCInboxFilterPage  @FilterTestCase @MyMails @CheckFlows @RMSCCInbox
  Scenario Outline: Verify user should get mail thread of selected requirement,group,Mail Type "Document Requested" and Others "My Mails" filter is applied
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And I click on Request Document option
    And I click on Document List dropdown
    And I select option as "Select All"
    Then I click on Request Button
    And  I fill in the subject field
    And I click on Term and Condition check box
    And I click on "SEND MAIL"
    And  User reload the page.
    Then User click on mailboxtab
    Then I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And User Get the information about the candidate
    And  User Get the information for mail sent from mailbox tab
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Documents Requested|
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And   User enter "Others" name in search box and select the same
      |My Mails|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |


  @id:54 @RMS @RMSCCInboxFilterPage  @FilterTestCase @MyMails @CheckFlows @RMSCCInbox
  Scenario Outline: Verify user should get mail thread of selected requirement,group,Mail Type "Message" and Others "My Mails" filter is applied
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Message|
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And   User enter "Others" name in search box and select the same
      |My Mails|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |

  @id:55 @RMS @RMSCCInboxFilterPage  @FilterTestCase @MyMails @CheckFlows @RMSCCInbox
  Scenario Outline: Verify user should get mail thread of selected requirement,group,Mail Type "Requirement" and Others "My Mails" filter is applied
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And  User reload the page.
    And  User click on mailboxtab
    And I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And   User enter "Others" name in search box and select the same
      |My Mails|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    Examples:
      | userType   |
      | Enterprise2 |


  @id:56 @CheckFlows @RMSCCInbox @AutomaticMailer @CheckAgain
  Scenario Outline: Verify the mail that has been sent to candidate when status is changed To " Interview - Round 2 "automatically ,is same on both pages Cv details and CCInbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User is on "mailerSettings" page
    And  User refresh the page until "Interview-Round 2" is visible
    And I add Default Automatic mailer for "Interview-Round 2" stage.
    And  User move to cv detail page of candidate.
    And User move the candidate to "Interview - Round 2" stage.
    And User Set The Interview Details
    And User Get the information about the candidate
    And User reload the page.
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      |Interview Invite|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet
    And Verify mailBlock type "Interview" for "Face to face"

    Examples:
      | userType   |
      | Enterprise2 |

  @id:57 @CheckFlows @RMSCCInbox @AutomaticMailer @CheckAgain
  Scenario Outline: Verify the mail that has been sent to candidate when status is changed To "Prospect" automatically ,is same on both pages Cv details and CCInbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And  User is on "mailerSettings" page
    And  User refresh the page until "Prospect" is visible
    And User add Default Automatic mailer for "Prospect" stage.
    And  User move to cv detail page of candidate.
    And User move the candidate to "Prospect" stage.
    And User Get the information about the candidate
    And User reload the page.
    Then User click on mailboxtab
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      |Status Change Email|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet

    Examples:
      | userType   |
      | Enterprise2 |





  @id:58 @RMS @RMSCCInboxFilterPage  @FilterTestCase  @UnMappedProfile @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Send Message
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User is on "addSingleProfile" page
    And  I fill details of the candidate
    And  I click on Save button
    And User updates the value of Url formed for cv detail page.
    And User move to cv detail page of candidate.
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And User reload the page.
    When User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User Get the information about the candidate for unmapped profile
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And  User is on "CCInboxPage" page
    And  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And   User enter "Others" name in search box and select the same
      |Mails on Unmapped applications|
    And  User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    And   User enter "Mail Type" name in search box and select the same
      |Message|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify Mail Details on right facet for unmapped profile
    Examples:
      | userType   |
      | Enterprise2 |



  @id:60 @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @UnMappedProfile @CheckFlows @RMSCCInbox
  Scenario Outline: Verify after applying requirement filter user gets results for selected requirement mail thread started via Send a Requirement
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User move to cv detail page of candidate.
    And  User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And  User reload the page.
    When User click on mailboxtab
    And I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User Get the information about the candidate for unmapped profile
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And  User is on "CCInboxPage" page
    And  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And   User enter "Mail Type" name in search box and select the same
      |Mails on Unmapped applications|
    And  User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    And   User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify Mail Details on right facet for unmapped profile
    Examples:
      | userType   |
      | Enterprise2 |

  @id:60 @RMS @RMSCCInboxPage @WIP @MasterProfile @CheckFlows @RMSCCInbox
  Scenario Outline: Verify Mails send via "Send message"  for  Master Profile  on CC Inbox page when "Message","Mails on Master Profile" and "My Mails" filter is applied
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I search for the candidate for master profile with "email"
    And User click on candidate and move to candidate page
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And  User reload the page.
    When User click on mailboxtab
    And  User Get the information about the candidate for unmapped profile
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And  User is on "CCInboxPage" page
    And  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      |Mails on Master Profile|My Mails|
    And  User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    And  User enter "Mail Type" name in search box and select the same
      |Message|
    And  User clicks on "Apply" button in conformation box
    And User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet for unmapped profile
    Examples:
      | userType   |
      | Enterprise |

  @id:61 @RMS @RMSCCInboxPage @WIP @MasterProfile @CheckFlows @RMSCCInbox
  Scenario Outline: Verify Mails send via "Send Requirement"  for  Master Profile  on CC Inbox page when "Message","Mails on Master Profile" and "My Mails" filter is applied and check subuseris not able to see "Mails on Master Profile" filter
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I search for the candidate for master profile with "email"
    And User click on candidate and move to candidate page
    And  User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And  User reload the page.
    And  User Get the information about the candidate for unmapped profile
    When User click on mailboxtab
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And  User is on "CCInboxPage" page
    And  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      |Mails on Master Profile|My Mails|
    And  User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    And  User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Apply" button in conformation box
    And User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet for unmapped profile
    Examples:
      | userType   |
      | Enterprise |

  @id:62 @RMS @RMSCCInboxPage @MasterProfile @CheckFlows @RMSCCInbox
  Scenario Outline: Verify Mails send via "Send message"  for  Master Profile  on CC Inbox page when "Message","Mails on Master Profile" and "My Mails" filter is applied
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I search for the candidate for master profile with "email"
    And User click on candidate and move to candidate page
    And  User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And  User reload the page.
    And User click on mailboxtab
    And  User Get the information about the candidate for unmapped profile
    And  User Get the information for mail sent from mailbox tab for unmapped profile
    And  User is on "CCInboxPage" page
    And  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And  User enter "Others" name in search box and select the same
      |Mails on Master Profile|My Mails|
    And  User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    And  User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Apply" button in conformation box
    And User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And User Verify Mail Details on right facet for unmapped profile
    And User logout from application
    And User login to the application "CCInboxPage" using "Subuser" of "Enterprise2" user
    And  User is on "CCInboxPage" page
    And  User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    Then  User verify when provides name in search area which doesn't exists should get not found in DD List
      |Mails on Master Profile|
    Examples:
      | userType   |
      | Enterprise |

  @id:63 @RMSCCInbox
  Scenario Outline: Verify mails are visible to subuser on cc mailbox page, if sub user have visibility to requirement
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
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
    And   User hover on the Email option on top panel of the inbox
    Then  User should be able to see the Message option in the hover list
    When  User click on Message option
    And   User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And   User Get the information about the candidate
    And   I verify the mail count is changed
    Then  User click on mailboxtab
    And   User Get the information for mail sent from mailbox tab
    And   User logout from application
    And   User login to the application "CCInboxPage" using "Subuser" of "Enterprise2" user
    And   User is on "CCInboxPage" page
    Then  User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When  User enter "Mail Type" name in search box and select the same
      |Message|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When  User clicks on "SENT" Filter
    And   User Verify Details of first tuple on left facet

    Examples:
      | userType   |
      | Enterprise2 |

  @id:64 @RMSCCInbox
  Scenario Outline: Verify mails are not visible to subuser on cc mailbox page, if sub user doesn't have visibility to requirement
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User is on "groupListing" page
    And   User add group with "enterprise2_subuser1@yopmail.com" as HR and also as HRSpoc, "mansi" as HM and "mansi" as HMSpoc
    And   User is on "addANewRequirement" page
    And   I create a requirement with "Visible to Only Me"
    And   User click on More and Select Add Single Profile option on Requirement Overview Page
    And   I fill details of the candidate
    And   I click on Save button
    And   User updates the value of Url formed for cv detail page.
    And   User move to cv detail page of candidate.
    And   User hover on the Email option on top panel of the inbox
    Then  User should be able to see the Message option in the hover list
    When  User click on Message option
    And   User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And   User Get the information about the candidate
    And   I verify the mail count is changed
    Then  User click on mailboxtab
    And   User Get the information for mail sent from mailbox tab
    And   User logout from application
    And   User login to the application "CCInboxPage" using "Subuser" of "Enterprise2" user
    And   User is on "CCInboxPage" page
    Then  User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When  User enter "Mail Type" name in search box and select the same
      | Message |
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When  User clicks on "SENT" Filter
    And   User verify mail not found on left facet cc mailbox page

    Examples:
      | userType    |
      | Enterprise2 |

  @id:65 @RMSCCInbox
  Scenario Outline: Verify unread mails are shown, if "Unread" filter is applied
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    And  User move to cv detail page of candidate.
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC                   | MailSubject          | MailAttachment             | MailBody          |
      |        | singh.avinash@naukri.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    And  User clicks on "Unread" Filter
    When User clicks on "SENT" Filter
    And  Verify Unread mail is displayed on latest mail present in left facet
    Examples:
      | userType   |
      | Enterprise2|

  @id:66 @RMSCCInbox
  Scenario: user is able to schedule interview without interviewer and opening editior
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And user select Requirement while adding a single profile
    And I click on Add Candidate button
    And user move an application to interview stage
    Then verify that user is able to see the listed headings on page
      | Schedule Interview for                                                   |
      | No Interviewer added to this stage. Add                                  |
      | Interviewers                                                             |
      | Interview Date                                                           |
      | Interview Time                                                           |
      | Interview Location                                                       |
      | Block room for interview                                                 |
      | Interview invite will be mailed to the candidate.                        |
      | Interview invite and candidate’s profile will be mailed to interviewers. |
    When user fill "Infoedge" location for scheduling interview
    And user click on "Block room for interview" button
    Then user should be able to see the label "Interview room details will be shared only with interviewers."
    And user click on "Schedule Interview" button
    Then user should be able to see the label "Confirm"
    When user click on "Send Invite" button
    And Verify MailboxTab is displayed
    And User Get the information about the candidate
    Then User click on mailboxtab
    Then I apply filter "Interview invite sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And User Get the information for mail sent from mailbox tab
    And  User Verifies "Mailbox" is displayed on CC Inbox page
    When User click on GNB option "Mailbox"
    Then User Verify "Candidate Mailbox" Heading is Visible on Page
    When  User clicks on "All filters" Filter
    When User enter "Mail Type" name in search box and select the same
      |Interview Invite|
    When  User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    And   User clicks on "Apply" button in conformation box
    When User clicks on "SENT" Filter
    And User Verify Details of first tuple on left facet
    And User Click on "LatestMail" visible on the top
    And Verify mailBlock type "Interview" for "Face to face"

  @id:67 @RMS @CheckFlows @RMSCCInbox @RequirementStatusChange
  Scenario Outline: Verify user should be able to see mails for "On Hold" Requirement
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then User updates the value of Url formed for cv detail page.
    And  User move to cv detail page of candidate.
    And  User click on requirement on cv details page
    And  User changes the status of requirement as "On Hold"
    And  User reload the page.
    And  User move to cv detail page of candidate.
    And  User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User Get the information about the candidate
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    And User Verify Requirement is displayed as "On hold" on right facet
    Examples:
      | userType   |
      | Enterprise2|


  @id:68 @RMS @CheckFlows @RMSCCInbox @RequirementStatusChange
  Scenario Outline: Verify user should be able to see mails for "Close" Requirement
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  User move to cv detail page of candidate.
    And  User click on requirement on cv details page
    And  User changes the status of requirement as "Close"
    And  User click on Close in confirmation box
    And  User reload the page.
    And  User move to cv detail page of candidate.
    And  User get the requirement attached with the cv
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  I fill in the body field
    And  I fill in the subject field
    And  I click on "SEND MAIL"
    And  User reload the page.
    And  User click on mailboxtab
    Then I apply filter "Message sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    And  User is on "CCInboxPage" page
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "SENT" Filter
    And  User Click on "LatestMail" visible on the top
    Then User Verify results contains requirement name " " on right facet.
    And User Verify Requirement is displayed as "Close" on right facet
    Examples:
      | userType   |
      | Enterprise2 |

