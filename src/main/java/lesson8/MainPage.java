package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private SelenideElement journalBtn = $(By.xpath("//div[@class='b-header__bottom container mobile-container']//span[text()[contains(.,'Журнал')]]"));

    @Step("Клик на Журнал в хедере")
    public JournalPage clickJournalBtn() {
        journalBtn.click();
        return page(JournalPage.class);
    }
}