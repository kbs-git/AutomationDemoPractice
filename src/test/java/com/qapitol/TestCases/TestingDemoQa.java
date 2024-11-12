package com.qapitol.TestCases;

import com.qapitol.Base.BaseClass;
import com.qapitol.Pages.TextBoxPage;
import com.qapitol.Pages.checkBoxPage;
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
        TextBoxPage text= PageFactory.initElements(driver, TextBoxPage.class);
        text.login("kavya","B S","Bengaluru","Davanagere");
    }
    @Test(enabled = true)
    public void checkBoxElements() throws InterruptedException {
        checkBoxPage check= PageFactory.initElements(driver, checkBoxPage.class);
        check.checkBoxMethod();
    }

    @AfterTest
    public void tearDown(){
         BaseClass.quit();
    }
}
