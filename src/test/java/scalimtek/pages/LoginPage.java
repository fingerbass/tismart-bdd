package scalimtek.pages;

import com.tismart.utils.WebDriverDOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebDriverDOM {
    @FindBy(id = "txtLoginName")
    private WebElement txtUsuario;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "btnIngresar")
    private WebElement btnIngresar;

    @FindBy(id = "lblMensaje")
    private WebElement msgLoginIncorrecto;

    public void digitarUsuario(String texto) {
        sendKeys(txtUsuario, texto);
    }

    public void digitarPassword(String texto) {
        sendKeys(txtPassword, texto);
    }

    public void clicBotonIngresar() {
        click(btnIngresar);
    }

    public String getTextoMsgLoginIncorrecto(){
        waitVisibility(msgLoginIncorrecto);
        return msgLoginIncorrecto.getText();
    }
}
