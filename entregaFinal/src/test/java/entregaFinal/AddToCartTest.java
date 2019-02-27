package entregaFinal;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import entregaFinal.AddToCartResultPage;

public class AddToCartTest extends BaseTest {

	@Test
	public void addProductToCartTest() {
		AddToCartResultPage addToCart = homePage.clickAddToCart();
		AssertJUnit.assertEquals("shopping cart",
				addToCart.getTextSuccess());
	}

}
