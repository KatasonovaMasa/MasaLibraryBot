package canva;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CanvaReg {
    @Test
    public void googleOpen(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver1");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1000,1000));
        driver.get("https://www.canva.com/");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[6]/div/section/div/div/div/div/div/div/button"));
        button.click();
        WebDriverWait  wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div[6]/div/section/div/div/div/div/div/div/div[2]/form/button")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[6]/div/section/div/div/div/div/div/div/div[2]/form/div[1]/input")).sendKeys("Maru");
        Random random = new Random();
        int n = random.nextInt(100) +1;
        String email = "katasonomasa" + n + "@gmail.com";
        System.out.println(email);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[6]/div/section/div/div/div/div/div/div/div[2]/form/div[2]/div/div/div/input")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[6]/div/section/div/div/div/div/div/div/div[2]/form/div[3]/input")).sendKeys("zaqplM123!@");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[6]/div/section/div/div/div/div/div/div/div[2]/form/button/span")).click();
        driver.quit();
    }
}
