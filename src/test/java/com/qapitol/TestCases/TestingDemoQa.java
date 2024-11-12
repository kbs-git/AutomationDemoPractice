package com.qapitol.TestCases;

import com.qapitol.Base.BaseClass;
import com.qapitol.Pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qapitol.Base.BaseClass.driver;

public class TestingDemoQa {
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize();
    }
    @Test(enabled = false)
    public void textBoxElements() throws InterruptedException {
        TextBoxPage text=new TextBoxPage();
        text.login("kavya","B S","Bengaluru","Davanagere");
    }
    @Test(enabled = false)
    public void checkBoxElements() throws InterruptedException {
        checkBoxPage check= PageFactory.initElements(driver, checkBoxPage.class);
        check.checkBoxMethod();
    }
    @Test(enabled = false)
    public void radioButtonsElement() throws InterruptedException {
        RadioButtons radio= new RadioButtons();
        radio.radioButtton("Yes");
    }

    @Test(enabled = false)
    public void webTableElement() throws InterruptedException {
        WebTable wt=new WebTable();
        wt.webTableAdd("kavya","B S","kavyabskavya2001@gmail.com","10","10000","Engineering");
    }

    @Test(enabled = false)
    public void buttonsTest() throws InterruptedException {
        Buttons bt=new Buttons();
        bt.performCButtonClicks();
    }
    @Test(enabled = false)
    public void clickOnLinks() throws InterruptedException {
        Links l=new Links();
        l.clickOnLinks();
    }
    @Test(enabled = false)
    public void brokenLinks() throws IOException, InterruptedException {
        BrokenLinks bl=new BrokenLinks();
        bl.findBrokenLinks();
    }
    @Test(enabled = true)
    public void uploadFiles() throws IOException, InterruptedException {
        UploadAndDownload uad=new UploadAndDownload();
        uad.upLoadFile();
        uad.fileDownload();
    }
    @AfterTest
    public void terminate(){
        // BaseClass.quit();
    }
}
