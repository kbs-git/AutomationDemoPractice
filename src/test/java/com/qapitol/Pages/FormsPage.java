package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;

public class FormsPage extends BaseClass {
    public void forms(String name, String ln, String mail) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div")).click();
        driver.findElement(By.xpath("(//*[text()=\"Practice Form\"])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("firstName")).sendKeys(name);
        driver.findElement(By.xpath("lastName")).sendKeys(ln);
    }
}
