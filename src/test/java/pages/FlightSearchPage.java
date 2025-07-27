package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Random;

public class FlightSearchPage extends BasePage {

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.booking.com/flights");
    }

    public void selectOneWay() {
        waitForClick(By.xpath("//label[contains(text(),'One-way')]")).click();
    }

    public void enterRandomFromAndTo() {
        String[] cities = {"New York", "London", "Paris", "Dubai", "Tokyo", "Delhi"};
        Random rand = new Random();
        String fromCity = cities[rand.nextInt(cities.length)];
        String toCity;
        do {
            toCity = cities[rand.nextInt(cities.length)];
        } while (toCity.equals(fromCity));

        WebElement fromInput = waitForClick(By.xpath("//input[@placeholder='From?']"));
        fromInput.clear();
        fromInput.sendKeys(fromCity);
        waitAndClickSuggestion();

        WebElement toInput = waitForClick(By.xpath("//input[@placeholder='To?']"));
        toInput.clear();
        toInput.sendKeys(toCity);
        waitAndClickSuggestion();
    }

    private void waitAndClickSuggestion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul[role='listbox'] li"))).click();
    }

    public void selectDepartureDateAndPassengers() {
        waitForClick(By.cssSelector("[data-ui-name='input_date_field_departure']")).click();
        waitForClick(By.cssSelector("div[data-day]:not([class*='disabled'])")).click(); // Select first active date
        waitForClick(By.cssSelector("button[data-ui-name='button_passengers']")).click();
        waitForClick(By.cssSelector("button[aria-label='Increase number of Adults']")).click(); // Add 1 more adult
        waitForClick(By.cssSelector("button[data-ui-name='button_done']")).click();
    }

    public void clickSearch() {
        waitForClick(By.cssSelector("button[type='submit']")).click();
    }
}

