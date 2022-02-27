Feature: To verify changes on requirement overview page because of MLH

  @id:1 @MLHRequirementOverview @MLH @TestRun
  Scenario: To verify that RM with view only visibility can add comment on requirement overview page and added comment by RM is visible to reportee
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I logout
    When I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    And User clicks on created requirement name
    When User click on the tab "Comments" on requirement overview page
    And User enter comment on inbox
    And User clicks on Add Comment buttons
    Then User shoule be able to see entered comment
    And User should be able to see delete icon and comment date
    And I logout
    When I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    And User clicks on created requirement name
    When User click on the tab "Comments" on requirement overview page
    Then User shoule be able to see entered comment
    
    @id:2 @MLHRequirementOverview @MLH
    Scenario: To verify that RM with view only visbility does not see action buttons on requirement overview
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I logout
    When I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    And User clicks on created requirement name
    Then Verify that "Post" button is not displayed on requirement overview page
    And Verify that "Edit" button is not displayed on requirement overview page
    And Verify that "Set Visibility" button is not displayed on requirement overview page
    And Verify that "Assign Vendor" button is not displayed on requirement overview page
    And Verify that "Search" button is not displayed on requirement overview page
    And Verify that "Attach Assessment" button is not displayed on requirement overview page
    And Verify that "More " button is not displayed on requirement overview page
    When User click on the tab "Overview" on requirement overview page
    Then user should be able to see the label "Sourcing hasn't begun for this requirement as yet"
    When User click on the tab "Response Filters" on requirement overview page
    Then Verify that Apply Response Filters button is not displayed under Response Filters tab
    
    @id:3 @MLHRequirementOverview @MLH @ToRun
    Scenario: To verify that RM with view only visbility does not see add assessment, add feedback and add interviewer buttons on selection stage
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I logout
    When I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    And User clicks on created requirement name
    When User click on the tab "Selection Stages" on requirement overview page
    Then Verify that "Add Selection Stage" button is not displayed on requirement overview page
    Then Verify that "Add Sub Stage" button is not displayed on requirement overview page
    And Verify that "Add Interviewer(s)" title is not displayed
    And Verify that "Add Assessment Test to this selection stage" title is not displayed
    And Verify that "Attach Feedback Form" title is not displayed
    #When User click and hold "Prospect" stage and drags it to "Shortlisted" stage
    #Then Verify user is unable to drag 
    
    @id:4 @MLHRequirementOverview @MLH
    Scenario: To verify that RM with view only visbility cannot change status of requirement
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I logout
    When I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    When User clicks on created requirement name
    Then Verify that user cannot change status of requirement from overview page
    
    @id:5 @MLHRequirementOverview @MLH
    Scenario: To verify that RM with view only visbility cannot send meesages to vendor
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User clicks on "Assign Vendor" Link on Requirement Overview Page
    And User click on "Select Vendors" button on the page
    And User adds below vendors on Assign Requirement to Vendor Page
      |mVendorRestored |
    And User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And User clicks on "ASSIGN" button in conformation box
    And refresh the page
    And  User Clicks on "Message" for "mVendorRestored" on Requirement Overview page
    And  User clicks on "Send" button in conformation box
    Then Verify that message added to Overview Page
    And I logout
    When I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    When User clicks on created requirement name
    Then Verify that "Edit Assignment Details" button is not displayed on requirement overview page
    And Verify that "Unassign" button is not displayed on requirement overview page
    And Verify that " Send Reminder" button is not displayed on requirement overview page
    When User click on "Messages(1)"
    Then Verify message textarea is not displayed for vendor message on requirement overview
    And Verify that "Send" button is not displayed on requirement overview page
    
    @id:6 @MLHRequirementOverview @MLH
    Scenario: To verify that profile upload options are not present for RM with view only visibilty of requirement
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I added a single profile in requirement
    And I logout
    When I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    Then Verify User see the requirement created above
    When User clicks on created requirement name
    And Verify that "Upload Single CV" button is not displayed on requirement overview page
    And Verify that "Upload Excel" button is not displayed on requirement overview page
    And Verify that "Upload Multiple CV's" button is not displayed on requirement overview page
    And Verify that "Upload CV's in Bulk" button is not displayed on requirement overview page
    And user should be able to see the label "Uploaded CV's in Requirement"
    And user should be able to see the label "Uploaded CVs   "
    
    @id:7 @wip
    Scenario: To verify that RM can see added response filter on requirement overview
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User check the checkbox of Show Salary to jobseekers
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And click on groups section
    And select any other group on requirement creation page
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User click on the tab "Response Filters" on requirement overview page
    #And User click on "Apply Response Filters" under Response Filters
    
    
   
