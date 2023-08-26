package sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Environment {
    WebDriver driver;
    private By cookieButton = By.className("App_CookieButton__3cvqF"); //Локатор для кнопки согласия с куки
    public Environment(WebDriver driver){
        this.driver=driver;
    }
    public void openScooterPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(cookieButton).click();
    } //открыть страницу сервиса и согласиться с куками
}
