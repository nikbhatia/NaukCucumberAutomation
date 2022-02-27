Feature: Test Scenarios of video Interview

  @id:1 @VideoInterview
  Scenario Outline: Verify Video Interview scheduling mail on mailbox tab for Interview stage from Requirement Inbox Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And User select a "Add a Single Profile" from "Profiles" option
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on Requirement Name on candidate page
    And I move to Requirement Inbox Page
    And User refresh the page until candidate visible
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    Then User verify success message is displayed
    And User verify Hangout contact card is present on hovering on icon 
    When User click on Send To candidate button in success message
    And I uncheck checkbox for cc to send mail successfully
    And User get the text of MailSubject and send the Mail
    And  User click on candidate and move to candidate page
    And User click on mailboxtab
   Then User verify ThreadSubject is displayed as "Updated Subject" for Video Interview
   
   	 Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant |
     
 @id:2 @VideoInterview
  Scenario Outline: Verify Video Interview scheduling mail on Candidate mailbox tab  and Interviwer personal inbox for Interview stage from CV Detail Page
  	Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And delete all mail with label "VideoInterview"
    And User select a "Add a Single Profile" from "Profiles" option
    And I fill in all the details of the candidate
    And I click on Save button
    And refresh the page
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    Then User verify Hangout contact card is present on hovering on icon
    When User click on Send To candidate button in success message
    And I uncheck checkbox for cc to send mail successfully
    And User get the text of MailSubject and send the Mail
    And User click on mailboxtab
   	Then User verify ThreadSubject is displayed as "Updated Subject" for Video Interview
   	And User click on Forward to HM from success message strip
    Then User should be redirected to the forward lightbox
    Then User add To field as "assementtestingqa@gmail.com"
 		And User get the text of MailSubject
 		And User click on Preview and Send
 		And User get all Interview details from "MailPreview"
 		And User Send the mail from Mail Preview
 		And User verify that Recipient get the listed mail for specific requirement with label "VideoInterview"
 			|  |
 			| VideoInterviewMailContent.html |
 		And User launch mail content in browser
 			| VideoInterviewMailContent.html |
 		And User get all Interview details from "CandidateMailbox"
 		Then User compare that mail Preview and Candidate Inbox mail content for Interview details
 		   	
   	 Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant |
  
  @id:3 @VideoInterview
  Scenario Outline: Verify Video Interview scheduling mail from All Application Page
  	Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And User select a "Add a Single Profile" from "Profiles" option
    And I fill in all the details of the candidate
    And I click on Save button
    Then refresh the page
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    Then User verify Hangout contact card is present on hovering on icon
    When User click on Send To candidate button in success message
    And I get the Email id of the candidate
    Given User is on "applicationInbox" page
    When I search the candidate on Application Inbox page with "EmailId"
    And I click on edit icon
    And User provide InterviewDate and time
    And User click on set Interview
    And User click on Send To candidate button in success message
    Then I uncheck checkbox for cc to send mail successfully
    And User get the text of MailSubject and send the Mail
    And  User click on candidate and move to candidate page
    And User click on mailboxtab
   Then User verify ThreadSubject is displayed as "Updated Subject" for Video Interview
   
    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant |
   
     @id:4 @VideoInterview
  Scenario Outline: Verify Video Google Contact card and Interview scheduling mail using contact card from All Application Page
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And User select a "Add a Single Profile" from "Profiles" option
    And I fill in all the details of the candidate
    And I click on Save button
    Then refresh the page
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    And I get the Email id of the candidate
    Given User is on "applicationInbox" page
    And I search the candidate on Application Inbox page with "EmailId"
    Then User verify the Interview type as "Google Meet/Hangout"
    And User verify Hangout contact card is present on hovering on icon
    And User verify heading of contact card
    	| Details of Google Meet/Hangout meeting |
    And User verify the interview link and copy icon
    	| https://hangouts.google.com |
    And User verify "Send to Candidate" and "Send to Interviewer" button are present
    When User click on Send to Interviewer link
    Then User should be redirected to the forward lightbox
    
    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant |
      
  @id:5 @VideoInterview
  Scenario Outline: Verify the mail sent to candidate with Interview details automatically and manually to his personal mailbox
  	Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    And delete all mail with label "VideoInterview"
   Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And I add Default Automatic mailer for "Interview-Round 2" stage.
    And User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User refresh the page until candidate visible
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    Then User verify Hangout contact card is present on hovering on icon
    When User click on Send to candidate link
    And User get the text of MailSubject
 		And User click on Preview and Send
 		And User get all Interview details from "MailPreview"
 		And User Send the mail from Mail Preview
 		And User verify that Recipient get the listed mail for specific requirement with label "VideoInterview"
 			|  |
 			| VideoInterviewMailContent.html |
 		And User launch mail content in browser
 			| VideoInterviewMailContent.html |
 		And User get all Interview details from "CandidateMailbox"
 		Then User compare that mail Preview and Candidate Inbox mail content for Interview details
 		And User close the current tab and switch to parent tab 
    And delete all mail with label "VideoInterview"
    And User move to the candidate to "Interview - Round 2" stage
    And User click on set Interview
    Then User verify Hangout contact card is present on hovering on icon
    And User get the hangout link from Contact card
    And update subject for Automatic mailer
    And User update the hangout link in the hashmap if changed
    And User verify that Recipient get the listed mail for specific requirement with label "VideoInterview"
 			|  |
 			| VideoInterviewMailContent.html |
 		And User launch mail content in browser
 			| VideoInterviewMailContent.html |
 		And User get all Interview details from "CandidateMailbox"
 		Then User compare that mail Preview and Candidate Inbox mail content for Interview details
 		And User close the current tab and switch to parent tab
 		And I navigate to Settings page
    And I remove Automatic mailer for "Interview-Round 2" stage.
 			   	
 		Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant |

    