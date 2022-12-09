package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

// класс Главной страницы
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // метод для нажатия на поле с вопросом

    public void clickQuestion(int elementId) {
        driver.findElement(By.id("accordion__heading-" + elementId)).click();
    }
    // метод ожидания загрузки ответа на вопрос
    public void waitForLoadAnswer(int elementId) {
        By answerElement = By.id("accordion__panel-" + elementId);
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(
                driver -> (
                        driver.findElement(answerElement).getText() != null
                        && !driver.findElement(answerElement).getText().isEmpty()
                )
        );
    }
    //метод для проверки соответствия текста вопроса и текста ответа
    public void checkText(String questionText, String answerText, int elementId) {
        By questionElement = By.id("accordion__heading-" + elementId);
        By answerElement = By.id("accordion__panel-" + elementId);
        String questionValue = driver.findElement(questionElement).getText();
        String answerValue = driver.findElement(answerElement).getText();
        Assert.assertEquals(questionValue, questionText);
        Assert.assertEquals(answerElement, answerText);
    }
    //локатор для верхней кнопки "Заказать"
    private By orderButtonUpper = By.className("Order_Content__bmtHS");
    //метод нажатия на кнопку "Закать"
    public void clickOrderButtonUpper() {
        driver.findElement(orderButtonUpper).click();
    }
}
