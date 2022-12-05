package subjectiveassessment;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
        driver.get("http://137.184.76.209/orangehrm-4.9");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    @AfterMethod
    public void clearup() {
        driver.quit();

    }
    @Test
    public void createEmp() throws IOException, InterruptedException
    {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        AssertJUnit.assertEquals(driver.findElement(By.xpath("//b[text()='Admin']")).isDisplayed(), true);
        driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        String url=driver.getCurrentUrl();
        AssertJUnit.assertTrue(url.contains("addEmployee"));
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("vishnupriya");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("jorrigala");
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//input[@id='photofile']"))).click().perform();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("C:\\\\Users\\\\visjorri\\\\Desktop\\\\uploadfile.exe");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
        Thread.sleep(2000);
        //WebElement e=driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']"));
        //Assert.assertFalse(e.isEnabled());
        driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Vishnupriya");
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        driver.findElement(By.xpath("//input[@id='ohrmList_chkSelectAll']")).click();
        driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
        driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id()));
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        AssertJUnit.assertTrue(driver.getCurrentUrl().contains("login"));
        
        
    }



}