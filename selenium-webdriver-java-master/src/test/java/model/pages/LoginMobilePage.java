package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//    Create by: Thinhncse160927

public class LoginMobilePage {
    private WebDriver driver;

    By mobileMenuLink = By.xpath("//a[contains(., 'Mobile')]");
    By productNames = By.cssSelector(".product-name");
    By sortByDropdown = By.cssSelector("select[title='Sort By']"); // Updated CSS selector

    public LoginMobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileMenu() {
        driver.findElement(mobileMenuLink).click();
    }

    public void selectSortByName() {
        Select dropdown = new Select(driver.findElement(sortByDropdown));
        dropdown.selectByVisibleText("Name");
    }

    public boolean verifyProductsSortedByName() {

        java.util.List<WebElement> products = driver.findElements(productNames);

        // Check if the products are sorted by name
        for (int i = 1; i < products.size(); i++) {
            String productName1 = products.get(i - 1).getText();
            String productName2 = products.get(i).getText();
            if (productName1.compareTo(productName2) > 0) {
                return false;
            }
        }
        return true;
    }
}
