package sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Questions {
    WebDriver driver;
    private By allQuestions= By.className("Home_FourPart__1uthg"); //Локатор для модуля с вопросами
    private By accordeonPanel = By.xpath(".//*[starts-with(@id, 'accordion__heading-')]"); //Локатор для поля с вопросом
    private By accordeonItemPanel= By.xpath(".//*[starts-with(@id, 'accordion__panel-')]//p"); //Локатор для поля с ответом
    public Questions(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToQuestions(){
        WebElement element = driver.findElement(allQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    } //скролл до модуля с вопросами
    public String getAccordeonItemText(int id) {
        driver.findElements(accordeonPanel).get(id).click();
        return  driver.findElements(accordeonItemPanel).get(id).getText();
    } //возвращает текст ответа на полученный вопрос
}
