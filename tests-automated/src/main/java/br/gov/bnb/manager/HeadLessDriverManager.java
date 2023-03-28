package br.gov.bnb.manager;

import br.gov.bnb.factory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static br.gov.bnb.factory.BrowserList.CHROME;

public class HeadLessDriverManager implements Factory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(String.valueOf(CHROME)).setup();

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");

        return new ChromeDriver(chromeOptions);
    }
}
