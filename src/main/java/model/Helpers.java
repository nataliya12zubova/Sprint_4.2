package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helpers { //Класс для вспомогательных инструментов не относящийхся к тестам
        public static void waitTextToBePresentInElement(WebDriver driver, int timeToWait, By targetElement, String expectedText){
            new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.textToBePresentInElementLocated(targetElement, expectedText));
        }
        public static void waitElementDisplayed(WebDriver driver, int timeToWait, By targetElement){
            new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(d -> (driver.findElement(targetElement).isDisplayed()));
        }
    }
