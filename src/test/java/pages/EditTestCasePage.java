package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Placeholder;
import models.TestCase;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class EditTestCasePage {

    final static SelenideElement TITLE = $("#title");
    final static SelenideElement CANCEL_BUTTON = $(byXpath("//button[text()='Cancel']"));
    final static SelenideElement SAVE_BUTTON = $(byXpath("//button[text()='Save']"));
    final static SelenideElement CLOSE_FORM_BUTTON = $(byXpath("//button[text()='Close form']"));
    final static SelenideElement PRECONDITIONS_FIELD = $(byXpath("//*[@id='pre-conditionGroup']//p"));


    public TestCase getTestCaseDetails() {
        TestCase testCase = new TestCase();
        testCase.setTitle(TITLE.val());
        testCase.setDescription(new Placeholder("description").getText());
        testCase.setPre_conditions(new Placeholder("pre-condition").getText());
        testCase.setPost_conditions(new Placeholder("post-condition").getText());
        testCase.setPriority(new Dropdown("priority").getText());
        testCase.setSeverity(new Dropdown("severity").getText());
        testCase.setType(new Dropdown("type").getText());
        testCase.setSuite(new Dropdown("suite").getText());
        return testCase;
    }

    public void write(SelenideElement element, String text) {
        element.setValue(text);
    }

    public EditTestCasePage fillForm(TestCase testCase) {
        write(TITLE, testCase.getTitle());
        new Placeholder("description").write(testCase.getDescription());
        new Placeholder("pre-condition").write(testCase.getPre_conditions());
        new Placeholder("post-condition").write(testCase.getPost_conditions());
        new Dropdown("severity").selectOption(testCase.getSeverity());
        new Dropdown("priority").selectOption(testCase.getPriority());
        new Dropdown("type").selectOption(testCase.getType());
        new Dropdown("suite").selectOption(testCase.getSuite());
        return this;
    }

    public EditTestCasePage isEditPageOpened() {
        TITLE.shouldBe(visible);
        return this;
    }

    public EditTestCasePage clickCancelButton() {
        CANCEL_BUTTON.click();
        return this;
    }

    public RepositoryPage clickSaveButton() {
        SAVE_BUTTON.click();
        return new RepositoryPage();
    }

    public RepositoryPage clickCloseButton() {
        CLOSE_FORM_BUTTON.click();
        return new RepositoryPage();
    }

    public void changInputValue(String text){
        $(PRECONDITIONS_FIELD).setValue(text);
    }
}
