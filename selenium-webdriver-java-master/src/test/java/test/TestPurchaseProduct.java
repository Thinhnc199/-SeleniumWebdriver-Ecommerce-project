package test;


import driver.driverFactory;
import model.pages.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class TestPurchaseProduct {
    private LoginPageSimple loginPageSimple;

    WebDriver driver = driverFactory.getChromeDriver();
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        loginPageSimple = new LoginPageSimple(driver);
//        orderToPDF = new OrderToPDF(driver);
    }
    public  void testAccountForm() {

            WebElement mobileButton =  driver.findElement(By.linkText("MOBILE"));
            mobileButton.click();
            boolean test = true;
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();


        loginPageSimple.inputUsername("thinhncse@gmail.com");
        loginPageSimple.inputPassword("123456");
        loginPageSimple.clickLoginBtn();


            driver.findElement(By.linkText("MY WISHLIST")).click();
            driver.findElement(By.xpath("//div[@class='cart-cell']//button[@class='button btn-cart']")).click();
            CartPage c = new CartPage(driver);
            c.inputCountry("US");
            c.inputState("2");
            c.inputZip("3990");
            c.clickEstimateBtn();

            driver.findElement(By.xpath("//dd//ul//li//label[@for='s_method_flatrate_flatrate']")).click();
            driver.findElement(By.xpath("//button[@value='Update Total']")).click();


            driver.findElement(By.xpath("//button[@class='button btn-proceed-checkout btn-checkout']")).click();

            CheckOutPage ch = new CheckOutPage(driver);
            ch.inputFirstName("1");
            ch.inputMiddleName("1");
            ch.inputLastName("1");
            ch.inputCompany("1");
            ch.inputAddress1("Cuchi");
            ch.inputAddress2("ThuDuc");
            ch.inputCity("HCM");
            ch.inputState("2");
            ch.inputZip("70000");
            ch.inputCountry("US");
            ch.inputTelephone("1");
            ch.inputFax("1");
            ch.clickContinueBtn();
            loginPageSimple.waitForPageLoad();

        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]"));
//        driver.findElement(By.name("continue")).click();
       ////button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]")));
//        continueButton.click();

        //button[@onclick='payment.save()']
        driver.findElement(By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]"));


//        driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();////span[contains(text(),'Place Order')]
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement placeOrderButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Place Order')]")));
        placeOrderButton.click();

            Assertions.assertTrue(test);

        }

    }
