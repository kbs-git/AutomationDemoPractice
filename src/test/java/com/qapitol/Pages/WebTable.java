package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;

public class WebTable extends BaseClass {
    public void webTable(String fn,String ln, String email,int age){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-3")).click();
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(fn);
        driver.findElement(By.id("firstName")).sendKeys(ln);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);

    }

}
