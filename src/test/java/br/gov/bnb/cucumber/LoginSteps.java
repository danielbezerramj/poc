package br.gov.bnb.cucumber;

import br.gov.bnb.pages.HomePage;
import br.gov.bnb.pages.LoginPage;
import br.gov.bnb.wrapper.BaseWeb;
import br.support.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends BaseWeb {

    private HomePage home;
    private LoginPage login;
    private String user = ReadProperties.getInstance().getValue("email.login");
    private String pass = ReadProperties.getInstance().getValue("pass.login");

    @After
    public void tearDown() {
        login.quitePageTest();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        home = new HomePage(getDriver());
        login = new LoginPage(driver);
        login.doLogin("https://front.serverest.dev/login", user, pass);
    }

    @When("I enter my email and password invalid")
    public void i_enter_my_email_and_password_invalid() {
        System.out.println("2");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        System.out.println("3");
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        System.out.println("4");
        assertEquals("×\nEmail e/ou senha inválidos", home.getMensagemAlertLoginByCss());
    }
}
