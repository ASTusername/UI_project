package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.titleAboutCompanyPage;

public class AboutCompany {
    private final SelenideElement
            aboutCompanyTitle = $(".title_general");

    @Step("Проверка наличия заголовка О компнаии")
    public AboutCompany checkAboutCompanyTitleCorrect() {
        aboutCompanyTitle.shouldHave(text(titleAboutCompanyPage));
        return this;
    }
}
