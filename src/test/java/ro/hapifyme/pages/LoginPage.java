package ro.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage extends BasePage {

    private static final String BASE_URL =
            "https://apps.qualiadept.eu/hapifyme/index.php";

    // Login form is the first form on the login/register page.
    private final SelenideElement loginForm =
            $$("form").first();

    private final SelenideElement emailField =
            loginForm.$("input[type='email']");

    private final SelenideElement passwordField =
            loginForm.$("input[type='password']");

    private final SelenideElement loginButton =
            loginForm.$("input[type='submit'], button[type='submit']");

    public void openLoginPage() {
        openPage(BASE_URL);
        loginForm.shouldBe(visible);
    }

    public void login(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void verifySuccessfulLogin() {
        $("body").shouldBe(visible);

        if (url().contains("login_register.php")) {
            throw new AssertionError(
                    "Login failed: user is still on login page"
            );
        }
    }

    public void verifyLoginRejected() {
        // Invalid credentials should leave the login form visible.
        loginForm.shouldBe(visible);
    }
}