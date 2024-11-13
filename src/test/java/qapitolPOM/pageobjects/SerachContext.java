package qapitolPOM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qapitolPOM.base.BaseClassPOM;

import static qapitolPOM.Utils.Utility.contextSearch;

public class SerachContext extends BaseClassPOM {

    WebDriver driver;
    public SerachContext(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id="twotabsearchtextbox")
    WebElement search;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;


    // Method to perform the search in one step
    public void searchForItem(String searchTerm) {
        search.clear();
        search.sendKeys(searchTerm);
        searchButton.click();
        contextSearch(searchTerm);
    }

}
