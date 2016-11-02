package step_definitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import domain.builder.account.LoginDetailBuilder;
import domain.detail.account.LoginDetails;
import util.PageStore;
import util.Specification;

public class Login_Steps {
	public WebDriver driver;

	LoginDetailBuilder builder;
	Specification user;
	PageStore pageStore;

	public Login_Steps() {
		this.builder = new LoginDetailBuilder();
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

	@And("I go to project dashboard page")
	public void i_go_to_projectdashboard() {
		user.goToProjectDashboard();
	}

	@And("I click plan menu")
	public void i_click_plan_menu() {
		user.browsePlans();
	}

	@And("I click to see all plans")
	public void i_see_all_plans() {
		user.clickAllPlans();
	}

	@And("I select team area")
	public void i_select_team_area() {
		user.selectTeamArea();
	}

	@And("I choose team")
	public void i_choose_team() {
		user.chooseTeam();
	}
	
	@And("I choose KDD team")
	public void i_choose_team_KDD() {
		user.chooseTeamKDD();
	}
	
	@And("I click sprint")
	public void i_click_sprint() {
		user.clickSprint();
	}
}
