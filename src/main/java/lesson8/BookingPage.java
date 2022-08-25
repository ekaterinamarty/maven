package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BookingPage {

    private SelenideElement bookingContent = $(By.xpath("//div[@class='booking-step__content']"));

    @Step("Переход на страницу Авторизации")
    public BookingPage bookingContentPage() {
        $(bookingContent).shouldBe(visible);
        return this;
    }
}