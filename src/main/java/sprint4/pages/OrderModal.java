package sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderModal {
    WebDriver driver;
    private By yesField= By.cssSelector("div > div.Order_Content__bmtHS > div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");//Локатор кнопки Да
    private By modalSuccess= By.className("Order_ModalHeader__3FDaJ"); //Локатор модалки с завершением оформления

   public OrderModal(WebDriver driver){
       this.driver=driver;
   }

    public void clickYes(){
        driver.findElement(yesField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(modalSuccess));
    }    //Нажать на да. Подождать пока появится модалка

    public String actualText(){
        return driver.findElement(modalSuccess).getText();
    } //Получить текст на модалке
}
