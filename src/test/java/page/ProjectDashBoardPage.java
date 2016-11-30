package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import util.PropertiesStore;

public class ProjectDashBoardPage extends BasePage {

	public ProjectDashBoardPage(WebDriver driver) throws IOException {
		super(driver);
		team = PropertiesStore.getProperty("team");
	}

	private String team;
	private String spanSprint = "//span[contains(text(), \'%DATE%\')]";
	private String divSprintByJs = "return arguments[0].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;";
	private String menuPlan = "#jazz_ui_MenuPopup_4_dropdown";
	private String comboTeamList = "div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable";

	private String comboSelectTeam = "ul li:nth-child(%INDEX%)";
	private WebElement comboTeam;

	@FindBy(id = "jazz_ui_MenuPopup_4")
	private WebElement plansMenu;

	@FindBy(id = "jazz_ui_menu_MenuItem_3_text")
	private WebElement allPlans;

	@FindBy(css = "div.ValueHolder.ViewBorder")
	private WebElement allTeamAreas;

	@FindBy(css = "div.entry.unselected.children.expanded div.entryChildren div:first-child a")
	private WebElement currentSprint;

	private void clickSelectTeamFromCombo(WebElement comboTeam, String index) {
		String choosenSelector = comboSelectTeam.replace("%INDEX%", index);
		comboTeam = driver.findElement(By.cssSelector(choosenSelector));
		comboTeam.click();
	}

	private void waitForPlanMenuAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(menuPlan));
	}

	private void waitForDropdownTeamsAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(comboTeamList));
	}

	private void waitForDropDownTeamsHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(comboTeamList));
	}

	public void clickSprint(String dateOfSprint) {
		String date = spanSprint.replace("%DATE%", dateOfSprint);
		WebElement span = driver.findElement(By.xpath(date));
		WebElement parentDiv = (WebElement) ((JavascriptExecutor) driver).executeScript(divSprintByJs, span);
		WebElement linkSprint = parentDiv.findElement(By.cssSelector("div.plan a"));
		new Actions(driver).moveToElement(linkSprint).click().perform();
		//linkSprint.click();
		waitCompletedProcess();
		waitContentOfCurrentSprintAppear();
	}

	public void clickPlansMenu() {
		plansMenu.click();
		waitForPlanMenuAppear();
	}

	public void clickAllPlans() {
		this.allPlans.click();
		waitCompletedProcess();
		waitForAllPlansAppear();
	}

	public void chooseTeamArea() {
		this.allTeamAreas.click();
		waitCompletedProcess();
		waitForDropdownTeamsAppear();
	}

	public void chooseTeam() {
		chooseTeamFromCombo(team);
		waitForDropDownTeamsHidden();
		waitCompletedProcess();
	}

	public void clickCurrentSprint() {
		currentSprint.click();
		waitCompletedProcess();
		waitContentOfCurrentSprintAppear();
	}

	public void chooseTeamFromCombo(String index) {
		clickSelectTeamFromCombo(comboTeam, index);
	}

}
