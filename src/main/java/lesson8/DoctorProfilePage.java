package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DoctorProfilePage {

    private SelenideElement onlineConsBtn = $(By.xpath("//span[text()[contains(.,'консультация')]]"));

    @Step("Клик Онлайн-консультация")
    public AppointmentPage clickOnlineConsBtn() {
        onlineConsBtn.click();
        return page(AppointmentPage.class);
    }
}