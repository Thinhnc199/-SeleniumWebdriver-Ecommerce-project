package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderToPDF {
    private WebDriver driver;

    By accounts = By.xpath("//span[@class='label'][normalize-space()='Account']");
    By myAccount = By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']");
    By emailInput = By.id("email");
    By passwordInput = By.id("pass");
    By loginButton = By.id("send2");
    By myOrdersLink = By.xpath("//a[normalize-space()='My Orders']");
    By viewOrderLink = By.xpath("//a[normalize-space()='View Order']");

    By printOrder = By.xpath("//a[@class='link-print' and contains(@href,'/sales/order/print/') and contains(@onclick,'this.target')][normalize-space()='Print Order']");

    public OrderToPDF(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccounts() {
        driver.findElement(accounts).click();
    }

    public void clickMyAccount() {
        driver.findElement(myAccount).click();
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickMyOrders() {
        driver.findElement(myOrdersLink).click();
    }

    public void clickViewOrderLink() {
         driver.findElement(viewOrderLink).click();
    }

    public void clickprintOrder(){
        driver.findElement(printOrder).click();
    }
}
