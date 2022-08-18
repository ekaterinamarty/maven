package lesson6;

// Главная страница --> Журнал --> Клик по врачу из последний статья в журнале(переход на страницу с инфо о враче) -->
// Онлайн-консультация --> Чек-бокс Я записываю ребенка --> 8 --> выбрать второй временной слот -->
// EP: выбрано указанное время, переход на страницу авторизации/регистрации для продолжения записи

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='b-header__bottom container mobile-container']//span[text()[contains(.,'Журнал')]]")
    public WebElement journalBtn;

    @Step("Клик на Журнал в хедере")
    public JournalPage clickJournalBtn() {
        webDriverWait.until(ExpectedConditions.visibilityOf(journalBtn));
        journalBtn.click();
        return new JournalPage(driver);
    }
}
