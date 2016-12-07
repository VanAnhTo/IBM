package step_definitions;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.task.TaskDetailBuilder;
import domain.detail.task.Task;
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

	@And("I click tab time tracking")
	public void i_click_tab_time_tracking() {
		user.clickTabTimeTracking();
	}

	@And("I choose task group \"(.*)\"")
	public void i_choose_task_gruop(String taskGroup) {
		taskBuilder.withTaskGroup(taskGroup);
		TaskDetail taskDetail = taskBuilder.build();
		user.chooseTaskGroup(taskDetail);
	}

	@And("I click to add time entry row")
	public void i_click_to_add_time_entry_row() {
		user.clickToAddTimeEntryRow();
	}

	@And("I add time tracking with \"(.*)\"")
	public void i_add_time_tracking(String workHour) {
		taskBuilder.withTimeTracking(workHour);
		TaskDetail taskDetail = taskBuilder.build();
		user.enterTimeTracking(taskDetail);
	}

	/*
	 * @And("I enter due date \"(.*)\"") public void i_add_due_date(String
	 * dueDate) { taskBuilder.withDueDate(dueDate); TaskDetail taskDetail =
	 * taskBuilder.build(); user.enterDueDate(taskDetail); }
	 */

	@And("I enter due date \"(.*)\"")
	public void i_add_due_date(String dueDate) throws ParseException {
		taskBuilder.withDueDate(dueDate);
		TaskDetail taskDetail = taskBuilder.build();
		user.enterDueDate(taskDetail);
	}

	@And("I click save task")
	public void i_click_save_task() {
		user.clickSaveTask();
	}

	@And("I click save to complete")
	public void i_click_save_to_complete() {
		user.clickSaveTask();
	}

	@And("I change status \"(.*)\"")
	public void i_change_Status(String status) {
		taskBuilder.withStatusBefore(status);
		TaskDetail taskDetail = taskBuilder.build();
		user.chooseStatus(taskDetail);
	}

	@And("I choose time code \"(.*)\"")
	public void i_choose_time_code(String timeCode) {
		taskBuilder.withTimeCode(timeCode);
		TaskDetail taskDetail = taskBuilder.build();
		user.chooseTimeCode(taskDetail);
	}

	@And("I add work item")
	public void i_add_work_item(List<Task> tasks) throws ParseException {
		user.addWorkItem(tasks);
	}

	@And("I upload excel")
	public void i_up_load_excel() throws Exception {
		user.uploadExel();
	}
}
