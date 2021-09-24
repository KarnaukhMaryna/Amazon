package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//div[@data-card-identifier='YourLists']")
    private WebElement yourLists;

    @FindBy(xpath = "//li[@id='my-lists-tab']")
    private WebElement yourList;

    @FindBy(xpath = "//input[@name='submit.deleteItem']")
    private WebElement deleteItem;

    @FindBy(xpath = "//div[@class='a-alert-content'][contains(text(),'Deleted')]")
    private WebElement iconItemDeleted;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickYourLists(){ yourLists.click();}

    public void clickYourList(){ yourList.click();}

    public void clickDeleteItem() { deleteItem.click();}

    public String getIconItemDeletedText(){ return iconItemDeleted.getText();}

    public WebElement getIconItemDeleted() {return iconItemDeleted;}
}
