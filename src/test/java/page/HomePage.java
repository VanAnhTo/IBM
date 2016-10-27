package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	@FindBy(id = "jazz_ui_ResourceLink_0")
	private WebElement projectLink;
	
	public void goToProjectDashboard() {
		projectLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//waitForDashboardPageAppear();
	}
	
	/*private void waitForDashboardPageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.id("dijit_InlineEditBox_0"));
	}*/
}
