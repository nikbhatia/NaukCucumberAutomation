Feature: Test Scenarios of RMSPLAT-44 Assessment facets

  @id:1 @ViewAssessment1 @wip
  Scenario: To Verify the facet count when test is sent
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
    #    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    # And User move to newly created or first requirement
    And I login into RMS as an "Enterprise" user
    And I search the "Existing Requirement" on SRP page
    When select a requirement
    #And I create a requirement with existing requirement "Test Requirement"
    #And I am adding a single profile with <CandidateEmail> and add them to a Requirement <RequirementName>
    #| CandidateName  | RequirementName               |
    #| CandidateOne   | Test Requirement0410202014504 |
    #| CandidateTwo   | RequirementName               |
    #| CandidateThree | RequirementName               |
    #| CandidateFour  | RequirementName               |
    #Then I move to Requirement OverviewPage
    Then click on selection stage
    And click on StageName the click on SubStage and attach test to that stages
      | StageName | SubStage | Testname           | SubTest            |
      | Applied   | Matching | Cloud Technologies | Azure Skills Test  |
      | Interview | hello    | Healthcare         | Life Sciences Test |
    #| Applied     | Not Matching       | Microsoft Technologies |Microsoft SharePoint Server 2013 Test |
    #| Interview   | Telephonic Round   | Geography Tests        |Applied Geology Skills Test |
    #|Offer Round | Joining            | Microsoft Technologies |                            |
    Then I move to Requirement Inbox Page
    #And I verify Assessment Tests link is Not visible
    Then I move the <CandidateName> to <StageName>
      | CandidateName | StageName          |
      | CandidateOne  | Applied - Matching |
    #| CandidateTwo   | Telephonic Round        |
    #| CandidateThree | hello        |
    #| CandidateFour  | Matching |
    And refresh the page
    And I verify Assessment Tests link is visible
    Then I click on Assessment Tests link
    And I click on <TestName> and check the checkbox <FacetsName>
      | TestName          | FacetsName     | TupleCount |
      | Azure Skills Test | Test Not Taken |          0 |
      | Azure Skills Test | Test not sent  |          1 |
      | Azure Skills Test | Passed         |          1 |
      | Azure Skills Test | Failed         |          1 |
    When click on folllowing tuple Link
      | Send Test |
    Then I click on Assessment Tests link
    And I click on <TestName> and check the checkbox <FacetsName>
      | TestName          | FacetsName     | TupleCount |
      | Azure Skills Test | Test not sent  |          0 |
      | Azure Skills Test | Passed         |          0 |
      | Azure Skills Test | Failed         |          0 |
      | Azure Skills Test | Test Not Taken |          1 |

  #@id:3 @ViewAssessment @wip
  #Scenario: To  if 2 facets are selected within a Single assessment test - then the condition of OR applies
    #Given I login into RMS as an "Enterprise" user
    #When I move to a perticular Requirement Inbox Page.
    #Then I verify the  profiles are visible.
    #Then I attach test in "any" stage
    #Then I move the candidate to that stage
    #Then I click on "testname" test.
    #Then I click on "percentage" and "Test not sent"checkbox
    #And I verify result is displayed
    #Then I click on send test link.
    #Then I click on "testname" test
    #Then I click on "percentage" and "Test not sent"checkbox
    #And I verify result is not displayed#verify the count in facet in the same method
    #Then I click on "percentage" and "Test Not Taken"checkbox
    #And I verify result is displayed
    #Then I click on "percentage" and "pass"checkbox
    #And I verify result is not displayed
#
  #@id:4 @ViewAssessment @wip 
  #Scenario: To if ALL facets are selected within a single assessment test - then the condition of OR applies
    #Given I login into RMS as an "Enterprise" user
    #When I move to a perticular Requirement Inbox Page.
    #Then I verify the  profiles are visible.
    #Then I attach test in "any" stage
    #Then I move the candidate to that stage
    #Then I click on "testname" test.
    #Then I click on "ALL percentage" and "ALL stages"checkbox
    #And I verify result is displayed
    #And I verify the count in Facet
#
  #@id:5 @ViewAssessment @wip 
  #Scenario: To if 2 facets are selected within a different assessment test - then the condition of AND applies
    #Given I login into RMS as an "Enterprise" user
    #When I move to a perticular Requirement Inbox Page.
    #Then I verify the  profiles are visible.
    #Then I attach test in "any" stage
    #Then I move the candidate to that stage
    #Then I click on "testname" test.
    #Then I click checkbox of "Any" stage
    #Then I click on "percentage" and "Test Sent"checkbox
    #And I verify result is displayed
    #And I verify the count in Facet
#
  #@id:6 @ViewAssessment @wip 
  #Scenario Outline: To if 2 facets are selected within a different assessment test - then the condition of AND applies
    #Given I login into RMS as an "Enterprise" user
    #When I move to a perticular Requirement Inbox Page.
    #Then I verify the  profiles are visible.
    #Then I attach test in "StageName" stage
    #Then I move the candidate to that stage
    #Then I click checkbox of "DifferentStage" stage.
    #Then I click on "percentage" and "TestNotTaken" checkbox
    #And I verify result is not displayed
    #And I verify the count in Facet
#
    #Examples: 
      #| userType   | StageName        | DifferentStage |
      #| Enterprise | Interview-Round1 | Round2         |
      #| Enterprise | Interview-Round2 | Round1         |
      #| Enterprise | Interview-Round3 | Round2         |
      #| Enterprise | Applied Matching | Round1         |
#
  #@id:7 @ViewAssessment @wip 
  #Scenario Outline: To if 2 facets are selected within a different assessment test - then the condition of AND applies
    #Given I login into RMS as an "Enterprise" user
    #When I move to a perticular Requirement Inbox Page.
    #Then I verify the  profiles are visible.
    #Then I attach test in "StageName" stage
    #Then I move the candidate to that stage
    #Then I click "All" checkbox of "SameStage" stage.
    #Then I click on "percentage" and "TestNotTaken" checkbox
    #And I verify result is displayed
    #And I verify the count in Facet
#
    #Examples: 
      #| userType   | StageName        | SameStage |
      #| Enterprise | Interview-Round1 | Round1    |
#
  #@id:8 @ViewAssessment @wip 
  #Scenario: To Verify count of facet if test send and test taken for test1 RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I added 2 test with candidate1
    #Then I click on Test1 inside Assessment Tests
    #Then I click on test not taken
    #Then I click on Test2 inside Assessment Tests
    #Then I click on test taken
    #And Verify test not taken facet as 1
    #And Verify test taken facet as 1
#
  #@id:9 @ViewAssessment @wip 
  #Scenario: To Verify count of facet if test send and test taken for test2 RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I added 2 test with candidate2
    #Then I click on Test1 inside Assessment Tests
    #Then I click on test taken
    #Then I click on Test2 inside Assessment Tests
    #Then I click on test taken
    #And Verify test not taken facet as 0
    #And Verify test taken facet as 2
#
  #@id:10 @ViewAssessment @wip 
  #Scenario: To Verify count of facet if test not taken and test taken for test1 RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I Verify Test1 is displayed
    #And Verify test not taken facet as 1
    #And Verify test taken facet as 1
    #And Verify test not sent facet as 3
#
  #@id:11 @ViewAssessment @wip 
  #Scenario: To Verify count of facet if test not taken and test taken for test2 RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I Verify Test2 is displayed
    #And Verify test not taken facet as 0
    #And Verify test taken facet as 1
#
  #@id:12 @ViewAssessment @wip 
  #Scenario: To Verify count of candidate profile if test not taken and test taken for test1 RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I click on Test1
    #Then I click on test not taken check box
    #Then I click on test  taken check box
    #And Verify result is displayed as 2
#
  #@id:13 @ViewAssessment @wip 
  #Scenario: To Verify count of candidate profile if test1 and Test2  are in test not taken and test taken stage RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I click on Test1
    #Then I click on test not taken check box
    #And I click on Test2
    #Then I click on test not taken check box
    #And Verify result is displayed as 0
#
  #@id:14 @ViewAssessment @wip 
  #Scenario: To Verify count of candidate profile if test1 is in test not taken and test taken stage RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I click on Test1
    #Then I click on test not taken check box
    #Then I click on test taken check box
    #And Verify result is displayed as 1
#
  #@id:15 @ViewAssessment @wip 
  #Scenario: To Verify count of candidate profile if test2 is in test not taken,Invite succesful and test taken stage RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I click on Test2
    #Then I click on invite succesful check box
    #And Verify result is displayed as 1
#
  #@id:16 @ViewAssessment @wip 
  #Scenario: To Verify count of candidate profile if test2 is in test not taken and test taken stage RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I click on Test2
    #Then I click on test taken check box
    #And Verify result is displayed as 0
#
  #@id:17 @ViewAssessment @wip 
  #Scenario: To Verify count of candidate profile if test3 is in test not taken and test taken stage RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 2 single profile with in the same requirement
    #Then I CLick on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I Attach Test1 to the Candidate1 on stage1
    #Then I Attach Test2 to the Candidate1 on stage1
    #Then I Attach Test1 to the Candidate2 on stage1
    #Then I Attach Test2 to the Candidate2 on stage1
    #Then I click on Assessment Tests
    #And I click on Test3
    #Then I click on test taken check box
    #And Verify result is displayed as 1
#
  #@id:18 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when first candidate is moved to Test Attached stage and "Test is not sent" yet RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:19 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when All candidate is moved to Applied Matching stage and Test is not sent yet RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I move the candidate2 to Applied Matching stage
    #Then I move the candidate3 to Applied Matching stage
    #Then I move the candidate4 to Applied Matching stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:20 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when All candidate is moved to their test attached stages  and Test is not sent yet RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I move the candidate2 to Interview1 stage
    #Then I move the candidate3 to Interview2 stage
    #Then I move the candidate4 to Offer stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:21 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when first candidate is moved to Test Attached stage and "Test is sent"  RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:22 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when All candidate is moved to Applied Matching stage and "Test is sent"  RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I move the candidate2 to Applied Matching stage
    #Then I move the candidate3 to Applied Matching stage
    #Then I move the candidate4 to Applied Matching stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:23 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when All candidate is moved to their test attached stages  and "Test is sent"  RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I move the candidate2 to Interview1 stage
    #Then I move the candidate3 to Interview2 stage
    #Then I move the candidate4 to Offer stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:24 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when first candidate is moved to Test Attached stage and "Test Is completed" RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:25 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when All candidate is moved to Applied Matching stage and "Test Is completed" RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I move the candidate2 to Applied Matching stage
    #Then I move the candidate3 to Applied Matching stage
    #Then I move the candidate4 to Applied Matching stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
#
  #@id:26 @ViewAssessment @wip 
  #Scenario: To Verify facet count of all Test when All candidate is moved to their test attached stages  and "Test Is completed" RMSPLAT-44
    #Given I login into RMS as an Enterprise user
    #Then I create 1 requirement
    #Then I add 4 single profile with in the same requirement
    #Then I Attach Test1 to the Candidate1 on Applied Matching
    #Then I Attach Test2 to the Candidate2 on Interview1
    #Then I Attach Test3 to the Candidate3 on Interview2
    #Then I Attach Test4 to the Candidate4 on Offer
    #Then I Click on no of candidate
    #Then I am on Requirement Inbox Page.
    #Then I move the candidate1 to Applied Matching stage
    #Then I move the candidate2 to Interview1 stage
    #Then I move the candidate3 to Interview2 stage
    #Then I move the candidate4 to Offer stage
    #Then I click on Assessment Tests
    #And I click on Test1
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test2
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test3
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
    #And I click on Test4
    #And I click and verify facet count of "Test not sent"
    #And I click and verify facet count of "Test Not Taken"
    #And I click and verify facet count of "Invite Unsuccessful"
    #And I click and verify facet count of "Percentage Score"
