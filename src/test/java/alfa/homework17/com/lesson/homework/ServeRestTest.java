package alfa.homework17.com.lesson.homework;

import alfa.homework17.com.lesson.homework.models.Usuario;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;

/**
 * Учебный набор API-тестов для тренировочного магазина ServeRest (https://serverest.dev).
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServeRestTest {

    private static final String USER_MESSAGE_CREATED = "Cadastro realizado com sucesso";
    private static final String USER_MESSAGE_UPDATED = "Registro alterado com sucesso";
    private static final String USER_MESSAGE_DELETED = "Registro excluído com sucesso";
    private static final String USER_MESSAGE_NOT_FOUND = "Usuário não encontrado";
    private static final String LOGIN_MESSAGE_SUCCESS = "Login realizado com sucesso";
    private static final String LOGIN_MESSAGE_INVALID = "Email e/ou senha inválidos";
    private static final String USER_EMAIL_DUPLICATE = "Este email já está sendo usado";

    private final String userEmail = "spy_" + System.currentTimeMillis() + "@qa.com";
    private static final String PASSWORD = "secret123";

    private String userId;
    private String token;

    @BeforeAll
    static void setup() {
        baseURI = "https://serverest.dev";
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(1)
    @DisplayName("Задание № 2")
    void shouldGetAllUsers() {
        given()
                .when().get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("quantidade", greaterThan(0))
                .body("usuarios", hasSize(greaterThan(0)));
    }

    @Test
    @Order(2)
    @DisplayName("Задание № 3")
    void shouldFindUserByEmail() {
        String email = given()
                .when().get("/usuarios")
                .then().extract().path("usuarios[0].email");

        given()
                .queryParam("email", email)
                .when().get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("usuarios[0].email", equalTo(email));
    }

    @Test
    @Order(3)
    @DisplayName("Задание № 4")
    void shouldCreateNewUser() {
        userId = putUserRequest()
                .body("""
                        {
                          "nome": "Тайный Покупатель",
                          "email": "%s",
                          "password": "%s",
                          "administrador": "true"
                        }
                        """.formatted(userEmail, PASSWORD))
                .when().post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo(USER_MESSAGE_CREATED))
                .body("_id", notNullValue())
                .extract().path("_id");
    }

    @Test
    @Order(4)
    @DisplayName("Задание № 5")
    void shouldUpdateUser() {
        putUserRequest()
                .pathParam("id", userId)
                .body("""
                        {
                          "nome": "Обновлённый Покупатель",
                          "email": "%s",
                          "password": "%s",
                          "administrador": "false"
                        }
                        """.formatted(userEmail, PASSWORD))
                .when().put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo(USER_MESSAGE_UPDATED));
    }

    @Test
    @Order(5)
    @DisplayName("Задание № 6.1")
    void shouldLogin() {
        token = putUserRequest()
                .body("""
                        {
                          "email": "%s",
                          "password": "%s"
                        }
                        """.formatted(userEmail, PASSWORD))
                .when().post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo(LOGIN_MESSAGE_SUCCESS))
                .body("authorization", notNullValue())
                .extract().path("authorization");
    }

    @Test
    @Order(6)
    @DisplayName("Задание № 6.2")
    void shouldDeleteUser() {
        given()
                .header("Authorization", token)
                .pathParam("id", userId)
                .when().delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo(USER_MESSAGE_DELETED));

        given()
                .pathParam("id", userId)
                .when().get("/usuarios/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo(USER_MESSAGE_NOT_FOUND));
    }

    @Test
    @Order(7)
    @DisplayName("Задание № 7")
    void shouldGetAllProducts() {
        given()
                .when().get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("produtos.preco", everyItem(greaterThan(0)))
                .body("produtos.nome", everyItem(not(empty())))
                .body("produtos.nome", hasItem("Logitech MX Vertical"));
    }

    @Test
    @Order(8)
    @DisplayName("★ Создание пользователя через DTO (сериализация)")
    void shouldCreateUserFromDto() {
        String dtoEmail = "dto_" + System.currentTimeMillis() + "@qa.com";
        Usuario usuario = new Usuario("Тайный Покупатель", dtoEmail, PASSWORD, "true");

        putUserRequest()
                .body(usuario)
                .when().post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo(USER_MESSAGE_CREATED))
                .body("_id", notNullValue());
    }

    @Test
    @Order(9)
    @DisplayName("Негативный: повторная регистрация с тем же email")
    void shouldNotCreateDuplicateUser() {
        String dupEmail = "dup_" + System.currentTimeMillis() + "@qa.com";

        putUserRequest()
                .body(usuarioBody("Основной", dupEmail, "false"))
                .when().post("/usuarios")
                .then()
                .statusCode(201);

        putUserRequest()
                .body(usuarioBody("Дубликат", dupEmail, "false"))
                .when().post("/usuarios")
                .then()
                .statusCode(400)
                .body("message", equalTo(USER_EMAIL_DUPLICATE));
    }

    @Test
    @Order(10)
    @DisplayName("Негативный: логин с неверным паролем")
    void shouldNotLoginWithWrongPassword() {
        putUserRequest()
                .body("""
                        {
                          "email": "%s",
                          "password": "wrong-password"
                        }
                        """.formatted(userEmail))
                .when().post("/login")
                .then()
                .statusCode(401)
                .body("message", equalTo(LOGIN_MESSAGE_INVALID));
    }

    @Test
    @Order(11)
    @DisplayName("Фильтрация товаров по имени")
    void shouldFilterProductsByName() {
        given()
                .queryParam("nome", "Logitech")
                .when().get("/produtos")
                .then()
                .statusCode(200)
                .body("produtos.nome", everyItem(containsString("Logitech")));
    }

    private static RequestSpecification putUserRequest() {
        return given().contentType(ContentType.JSON);
    }

    private static String usuarioBody(String nome, String email, String administrador) {
        return """
                {
                  "nome": "%s",
                  "email": "%s",
                  "password": "%s",
                  "administrador": "%s"
                }
                """.formatted(nome, email, PASSWORD, administrador);
    }
}