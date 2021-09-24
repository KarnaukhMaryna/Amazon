package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static String url = "https://www.amazon.com/";
    private static String keyword ="xiaomi redmi note 8 pro";
    private static String keyword2 ="DualShock 4";
    private static String email = "autotestingex@gmail.com";
    private static String invalidEmail = "hdlam76jib";
    private static String password = "qaz123xsw";
    private static String name = "Testing";
    private static String addedToWishList = "1 item added";
    private static String error = "Wrong";
    private static String errorForName = "Enter your name";
    WebDriver driver;
    MainPage mainPage;
    CreateAccountPage createAccountPage;
    LanguageSettingsPage languageSettingsPage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    ProductPage productPage;
    CartPage cartPage;
    AccountPage accountPage;
    PageFactoryManager pageFactoryManager;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens main page")
    public void userOpensMainPage() {
        mainPage = pageFactoryManager.getMainPage();
        mainPage.openMainPage(url);
    }

    @When("User clicks sign in button")
    public void userClicksSignInButton() {
        mainPage.clickSignInButton();
    }

    @And("User enters invalid email in the field")
    public void userEntersInvalidEmailInTheField() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterTextToEmailOrPhoneNumberField(invalidEmail);
    }

    @And("User clicks continue button")
    public void userClicksContinueButton() {
        signInPage.clickContinueButton();
    }

    @Then("User checks that error message appears")
    public void userChecksThatErrorMessageAppears() {
        assertTrue(signInPage.getErrorMessage().equalsIgnoreCase("There was a problem"));
    }

    @When("User clicks language button")
    public void userClicksLanguageButton() {
        mainPage.clickSelectLanguageButton();
    }

    @And("User clicks Deutsch language")
    public void userClicksDeutschLanguage() {
        languageSettingsPage = pageFactoryManager.getLanguageSettingsPage();
        languageSettingsPage.clickDeutschLanguage();
    }

    @And("User clicks save changes button")
    public void userClicksSaveChangesButton() {
        languageSettingsPage.clickSaveChangesButton();
    }

    @Then("User checks that current url contains chosen language")
    public void userChecksThatCurrentUrlContainsChosenLanguage() {
        assertTrue(driver.getCurrentUrl().contains("language=de_DE"));
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @And("User enters valid email in the field")
    public void userEntersValidEmailInTheField() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterTextToEmailOrPhoneNumberField(email);
    }

    @And("User enters valid password in the field")
    public void userEntersValidPasswordInTheField() {
        signInPage.enterTextToPasswordField(password);
    }

    @And("User clicks sign in button to continue")
    public void userClicksSignInButtonToContinue() {
        signInPage.clickSignInButton();
    }

    @Then("User checks that his name on the page")
    public void userChecksThatHisNameOnThePage() {
        assertTrue(mainPage.getTheNameOfAccount().contains(name));
    }

    @When("User makes search by keyword")
    public void userMakesSearchByKeyword() {
        mainPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        mainPage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        mainPage.clickSearchButton();
    }

    @And("User clicks on needed product")
    public void userClicksOnNeededProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickNeededProduct();
    }

    @And("User clicks wish list on product")
    public void userClicksWishListOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToListButton();
    }

    @And("User checks that product added to wishlist")
    public void userChecksThatProductAddedToWishlist() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAmountInWishList());
        assertTrue(productPage.getAmountAddedToWishList().contains(addedToWishList));
    }

    @When("User makes search by other keyword")
    public void userMakesSearchByOtherKeyword() {
        mainPage.enterTextToSearchField(keyword2);
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickFirstProduct();
    }

    @And("User clicks on add to cart button")
    public void userClicksOnAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton();
    }

    @Then("User checks that product added to cart")
    public void userChecksThatProductAddedToCart() {
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(productPage.getAmountProductsInCart().equals("1"));
    }

    @When("User clicks on cart button")
    public void userClicksOnCartButton() {
        mainPage.clickCartButton();
    }

    @And("User deletes product from cart")
    public void userDeletesProductFromCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.clickQuantityOfProductsButton();
        cartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickDeleteFromCart();
    }

    @Then("User checks that cart is empty")
    public void userChecksThatCartIsEmpty() {
        assertTrue(cartPage.getAmountProductsInCart().equals("0"));
    }

    @And("User clicks on section lists")
    public void userClicksOnSectionLists() {
        accountPage = pageFactoryManager.getAccountPage();
        accountPage.clickYourLists();
        accountPage.clickYourList();
    }

    @And("User clicks on delete item")
    public void userClicksOnDeleteItem() {
        accountPage.clickDeleteItem();
    }

    @Then("User checks that product deleted")
    public void userChecksThatProductDeleted() {
        accountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, accountPage.getIconItemDeleted());
        assertTrue(accountPage.getIconItemDeletedText().equals("Deleted"));
    }

    @When("User clicks on catalog")
    public void userClicksOnCatalog() {
        mainPage.clickCatalog();
    }

    @And("User clicks on electronics category")
    public void userClicksOnElectronicsCategory() {
        mainPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        mainPage.clickElectronics();
    }

    @And("User clicks on phones and accessories")
    public void userClicksOnPhonesAndAccessories() {
        mainPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        mainPage.clickPhonesAndAccessories();
    }

    @And("User clicks on filter Ailun")
    public void userClicksOnFilterAilun() {
        mainPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, mainPage.getCheckboxAilun());
        mainPage.clickCheckboxAilun();
        mainPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that names of products in the page contains Ailun")
    public void userChecksThatNamesOfProductsInThePageContainsAilun() {
        for (WebElement webElement : mainPage.productsOfAilun){
            assertTrue(webElement.getText().contains("Ailun"));
        }
    }

    @When("User clicks button to create account")
    public void userClicksButtonToCreateAccount() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickCreateAccountButton();
    }

    @And("User enters name in field")
    public void userEntersNameInField() {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.enterNameInField(name);
    }

    @And("User re-enters password")
    public void userReEntersPassword() {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        createAccountPage.reEnterPasswordInField(password);
    }

    @Then("User checks that error appears under email field")
    public void userChecksThatErrorAppearsUnderEmailField() {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.getErrorForInvalidEmail().contains(error));
    }

    @Then("User checks that error appears under name field")
    public void userChecksThatErrorAppearsUnderNameField() {
        assertTrue(createAccountPage.getErrorForEmptyNameField().contains(errorForName));
    }
}
