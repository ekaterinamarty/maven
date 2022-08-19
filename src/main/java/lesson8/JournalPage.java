package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class JournalPage {

    private SelenideElement doctorChoice =
            $(By.xpath("(//div[@class='article-card-wrap']//span[@class='link--hover-blue article-card-author__text'])[1]"));

    @Step("Клик по ФИО врача из последней публикации в Журнале")
    public DoctorProfilePage clickDoctorChoice() {
        doctorChoice.click();
        return page(DoctorProfilePage.class);
    }
}