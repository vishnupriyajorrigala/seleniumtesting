package subjectiveassessment;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {

WebDriver driver;
@BeforeMethod
public void setup() {
    
    driver=new ChromeDriver();
    System.out.println("Before method");
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
    driver.get("http://137.184.76.209/orangehrm-4.9");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
}

@AfterMethod
public void tearup() {
    driver.quit();
    System.out.println("after method");
}
@Test
public void Test1() {
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
//WebElement web=driver.findElement(By.xpath("//a[@id='welcome']"));
//	Select select=new Select(web);
//	List<WebElement> l=select.getOptions();
//    for(WebElement s:l) {
// 	   String str=s.getText();
// 	   if(str.equalsIgnoreCase("Logout")) {
// 	   System.out.println(str);
// 	   s.click();
// 	   break;
//    }
//	}
	AssertJUnit.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	driver.findElement(By.xpath("//a[@id='welcome']")).click();
    driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
}


@Test
public void Test2() {
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw");
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	AssertJUnit.assertTrue(driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed());
}
}