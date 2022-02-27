Feature: To Verify user is able to add variable component in salary

  @id:1 @RMS  @JPFormInRms 
  Scenario: Verify user is able to add variable component text under Annual CTC
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    Then User is able to see text below Annual CTC "Entire salary is fixed. It does not include any variable component. Change"
    And User is able to see change text and that should be link

  @id:2 @RMS  @JPFormInRms 
  Scenario: Verify user is able to add variable component fields
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User click on "Change" link under Annual CTC
    Then User should be able to see "Variable CTC Percentage" field
    And "Variable CTC Percentage" field should be non mandatory

  @id:3 @RMS  @JPFormInRms 
  Scenario: Verify variable component fields validations
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User click on "Change" link under Annual CTC
    And User enter "String" in veriable field
    Then User should not be able to see "String" value in variable field
    And User should be able to see text "Entire salary is fixed" against variable field
    When User enter "Number" in veriable field
    Then User should be able to see "Number" value in variable field
    When User enter "float" in veriable field
    Then User should be able to see "float" value in variable field
    When User enter "Special" in veriable field
    Then User should not be able to see "Special" value in variable field
    When User enter "above 100" in veriable field
    Then User should not be able to see "above 100" value in variable field
    When User enter "number" in veriable field
    Then User should not be able to see text "Entire salary is fixed" against variable field
    When User fill in the "minCTC" as "5,00,000"
    When User enter "number" in veriable field
    Then User should not be able to see text "Entire salary is fixed" against variable field
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enter "number" in veriable field
    Then User should be able to see RS.M-RS.N is variable

  @id:4 @RMS @JPFormInRms 
  Scenario: Verify variable component fields is displaying on Requirement preview page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Preview button on requirement page
    Then User should be able to see correct Annual CTC with variable on preview page

@id:5 @RMS @JPFormInRms 
  Scenario: To verify Annual CTC vairable is displaying same when user creating Requirement through Requisition
    Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
    And User is on "RMSRaiseRequisition" page
    Then User is able to see text below Annual CTC "Entire salary is fixed. It does not include any variable component.Change"
    And User is able to see change text and that should be link
    And User click on "Change" link under Annual CTC
    Then User should be able to see "Variable CTC Percentage" field
    And User enter "String" in veriable field
    Then User should not be able to see "String" value in variable field
    And User should be able to see text "Entire salary is fixed" against variable field
    When User enter "Number" in veriable field
    Then User should be able to see "Number" value in variable field
    When User enter "float" in veriable field
    Then User should be able to see "float" value in variable field
    When User enter "Special" in veriable field
    Then User should not be able to see "Special" value in variable field
    When User enter "above 100" in veriable field
    Then User should not be able to see "above 100" value in variable field
    When User enter "number" in veriable field
    Then User should not be able to see text "Entire salary is fixed" against variable field
    When User fill in the "minCTC" as "5,00,000"
    When User enter "number" in veriable field
    Then User should not be able to see text "Entire salary is fixed" against variable field
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enter "number" in veriable field
    And User add keyword as
      | JAVA       |
      | Python     |
      | JavaScript |
    And User click on the star on keyword chip
      | JAVA |
    When User fill the required requisition details
    And User Click on add requisition button
    Then I see that the Status of requirement as "Pending For Requirement"
    When User click on created requisition
    Then User should be able to see correct Annual CTC with variable on requsition preview page
    When I logout
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise4" user
    And User is on "RMSRequisitionList" page
    And I create requirement for raised requisition
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list 
    Then User should be able to see "number" value in variable field
    Then veriable percetage and amount should be same as mentioned in Requisition
    When User click on Show salary to job seeker checkbox
    And User fill in the job location as "Delhi,Ahmedabad"
    When User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see correct Annual CTC with variable on requirement detail page


   @id:6 @RMS @JPFormInRms 
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
  Then User should be able to see correct Annual CTC with variable on requirement detail page
  When User click on the "Overview" tab on requirement overview page
  When User click on "Edit" action of "Naukri Private Job"   
  Then User should be able to see "20" value in variable field
    
 @id:7 @RMS @JPFormInRms 
  Scenario: Verify variable component fields is displaying on Careersite JD page
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
   And User check the checkbox of Show Salary to jobseekers
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Career Site Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User select the questionnaire from list
    When User click on Save and Post Requirement on requirement page
    And User click on "View" action of "Career Site"
    And User switches to new window
    Then User should be able to see correct variable amount is displaying on career site

  @id:8 @RMS @JPFormInRms 
  Scenario: Verify variable component fields is displaying on Naukri
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
    And User click on Show salary to job seeker checkbox
    And User click on "Employment Type" field
  	And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User select the questionnaire from list
    When User click on Save and Post Requirement on requirement page
    And User click on "View" action of "Naukri Private Job"
    And User switches to new window
    Then User should be able to see correct Veriable amount with ctc is displaying on job

  @id:9 @RMS @JPFormInRms 
  Scenario: Annual CTC value entered on Single upload page.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
   And User click on "Add New " link
    When User fills in the requirement title for add a single profile
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    Then User should be able to correct calculated variable 
    When I click on Add Candidate button
    When User select a "All Requirements" from "Requirements" option
    And User click recent created requirement name
    And User click on the tab "Edit" on requirement overview page
    Then User should be able to see "number" value in variable field

 @id:10 @RMS @JPFormInRms 
  Scenario: Annual CTC value entered on multiple upload page.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Multiple CVs" from "Profiles" option
    And User click on "Add New " link
    When I select the CV in ".doc" extension for bulk upload
    And User fills in the requirement title for add a single profile
    When User add keyword as
      | JAVA       |
      | Python     |
      | JavaScript |
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    And I click on Upload Files on the multiple upload CV page
    Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details."
    When User select a "All Requirements" from "Requirements" option
    And User click recent created requirement name
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see correct Annual CTC with variable on requirement detail page
    When User click on the "Overview" tab on requirement overview page
    And User click on the tab "Edit" on requirement overview page
    Then User should be able to see "number" value in variable field
#
 @id:11 @RMS @JPFormInRms 
  Scenario: Annual CTC value entered on Excel upload page.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Profiles from Excel" from "Profiles" option
     And User click on "Add New " link
     Then User is able to see text below Annual CTC "Entire salary is fixed. It does not include any variable component. Change"
    And User is able to see change text and that should be link
    When User click on "Change" link under Annual CTC
    Then User should be able to see "Variable CTC Percentage" field
    And "Variable CTC Percentage" field should be non mandatory
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enter "number" in veriable field
    Then User should be able to see RS.M-RS.N is variable

  @id:12 @RMS @JPFormInRms 
  Scenario: Annual CTC value entered on Bulk upload page.
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs in Bulk" from "Profiles" option
     And User click on Add New link on Bulk upload page
     Then User is able to see text below Annual CTC "Entire salary is fixed. It does not include any variable component. Change"
    And User is able to see change text and that should be link
    When User click on "Change" link under Annual CTC
    Then User should be able to see "Variable CTC Percentage" field
    And "Variable CTC Percentage" field should be non mandatory
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enter "number" in veriable field
    Then User should be able to see RS.M-RS.N is variable

  @id:14 @RMS  @JPFormInRms 
  Scenario: To verify Requirement Variable CTC Percentage coulmn is available in all old reports page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise4" user
    When User select a "View Reports" from "Reports" option
    And User click on "Requirement Report" link
    And User click on Select Columns in Report drop down
    Then User should be able to see "Requirement Variable CTC Percentage" column in the list

  @id:15 @RMS @JPFormInRms 
  Scenario: To verify 'Requirement Variable CTC Percentage’ option is displaying in "choose application Details" section in download tracker.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When User click on "Manage Download Tracker" link
    And click on add a new tracker
    Then User should be able to see "Requirement Variable CTC Percentage" option in "choose application Details" section
    When User reload the page.
    When User select a "All Applications" from "Profiles" option
    And User click on first candidate on inbox page
    And User click on "Download" option on inbox page
    And User click on "Selected Resumes" option from "Download"
    Then User should be able to see download popup
    And User should be able to see "Requirement Variable CTC Percentage" option in "choose application Details" section
    When User reload the page.
    And User click on first candidate on inbox page
    And User click on "Download" option on inbox page
    And User click on "Index Range" option from "Download"
    Then User should be able to see download popup
    And User should be able to see "Requirement Variable CTC Percentage" option in "choose application Details" section

  
  @id:18 @RMS @JPFormInRms 
  Scenario: To verify ‘Variable CTC Percentage’ tag is available in requirement section for all mails.
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When User select a "All Applications" from "Profiles" option
    And I click on the forward option
    When User click on "Requirement" option against "body"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
    When User click on "Requirement" option against "subject"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "subject"
    When User reload the page.
    And User click on first candidate on inbox page
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When User click on "Requirement" option against "body"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
  When User click on "Requirement" option against "subject"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "subject"
   When User is on "settingsPage" page
    And User click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Status Change "
    When User click on "Requirement" option against "body"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
   When User click on "Requirement" option against "subject"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "subject"
   When User is on "settingsPage" page
    And User click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Send a Requirement"
    When User click on "Requirement" option against "body"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
	When User click on "Requirement" option against "subject"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "subject"
   When User is on "settingsPage" page
    And User click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Forward"
    When User click on "Requirement" option against "body"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "body"
    When User click on "Requirement" option against "subject"
    Then User should be able to see "Variable CTC Percentage" tag in "Requirement" section against "subject"
    
  @id:20  @RMS @JPFormInRms 
  Scenario: To verify Annual CTC vairable is displaying same on Requisition template popup
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    Then user should be able to see the label "Create Requisition Template"
    Then User is able to see text below Annual CTC "Entire salary is fixed. It does not include any variable component. Change"
    And User is able to see change text and that should be link
    And User click on "Change" link under Annual CTC
    Then User should be able to see "Variable CTC Percentage" field
    And "Variable CTC Percentage" field should be non mandatory
    And User should be able to see text "Entire salary is fixed" against variable field
    And User enter "String" in veriable field
    Then User should not be able to see "String" value in variable field
    When User enter "number" in veriable field
    Then User should be able to see "number" value in variable field
    When User enter "float" in veriable field
    Then User should be able to see "float" value in variable field
    When User enter "Special" in veriable field
    Then User should not be able to see "Special" value in variable field
    When User enter "above 100" in veriable field
    Then User should not be able to see "above 100" value in variable field
    When User enter "number" in veriable field
    Then User should not be able to see text "Entire salary is fixed" against variable field
    When I fill in the "minCTC" as "5,00,000" in requisition
    When User enter "number" in veriable field
    Then User should not be able to see text "Entire salary is fixed" against variable field
    When I fill in the "minCTC" as "5,00,000" in requisition
    And I fill in the "maxCTC" as "7,00,000" in requisition
    When User enter "number" in veriable field
    Then User should be able to see RS.M-RS.N is variable
    And User add keyword as on Requisition Template
      | JAVA       |
      | Python     |
      | JavaScript |
    And User click on the star on keyword chip on Requisition Template
      | JAVA |
     When user fill mandatory fields for requisition template
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When User click on the preview button of recent created requisition template
    And User should be able to see Variable amount with annual CTC is displaying on requisition popup

    
    @id:21 @RMS @JPFormInRms  
  Scenario: Verify variable component fields is displaying on Requirement overview page
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
    And User click on Show salary to job seeker checkbox
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
		And User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see correct Annual CTC with variable on requirement detail page
    And User click on the tab "Edit" on requirement overview page
    Then User should be able to see "number" value in variable field
    When User enter "number" in veriable field
    And User click on "Add Requirement" button on requirement creation
    And User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should be able to see correct Annual CTC with variable on requirement detail page
     And User click on the tab "Edit" on requirement overview page
    Then User should be able to see "number" value in variable field
    When User enter "Blank" in veriable field
    And User click on "Add Requirement" button on requirement creation
    And User click on Save and Post Requirement on requirement page
    And User click on the "Requirement Details" tab on requirement overview page
    Then User should not be able to see veriable field on details page
    
     @id:22 @RMS @JPFormInRms  
  Scenario: Verify same variable value is displaying on JP page when user create the JOb through RMS
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
    And User click on Show salary to job seeker checkbox
    And User click on "Employment Type" field
  	And User select an option "Full Time, Freelance/Homebased" from list
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
  Then User should be able to see correct variable on JP page
  
 @id:23 @RMS @JPFormInRms @fail
  Scenario: Verify Variable value on mail preview page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And User click on "Add New " link
    When User fills in the requirement title for add a single profile
    And User select the currency of CTC as "INR"
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    When User enter "number" in veriable field
    Then User should be able to correct calculated variable
    When I click on Add Candidate button
    When User select a "All Requirements" from "Requirements" option
    When User click on the application count against requirement.
    Then I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    When User click on "Requirement" option against "body"
    When User click on "Variable CTC Percentage" tag in "Requirement" section against "body"
    When User click on "Requirement" option against "subject"
    When User click on "Variable CTC Percentage" tag in "Requirement" section against "subject"
    And User click on "Preview & Send" link
    Then User should be able to see variable value on mailbody
    
@id:24 @RMS @RMSRequirements @RequirementCreation @JPFormInRms 
  Scenario: Verify variable component fields is displaying on Careersite preview page
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
   And User check the checkbox of Show Salary to jobseekers
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User add keyword as
      | JAVA |
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Employment Type" field
  And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Career Site Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User choose first address
    And User select the questionnaire from list
    And User click on Preview button on requirement page
    Then User should be able to see correct Annual CTC with variable on preview page
    
    @id:25 @RMS @JPFormInRms
  Scenario: To verify requistion template is created without variable ctc
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
  When user fill mandatory fields for requisition template
  And user click on "Save Template" value
  Then verify created requisition template is visible to user
  
  @id:26 @RMS @JPFormInRms 
  Scenario: To verify user is able to create requistion without variable ctc
    Given User login to the application "rmsDashboardPage" using "HiringManager" of "Enterprise4" user
    And User is on "RMSRaiseRequisition" page
    Then User is able to see text below Annual CTC "Entire salary is fixed. It does not include any variable component.Change"
    And User is able to see change text and that should be link
    When User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User click on "Change" link under Annual CTC
    And User add keyword as
      | JAVA       |
      | Python     |
      | JavaScript |
    And User click on the star on keyword chip
      | JAVA |
    When User fill the required requisition details
    And User Click on add requisition button
    Then I see that the Status of requirement as "Pending For Requirement"
    
    #@id:13 Manual 
  #Scenario: Annual CTC value entered	 on Email upload page.
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    #When I select a "Upload CVs from Email" from "Profiles" option
    #When User enter email credentials
    #And User click on "Add New" link
    #And I fill in the requirement title with "Multiple Upload Requirement"
    #When User add keyword as
      #| JAVA       |
      #| Python     |
      #| JavaScript |
    #And I select the currency of CTC as "INR"
    #When I fill in the "minCTC" as "5,00,000"
    #And I fill in the "maxCTC" as "7,00,000"
    #And User click on "Change" link under Annual CTC
    #When User enter "number" in veriable field
    #And I click on Upload Files on the multiple upload CV page
    #Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details."
    #When I select a "All Requirements" from "Requirements" option
    #And User click recent created requirement name
    #And User click on the "Requirement Details" tab on requirement overview page
    #Then User should be see the same Amount as mentioned in job
    #When User click on the "Requirement Overview" tab on requirement overview page
    #And User click on the tab "Edit" on requirement overview page
    #Then User should be able to see "number" value in variable field
    
    #@id:16 Manual
  #Scenario: To verify user is able to add requirement with Variable CTC in requirement API and get the same through API
    #Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    #And User Go to settings page
    #And User click on the "Manage Integration with other Software" link
    #And User click on "Sample API Structure" link
    #Then User should be able to see "Variable CTC Percentage" field in sample API
    #When user add "Requirement" API
    #Then User should be able to add requirement with Variable CTC Percentage value
    #When User Add "Requirement Data" API
    #Then User should be able to get "Variable CTC Percentage" value as mentioned in "requirement" in response data
#
 #@id:19 Manual
  #Scenario: To verify Variable CTC Percentage data for requisition is available in requirement reports excel download
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    #When I select a "View Reports" from "Reports" option
    #And User click on "Requirement Report" link
    #And User click on Select Columns in Report drop down
    #Then User should be able to see "Requirement Variable CTC Percentage" column in the list
    #And Variable CTC data should be download in excel file
    #When User goes to the "Dashboard" Report
    #And Download requisition reports
    #Then Variable CTC data should be download in excel file