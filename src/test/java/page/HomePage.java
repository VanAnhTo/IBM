package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
		
	private String project = "div.my-projects.section div div.project:nth-child(%INDEX%) h3 a";

	@FindBy(id = "jazz_ui_ResourceLink_0")
	private WebElement projectLink;
	
	@FindBy(css = "div.my-projects.section div div.project")
	private List<WebElement> listProject;
	
	@FindBy(css = "div.tabArea a:nth-child(2).tab div.title")
	private WebElement tabOther;
	
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	public void goToProjectDashboard() {
		projectLink.click();
		waitForDashboardPageAppear();
	}
	
	public void chooseProject(String curentProject) {	
		findItem(listProject, project, curentProject);
		waitForDashboardPageAppear();
	}
	
	private void waitForDashboardPageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("table.content-table"));
	}
}
