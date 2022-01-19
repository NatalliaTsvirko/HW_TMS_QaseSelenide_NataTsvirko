package elements;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Placeholder {

    protected String label;
    final String placeholderElementLocator = "//*[@id='%s" + "Group']//p";
    final String locatorForGetInfo = "//*[@id='%s" + "Group']//div[@contenteditable='true']//p";

    public Placeholder(String label) {
        this.label = label;
    }

    public void write(String text) {
        $(byXpath(String.format(placeholderElementLocator, label))).setValue(text);
    }

    public String getText() {
        return $(byXpath(String.format(locatorForGetInfo, label))).getText();
    }
}