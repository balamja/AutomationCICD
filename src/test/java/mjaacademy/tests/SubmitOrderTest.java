package mjaacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import io.github.bonigarcia.wdm.WebDriverManager;
import mjaacademy.TestComponents.BaseTest;
import mjaacademy.pageobjects.CartPage;
import mjaacademy.pageobjects.CheckoutPage;
import mjaacademy.pageobjects.ConfirmationPage;
import mjaacademy.pageobjects.LandingPage;
import mjaacademy.pageobjects.OrderPage;
import mjaacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String  productName= "ADIDAS ORIGINAL";
	@Test(dataProvider="getData" ,groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		
	    ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage =productCatalogue.goToCartPage();
		
		Boolean match =cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage =checkoutPage.submitOrder();		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() throws InterruptedException {
		
		//"ADIDAS ORIGINAL"; to know adidas is present are not
		
		ProductCatalogue productCatalogue =landingPage.loginApplication("balaarun009@gmail.com", "Arunn#007");
		OrderPage orderspage =productCatalogue.goToOrdersPage();
	    Assert.assertTrue(orderspage.VerifyOrderDisplay(productName));
		
	}
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws  IOException {
		
		

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\mjaacademy\\data\\PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
		
		
	}
	

}

//
//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email","balaarun009@gmail.com");
//map.put("password","Arunn#007"); 
//map.put("product","ADIDAS ORIGINAL"); 
//
//
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email","arunmja@gmail.com");
//map1.put("password","Arunn#007"); 
//map1.put("product","IPHONE 13 PRO"); 
//
