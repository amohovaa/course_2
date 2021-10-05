package testpackages.steps.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import testpackages.steps.serenity.SignUpSteps;

public class SignUpPageSteps {
    @Steps
    SignUpSteps steps;

    @Given("I open signup page")
    public void openPage() {
        steps.open_signup_page();
    }

    @When("I type email \"$mail\"")
    public void type_Email(String mail) {
        steps.type_email(mail);
    }

    @When("I type confirmation email \"$mail\"")
    public void type_Conformation_Email(String mail) {
        steps.type_confirmation_email(mail);
    }

    @When("I type name \"$name\"")
    public void type_Name(String name) {
        steps.type_name(name);
    }

    @When("I type password \"$password\"")
    public void type_Password(String password) {
        steps.type_password(password);
    }

    @Then("I see error \"$message\"")
    public void see_Error(String message) {
        steps.should_see_error(message);
    }
}
