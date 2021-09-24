package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(), 'Blu (Ocean Blue)')]")
    private WebElement neededProduct;

    @FindBy(xpath = "//h2[contains(@class, 'a-size-mini')]")
    private List<WebElement> searchResults;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickNeededProduct(){ neededProduct.click(); }

    public void clickFirstProduct(){ searchResults.get(0).click();}
}
