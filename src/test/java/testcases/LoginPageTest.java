package testcases;

import com.org.qa.base.TestBase;
import com.org.qa.pages.LoginPage;
import com.org.qa.pages.ProductlistPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    ProductlistPage listPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(enabled = true)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        Thread.sleep(5000);
        Assert.assertEquals(title, "Swag Labs");
    }



    @Test(enabled = true, priority = 1)
    public void successfulLoginTest() {
        System.out.println("Inside Test annotation");
        listPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @DataProvider(name = "InvalidUserdata")
    public Object[][] getInvalidUserdata() {
        Object[][] data={
                {"Samuser","Test0987@"},
                {"TTTuser","Test1872345@"}
        };
        return data;
    }
    @Test(dataProvider = "InvalidUserdata", priority = 2, enabled = true)
    public void unsuccessfulLogin(String un, String pwd) {
        System.out.println(un+" AND =>"+pwd);
        boolean flag = loginPage.unsuccessfulLogin(un,pwd);
        Assert.assertTrue(flag);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
