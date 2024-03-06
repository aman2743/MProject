

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitInSelenium {
   @Test
   
	public void ExplicitWaitMechanism() {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver =new ChromeDriver();
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	   driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   driver.findElement(By.id("btn1")).click();
	   WebElement we=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));  
       we.sendKeys("Custom Text");
	   
   }
}

