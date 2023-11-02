package edu.microservicios;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

// Clase de prueba para GreetingResource
@QuarkusTest
public class GreetingResourceTest {

    // Método de prueba para la ruta "/hello"
    @Test
    public void testHello() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)  // Verificar que el código de estado sea 200 (OK)
             .body(is("Hello"));  // Verificar que el cuerpo de la respuesta sea "Hello"
    }
}
