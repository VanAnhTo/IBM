Feature: Create task of a work day  
	As a staff member 
	I want to create task of a work day
	So that I can create tasks
	

Background: 
    Given I open browser and enter link website "https://qlsxpm.viettel.vn:9443/ccm/web"
    And I fill login form
    	| username  | password |
		| anhttv14  | Thin@123 |
    And I login

  Scenario Outline: Creat work item success
    And I go to project dashboard page 
    And I click plan menu
    And I click to see all plans
    And I select team area
    And I choose a team
    And I click current sprint
    And I click add new work item
    And I click add new task
    And I enter with "<taskName>"
    And I go to detail task page
    And I enter time estimate "<timeEstimate>"
    And I click owned by
    And I choose due date
    And I click tab time tracking
    And I choose task group
    And I click to add time entry row
    And I add time tracking with "<workDay>" and "<workHour>"

    
    Examples: List of values
      | taskName  		  |timeEstimate |workDay	|workHour|
      | This is task name | 8			| 	9		|	8	 |
      
   @wip
   Scenario: Login success to IBM
    And I login
    And I go to project dashboard page 
    And I click plan menu
    And I click to see all plans
    And I select team area
    And I choose KDD team