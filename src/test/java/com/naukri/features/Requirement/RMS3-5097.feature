Feature: To Verify adding photo in branding options

  @id:1 @RMS @JPFormInRms
  Scenario: Verify user is able to add 5 photos in branding options and rest checkboxes are disabled.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on "Add New Photo" link
    And User upload more than 5 photos from system on recruiter page
    And User select all the photoes from recruiter page
    And User Select "5" photos from drop down list
    Then User should be able to see rest of the list's checkboxes disabled

  @id:2 @RMS @JPFormInRms
  Scenario: Verify disabled checkboxes are enabled when user select less than 5.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User Select "5" photos from drop down list
    Then User should be able to see rest of the list's checkboxes disabled
    When User deselect one selected checkboxes
    Then User should be able to see rest checkbox are enabled

  @id:3 @RMS @JPFormInRms
  Scenario: Verify error message on disabled checkboxes.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User Select "5" photos from drop down list
    And User hover on disabled checkbox
    Then User should be able to see disabled photos tooltip "Maximum 5 photos can be attached."

  @id:4 @RMS @JPFormInRms @fail
  Scenario: Verify checkbox are not disabled when user select less than 5
   Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User Select "2" photos from drop down list
    Then User should be able to see rest checkbox are enabled


 @id:5 @RMS @JPFormInRms @fail
  Scenario: Verify user is able to view aded photos on requirement preview
   Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User Select "5" photos from drop down list
    And User click on Preview button on requirement page
    Then User should be able to see selected photos on requirement preview
    And User should be able to view added photos
    
  @id:6 @RMS @JPFormInRms @fail
  Scenario: Verify select photos are displaying on requirement preview
   Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job location as "Delhi"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User select the questionnaire from list
    And User Select "5" photos from drop down list
    And User click on Preview button on requirement page
    Then User should be able to see selected photos on requirement preview
    When User click on "Back to Edit" link
    And User fill in the job location as "Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User deselect one selected checkboxes
    And User click on Preview button on requirement page
    Then User should be able to see selected photos on requirement preview

    @id:7 @RMS @JPFormInRms
  Scenario: Verify select photos are displaying on requirement details page
   Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And refresh the page
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User select the questionnaire from list
    And User Select "5" photos from drop down list
    And User click on Save and Post Requirement on requirement page
  	And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see selected photos on requirement preview
    
   @id:8 @RMS @JPFormInRms
  Scenario: Verify user is able to see all attached thumbnail on JP form
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User post a "Naukri Private Job"
    And User choose first address
    And User select the questionnaire from list
    And User Select "5" photos from drop down list
    And User click on Save and Post Requirement on requirement page
    When User click on GNB option "Naukri"
    And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
    And User edit the recent created job on MJR
    And User click on company details edit button
    Then User should be able to see photo thumbnail on the job
    
    
    @id:9 @RMS @JPFormInRms @fail
  Scenario: Verify user is able to see all photo attached thumbnail on JD page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User post a "Naukri Private Job"
    And User choose first address
    And User select the questionnaire from list
    And User Select "3" photos from drop down list
    And User click on Save and Post Requirement on requirement page
    And User click on "View" action of "Naukri Private Job"
  	And User switches to new window
  	Then User should be able to see the photo thumbnail on JD page
