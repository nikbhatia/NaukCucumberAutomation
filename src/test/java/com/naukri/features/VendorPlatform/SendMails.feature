Feature: Test Scenarios of Multiple Mail type
  @id:1 @SendMail1 @SendAMessage @SendARequirement
  Scenario Outline: Verify the flow of Send Message, send A Requirement and Forard flow
    Given User adds a single profile to a new requirement through API for "<userType>" user
   	 | assementtestingqa@gmail.com |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement

    And I move to Requirement Inbox Page
    And User refresh the page until candidate visible
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
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
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
    And User launch mail content in browser
    	 | VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
    Examples: 
      | userType   |
      | Enterprise |
  @id:4 @SendMail @EmailCandidate1
  Scenario Outline: Verify the flow of EmailCandidate and Forward to Hiring Manager
    Given User login into RMS as an "<userType>" as "Superuser"
    When User is on "groupListing" page
    And User add group with "singh.avinash@naukri.com" as HR and also as HRSpoc, "avinashHM@yopmail.com" as HM and "avinashHM@yopmail.com" as HMSpoc
    And User map HiringManager "avinashhm@yopmail.com" to "Interview - Round 1" stage
    And refresh the page
    And User create a new requirement and move to overview page
    And User click on the tab "Edit" on requirement overview page
    And User fill Group Details for a Requirement
      | NoGroup | Visible to all in the group |
    And User click on the tab "Next" on requirement overview page
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company
    And User click on the tab "Save Requirement" on requirement overview page
    And refresh the page
    Given I am adding a single profile from Requirement OverView page
      | assementtestingqa@gmail.com |
   
    And I click on Requirement Name on candidate page
    And I move to Requirement Inbox Page
    And User refresh the page until candidate visible
    And User select the first candidate checkbox
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    Then User verify success message is displayed
    When User click on Send To candidate button in success message
     And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody          |
      |        | CC@yopmail.com |       							 | OfferLetterPathLessThan5MB | 									|
    And User verify that Recipient get the listed mail for specific requirement with label "RMSGeneralMails"
      |                                |
      | VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
    And User click on Forward to HM from success message strip
    And delete all mail with label "RMSGeneralMails"
    And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      | MailTo 														| MailCC         | MailSubject         | MailAttachment             | MailBody          |
      |  assementtestingqa@gmail.com      | CC@yopmail.com |       							 | OfferLetterPathLessThan5MB | 									|
    And User verify that Recipient get the listed mail for specific requirement with label "RMSGeneralMails"
      |                                |
      | VideoInterviewMailContent.html |
    And User launch mail content in browser
    	| VideoInterviewMailContent.html |
    Then User compare that mail Preview and Candidate Inbox mail content
    Examples: 
      | userType   |
      | Enterprise |
      
    @id:4 @MLHOldReport1
  Scenario Outline: Verify the flow of EmailCandidate and Forward to Hiring Manager
    Given User login into RMS as an "<userType>" as "Superuser"
    #When User is on "groupListing" page
    #And User add group with "singh.avinash@naukri.com" as HR and also as HRSpoc, "avinashHM@yopmail.com" as HM and "avinashHM@yopmail.com" as HMSpoc
    #And User map HiringManager "avinashhm@yopmail.com" to "Interview - Round 1" stage
    #And refresh the page
    #And User create a new requirement and move to overview page
    #When User get the current page Url
    When User goes to the "<ReportType>" Report
    #And User fill values on Report page
    #|DiffCOmbinationOfBreakUPandReportType| 
    
    And User fill values on Report page
    |ReportWithOnlyRecruiterData| 
    
    And User click on Generate Report button
    And User store the report data in database
    |ReportWithOnlyRecruiterData|Partnerassessment|
    And User move to "specificURL" URL
    #And User click on the tab "Edit" on requirement overview page
    #And User fill Group Details for a Requirement
      #| NoGroup | Visible to all in the group |
    #And User click on the tab "Next" on requirement overview page
    #And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    #And User chose "Functional Area" as "Banking / Insurance"
    #And User chose "Role" as "Cash Officer"
    #And User click on the tab "Save Requirement" on requirement overview page
    #And refresh the page
    #Given I am adding a single profile from Requirement OverView page
      #| assementtestingqa@gmail.com |
    #And I click on Requirement Name on candidate page
    #And I move to Requirement Inbox Page
    #And User refresh the page until candidate visible
    #And User select the first candidate checkbox
    #And User move to the candidate to "Interview - Round 1" stage
    #And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    #And User provide InterviewDate and time
    #And User click on set Interview
    #Then User verify success message is displayed
    #When User update "Interview" details in database
    #|ReportWithAllData|
     #
    #When User click on Send To candidate button in success message
     #And delete all mail with label "RMSGeneralMails"
    #And User send email with MailTo, Mail CC, Mail Subject, Mail Body and Mail Attachment
      #| MailTo | MailCC         | MailSubject          | MailAttachment             | MailBody         |
      #|        | CC@yopmail.com |       							 | OfferLetterPathLessThan5MB | 									|
      #
     When User update "Emailed" details in database
    |ReportWithOnlyRecruiterData| 
    When User goes to the "<ReportType>" Report
    And User fill values on Report page
    |ReportWithOnlyRecruiterData| 
    Then Verify the data in report is displayed successfully
    |ReportWithOnlyRecruiterData| 
    
     Examples: 
      | ReportType       | userType   |
      | Recruiter Report | Enterprise |
     
     
     
      @id:4 @MLHOldReport11
  Scenario Outline: Verify the flow of EmailCandidate and Forward to Hiring Manager
     Given User adds a single profile to a new requirement through API for "<userType>" user
   	 | assementtestingqa@gmail.com |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement

    And I move to Requirement Inbox Page
    And User refresh the page until candidate visible
    When User get the current page Url
    When User goes to the "<ReportType>" Report
    And User fill values on Report page
    		|ReportWithOnlyRecruiterData| 
    And User click on Generate Report button
    And User store the report data in database
    	  |ReportWithOnlyRecruiterData|
    And User move to "specificURL" URL
    And User refresh the page until candidate visible
   	And User select the first candidate checkbox
    And User move to the candidate to "Interview - Round 1" stage
    And User click on Interview Type dropdown and select "Google Meet/Hangout" option
    And User provide InterviewDate and time
    And User click on set Interview
    Then User verify success message is displayed
    When User update "Interview" details in database
       |ReportWithOnlyRecruiterData|
     
    When User goes to the "<ReportType>" Report
    And User fill values on Report page
   		 |ReportWithOnlyRecruiterData| 
    And User click on Generate Report button
    Then Verify the data in report is displayed successfully
   		 |ReportWithOnlyRecruiterData| 
   	 And User fill values on Report page
   		 |ReportWithOnlyRecruiterData|
     Examples: 
      | ReportType       | userType   |
      | Recruiter Report | Enterprise2 |
       