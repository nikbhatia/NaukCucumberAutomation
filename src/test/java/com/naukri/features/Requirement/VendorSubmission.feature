Feature: Vendor Submission of application to an assigned requirement

	@wip @testImp
	Scenario: To verify the new count on submission of a profile by a vendor
		Given I login into RMS as an "Enterprise" user
    When I select a "Add A New Requirement" from "Requirements" option
    And I fill in the requirement title
    And I fill in the job title
    And I fill in the Job Description
    And I fill in the Candidate Description
    And I select the currency of CTC as "INR"
    And I fill in the "minCTC" as "5,00,000"
    And I fill in the "maxCTC" as "7,00,000"
    And I fill in the more salary details
    And I fill in the "minExp" as "2" years of experience
    And I fill in the "maxExp" as "3" years of experience
    And I fill in the keywords as "java"
    And I fill in the job location as "Delhi,Ahmedabad"
    And I click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And I select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then I should be able to see the "B.A(English)" under the label You have selected as "Graduation"
    When I select "Graduation & Post Graduation will be enforced"
    And I select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then I should be able to see the "M.A(English)" under the label You have selected as "Post Graduation"
    When I select "Post Graduation, or Doctorate will be enforced"
    And User chose "Any Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company
    And User click on Save and Post Requirement on requirement page
    Then User should be able to see a layer with title "Questionnaire suggestion based on your Requirement"
    When I click on "Skip Questionnaire For Now" on the questionnaire preview
    Then User should be redirected to requirement overview page
    When I click on Assign Vendor for the requirement created
    #Then I should be able to see the text "Assign Requirement:" as the heading of the lightbox
    #When I select the vendor name for assigning the requirement
    #And I click on Assign Vendor button on Assign Vendor Lightbox
    #Then I should see the vendor assignment success message as "Vendor successfully assigned to the requirement." 
    #When I click on "Logout" by hovering on username
    #When I login into RMS as an "vendorsent1@yopmail.com|P@ssw0rd0987" user
    #When I select a "Connected Employers" from "RMS / CSM" option on Naukri GNB
    #And I click on the vendor name
   #	Then I must be redirected to the list of requirements with heading "List Of Requirements" 
   #	When I click on the requirement name of the requirement created above
   #	And I click on the submit candidate button
   #	Then I should be able to see the interface with heading "Submit Candidates" for a vendor
   #	
    #
    #
