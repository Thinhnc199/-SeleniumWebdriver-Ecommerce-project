package test;
import model.pages.LoginMobilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//    Create by: Thinhncse160927__________________TC01

public class TestLoginMobilePage {
    private WebDriver driver;
    private LoginMobilePage loginMobilePage;

    @BeforeTest
    public void setup() {
        // Set up the WebDriver (Make sure you have ChromeDriver installed and the path set correctly)
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        loginMobilePage = new LoginMobilePage(driver);
    }

    @Test
    public void testSortMobileProductsByName() {
        // Step 1: Click on the "Mobile" menu
        loginMobilePage.clickMobileMenu();

        // Step 2: Select the "Name" option from the dropdown
        loginMobilePage.selectSortByName();

        // Step 3: Verify that products are sorted by name
        boolean isSorted = loginMobilePage.verifyProductsSortedByName();

        // Assertion
        Assert.assertTrue(isSorted, "Products are sorted by name.");
    }


}
