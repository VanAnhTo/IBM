package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import domain.detail.task.TaskDetail;

public class CurrentSprintPage extends BasePage {

	public CurrentSprintPage(WebDriver driver) {
		super(driver);
		
	}
	Actions action = new Actions(driver);
	
	private String taskDetailPage = "div.com-ibm-team-workitem-view-layout-SectionLayout";
	private String taskName = "input.input.com-ibm-team-apt-web-ui-internal-editor-InPlaceLabelEditor";

	@FindBy(id = "com_ibm_team_rtc_foundation_web_ui_widgets_DropDownButton_3")
	private WebElement dropDownAddWorkItem;

	@FindBy(id = "com_ibm_team_rtc_foundation_web_ui_widgets_IconUrlMenuItem_3_text")
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
	
	private void enterTaskName(String taskName) {
		txtTaskName.sendKeys(taskName);
	}
	
	public void clickDropDownAddWorkItem() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
		dropDownAddWorkItem.click();
	}

	public void clickTaskOnDropDown() {
		task.click();
		waitForTaskNameAppear();
	}
	
	public void gotoTaskDetailPageWithTaskName(TaskDetail taskDetail) {
		enterTaskName(taskDetail.getTaskName());
		
		txtTaskName.sendKeys(Keys.ENTER);
		action.moveToElement(linkTaskName).sendKeys(Keys.ENTER).perform();
		//linkTaskName.sendKeys(Keys.ENTER);
		waitCompletedProcess();
		waitForTaskDetailPageAppear();
	}

}
