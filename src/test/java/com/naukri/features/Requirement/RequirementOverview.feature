Feature: Requirement overview feature

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify job is reposted from overview page with new details
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
    And User fill in the job location as "Delhi"
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
    And User choose first address
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User click on "Remove" action of "Naukri Private Job"
    Then Verify "Naukri Private Job" job is expired on overview page
    When User click on "Repost" action of "Naukri Private Job"
    Then Verify User see the "job" edit page
    When User click on the next button of the job edit page
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    When User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page


    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |


  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify salary is edited and currency is edited from overview page
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
    And User fill in the job location as "Delhi"
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
    When User click on "Edit" on requirement overview page
    And User select the currency of CTC as "USD"
    And User fill in the "minCTC" as "20,000"
    And User fill in the "maxCTC" as "25,000"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User clicks on Cross on update jobs lightbox
    When User click on the tab "Requirement Details" on requirement overview page
    Then verify currency is updated on overview page to "Annual CTC: U.S Dollars 20,000 to 25,000"
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify the visibilty is changed to visible to All in group from overview page
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
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And click on "Visible to Only Me" in visibility DD
    When User click on "Add Requirement" button on requirement creation
    When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When user clicks on Set Visibilty on overview page
    When User sets visibilty to "Visible to All in Group" from requirement overview page
    When User click on the tab "Requirement Details" on requirement overview page
    Then Verify that under requirement category Visible to "All" is displayed

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements @statusRequirement
  Scenario Outline: To verify all tabs on requirement overview page
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
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And click on "Visible to Only Me" in visibility DD
    When User click on "Add Requirement" button on requirement creation
    When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    And verify all the tabs on requirement overview page ie "Overview,Requirement Details,Questionnaire,Response Filters,Selection Stages,Comments"

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify Add a single profile can be created from requirement overview page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When user notes the projectId of requirement
    When User hover on "More" on overview page
    When User click on "Add Single Profile" of menu "More" Actions on overview page
    Then Verify Add a single profile url is displayed
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify selection stages are displayed on requirement overview page
    Given User login to the application "settingsPage" using <userType> of <Subscription> user
    Given user click on "Customize the Selection Process" link
    And user click on Add Selection Stage
    When user fill stage name as "Random Stage Name"
    And user click on Save stage button
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
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User clicks on "Selection Stages" on overview page
    Then Verify the new stage "Random Stage Name" is displayed on overview page
    When I navigate to Settings page
    Given user click on "Customize the Selection Process" link
    When user click on delete for "Random Stage Name" stage name button
    And user click on "Delete from entire System" from lightbox
    Then Verify "Stage Deleted" message is displayed
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

#  @wip
#  Scenario Outline: To verify requirement details on requirement overview page
#    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
#    When User select a "Add A New Requirement" from "Requirements" option
#    And User fill in the requirement title
#    And User click on "Employment Type" field
#    And User select an option "Full Time, Freelance/Homebased" from list
#    And User fill in the job title
#    And User fill in the Job Description
#    And User fill in the Candidate Description
#    And User select the currency of CTC as "INR"
#    And User fill in the "minCTC" as "5,00,000"
#    And User fill in the "maxCTC" as "7,00,000"
#    And User fill in the more salary details for "JP migrated" user
#    And User fill in the "minExp" as "2" years of experience
#    And User fill in the "maxExp" as "3" years of experience
#    And User fill in the keywords as "java"
#    And User fill in the job location as "Delhi,Ahmedabad"
#    And User click on "Add Requirement" button on requirement creation
#    And User post a "Naukri Private Job"
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation, or Doctorate will be enforced"
#    And User chose "Any Doctorate"
#    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
#    And User chose "Functional Area" as "Banking / Insurance"
#    And User chose "Role" as "Cash Officer"
#    And User check for the companyname and about company for "JP migrated" user
#    And User click on Save and Post Requirement on requirement page
#    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
#    When User click on "Skip Questionnaire For Now" on the questionnaire preview
#    Then Verify User redirected to requirement overview page
#    When User clicks on "Requirement Details" on overview page
#    Then Verify all the requirement details filled while creating requirement job title , job description,employment type,keywords,locations
#    Examples:
#      | userType       |Subscription     |
#      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify questionaire preview on requirement overview page
    Given User login to the application "requirementInbox" using <userType> of <Subscription> user
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
    And User clicks on Add new questionaire
    Then User verify the questionaire lightbox is opened
    When User enters questionaire name
    And User clicks on Add New Question
    And User enters Question and selects "Radio Button"
    And User enters "test ques 1a" and "test ques 1b " under answers
    And User clicks on Save Question
    And User clicks on Add New Question
    And User enters Question and selects "Check Box"
    And User enters "test ques 2a" ,"test ques 2b","test ques 2c" under answers
    And User clicks on Save Question
    And User clicks on Add New Question
    And User enters Question and selects "Custom List"
    And User enters "test ques 3a" and "test ques 3b" under answers
    And User clicks on Save Question
    And User clicks on Add New Question
    And User enters Question and selects "Text Area"
#    And User enters "test ques 4a" and "test ques 4b" under answers
    And User clicks on Save Question
    And User clicks on Save questionaire
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User clicks on qustionaire tab on overview page
    And User clicks on View questionaire
    Then Verify "4" questions in questionaire are created and displayed on preview on overview page
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify comment functionality on requirement overview page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User clicks on "Comments" on overview page
    When User enters "test" under comments section
    Then verify comment "test" displayed on overview page
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify response filters on requirement overview page
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
    And User fill in the job location as "Delhi"
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
    And User checks on Apply reponse filters on overview page
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify response filters page is displayed
    When User clicks on Save project on response filter page
    Then Verify User redirected to requirement overview page
    When User clicks on "Response Filters" on overview page
    And verify response filters on page
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify status of requirement on overview page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    And verify requirement status is "Open"
    When user sets the status to "On Hold"
    Then verify requirement status is "On Hold"
    When user sets the status to "Close"
    Then verify requirement status is "Closed"
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @don @run @testReport123 @RMSRequirements
  Scenario Outline: To verify requirement is posted ,reposted or not displayed on overview page
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
    And User fill in the job location as "Delhi"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    #Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    #When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And verify the status of requirement is "Not Posted" on overview page
    When user clicks on post on requirement overview page
    And User post a "Naukri Private Job"
    #And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And verify the status of requirement is "Posted" on overview page
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify requirement url on overview page
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
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    And verify requirement url contains requirement id

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify able to view job on naukri plateform
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
    And User fill in the job location as "Delhi"
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
    When User click on "View" action of "Naukri Private Job"
    Then verify job is visible on naukri plateform
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

#  @wip
#  Scenario Outline: To verify quick search functionality on listing page
#    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
#    When User select a "Add A New Requirement" from "Requirements" option
#    And User fill in the requirement title
#    And User fill in the job title
#    And User fill in the Job Description
#    And User fill in the Candidate Description
#    And User select the currency of CTC as "INR"
#    And User fill in the "minCTC" as "5,00,000"
#    And User fill in the "maxCTC" as "7,00,000"
#    And User fill in the more salary details for "JP migrated" user
#    And User fill in the "minExp" as "2" years of experience
#    And User fill in the "maxExp" as "3" years of experience
#    And User fill in the keywords as "java"
#    And User fill in the job location as "Delhi"
#    And User click on "Add Requirement" button on requirement creation
#    And User post a "Naukri Private Job"
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation & Doctorate will be enforced"
#    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
#    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
#    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
#    And User chose "Functional Area" as "Banking / Insurance"
#    And User chose "Role" as "Cash Officer"
#    And User check for the companyname and about company for "JP migrated" user
#    Then User click on Preview button on requirement page
#    And User click on Post button on Preview Requirement page
#    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
#    When User click on "Skip Questionnaire For Now" on the questionnaire preview
#    Then Verify User redirected to requirement overview page
#    When User navigate through GNB to "All Requirements" under "Requirements"
#    When under quick search bar user clicks on expand
#    And Enter any keyword matching and search
#    Then verify requirement is displayed
#    Examples:
#      | userType       |Subscription     |
#      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify visibility is set to only me from overview page
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
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And click on "Visible to All in Group" in visibility DD
   # And click on "Visible to Only Me" in visibility DD
    When User click on "Add Requirement" button on requirement creation
    When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When user clicks on Set Visibilty on overview page
    When User sets visibilty to "Visible to Only Me" from requirement overview page
    When User click on the tab "Requirement Details" on requirement overview page
    Then Verify that under requirement category Visible to "Only Me" is displayed

    Examples:
      | userType       |Subscription     |
     | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |


    @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify visibility is set to selected recruiter from overview page
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
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And click on "Visible to Only Me" in visibility DD
   # And click on "Visible to Only Me" in visibility DD
    When User click on "Add Requirement" button on requirement creation
    When User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When user clicks on Set Visibilty on overview page
    When User sets visibilty to "Visible to Selected People" from requirement overview page and select "mansisubuser.emlh@yopmail.com"
    When User click on the tab "Requirement Details" on requirement overview page
    Then Verify that under requirement category Visible to "mansisubuser.emlh@yopmail.com" is displayed

    Examples:
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify superuser able to comment on requirement from overview page (to check comment visible to subuser)
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User clicks on "Comments" on overview page
    When User enters "test" under comments section
    When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify User see the requirement created above
    And I logout

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify comments are visible to subuser on requirement overview (to check comment visible to subuser)
    Given I am logged in with "Enterprise" user "subuser3"
    When User is on "requirementInbox" page
    #When User navigate through GNB to "All Requirements" under "Requirements"
    Then Verify subUser see the requirement created above
    When user selects the requirement created
    Then Verify User redirected to requirement overview page
    When User clicks on "Comments" on overview page
    #When User enters "test" under comments section
    Then verify comment "test" displayed on overview page

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify history of requirement on requirement overview page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    Then verify the row displayed on history
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify requisition details tab displayed on requirement overview page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And user click on "Requisition Details Settings" link
    And User turn "on" Requisition Details Settings
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    When User navigate through GNB to "All Requirements" under "Requirements"
    And User clicks on created requirement name
    Then Verify that user see "Requisition Details" tab on overview page redirected from listing page

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify my database search based on requirement keyword and experience on requirement inbox page
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
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User hover on "Search" on overview page
    When User click on "My Database" of menu "Search" Actions on overview page
    Then verify the search is based on "Keyword,Experience,Current Location"
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify requirement details on requirement overview page
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
    And User fill in the job location as "Delhi"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User click on the tab "Requirement Details" on requirement overview page
    Then Verify the requirement details on overview page
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |
