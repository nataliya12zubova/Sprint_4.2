package model;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestFixtures {
    public static WebDriver driver;

    @Before
    public void setUpFixture() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }
}
