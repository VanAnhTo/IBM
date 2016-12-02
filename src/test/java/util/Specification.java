package util;

import java.text.ParseException;
import java.util.List;

import domain.builder.task.DashBoardBuilder;
import domain.builder.task.TaskDetailBuilder;
import domain.detail.account.LoginDetails;
import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;
import domain.detail.task.TaskDetail;
import page.LoginPage;
import page.ProjectDashBoardPage;
import page.TaskDetailPage;
import page.CurrentSprintPage;
import page.HomePage;

public class Specification {

	PageStore pageStore;

	public Specification(PageStore pageStore) {
		this.pageStore = pageStore;
	}

	public void clickLoginWith(LoginDetails loginDetails) {
		LoginPage onLoginPage = pageStore.get(LoginPage.class);
		onLoginPage.loginToMainPage(loginDetails);
	}

	public void goToProjectDashboard() {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToProjectDashboard();
	}

	/*public void browsePlans() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickPlansMenu();
	}

	public void clickAllPlans() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickAllPlans();
	}*/
	
	public void clickPlan() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickPlan();
	}

	/*public void selectTeamArea() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.chooseTeamArea();
	}

	public void clickCurrentSprint() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickCurrentSprint();
	}
*/
	public void clickAddNewWorkItem() {
		CurrentSprintPage onCurrentSprintPage = pageStore.get(CurrentSprintPage.class);
		onCurrentSprintPage.clickDropDownAddWorkItem();
	}

	public void clickAddNewTask() {
		CurrentSprintPage onCurrentSprintPage = pageStore.get(CurrentSprintPage.class);
		onCurrentSprintPage.clickTaskOnDropDown();
	}

	public void goToDetailTaskPage(TaskDetail taskDetail) {
		CurrentSprintPage onCurrentSprintPage = pageStore.get(CurrentSprintPage.class);
		onCurrentSprintPage.gotoTaskDetailPage(taskDetail);
	}

	public void clickOwnedBy() {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseOwnedBy();
	}

	public void enterTimeEstimate(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.enterTimeEstimateWith(taskDetail);
	}

	public void clickTabTimeTracking() {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.clickTabTimeTracking();
	}

	public void chooseTaskGroup(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseTaskGroup(taskDetail.getTaskGroup());
	}


	public void clickToAddTimeEntryRow() {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.clickToAddTimeEntryRow();
	}

	public void enterTimeTracking(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.enterTimeTracking(taskDetail.getTimeTracking());
	}
	
	public void enterDueDate(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.enterDueDateWith(taskDetail);
	}
	
	public void enterDueDateWith(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.enterDueDate(taskDetail);
	}

	public void clickSaveTask() {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.clickSaveTask();
	}

	public void clickSprint(DashboardDetail dashBoardDetail) {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickSprint(dashBoardDetail.getSprintDate());
	}

	public void chooseStatus(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseStatus(taskDetail.getStatus());
	}
	
	public void chooseStatusBefore(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseStatus(taskDetail.getStatusBefore());
	}
	
	public void chooseStatusAfter(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseStatus(taskDetail.getStatusAfter());
	}

	public void chooseTimeCode(TaskDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseTimeCode(taskDetail.getTimeCode());
	}

	public void chooseCurrentProject(DashboardDetail dashBoardDetail) {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.chooseProject(dashBoardDetail.getCurrentProject());
	}

	public void chooseTeam(DashboardDetail dashBoardDetail) {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.chooseTeam(dashBoardDetail.getTeam());
	}
	
	public void reloadPage() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.reload();
	}
	
	public void addWorkItem(List<Task> tasks) throws ParseException {
		for (Task task : tasks) {			
			TaskDetailBuilder taskBuilder = new TaskDetailBuilder();
			taskBuilder.withTaskName(task.getTaskName())
					   .withTimeEstimate(task.getTimeEstimate())
					   .withDueDate(task.getDueDate())
					   .withStatusBefore(task.getStatusBefore())
					   .withTaskGroup(task.getTaskGroup())
					   .withTimeCode(task.getTimeCode())
					   .withTimeTracking(task.getTimeTracking())
					   .withStatusAfter(task.getStatusAfter());
			TaskDetail taskDetail = taskBuilder.build();
			
			DashBoardBuilder dashBoardBuilder = new DashBoardBuilder();
			dashBoardBuilder.withTeam(task.getTeam()).withSprintDate(task.getSprintDate());
			DashboardDetail dashBoardDetail = dashBoardBuilder.build();
			
			//this.browsePlans();
			//this.clickAllPlans();
			this.clickPlan();
			this.chooseTeam(dashBoardDetail);
			this.clickSprint(dashBoardDetail);
			this.clickAddNewWorkItem();
			this.clickAddNewTask();
			this.goToDetailTaskPage(taskDetail);
			this.enterTimeEstimate(taskDetail);
			//this.enterDueDate(taskDetail);
			this.enterDueDateWith(taskDetail);
			this.clickOwnedBy();
			this.clickTabTimeTracking();
			this.chooseTaskGroup(taskDetail);
			this.clickToAddTimeEntryRow();
			this.chooseTimeCode(taskDetail);
			this.enterTimeTracking(taskDetail);
			this.clickSaveTask();
			this.chooseStatusBefore(taskDetail);
			this.clickSaveTask();
			this.chooseStatusAfter(taskDetail);
			this.clickSaveTask();
			//reloadPage();
		}
}

}
