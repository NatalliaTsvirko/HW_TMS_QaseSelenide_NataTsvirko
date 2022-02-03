package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    protected String label;
    final String dropdownElementLocator = "//*[@id='%s" + "Group']//div [@style='display: inline-block;']/input";
    final String locatorForGetInfo = "//*[@id='%s" + "Group']//div[contains(@class,'-container')]";

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOption(String text) {
        $(byXpath(String.format(dropdownElementLocator, label))).setValue(text).pressEnter();
    }

    public String getText() {
        return $(byXpath(String.format(locatorForGetInfo, label))).getText();
    }

}
