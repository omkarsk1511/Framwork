package mocktest.pageobjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import mocktest.actiondriver.Action;

import mocktest.base.BaseClass;
import mocktest.dataprovider.Data;

public class LoginPage extends BaseClass {

	Action action = new Action();

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtn;

	@FindBy(xpath = "//a[@class='link link-primary link-sm']")
	private WebElement forgotPassword;

	///html/body/div[1]/div/div[2]/div/div/div/button[2]
	//		//*[@id="subscriptionModal"]/div/div/div/button[1]/span
	//button.btn:nth-child(7)
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/button[2]")
	private WebElement popUp;
	
	

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage login(HomePage homePage) throws Throwable {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));  // 10 seconds timeout for waiting

		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, Data.adminUName());
		action.type(password, Data.adminPass());
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(1000);
		homePage = new HomePage();
		return homePage;
	}

	public StdHomePage login(StdHomePage stdHomePage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, Data.studentUName());
		action.type(password, Data.studentPass());
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(1000);
		stdHomePage = new StdHomePage();
		return stdHomePage;
	}

	public String getCurrURL() throws Throwable {
		String loginPageURL = action.getCurrentURL(getDriver());
		return loginPageURL;
	}

	public boolean validateUserName() throws Throwable {
		return action.isDisplayed(getDriver(), userName);

	}

	public boolean validatePassword() throws Throwable {
		return action.isDisplayed(getDriver(), password);

	}

	public boolean validateForgotPassword() throws Throwable {
		return action.isDisplayed(getDriver(), forgotPassword);

	}

	public boolean validateSignInBtn() throws Throwable {
		return action.isDisplayed(getDriver(), signInBtn);

	}

}