package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC-200:Design of the login page for open cart app")
@Story("US 211:implement login page features for open cart")
public class LoginPageTest extends BaseTest{
	
	
	@Description("login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void loginPageTitletest() {
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	
	@Description("login page url test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void loginPageUrltest() {
		
		String actUrl=loginPage.getLoginPageURL();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
		
	}
	

	@Description("check forgot pwd link exist on login page...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void isForgotPwdLinkExisttest() {
		
	Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	
	@Description("check user is able to open cart with valid credentials ...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4)
	public void logintest() {
		
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.isLogoutLinkExist(), true);
	}

}
