package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


// Главная страница --> Журнал --> Клик по врачу из последний статья в журнале(переход на страницу с инфо о враче) --> Онлайн-консультация -->
// Чек-бокс Я записываю ребенка --> 8 -->
// выбрать второй временной слот --> OP: выбрано указанное время, переход на страницу авторизации/регистрации для продолжения записи

public class ChaikaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://chaika.com/");
        driver.manage().window().maximize(); //

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement JournalBtn = driver.findElement(By.xpath("//div[@class='b-header__bottom container mobile-container']//span[text()[contains(.,'Журнал')]]"));
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='b-header__bottom container mobile-container']//span[text()[contains(.,'Журнал')]]"))));
        JournalBtn.click();
//        Thread.sleep(3000);

        WebElement AuthorBtn = driver.findElement(By.xpath("(//div[@class='article-card-wrap']//span[@class='link--hover-blue article-card-author__text'])[1]"));
        AuthorBtn.click();
//        Thread.sleep(3000);

        WebElement OnlineCons = driver.findElement(By.xpath("//span[text()[contains(.,'консультация')]]"));
        OnlineCons.click();
//        Thread.sleep(3000);

        WebElement CheckBox = driver.findElement(By.xpath("//div[@class='checkbox__icon']"));
        CheckBox.click();
//        Thread.sleep(3000);

        WebElement ChildAge = driver.findElement(By.xpath("//input[@placeholder='Укажите возраст']"));
        ChildAge.sendKeys("8");
//        Thread.sleep(3000);

        WebElement TimeSlot = driver.findElement(By.xpath("(//ul[@class='slots-card__dates']//li)[2]"));
        TimeSlot.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
