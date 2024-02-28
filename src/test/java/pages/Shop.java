package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.titleShop;

public class Shop {
    private final SelenideElement
            shopTitle = $("h1.title");

    @Step("Проверка наличия заголовка Билеты")
    public Shop checkAboutShopTitleCorrect() {
        shopTitle.shouldHave(text(titleShop));
        return this;
    }
}
