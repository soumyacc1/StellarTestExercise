package com.org.qa.pages;

import com.org.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ProductlistPage extends TestBase {

    @FindBy(className = "inventory_item_name")
    WebElement productTitle;



    public ProductlistPage() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductList() {
        List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
        return itemNames;

    }

    public InventoryDetailPage clickOnProductTile(){
        List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
        itemNames.get(0).click();
        return new InventoryDetailPage();
    }

}
