package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.EditTestCasePage;
import pages.RepositoryPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class EditCaseTest extends BaseTest {

    final String title = "Title";

    protected RepositoryPage repositoryPage;
    protected CreateTestCasePage createTestCasePage;
    protected EditTestCasePage editTestCasePage;


    @BeforeMethod
    public void initialize() {
        loginPage.navigate();
        loginPage.login(USERNAME, PASSWORD);
        repositoryPage = new RepositoryPage();
        createTestCasePage = new CreateTestCasePage();
        editTestCasePage = new EditTestCasePage();

    }

    @Test
    public void changeOnSignUpCase() {
        projectsPage.chooseProject();
        repositoryPage.isRepositoryPageOpened()
                .selectCase("Sign up");
        repositoryPage.clickEditCaseButton();
        editTestCasePage.changInputValue("888");
        editTestCasePage.clickSaveButton();

    }

    @Test
    public void changesCaseIsOpened() {
        projectsPage.chooseProject();
        repositoryPage.isRepositoryPageOpened()
                .selectCase("Sign up");
        repositoryPage.clickEditCaseButton()
        .isEditPageOpened();
        title.equalsIgnoreCase("Sign up");
    }
}
