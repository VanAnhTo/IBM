package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.PropertiesStore;

public class ProjectDashBoardPage {
	WebDriver driver;
	private String team;
	private String comboSelectTeam = "ul li:nth-child(%INDEX%)";
	private String spanSprint = "//span[contains(text(), \'%INDEX%\')]";

	public ProjectDashBoardPage(WebDriver driver) throws IOException {
		this.driver = driver;
		team = PropertiesStore.getProperty("team");
	}

	private WebElement comboTeam;

	@FindBy(id = "jazz_ui_MenuPopup_4")
	private WebElement plansMenu;

	@FindBy(id = "jazz_ui_menu_MenuItem_3_text")
	private WebElement allPlans;

	@FindBy(css = "div.ValueHolder.ViewBorder")
	private WebElement allTeamAreas;

	@FindBy(css = "div.entry.unselected.children.expanded div.entryChildren div:first-child a")
	private WebElement currentSprint;
	
	
	public void clickPlansMenu() {
		plansMenu.click();
		waitForPlanMenuAppear();
	}

	public void clickAllPlans() {
		allPlans.click();
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
		waitForAllPlansAppear();
	}

	public void selectTeamArea() {
		allTeamAreas.click();
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
		waitForComboTeamAppear();
	}

	public void chooseTeam() {
		chooseTeamFromCombo(team);
		waitForDropDownTeamsHidden();
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
	}

	public void clickCurrentSprint() {
		currentSprint.click();
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
		waitContentOfCurrentSprintAppear();
	}

	public void chooseTeamFromCombo(String index) {
		clickSelectTeamFromCombo(comboTeam, index);
	}

	protected void clickSelectTeamFromCombo(WebElement comboTeam, String index) {
		String choosenSelector = comboSelectTeam.replace("%INDEX%", index);
		comboTeam = driver.findElement(By.cssSelector(choosenSelector));
		comboTeam.click();
	}
	
	private String findSprint(String dateOfSprint){
		String dateSprint = spanSprint.replace("%INDEX%", dateOfSprint);
		return dateSprint;
	}

	public void clickSprint(String dateOfSprint){
		WebElement span = driver.findElement(By.xpath(findSprint(dateOfSprint)));
		WebElement parentDiv = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;",span);
		WebElement linkSprint = parentDiv.findElement(By.cssSelector("div.plan a"));
		linkSprint.click();
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
		waitContentOfCurrentSprintAppear();
	}

	private void waitForPlanMenuAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("#jazz_ui_MenuPopup_4_dropdown"));
	}

	private void waitForComboTeamAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(
				"div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable"));
	}

	private void waitForDropDownTeamsHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(
				"div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable"));
	}

	private void waitForStatusMessageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.status-message"));
	}

	private void waitForStatusMessageHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector("div.status-message"));
	}

	private void waitForAllPlansAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.results"));
	}
	
	private void waitContentOfCurrentSprintAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.root.children.expanded"));
	}

}
