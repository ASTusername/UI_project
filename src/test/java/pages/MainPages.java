package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPages {
    private final ElementsCollection topMenu = $("[class='column span-10 menu']").$$("ul");
    private final ElementsCollection leftMenu = $("[class='rm_menuleft]").$$("ul li");
    private final SelenideElement shop = $("[class='column span-1 buy']");
    private final SelenideElement about = $$(".parent").findBy(text("Русский музей"));
    private final SelenideElement
            inputSearch = $(".search-suggest");

    @Step("Открыть главную страницу")
    public MainPages openPage() {
        open(baseUrl);
        return this;
    }

    @Step("Перейти на страницу Билеты")
    public MainPages openPageShop() {
        shop.click();
        return this;
    }

    @Step("Поиск")
    public MainPages search(String value) {
        inputSearch.setValue(value).pressEnter();
        return this;
    }

    public int topMenu() {
        return topMenu.size();
    }

    public MainPages openPageAbout() {
        about.click();
        return this;
    }
}