package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiscountCoupon {
    private WebDriver driver;

    By mobileMenuLink = By.xpath("//a[contains(., 'Mobile')]");
    By ChooseMobile = By.id("product-collection-image-2");

    By Addtocard = By.xpath("//span[contains(text(),'Add to Cart')]");

    By CouponCode = By.xpath("//*[@id='coupon_code']");

    By ApplyCode = By.xpath("//span[contains(text(),'Apply')]");

    By grandTotalLocator = By.xpath("//td[@class='a-right']//span[@class='price']");
    public DiscountCoupon(WebDriver driver) {
        this.driver = driver;

    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenuLink).click();
    }

    public void Clickmobile() {driver.findElement(ChooseMobile).click();}

    public void clickAddtocard() {
        driver.findElement(Addtocard).click();
    }

    public WebElement TypeCouponCode() {
        return driver.findElement(CouponCode);
    }

    public void Clickapplycode() {driver.findElement(ApplyCode).click();}

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
}
