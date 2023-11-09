package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExportOrdersToCSV {

    private WebDriver driver;

    private By username = By.id("username");
    private By passwordID = By.id("login");
    private By loginBtn = By.cssSelector("[type='submit']");

    By chooseSales = By.xpath("//span[normalize-space()='Sales']");
//    By chooseSales = By.xpath("//a[span[normalize-space()='Sales' and @onclick='return false']]");

//    By Salesorders = By.xpath("//span[normalize-space()='Orders']");
By Salesorders = By.xpath("//a[contains(@href,'backendlogin/sales_order')]/span[normalize-space(text())='Orders']");


    public ExportOrdersToCSV(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String userid, String password) {
        driver.findElement(username).sendKeys(userid);
        driver.findElement(passwordID).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        });
    }
    public void clickChooseSales() {
        driver.findElement(chooseSales);
    }

    public void clickSalesorders() {
        driver.findElement(Salesorders).click();
    }



}
