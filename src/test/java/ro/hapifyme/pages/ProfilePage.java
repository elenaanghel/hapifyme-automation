package ro.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {

    // Replace selectors with the actual application selectors.
    private final SelenideElement searchField =
            $("#search_text_input");

    private final SelenideElement searchButton =
            $("img[alt='Search']");

    private final SelenideElement searchResults =
            $("a[href='live_tester']");

    private final SelenideElement profileName =
            $("h3.profile_hero_name");

    public void searchUser(String username) {
        enterText(searchField, username);
        clickElement(searchButton);
    }

    public void openUserProfile() {
        searchResults.click();
    }

    public void verifyProfile(String username) {
        profileName.shouldHave(text(username));
    }
}