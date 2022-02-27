Feature: Multiple CV Upload
  
  @RMS @RMSApplications @RMSMultipleUpload
  Scenario: To do the verify the new count on multiple cv uploadand mapping it to new requirement
  	Given I login into RMS as an "Enterprise" user
  	When User select a "Upload Multiple CVs" from "Profiles" option
  	Then I should be able to see "Add Candidate - Multiple Files" as the page heading for the multiple CV upload
  	When I select the CV in ".doc" extension for bulk upload
  	And I click on "Add New" for creating new requirement to map the uploaded CV
  	And I fill in the requirement title with "Multiple Upload Requirement" 
  	And I click on Upload Files on the multiple upload CV page
  	Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details." 
  	When I click on "View Upload Log" for the CVs uploaded
  	Then I must be able to see "1" under the "Profiles Created" 
  	When User select a "All Requirements" from "Requirements" option
  	Then I should be able to see the requirement created during multiple upload
  	