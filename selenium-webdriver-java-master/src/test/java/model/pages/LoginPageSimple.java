package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//    Create by: Thinhncse160927

public class LoginPageSimple {
    private WebDriver driver;


    private By usernameSelector = By.id("email");
    private By passwordSelector = By.id("pass");
    private By loginBtnSelector = By.cssSelector("[type='submit']");

    private By loginBtn = By.xpath("//div[@class='buttons-set']//button[@class='button']");
    public LoginPageSimple(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement username() {
        return driver.findElement(usernameSelector);
    }

    public WebElement password() {
        return driver.findElement(passwordSelector);
    }

    public WebElement loginBtn() {
        return driver.findElement(loginBtnSelector);
    }

    public void inputUsername(String username){
        username().sendKeys(username);
    }
    public void clickLoginBtn() {
        WebElement registerButtonElement = driver.findElement(loginBtn);
        registerButtonElement.click();
    }
    public void inputPassword(String password){
        password().sendKeys(password);
    }

    public void clickOnLoginBtn(){
        loginBtn().click();
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        });
    }
}
