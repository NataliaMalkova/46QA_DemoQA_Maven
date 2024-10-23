package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonPage extends BasePage {
    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonPage doubleClick() {
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonPage verifyDoubleClickMessage(String textToFind) {
        shouldHaveText(doubleClickMessage, textToFind, 2000);
        assert doubleClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonPage rightClickButton() throws InterruptedException {
        Thread.sleep(1000);
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonPage verifyrightClickButton(String textToFind) {
        scrollTo(100);
        shouldHaveText(rightClickMessage, textToFind, 2000);
        assert rightClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }
    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement dynamicClickButton;

    public ButtonPage dynamicClickButton()  {
        click(dynamicClickButton);
        return this;
    }

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickButtonMessage;

    public ButtonPage verifydynamicClickButton(String textToFind) {
        scrollTo(100);
        shouldHaveText(dynamicClickButtonMessage, textToFind, 2000);
        assert dynamicClickButtonMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }
}



