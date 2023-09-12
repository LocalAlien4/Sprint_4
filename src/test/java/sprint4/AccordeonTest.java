package sprint4;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sprint4.pages.Environment;
import sprint4.pages.Questions;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class AccordeonTest {
    private WebDriver driver;
    private final int id;
    private final String expectedText;

    public AccordeonTest(int id, String expectedText) {
        this.id = id;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionsAnswers(){
        return new Object[][]{
                {0,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void questionsCheck(){
           driver = new ChromeDriver();
        Environment environment = new Environment(driver);
        Questions questions= new Questions(driver);
        environment.openScooterPage(); //Открытие сервиса
        questions.scrollToQuestions(); //скролл до модуля с вопросами
        String actualText= questions.getAccordeonItemText(id); //в actualText записываю полученный текст элемента
        assertEquals(expectedText, actualText); //сравниваю ожидаемый текст с полученным
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
