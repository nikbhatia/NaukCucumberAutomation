Feature: To verify the recent regression bugs of requirement overview

  @RMS @RMSRequirements @RequirementCreation @Smoke @RMSRequirementReport @reportMR
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
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User post a "Career Site Job"
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
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job" with "Naukri Private Job"
     Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @RMS @RMSRequirements @RequirementCreation @RMSBUG-2463 @testreportMRR
  Scenario Outline: To verify the candidate profile and job description not getting merged on editing and vieing a Naukri Job.
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
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job" with "Naukri Private Job"
    When User click on "Edit Job" action of "Naukri Private Job"
    Then Verify User see the "job" edit page
    And Verify User see the job description text in job description field
    And Verify User see the candidate profile text in candidate profile field
    Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify the mandatory field error on the first page of requirement creation
     Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User click on "Add Requirement" button on requirement creation
    Then Verify User see the error message "Requirement Title can not be blank." for requirement title
    And Verify User see the error message "Job Title / Designation can not be blank." for job title
    And Verify User see the error message "Select the required minimum salary." for "minimum salary" for salary
    And Verify User see the error message "Select the required maximum salary." for "maximum salary" for salary
    And Verify User see the error message "Select the required minimum experience." for "minimum experience" for experience
    And Verify User see the error message "Select the required maximum experience." for "maximum experience" for experience
    And Verify User see the error message "Keywords can not be blank." for keyword field
    And Verify User see the error message "Select the required location." for location field
     Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify the candidate profile and job description not getting merged on editing and vieing a Naukri Job.
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
    And User click on Save and Post Requirement on requirement page
    And User click on Industy label
    Then Verify User see the error message "Select the required Industry." under the Industry field
    And Verify User see the error message "Select the required Functional Area." under the Functional Area
     Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify the working of about company in requirement creation form for non migrated clients
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
    And User fill in the more salary details for "<MigrationStatus>" user
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
    And User fill "123123123123123123123123123123" in about company for "<MigrationStatus>"
    And User click on label About Company
    Then Verify User see "No Error" message below the About Company textbox
    When User fill "abcdefighjklmnopqrstuvwxyzabcdef" in about company for "<MigrationStatus>"
    And User click on label About Company
    Then Verify User see "No Error" message below the About Company textbox
    When User fill "abcdefighjklmnopqrstuvwxyzabcdefg" in about company for "<MigrationStatus>"
    And User click on label About Company
    Then Verify User see "<LengthErrorMessage>" message below the About Company textbox
    When User fill "123123123123123123123123123123123" in about company for "<MigrationStatus>"
    And User click on label About Company
    Then Verify User see "<LengthErrorMessage>" message below the About Company textbox
    When User fill "basjbdbasjdbjasbdjkbajkb121323" in about company for "<MigrationStatus>"
    And User click on label About Company
    Then Verify User see "No Error" message below the About Company textbox
    When User fill "<html></html>" in about company for "<MigrationStatus>"
    And User click on label About Company
    Then Verify User see "<ErrorMessage>" message below the About Company textbox

    Examples: 
   	| userType  | Subscription     | MigrationStatus | ErrorMessage | LengthErrorMessage |
    |"Superuser"| "Enterprise"     | JP migrated     | No Error     | No Error           |
    |"Superuser"| "ProConsultant"  | JP migrated     | No Error     | No Error           |
    |"Superuser"| "Company"        | JP migrated     | No Error     | No Error           |
   

  @RMS @RMSRequirements @RequirementCreation @RMSBUG-2515 @RMSRequirementReport
  Scenario Outline: To verify the functionality of the Show salary details to jobseekers
     Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User select the currency of CTC as "<currencyType>"
    And User fill in the "minCTC" as "<minCTC>"
    And User fill in the "maxCTC" as "<maxCTC>"
    And User check the checkbox of Show Salary to jobseekers
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
    Then Verify User see the "Requirement Details" as the heading of the tab
    And Verify User see the "<expectedOutcome>"

    Examples: 
      | userType  | Subscription      | currencyType | minCTC   | maxCTC   | expectedOutcome                          |
     |"Superuser"| "Enterprise"      | INR          | 5,00,000 | 7,00,000 | Annual CTC: Rupees 5,00,000 to 7,00,000  |
     |"Superuser"| "Enterprise"      | USD          |   30,000 |   35,000 | Annual CTC: U.S Dollars 30,000 to 35,000 |


  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
	  Scenario Outline: Validating errors of fields on page 1 of requirement creation in eappa account 
	 Given User login to the application "addANewRequirement" using <userType> of <Subscription> user
    And User click on "Add Requirement" button on requirement creation
	  Then Verify User see the error message "Requirement Title can not be blank." for requirement title
    And Verify User see the error message "Job Title / Designation can not be blank." for job title
    And Verify User see the error message "Select the required minimum salary." for "minimum salary" for salary
    And Verify User see the error message "Select the required maximum salary." for "maximum salary" for salary
    And Verify User see the error message "Select the required minimum experience." for "minimum experience" for experience
    And Verify User see the error message "Select the required maximum experience." for "maximum experience" for experience
    And Verify User see the error message "Keywords can not be blank." for keyword field
	    And Verify User see the error message "Select the required location." for location field
	 
	    Examples:  
      |userType    |Subscription   |
      |"Superuser" |"Eapps2"       |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
    Scenario Outline: To verify valdations on second page of eapps
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
      And User click on Save and Post Requirement on requirement page
      And User click on Industy label
      Then Verify User see the error message "Select the required Industry." under the Industry field
      And Verify User see the error message "Select the required Functional Area." under the Functional Area
      Examples:
        |userType    |Subscription   |
        |"Superuser" |"Eapps2"       |



  @RMS @RMSRequirements @RequirementCreation @eapps @RMSRequirementReport
      Scenario Outline: To verify html editor and preview of requirement on eapps
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
    And User check for the companyname and about company for "JP migrated" user
    And User enters "<company website>" website
    And User enters "<contact person>" contact person
    And User enters "<phone number>" phone number
    And User click on preview on second page of requiremnt creation
    Then Verify User see the "<expectedOutcome>" , "2" , "3" , "java" , "Delhi,Ahmedabad" on preview page
    And Verify User see the "<company website>" website , "<contact person>" contact person, "<phone number>" phone no on preview page
    When User clicks on save requirement from preview page
    Then Verify User redirected to requirement overview page

   Examples:  
      |userType    |Subscription   | expectedOutcome                        | company website        | contact person | phone number |
      |"Superuser" |"Eapps2"       | Annual CTC Rupees 5,00,000 to 7,00,000 | https://www.google.com | test person    | 9878678767   |

      @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
      Scenario Outline: To verify count of requirements displayed on prefill from other requirements  
	 Given User login to the application "requirementInbox" using <userType> of <Subscription> user
	 And User select a "Add A New Requirement" from "Requirements" option
	 And User click on Prefill from other Requirement
	 Then Verify the count of requirements on the prefill from other requirement DD 
	  
	     Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
	 Scenario Outline: To verify the save and continue functionality of requirement creation and also check the remove keywords functionality
	 Given User login to the application "requirementInbox" using <userType> of <Subscription> user
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
	    And User check the checkbox of Show Salary to jobseekers
	    And User fill in the more salary details for "JP migrated" user
	    And User fill in the "minExp" as "2" years of experience
	    And User fill in the "maxExp" as "3" years of experience
	    And User fill in the keywords as "java"
        And User removes the keywords
        Then verify keywords textbox is empty
        When User fill in the keywords as "php"
	    And User fill in the job location as "Delhi"
	    And User click on "Add Requirement" button on requirement creation
		And User click on Requirement Overview button on success message
		Then  Verify User redirected to requirement overview page
		
		 Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      #| "Superuser"    |"Company"        |
      #| "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport @reportMR
		Scenario Outline: To verify the salary , work ex, keywords and location on preview page of requirement
		 Given User login to the application "requirementInbox" using <userType> of <Subscription> user
	   When User select a "Add A New Requirement" from "Requirements" option
	    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
	    And User fill in the job title
	    And User fill in the Job Description
	    And User select the currency of CTC as "<currencyType>"
	    And User fill in the "minCTC" as "<minCTC>"
	    And User fill in the "maxCTC" as "<maxCTC>"
	    And User check the checkbox of Show Salary to jobseekers
	    And User fill in the more salary details for "JP migrated" user
	    And User fill in the "minExp" as "<minExp>" years of experience
	    And User fill in the "maxExp" as "<maxExp>" years of experience
	    And User fill in the keywords as "<keywords>"
	    And User fill in the job location as "<location>"
	    And User click on "Add Requirement" button on requirement creation
	    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
		And User click on preview on second page of requiremnt creation 
		Then Verify User see the "<expectedOutcome>" , "<minExp>" , "<maxExp>" , "<keywords>" , "<location>" on preview page  
		  When User clicks on save requirement from preview page 
		  Then Verify User redirected to requirement overview page

    Examples: 
     | userType  | Subscription      | currencyType | minCTC   | maxCTC   | expectedOutcome                         |minExp| maxExp | keywords | location |
     |"Superuser"| "Enterprise2"      | INR          | 5,00,000 | 7,00,000 | Annual CTC Rupees 5,00,000 to 7,00,000  |2	   |  3     | java     |  Delhi   |
     |"Superuser"| "Enterprise"      | USD          |   30,000 |   35,000 | Annual CTC U.S Dollars 30,000 to 35,000 |2	   |  3     | java     |  Delhi   |
     |"Superuser"| "ProConsultant"   | USD          |   30,000 |   35,000 | Annual CTC U.S Dollars 30,000 to 35,000 |2	   |  3     | java     |  Delhi   |
     |"Superuser"| "ProConsultant"   | USD          |   30,000 |   35,000 | Annual CTC U.S Dollars 30,000 to 35,000 |2	   |  3     | java     |  Delhi   |
     |"Superuser"| "Company"         | USD          |   30,000 |   35,000 | Annual CTC U.S Dollars 30,000 to 35,000 |2	   |  3     | java     |  Delhi   |
     |"Superuser"| "Company"         | USD          |   30,000 |   35,000 | Annual CTC U.S Dollars 30,000 to 35,000 |2	   |  3     | java     |  Delhi   |
#
  @RMS @RMSRequirements @RequirementCreation @intLocationCheck @RMSRequirementReport
		Scenario Outline: To verify the international location and job location checkbox and remove functionlity
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
	    And User fill in the job location as <location>
	    Then Verify the contents of job <location>
      When User click on clear all locations
      Then Verify no location should be displayed
			When User fill in the international job location as <Internationallocation>
	Then Verify the contents of international locations as <Internationallocation>
	When User click on clear all locations
	Then Verify no location should be displayed
	When User fill in the international job location as <Internationallocation>  with city name <cityName>
	Then Verify the international locations selected <Internationallocation>  with city name <cityName>
	
	 Examples: 
      | userType       |Subscription     | location  | Internationallocation | cityName |
      | "Superuser"    |"ProConsultant"  | "Delhi"   | "Australia"           |  "test"  |
      | "Superuser"    |"Company"        | "Delhi"   | "Australia"           |  "test"  |
      | "Superuser"    |"Enterprise"     | "Delhi"   | "Australia"           |  "test"  |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
      Scenario Outline: To verify the international location and job location checkbox and remove functionlity on eapps account 
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
        And User fill in the job location as <location>
        Then Verify the contents of job <location>
        When User click on clear all locations
        Then Verify no location should be displayed
        When User fill in the international job location as <Internationallocation>
      #  And User click on save location
        Then Verify the contents of international locations as <Internationallocation>
        When User click on clear all locations
        Then Verify no location should be displayed
        When User fill in the international job location as <Internationallocation>  with city name <cityName>
      #  And User click on save location
        Then Verify the international locations selected <Internationallocation>  with city name <cityName>
    
        Examples:
          | userType       |Subscription       | location | Internationallocation | cityName|
          | "Superuser"    | "Eapps2"          | "Delhi"  | "Australia"           | "test"  |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify no groups section displayed in eapps account
		Given User login to the application "addANewRequirement" using <userType> of <Subscription> user
	   When User click on "Add Requirement" button on requirement creation
		Then verify no groups section should be displayed on requirement creation page 
		 Examples:  
      |userType    |Subscription   |
      |"Superuser" |"Eapps2"       |


  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
		Scenario Outline: To verify the headings on prefill from other requirements DD
	Given User login to the application "requirementInbox" using <userType> of <Subscription> user
		When User select a "Add A New Requirement" from "Requirements" option
		 And User click on Prefill from other Requirement
     Then Verify the headings on DD "All,Jobs,Emails,Vendors,Referrals,Folders,Drafts,Closed"
		  Examples:  
      |userType    |Subscription       |
      |"Superuser" |"Enterprise"       |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
	Scenario Outline: All groups visible and verify recruiters and hiring managers displayed on req creation page
	Given User login to the application "groupListing" using <userType> of <Subscription> user
	And get the count of groups on page
    And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process	
      | HR                               | HRSpoc                           | HM                      | HMSpoc                |
      | enterprise2_subuser1@yopmail.com | enterprise2_subuser1@yopmail.com | avinashHM@yopmail.com   | avinashHM@yopmail.com | 
 
      And click on cross for group selection stages 
	When User select a "Add A New Requirement" from "Requirements" option
	    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
	    And User fill in the job title
	    And User fill in the Job Description
	    And User select the currency of CTC as "<currencyType>"
	    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
	    And User check the checkbox of Show Salary to jobseekers
	    And User fill in the more salary details for "JP migrated" user
	    And User fill in the "minExp" as "2" years of experience
	    And User fill in the "maxExp" as "3" years of experience
	    And User fill in the keywords as "java"
	    And User fill in the job location as "Delhi"
		And click on groups section 
		Then verify the count of groups present in DD 
		When select the group created 
		And click on "Visible to Selected People" in visibility DD
		Then Verify the subrecruiters "enterprise2_subuser1@yopmail.com" 
		Then verify the hiring manager "avinashHM@yopmail.com"
		
		 Examples: 
      | userType       |Subscription       |
      | "Superuser"    |"Enterprise2"      |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: Verify that group can be edited after a profile is added to requirement created from all profiles page
    Given User login to the application "addANewRequirement" using <userType> of <Subscription> user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User fills in "Engineer Testing" as Current Designation
    And User fills in "Infoedge" as Current Company
    And User fills in "Noida" as Current Location
    And User checks in "Anywhere in North India" as preferred location
    And User fills in "IT Software - QA & Testing" as Functional Area
    And User fills in "QA/QC Exec." as Role
    And User fills in "Recruitment" as Industry
    And User selects 3 years and 10 months as total experience
    And User selects 10 lakhs and 50 thousands as annual salary
    And User selects 13 lakhs and 70 thousands as expected salary
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User select any group while creating requirement
    And I click on Add Candidate button
    And  user click on requirement name on cv details page 
    Then Verify User redirected to requirement overview page
    When  User click on the tab "Edit" on requirement overview page
     And User fill in the job title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
	    And User fill in the Job Description
	    And User fill in the Candidate Description
	    And User fill in the keywords as "java"
	    And User fill in the job location as "Delhi"
    And click on groups section
        And select any other group on requirement creation page
    And User click on "Add Requirement" button on requirement creation
	    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
		  And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
	    
    
    Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |


     @RMS @RMSRequirements @RequirementCreation @RMSEN-1498 @RMSRequirementReport @reportMR
    Scenario: This scenario verifies that User should not be able to create requirement if HM spoc has been removed from the group
    Given "Enterprise" user is on Settings Page with "Superuser"
    And user click on "Manage Groups " link
    And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR                               | HRSpoc                           | HM                      | HMSpoc                |
      | enterprise2_subuser1@yopmail.com | enterprise2_subuser1@yopmail.com | avinashHM@yopmail.com   | avinashHM@yopmail.com |

    Given I logout
    Given "Enterprise" user is on Settings Page with "HiringManager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    Given "Enterprise" user is on Settings Page with "Superuser"
    And User is on "settingsPage" page
    And user click on "Manage Groups " link 
    And User click on Edit link under group
    And User edit the group and "Remove" HMSpoc "avinashHM@yopmail.com" from group
    And user click on "SAVE" button 
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    Then User should be able to see error message "Requirement can’t be created from this requisition as hiring manager has been removed from the group"
    
    @RMS @RMSRequirements @RequirementCreation @RMSBUG-3258 @RMSRequirementReport @testreportMRR
    Scenario: This scenario verifies that User should not be able to create requirement if HM spoc has been removed from the group
    Given I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      And User is on "settingsPage" page
      And I turn "off" Requisition Approval Mandatory toggle bar
    
    Given I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    And User is on "settingsPage" page
    And user click on "Manage Groups " link 
    And User click on Edit link under group
    And User edit the group and "Remove" HMSpoc "MansiHM" from group
    And user click on "SAVE" button 
    When User select a "All Requirements" from "Requirements" option
    And User click created requirement from requisition
    And User click on the tab "Edit" on requirement overview page
#      And User click on "Employment Type" field
#      And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the "minCTC" as "7,00,000"
    And User fill in the "maxCTC" as "10,00,000"
    And User click on "Add Requirement" button on requirement creation
     And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page

  @RMS @RMSRequirements @RequirementCreation @RMSEN-1498 @RMSRequirementReport @testreportMRR
         Scenario: This scenario verifies that User should not be able to create requirement if HM spoc has been removed from the group
         Given I logout
         And I am logged in with "Enterprise" user "superuser1"
         And User is on "settingsPage" page
         And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
           | HR          | HRSpoc      | HM        | HMSpoc  |
           | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar

         Given I logout
         And I am logged in with "Enterprise" user "hiringmanager1"
         And User is on "RMSRaiseRequisition" page
         And HM Spoc creates requisition with no approval process
         And I logout
         And I am logged in with "Enterprise" user "superuser1"

         And User is on "settingsPage" page
         And user click on "Manage Groups " link
         And User click on Edit link under group created
         And User edit the group and "Remove" HMSpoc "MansiHM" from group
         And user click on "SAVE" button
         And User is on "RMSRequisitionList" page
         And I go to "Requisitions Ready for Creation" section
         When I create requirement for raised requisition
         Then User should be able to see error message "Requirement can’t be created from this requisition as hiring manager has been removed from the group"

  @RMS @RMSRequirements @RequirementCreation @RMSBUG-3258 @reportGenrequirement1  @RMSRequirementReport @testreportMRR
        Scenario: This scenario verifies that User should be able to edit requirement if HM spoc has been removed from the group
          Given I logout
          And I am logged in with "Enterprise" user "superuser1"
          And User is on "settingsPage" page
          And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
            | HR          | HRSpoc      | HM        | HMSpoc  |
            | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar

          Given I logout
          And I am logged in with "Enterprise" user "hiringmanager1"
          And User is on "RMSRaiseRequisition" page
          And HM Spoc creates requisition with no approval process
          And I logout
          And I am logged in with "Enterprise" user "superuser1"
          And User is on "RMSRequisitionList" page
          And I go to "Requisitions Ready for Creation" section
          When I create requirement for raised requisition
          And User is on "settingsPage" page
          And user click on "Manage Groups " link
          And User click on Edit link under group created
          And User edit the group and "Remove" HMSpoc "MansiHM" from group
          And user click on "SAVE" button
          When User select a "All Requirements" from "Requirements" option
          And User click created requirement from requisition
          And User click on the tab "Edit" on requirement overview page
#    And User click on "Employment Type" field
#    And User select an option "Full Time, Freelance/Homebased" from list
          And User fill in the "minCTC" as "7,00,000"
          And User fill in the "maxCTC" as "10,00,000"
          And User click on "Add Requirement" button on requirement creation
          And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
          And User chose "Functional Area" as "Banking / Insurance"
          And User chose "Role" as "Cash Officer"
          And User click on Save and Post Requirement on requirement page
          Then Verify User redirected to requirement overview page after requisition is raised


  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
     Scenario Outline: To verify hiring for displayed for consultant account
     Given User login to the application "groupListing" using <userType> of <Subscription> user
	And get the count of groups on page
	And User select a "Add A New Requirement" from "Requirements" option
	    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
	    And User fill in the job title
	    And User fill in the Job Description
	    And User select the currency of CTC as "<currencyType>"
	    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
	    And User check the checkbox of Show Salary to jobseekers
	    And User fill in the more salary details for "JP migrated" user
	    And User fill in the "minExp" as "2" years of experience
	    And User fill in the "maxExp" as "3" years of experience
	    And User fill in the keywords as "java"
	    And User fill in the job location as "Delhi"
		And click on groups section 
		Then verify the count of groups present in DD 
		And verify "Hiring For:  " is displayed on add requirement page 
	
      Examples:  
      |userType   |Subscription     |
      |"Superuser"|"ProConsultant"  |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
      Scenario Outline: To verify prefill from requirements functionality
        Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
        When User select a "Add A New Requirement" from "Requirements" option
        And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
        And User fill in the job title
        And User fill in the Job Description
        And User fill in the Candidate Description
        And User select the currency of CTC as "USD"
        And User fill in the "minCTC" as "30,000"
        And User fill in the "maxCTC" as "35,000"
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
       # Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
       # When User click on "Skip Questionnaire For Now" on the questionnaire preview
        And User select a "Add A New Requirement" from "Requirements" option
        And User click on Prefill from other Requirement
        And select first requirement from prefill from other requirements DD
        Then verify the fields prefilled from previous requirement
        Examples:
          | userType       |Subscription       |
          | "Superuser"    | "Enterprise2"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
      Scenario Outline: To verify work experience range values
       Given User login to the application "groupListing" using <userType> of <Subscription> user
	And get the count of groups on page
	And User select a "Add A New Requirement" from "Requirements" option
	    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
	    And User fill in the job title
	    And User fill in the Job Description
	    And User select the currency of CTC as "<currencyType>"
	    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
	    And User check the checkbox of Show Salary to jobseekers
	    And User fill in the more salary details for "JP migrated" user
	    And User fill in the "minExp" as "5" years of experience
	    When click on maxExp
	    Then verify the count of max experience "7"
		When User fill in the "minExp" as "15" years of experience
		When click on maxExp
		Then verify the count of max experience "12"
		When User fill in the "minExp" as "30" years of experience
		Then verify the count of max experience "2"
	    
	   Examples: 
      | userType       |Subscription     | 
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
        Scenario Outline: To verify No of vacancies and ref code with group name exists on preview
          Given User login to the application "requirementInbox" using <userType> of <Subscription> user
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
          And User enters no of vacancies as "10"
          And User enters reference no as "123"
          And User click on "Add Requirement" button on requirement creation
          And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
          And User chose "Functional Area" as "Banking / Insurance"
          And User chose "Role" as "Cash Officer"
          And User click on preview on second page of requiremnt creation
          Then Verify User see the "No. of Vacancies" as "10" and "Reference Code" as "123" on preview page

				 Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"ProConsultant"  |
      | "Superuser"    |"Company"        |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
      Scenario Outline: To verify able to see 3 tabs on requirement creation
        Given User login to the application "requirementInbox" using <userType> of <Subscription> user
        When User select a "Add A New Requirement" from "Requirements" option
        Then verify 3 tabs are visible on requirement creation ie " Requirement Details  ", " Additional Details ", " Response Filters (Optional) "
        Examples:
          | userType       |Subscription     |
          | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport @testPrevieww
  Scenario Outline: To verify requirement can be created with duplicate requirement name
    Given User login to the application "requirementInbox" using <userType> of <Subscription> user
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
    And User select a "Add A New Requirement" from "Requirements" option
    And User enters the requirement name previously used
    And User click on Prefill from other Requirement
    And select first requirement from prefill from other requirements DD
    And User click on "Add Requirement" button on requirement creation
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page

    Examples:
      | userType       |Subscription       |
      | "Superuser"    | "Enterprise2"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify Edit requirement and currency should persist
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "USD"
    And User fill in the "minCTC" as "30,000"
    And User fill in the "maxCTC" as "35,000"
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
    When  User click on the tab "Edit" on requirement overview page
    Then Verify currency "USD" persists on editing requirement

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify company name , company website , contact person and phone number visible on preview page
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
    And User check for the companyname and about company for "JP migrated" user
    And User enters "<company website>" website
    And User enters "<contact person>" contact person
    And User enters "<phone number>" phone number
    And User click on preview on second page of requiremnt creation
    Then Verify User see the "<company website>" website , "<contact person>" contact person, "<phone number>" phone no on preview page
    When User clicks on save requirement from preview page
    Then Verify User redirected to requirement overview page

    Examples:
      | userType       |Subscription     | company website       | contact person | phone number |
      | "Superuser"    |"Enterprise"     |https://www.google.com | test person    | 9910292878   |


  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify add a new questionaire to requirement
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
    Then User verifies the questionaire name on requirement creation page

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
    Scenario Outline: To verify max 10 answers could be created for a question
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
      When User enters questionaire name
      And User clicks on Add New Question
      And User enters Question and selects "Custom List"
      And User opens all the 10 textboxes
      Then verify Only 10 answers could be displayed for a question
    Examples:
    | userType       |Subscription     |
    | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
      Scenario Outline:  To verify Edit, Duplicate , Delete , Cancel functionality for a new questionaire
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
      When User enters questionaire name
      And User clicks on Add New Question
      And User enters Question and selects "Radio Button"
      And User clicks on Mandatory question
      And User enters "test ques 1a" and "test ques 1b " under answers
      And User clicks on Save Question
      And verify "Edit" , "Duplicate" and delete icon is displayed
      When User clicks on "Edit" button on question
      Then Verify Mandatory question is checked
      And Edit Question should be displayed on lightbox
      When Change the question on edit
      And User clicks on Save Question
      And User clicks on "Duplicate" button on question
      Then Verify duplicate question is displayed on lightbox
      When User clicks on delete icon on question
      Then Verify no question should be displayed

      Examples:
        | userType       |Subscription     |
        | "Superuser"    |"Enterprise"     |


  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify edit, Duplicate, Delete , cancel functionality on existing questionaire with mandatory question 
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
      When User click on cancel on lightbox
      Then verify no questionaire is displayed
      And User clicks on Add new questionaire
    When User enters questionaire name
    And User clicks on Add New Question
      And User clicks on Mandatory question
    And User enters Question and selects "Radio Button"
    And User enters "test ques 1a" and "test ques 1b " under answers
    And User clicks on Save Question
    And User clicks on Save questionaire
    And User clicks on Add new questionaire
    And User select questionaire created above from existing questionaire
    Then verify that one question is created
    And verify "Edit" , "Duplicate" and delete icon is displayed
    When User clicks on "Edit" button on question
      Then Verify Mandatory question is checked
      And Edit Question should be displayed on lightbox
      When Change the question on edit
    And User enters "test ques 1a" and "test ques 1b " under answers
    And User clicks on Save Question
      And User clicks on "Duplicate" button on question
      Then Verify duplicate question is displayed on lightbox
    When User clicks on delete icon on question
    Then Verify no question should be displayed

      Examples:
        | userType       |Subscription     |
        | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: Verify validations on questionaire lightbox
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
    And User clicks on Save questionaire
    Then Verify "Questionnaire name can not be blank." error displayed on questionaire name
    When User enters questionaire name
    And User clicks on Save questionaire
    Then Verify "Add atleast one Question to save the Questionnaire." error displayed on questionaire name
    And User clicks on Add New Question
    And User clicks on Save Question
    Then Verify "Required Field can not be left blank" error displayed for question name
    And Verify "Answer Field can not be left blank" error displayed for answer name
  
    Examples:
        | userType       |Subscription     |
        | "Superuser"    |"Enterprise"     |

