package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CompareProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    By mobileMenuLink = By.xpath("//a[contains(., 'Mobile')]");
    By addSonyXperia = By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    By addiPhone = By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    By compareButton = By.xpath("//button[@title='Compare']");

    public CompareProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenuLink).click();
    }

    public void setAddSonyXperia() {
        driver.findElement(addSonyXperia).click();
    }

    public void setAddiPhone() {
        driver.findElement(addiPhone).click();
    }

    public void clickCompareButton() {
        driver.findElement(compareButton).click();
    }

    public boolean isPopupDisplayed() {
        WebElement popup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[normalize-space()='Compare Products']")));

        return popup.isDisplayed();
    }

    public void closePopup() {
        driver.findElement(By.xpath("//button[@title='Close Window']")).click();
    }
}
