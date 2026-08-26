package alfa.homework19.steps;

import alfa.homework19.pages.HomePage;
import alfa.homework19.pages.LoginPage;
import alfa.homework19.pages.SecureAreaPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {

    private static final String BASE_URL = "https://the-internet.herokuapp.com/";

    private HomePage homePage;
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @Дано("открыта главная страница the-internet")
    public void openHomePage() {
        homePage = open(BASE_URL, HomePage.class);
    }

    @Когда("открыта страница Form Authentication")
    public void openFormAuthentication() {
        loginPage = homePage.openFormAuthentication();
    }

    @Тогда("заголовок страницы содержит {string}")
    public void assertTitle(String title) {
        loginPage.assertTitle(title);
    }

    @И("внизу страницы есть ссылка Elemental Selenium")
    public void assertElementalSeleniumLink() {
        loginPage.assertElementalSeleniumLink();
    }

    @Когда("введен логин {string} и пароль {string}")
    public void login(String user, String pass) {
        secureAreaPage = loginPage.login(user, pass);
    }

    @Тогда("отображается сообщение {string}")
    public void assertMessage(String message) {
        if (message.contains("invalid")) {
            loginPage.assertInvalidCredentialsMessage();
        } else {
            secureAreaPage.assertSuccessMessage();
        }
    }

    @И("на экране присутствует кнопка Logout")
    public void assertLogoutButton() {
        secureAreaPage.assertLogoutButton();
    }

    @Когда("нажата кнопка Logout")
    public void logout() {
        loginPage = secureAreaPage.logout();
    }
}