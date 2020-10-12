package br.com.stanley.vgeplugins.rest;

import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FuncionalidadeResourceTest {
	
	@Test
	void obtemFuncionalidadeComSucesso () {
		
		RestAssured.given()
        .pathParam("id", "123456")
        .when().get("/funcionalidade/{id}")
        .then()
          .statusCode(200);
		
	}

}
