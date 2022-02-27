Feature: Assessment features on Requirement overview page and test Details On Srp And CV Details Page

  @id:1 @SendAssessment1 @SendANewAssessmentHE @partnerAssessment
  Scenario Outline: To verify Send a new Assessment from HackerEarth to candidates in a requirement
  Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
    	| client_id                                                        | client_secret                            |
        | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User select all the candidates at "All" stages
    And User hover on Send Assessment to open Dropdown
    And User click on Send a new assessment
    Then User verify the heading on Send Assessment page
    And User verify the subheading on Send Assessment page
    When User click on "HackerEarth" radio button
    Then User verify partner tests should be present with expected details for "HackerEarth"
    And User verify Create New Test button is present
    And User hover on a particular test to verify edit and preview button are present and visible
    And User select a particular or first test for partner
      | Android Test edited |
    And User click on Send Assessment button
    Then User verify the heading and sub heading of modal window for test for "sending" assessments
      | Android Test edited |
      | 1 |
    And User verify that "Not yet invited" checkbox is checked by default
    And User verify that radio buttons under "Not yet invited" checkbox are not present
    And User verify whether webcam and tab switching checkboxes are present for "HackerEarth"
    When User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "HackerEarth"
    And User verify that "success" message is displayed and correct
    	| 1 |
    Examples: 
      | userType       |
      | Enterprise2    |
      | Company        |
      | ProConsultant2 |
      
      @id:2 @SendAssessment1 @SendANewAssessmentCodility @Codility @partnerAssessment
  Scenario Outline: To verify Send a new Assessment from Codility to candidates in a requirement
  Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "Codility" if not configured
      | Api key              |
      | MEtbanE46K7JYFx40GiD |
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User select all the candidates at "All" stages
    And User hover on Send Assessment to open Dropdown
    And User click on Send a new assessment
    Then User verify the heading on Send Assessment page
    And User verify the subheading on Send Assessment page
    When User click on "Codility" radio button
    Then User verify partner tests should be present with expected details for "Codility"
    And User verify Create New Test button is present
    And User hover on a particular test to verify edit and preview button are present and visible
    And User select a particular or first test for partner
      | Do Not Edit test |
    And User click on Send Assessment button
    Then User verify the heading and sub heading of modal window for test for "sending" assessments
      | Do Not Edit test |
      | 1 |
    And User verify that "Not yet invited" checkbox is checked by default
    And User verify that radio buttons under "Not yet invited" checkbox are not present
    And User verify whether webcam and tab switching checkboxes are present for "HackerEarth"
    When User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "Codility"
    And User verify that "success" message is displayed and correct
    	| 1 |
    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
      
  @id:3 @SendAssessment @SendANewAssessmenrER @partnerAssessment
  Scenario Outline: To verify Send a new Assessment from Naukri Assessments to candidates in a requirement
   Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User select all the candidates at "All" stages
    And User hover on Send Assessment to open Dropdown
    And User click on Send a new assessment
    Then User verify the heading on Send Assessment page
    And User verify the subheading on Send Assessment page
    When User click on "Naukri Assessments" radio button
    And User expand a particular or first test in Naukri Assessments
    And User select a particular or first test in expanded category in Naukri Assessments
      | Applied Geology Skills Test |
    And User click on Send Assessment button
    Then User verify the heading and sub heading of modal window for test for "sending" assessments
      | Applied Geology Skills Test |
      | 1 |
    And User verify that "Not yet invited" checkbox is checked by default
    And User verify that radio buttons under "Not yet invited" checkbox are not present
    Then User verify whether webcam and tab switching checkboxes are present for "Naukri Assessments"
    And User verify the text of webcam and tab switching checkboxes
      | Monitor Candidate using Webcam |
      | Restrict Candidate from Switching Tabs |
    When User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "Naukri Assessments"
    And User verify that "success" message is displayed and correct
    	| 1 |
   Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
      
  @id:4 @SendAssessment @OneA @partnerAssessment
  Scenario Outline: To verify that attached test is visible in Send Assessment dropdown and sending it to candidate on same stage and pending case as well
    Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    Then User validate "Naukri Assessments" is shown configured
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button
    And User click on "Naukri Assessments" radio button
    And User expand a particular or first test in Naukri Assessments
    And User select a particular or first test in expanded category in Naukri Assessments
      | Applied Geology Skills Test |
    And User click on Next button
    And User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Applied Geology Skills Test"
    And User verify the attach button is now "View Assessment (1)"
    And User select all the candidates at "All" stages
    And User hover on Send Assessment to open Dropdown
    Then User verify that "Applied Geology Skills Test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "Applied Geology Skills Test" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User verify the heading and sub heading of modal window for test for "sending" assessments
      | Applied Geology Skills Test |
      | 1 |
    And User verify that "Not yet invited" checkbox is checked by default
    And User verify that radio buttons under "Not yet invited" checkbox are not present
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "Naukri Assessments"
    And User verify that "success" message is displayed and correct
    	| 1 |
    And User hover on Send Assessment to open Dropdown
    Then User verify that "Applied Geology Skills Test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "Applied Geology Skills Test" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User verify the heading and sub heading of modal window for test for "pending" assessments
      | Applied Geology Skills Test |
      | 1 |
    And User verify that "Not yet invited" and "Test already sent" checkboxes are not present
    And User verify that "SEND" button is not clickable
    And User click on "CANCEL" in Send Assessment confirmation box

	Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
      
  @id:5 @SendAssessment @OneB @OneC1 @partnerAssessment
  Scenario Outline: Sending attached HackerEarth test to candidates where  not all are on same stage and when the candidate not at same stage as test
     Given User login to the application "rmsDashboardPage" using "Superuser" of "<userType>" user
     And User create a new requirement and move to overview page
     And User adds multiple profiles to an existing requirement through API for "<userType>"
    	|  |
     	| 2 |
    When User navigate to settings page
    Then User click on Assessment Partner Integration Assessment
    Then User validate "HackerEarth" is shown configured
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button
    When User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
      | Android Test edited |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Android Test edited"
    And refresh the page
    And User verify the attach button is now "View Assessment (1)"
    And User move to the candidate to "Duplicate" stage
    When User select all the candidates at "All" stages
    And User hover on Send Assessment to open Dropdown
    Then User verify that "Android Test edited" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "Android Test edited" attached at "On Hold" stage in "SendAssessment" Dropdown
    And User verify the heading and sub heading of modal window for test for "sending" assessments
      | Android Test edited | 
      | 2 |
    And User verify that "Not yet invited" checkbox is checked by default
    And User verify that 2 radio buttons under "Not yet invited" checkbox  present
    And User select "sendToStageNew" radio button under "Not yet invited" checkbox
    And User verify whether webcam and tab switching checkboxes are present for "HackerEarth"
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "HackerEarth"
    And User verify that "success" message is displayed and correct
    	| 2 |
    When User select the candidate not on "Duplicate" stage
    And User hover on Send Assessment to open Dropdown
    When User click on "Android Test edited" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User verify the heading and sub heading of modal window for test for "sending" assessments
      | Android Test edited |
      | 1 |
    And User verify that "Not yet invited" checkbox is checked by default
    And User verify that radio buttons under "Not yet invited" checkbox not present
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "HackerEarth"
    And User verify that "success" message is displayed and correct
    	| 1 |
		Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
	
  @id:6 @SendAssessment @SRP @partnerAssessment
  Scenario Outline: To verify that user is able to see and do actions on the tuples on SRP page and candidates is getting ExpertRating assessment mails for "<userType>"
    Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    And delete all mail with label "Assessment"
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    Then User validate "Naukri Assessments" is shown configured
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button
    And User click on "Naukri Assessments" radio button
    Then User expand a particular or first test in Naukri Assessments
    Then User select a particular or first test in expanded category in Naukri Assessments
      | Applied Geology Skills Test |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Applied Geology Skills Test"
    And refresh the page
    And User move to the candidate to "Duplicate" stage
    Then User verify the "Send Test" tuple for the candidate on "SRP" page
      | Applied Geology Skills Test |
    When click on folllowing tuple Link
      | Send Test |
    Then User verify the "soon be sent" tuple for the candidate on "SRP" page
       | Applied Geology Skills Test |
    And reload the page
    Then User verify the "Send Reminder" tuple for the candidate on "SRP" page
      | Applied Geology Skills Test |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Online Assessment Test link for |
      | assessmentTest.html             |
    And delete all mail with label "Assessment"
    When click on folllowing tuple Link
      | Send Reminder |
    And User select response in Reminder Confirmation Box
      | YES |
    Then User verify the "reminder sent" tuple for the candidate on "SRP" page
     	 | Applied Geology Skills Test |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Reminder: Online Assessment Test link for |
      | assessmentTest.html                       |

    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |

  @id:7 @SendAssessment @CVdetails @partnerAssessment
  Scenario Outline: To verify that user is able to see and do actions on the tuples on CVsdetails page and candidates is getting HackerEarth assessment mails for "<userType>"
  Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
   And User add an copy of HackerEarth Test for below credentials
    	  | Username                  | Password    | testName             |
        | Kaur.amanpreet@naukri.com | amanpreet21 | Compiler Design Test |
    And delete all mail with label "Assessment"
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
    	  | client_id                                                        | client_secret                            |
        | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
     When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button
    And User click on "HackerEarth" radio button
     Then User select a particular or first test for partner
    	|  |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Java Test 33" 
    And refresh the page
    And User move to the candidate to "Duplicate" stage
    And User move to CVdetails page for the candidate
    Then User verify the "Send Test" tuple for the candidate on "CVdetails" page
      | |
    When click on folllowing tuple Link
      | Send Test |
    Then User verify the "soon be sent" tuple for the candidate on "CVdetails" page
       |  |
    And reload the page
    Then User verify the "Send Reminder" tuple for the candidate on "CVdetails" page
      |  |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Online Assessment Test link for |
      | assessmentTest.html             |
    And delete all mail with label "Assessment"
    When click on folllowing tuple Link
      | Send Reminder |
    And User select response in Reminder Confirmation Box
      | YES |
    Then User verify the "reminder sent" tuple for the candidate on "CVdetails" page
     	 |  |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Reminder: Online Assessment Test link for |
      | assessmentTest.html                       |
	  And User delete the test from HackerEarth
    	 | Username                  | Password    | testName      |
       | Kaur.amanpreet@naukri.com | amanpreet21 |  			 			 |
    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
      
      @id:8 @SendAssessment @CVdetails @Codility @partnerAssessment
  Scenario Outline: To verify that user is able to see and do actions on the tuples on CVsdetails page and candidates is getting Codility assessment mails for "<userType>"
  Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    And delete all mail with label "Assessment"
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "Codility" if not configured
      | Api key              |
      | MEtbanE46K7JYFx40GiD |
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button
    And User click on "Codility" radio button
     Then User select a particular or first test for partner
    	| Do Not Edit test |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Do Not Edit test"
    And refresh the page
    And User move to the candidate to "Duplicate" stage
    And User move to CVdetails page for the candidate
    Then User verify the "Send Test" tuple for the candidate on "CVdetails" page
      | Do Not Edit test |
    When click on folllowing tuple Link
      | Send Test |
    Then User verify the "soon be sent" tuple for the candidate on "CVdetails" page
       | Do Not Edit test |
    And reload the page
    Then User verify the "Send Reminder" tuple for the candidate on "CVdetails" page
      | Do Not Edit test |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Online Assessment Test link for |
      | assessmentTest.html             |
    And delete all mail with label "Assessment"
    When click on folllowing tuple Link
      | Send Reminder |
    And User select response in Reminder Confirmation Box
      | YES |
    Then User verify the "reminder sent" tuple for the candidate on "CVdetails" page
     	 | Do Not Edit test |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Reminder: Online Assessment Test link for |
      | assessmentTest.html                       |

    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
   

  @id:9 @SendAssessment @ResultOnSRP12 @Sanity @NaukriAssessments @partnerAssessment
  Scenario Outline: To verify that when candidate of "<userType>" user complete the automatically sent Naukri Assessments test, results should appear on the SRP Page
    Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And delete all mail with label "Assessment"
   And User click on Add Assessment button 
    Then User click on "Naukri Assessments" radio button
    Then User expand a particular or first test in Naukri Assessments
    Then User select a particular or first test in expanded category in Naukri Assessments
    	| Applied Geology Skills Test |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Applied-Matching" stage from the Dropdown
    Then User click on trigger test automatically check box and fill "20" in  candidates allowed textbox
    Then User click on Attach test button
    And User verify the success message for test "Applied Geology Skills Test" 
    And I move to Requirement Inbox Page
    And User move to the candidate to "Applied - Matching" stage
    And User reload the page.
    Then User verify the "Send Reminder" tuple for the candidate on "SRP" page
      | Applied Geology Skills Test |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
        | Online Assessment Test link for |
        | assessmentTest.html             |
    And User launch mail content in browser
      | assessmentTest.html             |
    And Candidate attempt the test for "Naukri Assessments"
    And User close the current tab and switch to parent tab
    Then User verify result on Srp with "cutoff present" as "Failed" for the test
      | Applied Geology Skills Test |
    And User update the requirement name in database for "<userType>"

   Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |

      
      @id:10 @SendAssessment @ResultOnSRP1 @Sanity @Codility @partnerAssessment
  Scenario Outline: To verify that when candidate of "<userType>" user complete the automatically sent Codility test, results should appear on the SRP Page
    Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And delete all mail with label "Assessment"
   And User click on Add Assessment button 
    Then User click on "Codility" radio button
    Then User select a particular or first test for partner
    	| Do Not Edit test |
    And User click on Next button  
    Then User verify no stage selected by default
    Then User click on select stage Dropdown
    And User select "Applied-Matching" stage from the Dropdown
    Then User click on trigger test automatically check box and fill "20" in  candidates allowed textbox
    Then User click on Attach test button
     And User verify the success message for test "Do Not Edit test"
    	And I move to Requirement Inbox Page
    	And User move to the candidate to "Applied - Matching" stage
    	And User reload the page.
      Then User verify the "Send Reminder" tuple for the candidate on "SRP" page
         | Do Not Edit test |
      And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
        | Online Assessment Test link for |
        | assessmentTest.html             |
    And User launch mail content in browser
      | assessmentTest.html             |
    And Candidate attempt the test for "Codility"
    And User close the current tab and switch to parent tab
      Then User verify result on Srp with "cutoff absent" as "noResult" for the test
          | Do Not Edit test |

   Examples: 
      | userType       |
      | Enterprise2    |
      | Company        |
      | ProConsultant2 |
      
      
       @id:11 @SendAssessment @ResultOnCVDetails @Sanity @HackerEarth @partnerAssessment @ResultOnSRP
  Scenario Outline: To verify that when candidate of "<userType>" user complete the automatically sent HackerEarth test, results should appear on the CVdetails Page
    Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    And User add an copy of HackerEarth Test for below credentials
    	  | Username                  | Password    | testName             |
        | Kaur.amanpreet@naukri.com | amanpreet21 | Compiler Design Test |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And delete all mail with label "Assessment"
    And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
    	|  |
    And User click on Next button  
    Then User verify no stage selected by default
    Then User click on select stage Dropdown
    And User select "Applied-Matching" stage from the Dropdown
    Then User click on trigger test automatically check box and fill "20" in  candidates allowed textbox
    Then User click on Attach test button
     And User verify the success message for test "_Test_donotedit_requiredfor_uts&its" 
    	And I move to Requirement Inbox Page
    	And User move to the candidate to "Applied - Matching" stage
    	And User move to CVdetails page for the candidate
      Then User verify the "Send Reminder" tuple for the candidate on "CVdetails" page
         |  |
      And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
        | Online Assessment Test link for |
        | assessmentTest.html             |
     And User click on mailboxtab  
     Then User verify ThreadSubject is displayed as "Updated Subject" for Video Interview
    And User launch mail content in browser
      | assessmentTest.html  |
    And Candidate attempt the test for "HackerEarth"
    And User close the current tab and switch to parent tab
    Then User verify the "Resend" tuple for the candidate on "CVdetails" page
    	|  |
    Then User verify result on CVdetails page for test with "cutoff present" as failed
    	|  |

    Examples: 
      | userType      |
      | Enterprise2    |
      | Company       |
      | ProConsultant2 |
      
       @id:12 @SendAssessment @ResendCompletedTest @ResultOnSRP1 @partnerAssessment
  Scenario Outline: To verify resend an Assessment from ER to candidates in a requirement from Send dropdown
    Given User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User moved to requirement with name picked from database for "<userType>"
    And I move to Requirement Inbox Page
    And User select all the candidates at "All" stages
     And User hover on Send Assessment to open Dropdown
    And User click on "Applied Geology Skills Test" attached at "Not attached to any stage" stage in "SendAssessment" Dropdown
    And User verify that "Test Already Sent" checkbox is not checked by default
    And User verify that radio buttons under "Test Already Sent" checkbox are not present
    And User click on "Test Already Sent" checkbox
     And User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "Naukri Assessments"
    And User verify that "success" message is displayed and correct
    	| 1 |
    Examples: 
      | userType       |
      | Enterprise2    |
      | Company        |
      | ProConsultant2 |
  
  
    	