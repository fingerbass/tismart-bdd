package automationpractice.pages;

import com.tismart.utils.WebDriverDOM;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TiendaPage extends WebDriverDOM {
    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private List<WebElement> listaProductos;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeAddedConfirmation;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    private WebElement textConfirmationSuccessfull;

    @FindBy(xpath = "//div[@class='shopping_cart']/a[@title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//span[@class='price cart_block_total ajax_block_cart_total']")
    private WebElement totalPrice;


//    @FindBy(xpath = "//a[@title='Blouse' and @class='product-name']")
    // XPath dinámico del elemento Price//ul[@class='product_list grid row']/li/div/div[2]/div/span[@itemprop='price']
    // XPath dinámico del elemento Add to Cart: //ul[@class='product_list grid row']/li/div/div[2]/div[2]/a[@title='Add to cart']

    // div/div[2]/h5/a

    public void agregarItem(String nomProd, String precProd, String msgEsperado) {
//        itemBlusa.click();
        String auxNomProd, auxPrecProd;

        for (int item = 0; item < listaProductos.size(); item++) {
            auxNomProd = listaProductos.get(item).findElement(By.xpath("div/div[2]/h5/a")).getText();
            auxPrecProd = listaProductos.get(item).findElement(By.xpath("div/div[2]/div/span[@itemprop='price']")).getText();

            if (auxNomProd.equals(nomProd) && auxPrecProd.equals(precProd)) {
//                System.out.println("-------------------------------------");
//                System.out.println("Nombre del producto " + item + ": " + auxNomProd);
//                System.out.println("-------------------------------------");
                click(listaProductos.get(item));
                click(listaProductos.get(item).findElement(By.xpath("div/div[2]/div[2]/a[@title='Add to cart']")));

                // Esperamos que popup se cargue con el mensaje de confirmación
                waitForVisibility(textConfirmationSuccessfull);

                Assert.assertEquals(msgEsperado, getText(textConfirmationSuccessfull, "Leyendo datos"));
                click(closeAddedConfirmation);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void validaPrecioTotal(String precioEsperado) {
//        click(shoppingCart);
        actions.moveToElement(shoppingCart).perform();

//        objectHover(shoppingCart, "Desplegando carrito de compras");

        waitForVisibility(totalPrice);
        Assert.assertEquals(precioEsperado, totalPrice.getText());
    }
}
