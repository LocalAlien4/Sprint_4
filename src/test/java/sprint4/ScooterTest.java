package sprint4;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sprint4.pages.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterTest {
    private WebDriver driver;
    private final boolean header;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String numberPhone;
    private final int idDate;
    private final int idPeriod;
    private final int color;
    private final String comment;

    public ScooterTest(boolean header, String userName, String userSurname, String userAddress, String numberPhone, int idDate, int idPeriod, int color, String comment) {
        this.header = header;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.numberPhone = numberPhone;
        this.idDate = idDate;
        this.idPeriod = idPeriod;
        this.color = color;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getOrderInformation(){
        return new Object[][]{
              {true,"Иван","Иванов","Какой-то адрес","79119991199", 4,1,0,"Этот заказ оформлен с хэдера"},
              {false,"Петр","Петрович","Из Москвы","79111111111", 28,4,1,"Этот заказ оформлен с большой кнопки"},
      };
    }

    @Test
    public void newOrderPositiveCase() throws InterruptedException {
          driver = new ChromeDriver();
        Environment environment = new Environment(driver);
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        MainPage mainPage = new MainPage(driver);
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);
        OrderModal orderModal= new OrderModal(driver);

        environment.openScooterPage(); //Открытие сервиса
        mainPage.clickOrderButton(header); //клик на кнопку заказать
        orderFirstPage.userInfo(userName,userSurname,userAddress,numberPhone); //Заполнение полей на первой странице заказа и нажатие на кнопку Далее
        orderSecondPage.orderInfo( idDate,idPeriod,color,comment); //Заполнение полей на второй странице заказа
        orderModal.clickYes(); //подтверждение
        assertTrue("Не отобразилось сообщение об успешном заказе",orderModal.actualText().startsWith("Заказ оформлен")); //проверка на появление сообщения об успешном заказе
    }

       @After
   public void closeDriver() {
        driver.quit();
    }
}
