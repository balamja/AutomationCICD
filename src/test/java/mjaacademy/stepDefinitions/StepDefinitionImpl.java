package mjaacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mjaacademy.TestComponents.BaseTest;
import mjaacademy.pageobjects.CartPage;
import mjaacademy.pageobjects.CheckoutPage;
import mjaacademy.pageobjects.ConfirmationPage;
import mjaacademy.pageobjects.LandingPage;
import mjaacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = loginApplication();
    }

    @Given("I login with username {string} and password {string}")
    public void logged_in_username_and_password(String username, String password) {
        productCatalogue = landingPage.loginApplication(username, password);
    }

    @When("I add the product {string} to the cart")
    public void i_add_product_to_page(String productName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("I checkout the product {string} and submit the order")
    public void checkout_subit_order(String productName) {
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message should be displayed on the Confirmation Page")
    public void message_is_displayed_on_ConfirmationPage(String expectedMessage) {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(expectedMessage));
        driver.close();
        
         }
    @Then("{string} message is displayed")
    public void somthing_error_diisplayed(String string) {
    	Assert.assertEquals(string, landingPage.getErrorMessage()); 
    	driver.close();
    }
    
    
   
}
