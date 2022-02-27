Feature: Verify Billing option in offer stage features

	@id:1
  Scenario: Login to RMS application with consultant account and verify Billing option in offer satge
    Given I am on RMS Customize the Selection Process page in settings
    When I clicked on offers & joining stage
    Then I validate Billing stag is available in each sub stage
    And offered billing stage default selected
    
	@id:2
  Scenario: Add new billing stage.
    Given I am on RMS Customize the Selection Process page in settings
    When I clicked on offers & joining stage
    And click on Add Sub Stage option and fill "Move To Billing" name in text field and click on save button
    And click on checkbox against Billing stage option in stage "Move To Billing"
