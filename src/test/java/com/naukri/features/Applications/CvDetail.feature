@RMSApplications
Feature: To Verify CV detail page of an application on RMS
  Author:himanshu.dua@naukri.com

  Background: 
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the name of "35" in the candidate name
    And I fill in the email of the candidate
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    
  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to see all the sections on "CV Details" page
    When User on cv detail page
    Then User should be able to see following sections on CV detail page
    | Candidate Details           |
  	| Custom Fields for candidate |
 		| Summary                     |
 		|	Work Experience							|
 		|	Education										|
 		|	IT Skills										|
 		|	Language Known							|
 		|	Projects										|
 		|	Other Details								|
 		|	Attached Documents					|

  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to see all the links on "CV Details" page
    When User on cv detail page
    Then User should be able to see link on CV detail page
    |	Custom Fields		|
    |	Work Experience	|
    |	Education				|
    |	Attached Documents|
    |	Attached Resume	|	

  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to edit "Candidate Details"
    When User click on "Edit" link against "Candidate Details" on CV detail page 
    And User fill detail in respected field on CV detail page
    |Current Designation| Engineer Testing			|
    |Current Company		|IBM										|
    |Current Location		| Faridabad							|
    |Preferred Location	| Faridabad							|
    |Functional Area		| Hotels / Restaurants	|
    |Role								| Staff Function				|
    |Industry						| Auto/Auto Ancillary		|
    |Total Experience		| 4											|
    |Annual Salary			| 9											|
    |Expected CTC				| 17										|
    And User click on "Save" button.
    And User reload the page.
    Then User should be able to see all the entered value are edited in candidate details section

  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to edit "Summary"
    When User click on "Edit" link against "Summary" on CV detail page
    And enter data in summary as "This is summary detail for candidate"
    And User click on "Save" button.
    And User reload the page.
    Then User should be able to see saved summary data.

  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to Add "Work Experience"
    When User click on "Add Experience" link against "Work Experience" on CV detail page
    And User fill detail in Employer Name field as "TCS"
    And User select radio button of "Current Employer"
    And User select "Duration" as "Mar" "2018" on CV detail page
    And User fill detail in Designation field as "Testing Engineer" on CV detail page
    And User fill detail in job Profile field as "Test job profile" on CV detail page
    And User select "Notice period" from dropdown as "15 Days or less" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see all the entered details in work experience fields

  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to Add "Education"
    When User click on "Add UG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
    |Degree				 |B.A					 |
    |specialization|Communication|
    |University		 |Amravati University|
    |Year					 |2017				 |
    And User select the education type as "Part Time" on CV detail page
    And User click on "Save" button on candidate profile page
    And User reload the page.
    Then User should be able to see saved education on the cv details page for "UG"
    When User click on "Add PG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
    |Degree			 	 |M.A					 	 |
    |specialization|Communication	 |
    |University		 |Anna University|
    |Year					 |2019				 	 |
    And User select the education type as "Full Time" on CV detail page
    And User click on "Save" button on candidate profile page
    And User reload the page.
    Then User should be able to see saved education on the cv details page for "PG"
    When User click on "Add PPG" link against "Education" on CV detail page
  	 And User choose Degree from dropdown on CV detail page
    |Degree				 |MPHIL				|
    |specialization|Anthropology|
    |University		 |Allahabad University|
    |Year					 |2021				|
    And User select the education type as "Correspondence/Distance Learning" on CV detail page
    And User click on "Save" button on candidate profile page
    And User reload the page.
    Then User should be able to see saved education on the cv details page for "PPG"
    When User click on "Add Certification" link against "Education" on CV detail page
    And User fill detail in "Diploma/Certificate" as "Testing Diploma ISTQB certified" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see added certificate in education
    
  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to Add "Language Known"
    When User click on "Edit" link against "Language Known" on CV detail page
    And Add language "English" and Proficiency as "read" , "write" and "speak" on CV detail page
    And click on "Add Language" link on CV detail page
    Then User should be able to see another field for add language
    When User click on "Save" button on candidate profile page
    Then User should be able to see added language on CV detail page
    
  @RMS @RMSApplications @CvDetails
  Scenario: To verify user is able to Edit "Other Details"
    When User reload the page.
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
    And User entered value in other details on CV detail page
    |postalAddress					 |This is my Permanent Address|
    |pinCode								 |121102											|
    |homeTown								 |Delhi												|
    |physicallyChallengedDesc|This is Description					|
    And User click on "Save" button on candidate profile page
    Then User should be able to see added details in "Other Details" section
  
  @RMS @RMSApplications @CvDetails @Recent
  Scenario: To verify the presence of application id on CV details page
  	Then User should be able to see the "Application ID" same as that present in URL formed
  
  @RMS @RMSApplications @CvDetails
  Scenario: To verify the last active date on the cv details page
  	Then User should be able to see the "Last Active:" date of present day
  
  @RMS @RMSApplications @CvDetails
  Scenario: To verify the last modified date on the cv details page
  	Then User should be able to see the "Last Modified:" date of present day
  
  @RMS @RMSApplications @CvDetails
  Scenario: To verify the application date on the cv details page
  	Then User should be able to see the "Application Date:" date of present day
  
  @RMS @RMSApplications @CvDetails
  Scenario: To verify the absence of add ug link after adding ug qualification
  	When User click on "Add UG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
    |Degree				 |B.A					 |
    |specialization|Communication|
    |University		 |Amravati University|
    |Year					 |2017				 |
    And User select the education type as "Part Time" on CV detail page
    And User click on "Save" button on candidate profile page
    And User reload the page.
    Then User should be able to see saved education on the cv details page for "UG"
    And User should not be able to see "Add UG" under "Education" on details page
 
  @RMS @RMSApplications @CvDetails
  Scenario: To verify the absence of add pg link after adding pg qualification
  	When User click on "Add PG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
    |Degree			 	 |M.A					 	 |
    |specialization|Communication	 |
    |University		 |Anna University|
    |Year					 |2019				 	 |
    And User select the education type as "Full Time" on CV detail page
    And User click on "Save" button on candidate profile page
    And User reload the page.
    Then User should be able to see saved education on the cv details page for "PG"
    And User should not be able to see "Add PG" under "Education" on details page
  
 @RMS @RMSApplications @CvDetails
  Scenario: To verify the absence of add ppg link after adding ppg qualification
  	When User click on "Add PPG" link against "Education" on CV detail page
  	 And User choose Degree from dropdown on CV detail page
    |Degree				 |MPHIL				|
    |specialization|Anthropology|
    |University		 |Allahabad University|
    |Year					 |2021				|
    And User select the education type as "Correspondence/Distance Learning" on CV detail page
    And User click on "Save" button on candidate profile page
    And User reload the page.
    Then User should be able to see saved education on the cv details page for "PPG"
    And User should not be able to see "Add PPG" under "Education" on details page
  
  	
