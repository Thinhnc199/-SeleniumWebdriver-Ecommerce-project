
package test;

        import model.pages.CompareProductsPage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;
        import org.openqa.selenium.WebElement;

public class TestCompareProductsPage {
    private WebDriver driver;
    private CompareProductsPage compareProductsPage;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        compareProductsPage = new CompareProductsPage(driver);
    }

    @Test
    public void verifyProductComparison() {
        compareProductsPage.clickMobileMenu();
        compareProductsPage.setAddSonyXperia();

       compareProductsPage.setAddiPhone();

        compareProductsPage.clickCompareButton();

        compareProductsPage.isPopupDisplayed();

        WebElement popup = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']"));

        Assert.assertTrue(popup.isDisplayed(), "The popup for product comparison is not displayed.");

        compareProductsPage.closePopup();
    }
}

