package alfa.homework19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Страница логина (Form Authentication).
 */
public class LoginPage {

    private final SelenideElement loginPageTitle = $("h2");
    private final SelenideElement elementalSeleniumLink = $("a[href*='elementalselenium']");
    private final SelenideElement flashingMessage = $("#flash");
    private final SelenideElement username = $("#username");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");

    private final String INVALID_CREDENTIALS_FLASH_MESSAGE = "Your username is invalid!";

    public void assertTitle(String title) {
        loginPageTitle.shouldHave(text(title));
    }

    public void assertElementalSeleniumLink() {
        elementalSeleniumLink.shouldBe(visible);
    }

    public SecureAreaPage login(String user, String pass) {
        username.setValue(user);
        password.setValue(pass);
        loginButton.click();
        return page(SecureAreaPage.class);
    }

    public void assertInvalidCredentialsMessage() {
        flashingMessage.shouldHave(text(INVALID_CREDENTIALS_FLASH_MESSAGE));
    }
}