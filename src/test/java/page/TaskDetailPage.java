package page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.task.TaskDetail;

public class TaskDetailPage {
	WebDriver driver;
	private WebElement timeTracking;
	private String timeDueDate;
	// private String dayInTimeTracking;

	protected String txtTimeTracking = "table.tptTable.tptTSTable tbody tr td:nth-child(%INDEX%) input";

	private String elementForDropDown = "div.com-ibm-team-workitem-web-ui-internal-view-editor-mvvm-views-QueryableComboView-DropDown.ViewBorder.PopUp.Filterable";
	private String elementForDropDownCalendarDueDateHidden = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow.Hidden";
	private String elementForDropDownCalendarDueDateAppear = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow";

	public TaskDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".Column.leftColumn tbody tr:nth-child(8) div.ValueHolder.ViewBorder")
	private WebElement dropDownOwnedBy;

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

	@FindBy(css = "div.DatePicker input.dateInput.ViewBorder")
	private WebElement txtDueDate;

	@FindBy(css = "td#Timesheet_weekTextBox div.dijitReset.dijitInputField.dijitInputContainer input.dijitReset")
	private WebElement txtDateTimeTracking;

	@FindBy(css = "td#Timesheet_previous_button a")
	private WebElement btnPrevious;	

	@FindBy(css = "span.CommandArea button.primary-button")
	private WebElement btnSave;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea div.fieldWrapper")
	private WebElement cbxStatus;
	
	@FindBy(css = "div.SummaryArea.DynamicHeaderArea .Select option:nth-child(2)")
	private WebElement optionStartWorking;
	
	@FindBy(css = ".workItemEditor div.SummaryArea.DynamicHeaderArea .Select option:nth-child(4)")
	private WebElement optionInvalid;
	
	@FindBy(css = ".workItemEditor div.SummaryArea.DynamicHeaderArea .Select option:nth-child(3)")
	private WebElement optionComplete;
	
	
	public void clickStartWorking(){
		cbxStatus.click();
		optionStartWorking.click();
	}
	
	public void clickComplete(){
		cbxStatus.click();
		optionInvalid.click();
	}
	

	private int getWeekOfDueDate(String content) {
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		int weekOfDate = 0;
		try {
			Calendar cal = Calendar.getInstance();
			Date date = formatter.parse(content);
			cal.setTime(date);
			weekOfDate = cal.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return weekOfDate;
	}
	
	private int getWeekOfDateTimeTracking(String content) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int weekOfDate = 0;
		try {
			Calendar cal = Calendar.getInstance();
			Date date = formatter.parse(content);
			cal.setTime(date);
			weekOfDate = cal.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return weekOfDate;
	}

	private String getExcuteJavaScript() {
		String s = "document.querySelector('td#Timesheet_weekTextBox div.dijitReset.dijitInputField.dijitInputContainer input:nth-child(2)').value;" +
					"return document.querySelector('td#Timesheet_weekTextBox div.dijitReset.dijitInputField.dijitInputContainer input:nth-child(2)').value";
		return (String) ((JavascriptExecutor) driver).executeScript(s);
	}

	private String getDayInTimeTracking() {
		String dayInTimeTracking = getExcuteJavaScript();
		System.out.println("day in time tracking: " + dayInTimeTracking);
		return dayInTimeTracking;
	}

	private void clickPreviousButton() {
		try {
			int weekOfDueDate = getWeekOfDueDate(timeDueDate);
			System.out.println("week of due date: " + weekOfDueDate);
			String dayInTimeTracking = getDayInTimeTracking();
			int weekOfTimeTracking = getWeekOfDateTimeTracking(dayInTimeTracking);
			System.out.println("week of time tracking: " + weekOfTimeTracking);
			if (weekOfTimeTracking > weekOfDueDate) {
				for (int i = 0; i < weekOfTimeTracking - weekOfDueDate; i++) {
					btnPrevious.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void enterDueDate(String dueDate) {
		txtDueDate.click();
		txtDueDate.clear();
		txtDueDate.sendKeys(dueDate);
		this.timeDueDate = dueDate.substring(0, 12);
		System.out.println("Due date is: " + timeDueDate);
	}

	public void enterDueDateWith(TaskDetail dueDate) {
		this.enterDueDate(dueDate.getDueDate());
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

	public void chooseTaskGroup() {
		cbxTaskGroupOnTabTimeTracking.click();
		waitForDropDownAppear();
		taskGroupOnTabTimeTracking.click();
		waitForDropDownHidden();
	}

	public void clickToAddTimeEntryRow() {
		clickPreviousButton();
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
	
	public void clickSaveTask() {
		btnSave.click();
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
