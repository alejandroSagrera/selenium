package entregaFinal;

import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import Utilities.ExcelConfig;
import entregaFinal.BaseTest;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends BaseTest {

	@Test(dataProvider = "testDataLogin", priority=1) 
	public void testLoginOk(String mail, String passw) {
		LoginPage loginPage = homePage.clickLoginLink();
		loginPage.logInputs(mail, passw);
		LoginResultPage loginResult = loginPage.clickLogin();
		AssertJUnit.assertEquals("My Account", loginResult.getLbnAccount());
	}
	@Test(dataProvider = "testDataIncorrectLogin", priority=2)  
	public void testLoginNotOk(String mail, String passw) {
		LoginPage loginPage = homePage.clickLoginLink();
		loginPage.logInputs(mail, passw);
		LoginWrongResultPage loginResult = loginPage.clickLoginWrongData();
		AssertJUnit.assertEquals("Warning: No match for E-Mail Address and/or Password.", loginResult.getLbnMsjeValidation());
	}

	@Test
	@DataProvider
	public Object[][] testDataLogin() {
		try {
		ExcelConfig ex = new ExcelConfig("src/loginData.xlsx");
		Object data[][] = ex.readExcel();
		return data;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Test
	@DataProvider
	public Object[][] testDataIncorrectLogin() {
		ExcelConfig ex = new ExcelConfig("src/loginIncorrectData.xlsx");
		Object data[][] = ex.readExcel();
		return data;
	}
}
