package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.wikipedia_page.WikiSearchPage;
import utilities.Driver;

public class WikiStepDefinitions {

    WikiSearchPage wikiSearchPage=new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");

    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiSearchPage.searchBox.sendKeys(string);

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.searchButton.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }


    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String string) {

        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());
        Assert.assertTrue(wikiSearchPage.mainHeader.getText().equals(string));


    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String string ){
        Assert.assertTrue(wikiSearchPage.imageHeader.isDisplayed());
        Assert.assertTrue(wikiSearchPage.imageHeader.getText().equals(string));


    }

}
