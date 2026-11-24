package ro.hapifyme.stepsdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import ro.hapifyme.pages.ProfilePage;

public class ProfileSteps {

    private final ProfilePage profilePage = new ProfilePage();

    @When("I search for user {string}")
    public void searchUser(String username) {
        profilePage.searchUser(username);
    }

    @When("I open the profile")
    public void openProfile() {
        profilePage.openUserProfile();
    }

    @Then("I should see the profile of {string}")
    public void verifyProfile(String username) {
        profilePage.verifyProfile(username);
    }
}