package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='passwordCheck']")
    private WebElement reEnterPasswordField;

    @FindBy(xpath = "//div[@class='a-alert-content'][contains(text(), 'Invalid email')]")
    private WebElement errorForInvalidEmail;

    @FindBy(xpath = "//div[contains(@id, 'customerName')]//div[@class='a-alert-content']")
    private WebElement errorForEmptyNameField;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterNameInField(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void reEnterPasswordInField(String password){
        reEnterPasswordField.clear();
        reEnterPasswordField.sendKeys(password);
    }

    public String getErrorForInvalidEmail(){ return errorForInvalidEmail.getText();}

    public String getErrorForEmptyNameField() { return errorForEmptyNameField.getText();}
}
