package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Name*']")
    WebElement Name;

    @FindBy(xpath = "//input[@placeholder='Surname*']")
    WebElement Surname;

    @FindBy(xpath = "//input[@placeholder='Email*']")
    WebElement Email;

    @FindBy(xpath = "//input[@placeholder='Password*']")
    WebElement Password;

    @FindBy(xpath = "//input[@placeholder='Confirm password*']")
    WebElement ConfirmPassword;

    @FindBy(xpath = "//input[@placeholder='Phone number*']")
    WebElement Phonenumber;

    @FindBy(xpath = "//input[@type='checkbox' and @id='c2']")
    WebElement termsCheckbox;

    @FindBy(xpath = "//button[@type='submit' and text()='Register']")
    WebElement RegisterButton;

    // Заполнение полей регистрационной формы
    public RegistrationPage fillRegistrationForm(String firstName, String lastName, String email, String password, String confirmPassword, String phoneNumber) {
        type(Name, firstName);
        type(Surname, lastName);
        type(Email, email);
        type(Password, password);
        type(ConfirmPassword, confirmPassword);
        type(Phonenumber, phoneNumber);
        return this;
    }
    public RegistrationPage navigateToCheckboxAndAgree() {
        Actions actions = new Actions(driver);

        // Предположим, что вы сначала должны нажать Tab несколько раз, чтобы добраться до чекбокса
        // Количество нажатий Tab зависит от вашей формы
        for (int i = 0; i < 4; i++) { // Замените 5 на нужное количество
            actions.sendKeys(Keys.TAB).perform();
        }

        // Установите галочку в чекбоксе, нажав пробел
        actions.sendKeys(Keys.SPACE).perform();

        return this;
    }

    // Метод для отправки формы
    public RegistrationPage submitForm() {
        RegisterButton.click(); // Исправлено: используем RegisterButton, а не строку
        return this;
    }

    // Метод для проверки успешности регистрации
    public RegistrationPage verifyRegistrationSuccess() {
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'success-message')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Регистрация прошла неуспешно.");
        return this;
    }
}
