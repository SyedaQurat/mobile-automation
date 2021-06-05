/* You may create more screens here with in this
package of screens. The package allows you to create
new java-class as per defined screens in your app
 */
package screens;

import base.IdentifierReader;
import base.WebDriverGenerator;
import org.openqa.selenium.By;

public class OTPScreen {


    public String getOTPNumber(String OTP)
    {
        WebDriverGenerator.getDriver().findElement(By.id(IdentifierReader.defaultReader.getProperty("enterOTP"))).sendKeys(OTP);
        return OTP;
    }
}
