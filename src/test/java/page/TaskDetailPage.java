package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@FindBy(css = "div.SelectOptions ul li:nth-child(2)")
	private WebElement ownedBy;
	
	@FindBy(css = ".EstimateWidget2 .com-ibm-team-apt-web-ui-internal-parts-DurationWidget")
	private WebElement estimateFeild;
		
	@FindBy(css = "input.input")
	private WebElement txtEstimate;

	public void chooseOwnedBy() {
		dropDownOwnedBy.click();
		waitForDropDownOwnedAppear();
		ownedBy.click();
		waitForDropDownOwnedHidden();
	}
	
	public void enterTimeEstimate(String timeEstimate){
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
}
