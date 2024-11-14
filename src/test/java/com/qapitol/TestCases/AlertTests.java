package com.qapitol.TestCases;

import com.qapitol.Base.BaseClass;
import com.qapitol.Pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertTests extends BaseClass{
    AlertsWindow alertsWindow=new AlertsWindow();
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize();
    }
    @Test
    public void alertsTesting() throws InterruptedException {
        alertsWindow.newtab();
        alertsWindow.newwindow();
        alertsWindow.alerting();
        alertsWindow.frames();
        alertsWindow.nestedframe();
    }
    @AfterTest
    public void terminate(){
        BaseClass.quit();
    }

}
