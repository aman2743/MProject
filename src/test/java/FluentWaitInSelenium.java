

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitInSelenium {
   @Test
   
	public void FluentWaitMechanism() throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
	   Thread.sleep(1000);
//	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	   driver.findElement(By.id("btn2")).click();
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(14))
		       .pollingEvery(Duration.ofSeconds(2))
		       .ignoring(NoSuchElementException.class);

	     WebElement we=wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("txt2"));
		     }
		   });
	 
         we.sendKeys("Custom Text");
	   
   }
}

