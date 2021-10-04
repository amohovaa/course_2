import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SignUpTest {
    private WebDriver driver;
    private SignUpPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mokhova_aa\\IdeaProjects\\Course_udemy\\drivers\\chromedriver_2.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get("https://www.spotify.com/kg-ru/signup");
    }

//    @Test
//    public void typeInvalidYear() {
//        page = new SignUpPage(driver);
//        page.setMonth("Октябрь").typeDay("4").typeYear("85").setShare(true);
//        Assert.assertTrue(page.isErrorVisible("Укажите действительный год."));
//    }

//    @Test
//    public void typeInvalidEmail() {
//        page = new SignUpPage(driver);
//        page.typeEmail("test@mail.test").typeConfirmEmail("wrong@mail.test").typeName("Testname");
//        Assert.assertTrue(page.isErrorVisible("Адреса электронной почты не совпадают."));
//    }

    @Test
    public void signUpShortPassword() {
        page = new SignUpPage(driver);
        page.typeEmail("test@mail.test").typeConfirmEmail("test@mail.test").typePassword(" ").typeName("Testname");
        Assert.assertTrue(page.isErrorVisible("Пароль слишком короткий."));
    }

    @Test
    public void typeInvalidValues() {
        page = new SignUpPage(driver);
        page.typeEmail("test").typeConfirmEmail("test@mail.test").typePassword("qwerty!123").typeName("Name");
        Assert.assertEquals(2, page.getErrors().size());
        Assert.assertEquals("Адреса электронной почты не совпадают.", page.getErrorByNumber(2));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
