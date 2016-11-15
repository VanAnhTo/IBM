package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.task.TaskNameDetail;

public class TaskDetailPage {
	WebDriver driver;

	public TaskDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".Column.leftColumn tbody tr:nth-child(8) div.ValueHolder.ViewBorder")
	private WebElement dropDownOwnedBy;

	@FindBy(css = "div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable div.SelectOptions ul li:nth-child(2)")
	private WebElement ownedBy;

	@FindBy(css = ".EstimateWidget2 .com-ibm-team-apt-web-ui-internal-parts-DurationWidget")
	private WebElement estimateFeild;

	@FindBy(css = "input.input")
	private WebElement txtEstimate;

	@FindBy(css = "div.DatePicker a:nth-child(3)")
	private WebElement iconCalendarDueDate;

	@FindBy(css = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow div a.OkButton")
	private WebElement btnOkDueDate;
	
	@FindBy(css = "div.ValueHolder.ViewBorder")
	private WebElement cbxTaskGroupOnTabTimeTracking;
	
	@FindBy(css = "div.SelectOptions ul li:nth-child(11)")
	private WebElement taskGroupOnTabTimeTracking;
	
	@FindBy(css = "div.TabArea a:nth-child(5)")
	private WebElement tabTimeTracking;
	
	@FindBy(css = "span#Timecode_addButton span a span:nth-child(2)")
	private WebElement linkTextTimeEntryRow;

	public void chooseOwnedBy() {
		dropDownOwnedBy.click();
		waitForDropDownOwnedAppear();
		ownedBy.click();
		waitForDropDownOwnedHidden();
	}

	public void chooseDueDate() {
		iconCalendarDueDate.click();
		waitForDropDownCalendarDueDateAppear();
		btnOkDueDate.click();
		waitForDropDownCalendarDueDateHidden();
	}

	public void enterTimeEstimate(String timeEstimate) {
		estimateFeild.click();
		txtEstimate.sendKeys(timeEstimate);
	}

	public void enterWith(TaskNameDetail timeEstimate) {
		this.enterTimeEstimate(timeEstimate.getTimeEstimate());
	}

	private void waitForDropDownOwnedAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(
				"div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable"));
	}

	private void waitForDropDownOwnedHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(
				"div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable"));
	}

	private void waitForDropDownCalendarDueDateHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By
				.cssSelector("div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow.Hidden"));
	}

	private void waitForDropDownCalendarDueDateAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(
				By.cssSelector("div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow"));
	}
}
