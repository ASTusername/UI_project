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

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.title;
import static data.TestData.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Alexander Trifonov")
@Tag("ui")
@DisplayName("Проверка главной страницы")
public class Tests extends TestBase {
    MainPage mainPage = new MainPage();
    AboutCompany aboutCompany = new AboutCompany();
    Cart cart = new Cart();
    Search search = new Search();
    Catalog catalog = new Catalog();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка заголовка главной страницы")
    void testMainPageTitle() {
        mainPage.openPage();
        step("Проверяем заголовок главной страницы", () ->
                assertThat(title()).isEqualTo(titleMainPage));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка корзины")
    void testCart() {
        mainPage.openPage().addItem();
        mainPage.openBasket();
    //    cart.checkCart();
    //    sleep(30000);
        cart.checkCart();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка страницы О компании")
    void testOpenPageAboutCompany() {
        mainPage.openPage().openPageAboutCompany();
        aboutCompany.checkAboutCompanyTitleCorrect();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка поиска")
    void testSearch() {
        step("Открываем страницу и вводим поисковое слово", () ->
                mainPage.openPage().search(searchQuery));
        step("Проверка поискового слова на странице поиска и количество найденных товаров", () -> {
                search.checkSearchTitle(searchQuery);
                search.checkCountResults();
        });
    }

    @CsvFileSource(resources = "/search.csv", delimiter = '|')
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка поиска товаров")
    @ParameterizedTest(name = "При поиске товара из категории {0} в списке есть товар {1}")
    void testSearchParameterized(String searchQuery, String expectedName) {
        step("Открываем страницу и вводим поисковое слово", () ->
                mainPage.openPage().search(searchQuery));
        step("Проверка поискового слова на странице поиска и количество найденных товаров", () -> {
            search.checkResults(expectedName);
        });
    }

    /*@Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка каталога")
    void testOpenSubCatalog() {
        step("Открываем подкаталог Мебель для ванной", () ->
                mainPage.openPage()
                        .openCatalogMenu().openSubCatalogMenu());
        step("Проверка заголовка в подкаталоге", () -> {
            catalog.checkTitleCatalog(titleSubCatalog);
        });
    }*/
}
