package com.qapitol.Base;

import com.qapitol.Utils.ReadPropFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
        public static WebDriver driver;
        public static void initialize() throws IOException {
            driver=new EdgeDriver();
            driver.get(ReadPropFile.getObject("url"));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        public static void quit() {
            driver.close();
        }

}
