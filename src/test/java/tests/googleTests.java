package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.ru/");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("selenium", Keys.ENTER);
        assertEquals(9,driver.findElements(By.cssSelector("#search .g")).size());
        driver.quit();


    }
}
