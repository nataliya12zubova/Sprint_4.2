package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//класс страницы Заказа
public class OrderPage {
    private WebDriver driver;
    //создали локаторы для полей Заказа
    private By nameField = By.xpath(".//input[placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[placeholder='* Адрес: куда привезти заказ']");
    private By subwayStationField = By.xpath(".//input[placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[placeholder='* Телефон: на него позвонит курьер']");
    // создали локатор для кнопки перехода к следющим полям заполнения заказа
    private By nextBtn = By.className("Button_Middle__1CSJM");
    private By dateField = By.xpath(".//input[placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//input[placeholder='* Срок аренды']");
    private By colorField = By.id("grey");
    private By commentField = By.xpath(".//input[placeholder='Комментарий для курьера']");
    private By invertedBtn = By.className("Button_Inverted__3IF-i");
    private By orderedBtn = By.xpath(".//button[@text='Заказать'] and @class='Button_Button__ra12g Button_Middle__1CSJM'");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
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
    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    public void setRentalPeriodField(String rentalPeriod) {
        driver.findElement(rentalPeriodField).sendKeys(rentalPeriod);
    }
    public void setColorField(String color) {
        driver.findElement(colorField).sendKeys("grey");
    }
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    // метод для нажатия на кнопку "Заказать"
    public void clickInvertedBtn() {
        driver.findElement(invertedBtn).click();
    }
    // метод для нажатия на кнопку подтверждения заказа "Да"
    public void clickOrderedBtn() {
        driver.findElement(orderedBtn).click();
    }
    // метод ожидания загрузки страницы заказа
    public void waitForLoadAnswer() {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(
                driver -> (
                        driver.findElement(nameField).getText() != null
                                && !driver.findElement(nameField).getText().isEmpty()
                )
        );
    }
}


