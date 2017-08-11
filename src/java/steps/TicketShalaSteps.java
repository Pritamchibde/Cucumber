package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import runner.Extension;
import runner.Global;
import runner.WebBrowser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TicketShalaSteps extends Global {

    WebDriver driver = WebBrowser.driver;
    Extension extension = new Extension();

    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String url) throws Throwable {
        extension.NavigateToUrl(url);
    }

    @When("^I click on Hotels$")
    public void i_click_on_Hotels() throws Throwable {
        extension.Click(By.xpath("//p[text()=' Hotels ']"));
    }

    @When("^Select destination \"([^\"]*)\"$")
    public void select_destination(String arg1) throws Throwable {
        extension.SendKeys(By.id("hotelsearch"), "Malaysia");
        extension.Click(By.xpath("//ul/li/a/strong[text()='Malaysia, Kuala lumpur']"));
    }

    @When("^Select future start date and end date$")
    public void select_future_start_date_and_end_date() throws Throwable {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        //Add one day to current date.
        cal.add(Calendar.DATE, 1);
        String CheckInDate = dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, 2);
        String CheckOutDate = dateFormat.format(cal.getTime());

        extension.SendKeys(By.id(""), CheckInDate);
        extension.SendKeys(By.id(""), CheckOutDate);
    }

    @When("^Select \"([^\"]*)\" rooms and \"([^\"]*)\" guests$")
    public void select_rooms_and_guests(String arg1, String arg2) throws Throwable {
        extension.SelectElementByText(By.id("room"), "2 Rooms");
        extension.SelectElementByText(By.id("adult"),"4 Guests");
    }

    @When("^Click on Search$")
    public void click_on_Search() throws Throwable {
        extension.Click(By.xpath("//button[contains(text(),'Search')]"));
    }
}