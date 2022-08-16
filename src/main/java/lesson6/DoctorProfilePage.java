package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorProfilePage extends BasePage {

    public DoctorProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()[contains(.,'консультация')]]")
    public WebElement onlineConsBtn;

    @Step("Клик Онлайн-консультация")
    public AppointmentPage clickOnlineConsBtn() {
        webDriverWait.until(ExpectedConditions.visibilityOf(onlineConsBtn));
        onlineConsBtn.click();
        return new AppointmentPage(driver);
    }
}
