package mjaacademy.pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import mjaacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
 
	WebDriver driver;
	
	
	@FindBy(css="li.totalRow button") 	
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3") 	
   	List<WebElement> cartProducts;
	
		
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public Boolean VerifyProductDisplay(String productName) {
		
		Boolean match = cartProducts.stream()
				.allMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckoutPage () {
		
		checkoutEle.click();
		return new CheckoutPage(driver);
		
	}

	
	
}
