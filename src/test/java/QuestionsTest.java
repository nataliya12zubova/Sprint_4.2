import model.MainPageObj;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxOptions;


@RunWith(Parameterized.class)
public class QuestionsTest {
    public String questionText;
    public String answerText;
    public int elementId;

    public WebDriver webDriverType;

    public WebDriver driver;

    public QuestionsTest(
            WebDriver webDriverValue,
            String questionText,
            String answerText,
            int elementId) {
        this.webDriverType = webDriverValue;
        this.questionText = questionText;
        this.answerText = answerText;
        this.elementId = elementId;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        // создали драйвер для браузера Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        // перешли на страницу тестового приложения
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);

        // создали драйвер для браузера Firefox
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver firefoxDriver = new FirefoxDriver(ffOptions);

        return new Object[][] {
                {
                    "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    32,
                    chromeDriver
                },
                {
                    "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    33,
                    firefoxDriver
                },
        };
    }

    @Test
    public void checkQuestions() {
        // перешли на страницу тестового приложения
        driver = webDriverType;
        //driver = new FireFoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создали объект класса Главной страницы
        MainPageObj mainPageObj = new MainPageObj(driver);
        // кликнули на строку на Главной странице
        mainPageObj.clickQuestion(elementId);
        // подождали пока загрузится контент
        mainPageObj.waitForLoadAnswer(elementId);
        // проверли, что текст ответа соответсвует тексту вопроса
        mainPageObj.checkText(questionText, answerText, elementId);
    }
    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }
}
