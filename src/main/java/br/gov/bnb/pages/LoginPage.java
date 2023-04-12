package br.gov.bnb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends DslPage {
    private By usernameBy = By.name("email");
    private By passwordBy = By.name("password");
    private By btnLogin = By.cssSelector("button[data-testid='entrar']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void doLogin(String url, String email, String pass){
        openPage(url);
        setFieldByName(usernameBy, email);
        setFieldByName(passwordBy, pass);
        clkByCss(btnLogin);
    }

    public void openPage(String url){
        setPage(url);
    }

    public void quitePageTest(){
        quiteDriver();
    }
}
