package test;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.*;

import static com.codeborne.selenide.Selenide.title;
import static data.TestData.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Alexander Trifonov")
@Tag("ui")
@DisplayName("Проверка главной страницы")
public class Tests extends TestBase {
    MainPages mainPages = new MainPages();
    ShopPages shopPages = new ShopPages();
    SearchPages searchPages = new SearchPages();
    AboutPages aboutPages = new AboutPages();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка заголовка главной страницы")
    void testMainPageTitle() {
        mainPages.openPage();
        step("Проверяем заголовок главной страницы", () ->
                assertThat(title()).isEqualTo(titleMainPage));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка количества элементов главного меню")
    void testMainPageTopMenu() {
        mainPages.openPage();
        step("Проверяем количества элементов главного меню", () ->
                assertThat(mainPages.topMenu()).isEqualTo(12));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка страницы Билеты")
    void testOpenPageShop() {
        mainPages.openPage().openPageShop();
        shopPages.checkAboutShopTitleCorrect();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка информации о билетах")
    void testPageShop() {
        mainPages.openPage().openPageShop();
        shopPages.checkInfoAboutTickets();
    }

    @CsvFileSource(resources = "/search.csv", delimiter = '|')
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка поиска")
    @ParameterizedTest(name = "При поиске товара из категории {0} в списке есть товар {1}")
    void testSearchParameterized(String searchQuery, String expectedName) {
        step("Открываем страницу и вводим поисковое слово", () ->
                mainPages.openPage().search(searchQuery));
        step("Проверка поискового слова на странице поиска и количество найденных товаров", () -> {
            searchPages.checkResults(expectedName);
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка страницы из левого меню")
    void testOpenPageFromLeftMenu() {
        mainPages.openPage().openPageAbout();
        aboutPages.leftMenuFindElement(leftMenuMainPage).checkTitleCPalaceorrect();
    }
}
