package tests;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.data.Cities;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestMTS extends BaseTest {


    @ValueSource(strings = {
            "Перейти в билайн",
            "Мобильная связь",
            "Безопасность"
    })
    @ParameterizedTest(name = "Открытие каталога {0}")
    void openCatalog(String nameCatalog) {
        $(".AdThl.cNwcj.gqblx.sRkzH.prz9u").click();
        $("[aria-label='Каталог, провалиться в пункт Space, ArrowRight, выйти из пункта ArrowLeft, выход из каталога Esc или Shift + Tab']").
                $(byText(nameCatalog)).click();
        $("div.EyvsU").shouldHave(text(nameCatalog));
    }


    @CsvSource(value = {
            "15 , 400 , 780",
            "20 , 700 , 850"
    })
    @ParameterizedTest(name = "Расчет тарифа для {0} Гб и {1} минут")
    void tariffCalculationVer1(String gb, String minute, String sum) {
        $(".AdThl.cNwcj.gqblx.sRkzH.prz9u").click();
        $("[aria-label='Каталог, провалиться в пункт Space, ArrowRight, выйти из пункта ArrowLeft, выход из каталога Esc или Shift + Tab']").
                $(byText("Мобильная связь")).click();
        $(byText("Тарифы для смартфонов")).click();
        $$("[data-t-id=components-Tariff]").first().click();
        $$("[data-t-id=tempComponents-PresetPicker]").first().$(byText(gb)).click();
        $$("[data-t-id=tempComponents-PresetPicker]").get(1).$(byText(minute)).click();
        $("[data-t-id=components-TotalSum]").shouldHave(text(sum));
    }

    @CsvFileSource(resources = "/test_data/tariff.csv")
    @ParameterizedTest(name = "Расчет тарифа для {0} Гб и {1} минут")
    void tariffCalculationVer2(String gb, String minute, String sum) {
        $(".AdThl.cNwcj.gqblx.sRkzH.prz9u").click();
        $("[aria-label='Каталог, провалиться в пункт Space, ArrowRight, выйти из пункта ArrowLeft, выход из каталога Esc или Shift + Tab']").
                $(byText("Мобильная связь")).click();
        $(byText("Тарифы для смартфонов")).click();
        $$("[data-t-id=components-Tariff]").first().click();
        $$("[data-t-id=tempComponents-PresetPicker]").first().$(byText(gb)).click();
        $$("[data-t-id=tempComponents-PresetPicker]").get(1).$(byText(minute)).click();
        $("[data-t-id=components-TotalSum]").shouldHave(text(sum));
    }


    @EnumSource(Cities.class)
    @ParameterizedTest(name = "Смена региона {0}")
    void changeRegion(Cities city) {
        $("#toggleButton-regions-desktop").click();
        $(".content-inner").$(byText(city.name())).click();
        $("#toggleButton-regions-desktop").shouldHave(text(city.name()));
    }
}
