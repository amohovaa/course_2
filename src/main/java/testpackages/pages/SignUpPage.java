package testpackages.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://www.spotify.com/kg-ru/signup/")
public class SignUpPage extends PageObject {

//    WebDriver driver;
//    public SignUpPage(WebDriver driver){
//        this.driver = driver;
//    }

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
        find(emailField).sendKeys(email);
//        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email) {
        find(confirmEmailField).sendKeys(email);
//        driver.findElement(confirmEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        find(passwordField).sendKeys(password);
//        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        find(nameField).sendKeys(name);
//        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage typeDay(String day) {
        find(dayField).sendKeys(day);
//        driver.findElement(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month) {
        find(monthDropDown).click();
        find(xpath(format(monthDropDownOption, month))).waitUntilVisible().click();
//        driver.findElement(xpath(format(monthDropDownOption, month))).click();
//        new WebDriverWait(driver, 5).until(visibilityOfElementLocated(xpath(format(monthDropDownOption, month)))).click();
        return this;
    }

//    public SignUpPage typeYear(String year) {
//        find(yearField).sendKeys(year);
////        driver.findElement(yearField).sendKeys(year);
//        return this;
//    }
//
//    public SignUpPage setSex(String value) {
//        find(xpath(format(sexRadioButton, value))).click();
////        driver.findElement(xpath(format(sexRadioButton, value))).click();
//        return this;
//    }

//    public SignUpPage setShare(boolean value) {
//        WebElement chekbox = driver.findElement(shareCheckbox);
//        if(!chekbox.isSelected() == value) {
//            chekbox.click();
//        }
//        return this;
//    }

//    public void clickSignUpButton() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(visibilityOfElementLocated(registerButton)).click();
//    }

    public List<WebElementFacade> getErrors() {
        return findAll(errorLabel);
//        return driver.findElements(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return findAll(xpath(format(errorByText, message))).size() > 0
                && findAll(xpath(format(errorByText, message))).get(0).isDisplayed();
//        return driver.findElements(xpath(format(errorByText, message))).size() > 0
//                && driver.findElements(xpath(format(errorByText, message))).get(0).isDisplayed();
    }

}
