package test;

import model.pages.VerifyCartLimit_TC3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//    Create by: Thinhncse160927

public class TestVerifyCartLimit_TC3 {
    private WebDriver driver;
    private VerifyCartLimit_TC3 verifyCartLimit_TC3;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        verifyCartLimit_TC3 = new VerifyCartLimit_TC3(driver);
    }
    @Test
    public void verifyCartLimit() {

        verifyCartLimit_TC3.clickMobileMenu();

        verifyCartLimit_TC3.addToCartSonyXperia();

        verifyCartLimit_TC3.updateQuantity("1000");

        //  Verify the error message
        String expectedErrorMessage = "Some of the products cannot be ordered in requested quantity.";
        Assert.assertEquals(verifyCartLimit_TC3.getErrorMessage(), expectedErrorMessage, "The maximum quantity allowed for purchase is 500.");

        verifyCartLimit_TC3.emptyCart();

        String expectedCartEmptyMessage = "SHOPPING CART IS EMPTY";
        Assert.assertEquals(verifyCartLimit_TC3.getCartEmptyMessage(), expectedCartEmptyMessage, "Cart is not empty as expected");
    }

}
