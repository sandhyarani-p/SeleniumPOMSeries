package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageTitletest() {
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void loginPageUrltest() {
		
		String actUrl=loginPage.getLoginPageURL();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
		
	}
	@Test(priority=3)
	public void isForgotPwdLinkExisttest() {
		
	Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority=4)
	public void logintest() {
		
		accPage = loginPage.doLogin("janautomation@gmail.com", "Selenium@12345");
		Assert.assertEquals(accPage.isLogoutLinkExist(), true);
	}

}
