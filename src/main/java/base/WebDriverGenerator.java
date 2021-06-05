package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class WebDriverGenerator {

    public static AppiumDriver driver;

    @BeforeClass
    public static void startDriver() throws IOException {
        CapabilitiesGenerator capabilities = new CapabilitiesGenerator();
        if (driver == null) {
            driver = (AppiumDriver) capabilities.setCapabilities(driver);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver != null)
        {
            return driver;
        } else
        {
            throw new WebDriverException("Exception");
        }
    }


    @AfterClass
    public static void quitDriver() {
        driver = null;
    }
}