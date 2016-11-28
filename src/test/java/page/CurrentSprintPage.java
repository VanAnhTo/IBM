package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.task.TaskDetail;

public class CurrentSprintPage extends BasePage {

	public CurrentSprintPage(WebDriver driver) {
		super(driver);
	}
	
	private String taskDetailPage = "div.com-ibm-team-workitem-view-layout-SectionLayout";
	private String taskName = "input.input.com-ibm-team-apt-web-ui-internal-editor-InPlaceLabelEditor";

	@FindBy(id = "com_ibm_team_rtc_foundation_web_ui_widgets_DropDownButton_3")
	private WebElement dropDownAddWorkItem;

	@FindBy(id = "com_ibm_team_rtc_foundation_web_ui_widgets_IconUrlMenuItem_3")
	private WebElement task;

	@FindBy(css = "input.input.com-ibm-team-apt-web-ui-internal-editor-InPlaceLabelEditor")
	private WebElement txtTaskName;
	
	@FindBy(css = "div.outliner a.label.summaryText")
	private WebElement linkTaskName;

	private void waitForTaskDetailPageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(taskDetailPage));
	}
	
	private void waitForTaskNameAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(taskName));
	}
	
	public void clickDropDownAddWorkItem() {
		dropDownAddWorkItem.click();
	}

	public void clickTaskOnDropDown() {
		task.click();
		waitForTaskNameAppear();
	}

	public void enterTaskName(String taskName) {
		txtTaskName.sendKeys(taskName);
	}

	public void gotoTaskDetailPage(TaskDetail taskDetail) {
		this.enterTaskName(taskDetail.getTaskName());
		txtTaskName.sendKeys(Keys.ENTER);
		linkTaskName.sendKeys(Keys.ENTER);
		waitCompletedProcess();
		waitForTaskDetailPageAppear();
	}

}
