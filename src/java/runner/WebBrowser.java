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
        System.setProperty("webdriver.gecko.driver", Driver_Path +"geckodriver.exe");
        driver = new FirefoxDriver();

//        System.setProperty("webdriver.ie.driver", Driver_Path + "IEDriverServer.exe");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("nativeEvents", false);
//        caps.setCapability("ensureCleanSession", true);
//        driver = new InternetExplorerDriver(caps);
//        System.out.println("1: " + driver);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
//        driver.manage().timeouts().setScriptTimeout(60000, TimeUnit.MILLISECONDS);
//        driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
//        System.out.println("2: " + driver);
    }

    @After
    public static void TearDown() {
        driver.quit();
    }


}
