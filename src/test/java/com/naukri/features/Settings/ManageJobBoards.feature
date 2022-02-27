Feature: Manage Job Boards
Background: 
	Given "Enterprise" user is on Settings Page with "Superuser1" 

@Settings
Scenario: verify RMS user is able to open help link
	When user click on "Manage Job Boards" link
	And user click on " HELP " link 
	Then verify user is navigated to Adding a Job Board 
	
@Settings
Scenario: verify RMS user is able to view all Job Boards
	When user click on "Manage Job Boards" link
	Then verify user able to see the below listed job boards
		|Times Jobs|
		|LinkedIn Jobs|
		|Monster Jobs|
		|Shine Jobs|
		
		
