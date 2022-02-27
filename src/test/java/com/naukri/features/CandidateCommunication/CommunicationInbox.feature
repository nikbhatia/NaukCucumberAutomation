Feature: Test Scenarios of Communication Inbox Page

  Author: nikhil.bhatia@naukri.com

  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify when user selects or delets Group from filter DD List on CC inbox page or filter lightbox then same should reflect on both in CC inbox page and in All Filter Lightbox and compares the same
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User clicks on "Group" Filter
    And   User enter "Group" name in search box and select the same
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|.GroupCheckForCC|
    And   User clicks on "Apply" button in conformation box
    And   User clicks on "Group" Filter
    Then  User verifies below items should be "checked" in DD list
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|.GroupCheckForCC|
    When  User clicks on "All filters" Filter
    Then  User Verifies "Group" is displayed in "third" layer of All Filter Lightbox
    And   User Verifies "Group" is displayed in "first" layer of All Filter Lightbox
    When  User stores the values of "Group" filter from the third layer of All Filter
    Then  User Verify values of chip and "Group" filter
    When  User clicks on "Group" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "checked" in DD list
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|.GroupCheckForCC|
    When  User deletes below values from All filters lightbox
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|.GroupCheckForCC|
    And  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    And   User clicks on "Group" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "unchecked" in DD list
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|.GroupCheckForCC|
    And   User clicks on "Apply" button in conformation box
    And   User clicks on "Group" Filter
    Then  User verifies below items should be "unchecked" in DD list
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|.GroupCheckForCC|
    Examples:
      | userType      |
      | Enterprise2    |
#      |Company        |


  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify when user selects or delets Requirement from filter DD List on CC inbox page or filter lightbox then same should reflect on both in CC inbox page and in All Filter Lightbox and compares the same
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User clicks on "Requirement Name" Filter
    And   User enter "Requirement Name" name in search box and select the same
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    And   User clicks on "Apply" button in conformation box
    And   User clicks on "Requirement Name" Filter
    Then  User verifies below items should be "checked" in DD list
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    When  User clicks on "All filters" Filter
    Then  User Verifies "Requirement Name" is displayed in "third" layer of All Filter Lightbox
    And   User Verifies "Requirement Name" is displayed in "first" layer of All Filter Lightbox
    When  User stores the values of "Requirement Name" filter from the third layer of All Filter
    Then  User Verify values of chip and "Requirement Name" filter
    When  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "checked" in DD list
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    When  User deletes below values from All filters lightbox
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    And   User clicks on "Group" Filter in the first layer of All Filter lightbox
    And   User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "unchecked" in DD list
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    And   User clicks on "Apply" button in conformation box
    And   User clicks on "Requirement Name" Filter
    Then  User verifies below items should be "unchecked" in DD list
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|

    Examples:
      | userType      |
      | Enterprise2    |
#      |Company        |

  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify user is able to see all values of Others Filter in the third layer of All Filter lightbox ,which are selected from the second layer of All Filter lightbox
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When   User clicks on "All filters" Filter
    And  User clicks on "Others" Filter in the first layer of All Filter lightbox
    And   User enter "Others" name in search box and select the same
      |Mails on Master Profile|Mails on Unmapped applications|Unread Mails|My Mails|
    And   User stores the values of "Others" filter from the third layer of All Filter
    Then  User Verify values of chip and "Others" filter
    When  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    And   User clicks on "Others" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "checked" in DD list
      |Mails on Master Profile|Mails on Unmapped applications|Unread Mails|My Mails|
    When  User deletes below values from All filters lightbox
      |Mails on Master Profile|Mails on Unmapped applications|Unread Mails|My Mails|
    And   User clicks on "Group" Filter in the first layer of All Filter lightbox
    And   User clicks on "Others" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "unchecked" in DD list
      |Mails on Master Profile|Mails on Unmapped applications|Unread Mails|My Mails|

    Examples:
      | userType      |
      | Enterprise2    |
#      |Company        |


  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify user is able to see all values of Mail Type Filter in the third layer of All Filter lightbox ,which are selected from the second layer of All Filter lightbox
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User clicks on "All filters" Filter
    And   User enter "Mail Type" name in search box and select the same
      |Requirement|Message|Interview Invite|Documents Requested|Offers|Assessments|Status Change Email|
    And   User stores the values of "Mail Type" filter from the third layer of All Filter
    Then  User Verify values of chip and "Mail Type" filter
    When  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    And   User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    Then  User verifies below items should be "checked" in DD list
      |Requirement|Message|Interview Invite|Documents Requested|Offers|Assessments|Status Change Email|
    When  User deletes below values from All filters lightbox
      |Requirement|Message|Interview Invite|Documents Requested|Offers|Assessments|Status Change Email|
    And  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    And   User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    Then User verifies below items should be "unchecked" in DD list
      |Requirement|Message|Interview Invite|Documents Requested|Offers|Assessments|Status Change Email|
    And  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
    And   User clicks on "Mail Type" Filter in the first layer of All Filter lightbox
    And  Verify on hover user should see "Does not include Offers & Interview" on "Status Change Email"

    Examples:
      | userType      |
      | Enterprise2    |
#      |Company        |


  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify user is able to see 'Group','Requirement Name','Applied Filters:','Clear All','Unread','My Mails','All Filter' on CC page and 'Group','Requirement Name','Mail Type','Others' in All Filter lightbox
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    Then  User Verifies "Group" is displayed on CC Inbox page
    And   User Verifies "Requirement Name" is displayed on CC Inbox page
    And   User Verifies "Unread" is displayed on CC Inbox page
    And   User Verifies "My Mails" is displayed on CC Inbox page
    And   User Verifies "All filters" is displayed on CC Inbox page
    When   User clicks on "Group" Filter
    And   User enter "Group" name in search box and select the same
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|
    And   User clicks on "Apply" button in conformation box
    And   User clicks on "Requirement Name" Filter
    And   User enter "Requirement Name" name in search box and select the same
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    And   User clicks on "Apply" button in conformation box
    And   User Verifies "Applied Filters:" is displayed on CC Inbox page
    And   User Verifies "Clear All" is displayed on CC Inbox page
    When  User clicks on "All filters" Filter
    Then  User Verifies "Group" is displayed in "first" layer of All Filter Lightbox
    And   User Verifies "Requirement Name" is displayed in "first" layer of All Filter Lightbox
    And   User Verifies "Others" is displayed in "first" layer of All Filter Lightbox
    And   User Verifies "Mail Type" is displayed in "first" layer of All Filter Lightbox
    And   User Verifies "Requirement Name" is displayed in "third" layer of All Filter Lightbox
    And   User Verifies "Group" is displayed in "third" layer of All Filter Lightbox
    Examples:
      | userType      |
      | Enterprise2    |
#      |Company        |

#  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
#  Scenario Outline: Verify DD List both on CC Inbox Page and All Filter lightbox is in Alphabetical order
#    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
#    When  User clicks on "Group" Filter
#    Then  User Verify DD list is in alphabetical order
#    When  User clicks on "Requirement Name" Filter
#    Then  User Verify DD list is in alphabetical order
#    When  User clicks on "All Filters" Filter
#    And   User clicks on "Group" Filter in the first layer of All Filter lightbox
#    Then  User Verify DD list is in alphabetical order
#    When  User clicks on "Requirement Name" Filter in the first layer of All Filter lightbox
#    Then  User Verify DD list is in alphabetical order
#
#
#    Examples:
#      | userType      |
#      | Enterprise    |
#      |Company        |


  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify User created a new group and it should be visible in DD list of group
    Given User login to the application "groupListing" using "Superuser" of "<userType>" user
    When  User click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And  user Select Recruiters & Hiring Managers and fill all other details
    And  user click on "SAVE" button
    And  User is on "CCInboxPage" page
    And  User clicks on "Group" Filter
    Then User Verify User is able to see "Group" name in the DD List

    Examples:
      | userType      |
      | Enterprise   |
#      |Company        |

  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify user should see not found in DD List when user provides group ,req name which doesn't exists in DD List
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User clicks on "Group" Filter
    Then  User verify when provides name in search area which doesn't exists should get not found in DD List
      |skhdfjshgj|khfksg|
    When  User clicks on "Requirement Name" Filter
    Then  User verify when provides name in search area which doesn't exists should get not found in DD List
      |skhdfjshgj|khfksg|

    Examples:
      | userType      |
      | Enterprise2   |
#      |Company        |

  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify more link on CC Inbox Page
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User clicks on "Group" Filter
    And   User enter "Group" name in search box and select the same
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|GroupzbQwXpsOHA|GroupzbxbxwfjU|TestGroup 1593531423402|
    And   User clicks on "Apply" button in conformation box
    Then  Verify user is able to see "1" link on CC Inbox Page
    And   Verify below chiplist is displayed on CC Inbox page
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|GroupzbQwXpsOHA|GroupzbxbxwfjU|
    Examples:
      | userType      |
      | Enterprise2    |
#      |Company        |

  @RMS @RMSCCInboxFilterPage  @FilterTestCase @Wip @RMSCCInbox
  Scenario Outline: Verify when user selects Group/Requirement from DD List and again deselect them and refresh the page than user should see "Recently Used" and searched Group/Requirement in Recently Used in DD
    Given User login to the application "CCInboxPage" using "Superuser" of "<userType>" user
    When  User clicks on "Group" Filter
    And   User enter "Group" name in search box and select the same
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|
    And   User clicks on "Apply" button in conformation box
    And   User reload the page.
    And   User clicks on "Group" Filter
    Then   User Verifies "Recently Used" is displayed on CC Inbox page
    And   User Verifies below values should be displyed in recently used section in DD List
      |anygroup|AFTER MLH LIVE|yDufIlYEmJGroup|
    When  User clicks on "Requirement Name" Filter
    And   User enter "Requirement Name" name in search box and select the same
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|
    And   User clicks on "Apply" button in conformation box
    And   User reload the page.
    And   User clicks on "Requirement Name" Filter
    Then  User Verifies "Recently Used" is displayed on CC Inbox page
    And   User Verifies below values should be displyed in recently used section in DD List
      |Requirement CC inbox vendor|Requirement CC Inboxxx Vendor|CCMailboxTestRequirement 1598429226778|

    Examples:
      | userType      |
      | Enterprise2    |


