package com.tismart.utils;

import com.tismart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Se encarga de realizar acciones sobre un elemento web.
 */
public class WebDriverDOM {
    public WebDriver driver;
    public final Actions actions;

    public WebDriverDOM() {
        driver = new DriverManager().getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    // Espera que un elemento web se encuentre visible.
    public void waitVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Hacer clic sobre un elemento web
    public void click(WebElement e) {
        waitVisibility(e);
        e.click();
    }
}