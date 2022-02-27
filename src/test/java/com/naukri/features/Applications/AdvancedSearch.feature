Feature: Advance Search

	@RMS @RMSApplications @AdvanceSearch
	Scenario: To create a profile for performing advanced search
		Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User fills in "Engineer Testing" as Current Designation
    And User fills in "Infoedge" as Current Company
    And User fills in "Noida" as Current Location
    And User checks in "Anywhere in North India" as preferred location
    And User fills in "IT Software - QA & Testing" as Functional Area
    And User fills in "QA/QC Exec." as Role
    And User fills in "Recruitment" as Industry
    And User selects 3 years and 10 months as total experience
    And User selects 10 lakhs and 50 thousands as annual salary
    And User selects 13 lakhs and 70 thousands as expected salary
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    And User should be able to see the "Current Designation" same as "designation" from property file
    And User should be able to see the "Current Company" same as "company" from property file
    And User should be able to see the "Current Location" same as "current location" from property file
    And User should be able to see the "Pref. Location" same as "preferred location" from property file
    And User should be able to see the "Functional Area" same as "functional area" from property file
    And User should be able to see the "Role" same as "role" from property file
    And User should be able to see the "Industry" same as "industry" from property file
    And User should be able to see the "Total Experience" same as "total experience" from property file
    And User should be able to see the "Annual Salary" same as "annual salary" from property file
    And User should be able to see the "Expected CTC" same as "expected ctc" from property file
    When User click on "Edit" link against "Summary" on CV detail page
    And enter data in summary as "This is summary detail for candidate"
    And User click on "Save" button.
    And User reload the page.
    Then User should be able to see saved summary data.
    And User click on "Edit" link against "Other Details" on CV detail page
    And User choose "Date of Birth"  date as "11" and month as "Mar" and year as "1988" on CV detail page
    And User choose option in other details on CV detail page
    |Gender									 |Male												|
    |Job Type								 |Temporary/Contractual				|
    |Employment Type				 |Full Time										|
    |Other Countries				 |Australia										|
    |Physically Challenged	 |Yes													|
    And User select value in other details on CV detail page
    |maritalStatus 					 |Married											|
    |workPermitUS						 |Need H1 Visa								|
    |category								 |ST													|
    When User comments "Comment" on the application created
    Then User should be able to see the "Comment" in comments section as the comment on index 1
    When User gives the star rating to the application as 5 stars
    Then User should be able to see the star rating value as "5"

	@RMS @RMSApplications @AdvanceSearch
	Scenario: To verify the basic layout of advance search for profile search
		Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
		When User clicks on the advance search for "Profile Search" 
		Then User should be able to see the Profiles option on GNB as active
		And User should be able to see the component with heading "Advanced Search" 
		And User should be able to see the component with division named as "Recent Searches" 
		And User should be able to see the component with division named as "Saved Searches" 
		And User should be able to see the component with division named as "Basic Details" 
		And User should be able to see the component with division named as "Search Candidates In " 
		And User should be able to see the component with division named as "Employment Details" 
		And User should be able to see the component with division named as "Educational Details" 
		And User should be able to see the component with division named as "Additional Filters" 
		And User should be able to see the component with division named as "Affirmative Actions" 
		And User should be able to see the component with division named as "Display Options" 
		And User should be able to see the button as "Find Resumes" on advance search layout 
		And User should be able to see the Modified in drop down having values as 
		|  3 days  							 |
		|  7 days  							 |
		|  15 days  						 |
		|  30 days  						 |
		|  2 months 						 |
		|  3 months  						 |
		|  4 months  						 |
		|  6 months  			 			 |
		|  9 months  			 			 |
		|  1 Year  							 |
		|  All Resumes  		 		 |
		|  4 days to 7 days  	   |
		|  8 days to 15 days     |
		|  16 days to 30 days    |
		|  30 days to 2 months   |
		|  30 days to 3 months   |
		|  2 months to 3 months  |
		|  2 months to 4 months  |
		|  3 months to 4 months  |
		|  3 months to 6 months  |
		|  4 months to 6 months  |
		|  6 months to 9 months  |
		|  6 months to 1 Year    |
		|  9 months to 1 Year    |
		|  1 Year+  						 |