package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testcase6 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();

        driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']")).click();

        driver.findElement(By.id("email")).sendKeys("thinhncse@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        driver.findElement(By.linkText("MY WISHLIST")).click();


        driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();

        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.id("region_id")).sendKeys("California");
        driver.findElement(By.id("postcode")).sendKeys("7000");

        driver.findElement(By.xpath("//button[@title='Estimate']")).click();


        driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Update Total')]")).click();


      driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();

        driver.findElement(By.id("billing:firstname")).sendKeys("John");
        driver.findElement(By.id("billing:lastname")).sendKeys("Doe");
        driver.findElement(By.id("billing:street1")).sendKeys("123 Main Street");
        driver.findElement(By.id("billing:city")).sendKeys("Anytown");
        driver.findElement(By.id("billing:region_id")).sendKeys("California");
        driver.findElement(By.id("billing:postcode")).sendKeys("91201");
        driver.findElement(By.id("billing:telephone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();

        driver.findElement(By.id("shipping:firstname")).sendKeys("John");
        driver.findElement(By.id("shipping:lastname")).sendKeys("Doe");
        driver.findElement(By.id("shipping:street1")).sendKeys("123 Main Street");
        driver.findElement(By.id("shipping:city")).sendKeys("Anytown");
        driver.findElement(By.id("shipping:region_id")).sendKeys("California");
        driver.findElement(By.id("shipping:postcode")).sendKeys("91201");
        driver.findElement(By.id("shipping:telephone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();

        driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")).click();
        driver.findElement(By.name("continue")).click();
        driver.findElement(By.xpath("//label[@for='p_method_checkmo']")).click();
        driver.findElement(By.xpath("//button[@class='button']//span//span[contains(text(),'Continue')]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
    }
}