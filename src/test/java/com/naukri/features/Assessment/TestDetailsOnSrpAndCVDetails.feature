Feature: test Details On Srp And CV Details Page (RMSEn-383, 326)

  @TestDetailsOnSrpAndCvDetails @Assessment
  Scenario: To verify the test details on srp and cv details page when test is sent and validating the reminder lightbox
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
    When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
     And User attach a test on substage "Matching" of "Applied" stage on selection stage tab
    And I move to Requirement Inbox Page
    And Move candidate to following stage
      | Applied |
    And reload the page
    Then verify the assessment tuple on srp page
      | Send Reminder |
    When click on folllowing tuple Link
      | Send Reminder |
    And click on following in reminder lightbox
      | NO |
    Then verify the assessment tuple on srp page
      | Send Reminder |

  @TestDetailsOnSrpAndCvDetails @Assessment
  Scenario: To verify that reminder is sent to candidate
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      | assementtestingqa@gmail.com |
    And delete all mail with label "Assessment"
    And reload the page
     When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
      And User attach a test on substage "Matching" of "Applied" stage on selection stage tab
    And I move to Requirement Inbox Page
    And Move candidate to following stage
      | Applied |
    And reload the page
    When click on folllowing tuple Link
      | Send Reminder |
    And click on following in reminder lightbox
      | YES |
    Then verify reminder sent icon is visible on srp page	
    When reload the page
    Then verify the assessment tuple on srp page
      | Send Reminder |
    And User verify that Recipient get the listed mail for specific requirement with label "Assessment"
      | Reminder: Online Assessment Test link for |
      | assessmentTest.html |

  @TestDetailsOnSrpAndCvDetails @Assessment
  Scenario: To verify that when candidate completed the test, results should appear on the SRP Page
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      | assementtestingqa@gmail.com |
    And delete all mail with label "Assessment"
    When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
    And click on selection stage
    And  click on "Applied" stage on selection stages tab
    And User click on substage "Matching" of "Applied" stage on selection stage tab
    And click on test icon
    And select first test
    And click on attach test
    And I move to Requirement Inbox Page
    And Move candidate to following stage
      | Applied |
    When click on folllowing tuple Link
      | Send Test |
    #And click on following in reminder lightbox
      #| YES |
    When reload the page
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

  @TestDetailsOnSrpAndCvDetails @Assessment
  Scenario: To verify that we land to srp page and test is not sent if we click on No in the confirmation lightbox
    Given User adds a single profile to a new requirement through API for "Enterprise" user
      |  |
     When User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    And User move to newly created or first requirement
    And click on selection stage
    And  click on "Applied" stage on selection stages tab
   And User click on substage "Matching" of "Applied" stage on selection stage tab
    And click on test icon
    And select first test
    And click on attach test
    And I move to Requirement Inbox Page
    And Move candidate to following stage
      | Applied |
    Then verify the assessment tuple on srp page
      | Send Test |
    When click on folllowing tuple Link
      | Send Test |
    Then verify the assessment tuple on srp page
      | Send Reminder |



  #@Test5
  # Note : Cannot automate the same
  Scenario: 
    To verify that mail is not sent to candidate if the quota is not available


  #Given I am on requirement listing page
  #When select a requirement
  #And click on selection stage
  #And click on following stage
  #| Applied |
  #And click on Not Matching
  #And click on test icon
  #And select first test
  #And enter the activation period as "5" hours
  #And click on attach test
  #And create a candidate and move it to applied matching stage
  #And click on send test
  #Then If the test credits are not available then validate the lightbox labelled test cannot be sent to candidate
  #When click on okay in test cannot be set to candidate lightbox
  #Then we must land to srp page
  #And validate the updated tuple message
  #And send test should be disabled
  #@Test7
  #Scenario:
  #To verify that mail is sent to candidate if we click on resend in resend lightbox
  #
  #Given I am on requirement listing page
  #When select a requirement
  #And click on selection stage
  #And click on following stage
  #| Applied |
  #And click on Not Matching
  #And click on test icon
  #And select first test
  #And enter the activation period as "5" hours
  #And click on attach test
  #And create a candidate and move it to applied matching stage
  #And click on send test
  #And The candidate attempts the test and score is also calculated
  #And reload the srp page
  #And click on resend test
  #And click on resend
  #Then test should be sent to candidate
  #When The candidate attempts the test and score is also calculated
  #Then the test results and score should be removed from srp and cv details page
  #And verify the assessment tuple on srp page and cv details page
  #And the recent test result should be displayed on srp and cv details page
  #When navigate to requirement dashboard
  #And click on candidate assessment
  #And click on applied marching stage
  #Then the recent test report should be visible on dashboard and the previous one should be removed
  #not automatable
  #@TagActivationPeriodCrossed
  #Scenario:
  #Displaying 'Test Not Taken' info on SRP when the activation period of the test has crossed
  #
  #Given I am on requirement listing page
  #When select a requirement
  #And click on selection stage
  #And click on following stage
  #| Applied |
  #And click on Not Matching
  #And click on test icon
  #And select first test
  #And enter the activation period as "1" hours
  #And click on attach test
  #And create a candidate and move it to applied matching stage
  #And click on send test
  #Then After 1 hour the test should be expired when the candidate do not take up the test
  #And resend test link along with the helptext should be visible on srp page
  #And test not taken should be visible on the tuple
  #@Tag
  #Scenario:
  #Displaying 'Test Not Taken' info on SRP when the candidate has crossed the maximum no of retries possible
  #
  #Given I am on requirement listing page
  #When select a requirement
  #And click on selection stage
  #And click on following stage
  #| Applied |
  #And click on Not Matching
  #And click on test icon
  #And select first test
  #And click on attach test
  #And create a candidate and move it to applied matching stage
  #And click on send test
  #And the candidate has crossed the maximum no of retries possible
  #Then resend test link along with the helptext should be visible on srp page
  #And test not taken should be visible on the tuple
  #@Test9
  #Scenario:
  #Test is attached to interview stage then the assessment tuple will be displayed below interview stage details
  #
  #Given I am on requirement listing page
  #When select a requirement
  #And click on selection stage
  #And click on interview round 1
  #And click on test icon
  #And select first test
  #And click on attach test
  #And create a candidate and move it to interview round 1
  #And enter the location , time , date of the interview round and click on set
  #Then the assessment tuple should be visible under interview tuple
 