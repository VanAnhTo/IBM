package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.task.TaskDetail;

public class TaskDetailPage {
	WebDriver driver;
	protected WebElement timeTracking;

	protected String txtTimeTracking = "table.tptTable.tptTSTable tbody tr td:nth-child(%INDEX%) input";
	
	private String elementForDropDown = "div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable";
	private String elementForDropDownCalendarDueDateHidden = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow.Hidden";
	private String elementForDropDownCalendarDueDateAppear = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow";

	public TaskDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".Column.leftColumn tbody tr:nth-child(8) div.ValueHolder.ViewBorder")
	private WebElement dropDownOwnedBy;

	//@FindBy(xpath = "/html/body/div[13]/div[2]/div[1]/ul/li[2]")
	@FindBy(css = "body>div:last-child ul li:nth-child(2)")
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

	@FindBy(css = "span.CommandArea button.primary-button")
	private WebElement btnSave;

	public void clickSaveTask() {
		btnSave.click();
	}

	public void chooseOwnedBy() {
		dropDownOwnedBy.click();
		waitForDropDownAppear();
		ownedBy.click();
		waitForDropDownHidden();
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

	public void enterTimeEstimateWith(TaskDetail timeEstimate) {
		this.enterTimeEstimate(timeEstimate.getTimeEstimate());
	}

	public void clickTabTimeTracking() {
		tabTimeTracking.click();
	}
	
	public void chooseTaskGroup() {
		cbxTaskGroupOnTabTimeTracking.click();
		waitForDropDownAppear();
		taskGroupOnTabTimeTracking.click();
		waitForDropDownHidden();
	}

	public void clickToAddTimeEntryRow() {
		linkTextTimeEntryRow.click();
	}

	public void enterTimeTracking(String index, String workHour) {
		this.enterTimeTracking(timeTracking, index, workHour);
	}

	protected void enterTimeTracking(WebElement txtWorkHour, String index, String workHour) {
		String timeTracking = txtTimeTracking.replace("%INDEX%", index);
		txtWorkHour = driver.findElement(By.cssSelector(timeTracking));
		txtWorkHour.clear();
		txtWorkHour.sendKeys(workHour);
	}	
	
	private void waitForDropDownAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(elementForDropDown));
	}

	private void waitForDropDownHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(elementForDropDown));
	}

	private void waitForDropDownCalendarDueDateHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(elementForDropDownCalendarDueDateHidden));
	}

	private void waitForDropDownCalendarDueDateAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(elementForDropDownCalendarDueDateAppear));
	}

}
