package entregaFinal;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelConfig;

public class LogOutTest extends BaseTest {

	@Test(dataProvider = "testDataLogin")
	public void testLogOutOk(String mail, String passw) {
		LoginPage loginPage = homePage.clickLoginLink();
		loginPage.logInputs(mail, passw);
		LoginResultPage loginResult = loginPage.clickLogin();
		if (!loginResult.getLbnAccount().isEmpty()) {
			LogOutResultPage logOutResult = loginResult.clickLogOut();
			AssertJUnit.assertEquals("Account Logout", logOutResult.getLbnLogOut());
		} else {
			System.out.println("Problemas al realizar login");
		}
	}

	@Test
	@DataProvider
	public Object[][] testDataLogin() {
		ExcelConfig ex = new ExcelConfig("src/loginData.xlsx");
		Object data[][] = ex.readExcel();
		return data;
	}
}
