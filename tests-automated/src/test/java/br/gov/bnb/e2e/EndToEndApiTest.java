package br.gov.bnb.e2e;

import br.gov.bnb.wrapper.BaseApi;
import org.apache.http.HttpStatus;
import org.junit.Test;
import br.support.ClearDB;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class EndToEndApiTest extends BaseApi {

    private  JSONObject requestParams = new JSONObject();

    @Test
    public void testCriarEListarNovoUsuario(){
        requestParams.put("nome", "Lobo Silva");
        requestParams.put("email", "lobo@qa.com");
        requestParams.put("password", "teste");
        requestParams.put("administrador", "true");

        given().relaxedHTTPSValidation().header("Accept","application/json").contentType("application/json")
                .body(requestParams.toString())
                .log().all()
                .when().post("/usuarios").then()
                .log().all().statusCode(HttpStatus.SC_CREATED)
                .body("message", equalTo("Cadastro realizado com sucesso"));

        given().relaxedHTTPSValidation().header("Accept","application/json").when().get("/usuarios?nome=Lobo").then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body(containsString("quantidade"))
                .body(containsString("Lobo Silva"))
                .body("usuarios.nome[0]", equalTo("Lobo Silva"));

        ClearDB.deletaUsuario("Lobo Silva");
    }
}
