import model.MainPageObj;
import model.OrderPage;
import model.TestFixtures;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderTest extends TestFixtures {
        private MainPageObj mainPageObj = new MainPageObj(driver);
        private OrderPage orderPage = new OrderPage(driver);
        // это переменные со значением, которые надо ввести в поля
        private String name;
        private String surname;
        private String address;
        private String subwayStation;
        private String phone;
        private String date;
        private String rentalPeriod;
        private String color;
        private String comment;
        private boolean isDisplayed;;

        public OrderTest(String name, String surname, String address, String subwayStation, String phone,
                String date, String rentalPeriod, String color, String comment, boolean isDisplayed) {
                this.name = name;
                this.surname = surname;
                this.address = address;
                this.subwayStation = subwayStation;
                this.phone = phone;
                this.date = date;
                this.rentalPeriod = rentalPeriod;
                this.color = color;
                this.comment = comment;
                this.isDisplayed = isDisplayed;
        }

        @Parameterized.Parameters(name = "CHROME. Форма заказа заполнена корректно для {0} {1}. Заказ оформлен? {9}")
        public static Object[][] getData() {
                return new Object[][] {
                        { "Наталия", "Зубова", "Тверская,10", "Охотный ряд", "+77777777777", "12.12.2022", "двое суток", "серая безысходность", "оплата наличными", true}
                };
        }

        @Test
        public void makeOrderButtonUpper() {
                // кликнули на верхнюю кнопку "Заказать" на Главной странице
                mainPageObj.clickOrderButtonUpper();
                //ожидание загрузки страницы заказа
                orderPage.waitForLoadPage();
                // заполнение атрибутов заказа (стр. 1)
                orderPage.completeOrderForm1(
                        name,
                        surname,
                        address,
                        subwayStation,
                        phone);
                // кликнули на кнопку "Далее"
                orderPage.clickNextBtn();
                // заполнение атрибутов заказа (стр. 2)
                orderPage.completeOrderForm2(
                        date,
                        rentalPeriod,
                        color,
                        comment);
                orderPage.clickOrderedBtn();
                orderPage.waitForOrderConfirmationModal();
                orderPage.clickInvertedBtn();
                orderPage.waitForSuccessOrderModal();
                orderPage.waitForSuccessOrderModal();
                Assert.assertTrue("Модальное окно \"Заказ оформлен\" не отображается",driver.findElement(orderPage.getSuccessOrderModal()).isDisplayed()==isDisplayed);

        }
        @Test
        public void makeOrderButtonMiddle() {
                // кликнули на среднюю кнопку "Заказать" на Главной странице
                mainPageObj.clickOrderButtonMiddle();
                //ожидание загрузки страницы заказа
                orderPage.waitForLoadPage();
                // заполнение атрибутов заказа (стр. 1)
                orderPage.completeOrderForm1(
                        name,
                        surname,
                        address,
                        subwayStation,
                        phone);
                // кликнули на кнопку "Далее"
                orderPage.clickNextBtn();
                // заполнение атрибутов заказа (стр. 2)
                orderPage.completeOrderForm2(
                        date,
                        rentalPeriod,
                        color,
                        comment);
                orderPage.clickOrderedBtn();
                orderPage.waitForOrderConfirmationModal();
                orderPage.clickInvertedBtn();
                orderPage.waitForSuccessOrderModal();
                orderPage.waitForSuccessOrderModal();
                Assert.assertTrue("Модальное окно \"Заказ оформлен\" не отображается",driver.findElement(orderPage.getSuccessOrderModal()).isDisplayed()==isDisplayed);


                }
        @After
        public void tearDown() {
        // закрыли браузер
        driver.quit();
        }
}
