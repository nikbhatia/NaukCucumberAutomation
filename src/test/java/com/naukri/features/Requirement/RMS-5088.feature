Feature: To verify Employement Type in RMS
#
  @id:1  @RMS @JPFormInRms
  Scenario: To verify Employment Type field is displaying on Add requirement form
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  Then User should be able to see "Employment Type" filed on the add requirement form
  And User should be able to see "Employment Type" filed as Mandatory field
  
  @id:2 @RMS @JPFormInRms @fail
  Scenario: To verify Employment Type field options are displaying and in correct sequence
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User click on "Employment Type" field
  Then User should be able to see all options with correct sequence
  | Full Time, Permanent             |
  | Full Time, Temporary/Contractual |
  | Full Time, Freelance/Homebased   |
  | Part Time, Permanent             |
  | Part Time, Temporary/Contractual|
  | Part Time, Freelance/Homebased |
  
  @id:3 @RMS @JPFormInRms
  Scenario: To verify Employment Type value is displaying on Naukri jobs on preview
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
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
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User choose first address
  And User select the questionnaire from list
  And User click on Preview button on requirement page
  Then User should be able to see "Employment Type" field with filed value "Full Time, Freelance/Homebased"
 
 @id:4 @RMS @JPFormInRms 
  Scenario: To verify Employment Type value is displaying on careersite jobs on preview
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User select the currency of CTC as "INR"
  And User fill in the "minCTC" as "5,00,000"
  And User fill in the "maxCTC" as "7,00,000"
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User post a "Career Site Job"
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User choose first address
  And User click on Preview button on requirement page
  Then User should be able to see "Employment Type" field with filed value "Full Time, Freelance/Homebased"
  
  @id:5 @RMS @JPFormInRms
  Scenario: To verify Employment Type value is displaying on Naukri and careersite jobs on Job description page
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
  And User select the currency of CTC as "INR"
  And User fill in the "minCTC" as "5,00,000"
  And User fill in the "maxCTC" as "7,00,000"
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User post a "Naukri Private Job"
  And User choose first address
  ##And User post a "Career Site Job"
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User select the questionnaire from list
  And User click on Save and Post Requirement on requirement page
  And User click on "View" action of "Naukri Private Job"
  And User switches to new window
  Then User should be able to see "Employment Type" field with filed value "Full Time, Freelance/Homebased" on Job description page
 ## When User come back on the previous tab
  ##And User click on "View" action of "Career Site"
 ## Then User should be able to see "Employment Type" field with filed value "Full Time, Freelance/Homebased" on Job description page
  
  @id:6 @RMS @JPFormInRms
  Scenario: To verify same "Employment Type" value is displaying in RMS while job is created through JP
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  When User click on GNB option "Naukri"
  And I select a "Post a Private Job" from "Jobs & Responses" option on Naukri GNB
  And User fill Key skills as "Java"
    And User select key skills "Java" as must have key skill
    And User fill work experience "Minimum Experience" as "3"
    And User fill work experience "Maximum Experience" as "6"
    And User fill Annual Salary  "Minimum Salary" as "7,00,000"
    And User fill Annual Salary  "Maximum Salary" as "10,00,000"
    And User fill "Location" as "Kolkata"
    And User fill "Industry" as "Architecture / Interior Design"
    And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
    And User fill "Role" as "Collections Officer"
     And User fill "Education" Qualification in "Graduate" as "B.A"
    And User fill "Education" Qualification in "Postgraduate" as "CA"
    And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
      And User fill requirement name
  And User fill Employment Type as "Full Time, Temporary/Contractual"
  And User fill company details as "Company Details"
  And User fill Job Description "Roles and Responsibilities" as "Roles Description testing"
    And User fill Job Description "Desired Candidate Profile" as "Desired Candidate Profile Description testing"
    And User fill Job Description "Perks and Benefits" as "Perks and Benefits Description testing"
    When User fill Job Posting heading as "Software developer Engineer_"
    And User click on "Preview and Post" button and post the job
  And User is on "requirementInbox" page
  And User click recent created requirement name from JP
  And User click on the "Requirement Details" tab on requirement overview page
  Then User should be able to see "Employment Type" field with filed value "Full Time, Temporary/Contractual" on requirment overview page
  When User click on the "Overview" tab on requirement overview page
  When User click on "Edit" action of "Naukri Private Job"
  Then User should be able to see same "Employement Type" as "Full Time, Temporary/Contractual"
  #
  
  @id:8 @RMS @JPFormInRms
  Scenario: To verify "Employment Type" value is displaying on Requirement overview page
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
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
  And User click on Save and Post Requirement on requirement page
  And User click on the "Requirement Details" tab on requirement overview page
  Then User should be able to see "Employment Type" field with filed value "Full Time, Freelance/Homebased" on requirment overview page
  
  @id:9 @RMS @JPFormInRms
  Scenario: To verify "Employment Type" coulmn is available in all old reports page
  Given User login to the application "rmsDashboardPage" using "Superuser1" of "Enterprise" user
  When User select a "View Reports" from "Reports" option
  And User click on "Requirement Report" link
  And User click on Select Columns in Report drop down
  Then User should be able to see "Requirement Employment Type" column in the list
  
  @id:10 @RMS @JPFormInRms
  Scenario: To verify "Employment Type" option is displaying in "choose application Details" section in download tracker.
  Given User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
  When User click on "Manage Download Tracker" link
  And click on add a new tracker
  Then User should be able to see "Requirement Employment Type" option in "choose application Details" section
  When User reload the page.
  When User select a "All Applications" from "Profiles" option
  And User click on first candidate on inbox page
  And User click on "Download" option on inbox page
  And User click on "Selected Resumes" option from "Download"
  Then User should be able to see download popup
  And User should be able to see "Requirement Employment Type" option in "choose application Details" section
  When User reload the page.
  When User select a "All Applications" from "Profiles" option
  And User click on first candidate on inbox page
  And User click on "Download" option on inbox page
  And User click on "Index Range" option from "Download"
  Then User should be able to see download popup
  And User should be able to see "Requirement Employment Type" option in "choose application Details" section
  
  @id:11  @RMS @JPFormInRms
  Scenario: To verify "Employment Type" tag is available in requirement section for all mails.
  Given User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
  When User select a "All Applications" from "Profiles" option
  And I click on the forward option
  And User click on close button on update password popup
  Then User should be redirected to the forward lightbox
  When User click on "Requirement" option against "body"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "subject"
  When User reload the page.
  And User click on first candidate on inbox page
  And User hover on the Email option on top panel of the inbox
  Then I should be able to see the Send A Requirement option in the hover list
  When I click the send a requirement option in hover list
  And User click on close button on update password popup
  Then I should be redirected to send a requirement lightbox
  When User click on "Requirement" option against "body"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "subject"
  When User is on "settingsPage" page
  And User click on "Manage Email Templates" link
  And user click on "Add a New Template  " link
  And user select template type "Status Change "
  When User click on "Requirement" option against "body"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "subject"
  When User is on "settingsPage" page
  And User click on "Manage Email Templates" link
  And user click on "Add a New Template  " link
  And user select template type "Send a Requirement"
  When User click on "Requirement" option against "body"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "subject"
  When User is on "settingsPage" page
  And User click on "Manage Email Templates" link
  And user click on "Add a New Template  " link
  And user select template type "Forward"
  When User click on "Requirement" option against "body"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Employment Type" tag in "Requirement" section against "subject"
 
  @id:13 @RMS @JPFormInRms
  Scenario: To verify "Employment Type" value is displaying on Requirement overview page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
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
    And User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see "Employment Type" field with filed value "Full Time, Freelance/Homebased" on requirment overview page
    When User click on the tab "Edit" on requirement overview page
    And User click on "Employment Type" field
    And User select an option "Full Time, Temporary/Contractual" from list
    And User click on "Add Requirement" button on requirement creation
    And User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see "Employment Type" field with filed value "Full Time, Temporary/Contractual" on requirment overview page
    
    
  @id:14 @RMS @JPFormInRms
  Scenario: To verify same Employment Type value is displaying on JP while editing the job
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
  And User select the currency of CTC as "INR"
  And User fill in the "minCTC" as "5,00,000"
  And User fill in the "maxCTC" as "7,00,000"
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User post a "Naukri Private Job"
  And User choose first address
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User select the questionnaire from list
  And User click on Save and Post Requirement on requirement page
  When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR 
  Then User should be able to see employement type as "Full Time, Freelance/Homebased" on JP page

   #@id:12 Manual
  #Scenario: To verify "Employment Type" tag is available in requirement API
  #Given User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
  #And User Go to settings page
  #And User click on the "Manage Integration with other Software" link
  #And User click on "Sample API Structure" link
  #Then User should be able to see "Employement Type" field in sample API
  #When user add "Requirement" API
  #Then User should be able to add requirement with "Employement Type"
  #When User Add "Requirement Data" API
  #Then User should be able to see "Employement Type" in response data
