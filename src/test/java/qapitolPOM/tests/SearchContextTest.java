package qapitolPOM.tests;

import com.qapitol.Utils.ReadPropFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qapitolPOM.base.BaseClassPOM;
import qapitolPOM.pageobjects.SerachContext;

import java.io.IOException;

import static qapitolPOM.base.BaseClassPOM.*;

public class SearchContextTest extends BaseClassPOM {
    SerachContext serachContext;
    @BeforeTest
    public void setUp(){
        try {
            intialization(ReadPropFile.getObject("browser"));
            driver.get(ReadPropFile.getObject("pageObjecturl"));
            serachContext=new SerachContext();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest
    public void quit(){
        terminatePOM();
    }
    @Test
    public void searchContextTest(){

    }
}
