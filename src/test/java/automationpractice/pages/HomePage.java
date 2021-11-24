package automationpractice.pages;

import com.tismart.utils.WebDriverDOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebDriverDOM {
    @FindBy(xpath = "//a[@title='Women']")
    private WebElement menuWomen;

    @FindBy(xpath = "//ul[contains(@class,'product_list')]")
    private WebElement listadoProductos;

    public void IrMenuWomen() throws InterruptedException {
        click(menuWomen);
//        actions.moveToElement(menuWomen).perform();
//        Thread.sleep(5000);
    }

    public void getListadoProductos() {
        System.out.println("================== MOSTRANDO DATOS DEL ELEMENTO LISTADOPRODICTOS ==================");
        System.out.println(listadoProductos);
    }

}
