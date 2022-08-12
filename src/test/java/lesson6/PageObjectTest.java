package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
