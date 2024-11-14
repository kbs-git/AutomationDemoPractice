package facebookTestsUsingPom.facebookBase;

import com.base.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.utilities.ReadPropFile;

import java.io.IOException;

public class FaceBookBaseClass extends BaseClass{
    @BeforeTest
    public void setUp(){
        try {
            BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("facebook"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown(){
        BaseClass.quit();
    }

}
