package scalimtek.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import scalimtek.pages.LoginPage;

public class LoginStepDef {
    LoginPage paginaLogin = new LoginPage();

    // Steps sin usar "examples"
    @Given("Digito el usuario ABC123")
    public void digitoUsuario() {
        paginaLogin.digitarUsuario("ABC123");
    }

    @And("Digito la contraseña abrakadabra")
    public void digitoContrasena() {
        paginaLogin.digitarPassword("ABC123");
    }

    @When("Haga clic en el botón INGRESAR")
    public void hagoClicBotonIngresar() {
        paginaLogin.clicBotonIngresar();
    }

    @Then("El usuario no accede al sistema")
    public void usuarioNoAccede() {

    }

    // Steps usados por examples
    @Given("Digito el usuario {string}")
    public void digitoUsuarioX(String usuario) {
        paginaLogin.digitarUsuario(usuario);
    }

    @And("Digito la contraseña {string}")
    public void digitaPasswordX(String datoTexto) {
        paginaLogin.digitarPassword(datoTexto);
    }

    @Then("Se visualiza el mensaje {string}")
    public void validarMensajeLogin(String msgEsperado) {
        Assert.assertEquals(msgEsperado, paginaLogin.getTextoMsgLoginIncorrecto());
    }
}
