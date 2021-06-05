package screens;

import base.IdentifierReader;
import base.WebDriverGenerator;
import org.openqa.selenium.By;

public class PhoneNumberScreen {

    public String enterMobileNumber(String phoneNumber)
    {
        WebDriverGenerator.getDriver().findElement(By.id(IdentifierReader.defaultReader.getProperty("enterMobileNumber"))).sendKeys(phoneNumber);
        return phoneNumber; }

    public void hitContinueBtn()
    {
        WebDriverGenerator.getDriver().findElement(By.id(IdentifierReader.defaultReader.getProperty("continueBtn"))).click(); }

}