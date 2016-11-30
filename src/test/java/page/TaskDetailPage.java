package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import domain.detail.task.TaskDetail;
import util.DateTime;
import util.IbmEnum;

public class TaskDetailPage extends BasePage {
	public TaskDetailPage(WebDriver driver) {
		super(driver);
	}

	private WebElement timeTracking;
	private String timeDueDate;
	private String formatDueDate = "MMM dd, yyyy";
	private String formatTimeTracking = "yyyy-MM-dd";
	private String txtTimeTracking = "table.tptTable.tptTSTable tbody tr td:nth-child(%INDEX%) input";
	private String ownedBy = "body>div:last-child ul li:nth-child(%INDEX%)";
	
	private String childSpan = "span:nth-child(3)";

	private String dropDown = "div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable";
	private String calendarDueDate = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow%s";
	private String dateTimeTracking = "td#Timesheet_weekTextBox div.dijitReset.dijitInputField.dijitInputContainer input:nth-child(2)";

	@FindBy(css = ".Column.leftColumn tbody tr:nth-child(8) div.ValueHolder.ViewBorder")
	private WebElement divOwnedBy;

	@FindBy(css = "body>div:last-child ul li:first-child")
	private WebElement dropDownOwnedBy;

	/*@FindBy(css = "body>div:last-child ul li:nth-child(2)")
	private WebElement ownedBy;*/

	@FindBy(css = "body>div:last-child div.SearchBox input")
	private WebElement txtSearch;

	@FindBy(css = ".EstimateWidget2 .com-ibm-team-apt-web-ui-internal-parts-DurationWidget")
	private WebElement estimateFeild;

	@FindBy(css = "input.input")
	private WebElement txtEstimate;

	@FindBy(css = "div.DatePicker a:nth-child(3)")
	private WebElement iconCalendarDueDate;

	@FindBy(css = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow div a.OkButton")
	private WebElement btnOkDueDate;

	@FindBy(css = "div.ValueHolder.ViewBorder")
	private WebElement divTaskGroup;

	@FindBy(css = "div.SelectOptions ul li:first-child")
	private WebElement dropDownTaskGroup;

	@FindBy(css = "div.SelectOptions ul li:nth-child(11)")
	private WebElement taskGroupOnTabTimeTracking;

	@FindBy(css = "div.TabArea a:nth-child(5)")
	private WebElement tabTimeTracking;

	@FindBy(css = "span#Timecode_addButton span a span:nth-child(2)")
	private WebElement linkTextTimeEntryRow;

	@FindBy(css = "div.DatePicker input.dateInput.ViewBorder")
	private WebElement txtDueDate;

	@FindBy(css = "td#Timesheet_weekTextBox div.dijitReset.dijitInputField.dijitInputContainer input.dijitReset")
	private WebElement txtDateTimeTracking;

	@FindBy(css = "td#Timesheet_previous_button a")
	private WebElement btnPrevious;

	@FindBy(css = "span.CommandArea button.primary-button")
	private WebElement btnSave;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea div.fieldWrapper")
	private WebElement divStatus;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea .Select")
	private WebElement cbxStatus;

	@FindBy(css = "table.tptTable.tptTSTable select")
	private WebElement cbxTimeCode;

	@FindBy(css = "body>div:last-child ul li")
	private List<WebElement> listDropOwnedBy;

	private void searchTaskGroup(String taskGroup) {
		divTaskGroup.click();
		waitForDropDownAppear();
		txtSearch.sendKeys(taskGroup);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void waitForDropDownAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(dropDown));
	}

	private void waitForDropDownHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.hiddenOfTheElement(By.cssSelector(dropDown));
	}

	private void waitForDropDownCalendarDueDateHidden() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(String.format(calendarDueDate, ".Hidden")));
	}

	private void waitForDropDownCalendarDueDateAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector(String.format(calendarDueDate, "")));
	}

	private String getDateInTimeTracking() {
		// String s = "return document.querySelector('" + dateTimeTracking +
		// "').value";
		String s = String.format("return document.querySelector('%s').value", dateTimeTracking);
		return (String) ((JavascriptExecutor) driver).executeScript(s);
	}

	private void clickPreviousButton() {
		int weekOfDueDate = DateTime.getWeekOfDate(timeDueDate, formatDueDate);
		int weekOfTimeTracking = DateTime.getWeekOfDate(getDateInTimeTracking(), formatTimeTracking);
		if (weekOfTimeTracking > weekOfDueDate) {
			for (int i = 0; i < weekOfTimeTracking - weekOfDueDate; i++) {
				btnPrevious.click();
			}
		}
	}

	private void enterTimeTracking(WebElement txtWorkHour, String workHour) {
		String dayOfWeek = String.valueOf(DateTime.getDayOfWeek(timeDueDate, formatDueDate) + 2);
		String timeTracking = txtTimeTracking.replace("%INDEX%", dayOfWeek);
		txtWorkHour = driver.findElement(By.cssSelector(timeTracking));
		txtWorkHour.clear();
		txtWorkHour.sendKeys(workHour);
	}

	public void enterTimeTracking(String workHour) {
		this.enterTimeTracking(timeTracking, workHour);
	}

	public void enterDueDateWith(TaskDetail dueDate) {
		txtDueDate.click();
		txtDueDate.clear();
		txtDueDate.sendKeys(dueDate.getDueDate());
		this.timeDueDate = dueDate.getDueDate().substring(0, 12);
	}

	/*public void chooseOwnedBy() {
		dropDownOwnedBy.click();
		waitForDropDownAppear();
		ownedBy.click();
		waitForDropDownHidden();
	}*/

	public void chooseDueDate() {
		iconCalendarDueDate.click();
		waitForDropDownCalendarDueDateAppear();
		btnOkDueDate.click();
		waitForDropDownCalendarDueDateHidden();
	}

	private void enterTimeEstimate(String timeEstimate) {
		estimateFeild.click();
		txtEstimate.sendKeys(timeEstimate);
	}

	public void enterTimeEstimateWith(TaskDetail timeEstimate) {
		this.enterTimeEstimate(timeEstimate.getTimeEstimate());
	}

	public void clickTabTimeTracking() {
		tabTimeTracking.click();
	}

	public void clickToAddTimeEntryRow() {
		clickPreviousButton();
		linkTextTimeEntryRow.click();
	}

	public void clickSaveTask() {
		btnSave.click();
		waitCompletedProcess();
	}

	public void chooseStatus(String status) {
		String statusValue = IbmEnum.Status.valueOf(status).value;
		Select selectStatus = new Select(cbxStatus);
		selectStatus.selectByValue(statusValue);
	}

	/*private void searchOwnedBy() {
		divOwnedBy.click();
		waitForDropDownAppear();
		txtSearch.sendKeys(LoginPage.username);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickOwnedBy() {
		searchOwnedBy();
		dropDownOwnedBy.click();
		waitForDropDownHidden();
	}*/
	
	public void chooseOwnedBy() {
		divOwnedBy.click();
		waitForDropDownAppear();
		findItem(listDropOwnedBy, ownedBy, childSpan, LoginPage.username);
		waitForDropDownHidden();
	}


	public void chooseTimeCode(String timeCode) {
		cbxTimeCode.click();
		Select slectStatus = new Select(cbxTimeCode);
		slectStatus.selectByVisibleText(timeCode);
	}

	public void chooseTaskGroup(String taskGroup) {
		searchTaskGroup(taskGroup);
		dropDownTaskGroup.click();
		waitForDropDownHidden();
	}

}
