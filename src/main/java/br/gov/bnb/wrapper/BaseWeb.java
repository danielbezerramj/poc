package br.gov.bnb.wrapper;

import br.gov.bnb.factory.DriverFactory;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseWeb {
    protected WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BaseWeb.class);


    @Before
    public void preCondition() {
        //String browserToUse = ReadProperties.getInstance().getValue("browser");
        String browserToUse = System.getProperty("browser", "Chrome");
        driver = new DriverFactory().createInstance(browserToUse);
    }

    @After
    public void postCondition() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\printScreen\\"+ getClass().getName()+ ".png"));
    }

}
