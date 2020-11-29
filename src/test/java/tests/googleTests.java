package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DetailsPage DetailsPage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        DetailsPage = new DetailsPage(driver);

    }

    @BeforeEach
    public void setup() {
        driver.get("https://www.google.ru/");
    }
    @Test
    @DisplayName("Поиск числа результатов")
    public void test1() {
        searchPage.search("selenium");
        assertEquals(10,searchPage.results.size());
    }

    @Test
    @DisplayName("Проверка деталей ресурса")
    public void test2() {
        searchPage.search("selenium");
        assertAll(
                () -> assertEquals("Selenium", DetailsPage.getTitle()),
                () -> assertEquals("3.141.59 (14 ноября 2018 года)", DetailsPage.getVersion()),
                () -> assertEquals("Apache License 2.0", DetailsPage.getlicense())
        );

    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
