package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailOrPhoneNumberField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//h4[@class='a-alert-heading']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccountButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToEmailOrPhoneNumberField(final String email) {
        emailOrPhoneNumberField.clear();
        emailOrPhoneNumberField.sendKeys(email);
    }

    public void clickContinueButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", continueButton);
    }

    public void enterTextToPasswordField(final String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() { signInButton.click(); }

    public void clickCreateAccountButton(){ createAccountButton.click();}

    public String getErrorMessage(){ return errorMessage.getText();}

}
