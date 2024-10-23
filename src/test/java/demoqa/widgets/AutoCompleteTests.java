package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.AutoCompletePage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectAutoCompleteMenu().hideAds();
    }
    @Test
    public void autoCompleteSingleTest1() {
        new AutoCompletePage(app.driver)
                .autoComplete("m")
                .verifyAutocomplete("Magenta");
    }
    @Test
    public void autoCompleteArrayTest1() {
        String[] autoCompleteArray = {"m", "b"};
        String[] autoCompleteArrayVerify = {"Magenta", "Black", "Blue"};
        new AutoCompletePage(app.driver)
                .autoCompleteArray(autoCompleteArray)
                .verifyautoCompleteArray(autoCompleteArrayVerify);
    }
}
