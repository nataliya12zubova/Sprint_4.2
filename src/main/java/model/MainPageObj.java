package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

// класс Главной страницы
public class MainPageObj {
    private WebDriver driver;
    private By question;
    private By answer;

    //локатор для верхней кнопки "Заказать"
    private By orderButtonUpper = By.className("Button_Button__ra12g");
    //локатор для средней кнопки "Заказать"
    private By orderButtonMiddle = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор для вопроса 1
    private By question1 = By.id("accordion__heading-0");
    //локатор для вопроса 2
    private By question2 = By.id("accordion__heading-1");
    //локатор для вопроса 3
    private By question3 = By.id("accordion__heading-2");
    //локатор для вопроса 4
    private By question4 = By.id("accordion__heading-3");
    //локатор для вопроса 5
    private By question5 = By.id("accordion__heading-4");
    //локатор для вопроса 6
    private By question6 = By.id("accordion__heading-5");
    //локатор для вопроса 7
    private By question7 = By.id("accordion__heading-6");
    //локатор для вопроса 8
    private By question8 = By.id("accordion__heading-7");

    //локатор для ответа 1
    private By answer1 = By.id("accordion__panel-0");
    //локатор для ответа 2
    private By answer2 = By.id("accordion__panel-1");
    //локатор для ответа 3
    private By answer3 = By.id("accordion__panel-2");
    //локатор для ответа 4
    private By answer4 = By.id("accordion__panel-3");
    //локатор для ответа 5
    private By answer5 = By.id("accordion__panel-4");
    //локатор для ответа 6
    private By answer6 = By.id("accordion__panel-5");
    //локатор для ответа 7
    private By answer7 = By.id("accordion__panel-6");
    //локатор для ответа 8
    private By answer8 = By.id("accordion__panel-7");

    public MainPageObj(WebDriver driver) {
        this.driver = driver;
    }
    // метод для нажатия на поле с вопросом

    public void clickQuestion() {
        driver.findElement(question).click();
    }
    // метод ожидания загрузки ответа на вопрос
    public void waitForLoadAnswer() {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(
                driver -> (
                        driver.findElement(answer).getText() != null
                                && !driver.findElement(answer).getText().isEmpty()
                )
        );
    }
    public void indicatePair(int number) {
        switch (number) {
            case 1:
                answer = answer1;
                break;
            case 2:
                answer = answer2;
                break;
            case 3:
                answer = answer3;
                break;
            case 4:
                answer = answer4;
                break;
            case 5:
                answer = answer5;
                break;
            case 6:
                answer = answer6;
                break;
            case 7:
                answer = answer7;
                break;
            default:
                answer = answer8;
                break;
        }

        switch (number) {
            case 1: question = question1;
                break;
            case 2: question = question2;
                break;
            case 3: question = question3;
                break;
            case 4: question = question4;
                break;
            case 5: question = question5;
                break;
            case 6: question = question6;
                break;
            case 7: question = question7;
                break;
            default: question = question8;
                break;
        }
    }

    //метод для проверки соответствия текста вопроса и текста ответа
    public void checkText(String questionText, String answerText) {
        String questionValue = driver.findElement(question).getText();
        String answerValue = driver.findElement(answer).getText();
        Assert.assertEquals(questionValue, questionText);
        Assert.assertEquals(answerValue, answerText);
    }

    //метод нажатия на верхнюю кнопку "Закать"
    public void clickOrderButtonUpper() {
        driver.findElement(orderButtonUpper).click();
    }

    //метод нажатия на среднюю кнопку "Закать"
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }
}
