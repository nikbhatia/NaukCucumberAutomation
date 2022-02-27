Feature: Candidate Assessment

  @CandidateAssessment @Assessment
  Scenario Outline: To verify that user is able to see all the headings and buttons in select test flow for "<userType>"
    Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And User clicks on Candidate Assessment Tab
    Then Verify that user is able to see the Add candidate button on candidate assessment page
    When User clicks on add candidate assessment button
    Then Verify that user is able to see the listed headings on page
      | Add Assessment Test     |
      | Configure the test here |
    When select first test
    Then Verify that user is able to see the listed headings on page
      | Change Test                                                      |
      | Configure Test Settings at Stage                                 |
      | Selected Stage                                                   |
      | Test Link Validity                                               |
      | Trigger test automatically when candidate is moved to this stage |
      | Monitor Candidate using Webcam                                   |
      | Restrict Candidate from Switching Tabs                           |
    When click on "CANCEL" button in bottom
    Then Verify that user is able to see the Add candidate button on candidate assessment page

    Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant |

  @CandidateAssessment @Assessment
  Scenario Outline: To Verify the order of Global stages and Selection stage DD for "<userType>"
    Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And "<userType>" User Sets all the stages on customize the selection process page
    And User is on "requirementInbox" page
    And User move to newly created or first requirement
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    Then Verify that user is able to see all the stages in Selected Stage DD

    Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant |

  @CandidateAssessment @Assessment
  Scenario Outline: To verify that user is able to see the tuples on SRP page and able to do the operations for "<userType>"
    Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    Then Verify that user is able to see the test name in headings on Selected Assessment Test
    And User attach a test on "Applied-Matching" stage when using selction stage DD to select stage
    And click on attach test
    And I move to Requirement Inbox Page
    And Move candidate to following stage
      | Applied |
    Then verify the assessment tuple on srp page
      | Send Test |
    And delete all mail with label "Assessment"
    When click on folllowing tuple Link
      | Send Test |
    And reload the page
    Then verify the assessment tuple on srp page
      | Send Reminder |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Online Assessment Test link for |
      | assessmentTest.html | 
    And delete all mail with label "Assessment"
    When click on folllowing tuple Link
      | Send Reminder |
    And click on following in reminder lightbox
      | YES |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Reminder: Online Assessment Test link for |
      | assessmentTest.html |

    Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant |

  @CandidateAssessment @Assessment
  Scenario Outline: To verify that when candidate of "<userType>" user completed the test, results should appear on the SRP Page
    Given User adds a single profile to a new requirement through API for "<userType>" user
      | assementtestingqa@gmail.com |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And delete all mail with label "Assessment"
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    And click on send test automatically to candidate
    Then Verify that user is able to see the test name in headings on Selected Assessment Test
    And User attach a test on "Applied-Matching" stage when using selction stage DD to select stage
    And click on attach test
    And I move to Requirement Inbox Page
    And Move candidate to following stage
      | Applied |
    And reload the page
    Then verify the assessment tuple on srp page
      | Send Reminder |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
	      | Online Assessment Test link for |
	      | assessmentTest.html |
	  And User launch mail content in browser
	    | assessmentTest.html |
    And Candidate attempt the test
    And User close the current tab and switch to parent tab
    Then verify result on Srp

    Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant |

  @CandidateAssessment @Assessment
  Scenario Outline: To verify that "<userType>" user is able to see the stage added from global cofiguration settings after adding Asssement
    Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And "<userType>" user navigated to customized selection stage page
    And User added a stage on customized section stage page
    Then Verify that user is able to "Add" the stage on customized selection page
    When User is on "requirementInbox" page
    And User move to newly created or first requirement
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    Then Verify that stage is "Added" from customize selected process page reflected to Selected Stage DD
    When "<userType>" user navigated to customized selection stage page
    And User deleted the added stage from customized section stage page
    Then Verify that user is able to "Delete" the stage on customized selection page
    When User is on "requirementInbox" page
    And User move to newly created or first requirement
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    Then Verify that stage is "deleted" from customize selected process page reflected to Selected Stage DD

    Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant |

  @CandidateAssessment @Assessment
  Scenario Outline: To verify that "<userType>" user is able to view/edit/remove the test on a stage
    Given User adds a single profile to a new requirement through API for "<userType>" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "<userType>" user
    And User move to newly created or first requirement
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    And User attach a test on "Applied-Matching" stage when using selction stage DD to select stage
    And click on attach test
    Then Verify that user is able to view the test on "Applied-Matching" stage on Candidate Assessment Page Grid
    When User click on "Edit" button on Candidate Assessment Page Grid
    Then Verify that user is able to see the listed headings on page
      | Edit Assessment Test Settings |
      | Configure the test here       |
    And click on "CANCEL" button in bottom
    And User select "YES" in light box
    When User click on "Remove" button on Candidate Assessment Page Grid
    And User accept to remove the test
    Then Verify that Test is displying in inactive tests History

    Examples: 
      | userType      |
      | Enterprise    |
      | Company       |
      | ProConsultant |
