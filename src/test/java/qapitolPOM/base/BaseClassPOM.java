package qapitolPOM.base;

import com.qapitol.Utils.ReadPropFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class BaseClassPOM {
    public static WebDriver driver;
    public static void intialization(String browser) throws IOException {
        if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else{
            driver = new ChromeDriver();
        }
            driver.manage().window().maximize();
    }

    public static void terminatePOM(){
        driver.quit();
    }
}
