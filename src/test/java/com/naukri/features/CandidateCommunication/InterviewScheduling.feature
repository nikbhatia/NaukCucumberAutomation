@wip
Feature: To verify Interview Scheduling and its headers under mailbox tab for all account types
  @Wip @Mailer
  Scenario Outline: To verify candidate Accepted the Interview Invite sent from recruiter with Interview Accepted header having candidate name and date time in the mailbox tab for all account type
    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Accept the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview accepted
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Acceptance header is visible along with attachments and status change block

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify candidate Rejected the Interview Invite sent from recruiter with Interview Rejection  header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Rejected the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview Rejected
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Rejection header is visible along with attachments and status change block

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |


  @Wip @Mailer
  Scenario Outline: To verify candidate Tentatively Accepted the Interview Invite sent from recruiter with Interview Tentatively Accepted header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Tentatively Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview Tentatively Accepted
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Tentatively Accepted header is visible along with attachments and status change block


    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |


  Scenario Outline: To verify recruiter cancelled the Interview Invite sent to candidate with Interview cancellation header having recruiter name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview-Round 1" stage.
    And User move to Manage your Profile Page
    Then User set alias as "<alias>" .
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User verify the mail count is changed
    Then User add Automatic mailer for "Interview-Round 1" stage.
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    And User move to "<personalMailbox>" of candidate
    When Verify the ics file and cancellation mail from "<personalMailbox>"
    Then Verify the ics file and Interview mail from recruiter
    Then User redirected to cv detail page of candidate
    And  User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview cancellation header is visible with alias as "<alias>" along with attachments and status change block

    Examples:
      | userType      | interviewType    | alias                     | persoanlMailbox |
      | Enterprise    | Face-To-Face     | lokesh.agrawal@naukri.com | outlook         |
      | Enterprise    | Telephonic       | rmstesting                | outlook         |
      | Enterprise    | Video Conference | lokesh.agrawal@naukri.com | outlook         |
      | Company       | Face-To-Face     | rmstesting                | outlook         |
      | Company       | Telephonic       | rmstesting                | outlook         |
      | Company       | Video Conference | rmstesting                | outlook         |
      | ProConsultant | Face-To-Face     | rmstesting                | outlook         |
      | ProConsultant | Telephonic       | rmstesting                | outlook         |
      | ProConsultant | Video Conference | rmstesting                | outlook         |
      | Enterprise    | Face-To-Face     | lokesh.agrawal@naukri.com | gmail           |
      | Enterprise    | Telephonic       | rmstesting                | gmail           |
      | Enterprise    | Video Conference | lokesh.agrawal@naukri.com | gmail           |
      | Company       | Face-To-Face     | rmstesting                | gmail           |
      | Company       | Telephonic       | rmstesting                | gmail           |
      | Company       | Video Conference | rmstesting                | gmail           |
      | ProConsultant | Face-To-Face     | rmstesting                | gmail           |
      | ProConsultant | Telephonic       | rmstesting                | gmail           |
      | ProConsultant | Video Conference | rmstesting                | gmail           |
      | Enterprise    | Face-To-Face     | lokesh.agrawal@naukri.com | yahoo           |
      | Enterprise    | Telephonic       | rmstesting                | yahoo           |
      | Enterprise    | Video Conference | lokesh.agrawal@naukri.com | yahoo           |
      | Company       | Face-To-Face     | rmstesting                | yahoo           |
      | Company       | Telephonic       | rmstesting                | yahoo           |
      | Company       | Video Conference | rmstesting                | yahoo           |
      | ProConsultant | Face-To-Face     | rmstesting                | yahoo           |
      | ProConsultant | Telephonic       | rmstesting                | yahoo           |
      | ProConsultant | Video Conference | rmstesting                | yahoo           |




  @Wip @Mailer
  Scenario Outline: Verify Advance Interview scheduling mailer for candidate sent from recruiter with Interview Accepted header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview - Telephonic Round" stage.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Accept the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview accepted
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Accepted header is visible along with attachments and status change block

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |
  @Wip @Mailer
  Scenario Outline: Verify Advance Interview scheduling mailer for candidate sent from recruiter with Interview Rejection header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview - Telephonic Round" stage.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Rejected the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview Rejected
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Rejected header is visible along with attachments and status change block

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: Verify Advance Interview scheduling mailer for candidate, sent from recruiter with Interview Tentatively Accepted header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview - Telephonic Round" stage.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Tentatively Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview Tentatively Accepted
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Tentatively Accepted header is visible along with attachments and status change block

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: Verify Advance Interview scheduling mailer when recruiter cancel the interview check Interview cancellation header having recruiter alias in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for "Interview - Telephonic Round" stage.
    And User move to Manage your Profile Page
    Then User set alias as "<alias>" .
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User reschedule Interview by clicking on Edit Icon followed by schedule Interview
    And User verify the mail count is changed
    Then User add Automatic mailer for "Interview-Round 1" stage.
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    And User move to "<personalMailbox>" of candidate
    When Verify the ics file and cancellation mail from "<personalMailbox>"
    Then Verify the ics file and Interview mail from recruiter
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview cancellation header is visible with alias as "<alias>" along with attachments and status change block

    Examples:
      | userType      | interviewType    | alias                     | persoanlMailbox |
      | Enterprise    | Face-To-Face     | lokesh.agrawal@naukri.com | outlook         |
      | Enterprise    | Telephonic       | rmstesting                | outlook         |
      | Enterprise    | Video Conference | lokesh.agrawal@naukri.com | outlook         |
      | Company       | Face-To-Face     | rmstesting                | outlook         |
      | Company       | Telephonic       | rmstesting                | outlook         |
      | Company       | Video Conference | rmstesting                | outlook         |
      | ProConsultant | Face-To-Face     | rmstesting                | outlook         |
      | ProConsultant | Telephonic       | rmstesting                | outlook         |
      | ProConsultant | Video Conference | rmstesting                | outlook         |
      | Enterprise    | Face-To-Face     | lokesh.agrawal@naukri.com | gmail           |
      | Enterprise    | Telephonic       | rmstesting                | gmail           |
      | Enterprise    | Video Conference | lokesh.agrawal@naukri.com | gmail           |
      | Company       | Face-To-Face     | rmstesting                | gmail           |
      | Company       | Telephonic       | rmstesting                | gmail           |
      | Company       | Video Conference | rmstesting                | gmail           |
      | ProConsultant | Face-To-Face     | rmstesting                | gmail           |
      | ProConsultant | Telephonic       | rmstesting                | gmail           |
      | ProConsultant | Video Conference | rmstesting                | gmail           |
      | Enterprise    | Face-To-Face     | lokesh.agrawal@naukri.com | yahoo           |
      | Enterprise    | Telephonic       | rmstesting                | yahoo           |
      | Enterprise    | Video Conference | lokesh.agrawal@naukri.com | yahoo           |
      | Company       | Face-To-Face     | rmstesting                | yahoo           |
      | Company       | Telephonic       | rmstesting                | yahoo           |
      | Company       | Video Conference | rmstesting                | yahoo           |
      | ProConsultant | Face-To-Face     | rmstesting                | yahoo           |
      | ProConsultant | Telephonic       | rmstesting                | yahoo           |
      | ProConsultant | Video Conference | rmstesting                | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify candidate Accepted the Interview Invite sent from recruiter via Automatic Mailer and check Interview Accepted header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User add Automatic mailer for "Interview-Round1-TelephonicRound" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1-TelephonicRound" Stage
    Then User Verify success message for mail sent successfully to candidate
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Accept the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview accepted
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    Then User verify Interview Acceptance header is visible along with attachments and status change block

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify candidate Rejected the Interview Invite sent from recruiter via Automatic Mailer and check  Interview Rejected header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User add Automatic mailer for "Interview-Round1-TelephonicRound" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1-TelephonicRound" Stage
    Then User Verify success message for mail sent successfully to candidate
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Rejected the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview Rejected
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    Then User verify Interview Rejected header is visible along with attachments and status change block

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |


  @Wip @Mailer
  Scenario Outline: To verify candidate Tentatively Accepted the Interview Invite sent from recruiter via Automatic Mailer and check  Interview Tentatively Accepted header having candidate name and date time in the mailbox tab for all account type

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User add Automatic mailer for "Interview-Round1-TelephonicRound" stage.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1-TelephonicRound" Stage
    Then User Verify success message for mail sent successfully to candidate
    And User verify the mail count is changed
    And User move to "<personalMailbox>" of candidate
    When Candidate Tentatively Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of candidate for interview Tentatively Accepted
    Then User redirected to cv detail page of candidate
    And User click on mailboxtab
    Then User verify Interview Tentatively Accepted header is visible along with attachments and status change block

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |



  @Wip @Mailer
  Scenario Outline: To verify Hiring Manager accepted the Interview Invite sent via Old Interview Scheduling

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    Then User click on Forward to HM Lightbox
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User move to "<personalMailbox>" of HM
    Then User verify all attachments and content sent by recruiter
    When HM Accept the Interview Invite from personal Mailbox
    And Verify ics file and  calendar of HM for interview Accept
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Acceptance is visible for HM

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify Hiring Manager rejected the Interview Invite sent via Old Interview Scheduling

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    Then User click on Forward to HM Lightbox
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User move to "<personalMailbox>" of HM
    When HM rejected the Interview Invite from personalMailbox
    And Verify ics file and  calendar of HM for interview rejected
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview rejected is visible for HM

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify Hiring Manager Tentatively Accepted the Interview Invite sent via Old Interview Scheduling

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    And User move the Candidate to "Interview - Round 1" Stage and set Interview Type as "<interviewType>"
    Then User click on Forward to HM Lightbox
    And User fill in the subject field as "Updated Subject"
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template and send the Mail
    And User move to "<personalMailbox>" of HM
    When HM Tentatively Accepted the Interview Invite from personal Mailbox
    And Verify ics file and  calendar of HM for interview Tentatively Accepted
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Tentatively Accepted is visible for HM

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: Verify HM Accepted the Interview Invite sent via Advance Interview scheduling By Recruiter

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User move to "<personalMailbox>" of HM
    When HM Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of HM for interview  Accepted
    Then User verify all attachments and content sent by recruiter
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Accepted is visible for HM

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |

  @Wip @Mailer
  Scenario Outline: Verify HM Rejected the Interview Invite sent via Advance Interview scheduling By Recruiter

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User move to "<personalMailbox>" of HM
    When HM Rejected the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of HM for interview  Rejected
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Rejected is visible for HM

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |


  @Wip @Mailer
  Scenario Outline: Verify HM Tentatively Accepted the Interview Invite sent via Advance Interview scheduling By Recruiter

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User remove Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User open cv detail page of first candidate
    Then User move to Mapped Requirement and update Group for "<userType>"
    Then User Update Hiring Managers for Selection stage "Interview - Telephonic Round"
    And User move the Candidate to "Interview - Telephonic Round" Stage .
    And User see Advance Interview scheduling mailbox
    When User select Interview types as "<interviewType>" .
    Then User select the first hm from dropdown to which the mail is send
    And User fill in the location field as "Updated location"
    And User click on customize candidate message
    Then User Attach All Type Of Attachments it supports
    And User fill in the Body field of Mail Template
    Then User click on Schedule Interview
    And User move to "<personalMailbox>" of HM
    When HM Tentatively Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of HM for interview  Tentatively Accepted
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Tentatively Accepted is visible for HM

    Examples:
      | userType      | interviewType    | personalMailbox |
      | Enterprise    | Face-To-Face     | outlook         |
      | Enterprise    | Telephonic       | outlook         |
      | Enterprise    | Video Conference | outlook         |
      | Company       | Face-To-Face     | outlook         |
      | Company       | Telephonic       | outlook         |
      | Company       | Video Conference | outlook         |
      | ProConsultant | Face-To-Face     | outlook         |
      | ProConsultant | Telephonic       | outlook         |
      | ProConsultant | Video Conference | outlook         |
      | Enterprise    | Face-To-Face     | gmail           |
      | Enterprise    | Telephonic       | gmail           |
      | Enterprise    | Video Conference | gmail           |
      | Company       | Face-To-Face     | gmail           |
      | Company       | Telephonic       | gmail           |
      | Company       | Video Conference | gmail           |
      | ProConsultant | Face-To-Face     | gmail           |
      | ProConsultant | Telephonic       | gmail           |
      | ProConsultant | Video Conference | gmail           |
      | Enterprise    | Face-To-Face     | yahoo           |
      | Enterprise    | Telephonic       | yahoo           |
      | Enterprise    | Video Conference | yahoo           |
      | Company       | Face-To-Face     | yahoo           |
      | Company       | Telephonic       | yahoo           |
      | Company       | Video Conference | yahoo           |
      | ProConsultant | Face-To-Face     | yahoo           |
      | ProConsultant | Telephonic       | yahoo           |
      | ProConsultant | Video Conference | yahoo           |


  @Wip @Mailer
  Scenario Outline: To verify HM Accepted the Interview Invite sent from recruiter via Automatic Mailer

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User add Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1" Stage
    Then User Verify success message for mail sent successfully to HM
    And User move to "<personalMailbox>" of HM
    And Verify ics file and  calendar of HM for interview  Accepted
    Then User verify all attachments and content sent by recruiter
    When HM Accept the Interview Invite from "<personalMailbox>"
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Acceptance is visible for HM

    Examples:
      | userType     |
      | Enterprise   |
      | Company      |
      | ProConsultant|

  @Wip @Mailer
  Scenario Outline: To verify HM Rejected the Interview Invite sent from recruiter via Automatic Mailer

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User add Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1" Stage
    Then User Verify success message for mail sent successfully to HM
    And User move to "<personalMailbox>" of HM
    When HM Rejected the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of HM for interview  Rejected
    Then User redirected to cv detail page of candidate
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Rejected is visible for HM

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify HM Tentatively Accepted the Interview Invite sent from recruiter via Automatic Mailer

    Given User login into RMS as "<userType>"
    When User navigate to Settings page
    Then User add Automatic mailer for HM.
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And User move to particular candidate details page
    And User move the Candidate to "Interview-Round1" Stage
    Then User Verify success message for mail sent successfully to HM
    And User move to "<personalMailbox>" of HM
    When HM Tentatively Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and  calendar of HM for interview Tentatively Accepted
    Then User redirected to cv detail page of candidate
    And User check Awaiting Reply for HM
    Then Verify Interview Tentatively Accepted is visible for HM

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |

  @Wip @Mailer
  Scenario Outline: To verify Bulk status change mailers subject and content for Interview Round

    Given User login into RMS as "<userType>"
    When User is on Requirement Inbox page containing multiple applications.
    And User select the checkbox at the top to select all candidate
    And User click on change status option
    Then User should be redirected to the status change lightbox
    Then User Change the status to "Interview-Round1"
    And User enter venue of interview
    Then User click on Update Button.
    Then User click on Send Email Button
    And User fill in the subject field as "Updated Subject"
    And User type in the mail body "testMailBodyText"
    And User attach Multiple attachments to it max ten.
    And User select Email from Reply To option
    And User click on Send button
    And User move to "<personalMailbox>" of candidate
    When Candidate  Accepted the Interview Invite from "<personalMailbox>"
    And Verify ics file and calendar of candidate for interview  Accepted
    Then User redirected to requirement Inbox Page
    And User click on mailboxtab
    And Verify ThreadSubject is displayed as "Updated Subject"
    Then User verify Interview Acceptance is visible for candidate on hover under Awaiting reply Box

    Examples:
      | userType      | personalMailbox |
      | Enterprise    | gmail           |
      | Company       | gmail           |
      | ProConsultant | gmail           |
      | Enterprise    | outlook         |
      | Company       | outlook         |
      | ProConsultant | outlook         |
      | Enterprise    | yahoo           |
      | Company       | yahoo           |
      | ProConsultant | yahoo           |