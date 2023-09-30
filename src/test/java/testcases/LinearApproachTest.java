package testcases;

import com.org.qa.base.TestBase;
import com.org.qa.pages.InventoryDetailPage;
import com.org.qa.pages.LoginPage;
import com.org.qa.pages.ProductlistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LinearApproachTest extends TestBase {
    LoginPage loginPage;
    ProductlistPage listPage;
    InventoryDetailPage detailPage;

    LinearApproachTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        listPage = new ProductlistPage();
        detailPage = new InventoryDetailPage();


    }


    @Test
    public void checkoutFlowTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        listPage.clickOnProductTile();

        //Followed linear scripting approach from here . .  . .
        //Add an item to cart from PDP page, proceed to checkout page and submit  order

        WebElement btnAddtocart = driver.findElement(By.xpath("//*[contains(@id, 'add-to-cart')]"));
        btnAddtocart.click();
        WebElement linkShoppingCart = driver.findElement(By.className("shopping_cart_link"));
        linkShoppingCart.click();
        WebElement btnCheckout = driver.findElement(By.id("checkout"));
        btnCheckout.click();

        fillUserDetails();

        WebElement btnContinue = driver.findElement(By.id("continue"));
        btnContinue.click();
        WebElement btnFinish = driver.findElement(By.id("finish"));
        btnFinish.click();

    }

    @Test
    public void leftHamburgerMenuOptionsTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        WebElement hamburgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        hamburgerMenu.click();

        List<WebElement> options = driver.findElements(By.xpath("//*[@class='bm-item-list']//child::a"));
        for (WebElement a : options) {
            System.out.println("" + a.getText());
        }
        Assert.assertEquals(options.size(), 3); //Deliberately failing the test


    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }


    // For time being written a static method here so that I can call this method directly
    public static void fillUserDetails() {
        WebElement txtFirstName = driver.findElement(By.id("first-name"));
        WebElement txtLastName = driver.findElement(By.id("last-name"));
        WebElement txtPostalCode = driver.findElement(By.id("postal-code"));
        txtFirstName.sendKeys("Sowmya");
        txtLastName.sendKeys("CC");
        txtPostalCode.sendKeys("75019");

    }
}

