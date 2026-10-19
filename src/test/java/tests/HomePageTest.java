package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class HomePageTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }

    @Test
    public void shouldOpenHomePage() {
        HomePage homePage = new HomePage();

        homePage.openPage();

        homePage.pageTitle()
                .shouldBe(visible)
                .shouldHave(text("WE CREATE PRODUCTS THAT TELL STORIES"));
    }

    @Test
    public void shouldNavigateToLifeInAmo() {
        HomePage homePage = new HomePage();

        homePage.openPage();
        homePage.navbar().clickLifeInAmo();

        assertEquals(
                url(),
                "https://amo.tech/life"
        );
    }
}
