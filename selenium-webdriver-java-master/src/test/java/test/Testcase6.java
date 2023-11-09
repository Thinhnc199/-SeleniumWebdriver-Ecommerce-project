package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testcase6 {

    public static void main(String[] args) throws InterruptedException {
        // Set up the WebDriver
        WebDriver driver = new ChromeDriver();

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();

        driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']")).click();

        // Login to the application using previously created credentials
        driver.findElement(By.id("email")).sendKeys("johndoe@example.com");
        driver.findElement(By.id("pass")).sendKeys("password123");
        driver.findElement(By.id("send2")).click();

        // Click on the "MY WISHLIST" link
        driver.findElement(By.linkText("MY WISHLIST")).click();

        // In next page, click ADD TO CART link

        driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();

        // Enter general shipping country, state/province and zip for the shipping cost estimate
        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.id("region_id")).sendKeys("California");
        driver.findElement(By.id("postcode")).sendKeys("7000");

        // Click Estimate"
        driver.findElement(By.xpath("//button[@title='Estimate']")).click();


        // Select Shipping Cost, Update Total
        driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Update Total')]")).click();


        // Click "Proceed to Checkout"
//        driver.findElement(By.name("proceed")).click();
      driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();

        // Enter Billing Information, and click Continue
        driver.findElement(By.id("billing:firstname")).sendKeys("John");
        driver.findElement(By.id("billing:lastname")).sendKeys("Doe");
        driver.findElement(By.id("billing:street1")).sendKeys("123 Main Street");
        driver.findElement(By.id("billing:city")).sendKeys("Anytown");
        driver.findElement(By.id("billing:region_id")).sendKeys("California");
        driver.findElement(By.id("billing:postcode")).sendKeys("91201");
        driver.findElement(By.id("billing:telephone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

        // Enter Shipping Information, and click Continue
        driver.findElement(By.id("shipping:firstname")).sendKeys("John");
        driver.findElement(By.id("shipping:lastname")).sendKeys("Doe");
        driver.findElement(By.id("shipping:street1")).sendKeys("123 Main Street");
        driver.findElement(By.id("shipping:city")).sendKeys("Anytown");
        driver.findElement(By.id("shipping:region_id")).sendKeys("California");
        driver.findElement(By.id("shipping:postcode")).sendKeys("91201");
        driver.findElement(By.id("shipping:telephone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();

        // In Shipping Method, Click Continue
        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();
        driver.findElement(By.name("continue")).click();
        // In Payment Information select 'Check/Money Order' radio button. Click Continue
        driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();
        driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();
        // Click `PLACE ORDER` button
        driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
    }
}