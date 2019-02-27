package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmptyCartPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]//*[@class=\"btn btn-danger\"]")
	private WebElement removeItemBtn;

	public EmptyCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmptyCartResultPage clickDeleteItem() {
		try {
			BasePage.implicitWait("//*[@id=\"content\"]//*[@class=\"btn btn-danger\"]");
			removeItemBtn.click();
			return new EmptyCartResultPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
