package mjaacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import mjaacademy.TestComponents.BaseTest;
import mjaacademy.pageobjects.CartPage;
import mjaacademy.pageobjects.CheckoutPage;
import mjaacademy.pageobjects.ConfirmationPage;
import mjaacademy.pageobjects.LandingPage;
import mjaacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups={"ErrorHandling"},retryAnalyzer=mjaacademy.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{

		//class="btn btn-block login-btn"
		//div[aria-label='Incorrect email or password.']
		
           
           
        landingPage.loginApplication("balaarun0Mjamu@gmail.com", "Arunn#007");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage()); 
		
        
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String  productName = "ADIDAS ORIGINAL";
				ProductCatalogue productCatalogue =landingPage.loginApplication("arunmja@gmail.com", "Arunn#007");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage =productCatalogue.goToCartPage();
		
		Boolean match =cartPage.VerifyProductDisplay("ADIDAS ORIGINAL 12");
		Assert.assertFalse(match);
		

	}

}
