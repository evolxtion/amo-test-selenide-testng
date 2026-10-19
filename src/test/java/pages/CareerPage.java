package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class CareerPage {

    private final SelenideElement searchInput =
            $$("input[type='text']").filterBy(visible).first();

    private final ElementsCollection searchResults =
            $$(".results a");

    public CareerPage openPage() {
        open("https://amo.tech/career");
        return this;
    }

    public CareerPage searchVacancy(String vacancyName) {
        executeJavaScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'auto'});",
                searchInput
        );

        searchInput.shouldBe(visible)
                .setValue(vacancyName);

        return this;
    }

    public ElementsCollection searchResults() {
        return searchResults;
    }
}
