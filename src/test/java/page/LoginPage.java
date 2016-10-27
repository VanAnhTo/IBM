package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import domain.detail.account.LoginDetails;

public class LoginPage {
	WebDriver driver;

	@FindBy(name = "j_username")
	private WebElement usernameField;

	@FindBy(name = "j_password")
	private WebElement passwordFiel;

	@FindBy(css = ".form button")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsernameAs(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public void enterPasswordAs(String password) {
		passwordFiel.clear();
		passwordFiel.sendKeys(password);
	}

	public void loginToMainPage() {
		loginButton.click();
	}

	public void loginToMainPage(LoginDetails loginDetails) {
		this.enterUsernameAs(loginDetails.getUsername());
		this.enterPasswordAs(loginDetails.getPassword());
		loginButton.click();
		waitForHomePageAppear();

	}

	private void waitForHomePageAppear() {
		util.WaitFor wait = new util.WaitFor(driver);
		wait.presenceOfTheElement(By.cssSelector("div.my-projects.section"));
	}
}
