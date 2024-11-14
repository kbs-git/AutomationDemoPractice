package com.pages.demoQA;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class AlertsWindow extends BaseClass {
    public void alerts() {
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
        WebElement al = driver.findElement(By.xpath("//*[text()='Alerts']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", al);
        WebElement ab = driver.findElement(By.id("alertButton"));
        js.executeScript("arguments[0].click()", ab);

        //Alerts alt=new Alerts();
        driver.switchTo().alert().accept();
        WebElement b = driver.findElement(By.id("confirmButton"));
        js.executeScript("arguments[0].click()", b);
        driver.switchTo().alert().dismiss();
        WebElement gg = driver.findElement(By.id("promtButton"));
        js.executeScript("arguments[0].click()", gg);
        driver.switchTo().alert().sendKeys("Shruti");
        driver.switchTo().alert().accept();

    }

    public void windowpage() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()=\"Alerts, Frame & Windows\"]")).click();
        WebElement ff = driver.findElement(By.xpath("(//*[text()=\"Browser Windows\"])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", ff);

        WebElement Web = driver.findElement(By.id("windowButton"));
        js.executeScript("arguments[0].click()", Web);
        Set<String> str = driver.getWindowHandles();
        Iterator<String> itr = str.iterator();
        String nstr = itr.next();
        String rrt = itr.next();
        driver.switchTo().window(rrt);
        WebElement der = driver.findElement(By.id("sampleHeading"));
        System.out.println(der.getText());
        driver.close();
    }

    public void iframe() {
        driver.findElement(By.xpath("//*[text()=\"Alerts, Frame & Windows\"]")).click();
        WebElement bb = driver.findElement(By.id("item-2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", bb);
        driver.switchTo().frame("frame1");
        String txt = driver.findElement(By.id("sampleHeading")).getText();

        System.out.println(txt);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");

        String txt1 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txt1);

        driver.switchTo().defaultContent();


    }

    public void nestedframe() {
        driver.findElement(By.xpath("//*[text()=\"Alerts, Frame & Windows\"]")).click();
        WebElement nested = driver.findElement(By.xpath("//*[text()=\"Nested Frames\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", nested);
        driver.switchTo().frame("frame1");

        driver.switchTo().frame(0);

        WebElement childFrame = driver.findElement(By.xpath("//p[text()='Child Iframe']"));

        System.out.println(childFrame.getText());
        driver.switchTo().parentFrame();

        System.out.println(driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());
    }

}
