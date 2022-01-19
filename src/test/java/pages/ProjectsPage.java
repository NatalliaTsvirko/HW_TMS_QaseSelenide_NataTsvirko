package pages;

import com.codeborne.selenide.SelenideElement;
import utils.PropertyReader;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {

    final static SelenideElement USER_MENU_IMAGE = $("#user-menu");
    final String projectNameLocator = "//a[contains(text(),'%s')]";
    final String projectName = System.getenv().getOrDefault("PROJECT_NAME", PropertyReader.getProperty("qase.projectName"));

    public SelenideElement isProjectPageOpened() {
        return USER_MENU_IMAGE.shouldBe(visible);
    }

    public RepositoryPage chooseProject() {
        $(byXpath(String.format(projectNameLocator, projectName))).click();
        return new RepositoryPage();
    }


}
