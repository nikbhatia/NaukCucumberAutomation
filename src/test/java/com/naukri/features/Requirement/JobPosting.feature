Feature: Job Posting

  @RMS @JPFormInRms @JobPosting
  Scenario: To verify Created requirement thotugh JP is visible on RMS
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User click on GNB option "Naukri"
    When I select a "Post a Private Job" from "Jobs & Responses" option on Naukri GNB
    And User fill Key skills as "Java"
    And User select key skills "Java" as must have key skill
    And User fill work experience "Minimum Experience" as "3"
    And User fill work experience "Maximum Experience" as "6"
    And User fill Annual Salary  "Minimum Salary" as "7,00,000"
    And User fill Annual Salary  "Maximum Salary" as "10,00,000"
    And User fill variable as "20" percent
    #And User click on "Hide salary details from candidates" checkbox
    And User fill "Location" as "Kolkata"
    And User fill "Industry" as "Architecture / Interior Design"
    And User fill "Functional Area" as "Financial Services, Banking, Investments, Insurance"
    And User fill "Role" as "Collections Officer"
    And User fill Reference code as "refc1234"
    And User fill Number of vacancy as "12"
    And User fill "Education" Qualification in "Graduate" as "B.A"
    And User fill "Education" Qualification in "Postgraduate" as "CA"
    And User fill "Education" Qualification in "Doctoral/Ph.D" as "Ph.D"
    And User select walk-in details
    #And User attach Questionnaire
    And User fill requirement name
    And User select job refresh schedule as "Fortnight" after "2" days
    And User select Receive matching applies on email checkbox and fill the email ID
    When User fill Job Posting heading as "Software developer Engineer_"
    And User fill Employment Type as "Full Time, Temporary/Contractual"
    And User fill Job Description "Roles and Responsibilities" as "Roles Description testing"
    And User fill Job Description "Desired Candidate Profile" as "Desired Candidate Profile Description testing"
    And User fill Job Description "Perks and Benefits" as "Perks and Benefits Description testing"
    And User click on "Preview and Post" button and post the job
    And User is on "requirementInbox" page
    #Then User should be able to see the requirement created from the JP
  #When User Click on recent requirement
  #And User click on the edit button under the posted job
  #Then User Should be able to see all the detail sale as fill at the JP side
  @RMS @RMSRequirements @JobPosting @RMSBUG-2464 @Smoke @RMSRequirementReport
  Scenario Outline: To check the merge of candidate profile and Job description
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
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "I Will Choose Doctorate" option
    And User select "Doctorate" degree "MPHIL" and "Agriculture" subject
#    When User select "Post Graduation & Doctorate will be enforced"
#    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
#    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User click on "Edit Job" action of "Naukri Private Job"
    Then Verify User see the "job" edit page
    When User click on the next button of the job edit page
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"

    Examples: 
      | userType    | Subscription |
      | "Superuser" | "Enterprise" |

  @RMS @RMSRequirements @JobPosting @RMSBUG-2949 @RMSRequirementReport
  Scenario Outline: To check the merge of candidate profile and Job description using Preview option on Create requirement page
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
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation & Doctorate will be enforced"
#    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
#    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    #Then User should not be able to see any dropdown after Doctorate field
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "I Will Choose Doctorate" option
    And User select "Doctorate" degree "MPHIL" and "Agriculture" subject
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    Then User click on Preview button on requirement page
    And User click on Post button on Preview Requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User click on "Edit Job" action of "Naukri Private Job"
    Then Verify User see the "job" edit page
    When User click on the next button of the job edit page
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"

    Examples: 
      | userType    | Subscription |
      | "Superuser" | "Enterprise" |

  @RMS @RMSRequirements @JobPosting @RMSBUG-3467 @RMSRequirementReport
  Scenario: To Check only single job is being posted on requirement overview of CSV/HV
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise2" user
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
    And User post a "Career Site Job"
#    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
#    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
#    When User select "Graduation & Post Graduation will be enforced"
#    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
#    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
#    When User select "Post Graduation & Doctorate will be enforced"
#    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
#    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    When User select "I Will Choose Graduation" option
    And User select "Graduation" degree "B.A" and "English" subject
    #Then User should not be able to see any dropdown after Doctorate field
    And User select "I Will Choose Post Graduation" option
    And User select "Post" degree "M.A" and "English" subject
    When User select "I Will Choose Doctorate" option
    And User select "Doctorate" degree "MPHIL" and "Agriculture" subject
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And Verify only single jobs being posted of "Naukri Private Job" on requirement overview page
    And Verify only single jobs being posted of "Career Site" on requirement overview page
