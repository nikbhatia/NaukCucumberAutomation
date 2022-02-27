Feature: Verifying the multiple billing categories
@id:1
Scenario: To verify the functionality of the multiple billing category against the same employer when not choosing the billing category under the new requirement and move to billing stage 
	Given I login with consultant account
	And I create an employer with the mutliple billing addresses and categories with different payable days
	And I add candidate against the same employer without choosing billing category in Requirement
	When I move the candidate to billing stage without chosing the billing category
	And I move to the billing dashboard
	Then I am able to see the candidate added under the To be generated tab
	When I click on generate proforma invoice by selecting the proforma invoice by selecting it from more options.
	Then link of proforma invoice should be visible under the candidate.
	When I select edit proforma invoice and choose the other billing category with the other payable details
	Then I am able to see the candidate with changed details against the selected billing category
	When I generate the invoice for the same candidate and move to outstanding tab
	Then I am able to see the added candidate under the Outstanding tab.
	And The links of invoice and proforma invoice is present under the candidate tuple
	
#Scenario: To verify the functionality of the multiple billing category under the chosing the billing category during requirement creation
#	Given I login with consultant account
#	And I create an employer with the mutliple billing addresses and categories with different payable days
#	And I add candidate against the same employer 
#	And I fill in all details and selecting the billing category name
#	And I switch I move to billing dashboard 
#	Then I am on to be generated tab and the added candidate should be visible on the tab
#	When I select the proforma invoice with the selected billing category
#	Then I am able to see the link proforma invoice in the footer of the candidate tuple
#	When I edit the proforma invoice for the same candidate with the different billing catgeory
#	Then I am able to see the candidate on the billing dashboard with the changed values against the changed category
#	When I generate invoice and move to the Outstanding tab
#	Then I am able to see the moved candidate on the Outstanding tab 
#	
#Scenario: To verify the functionality of changing the billing category at the time of moving the candidate to the billing stage
#	When I login with consultant credentials
#	And I create an employer with the mutliple billing addresses and categories with different payable days
#	And I add candidate against the same employer with new requirement and select a billing category
#	And I move the candidate to the billing stage with changed in billing category
#	And I go to billing dashboard
#	Then The added candidate should be visible under the to be generated tab
#	When I generate the proforma invoice of the added candidate
#	Then the candidate should be present under the with the newly mapped billing category
#	And The link of the proforma invoice of the candidate should be present under the footer of the candidate tuple
#	When I generate invoice of the same added candidate
#	And user click on "Paid" tab on billing dashboard
#	Then I am able to see the candidate under the paid tab.
#	
#Scenario: Verify Invoice Editor if some invoice settings/employer settings are missing
#	
#Scenario: Verify Invoice Editor if addresses are of same state and are of diffrent state and are tax exempted or Unregistered
