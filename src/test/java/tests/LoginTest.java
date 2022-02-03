package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        loginPage.navigate();
        loginPage.login(USERNAME, PASSWORD)
                .isProjectPageOpened();
    }
}
