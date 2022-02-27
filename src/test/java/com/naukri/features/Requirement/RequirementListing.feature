Feature: To verify the list functionality of requirement listing page

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify the presence of all status on requirement listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the Filter by "Status"
    And Verify User see text "Status (1)" on status filter
    When User click on filter by status
    Then Verify User see the checkbox "Open" label is "checked"
    And Verify User see the checkbox "Close" label is "unchecked"
    And Verify User see the checkbox "On Hold" label is "unchecked"
    Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify the presence of requirement source DD on requirement listing page
     Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the Filter by "Requirement Source"
    And Verify User see text "All" on requirement source filter
    When User click on filter by requirement source
    Then Verify User see the list as "All,Jobs,Emails,Vendors,Referral,Monster,Linkedin,Shine,Facebook,TimesJob,Naukri Premium Vacancy,Naukri Hot Vacancy,Naukri Classified,Naukri Private Job,Naukri Walkin Private,Career Site,Career Site Walkin,Career Site URL,Email Import,IIMJob,Resdex Email as Job,Twitter,Naukri Walkin HV,Naukri Walkin Classified,Naukri Walkin PV,Naukri URL Hot Vacancy,Naukri Classified Company URL,Employee Referral,Referral Drop Cv,Resdex Email,Naukri Private Company URL,Naukri URL PV,Other"
   Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |

  @RMS @RMSRequirements @RMSRequirementListing @Smoke @RMSRequirementReport
  Scenario Outline: To verify the requirement search on the requirement listing page
     Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
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
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Employment Type" field
  		And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation, or Doctorate will be enforced"
#    And User chose "Any Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "Any Doctorate" option
 #   And User select "Doctorate" degree "MPHIL" and "Agriculture" subject
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
   	And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User type in the requirement name in the search bar
    And User click on the search button on requirement listing
    Then Verify User see the searched requirement on the listing page
    Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify the disability of download by index and status graph in 0 source on requirement listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
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
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation, or Doctorate will be enforced"
#    And User chose "Any Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "Any Doctorate" option
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    And User should be able to see the label "0" sources
    When User click on the status graph of the created requirement
    Then Verify User see the status graph "disabled"
    When User hover on "More Actions" for a "requirement created"
    Then Verify User see the list of option available "Edit,Add Single Profile,Download By Index,Assign Vendor,Get Apply Link" under "More Actions" for "requirement created"
    When User click on "Download By Index" of menu "More Actions" of "requirement created"
    Then Verify User not see the download by index lightbox open
    Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify the count across the different requirement source on requirement listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the Filter by "Status"
    And Verify User see text "Status (1)" on status filter
    When User click on filter by status
    When User "uncheck" the checkbox with the label "Open"
    And User record the total count of requirement in system
    When User click on filter by status
    And User "check" the checkbox with the label "Open"
    And User record the total count of requirement
    When User click on filter by status
    And User "check" the checkbox with the label "Close"
    And User record the total count of requirement
    When User click on filter by status
    And User "check" the checkbox with the label "On Hold"
    And User record the total count of requirement
    Then Verify User see the total number of requirement less than the number of requirement recorded in all the requirement status according to <Subscription>
    Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify the presence of all options for a requirement under requirement listing page on requirement listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
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
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Employment Type" field
  		And User select an option "Full Time, Freelance/Homebased" from list
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation, or Doctorate will be enforced"
#    And User chose "Any Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "Any Doctorate" option
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User hover on "Modify" for a "requirement created"
    Then Verify User see the list of option available "Edit,Close,Post,Edit Response Filters" under "Modify" for "requirement created"
    When User hover on "Search" for a "requirement created"
    Then Verify User see the list of option available "My Database,Resdex" under "Search" for "requirement created"
    When User hover on "Open" for a "requirement created"
    Then Verify User see the list of option available "On Hold,Close" under "Open" for "requirement created"
    When User hover on "More Actions" for a "requirement created"
    Then Verify User see the list of option available "Edit,Add Single Profile,Download By Index,Assign Vendor,Get Apply Link" under "More Actions " for "requirement created"
	Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      
  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify the presence of all options for a requirement under requirement listing page on requirement listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the Filter by "Status" 
   And Verify User see the requirement created above
    When User hover on "Modify" for a "requirement created"
    Then Verify User see the list of option available "Edit,Close,Post,Edit Response Filters" under "Modify" for "requirement created"
    When User hover on "Search" for a "requirement created"
    Then Verify User see the list of option available "My Database" under "Search" for "requirement created"
    When User hover on "Open" for a "requirement created"
    Then Verify User see the list of option available "On Hold,Close" under "Open" for "requirement created"
    When User hover on "More Actions" for a "requirement created"
    Then Verify User see the list of option available "Edit,Add Single Profile,Download By Index,Share with Vendor,Get Apply Link" under "More Actions" for "requirement created"
    Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |

      @RMS @RMSRequirements @RMSRequirementListing @RMSBUG-3006 @RMSRequirementReport
  Scenario Outline: To verify the count of open Requirements on dashboard matched that in listing
  	 Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
  	And User adds "Open Requirements" notification on Dashboard if not present
  	When User clicks on count for the "Open Requirements"
  	Then Verify Total count of requirments matchs that on Dashboard
  	Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
   Scenario Outline: To verify the Refine Requirements filter fields
     Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
     When User navigate through GNB to "All Requirements" under "Requirements"
     Then Verify User see the Filter icon for categorization of requirements
     When User click on filter by Requirement categorization
     Then Verify User see the list as "By Industry","By Functional Area","By Group","Created By","Visible To"
     Examples:
       | userType       |Subscription     |
       | "Superuser"    |"Enterprise"     |
       | "Superuser"    |"ProConsultant"  |
       | "Superuser"    |"Company"        |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
    Scenario Outline: To verify comments displayed on requirement listing page
      Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
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
      And User fill in the more salary details for "JP migrated" user
      And User fill in the "minExp" as "2" years of experience
      And User fill in the "maxExp" as "3" years of experience
      And User fill in the keywords as "java"
      And User fill in the job location as "Delhi,Ahmedabad"
      And User click on "Add Requirement" button on requirement creation
      And User post a "Naukri Private Job"
#      And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#      Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#      When User select "Graduation & Post Graduation will be enforced"
#      And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#      Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#      When User select "Post Graduation, or Doctorate will be enforced"
#      And User chose "Any Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "Any Doctorate" option
      And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
      And User chose "Functional Area" as "Banking / Insurance"
      And User chose "Role" as "Cash Officer"
      And User check for the companyname and about company for "JP migrated" user
    And User choose first address
      And User click on Save and Post Requirement on requirement page
      Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
      When User click on "Skip Questionnaire For Now" on the questionnaire preview
      Then Verify User redirected to requirement overview page
      When User navigate through GNB to "All Requirements" under "Requirements"
      Then Verify User see the requirement created above
      When User clicks on comments icon on the requirement created
      And User enters comment on the listing page
      Then user verifies the count of comments should be "1"
      When User clicks on delete icon for the latest comment
      Then user verifies the count of comments should be "0"
      Examples:
        | userType       |Subscription     |
        | "Superuser"    |"Enterprise"     |
        | "Superuser"    |"ProConsultant"  |
        | "Superuser"    |"Company"        |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
      Scenario Outline: To verify user able to add a single profile to requirement from requirement listing page and check download by index lightbox visible 
        Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
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
        And User fill in the more salary details for "JP migrated" user
        And User fill in the "minExp" as "2" years of experience
        And User fill in the "maxExp" as "3" years of experience
        And User fill in the keywords as "java"
        And User fill in the job location as "Delhi,Ahmedabad"
        And User click on "Add Requirement" button on requirement creation
        And User post a "Naukri Private Job"
#        And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#        Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#        When User select "Graduation & Post Graduation will be enforced"
#        And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#        Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#        When User select "Post Graduation, or Doctorate will be enforced"
#        And User chose "Any Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "Any Doctorate" option
        And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
        And User chose "Functional Area" as "Banking / Insurance"
        And User chose "Role" as "Cash Officer"
        And User check for the companyname and about company for "JP migrated" user
    And User choose first address
        And User click on Save and Post Requirement on requirement page
        Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
        When User click on "Skip Questionnaire For Now" on the questionnaire preview
        Then Verify User redirected to requirement overview page
        When User navigate through GNB to "All Requirements" under "Requirements"
        Then Verify User see the requirement created above
        #When User type in the requirement name in the search bar
        #And User click on the search button on requirement listing
    #	Then Verify User see the searched requirement on the listing page
        When User hover on "More Actions" for a "requirement created"
        When User click on "Add Single Profile" of menu "More Actions" of "requirement created"
        When I enter the "Candidate Test User" characters in the candidate name
        And I fill in the email of the candidate
        And I fill in the contact of the candidate
        And I click on Add Candidate button
        And  user click on requirement name on cv details page
        Then Verify User redirected to requirement overview page
        When User navigate through GNB to "All Requirements" under "Requirements"
        #When User type in the requirement name in the search bar
        #And User click on the search button on requirement listing
        #Then Verify User see the searched requirement on the listing page
        Then User verify the count of application on listing page should be "1"
        When User hover on "More Actions" for a "requirement created"
        When User click on "Download By Index" of menu "More Actions" of "requirement created"
        Then Verify User is able to see download by index lightbox

        Examples:
        | userType       |Subscription     |
        | "Superuser"    |"Enterprise"     |
        | "Superuser"    |"ProConsultant"  |
        | "Superuser"    |"Company"        |

        #@testreqlistingcases @testyuu12
#	  Scenario: To do the verify the count on multiple cv uploadand mapping it to new requirement 
  #	Given I login into RMS as an "Enterprise" user
  #	When User select a "Upload Multiple CVs" from "Profiles" option
  #	Then I should be able to see "Add Candidate - Multiple Files" as the page heading for the multiple CV upload
  #	When I select the CV in ".doc" extension for bulk upload
  #	And I click on "Add New" for creating new requirement to map the uploaded CV
  #	And I fill in the requirement title with "Multiple Upload Requirement" 
  #	And I click on Upload Files on the multiple upload CV page
  #	Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details." 
  #	When I click on "View Upload Log" for the CVs uploaded
  #	Then I must be able to see "1" under the "Profiles Created" 
  #	When User select a "All Requirements" from "Requirements" option
  #	Then I should be able to see the requirement created during multiple upload
  #	And User verify the count of application on listing page should be "1"
  #

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify Requirement is marked closed on requirement listing page when user choses Closed from filter
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User hover on "Open" for a "requirement created"
    And user selects any requirement and marks its status to closed
    And user clicks on requirement name on listing page
    Then verify the status of requirement is "Closed" on overviewPage
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |




    @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify user able to post jobs from requirement listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User hover on "Modify" for a "requirement created"
    And User clicks on "Post" for requirement created
    And User post a "Naukri Private Job"
    And User choose first address
     And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And User verifies "Naukri Private Job   " is displayed on overview page
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job" with "Naukri Private Job"
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User clicks on Sources under requirement
    Then User verifies "Naukri Private Job   " is displayed on listing page
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job" displayed on listing page


    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |


  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify user able to edit requirement from listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User hover on "Modify" for a "requirement created"
    And User clicks on "Edit" for requirement created
    And User changes the Job title of the requirement
    And User click on "Add Requirement" button on requirement creation
    And User click on Save and Post Requirement on requirement page
    And User marks tick to update job with new job title
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User clicks on Sources under requirement
    Then User verifies the job title on listing page is updated
	       Examples:
        | userType       |Subscription     |
        | "Superuser"    |"Enterprise"     |
        | "Superuser"    |"ProConsultant"  |
        | "Superuser"    |"Company"        |


  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify user able to change no of requirements visible on listing page through filter
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "All Requirements" under "Requirements"
    And User selects "20" requirements from filter
    Then Verify only "20" requirements are displayed on listing page
      Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
    Scenario Outline: To verify count of requirement when filter is selected from refine requirements
      Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
      When User navigate through GNB to "All Requirements" under "Requirements"
      Then Verify User see the Filter icon for categorization of requirements
      When User click on filter by Requirement categorization
      And User clicks on first filter on refine requirements
      And User clicks on Refine Requirements on listing page
      Then Verify the requirement count on listing page after filter is selected
          Examples:
            | userType       |Subscription     |
            | "Superuser"    |"Enterprise"     |
            | "Superuser"    |"ProConsultant"  |
            | "Superuser"    |"Company"        |




  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario: To verify Requirement is searchable from requirement id on listing page
     Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
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
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    When User type in the requirement id in the search bar
    And User click on the search button on requirement listing
    Then Verify User see the searched requirement on the listing page

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify user able to add comments in eapps account
    Given User login to the application "addANewRequirement" using <userType> of <Subscription> user
    When User click on "Add Requirement" button on requirement creation
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
    When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User is on "requirementInbox" page
    Then Verify User see the requirement created above
    When User clicks on comments icon on the requirement created
    And User enters comment on the listing page
    Then user verifies the count of comments should be "1"
    When User clicks on delete icon for the latest comment
    Then user verifies the count of comments should be "0"
    Examples:
      |userType    |Subscription   |
      |"Superuser" |"Eapps2"       |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario Outline: To verify no groups or employer entry on eapps requirement listing page
    Given I login into RMS as "<userType>"
    When User is on "requirementInbox" page
    Then Verify Groups not displayed on requirement listing page

    Examples:
      | userType        |
      | Eapps.Superuser |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
        Scenario Outline: To verify requirement visible to only superuser when visibility not set to all in group in eapps
          Given User login to the application "addANewRequirement" using <userType> of <Subscription> user
          When User click on "Add Requirement" button on requirement creation
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
          And click on "Visible to Only Me" in visibility DD
          #And select subrecruiter "godfather12345@yopmail.com"
          When User click on "Add Requirement" button on requirement creation
          When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
          And User chose "Functional Area" as "Banking / Insurance"
          And User chose "Role" as "Cash Officer"
          And User click on Save and Post Requirement on requirement page
          Then Verify User redirected to requirement overview page
          When User is on "requirementInbox" page
          Then Verify User see the requirement created above
          And Verify requirement visible to superuser only on eapps

          Examples:
            |userType    |Subscription   |
            |"Superuser" |"Eapps2"       |



  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
        Scenario Outline: To verify requirement is visible to all recruiters when visibilty is set to all in group in eapps
          Given User login to the application "addANewRequirement" using <userType> of <Subscription> user
          When User click on "Add Requirement" button on requirement creation
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
          And click on "Visible to Selected People" in visibility DD
          And select subrecruiter "godfather12345@yopmail.com"
          When User click on "Add Requirement" button on requirement creation
          When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
          And User chose "Functional Area" as "Banking / Insurance"
          And User chose "Role" as "Cash Officer"
          And User click on Save and Post Requirement on requirement page
          Then Verify User redirected to requirement overview page
          When User is on "requirementInbox" page
          Then Verify User see the requirement created above
          And Verify requirement visible to "2" recruiters

          Examples:
            |userType    |Subscription   |
            |"Superuser" |"Eapps2"       |

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport	
  Scenario: To verify requirement is visible to subuser when group assigned and visibilty to all in group is chosen
    Given I am logged in with "Enterprise" user "superuser1"
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR                         | HRSpoc                     | HM        | HMSpoc  |
      | NotInHierarchy@yopmail.com | NotInHierarchy@yopmail.com | MansiHM   | MansiHM |
    Then Verify that Group name is displayed on manage group page
    And User is on "settingsPage" page
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
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User fill the group name on req creation page
    And user selects visibilty settings to "Visible to All in Group"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation, or Doctorate will be enforced"
#    And User chose "Any Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "Any Doctorate" option
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    And I logout
    And I am logged in with "Enterprise" user "subuser3"
    When User is on "requirementInbox" page
    #When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify subUser see the requirement created above

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario: To verify requirement is created and visibility is set yo none in group (visibility set to none)
    Given I am logged in with "Enterprise" user "superuser1"
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR                         | HRSpoc                     | HM        | HMSpoc  |
      | NotInHierarchy@yopmail.com | NotInHierarchy@yopmail.com | MansiHM   | MansiHM |
    Then Verify that Group name is displayed on manage group page
    And User is on "settingsPage" page
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
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User fill the group name on req creation page
    And user selects visibilty settings to "Visible to Only Me"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
          When User select "I Will Choose Graduation" option
          And User select "Graduation" degree "B.A" and "English" subject
          And User select "I Will Choose Post Graduation" option
          And User select "Post" degree "M.A" and "English" subject
          When User select "Any Doctorate" option
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
          And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    And User logout from application

  @RMS @RMSRequirements @RMSRequirementListing @RMSRequirementReport
  Scenario: To verify requiremeent not visible to subuser when visibility set to none (visibility set to none)
    Given I am logged in with "Enterprise" user "subuser3"
    When User is on "requirementInbox" page
    Then Verify User do not see the requirement created above





