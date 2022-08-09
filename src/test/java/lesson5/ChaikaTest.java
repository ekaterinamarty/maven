package lesson5;

import com.google.gson.internal.bind.JsonTreeReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ChaikaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String CHAIKA_BASE_URL = "https://chaika.com";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(CHAIKA_BASE_URL);
        driver.manage().window().maximize();
    }

    // Главная страница --> Журнал --> Клик по врачу из последний статья в журнале(переход на страницу с инфо о враче) -->
    // Онлайн-консультация --> Чек-бокс Я записываю ребенка --> 8 --> выбрать второй временной слот -->
    // EP: выбрано указанное время, переход на страницу авторизации/регистрации для продолжения записи
    @Test
    void appointmentTest() {
        driver.findElement(
                By.xpath("//div[@class='b-header__bottom container mobile-container']//span[text()[contains(.,'Журнал')]]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//div[@class='article-card-wrap']//span[@class='link--hover-blue article-card-author__text'])[1]")));
        driver.findElement(
                By.xpath("(//div[@class='article-card-wrap']//span[@class='link--hover-blue article-card-author__text'])[1]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()[contains(.,'консультация')]]")));
        driver.findElement(By.xpath("//span[text()[contains(.,'консультация')]]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='checkbox__icon']")));
        driver.findElement(By.xpath("//div[@class='checkbox__icon']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Укажите возраст']")));
        driver.findElement(By.xpath("//input[@placeholder='Укажите возраст']")).sendKeys("8");
        webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@placeholder='Укажите возраст']"), "8"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='slots-card__dates']//li[2]")));
        driver.findElement(By.xpath("//ul[@class='slots-card__dates']//li[2]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='booking-step__content']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='booking-step__content']")).isDisplayed(), true);
    }

    // Главная страница --> Подписка на доктора --> Выберите доктора (плейсхолдер Поиск по имени доктора) -->
    // ввод имени Анна --> Выбрать второго врача из списка --> Клик Хочу подписаться -->
    // EP: переход на страницу для входа/регистрации в ЛК
    @Test
    void followingDoctor() {
        driver.findElement(By.xpath("//li[@class='hotmenu__item']//span[text()[contains(.,'Подписка')]]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Поиск по имени доктора']")));
        driver.findElement(By.xpath("//input[@placeholder='Поиск по имени доктора']")).sendKeys("Анна");
        webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@placeholder='Поиск по имени доктора']"), "Анна"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='doctors-list']//li[@class='doctors-list__item'][2]//span[@class='button__text']")));
        driver.findElement(
                By.xpath("//ul[@class='doctors-list']//li[@class='doctors-list__item'][2]//span[@class='button__text']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layout__inner']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='layout__inner']")).isDisplayed(), true);
    }

    //Главная страница --> Клик по Google Play в хедере --> EP: переход в магазин Google Play
    @Test
    void googlePlayLink() {
        driver.findElement(By.xpath("//a[text()[contains(.,'Google Play')]]")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://play.google.com/store/apps/details?id=app.axetop.chaika");
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}