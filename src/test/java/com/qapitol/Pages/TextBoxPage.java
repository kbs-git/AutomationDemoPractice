package com.qapitol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage {
    static WebDriver driver;

    public TextBoxPage(WebDriver driver){

        TextBoxPage.driver =driver;
        //PageFactory.initElements(driver, TextBoxPage.class);
    }

    @FindBy(id = "userName")
    WebElement fullName;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "currentAddress")
    WebElement current_address;
    @FindBy(id = "permanentAddress")
    WebElement par_address;
    @FindBy(xpath= "/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button")
    WebElement submit;
    @FindBy(xpath="//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div/div[1]")
    WebElement elements;
    @FindBy(id="item-0") WebElement textBoxMenuIcon;

    public void login(String fn, String email1, String c_address, String p_address) throws InterruptedException {
        Thread.sleep(3000);
        elements.click();
        textBoxMenuIcon.click();
        fullName.sendKeys(fn);
        email.sendKeys(email1);
        current_address.sendKeys(c_address);
        par_address.sendKeys(p_address);
        Thread.sleep(5000);
        submit.click();
    }
}
