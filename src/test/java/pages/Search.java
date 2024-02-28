package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Search {
    private final SelenideElement
            searchTitle = $(".title_general");
    private final SelenideElement
            inputSearch = $(".popup_content");

    private final SelenideElement
            itemTitle = $("h1.title");
    private final ElementsCollection
            countResult = $$(".item-catalogue-card__container");

    @Step("Проверка наличия поискового запроса")
    public Search checkSearchTitle(String searchQuery) {
        String searchValue = "Поиск по запросу: \"" + searchQuery + "\"";
        searchTitle.shouldHave(text(searchValue));
        return this;
    }

    @Step("Проверка количества результатов поиска")
    public Search checkCountResults() {
        countResult.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверка количества результатов поиска")
    public Search checkResults(String value) {
        itemTitle.shouldHave(text(value));
        return this;
    }
}
