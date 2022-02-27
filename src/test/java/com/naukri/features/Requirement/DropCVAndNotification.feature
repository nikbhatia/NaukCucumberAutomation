Feature: Drop cv functionality and notifications on dashboard

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify functionality of creating a new category with questionaire attached
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And User clicks on Add a new category
    And User enters name of category
    And User enters new email id to forward response
    Then Verify email is added to forward response
    And User clicks on Add new questionaire
    Then User verify the questionaire lightbox is opened
    When User enters questionaire name
    And User clicks on Add New Question
    And User enters Question and selects "Radio Button"
    And User enters "test ques 1a" and "test ques 1b " under answers
    And User clicks on Save Question
    And User clicks on Save questionaire
    And user clicks on save custom category
    Then verify category should be displayed under category listing

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise2"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify adding existing questionaire to a new category
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And User clicks on Add a new category
    And User enters name of category
    And User clicks on Add new questionaire
    Then User verify the questionaire lightbox is opened
    When User enters questionaire name
     When User selects first existing questionaire
    And User clicks on Save questionaire
    And user clicks on save custom category
    Then verify category should be displayed under category listing
    And user clicks on "Edit" category
    Then Verify first questionaire name should be displayed
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise2"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify remove questionaire functionality from category
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And User clicks on Add a new category
    And User enters name of category
    And User clicks on Add new questionaire
    Then User verify the questionaire lightbox is opened
    When User enters questionaire name
    When User selects first existing questionaire
    And User clicks on Save questionaire
    Then Verify first questionaire name should be displayed
    When user removes the questionaire from category
    Then Verify Questionaire is removed and Add new button is visible

    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise2"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify category is searchable on listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And User clicks on Add a new category
    And User enters name of category
    And user selects any existing questionaire from DD on category creation
    And user clicks on save custom category
    Then verify category should be displayed under category listing
    When user enters category name under quick search
    Then verify category should be displayed under category listing
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise2"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify category can be edited from listing page
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And User clicks on Add a new category
    And User enters name of category
    And user selects any existing questionaire from DD on category creation
    And user clicks on save custom category
  Then verify category should be displayed under category listing
    And user clicks on "Edit" category
    And update the category name on lightbox
    And user clicks on save custom category
    Then verify category should be displayed under category listing
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise2"     |

  @done @run @testReport123 @RMSRequirements  @statusRequirement
  Scenario Outline: To verify close functionality of category
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And User clicks on Add a new category
    And User enters name of category
    And user selects any existing questionaire from DD on category creation
    And user clicks on save custom category
    Then verify category should be displayed under category listing
    And user clicks on "Close" category
    And user confirms to close category
    Then Verify category is closed and status is changed to reopen
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise2"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify user able to see reponses to category  created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    And user selects category with applications mapped "Report CHeck 95"
    Then Verify project inbox page is displayed and application is visible
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @done @run @testReport123 @RMSRequirements
  Scenario Outline: To verify 2 tabs career site and referral displayed on  drop cv
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "CVs dropped on Careersite" under "Profiles"
    Then Verify career site and referral both are displayed on drop cv listing page
    Examples:
      | userType       |Subscription     |
      | "Superuser"    |"Enterprise"     |

  @done @fail
  Scenario: To verify requirement assigned notification is displayed on dashboard
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
    And I logout
    And I am logged in with "Enterprise" user "subuser3"
    When user click on recruitement solutions link
    Then verify requirement assigned notification is displayed on dashboard

  #already coverd in hm rename feature
  Scenario: To verify hm removed from requirement notification is displayed on dashboard


