package sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFirstPage {
    WebDriver driver;
    private By nameField = By.cssSelector("[placeholder=\"* Имя\"]"); //Локатор поля имя
    private By surnameField = By.cssSelector("[placeholder=\"* Фамилия\"]"); //Локатор поля фамилия
    private By addressField= By.cssSelector("[placeholder=\"* Адрес: куда привезти заказ\"]"); //Локатор поля адреса
    private By metroStationField =By.className("select-search__input"); //Локатор поля метро
    private By metroStationDropField = By.className("select-search__row"); //Локатор выбора станции метро
    private By numberPhoneField = By.cssSelector("[placeholder=\"* Телефон: на него позвонит курьер\"]"); //Локатор поля ввода номера телефона
    private By nextButton = By.className("Button_Middle__1CSJM"); //Локатор кнопки Далее


    public OrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для заполнения всех полей на первой странице заказа
    public void userInfo(String userName, String userSurname, String userAddress, String numberPhone){
        setUserName(userName);
        setUserSurname(userSurname);
        setUserAddress(userAddress);
        setMetroStation();
        setNumberPhone(numberPhone);
        clickButtonNext();
    }

    public void clickButtonNext() {
        driver.findElement(nextButton).click();
    } //Нажимает кнопку Далее

    public void setNumberPhone(String numberPhone) {
        driver.findElement(numberPhoneField).sendKeys(numberPhone);
    } //заполняет номер телефона

    public void setMetroStation() {
        driver.findElement(metroStationField).click();
        driver.findElements(metroStationDropField).get(4).click();
    } //выбирает станцию метро

    public void setUserAddress(String userAddress) {
        driver.findElement(addressField).sendKeys(userAddress);
    } //заполняет адрес

    public void setUserSurname(String userSurname) {
        driver.findElement(surnameField).sendKeys(userSurname);
    } //заполняет фамилию

    public void setUserName(String userName) {
        driver.findElement(nameField).sendKeys(userName);
    } //заполняет имя
}
