package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected void waitCompletedProcess() {
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
	}
	
	private void waitForStatusMessageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.status-message"));
	}

	private void waitForStatusMessageHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector("div.status-message"));
	}
	
	protected void waitForAllPlansAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.results"));
	}

	protected void waitContentOfCurrentSprintAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.root.children.expanded"));
	}
}
