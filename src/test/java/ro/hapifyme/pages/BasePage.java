package ro.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    protected void openPage(String url) {
        open(url);
    }

    protected void clickElement(SelenideElement element) {
        element.shouldBe(visible).click();
    }

    protected void enterText(
            SelenideElement element, String value) {

        element.shouldBe(visible).setValue(value);
    }

    protected void verifyVisible(SelenideElement element) {
        element.shouldBe(visible);
    }
}