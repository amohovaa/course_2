package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.SignUpPage;

public class SignUpSteps {
    SignUpPage page;

    @Step
    public void open_signup_page() {
        page.open();
    }

    @Step("User types email [0]")
    public void type_email(String mail) {
        page.typeEmail(mail);
    }

    @Step
    public void type_confirmation_email(String mail) {
        page.typeConfirmEmail(mail);
    }

    @Step
    public void type_password(String password) {
        page.typePassword(password);
    }

    @Step
    public void type_name(String name) {
        page.typeName(name);
    }

    @Step
    public void should_see_error(String message) {
        Assertions.assertThat(page.isErrorVisible(message)).as("User should see message, but he doesn't").isTrue();
    }
    @Step
    public void should_not_see_error(String message) {
        Assertions.assertThat(page.isErrorVisible(message)).as("User should not see message, but he does").isFalse();
    }


}
