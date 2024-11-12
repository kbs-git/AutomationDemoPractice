package qapitolPOM.tests;

import com.qapitol.Utils.ReadPropFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qapitolPOM.base.BaseClassPOM;
import qapitolPOM.pageobjects.LoginFaceBook;

import java.io.IOException;

public class LoginFaceBookTest extends BaseClassPOM {
    LoginFaceBook loginFaceBookPage;
    @BeforeTest
    public void setUp(){
        try {
            intialization(ReadPropFile.getObject("browser"));
            driver.get(ReadPropFile.getObject("pageObjecturl"));
            loginFaceBookPage=new LoginFaceBook(BaseClassPOM.driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void loginFaceBookTest() throws IOException {
        loginFaceBookPage.loginFaceBook(ReadPropFile.getObject("email"), ReadPropFile.getObject("pwd") );
    }
    @AfterTest
    public void tearDown(){
        terminatePOM();
    }

}
