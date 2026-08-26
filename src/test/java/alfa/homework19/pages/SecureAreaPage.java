package alfa.homework19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Страница защищённой зоны (после успешного логина).
 */
public class SecureAreaPage {

    private final SelenideElement flashingMessage = $("#flash");
    private final SelenideElement logoutButton = $("a[href='/logout']");

    private final String SUCCESSFUL_LOGIN_FLASH_MESSAGE = "You logged into a secure area!";
    
    public void assertSuccessMessage() {
        flashingMessage.shouldHave(text(SUCCESSFUL_LOGIN_FLASH_MESSAGE));
    }

    public void assertLogoutButton() {
        logoutButton.shouldBe(visible);
    }

    public LoginPage logout() {
        logoutButton.click();
        return page(LoginPage.class);
    }
}