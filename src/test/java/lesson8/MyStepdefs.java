package lesson8;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {

    @Given("Пользователь на главной странице")
    public void пользовательНаГлавнойСтранице() {
        open("https://chaika.com/");
    }

    @When("^Клик на Журнал$")
    public void кликНаЖурнал() {
        new MainPage().clickJournalBtn();
    }

    @And("^Клик по врачу из первой статьи в Журнале$")
    public void кликПоВрачуИзПервойСтатьиВЖурнале() {
        new JournalPage().clickDoctorChoice();
    }

    @And("^Клик онлайн-консультация на странице врача$")
    public void кликОнлайнКонсультацияНаСтраницеВрача() {
        new DoctorProfilePage().clickOnlineConsBtn();
    }

    @And("Клик чек-бокс Я записываю ребенка")
    public void кликЧекБоксЯЗаписываюРебенка() {
        new AppointmentPage().clickCheckBox();
    }

    @And("Ввод возраста в поле Укажите возраст {string}")
    public void вводВозрастаВПолеУкажитеВозрастAge(String age) {
        new AppointmentPage().setInputAge(age);
    }

    @And("^Клик по второму временному слоту для записи$")
    public void кликПоВторомуВременномуСлотуДляЗаписи() {
        Configuration.timeout = 10000;
        new AppointmentPage().timeSlotChoice();
    }

    @Then("^Страница вход/регистрация отображается$")
    public void страницаВходРегистрацияОтображается() {
        new BookingPage().bookingContentPage();
    }

    @After(value = "@close")
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}