package test;

import model.pages.ExportOrdersToCSV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void TestExportOrdersToCSV(){
            exportOrdersToCSV.login("user01","guru99com");
            exportOrdersToCSV.waitForPageLoad();
            exportOrdersToCSV.clickChooseSales();
            exportOrdersToCSV.waitForPageLoad();
            exportOrdersToCSV.clickSalesorders();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li#sales_order_menu")));
        driver.findElement(By.cssSelector("li#sales_order_menu")).click();

        // Selecting 'CSV' in Export To dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#sales_order_grid_export")));
        Select exportDropdown = new Select(driver.findElement(By.cssSelector("select#sales_order_grid_export")));
        exportDropdown.selectByVisibleText("CSV");

        // Clicking the Export button
        driver.findElement(By.cssSelector("button[title='Export']")).click();

    }


}
