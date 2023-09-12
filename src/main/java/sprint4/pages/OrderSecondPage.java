package sprint4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSecondPage {
    WebDriver driver;
    private By dateField= By.xpath("*//div[@class='react-datepicker__input-container']//input[contains(@class,'Input_Responsible__1jDKN')]"); //Локатор поля с датой
    private By calendarDrop= By.className("react-datepicker__day"); //Локатор дат в календаре
    private By arendaField= By.className("Dropdown-control"); // Локатор поля со сроком аренды
    private By arendaDrop= By.className("Dropdown-option"); // Локатор полей со сроком аренды
    private By colorField= By.className("Checkbox_Label__3wxSf");//Локатор поля с цветом
    private By commentField = By.xpath("*//div[@class='Input_InputContainer__3NykH']//input[contains(@class,'Input_Responsible__1jDKN')]"); //Локатор для комментария

    private By orderButton = By.xpath("*//div[@class='Order_Buttons__1xGrp']//button[2]");// Локатор для кнопки заказа
    public OrderSecondPage(WebDriver driver){
        this.driver=driver;
    }
      public void setDateField(int idDate){
        driver.findElement(dateField).click();
        driver.findElements(calendarDrop).get(idDate).click();
    }   //Заполняет поле с датой

    public void setArendaField(int idPeriod){
        driver.findElement(arendaField).click();
        driver.findElements(arendaDrop).get(idPeriod).click();
    }     //Заполняет поле со сроком аренды

    public void setColorField(int color){
        driver.findElements(colorField).get(color).click();
    }    //Выбирает цвет

    public void setCommentField(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }     //Пишет комментарий

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }     //Нажимает кнопку заказать под полями

//Метод для заполнения всех полей данных для заказа
    public void orderInfo(int idDate, int idPeriod, int color, String comment){
        setDateField(idDate);
        setArendaField(idPeriod);
        setColorField(color);
        setCommentField(comment);
        clickOrderButton();
    }
}
