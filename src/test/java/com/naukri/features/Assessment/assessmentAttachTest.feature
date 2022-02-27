Feature: Assessment Attach Test(319, 320, 388, 328)

  Background: Recruiter is attaching the test at applied stage
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
    And click on selection stage
    And  click on "Applied" stage on selection stages tab

  @AssessmentAttachTest @Assessment
  Scenario: Verify that attach test icon is displayed and user is able to attach a test
    When User click on substage "Matching" of "Applied" stage on selection stage tab
    Then apply test icon should be visible
    When click on test icon
    And Recuiter attach the test
    And  click on "Applied" stage on selection stages tab
    Then test should be visible on requirement dashboard

  @AssessmentAttachTest @Assessment
  Scenario: Verify the scrolling functionality on test selection stage
    When User click on substage "Matching" of "Applied" stage on selection stage tab
    And click on test icon
    And get the total no of tests
    Then Verify that total number of tests is visible
    And click on category name
    And verify that category name, time taken, questions heading should be visible
    And verify first 5 tests are visible
    And verify the view n more tests in this category and view all the tests
    And verify the total no of tests matches the count of tests

  @AssessmentAttachTest @Assessment
  Scenario: To verify the search functionality and cancel functionality on test
    listing page

    Given User click on substage "Matching" of "Applied" stage on selection stage tab 
    When click on test icon
    And Enter "applied geology" in searchbar
    Then verify test results of "Applied Geology" is correct
    When click on "CANCEL" button in bottom
    Then it should take me to the previous page without mapping the selected test to the stage

  @AssessmentAttachTest @Assessment @Smoke
  Scenario: To verify the static data visible on configuring test settings page
    is displayed correctly or not

    Given User click on substage "Matching" of "Applied" stage on selection stage tab
    When click on test icon
    And select first test
    Then configuring test settings page should be displayed
    When click on attach test
    And  click on "Applied" stage on selection stages tab
    And click on edit icon
    Then I should see labels such as send test automatically,restrict multiple tabs,monitor webcam usage
    When click on send test automatically to candidate
    Then default value of no of candidates allowed should be 50

  @AssessmentAttachTest @Assessment
  Scenario: To verify that activation period cannot be greater than 365 days and
    the no of candidates allowed cannot be greater than the quota left

   Given User click on substage "Matching" of "Applied" stage on selection stage tab
    When click on test icon
    And select first test
    And clear the activation period value
    And enter "366" days
    Then error should be displayed that maximum activation period can be 1-365 days and 0-23 hours
    When clear the activation period value
    And enter "1" day and "25" hours
    Then error should be displayed that maximum activation period can be 1-365 days and 0-23 hours
    #When clear the activation period value
    # And enter "1" day and "2" hours
    #And click on send test automatically to candidate
    #And enter the no of candidates allowed more than the total credits allotted
    #Then the error message should be displayed that the no of candidates cannot be greater than the credits available

  @AssessmentAttachTest @Assessment
  Scenario: To verify that edit test settings and delete test functionality at
    any stage

   Given User click on substage "Matching" of "Applied" stage on selection stage tab
    When click on test icon
    And select first test
    And click on send test automatically to candidate
    And enter no of candidates allowed to be "3"
    And click on attach test
    And click on selection stage
    And  click on "Applied" stage on selection stages tab
    And click on edit icon
    Then verify all the initial configured settings should be prefilled candidates should be "3"
    And verify the label of the page
    When click on the back button
    Then we should get redirected to requirement dashboard

  @AssessmentAttachTest @Assessment
  Scenario: delete the value in activation period , by default the value will be
    set as 10 days
   Given User click on substage "Matching" of "Applied" stage on selection stage tab
    When click on test icon
    And select first test
    And delete the value in activation period
    And click on attach test
    And click on "Applied" stage on selection stages tab
    And click on edit icon
    Then the value in activation period should be displayed as 10

  #@AssessmentAttachTest
  #Scenario: To verify that that when test is sent to candidate the test credits
  #pending should get increased by 1
  #Given User adds a single profile to a new requirement through API for "Enterprise" user
  #| assementtestingqa@gmail.com |
  #And delete all mail with label "Assessment"
  #And reload the page
  #When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
  #And User move to newly created or first requirement
  #And User attach a test on following stage
  #| Applied |
  #And Recruiter Navigated to requirement SRP Page
  #And Move candidate to following stage
  #| Applied |
  #And reload the page
  #And Candidate Read the mail
  #And Candidate attempt the test
  #And Navigate to admin dashboard
  #Then verify that credits pending to be consumed should be decreased by 1
  #And verify that credits available should be decreased by 1
  #And verify that credits consumed should be increased by 1
  # to be completed
  Scenario: To verify that the no of candidates allowed are less than the
    candidates in requirement then for the rest candidates the mails will not go 
    automatically rather a send mail link will be visible

    Given I am on requirement listing page
    When select a requirement
    And click on selection stage
    And click on following stage
      | Applied |
    And click on Not Matching
    And click on test icon
    And select first test
    And click on send test automatically to candidate
    And enter no of candidates allowed to be "1"
    And click on attach test
    And create 2 candidates and move their status to applied matching
    Then error message will be displayed and no mail will be sent

  # to be completed
  Scenario: If half of the candidates have been sent test and later the no of
    candidates is decreased in the test settings then error should come

    Given I am on requirement listing page
    When select a requirement
    And click on selection stage
    And click on following stage
      | Applied |
    And click on Not Matching
    And click on test icon
    And select first test
    And click on send test automatically to candidate
    And enter no of candidates allowed to be "3"
    And click on attach test
    And create 2 candidates and move their status to applied matching
    And navigate to requirement dashboard
    And click on edit settings
    And enter no of candidates allowed to be "1"
    Then the error message should be displayed showing 2 have already been sent the test

  #not possible
  Scenario: To verify that if restrict multiple tabs is selected then the
    candidate can take the maximum 2 retries

    Given I am on requirement listing page
    When select a requirement
    And click on selection stage
    And click on following stage
      | Applied |
    And click on Not Matching
    And click on test icon
    And select first test
    And click on attach test
    And select the restrict multiple tabs checkbox
    And click on send test automatically to candidate
    And enter no of candidates allowed to be "3"
    And click on attach test
    And create a candidate and move its status to applied matching
    And candidate clicks on attempt test
    And the candidate opens another tab and returns to the test taking window thrice
    Then the test should get expired and the candidate should not be allowed to attempt the rest of questions
