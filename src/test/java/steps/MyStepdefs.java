package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    
    @Given("creating a user")
    public void creating_a_user() {
    }


    @When("updating the user")
    public void updating_the_user() {
    }


    @Then("the user is updated")
    public void the_user_is_updated() {
    }

    @When("^User enters \"(.*)\"(.*)\"$")
    public void updatingTheUserUserNamePassword(String userName,  String password) {
        System.out.println(userName);
        System.out.println(password);

    }

    @When("updating the user with invalid input {string} {string}")
    public void updating_user_with_invalid_input(String string, String string2) {
        System.out.println(string);
        System.out.println(string2);
    }


    @Then("the user not to be updated")
    public void the_user_not_to_be_updated() {
    }

    @When("^updating the user with invalid input \"(.*)\" and \"(.*)\"$")
    public void updatingTheUserWithInvalidInput(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }
}
