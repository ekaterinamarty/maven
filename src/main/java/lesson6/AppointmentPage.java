package lesson6;

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

    public AppointmentPage clickCheckBox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(checkBox));
        checkBox.click();
        return this;
    }

    @FindBy(xpath = "//input[@placeholder='Укажите возраст']")
    public WebElement inputAge;

    public AppointmentPage setInputAge(String age) {
        webDriverWait.until(ExpectedConditions.visibilityOf(inputAge));
        inputAge.sendKeys(age);
        return this;
    }

    @FindBy(xpath = "//ul[@class='slots-card__dates']//li[2]")
    public WebElement timeSlot;

    public BookingPage timeSlotChoice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(timeSlot));
        timeSlot.click();
        return new BookingPage(driver);
    }
}
