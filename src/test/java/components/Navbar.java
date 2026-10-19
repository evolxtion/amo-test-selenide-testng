package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Navbar {

    private final SelenideElement logo = $("a.logo");

    private final SelenideElement aboutUsLink = $("a[href='/about']");
    private final SelenideElement publishingLink =
            $("a[href='/company/amo-publishing']");
    private final SelenideElement picturesLink =
            $("a[href='/company/amo-pictures']");
    private final SelenideElement appsLink =
            $("a[href='/company/amo-apps']");

    private final SelenideElement lifeInAmoLink = $("a[href='/life']");
    private final SelenideElement pressLink = $("a[href='/press']");

    private final ElementsCollection careerLinks = $$("a[href='/career']");
    private final ElementsCollection contactLinks = $$("a[href='/contact']");

    private final SelenideElement englishLink =
            $$("a[href='/']").findBy(text("ENG"));
    private final SelenideElement ukrainianLink = $("a[href='/ua']");

    private final SelenideElement mobileMenuButton =
            $("a.mobile-menu-toggler");


    public void clickAboutUs() {
        aboutUsLink.click();
    }

    public void clickPublishing() {
        publishingLink.click();
    }


    public void clickLifeInAmo() {
        lifeInAmoLink.click();
    }

    public void clickCareer() {
        careerLinks.filterBy(visible).first().click();
    }

    public void switchToUkrainian() {
        ukrainianLink.click();
    }
    
}