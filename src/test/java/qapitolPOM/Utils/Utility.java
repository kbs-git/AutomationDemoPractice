package qapitolPOM.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qapitolPOM.base.BaseClassPOM;

import java.util.List;

public class Utility extends BaseClassPOM {
    public static  void contextSearch(String quary){
        List<WebElement> elements=driver.findElements(By.xpath("//span[@class='a-declarative']/div/div/div/div[2]/div/div/div/h2"));
        if(elements.size()>0){
            for (WebElement element:elements){
                String text=element.getText();
                if (text.contains(quary)){
                    System.out.println("Search query contains result are "+text);
                }else {
                    System.out.println("Search query contains no result");
                }
            }
        }

    }
}
