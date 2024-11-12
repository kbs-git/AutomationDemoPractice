package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RadioButtons extends BaseClass {

    public void radioButtton(String str) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-2")).click();
        if(str.equalsIgnoreCase("Yes")){

            WebElement ele=driver.findElement(By.xpath("//label[@for='yesRadio']"));
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);",ele);
            ele.click();
        }else {
            WebElement ele=driver.findElement(By.xpath("//*[text()='Impressive']"));
            JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);",ele);
            ele.click();
        }

    }

}
