package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//    Create by: Thinhncse160927
public class VerifyCartLimit_TC3 {
    private WebDriver driver;

    By mobileMenuLink = By.xpath("//a[contains(., 'Mobile')]");

    By addToCartButton = By.xpath("//h2[@class='product-name']/a[text()='Sony Xperia']/../following-sibling::div[@class='actions']//button[@title='Add to Cart']");
    By editQyt = By.xpath("//input[@title='Qty']");
    By updateButton = By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]");
    By errorMessageBox = By.xpath("//li[@class='error-msg']//ul//li");
    By emptyCartButton = By.id("empty_cart_button");

    By cartEmptyMessage = By.xpath("//div[@class='page-title']");

    public VerifyCartLimit_TC3(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenuLink).click();
    }

    public void addToCartSonyXperia() {
        driver.findElement(addToCartButton).click();

    }

    public void updateQuantity(String qty) {
        driver.findElement(editQyt).clear();
        driver.findElement(editQyt).sendKeys(qty);
        driver.findElement(updateButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageBox).getText();
    }

    public void emptyCart() {
        driver.findElement(emptyCartButton).click();
    }

    public String getCartEmptyMessage() {
        return driver.findElement(cartEmptyMessage).getText();
    }
}
