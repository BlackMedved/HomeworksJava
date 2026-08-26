package alfa.homework19;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class HerokuAppTest {

    @Test
    void successfulLogin() {
        open("https://the-internet.herokuapp.com/");
        $("a[href='/login']").click();
        $("h2").shouldHave(text("Login Page"));
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button[type='submit']").click();
        $("#flash").shouldHave(text("You logged into a secure area!"));
        $("a[href='/logout']").shouldBe(visible);
        $("a[href='/logout']").click();
        $("h2").shouldHave(text("Login Page"));
    }

    @Test
    void invalidLogin() {
        open("https://the-internet.herokuapp.com/");
        $("a[href='/login']").click();
        $("h2").shouldHave(text("Login Page"));
        $("a[href*='elementalselenium']").shouldBe(visible);
        $("#username").setValue("admin");
        $("#password").setValue("1234");
        $("button[type='submit']").click();
        $("#flash").shouldHave(text("Your username is invalid!"));
    }
}