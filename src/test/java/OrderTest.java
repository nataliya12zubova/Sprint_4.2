import model.CheckOrderPlacedPage;
import model.MainPage;
import model.OrderPage;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class OrderTest {
        public WebDriver driver;

        public WebDriver webDriverType;

        public OrderTest(WebDriver webDriverValue) {
                this.webDriverType = webDriverValue;
        }

        @Parameterized.Parameters
        public static Object[] getData() {
                // создали драйвер для браузера Chrome
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                // перешли на страницу тестового приложения
                WebDriver chromeDriver = new ChromeDriver(chromeOptions);

                // создали драйвер для браузера Firefox
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                WebDriver firefoxDriver = new FirefoxDriver(ffOptions);

                return new Object[] {
                        chromeDriver,
                        firefoxDriver,
                };
        }

        // это переменные со значением, которые надо ввести в поля
        private final String name = "Наталия";
        private final String surname = "Зубова";
        private final String address ="Тверская, 10";
        private final String subwayStation = "Охотный ряд";
        private final String phone = "+77777777777";
        private final String date = "12.12.2022";
        private final String rentalPeriod = "двое суток";
        private final String color ="серая безысходность";
        private final String comment = "оплата наличными";
        private final String orderSuccess = "Заказ офромлен";

        @Test
        public void makeOrder() {
                // перешли на страницу тестового приложения
                driver = webDriverType;
                //driver = new FireFoxDriver(options);
                driver.get("https://qa-scooter.praktikum-services.ru/");

                OrderPage orderPage = new OrderPage(driver);

                // создали объект класса Главной страницы
                MainPage mainPage = new MainPage(driver);

                // кликнули на кнопку "Заказать" на Главной странице
                mainPage.clickOrderButtonUpper();
                //ожидание загрузки страницы заказа
                orderPage.waitForLoadAnswer();
                // заполнение атрибутов заказа (стр. 1)
                orderPage.setUserName(name);
                orderPage.setSurname(surname);
                orderPage.setAddress(address);
                orderPage.setSubwayStationField(subwayStation);
                orderPage.setPhoneField(phone);

                // кликнули на кнопку "Далее"
                orderPage.clickNextBtn();

                // заполнение атрибутов заказа (стр. 2)
                orderPage.setDateField(date);
                orderPage.setRentalPeriodField(rentalPeriod);
                orderPage.setColorField(color);
                orderPage.setCommentField(comment);

                // кликнули на кнопку "Заказать"
                orderPage.clickInvertedBtn();

                // кликнули на кнопку "Да"
                orderPage.clickOrderedBtn();

                // создай объект класса модального окна "Заказ оформлен"
                CheckOrderPlacedPage checkOrderPlacedPage = new CheckOrderPlacedPage(driver);
                // дождись загрузки заголовка
                checkOrderPlacedPage.waitForLoadHeader();
                // получи текст элемента в заголовке
                String OrderPlacedText = checkOrderPlacedPage.orderPlaced();
                // сделай проверку, что полученное значение совпадает с текстом "Заказ офромлен"
                MatcherAssert.assertThat(OrderPlacedText, is(orderSuccess));
        }
        @After
        public void tearDown() {
        // закрыли браузер
        driver.quit();
        }
}
