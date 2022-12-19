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
    public int number;

    public String webDriverType;

    public WebDriver driver;

    public QuestionsTest(
            String webDriverValue,
            String questionText,
            String answerText,
            int number) {
        this.webDriverType = webDriverValue;
        this.questionText = questionText;
        this.answerText = answerText;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {
                        "Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        1,
                        "chrome"
                },
                {
                        "Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        1,
                        "firefoxDriver"
                },
                {
                        "Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        2,
                        "chrome"
                },
                {
                        "Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        2,
                        "firefoxDriver"
                },
                {
                        "Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        3,
                        "chrome"
                },
                {
                        "Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        3,
                        "firefoxDriver"
                },
                {
                        "Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        4,
                        "chrome"
                },
                {
                        "Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        4,
                        "firefoxDriver"
                },
                {
                        "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        5,
                        "chrome"
                },
                {
                        "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        5,
                        "firefoxDriver"
                },
                {
                        "Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        6,
                        "chrome"
                },
                {
                        "Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        6,
                        "firefoxDriver"
                },
                {
                        "Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        7,
                        "chrome"
                },
                {
                        "Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        7,
                        "firefoxDriver"
                },
                {
                        "Я жизу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                        8,
                        "chrome"
                },
                {
                        "Я жизу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                        8,
                        "firefoxDriver"
                },
        };
    }

    @Test
    public void checkQuestions() {
        // создали драйвер для браузера Chrome
        if (webDriverType == "chrome") {
            ChromeOptions chromeOptions = new ChromeOptions();
            // перешли на страницу тестового приложения
            driver = new ChromeDriver(chromeOptions);
        }
        // создали драйвер для браузера Firefox
        else {
            FirefoxOptions ffOptions = new FirefoxOptions();
            // перешли на страницу тестового приложения
            driver = new FirefoxDriver(ffOptions);
        }

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создали объект класса Главной страницы
        MainPageObj mainPageObj = new MainPageObj(driver);
        mainPageObj.indicatePair(number);
        // кликнули на строку на Главной странице
        mainPageObj.clickQuestion();
        // подождали пока загрузится контент
        mainPageObj.waitForLoadAnswer();
        // проверли, что текст ответа соответсвует тексту вопроса
        mainPageObj.checkText(questionText, answerText);
    }
    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }
}
