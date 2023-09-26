package com.crackelets.bigfun.platform.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    @Given("the TheBigFun-API backend is up and running")
    public void the_thebigfun_api_backend_is_up_and_running() {
        // implementation for checking if the backend is up and running
    }

    @Given("the frontend thebigfun-frontend is running")
    public void the_frontend_thebigfun_frontend_is_running() {
        // implementation for checking if the frontend is running
    }

    @Given("the visitor enters his username {string} and password {string}")
    public void the_visitor_enters_his_username_and_password(String username, String password) {
        // implementation for entering the username and password
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        // implementation for clicking the login button
    }

    @Then("the visitor has entered their profile in the application")
    public void the_visitor_has_entered_their_profile_in_the_application() {
        // implementation for checking if the user has entered their profile
    }

    @Then("a valid user session is established")
    public void a_valid_user_session_is_established() {
        // implementation for checking if a valid user session is established
    }

    @Then("an error message is displayed on the frontend")
    public void an_error_message_is_displayed_on_the_frontend() {
        // implementation for checking if an error message is displayed on the frontend
    }

    @Then("the user session is not established")
    public void the_user_session_is_not_established() {
        // implementation for checking if the user session is not established
    }
}