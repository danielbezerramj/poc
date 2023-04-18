package br.gov.bnb.ui;

import br.gov.bnb.pages.HomePage;
import br.gov.bnb.pages.LoginPage;
import br.gov.bnb.wrapper.BaseWeb;
import br.support.ReadProperties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CadastroUsuarioTest extends BaseWeb {

    private HomePage home;
    private LoginPage login;
    private String user = ReadProperties.getInstance().getValue("email.login");
    private String pass = ReadProperties.getInstance().getValue("pass.login");

    @Before
    public void setUp(){
        home = new HomePage(driver);
        login = new LoginPage(driver);
        login.doLogin("https://front.serverest.dev/login",user, pass);
    }
    
    @After
    public void tearDown() {
    	login.quitePageTest();
    }

    @Test
    public void validaTelaHomeTest() throws IOException {
        getScreenShot();
        assertEquals("×\nEmail e/ou senha inválidos", home.getMensagemAlertLoginByCss());
    }
}
