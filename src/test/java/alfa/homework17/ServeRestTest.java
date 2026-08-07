package alfa.homework17;

import alfa.homework17.com.lesson.homework.models.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServeRestTest {
    private static String userId;
    private static String token;
    private static final String EMAIL = "spy_" + System.currentTimeMillis() + "@qa.com";

    @BeforeAll
    @DisplayName("Задание № 1")
    static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Задание № 2")
    public void shouldGetAllUsers() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("quantidade", greaterThan(0))
                .body("usuarios", hasSize(greaterThan(0)));
    }

    @Test
    @DisplayName("Задание № 3")
    public void shouldFindUserByEmail() {
        String email = given().when().get("/usuarios").then().extract().path("usuarios[0].email");

        given()
                .queryParam("email", email)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", is(1))
                .body("usuarios[0].email", equalTo(email));
    }

    @Test
    @Order(1)
    @DisplayName("Задание № 4")
    public void shouldCreateNewUser() {
        userId = given()
                .contentType(ContentType.JSON)
                .body(String.format("""
                        {
                          "nome": "Тайный Покупатель",
                          "email": "%s",
                          "password": "secret123",
                          "administrador": "true"
                        }
                        """, EMAIL))
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue())
                .extract().path("_id");
    }

    @Test
    @Order(2)
    @DisplayName("Задание № 5")
    public void shouldUpdateUser() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", userId)
                .body(String.format("""
                        {
                          "nome": "Обновлённый Покупатель",
                          "email": "%s",
                          "password": "secret123",
                          "administrador": "true"
                        }
                        """, EMAIL))
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(3)
    @DisplayName("Задание № 6.1")
    public void shouldLogin() {
        token = given()
                .contentType(ContentType.JSON)
                .body(String.format("""
                        {
                          "email": "%s",
                          "password": "secret123"
                        }
                        """, EMAIL))
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", notNullValue())
                .extract().path("authorization");
    }

    @Test
    @Order(4)
    @DisplayName("Задание № 6.2")
    public void shouldDeleteUser() {
        given()
                .header("Authorization", token)
                .pathParam("id", userId)
                .when()
                .delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));
        given()
                .pathParam("id", userId)
                .when()
                .get("/usuarios/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }

    @Test
    @DisplayName("Задание № 7")
    public void shouldGetAllProducts() {
        given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("produtos.preco", everyItem(greaterThan(0)))
                .body("produtos.nome", everyItem((notNullValue())))
                .body("produtos.nome", hasItem("Logitech MX Vertical"));
    }

    @Test
    @DisplayName("★ Создание пользователя через DTO (сериализация)")
    public void shouldCreateUserFromDto() {
        Usuario usuario = new Usuario("Тайный Покупатель", EMAIL, "secret123", "true");
        given()
                .contentType(ContentType.JSON)
                .body(usuario)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", notNullValue());
    }
}
