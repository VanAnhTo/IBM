package step_definitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.task.TaskNamelBuilder;
import domain.detail.task.TaskNameDetail;
import util.PageStore;
import util.Specification;

public class AddDetailTask_Steps {
	public WebDriver driver;
	LoginDetailBuilder builder;
	TaskNamelBuilder taskBuilder;
	Specification user;
	PageStore pageStore;

	public AddDetailTask_Steps() {
		this.builder = new LoginDetailBuilder();
		this.taskBuilder = new TaskNamelBuilder();
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
		TaskNameDetail taskDetail = taskBuilder.build();
		user.goToDetailTaskPage(taskDetail);
	}
	
	@And("I click onwned by")
	public void i_click_owned_by() {
		user.clickOwnedBy();
	}
	
	@And("I enter time estimate \"(.*)\"")
	public void i_enter_time_estimate(String timeEstimate) {
		taskBuilder.withTimeEstimate(timeEstimate);
		TaskNameDetail taskDetail = taskBuilder.build();
		user.enterTimeEstimate(taskDetail);
	}
		
}
