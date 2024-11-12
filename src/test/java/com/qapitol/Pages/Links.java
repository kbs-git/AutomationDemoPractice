package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Links extends BaseClass {
    public void clickOnLinks() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        Thread.sleep(1000);
        WebElement link = driver.findElement(By.id("item-5"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", link);
        js.executeScript("window.scrollBy(0,500)", "");
        List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
        int siz=allLinks.size();
        System.out.println(siz);
        for(int i=0;i<siz;i++)
        {
            WebElement ds=allLinks.get(i);
            String name=ds.getText();
            System.out.println(name);
        }
        driver.findElement(By.id("simpleLink")).click();
        String st=driver.getWindowHandle();
        System.out.println(st);
    }
}
