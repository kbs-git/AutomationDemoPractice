package com.qapitol.Pages;

import com.qapitol.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Elements  extends BaseClass {

    public void textBox(String fn, String email1, String c_address, String p_address) throws InterruptedException {
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

    public void radioButtton(String str) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        driver.findElement(By.id("item-2")).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        if(str.equalsIgnoreCase("Yes")){

            WebElement ele=driver.findElement(By.xpath("//label[@for='yesRadio']"));

            js.executeScript("arguments[0].scrollIntoView(true);",ele);
            ele.click();
        }else {
            WebElement ele=driver.findElement(By.xpath("//*[text()='Impressive']"));
            js.executeScript("arguments[0].scrollIntoView(true);",ele);
            ele.click();
        }

    }

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

    public void performCButtonClicks() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        Thread.sleep(1000);
        WebElement buttons= driver.findElement(By.xpath("//*[text()=\"Buttons\"]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",buttons);
        Actions action=new Actions(driver);
        WebElement doubleClickBtn= driver.findElement(By.id("doubleClickBtn"));
        js.executeScript("arguments[0].scrollIntoView(true);",doubleClickBtn);
        action.doubleClick(doubleClickBtn).perform();

        Thread.sleep(1000);
        WebElement rightClick=driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClick).perform();
        Thread.sleep(2000);
        WebElement click1= driver.findElement(By.xpath("//button[text()='Click Me']"));
        action.click(click1).perform();
    }

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

    public void findBrokenLinks() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")).click();
        Thread.sleep(1000);
        WebElement ii=driver.findElement(By.id("item-6"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",ii);

        List<WebElement> links = driver.findElements(By.tagName("a"));


        // Iterating each link and checking the response status
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyLink(url);
        }


    }


    public static void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();


            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }
}
