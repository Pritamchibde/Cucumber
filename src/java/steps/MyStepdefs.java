package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import runner.Global;
import runner.WebBrowser;

public class MyStepdefs extends Global {

    WebDriver driver = WebBrowser.driver;

    @Given("^I login to facebook account$")
    public void iLoginToFacebookAccount() throws Throwable {
        driver.navigate().to(FaceBookUrl);
        driver.findElement(By.id("email")).sendKeys(Username);
        driver.findElement(By.id("pass")).sendKeys(Password);
    }

    @When("^I post a message on the wall$")
    public void iPostAMessageOnTheWall() throws Throwable {

    }

    @Then("^The message should be displayed on the wall$")
    public void theMessageShouldBeDisplayedOnTheWall() throws Throwable {

    }
}
