Feature: Requisition id feature

  @done @testReport123 @RMSRequirements
  Scenario: To verify requisition id is generated  according to series set
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout of RMS
    Given "Enterprise" user is on Settings Page with "HiringManager1"
    And User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
    Then verify requisition is created with requisition id set on listing page
    And Verify User see same Requisition Id as set in Settings in Success Message on Requisition Listing



  @done @testReport123 @RMSRequirements
  Scenario: To verify Requisition id is displayed on listing page along with requisition on all the required tabs
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout of RMS
    #Given "Enterprise" user is on Settings Page with "HiringManager1"
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    And User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
    When I switch to tab "Requisitions Raised by You"
 #   When User clicks on "Requisition raised by you" tab on requisition listing page
 #   Then verify requisiton id along with requisition name displayed on "Requisition raised by you" tab
  Then verify requisition is created with requisition id set on listing page

  @done @testReport123 @RMSRequirements
  Scenario: To verify requisition details on requisition overview page
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout of RMS
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    When User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
    And user clicks on the requisition link
    Then Verify Requisiton details on requisition overview page
    And verify requsition status "Pending For Requirement", hr spoc, group, raised by you field
    And verify requisition id on overview page
    And verify the url contains requisition id on requisition overview page

  @done @testReport123 @RMSRequirements
   Scenario: HM spoc raise requisition (to check approve functionality)
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process "test approver"
    And I logout

  @done @testReport123 @RMSRequirements
    Scenario: To verify approver approves requisition (to check approve functionality)
      Given User login to the application "settingsPage" using "Superuser1" of "approver1" user
      And User is on "RMSRequisitionList" page
      And user clicks on the requisition link
      Then Verify Requisiton details on requisition overview page
      And verify status of requisition is "Approval Pending"
      When Approver approves the requisition on overview page
      Then Verify the requisition strip "Requisition Approved"

  @done @testReport123 @RMSRequirements
      Scenario: To verify requisition is approved by all and create requisition , withdraw button visible on overview page (to check approve functionality)
        Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
        And User is on "RMSRequisitionList" page
        When I switch to tab "Requisitions Ready for Creation"
        And user clicks on the requisition link
        Then verify status of requisition is "Approval Completed"
        And Verify that "Create Requirement" button is displayed for requirement on overview page
        And Verify that "Withdraw" button is displayed for requirement on overview page

  @done @testReport123 @RMSRequirements
  Scenario: HM spoc raise requisition (to check reject functionality)
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process "test approver"
    And I logout

  @done @testReport123 @RMSRequirements
  Scenario: To reject requisition by approver (to check reject functionality)
    Given User login to the application "settingsPage" using "Superuser1" of "approver1" user
    And User is on "RMSRequisitionList" page
    And user clicks on the requisition link
    And Approver rejects the requisition on overview page


  @done  @run @testReport123 @RMSRequirements
  Scenario: To verify reject requisition functionality from requisition overview page (to check reject functionality)
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    And User is on "RMSRequisitionList" page
    When I switch to tab "Requisitions Awaiting Others Approval"
    And user clicks on the requisition link
    Then verify status of requisition is "Approval Rejected"
    And Verify that "Create Requirement" button is not displayed for requirement on overview page
    And Verify that "Withdraw" button is displayed for requirement on overview page

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify the list of approvers in requisition is displayed on overview page
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process "test approver"
    And I logout
    Given User login to the application "settingsPage" using "Superuser1" of "approver1" user
    And User is on "RMSRequisitionList" page
    And user clicks on the requisition link
    And verify Current Approval Stage is "recruter@yopmail.com"

  @done @run @testReport123 @RMSRequirements
  Scenario: To create a requisition series (search basedon requisition id on listing page)
  Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And I logout of RMS

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify search basedon requisition id on listing page (search basedon requisition id on listing page)
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    And User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
  #  Then verify requisition is created with requisition id set on listing page
    When User is on "RMSHMRequisitionList" page
    When user searches for the requisition with requisition id
    Then verify requisition is searched based on requisition id

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify withdraw fucntionality on requisition overview page
    Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    And User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
    And user clicks on the requisition link
    When User click on "Withdraw" button on requisition overview page
    And User click on "Yes" button
    And I logout
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    And User is on "RMSRequisitionList" page
    When I switch to tab "All Other Requisitions"
    When user clicks on the requisition link
    And Verify that "Create Requirement" button is not displayed for requirement on overview page
    Then verify status of requisition is "Withdrawn"


  @done @run @testReport123 @RMSRequirements
  Scenario: To verify requisition details tab is displayed on requirement preview page
   # Given User login to the application "settingsPage" using "Superuser1" of "HM1" user
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
  #  Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    Then Verify created requisition is displayed
    When user clicks on the requisition link
    Then Verify that "Create Requirement" button is displayed for requirement on overview page
    When I create requirement for raised requisition
    And User click on Requirement Overview button on success message
    Then Verify Requistion Details tab is visible on requirement overview page


  @done @run @testReport123 @RMSRequirements
  Scenario: To create a requisition id series (requirement search through requisition id )
    When I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout of RMS

  @done @run @testReport123 @RMSRequirements
  Scenario: To create a requisition (requirement search through requisition id )
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify requirement is searchable from requisition id (requirement search through requisition id )
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    Then Verify created requisition is displayed
    When I create requirement for raised requisition
    And User click on Requirement Overview button on success message
    When User navigate through GNB to "All Requirements" under "Requirements"
    When user search basis the requisition id on project listing page
    And User click on the search button on requirement listing
    Then Verify User see the searched requirement on the listing page

  @done @run @testReport123 @RMSRequirements
  Scenario: To verify comments functionality on overview page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    When I go to "Requisitions Raised by You" section
    Then I see that the Status of requirement as "Pending For Requirement"
    When I logout
    When I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And user clicks on the requisition link
    And HR Spoc adds comment for the requisition with no approval process as "Comment added by HR Spoc" on overview page
    And I logout
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    And user clicks on the requisition link
    When I click on comments for raised requisition ready for creation on overview page
    Then HM Spoc must be able to see "Comment added by HR Spoc" comment added by HR Spoc against requisition on overview
