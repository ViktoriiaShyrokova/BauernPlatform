package de.bauernPlatform.pages;

import de.bauernPlatform.core.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Homepage extends PageBase {

    @FindBy(xpath = "//a[contains(text(), 'Registrieren')] | //button[contains(text(), 'Registrieren')]")
    private WebElement registerButton;

    @FindBy(xpath = "//button[contains(text(), 'Login')] | //a[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(css = "input[placeholder='Produkt suchen...']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[text()='Alle']/..")
    private WebElement categoryAll;

    @FindBy(xpath = "//span[text()='Gemüse']/..")
    private WebElement categoryVegetables;

    @FindBy(xpath = "//span[text()='Obst und Beeren']/..")
    private WebElement categoryFruits;

    @FindBy(xpath = "//span[text()='Bauern Produkte']/..")
    private WebElement categoryFarmerProducts;

    @FindBy(xpath = "//button[contains(text(), 'Details anzeigen')]")
    private List<WebElement> productDetailsButtons;

    @FindBy(xpath = "//button[contains(text(), 'Weiter ›')] | //a[contains(text(), 'Weiter ›')]")
    private WebElement paginationNextButton;

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }

    public boolean isSearchInputDisplayed() {
        return isDisplayed(searchInput);
    }

    public void clickLogin() {
        click(loginButton);
        //return new LoginPage(driver);
    }

    public void clickRegister() {
        click(registerButton);
        // return new RegisterPage(driver);
    }

    public void searchForProduct(String productName) {
        type(searchInput, productName);
        searchInput.submit();
    }

    public void selectVegetablesCategory() {
        click(categoryVegetables);
    }

    public int getDisplayedProductsCount() {
        if (!productDetailsButtons.isEmpty()) {
            return productDetailsButtons.size();
        }
        return 0;
    }

    public boolean isPaginationNextButtonDisplayed() {
        return isDisplayed(paginationNextButton);
    }
}
