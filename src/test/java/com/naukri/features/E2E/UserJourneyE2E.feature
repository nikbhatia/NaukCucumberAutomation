Feature: RMS User Journey End To End Cases

  @id:1 @E2E @UserJourney1
  Scenario Outline: Create a requirement and Post a job through Requirement Creation Module of RMS
    Given User login into RMS as an "<userType>" as "Superuser"
    When I navigate to Settings page
    And I remove Automatic mailer for "Interview-Round 1" stage.
     And User uncheck Automatic mailer to HM checbox in settings
    When User is on "groupListing" page
    And User add group with "singh.avinash@naukri.com" as HR and also as HRSpoc, "avinashHM@yopmail.com" as HM and "avinashHM@yopmail.com" as HMSpoc
    And User map HiringManager "avinashhm@yopmail.com" to "Interview - Round 1" stage
    And refresh the page
    And User create a new requirement and move to overview page
    When User click on the tab "Comments" on requirement overview page
    And User enter comments on Requirement Overview page
    Then User Verify the Comment given is displayed
    And User click on the tab "Edit" on requirement overview page
    And User fill Group Details for a Requirement
      | GroupName | Visible to all in the group |
    And User click on the tab "Next" on requirement overview page
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on the tab "Save Requirement" on requirement overview page
    And User click on post button on Requirement Overview Page
    And User post a "Naukri Private Job"
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    #Then User should be redirected to requirement overview page
    And refresh the page
    And User click on view button of Naukri Private Job on Overview page
    And Candidate applies on the job posted by the user through Naukri Platform
      | assementtestingqa@gmail.com | Test@123 |
    Then User Verify The count of the applications will be present as a summation of all applications on the requirement overview page
    And User Verify on the count will navigate to the requirement inbox page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And User verify that Recipient get the listed mail for specific requirement with label "RMSGeneralMails"
      |                                |
      | VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
    And User click on forward Mail option
    Then User should be redirected to the forward lightbox
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo                      | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      | assementtestingqa@gmail.com | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And User verify that Recipient get the listed mail for specific requirement with label "RMSGeneralMails"
      |                                |
      | VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
    When User can perform actions like "bulk status change"
    Then User Verify the details of "bulk status change" is displayed
    When User can perform actions like "Comment"
    Then User Verify the details of "comment" is displayed
    When User can perform actions like "star rating"
    Then User Verify the details of "star rate" is displayed
    When User can perform actions like "Add To Backup"
    And User click on candidate and move to candidate page
    And User move to the candidate to "Shortlisted - stage1" stage
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    And User click on Send To candidate button in success message
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject | MailAttachment             | MailBody |
      |        | CC@yopmail.com |             | OfferLetterPathLessThan5MB |          |
    And User verify that Recipient get the listed mail for specific requirement with label "RMSGeneralMails"
      |                                |
      | VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
     And User click on mailboxtab
    #Then User verify ThreadSubject is displayed as "Updated Subject" for Video Interview
    And User click on Forward to HM from success message strip
    
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo                      | MailCC         | MailSubject | MailAttachment             | MailBody |
      | assementtestingqa@gmail.com | CC@yopmail.com |             | OfferLetterPathLessThan5MB |          |
    And User verify that Recipient get the listed mail for specific requirement with label "RMSGeneralMails"
      |                                |
      | VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
    And refresh the page
    And User Verify the details of "remove from backup" is displayed
    When User get the current page Url
    And I logout of RMS
    #And Candidate accept the Interview
    #And HM accept the Interview
    Given "Enterprise" user is on Settings Page with "HiringManager1"
    When User move to "specificURL" URL
    And I click on Give Feedback button for first application
    And I fill all the mandatory fields
    And I Approve Candidate by clicking on "Reject" button
    Then I see "Reject" is appended before the stage name
    And I logout of RMS
    Given User login into RMS as an "<userType>" as "Superuser"
    And User move to "specificURL" URL
    And refresh the page
    And Use Verify the Status is displayed On Requirement Inbox Page
    #Then User Verify the Interview is accepted by candidate and HM
    #Then Verify rejected count can be seen in the reports section if we include the rejected column of the stage
    #When User click on rejected count present on the report
    #Then User will be redirected to the search result page containing the application in the rejected state
    Examples: 
      | userType   |
      | Enterprise |

  @id:2 @E2E
  Scenario: To create a Requirement using Create a Single Profile
    Given I login into RMS as an "singh.avinash@naukri.com|P@ssw0rd0987" user
    When I click on "Account Settings" by hovering on username
    And I am on "groupListing" page
    And User add group with "singh.avinash@naukri.com" as HR and also as HRSpoc, "avinashHM@yopmail.com" as HM and "avinashHM@yopmail.com" as HMSpoc
    And User map HiringManager "avinashhm@yopmail.com" to "Interview - Round 1" stage
    And refresh the page
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fills in the "" as the group attached to the requirement
    And User selects "Visible to All in Group" as the visibility mode of requirement
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    And User should be able to see the call actions dd on CV details page
    When I click on status change drop down
    And I click on "Shortlisted| - stage1" on DD
    Then I should be able to see candidate on "Shortlisted - stage1" on profile listing page
    When I click on status change drop down
    And I click on "Interview| - Round 1" on DD
    Then I should be able to see candidate on "Interview - Round 1" on profile listing page
    When User provides InterviewDate as current date
    And User provides the Interview time as "01" hours and "00" minutes
    And User fills in the interview venue as "Delhi"
    And User click on set Interview
    Then I should be able to see the success message "Success! Application status has been successfully changed to Interview - Round 1" On CV details Page
    When User marks the contact status of candidate as "Called"
    Then User should be able to see "Called" as the status
    When User sees the video interview promotion
    When User comments "Comment" on the application created
    Then User should be able to see the "Comment" in comments section as the comment on index 1
    When User gives the star rating to the application as 5 stars
    Then User should be able to see the star rating value as "5"
    When User navigates to the dashboard page
    And User scrolls down to the Events section
    And User clicks on the calender icon of Events Widget
    And User selects the date as "today"
    Then User should be able to see the Candidate present under the interview section
    When I click on "Logout" by hovering on username
    And I login into RMS as an "avinashhm@yopmail.com|P@ssw0rd0987" user
    And User should be redirected to the HM dashboard page
    Then User finds the candidate under section Upcomimg Interviews
    When User clicks on the candidate name
    And User clicks on Give Feedback button of added candidate CV details page
    And User provides the star rating as "5" to the candidate
    And User provides the "Approved" as approved comment
    And User approves Candidate by clicking on "Approve" button
    When I click on "Logout" by hovering on username
    And I login into RMS as an "singh.avinash@naukri.com|P@ssw0rd0987" user
    When User navigates to the added candidate CV details page
    Then I should be able to see candidate on "Approved - Interview - Round 1" on profile listing page
    And User should be able to see the Assessment Feedback Block

  @id:3 @E2E @wip @UserJourney14
  Scenario Outline: Journey 14: Tracking Mails in mailbox tab sent to candidate from recruiter
   	Given I login into RMS as an "singh.avinash@naukri.com|P@ssw0rd0987" user
   	When I navigate to Settings page
    And I click on Manage Profile
    And I "Grant Permission" to mask and unmask candidate mails
    And User is on "addSingleProfile" page
    And I fill details of the candidate
    And I click on Save button
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    And User click on Message option
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And I search for the candidate for master profile with "email"
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And delete all mail with label "RMSGeneralMails"
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
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com | Test Subject for Req | OfferLetterPathLessThan5MB | Test Mail Body .. |
    And User click on mailboxtab
    And I apply filter "Requirement sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    Then Verify ThreadSubject is displayed as "Updated Subject"
    When refresh the page
    And I click on Request Document option
    And I click on Document List dropdown
    And I select option as "Select All"
    And I click on Request Button
    And User fill in the subject field as "Updated Subject"
    And I click on Term and Condition check box
    And I click on "SEND MAIL"
    And User click on mailboxtab
    And I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    Then Verify ThreadSubject is displayed as "Updated Subject"
    When refresh the page
    And I move the candidate to "Applied - Matching" Stage
    And User fill in the subject field as "Updated Subject"
    And I uncheck checkbox for cc to send mail successfully
    And I fill in the Body field of Mail Template
    And User click on mailboxtab
    And I apply filter "Status change email sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    Then Verify ThreadSubject is displayed as "Updated Subject"
    #And Mail is tracked under mailbox tab with subject on top of thread and header for status changed to applied matching ,when, changed by field having info
		#And Message Body and attachment is visible 
    #And Click on message body to expand and see whole message  in the body
		#Download attachment by clicking on any attachment or zip by clicking on download all option
		When User get the current page Url
		And I click on Requirement Name on candidate page  
		And click on selection stage
    And User click on StageName the click on SubStage and attach test to that stages
      | StageName | SubStage | Testname           | SubTest            |
      |Interview  | Round 1    | Healthcare       | Life Sciences Test |  
    When User move to "specificURL" URL
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    When click on folllowing tuple Link
      | Send Test |
    When reload the page
    Then verify the assessment tuple on srp page
      | Send Reminder |
    #When User move to that CV Detail Page
    #When candidate reply to interview mail for the feedback check on top of mailbox tab red  box with count one is visible
		#Message received from candidate is visible at top with blue  background having mark as read option
		And refresh the page
		Then User click on mailboxtab
    Then I apply filter "Status change email sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
		And I click on replyAll button from status change message
    Then I check email id's in To field
    Then I fill message body and send the message
    And Verify message is listing under same subject on top and hover message for recently sent is displayed
    And User get the current page Url
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
    And User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Hiring Managers"
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    When click on Add New offer Template
    And Enter offer approval template name
    And I save "first" Offer template name
    And Enter stage name "stage1"
    And Enter one approver as "Enterprise.Sub_user"
    And Click on save template
    When click on Add New offer Template
    And Enter offer approval template name
    And I save "second" Offer template name
    And Enter stage name "stage1"
    And Enter one approver as "Enterprise.Sub_user"
    And click on add approval stage
    And Enter second stage name "stage2"
    And Enter one approver in stage2 as "Enterprise.Super_user"
    And Click on save template
    And user click on "SAVE" button
    And User move to "specificURL" URL
    And refresh the page
    
    And I click on Requirement Name on candidate page
    And User click on the tab "Edit" on requirement overview page
    And User fill other details of the Requirement when edit
    And User fill Group Details for a Requirement
      | NoGroup | Visible to all in the group |
		And User click on the tab "Next" on requirement overview page
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on the tab "Save Requirement" on requirement overview page
    
    #offer approval
	  And User move to "specificURL" URL
    And refresh the page
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And User fill in the subject field as "Updated Subject"
    And I fill Offer Mail Body field
    And I click on Select Approval Process dropdown
    And I select "second" approval process from dropdown
    
    And I uncheck "Mail Automicatically to candidate once everyone approves" checkbox on Attach Offer Letter page
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "Enterprise.Sub_user"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    Given I login into RMS as an "jatinrec@yopmail.com|P@ssw0rd0987" user
    And User move to "specificURL" URL
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I logout of RMS
    Given I login into RMS as an "singh.avinash@naukri.com|P@ssw0rd0987" user
    And User move to "specificURL" URL
    And refresh the page
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And refresh the page
    Then I should see "Offer Approved by All" offer status on CV Details page
    Then I should see "Offer Approved by All" status text in offer timeline
   
    And refresh the page
    Then User click on mailboxtab
    Then I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
    Then user Verify "MasterProfile Block" is visible
    And user Verify "MasterProfile MailBox" is visible
    And user Verify "UnMappedProfile Block" is visible
    And user Verify "UnMappedProfile MailBox" is visible
     Examples:
      | subuserType        |
      | Enterprise.Subuser |

  #Then I apply filter "Documents requested" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
  @id:4 @E2E
  Scenario: To verify the selection stage present in the RMS system
    Given I login into RMS as an "singh.avinash@naukri.com|P@ssw0rd0987" user
    When I click on "Account Settings" by hovering on username
    And User clicks on Customize the Selection Process on settings page
    Then User should be redirected to "Customize the Selection Process" page
    When User records the selection stages of the system
    And User select a "Add A New Requirement" from "Requirements" option
   And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the more salary details
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User click on the tab "Selection Stages" on requirement overview page
    When User records the selection stages of the requirement created
    Then User should observe that the selection stage in customize selection state and requirement level selection state is same
    When I click on "Account Settings" by hovering on username
    And I am on "groupListing" page
    And User add group with "singh.avinash@naukri.com" as HR and also as HRSpoc, "avinashHM@yopmail.com" as HM and "avinashHM@yopmail.com" as HMSpoc
    And refresh the page
    And User adds the selection stage "testStage" in the group created
    Then User should be able to see the stage added
    When User clicks on continue button on the selection stage lightbox
    And User redirects to the requirement overview page of the created requirement
    And User clicks on "Edit" for the created requirement
    And User fills in the "" as the group attached to the requirement
    And User click on "Add Requirement" button on requirement creation
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User click on the tab "Selection Stages" on requirement overview page
    Then User should be able to view the new selection stage addded

    @id:5 @E2E @UserJourney10 @whiteLabeling @Settings
  Scenario: To verify the Whitelabel settings of RMS user
    #Given I login into RMS as an "singh.avinash@naukri.com|P@ssw0rd0987" user
    Given I login into RMS as an "gupta.mansi@naukri.com|N0wy0us33m3#" user
   	When I navigate to Settings page
    And user click on "Manage White labelling Settings" link
    Then verify that user is able to see the listed headings on page
      | White Labeling      |
      | Choose Custom URL   |
      | Company Name:       |
      | About Company:      |
      | Choose Colour Theme |
      | Mail                |
    When user is able to fill Custom URL for WhiteLabel Settings
    |customurl|  
    And user fill Company Name
    And user switch to frame about company
    And user fill About Company
    And user switch to default frame
    And user choose color theme & click on save
    Then verify success message "Settings saved successfully"
    When User create a new requirement and move to overview page
    And User get the current page Url
    And User verify "Requirement OverView page URL" "contains" custom url as prefix
    And User click on the tab "Edit" on requirement overview page
    And User click on the tab "Next" on requirement overview page
    Then User verify "Requirement OverView page URL" "contains" custom url as prefix
    When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    Then User verify data of "Company Name" on white label setting page displayed
    #And User verify data of "About Company" on white label setting page displayed
    When User click on the tab "Save Requirement" on requirement overview page
    And I navigate to Settings page
    Then User verify "Setting page URL" "contains" custom url as prefix
    When user click on "Manage White labelling Settings" link
    And user click on remove button on white label page
    #And User enter company name as "" and about company as "" details from the page
    And user fill Company Name
    And user switch to frame about company
    And user fill About Company
    And user switch to default frame
    And user choose color theme & click on save
    When User create a new requirement and move to overview page
    And User verify "Requirement OverView page URL" "does not contain" custom url as prefix
    And User click on the tab "Edit" on requirement overview page
    And User click on the tab "Next" on requirement overview page
    Then User verify data of "Company Name" on white label setting page displayed
    #And User verify data of "About Company" on white label setting page displayed
    When User click on the tab "Save Requirement" on requirement overview page
    When I navigate to Settings page
    When user click on "Manage White labelling Settings" link
    And user fill Company Name
    And user switch to frame about company
    And user fill About Company
    And user switch to default frame
    And user choose color theme & click on save
    Then verify success message "Settings saved successfully"
   