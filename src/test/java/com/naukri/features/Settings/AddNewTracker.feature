Feature: Add a new tracker

  Background: 
    Given User login to the application "clientTracker" using "Superuser" of "ProConsultant" user
        
  @AddANewTracker @Settings
  Scenario: employer not added to the tracker , the tracker is saved as uncategorised tracker
    And click on add a new tracker
    And Enter tracker name
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When Enter the template name Under Quick Search Template
    Then The search results should be displayed correctly

  @AddANewTracker @Settings
  Scenario: Editing the categorised tracker ,employer name should be disabled
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When refresh the page
    And Enter the template name Under Quick Search Template
    And user click on "Edit" link
    Then employer name should be disabled ie we must not be allowed to change the employer name

  @AddANewTracker @Settings
  Scenario: Editing the uncategorised tracker , employer name should not be disabled
    When click on add a new tracker
    And Enter tracker name
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When refresh the page
    And Enter the template name Under Quick Search Template
    And user click on "Edit" link
    And click on the assign employer DD
    Then we should be able to choose the employer

  @AddANewTracker @Settings
  Scenario: employer is selected share with has 2 options ie share with everyone in group and no one and checking the functionality of no one
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And click on Share with
    Then Everyone in group and no one should be displayed
    When click on None option
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When I logout of RMS
    And User login to the application "clientTracker" using "Subuser" of "ProConsultant" user
    And Enter the template name Under Quick Search Template
    Then the tracker should not be visible

  @AddANewTracker @Settings @Smoke
  Scenario: employer is selected , validating the functionality of everyone in group
    When User is on "groupListing" page
    And Click on add a new employer
    And enter employer name
    And Enter Subrecruiter name and click on save
    When User is on "clientTracker" page
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And click on Share with
    Then Everyone in group and no one should be displayed
    When click on everyone in group
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When I logout of RMS
    And User login to the application "clientTracker" using "Subuser" of "ProConsultant" user
    And Enter the template name Under Quick Search Template
    Then The search results should be displayed correctly

  @AddANewTracker @Settings
  Scenario: All the names of employers displayed on create new tracker page
    When User is on "groupListing" page
    And get the total no of employers
    When User is on "clientTracker" page
    And click on add a new tracker
    Then Create New Tracker should be the heading
    And Assign employer should be a label name
    When click on the assign employer DD
    Then All the employers of the company should be visible

  @AddANewTracker @Settings 
  Scenario: employer is not selected share with has 2 options ie Share with everyone and no one and validating the functionality of share with everyone
    When click on add a new tracker
    And Enter tracker name
    And click on Share with
    And click on share with everyone
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully" 
    When I logout of RMS
    And User login to the application "clientTracker" using "Subuser" of "ProConsultant" user
    And Enter the template name Under Quick Search Template
    Then The search results should be displayed correctly

  @AddANewTracker @Settings
  Scenario: when employer is not selected , validating the functionality of no one
    When click on add a new tracker
    And Enter tracker name
    And click on Share with
    And click on None option
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When I logout of RMS
    And User login to the application "clientTracker" using "Subuser" of "ProConsultant" user
    And Enter the template name Under Quick Search Template
    Then the tracker should not be visible

  @AddANewTracker @Settings
  Scenario: All the functionality will remain same for subrecruiter
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And select name , email id , job title
    And Click on edit labels
    And Change the names of the labels ie Name,Email ID
    And click on save edit labels
    Then verify that labels are edited in the coloumn

  @AddANewTracker @Settings 
  Scenario: To verify that if the employer is already selected then after edit , employer name DD will be disabled
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And get the employer name
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    And Enter the template name Under Quick Search Template
    And user click on "Edit" link
    Then the employer name should be visible

  @AddANewTracker @Settings
  Scenario: To verify that if uncategorised tracker is created ,we can select the employer name
    When click on add a new tracker
    And Enter tracker name
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When Enter the template name Under Quick Search Template
    And user click on "Edit" link
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And Click on save button on create new tracker page
    Then verify success message "Tracker edited successfully"
    And Enter the template name Under Quick Search Template
    And user click on "Edit" link
    And get the employer name
    Then the employer name should be visible

  @AddANewTracker @Settings
  Scenario: When employer is added , heading on manage template page is edit tracker coloumn labels for employer name
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    When Enter the template name Under Quick Search Template
    Then user should be able to see the label "Edit Tracker Column Name" 
    When user click on "Edit Tracker Column Name" link
    Then I should see three labels default, custom and values

  @AddANewTracker @Settings
  Scenario: verify the validation errors on values
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And select name , email id , job title
    And Click on save button on create new tracker page
    Then verify success message "Tracker added successfully"
    And Enter the template name Under Quick Search Template
    When user click on "Edit Tracker Column Name" link
    And Enter random string 52 chars in first field
    Then verify user able to see error message "Error: Max length allowed is 50 char"  
    When Enter '#$%^&*()' in second field
    Then verify user able to see error message "Error: Special Characters not allowed" 
   

  @AddANewTracker @Settings 
  Scenario: login with enterprise account and verify that Edit Tracker Coloumn Labels should not be displayed
    When I logout of RMS
    And User login to the application "clientTracker" using "Superuser" of "Enterprise2" user
    And click on add a new tracker
    And Enter tracker name
    Then Edit Tracker Coloumn Labels should not be displayed
