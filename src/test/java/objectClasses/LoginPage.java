package objectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,LoginPage.this);
	}

	@FindBy(name = "uid")
	WebElement uname;

	@FindBy(name = "passw")
	WebElement password;

	@FindBy(name="btnSubmit")
	WebElement loginButton;

	public void enterUserName(String user) {
		uname.sendKeys(user);
	}

	public void enterPassword(String pwd) {
	password.sendKeys(pwd);;
	}

	public void clickLogin() {
		loginButton.click();
	}

}
