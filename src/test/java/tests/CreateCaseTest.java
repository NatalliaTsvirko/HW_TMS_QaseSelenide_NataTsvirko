package tests;

import models.TestCase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.EditTestCasePage;
import pages.RepositoryPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertEquals;

public class CreateCaseTest extends BaseTest {

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
    public void createTestCaseTest() {
        TestCase testCase = TestDataHelper.getTestCaseData();
        projectsPage.chooseProject();
        repositoryPage.isRepositoryPageOpened()
                .clickCreateCaseButton()
                .fillForm(testCase)
                .clickSaveButton()
               .openDetailsTestCase();
        TestCase actualDetailsTestCase = repositoryPage.clickEditCaseButton()
                .getTestCaseDetails();
        editTestCasePage.clickCancelButton().clickCloseButton();
        assertEquals(actualDetailsTestCase, testCase);
    }
}
