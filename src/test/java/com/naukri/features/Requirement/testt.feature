#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature

  #@id:12
  #Scenario: To verify Job Description is dividing into 3 fields as per text when Posting HV/Private job from JP when edit
  #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  #When User click on GNB option "Naukri"
  #And I select a "Post a Private Job" from "Jobs & Responses" option on Naukri GNB
  #And User fill Key skills as "Java"
  #And User select key skills "Java" as must have key skill
  #And User fill work experience "Minimum Experience" as "3"
  #And User fill work experience "Maximum Experience" as "6"
  #And User fill Annual Salary  "Minimum Salary" as "7,00,000"
  #And User fill Annual Salary  "Maximum Salary" as "10,00,000"
  #And User fill variable as "20" percent
  #And User fill "Location" as "Kolkata"
  #And User fill "Industry" as "Architecture / Interior Design"
  #And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
  #And User fill "Role" as "Collections Officer"
  #And User fill "Education" Qualification in "Graduate" as "B.A"
  #And User fill "Education" Qualification in "Postgraduate" as "CA"
  #And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
  #And User fill requirement name
  #And User fill Employment Type as "Full Time, Temporary/Contractual"
  #And User fill Job Description "Roles and Responsibilities" as "Roles Description testing"
  #And User fill Job Description "Desired Candidate Profile" as "Desired Candidate Profile Description testing"
  #And User fill Job Description "Perks and Benefits" as "Perks and Benefits Description testing"
  #When User fill Job Posting heading as "Software developer Engineer_"
  #And User click on "Preview and Post" button and post the job
  #And User is on "requirementInbox" page
  #And User click recent created requirement name from JP
  #When User click on "Edit" action of "Naukri Private Job"
  #And User click on Next button on requirement page
  #And User choose first address
  #And User select the questionnaire from list
  #And User click on Preview button on requirement page
  #Then User should be able to see "Roles and Responsibilities" in Job description section
  #Then User should be able to see "Desired Candidate Profile" in Job description section
  #Then User should be able to see "Perks and Benefits" in Job description section
  #When User click on GNB option "Naukri"
  #And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  #And User edit the recent created job from jp on MJR
  #And User clear Job Description "Desired Candidate Profile" field
  #And User fill Key skills as "PHP"
  #And User click on "Preview and Post" button and post the job
  #And User is on "requirementInbox" page
  #And User click recent created requirement name from JP
  #When User click on "Edit" action of "Naukri Private Job"
  #And User click on Next button on requirement page
  #And User choose first address
  #And User select the questionnaire from list
  #And User click on Preview button on requirement page
  #Then User should be able to see "Roles and Responsibilities" in Job description section
  #Then User should not be able to see "Desired Candidate Profile" in Job description section
  #Then User should be able to see "Perks and Benefits" in Job description section
  ## #When User click on "Back to Edit" link
  #####And User remove text from Other details for "JP migrated"
  #
  #### #Then User should be able to see "Roles and Responsibilities" in Job description section
  #####Then User should not be able to see "Desired Candidate Profile" in Job description section
  ######Then User should be able to see Job Description and Other salary detail
  #### #And User should be able to see "Candidate profile" field as blank
  #When User click on GNB option "Naukri"
  #And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  #And User edit the recent created job from jp on MJR
  #And User clear Job Description "Perks and Benefits" field
  #And User click on "Preview and Post" button and post the job
  #And User is on "requirementInbox" page
  #And User click recent created requirement name from JP
  #When User click on "Edit" action of "Naukri Private Job"
  #And User click on Next button on requirement page
  #And User choose first address
  #And User select the questionnaire from list
  #And User click on Preview button on requirement page
  #Then User should be able to see "Roles and Responsibilities" in Job description section
  #Then User should not be able to see "Desired Candidate Profile" in Job description section
  #Then User should not be able to see "Perks and Benefits" in Job description section
  @id:6 @RMS @JPFormInRms
  Scenario: Verify user is able see 'Company Name', 'About company' and 'Address' fields as mandatory while posting Naukri job
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
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User clear Company Name and About company
    And User click on Save and Post Requirement on requirement page
    Then User should be able to see "Company Name" field as mandatory and error message "Select the required Company Name." is displaying
    And User should be able to see "About Company" field as mandatory and error message "This field cannot be left blank" is displaying
    And User should be able to see "Address" field as mandatory and error message "Company address is required" is displaying
