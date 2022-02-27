Feature: To Verify Restrict recruiter profile to creator only

@id:1 @RMS @JPFormInRms
  Scenario: Verify user is able see 'Add Profile' and 'Refresh' link with 'Attach NaukriRecruiter Profile' field if recruiter profile doesn't exists
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
    And User post a "Naukri Private Job"
    Then User should be able to see 'Add Profile' link with 'Attach NaukriRecruiter Profile' field
    Then User should be able to see 'Refresh' link with 'Attach NaukriRecruiter Profile' field

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

    @id:8 @RMS @JPFormInRms
  Scenario: Verify user is able see naukri recruiter profile when user click on 'Add Profile'
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
    And User post a "Naukri Private Job"
    And User click on 'Add Profile' link with 'Attach NaukriRecruiter Profile' field
    Then User should be redirected on the naukri recruiter profile page in new tab
    
#
  #@id:2 Manual
  #Scenario: Verify user is able see Recruiter Email Id in 'Attach NaukriRecruiter Profile' field if recruiter profile exists
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
     #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #Then User should be able to see recruiter email ID in 'Attach NaukriRecruiter Profile' field
#
  #
#
  #@id:3 Manual
  #Scenario: Verify user is able see help text with 'Attach NaukriRecruiter Profile' field if recruiter profile doesn't exists
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
   #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #Then User should be able to see help text "No profile exists. Click on ‘Add Profile’ to create a profile."
#
  #@id:4 Manual
  #Scenario: Verify user is able see 'Attach NaukriRecruiter Profile' field disabled if recruiter profile doesn't exists
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #Then User should be able to see Attach NaukriRecruiter Profile field disabled
#
  #@id:5Manual
  #Scenario: Verify user is able see recruiter contact detail in job same as recruiter profile
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #And User post a job with recruiter contact details
    #When User click on GNB option "Naukri"
    #And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
    #And User edit the recent created job on MJR
    #Then User should be able to see the same recruiter contact detail in job as recruiter profile
#
  
  #@id:7 Manual
  #Scenario: Verify user is able see 'Company Name', 'About company' and 'Address' fields as non mandatory while saving requirement
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #Then User should be able to see 'Company Name' field as mandatory
    #And User should be able to see 'About Company' field as mandatory
    #And User should be able to see 'Address' field as mandatory
    #When User uncheck "Naukri Private Job" checkbox
    #Then User should not be able to see 'Company Name' field as mandatory
    #And User should not be able to see 'About Company' field as mandatory
#
  
#
  #@id:10 Manual
  #Scenario: Verify user is able see recruiter profile fileds updated when user click on 'Refresh'
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #And User click on 'Refresh' link with 'Attach NaukriRecruiter Profile' field
    #Then User should be able to see only recruiter profile fileds updated and show data in fields if available
#
  #@id:11 manual
  #Scenario: Verify user is able not able to see recruiter profile data on job until profile is not verified
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
   #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #And User click on 'Add Profile' link with 'Attach NaukriRecruiter Profile' field
    #And User add a recruiter profile
    #And User click on 'Refresh' link with 'Attach NaukriRecruiter Profile' field
    #And User post a job with recruiter contact details
    #When User click on GNB option "Naukri"
    #And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
    #And User edit the recent created job on MJR
    #Then User should not be able to see Recruiter profile data on job
#
  #@id:12 manual
  #Scenario: Verify user is able able to see recruiter profile data on job after validate recruiter profile
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And User click on the star on keyword chip
      #| JAVA |
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the requirement title
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And User select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And User click on "Add Requirement" button on requirement creation
    #And User post a "Naukri Private Job"
    #And User click on 'Add Profile' link with 'Attach NaukriRecruiter Profile' field
    #And User add a recruiter profile
    #And User click on 'Refresh' link with 'Attach NaukriRecruiter Profile' field
    #And User post a job with recruiter contact details
    #And User validate the recruiter profile
    #When User click on GNB option "Naukri"
    #And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
    #And User edit the recent created job on MJR
    #Then User should be able to see Recruiter profile data on job
