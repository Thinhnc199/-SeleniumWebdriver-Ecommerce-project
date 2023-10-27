package test;
import model.pages.ProductCostVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
//    Create by: Thinhncse160927_______________TC2

public class TestProductCostVerification {
    private WebDriver driver;

    private ProductCostVerification productCostVerification;
@BeforeTest
    public void setup() {
        // Set up the WebDriver (Make sure you have ChromeDriver installed and the path set correctly)
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
     productCostVerification = new ProductCostVerification(driver);
    }

    @Test
    public void verifyProductCost() {

        productCostVerification.clickMobileMenu();


        String productCostListPage = productCostVerification.getProductCostListPage();


//        driver.findElement(By.linkText("Sony Xperia")).click();
        driver.findElement(By.xpath("//a[@title='Sony Xperia'][normalize-space()='Sony Xperia']")).click();

        // Step 5: Read the Sony Xperia mobile cost from the details page
        String productCostDetailsPage = driver.findElement(By.xpath("//span[@id='product-price-1']//span[@class='price'][normalize-space()='$100.00']")).getText();

        // Step 6: Compare the product cost in the list and details page
        Assert.assertEquals(productCostListPage, productCostDetailsPage, "Product cost in list and details page is not equal");
    }

}
