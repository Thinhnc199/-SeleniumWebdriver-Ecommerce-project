package test;

import model.pages.OrderToPDF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderToPDFTest {

    WebDriver driver;

    private OrderToPDF orderToPDF;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        orderToPDF = new OrderToPDF(driver);
    }

    @Test
    public void saveOrderAsPDF() {

        orderToPDF.clickAccounts();

        orderToPDF.clickMyAccount();

        orderToPDF.login("johndoe@example.com", "password123");

        orderToPDF.clickMyOrders();

        orderToPDF.clickViewOrderLink();

        orderToPDF.clickprintOrder();


    }
}
