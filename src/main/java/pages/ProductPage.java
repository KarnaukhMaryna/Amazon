package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//input[@title='Add to List']")
    private WebElement addToListButton;

    @FindBy(xpath = "//div[@class='w-success-msg']")
    private WebElement amountAddedToWishList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountProductsInCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToListButton(){addToListButton.click();}

    public String getAmountAddedToWishList(){ return amountAddedToWishList.getText();}

    public WebElement getAmountInWishList(){ return amountAddedToWishList;}

    public void clickAddToCartButton(){ addToCartButton.click();}

    public String getAmountProductsInCart(){return amountProductsInCart.getText();}

}
