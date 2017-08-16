package steps;

import cucumber.api.PendingException;
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

import java.util.Set;

public class GuruSteps extends Global {

    WebDriver driver = WebBrowser.driver;
    Extension extension = new Extension();
    String ValList, ValDetail = null;

    @Given("^I am logged in to \"([^\"]*)\"$")
    public void iAmLoggedInTo(String url) throws Throwable {
        extension.NavigateToUrl(url);
    }

    @Then("^Verify the title page is displayed as \"([^\"]*)\"$")
    public void verifyTheTitlePageIsDisplayedAs(String val) throws Throwable {
        if (val.equals("Mobile")) {
            extension.WaitUntilIsElementExistsAndDisplayed(By.xpath("//h1[contains(text(),'" + val + "')]"));
            Assert.assertTrue("Title " + val + "is displayed", driver.findElement(By.xpath("//h1[contains(text(),'" + val + "')]")).isDisplayed());
        } else if (val.equals("This is demo site for"))
            Assert.assertTrue("Title " + val + "is displayed", driver.findElement(By.xpath("//h2[contains(text(),'" + val + "')]")).isDisplayed());
    }

    @When("^I click on mobile menu$")
    public void iClickOnMobileMenu() throws Throwable {
        extension.Click(By.xpath("//a[text()='Mobile']"));
    }

    @When("^I sort by name$")
    public void iSortByName() throws Throwable {
        extension.SelectElementByValue(By.cssSelector("select[title='Sort By']"), "http://live.guru99.com/index.php/mobile.html?dir=asc&order=name");
    }

    @Then("^Verify products are sorted by name$$")
    public void verifyProductsAreSortedByName() throws Throwable {
        extension.WaitUntilIsElementExistsAndDisplayed(By.xpath("//ul/li/div/h2/a[text()='IPhone']"));
        Assert.assertTrue(driver.findElement(By.xpath("//ul/li[1]/div/h2/a[text()='IPhone']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul/li[2]/div/h2/a[text()='Samsung Galaxy']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul/li[3]/div/h2/a[text()='Sony Xperia']")).isDisplayed());
    }

    @And("^In the list view of all mobiles I read cost of Sony Xperia$")
    public void inTheListViewOfAllMobilesIReadCostOfSonyXperia() throws Throwable {
        extension.WaitUntilIsElementExistsAndDisplayed(By.xpath("//h2/a[text()='Sony Xperia']/parent::h2/parent::div/div/span/span"));
        ValList = driver.findElement(By.xpath("//h2/a[text()='Sony Xperia']/parent::h2/parent::div/div/span/span")).getText();
    }

    @And("^I click on Sony Xperia phone$")
    public void iClickOnSonyXperiaPhone() throws Throwable {
        extension.Click(By.xpath("//h2/a[text()='Sony Xperia']"));
    }

    @And("^Read the value from detail view$")
    public void readTheValueFromDetailView() throws Throwable {
        extension.WaitUntilIsElementExistsAndDisplayed(By.xpath("//div/span[text()='Sony Xperia']/parent::div/parent::div/div/div/span/span"));
        ValDetail = driver.findElement(By.xpath("//div/span[text()='Sony Xperia']/parent::div/parent::div/div/div/span/span")).getText();
    }

    @Then("^Verify both the values are equal$")
    public void verifyBothTheValuesAreEqual() throws Throwable {
        Assert.assertEquals(ValList, ValDetail);
    }

    @And("^I click on Add to cart for Sony Xperia$")
    public void iClickOnAddToCartForSonyXperia() throws Throwable {
        extension.Click(By.xpath("//a[text()='Sony Xperia']/following::div/button/span/span[text()='Add to Cart']"));
    }

    @And("^Change the Quantity to \"([^\"]*)\"$")
    public void changeTheQuantityTo(String qty) throws Throwable {
        extension.SendKeys(By.xpath("//a[text()='Sony Xperia']/following::td/input[@title='Qty']"),qty);
    }

    @And("^Click on Update$")
    public void clickOnUpdate() throws Throwable {
        extension.Click(By.xpath("//a[text()='Sony Xperia']/following::td/button/span/span[text()='Update']"));
    }

    @Then("^An Error message is displayed \"([^\"]*)\"$")
    public void anErrorMessageIsDisplayed(String msg) throws Throwable {
        extension.WaitUntilIsElementExistsAndDisplayed(By.xpath("//p[contains(text(),'" + msg  + "')]"));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Some of the products cannot be ordered in requested quantity.']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + msg  + "')]")).isDisplayed());
    }

    @When("^I click on Empty cart link$")
    public void iClickOnEmptyCartLink() throws Throwable {
        extension.Click(By.id("empty_cart_button"));
    }

    @Then("^\"([^\"]*)\" message should be displayed$")
    public void messageShouldBeDisplayed(String msg) throws Throwable {
        extension.WaitUntilIsElementExistsAndDisplayed(By.xpath("//h1[text()='" + msg  + "']"));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='" + msg  + "']")).isDisplayed());
    }

    @And("^Click on Compare button$")
    public void clickOnCompareButton() throws Throwable {
        extension.Click(By.xpath("//span[text()='Compare']"));
    }

    @Then("^A new pop up window should be displayed and (\\d+) products should be displayed$")
    public void aNewPopUpWindowShouldBeDisplayedAndProductsShouldBeDisplayed(int arg0) throws Throwable {
        Set handles= driver.getWindowHandles();
        for (String handle1 : driver.getWindowHandles())
            driver.switchTo().window(handle1);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Compare Products']")).isDisplayed());
    }

    @And("^Close the popup window$")
    public void closeThePopupWindow() throws Throwable {
        extension.Click(By.xpath("//span[text()='Close Window']"));
    }

    @And("^I click on Add to Compare button for (\\d+) products$")
    public void iClickOnAddToCompareButtonForProducts(int arg0) throws Throwable {
        extension.Click(By.xpath("//a[text()='Samsung Galaxy']/ancestor::div/div/ul/li/a[text()='Add to Compare']"));
        extension.Click(By.xpath("//a[text()='Sony Xperia']/ancestor::div/div/ul/li/a[text()='Add to Compare']"));
    }
}
