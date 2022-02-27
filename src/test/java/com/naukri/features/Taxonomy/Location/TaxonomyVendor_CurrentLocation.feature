Feature: Location Taxonomy changes in Vendor portal

  Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User clicks on "Candidate's Current Location" drop down
    Then User sees "Top Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | New Delhi		           |
      | Gurgaon/Gurugram	     |
      | Noida                  |
      | Mumbai						     |

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "b" in "Candidate's Current Location" field
    Then User sees at max 10 cities suggestions

  Scenario: Verify when city is not present in the suggestion
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "x" in "Candidate's Current Location" field
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "test" entered text in "Other Location" field

  Scenario: Verify error messages in "Add Other Location" layer
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  Scenario: Verify user is able to add Other National Location
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as location value

  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "test" entered text in "Other Location" field

  Scenario: Verify error messages in "Add International Location" layer
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  Scenario: Verify user is able to add Other International Location
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as location value

  Scenario: Verify that each city selection is displayed as text in "Candidate's Current Location" Field
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value

  Scenario: Verify that preselected city in dropdown is highlighted and tick is displayed along the selected location
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
	And  User Select Specific Requirement on Vendor Portal
    When User selects 1 option from dropdown in "Top Metropolitan Cities"
    Then User sees selected city is highlighted and tick mark is displayed beside the option in dropdown

  Scenario: Verify the value added if city is not present in global list
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as location value
    When User clicks on "Candidate's Current Location" drop down
    And User enters "test" in "Candidate's Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as location value

  Scenario: Verify that user is able to enter Indian City as "Candidate's Current Location"
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User selects 1 option from the "Candidate's Current Location" dropdown
    Then User sees "Ajmer" text in "Candidate's Current Location" Field
    When User enters "Ajmer" in "Candidate's Current Location" field
    Then User sees the selected value is highlighted in dropdown

  Scenario: Verify that user is able to change location
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    When User clicks on "Candidate's Current Location" drop down
    And User enters "Chandigarh" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Chandigarh" added as location value
	
	Scenario: Verify that user is able to see same current location for application added from vendorportal in "All profiles"
		Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    When User clicks on "Candidate's Current Location" drop down
    And User fill all fields except "Candidate's Current Location" field
    And User clicks "Submit Candidate" button
    And I logout of RMS
    When User login to the application "profileListingInbox" using "Superuser" of "Enterprise2" user
   	And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page
	
	Scenario: Verify that user is able to see same current location for application added from vendorportal for the Requirement on SRP
		Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    When User clicks on "Candidate's Current Location" drop down
    And User fill all fields except "Candidate's Current Location" field
    And User clicks "Submit Candidate" button
    And I logout of RMS
    When User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And User search requirement using Requirement Name
    And User clicks count of applications for the requirement
    And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page
    	
	
	Scenario: Verify that user is able to change current location for application added from vendorportal from CV Details
		Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    And User fill all fields except "Candidate's Current Location" field
    And User clicks "Submit Candidate" button
    And I logout of RMS
    When User login to the application "profileListingInbox" using "Superuser" of "Enterprise2" user
    And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page
    And User clicks the candidate name
    Then User is directed to CV Details for the candidate
    And User sees same current location for the candidate
    And User clicks "Edit Candidate Details" on SRP page
    When User enters "Noida" in "Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as location value
	
	Scenario: Verify that user is able to search for candidate using Advance Search or Quick Search on location entered for the candidate
		Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    And User fill all fields except "Candidate's Current Location" field
    And User clicks "Submit Candidate" button
    And I logout of RMS
    When User login to the application "profileListingInbox" using "Superuser" of "Enterprise2" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Current Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees locations in "Current Location" label on SRP page
    Then User sees profiles with locations entered
    And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page
    And User clicks "Expand" option for "All Profiles"
    When User enters "Ajmer" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" value checked for the location dropdown
    And User clicks "Search" button
    And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page
	
	Scenario: Verify that vendor applied application is displayed when location filter is applied for the location in the application
		Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And  User Select Specific Requirement on Vendor Portal
    When User enters "Ajmer" in "Candidate's Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    And User fill all fields except "Candidate's Current Location" field
    And User clicks "Submit Candidate" button
    And I logout of RMS
    When User login to the application "profileListingInbox" using "Superuser" of "Enterprise2" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Ajmer" location filter
    Then User sees profiles with "Ajmer" current location
    And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page