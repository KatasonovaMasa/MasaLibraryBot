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
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,1500));
        driver.get("https://www.canva.com");
        WebElement button = driver.findElement(By.xpath("//span[text()='Sign up']"));
        button.click();
        //убеждаемся, что браузер открылся в течении 10 сек
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section//..//span[text()='Sign up with email']"))).click();

        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Maru");
        //добавляем метод рандомного добавления числа, для уникальности email
        Random random = new Random();
        int n = random.nextInt(100) +1;
        String email = "katasonova_masa1" + n + "@gmail.com";
        System.out.println(email);
        //ищем элементы формы и заполняем данные
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("zaqplM123!@");
        driver.findElement(By.xpath("//span[contains(text(),\"Get started, it's free!\")]")).click();
        //проверяем проверку путем появления элемента после регистрации
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), \"We'll use this to recommend designs and templates especially for you.\")]")));
        //закрывем браузер
        // driver.quit();
    }
}