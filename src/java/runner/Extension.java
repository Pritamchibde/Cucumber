package runner;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class Extension {

    public void WaitUntilIsElementExistsAndDisplayed(By Locator) {
        try {
            WebDriverWait wait = new WebDriverWait(WebBrowser.driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
            wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
        } catch (Exception ex) {
            Assert.fail("Following element is not displayed : " + Locator);
        }
    }

    public void Click(By Locator) {
        WaitUntilIsElementExistsAndDisplayed(Locator);
        WebBrowser.driver.findElement(Locator).click();
    }

    public void SelectElementByText(By Locator, String text) {
        WaitUntilIsElementExistsAndDisplayed(Locator);
        new Select(WebBrowser.driver.findElement(Locator)).selectByVisibleText(text);
    }

    public void SelectElementByValue(By Locator, String value) {
        WaitUntilIsElementExistsAndDisplayed(Locator);
        new Select(WebBrowser.driver.findElement(Locator)).selectByValue(value);
    }

    public void SendKeys(By Locator, String text) {
        Clear(Locator);
        WebBrowser.driver.findElement(Locator).sendKeys(text);
    }

    public void Clear(By Locator) {
        WaitUntilIsElementExistsAndDisplayed(Locator);
        WebBrowser.driver.findElement(Locator).clear();
    }

    public void NavigateToUrl(String url) {
        WebBrowser.driver.navigate().to(url);
    }
}