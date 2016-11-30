Feature: Create task of a work day
  As a staff member 
  I want to create task of a work day
  So that I can create tasks

  #Work time per day: default 8 hour
  #Estimate time for work: default 8 hour
  Background: 
    Given I open browser and enter link website "https://qlsxpm.viettel.vn:9443/ccm/web"
    And I fill login form
      | username | password  |
      | hoangnl  | 123qwe!@# |
    And I login

  Scenario Outline: Create work item success
    Given I go to current project "<curentProject>"
    When I click plan menu
    And I click to see all plans
    And I choose team "<team>"
    #Then I wait for completing task
    And I click the sprint has time "<dateOfSprint>"
    And I click add new work item
    And I click add new task
    And I enter with "<taskName>"
    #Then I wait to see detak task page
    And I go to detail task page
    And I enter time estimate "<timeEstimate>"
    And I enter due date "<dueDate>"
    And I click owned by
    #And I choose due date
    And I click tab time tracking
    And I choose task group "<taskGroup>"
    And I click to add time entry row
    And I choose time code "<timeCode>"
    And I add time tracking with "<workHour>"

    And I click save task
    #Then I wait for completing task
    And I change status "START_WORKING"
    #And I click save task
    And I change status "INVALIDATE"
    #And I click save task
    Examples: List of values
      | curentProject                           | team                                    | dateOfSprint                | taskName | timeEstimate | workHour | dueDate                   | taskGroup | timeCode |
      | VTICT_VA_13001_HQMC (Change Management) | VTICT_VA_13001_HQMC (Change Management) | Nov 21, 2016 - Dec 24, 2016 | Test     |            8 |        8 | Nov 19, 2016, 12:00:00 PM | Support   | Report   |
      | VTICT_VA_13001_HQMC (Change Management) | VTICT_VA_13001_HQMC (Change Management) | Nov 21, 2016 - Dec 24, 2016 | Test1    |            8 |        8 | Nov 21, 2016, 12:00:00 PM | Code      | Document |
      | VTICT_VA_13001_HQMC (Change Management) | VTICT_VA_13001_HQMC (Change Management) | Nov 21, 2016 - Dec 24, 2016 | Test2    |            8 |        8 | Nov 22, 2016, 12:00:00 PM | Support   | Execute  |

  Scenario: Create work item success
    Given I go to current project "VTICT_VA_13001_HQMC (Change Management)"
    And I add work item
      | team                                    | dateOfSprint                | taskName | timeEstimate | workHour | dueDate                   | taskGroup | timeCode |
      | VTICT_VA_13001_HQMC (Change Management) | Nov 21, 2016 - Dec 24, 2016 | Test     |            8 |        8 | Nov 19, 2016, 12:00:00 PM | Support   | Report   |
      | VTICT_VA_13001_HQMC (Change Management) | Nov 21, 2016 - Dec 24, 2016 | Test1    |            8 |        8 | Nov 21, 2016, 12:00:00 PM | Code      | Document |
      | VTICT_VA_13001_HQMC (Change Management) | Nov 21, 2016 - Dec 24, 2016 | Test2    |            8 |        8 | Nov 22, 2016, 12:00:00 PM | Support   | Execute  |
