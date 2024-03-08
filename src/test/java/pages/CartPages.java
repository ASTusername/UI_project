package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.TestData.*;

public class CartPages {
    private final SelenideElement
            tickets = $(".bt_arrow red"),
            title = $(".title"),
            infoAboutTickets = $(".slide-title"),
            basketBack = $(".back_prod");
    //basketBack = $(By.linkText("Нажмите здесь"));
    private final ElementsCollection
            btnBuy = $$(".item-catalogue-card__title");

    /*@Step("Добавление в корзину")
    public Cart addItem() {
        btnBuy.first().click();
        Selenide.closeWindow();
        return this;
    }*/

    @Step("Проверка надписи")
    public CartPages checkTitle() {
        title.shouldHave(text(titleCartPage));
        return this;
    }

/*    @Step("Проверка надписи в непустой корзине")
    public Cart checkCart() {
        basketNotEmpty.shouldHave(text(titleCartPage));
        return this;
    }

    @Step("Выход из пустой корзины")
    public Cart backFromCart() {
        basketBack.click();
        return this;
    }*/
}
