Feature: To Verify Educational qualification field

  @id:1 @RMS @JPFormInRms @fail
  Scenario: Verify user is able see post-graduation and Doctorate radio buttons disable when ‘Graduation Not Required’ option is selected
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User select "Graduation Not Required" option
    Then User should be able to see "Post Graduation" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
    Then User should be able to see "Doctorate" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying

  #@id:2  icon removed
  #Scenario: Verify user is able see info icon button when ‘Graduation Not Required’ option is selected
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When I select a "Add A New Requirement" from "Requirements" option
    #And User fill in the requirement title
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And I select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the keywords as "java"
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And I click on "Add Requirement" button on requirement creation
    #And User select "Graduation Not Required" option
    #Then User should be able to see info icon button
    #When User hover on info icon button
    #Then User should be able to see message "Post Graduation/Doctorate can only be selected if some Graduation option is selected."
#
  #@id:3 Gap in JP and RMS 
  #Scenario: Verify user is able ‘Graduation Not Required’ chip on JP form
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When User Add a requirement
    #And Select 'Naukri' option on second page
    #And User select ‘Graduation Not Required’ option
    #And User post a job with recruiter contact details
    #And User go to MNR page
    #And User edit the recent created job
    #Then User should be able to see only ‘Graduation Not Required’ chip on JP form
#
  @id:4 @RMS @JPFormInRms
  Scenario: Verify user is able to see other option enable if other Graduation options are selected
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    Then User should not be able to see "Post Graduation" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
    Then User should not be able to see "Doctorate" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying


  @id:5 @RMS @JPFormInRms @fail
  Scenario: Verify user is able to see dropdown after Doctorate field
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "CS" and "CS" subject
    When User select "I Will Choose Doctorate" option
    When User click on "Change" link
    Then User should be able to see "First" dropdown value "Candidates must have all the above specializations in Graduation, Post Graduation and Doctorate"
    And User should be able to see "Second" dropdown value "Candidates can have any of the above specializations in Graduation, Post Graduation or Doctorate"

  @id:6 @RMS @JPFormInRms
  Scenario: Verify user is able to see by default first option is selected in dropdown after Doctorate field
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
  When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "CS" and "CS" subject
    When User select "I Will Choose Doctorate" option
    Then  User is able to see value "Candidates must have all the above specializations in Graduation, Post Graduation and Doctorate"
    When User click on "Change" link
    ###Then User should be able to see by default first option is selected 

  #@id:7 TBR on staging @RMS @RMSRequirements @RequirementCreation @JPFormInRms
  #Scenario: Verify user is able to see by same option is selected in dropdown after Doctorate field on JP form
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    #When User select a "Add A New Requirement" from "Requirements" option
    #And User fill in the requirement title
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the keywords as "java"
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #When User select "I Will Choose Graduation" option
    #And User select "Graduation" degree "B.A" and "English" subject
   #And User select "I Will Choose Post Graduation" option
    #And User select "Post" degree "CS" and "CS" subject
    #When User click on "Change" link
    #And User select "2" option from education specialization
    #And User post a "Naukri Private Job"
  #And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  #And User chose "Functional Area" as "Banking / Insurance"
  #And User chose "Role" as "Cash Officer"
  #And User choose first address
  #And User select the questionnaire from list
  #And User click on Save and Post Requirement on requirement page
    #When User click on GNB option "Naukri"
  #And User select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  #And User edit the recent created job on MJR
    #Then User should be able to see education specialization text as "Candidates must have all the above specializations in undergraduate and postgraduate" on JP form
#
  @id:8 @RMS @JPFormInRms @fail
  Scenario: Verify user is not able to see dropdown after Doctorate field if only one specialization is selected
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    Then User should be able to see any dropdown after Doctorate field
    
  @id:9 @RMS @JPFormInRms @fail
  Scenario: Verify user is able to see customize text when user selected different specialization
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And refresh the page
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    Then User should be able to see any dropdown after Doctorate field
		And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "CS" and "CS" subject
    Then  User is able to see value "Candidates must have all the above specializations in Graduation, Post Graduation and Doctorate"
    When User click on "Change" link
    Then User should be able to see "First" dropdown value "Candidates must have all the above specializations in Graduation, Post Graduation and Doctorate"
    And User should be able to see "Second" dropdown value "Candidates can have any of the above specializations in Graduation, Post Graduation or Doctorate"



@id:10 @RMS @JPFormInRms @fail
  Scenario: Verify user is able to see "Select Graduation Not Required" confirmation pop-up
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
   When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    Then User should be able to see any dropdown after Doctorate field
		And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "CS" and "CS" subject
    When User select "Graduation Not Required" option
    Then User verify continue pop-up and its text "Selecting ‘Graduation Not Required’ option will delete the selected values of Post Graduation/Doctorate. Are you sure you want to continue?"
     When User click on cancel button
    Then User should not be able to see "Post Graduation" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
    Then User should not be able to see "Doctorate" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
     When User select "Graduation Not Required" option
     When User click on close button
     When User should not be able to see "Post Graduation" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
    Then User should not be able to see "Doctorate" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
    When User select "Graduation Not Required" option
    When User click on continue button
    Then User should be able to see "Post Graduation" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
    Then User should be able to see "Doctorate" radio buttons disabled and tooltip is "Post Graduation/Doctorate can only be selected if some Graduation option is selected." displaying
 
