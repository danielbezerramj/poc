package br.gov.bnb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends DslPage {

    public By alert = By.cssSelector("div[class='alert alert-secondary alert-dismissible']");

    public HomePage(WebDriver driver){ this.driver = driver; }

    public String retornaUrlHome(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("/home"));
        return getCurrentUrls();
    }

    public String getMensagemAlertLoginByCss() {
        return getTextoAlert(alert);
    }
}
