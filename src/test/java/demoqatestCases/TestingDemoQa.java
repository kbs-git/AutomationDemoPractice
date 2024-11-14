package demoqatestCases;

import com.base.BaseClass;
import com.pages.demoQA.Elements;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utilities.ReadPropFile;

import java.io.IOException;

public class TestingDemoQa  extends BaseClass{
   public Elements ele;
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("demoqaUrl"));
        ele=new Elements();
    }
    @Test(enabled = false)
    public void textBoxElements() throws InterruptedException {
        ele.textBox("kavya","B S","Bengaluru","Davanagere");
    }
    @Test(enabled = false)
    public void checkBoxElements() throws InterruptedException {
        ele.checkBoxMethod();
    }
    @Test(enabled = true)
    public void radioButtonsElement() throws InterruptedException {
        ele.radioButtton("Yes");
    }

    @Test(enabled = false)
    public void webTableElement() throws InterruptedException {
        ele.webTableAdd("kavya","B S","kavyabskavya2001@gmail.com","10","10000","Engineering");
    }

    @Test(enabled = false)
    public void buttonsTest() throws InterruptedException {
        ele.performCButtonClicks();
    }
    @Test(enabled = false)
    public void clickOnLinks() throws InterruptedException {
        ele.clickOnLinks();
    }
    @Test(enabled = false)
    public void brokenLinks() throws IOException, InterruptedException {
        ele.findBrokenLinks();
    }
    @Test(enabled = false)
    public void uploadFiles() throws IOException, InterruptedException {
        ele.upLoadFile();
        ele.fileDownload();
    }
    @AfterTest
    public void terminate(){

        BaseClass.quit();
    }
}
