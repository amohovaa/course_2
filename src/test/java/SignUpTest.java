import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignUpPage;
import steps.SignUpSteps;

import java.util.concurrent.TimeUnit;
@RunWith(SerenityRunner.class)
public class SignUpTest {
    @Steps
    SignUpSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void typeInvalidValues() {
        steps.open_signup_page();
        steps.type_email("test@mail.test");
        steps.type_confirmation_email("wrong@mail.test");
        steps.type_name("Testname");
        steps.type_password("qwerty!123");
        steps.should_see_error("Адреса электронной почты не совпадают.");
    }

    @Test
    public void signUpShortPassword() {
        steps.open_signup_page();
        steps.type_email("test@mail.test");
        steps.type_confirmation_email("wrong@mail.test");
        steps.type_name("Testname");
        steps.type_password(" ");
        steps.should_see_error("Пароль слишком короткий.");
    }
//    private WebDriver driver;
//    private SignUpPage page;

//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mokhova_aa\\IdeaProjects\\Course_udemy\\drivers\\chromedriver_2.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//        driver.get("https://www.spotify.com/kg-ru/signup");
//    }

    // НЕ РАБОТАЮТ
//    @Test
//    public void typeInvalidYear() {
//        page = new pages.SignUpPage(driver);
//        page.setMonth("Октябрь").typeDay("4").typeYear("85").setShare(true);
//        Assert.assertTrue(page.isErrorVisible("Укажите действительный год."));
//    }

//    @Test
//    public void typeInvalidEmail() {
//        page = new pages.SignUpPage(driver);
//        page.typeEmail("test@mail.test").typeConfirmEmail("wrong@mail.test").typeName("Testname");
//        Assert.assertTrue(page.isErrorVisible("Адреса электронной почты не совпадают."));
//    }

    // ДЛЯ Selenium + JUnit
//    @Test
//    public void signUpShortPassword() {
//        page = new SignUpPage(driver);
//        page.typeEmail("test@mail.test").typeConfirmEmail("test@mail.test").typePassword(" ").typeName("Testname");
//        Assert.assertTrue(page.isErrorVisible("Пароль слишком короткий."));
//    }
//
//    @Test
//    public void typeInvalidValues() {
//        page = new SignUpPage(driver);
//        page.typeEmail("test").typeConfirmEmail("test@mail.test").typePassword("qwerty!123").typeName("Name");
//        Assert.assertEquals(2, page.getErrors().size());
//        Assert.assertEquals("Адреса электронной почты не совпадают.", page.getErrorByNumber(2));
//    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
