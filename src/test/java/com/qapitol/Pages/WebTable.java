package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebTable extends BaseClass {
    public void webTableAdd(String fn,String ln, String email,String age, String salary, String department ) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        WebElement ele=driver.findElement(By.id("item-3"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",ele);
        Thread.sleep(15000);
        WebElement add=driver.findElement(By.id("addNewRecordButton"));
        js.executeScript("arguments[0].click();",add);

        driver.findElement(By.id("firstName")).sendKeys(fn);
        driver.findElement(By.id("lastName")).sendKeys(ln);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(department);
        driver.findElement(By.id("submit")).click();
    }

}
