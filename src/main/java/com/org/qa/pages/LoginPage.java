package com.org.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.qa.base.TestBase;
import org.testng.Assert;

public class LoginPage extends TestBase {

    //Page Factory - OR:
    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(className = "app_logo")
    WebElement swagLabsLogo;
    @FindBy(xpath = "//*[@data-test='error']")
    WebElement msgInvalidLogin;

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public void validateCRMImage() {
//        return crmLogo.isDisplayed();
    }

    public ProductlistPage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
		    	/*JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);*/

        swagLabsLogo.isDisplayed();
        return new ProductlistPage();
    }

    public boolean unsuccessfulLogin(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        System.out.println("Error Message is => " + msgInvalidLogin.getText());
        return msgInvalidLogin.isDisplayed();
    }

}
