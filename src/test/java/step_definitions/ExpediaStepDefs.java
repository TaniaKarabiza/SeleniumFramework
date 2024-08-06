package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.expedia_pages.ExpediaLandingPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.SeleniumUtils;


public class ExpediaStepDefs {

    ExpediaLandingPage expediaLandingPage=new ExpediaLandingPage();
    String expectedOriginCityAirport="";
    String expectedDestinationCityAirport="";

    @Given("user is on the Expedia Landing Page")
    public void userIsOnTheExpediaLandingPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("expedia_url"));

    }

    @When("user clicks on Flights")
    public void userClicksOnFlights() {

        SeleniumUtils.waitFor(2);
        expediaLandingPage.flightsOption.click();

    }

    @And("user enters {string} by adding nearby airports and enters {string} cities")
    public void userEntersByAddingNearbyAirportsAndEntersCities(String originCity, String destinationCity) {

        expectedOriginCityAirport=originCity;
        expectedDestinationCityAirport=destinationCity;

        SeleniumUtils.waitForPageToLoad(2);

        expediaLandingPage.originCityAirportInputBox.click();
        expediaLandingPage.originCityAirportInput.sendKeys(originCity);
        expediaLandingPage.originCityAirportFirstOption.click();

        SeleniumUtils.waitForClickablility(expediaLandingPage.destinationCityAirportInputBox,3);
        expediaLandingPage.destinationCityAirportInputBox.click();
        expediaLandingPage.destinationCityAirportInput.sendKeys(destinationCity);
        expediaLandingPage.destinationCityAirportFirstOption.click();

    }

    @And("user selects {string} and {string} dates")
    public void userSelectsAndDates(String departureDate, String returnDate) {

        SeleniumUtils.waitForClickablility(expediaLandingPage.inputDates,1);
        expediaLandingPage.inputDates.click();

        SeleniumUtils.waitForVisibility(expediaLandingPage.departureMonth,2);

       String depLiteralMonth= expediaLandingPage.convertMonthToString(Integer.parseInt(expediaLandingPage.convertIntMonthToString(departureDate)));
       expediaLandingPage.chooseDepartureMonth(depLiteralMonth);

       SeleniumUtils.waitFor(1);

       expediaLandingPage.chooseDepartureDate(expediaLandingPage.getDay(departureDate));
       SeleniumUtils.waitForVisibility(expediaLandingPage.returnMonth,2);

       String retLiteralMonth=expediaLandingPage.convertMonthToString(Integer.parseInt(expediaLandingPage.convertIntMonthToString(returnDate)));
       SeleniumUtils.waitForVisibility(expediaLandingPage.returnMonth,1);
       expediaLandingPage.chooseReturnMonth(retLiteralMonth);
       SeleniumUtils.waitFor(1);

       expediaLandingPage.chooseReturnDate(expediaLandingPage.getDay(returnDate));
       SeleniumUtils.waitForClickablility(expediaLandingPage.calendarDoneButton,1);

       expediaLandingPage.calendarDoneButton.click();






    }

    @And("user clicks search button")
    public void userClicksSearchButton() {
        expediaLandingPage.submitButton.click();
        SeleniumUtils.waitForPageToLoad(2);
    }

    @Then("origin and destination details are same as entered in the main screen")
    public void originAndDestinationDetailsAreSameAsEnteredInTheMainScreen() {

        Assert.assertTrue((expediaLandingPage.originCityResult.getText()).contains(expectedOriginCityAirport));
        Assert.assertTrue((expediaLandingPage.destinationCityResult.getText().contains(expectedDestinationCityAirport)));


    }


    @And("user is able to see {string} text")
    public void userIsAbleToSeeText(String expectedText) {
        Assert.assertEquals(expectedText, expediaLandingPage.actualText.getText());


    }


}
