package TestMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object.sportsdirect;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases {
	WebDriver driver;
	
 @BeforeTest
 public void initiatedriver() {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	 driver.get("https://lv.sportsdirect.com/");
	 driver.manage().window().maximize();
 }
 @Test(priority =1 )
 public void estonia() {
	 sportsdirect page = new sportsdirect(driver);
	  page.web();
 }
 @Test(priority =2)
 public void searchProduct() throws InterruptedException {
	 sportsdirect page = new sportsdirect(driver);
	 page.searchProduct("WOMEN'S FLEECES");
	 Thread.sleep(2000);
     page.searchItem();
     page.selectsize();
    
     Thread.sleep(4000);
 }
 
@AfterTest
 public void close() {
 driver.quit();
}
}
