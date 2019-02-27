package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCartResultPage extends BasePage {
	
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-success\"]//a[2]")
	private WebElement lbnProductAdded;
	
	public String getTextSuccess() {
		BasePage.implicitWait("//div[@class=\"alert alert-success\"]//a[2]");
		return lbnProductAdded.getText();
	}

	public AddToCartResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}


}
