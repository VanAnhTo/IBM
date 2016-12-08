package util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;

import Interface.ExcelDatasource;
import Interface.ExternalDatasource;
import Interface.XmlDatasource;
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

	private ExternalDatasource _source;
	
	public Specification(PageStore pageStore) {
		this.pageStore = pageStore;
		_source = new XmlDatasource();
	}

	public void clickLoginWith(LoginDetails loginDetails) {
		LoginPage onLoginPage = pageStore.get(LoginPage.class);
		onLoginPage.loginToMainPage(loginDetails);
	}

	public void goToProjectDashboard() {
		HomePage onHomePage = pageStore.get(HomePage.class);
		onHomePage.goToProjectDashboard();
	}

	public void clickPlan() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickPlan();
	}

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
		onCurrentSprintPage.gotoTaskDetailPageWithTaskName(taskDetail);
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
		onTaskDetailPage.enterDueDate(taskDetail.getDueDate());
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
			DashBoardBuilder dashBoardBuilder = new DashBoardBuilder();
			dashBoardBuilder.withTeam(task.getTeam()).withSprintDate(task.getSprintDate());
			DashboardDetail dashBoardDetail = dashBoardBuilder.build();
			addWorkTaskSteps(dashBoardDetail, task);
		}

	}

	public void uploadExel() throws Exception {
		DashboardDetail dashBoardDetail = _source.readDashboardDetailFromExternalDatasource();
		List<Task> listTask = _source.readTaskListFromExternalDatasource();
		for (int indexR = 1; indexR < listTask.size(); indexR++) {
			addWorkTaskSteps(dashBoardDetail, listTask.get(indexR));

		}
	}

	private void addWorkTaskSteps(DashboardDetail dashBoardDetail, Task task) {
		TaskDetailBuilder taskBuilder = new TaskDetailBuilder();
		taskBuilder.withTaskName(task.getTaskName()).withTimeEstimate(task.getTimeEstimate())
				.withDueDate(task.getDueDate()).withStatusBefore(task.getStatusBefore())
				.withTaskGroup(task.getTaskGroup()).withTimeCode(task.getTimeCode())
				.withTimeTracking(task.getTimeTracking()).withStatusAfter(task.getStatusAfter());
		TaskDetail taskDetail = taskBuilder.build();

		this.clickPlan();
		this.chooseTeam(dashBoardDetail);
		this.clickSprint(dashBoardDetail);
		this.clickAddNewWorkItem();
		this.clickAddNewTask();
		this.goToDetailTaskPage(taskDetail);
		this.enterTimeEstimate(taskDetail);
		this.enterDueDate(taskDetail);
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
		this.reloadPage();
	}

}
