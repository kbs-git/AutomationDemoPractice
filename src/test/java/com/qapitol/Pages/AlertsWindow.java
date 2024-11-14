package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AlertsWindow extends BaseClass {
    public void newtab() {
        WebElement element = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",element);
        WebElement window = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        jse.executeScript("arguments[0].click()",window);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Set<String> allwin = driver.getWindowHandles();
        for(String currentwindow:allwin) {

            String title = driver.switchTo().window(currentwindow).getTitle();
            if(title.contains("sample")) {
                driver.switchTo().window(currentwindow);
                break;
            }
        }
    }
    public void newwindow() {
        WebElement element = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",element);
        WebElement window = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        jse.executeScript("arguments[0].click()",window);
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        Set<String> allwin = driver.getWindowHandles();
        for(String currentwindow:allwin) {

            String title = driver.switchTo().window(currentwindow).getTitle();
            if(title.contains("sample")) {
                driver.switchTo().window(currentwindow);
                break;
            }
        }
    }
    public void alerting() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",element);
        WebElement alerts = driver.findElement(By.xpath("//span[text()='Alerts']"));
        jse.executeScript("arguments[0].click()",alerts);
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        WebElement conformButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        jse.executeScript("arguments[0].click()",conformButton);
        alert.accept();
        WebElement promtbutton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        jse.executeScript("arguments[0].click()",promtbutton);
        alert.sendKeys("satya");
    }
    public void frames() {
        WebElement element = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",element);
        WebElement frames = driver.findElement(By.xpath("//span[text()='Frames']"));
        jse.executeScript("arguments[0].click()",frames);
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame1);
        WebElement text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(text.getText());
        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
        driver.switchTo().frame(frame2);
        driver.switchTo().defaultContent();
    }
    public void nestedframe() {
        WebElement element = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",element);
        WebElement nestedframes = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        jse.executeScript("arguments[0].click()", nestedframes);
        WebElement parentframe = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(parentframe);
        WebElement text = driver.findElement(By.xpath("//body[text()='Parent frame']"));
        System.out.println(text.getText());
        WebElement childframe = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(childframe);
        WebElement text1 = driver.findElement(By.xpath("//body/p[text()='Child Iframe']"));
        System.out.println(text1.getText());
    }

}
