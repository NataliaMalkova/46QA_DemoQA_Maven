package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksImagesPage extends BasePage {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> allImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        System.out.println(allImages.size());
        for (WebElement image : allImages) {
            String imageURL = image.getAttribute("src");
            if (imageURL != null) {
                verifyLink(imageURL);
            }
            boolean isDisplayed = (Boolean) js.executeScript("return arguments[0].naturalWidth > 0", image);
            System.out.println("Image: [" + imageURL + (isDisplayed ? " is displayed! " : " is NOT displayed"));
        }

        return this;
    }

    public void verifyLink(String urlToCheck) {
        try {
            URL url = new URL(urlToCheck);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();

            // Получение кода ответа
            int responseCode = connection.getResponseCode();
            // Получение заголовка ответа
            String responseMessage = connection.getResponseMessage();

            if (responseCode >= 400) {
                // broken link
                System.err.println("URL to check: [" + urlToCheck + "], " + "response code: [" + responseCode + "], " + "response message: [" + responseMessage + "] is broken link");
            } else {
                // correct link
                System.out.println("URL to check: [" + urlToCheck + "], " + "response code: [" + responseCode + "], " + "response message: [" + responseMessage + "] is valid link");
            }

        } catch (MalformedURLException error) {
            System.err.println("Error: Malformed URL: [" + urlToCheck + "], error message: [" + error.getMessage() + "]");
            //throw new RuntimeException(e);
        } catch (IOException error) {
            System.err.println("Error occurred: [" + error.getMessage() + "] for URL: [" + urlToCheck + "]");
            //throw new RuntimeException(e);
        }
    }
}