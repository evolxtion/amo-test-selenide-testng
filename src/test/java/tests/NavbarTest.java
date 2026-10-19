package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class NavbarTest {

    private HomePage homePage;

    @BeforeClass
    public void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage();
        homePage.openPage();
    }

    private void scrollToTopOf(SelenideElement element) {
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'start', behavior: 'auto'});",
                element
        );
    }

    @Test
    public void shouldNavigateToAboutUs() {
        homePage.navbar().clickAboutUs();

        webdriver().shouldHave(url("https://amo.tech/about"));

        String expectedText =
                "AMO is an international IT company with three independent teams united by culture and values.";

        SelenideElement title = $x(
                "//div[contains(@class,'title') and contains(., 'AMO is an international IT company')]"
        );

        scrollToTopOf(title);

        title.shouldBe(visible)
                .shouldHave(text(expectedText));
    }

    @Test
    public void shouldNavigateToPublishing() {
        homePage.navbar().clickPublishing();

        webdriver().shouldHave(
                url("https://amo.tech/company/amo-publishing")
        );

        String expectedText =
                "In 2017, we launched AMOMAMA Entertainment Media, which eventually became a publishing business. And now, AMOMAMA attracts more than 40M readers from the USA and Western Europe and is published in 4 languages.";

        SelenideElement title = $x(
                "//div[contains(@class,'title') and contains(., 'In 2017, we launched AMOMAMA Entertainment Media')]"
        );

        scrollToTopOf(title);

        title.shouldBe(visible)
                .shouldHave(text(expectedText));
    }

    @Test
    public void shouldNavigateToLifeInAmo() {
        homePage.navbar().clickLifeInAmo();

        webdriver().shouldHave(url("https://amo.tech/life"));

        SelenideElement heading = $x(
                "//div[contains(@class,'heading') and normalize-space(.)='LIFE IN AMO']"
        );

        scrollToTopOf(heading);

        heading.shouldBe(visible)
                .shouldHave(text("LIFE IN AMO"));
    }

    @Test
    public void shouldNavigateToCareer() {
        homePage.navbar().clickCareer();

        webdriver().shouldHave(url("https://amo.tech/career"));

        SelenideElement heading = $x(
                "//div[contains(@class,'heading') and normalize-space(.)='CAREER AT AMO']"
        );

        scrollToTopOf(heading);

        heading.shouldBe(visible)
                .shouldHave(text("CAREER AT AMO"));
    }

    @Test
    public void shouldSwitchLanguageToUkrainian() {
        homePage.navbar().switchToUkrainian();

        webdriver().shouldHave(url("https://amo.tech/ua"));

        String expectedText =
                "Ми робимо продукти, з яких народжуються історії";

        SelenideElement title = $x(
                "//div[contains(@class,'title') and contains(., 'Ми робимо')]"
        );

        scrollToTopOf(title);

        title.shouldBe(visible)
                .shouldHave(text(expectedText));
    }

}
