package demoqatestCases;

import com.base.BaseClass;
import com.pages.demoQA.AlertsWindow;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utilities.ReadPropFile;

import java.io.IOException;

public class AlertTests extends BaseClass {
    AlertsWindow alertsWindow;
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("demoqaUrl"));
        alertsWindow=new AlertsWindow();
    }
    @Test
    public void alertsTesting() throws InterruptedException {
        alertsWindow.alerts();
        /*alertsWindow.windowpage();
        alertsWindow.iframe();
        alertsWindow.nestedframe();*/
    }
    @AfterTest
    public void terminate(){

        BaseClass.quit();
    }

}
