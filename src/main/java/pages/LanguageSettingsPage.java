package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageSettingsPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class,'a-radio-label')][contains(text(),'Deutsch')]")
    private WebElement deutschLanguage;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveChangesButton;

    public LanguageSettingsPage(WebDriver driver) {super(driver);}

    public void clickSaveChangesButton(){saveChangesButton.click();}

    public void clickDeutschLanguage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", deutschLanguage);
    }

    public WebElement getDeutschLanguage(){return deutschLanguage;}
}
