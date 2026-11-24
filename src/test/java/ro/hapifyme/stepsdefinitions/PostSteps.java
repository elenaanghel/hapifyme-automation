package ro.hapifyme.stepsdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import ro.hapifyme.pages.FeedPage;

import java.util.Map;

public class PostSteps {

    private final FeedPage feedPage = new FeedPage();

    private String postMessage;

    @When("I create a post with the following message {string}")
    public void createPost(String message) {
        postMessage = message;

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException(
                    "Post message cannot be empty"
            );
        }

        feedPage.createPost(message);
    }

    @Then("the post should be visible on the feed")
    public void verifyPost() {
        feedPage.verifyPost(postMessage);
    }
}