package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField ;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountProductsInCart;

    @FindBy(xpath = "//span[contains(@id, 'accountList')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='nav-main']/div[@class='nav-left']")
    private WebElement catalog;

    @FindBy(xpath = "//div[@id='nav-tools']/a[contains(@href, 'select-language')]")
    private WebElement selectLanguageButton;

    @FindBy(xpath = "//a[@class='hmenu-item']/div[contains(text(), 'Electronics')]")
    private WebElement electronics;

    @FindBy(xpath = "//a[contains(text(), 'Phones')]")
    private WebElement phonesAndAccessories;

    @FindBy(xpath = "//li[@aria-label='Ailun']")
    private WebElement checkboxAilun;

    @FindBy(xpath = "//div[contains(@class, 's-card-container')]")
    public List<WebElement> productsOfAilun;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage(String url) {
        driver.get(url);
    }

    public void clickSearchButton() { searchButton.click();}

    public void clickSignInButton() {signInButton.click();}

    public void clickCatalog(){catalog.click();}

    public void clickCartButton(){ amountProductsInCart.click();}

    public String getTheNameOfAccount(){ return signInButton.getText();}

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSelectLanguageButton(){selectLanguageButton.click();}

    public void clickElectronics(){ electronics.click();}

    public void clickPhonesAndAccessories(){ phonesAndAccessories.click();}

    public void clickCheckboxAilun(){ ((JavascriptExecutor) driver).executeScript("arguments[0].click()", checkboxAilun);}

    public WebElement getCheckboxAilun(){ return checkboxAilun; }


}
