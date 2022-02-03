package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Dropdown;
import elements.Placeholder;
import models.TestCase;

import static com.codeborne.selenide.Selenide.$;

public class CreateTestCasePage {

    final static SelenideElement TITLE = $("#title");
    final static SelenideElement SAVE_BUTTON = $("#save-case");


    public void write(SelenideElement element, String text) {
        element.setValue(text);
    }

    public CreateTestCasePage fillForm(TestCase testCase) {
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

    public RepositoryPage clickSaveButton() {
        SAVE_BUTTON.click();
        return new RepositoryPage();
    }
}
