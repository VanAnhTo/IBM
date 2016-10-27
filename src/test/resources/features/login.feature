Feature: As a Staff
I want to login

  Scenario: Login success to IBM
    Given I open browser and enter link website "https://qlsxpm.viettel.vn:9443/ccm/web"
    And I fill login form
    	| username  | password |
		| anhttv14 |      Thin@123 |
    And I login
    And I go to project dashboard page 
    And I click plan menu
    And I click to see all plans
    And I select team area