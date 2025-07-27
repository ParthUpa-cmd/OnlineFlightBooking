package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void printFlightCount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-testid='flight_card']")));
            int flights = driver.findElements(By.cssSelector("div[data-testid='flight_card']")).size();
            System.out.println("Number of flights found: " + flights);
        } catch (TimeoutException e) {
            System.out.println("No flights found or result took too long to load.");
        }
    }
}