package entregaFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogOutResultPage extends BasePage{
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h1[contains(text(),\"Account Logout\")]")
	private WebElement lbnLogOut;

	public String getLbnLogOut() {
		BasePage.implicitWait("//*[@id=\"content\"]/h1[contains(text(),\"Account Logout\")]");
		return lbnLogOut.getText();
	}
	public LogOutResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public By getPageLoadLocator() {
		// TODO Auto-generated method stub
		return null;
	}

}
