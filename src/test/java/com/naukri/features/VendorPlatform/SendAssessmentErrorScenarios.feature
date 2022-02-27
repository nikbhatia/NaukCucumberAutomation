Feature: Test Scenarios of Attach Assessment and related ones.

  @id:1  @AuthorisationError @Docker @TestDBInteraction
  Scenario: Verify the authorisation error for partner when an attached assessment sent from Send dropdown and tuple
  	Given User adds a single profile to a new requirement through API for "Enterprise22" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "Enterprise22" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
    	  | client_id                                                        | client_secret                            |
        | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
     When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
    	| Algorithms Test |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Java Test 33" 
     And refresh the page
     And User select all the candidates at "All" stages
  And User hover on Send Assessment to open Dropdown
  Then User verify that "Algorithms Test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "Algorithms Test" attached at "Duplicate" stage in "SendAssessment" Dropdown
      And User verify the heading and sub heading of modal window for test for "sending" assessments
      | Algorithms Test |
      | 1 |
    And User switch to new tab
     And User navigate to settings page
     Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value       |
      | clientId  |      168613 |
      | partnerId | hackerearth |
     And User close the current tab and switch to parent tab
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that "Authorisation error" for "HackerEarth" is displayed within confirmation box
    And User click on "CANCEL" in Send Assessment confirmation box
    
    
    
    @id:2 @ErrorSendAssessment @TestNotFoundError @partnerAssessment
  Scenario: Verify the TestNotFound error for partner HackerEarth when an attached assessment sent from Send dropdown and tuple
  	Given User adds a single profile to a new requirement through API for "Enterprise2" user
      |  |
    And User add an copy of HackerEarth Test for below credentials
    	  | Username                  | Password    | testName             |
        | Kaur.amanpreet@naukri.com | amanpreet21 | Compiler Design Test |
    When User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
    	  | client_id                                                        | client_secret                            |
        | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
     When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
    	|  |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
     And refresh the page
     And User switch to new tab
   And User delete the test from HackerEarth
    	 | Username                  | Password    | testName      |
       | Kaur.amanpreet@naukri.com | amanpreet21 |  			 			 |
   And User close the current tab and switch to parent tab
        And User select all the candidates at "All" stages
  And User hover on Send Assessment to open Dropdown
  Then User verify that "New test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "New test" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that "TestNotFound error" for "HackerEarth" is displayed within confirmation box
    And User click on "CANCEL" in Send Assessment confirmation box
     And User move to the candidate to "Duplicate" stage 
    When click on folllowing tuple Link
      | Send Test |
    Then User verify that the sticky box is displayed with "TestNotFound error" for "HackerEarth"
     And User click on Okay button in error window
    
     @id:3 @ErrorSendAssessment @TestExpiredError @partnerAssessment
  Scenario: Verify the TestExpired error for partner when an attached assessment sent from Send dropdown and tuple
  	   Given User add an copy of HackerEarth Test for below credentials
    	  | Username                  | Password    | testName             |
        | Kaur.amanpreet@naukri.com | amanpreet21 | Compiler Design Test |
  	And User adds a single profile to a new requirement through API for "Enterprise2" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
    	  | client_id                                                        | client_secret                            |
        | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
     When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button 
    And User click on "HackerEarth" radio button
    And User select a particular or first test for partner
    	|  |
      And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
		And User switch to new tab
		And User update the end date for the new test from HackerEarth to make it expired
    	 | Username                  | Password    | testName  |
        | Kaur.amanpreet@naukri.com | amanpreet21 |          |
     And User close the current tab and switch to parent tab
     And refresh the page
     And User select all the candidates at "All" stages
     And User hover on Send Assessment to open Dropdown
		 Then User verify that "New test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "New test" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that "TestExpired error" for "HackerEarth" is displayed within confirmation box
    And User click on "CANCEL" in Send Assessment confirmation box
     And User move to the candidate to "Duplicate" stage 
    When click on folllowing tuple Link
      | Send Test |
    Then User verify that the sticky box is displayed with "TestExpired error" for "HackerEarth"
      And User click on Okay button in error window
    
    @id:4 @ErrorSendAssessment1 @ErrorAlreadyInvited @partnerAssessment
  Scenario: Verify the Already Invited error for partner when an attached assessment sent from Send dropdown and tuple
  	Given User adds a single profile to a new requirement through API for "Enterprise2" user
      | assementtestingqa@gmail.com |
    And User add an copy of HackerEarth Test for below credentials
    	  | Username                  | Password    | testName             |
        | Kaur.amanpreet@naukri.com | amanpreet21 | Compiler Design Test |
    And User invite an candidate for the test
    	| CandidateEmailID            | testName    |
    	| assementtestingqa@gmail.com |             |
    When User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
    	  | client_id                                                        | client_secret                            |
        | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
     When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
    	|  |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
     And refresh the page
      And User select all the candidates at "All" stages
     And User hover on Send Assessment to open Dropdown
  Then User verify that "New test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "New test" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that In progress status message is displayed for "HackerEarth"
    #And User verify that "failure" message is displayed and correct
    #	| 1 |
    And User click on "View details" link in the error message
    Then User verify that "Already Invited" error for "HackerEarth" is displayed inside modal window
    And User verify that candidate image is displayed on hover as well
    And User verify that candidate name is displayed on hover
    And User click on Okay button in error window
     And User move to the candidate to "Duplicate" stage 
    Then User verify error message in candidate tuple
      | This candidate is already invited |
     And User delete the test from HackerEarth
    	 | Username                  | Password    | testName   |
       | Kaur.amanpreet@naukri.com | amanpreet21 |  			 		|
       
       
  @id:5 @ErrorSendAssessment1 @TestNotFoundError @Codility @wip
  Scenario: Verify the TestNotFound error for partner Codility when an attached assessment sent from Send dropdown and tuple
  	Given User adds a single profile to a new requirement through API for "Enterprise2" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "Codility" if not configured
    	  | MEtbanE46K7JYFx40GiD |
     When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And I move to Requirement Inbox Page
    And User click on Add Assessment button 
    Then User click on "Codility" radio button
    Then User select a particular or first test for Codility
    	| Intern test |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
     And refresh the page
     And User switch to new tab
   And User archive the test from Codility
    	 | Username                  | Password    | testName      |
         | Kaur.amanpreet@naukri.com | amanpreet21 | Intern test   |
   And User close the current tab and switch to parent tab
        And User select all the candidates at "All" stages
  And User hover on Send Assessment to open Dropdown
  Then User verify that "Intern test" attached at "Duplicate" stage is shown in "SendAssessment" Dropdown
    When User click on "Intern test" attached at "Duplicate" stage in "SendAssessment" Dropdown
    And User click on "SEND" in Send Assessment confirmation box
    Then User verify that "TestNotFound error" for "Codility" is displayed within confirmation box
    And User click on "CANCEL" in Send Assessment confirmation box
     And User move to the candidate to "Duplicate" stage 
    When click on folllowing tuple Link
      | Send Test |
    Then User verify that the sticky box is displayed with "TestNotFound error" for "Codility"
     And User click on Okay button in error window
     
     
  @id:5 @DeleteTests
  Scenario: To delete unused tests for HackerEarth
  Given User delete unused tests
    
    
   
    
    
     		