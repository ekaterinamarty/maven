package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppointmentPage extends BasePage {

    public AppointmentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='checkbox__icon']")
    public WebElement checkBox;

    @Step("Клик чек-бокс Я записываю ребенка")
    public AppointmentPage clickCheckBox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(checkBox));
        checkBox.click();
        return this;
    }

    @FindBy(xpath = "//input[@placeholder='Укажите возраст']")
    public WebElement inputAge;

    @Step("Ввод возраста")
    public AppointmentPage setInputAge(String age) {
        webDriverWait.until(ExpectedConditions.visibilityOf(inputAge));
        inputAge.sendKeys(age);
        return this;
    }

    @FindBy(xpath = "//ul[@class='slots-card__dates']//li[2]")
    public WebElement timeSlot;

    @Step("Выбрать второй временной слот для записи")
    public BookingPage timeSlotChoice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(timeSlot));
        timeSlot.click();
        return new BookingPage(driver);
    }
}
