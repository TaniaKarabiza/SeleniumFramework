package pages.expedia_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class ExpediaLandingPage {

    public ExpediaLandingPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='uitk-tab']")
    public WebElement flightsOption;

    @FindBy(xpath = "//div[@class='uitk-input-swapper-start-input']")
    public WebElement originCityAirportInputBox;

    @FindBy(xpath = "//input[@data-stid='origin_select-menu-input']")
    public WebElement originCityAirportInput;

    @FindBy(xpath = "(//button[@data-stid='origin_select-result-item-button'])[1]")
    public WebElement originCityAirportFirstOption;

    @FindBy(xpath = "//div[@class='uitk-input-swapper-end-input']")
    public WebElement destinationCityAirportInputBox;

    @FindBy(xpath ="//input[@data-stid='destination_select-menu-input']" )
    public WebElement destinationCityAirportInput;

    @FindBy(xpath = "(//button[@data-stid='destination_select-result-item-button'])[1]")
    public WebElement destinationCityAirportFirstOption;

    @FindBy(xpath = "(//button[@class='uitk-fake-input uitk-form-field-trigger'])[3]")
    public WebElement inputDates;

    @FindBy(xpath = "(//table[@data-stid='month-table'])[1]//tbody//tr//td")
    public List<WebElement> departureDates;

    @FindBy(xpath = "(//span[@class='uitk-align-center uitk-month-label'])[1]")
    public WebElement departureMonth;

    @FindBy(xpath = "(//span[@class='uitk-align-center uitk-month-label'])[2]")
    public WebElement returnMonth;

    @FindBy(xpath = "//button[@data-stid='uitk-calendar-navigation-controls-next-button']")
    public WebElement nextMonthsNavigationArrow;

    @FindBy(xpath = "(//table[@data-stid='month-table'])[2]//tbody//tr//td")
    public List<WebElement> returnDates;

    @FindBy(xpath = "//button[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary uitk-layout-flex-item']")
    public WebElement calendarDoneButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[@data-stid='typeahead-originInput-0-menu-trigger']")
    public WebElement originCityResult;

    @FindBy(xpath = "//button[@data-stid='typeahead-destinationInput-0-menu-trigger']")
    public WebElement destinationCityResult;

    @FindBy(xpath ="//h5[@class='uitk-heading uitk-heading-5']" )
    public WebElement actualText;


    public  String convertMonthToString(int month1){
        String month="";

        switch (month1){
            case 1:
                month="January";
                break;
            case 2:
                month="February";
                break;
            case 3:
                month="March";
                break;
            case 4:
                month="April";
                break;
            case 5:
                month="May";
                break;
            case 6:
                month="June";
                break;
            case 7:
                month="July";
                break;
            case 8:
                month="August";
                break;
            case 9:
                month="September";
                break;
            case 10:
                month="October";
                break;
            case 11:
                month="November";
                break;
            case 12:
                month="December";
                break;

        }
        return month;
    }

    public void chooseDepartureMonth(String departureMonth) {


        while (departureMonth != this.departureMonth.getText()) {

            if (departureMonth != this.departureMonth.getText()) {
                nextMonthsNavigationArrow.click();
                break;
            }

        }
    }

    public void chooseReturnMonth(String returnMonth){

            while (!(this.returnMonth.getText().contains(returnMonth))) {

                if (!(this.returnMonth.getText().contains(returnMonth))) {
                    nextMonthsNavigationArrow.click();
                    break;
                }

            }


        }

    public void chooseDepartureDate(String departureDate){



        for (int i = 0; i < departureDates.size(); i++) {

            if ((departureDates.get(i).getText()).equals(departureDate)){
                departureDates.get(i).click();
               break;
            }


        }





    }

    public void chooseReturnDate(String returnDate) {


        for (int i = 0; i < returnDates.size(); i++) {

            if ((returnDates.get(i).getText()).equals(returnDate)) {
                returnDates.get(i).click();
                break;
            }


        }

    }

    public String convertIntMonthToString(String date){

        String stringMonth="";
        if(date.startsWith("0")){
            stringMonth= date.substring(1,2);
        }else {
            stringMonth= date.substring(0,2);
        }

        return stringMonth;

    }

    public String getDay(String date){


        String stringDay=date.substring(3,5);
        if (stringDay.startsWith("0")){
            stringDay=stringDay.substring(1);
        }


        return stringDay;

    }



    }
