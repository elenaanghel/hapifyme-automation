package ro.hapifyme.hooks;

import com.codeborne.selenide.Configuration;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        Configuration.headless = Boolean.parseBoolean(
                System.getProperty("headless", "false")
        );
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}