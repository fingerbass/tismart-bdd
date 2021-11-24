package com.tismart.utils;

import com.tismart.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Se encarga de realizar acciones sobre un elemento web.
 */
public class WebDriverDOM {
    public WebDriver driver;
    public final Actions actions;
    public final TestUtils utils;

    public WebDriverDOM() {
        utils = new TestUtils();
        driver = new DriverManager().getDriver();
        driver.manage().timeouts().implicitlyWait(TestUtils.WAIT, TimeUnit.SECONDS);
        actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    /**
     * Espera que un objeto tipo WebElement esté visible
     */
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

//    public void waitForInvisibilityOf(String e){
//        WebElement element = driver.findElement()
//        WebDriverWait wait;
//    }

    /**
     * Crea elementos web (WebElements) a partir de un hijo de un WebElement creado
     */
    public WebElement nestedWebElement(WebElement elemento, String subelemento) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(elemento, By.xpath(subelemento)));
        WebElement we = elemento.findElement(By.xpath(subelemento));
        return we;
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    /**
     * Limpia los datos de un objeto WebElement
     */
    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    /**
     * Clic en un objeto tipo WebElement
     */
    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    /**
     * Clic en un objeto tipo WebElement y envía un mensaje
     * al log del framework.
     */
    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }

    /**
     * Clic en un objeto buscado por By y envía
     * un mensaje al log del framework
     */
    public void click(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    /**
     * Envía texto a un objeto tipo WebElement
     *
     * @param e   Objeto
     * @param txt Texto
     */
    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }


    /**
     * Envía texto a un objeto tipo WebElement
     * y envía texto al log de ejecuciones.
     */
    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    /**
     * Devuelve el atributo pasado como parámetro
     * de un objeto tipo WebElement
     */
    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    /**
     * Devuelve el atributo pasado como parámetro
     * de un objeto tipo By
     */
    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    /**
     * Obtiene el texto de un objeto tipo WebElement
     * y envía un mensaje al log del framework
     */
    public String getText(WebElement e, String msg) {
        String txt = e.getText();
        utils.log().info(msg + txt);
        return txt;
    }

    /**
     * Obtiene el texto de un objeto tipo By
     * y envía un mensaje al log del framework
     */
    public String getText(By e, String msg) {
        String txt = driver.findElement(e).getText();
        utils.log().info(msg + txt);
        return txt;
    }


    /**
     * Seleccionar una opción de un menú dropdown (Select) por By
     * y envía un mensaje al log del framework
     */
    public void selectOption(By e, String txt, String msg) {
        waitForVisibility(e);
        Select select = new Select(driver.findElement(e));
        select.selectByVisibleText(txt);
        utils.log().info(msg + txt);
    }

    /**
     * Seleccionar una opción de un menú dropdown (Select) por WebElement
     * y envía un mensaje al log del framework
     */
    public void selectOption(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        Select select = new Select(e);
        select.selectByVisibleText(txt);
        utils.log().info(msg + txt);
    }

    /**
     * Método para posicionarse sobre un web element
     * y envía un mensaje al log del framework
     */
    public void objectHover(WebElement e, String msg) {
        actions.moveToElement(e).perform();
        utils.log().info(msg);
    }

    /**
     * Método para posicionarse sobre un web element
     * y envía un mensaje al log del framework
     */
    public void objectHover(By e, String msg) {
        actions.moveToElement(driver.findElement(e)).perform();
        utils.log().info(msg);
    }

    /**
     * Acepta un mensaje de Alerta JavaScript
     */
    public void acceptWebAlert() {
        driver.switchTo().alert().accept();
        utils.log().info("Aceptando mensaje Alert");
    }

    /**
     * Cancela un mensaje de alerta Javascript
     */
    public void dismissWebAlert() {
        driver.switchTo().alert().dismiss();
        utils.log().info("Cancelando mensaje Alert");
    }
}