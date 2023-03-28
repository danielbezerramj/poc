package br.gov.bnb.api;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import br.support.ClearDB;
import br.gov.bnb.wrapper.BaseApi;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiUsuariosTest extends BaseApi {

    private  JSONObject requestParams = new JSONObject();
    @Test
    public void testRetornaListaUsuarios(){
        Response response = given().relaxedHTTPSValidation().header("Accept", "application/json").when().get("/usuarios");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertTrue(response.asPrettyString().contains("Fulano"));
    }
    @Test
    public void testRetornaListaUsuariosComParametro(){
        given().relaxedHTTPSValidation().header("Accept","application/json").when().get("/usuarios?nome=Fulano").then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("quantidade"))
                .body(containsString("Fulano da Silva"))
                .body("usuarios.nome[0]", equalTo("Fulano da Silva"));
    }

    @Test
    public void testCriarNovoUsuario(){
        requestParams.put("nome", "Manolo Silva");
        requestParams.put("email", "manolo@qa.com");
        requestParams.put("password", "teste");
        requestParams.put("administrador", "true");

        given().relaxedHTTPSValidation().header("Accept","application/json").contentType("application/json")
                .body(requestParams.toString())
                .log().all()
                .when().post("/usuarios").then()
                .log().all().statusCode(HttpStatus.SC_CREATED)
                .body("message", equalTo("Cadastro realizado com sucesso"));

        ClearDB.deletaUsuario("Manolo Silva");
    }

}
