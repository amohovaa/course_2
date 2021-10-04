import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailField = By.cssSelector("input#email");
    private By confirmEmailField = By.cssSelector("input#confirm");
    private By passwordField = By.cssSelector("input#password");
    private By nameField = By.cssSelector("input#displayname");
    private By dayField = By.cssSelector("input#day");
    private By monthDropDown = By.xpath("select[@id = 'month']");
    private String monthDropDownOption = "//select[@id = 'month']/option[text() = '%s']";
    private By yearField = By.cssSelector("input#year");
    private String sexRadioButton = "//span[text() = '%s']/../..";
    private By shareCheckbox = By.xpath("//span[text() = 'Я разрешаю сообщить мои регистрационные данные партнерам Spotify в целях рекламы.']");
    By registerButton = By.xpath("//button[@type = 'submit']");
    private By errorLabel = xpath("//div[@aria-label = 'Значок ошибки']");
    private String errorByText = "//div[@aria-label = 'Значок ошибки' and text() = '%s']";

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        driver.findElement(confirmEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage typeDay(String day) {
        driver.findElement(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month) {
        driver.findElement(monthDropDown).click();
        driver.findElement(xpath(format(monthDropDownOption, month))).click();
//        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(xpath(format(monthDropDownOption, month)))).click();
        return this;
    }

    public SignUpPage typeYear(String year) {
        driver.findElement(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        driver.findElement(xpath(format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        WebElement chekbox = driver.findElement(shareCheckbox);
        if(!chekbox.isSelected() == value) {
            chekbox.click();
        }
        return this;
    }

    public void clickSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(registerButton)).click();
    }

    public List<WebElement> getErrors() {
        return driver.findElements(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return driver.findElements(xpath(format(errorByText, message))).size() > 0
                && driver.findElements(xpath(format(errorByText, message))).get(0).isDisplayed();
    }

}
