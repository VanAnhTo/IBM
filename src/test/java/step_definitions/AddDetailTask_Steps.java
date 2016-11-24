package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.task.TaskDetailBuilder;
import domain.detail.task.TaskDetail;
import util.PageStore;
import util.Specification;

public class AddDetailTask_Steps {
	public WebDriver driver;
	LoginDetailBuilder builder;
	TaskDetailBuilder taskBuilder;
	Specification user;
	PageStore pageStore;

	public AddDetailTask_Steps() {
		this.builder = new LoginDetailBuilder();
		this.taskBuilder = new TaskDetailBuilder();
		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}
	
	@And("I click add new work item")
	public void i_click_add_new_work_item() {
		user.clickAddNewWorkItem();
	}
	
	@And("I click add new task")
	public void i_click_add_new_task() {
		user.clickAddNewTask();
	}
	
	@And("I enter with \"(.*)\"")
	public void i_enter_task_name(String taskName) {
		taskBuilder.withTaskName(taskName);
	}
	
	@And("I go to detail task page")
	public void i_go_to_task_page() {
		TaskDetail taskDetail = taskBuilder.build();
		user.goToDetailTaskPage(taskDetail);
	}
	
	@And("I click owned by")
	public void i_click_owned_by() {
		user.clickOwnedBy();
	}
	
	@And("I enter time estimate \"(.*)\"")
	public void i_enter_time_estimate(String timeEstimate) {
		taskBuilder.withTimeEstimate(timeEstimate);
		TaskDetail taskDetail = taskBuilder.build();
		user.enterTimeEstimate(taskDetail);
	}
	
	@And("I choose due date")
	public void i_choose_due_date() {
		user.chooseDueDate();
	}
	
	@And("I click tab time tracking")
	public void i_click_tab_time_tracking() {
		user.clickTabTimeTracking();
	}
	
	@And("I choose task group")
	public void i_choose_task_gruop() {
		user.chooseTaskGroup();
	}
	
	@And("I click to add time entry row")
	public void i_click_to_add_time_entry_row() {
		user.clickToAddTimeEntryRow();
	}
	
	@And("I add time tracking with \"(.*)\" and \"(.*)\"")
	public void i_add_time_tracking(String workDay, String workHour) {
		taskBuilder.withTimeTracking(workDay, workHour);
		TaskDetail taskDetail = taskBuilder.build();
		user.enterTimeTracking(taskDetail);
	}
	
	@And("I enter due date \"(.*)\"")
	public void i_add_due_date(String dueDate) {
		taskBuilder.withDueDate(dueDate);
		TaskDetail taskDetail = taskBuilder.build();
		user.enterDueDate(taskDetail);
	}	
	
	@And("I click save task")
	public void i_click_save_task() {
		user.clickSaveTask();
	}
	
	@And("I change status to start working")
	public void i_change_status_to_start_working() {
		user.changeStatusToStartWorking();
	}
	
	@And("I save status has changed")
	public void i_save_status_has_changed() {
		user.clickSaveTask();
	}
	
	@And("I change status to complete")
	public void i_change_status_to_complete() {
		user.changeStatusToComplete();
	}
	
	@And("I click save to complete")
	public void i_click_save_to_complete() {
		user.clickSaveTask();
	}
}
