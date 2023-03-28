package br.gov.bnb.manager;

import br.gov.bnb.factory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.gov.bnb.factory.BrowserList.FIREFOX;

public class FirefoxDriverManager implements Factory {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(String.valueOf(FIREFOX)).setup();

        return new FirefoxDriver();
    }
}
