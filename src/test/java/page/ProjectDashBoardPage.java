package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.PropertiesStore;

public class ProjectDashBoardPage {
	WebDriver driver;

	public ProjectDashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id = "jazz_ui_MenuPopup_4")
	private WebElement plansMenu;

	@FindBy(id = "jazz_ui_menu_MenuItem_3_text")
	private WebElement allPlans;

	@FindBy(css = "div.ValueHolder.ViewBorder")
	private WebElement allTeamAreas;
	
	@FindBy(id = "com_ibm_team_workitem_web_mvvm_view_queryable_combo_QueryableSection_QueryableElement_37")
	private WebElement teamKDD;
	
	public void clickPlansMenu() {
		plansMenu.click();
		waitForPlanMenuAppear();
	}
	
	public void clickAllPlans(){
		allPlans.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTeam(){
		allTeamAreas.click();
	}
	
	public void selectTeamKDD(){
		teamKDD.click();
	}
	

	private void waitForPlanMenuAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("#jazz_ui_MenuPopup_4_dropdown"));
	}
	
}
