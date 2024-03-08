package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPages {
    private final SelenideElement
            searchTitle = $(".title_general");
    private final SelenideElement
            inputSearch = $(".popup_content");

    private final SelenideElement
            itemTitle = $("h1.title");
    private final ElementsCollection
            countResult = $$(".item-catalogue-card__container");

    @Step("Проверка количества результатов поиска")
    public SearchPages checkResults(String value) {
        itemTitle.shouldHave(text(value));
        return this;
    }
}
