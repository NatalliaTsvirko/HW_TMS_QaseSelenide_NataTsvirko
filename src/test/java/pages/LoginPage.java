package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    final static SelenideElement USERNAME_INPUT = $("#inputEmail");
    final static SelenideElement PASSWORD_INPUT = $("#inputPassword");

    public void navigate() {
        open("/login");
    }

    public ProjectsPage login(String username, String password) {
        USERNAME_INPUT.setValue(username);
        PASSWORD_INPUT.setValue(password).submit();
        return new ProjectsPage();
    }
}
