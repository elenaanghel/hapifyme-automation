package ro.hapifyme.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import ro.hapifyme.pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("I am on the HapifyMe login page")
    public void openLoginPage() {
        loginPage.openLoginPage();
    }

    @When("I login using valid credentials")
    public void loginWithValidCredentials() {

        String email = System.getenv("HAPIFY_USER");
        String password = System.getenv("HAPIFY_PASSWORD");

        if (email == null || email.isBlank()
                || password == null || password.isBlank()) {

            throw new IllegalStateException(
                    "Configure HAPIFY_USER and HAPIFY_PASSWORD"
            );
        }

        loginPage.login(email, password);
    }

    @When("I login with username {string} and password {string}")
    public void loginWithInvalidCredentials(
            String username, String password) {

        loginPage.login(username, password);
    }

    @Then("I should access the application feed")
    public void verifySuccessfulLogin() {
        loginPage.verifySuccessfulLogin();
    }

    @Then("I should see a login error message")
    public void verifyLoginError() {
        loginPage.verifyLoginRejected();
    }

    @Given("I am logged in to HapifyMe")
    public void loginBeforeTest() {
        loginPage.openLoginPage();
        loginWithValidCredentials();
        loginPage.verifySuccessfulLogin();
    }
}