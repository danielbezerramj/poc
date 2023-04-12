package br.gov.bnb.wrapper;

import br.gov.bnb.factory.DriverFactory;
import org.apache.commons.io.FileUtils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseWeb {
    protected WebDriver driver;

    @Before
    public void preCondition() {
        //String browserToUse = ReadProperties.getInstance().getValue("browser");
        String browserToUse = System.getProperty("browser", "Chrome");
        driver = new DriverFactory().createInstance(browserToUse);
    }

    public WebDriver getDriver() {
        //String browserToUse = ReadProperties.getInstance().getValue("browser");
        String browserToUse = System.getProperty("browser", "Chrome");
        return driver = new DriverFactory().createInstance(browserToUse);
    }

    @After
    public void postCondition() {
       /* if (driver != null) {
            driver.quit();
        }*/
    }

    /*public void quiteDriver() {
        driver.quit();
    }*/

    protected void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\printScreen\\" + getClass().getName() + ".png"));
    }

}
