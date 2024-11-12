package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons extends BaseClass {
    public void performCButtonClicks() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        Thread.sleep(1000);
        WebElement buttons= driver.findElement(By.xpath("//*[text()=\"Buttons\"]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",buttons);
        Actions action=new Actions(driver);
        WebElement doubleClickBtn= driver.findElement(By.id("doubleClickBtn"));
        js.executeScript("arguments[0].scrollIntoView(true);",doubleClickBtn);
        action.doubleClick(doubleClickBtn).perform();

        Thread.sleep(1000);
        WebElement rightClick=driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClick).perform();
        Thread.sleep(2000);
        WebElement click1= driver.findElement(By.xpath("//button[text()='Click Me']"));
        action.click(click1).perform();
    }
}
