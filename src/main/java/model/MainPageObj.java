package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// класс Главной страницы
public class MainPageObj extends TestFixtures{
    //Заголовок элемента выпадающего списка
    private By faqHeader =By.className("accordion__heading");

    //Выпадающий текст элемента выпадающего списка
    private By faqDropdownText = By.className("accordion__panel");

    //локатор для верхней кнопки "Заказать"
    private By orderButtonUpper = By.xpath(".//div[contains(@class, 'Header_Nav__AGCXC')]/button[contains(text(), 'Заказать')]");

    //локатор для средней кнопки "Заказать"
    private By orderButtonMiddle = By.xpath(".//div[contains(@class,'Home_FinishButton')]/button[contains(text(), 'Заказать')]");

    public MainPageObj(WebDriver driver){
        this.driver = driver;
    }

    //метод нажатия на верхнюю кнопку "Закать"
    public void clickOrderButtonUpper() {
        driver.findElement(orderButtonUpper).click();
    }

    //метод нажатия на среднюю кнопку "Закать"
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }

    //Получить элемент "Заголовок" выпадающего списка "Вопросы о важном"
    public By getFaqHeader(int item){
        faqHeader = By.id("accordion__heading-" + item);
        return faqHeader;
    }

    //Получить элемент "Выпадающий текст" элемента аккордеона "Вопросы о важном"
    public By getFaqDropdownText(int item){
        faqDropdownText = By.id("accordion__panel-" + item);
        return faqDropdownText;
    }
}
