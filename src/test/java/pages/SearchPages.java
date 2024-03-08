package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPages {
    private final SelenideElement
            itemTitle = $("h1.title");

    @Step("Проверка количества результатов поиска")
    public SearchPages checkResults(String value) {
        itemTitle.shouldHave(text(value));
        return this;
    }
}
