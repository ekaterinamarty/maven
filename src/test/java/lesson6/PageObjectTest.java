package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import lesson7.AdditionalLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get("https://chaika.com/");
        driver.manage().window().maximize();
    }

    @Test
    @Feature("Авторизация")
    @TmsLink("0611")
    @DisplayName("Запись к врачу через Журнал")
    void appointmentTest() throws InterruptedException {
        new MainPage(driver).clickJournalBtn()
                .clickDoctorChoice()
                .clickOnlineConsBtn()
                .clickCheckBox()
                .setInputAge("8")
                .timeSlotChoice()
                .bookingContentPage();
                Assertions.assertEquals
                        (driver.findElement(By.xpath("//div[@class='booking-step__content']")).isDisplayed(), true);
    }

    @AfterEach
    void quitBrowser() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }

        driver.quit();
    }
}
