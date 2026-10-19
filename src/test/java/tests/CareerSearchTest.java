package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareerPage;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CareerSearchTest {

    private CareerPage careerPage;

    @BeforeClass
    public void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
    }

    @BeforeMethod
    public void openCareerPage() {
        careerPage = new CareerPage();
        careerPage.openPage();
    }

    @Test
    public void shouldFindGeneralQaVacancy() {
        careerPage.searchVacancy("General QA");

        careerPage.searchResults()
                .findBy(text("General QA Engineer, Amo Publishing"))
                .shouldBe(visible);
    }

    @Test
    public void shouldReturnNoResultsForNonExistingVacancy() {
        careerPage.searchVacancy("NonExistingVacancy12345");

        careerPage.searchResults()
                .shouldBe(empty);
    }

    @Test
    public void shouldReturnNoResultsForRandomInput() {
        careerPage.searchVacancy("qwertyZXCV987654");

        careerPage.searchResults()
                .shouldBe(empty);
    }
}
