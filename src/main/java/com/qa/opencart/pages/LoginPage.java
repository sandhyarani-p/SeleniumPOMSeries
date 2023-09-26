package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
		

	// 1. private By locators - page locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password11");
	private By registerLink = By.linkText("Register");
	private By registerLink1duplicate = By.linkText("Register");
	

	// 2. public Page Constructor
	
		public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public Page actions/methods
	@Step("......gettin login page title....")	
	public String getLoginPageTitle() {		
		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page title is: " + title);
		return title;
	}
	@Step("......gettin login page url....")	
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page url is: " + url);
		return url;
	}
	

	@Step("......is forgot pwd link exist or not....")	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}
	
	@Step("......login to app with username{0} and password :{1}")	
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("App creds are: " + username + ":" + pwd);
		eleUtil.waitForElementVisible(emailId, AppConstants.MEDIUM_TIME_OUT).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		//return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE,AppConstants.SHORT_TIME_OUT);
		return new AccountsPage(driver);
	}
	
	@Step("naviaget tp register page....")
	public RegisterPage navigateToRegisterPage() {
		eleUtil.waitForElementVisible(registerLink, AppConstants.SHORT_TIME_OUT).click();
		return new RegisterPage(driver);
	}
	
	
	

}