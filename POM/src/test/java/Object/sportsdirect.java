package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sportsdirect {
	WebDriver driver;
  public sportsdirect(WebDriver driver) {
	  this.driver =driver;
  }
  By  goTo = By.xpath("//*[@id=\"CountryRedirectGoLink\"]/div[2]");
  By SearchBox = By.xpath("//*[@id=\"txtSearch\"]");
  By prod =By.xpath("//*[@id=\"navlist\"]/li[1]/div/div/div[2]/div/div[1]");
  By submit = By.xpath("//*[@id=\"cmdSearch\"]/span");
  By selsize = By.partialLinkText("8 (XS)");
  By addtobag = By.id("aAddToBag");
  
public void web() {
	// TODO Auto-generated method stub
	driver.findElement(goTo).click();
}
public void searchProduct(String SearchProduct) {
	driver.findElement(SearchBox).sendKeys(SearchProduct);
	driver.findElement(submit).click();
}
public void searchItem () {
	driver.findElement(prod).click();
	
}
public void selectsize() {
	driver.findElement(selsize).click();
 driver.findElement(addtobag).click();
}

}
