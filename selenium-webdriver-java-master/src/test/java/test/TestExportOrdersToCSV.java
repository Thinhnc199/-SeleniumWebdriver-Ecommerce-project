package test;
import model.pages.ExportOrdersToCSV;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestExportOrdersToCSV {
    private WebDriver driver;
    private ExportOrdersToCSV exportOrdersToCSV;

    @BeforeTest
    public void setup() {
        // Set up the WebDriver (Make sure you have ChromeDriver installed and the path set correctly)
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/backendlogin");
        exportOrdersToCSV = new ExportOrdersToCSV(driver);
    }

    @Test
    public void testExportOrdersToCSVScenario() throws IOException {
            exportOrdersToCSV.login("user01","guru99com");
       driver.findElement(By.xpath("//div[@class='message-popup-head']//a[@title='close']")).click();
        driver.findElement(By.linkText("Sales")).click();
        driver.findElement(By.linkText("Orders")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("sales_order_grid_filter_real_order_id")).sendKeys("100021293");
        driver.findElement(By.name("created_at[from]")).sendKeys("01/01/2020");
        driver.findElement(By.name("created_at[to]")).sendKeys("01/01/2024");
        driver.findElement(By.xpath("//button[@title='Search']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 6. Screenshot capture
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotLocation = "./src/screenshot/screenshot.png";
        FileUtils.copyFile(screenshotFile, new File(screenshotLocation));
        System.out.println("Screenshot captured and saved to: " + screenshotLocation);
        }
    }



