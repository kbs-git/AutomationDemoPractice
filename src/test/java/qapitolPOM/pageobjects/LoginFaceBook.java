package qapitolPOM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qapitolPOM.base.BaseClassPOM;

public class LoginFaceBook extends BaseClassPOM{
    WebDriver driver;
    public LoginFaceBook(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id="email")
    WebElement email;
    @FindBy(id="pass") WebElement password;
    @FindBy(xpath = "//*[@name='login']") WebElement login;

    public void loginFaceBook(String mail, String pwd1){
        email.sendKeys(mail);
        password.sendKeys(pwd1);
        login.click();
    }

}
