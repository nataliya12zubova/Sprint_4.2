package model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс модального окна "Заказ оформлен"
public class CheckOrderPlacedPage {
    private WebDriver driver;

    // создали локатор для элемента c текстом "Заказ оформлен"
    private By headerUser = By.className("Order_ModalHeader__3FDaJ");

    public CheckOrderPlacedPage(WebDriver driver) {
        this.driver = driver;
    }
    // метод для получения текста элемента
    public void waitForLoadHeader(){
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(headerUser));
    }

    // метод для получения текста элемента
    public String orderPlaced () {
        return driver.findElement(headerUser).getText();
    }
}
