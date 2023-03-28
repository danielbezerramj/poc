package br.gov.bnb.factory;

import br.gov.bnb.exceptions.BrowserNotSupportedException;
import br.gov.bnb.manager.ChromeDriverManager;
import br.gov.bnb.manager.FirefoxDriverManager;
import br.gov.bnb.manager.HeadLessDriverManager;
import org.openqa.selenium.WebDriver;

import static br.gov.bnb.factory.BrowserList.HEADLESS;

public class DriverFactory {
    public WebDriver createInstance(String browser) {
        WebDriver driver;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            case HEADLESS:
                driver = new HeadLessDriverManager().createDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
    public enum BrowserList {
        CHROME, FIREFOX, HEADLESS
    }
}
