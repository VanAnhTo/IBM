package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.task.TaskNameDetail;

public class CurrentSprintPage {
	WebDriver driver;

	public CurrentSprintPage(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	@FindBy(id = "com_ibm_team_rtc_foundation_web_ui_widgets_DropDownButton_3")
	private WebElement dropDownAddWorkItem;

	@FindBy(id = "com_ibm_team_rtc_foundation_web_ui_widgets_IconUrlMenuItem_3")
	private WebElement task;

	@FindBy(css = "input.input.com-ibm-team-apt-web-ui-internal-editor-InPlaceLabelEditor")
	private WebElement txtTaskName;
	
	@FindBy(css = "div.outliner a.label.summaryText")
	private WebElement linkTaskName;

	public void clickDropDownAddWorkItem() {
		dropDownAddWorkItem.click();
	}

	public void clickTaskOnDropDown() {
		task.click();
		waitForTxtTaskNameAppear();
	}

	public void enterTaskName(String taskName) {
		txtTaskName.sendKeys(taskName);
	}

	public void gotoTaskDetailPage(TaskNameDetail taskDetail) {
		this.enterTaskName(taskDetail.getTaskName());
		txtTaskName.sendKeys(Keys.ENTER);
		linkTaskName.sendKeys(Keys.ENTER);
		waitForStatusMessageAppear();
		waitForStatusMessageHidden();
		waitForTaskDetailPageAppear();
	}

	private void waitForTaskDetailPageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.com-ibm-team-workitem-view-layout-SectionLayout"));
	}
	
	private void waitForStatusMessageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.status-message"));
	}

	private void waitForStatusMessageHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector("div.status-message"));
	}
	
	private void waitForTxtTaskNameAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("input.input.com-ibm-team-apt-web-ui-internal-editor-InPlaceLabelEditor"));
	}

}
