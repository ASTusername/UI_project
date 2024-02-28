package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.titleEmptyCartPage;

public class Catalog {
    private final SelenideElement
            titleSubCatalog = $("[class='element-title'].bx-sbb-empty-cart-text");

    @Step("Проверка названия в подкаталоге")
    public Catalog checkTitleCatalog(String value) {
        titleSubCatalog.shouldHave(text(value));
        return this;
    }
}
