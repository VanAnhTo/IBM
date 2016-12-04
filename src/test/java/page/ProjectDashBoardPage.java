package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProjectDashBoardPage extends BasePage {

	public ProjectDashBoardPage(WebDriver driver) throws IOException {
		super(driver);
	}

	private String spanSprint = "//span[contains(text(), \'%DATE%\')]";
	private String divSprintByJs = "return arguments[0].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;";
	private String menuPlan = "#jazz_ui_MenuPopup_4_dropdown";
	private String comboTeamList = "div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable";

	
	private String teamSelected = "body>div:last-child div.SelectOptions ul li:nth-child(%INDEX%)";
	private String childSpan = "span:nth-child(3)";

	@FindBy(id = "jazz_ui_MenuPopup_4")
	private WebElement plansMenu;

	@FindBy(css = "#jazz_ui_Menu_0 tbody tr:nth-child(5) a.itemHref")
	private WebElement allPlans;
	
	@FindBy(css = "div.pagination-container div.ValueHolder.ViewBorder")
	private WebElement divTeams;

	@FindBy(css = "div.SelectOptions ul li")
	private List<WebElement> listTeam;

	@FindBy(css = "div.entry.unselected.children.expanded div.entryChildren div:first-child a")
	private WebElement currentSprint;

	public void reload(){
		//driver.navigate().refresh();
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
		waitForDashboardPageAppear();
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
	
	private void waitForDashboardPageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("table.content-table"));
	}

	public void clickSprint(String dateOfSprint) {
		String date = spanSprint.replace("%DATE%", dateOfSprint);
		WebElement span = driver.findElement(By.xpath(date));
		WebElement parentDiv = (WebElement) ((JavascriptExecutor) driver).executeScript(divSprintByJs, span);
		WebElement linkSprint = parentDiv.findElement(By.cssSelector("div.plan a"));
		new Actions(driver).moveToElement(linkSprint).click().perform();
		waitCompletedProcess();
		waitContentOfCurrentSprintAppear();
	}
	
	public void clickPlan() {
		plansMenu.click();
		waitForPlanMenuAppear() ;
		new Actions(driver).moveToElement(allPlans).click().perform();
		waitCompletedProcess();
		waitForAllPlansAppear();
	}
	
	public void chooseTeam(String team) {
		divTeams.click();
		waitCompletedProcess();
		waitForDropdownTeamsAppear();
		findItem(listTeam, teamSelected, childSpan, team);
		waitForDropDownTeamsHidden();
		waitCompletedProcess();
	}

}
