
/*
This class defines the flow of the app.
Basically, in this class we define each specific user as an actor
 */

package actors;

import screens.OTPScreen;

import java.io.IOException;

public class Users {

    PhoneNumberScreen phoneNumberScreen = new PhoneNumberScreen();
    OTPScreen otpScreen = new OTPScreen();
    PINScreen pinScreen = new PINScreen();


    public void loginIntoApp() throws IOException, InterruptedException {
        phoneNumberScreen.enterMobileNumber("Enter-Your-Phone-Number");
        phoneNumberScreen.hitContinueBtn();
        otpScreen.getOTPNumber("Enter-Your-OTP-Code");
    }
}