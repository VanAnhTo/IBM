package step_definitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import domain.builder.account.LoginDetailBuilder;
import domain.builder.task.DashBoardBuilder;
import domain.detail.account.LoginDetails;
import domain.detail.task.DashboardDetail;
import util.PageStore;
import util.Specification;

public class Login_Steps {
	public WebDriver driver;

	LoginDetailBuilder builder;
	DashBoardBuilder dashBoardBuilder;
	Specification user;
	PageStore pageStore;

	public Login_Steps() {
		this.builder = new LoginDetailBuilder();
		this.dashBoardBuilder = new DashBoardBuilder();
		this.driver = Hooks.driver;
		this.pageStore = new PageStore(driver);
		this.user = new Specification(pageStore);
	}

	@Given("^I open browser and enter link website \"(.*)\"$")
	public void i_open_browser_and_enter_link_website(String linkWeb) {
		driver.get(linkWeb);
	}

	@And("^I fill login form$")
	public void i_fill_login_form(DataTable loginDataTable) {
		List<List<String>> result = loginDataTable.raw();
		String username = result.get(1).get(0);
		String password = result.get(1).get(1);
		builder.withUsername(username).withPassword(password);
	}

	@And("^I login$")
	public void i_get_homepage() {
		LoginDetails loginDetails = builder.build();
		user.clickLoginWith(loginDetails);
	}

	@Given("I go to project dashboard page")
	public void i_go_to_projectdashboard() {
		user.goToProjectDashboard();
	}
/*
	@When("I click plan menu")
	public void i_click_plan_menu() {
		user.browsePlans();
	}

	@And("I click to see all plans")
	public void i_see_all_plans() {
		user.clickAllPlans();
	}*/
	
	

	/*@And("I select team area")
	public void i_select_team_area() {
		user.selectTeamArea();
	}*/
/*
	@And("I choose a team")
	public void i_choose_team() {
		user.chooseTeam();
	}*/
	
	@When("I click all plan")
	public void i_click_plan_menu() {
		user.clickPlan();
	}

	@And("I choose team \"(.*)\"")
	public void i_choose_team(String team) {
		dashBoardBuilder.withTeam(team);
		DashboardDetail dashBoardDetail = dashBoardBuilder.build();
		user.chooseTeam(dashBoardDetail);
	}

	@And("I click the sprint has time \"(.*)\"")
	public void i_click_sprint(String sprintDate) {
		dashBoardBuilder.withSprintDate(sprintDate);
		DashboardDetail dashBoardDetail = dashBoardBuilder.build();
		user.clickSprint(dashBoardDetail);
	}
	
	@Given("I go to current project \"(.*)\"")
	public void i_go_to_current_project(String currentProject) {
		dashBoardBuilder.withCurrentProject(currentProject);
		DashboardDetail dashBoardDetail = dashBoardBuilder.build();
		user.chooseCurrentProject(dashBoardDetail);
	}
}
