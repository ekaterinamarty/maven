package lesson8;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AppointmentPage {
    private SelenideElement checkBox = $(By.xpath("//div[@class='checkbox__icon']"));

    @Step("Клик чек-бокс Я записываю ребенка")
    public AppointmentPage clickCheckBox() {
        checkBox.click();
        return this;
    }

    private SelenideElement inputAge = $(By.xpath("//input[@placeholder='Укажите возраст']"));

    @Step("Ввод возраста")
    public AppointmentPage setInputAge(String age) {
        inputAge.sendKeys(age);
        return this;
    }

    //private SelenideElement timeSlot = $(By.xpath("//ul[@class='slots-card__dates']//li[2]"));
    private ElementsCollection timeSlots = $$(By.xpath("//ul[@class='slots-card__dates']//li")); /* второй временной слот из списка */

    @Step("Выбрать второй временной слот для записи")
    public BookingPage timeSlotChoice() {
        timeSlots.get(1).click();
        return page(BookingPage.class);
    }
}