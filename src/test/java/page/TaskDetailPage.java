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

	private List<WebElement> timeTracking;
	private String timeDueDate;
	private String formatDueDateOutput = "MMM dd, yyyy";
	
	private String formatDueDateInput = "dd/MM/yyyy";
	
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

	@FindBy(css = "body>div:last-child div.SearchBox input")
	private WebElement txtSearch;

	@FindBy(css = ".EstimateWidget2 .com-ibm-team-apt-web-ui-internal-parts-DurationWidget")
	private WebElement estimateFeild;

	@FindBy(css = "div.EstimateWidget2 input.input")
	private WebElement txtEstimate;

	@FindBy(css = "div.DatePicker a:nth-child(3)")
	private WebElement iconCalendarDueDate;

	@FindBy(css = "div.com-ibm-team-workitem-web-ui-internal-view-mvvm-views-DateTimePopup.Shadow div a.OkButton")
	private WebElement btnOkDueDate;

	@FindBy(css = "div.SectionContent div.ValueHolder.ViewBorder")
	private WebElement divTaskGroup;

	@FindBy(css = "div.SectionContent div.ValueHolder.ViewBorder")
	private List<WebElement> listDivTaskGroup;

	@FindBy(css = "body>div:last-child div.SelectOptions ul li:first-child")
	private WebElement dropDownTaskGroup;

	@FindBy(css = "div.SelectOptions ul li:nth-child(11)")
	private WebElement taskGroupOnTabTimeTracking;

	@FindBy(css = "div.com-ibm-team-workitem div.com-ibm-team-workitem div:last-child div:last-child a:nth-child(5)")
	private WebElement tabTimeTracking;

	@FindBy(css = "span#Timecode_addButton span a span:nth-child(2)")
	private WebElement linkTextTimeEntryRow;

	@FindBy(css = "span#Timecode_addButton span a span:nth-child(2)")
	private List<WebElement> listLinkTextTimeEntryRow;

	@FindBy(css = "div.DatePicker input.dateInput.ViewBorder")
	private WebElement txtDueDate;

	@FindBy(css = "td#Timesheet_weekTextBox div.dijitReset.dijitInputField.dijitInputContainer input.dijitReset")
	private WebElement txtDateTimeTracking;

	@FindBy(css = "td#Timesheet_previous_button a")
	private WebElement btnPrevious;

	@FindBy(css = "td#Timesheet_previous_button a")
	private List<WebElement> listBtnPrevious;

	@FindBy(css = "div.com-ibm-team-workitem div.com-ibm-team-workitem div:last-child div:last-child div.Header1stRow button.primary-button")
	private WebElement btnSave;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea div.fieldWrapper")
	private WebElement divStatus;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea div.fieldWrapper")
	private List<WebElement> listDivStatus;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea .Select")
	private WebElement cbxStatus;

	@FindBy(css = "div.SummaryArea.DynamicHeaderArea .Select")
	private List<WebElement> listCbxStatus;

	@FindBy(css = "table.tptTable.tptTSTable select")
	private WebElement cbxTimeCode;

	@FindBy(css = "body>div:last-child ul li")
	private List<WebElement> listDropOwnedBy;

	private void searchTaskGroup(String taskGroup) {
		// divTaskGroup.click();
		//clickDivTaskGroup();
		clickElementIsDisplay(listDivTaskGroup);
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
		int weekOfDueDate = DateTime.getWeekOfDate(timeDueDate, formatDueDateInput);
		int weekOfTimeTracking = DateTime.getWeekOfDate(getDateInTimeTracking(), formatTimeTracking);
		if (weekOfTimeTracking > weekOfDueDate) {
			for (int i = 0; i < weekOfTimeTracking - weekOfDueDate; i++) {
				// btnPrevious.click();
				//clickBtnPrevious();
				clickElementIsDisplay(listBtnPrevious);
			}
		}
	}

	private void enterTimeTracking(List<WebElement> txtWorkHour, String workHour) {
		String dayOfWeek = String.valueOf(DateTime.getDayOfWeek(timeDueDate, formatDueDateInput) + 2);
		String timeTracking = txtTimeTracking.replace("%INDEX%", dayOfWeek);
		txtWorkHour = driver.findElements(By.cssSelector(timeTracking));
		for (int i = 0; i < txtWorkHour.size(); i++) {
			if (txtWorkHour.get(i).isDisplayed() == true) {
				txtWorkHour.get(i).clear();
				txtWorkHour.get(i).sendKeys(workHour);
			}
		}

	}

	public void enterTimeTracking(String workHour) {
		this.enterTimeTracking(timeTracking, workHour);
	}

	public void enterDueDateWith(TaskDetail dueDate) {
		txtDueDate.click();
		txtDueDate.clear();
		txtDueDate.sendKeys(dueDate.getDueDate() + ", 12:00:00 PM");
		this.timeDueDate = dueDate.getDueDate().substring(0, 12);
	}
	
	public void enterDueDate(String dueDate) {
		txtDueDate.click();
		txtDueDate.clear();
		String date = DateTime.convertToString(DateTime.convertToDate(dueDate, formatDueDateInput), formatDueDateOutput);
		txtDueDate.sendKeys(date + ", 12:00:00 PM");
		this.timeDueDate = dueDate;
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

	public void clickToAddTimeEntryRow() {
		clickPreviousButton();
		// linkTextTimeEntryRow.click();
		//clickLinkTextTimeEntryRow();
		clickElementIsDisplay(listLinkTextTimeEntryRow);
	}

	public void clickSaveTask() {
		btnSave.click();
		waitCompletedProcess();
	}

	public void chooseStatus(String status) {
		String statusValue = IbmEnum.Status.valueOf(status).value;
		Select selectStatus = new Select(getElementIsDIsplay(listCbxStatus));
		selectStatus.selectByValue(statusValue);
	}

	public void chooseOwnedBy() {
		divOwnedBy.click();
		waitForDropDownAppear();
		findItem(listDropOwnedBy, ownedBy, childSpan, LoginPage.username);
		waitForDropDownHidden();
	}

	public void chooseTimeCode(String timeCode) {
		cbxTimeCode.click();
		Select sl = new Select(cbxTimeCode);
		sl.selectByVisibleText(timeCode);
	}

	public void chooseTaskGroup(String taskGroup) {
		searchTaskGroup(taskGroup);
		dropDownTaskGroup.click();
		waitForDropDownHidden();
	}

}
