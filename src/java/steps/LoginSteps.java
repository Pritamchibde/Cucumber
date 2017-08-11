package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import runner.Extension;
import runner.Global;
import runner.WebBrowser;

public class LoginSteps extends Global {

    WebDriver driver = WebBrowser.driver;
    Extension extension = new Extension();

    @Given("^I am navigate to BrownTape site$")
    public void iAmLoggedInAsAUser() throws Throwable {
        extension.NavigateToUrl(BTUrl);
    }

    @When("^I enter username$")
    public void iEnterUsername() throws Throwable {
        extension.SendKeys(By.id("UserEmail"), BTUserName);
    }

    @And("^I enter password$")
    public void iEnterPassword() throws Throwable {
        extension.SendKeys(By.id("UserPassword"), BTPassWord);
    }

    @And("^Click on Sign in button$")
    public void clickOnLoginButton() throws Throwable {
        extension.Click(By.id("submit-btn"));
    }

    @Then("^User should be logged in$")
    public void userShouldBeLoggedIn() throws Throwable {
        Thread.sleep(9000);
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Partner Dashboard')]")).isDisplayed());
    }

    @Given("^I navigate to google site$")
    public void iNavigateToGoogleSite() throws Throwable {
        extension.NavigateToUrl(GoogleUrl);
    }

    @When("^I ente string \"([^\"]*)\" in search string$")
    public void iEnteStringInSearchString(String Val) throws Throwable {
        extension.SendKeys(By.id("lst-ib"), Val);
        extension.Click(By.xpath("//input[@value='Google Search']"));
    }

    @Then("^Results should be displayed$")
    public void resultsShouldBeDisplayed() throws Throwable {
        Thread.sleep(9000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='GitHub - google/googletest: Google Test']")).isDisplayed());
    }
}
