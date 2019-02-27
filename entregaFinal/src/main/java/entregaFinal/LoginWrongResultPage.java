package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginWrongResultPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class=\"alert alert-danger\"]")
	private WebElement msjeValidation;

	public LoginWrongResultPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public By getPageLoadLocator() {
		return By.xpath("//div[@class=\"alert alert-danger\"]");
	}

	public String getLbnMsjeValidation() {
		try {
			BasePage.implicitWait("//div[@class=\"alert alert-danger\"]");
			return msjeValidation.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
}
