package testcases;

import com.org.qa.base.TestBase;
import com.org.qa.pages.InventoryDetailPage;
import com.org.qa.pages.LoginPage;
import com.org.qa.pages.ProductlistPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductlistPageTest extends TestBase {
    LoginPage loginPage;
    ProductlistPage listPage;
    InventoryDetailPage detailPage;

    ProductlistPageTest() {
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
    public void productListTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        int size = listPage.getProductList().size();
        System.out.println("Verify number of items available on Home page");
        Assert.assertEquals(size, 6);
    }

    @Test
    public void verifyProductTileClick() {
        detailPage = listPage.clickOnProductTile();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}

