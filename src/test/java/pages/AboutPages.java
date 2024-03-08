package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;

public class AboutPages {
    private final SelenideElement titlePalace = $("[class='title yellow']");
    private final ElementsCollection leftMenu = $("[class='column span-3 rm_left']").$$("ul li");

    public AboutPages leftMenuFindElement(String value) {
        leftMenu.findBy(text(value)).click();
        return this;
    }

    @Step("Проверка заголовка")
    public AboutPages checkTitleCPalaceorrect() {
        titlePalace.shouldHave(text(titlePalaceAboutPage));
        return this;
    }

}
