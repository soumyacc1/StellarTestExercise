package com.org.qa.pages;

import com.org.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class InventoryDetailPage extends TestBase {
    public InventoryDetailPage(){
        PageFactory.initElements(driver,this);
            }
}
