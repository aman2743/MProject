

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitInSelenium {
   @Test
   
	public void ImplicitWaitMechanism() {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver =new ChromeDriver();
	   driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.findElement(By.id("btn1")).click();
	   driver.findElement(By.id("txt1")).sendKeys("Custom Text");
	   
   }
}

