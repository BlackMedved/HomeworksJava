package alfa.homework19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Главная страница the-internet.herokuapp.com.
 */
public class HomePage {

    private final SelenideElement formAuthenticationButton = $("a[href='/login']");

    public LoginPage openFormAuthentication() {
        formAuthenticationButton.click();
        return page(LoginPage.class);
    }
}