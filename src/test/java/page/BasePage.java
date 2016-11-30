package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	protected void findItem(List<WebElement> listItem, String parentCss, String childCss,  String input) {
		for (int i = 1; i <= listItem.size(); i++) {
			String tempParent = parentCss.replace("%INDEX%", Integer.toString(i));
			WebElement parent = driver.findElement(By.cssSelector(tempParent));
			WebElement child = parent.findElement(By.cssSelector(childCss));
			String childText = child.getText();
			if (childText.equals(input)) {
				driver.findElement(By.cssSelector(tempParent)).click();
			}
		}
	}
	
	protected void findItem(List<WebElement> listItem, String parentCss, String input) {
		for (int i = 1; i <= listItem.size(); i++) {
			String tempParent = parentCss.replace("%INDEX%", Integer.toString(i));
			WebElement parent = driver.findElement(By.cssSelector(tempParent));
			String childText = parent.getText();
			if (childText.equals(input)) {
				driver.findElement(By.cssSelector(tempParent)).click();
			}
		}
	}
}
