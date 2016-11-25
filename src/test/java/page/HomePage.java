package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	@FindBy(id = "jazz_ui_ResourceLink_0")
	private WebElement projectLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToProjectDashboard() {
		projectLink.click();
		waitForDashboardPageAppear();
	}
	
	private void waitForDashboardPageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("table.content-table"));
	}
}
