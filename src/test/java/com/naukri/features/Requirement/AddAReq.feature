Feature: To verify add a requirement functionality from project inbox page

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
    Scenario Outline: To verify Add application with new requirement on project inbox
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    And User gets the Candidate email id of the first candidate
    And User clicks on  Add To Requirement from panel
    Then Verify Add to requirement lightbox is visible
    When User click on Add a new Requirement checkbox
    And User enters name of the requirement
    And User clicks "Add" on  Add a requirement lightbox
    Then User verifies name of the new requirement is displayed on the lightbox
    When User clicks on the requirement name on the lightbox
    Then Verify User redirected to requirement overview page with requirement name
    When User clicks on the application count on requirement overview page
    Then Profile should be displayed on srp page

	Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
      
 
  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: To verify Add application with existing requirement on project inbox
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    And User gets the Candidate email id of the first candidate
    And User clicks on  Add To Requirement from panel
    Then Verify Add to requirement lightbox is visible
    When User selects second requirement from Existing requirments
    And User clicks "Add" on  Add a requirement lightbox
    Then User verifies name of the existing requirement is displayed on the lightbox
    When User clicks on the requirement name on the lightbox
    Then Verify User redirected to requirement overview page with requirement name
    When User clicks on the application count on requirement overview page
    Then Profile should be displayed on srp page

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @RMS @RMSRequirements @RequirementCreation @RMSRequirementReport
  Scenario Outline: verify req id is displayed on add a req lightbox after it is added
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
    #And User choose first address
    And User click on Save and Post Requirement on requirement page
    Then Verify User redirected to requirement overview page
    When User notes the requirement id of the requirement
    And User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    And User clicks on  Add To Requirement from panel
    Then Verify Add to requirement lightbox is visible
    When User click on Add a new Requirement checkbox
    And User enters name of the requirement
    And User clicks "Add" on  Add a requirement lightbox
    Then User verifies name of the existing requirement is displayed on the lightbox
    When User clicks on the requirement name on the lightbox
    Then Verify User redirected to requirement overview page with requirement name
    And Verify the requirement id displayed is correct both on the page and in URL

  	Examples: 
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |
