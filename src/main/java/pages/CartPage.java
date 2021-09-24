package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement quantityOfProducts;

    @FindBy(xpath = "//a[contains(text(), 'Delete')]")
    private WebElement deleteFromCart;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountProductsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickQuantityOfProductsButton(){ quantityOfProducts.click();}

    public void clickDeleteFromCart(){ deleteFromCart.click();}

    public String getAmountProductsInCart(){return amountProductsInCart.getText();}
}
