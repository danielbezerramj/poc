package br.gov.bnb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DslPage {

    protected WebDriver driver;

    public void setFieldByName(By campo, String att){
        driver.findElement(campo).sendKeys(att);
    }

    public void clkByCss(By campo){
        driver.findElement(campo).click();
    }

    public void setPage(String url){
        driver.get(url);
    }

    public String getCurrentUrls(){
        return driver.getCurrentUrl();
    }

    public String getTextoAlert(By cmp){
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(cmp));
        return driver.findElement(cmp).getText();
    }

    public void quiteDriver(){
        if(driver != null) {
            driver.quit();
        }
    }
}
