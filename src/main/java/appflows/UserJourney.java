/* This package help us know the core journey of our app.
Also, we can add multiple user-journies in this.
Example from login-perform some business logic-logout! 😊
 */

package appflows;

import actors.Users;
import base.WebDriverGenerator;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserJourney {

    Users users = new Users();

    @Test
    public void basicUserJourneyTest() throws IOException, InterruptedException {
        System.out.println("User login into the SadaPay Application");

        WebDriverGenerator.startDriver();
        users.loginIntoApp();
        WebDriverGenerator.quitDriver();
    }

}