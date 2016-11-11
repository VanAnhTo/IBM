package util;

import domain.detail.account.LoginDetails;
import domain.detail.task.TaskNameDetail;
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

	public void browsePlans() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickPlansMenu();
	}
	
	public void clickAllPlans() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickAllPlans();
	}
	
	public void selectTeamArea() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.selectTeamArea();
	}

	public void chooseTeam() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.chooseTeam();
		
	}

	public void chooseTeamKDD() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.selectTeamKDD();
	}

	public void clickCurrentSprint() {
		ProjectDashBoardPage onProjectDashBoardPagee = pageStore.get(ProjectDashBoardPage.class);
		onProjectDashBoardPagee.clickCurrentSprint();	
	}

	public void clickAddNewWorkItem() {
		CurrentSprintPage onCurrentSprintPage = pageStore.get(CurrentSprintPage.class);
		onCurrentSprintPage.clickDropDownAddWorkItem();			
	}

	public void clickAddNewTask() {
		CurrentSprintPage onCurrentSprintPage = pageStore.get(CurrentSprintPage.class);
		onCurrentSprintPage.clickTaskOnDropDown();	
	}

	public void goToDetailTaskPage(TaskNameDetail taskDetail) {
		CurrentSprintPage onCurrentSprintPage = pageStore.get(CurrentSprintPage.class);
		onCurrentSprintPage.gotoTaskDetailPage(taskDetail);
	}

	public void clickOwnedBy() {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.chooseOwnedBy();
	}

	public void enterTimeEstimate(TaskNameDetail taskDetail) {
		TaskDetailPage onTaskDetailPage = pageStore.get(TaskDetailPage.class);
		onTaskDetailPage.enterWith(taskDetail);
	}
	
	

}
