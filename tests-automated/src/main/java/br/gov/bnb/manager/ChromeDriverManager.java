package br.gov.bnb.manager;

import br.gov.bnb.factory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static br.gov.bnb.factory.BrowserList.CHROME;

public class ChromeDriverManager implements Factory {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(String.valueOf(CHROME)).setup();

        return new ChromeDriver();
    }
}
