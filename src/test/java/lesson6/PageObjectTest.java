package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://chaika.com/");
        driver.manage().window().maximize();
    }

    @Test
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
        driver.quit();
    }
}
