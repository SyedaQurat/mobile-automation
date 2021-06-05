package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CapabilitiesGenerator {

    DesiredCapabilities caps = new DesiredCapabilities();
    ConfigFileReader readProp = new ConfigFileReader();

    public WebDriver setCapabilities(AppiumDriver driver) throws IOException {
        if (System.getProperty("propEnv").equals("Android")) {
            caps.setCapability("deviceName", readProp.returnConfigFiles().getProperty("androidDeviceName") );
            caps.setCapability("platformVersion", readProp.returnConfigFiles().getProperty("androidPlatformVersion"));
            caps.setCapability("platformName", readProp.returnConfigFiles().getProperty("androidPlatformName"));
            caps.setCapability("app", readProp.returnConfigFiles().getProperty("androidFilePath"));
            caps.setCapability("automationName", readProp.returnConfigFiles().getProperty("androidAutomationName"));
            caps.setCapability("noReset", readProp.returnConfigFiles().getProperty("noReset"));
            caps.setCapability("appPackage", readProp.returnConfigFiles().getProperty("appPackage"));
            caps.setCapability("appActivity", readProp.returnConfigFiles().getProperty("appActivity"));
            caps.setCapability("appWaitForLaunch", readProp.returnConfigFiles().getProperty("appWaitForLaunch"));
            caps.setCapability("appWaitPackage", readProp.returnConfigFiles().getProperty("appWaitPackage"));
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
        else {
            caps.setCapability("deviceName", readProp.returnConfigFiles().getProperty("iOSDeviceName") );
            caps.setCapability("platformVersion", readProp.returnConfigFiles().getProperty("iOSPlatformVersion"));
            caps.setCapability("platformName", readProp.returnConfigFiles().getProperty("iOSPlatformName"));
            caps.setCapability("AutomationName", readProp.returnConfigFiles().getProperty("iOSAutomationName"));
            caps.setCapability("app", readProp.returnConfigFiles().getProperty("iOSFilePath"));
            caps.setCapability("noReset", readProp.returnConfigFiles().getProperty("noReset"));
            caps.setCapability("useNewWDA", readProp.returnConfigFiles().getProperty("newWDA"));
            caps.setCapability("bundleId",readProp.returnConfigFiles().getProperty("bundleId"));
            caps.setCapability("updatedWDABundleId", "com.facebook.wda.integrationAp");
            caps.setCapability("xcodeOrgId", "OrgID");
            caps.setCapability("xcodeSigningId", "iPhone Developer");
            driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        return driver;
    }
}