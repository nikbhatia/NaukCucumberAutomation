Feature: Test Scenarios of View Partner Assessment results

  @id:1 @ViewPartnerResults @wip
 Scenario: Verify following things in Assessment Results window are displayed
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment toopen dropdown.
	And User select a test from the dropdown
  Then User verify candidates & their relevant details  who have been sent the test successfully are present
	And User verify that sort candidates in different order can be performed
	And User apply various filters and verify filter results
	And User verify that actions on multi selections can be done
	And User verify other actions on this page
	And User verify different type of Test stage
	And User perform download content i excel and verify what comes in downloaded Excel
	And User view and verifies report interaction
	
	 @id:2 @ViewPartnerResults @partnerAssessment
Scenario Outline: Verify the UI for the view Assessment window for a test with no invites for HackerEarth.
	  Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
	 Given User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
	  And User click on Add Assessment button
    When User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
      | _Test_donotedit_requiredfor_uts&its |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Applied-Not Matching" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "_Test_donotedit_requiredfor_uts&its"
    And User verify the attach button is now "View Assessment (1)"
     And User hover on View Assessment to open Dropdown
      Then User verify that "_Test_donotedit_requiredfor_uts&its" attached at "Applied - Not Matching" stage is shown in "ViewAssessment" Dropdown
    When User click on "_Test_donotedit_requiredfor_uts&its" attached at "Applied - Not Matching" stage in "ViewAssessment" Dropdown
	 Then User verify heading and sub heading on View Assessments page
	 	| View Assessment |
	 And User verify various test details on View Assesments page
	 | PartnerName | Stage                | TestName                            |
	 | HackerEarth | Applied-Not Matching | _Test_donotedit_requiredfor_uts&its |
	 And User verify Edit Test Settings and back button are present
	 And User verify Export to excel is not present
	 And User verify text and sub text on the screen with no candidates
	 And User hover on View more options Drop down
	 And User verify more options for the partner "HackerEarth"
	 | Preview on |
	 | Manage on |
	 | Remove from attached Stage |
	 
	  Examples:  
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant2 |
      
      @id:3 @ViewPartnerResults @Codility @wip
Scenario Outline: Verify the UI for the view Assessment window for a test with no invites for Codility.
	  Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
	 Given User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
	  And User click on Add Assessment button
    When User click on "Codility" radio button
    Then User select a particular or first test for partner
      | Intern test |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Applied-Not Matching" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Intern test"
    And User verify the attach button is now "View Assessment (1)"
     And User hover on View Assessment to open Dropdown
      Then User verify that "Intern test" attached at "Applied - Not Matching" stage is shown in "ViewAssessment" Dropdown
    When User click on "Intern test" attached at "Applied - Not Matching" stage in "ViewAssessment" Dropdown
	 Then User verify heading and sub heading on View Assessments page
	 	| View Assessment |
	 And User verify various test details on View Assesments page
	 | PartnerName | Stage                | TestName |
	 | Codility    | Applied-Not Matching | Intern test |
	 And User verify Edit Test Settings and back button are present
	 And User verify Export to excel is not present
	 And User verify text and sub text on the screen with no candidates
	 And User hover on View more options Drop down
	 And User verify more options for the partner "Codility"
	 | Preview on |
	 | Manage on |
	 | Remove from attached Stage |
	 
	  Examples:  
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant2 |
      
       @id:4 @ViewPartnerResults @partnerAssessment
Scenario Outline: Verify the UI for the view Assessment window for a test with no invites for Naukri Assessments.
	  Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
	 Given User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
	  And User click on Add Assessment button
    And User click on "Naukri Assessments" radio button
    And User expand a particular or first test in Naukri Assessments
    And User select a particular or first test in expanded category in Naukri Assessments
      | Applied Geology Skills Test |
    And User click on Next button
    And User click on select stage Dropdown
    And User select "Applied-Not Matching" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Applied Geology Skills Test"
    And User verify the attach button is now "View Assessment (1)"
     And User hover on View Assessment to open Dropdown
      Then User verify that "Applied Geology Skills Test" attached at "Applied - Not Matching" stage is shown in "ViewAssessment" Dropdown
    When User click on "Applied Geology Skills Test" attached at "Applied - Not Matching" stage in "ViewAssessment" Dropdown
	  Then User verify heading and sub heading on View Assessments page
	 	 | View Assessment |
	 And User verify various test details on View Assesments page
	 | PartnerName        | Stage                | TestName                            |
	 | Naukri Assessments | Applied-Not Matching | Applied Geology Skills Test |
	 And User verify Edit Test Settings and back button are present
	 And User verify Export to excel is not present
	 And User verify text and sub text on the screen with no candidates
	 And User hover on View more options Drop down
	 And User verify more options for the partner "Naukri Assessments"
	 | Remove from attached Stage |
	 
	  Examples:  
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant2 |
	 
	 @id:5 @ViewPartnerResults @wip
Scenario: verify that updated count of Invites Sent, Passed/ Failed OR Test Completed is shown
     Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
     When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
     And User move to newly created or first requirement
	   And User move to selection stage tab in that requirement.
     And User click on Attach icon for substage "Not Matching" of stage "Applied"
    	Then User click on "HackerEarth" radio button
      And User select a particular or first test for partner
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied - Not Matching"
     And User click on Attach test button
	 And user refresh the page
	 And User click on Send Assessment from SRP and send this tests to some candidates
	 And User click on View Assessment to open dropdown
	 And User click on the test attached in previous steps
	 Then User verify View Assessment window is opened 
	 And User verify that updated count of Invites Sent, Passed/ Failed OR Test Completed is shown
	 
	  @id:6 @ViewPartnerResults @wip
Scenario: verify that 4 dividers which will come only when we have benchmark for the test
 Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
     When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
     And User move to newly created or first requirement
	      And User move to selection stage tab in that requirement.
    	And User click on Attach icon for substage "Not Matching" of stage "Applied"
    	Then User click on "HackerEarth" radio button
      And User select a particular test for HackerEarth which has benchmark set
      	|  |
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied - Not Matching"
     And User click on Attach test button
	 And user refresh the page
	 And User click on Send Assessment from SRP and send this tests to some candidates
	 And User click on View Assessment to open dropdown
	 And User click on the test attached in previous steps
	 Then User verify View Assessment window is opened 
	 And User verify 4 dividers which will come only when we have benchmark for the test
	 
	 @id:7 @ViewPartnerResults @wip
Scenario: verify that 3 dividers which will come only when we do not have benchmark for the test
	 Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
     When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
     And User move to newly created or first requirement
	      And User move to selection stage tab in that requirement.
    	And User click on Attach icon for substage "Not Matching" of stage "Applied"
    	Then User click on "HackerEarth" radio button
      And User select a particular test for HackerEarth which does not have benchmark set
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied - Not Matching"
     And User click on Attach test button
	 And user refresh the page
	 And User click on Send Assessment from SRP and send this tests to some candidates
	 And User click on View Assessment to open dropdown
	 And User click on the test attached in previous steps
	 Then User verify View Assessment window is opened 
	 And User verify 3 dividers which will come  when we do not have benchmark for the test
	 
	 @id:8 @ViewPartnerResults @wip
Scenario: verify the Fields present in the Table view in View Assessments window
 Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
     When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
     And User move to newly created or first requirement
	      And User move to selection stage tab in that requirement.
    	And User click on Attach icon for substage "Not Matching" of stage "Applied"
    	Then User click on "HackerEarth" radio button
      And User select a particular test for HackerEarth 
      And User click on Next button
      Then User verify that Selection Stage is already selected as "Applied - Not Matching"
     And User click on Attach test button
	 And user refresh the page
	 And User click on Send Assessment from SRP and send this tests to some candidates
	 And User click on View Assessment to open dropdown
	 And User click on the test attached in previous steps
	 Then User verify View Assessment window is opened 
	 And User verify the Fields present in the Table view in View Assessments window
	 
	 @id:9 @ViewPartnerResults @wip
Scenario: Verify that all candidates in the assessment results view can be downloaded in excel.
	When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment toopen dropdown.
	And User select a test from the dropdown to move to results page
	And User click on download button to download the results in excel
	Then User verify all the candidates are present in Excel.
	And Verify all the expected fields are present in downloaded excel.
	And Verify the name of the excel should be <Assessment Test name>_ <Requirement name> in case of no stage
	And Verify the name of the excel should be <Assessment Test name>_ <Requirement name> _<stage name> Stage in case of stage
	And Verify the pre formatting in excel
	
	@id:10 @ViewPartnerResults @wip
Scenario: Verify that all candidates in the assessment results view can be downloaded in excel.
	When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment toopen dropdown.
	And User select a test from the dropdown to move to results page
	And User applies specfic filters to get specific results
	And User click on download button to download the results in excel
	Then User verify only the filteres candidates are present in Excel.
	And Verify all the expected fields are present in downloaded excel.
	And Verify the name of the excel should be <Assessment Test name>_ <Requirement name> in case of no stage
	And Verify the name of the excel should be <Assessment Test name>_ <Requirement name> _<stage name> Stage in case of stage
	And Verify the pre formatting in excel
	
	@id:11 @ViewPartnerResults @wip
Scenario: Verify that for recruiter both High to low  AND Low to High sorting should be available for given fields
Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment to open dropdown.
	And User select a test from the dropdown to move to results page
	Then User verify that option to sort for both High to low  AND Low to High is available for below fields
|	Test Score |
|	Section-wise scores |
|	Percentage |
|	Last Activity |
|	Percentage Marks |
| Duration |
| Years of experience |
| CTC |
|	Correct  Questions |


	
	@id:12 @ViewPartnerResults @wip
Scenario: Verify that default sorting order when both test taken and invited candidates are present in results page
	Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment toopen dropdown.
	And User select a test from the dropdown to move to results page
	Then User verify that candidates who has taken the test are sorted on basis on timestamp which recent on top
	And User verify candidates whom has not taken the test yet follows the candidates who has completed the test 
	And User verify that candidates who has not taken test are also sorted on basis of timestamp of invite send.
	
	@id:13 @ViewPartnerResults @wip
Scenario: Verify that default sorting order when only invited candidates are present in results page
	Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment toopen dropdown.
	And User select a test from the dropdown to move to results page
	And User verify that candidates  are also sorted on basis of timestamp of invite sent.
	
	@id:14 @ViewPartnerResults @wip
Scenario: Verify that for recruiter is able to apply filters for pecific fields
Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment to open dropdown.
	And User select a test from the dropdown to move to results page
	Then User verify that filters for following fields can be applied
	| Candidate stage,Test status, Percentage Score, Years of Experience, Current CTC, Current Location |
	
	@id:15 @ViewPartnerResults @wip
Scenario: Verify that for recruiter is able to perform following actions after applying filters
	Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment to open dropdown.
	And User select a test from the dropdown to move to results page
	Then User verify that filters for following fields can be applied
	| Candidate stage,Test status, Percentage Score, Years of Experience, Current CTC, Current Location |
	And User verify bulk actions can be performed on filtered results.
	And User verify 'download as excel'action can be performed on filtered results.
	And User verify sorting can be performed on filtered results.
	
	@id:16 @ViewPartnerResults @wip
Scenario: Verify the UI view after applying various filters
	Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	And  User Move to a particular requirement where tests has already been sent to candidates
	And User click on View Assessment to open dropdown.
	And User select a test from the dropdown to move to results page
	Then User verify that filters for following fields can be applied
	| Candidate stage,Test status, Percentage Score, Years of Experience, Current CTC, Current Location |
	And User verifies values along with facet counts are shown.
	And User verifies same as in sync with SRP for all facets
	And User verifies if 'All' is selected then individul facets are not shown but remains checked.
	
	@id:17 @ViewPartnerResults @wip
Scenario: Verify that recruiter is able to change the stage for a test using Edit test settings
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	  And User move to newly created or first requirement
	    And User click on Add Assessment button 
    Then User click on "HackerEarth" radio button
    Then User select a particular or first test for partner
    	| Java Test 33 |
    And User click on Next button
    Then User click on select stage Dropdown
    And User select "Duplicate" stage from the Dropdown
    Then User click on Attach test button
    And User verify the success message for test "Java Test 33" 
	And User refresh the page
	And User hover on View Assessment dropdown 
	And click on the attached test from the list.
	And user click on Edit test settings for the test
	Then User verify that Step 2 is opened with all correct details
	Then User click on select stage Dropdown
	And User select "Prospect" stage from the Dropdown
	And User save the settings
	Then User verify that the success message for edit settings is displayed
	And User verify that the stage is updated in View Assessments
	
		@id:18 @ViewPartnerResults @wip
Scenario: Verify that recruiter is able to attach a test to a stage not attached to any stage previously using Edit test settings
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
	