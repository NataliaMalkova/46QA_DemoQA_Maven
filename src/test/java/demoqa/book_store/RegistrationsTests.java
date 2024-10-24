//package demoqa.book_store;
//
//import demoqa.core.TestBase;
//import demoqa.pages.RegistrationPage;
//import demoqa.utils.DataProviders;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class RegistrationsTests extends TestBase {
//
//    @BeforeMethod
//    public void precondition() {
//        app.driver.get("https://ticket-service-69443.firebaseapp.com/registration");
//    }
//
//    @Test(dataProvider = "registrationData", dataProviderClass = DataProviders.class)
//    public void registrationFormTest(String firstName, String lastName, String email, String password, String confirmPassword, String phoneNumber) {
//        new RegistrationPage(app.driver)
//                .fillRegistrationForm(firstName, lastName, email, password, confirmPassword, phoneNumber)
//                .submitForm()
//                .verifyRegistrationSuccess();
//    }
//}
