package com.qapitol.TestCases;

import com.qapitol.Base.BaseClass;
import com.qapitol.Pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertTests extends BaseClass{
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize();
    }
    @Test
    public void alertsTesting(){


    }
    @AfterTest
    public void terminate(){
        BaseClass.quit();
    }

}
