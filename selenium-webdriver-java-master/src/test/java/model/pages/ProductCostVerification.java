package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCostVerification {
    private WebDriver driver;

    By mobileMenuLink = By.xpath("//a[contains(., 'Mobile')]");
    By productCostListPage = By.xpath("//span[@id='product-price-1']//span[@class='price'][normalize-space()='$100.00']");

    public ProductCostVerification(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenuLink).click();
    }

    public String getProductCostListPage() {
        return driver.findElement(By.xpath("//span[@id='product-price-1']//span[@class='price'][normalize-space()='$100.00']")).getText();
    }

}