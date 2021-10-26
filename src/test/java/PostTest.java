import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class PostTest {

        @Test
        void shouldReturnDemoAccounts() {
            // Given - When - Then
            // Предусловия
            given()
                    .baseUri("https://postman-echo.com")
                    .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                    // Выполняемые действия
                    .when()
                    .post("/post")
                    // Проверки
                    .then()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                    .header("Content-Type", "application/json; charset=utf-8")
                    .header("Connection", "keep-alive")
                    .header("Vary", "Accept-Encoding");
        }
}