package com.qapitol.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkBoxPage {
    static WebDriver driver;

    public checkBoxPage(WebDriver driver){
        checkBoxPage.driver =driver;
    }

    @FindBy(id="item-1")
    WebElement checboxMenu;
    @FindBy(xpath="//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")
    WebElement elements;
    @FindBy(xpath = "//button[@title='Expand all']") WebElement expandAll;
    @FindBy(xpath = "//button[@title='Collapse all']") WebElement collapseAll;
    @FindBy(xpath = "//button[@title='Toggle']") WebElement toggle;

    public void checkBoxMethod() throws InterruptedException {
        elements.click();
        Thread.sleep(2000);
        checboxMenu.click();
        Thread.sleep(1000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",expandAll);
        js.executeScript("arguments[0].click()",collapseAll);
        js.executeScript("arguments[0].click()",toggle);

    }
}
