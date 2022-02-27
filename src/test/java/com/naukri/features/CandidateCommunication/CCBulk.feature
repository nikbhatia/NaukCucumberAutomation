Feature: CCBulk

  @id:1 @CCBulk @Wip
  Scenario Outline: Verify User is able to see Bulk and Individual Tab in Sent tab
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When User clicks on "SENT" Filter
    Then User Verifies "Bulk" is displayed on CC Inbox page
    And User Verifies "Individual" is displayed on CC Inbox page
    
     Examples:
      | userType      |
      | Enterprise2    |


  @id:2 @CCBulk @Wip
  Scenario Outline:Verify user is able to see Requirement Name,Number of Recipients,Subject on both left Facet and Right Facet for "Message Bulk Mail"
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User click on requirement on cv details page
    And User click on More and Select Add Single Profile option on Requirement Overview Page
    And I enter the "DD Bulk Profile Two" characters in the candidate name
    And I fill in the email of the candidate
    And I click on Save button
    And User click on requirement on cv details page
    And User click on More and Select Add Single Profile option on Requirement Overview Page
    And I enter the "DD Bulk Profile Three" characters in the candidate name
    And I fill in the email of the candidate
    And I click on Save button
    And User get the requirement name from Cv details page
    And User click on requirement on cv details page
    And User clicks on the application count on requirement overview page
    And User switch to new tab
    And User saves the details of the page for CC Bulk
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Bulk Message Mail"
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"



    Examples:
      | userType      |
      | Enterprise2    |



  @id:3 @CCBulk @Wip
  Scenario Outline:Verify user is able to send "Message Mail" from Mail Recipient page and able to see Requirement Name,Number of Recipients,Subject on both left Facet and Right Facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Bulk Message Mail Before Mail Recipient Mail"
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And User click on tuple for which bulk mail is sent
    And User clicks on "3 Recipient(s)" button in conformation box
    Then Verify User is able to see "Mail Recipient(s)" heading on MailRecipient page
    And Verify User is able to see "3" application count on MailRecipient page
    When  User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Bulk Message Mail From MailRecipient Page"
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"

    Examples:
      | userType      |
      | Enterprise2    |

  @id:4 @CCBulk @Wip
  Scenario Outline:Verify user is able to see sent "Message Mail" in bulk tab, when "Message" and "Requirement Name" filter are applied
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User loads the SRP page for CC Bulk
    And User click on first candidate name on inbox page
    And User get the requirement attached with the cv
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Bulk Message Mail For Filter"
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Message|
    And  User clicks on "Apply" button in conformation box
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"

    Examples:
      | userType      |
      | Enterprise2    |

  @id:5 @CCBulk @Wip
  Scenario Outline:Verify user is able to see Number of Recipients,Subject on both left Facet and Right Facet for "Requirement Bulk Mail"
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    When I click the send a requirement option in hover list
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject for Bulk Requirement Mail"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"

    Examples:
      | userType      |
      | Enterprise2    |

  @id:6 @CCBulk @Wip
  Scenario Outline:Verify user is able to see "Requirement Mail" in bulk tab, when "Reuqirement" and "Requirement Name" filter are applied
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User loads the SRP page for CC Bulk
    And User click on first candidate name on inbox page
    And User get the requirement attached with the cv
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    When I click the send a requirement option in hover list
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject for Bulk Requirement Mail For Filter"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Requirement|
    And  User clicks on "Apply" button in conformation box
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"

    Examples:
      | userType      |
      | Enterprise2    |


  @id:7 @CCBulk @Wip
  Scenario Outline:Verify user is able to send "Requirement Mail" from Mail Recipient page and able to see Requirement Name,Number of Recipients,Subject on both left Facet and Right Facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    When I click the send a requirement option in hover list
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject for Bulk Requirement Mail before MailRecipient Mail"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    When User click on tuple for which bulk mail is sent
    And User clicks on "3 Recipient(s)" button in conformation box
    Then Verify User is able to see "Mail Recipient(s)" heading on MailRecipient page
    And Verify User is able to see "3" application count on MailRecipient page
    And  User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    When I click the send a requirement option in hover list
    When I select the first requirement in the requirement drop down
    And  User fill in the subject field as "Updated Subject for Bulk Requirement Mail From Mail Recipient page"
    And  I type in the mail body "testMailBodyText"
    And  I click on "Send" button on sendRequirement
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"

    Examples:
      | userType      |
      | Enterprise2    |

  @id:8 @CCBulk
  Scenario Outline:Verify user is able to see Requirement Name,Number of Recipients,Subject on both left Facet and Right Facet for "Status Change Mail Bulk"
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Duplicate"
    And I click on update on the layout
    And User click on "Send Email"
    And  User fill in the subject field as "Updated Subject for Bulk Status Change Mail"
    And I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    And  Verify requirement name for bulk mail for "Other"
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"

    Examples:
      | userType      |
      | Enterprise2    |

  @id:9 @CCBulk @Wip
  Scenario Outline: Verify User is able to see Bulk Mail in Bulk section under bulk tab for "Status Change Bulk Mail"
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And User loads the SRP page for CC Bulk
    And User click on first candidate name on inbox page
    And User get the requirement attached with the cv
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Applied-Matching"
    And I click on update on the layout
    And User click on "Send Email"
    And  User fill in the subject field as "Updated Subject for Bulk Status Change Mail For Filter"
    And I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Status Change Email|
    And  User clicks on "Apply" button in conformation box
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"


    Examples:
      | userType      |
      | Enterprise2    |
      
      
  @id:10 @CCBulk @wip
  Scenario Outline:Verify user is able to send "Bulk Status Change Mail" from Mail Recipient page and able to see Requirement Name,Number of Recipients,Subject on both left Facet and Right Facet
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And  I navigate to Settings page
    And I remove Automatic mailer for "Prospect" stage.
    And  I navigate to Settings page
    And I remove Automatic mailer for "Applied-Matching" stage.
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Prospect"
    And I click on update on the layout
    And User click on "Send Email"
    And  User fill in the subject field as "Updated Subject for Bulk Status Change Mail Before Mail Recipient Mail"
    And I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    When User click on tuple for which bulk mail is sent
    And User clicks on "3 Recipient(s)" button in conformation box
    Then Verify User is able to see "Mail Recipient(s)" heading on MailRecipient page
    And Verify User is able to see "3" application count on MailRecipient page
    And  User click on Select all candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Applied-Matching"
    And I click on update on the layout
    And User click on "Send Email"
    And  User fill in the subject field as "Updated Subject for Bulk Status Change Mail From Mail Recipient page "
    And I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"

    Examples:
      | userType      |
      | Enterprise2    |


 @id:11 @CCBulk @Wip @CCBulkSubUser
  Scenario Outline:Verify user is able to see any info of "Document Requested Bulk Mail" when "Requirement Name " filter is applied
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User click on requirement on cv details page
    And User click on More and Select Add Single Profile option on Requirement Overview Page
    And I enter the "Bulk Profile Document Two" characters in the candidate name
    And I fill in the email of the candidate
    And I click on Save button
    And User click on requirement on cv details page
    And User click on More and Select Add Single Profile option on Requirement Overview Page
    And I enter the "Bulk Profile Document Three" characters in the candidate name
    And I fill in the email of the candidate
    And I click on Save button
    And User get the requirement name from Cv details page
    And User click on requirement on cv details page
    And User clicks on the application count on requirement overview page
    And User switch to new tab
    And User saves the details of the page for CC Bulk
    And User click on first candidate name on inbox page
    And User get the requirement attached with the cv
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Bulk Document Request Mail For Filter"
    And  User clicks on Request Documents link on mail screen
    And  User selects "Resume" from Document List on mail screen
    And  User selects "Passport" from Document List on mail screen
    And I click on Term and Condition check box
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And  User clicks on "Requirement Name" Filter
    And  User selects "Requirement" from the DD List
    And  User clicks on "Apply" button in conformation box
    And  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Documents Requested|
    And  User clicks on "Apply" button in conformation box
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"

    Examples:
      | userType      |
      | Enterprise2    |


  @id:12 @CCBulk @CCBulkSubUser
  Scenario Outline:Verify user is able to see "Remove Group or Unread filters to view bulk mail results." when searched with group in Bulk
    Given User login to the application "groupListing" using "Superuser" of "<userType>" user
    When User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Group filter check"
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And  User clicks on "Group" Filter
    And   User enter "Group" name in search box and select the same
      |TestGroup 1610509635546|
    And   User clicks on "Apply" button in conformation box
    And  User should be able to see "Remove Group or Unread filters to view bulk mail results." when searched with group


    Examples:
      | userType      |
      | Enterprise2    |




  @id:13 @CCBulk @CCBulkSubUser
  Scenario Outline:Verify user is able to see "Remove Group or Unread filters to view bulk mail results." when searched with unread in Bulk
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Duplicate"
    And I click on update on the layout
    And User click on "Send Email"
    And  User fill in the subject field as "Updated Subject for Unread Filter check"
    And I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    And  User clicks on "Unread" Filter
    And  User should be able to see "Remove Group or Unread filters to view bulk mail results." when searched with group

    Examples:
      | userType      |
      | Enterprise2    |



  @id:14 @CCBulk @CCBulkSubUser
  Scenario Outline:Verify subuser is able to see the bulk mail if only when there is visibility to subuser
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    When I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User click on requirement on cv details page
    And User click on "Set Visibility" link
    And click on "Visible to Selected People" in visibility DD
    And User selects "enterprise2_subuser1@yopmail.com" from recruiters DD on requirement overview page
    And User clicks "Save" button on requirement overview Visibility lightbox
    And User click on More and Select Add Single Profile option on Requirement Overview Page
    And I enter the "DD Bulk Profile Two" characters in the candidate name
    And I fill in the email of the candidate
    And I click on Save button
    And User click on requirement on cv details page
    And User click on More and Select Add Single Profile option on Requirement Overview Page
    And I enter the "DD Bulk Profile Three" characters in the candidate name
    And I fill in the email of the candidate
    And I click on Save button
    And User get the requirement name from Cv details page
    And User click on requirement on cv details page
    And User clicks on the application count on requirement overview page
    And User switch to new tab
    And User saves the details of the page for CC Bulk
    And User loads the SRP page for CC Bulk
    And User click on Select all candidate checkbox
    And  User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And  User fill in the subject field as "Updated Subject for Bulk Message Mail"
    And  I fill in the body field
    And  I click on "SEND MAIL"
    And User is on "CCInboxPage" page
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"
    And  User click on "Logout" from settings options
    And  User login to the application "CCInboxPage" using "Subuser" of "<userType>" user
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    Then Verify User is able to see subject as Mail Heading for "Left Facet"
    And  Verify requirement name for bulk mail for "Other"
    And Verify User is able to see "3 Recipient(s)" no of recipients on the "Left" facet
    When User click on tuple for which bulk mail is sent
    Then Verify User is able to see "3 Recipient(s)" no of recipients on the "Right" facet
    And  Verify User is able to see subject as Mail Heading for "Right Facet"
    And  Verify requirement name for bulk mail for "Other"
    And  User click on "Logout" from settings options
    And User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    And User loads the SRP page for CC Bulk
    And User click on first candidate name on inbox page
    And User click on requirement on cv details page
    And User click on "Set Visibility" link
    And click on "Visible to Only Me" in visibility DD
    And User clicks "Save" button on requirement overview Visibility lightbox
    And  User click on "Logout" from settings options
    And  User login to the application "CCInboxPage" using "Subuser" of "<userType>" user
    And User clicks on "SENT" Filter
    And User clicks on "Bulk" Filter
    Then Verify User is not able to see subject as Mail Heading for "Left Facet"
    Examples:
      | userType      |
      | Enterprise2    |