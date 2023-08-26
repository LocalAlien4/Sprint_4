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
