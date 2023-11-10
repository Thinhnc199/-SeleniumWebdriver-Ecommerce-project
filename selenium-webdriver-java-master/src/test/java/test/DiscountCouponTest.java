    package test;

    import model.pages.DiscountCoupon;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

//    Thinhncse160927 - TESTCASE09

    public class DiscountCouponTest {
        private WebDriver driver;
        private DiscountCoupon discountCoupon;


        @BeforeTest
        public void setup() {
            driver = new ChromeDriver();
            driver.get("http://live.techpanda.org/");
            discountCoupon = new DiscountCoupon(driver);
        }

        @Test
        public void DiscountCouponTest (){

            discountCoupon.clickMobileMenu();


            discountCoupon.waitForPageLoad();
            discountCoupon.Clickmobile();

            discountCoupon.clickAddtocard();

            String originalPriceText = discountCoupon.getGrandTotal();
            originalPriceText = originalPriceText.replace("$", "");
            float originalPrice = Float.parseFloat(originalPriceText);

            discountCoupon.TypeCouponCode().sendKeys("GURU50");

            discountCoupon.Clickapplycode();

            discountCoupon.waitForPageLoad();

            String discountedPriceText = discountCoupon.getGrandTotal();
            discountedPriceText = discountedPriceText.replace("$", "");
            float discountedPrice = Float.parseFloat(discountedPriceText);

            if (discountedPrice < originalPrice) {
                System.out.println("Price is discounted by 5%");
            } else {
                System.out.println("Price is not discounted by 5%");
            }
            Assert.assertNotEquals(originalPriceText,discountedPriceText);

        }
    }
