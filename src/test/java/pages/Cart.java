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

public class Cart {
    private final SelenideElement
            basketEmpty = $(".bx-sbb-empty-cart-text"),
            basketNotEmpty = $(".header_bascet"),
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

    @Step("Проверка надписи в пустой корзине")
    public Cart checkEmptyCart() {
        basketEmpty.shouldHave(text(titleEmptyCartPage));
        return this;
    }

    @Step("Проверка надписи в непустой корзине")
    public Cart checkCart() {
        basketNotEmpty.shouldHave(text(titleCartPage));
        return this;
    }

    @Step("Выход из пустой корзины")
    public Cart backFromCart() {
        basketBack.click();
        return this;
    }
}
