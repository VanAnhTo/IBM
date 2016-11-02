Feature: Create day task 


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
    And I choose team
    And I click sprint
      
      
   @wip
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
    And I choose KDD team