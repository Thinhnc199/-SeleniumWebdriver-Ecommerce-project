package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductReorder {
    private WebDriver driver;

    By reorder = By.xpath("//a[@class='link-reorder']");
    By editQyt = By.xpath("//input[@title='Qty']");
    By updateButton = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
     By grandTotalLocator = By.xpath("//td[@class='a-right']//span[@class='price']");
//      driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
    By proceedCheckout = By.xpath("//button[@title='Proceed to Checkout']");
    public ProductReorder(WebDriver driver) {
        this.driver = driver;
    }

    public void clickreorder() {
        driver.findElement(reorder).click();
    }
    public void updateQuantity(String qty) {
        driver.findElement(editQyt).clear();
        driver.findElement(editQyt).sendKeys(qty);
        driver.findElement(updateButton).click();
    }
    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        });
    }

    public String getGrandTotal() {
        return driver.findElement(grandTotalLocator).getText();
    }
    public void clickproceedCheckout() {
        driver.findElement(proceedCheckout).click();
    }



}
