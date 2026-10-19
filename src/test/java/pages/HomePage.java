package pages;

import com.codeborne.selenide.SelenideElement;
import components.Navbar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private static final String URL = "https://amo.tech/";
    private final Navbar navbar = new Navbar();
    private final SelenideElement pageTitle = $(".title");

    public HomePage openPage() {
        open(URL);
        return this;
    }

    public Navbar navbar() {
        return navbar;
    }

    public SelenideElement pageTitle() {
        return pageTitle;
    }
}