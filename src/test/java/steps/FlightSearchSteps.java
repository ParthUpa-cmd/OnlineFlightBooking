package steps;

import io.cucumber.java.en.*;
import pages.FlightSearchPage;
import pages.SearchResultsPage;
import utils.DriverFactory;

public class FlightSearchSteps {

    FlightSearchPage flightPage = new FlightSearchPage(DriverFactory.getDriver());
    SearchResultsPage resultPage = new SearchResultsPage(DriverFactory.getDriver());

    @Given("I open the Booking flight page")
    public void openFlightPage() {
        flightPage.open();
    }

    @When("I select one-way trip")
    public void selectOneWay() {
        flightPage.selectOneWay();
    }

    @And("I enter random From and To cities")
    public void enterCities() {
        flightPage.enterRandomFromAndTo();
    }

    @And("I select a departure date and passengers")
    public void selectDatePassengers() {
        flightPage.selectDepartureDateAndPassengers();
    }

    @And("I click the Search button")
    public void clickSearch() {
        flightPage.clickSearch();
    }

    @Then("I should see the number of flights available")
    public void printFlightCount() {
        resultPage.printFlightCount();
    }
}