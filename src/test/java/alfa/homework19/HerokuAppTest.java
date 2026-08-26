package alfa.homework19;

import alfa.homework19.pages.HomePage;
import alfa.homework19.pages.LoginPage;
import alfa.homework19.pages.SecureAreaPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class HerokuAppTest {

    private static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        open(BASE_URL, HomePage.class);
    }

    @Test
    public void successfulLogin() {
        HomePage home = new HomePage();

        LoginPage loginPage = home.openFormAuthentication();
        loginPage.assertTitle();

        SecureAreaPage secureArea = loginPage.login("tomsmith", "SuperSecretPassword!");
        secureArea.assertSuccessMessage();
        secureArea.assertLogoutButton();

        LoginPage backToLogin = secureArea.logout();
        backToLogin.assertTitle();
    }

    @Test
    public void invalidLogin() {
        HomePage home = new HomePage();

        LoginPage loginPage = home.openFormAuthentication();
        loginPage.assertTitle();
        loginPage.assertElementalSeleniumLink();

        loginPage.login("admin", "1234");
        loginPage.assertInvalidCredentialsMessage();
    }
}