package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage  extends BaseClass {

    public void login(String fn, String email1, String c_address, String p_address) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-0")).click();
        driver.findElement(By.id("userName")).sendKeys(fn);
        driver.findElement(By.id("userEmail")).sendKeys(email1);
        driver.findElement(By.id("currentAddress")).sendKeys(c_address);
        driver.findElement(By.id("permanentAddress")).sendKeys(p_address);
        Thread.sleep(5000);
        WebElement submit=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",submit);
    }
}
