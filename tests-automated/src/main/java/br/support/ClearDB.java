package br.support;

import br.gov.bnb.wrapper.BaseApi;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ClearDB extends BaseApi {

    public static void deletaUsuario(String nome){
        try {
            String id = getIdUsuarioParaDeletar(nome).toString();
            given().relaxedHTTPSValidation().header("Accept","application/json")
                    .when().delete("/usuarios/" + id).then()
                    .log().all().statusCode(HttpStatus.SC_OK);
        } catch (AssertionError ae){
            System.out.println("Não encontrou o usuario pelo _id.");
            ae.printStackTrace();
        }
    }

    private static String getIdUsuarioParaDeletar(String nome){
        return given().relaxedHTTPSValidation().header("Accept","application/json").when().get("/usuarios?nome=" + nome).then()
                .log().all().extract().path("usuarios[0]._id");
    }

}
