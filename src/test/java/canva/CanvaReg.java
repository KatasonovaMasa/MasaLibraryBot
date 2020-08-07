package canva;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CanvaReg {
    @Test
    public void canvaReg(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver1");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200,1200));
        driver.get("https://www.canva.com");
        WebElement button = driver.findElement(By.xpath("//section//..//span[text()='Зарегистрироваться']"));
        button.click();

        //убеждаемся, что браузер открылся в течении 10 сек
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Создать учетную запись']")));

        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Maru");

        //добавляем метод рандомного добавления числа, для уникальности email
        Random random = new Random();
        int n = random.nextInt(100) +1;
        String email = "katasonova_masa" + n + "@gmail.com";
        System.out.println(email);

        //ищем элементы формы и заполняем данные
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("zaqplM123!@");
        driver.findElement(By.xpath("//span[text()='Начните работу! Это бесплатно.']")).click();

        //проверяем проверку путем появления элемента после регистрации
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//..//p[text()='Мы собираем эту информацию, чтобы рекомендовать именно те дизайны и шаблоны, которые могут вам понравиться.']")));

        //закрывем браузер
        driver.quit();
    }
}