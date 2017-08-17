package runner;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebBrowser extends Global {
    public static WebDriver driver = null;

    @Before
    public static void Initialize() {
        System.setProperty("webdriver.gecko.driver", Driver_Path + "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public static void TearDown() {
        driver.quit();
    }
}
