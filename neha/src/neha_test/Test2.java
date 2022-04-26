package neha_test;


	import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Test2 {
		 
	       String appUrl = "https://demoqa.com/books";
	       WebDriver driver;
	     
	       
	 @BeforeSuite
	 public void Login() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "E:\\dee\\Kaam\\chromedriver.exe");
	  driver = new ChromeDriver();
	driver.manage().window().maximize();
	  Thread.sleep(50);


	 }
	@Test(priority=1)
	public void gmailLogin() throws InterruptedException {
		

		driver.get(appUrl); 
	              String actualTitle = driver.getTitle();
	              System.out.println("actualTitle");
	              WebElement Login = driver.findElement(By.id("login"));
	        Login.click();
	        
	        Thread.sleep(5000);
	      //  WebElement Newuser = driver.findElement(By.id("newUser"));
	        WebElement M1 = driver.findElement(By.id("newUser"));
	        JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("arguments[0].scrollIntoView();", M1);
	        M1.click();
	}
	@Test(priority =2)
	public void Registration() throws InterruptedException {
	 WebElement name = driver.findElement(By.id("firstname"));
	 name.sendKeys("abc");
	 WebElement lname = driver.findElement(By.id("lastname"));
	 lname.sendKeys("Sharma");
	       WebElement M2 = driver.findElement(By.id("userName"));
	        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
	        jse1.executeScript("arguments[0].scrollIntoView();", M2);
	      M2.sendKeys("abu");
	 WebElement  pass= driver.findElement(By.id("password"));
	      pass.sendKeys("Abu");
	      
	      driver.findElement(By.id("register")).click();
	      WebElement Regist = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	      String ExpText ="Please verify reCaptcha to register!";
	      String Text =Regist.getText();
	      System.out.println(Text);
	      Assert.assertEquals(Text, ExpText);
	      
	      Thread.sleep(5000);
	      //click captcha
	    //  driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[4]")).click();   
	      driver.findElement(By.id("gotologin")).click();
	}
		@Test(priority=3)
	public void Login1() {
		
		driver.findElement(By.id("userName")).sendKeys("Nesh");
		driver.findElement(By.id("password")).sendKeys("Star@2021");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id("login")).click();
		//WebElement Text =driver.findElement(By.xpath("//*[@id=\"output\"]/div"));
		//System.out.println(Text.getText());
	}
	
@Test(priority = 4)
	public void addbookstore() throws InterruptedException {
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    //Scroll down till the bottom of the page
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    driver.findElement(By.id("gotoStore")).click();
	Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")).click();
    
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]")).click();
    Thread.sleep(3000);      
    
 // Alert interface and switchTo().alert() method
    Alert al = driver.switchTo().alert();
    // click on OK to accept with accept()
    al.accept();
    Thread.sleep(2000); 
}

@Test(priority =5)
public void DeleteBook () throws InterruptedException {
	  
	Actions a = new Actions(driver);
	//scroll up a page
	a.sendKeys(Keys.PAGE_UP).build().perform();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
    Login1();
    Thread.sleep(2000);  
	driver.findElement(By.id("delete-record-undefined")).click(); 
	  Thread.sleep(2000); 
 driver.findElement(By.id("closeSmallModal-ok")).click();
 Thread.sleep(3000);
 // Alert interface and switchTo().alert() method
 Alert al1 = driver.switchTo().alert();
 // click on OK to accept with accept()
 al1.accept();
 
 driver.quit();
}

	}
 