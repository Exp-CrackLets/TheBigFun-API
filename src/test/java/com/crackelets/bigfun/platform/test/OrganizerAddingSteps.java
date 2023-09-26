package com.crackelets.bigfun.platform.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class OrganizerAddingSteps {

    @Given("The Endpoint {string} is available")
    public void the_endpoint_is_available(String endpoint) {
        // implementation for checking if the endpoint is available
    }

    @When("A Post Request is sent with values {string}, {string}, {string}")
    public void a_post_request_is_sent_with_values(String name, String userName, String email) {
        // implementation for sending a post request with the given values
    }

    @Then("A Response is received with Status {int}")
    public void a_response_is_received_with_status(int status) {
        // implementation for checking if the response status matches the expected status
    }

    @Then("An Organizer Resource is included in Response Body, with values {string}, {string}, {string}")
    public void an_organizer_resource_is_included_in_response_body_with_values(String name, String userName, String email) {
        // implementation for checking if the response body contains an organizer resource with the given values
    }

    @Given("An Organizer Resource with values {string}, {string}, {string} is already stored")
    public void an_organizer_resource_with_values_is_already_stored(String name, String userName, String email) {
        // implementation for storing an organizer resource with the given values
    }

    @Then("A Message is included in Response Body, with value {string}")
    public void a_message_is_included_in_response_body_with_value(String message) {
        // implementation for checking if the response body contains the expected message
    }
}