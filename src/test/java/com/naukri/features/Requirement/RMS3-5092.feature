Feature: Verify User can see the field ‘Walk-in Start Date

  @id:1 @RMS @JPFormInRms
  Scenario: Verify user is able see Walk-in Start Date field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Walk-in Start Date field
    And User should be able to see Start Date field mandatory
    And User should be able to see "Walk-in Start Date" field in walkin section
    And User should be able to see hint text "Choose Date" in start date field
    When User click on Save and Post Requirement on requirement page
    Then User should be able to see error message "Select start date for walk-in" if field is blank
		When User click on calendar icon on walkin   
    And User should be able to see older date disabled
    When User select any date in future
    And User select "2" from duration drop down
    Then User should be able to select the start date and see text "This job would not be visible to the candidates after the walk-in end date"

  @id:2 @RMS @JPFormInRms
  Scenario: Verify user is able see Duration (Days) field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Duration Days field
    And User should be able to see "Duration (Days)" field in walkin section
    And User should be able to see by default value 1
    And Duration Days should not be blank
    And User should be able select any interger values from 1 to 10 from drop down

  @id:3  @RMS @JPFormInRms
  Scenario: Verify user is able see text after selction of start date and duration field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Walk-in Start Date field
		When User click on calendar icon on walkin   
    When User select any date in future
    And User select "2" from duration drop down
    Then User should be able to select the start date and see text "This job would not be visible to the candidates after the walk-in end date"

  @id:4 @RMS @JPFormInRms
  Scenario: Verify user is able see Walk-in timing field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Walk-in timing drop down start field
     And User should be able to see walkin duration field text "Walk-in timing"
    And User should be able to see by default value is 9.30 AM
    When User select End time "9.30 AM" less then Start time "10.30 AM"
    When User click on Save and Post Requirement on requirement page
    Then User should be able to see error message for timing dd "Start time should be less than End time"
    And User should not be able to see empty field
     Then User should be able to see values range from ‘8:00 AM’ to ‘7:30 PM’ and interval of 30 min

  @id:6 @RMS @JPFormInRms
  Scenario: Verify user is able see Contact Person field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Contact Person text field
    And User should be able to see contact person field text "Walk-in Contact Person"
     And User should be able to see hint text "Recruiter Name (If Available)" in contact person field
    When User should be able to enter any "Number" in contact person Name
     When User click on Save and Post Requirement on requirement page
    Then User should not be able to see contact person error message "Allowed characters are alphabets, numbers, space, @ - () & , . / ` [] _ ' " ! *"
   	When User should be able to enter any "String" in contact person Name
   	 When User click on Save and Post Requirement on requirement page
    Then User should not be able to see contact person error message "Allowed characters are alphabets, numbers, space, @ - () & , . / ` [] _ ' " ! *"
    When User enter any "Mentioned" special symbol
     When User click on Save and Post Requirement on requirement page
    Then User should not be able to see contact person error message "Allowed characters are alphabets, numbers, space, @ - () & , . / ` [] _ ' " ! *"
    When User enter any "Not Mentioned" special symbol 
     When User click on Save and Post Requirement on requirement page
    Then User should be able to see contact person error message "Allowed characters are alphabets, numbers, space, @ - () & , . / ` [] _ ' " ! *"
    And User should be able to see contact person field as non mandatory field

  @id:7 @RMS @JPFormInRms
  Scenario: Verify user is able see Contact Number field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Contact Number text field
    And User should be able to see hint text "Add mobile number" in Walk-in Contact Number field
    And User should be able to see contact number note
    And User should be able to see contact person number field text "Walk-in Contact Number"
    When User enter "String" value in Walk-in Contact Number field
    When User click on Save and Post Requirement on requirement page
    Then User should be see an error message for Walk-in Contact Number field "Please enter a valid phone number."
    When User enter "special" value in Walk-in Contact Number field
    When User click on Save and Post Requirement on requirement page
    Then User should be see an error message for Walk-in Contact Number field "Please enter a valid phone number."
    When User enter "Number" value in Walk-in Contact Number field
    When User click on Save and Post Requirement on requirement page
    Then User should not be see an error message for Walk-in Contact Number field "Please enter a valid phone number."
    When User enter number upto 16 digits
    Then User should be able to enter number upto 15 digits
    And User should not be able to enter number is same
    When User enter number upto 15 digits
    Then User should be able to enter number upto 15 digits
    And User should be able to enter number is same
    And User should be able to see contact person number field as non mandatory field

   @id:8 @RMS @JPFormInRms
  Scenario: Verify user is able see Venue field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Venue text field
    And User should be able to see hint text "Type Address here" in venue field
    And User should be able to see field as mandatory field
    When User click on Save and Post Requirement on requirement page
    And User should be see an error message for venue field "Mention venue details for the walk-in" when left blank
    And User should be able to see drop down on the field
    When User click on the venue drop down
    Then User should be able to see list of saved venues
    
    
  #@id:9 @RMS @RMSRequirements @RequirementCreation @JPFormInRms
  #Scenario: Verify user is able see Venue field sync with JP form
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    #When User Add a requirement
    #And Select 'Naukri' option on second page
    #And User click on "Add Walk-in Details" link
    #And User fill Venue details
    #And User post a job with recruiter contact details
    #And User go to JP form
    #And User click on "Include Walk in" checkbox
    #And User click on the venue drop down
    #Then User should be able to see recent added venue through RMS
#
  @id:10 @RMS @JPFormInRms
  Scenario: Verify user is able see Google Map URL field
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see Google Map URL open text field
    And User should be able to see open field text "Google Map URL"
    When User enter URL in google map field 
    Then User should be able to see same URL in this field

  @id:11 @RMS @JPFormInRms
  Scenario: Verify user is able see Search on Google Maps
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
    And User click on "Add Walk-in Details" link
    Then User should be able to see "Search on Google Maps" link Google Map URL open text field
    And User should be able to see info icon with "Search on Google Maps" link
    Then User should see info tooltip text "You can search on the map and pin point your exact office location."
    And User should be able to see "Know More" as link with "You can search on the map and pin point your exact office location." tooltip
    And User should be able to see "Know More" link "https://recruiterzone.naukri.com/now-attach-venue-maps-to-your-walk-in-jobs/?othersrcp=26961&wExp=N"
    When User enter text "Infoedge" in venue field
     When User click on Search on Google Maps link in walkin
     Then User should be able to see layer of google maps
    Then User should be able to see text on layer of google maps which entered in venue field
    When User select the location on Google map
    And User click on USE THIS LOCATION button
    Then Google URL of this location should be pasted in Google URL field

   @id:12 @RMS @JPFormInRms
  Scenario: Verify user is walk-in details displaying on Job description page
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
    And User click on "Add Walk-in Details" link
    When User click on calendar icon on walkin
    When User select any date in future
    And User select "2" from duration drop down
    And User select start time as "11.30 AM" and End time "4.30 PM"
    And User enter text "Infoedge" in venue field
    When User click on Save and Post Requirement on requirement page
    When User click on "View" action of "Naukri Private Job"
    And User switches to new window
    Then User should be able to see walk-in details on job description page

@id:13 @RMS @JPFormInRms
  Scenario: Verify user is walk-in details are sending to careersite JD page
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
    And User post a "Career Site Job"
    And User choose first address
    And User select the questionnaire from list
    And User click on "Add Walk-in Details" link
    When User click on calendar icon on walkin
    When User select any date in future
    And User select "2" from duration drop down
    And User select start time as "11.30 AM" and End time "4.30 PM"
    And User enter text "Infoedge" in venue field
     When User click on Save and Post Requirement on requirement page
    And User click on "View" action of "Career Site"
   And User switches to new window
    Then User should be able to see the walkin details on careersite JD page

@id:14 @RMS @JPFormInRms
  Scenario: Verify user is walk-in details are sending from JP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
    When User click on GNB option "Naukri"
    And I select a "Post a Private Job" from "Jobs & Responses" option on Naukri GNB
    And User select walk-in details
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
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see walkin details section
    |Start Date			|
    |End Date				|
    |Walkin Timing	|
    |Contact Person	|
    |Contact Number	|
    |Venue					|
    |Google Map URL	|
    
  @id:16 @RMS @JPFormInRms
  Scenario: Verify user is able to see walk-in details on preview page
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
    And User click on "Add Walk-in Details" link
    When User click on calendar icon on walkin
    When User select any date in future
    And User select "2" from duration drop down
    And User select start time as "11.30 AM" and End time "4.30 PM"
    When User fill name "Interviewer" in contact person Name
    When User fill Number "9876543211" value in Walk-in Contact Number field
    And User enter text "Infoedge" in venue field
    When User enter URL in google map field 
    When User click on Preview button on requirement page
    Then User should be able to see walkin details section on preview
    |Start Date			|
    |End Date				|
    |Walk-in Timing	|
    |Walk-in Contact Person	|
    |Walk-in Contact Number	|
    |Venue					|
    |Google Map URL	|
    And User should be able to see walkin details on preview page
    |Infoedge			|
    |Interviewer	|
    |9876543211		|
    |11.30 AM			|
    |4.30 PM			|

  @id:17 @RMS @JPFormInRms
  Scenario: Verify user is able to see walk-in details on overview page
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
    And User click on "Add Walk-in Details" link
    When User click on calendar icon on walkin   
		When User select any date in future
		And User select "2" from duration drop down
		And User select start time as "11.30 AM" and End time "4.30 PM"
		When User fill name "Interviewer" in contact person Name
    When User fill Number "9876543211" value in Walk-in Contact Number field
    And User enter text "Infoedge" in venue field
    When User enter URL in google map field 
    When User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see walkin details section
    |Start Date			|
    |End Date				|
    |Walkin Timing	|
    |Contact Person	|
    |Contact Number	|
    |Venue					|
    |Google Map URL	|
    
@id:18 @RMS @JPFormInRms
  Scenario: Verify user is walk-in details displaying on JP form
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
     And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
    And User post a "Naukri Private Job"
    And User choose first address
    And User select the questionnaire from list
    And User click on "Add Walk-in Details" link
    When User click on calendar icon on walkin   
		When User select any date in future
		And User select "2" from duration drop down
		And User select start time as "11.30 AM" and End time "4.30 PM"
		And User enter text "Infoedge" in venue field 
    When User click on Save and Post Requirement on requirement page
     	When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
    Then User should be able to see all walk-in details on JP form
    
    @id:19 @RMS @JPFormInRms
  Scenario: Verify ‘Note: this will be visible to applicants' text removed under phone number field when user select walkin detail section
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User post a "Naukri Private Job"
    And User choose first address
    And User select the questionnaire from list
    And User click on "Add Walk-in Details" link
    Then User should not be able to see "Note: this will be visible to applicants" under phone number field

@id:20 @RMS @JPFormInRms
  Scenario: Verify user is walk-in details displaying on Requirement details page
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
    And User click on "Add Walk-in Details" link
    When User click on calendar icon on walkin
    When User select any date in future
    And User select "2" from duration drop down
    And User select start time as "11.30 AM" and End time "4.30 PM"
    When User should be able to enter any "String" in contact person Name
    When User enter "Number" value in Walk-in Contact Number field
    And User enter text "Infoedge" in venue field
    When User enter URL in google map field 
    When User click on Save and Post Requirement on requirement page
    When User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see walkin details section
    |Start Date			|
    |End Date				|
    |Walkin Timing	|
    |Contact Person	|
    |Contact Number	|
    |Venue					|
    |Google Map URL	|
     When User click on the google map url
     And User switches to new window
     Then User should be able to see the corrcet Google URL
    
    #@id:15  manual
  #Scenario: Verify contact details is not mandatory if walk-in details is selected
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
    #And User post a "Naukri Private Job"
    #And User click on "Add Walk-in Details" link
    #Then User should be able to see contact details is not mandatory