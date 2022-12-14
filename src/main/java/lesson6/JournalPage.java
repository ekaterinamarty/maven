package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JournalPage extends BasePage {

    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='article-card-wrap']//span[@class='link--hover-blue article-card-author__text'])[1]")
    public WebElement doctorChoice;

    @Step("Клик по ФИО врача из последней публикации в Журнале")
    public DoctorProfilePage clickDoctorChoice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(doctorChoice));
        doctorChoice.click();
        return new DoctorProfilePage(driver);
    }
}
