package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMainPage() {
        return new MainPage(driver);
    }

    public LanguageSettingsPage getLanguageSettingsPage() {
        return new LanguageSettingsPage(driver);
    }

    public CreateAccountPage getCreateAccountPage() {
        return new CreateAccountPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public ProductPage getProductPage() {return new ProductPage(driver); }

    public SearchResultsPage getSearchResultsPage() { return new SearchResultsPage(driver); }

    public CartPage getCartPage() { return new CartPage(driver);}

    public AccountPage getAccountPage() { return new AccountPage(driver); }


}
