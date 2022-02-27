Feature: Test Scenarios of Attach Assessment and related ones.

  

  @id:1 @AttachPart1 @partnerAssessment  
  Scenario: Verify that Superuser is able to Attach Assessment from all three locations if any of partner is active or configured.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    Then User click on Assessment Partner Integration Assessment
    Then User verify that atleast one partner is active or configured.
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    When I click on Requirement Name on candidate page
    Then User verify that	Attach Assessment button should be available and accessible.
    And User move to selection stage tab in that requirement.
    And User expand a particular or first Stage
    | Interview |
    Then User verify that Attach Assessment link should be available and accessible from all substages
    | Interview |
    And I move to Requirement Inbox Page
    Then User verify that	Attach Assessment button should be available and accessible.
    
   @id:2 @AttachFromSSTab1 @partnerAssessment
   Scenario: Verify that user is able to attach and edit test using selection stages for Naukri Assessments.
   	  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  		Then User create a new requirement and move to overview page
      And User move to selection stage tab in that requirement.
    	And User click on Attach icon for substage "Matching" of stage "Applied"
    	Then User click on "Naukri Assessments" radio button
      Then User expand a particular or first test in Naukri Assessments
      Then User select a particular or first test in expanded category in Naukri Assessments
    		| Applied Geology Skills Test |
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied-Matching"
      Then User click on trigger test automatically check box and fill "20" in  candidates allowed textbox
       Then User click on Attach test button
    	And User verify the success message for test "Applied Geology Skills Test" 
      And User expand a particular or first Stage
    		| Applied |
    	And User verify the test attached on "Matching" substage of expanded stage
    		| Applied Geology Skills Test |
    	Then User click on Edit icon for test attached on "Matching"
    	And User verify the dynamic subheading and prefilled stage on Edit Assessment page for "Applied Geology Skills Test"
    	Then User verify below headings on the page for "Naukri Assessments"
	    	| Edit Assessment |
	    	| Test Link Validity |
	    	| Trigger test automatically when candidate is moved to the selected stage |
	    	| Monitor Candidate using Webcam |
    		| Restrict Candidate from Switching Tabs |
    	Then User verify trigger test automatically check box is checked
    	And User verify the candidates allowed are "20" in the textbox
    	Then User deselect the trigger test automatically check box
    	Then User click on Save Settings button
    	And User verify the settings are updated for the test on "Matching" substage for "Applied" stage
    	
    	
    	@id:3 @AttachFromSSTab1 @Codility @partnerAssessment
   Scenario: Verify that user is able to attach and edit test using selection stages for Codility.
   	  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  		Then User create a new requirement and move to overview page
      And User move to selection stage tab in that requirement.
    	And User click on Attach icon for substage "Matching" of stage "Applied"
    	Then User click on "Codility" radio button
      Then User select a particular or first test for partner
    	 | Do Not Edit test |
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied - Not Matching"
     Then User click on trigger test automatically check box and fill "20" in  candidates allowed textbox
     Then User click on Attach test button
    	And User verify the success message for test "Do Not Edit test"
      And User expand a particular or first Stage
    		| Applied |
    	And User verify the test attached on "Matching" substage of expanded stage
    		| Do Not Edit test |
    	Then User click on Edit icon for test attached on "Matching"
    	And User verify the dynamic subheading and prefilled stage on Edit Assessment page for "Do Not Edit test"
    	Then User verify below headings on the page for "Codility"
	    	| Edit Assessment |
	    	| Trigger test automatically when candidate is moved to the selected stage |
    	Then User verify trigger test automatically check box is checked
    	And User verify the candidates allowed are "20" in the textbox
    	Then User deselect the trigger test automatically check box
    	Then User click on Save Settings button
    	And User verify the settings are updated for the test on "Matching" substage for "Applied" stage
    	
    @id:4 @AttachFromSSTab1 @partnerAssessment @Smoke
   Scenario: Verify that user is able to attach and edit test using selection stages for HackerEarth.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
		Then User create a new requirement and move to overview page
      And User move to selection stage tab in that requirement.
    	And User click on Attach icon for substage "Not Matching" of stage "Applied"
    	Then User click on "HackerEarth" radio button
      Then User select a particular or first test for partner
    	 | _Test_donotedit_requiredfor_uts&its |
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied - Not Matching"
     Then User click on trigger test automatically check box and fill "20" in  candidates allowed textbox
     Then User click on Attach test button
    	And User verify the success message for test "Data Engineer test 1" 
      And User expand a particular or first Stage
    		| Applied |
    	And User verify the test attached on "Not Matching" substage of expanded stage
    		| _Test_donotedit_requiredfor_uts&its |
    	Then User click on Edit icon for test attached on "Not Matching"
    	And User verify the dynamic subheading and prefilled stage on Edit Assessment page for "_Test_donotedit_requiredfor_uts&its"
    	Then User verify below headings on the page for "HackerEarth"
    	| Edit Assessment |
    	| Trigger test automatically when candidate is moved to the selected stage | 
    	Then User verify trigger test automatically check box is checked
    	And User verify the candidates allowed are "20" in the textbox
    	Then User deselect the trigger test automatically check box
    	Then User click on Save Settings button
    	And User verify the settings are updated for the test on "Not Matching" substage for "Applied" stage
    	
    	@id:5 @AttachFromSSTab111 @partnerAssessment
   Scenario: Verify that user is able to attach and remove test using selection stages
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
		Then User create a new requirement and move to overview page
      And User move to selection stage tab in that requirement.
      And User attach a "Naukri Assessments" test at "On Hold" stage using selection stages
      Then User click on remove test attached at "On Hold" stage	
      Then User click on Yes on the confirmation box
      And User verify that the test is removed from "On Hold" stage
   
  @id:6 @AttachPart1 @partnerAssessment
  Scenario: Verify that Subuser is able to Attach Assessment from all three locations
    Given User login to the application "addSingleProfile" using "Subuser2" of "Enterprise" user 
    And I fill in all the details of the candidate
    And I click on Save button
    When I click on Requirement Name on candidate page
    Then User verify that	Attach Assessment button should be available and accessible.
    And User move to selection stage tab in that requirement.
    And User expand a particular or first Stage
    | Interview |
    Then User verify that Attach Assessment link should be available and accessible from all substages
    | Interview |
    And I move to Requirement Inbox Page
    Then User verify that	Attach Assessment button should be available and accessible.

	 @id:7 @AttachPart5 @partnerAssessment
  Scenario: Verify that Candidate Assessments tab is removed from Requirement overview.
  		Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    	And User move to a particular requirement page
    	Then User verify Candidate Assessments tab is not visible

  @id:8  @wip @Manual 
  Scenario: Verify that user is allowed to Attach Assessmemt with 0 credits but unable to send them
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    And User verify that User have 0 credits for Naukri Assessmests
    Then User select a "All Requirements" from "Requirements" option
    And User move to a particular requirement page
    Then User verify that	Attach Assessment button should be available and accessible.
    And User attach the test at a particular stage
    Then User move a candidate to the stage where test is attached
    And User move to candidate profile.
    Then User verify that User am not able to send test to candidate.
    
    @id:9	@AttachPart21 @partnerAssessment
Scenario: Verify Headings, Subheadings, labels, Buttons and order of partners on Attach Assessment page.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
        Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    Then User select a "All Requirements" from "Requirements" option
    And User move to a particular requirement page
    And User click on Add Assessment button
	Then User verify the heading on Attach Assessment page
	Then User verify the subheading on Attach Assessment page
	Then User verify the labels on Attach Assessment page
	Then User verify the buttons on Attach Assessment page
	And User verify number of partners shown on Attach Assessment page
	Then user verify the radio buttons for the partners
	Then User verify order of partners on Attach Assessment page

  @id:10 @AttachPart55 @partnerAssessment
  Scenario Outline: Verify the flow and labels of attach for HackerEarth and restrictions on attaching same test or on same stage.
   Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User verify partner tests should be present with expected details for "HackerEarth"
    And User verify Create New Test button is present
    Then User hover on a particular test to verify edit and preview button are present and visible
    Then User select a particular or first test for partner
    	| _Test_donotedit_requiredfor_uts&its |
    And User click on Next button  
    Then User verify below headings on the page for "HackerEarth"
    	| Select Stage |
    Then User verify below headings not on the page for "HackerEarth"
    	| Monitor Candidate using Webcam |
    	| Restrict Candidate from Switching Tabs |
    	| Test Link Validity |
    Then User verify no stage selected by default
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User verify below headings on the page for "HackerEarth"
    	| Trigger test automatically when candidate is moved to the selected stage | 
    Then User click on Attach test button
    And User verify the success message for test "_Test_donotedit_requiredfor_uts&its" 
    And User hover on View Assessment to open Dropdown
    And User click on Attach new assessment in dropdown
    Then User click on "HackerEarth" radio button
    Then User verifies attached test is not allowed to be selected again
    	| _Test_donotedit_requiredfor_uts&its |
    And User verifies the hover message for the "_Test_donotedit_requiredfor_uts&its" test which is already attached
    Then User select a particular or first test for partner
    	| Android Test edited |
        And User click on Next button	
    Then User click on select stage Dropdown
    Then User verifies "Duplicate" stage with a test attached cannot be selected
    And User verifies the hover message for the "Duplicate" stage on which test is already attached
    
        Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant2 |
    
      @id:11 @AttachPart @Codility @partnerAssessment
  Scenario Outline: Verify the flow and labels of attach for HackerEarth and restrictions on attaching same test or on same stage.
   Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User configure "Codility" if not configured
			| MEtbanE46K7JYFx40GiD |
    And User validate "Codility" is shown configured
    When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And User click on Add Assessment button 
    Then User click on "Codility" radio button
    Then User verify partner tests should be present with expected details for "Codility"
    And User verify Create New Test button is present
    Then User hover on a particular test to verify edit and preview button are present and visible
    Then User select a particular or first test for partner
    	| Do Not Edit test |
    And User click on Next button  
    Then User verify below headings on the page for "Codility"
    	| Select Stage |
    Then User verify below headings not on the page for "Codility"
    	| Monitor Candidate using Webcam |
    	| Restrict Candidate from Switching Tabs |
    	| Test Link Validity |
    Then User verify no stage selected by default
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User verify below headings on the page for "Codility"
    	| Trigger test automatically when candidate is moved to the selected stage | 
    Then User click on Attach test button
    And User verify the success message for test "Test2" 
    And User hover on View Assessment to open Dropdown
    And User click on Attach new assessment in dropdown
    Then User click on "Codility" radio button
    Then User verifies attached test is not allowed to be selected again
    	| Do Not Edit test |
    And User verifies the hover message for the "Do Not Edit test" test which is already attached
    Then User select a particular or first test for partner
    	| Intern test |
        And User click on Next button	
    Then User click on select stage Dropdown
    Then User verifies "Duplicate" stage with a test attached cannot be selected
    And User verifies the hover message for the "Duplicate" stage on which test is already attached
    
        Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant2 |
    
    @id:12 @AttachPart56 @partnerAssessment
  Scenario Outline: Verify the flow and labels of attach for Naukri Assessments and restrictions on attaching same test or on same stage.
    Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "settingsPage" using "Superuser" of "<userType>" user
    Then User click on Assessment Partner Integration Assessment
    And User validate "Naukri Assessments" is shown configured
   When User select a "All Requirements" from "Requirements" option
    And User move to newly created or first requirement
    And User click on Add Assessment button 
    Then User click on "Naukri Assessments" radio button
    And User verify Create New Test button is not present for Naukri Assessments
    Then User expand a particular or first test in Naukri Assessments
    Then User verify partner tests should be present with expected details in expanded category
    Then User select a particular or first test in expanded category in Naukri Assessments
    	| Applied Geology Skills Test |
    And User click on Next button
    Then User verify below headings on the page for "Naukri Assessments"
    	| Select Stage |
    	| Test Link Validity |
    	| Monitor Candidate using Webcam |
    	| Restrict Candidate from Switching Tabs |
    Then User click on select stage Dropdown
    And User select "Applied-Matching" stage from the Dropdown
    Then User verify below headings on the page for "Naukri Assessments"
    	| Trigger test automatically when candidate is moved to the selected stage |
    Then User click on Attach test button
    And User verify the success message for test "Applied Geology Skills Test" 
    And User hover on View Assessment to open Dropdown
    And User click on Attach new assessment in dropdown
    Then User click on "Naukri Assessments" radio button
    Then User expand a particular or first test in Naukri Assessments
    Then User verifies attached test is not allowed to be selected again
    	| Applied Geology Skills Test |
    And User verifies the hover message for the "Applied Geology Skills Test" test which is already attached
    Then User select a particular or first test in expanded category in Naukri Assessments
    	| Applied Geophysics Skills Test |
    And User click on Next button	
    Then User click on select stage Dropdown
    Then User verifies "Applied-Matching" stage with a test attached cannot be selected
    And User verifies the hover message for the "Applied-Matching" stage on which test is already attached
    
        Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant2 |

 	  @id:13 @AttachPart2 @docker
  Scenario: Verify that Create Test appears as a button at bottom of screen if no tests added or created for HackerEarth.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value       |
      | clientId  |      168613 |
      | partnerId | hackerearth |
    And User click on each Configure HackerEarth
    And User fill and submit configure light box for HackerEarth with correct credentials
      | client_id                                                        | client_secret                            |
      | 9db60fda6a4d322655feffd2a566aa47c5da786522af.api.hackerearth.com | 2b4bc2dbeb07d66faf5bb67568a0ee674dfe23ae |
    And User validate "HackerEarth" is shown configured
		Then User select a "All Requirements" from "Requirements" option
    	And User move to a particular requirement page
      And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User verify buttons and labels in no tests case for "HackerEarth"
    
    @id:11 @AttachPart2 @docker @Codility @wip
  Scenario: Verify that Create Test appears as a button at bottom of screen if no tests added or created for HackerEarth.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value  |
      | clientId  | 168613 |
      | partnerId |   3    |
    And User click on each Configure HackerEarth
    And User fill and submit configure light box for HackerEarth with correct credentials
			| MEtbanE46K7JYFx40GiD |
    And User validate "Codility" is shown configured
		Then User select a "All Requirements" from "Requirements" option
    	And User move to a particular requirement page
      And User click on Add Assessment button 
    Then User click on "Codility" radio button
    Then User verify buttons and labels in no tests case for "Codility"
    
   @id:14  @wip
  Scenario: Verify the scrolling functionality on test selection stage
  	Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
    And click on selection stage
    And  click on "Applied" stage on selection stages tab
    When User click on substage "Matching" of "Applied" stage on selection stage tab
    And click on test icon
    And get the total no of tests
    Then Verify that total number of tests is visible
    And click on category name
    And verify that category name, time taken, questions heading should be visible
    And verify first 5 tests are visible
    And verify the view n more tests in this category and view all the tests
    And verify the total no of tests matches the count of tests

 @id:15 @wip
  Scenario: To verify the search functionality and cancel functionality on test
    listing page
		Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    Then User click on Assessment Partner Integration Assessment
    And User validate "Naukri Assessments" is shown configured
    And User configure "HackerEarth" if not configured
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    Then User select a "All Requirements" from "Requirements" option
    And User move to a particular requirement page
     And User click on Add Assessment button 
    Then User click on "Naukri Assessments" radio button
    And Enter "applied geology" in searchbar
    Then verify test results of "Applied Geology" is correct
    Then User click on "HackerEarth" radio button
    And Enter "Java" in searchbar
    Then verify test results of "Java" is correct
    When click on "CANCEL" button in bottom
    Then it should take me to the previous page without mapping the selected test to the stage

 @id:16  @wip
  Scenario: To verify that activation period cannot be greater than 365 days and
    the no of candidates allowed cannot be greater than the quota left

   Given User click on substage "Matching" of "Applied" stage on selection stage tab
    When click on test icon
    And select first test
    And clear the activation period value
    And enter "366" days
    Then error should be displayed that maximum activation period can be 1-365 days and 0-23 hours
    When clear the activation period value
    And enter "1" day and "25" hours
    Then error should be displayed that maximum activation period can be 1-365 days and 0-23 hours


  @id:17 @wip
  Scenario: delete the value in activation period , by default the value will be
    set as 10 days
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
    And click on selection stage
    And  click on "Applied" stage on selection stages tab
   Given User click on substage "Matching" of "Applied" stage on selection stage tab
    When click on test icon
    And select first test
    And delete the value in activation period
    And click on attach test
    And click on "Applied" stage on selection stages tab
    And click on edit icon
    Then the value in activation period should be displayed as 10



  @id:18 @Part2 @wip @Priority2
  Scenario: Verify that UI is adjusted if only one partner added
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And I Move to a particular requirement.
    And I click on Add Assessment button to land on tests or partner dashboard
    Then I verify that only one partner is added
    And I verify that there is no radio button and UI is as expected.
    
    
    @id:19 @MarketingTour @Docker @HEunconfigured
Scenario: Verify that Superuser is shown two buttons on Marketing tour page

  Given User login to the application "settingsPage" using "Superuser" of "Enterprise5" user
  Then User click on Assessment Partner Integration Assessment
	Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
	Then User verify heading on Marketing tour page
		| Introducing\nAssessment Integration with HackerEarth |
	Then User verify sub headings on Marketing tour page
	| Access HackerEarth Tests from RMS |
	| Map test to a selection stage |
	| Trigger the test to candidates |
	| Get instant results in RMS |
	| Try Assessment Integration with HackerEarth Now |
	Then User verify "REQUEST A DEMO" button is displayed
	And User verify "CONFIGURE HACKEREARTH" button is displayed
	Then User verify "RequestADemoLower" button is displayed
	And User verify "ConfigureHackerEarthLower" button is displayed
	Then User click on "REQUEST A DEMO" button on marketing page
	#Then user submit the Request Demo Form
	
	@id:20 @MarketingTour @Docker
	Scenario: Verify that Subuser is shown one button on Marketing tour page and able to send interest
	
  Given User login to the application "requirementInbox" using "Subuser" of "Enterprise5" user
    And User move to a particular requirement page
    And User click on Add Assessment button
		Then User move to Marketing tour page for HackerEarth from Attach Assessment
		Then User verify heading on Marketing tour page
		| Introducing\nAssessment Integration with HackerEarth |
	Then User verify sub headings on Marketing tour page
	| Access HackerEarth Tests from RMS |
	| Map test to a selection stage |
	| Trigger the test to candidates |
	| Get instant results in RMS |	
	| Are you interested in HackerEarth Assessments? |
	Then User verify "Send Interest" button is displayed
	Then User verify "SendInterestLower" button is displayed
#	Then User click on "Send Interest" button on marketing page
#	And User verify the success message is displayed for send interest
#		| Interest sent. We'll soon get in touch with you. |
	
	    @id:21 @MarketingTour @Docker 
Scenario: Verify that Superuser is shown two buttons on Marketing tour page and able to configure HE from tour
 
 Given User login to the application "requirementInbox" using "Superuser" of "Enterprise3" user
    And User move to a particular requirement page
    And User click on Add Assessment button
		Then User move to Marketing tour page for HackerEarth from Attach Assessment
	Then User click on "CONFIGURE HACKEREARTH" button on marketing page
	And User fill and submit configure light box for HackerEarth with correct credentials
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    	
    @id:22 @partnerAssessment @Sanity
  Scenario Outline: To Verify the order of Global stages and Selection stage DD for "<userType>"
    Given User login to the application "settingsPage" using "Superuser" of "<userType>" user
     Then User click on Assessment Partner Integration Assessment
    And User configure "HackerEarth" if not configured
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    And User checks all the stages on customize the selection process page
     When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    When I click on Requirement Name on candidate page
        And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
    	| Java Test 33 |
    And User click on Next button
    Then User click on select stage Dropdown
    Then Verify that user is able to see all the stages in Select Stage DD

    Examples: 
      | userType      |
      | Enterprise    |
      
      @id:23 @partnerAssessment @Sanity
  Scenario Outline: To verify that "<userType>" user is able to see the stage added from global cofiguration settings after adding Asssement
    Given User login to the application "SelectionProcessSettings" using "Superuser" of "<userType>" user
    And User added a new stage on customized selection stage page
    Then Verify that user is able to "Add" the stages on customized selection page
  	Then User select a "All Requirements" from "Requirements" option
    And User move to a particular requirement page
    And User click on Add Assessment button 
    Then User click on "Naukri Assessments" radio button
    Then User expand a particular or first test in Naukri Assessments
    Then User select a particular or first test in expanded category in Naukri Assessments
    	| Applied Geology Skills Test |
    And User click on Next button
    Then User click on select stage Dropdown
    Then Verify that stage is "Added" from customize selected process page reflected to Select Stage DD
    When User is on "SelectionProcessSettings" page
    And User deleted the newly added stage from customized section stage page
    Then Verify that user is able to "Delete" the stages on customized selection page
    		Then User select a "All Requirements" from "Requirements" option
    	And User move to a particular requirement page
    	And User click on Add Assessment button
    	Then User click on "Naukri Assessments" radio button 
    	Then User expand a particular or first test in Naukri Assessments
    Then User select a particular or first test in expanded category in Naukri Assessments
    	| Applied Geology Skills Test |
    And User click on Next button
    Then User click on select stage Dropdown
    Then Verify that stage is "deleted" from customize selected process page reflected to Select Stage DD

    Examples: 
      | userType      |
      | Enterprise    |
      
      
      
  		