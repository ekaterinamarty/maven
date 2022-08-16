package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingPage extends BasePage {
    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='booking-step__content']")
    public WebElement bookingContent;

    public void bookingContentPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(bookingContent));
    }
}
