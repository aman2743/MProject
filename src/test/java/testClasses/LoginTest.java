package testClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
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
		String actualText=driver.findElement(By.xpath("//font[text()='Sign Off']")).getText();
		String expectedText="Sign Off";
		Assert.assertEquals(actualText, expectedText);
	    System.out.println(driver.getTitle()+driver.getPageSource());
		
	}

	
	
}
