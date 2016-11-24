Feature: Create task of a work day  
	As a staff member 
	I want to create task of a work day
	So that I can create tasks
	
 #Thu 2 -> Thu 7: workDay number from: 4 -> 9
 #Work time per day: default 8 hour
 #Estimate time for work: default 8 hour

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
    And I enter due date "<duedate>"
    And I click owned by
    And I choose due date
    And I click tab time tracking
    And I choose task group
    And I click to add time entry row
    And I add time tracking with "<workDay>" and "<workHour>"

    
    Examples: List of values
      | taskName  		  |timeEstimate |workHour	|workDay |duedate					|
      | This is task name | 8			| 	8		|	6	 |Nov 09, 2016, 12:00:00 PM	|
      
   @wip
   Scenario: Login success to IBM
    And I login
    And I go to project dashboard page 
    And I click plan menu
    And I click to see all plans
    And I select team area
    And I choose KDD team
    
@wip
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
    And I enter due date "<duedate>"
    
    
     Examples: List of values
      | taskName  		  |timeEstimate |duedate						|
      | This is task name | 8			|	Nov 21, 2016, 12:00:00 PM	|
    