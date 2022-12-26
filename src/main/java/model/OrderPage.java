package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//класс страницы Заказа
public class OrderPage extends TestFixtures {
    //создали локаторы для полей Заказа
    private By nameField = By.xpath(".//input[placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[placeholder='* Адрес: куда привезти заказ']");
    private By subwayStationField = By.xpath(".//input[placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[placeholder='* Телефон: на него позвонит курьер']");

    // создали локатор для кнопки перехода к следющим полям заполнения заказа
    private By nextBtn = By.className("Button_Middle__1CSJM");

    //создали локаторы для полей Заказа
    private By dateField = By.xpath(".//input[placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//input[placeholder='* Срок аренды']");
    private By colorField = By.id("grey");
    private By commentField = By.xpath(".//input[placeholder='Комментарий для курьера']");

    // создали локатор для кнопки "Заказать"
    private By orderedBtn = By.xpath(".//button[@text='Заказать'] and @class='Button_Button__ra12g Button_Middle__1CSJM'");
    //Модальное окно "Подтверждение заказа"
    private By orderConfirmationModal = By.xpath(".//div[contains(text(), 'Хотите оформить заказ?')]");
    // создали локатор для кнопки "Да"
    private By invertedBtn = By.className("Button_Inverted__3IF-i");
    //Модальное окно "Заказ оформлен"
    private By successOrderModal = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");

    //Геттер для модального окна "Заказ оформлен"
    public By getSuccessOrderModal() {
        return successOrderModal;
    }

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение полей заказа
    public void setUserName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setSubwayStationField(String subwayStation) {
        driver.findElement(subwayStationField).sendKeys(subwayStation);
    }

    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // метод для нажатия на кнопку "Далее"
    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

    //Заполнение полей заказа
    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void setRentalPeriodField(String rentalPeriod) {
        driver.findElement(rentalPeriodField).sendKeys(rentalPeriod);
    }

    public void setColorField(String color) {
        driver.findElement(colorField).sendKeys(color);
    }

    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // метод для нажатия на кнопку "Заказать"
    public void clickOrderedBtn() {
        driver.findElement(orderedBtn).click();
    }

    // метод для нажатия на кнопку подтверждения заказа "Да"
    public void clickInvertedBtn() {
        driver.findElement(invertedBtn).click();
    }

    //Ожидание появления окна подтверждения заказа
    public void waitForLoadPage() {
        Helpers.waitElementDisplayed(driver, 5, nameField);
    }

    //Ожидание появления окна подтверждения заказа
    public void waitForOrderConfirmationModal() {
        Helpers.waitElementDisplayed(driver, 5, orderConfirmationModal);
    }

    //Ожидание появления окна об успешном заказе
    public void waitForSuccessOrderModal() {
        Helpers.waitElementDisplayed(driver, 5, successOrderModal);
    }

    //Шаги заполнения формы "Для кого самокат"
    public void completeOrderForm1(
            String name,
            String surname,
            String address,
            String subwayStation,
            String phone) {
        setUserName(name);
        setSurname(surname);
        setAddress(address);
        setSubwayStationField(subwayStation);
        setPhoneField(phone);
    }

    //Шаги заполнения формы "Про аренду"
    public void completeOrderForm2(
            String date,
            String rentalPeriod,
            String color,
            String comment) {
        setDateField(date);
        setRentalPeriodField(rentalPeriod);
        setColorField(color);
        setCommentField(comment);
    }
}

