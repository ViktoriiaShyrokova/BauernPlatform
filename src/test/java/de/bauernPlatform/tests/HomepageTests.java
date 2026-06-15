package de.bauernPlatform.tests;

import de.bauernPlatform.core.TestBase;
import de.bauernPlatform.pages.Homepage;
import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTests extends TestBase {

    private Homepage homepage;

    @BeforeMethod
    public void initPage() {
        homepage = new Homepage(driver);
    }

    @Test(description = "Verify that the main elements on the homepage are displayed")
    public void testHomepageElementsAreDisplayed() {
        Assert.assertTrue(homepage.isLoginButtonDisplayed(), "Login button is not displayed");
        Assert.assertTrue(homepage.isSearchInputDisplayed(), "Product search input is not displayed");
    }

    @Test(description = "Verify the default number of displayed products on the homepage")
    public void testDefaultProductsCount() {
        int productCount = homepage.getDisplayedProductsCount();

        // Based on the pagination "1–20 von 31", the expected count per page is 20
        Assert.assertEquals(productCount, 20,
                "The number of product cards on the page does not match the expected count (20)");
    }

    @Test(description = "Verify navigation to the login page upon clicking the Login button")
    public void testClickOnLoginButton() {
        homepage.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"),
                "URL does not contain '/login' after clicking the Login button");
    }

    @Test(description = "Verify that the pagination block is visible at the bottom of the product list")
    public void testPaginationIsVisible() {
        Assert.assertTrue(homepage.isPaginationNextButtonDisplayed(),
                "The 'Next' button in the pagination block is not displayed");
    }
}
