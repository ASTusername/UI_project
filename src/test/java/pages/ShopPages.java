package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;

public class ShopPages {
    private final SelenideElement
            shopTitle = $("h1.title"),
            infoAboutTickets = $("[div='column span-9 text']");

    @Step("Проверка наличия заголовка Билеты")
    public ShopPages checkAboutShopTitleCorrect() {
        shopTitle.shouldHave(text(titleShop));
        return this;
    }

    @Step("Проверка информации о билетах")
    public ShopPages checkInfoAboutTickets() {
        infoAboutTickets.shouldHave(text(infoAboutTicketsShopPage));
        return this;
    }
}
