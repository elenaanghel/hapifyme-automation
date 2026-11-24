package ro.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage {

    // Replace these selectors if the application DOM differs.
    private final SelenideElement postField =
            $("textarea[name='post_text']");

    private final SelenideElement publishButton =
            $("#post_button");

    private final SelenideElement feed =
            $("span.post_body_content");

    public void createPost(String message) {
        enterText(postField, message);
        clickElement(publishButton);
    }

    public void verifyPost(String message) {
        feed.shouldHave(text(message));
    }
}