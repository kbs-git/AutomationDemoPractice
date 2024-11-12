package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class UploadAndDownload extends BaseClass {
    public void upLoadFile() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        Thread.sleep(1000);

        WebElement vv=driver.findElement(By.id("item-7"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",vv);
        js.executeScript("window.scrollBy(0,500)", "");

        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Qapitol QA\\Downloads\\sample-jpg-files-sample_640x426.jpg");

    }
    public void fileDownload(){
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
