package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenCatalogEldorado extends BaseTest {

    @Test
    void openCatalg(){
        open("https://spb.mts.ru/personal");
        $(".tooltip-location__wrapper").$(".mm-web-button__inner").click();
        $(".middle-menu__catalog-text").click();

        sleep(9000);
    }
}
