package sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
  private By orderButtonHeader = By.cssSelector("div > div.Home_HomePage__ZXKIX > div.Header_Header__214zg > div.Header_Nav__AGCXC > button.Button_Button__ra12g"); //Локатор кнопки в хэдере

    private By orderButtonBig = By.cssSelector("div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"); //Локатор кнопки под инструкцией

    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickHeaderOrder() {
        driver.findElement(orderButtonHeader).click();
    } //нажатие на кнопку заказа в хэдере

    public void clickBigButton()  {
        WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonBig));
        driver.findElement(orderButtonBig).click();
    } //нажатие на кнопку заказа под инструкцией

    public void clickOrderButton(boolean header){
        if (header){
            clickHeaderOrder();
        }
        else {clickBigButton();}
    } //метод для нажатия кнопки в зависимости от параметра теста
}
