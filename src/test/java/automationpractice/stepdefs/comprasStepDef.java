package automationpractice.stepdefs;

import automationpractice.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class comprasStepDef {
    HomePage homePage = new HomePage();

    @Given("Ingreso al menu principal {string}")
    public void IngresoAlMenuPrincipal(String nombreMenu) throws InterruptedException {
        homePage.IrMenuWomen();
        homePage.getListadoProductos();
    }

    @And("selecciono la categoría {string}")
    public void seleccionoLaCategoria(String nombreCategoria) {
    }

    @When("Agrego los productos")
    public void agregoLosProductos(DataTable productos) {
        List<Map<String, String>> producto = productos.asMaps(String.class, String.class);
        String nomProd = null;

        for (Map<String, String> prod : producto) {
            nomProd = prod.get("nombreProducto");
            // Paso 1 buscar el producto i
            // Paso 2 agregar ese producto al carrito
        }
    }

    @Then("El monto del carrito debería ser {string}")
    public void elMontoDelCarritoDeberiaSer(String arg0) {
    }
}
