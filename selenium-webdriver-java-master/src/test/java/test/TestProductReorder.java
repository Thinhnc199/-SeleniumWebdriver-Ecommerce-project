package test;


import model.pages.OrderToPDF;
import model.pages.ProductReorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestProductReorder {
    WebDriver driver;

    private ProductReorder productReorder;
    private OrderToPDF orderToPDF;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        productReorder = new ProductReorder(driver);
        orderToPDF = new OrderToPDF(driver);
    }

    @Test
    public void UpdateProductReorder (){
        orderToPDF.clickAccounts();

        orderToPDF.clickMyAccount();

        orderToPDF.login("johndoe@example.com", "password123");

        orderToPDF.clickMyOrders();

        productReorder.clickreorder();

        String initialGrandTotal = productReorder.getGrandTotal();

        productReorder.updateQuantity("10");

        productReorder.waitForPageLoad();
        String updatedGrandTotal = productReorder.getGrandTotal();
        if (!initialGrandTotal.equals(updatedGrandTotal)) {
            System.out.println("Grand Total has changed after updating product quantity");
        } else {
            System.out.println("Grand Total remains the same after updating product quantity");
        }
        Assert.assertNotEquals(initialGrandTotal, updatedGrandTotal, "Grand Total did not change after updating the product quantity");
        productReorder.clickproceedCheckout();




        driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();


        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();

        // In Shipping Method, Click Continue
        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();
//<button type="button" class="button" onclick="shippingMethod.save()"><span><span>Continue</span></span></button>
        driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();
        driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
    }

}
