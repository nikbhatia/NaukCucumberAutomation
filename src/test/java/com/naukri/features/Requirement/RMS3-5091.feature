Feature: To Verify Must have star in key skills for requirement/requisition form

  @id:1 @RMS @JPFormInRms
  Scenario: Verify user is able to see star on keyword skill chip.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  Then User should be able to see "Unselected" star on keyword skill chip
  | JAVA       |
  | Python     |
  | JavaScript |
  
  @id:2 @RMS @JPFormInRms
  Scenario: Verify user is able to mark keyword skill chip as must have.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User add keyword as
  | JAVA |
  And User click on the star on keyword chip
  | JAVA |
  Then User should be able to see "Selected" star on keyword skill chip
  | JAVA |
  
  @id:3 @RMS @JPFormInRms
  Scenario: Verify User can mark 3 keyword as must have keyword
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  | C          |
  | C++        |
  And User click on the star on keyword chip
  | JAVA       |
  | Python     |
  | JavaScript |
  Then User should be able to see "Disabled" star on keyword skill chip
  | C   |
  | C++ |
  And User should be able to see "Disabled" tooltip
  | C   |
  | C++ |
  
  @id:4 @RMS @JPFormInRms
  Scenario: Verify user tooltip value when user hover on star
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  Then User should be able to see "Selected" star on keyword skill chip
  | JAVA |
  And User should be able to see "Selected" tooltip
  | JAVA |
  And User should be able to see "Unselected" tooltip
  | Python     |
  | JavaScript |
  
  @id:5 @RMS @JPFormInRms
  Scenario: Verify user is able to see UI text under Keyword field.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  Then User should be able to see text "Specify up to 3 key skills as 'must have' by star marking them. These will be displayed in job and will help target a relevant pool of candidates." under keyword field
  Then User should be able to see "Remove all Keywords" on right side of keyword field
  
  
 @id:6 @RMS @JPFormInRms @fail
  Scenario: To verify same "Keyword" value is displaying same when user creating Requirement through Requisition
  Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
    And User is on "RMSRaiseRequisition" page
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User fill the required requisition details
    And User Click on add requisition button
    Then I see that the Status of requirement as "Pending For Requirement"
    When User click on created requisition
    And User switches to new window
    Then User should be able to see correct Keyskills on requsition preview page
    | JAVA       |
  	| Python     |
  	| JavaScript |
    When I logout
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise4" user
    And User is on "RMSRequisitionList" page
    And I create requirement for raised requisition
    Then User should be able to see "Selected" star on keyword skill chip
  	| JAVA |

  @id:7 @RMS @JPFormInRms @fail
  Scenario: To verify Keyword value is displaying on Requirement overview page
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add A New Requirement" from "Requirements" option
  And refresh the page
  And User fill in the requirement title
  And User fill in the job title
  And User fill in the Job Description
  And User fill in the Candidate Description
  And User select the currency of CTC as "INR"
  And User fill in the "minCTC" as "5,00,000"
  And User fill in the "maxCTC" as "7,00,000"
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User click on Save and Post Requirement on requirement page
  And User click on the "Requirement Details" tab on requirement overview page
  Then User should be able to see keyword value and must have star on chip
  | JAVA |
  Then User should be able to see keyword value and doesn't has must have star on chip
  | Python     |
  | JavaScript |
  
  @id:8 @RMS @JPFormInRms @fail
  Scenario: To verify same Keyword value is displaying in RMS while job is created through JP
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
  And User click on the "Requirement Details" tab on requirement overview page
  Then User should be able to see keyword value and must have star on chip
  | Java |
  When User click on the "Overview" tab on requirement overview page
  When User click on "Edit" action of "Naukri Private Job"
  Then User should be able to see "Selected" star on keyword skill chip
  | Java |
  
 
  @id:10 @RMS @JPFormInRms
  Scenario: To verify ‘Requirement Keywords’ and ‘Requirement Must Have Keywords’ option is displaying in "choose application Details" section in download tracker.
  Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
  When User click on "Manage Download Tracker" link
  And click on add a new tracker
  Then User should be able to see "Requirement Keywords" option in "choose application Details" section
  And User should be able to see "Requirement Must Have Keywords" option in "choose application Details" section
  When User reload the page.
  When User select a "All Applications" from "Profiles" option
  And User click on first candidate on inbox page
  And User click on "Download" option on inbox page
  And User click on "Selected Resumes" option from "Download"
  Then User should be able to see download popup
  Then User should be able to see "Requirement Keywords" option in "choose application Details" section
  And User should be able to see "Requirement Must Have Keywords" option in "choose application Details" section
  When User reload the page.
  When User select a "All Applications" from "Profiles" option
  And I select profile 1 on profile listing page
  And User click on first candidate on inbox page
  And User click on "Download" option on inbox page
  And User click on "Index Range" option from "Download"
  Then User should be able to see download popup
  Then User should be able to see "Requirement Keywords" option in "choose application Details" section
  And User should be able to see "Requirement Must Have Keywords" option in "choose application Details" section
  
 
  @id:12 @RMS @JPFormInRms
  Scenario: To verify ‘Requirement Keywords’ and ‘Requirement Must Have Keywords’ tag is available in requirement section for all mails.
  Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
  When User select a "All Applications" from "Profiles" option
  And I click on the forward option
  When User click on "Requirement" option against "body"
  Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Requirement Keywords" tag in "Requirement" section against "subject"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "subject"
  When User reload the page.
  And User click on first candidate on inbox page
  And User hover on the Email option on top panel of the inbox
  Then I should be able to see the Send A Requirement option in the hover list
  When I click the send a requirement option in hover list
  Then I should be redirected to send a requirement lightbox
  When User click on "Requirement" option against "body"
  Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Requirement Keywords" tag in "Requirement" section against "subject"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "subject"
  When User is on "settingsPage" page
  And User click on "Manage Email Templates" link
  And user click on "Add a New Template  " link
  And user select template type "Status Change "
  When User click on "Requirement" option against "body"
  Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Requirement Keywords" tag in "Requirement" section against "subject"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "subject"
  When User is on "settingsPage" page
  And User click on "Manage Email Templates" link
  And user click on "Add a New Template  " link
  And user select template type "Send a Requirement"
  When User click on "Requirement" option against "body"
  Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Requirement Keywords" tag in "Requirement" section against "subject"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "subject"
  When User is on "settingsPage" page
  And User click on "Manage Email Templates" link
  And user click on "Add a New Template  " link
  And user select template type "Forward"
  When User click on "Requirement" option against "body"
  Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
  Then User should be able to see "Requirement Keywords" tag in "Requirement" section against "subject"
  Then User should be able to see "Requirement Must Have Keywords" tag in "Requirement" section against "subject"
  
  @id:13 @RMS @JPFormInRms 
  Scenario: Keyword value is displaying on Requisition Template and Requisition pop-up
  Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
  When user click on "Manage Requisition Templates" link
  And user click on "Create Requisition Template" value
  Then user should be able to see the label "Create Requisition Template"
  When User add keyword as on Requisition Template
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip on Requisition Template
  | JAVA |
  When I fill in the "minCTC" as "5,00,000" in requisition
  And I fill in the "maxCTC" as "7,00,000" in requisition
  And User click on "Change" link under Annual CTC
  When User enter "number" in veriable field
  When user fill mandatory fields for requisition template
  And user click on "Save Template" value
  Then verify created requisition template is visible to user
  When User click on the preview button of recent created requisition template
  Then User should be able to see keyword value and must have star on chip
  | JAVA |
  Then User should be able to see keyword value and doesn't has must have star on chip
  | Python     |
  | JavaScript |
  
  @id:14 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on Single upload page.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add a Single Profile" from "Profiles" option
  And User fill in the random email of the candidate
  And User click on "Add New " link
  When User fills in the requirement title for add a single profile
  When User add keyword in single profile as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  And User should be able to see "Selected" tooltip
  | JAVA |
  And User should be able to see "Unselected" tooltip
  | Python     |
  | JavaScript |
  When I click on Add Candidate button
  When User select a "All Requirements" from "Requirements" option
  And User click recent created requirement name
  And User click on the "Requirement Details" tab on requirement overview page
  Then User should be able to see keyword value and must have star on chip
  | JAVA |
  When User click on the tab "Edit" on requirement overview page
  Then User should be able to see "Selected" star on keyword skill chip
  | JAVA |
  
  @id:15 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on multiple upload page.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Upload Multiple CVs" from "Profiles" option
  When I select the CV in ".doc" extension for bulk upload
  And User click on "Add New " link
  And  User fills in the requirement title for add a single profile
  When User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  Then User should be able to see "Selected" tooltip
  | JAVA |
  And User should be able to see "Unselected" tooltip
  | Python     |
  | JavaScript |
  And I click on Upload Files on the multiple upload CV page
  Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details."
  When User select a "All Requirements" from "Requirements" option
  And User click recent created requirement name
  And User click on the "Requirement Details" tab on requirement overview page
  Then User should be able to see keyword value and must have star on chip
  | JAVA |
  When User click on the tab "Edit" on requirement overview page
  Then User should be able to see "Selected" star on keyword skill chip
  | JAVA |
   
  
  @id:16 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on Excel upload page.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  When User select a "Upload Profiles from Excel" from "Profiles" option
    And User click on "Add New " link
    And User fills in the requirement title for add a single profile
    When User add keyword as
      | JAVA       |
      | Python     |
      | JavaScript |
      | C          |
      | C++        |
    And User click on the star on keyword chip
      | JAVA |
    Then User should be able to see "Selected" tooltip
      | JAVA |
    And User should be able to see "Unselected" tooltip
      | Python     |
      | JavaScript |
    When User click on the star on keyword chip
      | Python     |
      | JavaScript |
    Then User should be able to see "Disabled" star on keyword skill chip
      | C   |
      | C++ |
    And User should be able to see "Disabled" tooltip
      | C   |
      | C++ |

  
  @id:17 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on Bulk upload page.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  When User select a "Upload CVs in Bulk" from "Profiles" option
    And User click on Add New link on Bulk upload page 
    And User fills in the requirement title for add a single profile
    When User add keyword as
      | JAVA       |
      | Python     |
      | JavaScript |
      | C          |
      | C++        |
    And User click on the star on keyword chip
      | JAVA |
    Then User should be able to see "Selected" tooltip
      | JAVA |
    And User should be able to see "Unselected" tooltip
      | Python     |
      | JavaScript |
    When User click on the star on keyword chip
      | Python     |
      | JavaScript |
    Then User should be able to see "Disabled" star on keyword skill chip
      | C   |
      | C++ |
    And User should be able to see "Disabled" tooltip
      | C   |
      | C++ |
  
  @id:19 @RMS @JPFormInRms @fail
  Scenario: To verify Keyword value is displaying on Requirement Preview page
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
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User click on Preview button on requirement page
  Then User should be able to see keyword value and must have star on chip
  | JAVA |
  Then User should be able to see keyword value and doesn't has must have star on chip
  | Python     |
  | JavaScript |
  
  @id:20 @RMS @JPFormInRms 
  Scenario: Verify same keyskill and must have keyskill values are displaying on JP page when user create the JOb through RMS
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
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  And User click on Show salary to job seeker checkbox
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
  When User click on Save and Post Requirement on requirement page
  	When User click on GNB option "Naukri"
  And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
  And User edit the recent created job on MJR
  Then User should be able to see correct keyskills on JP
  		| JAVA       |
  | Python     |
  | JavaScript |
  Then User should be able to see correct must have keyskills on JP
  		| JAVA |
  
  @id:21 @RMS @JPFormInRms 
  Scenario: Verify user is able to see star on keyword skill chip on requisition form.
  Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
  And User is on "RMSRaiseRequisition" page
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  Then User should be able to see "Unselected" star on keyword skill chip
  | JAVA       |
  | Python     |
  | JavaScript |
  
  @id:22 @RMS @JPFormInRms
  Scenario: Verify user is able to mark keyword skill chip as must have on requisition form.
  Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
  And User is on "RMSRaiseRequisition" page
  And User add keyword as
  | JAVA |
  And User click on the star on keyword chip
  | JAVA |
  Then User should be able to see "Selected" star on keyword skill chip
  | JAVA |
  
  @id:23 @RMS @JPFormInRms
  Scenario: Verify User can mark 3 keyword as must have keyword on requisition form
  Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
  And User is on "RMSRaiseRequisition" page
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  | C          |
  | C++        |
  And User click on the star on keyword chip
  | JAVA       |
  | Python     |
  | JavaScript |
  Then User should be able to see "Disabled" star on keyword skill chip
  | C   |
  | C++ |
  And User should be able to see "Disabled" tooltip
  | C   |
  | C++ |
  
  @id:24 @RMS @JPFormInRms
  Scenario: Verify user tooltip value when user hover on star on requisition form
  Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
  And User is on "RMSRaiseRequisition" page
  And User add keyword as
  | JAVA       |
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | JAVA |
  Then User should be able to see "Selected" star on keyword skill chip
  | JAVA |
  And User should be able to see "Selected" tooltip
  | JAVA |
  And User should be able to see "Unselected" tooltip
  | Python     |
  | JavaScript |
  
  @id:25 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on Single upload page and its tooltips.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add a Single Profile" from "Profiles" option
  And User fill in the random email of the candidate
  And User click on "Add New " link
  When User fills in the requirement title for add a single profile
  When User add keyword in single profile as
  | JAVA       |
  | Python     |
  | JavaScript |
  | C          |
  | C++        |
  And User click on the star on keyword chip
  | JAVA |
  And User should be able to see "Selected" tooltip
  | JAVA |
  And User should be able to see "Unselected" tooltip
  | Python     |
  | JavaScript |
  And User click on the star on keyword chip
  | Python     |
  | JavaScript |
  Then User should be able to see "Disabled" star on keyword skill chip
  | C   |
  | C++ |
  And User should be able to see "Disabled" tooltip
  | C   |
  | C++ |
  
  
 @id:28 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on multiple upload page and its tooltips.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Multiple CVs" from "Profiles" option
    And User click on "Add New " link
    Then User should be able to see text "Specify up to 3 key skills as 'must have' by star marking them. These will be displayed in job and will help target a relevant pool of candidates." under keyword field
    Then User should be able to see "Remove all Keywords" on right side of keyword field

    @id:29 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on Bulk upload page and its tooltips.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  When User select a "Upload CVs in Bulk" from "Profiles" option
  And User click on Add New link on Bulk upload page
  Then User should be able to see text "Specify up to 3 key skills as 'must have' by star marking them. These will be displayed in job and will help target a relevant pool of candidates." under keyword field
  Then User should be able to see "Remove all Keywords" on right side of keyword field
  
  @id:30 @RMS @JPFormInRms
  Scenario: Keyword value is displaying on Single upload page and its tooltips.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
  When User select a "Add a Single Profile" from "Profiles" option
  And User click on "Add New " link
  Then User should be able to see text "Specify up to 3 key skills as 'must have' by star marking them. These will be displayed in job and will help target a relevant pool of candidates." under keyword field
  Then User should be able to see "Remove all Keywords" on right side of keyword field
  
  @id:31 @RMS @JPFormInRms
  Scenario: Keyword tooltio value is displaying on Requisition Template
  Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
  When user click on "Manage Requisition Templates" link
  And user click on "Create Requisition Template" value
  Then user should be able to see the label "Create Requisition Template"
  When User add keyword as on Requisition Template
  | JAVA       |
  | Python     |
  | JavaScript |
  | C          |
  | C++        |
  And User click on the star on keyword chip on Requisition Template
  | JAVA |
  And User should be able to see correct tooltip for "Selected" on Requisition template
  | JAVA |
  And User should be able to see correct tooltip for "Unselected" on Requisition template
  | Python     |
  | JavaScript |
   And User click on the star on keyword chip on Requisition Template
  | Python     |
  | JavaScript |
  And User should be able to see correct tooltip for "Disabled" on Requisition template
  | C          |
  | C++        |
  
   #@id:11 Manual
  #Scenario: To verify user is able to add Keyword must have in requirement API
  #Given User login to the application "settingsPage" using "Superuser" of "Enterprise2" user
  #And User Go to settings page
  #And User click on the "Manage Integration with other Software" link
  #And User click on "Sample API Structure" link
  #When user add "Requirement" API
  #Then User should be able to add requirement with keyword as must have and requirement keyword
  #When User Add "Requirement Data" API
  #Then User should be able to see Requirement keyword as must have and requirement keyword in response data
  #
  
  #@id:18 Manual
  #Scenario: Keyword value is displaying on Email upload page.
  #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user
  #When I select a "Upload CVs from Email" from "Profiles" option
  #When User enter email credentials
  #And User click on "Add New " link
  #And I fill in the requirement title with "Multiple Upload Requirement"
  #When User add keyword as
  #| JAVA       |
  #| Python     |
  #| JavaScript |
  #And User click on the star on keyword chip
  #| JAVA |
  #Then User should be able to see "Selected" tooltip
  #| Java |
  #And User should be able to see "Unselected" tooltip
  #| Python     |
  #| JavaScript |
  #And I click on Upload Files on the multiple upload CV page
  #Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details."
  #When I select a "All Requirements" from "Requirements" option
  #And User click recent created requirement name
  #And User click on the "Requirement Details" tab on requirement overview page
  #Then User should be able to see keyword value and must have star on chip
  #| JAVA |
  #When User click on "Edit" button
  #Then User should be able to see "Selected" star on keyword skill chip
  #| JAVA |
  #And User should be able to see "Unselected" star on keyword skill chip
  #| Python     |
  #| JavaScript |
  #
