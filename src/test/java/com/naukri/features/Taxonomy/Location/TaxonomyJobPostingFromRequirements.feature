Feature: Job posting after creating Requirement

  Scenario Outline: Verify that user is able to post different jobs with new location dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that user is able to post job to a requirement after editing/changing location
    #Scenario: Verify that user is able to post job using "Post" button on Requirement Listing page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    #And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User clicks "Save Requirement" button
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And User clicks "Edit" button
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User clicks "Next" button
    And User clicks "Save Requirement" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview
    And User clicks "Post" button on Requirement Overview
    And User post a "<jobTypes>"
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    Then User sees job posted with location as "Noida"

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that user is able to post another job after one job has been posted
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And User clicks "Post" button on Requirement Overview
    And User post a "<jobTypes>"
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    Then User sees job posted with location as "Noida"

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that user is able to post another job with different locations after one job has been posted
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And User clicks "Post" button on Requirement Overview
    And User clicks "Requirement Details" tab
    And User clicks "Save and Continue"
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User post a "<jobTypes>"
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    Then User sees job posted with location as "Noida"

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that user is able to post job using "Preview" option
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
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

  Scenario Outline: Verify that user is able to post job for requirements created from requisition
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And I logout of RMS
    Given User login to the application "RMSRequisitionList" using "Superuser2" of "Enterprise" user
    And User navigates to Requisition Overview using Requisition Tracking ID
    And User click on "Add Requirement" button on requirement creation
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview
    And User click on the tab "Requisition Details" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview
    Then User sees "Ajmer" added as location for the job posted

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that user is able to post job for requirements created using prefill option
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    And User click on Prefill from other Requirement
    And User selects created Requirement from prefill dropdown
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview
    Then User sees "Ajmer" added as location for the job posted

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that when more than 3 locations are selected for a Naukri job, widget to update job locations is displayed with warning
    #Scenario: Verify that locations entered on first page are prefilled on widget
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    When User enters "Rewari" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Rewari" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    Then User sees widget on Additional Details with message "Warning! You have Selected 4 locations, This will consume total 2 Jobs."
    Then User sees locations added to widget
      | Ajmer      |
      | Noida      |
      | Chandigarh |
      | Rewari     |

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  #Scenario: Verify that widget is removed on unchecking job post board
  Scenario Outline: Verify that widget is displayed again on checking, unchecking and then checking again any naukri job board
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    When User enters "Rewari" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Rewari" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    Then User sees widget on Additional Details with message "Warning! You have Selected 4 locations, This will consume total 2 Jobs."
    And User checks Job Posting checkbox
    Then User sees widget on Additional Details gets removed
    And User post a "<jobTypes>"
    Then User sees widget on Additional Details with message "Warning! You have Selected 4 locations, This will consume total 2 Jobs."

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that number of quota to be deducted also gets updated on changing/updating locations on the widget
    #Scenario Outline: Verify that user is able to change the job locations on the widget on Requirement Details page and post job, also requirement locations are not impacted
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    When User enters "Rewari" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Rewari" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    Then User sees widget on Additional Details with message "Warning! You have Selected 4 locations, This will consume total 2 Jobs."
    Then User sees locations added to widget
      | Ajmer      |
      | Noida      |
      | Chandigarh |
      | Rewari     |
    And User clicks cross icon for the tag
    Then User sees widget on Additional Details with message "Warning! You have Selected 3 locations, This will consume total 1 Jobs."
    When User enters "Bangalore" in widget
    And User checks the checkbox from the dropdown
    Then User sees "Bangalore" added as tag in the widget
    Then User sees widget on Additional Details with message "Warning! You have Selected 4 locations, This will consume total 2 Jobs."

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario Outline: Verify that for the job boards Eg: Careersite, widget is displayed with locations without warning messages
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    When User enters "Rewari" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Rewari" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    Then User sees widget on Additional Details with message "Warning! You have Selected 4 locations, This will consume total 2 Jobs."
    Then User sees locations added to widget
      | Ajmer      |
      | Noida      |
      | Chandigarh |
      | Rewari     |

    Examples: 
      | jobTypes   |
      | CareerSite |

  Scenario Outline: Verify that user is able to edit jobs posted with new locations
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
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
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User click on "Add Requirement" button on requirement creation
    And User post a "<jobTypes>"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation & Doctorate will be enforced"
    And User select "Doctorate" field as "I Will Choose Doctorate", "Choose Doctorate Degree" as "MPHIL" and Choose Specialization as "Agriculture"
    Then Verify User see the "MPHIL(Agriculture)" under the label You have selected as "Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    When User click on "Edit Job" action of "Naukri Private Job"
    Then Verify User see the "job" edit page
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User clicks "Next" button
    And User clicks "Save Job" button
    Then User sees "Ajmer" added as location for the job posted
    Then User sees "Noida" added as location for the job posted

    Examples: 
      | jobTypes           |
      | Naukri Private Job |
      | Naukri Hot Vacancy |
      | Naukri Classified  |
      | Naukri Premium     |

  Scenario: Verify that user is able to edit old jobs posted with old locations
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User applies "Jobs" filter to Requirement Listing page
    And User clicks on 1 requirement in the list
    When User click on "Edit Job" action of "<jobType>"
    Then Verify User see the "job" edit page
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User clicks "Next" button
    And User clicks "Save Job" button
    Then User sees "Noida" added as location for the job posted

  Scenario: Verify that user is able to repost jobs posted with new locations
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User applies "Jobs" filter to Requirement Listing page
    And User clicks on 1 requirement in the list
    When User click on "Repost" action of "<jobType>"
    Then Verify User see the "job" edit page
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User clicks "Next" button
    And User clicks "Save Job" button
    Then User sees "Noida" added as location for the job posted

  Scenario: Verify that user is able to repost old jobs with old locations
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User applies "Jobs" filter to Requirement Listing page
    And User clicks 5 on pagination
    And User clicks on 1 requirement in the list
    When User click on "Repost" action of "<jobType>"
    Then Verify User see the "job" edit page
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User clicks "Next" button
    And User clicks "Save Job" button
    Then User sees "Noida" added as location for the job posted

  # Scenario related to JP Integration
  Scenario: Verify that jobs posted from JP using old locations are visible in RMS with correct locations

  Scenario: Verify that jobs posted from JP using new locations  are visible in RMS with correct locations

  Scenario: Verify that user is able to edit new jobs posted from JP in RMS with new locations

  Scenario: Verify that user is able to edit old jobs posted from JP in RMS with new locations

  Scenario: Verify that user is able to repost new jobs posted from JP in RMS with new locations

  Scenario: Verify that user is able to repost old jobs posted from JP in RMS with new locations
