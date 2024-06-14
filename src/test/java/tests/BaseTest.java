package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open("https://moskva.beeline.ru/customers/products/");
        if ($(".FnP54").isEnabled()) {
            $(".tVHtn").$(".AdThl").click();
        }
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
