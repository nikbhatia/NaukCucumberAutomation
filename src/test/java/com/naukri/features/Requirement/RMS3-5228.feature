Feature: Verify Combining 3 fields in preview for HV/private job

  @id:1  @RMS @JPFormInRms
  Scenario: Verify user is able see Combining 3 fields in preview for Private job
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
  And User click on Preview button on requirement page
  Then User should be able to see "Roles and Responsibilities" in Job description section
  Then User should be able to see "Desired Candidate Profile" in Job description section
  Then User should be able to see "Perks and Benefits" in Job description section
  And User should be able to see "Roles and Responsibilities" correct value on preview page
  And User should be able to see "Desired Candidate Profile" correct value on preview page
  And User should be able to see "Perks and Benefits" correct value on preview page
  
  
  @id:2 @RMS @JPFormInRms
  Scenario: Verify user is able see Combining 3 fields in preview for HV job
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
  And User click on Preview button on requirement page
  Then User should be able to see "Roles and Responsibilities" in Job description section
  Then User should be able to see "Desired Candidate Profile" in Job description section
  Then User should be able to see "Perks and Benefits" in Job description section
  And User should be able to see "Roles and Responsibilities" correct value on preview page
  And User should be able to see "Desired Candidate Profile" correct value on preview page
  And User should be able to see "Perks and Benefits" correct value on preview page
 
 
  @id:3 @RMS @JPFormInRms
  Scenario: Verify user is able see seperately 3 fields in preview for Classified job
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And refresh the page
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
  And User post a "Naukri Classified"
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User choose first address
  And User click on Preview button on requirement page
  Then User should not be able to see "Roles and Responsibilities" in Job description section
  Then User should not be able to see "Desired Candidate Profile" in Job description section
  Then User should not be able to see "Perks and Benefits" in Job description section
  And User should be able to see "Job Description" on preview page
  And User should be able to see "Candidate Profile" on preview page
  And User should be able to see "Other Salary" on preview page
  
  
  @id:4 @RMS @JPFormInRms
  Scenario: Verify user is able see Combining 3 fields as Job Description while sending data to JP
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
  And User select the questionnaire from list
  And User click on Save and Post Requirement on requirement page
  When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
  Then User should be able to see "Roles and Responsibilities" in Job description section on JP form
  Then User should be able to see "Desired Candidate Profile" in Job description section on JP form
  Then User should be able to see "Perks and Benefits" in Job description section on JP form
  
  
  @id:5 @RMS @JPFormInRms
  Scenario: To verify Job Description is dividing into 3 fields as per text when Posting Private job from JP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User click on GNB option "Naukri"
    And I select a "Post a Private Job" from "Jobs & Responses" option on Naukri GNB
    And User fill Key skills as "Java"
    And User select key skills "Java" as must have key skill
    And User fill work experience "Minimum Experience" as "3"
    And User fill work experience "Maximum Experience" as "6"
    And User fill Annual Salary  "Minimum Salary" as "7,00,000"
    And User fill Annual Salary  "Maximum Salary" as "10,00,000"
    And User fill variable as "20" percent
    And User fill "Location" as "Kolkata"
    And User fill "Industry" as "Architecture / Interior Design"
    And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
    And User fill "Role" as "Collections Officer"
    And User fill "Education" Qualification in "Graduate" as "B.A"
    And User fill "Education" Qualification in "Postgraduate" as "CA"
    And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
    And User fill requirement name
    And User fill Employment Type as "Full Time, Temporary/Contractual"
    And User fill Job Description "Roles and Responsibilities" as "Roles Description testing"
    And User fill Job Description "Desired Candidate Profile" as "Desired Candidate Profile Description testing"
    And User fill Job Description "Perks and Benefits" as "Perks and Benefits Description testing"
    When User fill Job Posting heading as "Software developer Engineer_"
    And User click on "Preview and Post" button and post the job
    And User is on "requirementInbox" page
    And User click recent created requirement name from JP
    When User click on "Edit" action of "Naukri Private Job"
    And User click on "Add Requirement" button on requirement creation
    And User choose first address
    And User select the questionnaire from list
    And User click on Preview button on requirement page
    Then User should be able to see "Roles and Responsibilities" in Job description section
    Then User should be able to see "Desired Candidate Profile" in Job description section
    Then User should be able to see "Perks and Benefits" in Job description section
    Then User should be able to see field "Roles and Responsibilities" filled value "Roles Description testing" on JP form on RMS preview page
    Then User should be able to see field "Desired Candidate Profile" filled value "Desired Candidate Profile Description testing" on JP form on RMS preview page
    Then User should be able to see field "Perks and Benefits" filled value "Perks and Benefits Description testing" on JP form on RMS preview page

  @id:6 @RMS @JPFormInRms
  Scenario: To verify Job Description is not dividing into 3 fields as per text when Posting classified job from JP
   Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User click on GNB option "Naukri"
    And I select a "Post a Classified" from "Jobs & Responses" option on Naukri GNB
    And User fill Key skills as "Java"
    And User select key skills "Java" as must have key skill
    And User fill work experience "Minimum Experience" as "3"
    And User fill work experience "Maximum Experience" as "6"
    And User fill Annual Salary  "Minimum Salary" as "7,00,000"
    And User fill Annual Salary  "Maximum Salary" as "10,00,000"
    And User fill variable as "20" percent
    And User fill "Location" as "Kolkata"
    And User fill "Industry" as "Architecture / Interior Design"
    And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
    And User fill "Role" as "Collections Officer"
    And User fill "Education" Qualification in "Graduate" as "B.A"
    And User fill "Education" Qualification in "Postgraduate" as "CA"
    And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
    And User fill requirement name
    And User fill Employment Type as "Full Time, Temporary/Contractual"
    When User fill Job Posting heading as "Software developer Engineer_"
    And User fill Job Description "Job Description" as "Job Description testing" for CL job
    And User fill Job Description "Candidate Profile" as "Candidate Profile testing" for CL job
    And User click on "Preview and Post" button and post the job
    And User is on "requirementInbox" page
    And User click recent created requirement name from JP
    When User click on "Edit" action of "Naukri Classified"
    And User click on "Add Requirement" button on requirement creation
    And User choose first address
    And User select the questionnaire from list
    And User click on Preview button on requirement page
    Then User should be able to see "Job Description" value "Job Description testing" on preview page for CL job
  And User should be able to see "Candidate Profile" value "Candidate Profile testing" on preview page for CL job

  @id:7 @RMS @JPFormInRms
  Scenario: Verify all 3 fields Job Description, Candidate profile are treated differently while sending data to JP
   Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And refresh the page
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
  And User post a "Naukri Classified"
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User choose first address
  And User select the questionnaire from list
    And User click on Save and Post Requirement on requirement page
  When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
   Then User should be able to see "Job Description" value on jp form 
	Then User should be able to see "Candidate Profile" value on jp form

  @id:8 @RMS @JPFormInRms
  Scenario: To verify Job Description is dividing into 3 fields as per text when Posting classified job from JP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User click on GNB option "Naukri"
    And I select a "Post a Classified" from "Jobs & Responses" option on Naukri GNB
    And User fill Key skills as "Java"
    And User select key skills "Java" as must have key skill
    And User fill work experience "Minimum Experience" as "3"
    And User fill work experience "Maximum Experience" as "6"
    And User fill Annual Salary  "Minimum Salary" as "7,00,000"
    And User fill Annual Salary  "Maximum Salary" as "10,00,000"
    And User fill variable as "20" percent
    And User fill "Location" as "Kolkata"
    And User fill "Industry" as "Architecture / Interior Design"
    And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
    And User fill "Role" as "Collections Officer"
    And User fill "Education" Qualification in "Graduate" as "B.A"
    And User fill "Education" Qualification in "Postgraduate" as "CA"
    And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
    And User fill requirement name
    And User fill Employment Type as "Full Time, Temporary/Contractual"
    And User fill Job Description "Job Description" as "Job Description testing" for CL job
    And User fill Job Description "Candidate Profile" as "Candidate Profile testing" for CL job 
    When User fill Job Posting heading as "Software developer Engineer_"
    And User click on "Preview and Post" button and post the job
    And User is on "requirementInbox" page
    And User click recent created requirement name from JP
    When User click on "Edit" action of "Naukri Classified"
    Then User should be able to see value "Candidate Profile testing" in "Candidate Profile" section
    Then User should be able to see value "Job Description testing" in "Job Description" section
   When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job from jp on MJR
    And User fill Job Description "Candidate Profile" as "" for CL job 
    And User click on "Preview and Post" button and post the job
    And User is on "requirementInbox" page
    And User click recent created requirement name from JP
    When User click on "Edit" action of "Naukri Classified"
    Then User should be able to see value "" in "Candidate Profile" section

  @id:9 @RMS @JPFormInRms
  Scenario: Verify user is able see 3 fields seperately in preview for classified job
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User fill in the more salary details for "JP migrated" user
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
    And User post a "Naukri Classified"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User click on Preview button on requirement page
    Then User should be able to see "Job Description" value "Job Description" on preview page for CL job
    And User should be able to see "Candidate Profile" value "Candidate Details" on preview page for CL job
    And User should be able to see "Other Salary" value "Other Salary Details" on preview page for CL job
    When User click on "Back to Edit" link
    And User remove text from Other details for "JP migrated"
    And User remove text from Candidate profile
    And User click on Next button on requirement page
    And User choose first address
    And User select the questionnaire from list
    And User click on Preview button on requirement page
    Then User should be able to see "Job Description" value "Job Description" on preview page for CL job
    And User should not be able to see "Candidate Profile" field on preview page for CL job
    And User should not be able to see "Other Salary" field on preview page for CL job

  @id:10 @RMS @JPFormInRms
  Scenario: Verify user is able see Combining 3 fields in preview for private job after edit
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
    And User click on Preview button on requirement page
    Then User should be able to see "Roles and Responsibilities" in Job description section
  Then User should be able to see "Desired Candidate Profile" in Job description section
  Then User should be able to see "Perks and Benefits" in Job description section
  And User should be able to see "Roles and Responsibilities" correct value on preview page
  And User should be able to see "Desired Candidate Profile" correct value on preview page
  And User should be able to see "Perks and Benefits" correct value on preview page
  When User click on "Back to Edit" link
    And User remove text from Other details for "JP migrated"
    And User click on Next button on requirement page
    And User click on Preview button on requirement page
     And User should be able to see "Roles and Responsibilities" correct value on preview page
  	And User should be able to see "Desired Candidate Profile" correct value on preview page
    When User click on "Back to Edit" link
    And User remove text from Candidate profile
    And User fill in the more salary details for "JP migrated" user
    And User click on Next button on requirement page
    And User click on Preview button on requirement page
     And User should be able to see "Roles and Responsibilities" correct value on preview page
  And User should be able to see "Perks and Benefits" correct value on preview page


  @id:11 @RMS @JPFormInRms
  Scenario: Verify user is able see Combining 3 fields as Job Description while sending data to JP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
   When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User fill in the more salary details for "JP migrated" user
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
  And User select the questionnaire from list
    And User click on Save and Post Requirement on requirement page
    When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
    Then User should be able to see "Roles and Responsibilities" in Job description section on JP form
  Then User should be able to see "Desired Candidate Profile" in Job description section on JP form
  Then User should be able to see "Perks and Benefits" in Job description section on JP form
    When User is on "requirementInbox" page
    And User click recent created requirement name from rms
    When User click on "Edit" action of "Naukri Private Job" 
    And User remove text from Candidate profile
   And User click on Next button on requirement page
   And User choose first address
    And User click on Save and Post Requirement on requirement page
   When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
    Then User should be able to see "Roles and Responsibilities" in Job description section on JP form
    Then User should be able to see "Perks and Benefits" in Job description section on JP form
     Then User should not be able to see "Desired Candidate Profile" in Job description section on JP form
     When User is on "requirementInbox" page
   And User click recent created requirement name from rms
    When User click on "Edit" action of "Naukri Private Job" 
    When User fill in the Candidate Description
    And User remove text from Other details for "JP migrated"
    And User click on Next button on requirement page
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
    Then User should be able to see "Roles and Responsibilities" in Job description section on JP form
    Then User should be able to see "Desired Candidate Profile" in Job description section on JP form
     Then User should not be able to see "Perks and Benefits" in Job description section on JP form
     When User is on "requirementInbox" page
    And User click recent created requirement name from rms
    When User click on "Edit" action of "Naukri Private Job" 
    And User remove text from Candidate profile
    And User click on Next button on requirement page
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
    Then User should be able to see "Roles and Responsibilities" in Job description section on JP form
    Then User should not be able to see "Perks and Benefits" in Job description section on JP form
    Then User should not be able to see "Desired Candidate Profile" in Job description section on JP form
    
#
  #@id:12 #TBR on staging @RMS @RMSRequirements @RequirementCreation @JPFormInRms
  #Scenario: To verify Job Description is dividing into 3 fields as per text when Po
  #sting HV/Private job from JP when edit
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
    #When User fill Job Posting heading as "Software developer Engineer_"
    #And User fill Job Description "Roles and Responsibilities" as "Roles Description testing"
    #And User fill Job Description "Desired Candidate Profile" as "Desired Candidate Profile Description testing"
    #And User fill Job Description "Perks and Benefits" as "Perks and Benefits Description testing"
    #And User click on "Preview and Post" button and post the job
    #And User is on "requirementInbox" page
    #And User click recent created requirement name from JP
    #When User click on "Edit" action of "Naukri Private Job"
    #And User click on "Add Requirement" button on requirement creation
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
   #And User click on "Preview and Post" button and post the job
     #And User is on "requirementInbox" page
    #And User click recent created requirement name from JP
    #When User click on "Edit" action of "Naukri Private Job"
    #And User click on "Add Requirement" button on requirement creation
    #And User choose first address
    #And User select the questionnaire from list
    #And User click on Preview button on requirement page
   #Then User should be able to see "Roles and Responsibilities" in Job description section
  #Then User should not be able to see "Desired Candidate Profile" in Job description section
  #Then User should be able to see "Perks and Benefits" in Job description section
    #When User click on "Back to Edit" link
    #And User remove text from Other details for "JP migrated"
    #Then User should be able to see Job Description and Other salary detail
    #And User should be able to see "Candidate profile" field as blank
    #When User click on GNB option "Naukri"
  #And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  #And User edit the recent created job from jp on MJR
    #And User clear Job Description "Perks and Benefits" field
    #And User click on "Preview and Post" button and post the job
     #And User is on "requirementInbox" page
    #And User click recent created requirement name from JP
    #When User click on "Edit" action of "Naukri Private Job"
    #And User click on "Add Requirement" button on requirement creation
    #And User choose first address
    #And User select the questionnaire from list
    #And User click on Preview button on requirement page
   #Then User should be able to see "Roles and Responsibilities" in Job description section
  #Then User should not be able to see "Desired Candidate Profile" in Job description section
  #Then User should not be able to see "Perks and Benefits" in Job description section

@id:13 @RMS @RMSRequirements @RequirementCreation @JPFormInRms
  Scenario: To verify Job Description is dividing into 3 fields as per text when Posting HV/Private job from JP and edit thorough RMS
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
     When User click on GNB option "Naukri"
    And I select a "Post a Private Job" from "Jobs & Responses" option on Naukri GNB
    And User fill Key skills as "Java"
    And User select key skills "Java" as must have key skill
    And User fill work experience "Minimum Experience" as "3"
    And User fill work experience "Maximum Experience" as "6"
    And User fill Annual Salary  "Minimum Salary" as "7,00,000"
    And User fill Annual Salary  "Maximum Salary" as "10,00,000"
    And User fill variable as "20" percent
    And User fill "Location" as "Kolkata"
    And User fill "Industry" as "Architecture / Interior Design"
    And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
    And User fill "Role" as "Collections Officer"
    And User fill "Education" Qualification in "Graduate" as "B.A"
    And User fill "Education" Qualification in "Postgraduate" as "CA"
    And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
    And User fill requirement name
    And User fill Employment Type as "Full Time, Temporary/Contractual"
    When User fill Job Posting heading as "Software developer Engineer_"
    And User fill Job Description "Roles and Responsibilities" as "Roles Description testing"
    And User fill Job Description "Desired Candidate Profile" as "Desired Candidate Profile Description testing"
    And User fill Job Description "Perks and Benefits" as "Perks and Benefits Description testing"
    And User click on "Preview and Post" button and post the job
    And User is on "requirementInbox" page
    And User click recent created requirement name from JP
    When User click on "Edit" action of "Naukri Private Job"
    And User remove text from Candidate profile
    And User click on Next button on requirement page
    And User choose first address
    And User select the questionnaire from list
    And User click on Save and Post Requirement on requirement page
    And Click On cancel button on update job popup
   When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job from jp on MJR
   Then User should be able to see "Roles and Responsibilities" in Job description section on JP form
   Then User should be able to see "Perks and Benefits" in Job description section on JP form
   Then User should not be able to see "Desired Candidate Profile" value "Desired Candidate Profile Description testing" in Job description section on JP form
  
