package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class checkBoxPage extends BaseClass {


    public void checkBoxMethod() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("item-1")).click();
        Thread.sleep(1000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement expandAll= driver.findElement(By.xpath("//button[@title='Expand all']"));
        WebElement collapseAll= driver.findElement(By.xpath("//button[@title='Collapse all']"));
        WebElement toggle=driver.findElement(By.xpath("//button[@title='Toggle']"));
        js.executeScript("arguments[0].click()",expandAll);
        js.executeScript("arguments[0].click()",collapseAll);
        js.executeScript("arguments[0].click()",toggle);

    }
}
