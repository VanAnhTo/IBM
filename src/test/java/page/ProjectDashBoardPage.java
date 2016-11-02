package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.PropertiesStore;

public class ProjectDashBoardPage {
	WebDriver driver;
	private String team;
	protected String ComboSelectTeam = "ul li:nth-child(%INDEX%)";
	
	public ProjectDashBoardPage(WebDriver driver) throws IOException {
		this.driver = driver;
		team = PropertiesStore.getProperty("team");
	}
	protected WebElement comboTeam;

	@FindBy(id = "jazz_ui_MenuPopup_4")
	private WebElement plansMenu;

	@FindBy(id = "jazz_ui_menu_MenuItem_3_text")
	private WebElement allPlans;

	@FindBy(css = "div.ValueHolder.ViewBorder")
	private WebElement allTeamAreas;

	@FindBy(css = "ul li:nth-child(6)")
	private WebElement teamKDD;
	
	@FindBy(css = "div.entry.unselected.children.expanded div.entryChildren div:first-child a")
	private WebElement sprint;
	
	public void clickPlansMenu() {
		plansMenu.click();
		waitForPlanMenuAppear();
	}

	public void clickAllPlans() {
		allPlans.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectTeamArea() {
		allTeamAreas.click();
		waitForComboTeamAppear();
	}

	public void selectTeamKDD() {
		teamKDD.click();
	}
	
	public void clickSprint() {
		sprint.click();
	}
	
		
	public void chooseTeam() {
		chooseTeamFromCombo(team);
		waitForListSprintAppear();
	}
	
	public void chooseTeamFromCombo(String index) {
		clickSelectTeamFromCombo(comboTeam,index);
	}
	
	protected void clickSelectTeamFromCombo(WebElement comboTeam, String index) {
		String choosenSelector = ComboSelectTeam.replace("%INDEX%", index);
		comboTeam = driver.findElement(By.cssSelector(choosenSelector));
		comboTeam.click();
	}

	private void waitForPlanMenuAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("#jazz_ui_MenuPopup_4_dropdown"));
	}
	
	private void waitForComboTeamAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("ul li:nth-child(6)"));
	}
	
	private void waitForListSprintAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.entryChildren"));
	}
}
