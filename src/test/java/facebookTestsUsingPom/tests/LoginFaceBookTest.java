package facebookTestsUsingPom.tests;

import com.base.BaseClass;
import facebookTestsUsingPom.facebookBase.FaceBookBaseClass;
import com.utilities.ReadPropFile;
import org.testng.annotations.Test;
import com.pages.faceBookpages.LoginFaceBook;

import java.io.IOException;

public class LoginFaceBookTest extends FaceBookBaseClass {

    @Test
    public void loginFaceBookTest() throws IOException {
        LoginFaceBook loginFaceBookPage=new LoginFaceBook(BaseClass.driver);
        loginFaceBookPage.loginFaceBook(ReadPropFile.getObject("email"), ReadPropFile.getObject("pwd") );
    }

}
