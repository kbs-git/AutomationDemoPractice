package qapitolPOM.tests;

import com.qapitol.Utils.ReadPropFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qapitolPOM.base.BaseClassPOM;
import qapitolPOM.pageobjects.RegistrationFb;

import java.io.IOException;

public class RegistraionFbTest extends BaseClassPOM{
    RegistrationFb registrationPage1;
    @BeforeTest
    public void setUp(){
        try {
            intialization(ReadPropFile.getObject("browser"));
            driver.get(ReadPropFile.getObject("pageObjecturl"));
            registrationPage1=new RegistrationFb(BaseClassPOM.driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void registrationFaceBookTest() throws IOException, InterruptedException {
        registrationPage1.registration1();
        registrationPage1.name("kavya","B S");
        registrationPage1.dob(10,5,2000);
        registrationPage1.genderSelection(1);
        registrationPage1.enterMobile("1234567890");
        registrationPage1.enterPwd("abs@123");
    }
    @AfterTest
    public void tearDown(){
        terminatePOM();
    }
}
