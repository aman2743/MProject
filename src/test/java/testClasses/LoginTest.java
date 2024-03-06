package testClasses;

import java.time.Duration;


import org.testng.annotations.Test;

import baseClass.MainClass;

import objectClasses.LoginPage;


public class LoginTest extends MainClass{
	
	@Test
	public void LoginPageTest() {

	    LoginPage lp;
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		lp = new LoginPage(driver);
		// Enter Username
		lp.enterUserName(name);
		// Enter Password
		lp.enterPassword(pwd);
		// Click login button
		lp.clickLogin();
		
	}

	
	
}
