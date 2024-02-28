package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.titleShop;
import static data.TestData.topMenuShop;

public class MainPage {
    private final SelenideElement shop = $$(".parent").findBy(text("Посетителям"));
    private final SelenideElement btnBasket = $("a.btn");
    private final SelenideElement searchInput = $("#title-search-input");
    /*private final SelenideElement catalogMenu = $(".btn_catalog js-catalogue-toggle btn_ctg_other");
    private final SelenideElement catalogSubMenu = $("[data-id='797124']");*/
    private final ElementsCollection
            btnBuy = $$(".item-catalogue-card__title");
    private final SelenideElement
            btnSearch = $("[aria-label='Поиск']");
    private final SelenideElement
            inputSearch = $(".search-suggest");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    @Step("Перейти на страницу Билеты")
    public MainPage openPageShop() {
        shop.click();
        return this;
    }

    @Step("Перейти в Корзину")
    public MainPage openBasket() {
        btnBasket.click();
        return this;
    }

    @Step("Поиск")
    public MainPage openSearch() {
        btnSearch.click();
        return this;
    }

    @Step("Поиск")
    public MainPage search(String value) {
        inputSearch.setValue(value).pressEnter();
        return this;
    }

    @Step("Добавление в корзину")
    public MainPage addItem() {
        btnBuy.first().click();
        Selenide.closeWindow();
        return this;
    }

   /* @Step("Открыть меню каталога")
    public MainPage openCatalogMenu() {
        catalogMenu.click();
        return this;
    }

    @Step("Открыть саб-меню каталога")
    public MainPage openSubCatalogMenu() {
        catalogSubMenu.click();
        return this;
    }*/
}
